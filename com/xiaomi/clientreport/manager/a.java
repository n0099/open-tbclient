package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ai;
import com.xiaomi.push.az;
import com.xiaomi.push.ba;
import com.xiaomi.push.bb;
import com.xiaomi.push.bc;
import com.xiaomi.push.be;
import com.xiaomi.push.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class a {
    private static volatile a a;

    /* renamed from: a  reason: collision with other field name */
    private Context f13a;

    /* renamed from: a  reason: collision with other field name */
    private Config f14a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f15a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f16a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f18a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f17a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    private a(Context context) {
        this.f13a = context;
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private void a(Runnable runnable, int i) {
        ai.a(this.f13a).a(runnable, i);
    }

    private void d() {
        if (a(this.f13a).a().isEventUploadSwitchOpen()) {
            ba baVar = new ba(this.f13a);
            int eventUploadFrequency = (int) a(this.f13a).a().getEventUploadFrequency();
            int i = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bh.a(this.f13a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f13a).a(new d(this, baVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f13a).a((ai.a) baVar, i)) {
                    ai.a(this.f13a).m113a(100886);
                    ai.a(this.f13a).a((ai.a) baVar, i);
                }
            }
        }
    }

    private void e() {
        if (a(this.f13a).a().isPerfUploadSwitchOpen()) {
            bb bbVar = new bb(this.f13a);
            int perfUploadFrequency = (int) a(this.f13a).a().getPerfUploadFrequency();
            int i = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bh.a(this.f13a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f13a).a(new e(this, bbVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f13a).a((ai.a) bbVar, i)) {
                    ai.a(this.f13a).m113a(100887);
                    ai.a(this.f13a).a((ai.a) bbVar, i);
                }
            }
        }
    }

    public synchronized Config a() {
        if (this.f14a == null) {
            this.f14a = Config.defaultConfig(this.f13a);
        }
        return this.f14a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m37a() {
        a(this.f13a).d();
        a(this.f13a).e();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f14a = config;
        this.f15a = iEventProcessor;
        this.f16a = iPerfProcessor;
        this.f15a.setEventMap(this.b);
        this.f16a.setPerfMap(this.f17a);
    }

    public void a(EventClientReport eventClientReport) {
        if (a().isEventUploadSwitchOpen()) {
            this.f18a.execute(new az(this.f13a, eventClientReport, this.f15a));
            a(new b(this), 30);
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (a().isPerfUploadSwitchOpen()) {
            this.f18a.execute(new az(this.f13a, perfClientReport, this.f16a));
            a(new c(this), 30);
        }
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        if (this.f14a != null) {
            if (z == this.f14a.isEventUploadSwitchOpen() && z2 == this.f14a.isPerfUploadSwitchOpen() && j == this.f14a.getEventUploadFrequency() && j2 == this.f14a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f14a.getEventUploadFrequency();
            long perfUploadFrequency = this.f14a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(be.a(this.f13a)).setEventEncrypted(this.f14a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f13a);
            this.f14a = build;
            if (!this.f14a.isEventUploadSwitchOpen()) {
                ai.a(this.f13a).m113a(100886);
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f13a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                d();
            }
            if (!this.f14a.isPerfUploadSwitchOpen()) {
                ai.a(this.f13a).m113a(100887);
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f13a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                e();
            }
        }
    }

    public void b() {
        if (a().isEventUploadSwitchOpen()) {
            bc bcVar = new bc();
            bcVar.a(this.f13a);
            bcVar.a(this.f15a);
            this.f18a.execute(bcVar);
        }
    }

    public void c() {
        if (a().isPerfUploadSwitchOpen()) {
            bc bcVar = new bc();
            bcVar.a(this.f16a);
            bcVar.a(this.f13a);
            this.f18a.execute(bcVar);
        }
    }
}
