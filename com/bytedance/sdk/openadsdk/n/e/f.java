package com.bytedance.sdk.openadsdk.n.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f31904a;

    /* renamed from: b  reason: collision with root package name */
    public String f31905b;

    /* renamed from: c  reason: collision with root package name */
    public long f31906c;

    /* renamed from: d  reason: collision with root package name */
    public long f31907d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f31908e;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31906c = -1L;
        this.f31907d = -1L;
    }
}
