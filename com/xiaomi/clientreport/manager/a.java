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
    private static volatile a f16a;

    /* renamed from: a  reason: collision with other field name */
    private Context f17a;

    /* renamed from: a  reason: collision with other field name */
    private Config f18a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f19a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f20a;

    /* renamed from: a  reason: collision with other field name */
    private String f21a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f23a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f22a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        a = l.m494a() ? 30 : 10;
    }

    private a(Context context) {
        this.f17a = context;
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
        if (f16a == null) {
            synchronized (a.class) {
                if (f16a == null) {
                    f16a = new a(context);
                }
            }
        }
        return f16a;
    }

    private void a(ai.a aVar, int i) {
        ai.a(this.f17a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        int i;
        int i2 = 0;
        if (this.f22a == null) {
            return 0;
        }
        Iterator<String> it = this.f22a.keySet().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3;
            }
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f22a.get(it.next());
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
        if (this.f19a != null) {
            this.f19a.mo55a(eventClientReport);
            if (a() < 10) {
                a(new d(this), a);
                return;
            }
            d();
            ai.a(this.f17a).m122a(100888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        if (this.f20a != null) {
            this.f20a.mo55a(perfClientReport);
            if (b() < 10) {
                a(new f(this), a);
                return;
            }
            e();
            ai.a(this.f17a).m122a(100889);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f19a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f20a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f17a).m52a().isEventUploadSwitchOpen()) {
            bg bgVar = new bg(this.f17a);
            int eventUploadFrequency = (int) a(this.f17a).m52a().getEventUploadFrequency();
            int i = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f17a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f17a).a(new h(this, bgVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f17a).a((ai.a) bgVar, i)) {
                    ai.a(this.f17a).m122a(100886);
                    ai.a(this.f17a).a((ai.a) bgVar, i);
                }
            }
        }
    }

    private void g() {
        if (a(this.f17a).m52a().isPerfUploadSwitchOpen()) {
            bh bhVar = new bh(this.f17a);
            int perfUploadFrequency = (int) a(this.f17a).m52a().getPerfUploadFrequency();
            int i = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bm.a(this.f17a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f17a).a(new i(this, bhVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f17a).a((ai.a) bhVar, i)) {
                    ai.a(this.f17a).m122a(100887);
                    ai.a(this.f17a).a((ai.a) bhVar, i);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m52a() {
        if (this.f18a == null) {
            this.f18a = Config.defaultConfig(this.f17a);
        }
        return this.f18a;
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
        eventClientReport.setAppPackageName(this.f17a.getPackageName());
        eventClientReport.setSdkVersion(this.f21a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m53a() {
        a(this.f17a).f();
        a(this.f17a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f18a = config;
        this.f19a = iEventProcessor;
        this.f20a = iPerfProcessor;
        this.f19a.setEventMap(this.b);
        this.f20a.setPerfMap(this.f22a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m52a().isEventUploadSwitchOpen()) {
            this.f23a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m52a().isPerfUploadSwitchOpen()) {
            this.f23a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f21a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        if (this.f18a != null) {
            if (z == this.f18a.isEventUploadSwitchOpen() && z2 == this.f18a.isPerfUploadSwitchOpen() && j == this.f18a.getEventUploadFrequency() && j2 == this.f18a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f18a.getEventUploadFrequency();
            long perfUploadFrequency = this.f18a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bj.a(this.f17a)).setEventEncrypted(this.f18a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f17a);
            this.f18a = build;
            if (!this.f18a.isEventUploadSwitchOpen()) {
                ai.a(this.f17a).m122a(100886);
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f17a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f18a.isPerfUploadSwitchOpen()) {
                ai.a(this.f17a).m122a(100887);
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f17a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m54b() {
        if (m52a().isEventUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f17a);
            biVar.a(this.f19a);
            this.f23a.execute(biVar);
        }
    }

    public void c() {
        if (m52a().isPerfUploadSwitchOpen()) {
            bi biVar = new bi();
            biVar.a(this.f20a);
            biVar.a(this.f17a);
            this.f23a.execute(biVar);
        }
    }
}
