package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class gq {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f77557a;

    /* renamed from: a  reason: collision with other field name */
    public static long f444a;

    /* renamed from: a  reason: collision with other field name */
    public static al f445a;

    /* renamed from: a  reason: collision with other field name */
    public static com.xiaomi.push.providers.a f446a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f447a;

    /* renamed from: a  reason: collision with other field name */
    public static String f448a;

    /* renamed from: a  reason: collision with other field name */
    public static List<a> f449a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77558a;

        /* renamed from: a  reason: collision with other field name */
        public long f450a;

        /* renamed from: a  reason: collision with other field name */
        public String f451a;

        /* renamed from: b  reason: collision with root package name */
        public int f77559b;

        /* renamed from: b  reason: collision with other field name */
        public long f452b;

        /* renamed from: b  reason: collision with other field name */
        public String f453b;

        public a(String str, long j2, int i2, int i3, String str2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2, Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f451a = "";
            this.f450a = 0L;
            this.f77558a = -1;
            this.f77559b = -1;
            this.f453b = "";
            this.f452b = 0L;
            this.f451a = str;
            this.f450a = j2;
            this.f77558a = i2;
            this.f77559b = i3;
            this.f453b = str2;
            this.f452b = j3;
        }

        public boolean a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? TextUtils.equals(aVar.f451a, this.f451a) && TextUtils.equals(aVar.f453b, this.f453b) && aVar.f77558a == this.f77558a && aVar.f77559b == this.f77559b && Math.abs(aVar.f450a - this.f450a) <= 5000 : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56373610, "Lcom/xiaomi/push/gq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56373610, "Lcom/xiaomi/push/gq;");
                return;
            }
        }
        f445a = new al(true);
        f77557a = -1;
        f444a = System.currentTimeMillis();
        f447a = new Object();
        f449a = Collections.synchronizedList(new ArrayList());
        f448a = "";
        f446a = null;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f77557a == -1) {
                f77557a = b(context);
            }
            return f77557a;
        }
        return invokeL.intValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return str.getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException unused) {
                return str.getBytes().length;
            }
        }
        return invokeL.intValue;
    }

    public static long a(int i2, long j2, boolean z, long j3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(j3), Boolean.valueOf(z2)})) == null) {
            if (z && z2) {
                long j4 = f444a;
                f444a = j3;
                if (j3 - j4 > 30000 && j2 > 1024) {
                    return j2 * 2;
                }
            }
            return (j2 * (i2 == 0 ? 13 : 11)) / 10;
        }
        return invokeCommon.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static com.xiaomi.push.providers.a m359a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            com.xiaomi.push.providers.a aVar = f446a;
            if (aVar != null) {
                return aVar;
            }
            com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
            f446a = aVar2;
            return aVar2;
        }
        return (com.xiaomi.push.providers.a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m360a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (gq.class) {
                return !TextUtils.isEmpty(f448a) ? f448a : "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m362a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            f77557a = b(context);
        }
    }

    public static void a(Context context, String str, long j2, boolean z, long j3) {
        int a2;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(j3)}) == null) || context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f447a) {
            isEmpty = f449a.isEmpty();
            a(new a(str, j3, a2, z ? 1 : 0, a2 == 0 ? m360a(context) : "", j2));
        }
        if (isEmpty) {
            f445a.a(new gr(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j2, boolean z, boolean z2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j3)}) == null) {
            a(context, str, a(a(context), j2, z, j3, z2), z, j3);
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            for (a aVar2 : f449a) {
                if (aVar2.a(aVar)) {
                    aVar2.f452b += aVar.f452b;
                    return;
                }
            }
            f449a.add(aVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m363a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            synchronized (gq.class) {
                if (!l.d() && !TextUtils.isEmpty(str)) {
                    f448a = str;
                }
            }
        }
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return -1;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return -1;
                }
                return activeNetworkInfo.getType();
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static void b(Context context, List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, list) == null) {
            try {
                synchronized (com.xiaomi.push.providers.a.f830a) {
                    SQLiteDatabase writableDatabase = m359a(context).getWritableDatabase();
                    writableDatabase.beginTransaction();
                    try {
                        for (a aVar : list) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("package_name", aVar.f451a);
                            contentValues.put("message_ts", Long.valueOf(aVar.f450a));
                            contentValues.put("network_type", Integer.valueOf(aVar.f77558a));
                            contentValues.put("bytes", Long.valueOf(aVar.f452b));
                            contentValues.put("rcv", Integer.valueOf(aVar.f77559b));
                            contentValues.put(BaseStatisContent.IMSI, aVar.f453b);
                            writableDatabase.insert("traffic", null, contentValues);
                        }
                        writableDatabase.setTransactionSuccessful();
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
            } catch (SQLiteException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }
}
