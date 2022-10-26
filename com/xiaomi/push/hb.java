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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class hb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile int a;

    /* renamed from: a  reason: collision with other field name */
    public static long f453a;

    /* renamed from: a  reason: collision with other field name */
    public static ao f454a;

    /* renamed from: a  reason: collision with other field name */
    public static com.xiaomi.push.providers.a f455a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f456a;

    /* renamed from: a  reason: collision with other field name */
    public static String f457a;

    /* renamed from: a  reason: collision with other field name */
    public static List f458a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f459a;

        /* renamed from: a  reason: collision with other field name */
        public String f460a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f461b;

        /* renamed from: b  reason: collision with other field name */
        public String f462b;

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
            this.f460a = "";
            this.f459a = 0L;
            this.a = -1;
            this.b = -1;
            this.f462b = "";
            this.f461b = 0L;
            this.f460a = str;
            this.f459a = j;
            this.a = i;
            this.b = i2;
            this.f462b = str2;
            this.f461b = j2;
        }

        public boolean a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? TextUtils.equals(aVar.f460a, this.f460a) && TextUtils.equals(aVar.f462b, this.f462b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f459a - this.f459a) <= 5000 : invokeL.booleanValue;
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
        f454a = new ao(true);
        a = -1;
        f453a = System.currentTimeMillis();
        f456a = new Object();
        f458a = Collections.synchronizedList(new ArrayList());
        f457a = "";
        f455a = null;
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
                long j3 = f453a;
                f453a = j2;
                if (j2 - j3 > 30000 && j > 1024) {
                    return j * 2;
                }
            }
            return (j * (i == 0 ? 13 : 11)) / 10;
        }
        return invokeCommon.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static com.xiaomi.push.providers.a m389a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            com.xiaomi.push.providers.a aVar = f455a;
            if (aVar != null) {
                return aVar;
            }
            com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
            f455a = aVar2;
            return aVar2;
        }
        return (com.xiaomi.push.providers.a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m390a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (hb.class) {
                return !TextUtils.isEmpty(f457a) ? f457a : "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m392a(Context context) {
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
        synchronized (f456a) {
            isEmpty = f458a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m390a(context) : "", j));
        }
        if (isEmpty) {
            f454a.a(new hc(context), 5000L);
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
            for (a aVar2 : f458a) {
                if (aVar2.a(aVar)) {
                    aVar2.f461b += aVar.f461b;
                    return;
                }
            }
            f458a.add(aVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m393a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            synchronized (hb.class) {
                if (!m.m566d() && !TextUtils.isEmpty(str)) {
                    f457a = str;
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

    public static void b(Context context, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, list) == null) {
            try {
                synchronized (com.xiaomi.push.providers.a.f824a) {
                    SQLiteDatabase writableDatabase = m389a(context).getWritableDatabase();
                    writableDatabase.beginTransaction();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f460a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f459a));
                        contentValues.put("network_type", Integer.valueOf(aVar.a));
                        contentValues.put("bytes", Long.valueOf(aVar.f461b));
                        contentValues.put("rcv", Integer.valueOf(aVar.b));
                        contentValues.put(BaseStatisContent.IMSI, aVar.f462b);
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
