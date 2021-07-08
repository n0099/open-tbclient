package com.bytedance.sdk.openadsdk.preload.geckox.k.a;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @c(a = "gecko_accesskey")

    /* renamed from: a  reason: collision with root package name */
    public List<String> f32237a;
    @c(a = IAdRequestParam.OS)

    /* renamed from: b  reason: collision with root package name */
    public int f32238b;
    @c(a = "msg_type")

    /* renamed from: c  reason: collision with root package name */
    public int f32239c;

    public a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32238b = 0;
        this.f32239c = 1;
        this.f32237a = list;
    }
}
