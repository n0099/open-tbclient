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
    public static volatile a f15a;

    /* renamed from: a  reason: collision with other field name */
    public Context f16a;

    /* renamed from: a  reason: collision with other field name */
    public Config f17a;

    /* renamed from: a  reason: collision with other field name */
    public IEventProcessor f18a;

    /* renamed from: a  reason: collision with other field name */
    public IPerfProcessor f19a;

    /* renamed from: a  reason: collision with other field name */
    public String f20a;

    /* renamed from: a  reason: collision with other field name */
    public ExecutorService f22a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f21a = new HashMap<>();
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        a = j.m720a() ? 30 : 10;
    }

    public a(Context context) {
        this.f16a = context;
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
        if (f15a == null) {
            synchronized (a.class) {
                if (f15a == null) {
                    f15a = new a(context);
                }
            }
        }
        return f15a;
    }

    private void a(aj.a aVar, int i) {
        aj.a(this.f16a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f21a;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f21a.get(str);
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
        IEventProcessor iEventProcessor = this.f18a;
        if (iEventProcessor != null) {
            iEventProcessor.mo198a(eventClientReport);
            if (a() < 10) {
                a(new d(this), a);
                return;
            }
            d();
            aj.a(this.f16a).m270a("100888");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f19a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo198a(perfClientReport);
            if (b() < 10) {
                a(new f(this), a);
                return;
            }
            e();
            aj.a(this.f16a).m270a("100889");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f18a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f19a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f16a).m195a().isEventUploadSwitchOpen()) {
            bp bpVar = new bp(this.f16a);
            int eventUploadFrequency = (int) a(this.f16a).m195a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bv.a(this.f16a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                aj.a(this.f16a).a(new h(this, bpVar), 10);
            }
            synchronized (a.class) {
                if (!aj.a(this.f16a).a((aj.a) bpVar, eventUploadFrequency)) {
                    aj.a(this.f16a).m270a("100886");
                    aj.a(this.f16a).a((aj.a) bpVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f16a).m195a().isPerfUploadSwitchOpen()) {
            bq bqVar = new bq(this.f16a);
            int perfUploadFrequency = (int) a(this.f16a).m195a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bv.a(this.f16a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                aj.a(this.f16a).a(new i(this, bqVar), 15);
            }
            synchronized (a.class) {
                if (!aj.a(this.f16a).a((aj.a) bqVar, perfUploadFrequency)) {
                    aj.a(this.f16a).m270a("100887");
                    aj.a(this.f16a).a((aj.a) bqVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m195a() {
        if (this.f17a == null) {
            this.f17a = Config.defaultConfig(this.f16a);
        }
        return this.f17a;
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
        eventClientReport.setAppPackageName(this.f16a.getPackageName());
        eventClientReport.setSdkVersion(this.f20a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m196a() {
        a(this.f16a).f();
        a(this.f16a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f17a = config;
        this.f18a = iEventProcessor;
        this.f19a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f19a.setPerfMap(this.f21a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m195a().isEventUploadSwitchOpen()) {
            this.f22a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m195a().isPerfUploadSwitchOpen()) {
            this.f22a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f20a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f17a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f17a.isPerfUploadSwitchOpen() && j == this.f17a.getEventUploadFrequency() && j2 == this.f17a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f17a.getEventUploadFrequency();
            long perfUploadFrequency = this.f17a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bs.a(this.f16a)).setEventEncrypted(this.f17a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f16a);
            this.f17a = build;
            if (!build.isEventUploadSwitchOpen()) {
                aj.a(this.f16a).m270a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f16a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f17a.isPerfUploadSwitchOpen()) {
                aj.a(this.f16a).m270a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f16a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m197b() {
        if (m195a().isEventUploadSwitchOpen()) {
            br brVar = new br();
            brVar.a(this.f16a);
            brVar.a(this.f18a);
            this.f22a.execute(brVar);
        }
    }

    public void c() {
        if (m195a().isPerfUploadSwitchOpen()) {
            br brVar = new br();
            brVar.a(this.f19a);
            brVar.a(this.f16a);
            this.f22a.execute(brVar);
        }
    }
}
