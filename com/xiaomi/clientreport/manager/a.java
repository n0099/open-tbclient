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
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4718a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile a f8a;

    /* renamed from: a  reason: collision with other field name */
    private Context f9a;

    /* renamed from: a  reason: collision with other field name */
    private Config f10a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f11a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f12a;

    /* renamed from: a  reason: collision with other field name */
    private String f13a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f15a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f14a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        f4718a = l.m500a() ? 30 : 10;
    }

    private a(Context context) {
        this.f9a = context;
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
        if (f8a == null) {
            synchronized (a.class) {
                if (f8a == null) {
                    f8a = new a(context);
                }
            }
        }
        return f8a;
    }

    private void a(ai.a aVar, int i) {
        ai.a(this.f9a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        int i;
        int i2 = 0;
        if (this.f14a == null) {
            return 0;
        }
        Iterator<String> it = this.f14a.keySet().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3;
            }
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f14a.get(it.next());
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
        if (this.f11a != null) {
            this.f11a.mo61a(eventClientReport);
            if (a() < 10) {
                a(new d(this), f4718a);
                return;
            }
            d();
            ai.a(this.f9a).m128a(100888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        if (this.f12a != null) {
            this.f12a.mo61a(perfClientReport);
            if (b() < 10) {
                a(new f(this), f4718a);
                return;
            }
            e();
            ai.a(this.f9a).m128a(100889);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f11a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f12a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f9a).m58a().isEventUploadSwitchOpen()) {
            bg bgVar = new bg(this.f9a);
            int eventUploadFrequency = (int) a(this.f9a).m58a().getEventUploadFrequency();
            int i = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f9a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f9a).a(new h(this, bgVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f9a).a((ai.a) bgVar, i)) {
                    ai.a(this.f9a).m128a(100886);
                    ai.a(this.f9a).a((ai.a) bgVar, i);
                }
            }
        }
    }

    private void g() {
        if (a(this.f9a).m58a().isPerfUploadSwitchOpen()) {
            bh bhVar = new bh(this.f9a);
            int perfUploadFrequency = (int) a(this.f9a).m58a().getPerfUploadFrequency();
            int i = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f9a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f9a).a(new i(this, bhVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f9a).a((ai.a) bhVar, i)) {
                    ai.a(this.f9a).m128a(100887);
                    ai.a(this.f9a).a((ai.a) bhVar, i);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m58a() {
        if (this.f10a == null) {
            this.f10a = Config.defaultConfig(this.f9a);
        }
        return this.f10a;
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
        eventClientReport.setAppPackageName(this.f9a.getPackageName());
        eventClientReport.setSdkVersion(this.f13a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m59a() {
        a(this.f9a).f();
        a(this.f9a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f10a = config;
        this.f11a = iEventProcessor;
        this.f12a = iPerfProcessor;
        this.f11a.setEventMap(this.b);
        this.f12a.setPerfMap(this.f14a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m58a().isEventUploadSwitchOpen()) {
            this.f15a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m58a().isPerfUploadSwitchOpen()) {
            this.f15a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f13a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        if (this.f10a != null) {
            if (z == this.f10a.isEventUploadSwitchOpen() && z2 == this.f10a.isPerfUploadSwitchOpen() && j == this.f10a.getEventUploadFrequency() && j2 == this.f10a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f10a.getEventUploadFrequency();
            long perfUploadFrequency = this.f10a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bj.a(this.f9a)).setEventEncrypted(this.f10a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f9a);
            this.f10a = build;
            if (!this.f10a.isEventUploadSwitchOpen()) {
                ai.a(this.f9a).m128a(100886);
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f9a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f10a.isPerfUploadSwitchOpen()) {
                ai.a(this.f9a).m128a(100887);
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f9a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m60b() {
        if (m58a().isEventUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f9a);
            biVar.a(this.f11a);
            this.f15a.execute(biVar);
        }
    }

    public void c() {
        if (m58a().isPerfUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f12a);
            biVar.a(this.f9a);
            this.f15a.execute(biVar);
        }
    }
}
