package com.xiaomi.push.service;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.Cif;
import java.util.Map;
/* loaded from: classes8.dex */
public class ag {
    public static /* synthetic */ Interceptable $ic;
    public static a a;

    /* renamed from: a  reason: collision with other field name */
    public static b f910a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        Map<String, String> a(Context context, Cif cif);

        /* renamed from: a  reason: collision with other method in class */
        void m676a(Context context, Cif cif);

        boolean a(Context context, Cif cif, boolean z);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(Cif cif);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m677a(Cif cif);
    }

    public static Map<String, String> a(Context context, Cif cif) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, cif)) == null) {
            a aVar = a;
            if (aVar == null || cif == null) {
                com.xiaomi.channel.commonutils.logger.b.m103a("pepa listener or container is null");
                return null;
            }
            return aVar.a(context, cif);
        }
        return (Map) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m674a(Context context, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, cif) == null) {
            a aVar = a;
            if (aVar == null || cif == null) {
                com.xiaomi.channel.commonutils.logger.b.m103a("handle msg wrong");
            } else {
                aVar.m676a(context, cif);
            }
        }
    }

    public static void a(Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cif) == null) {
            b bVar = f910a;
            if (bVar == null || cif == null) {
                com.xiaomi.channel.commonutils.logger.b.m103a("pepa clearMessage is null");
            } else {
                bVar.a(cif);
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            b bVar = f910a;
            if (bVar == null || str == null) {
                com.xiaomi.channel.commonutils.logger.b.m103a("pepa clearMessage is null");
            } else {
                bVar.a(str);
            }
        }
    }

    public static boolean a(Context context, Cif cif, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, cif, z)) == null) {
            a aVar = a;
            if (aVar == null || cif == null) {
                com.xiaomi.channel.commonutils.logger.b.m103a("pepa judement listener or container is null");
                return false;
            }
            return aVar.a(context, cif, z);
        }
        return invokeLLZ.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m675a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cif)) == null) {
            b bVar = f910a;
            if (bVar == null || cif == null) {
                com.xiaomi.channel.commonutils.logger.b.m103a("pepa handleReceiveMessage is null");
                return false;
            }
            return bVar.m677a(cif);
        }
        return invokeL.booleanValue;
    }
}
