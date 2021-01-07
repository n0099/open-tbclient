package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ai;
import com.xiaomi.push.bf;
import com.xiaomi.push.bg;
import com.xiaomi.push.bh;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bm;
import com.xiaomi.push.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f14072a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile a f90a;

    /* renamed from: a  reason: collision with other field name */
    private Context f91a;

    /* renamed from: a  reason: collision with other field name */
    private Config f92a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f93a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f94a;

    /* renamed from: a  reason: collision with other field name */
    private String f95a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f97a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f96a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f14073b = new HashMap<>();

    static {
        f14072a = l.m530a() ? 30 : 10;
    }

    private a(Context context) {
        this.f91a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        if (this.f14073b != null) {
            int i = 0;
            for (String str : this.f14073b.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f14073b.get(str);
                i = (arrayList != null ? arrayList.size() : 0) + i;
            }
            return i;
        }
        return 0;
    }

    public static a a(Context context) {
        if (f90a == null) {
            synchronized (a.class) {
                if (f90a == null) {
                    f90a = new a(context);
                }
            }
        }
        return f90a;
    }

    private void a(ai.a aVar, int i) {
        ai.a(this.f91a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        int i;
        int i2 = 0;
        if (this.f96a == null) {
            return 0;
        }
        Iterator<String> it = this.f96a.keySet().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3;
            }
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f96a.get(it.next());
            if (hashMap != null) {
                Iterator<String> it2 = hashMap.keySet().iterator();
                while (true) {
                    i = i3;
                    if (!it2.hasNext()) {
                        break;
                    }
                    com.xiaomi.clientreport.data.a aVar = hashMap.get(it2.next());
                    i3 = aVar instanceof PerfClientReport ? (int) (i + ((PerfClientReport) aVar).perfCounts) : i;
                }
                i2 = i;
            } else {
                i2 = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        if (this.f93a != null) {
            this.f93a.mo91a(eventClientReport);
            if (a() < 10) {
                a(new d(this), f14072a);
                return;
            }
            d();
            ai.a(this.f91a).m158a(100888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        if (this.f94a != null) {
            this.f94a.mo91a(perfClientReport);
            if (b() < 10) {
                a(new f(this), f14072a);
                return;
            }
            e();
            ai.a(this.f91a).m158a(100889);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f93a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f94a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f91a).m88a().isEventUploadSwitchOpen()) {
            bg bgVar = new bg(this.f91a);
            int eventUploadFrequency = (int) a(this.f91a).m88a().getEventUploadFrequency();
            int i = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f91a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f91a).a(new h(this, bgVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f91a).a((ai.a) bgVar, i)) {
                    ai.a(this.f91a).m158a(100886);
                    ai.a(this.f91a).a((ai.a) bgVar, i);
                }
            }
        }
    }

    private void g() {
        if (a(this.f91a).m88a().isPerfUploadSwitchOpen()) {
            bh bhVar = new bh(this.f91a);
            int perfUploadFrequency = (int) a(this.f91a).m88a().getPerfUploadFrequency();
            int i = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f91a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f91a).a(new i(this, bhVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f91a).a((ai.a) bhVar, i)) {
                    ai.a(this.f91a).m158a(100887);
                    ai.a(this.f91a).a((ai.a) bhVar, i);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m88a() {
        if (this.f92a == null) {
            this.f92a = Config.defaultConfig(this.f91a);
        }
        return this.f92a;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bf.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f91a.getPackageName());
        eventClientReport.setSdkVersion(this.f95a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m89a() {
        a(this.f91a).f();
        a(this.f91a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f92a = config;
        this.f93a = iEventProcessor;
        this.f94a = iPerfProcessor;
        this.f93a.setEventMap(this.f14073b);
        this.f94a.setPerfMap(this.f96a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m88a().isEventUploadSwitchOpen()) {
            this.f97a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m88a().isPerfUploadSwitchOpen()) {
            this.f97a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f95a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        if (this.f92a != null) {
            if (z == this.f92a.isEventUploadSwitchOpen() && z2 == this.f92a.isPerfUploadSwitchOpen() && j == this.f92a.getEventUploadFrequency() && j2 == this.f92a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f92a.getEventUploadFrequency();
            long perfUploadFrequency = this.f92a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bj.a(this.f91a)).setEventEncrypted(this.f92a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f91a);
            this.f92a = build;
            if (!this.f92a.isEventUploadSwitchOpen()) {
                ai.a(this.f91a).m158a(100886);
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f91a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f92a.isPerfUploadSwitchOpen()) {
                ai.a(this.f91a).m158a(100887);
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f91a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m90b() {
        if (m88a().isEventUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f91a);
            biVar.a(this.f93a);
            this.f97a.execute(biVar);
        }
    }

    public void c() {
        if (m88a().isPerfUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f94a);
            biVar.a(this.f91a);
            this.f97a.execute(biVar);
        }
    }
}
