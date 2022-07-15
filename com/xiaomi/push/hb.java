package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
/* loaded from: classes8.dex */
public class hb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile int a;

    /* renamed from: a  reason: collision with other field name */
    public static long f1172a;

    /* renamed from: a  reason: collision with other field name */
    public static ao f1173a;

    /* renamed from: a  reason: collision with other field name */
    public static com.xiaomi.push.providers.a f1174a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f1175a;

    /* renamed from: a  reason: collision with other field name */
    public static String f1176a;

    /* renamed from: a  reason: collision with other field name */
    public static List<a> f1177a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f1178a;

        /* renamed from: a  reason: collision with other field name */
        public String f1179a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f1180b;

        /* renamed from: b  reason: collision with other field name */
        public String f1181b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1179a = "";
            this.f1178a = 0L;
            this.a = -1;
            this.b = -1;
            this.f1181b = "";
            this.f1180b = 0L;
            this.f1179a = str;
            this.f1178a = j;
            this.a = i;
            this.b = i2;
            this.f1181b = str2;
            this.f1180b = j2;
        }

        public boolean a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? TextUtils.equals(aVar.f1179a, this.f1179a) && TextUtils.equals(aVar.f1181b, this.f1181b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f1178a - this.f1178a) <= 5000 : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56373114, "Lcom/xiaomi/push/hb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56373114, "Lcom/xiaomi/push/hb;");
                return;
            }
        }
        f1173a = new ao(true);
        a = -1;
        f1172a = System.currentTimeMillis();
        f1175a = new Object();
        f1177a = Collections.synchronizedList(new ArrayList());
        f1176a = "";
        f1174a = null;
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

    public static long a(int i, long j, boolean z, long j2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z), Long.valueOf(j2), Boolean.valueOf(z2)})) == null) {
            if (z && z2) {
                long j3 = f1172a;
                f1172a = j2;
                if (j2 - j3 > 30000 && j > 1024) {
                    return j * 2;
                }
            }
            return (j * (i == 0 ? 13 : 11)) / 10;
        }
        return invokeCommon.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static com.xiaomi.push.providers.a m1327a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            com.xiaomi.push.providers.a aVar = f1174a;
            if (aVar != null) {
                return aVar;
            }
            com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
            f1174a = aVar2;
            return aVar2;
        }
        return (com.xiaomi.push.providers.a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m1328a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (hb.class) {
                return !TextUtils.isEmpty(f1176a) ? f1176a : "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m1330a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            a = b(context);
        }
    }

    public static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Long.valueOf(j), Boolean.valueOf(z), Long.valueOf(j2)}) == null) || context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f1175a) {
            isEmpty = f1177a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m1328a(context) : "", j));
        }
        if (isEmpty) {
            f1173a.a(new hc(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2)}) == null) {
            a(context, str, a(a(context), j, z, j2, z2), z, j2);
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            for (a aVar2 : f1177a) {
                if (aVar2.a(aVar)) {
                    aVar2.f1180b += aVar.f1180b;
                    return;
                }
            }
            f1177a.add(aVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m1331a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            synchronized (hb.class) {
                if (!m.m1504d() && !TextUtils.isEmpty(str)) {
                    f1176a = str;
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
                synchronized (com.xiaomi.push.providers.a.f1543a) {
                    SQLiteDatabase writableDatabase = m1327a(context).getWritableDatabase();
                    writableDatabase.beginTransaction();
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f1179a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f1178a));
                        contentValues.put("network_type", Integer.valueOf(aVar.a));
                        contentValues.put("bytes", Long.valueOf(aVar.f1180b));
                        contentValues.put("rcv", Integer.valueOf(aVar.b));
                        contentValues.put(BaseStatisContent.IMSI, aVar.f1181b);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            }
        }
    }
}
