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
/* loaded from: classes4.dex */
public class MiTinyDataClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static volatile a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public Context f53a;

        /* renamed from: a  reason: collision with other field name */
        public C2265a f54a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f55a;

        /* renamed from: a  reason: collision with other field name */
        public String f56a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<hj> f57a;

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2265a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: a  reason: collision with other field name */
            public final Runnable f58a;

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hj> f59a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledFuture<?> f60a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledThreadPoolExecutor f61a;

            public C2265a(a aVar) {
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
                this.a = aVar;
                this.f61a = new ScheduledThreadPoolExecutor(1);
                this.f59a = new ArrayList<>();
                this.f58a = new aa(this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f60a == null) {
                    this.f60a = this.f61a.scheduleAtFixedRate(this.f58a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                    hj remove = this.f59a.remove(0);
                    for (ie ieVar : bm.a(Arrays.asList(remove), this.a.f53a.getPackageName(), b.m175a(this.a.f53a).m176a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                        an.a(this.a.f53a).a((an) ieVar, hf.f61211i, true, (hs) null);
                    }
                }
            }

            public void a(hj hjVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hjVar) == null) {
                    this.f61a.execute(new z(this, hjVar));
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
            this.f54a = new C2265a(this);
            this.f57a = new ArrayList<>();
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

        private void a(hj hjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, hjVar) == null) {
                synchronized (this.f57a) {
                    if (!this.f57a.contains(hjVar)) {
                        this.f57a.add(hjVar);
                        if (this.f57a.size() > 100) {
                            this.f57a.remove(0);
                        }
                    }
                }
            }
        }

        private boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
                if (an.a(context).m168a()) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) ? b.m175a(context).m176a() == null && !a(this.f53a) : invokeL.booleanValue;
        }

        private boolean b(hj hjVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, hjVar)) == null) {
                if (bm.a(hjVar, false)) {
                    return false;
                }
                if (!this.f55a.booleanValue()) {
                    this.f54a.a(hjVar);
                    return true;
                }
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hjVar.d());
                an.a(this.f53a).a(hjVar);
                return true;
            }
            return invokeL.booleanValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m148a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                if (context == null) {
                    com.xiaomi.channel.commonutils.logger.b.m134a("context is null, MiTinyDataClientImp.init() failed.");
                    return;
                }
                this.f53a = context;
                this.f55a = Boolean.valueOf(a(context));
                b(MiTinyDataClient.PENDING_REASON_INIT);
            }
        }

        public synchronized void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (TextUtils.isEmpty(str)) {
                        com.xiaomi.channel.commonutils.logger.b.m134a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                        return;
                    }
                    this.f56a = str;
                    b(MiTinyDataClient.PENDING_REASON_CHANNEL);
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m149a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53a != null : invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m150a(hj hjVar) {
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
                    boolean z2 = TextUtils.isEmpty(hjVar.m439a()) && TextUtils.isEmpty(this.f56a);
                    boolean z3 = !m149a();
                    z = (this.f53a == null || b(this.f53a)) ? true : true;
                    if (!z3 && !z2 && !z) {
                        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hjVar.d());
                        if (TextUtils.isEmpty(hjVar.d())) {
                            hjVar.f(com.xiaomi.push.service.at.a());
                        }
                        if (TextUtils.isEmpty(hjVar.m439a())) {
                            hjVar.a(this.f56a);
                        }
                        if (TextUtils.isEmpty(hjVar.c())) {
                            hjVar.e(this.f53a.getPackageName());
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
                synchronized (this.f57a) {
                    arrayList.addAll(this.f57a);
                    this.f57a.clear();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    m150a((hj) it.next());
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
                com.xiaomi.channel.commonutils.logger.b.m134a("context is null, MiTinyDataClient.init(Context, String) failed.");
                return;
            }
            a.a().m148a(context);
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m134a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
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
            if (!a.a().m149a()) {
                a.a().m148a(context);
            }
            return a.a().m150a(hjVar);
        }
        return invokeLL.booleanValue;
    }

    public static boolean upload(Context context, String str, String str2, long j2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Long.valueOf(j2), str3})) == null) {
            hj hjVar = new hj();
            hjVar.d(str);
            hjVar.c(str2);
            hjVar.a(j2);
            hjVar.b(str3);
            hjVar.a(true);
            hjVar.a("push_sdk_channel");
            return upload(context, hjVar);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean upload(String str, String str2, long j2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Long.valueOf(j2), str3})) == null) {
            hj hjVar = new hj();
            hjVar.d(str);
            hjVar.c(str2);
            hjVar.a(j2);
            hjVar.b(str3);
            return a.a().m150a(hjVar);
        }
        return invokeCommon.booleanValue;
    }
}
