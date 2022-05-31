package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.VideoTemplate.DataRes;
import tbclient.VideoTemplateContent;
/* loaded from: classes5.dex */
public class bt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<at8> a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;

    public bt8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public List<at8> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataRes) == null) {
            this.b = dataRes.topic_id.intValue();
            this.c = dataRes.topic_name;
            this.d = dataRes.back_url;
            this.e = dataRes.video_template_url;
            this.f = dataRes.activity_url;
            List<VideoTemplateContent> list = dataRes.video_template_content;
            if (list != null) {
                this.a = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    at8 at8Var = new at8();
                    at8Var.a(list.get(i));
                    this.a.add(at8Var);
                }
            }
        }
    }
}
