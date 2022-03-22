package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class bk implements ai {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bk a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f915a;

    /* renamed from: a  reason: collision with other field name */
    public Context f916a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f917a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f918a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f919a;

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public String f920a;

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
            this.f920a = str;
            this.a = j;
        }

        public abstract void a(bk bkVar);

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || bk.a == null) {
                return;
            }
            Context context = bk.a.f916a;
            if (com.xiaomi.push.bg.d(context)) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences sharedPreferences = bk.a.f917a;
                if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f920a, 0L) > this.a || com.xiaomi.push.af.a(context)) {
                    SharedPreferences.Editor edit = bk.a.f917a.edit();
                    com.xiaomi.push.r.a(edit.putLong(":ts-" + this.f920a, System.currentTimeMillis()));
                    a(bk.a);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f919a = false;
        this.f918a = new ConcurrentHashMap<>();
        this.f916a = context.getApplicationContext();
        this.f917a = context.getSharedPreferences(StampMissionHttpRequestMessage.TYPE_SYNC, 0);
    }

    public static bk a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == null) {
                synchronized (bk.class) {
                    if (a == null) {
                        a = new bk(context);
                    }
                }
            }
            return a;
        }
        return (bk) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.f917a;
            return sharedPreferences.getString(str + ":" + str2, "");
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.xiaomi.push.service.ai
    /* renamed from: a  reason: collision with other method in class */
    public void mo661a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f919a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f915a < 3600000) {
            return;
        }
        this.f915a = currentTimeMillis;
        this.f919a = true;
        com.xiaomi.push.ai.a(this.f916a).a(new bl(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) && this.f918a.putIfAbsent(aVar.f920a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f916a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            SharedPreferences.Editor edit = a.f917a.edit();
            com.xiaomi.push.r.a(edit.putString(str + ":" + str2, str3));
        }
    }
}
