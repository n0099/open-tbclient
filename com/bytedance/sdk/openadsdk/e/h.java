package com.bytedance.sdk.openadsdk.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31119a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31120b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31121c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f31122d;

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
        this.f31119a = z;
        this.f31120b = i2;
        this.f31121c = str;
        this.f31122d = z2;
    }
}
