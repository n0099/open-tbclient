package com.heytap.openid.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Keep
/* loaded from: classes9.dex */
public class m_a {
    public static /* synthetic */ Interceptable $ic;
    @Keep
    public static final ThreadPoolExecutor m_a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1715945021, "Lcom/heytap/openid/sdk/m_a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1715945021, "Lcom/heytap/openid/sdk/m_a;");
                return;
            }
        }
        m_a = new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    }

    @Keep
    public static native int m_a(int i);

    @Keep
    public static native String m_a(Context context, String str);

    @Keep
    public static native String m_a(Context context, String str, String str2);

    @Keep
    public static native String m_a(String str);

    public static void m_a(Context context, Map<String, m_f> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, map) == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("cache", 0);
                m_a(sharedPreferences, map, "GUID", "GUID_TIME", "GUID_IV");
                m_a(sharedPreferences, map, "APID", "APID_TIME", "APID_IV");
                m_a(sharedPreferences, map, "DUID", "DUID_TIME");
                m_a(sharedPreferences, map, "AUID", "AUID_TIME");
                m_a(sharedPreferences, map, "OUID", "OUID_TIME");
                m_a(sharedPreferences, map, "OUID_STATUS", "OUID_STATUS_TIME");
            } catch (IllegalStateException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("1020:");
                sb.append(e.getMessage());
                Log.e("IDHelper", sb.toString() != null ? e.getMessage() : e.getLocalizedMessage());
            }
        }
    }

    @Keep
    public static native void m_a(SharedPreferences.Editor editor, m_f m_fVar, String str, String str2, String str3);

    public static void m_a(SharedPreferences sharedPreferences, Map<String, m_f> map, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65543, null, sharedPreferences, map, str, str2) == null) || map.containsKey(str)) {
            return;
        }
        String string = sharedPreferences.getString(str, null);
        long j = sharedPreferences.getLong(str2, 0L);
        if (string == null || j == 0) {
            return;
        }
        map.put(str, new m_f(string, j));
    }

    public static void m_a(SharedPreferences sharedPreferences, Map<String, m_f> map, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65544, null, sharedPreferences, map, str, str2, str3) == null) || map.containsKey(str)) {
            return;
        }
        String string = sharedPreferences.getString(str, null);
        long j = sharedPreferences.getLong(str2, 0L);
        String string2 = sharedPreferences.getString(str3, null);
        if (string == null || j == 0 || string2 == null) {
            return;
        }
        try {
            byte[] m_a2 = m_g.m_a(m_a("U3RkSWRBcHBLZXk="), string, string2);
            if (m_a2 != null) {
                map.put(str, new m_f(new String(m_a2, "ISO-8859-1"), j));
            }
        } catch (UnsupportedEncodingException e) {
            Log.e("IDHelper", e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
        }
    }

    @Keep
    public static native long m_b(String str);
}
