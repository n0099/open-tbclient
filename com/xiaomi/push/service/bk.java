package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class bk implements ai {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile bk f40920a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f934a;

    /* renamed from: a  reason: collision with other field name */
    public Context f935a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f936a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f937a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f938a;

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f40921a;

        /* renamed from: a  reason: collision with other field name */
        public String f939a;

        public a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f939a = str;
            this.f40921a = j;
        }

        public abstract void a(bk bkVar);

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || bk.f40920a == null) {
                return;
            }
            Context context = bk.f40920a.f935a;
            if (com.xiaomi.push.bg.d(context)) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences sharedPreferences = bk.f40920a.f936a;
                if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f939a, 0L) > this.f40921a || com.xiaomi.push.af.a(context)) {
                    SharedPreferences.Editor edit = bk.f40920a.f936a.edit();
                    com.xiaomi.push.r.a(edit.putLong(":ts-" + this.f939a, System.currentTimeMillis()));
                    a(bk.f40920a);
                }
            }
        }
    }

    public bk(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f938a = false;
        this.f937a = new ConcurrentHashMap<>();
        this.f935a = context.getApplicationContext();
        this.f936a = context.getSharedPreferences("sync", 0);
    }

    public static bk a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f40920a == null) {
                synchronized (bk.class) {
                    if (f40920a == null) {
                        f40920a = new bk(context);
                    }
                }
            }
            return f40920a;
        }
        return (bk) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.f936a;
            return sharedPreferences.getString(str + ":" + str2, "");
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.xiaomi.push.service.ai
    /* renamed from: a  reason: collision with other method in class */
    public void mo619a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f938a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f934a < 3600000) {
            return;
        }
        this.f934a = currentTimeMillis;
        this.f938a = true;
        com.xiaomi.push.ai.a(this.f935a).a(new bl(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) && this.f937a.putIfAbsent(aVar.f939a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f935a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            SharedPreferences.Editor edit = f40920a.f936a.edit();
            com.xiaomi.push.r.a(edit.putString(str + ":" + str2, str3));
        }
    }
}
