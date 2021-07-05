package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class db {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile db f42948a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f217a;

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentLinkedQueue<b> f218a;

    /* loaded from: classes8.dex */
    public class a extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ db f42949a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(db dbVar) {
            super(dbVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((db) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42949a = dbVar;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42949a.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends al.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f42950a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ db f42951b;

        public b(db dbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42951b = dbVar;
            this.f42950a = System.currentTimeMillis();
        }

        @Override // com.xiaomi.push.al.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.xiaomi.push.al.b
        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() - this.f42950a > 172800000 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42952a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ db f219a;

        /* renamed from: a  reason: collision with other field name */
        public File f220a;

        /* renamed from: a  reason: collision with other field name */
        public String f221a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f222a;

        /* renamed from: b  reason: collision with root package name */
        public String f42953b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f223b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(db dbVar, String str, String str2, File file, boolean z) {
            super(dbVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dbVar, str, str2, file, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((db) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f219a = dbVar;
            this.f221a = str;
            this.f42953b = str2;
            this.f220a = file;
            this.f223b = z;
        }

        private boolean c() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                int i3 = 0;
                SharedPreferences sharedPreferences = this.f219a.f217a.getSharedPreferences("log.timestamp", 0);
                String string = sharedPreferences.getString("log.requst", "");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    currentTimeMillis = jSONObject.getLong("time");
                    i2 = jSONObject.getInt("times");
                } catch (JSONException unused) {
                    i2 = 0;
                }
                if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                    currentTimeMillis = System.currentTimeMillis();
                } else if (i2 > 10) {
                    return false;
                } else {
                    i3 = i2;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis);
                    jSONObject2.put("times", i3 + 1);
                    sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
                } catch (JSONException e2) {
                    com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e2.getMessage());
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bg.e(this.f219a.f217a) || (this.f223b && bg.b(this.f219a.f217a)) : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (c()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("uid", com.xiaomi.push.service.bi.m612a());
                        hashMap.put("token", this.f42953b);
                        hashMap.put("net", bg.m172a(this.f219a.f217a));
                        bg.a(this.f221a, hashMap, this.f220a, "file");
                    }
                    this.f222a = true;
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo242c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!this.f222a) {
                    int i2 = this.f42952a + 1;
                    this.f42952a = i2;
                    if (i2 < 3) {
                        this.f219a.f218a.add(this);
                    }
                }
                if (this.f222a || this.f42952a >= 3) {
                    this.f220a.delete();
                }
                this.f219a.a((1 << this.f42952a) * 1000);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56376958, "Lcom/xiaomi/push/db;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56376958, "Lcom/xiaomi/push/db;");
        }
    }

    public db(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f218a = concurrentLinkedQueue;
        this.f217a = context;
        concurrentLinkedQueue.add(new a(this));
        b(0L);
    }

    public static db a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f42948a == null) {
                synchronized (db.class) {
                    if (f42948a == null) {
                        f42948a = new db(context);
                    }
                }
            }
            f42948a.f217a = context;
            return f42948a;
        }
        return (db) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) && (peek = this.f218a.peek()) != null && peek.a()) {
            b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || aa.b() || aa.m138a()) {
            return;
        }
        try {
            File file = new File(this.f217a.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65545, this, j) == null) || this.f218a.isEmpty()) {
            return;
        }
        go.a(new dd(this), j);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            while (!this.f218a.isEmpty()) {
                b peek = this.f218a.peek();
                if (peek != null) {
                    if (!peek.b() && this.f218a.size() <= 6) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.f218a.remove(peek);
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            a(0L);
        }
    }

    public void a(String str, String str2, Date date, Date date2, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, date, date2, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f218a.add(new dc(this, i2, date, date2, str, str2, z));
            b(0L);
        }
    }
}
