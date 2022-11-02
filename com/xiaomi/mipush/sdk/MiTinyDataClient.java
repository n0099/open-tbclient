package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class MiTinyDataClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static volatile a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public Context f37a;

        /* renamed from: a  reason: collision with other field name */
        public C0715a f38a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f39a;

        /* renamed from: a  reason: collision with other field name */
        public String f40a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<hn> f41a;

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0715a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: a  reason: collision with other field name */
            public final Runnable f42a;

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hn> f43a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledFuture<?> f44a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledThreadPoolExecutor f45a;

            public C0715a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
                this.f45a = new ScheduledThreadPoolExecutor(1);
                this.f43a = new ArrayList<>();
                this.f42a = new ab(this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f44a == null) {
                    this.f44a = this.f45a.scheduleAtFixedRate(this.f42a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                    hn remove = this.f43a.remove(0);
                    for (ii iiVar : bz.a(Arrays.asList(remove), this.a.f37a.getPackageName(), b.m131a(this.a.f37a).m132a(), (int) TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                        ao.a(this.a.f37a).a((ao) iiVar, hj.i, true, (hw) null);
                    }
                }
            }

            public void a(hn hnVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hnVar) == null) {
                    this.f45a.execute(new aa(this, hnVar));
                }
            }
        }

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
                    return;
                }
            }
            this.f38a = new C0715a(this);
            this.f41a = new ArrayList<>();
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (a == null) {
                    synchronized (a.class) {
                        if (a == null) {
                            a = new a();
                        }
                    }
                }
                return a;
            }
            return (a) invokeV.objValue;
        }

        private void a(hn hnVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, hnVar) == null) {
                synchronized (this.f41a) {
                    if (!this.f41a.contains(hnVar)) {
                        this.f41a.add(hnVar);
                        if (this.f41a.size() > 100) {
                            this.f41a.remove(0);
                        }
                    }
                }
            }
        }

        private boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
                if (ao.a(context).m124a()) {
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                        if (packageInfo == null) {
                            return false;
                        }
                        return packageInfo.versionCode >= 108;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        private boolean b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) ? b.m131a(context).m132a() == null && !a(this.f37a) : invokeL.booleanValue;
        }

        private boolean b(hn hnVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, hnVar)) == null) {
                if (bz.a(hnVar, false)) {
                    return false;
                }
                if (!this.f39a.booleanValue()) {
                    this.f38a.a(hnVar);
                    return true;
                }
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hnVar.d());
                ao.a(this.f37a).a(hnVar);
                return true;
            }
            return invokeL.booleanValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m104a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                if (context == null) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("context is null, MiTinyDataClientImp.init() failed.");
                    return;
                }
                this.f37a = context;
                this.f39a = Boolean.valueOf(a(context));
                b(MiTinyDataClient.PENDING_REASON_INIT);
            }
        }

        public synchronized void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (TextUtils.isEmpty(str)) {
                        com.xiaomi.channel.commonutils.logger.b.m89a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                        return;
                    }
                    this.f40a = str;
                    b(MiTinyDataClient.PENDING_REASON_CHANNEL);
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m105a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37a != null : invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m106a(hn hnVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hnVar)) == null) {
                synchronized (this) {
                    boolean z = false;
                    if (hnVar == null) {
                        return false;
                    }
                    if (bz.a(hnVar, true)) {
                        return false;
                    }
                    boolean z2 = TextUtils.isEmpty(hnVar.m399a()) && TextUtils.isEmpty(this.f40a);
                    boolean z3 = !m105a();
                    z = (this.f37a == null || b(this.f37a)) ? true : true;
                    if (!z3 && !z2 && !z) {
                        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hnVar.d());
                        if (TextUtils.isEmpty(hnVar.d())) {
                            hnVar.f(bd.a());
                        }
                        if (TextUtils.isEmpty(hnVar.m399a())) {
                            hnVar.a(this.f40a);
                        }
                        if (TextUtils.isEmpty(hnVar.c())) {
                            hnVar.e(this.f37a.getPackageName());
                        }
                        if (hnVar.a() <= 0) {
                            hnVar.b(System.currentTimeMillis());
                        }
                        return b(hnVar);
                    }
                    if (!z3) {
                        if (z) {
                            str = "MiTinyDataClient Pending " + hnVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID;
                        }
                        a(hnVar);
                        return true;
                    }
                    str = "MiTinyDataClient Pending " + hnVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT;
                    com.xiaomi.channel.commonutils.logger.b.c(str);
                    a(hnVar);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + SmallTailInfo.EMOTION_SUFFIX);
                ArrayList arrayList = new ArrayList();
                synchronized (this.f41a) {
                    arrayList.addAll(this.f41a);
                    this.f41a.clear();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    m106a((hn) it.next());
                }
            }
        }
    }

    public MiTinyDataClient() {
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

    public static void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m89a("context is null, MiTinyDataClient.init(Context, String) failed.");
                return;
            }
            a.a().m104a(context);
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m89a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
            } else {
                a.a().a(str);
            }
        }
    }

    public static boolean upload(Context context, hn hnVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, hnVar)) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hnVar.d());
            if (!a.a().m105a()) {
                a.a().m104a(context);
            }
            return a.a().m106a(hnVar);
        }
        return invokeLL.booleanValue;
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Long.valueOf(j), str3})) == null) {
            hn hnVar = new hn();
            hnVar.d(str);
            hnVar.c(str2);
            hnVar.a(j);
            hnVar.b(str3);
            hnVar.a(true);
            hnVar.a("push_sdk_channel");
            return upload(context, hnVar);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Long.valueOf(j), str3})) == null) {
            hn hnVar = new hn();
            hnVar.d(str);
            hnVar.c(str2);
            hnVar.a(j);
            hnVar.b(str3);
            return a.a().m106a(hnVar);
        }
        return invokeCommon.booleanValue;
    }
}
