package d.a.h0.g.a0;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.z1.h;
import d.a.h0.g.l.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: i  reason: collision with root package name */
    public int f46036i;
    public String j;
    public boolean k;
    public ArrayList<d.a.h0.g.a0.h.b> l;
    public List<String> m;
    public List<String> n;

    /* renamed from: d.a.h0.g.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0918a implements d.a.h0.g.a0.h.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46037a;

        public C0918a(d.a.h0.g.e.d.c cVar) {
            this.f46037a = cVar;
        }

        @Override // d.a.h0.g.a0.h.c
        public void a(d.a.h0.g.a0.h.d dVar, String str) {
            a.this.E(this.f46037a, str);
        }
    }

    public a(d.a.h0.g.i.b bVar) {
        super(bVar);
        this.k = false;
        this.l = new ArrayList<>();
        this.m = new ArrayList(3);
        this.n = new ArrayList(3);
    }

    public final void E(d.a.h0.g.e.d.c cVar, String str) {
        if (f.f46039h) {
            Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
        }
        d.a.h0.g.i0.b.a(cVar, false, new b(str));
    }

    @NonNull
    public final String F(String str, @NonNull List<String> list, int i2) {
        if (list.size() >= i2) {
            String remove = list.remove(0);
            d.a.h0.p.d.g(n.K(remove));
            if (f.f46039h) {
                Log.d("GameRecorderApi", "deleteFile: " + remove);
            }
        }
        String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
        list.add(format);
        return format;
    }

    public final void G() {
        if (f.f46039h) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.f46036i + "," + this.j);
        }
        this.l.clear();
        this.k = false;
        g.a().b().t(this.f46036i, this.j);
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
        if (f.f46039h) {
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
    public final d.a.h0.g.e.d.c J(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        return F == null ? new d.a.h0.g.e.d.c() : F;
    }

    public final void K(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        d.a.h0.g.e.d.c J = J(jsObject);
        String B = J.B("path");
        if (f.f46039h) {
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
            new d.a.h0.g.a0.h.e(this.l, n.y(B), n.K(F("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.n, 3))).c(new C0918a(J));
            this.l.clear();
            this.k = true;
            d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
            eVar.f45412b = "clipVideo";
            h.j(eVar);
        }
    }

    @JavascriptInterface
    public void pause() {
        if (f.f46039h) {
            Log.d("GameRecorderApi", "pause");
        }
        if (I(GameRecorderController.RecorderState.RECORDING)) {
            return;
        }
        g.a().b().o();
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        d.a.h0.g.e.d.c J = J(jsObject);
        if (I(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            return;
        }
        double[] p = J.p("timeRange");
        K(jsObject);
        if (!H(p)) {
            p = new double[]{3.0d, 3.0d};
        }
        d.a.h0.g.a0.h.b b2 = d.a.h0.g.a0.h.b.b(g.a().b().k(), p[0], p[1]);
        if (f.f46039h) {
            Log.d("GameRecorderApi", "recordClip:" + b2.toString());
        }
        this.l.add(b2);
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = "recordClip";
        h.j(eVar);
    }

    @JavascriptInterface
    public void resume() {
        if (f.f46039h) {
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
        if (f.f46039h) {
            Log.d("GameRecorderApi", IntentConfig.STOP);
        }
        if (I(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            return;
        }
        g.a().b().u();
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        if (f.f46039h) {
            Log.d("GameRecorderApi", IntentConfig.START);
        }
        if (I(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || g.a().c()) {
            return;
        }
        d.a.h0.g.e.d.c J = J(jsObject);
        int s = J.s("duration", 10);
        this.f46036i = s;
        if (s <= 0) {
            this.f46036i = 10;
        }
        if (this.f46036i > 120) {
            this.f46036i = 120;
        }
        if (this.m.size() == 0) {
            d.a.h0.p.d.g(n.K("bdfile://tmp/SwanVideoRecorder/"));
        }
        String F = F("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.m, 3);
        C(F);
        String K = n.K(F);
        this.j = K;
        if (K == null) {
            if (f.f46039h) {
                Log.e("GameRecorderApi", "recordPath == null.");
                return;
            }
            return;
        }
        if (J.n("microphoneEnabled", false)) {
            B(2);
        }
        G();
        d.a.h0.g.b0.b.a.l();
    }
}
