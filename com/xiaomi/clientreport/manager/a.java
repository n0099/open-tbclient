package com.xiaomi.clientreport.manager;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ai;
import com.xiaomi.push.bm;
import com.xiaomi.push.bn;
import com.xiaomi.push.bo;
import com.xiaomi.push.bp;
import com.xiaomi.push.bq;
import com.xiaomi.push.bt;
import com.xiaomi.push.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f40008a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile a f30a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f31a;

    /* renamed from: a  reason: collision with other field name */
    public Config f32a;

    /* renamed from: a  reason: collision with other field name */
    public IEventProcessor f33a;

    /* renamed from: a  reason: collision with other field name */
    public IPerfProcessor f34a;

    /* renamed from: a  reason: collision with other field name */
    public String f35a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f36a;

    /* renamed from: a  reason: collision with other field name */
    public ExecutorService f37a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f40009b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1753960242, "Lcom/xiaomi/clientreport/manager/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1753960242, "Lcom/xiaomi/clientreport/manager/a;");
                return;
            }
        }
        f40008a = l.m535a() ? 30 : 10;
    }

    public a(Context context) {
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
        this.f37a = Executors.newSingleThreadExecutor();
        this.f36a = new HashMap<>();
        this.f40009b = new HashMap<>();
        this.f31a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f40009b;
            if (hashMap != null) {
                int i2 = 0;
                for (String str : hashMap.keySet()) {
                    ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f40009b.get(str);
                    i2 += arrayList != null ? arrayList.size() : 0;
                }
                return i2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (f30a == null) {
                synchronized (a.class) {
                    if (f30a == null) {
                        f30a = new a(context);
                    }
                }
            }
            return f30a;
        }
        return (a) invokeL.objValue;
    }

    private void a(ai.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, aVar, i2) == null) {
            ai.a(this.f31a).b(aVar, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f36a;
            int i2 = 0;
            if (hashMap != null) {
                for (String str : hashMap.keySet()) {
                    HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f36a.get(str);
                    if (hashMap2 != null) {
                        for (String str2 : hashMap2.keySet()) {
                            com.xiaomi.clientreport.data.a aVar = hashMap2.get(str2);
                            if (aVar instanceof PerfClientReport) {
                                i2 = (int) (i2 + ((PerfClientReport) aVar).perfCounts);
                            }
                        }
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, eventClientReport) == null) || (iEventProcessor = this.f33a) == null) {
            return;
        }
        iEventProcessor.mo78a(eventClientReport);
        if (a() < 10) {
            a(new d(this), f40008a);
            return;
        }
        d();
        ai.a(this.f31a).m143a("100888");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, perfClientReport) == null) || (iPerfProcessor = this.f34a) == null) {
            return;
        }
        iPerfProcessor.mo78a(perfClientReport);
        if (b() < 10) {
            a(new f(this), f40008a);
            return;
        }
        e();
        ai.a(this.f31a).m143a("100889");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            try {
                this.f33a.b();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("we: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            try {
                this.f34a.b();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("wp: " + e2.getMessage());
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65553, this) == null) && a(this.f31a).m75a().isEventUploadSwitchOpen()) {
            bn bnVar = new bn(this.f31a);
            int eventUploadFrequency = (int) a(this.f31a).m75a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bt.a(this.f31a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                ai.a(this.f31a).a(new h(this, bnVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f31a).a((ai.a) bnVar, eventUploadFrequency)) {
                    ai.a(this.f31a).m143a("100886");
                    ai.a(this.f31a).a((ai.a) bnVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && a(this.f31a).m75a().isPerfUploadSwitchOpen()) {
            bo boVar = new bo(this.f31a);
            int perfUploadFrequency = (int) a(this.f31a).m75a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bt.a(this.f31a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                ai.a(this.f31a).a(new i(this, boVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f31a).a((ai.a) boVar, perfUploadFrequency)) {
                    ai.a(this.f31a).m143a("100887");
                    ai.a(this.f31a).a((ai.a) boVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m75a() {
        InterceptResult invokeV;
        Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f32a == null) {
                    this.f32a = Config.defaultConfig(this.f31a);
                }
                config = this.f32a;
            }
            return config;
        }
        return (Config) invokeV.objValue;
    }

    public EventClientReport a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            EventClientReport eventClientReport = new EventClientReport();
            eventClientReport.eventContent = str;
            eventClientReport.eventTime = System.currentTimeMillis();
            eventClientReport.eventType = i2;
            eventClientReport.eventId = bm.a(6);
            eventClientReport.production = 1000;
            eventClientReport.reportType = 1001;
            eventClientReport.clientInterfaceId = "E100004";
            eventClientReport.setAppPackageName(this.f31a.getPackageName());
            eventClientReport.setSdkVersion(this.f35a);
            return eventClientReport;
        }
        return (EventClientReport) invokeIL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m76a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(this.f31a).f();
            a(this.f31a).g();
        }
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, config, iEventProcessor, iPerfProcessor) == null) {
            this.f32a = config;
            this.f33a = iEventProcessor;
            this.f34a = iPerfProcessor;
            iEventProcessor.setEventMap(this.f40009b);
            this.f34a.setPerfMap(this.f36a);
        }
    }

    public void a(EventClientReport eventClientReport) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, eventClientReport) == null) && m75a().isEventUploadSwitchOpen()) {
            this.f37a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, perfClientReport) == null) && m75a().isPerfUploadSwitchOpen()) {
            this.f37a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f35a = str;
        }
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) || (config = this.f32a) == null) {
            return;
        }
        if (z == config.isEventUploadSwitchOpen() && z2 == this.f32a.isPerfUploadSwitchOpen() && j == this.f32a.getEventUploadFrequency() && j2 == this.f32a.getPerfUploadFrequency()) {
            return;
        }
        long eventUploadFrequency = this.f32a.getEventUploadFrequency();
        long perfUploadFrequency = this.f32a.getPerfUploadFrequency();
        Config build = Config.getBuilder().setAESKey(bq.a(this.f31a)).setEventEncrypted(this.f32a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f31a);
        this.f32a = build;
        if (!build.isEventUploadSwitchOpen()) {
            ai.a(this.f31a).m143a("100886");
        } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
            com.xiaomi.channel.commonutils.logger.b.c(this.f31a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
            f();
        }
        if (!this.f32a.isPerfUploadSwitchOpen()) {
            ai.a(this.f31a).m143a("100887");
        } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
            com.xiaomi.channel.commonutils.logger.b.c(this.f31a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
            g();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m77b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && m75a().isEventUploadSwitchOpen()) {
            bp bpVar = new bp();
            bpVar.a(this.f31a);
            bpVar.a(this.f33a);
            this.f37a.execute(bpVar);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && m75a().isPerfUploadSwitchOpen()) {
            bp bpVar = new bp();
            bpVar.a(this.f34a);
            bpVar.a(this.f31a);
            this.f37a.execute(bpVar);
        }
    }
}
