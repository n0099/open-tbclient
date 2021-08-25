package com.tencent.open.a;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.utils.l;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static d f76131a;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized d a() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (d.class) {
                if (f76131a == null) {
                    f76131a = new d();
                }
                dVar = f76131a;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            g.a().a(l.a(str, str3, str4, str5, str2, str6), str2, true);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8}) == null) {
            g.a().a(l.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10}) == null) {
            g.a().a(l.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
        }
    }

    public void a(int i2, String str, String str2, String str3, String str4, Long l, int i3, int i4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, l, Integer.valueOf(i3), Integer.valueOf(i4), str5}) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
            if (l.longValue() == 0 || elapsedRealtime < 0) {
                elapsedRealtime = 0;
            }
            StringBuffer stringBuffer = new StringBuffer("https://huatuocode.huatuo.qq.com");
            stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
            stringBuffer.append(i2);
            stringBuffer.append("&code=");
            stringBuffer.append(i3);
            stringBuffer.append("&time=");
            stringBuffer.append(elapsedRealtime);
            stringBuffer.append("&rate=");
            stringBuffer.append(i4);
            stringBuffer.append("&uin=");
            stringBuffer.append(str2);
            stringBuffer.append("&data=");
            g.a().a(stringBuffer.toString(), "GET", l.a(String.valueOf(i2), String.valueOf(i3), String.valueOf(elapsedRealtime), String.valueOf(i4), str, str2, str3, str4, str5), true);
        }
    }
}
