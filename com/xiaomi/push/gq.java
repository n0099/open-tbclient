package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes3.dex */
public class gq {
    public static /* synthetic */ Interceptable $ic;
    public static volatile int a;

    /* renamed from: a  reason: collision with other field name */
    public static long f445a;

    /* renamed from: a  reason: collision with other field name */
    public static al f446a;

    /* renamed from: a  reason: collision with other field name */
    public static com.xiaomi.push.providers.a f447a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f448a;

    /* renamed from: a  reason: collision with other field name */
    public static String f449a;

    /* renamed from: a  reason: collision with other field name */
    public static List<a> f450a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f451a;

        /* renamed from: a  reason: collision with other field name */
        public String f452a;

        /* renamed from: b  reason: collision with root package name */
        public int f62961b;

        /* renamed from: b  reason: collision with other field name */
        public long f453b;

        /* renamed from: b  reason: collision with other field name */
        public String f454b;

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
            this.f452a = "";
            this.f451a = 0L;
            this.a = -1;
            this.f62961b = -1;
            this.f454b = "";
            this.f453b = 0L;
            this.f452a = str;
            this.f451a = j2;
            this.a = i2;
            this.f62961b = i3;
            this.f454b = str2;
            this.f453b = j3;
        }

        public boolean a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? TextUtils.equals(aVar.f452a, this.f452a) && TextUtils.equals(aVar.f454b, this.f454b) && aVar.a == this.a && aVar.f62961b == this.f62961b && Math.abs(aVar.f451a - this.f451a) <= 5000 : invokeL.booleanValue;
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
        f446a = new al(true);
        a = -1;
        f445a = System.currentTimeMillis();
        f448a = new Object();
        f450a = Collections.synchronizedList(new ArrayList());
        f449a = "";
        f447a = null;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == -1) {
                a = b(context);
            }
            return a;
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
                long j4 = f445a;
                f445a = j3;
                if (j3 - j4 > 30000 && j2 > 1024) {
                    return j2 * 2;
                }
            }
            return (j2 * (i2 == 0 ? 13 : 11)) / 10;
        }
        return invokeCommon.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static com.xiaomi.push.providers.a m408a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            com.xiaomi.push.providers.a aVar = f447a;
            if (aVar != null) {
                return aVar;
            }
            com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
            f447a = aVar2;
            return aVar2;
        }
        return (com.xiaomi.push.providers.a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m409a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (gq.class) {
                return !TextUtils.isEmpty(f449a) ? f449a : "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m411a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            a = b(context);
        }
    }

    public static void a(Context context, String str, long j2, boolean z, long j3) {
        int a2;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(j3)}) == null) || context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f448a) {
            isEmpty = f450a.isEmpty();
            a(new a(str, j3, a2, z ? 1 : 0, a2 == 0 ? m409a(context) : "", j2));
        }
        if (isEmpty) {
            f446a.a(new gr(context), 5000L);
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
            for (a aVar2 : f450a) {
                if (aVar2.a(aVar)) {
                    aVar2.f453b += aVar.f453b;
                    return;
                }
            }
            f450a.add(aVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m412a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            synchronized (gq.class) {
                if (!l.d() && !TextUtils.isEmpty(str)) {
                    f449a = str;
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
                synchronized (com.xiaomi.push.providers.a.f831a) {
                    SQLiteDatabase writableDatabase = m408a(context).getWritableDatabase();
                    writableDatabase.beginTransaction();
                    try {
                        for (a aVar : list) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("package_name", aVar.f452a);
                            contentValues.put("message_ts", Long.valueOf(aVar.f451a));
                            contentValues.put("network_type", Integer.valueOf(aVar.a));
                            contentValues.put("bytes", Long.valueOf(aVar.f453b));
                            contentValues.put("rcv", Integer.valueOf(aVar.f62961b));
                            contentValues.put(BaseStatisContent.IMSI, aVar.f454b);
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
