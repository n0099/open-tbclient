package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ˆ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0398 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public int f377;

    /* renamed from: ʼ  reason: contains not printable characters */
    public int f378;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f379;

    /* renamed from: ʾ  reason: contains not printable characters */
    public String f380;

    /* renamed from: ʿ  reason: contains not printable characters */
    public String f381;

    /* renamed from: ˆ  reason: contains not printable characters */
    public Context f382;

    /* renamed from: ˈ  reason: contains not printable characters */
    public ClassLoader f383;

    /* renamed from: ˉ  reason: contains not printable characters */
    public String f384;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f385;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f386;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f387;

    /* renamed from: ˏ  reason: contains not printable characters */
    public ActivityInfo[] f388;

    /* renamed from: ˑ  reason: contains not printable characters */
    public String f389;

    /* renamed from: י  reason: contains not printable characters */
    public String f390;

    /* renamed from: ـ  reason: contains not printable characters */
    public String f391;

    /* renamed from: ٴ  reason: contains not printable characters */
    public int f392;

    /* renamed from: ᐧ  reason: contains not printable characters */
    public int f393;

    /* renamed from: ᴵ  reason: contains not printable characters */
    public PackageInfo f394;

    /* renamed from: ᵎ  reason: contains not printable characters */
    public long f395;

    /* renamed from: ᵔ  reason: contains not printable characters */
    public int f396;

    /* renamed from: ᵢ  reason: contains not printable characters */
    public int f397;

    /* renamed from: ⁱ  reason: contains not printable characters */
    public boolean f398;

    /* renamed from: ﹳ  reason: contains not printable characters */
    public int f399;

    /* renamed from: ﹶ  reason: contains not printable characters */
    public int f400;

    /* renamed from: ﾞ  reason: contains not printable characters */
    public boolean f401;

    public C0398() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f400 = -1;
    }

    public C0398(PackageInfo packageInfo, int i, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageInfo, Integer.valueOf(i), str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f400 = -1;
        this.f394 = packageInfo;
        this.f377 = i;
        this.f379 = str;
        this.f380 = str2;
        this.f385 = str3;
        this.f386 = str4;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C0398.class == obj.getClass()) {
                String str = this.f379;
                String str2 = ((C0398) obj).f379;
                if (str == null) {
                    if (str2 != null) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.f379;
            return (str == null ? 0 : str.hashCode()) + 31;
        }
        return invokeV.intValue;
    }
}
