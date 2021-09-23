package com.bytedance.sdk.openadsdk.n.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68545a;

    /* renamed from: b  reason: collision with root package name */
    public String f68546b;

    /* renamed from: c  reason: collision with root package name */
    public long f68547c;

    /* renamed from: d  reason: collision with root package name */
    public long f68548d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f68549e;

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
        this.f68547c = -1L;
        this.f68548d = -1L;
    }
}
