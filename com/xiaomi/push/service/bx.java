package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public final class bx implements ar {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bx a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f948a;

    /* renamed from: a  reason: collision with other field name */
    public Context f949a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f950a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f951a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f952a;

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public String f953a;

        public a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f953a = str;
            this.a = j;
        }

        public abstract void a(bx bxVar);

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || bx.a == null) {
                return;
            }
            Context context = bx.a.f949a;
            if (com.xiaomi.push.bj.d(context)) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences sharedPreferences = bx.a.f950a;
                if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f953a, 0L) > this.a || com.xiaomi.push.ai.a(context)) {
                    SharedPreferences.Editor edit = bx.a.f950a.edit();
                    com.xiaomi.push.t.a(edit.putLong(":ts-" + this.f953a, System.currentTimeMillis()));
                    a(bx.a);
                }
            }
        }
    }

    public bx(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f952a = false;
        this.f951a = new ConcurrentHashMap<>();
        this.f949a = context.getApplicationContext();
        this.f950a = context.getSharedPreferences(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, 0);
    }

    public static bx a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == null) {
                synchronized (bx.class) {
                    if (a == null) {
                        a = new bx(context);
                    }
                }
            }
            return a;
        }
        return (bx) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.f950a;
            return sharedPreferences.getString(str + ":" + str2, "");
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.xiaomi.push.service.ar
    /* renamed from: a  reason: collision with other method in class */
    public void mo650a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f952a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f948a < 3600000) {
            return;
        }
        this.f948a = currentTimeMillis;
        this.f952a = true;
        com.xiaomi.push.al.a(this.f949a).a(new by(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) && this.f951a.putIfAbsent(aVar.f953a, aVar) == null) {
            com.xiaomi.push.al.a(this.f949a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            SharedPreferences.Editor edit = a.f950a.edit();
            com.xiaomi.push.t.a(edit.putString(str + ":" + str2, str3));
        }
    }
}
