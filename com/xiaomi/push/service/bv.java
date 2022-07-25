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
import com.xiaomi.push.ao;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.gz;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class bv {
    public static /* synthetic */ Interceptable $ic;
    public static bv a;

    /* renamed from: a  reason: collision with other field name */
    public static String f950a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public ao.b f951a;

    /* renamed from: a  reason: collision with other field name */
    public dw.a f952a;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f953a;

    /* loaded from: classes8.dex */
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

        public void a(dw.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            }
        }

        public void a(dx.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163666, "Lcom/xiaomi/push/service/bv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163666, "Lcom/xiaomi/push/service/bv;");
                return;
            }
        }
        a = new bv();
    }

    public bv() {
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
        this.f953a = new ArrayList();
    }

    public static bv a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a : (bv) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m648a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (bv.class) {
                if (f950a == null) {
                    SharedPreferences sharedPreferences = com.xiaomi.push.v.m687a().getSharedPreferences("XMPushServiceConfig", 0);
                    String string = sharedPreferences.getString("DeviceUUID", null);
                    f950a = string;
                    if (string == null) {
                        String a2 = com.xiaomi.push.j.a(com.xiaomi.push.v.m687a(), false);
                        f950a = a2;
                        if (a2 != null) {
                            sharedPreferences.edit().putString("DeviceUUID", f950a).commit();
                        }
                    }
                }
                str = f950a;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f952a == null) {
            d();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.f951a == null) {
            bw bwVar = new bw(this);
            this.f951a = bwVar;
            gz.a(bwVar);
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
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = interceptable;
            if (r2.invokeV(65547, this) != null) {
                return;
            }
        }
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.v.m687a().openFileInput("XMCloudCfg"));
                try {
                    this.f952a = dw.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    r2 = bufferedInputStream;
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.m89a("load config failure: " + e.getMessage());
                    r2 = bufferedInputStream;
                    com.xiaomi.push.ab.a((Closeable) r2);
                    if (this.f952a != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.ab.a((Closeable) r2);
                throw th;
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            com.xiaomi.push.ab.a((Closeable) r2);
            throw th;
        }
        com.xiaomi.push.ab.a((Closeable) r2);
        if (this.f952a != null) {
            this.f952a = new dw.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            try {
                if (this.f952a != null) {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.v.m687a().openFileOutput("XMCloudCfg", 0));
                    com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                    this.f952a.a(a2);
                    a2.m216a();
                    bufferedOutputStream.close();
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m89a("save config failure: " + e.getMessage());
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m651a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b();
            dw.a aVar = this.f952a;
            if (aVar != null) {
                return aVar.c();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dw.a m652a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b();
            return this.f952a;
        }
        return (dw.a) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m653a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f953a.clear();
            }
        }
    }

    public void a(dx.b bVar) {
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar.m286d() && bVar.d() > m651a()) {
                c();
            }
            synchronized (this) {
                aVarArr = (a[]) this.f953a.toArray(new a[this.f953a.size()]);
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
                this.f953a.add(aVar);
            }
        }
    }
}
