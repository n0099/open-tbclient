package com.bytedance.sdk.openadsdk.n.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f67788a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67789b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67790c;

    /* renamed from: d  reason: collision with root package name */
    public final int f67791d;

    /* renamed from: e  reason: collision with root package name */
    public final String f67792e;

    public a(String str, String str2, int i2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67788a = str;
        this.f67789b = str2;
        this.f67790c = i2;
        this.f67791d = i3;
        this.f67792e = str3;
    }
}
