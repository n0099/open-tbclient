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
/* loaded from: classes8.dex */
public class a {
    private static final int a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile a f9a;

    /* renamed from: a  reason: collision with other field name */
    private Context f10a;

    /* renamed from: a  reason: collision with other field name */
    private Config f11a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f12a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f13a;

    /* renamed from: a  reason: collision with other field name */
    private String f14a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f16a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f15a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        a = l.m496a() ? 30 : 10;
    }

    private a(Context context) {
        this.f10a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        if (this.b != null) {
            int i = 0;
            for (String str : this.b.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.b.get(str);
                i = (arrayList != null ? arrayList.size() : 0) + i;
            }
            return i;
        }
        return 0;
    }

    public static a a(Context context) {
        if (f9a == null) {
            synchronized (a.class) {
                if (f9a == null) {
                    f9a = new a(context);
                }
            }
        }
        return f9a;
    }

    private void a(ai.a aVar, int i) {
        ai.a(this.f10a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        int i;
        int i2 = 0;
        if (this.f15a == null) {
            return 0;
        }
        Iterator<String> it = this.f15a.keySet().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3;
            }
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f15a.get(it.next());
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
        if (this.f12a != null) {
            this.f12a.mo57a(eventClientReport);
            if (a() < 10) {
                a(new d(this), a);
                return;
            }
            d();
            ai.a(this.f10a).m124a(100888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        if (this.f13a != null) {
            this.f13a.mo57a(perfClientReport);
            if (b() < 10) {
                a(new f(this), a);
                return;
            }
            e();
            ai.a(this.f10a).m124a(100889);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f12a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f13a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f10a).m54a().isEventUploadSwitchOpen()) {
            bg bgVar = new bg(this.f10a);
            int eventUploadFrequency = (int) a(this.f10a).m54a().getEventUploadFrequency();
            int i = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f10a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f10a).a(new h(this, bgVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f10a).a((ai.a) bgVar, i)) {
                    ai.a(this.f10a).m124a(100886);
                    ai.a(this.f10a).a((ai.a) bgVar, i);
                }
            }
        }
    }

    private void g() {
        if (a(this.f10a).m54a().isPerfUploadSwitchOpen()) {
            bh bhVar = new bh(this.f10a);
            int perfUploadFrequency = (int) a(this.f10a).m54a().getPerfUploadFrequency();
            int i = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f10a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f10a).a(new i(this, bhVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f10a).a((ai.a) bhVar, i)) {
                    ai.a(this.f10a).m124a(100887);
                    ai.a(this.f10a).a((ai.a) bhVar, i);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m54a() {
        if (this.f11a == null) {
            this.f11a = Config.defaultConfig(this.f10a);
        }
        return this.f11a;
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
        eventClientReport.setAppPackageName(this.f10a.getPackageName());
        eventClientReport.setSdkVersion(this.f14a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m55a() {
        a(this.f10a).f();
        a(this.f10a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f11a = config;
        this.f12a = iEventProcessor;
        this.f13a = iPerfProcessor;
        this.f12a.setEventMap(this.b);
        this.f13a.setPerfMap(this.f15a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m54a().isEventUploadSwitchOpen()) {
            this.f16a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m54a().isPerfUploadSwitchOpen()) {
            this.f16a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f14a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        if (this.f11a != null) {
            if (z == this.f11a.isEventUploadSwitchOpen() && z2 == this.f11a.isPerfUploadSwitchOpen() && j == this.f11a.getEventUploadFrequency() && j2 == this.f11a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f11a.getEventUploadFrequency();
            long perfUploadFrequency = this.f11a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bj.a(this.f10a)).setEventEncrypted(this.f11a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f10a);
            this.f11a = build;
            if (!this.f11a.isEventUploadSwitchOpen()) {
                ai.a(this.f10a).m124a(100886);
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f10a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f11a.isPerfUploadSwitchOpen()) {
                ai.a(this.f10a).m124a(100887);
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f10a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m56b() {
        if (m54a().isEventUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f10a);
            biVar.a(this.f12a);
            this.f16a.execute(biVar);
        }
    }

    public void c() {
        if (m54a().isPerfUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f13a);
            biVar.a(this.f10a);
            this.f16a.execute(biVar);
        }
    }
}
