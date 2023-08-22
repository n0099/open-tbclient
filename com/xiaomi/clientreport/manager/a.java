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
    public static volatile a f20a;

    /* renamed from: a  reason: collision with other field name */
    public Context f21a;

    /* renamed from: a  reason: collision with other field name */
    public Config f22a;

    /* renamed from: a  reason: collision with other field name */
    public IEventProcessor f23a;

    /* renamed from: a  reason: collision with other field name */
    public IPerfProcessor f24a;

    /* renamed from: a  reason: collision with other field name */
    public String f25a;

    /* renamed from: a  reason: collision with other field name */
    public ExecutorService f27a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f26a = new HashMap<>();
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        a = j.m710a() ? 30 : 10;
    }

    public a(Context context) {
        this.f21a = context;
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
        if (f20a == null) {
            synchronized (a.class) {
                if (f20a == null) {
                    f20a = new a(context);
                }
            }
        }
        return f20a;
    }

    private void a(aj.a aVar, int i) {
        aj.a(this.f21a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f26a;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f26a.get(str);
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
        IEventProcessor iEventProcessor = this.f23a;
        if (iEventProcessor != null) {
            iEventProcessor.mo188a(eventClientReport);
            if (a() < 10) {
                a(new d(this), a);
                return;
            }
            d();
            aj.a(this.f21a).m260a("100888");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f24a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo188a(perfClientReport);
            if (b() < 10) {
                a(new f(this), a);
                return;
            }
            e();
            aj.a(this.f21a).m260a("100889");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f23a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f24a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f21a).m185a().isEventUploadSwitchOpen()) {
            bp bpVar = new bp(this.f21a);
            int eventUploadFrequency = (int) a(this.f21a).m185a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bv.a(this.f21a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                aj.a(this.f21a).a(new h(this, bpVar), 10);
            }
            synchronized (a.class) {
                if (!aj.a(this.f21a).a((aj.a) bpVar, eventUploadFrequency)) {
                    aj.a(this.f21a).m260a("100886");
                    aj.a(this.f21a).a((aj.a) bpVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f21a).m185a().isPerfUploadSwitchOpen()) {
            bq bqVar = new bq(this.f21a);
            int perfUploadFrequency = (int) a(this.f21a).m185a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bv.a(this.f21a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                aj.a(this.f21a).a(new i(this, bqVar), 15);
            }
            synchronized (a.class) {
                if (!aj.a(this.f21a).a((aj.a) bqVar, perfUploadFrequency)) {
                    aj.a(this.f21a).m260a("100887");
                    aj.a(this.f21a).a((aj.a) bqVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m185a() {
        if (this.f22a == null) {
            this.f22a = Config.defaultConfig(this.f21a);
        }
        return this.f22a;
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
        eventClientReport.setAppPackageName(this.f21a.getPackageName());
        eventClientReport.setSdkVersion(this.f25a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m186a() {
        a(this.f21a).f();
        a(this.f21a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f22a = config;
        this.f23a = iEventProcessor;
        this.f24a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f24a.setPerfMap(this.f26a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m185a().isEventUploadSwitchOpen()) {
            this.f27a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m185a().isPerfUploadSwitchOpen()) {
            this.f27a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f25a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f22a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f22a.isPerfUploadSwitchOpen() && j == this.f22a.getEventUploadFrequency() && j2 == this.f22a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f22a.getEventUploadFrequency();
            long perfUploadFrequency = this.f22a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bs.a(this.f21a)).setEventEncrypted(this.f22a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f21a);
            this.f22a = build;
            if (!build.isEventUploadSwitchOpen()) {
                aj.a(this.f21a).m260a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f21a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f22a.isPerfUploadSwitchOpen()) {
                aj.a(this.f21a).m260a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f21a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m187b() {
        if (m185a().isEventUploadSwitchOpen()) {
            br brVar = new br();
            brVar.a(this.f21a);
            brVar.a(this.f23a);
            this.f27a.execute(brVar);
        }
    }

    public void c() {
        if (m185a().isPerfUploadSwitchOpen()) {
            br brVar = new br();
            brVar.a(this.f24a);
            brVar.a(this.f21a);
            this.f27a.execute(brVar);
        }
    }
}
