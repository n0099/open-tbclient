package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.go;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class bi {
    public static /* synthetic */ Interceptable $ic;
    public static bi a;

    /* renamed from: a  reason: collision with other field name */
    public static String f910a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public al.b f911a;

    /* renamed from: a  reason: collision with other field name */
    public dt.a f912a;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f913a;

    /* loaded from: classes7.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(dt.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            }
        }

        public void a(du.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163263, "Lcom/xiaomi/push/service/bi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163263, "Lcom/xiaomi/push/service/bi;");
                return;
            }
        }
        a = new bi();
    }

    public bi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f913a = new ArrayList();
    }

    public static bi a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a : (bi) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m654a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (bi.class) {
                if (f910a == null) {
                    SharedPreferences sharedPreferences = com.xiaomi.push.t.m678a().getSharedPreferences("XMPushServiceConfig", 0);
                    String string = sharedPreferences.getString("DeviceUUID", null);
                    f910a = string;
                    if (string == null) {
                        String a2 = com.xiaomi.push.i.a(com.xiaomi.push.t.m678a(), false);
                        f910a = a2;
                        if (a2 != null) {
                            sharedPreferences.edit().putString("DeviceUUID", f910a).commit();
                        }
                    }
                }
                str = f910a;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f912a == null) {
            d();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.f911a == null) {
            bj bjVar = new bj(this);
            this.f911a = bjVar;
            go.a(bjVar);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0025 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        ?? r2;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = interceptable;
            if (r2.invokeV(65547, this) != null) {
                return;
            }
        }
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m678a().openFileInput("XMCloudCfg"));
                try {
                    this.f912a = dt.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    r2 = bufferedInputStream;
                } catch (Exception e3) {
                    e2 = e3;
                    com.xiaomi.channel.commonutils.logger.b.m112a("load config failure: " + e2.getMessage());
                    r2 = bufferedInputStream;
                    com.xiaomi.push.y.a((Closeable) r2);
                    if (this.f912a != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.y.a((Closeable) r2);
                throw th;
            }
        } catch (Exception e4) {
            bufferedInputStream = null;
            e2 = e4;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            com.xiaomi.push.y.a((Closeable) r2);
            throw th;
        }
        com.xiaomi.push.y.a((Closeable) r2);
        if (this.f912a != null) {
            this.f912a = new dt.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            try {
                if (this.f912a != null) {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m678a().openFileOutput("XMCloudCfg", 0));
                    com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                    this.f912a.a(a2);
                    a2.m235a();
                    bufferedOutputStream.close();
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m112a("save config failure: " + e2.getMessage());
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m657a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b();
            dt.a aVar = this.f912a;
            if (aVar != null) {
                return aVar.c();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dt.a m658a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b();
            return this.f912a;
        }
        return (dt.a) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m659a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f913a.clear();
            }
        }
    }

    public void a(du.b bVar) {
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar.m305d() && bVar.d() > m657a()) {
                c();
            }
            synchronized (this) {
                aVarArr = (a[]) this.f913a.toArray(new a[this.f913a.size()]);
            }
            for (a aVar : aVarArr) {
                aVar.a(bVar);
            }
        }
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            synchronized (this) {
                this.f913a.add(aVar);
            }
        }
    }
}
