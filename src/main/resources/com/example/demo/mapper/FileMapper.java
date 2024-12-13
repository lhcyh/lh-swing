<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.demo.mapper.FileMapper">
    <insert id="addFile" userGeneratedKey="true" keyProperty="id" parameterType="com.example.demo.pojo.File">
         insert into file(url,file_id,remarks) values(#{url},#{fileId},#{remarks})
    </insert>
    <delete id="deleteFileById">
         delete from file where id=#{id}
    </delete>
    <update id="updateFile" parameterType="com.example.demo.pojo.File">
        update file
        <set>
          <if test="url!=null">
             url=#{url},
          </if>
          <if test="fileId!=null">
             file_id=#{fileId},
          </if>
          <if test="remarks!=null">
             remarks=#{remarks},
          </if>
        </set>
        where id=#{id}
    </update>


    <select id="getFileById" resultType="com.example.demo.pojo.File" >
        select * from file where id=#{id}
    </select>


    <sql id="tableFieldMapping">
       file.${field}
    </sql>

    <sql id="exampleClause">
        <where>
            <foreach collection="orCriterionList" item="criterionList" separator="or">
                <trim prefix="(" prefixOverrides="and" suffix=")">
                    <foreach collection="criterionList" item="criterion">
                        and
                        <bind name="table" value="criterion.table"/>
                        <bind name="field" value="criterion.field"/>
                        <include refid="tableFieldMapping"></include>
                        <choose>
                            <when test="criterion.valueType=='noValue'">
                                ${criterion.condition}
                            </when>
                            <when test="criterion.valueType=='singleValue'">
                                ${criterion.condition} #{criterion.value}
                            </when>
                            <when test="criterion.valueType=='betweenValue'">
                                ${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                            </when>
                        </choose>
                    </foreach>
                </trim>
            </foreach>
        </where>
        <if test="orderBy!=null">
            <bind name="table" value="orderBy.table"/>
            <bind name="field" value="orderBy.field"/>
            order by
            <include refid="tableFieldMapping"></include>
            ${orderBy.condition}
        </if>
        <if test="limitStart!=null">
            limit #{limitStart}
            <if test="limitNum!=null">
                ,#{limitNum}
            </if>
        </if>
    </sql>

    <select id="getFileListByExample" parameterType="Example"  resultType="com.example.demo.pojo.File" >
        select * from file
        <include refid="exampleClause"></include>
    </select>

</mapper>
