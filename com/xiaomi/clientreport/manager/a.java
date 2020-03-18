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
/* loaded from: classes8.dex */
public class a {
    private static volatile a a;

    /* renamed from: a  reason: collision with other field name */
    private Context f8a;

    /* renamed from: a  reason: collision with other field name */
    private Config f9a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f10a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f11a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f13a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f12a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    private a(Context context) {
        this.f8a = context;
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
        ai.a(this.f8a).a(runnable, i);
    }

    private void d() {
        if (a(this.f8a).a().isEventUploadSwitchOpen()) {
            ba baVar = new ba(this.f8a);
            int eventUploadFrequency = (int) a(this.f8a).a().getEventUploadFrequency();
            int i = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - bh.a(this.f8a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f8a).a(new d(this, baVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f8a).a((ai.a) baVar, i)) {
                    ai.a(this.f8a).m125a(100886);
                    ai.a(this.f8a).a((ai.a) baVar, i);
                }
            }
        }
    }

    private void e() {
        if (a(this.f8a).a().isPerfUploadSwitchOpen()) {
            bb bbVar = new bb(this.f8a);
            int perfUploadFrequency = (int) a(this.f8a).a().getPerfUploadFrequency();
            int i = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - bh.a(this.f8a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f8a).a(new e(this, bbVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f8a).a((ai.a) bbVar, i)) {
                    ai.a(this.f8a).m125a(100887);
                    ai.a(this.f8a).a((ai.a) bbVar, i);
                }
            }
        }
    }

    public synchronized Config a() {
        if (this.f9a == null) {
            this.f9a = Config.defaultConfig(this.f8a);
        }
        return this.f9a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m49a() {
        a(this.f8a).d();
        a(this.f8a).e();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f9a = config;
        this.f10a = iEventProcessor;
        this.f11a = iPerfProcessor;
        this.f10a.setEventMap(this.b);
        this.f11a.setPerfMap(this.f12a);
    }

    public void a(EventClientReport eventClientReport) {
        if (a().isEventUploadSwitchOpen()) {
            this.f13a.execute(new az(this.f8a, eventClientReport, this.f10a));
            a(new b(this), 30);
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (a().isPerfUploadSwitchOpen()) {
            this.f13a.execute(new az(this.f8a, perfClientReport, this.f11a));
            a(new c(this), 30);
        }
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        if (this.f9a != null) {
            if (z == this.f9a.isEventUploadSwitchOpen() && z2 == this.f9a.isPerfUploadSwitchOpen() && j == this.f9a.getEventUploadFrequency() && j2 == this.f9a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f9a.getEventUploadFrequency();
            long perfUploadFrequency = this.f9a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(be.a(this.f8a)).setEventEncrypted(this.f9a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f8a);
            this.f9a = build;
            if (!this.f9a.isEventUploadSwitchOpen()) {
                ai.a(this.f8a).m125a(100886);
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f8a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                d();
            }
            if (!this.f9a.isPerfUploadSwitchOpen()) {
                ai.a(this.f8a).m125a(100887);
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f8a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                e();
            }
        }
    }

    public void b() {
        if (a().isEventUploadSwitchOpen()) {
            bc bcVar = new bc();
            bcVar.a(this.f8a);
            bcVar.a(this.f10a);
            this.f13a.execute(bcVar);
        }
    }

    public void c() {
        if (a().isPerfUploadSwitchOpen()) {
            bc bcVar = new bc();
            bcVar.a(this.f11a);
            bcVar.a(this.f8a);
            this.f13a.execute(bcVar);
        }
    }
}
