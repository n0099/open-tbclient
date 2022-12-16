package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ik;
import com.xiaomi.push.it;
import com.xiaomi.push.iz;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ik a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cif)) == null) {
            byte[] m481a = cif.m481a();
            ik ikVar = new ik();
            try {
                it.a(ikVar, m481a);
                return ikVar;
            } catch (iz unused) {
                return null;
            }
        }
        return (ik) invokeL.objValue;
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] b = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (b != null) {
                al.m615a(context, y.a(b), b);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m99a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("notify fcm notification error ", th);
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, str, str2) == null) || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }

    public static byte[] a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m99a("secret is empty, return null");
                return null;
            }
            try {
                return com.xiaomi.push.i.b(com.xiaomi.push.bm.m212a(str), bArr);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("encryption error. ", e);
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m99a("secret is empty, return null");
                return null;
            }
            try {
                return com.xiaomi.push.i.a(com.xiaomi.push.bm.m212a(str), bArr);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("dencryption error. ", e);
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
