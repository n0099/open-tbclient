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
/* loaded from: classes6.dex */
public class a {
    private static volatile a a;

    /* renamed from: a  reason: collision with other field name */
    private Context f11a;

    /* renamed from: a  reason: collision with other field name */
    private Config f12a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f13a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f14a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f16a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f15a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    private a(Context context) {
        this.f11a = context;
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
        ai.a(this.f11a).a(runnable, i);
    }

    private void d() {
        if (a(this.f11a).a().isEventUploadSwitchOpen()) {
            ba baVar = new ba(this.f11a);
            int eventUploadFrequency = (int) a(this.f11a).a().getEventUploadFrequency();
            int i = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bh.a(this.f11a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f11a).a(new d(this, baVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f11a).a((ai.a) baVar, i)) {
                    ai.a(this.f11a).m122a(100886);
                    ai.a(this.f11a).a((ai.a) baVar, i);
                }
            }
        }
    }

    private void e() {
        if (a(this.f11a).a().isPerfUploadSwitchOpen()) {
            bb bbVar = new bb(this.f11a);
            int perfUploadFrequency = (int) a(this.f11a).a().getPerfUploadFrequency();
            int i = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bh.a(this.f11a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f11a).a(new e(this, bbVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f11a).a((ai.a) bbVar, i)) {
                    ai.a(this.f11a).m122a(100887);
                    ai.a(this.f11a).a((ai.a) bbVar, i);
                }
            }
        }
    }

    public synchronized Config a() {
        if (this.f12a == null) {
            this.f12a = Config.defaultConfig(this.f11a);
        }
        return this.f12a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m46a() {
        a(this.f11a).d();
        a(this.f11a).e();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f12a = config;
        this.f13a = iEventProcessor;
        this.f14a = iPerfProcessor;
        this.f13a.setEventMap(this.b);
        this.f14a.setPerfMap(this.f15a);
    }

    public void a(EventClientReport eventClientReport) {
        if (a().isEventUploadSwitchOpen()) {
            this.f16a.execute(new az(this.f11a, eventClientReport, this.f13a));
            a(new b(this), 30);
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (a().isPerfUploadSwitchOpen()) {
            this.f16a.execute(new az(this.f11a, perfClientReport, this.f14a));
            a(new c(this), 30);
        }
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        if (this.f12a != null) {
            if (z == this.f12a.isEventUploadSwitchOpen() && z2 == this.f12a.isPerfUploadSwitchOpen() && j == this.f12a.getEventUploadFrequency() && j2 == this.f12a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f12a.getEventUploadFrequency();
            long perfUploadFrequency = this.f12a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(be.a(this.f11a)).setEventEncrypted(this.f12a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f11a);
            this.f12a = build;
            if (!this.f12a.isEventUploadSwitchOpen()) {
                ai.a(this.f11a).m122a(100886);
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f11a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                d();
            }
            if (!this.f12a.isPerfUploadSwitchOpen()) {
                ai.a(this.f11a).m122a(100887);
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f11a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                e();
            }
        }
    }

    public void b() {
        if (a().isEventUploadSwitchOpen()) {
            bc bcVar = new bc();
            bcVar.a(this.f11a);
            bcVar.a(this.f13a);
            this.f16a.execute(bcVar);
        }
    }

    public void c() {
        if (a().isPerfUploadSwitchOpen()) {
            bc bcVar = new bc();
            bcVar.a(this.f14a);
            bcVar.a(this.f11a);
            this.f16a.execute(bcVar);
        }
    }
}
