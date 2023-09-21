package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.aj;
import com.xiaomi.push.bo;
import com.xiaomi.push.bp;
import com.xiaomi.push.bq;
import com.xiaomi.push.br;
import com.xiaomi.push.bs;
import com.xiaomi.push.bv;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public class a {
    public static final int a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile a f19a;

    /* renamed from: a  reason: collision with other field name */
    public Context f20a;

    /* renamed from: a  reason: collision with other field name */
    public Config f21a;

    /* renamed from: a  reason: collision with other field name */
    public IEventProcessor f22a;

    /* renamed from: a  reason: collision with other field name */
    public IPerfProcessor f23a;

    /* renamed from: a  reason: collision with other field name */
    public String f24a;

    /* renamed from: a  reason: collision with other field name */
    public ExecutorService f26a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f25a = new HashMap<>();
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        a = j.m713a() ? 30 : 10;
    }

    public a(Context context) {
        this.f20a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
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

    public static a a(Context context) {
        if (f19a == null) {
            synchronized (a.class) {
                if (f19a == null) {
                    f19a = new a(context);
                }
            }
        }
        return f19a;
    }

    private void a(aj.a aVar, int i) {
        aj.a(this.f20a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f25a;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f25a.get(str);
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
        IEventProcessor iEventProcessor = this.f22a;
        if (iEventProcessor != null) {
            iEventProcessor.mo191a(eventClientReport);
            if (a() < 10) {
                a(new d(this), a);
                return;
            }
            d();
            aj.a(this.f20a).m263a("100888");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f23a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo191a(perfClientReport);
            if (b() < 10) {
                a(new f(this), a);
                return;
            }
            e();
            aj.a(this.f20a).m263a("100889");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f22a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f23a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f20a).m188a().isEventUploadSwitchOpen()) {
            bp bpVar = new bp(this.f20a);
            int eventUploadFrequency = (int) a(this.f20a).m188a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bv.a(this.f20a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                aj.a(this.f20a).a(new h(this, bpVar), 10);
            }
            synchronized (a.class) {
                if (!aj.a(this.f20a).a((aj.a) bpVar, eventUploadFrequency)) {
                    aj.a(this.f20a).m263a("100886");
                    aj.a(this.f20a).a((aj.a) bpVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f20a).m188a().isPerfUploadSwitchOpen()) {
            bq bqVar = new bq(this.f20a);
            int perfUploadFrequency = (int) a(this.f20a).m188a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bv.a(this.f20a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                aj.a(this.f20a).a(new i(this, bqVar), 15);
            }
            synchronized (a.class) {
                if (!aj.a(this.f20a).a((aj.a) bqVar, perfUploadFrequency)) {
                    aj.a(this.f20a).m263a("100887");
                    aj.a(this.f20a).a((aj.a) bqVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m188a() {
        if (this.f21a == null) {
            this.f21a = Config.defaultConfig(this.f20a);
        }
        return this.f21a;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bo.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f20a.getPackageName());
        eventClientReport.setSdkVersion(this.f24a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m189a() {
        a(this.f20a).f();
        a(this.f20a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f21a = config;
        this.f22a = iEventProcessor;
        this.f23a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f23a.setPerfMap(this.f25a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m188a().isEventUploadSwitchOpen()) {
            this.f26a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m188a().isPerfUploadSwitchOpen()) {
            this.f26a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f24a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f21a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f21a.isPerfUploadSwitchOpen() && j == this.f21a.getEventUploadFrequency() && j2 == this.f21a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f21a.getEventUploadFrequency();
            long perfUploadFrequency = this.f21a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bs.a(this.f20a)).setEventEncrypted(this.f21a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f20a);
            this.f21a = build;
            if (!build.isEventUploadSwitchOpen()) {
                aj.a(this.f20a).m263a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f20a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f21a.isPerfUploadSwitchOpen()) {
                aj.a(this.f20a).m263a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f20a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m190b() {
        if (m188a().isEventUploadSwitchOpen()) {
            br brVar = new br();
            brVar.a(this.f20a);
            brVar.a(this.f22a);
            this.f26a.execute(brVar);
        }
    }

    public void c() {
        if (m188a().isPerfUploadSwitchOpen()) {
            br brVar = new br();
            brVar.a(this.f23a);
            brVar.a(this.f20a);
            this.f26a.execute(brVar);
        }
    }
}
