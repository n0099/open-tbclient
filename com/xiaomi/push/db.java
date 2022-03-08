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
    public Context f222a;

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentLinkedQueue<b> f223a;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ db f59532b;

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
            this.f59532b = dbVar;
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
        public final /* synthetic */ db f224a;

        /* renamed from: a  reason: collision with other field name */
        public File f225a;

        /* renamed from: a  reason: collision with other field name */
        public String f226a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f227a;

        /* renamed from: b  reason: collision with root package name */
        public String f59533b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f228b;

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
            this.f224a = dbVar;
            this.f226a = str;
            this.f59533b = str2;
            this.f225a = file;
            this.f228b = z;
        }

        private boolean c() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                int i3 = 0;
                SharedPreferences sharedPreferences = this.f224a.f222a.getSharedPreferences("log.timestamp", 0);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bg.e(this.f224a.f222a) || (this.f228b && bg.b(this.f224a.f222a)) : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (c()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("uid", com.xiaomi.push.service.bi.m675a());
                        hashMap.put("token", this.f59533b);
                        hashMap.put("net", bg.m235a(this.f224a.f222a));
                        bg.a(this.f226a, hashMap, this.f225a, "file");
                    }
                    this.f227a = true;
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo305c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!this.f227a) {
                    int i2 = this.a + 1;
                    this.a = i2;
                    if (i2 < 3) {
                        this.f224a.f223a.add(this);
                    }
                }
                if (this.f227a || this.a >= 3) {
                    this.f225a.delete();
                }
                this.f224a.a((1 << this.a) * 1000);
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
        this.f223a = concurrentLinkedQueue;
        this.f222a = context;
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
            a.f222a = context;
            return a;
        }
        return (db) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        b peek;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65541, this, j2) == null) && (peek = this.f223a.peek()) != null && peek.a()) {
            b(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || aa.b() || aa.m201a()) {
            return;
        }
        try {
            File file = new File(this.f222a.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65545, this, j2) == null) || this.f223a.isEmpty()) {
            return;
        }
        go.a(new dd(this), j2);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            while (!this.f223a.isEmpty()) {
                b peek = this.f223a.peek();
                if (peek != null) {
                    if (!peek.b() && this.f223a.size() <= 6) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.f223a.remove(peek);
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
            this.f223a.add(new dc(this, i2, date, date2, str, str2, z));
            b(0L);
        }
    }
}
