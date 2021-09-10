package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.task.item.StrictModeTask;
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
/* loaded from: classes10.dex */
public class db {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile db f77467a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f221a;

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentLinkedQueue<b> f222a;

    /* loaded from: classes10.dex */
    public class a extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ db f77468a;

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
            this.f77468a = dbVar;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f77468a.b();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends al.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f77469a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ db f77470b;

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
            this.f77470b = dbVar;
            this.f77469a = System.currentTimeMillis();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() - this.f77469a > StrictModeTask.CLEAN_FILE_INTERVAL : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77471a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ db f223a;

        /* renamed from: a  reason: collision with other field name */
        public File f224a;

        /* renamed from: a  reason: collision with other field name */
        public String f225a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f226a;

        /* renamed from: b  reason: collision with root package name */
        public String f77472b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f227b;

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
            this.f223a = dbVar;
            this.f225a = str;
            this.f77472b = str2;
            this.f224a = file;
            this.f227b = z;
        }

        private boolean c() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                int i3 = 0;
                SharedPreferences sharedPreferences = this.f223a.f221a.getSharedPreferences("log.timestamp", 0);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bg.e(this.f223a.f221a) || (this.f227b && bg.b(this.f223a.f221a)) : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (c()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("uid", com.xiaomi.push.service.bi.m615a());
                        hashMap.put("token", this.f77472b);
                        hashMap.put("net", bg.m175a(this.f223a.f221a));
                        bg.a(this.f225a, hashMap, this.f224a, "file");
                    }
                    this.f226a = true;
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo245c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!this.f226a) {
                    int i2 = this.f77471a + 1;
                    this.f77471a = i2;
                    if (i2 < 3) {
                        this.f223a.f222a.add(this);
                    }
                }
                if (this.f226a || this.f77471a >= 3) {
                    this.f224a.delete();
                }
                this.f223a.a((1 << this.f77471a) * 1000);
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
        this.f222a = concurrentLinkedQueue;
        this.f221a = context;
        concurrentLinkedQueue.add(new a(this));
        b(0L);
    }

    public static db a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f77467a == null) {
                synchronized (db.class) {
                    if (f77467a == null) {
                        f77467a = new db(context);
                    }
                }
            }
            f77467a.f221a = context;
            return f77467a;
        }
        return (db) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        b peek;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2) == null) && (peek = this.f222a.peek()) != null && peek.a()) {
            b(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || aa.b() || aa.m141a()) {
            return;
        }
        try {
            File file = new File(this.f221a.getExternalFilesDir(null) + "/.logcache");
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
        if (!(interceptable == null || interceptable.invokeJ(65545, this, j2) == null) || this.f222a.isEmpty()) {
            return;
        }
        go.a(new dd(this), j2);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            while (!this.f222a.isEmpty()) {
                b peek = this.f222a.peek();
                if (peek != null) {
                    if (!peek.b() && this.f222a.size() <= 6) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.f222a.remove(peek);
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
            this.f222a.add(new dc(this, i2, date, date2, str, str2, z));
            b(0L);
        }
    }
}
