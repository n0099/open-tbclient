package com.xiaomi.push;

import android.content.Context;
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
    public static volatile db a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f198a;

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentLinkedQueue<b> f199a;

    /* loaded from: classes8.dex */
    public class a extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(db dbVar) {
            super(dbVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((db) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dbVar;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends al.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ db b;

        public b(db dbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dbVar;
            this.a = System.currentTimeMillis();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() - this.a > 172800000 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ db f200a;

        /* renamed from: a  reason: collision with other field name */
        public File f201a;

        /* renamed from: a  reason: collision with other field name */
        public String f202a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f203a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f204b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(db dbVar, String str, String str2, File file, boolean z) {
            super(dbVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dbVar, str, str2, file, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((db) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f200a = dbVar;
            this.f202a = str;
            this.b = str2;
            this.f201a = file;
            this.f204b = z;
        }

        private boolean c() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                int i2 = 0;
                SharedPreferences sharedPreferences = this.f200a.f198a.getSharedPreferences("log.timestamp", 0);
                String string = sharedPreferences.getString("log.requst", "");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    currentTimeMillis = jSONObject.getLong("time");
                    i = jSONObject.getInt("times");
                } catch (JSONException unused) {
                    i = 0;
                }
                if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                    currentTimeMillis = System.currentTimeMillis();
                } else if (i > 10) {
                    return false;
                } else {
                    i2 = i;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis);
                    jSONObject2.put("times", i2 + 1);
                    sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
                } catch (JSONException e) {
                    com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bg.e(this.f200a.f198a) || (this.f204b && bg.b(this.f200a.f198a)) : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (c()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("uid", com.xiaomi.push.service.bi.m651a());
                        hashMap.put("token", this.b);
                        hashMap.put("net", bg.m211a(this.f200a.f198a));
                        bg.a(this.f202a, hashMap, this.f201a, "file");
                    }
                    this.f203a = true;
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo281c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!this.f203a) {
                    int i = this.a + 1;
                    this.a = i;
                    if (i < 3) {
                        this.f200a.f199a.add(this);
                    }
                }
                if (this.f203a || this.a >= 3) {
                    this.f201a.delete();
                }
                this.f200a.a((1 << this.a) * 1000);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f199a = concurrentLinkedQueue;
        this.f198a = context;
        concurrentLinkedQueue.add(new a(this));
        b(0L);
    }

    public static db a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == null) {
                synchronized (db.class) {
                    if (a == null) {
                        a = new db(context);
                    }
                }
            }
            a.f198a = context;
            return a;
        }
        return (db) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65541, this, j) == null) && (peek = this.f199a.peek()) != null && peek.a()) {
            b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || aa.b() || aa.m177a()) {
            return;
        }
        try {
            File file = new File(this.f198a.getExternalFilesDir(null) + "/.logcache");
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
        if (!(interceptable == null || interceptable.invokeJ(65545, this, j) == null) || this.f199a.isEmpty()) {
            return;
        }
        go.a(new dd(this), j);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            while (!this.f199a.isEmpty()) {
                b peek = this.f199a.peek();
                if (peek != null) {
                    if (!peek.b() && this.f199a.size() <= 6) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.f199a.remove(peek);
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

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, date, date2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f199a.add(new dc(this, i, date, date2, str, str2, z));
            b(0L);
        }
    }
}
