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
/* loaded from: classes4.dex */
public final class bk implements ai {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bk a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f939a;

    /* renamed from: a  reason: collision with other field name */
    public Context f940a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f941a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f942a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f943a;

    /* loaded from: classes4.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public String f944a;

        public a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f944a = str;
            this.a = j2;
        }

        public abstract void a(bk bkVar);

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || bk.a == null) {
                return;
            }
            Context context = bk.a.f940a;
            if (com.xiaomi.push.bg.d(context)) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences sharedPreferences = bk.a.f941a;
                if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f944a, 0L) > this.a || com.xiaomi.push.af.a(context)) {
                    SharedPreferences.Editor edit = bk.a.f941a.edit();
                    com.xiaomi.push.r.a(edit.putLong(":ts-" + this.f944a, System.currentTimeMillis()));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f943a = false;
        this.f942a = new ConcurrentHashMap<>();
        this.f940a = context.getApplicationContext();
        this.f941a = context.getSharedPreferences(StampMissionHttpRequestMessage.TYPE_SYNC, 0);
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
            SharedPreferences sharedPreferences = this.f941a;
            return sharedPreferences.getString(str + ":" + str2, "");
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.xiaomi.push.service.ai
    /* renamed from: a  reason: collision with other method in class */
    public void mo682a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f943a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f939a < 3600000) {
            return;
        }
        this.f939a = currentTimeMillis;
        this.f943a = true;
        com.xiaomi.push.ai.a(this.f940a).a(new bl(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) && this.f942a.putIfAbsent(aVar.f944a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f940a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            SharedPreferences.Editor edit = a.f941a.edit();
            com.xiaomi.push.r.a(edit.putString(str + ":" + str2, str3));
        }
    }
}
