package com.xiaomi.clientreport.manager;

import android.content.Context;
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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f40413a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile a f27a;

    /* renamed from: a  reason: collision with other field name */
    public Context f28a;

    /* renamed from: a  reason: collision with other field name */
    public Config f29a;

    /* renamed from: a  reason: collision with other field name */
    public IEventProcessor f30a;

    /* renamed from: a  reason: collision with other field name */
    public IPerfProcessor f31a;

    /* renamed from: a  reason: collision with other field name */
    public String f32a;

    /* renamed from: a  reason: collision with other field name */
    public ExecutorService f34a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f33a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f40414b = new HashMap<>();

    static {
        f40413a = l.m520a() ? 30 : 10;
    }

    public a(Context context) {
        this.f28a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f40414b;
        if (hashMap != null) {
            int i = 0;
            for (String str : hashMap.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f40414b.get(str);
                i += arrayList != null ? arrayList.size() : 0;
            }
            return i;
        }
        return 0;
    }

    public static a a(Context context) {
        if (f27a == null) {
            synchronized (a.class) {
                if (f27a == null) {
                    f27a = new a(context);
                }
            }
        }
        return f27a;
    }

    private void a(ai.a aVar, int i) {
        ai.a(this.f28a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f33a;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f33a.get(str);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f30a;
        if (iEventProcessor != null) {
            iEventProcessor.mo63a(eventClientReport);
            if (a() < 10) {
                a(new d(this), f40413a);
                return;
            }
            d();
            ai.a(this.f28a).m128a("100888");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f31a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo63a(perfClientReport);
            if (b() < 10) {
                a(new f(this), f40413a);
                return;
            }
            e();
            ai.a(this.f28a).m128a("100889");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f30a.b();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f31a.b();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e2.getMessage());
        }
    }

    private void f() {
        if (a(this.f28a).m60a().isEventUploadSwitchOpen()) {
            bn bnVar = new bn(this.f28a);
            int eventUploadFrequency = (int) a(this.f28a).m60a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bt.a(this.f28a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                ai.a(this.f28a).a(new h(this, bnVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f28a).a((ai.a) bnVar, eventUploadFrequency)) {
                    ai.a(this.f28a).m128a("100886");
                    ai.a(this.f28a).a((ai.a) bnVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f28a).m60a().isPerfUploadSwitchOpen()) {
            bo boVar = new bo(this.f28a);
            int perfUploadFrequency = (int) a(this.f28a).m60a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bt.a(this.f28a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                ai.a(this.f28a).a(new i(this, boVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f28a).a((ai.a) boVar, perfUploadFrequency)) {
                    ai.a(this.f28a).m128a("100887");
                    ai.a(this.f28a).a((ai.a) boVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m60a() {
        if (this.f29a == null) {
            this.f29a = Config.defaultConfig(this.f28a);
        }
        return this.f29a;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bm.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f28a.getPackageName());
        eventClientReport.setSdkVersion(this.f32a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m61a() {
        a(this.f28a).f();
        a(this.f28a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f29a = config;
        this.f30a = iEventProcessor;
        this.f31a = iPerfProcessor;
        iEventProcessor.setEventMap(this.f40414b);
        this.f31a.setPerfMap(this.f33a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m60a().isEventUploadSwitchOpen()) {
            this.f34a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m60a().isPerfUploadSwitchOpen()) {
            this.f34a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f32a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f29a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f29a.isPerfUploadSwitchOpen() && j == this.f29a.getEventUploadFrequency() && j2 == this.f29a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f29a.getEventUploadFrequency();
            long perfUploadFrequency = this.f29a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bq.a(this.f28a)).setEventEncrypted(this.f29a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f28a);
            this.f29a = build;
            if (!build.isEventUploadSwitchOpen()) {
                ai.a(this.f28a).m128a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f28a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f29a.isPerfUploadSwitchOpen()) {
                ai.a(this.f28a).m128a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f28a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m62b() {
        if (m60a().isEventUploadSwitchOpen()) {
            bp bpVar = new bp();
            bpVar.a(this.f28a);
            bpVar.a(this.f30a);
            this.f34a.execute(bpVar);
        }
    }

    public void c() {
        if (m60a().isPerfUploadSwitchOpen()) {
            bp bpVar = new bp();
            bpVar.a(this.f31a);
            bpVar.a(this.f28a);
            this.f34a.execute(bpVar);
        }
    }
}
