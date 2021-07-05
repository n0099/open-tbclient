package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
import com.xiaomi.push.service.bm;
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

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f42741a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public Context f48a;

        /* renamed from: a  reason: collision with other field name */
        public C0568a f49a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f50a;

        /* renamed from: a  reason: collision with other field name */
        public String f51a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<hj> f52a;

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0568a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f42742a;

            /* renamed from: a  reason: collision with other field name */
            public final Runnable f53a;

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hj> f54a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledFuture<?> f55a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledThreadPoolExecutor f56a;

            public C0568a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42742a = aVar;
                this.f56a = new ScheduledThreadPoolExecutor(1);
                this.f54a = new ArrayList<>();
                this.f53a = new aa(this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f55a == null) {
                    this.f55a = this.f56a.scheduleAtFixedRate(this.f53a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                    hj remove = this.f54a.remove(0);
                    for (ie ieVar : bm.a(Arrays.asList(remove), this.f42742a.f48a.getPackageName(), b.m111a(this.f42742a.f48a).m112a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                        an.a(this.f42742a.f48a).a((an) ieVar, hf.f43244i, true, (hs) null);
                    }
                }
            }

            public void a(hj hjVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hjVar) == null) {
                    this.f56a.execute(new z(this, hjVar));
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49a = new C0568a(this);
            this.f52a = new ArrayList<>();
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f42741a == null) {
                    synchronized (a.class) {
                        if (f42741a == null) {
                            f42741a = new a();
                        }
                    }
                }
                return f42741a;
            }
            return (a) invokeV.objValue;
        }

        private void a(hj hjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, hjVar) == null) {
                synchronized (this.f52a) {
                    if (!this.f52a.contains(hjVar)) {
                        this.f52a.add(hjVar);
                        if (this.f52a.size() > 100) {
                            this.f52a.remove(0);
                        }
                    }
                }
            }
        }

        private boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, context)) == null) {
                if (an.a(context).m104a()) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) ? b.m111a(context).m112a() == null && !a(this.f48a) : invokeL.booleanValue;
        }

        private boolean b(hj hjVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, hjVar)) == null) {
                if (bm.a(hjVar, false)) {
                    return false;
                }
                if (!this.f50a.booleanValue()) {
                    this.f49a.a(hjVar);
                    return true;
                }
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hjVar.d());
                an.a(this.f48a).a(hjVar);
                return true;
            }
            return invokeL.booleanValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m84a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                if (context == null) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("context is null, MiTinyDataClientImp.init() failed.");
                    return;
                }
                this.f48a = context;
                this.f50a = Boolean.valueOf(a(context));
                b(MiTinyDataClient.PENDING_REASON_INIT);
            }
        }

        public synchronized void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (TextUtils.isEmpty(str)) {
                        com.xiaomi.channel.commonutils.logger.b.m70a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                        return;
                    }
                    this.f51a = str;
                    b(MiTinyDataClient.PENDING_REASON_CHANNEL);
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m85a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48a != null : invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m86a(hj hjVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hjVar)) == null) {
                synchronized (this) {
                    boolean z = false;
                    if (hjVar == null) {
                        return false;
                    }
                    if (bm.a(hjVar, true)) {
                        return false;
                    }
                    boolean z2 = TextUtils.isEmpty(hjVar.m375a()) && TextUtils.isEmpty(this.f51a);
                    boolean z3 = !m85a();
                    z = (this.f48a == null || b(this.f48a)) ? true : true;
                    if (!z3 && !z2 && !z) {
                        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hjVar.d());
                        if (TextUtils.isEmpty(hjVar.d())) {
                            hjVar.f(com.xiaomi.push.service.at.a());
                        }
                        if (TextUtils.isEmpty(hjVar.m375a())) {
                            hjVar.a(this.f51a);
                        }
                        if (TextUtils.isEmpty(hjVar.c())) {
                            hjVar.e(this.f48a.getPackageName());
                        }
                        if (hjVar.a() <= 0) {
                            hjVar.b(System.currentTimeMillis());
                        }
                        return b(hjVar);
                    }
                    if (!z3) {
                        if (z) {
                            str = "MiTinyDataClient Pending " + hjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID;
                        }
                        a(hjVar);
                        return true;
                    }
                    str = "MiTinyDataClient Pending " + hjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT;
                    com.xiaomi.channel.commonutils.logger.b.c(str);
                    a(hjVar);
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
                synchronized (this.f52a) {
                    arrayList.addAll(this.f52a);
                    this.f52a.clear();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    m86a((hj) it.next());
                }
            }
        }
    }

    public MiTinyDataClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m70a("context is null, MiTinyDataClient.init(Context, String) failed.");
                return;
            }
            a.a().m84a(context);
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m70a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
            } else {
                a.a().a(str);
            }
        }
    }

    public static boolean upload(Context context, hj hjVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, hjVar)) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hjVar.d());
            if (!a.a().m85a()) {
                a.a().m84a(context);
            }
            return a.a().m86a(hjVar);
        }
        return invokeLL.booleanValue;
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Long.valueOf(j), str3})) == null) {
            hj hjVar = new hj();
            hjVar.d(str);
            hjVar.c(str2);
            hjVar.a(j);
            hjVar.b(str3);
            hjVar.a(true);
            hjVar.a("push_sdk_channel");
            return upload(context, hjVar);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{str, str2, Long.valueOf(j), str3})) == null) {
            hj hjVar = new hj();
            hjVar.d(str);
            hjVar.c(str2);
            hjVar.a(j);
            hjVar.b(str3);
            return a.a().m86a(hjVar);
        }
        return invokeCommon.booleanValue;
    }
}
