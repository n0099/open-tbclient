package d.a.m0.a.y0.k.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.e0.d;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.k;
import d.a.m0.a.r1.h;
import d.a.m0.a.v2.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49669e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Long> f49670a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f49671b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f49672c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49673d = false;

    /* renamed from: d.a.m0.a.y0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0978a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f49674e;

        public RunnableC0978a(b.a aVar) {
            this.f49674e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j(this.f49674e);
        }
    }

    public final void b() {
        this.f49670a.clear();
        this.f49671b.clear();
    }

    public synchronized void c() {
        this.f49673d = true;
    }

    public synchronized boolean d(@NonNull String str) {
        return this.f49670a.containsKey(str);
    }

    public synchronized boolean e(@NonNull String str) {
        return this.f49671b.containsKey(str);
    }

    public synchronized boolean f() {
        return this.f49673d;
    }

    public synchronized void g(String str, String str2) {
        if (!this.f49673d) {
            this.f49671b.put(str, str2);
        }
    }

    public synchronized void h(@NonNull String str) {
        if (f49669e) {
            Log.i("VideoStaticRecorder", "inline video record: action " + str);
        }
        if (!this.f49673d && !this.f49670a.containsKey(str)) {
            this.f49670a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized void i(@NonNull String str, long j) {
        if (f49669e) {
            Log.i("VideoStaticRecorder", "inline video record: action " + str);
        }
        if (!this.f49670a.containsKey(str)) {
            this.f49670a.put(str, Long.valueOf(j));
        }
    }

    public final synchronized void j(b.a aVar) {
        if (this.f49672c) {
            return;
        }
        this.f49672c = true;
        boolean equals = TextUtils.equals("1", this.f49671b.get("autoPlay"));
        boolean equals2 = TextUtils.equals("1", this.f49671b.get("playMethod"));
        if (f49669e) {
            Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
        }
        if (!equals && !equals2) {
            b();
            return;
        }
        h.r("video");
        HybridUbcFlow p = h.p("video");
        for (Map.Entry<String, Long> entry : this.f49670a.entrySet()) {
            d.g("VideoStaticRecorder", "submit: event key: " + entry.getKey() + " value " + entry.getValue());
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(entry.getKey());
            ubcFlowEvent.h(entry.getValue().longValue());
            p.C(ubcFlowEvent);
        }
        for (Map.Entry<String, String> entry2 : this.f49671b.entrySet()) {
            d.g("VideoStaticRecorder", "submit: ext key: " + entry2.getKey() + " value " + entry2.getValue());
            p.A(entry2.getKey(), entry2.getValue());
        }
        String g2 = p.g("fmpArrived");
        if (TextUtils.isEmpty(g2)) {
            g2 = "0";
        }
        p.A("fmpArrived", g2);
        long l = aVar.l("launch_time", 0L);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_start");
        ubcFlowEvent2.h(l);
        p.C(ubcFlowEvent2);
        p.A("launchID", aVar.V());
        p.A("scheme", aVar.W());
        p.A("appid", aVar.H());
        p.A("page", aVar.e0());
        long j = aVar.r0().getLong("click_time", 0L);
        if (j > 0) {
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("user_action");
            ubcFlowEvent3.h(j);
            p.C(ubcFlowEvent3);
        }
        p.x();
        b();
    }

    public void k() {
        q.j(new RunnableC0978a(d.a.m0.a.a2.d.g().r().L()), "VideoStaticRecorder");
    }
}
