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
import com.xiaomi.push.al;
import com.xiaomi.push.bp;
import com.xiaomi.push.bq;
import com.xiaomi.push.br;
import com.xiaomi.push.bs;
import com.xiaomi.push.bt;
import com.xiaomi.push.bw;
import com.xiaomi.push.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile a f11a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f12a;

    /* renamed from: a  reason: collision with other field name */
    public Config f13a;

    /* renamed from: a  reason: collision with other field name */
    public IEventProcessor f14a;

    /* renamed from: a  reason: collision with other field name */
    public IPerfProcessor f15a;

    /* renamed from: a  reason: collision with other field name */
    public String f16a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f17a;

    /* renamed from: a  reason: collision with other field name */
    public ExecutorService f18a;
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b;

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
        a = m.m555a() ? 30 : 10;
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18a = Executors.newSingleThreadExecutor();
        this.f17a = new HashMap<>();
        this.b = new HashMap<>();
        this.f12a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.b;
            if (hashMap != null) {
                int i = 0;
                for (String str : hashMap.keySet()) {
                    ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.b.get(str);
                    i += arrayList != null ? arrayList.size() : 0;
                }
                return i;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (f11a == null) {
                synchronized (a.class) {
                    if (f11a == null) {
                        f11a = new a(context);
                    }
                }
            }
            return f11a;
        }
        return (a) invokeL.objValue;
    }

    private void a(al.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, aVar, i) == null) {
            al.a(this.f12a).b(aVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f17a;
            int i = 0;
            if (hashMap != null) {
                for (String str : hashMap.keySet()) {
                    HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f17a.get(str);
                    if (hashMap2 != null) {
                        for (String str2 : hashMap2.keySet()) {
                            com.xiaomi.clientreport.data.a aVar = hashMap2.get(str2);
                            if (aVar instanceof PerfClientReport) {
                                i = (int) (i + ((PerfClientReport) aVar).perfCounts);
                            }
                        }
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, eventClientReport) == null) || (iEventProcessor = this.f14a) == null) {
            return;
        }
        iEventProcessor.mo92a(eventClientReport);
        if (a() < 10) {
            a(new d(this), a);
            return;
        }
        d();
        al.a(this.f12a).m162a("100888");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, perfClientReport) == null) || (iPerfProcessor = this.f15a) == null) {
            return;
        }
        iPerfProcessor.mo92a(perfClientReport);
        if (b() < 10) {
            a(new f(this), a);
            return;
        }
        e();
        al.a(this.f12a).m162a("100889");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            try {
                this.f14a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            try {
                this.f15a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65553, this) == null) && a(this.f12a).m89a().isEventUploadSwitchOpen()) {
            bq bqVar = new bq(this.f12a);
            int eventUploadFrequency = (int) a(this.f12a).m89a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bw.a(this.f12a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                al.a(this.f12a).a(new h(this, bqVar), 10);
            }
            synchronized (a.class) {
                if (!al.a(this.f12a).a((al.a) bqVar, eventUploadFrequency)) {
                    al.a(this.f12a).m162a("100886");
                    al.a(this.f12a).a((al.a) bqVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && a(this.f12a).m89a().isPerfUploadSwitchOpen()) {
            br brVar = new br(this.f12a);
            int perfUploadFrequency = (int) a(this.f12a).m89a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bw.a(this.f12a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                al.a(this.f12a).a(new i(this, brVar), 15);
            }
            synchronized (a.class) {
                if (!al.a(this.f12a).a((al.a) brVar, perfUploadFrequency)) {
                    al.a(this.f12a).m162a("100887");
                    al.a(this.f12a).a((al.a) brVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m89a() {
        InterceptResult invokeV;
        Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f13a == null) {
                    this.f13a = Config.defaultConfig(this.f12a);
                }
                config = this.f13a;
            }
            return config;
        }
        return (Config) invokeV.objValue;
    }

    public EventClientReport a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
            EventClientReport eventClientReport = new EventClientReport();
            eventClientReport.eventContent = str;
            eventClientReport.eventTime = System.currentTimeMillis();
            eventClientReport.eventType = i;
            eventClientReport.eventId = bp.a(6);
            eventClientReport.production = 1000;
            eventClientReport.reportType = 1001;
            eventClientReport.clientInterfaceId = "E100004";
            eventClientReport.setAppPackageName(this.f12a.getPackageName());
            eventClientReport.setSdkVersion(this.f16a);
            return eventClientReport;
        }
        return (EventClientReport) invokeIL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m90a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(this.f12a).f();
            a(this.f12a).g();
        }
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, config, iEventProcessor, iPerfProcessor) == null) {
            this.f13a = config;
            this.f14a = iEventProcessor;
            this.f15a = iPerfProcessor;
            iEventProcessor.setEventMap(this.b);
            this.f15a.setPerfMap(this.f17a);
        }
    }

    public void a(EventClientReport eventClientReport) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, eventClientReport) == null) && m89a().isEventUploadSwitchOpen()) {
            this.f18a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, perfClientReport) == null) && m89a().isPerfUploadSwitchOpen()) {
            this.f18a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f16a = str;
        }
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) || (config = this.f13a) == null) {
            return;
        }
        if (z == config.isEventUploadSwitchOpen() && z2 == this.f13a.isPerfUploadSwitchOpen() && j == this.f13a.getEventUploadFrequency() && j2 == this.f13a.getPerfUploadFrequency()) {
            return;
        }
        long eventUploadFrequency = this.f13a.getEventUploadFrequency();
        long perfUploadFrequency = this.f13a.getPerfUploadFrequency();
        Config build = Config.getBuilder().setAESKey(bt.a(this.f12a)).setEventEncrypted(this.f13a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f12a);
        this.f13a = build;
        if (!build.isEventUploadSwitchOpen()) {
            al.a(this.f12a).m162a("100886");
        } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
            com.xiaomi.channel.commonutils.logger.b.c(this.f12a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
            f();
        }
        if (!this.f13a.isPerfUploadSwitchOpen()) {
            al.a(this.f12a).m162a("100887");
        } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
            com.xiaomi.channel.commonutils.logger.b.c(this.f12a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
            g();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m91b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && m89a().isEventUploadSwitchOpen()) {
            bs bsVar = new bs();
            bsVar.a(this.f12a);
            bsVar.a(this.f14a);
            this.f18a.execute(bsVar);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && m89a().isPerfUploadSwitchOpen()) {
            bs bsVar = new bs();
            bsVar.a(this.f15a);
            bsVar.a(this.f12a);
            this.f18a.execute(bsVar);
        }
    }
}
