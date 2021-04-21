package d.b.h0.g.a0;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.h0.a.z1.h;
import d.b.h0.g.l.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a extends f {
    public int i;
    public String j;
    public boolean k;
    public ArrayList<d.b.h0.g.a0.h.b> l;
    public List<String> m;
    public List<String> n;

    /* renamed from: d.b.h0.g.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0979a implements d.b.h0.g.a0.h.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f48575a;

        public C0979a(d.b.h0.g.e.d.c cVar) {
            this.f48575a = cVar;
        }

        @Override // d.b.h0.g.a0.h.c
        public void a(d.b.h0.g.a0.h.d dVar, String str) {
            a.this.E(this.f48575a, str);
        }
    }

    public a(d.b.h0.g.i.b bVar) {
        super(bVar);
        this.k = false;
        this.l = new ArrayList<>();
        this.m = new ArrayList(3);
        this.n = new ArrayList(3);
    }

    public final void E(d.b.h0.g.e.d.c cVar, String str) {
        if (f.f48577h) {
            Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
        }
        d.b.h0.g.i0.b.a(cVar, false, new b(str));
    }

    @NonNull
    public final String F(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            d.b.h0.p.d.g(n.K(remove));
            if (f.f48577h) {
                Log.d("GameRecorderApi", "deleteFile: " + remove);
            }
        }
        String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
        list.add(format);
        return format;
    }

    public final void G() {
        if (f.f48577h) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.i + "," + this.j);
        }
        this.l.clear();
        this.k = false;
        g.a().b().t(this.i, this.j);
    }

    public final boolean H(double[] dArr) {
        if (dArr == null || dArr.length < 2) {
            return false;
        }
        long j = (long) (dArr[0] * 1000.0d);
        long j2 = (long) (dArr[1] * 1000.0d);
        return j >= 0 && j2 >= 0 && j + j2 > 0;
    }

    public final boolean I(GameRecorderController.RecorderState... recorderStateArr) {
        GameRecorderController.RecorderState l = g.a().b().l();
        if (f.f48577h) {
            Log.d("GameRecorderApi", "RecorderState:" + l);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (l == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public final d.b.h0.g.e.d.c J(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        return F == null ? new d.b.h0.g.e.d.c() : F;
    }

    public final void K(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        d.b.h0.g.e.d.c J = J(jsObject);
        String B = J.B("path");
        if (f.f48577h) {
            Log.d("GameRecorderApi", "clipPath:" + B + "，hasExecutedClip：" + this.k);
        }
        if (this.k) {
            return;
        }
        if (I(GameRecorderController.RecorderState.STOP)) {
            E(J, "clipVideo can only called after onStop");
        } else if (this.l.isEmpty()) {
            E(J, "range is illegal");
        } else {
            new d.b.h0.g.a0.h.e(this.l, n.y(B), n.K(F("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.n, 3))).c(new C0979a(J));
            this.l.clear();
            this.k = true;
            d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
            eVar.f47973b = "clipVideo";
            h.j(eVar);
        }
    }

    @JavascriptInterface
    public void pause() {
        if (f.f48577h) {
            Log.d("GameRecorderApi", "pause");
        }
        if (I(GameRecorderController.RecorderState.RECORDING)) {
            return;
        }
        g.a().b().o();
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        d.b.h0.g.e.d.c J = J(jsObject);
        if (I(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            return;
        }
        double[] p = J.p("timeRange");
        K(jsObject);
        if (!H(p)) {
            p = new double[]{3.0d, 3.0d};
        }
        d.b.h0.g.a0.h.b b2 = d.b.h0.g.a0.h.b.b(g.a().b().k(), p[0], p[1]);
        if (f.f48577h) {
            Log.d("GameRecorderApi", "recordClip:" + b2.toString());
        }
        this.l.add(b2);
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47973b = "recordClip";
        h.j(eVar);
    }

    @JavascriptInterface
    public void resume() {
        if (f.f48577h) {
            Log.d("GameRecorderApi", "resume");
        }
        if (I(GameRecorderController.RecorderState.PAUSE) || g.a().c()) {
            return;
        }
        g.a().b().q();
    }

    @JavascriptInterface
    public void start() {
        start(null);
    }

    @JavascriptInterface
    public void stop() {
        if (f.f48577h) {
            Log.d("GameRecorderApi", IntentConfig.STOP);
        }
        if (I(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            return;
        }
        g.a().b().u();
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        if (f.f48577h) {
            Log.d("GameRecorderApi", IntentConfig.START);
        }
        if (I(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || g.a().c()) {
            return;
        }
        d.b.h0.g.e.d.c J = J(jsObject);
        int s = J.s("duration", 10);
        this.i = s;
        if (s <= 0) {
            this.i = 10;
        }
        if (this.i > 120) {
            this.i = 120;
        }
        if (this.m.size() == 0) {
            d.b.h0.p.d.g(n.K("bdfile://tmp/SwanVideoRecorder/"));
        }
        String F = F("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.m, 3);
        C(F);
        String K = n.K(F);
        this.j = K;
        if (K == null) {
            if (f.f48577h) {
                Log.e("GameRecorderApi", "recordPath == null.");
                return;
            }
            return;
        }
        if (J.n("microphoneEnabled", false)) {
            B(2);
        }
        G();
        d.b.h0.g.b0.b.a.l();
    }
}
