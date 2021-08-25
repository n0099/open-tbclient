package com.bytedance.sdk.openadsdk.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f67614a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67615b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67616c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67617d;

    public h(boolean z, int i2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67614a = z;
        this.f67615b = i2;
        this.f67616c = str;
        this.f67617d = z2;
    }
}
