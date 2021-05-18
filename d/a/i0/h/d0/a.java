package d.a.i0.h.d0;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.i0.a.j2.k;
import d.a.i0.a.r0.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: i  reason: collision with root package name */
    public int f47104i;
    public String j;
    public boolean k;
    public ArrayList<d.a.i0.h.d0.h.b> l;
    public List<String> m;
    public List<String> n;

    /* renamed from: d.a.i0.h.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1008a implements d.a.i0.h.d0.h.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47105a;

        public C1008a(d.a.i0.a.y.b.a aVar) {
            this.f47105a = aVar;
        }

        @Override // d.a.i0.h.d0.h.c
        public void a(d.a.i0.h.d0.h.d dVar, String str) {
            a.this.D(this.f47105a, str);
        }
    }

    public a(d.a.i0.a.l0.c cVar) {
        super(cVar);
        this.k = false;
        this.l = new ArrayList<>();
        this.m = new ArrayList(3);
        this.n = new ArrayList(3);
    }

    public final void D(d.a.i0.a.y.b.a aVar, String str) {
        if (f.f47107h) {
            Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
        }
        d.a.i0.h.m0.c.a(aVar, false, new b(str));
    }

    @NonNull
    public final String E(String str, @NonNull List<String> list, int i2) {
        if (list.size() >= i2) {
            String remove = list.remove(0);
            d.a.i0.t.d.j(n.K(remove));
            if (f.f47107h) {
                Log.d("GameRecorderApi", "deleteFile: " + remove);
            }
        }
        String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
        list.add(format);
        return format;
    }

    public final void F() {
        if (f.f47107h) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.f47104i + "," + this.j);
        }
        this.l.clear();
        this.k = false;
        g.a().b().t(this.f47104i, this.j);
    }

    public final boolean G(double[] dArr) {
        if (dArr == null || dArr.length < 2) {
            return false;
        }
        long j = (long) (dArr[0] * 1000.0d);
        long j2 = (long) (dArr[1] * 1000.0d);
        return j >= 0 && j2 >= 0 && j + j2 > 0;
    }

    public final boolean H(GameRecorderController.RecorderState... recorderStateArr) {
        GameRecorderController.RecorderState l = g.a().b().l();
        if (f.f47107h) {
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
    public final d.a.i0.a.y.b.a I(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        return G == null ? new d.a.i0.a.y.b.a() : G;
    }

    public final void J(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        d.a.i0.a.y.b.a I = I(jsObject);
        String C = I.C("path");
        if (f.f47107h) {
            Log.d("GameRecorderApi", "clipPath:" + C + "，hasExecutedClip：" + this.k);
        }
        if (this.k) {
            return;
        }
        if (H(GameRecorderController.RecorderState.STOP)) {
            D(I, "clipVideo can only called after onStop");
        } else if (this.l.isEmpty()) {
            D(I, "range is illegal");
        } else {
            new d.a.i0.h.d0.h.e(this.l, n.y(C), n.K(E("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.n, 3))).c(new C1008a(I));
            this.l.clear();
            this.k = true;
            d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
            eVar.f43012b = "clipVideo";
            k.h(eVar);
        }
    }

    @JavascriptInterface
    public void pause() {
        if (f.f47107h) {
            Log.d("GameRecorderApi", "pause");
        }
        if (H(GameRecorderController.RecorderState.RECORDING)) {
            return;
        }
        g.a().b().o();
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        d.a.i0.a.y.b.a I = I(jsObject);
        if (H(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            return;
        }
        double[] p = I.p("timeRange");
        J(jsObject);
        if (!G(p)) {
            p = new double[]{3.0d, 3.0d};
        }
        d.a.i0.h.d0.h.b b2 = d.a.i0.h.d0.h.b.b(g.a().b().k(), p[0], p[1]);
        if (f.f47107h) {
            Log.d("GameRecorderApi", "recordClip:" + b2.toString());
        }
        this.l.add(b2);
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43012b = "recordClip";
        k.h(eVar);
    }

    @JavascriptInterface
    public void resume() {
        if (f.f47107h) {
            Log.d("GameRecorderApi", "resume");
        }
        if (H(GameRecorderController.RecorderState.PAUSE) || g.a().c()) {
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
        if (f.f47107h) {
            Log.d("GameRecorderApi", IntentConfig.STOP);
        }
        if (H(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            return;
        }
        g.a().b().u();
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        if (f.f47107h) {
            Log.d("GameRecorderApi", IntentConfig.START);
        }
        if (H(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || g.a().c()) {
            return;
        }
        d.a.i0.a.y.b.a I = I(jsObject);
        int s = I.s("duration", 10);
        this.f47104i = s;
        if (s <= 0) {
            this.f47104i = 10;
        }
        if (this.f47104i > 120) {
            this.f47104i = 120;
        }
        if (this.m.size() == 0) {
            d.a.i0.t.d.j(n.K("bdfile://tmp/SwanVideoRecorder/"));
        }
        String E = E("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.m, 3);
        B(E);
        String K = n.K(E);
        this.j = K;
        if (K == null) {
            if (f.f47107h) {
                Log.e("GameRecorderApi", "recordPath == null.");
                return;
            }
            return;
        }
        if (I.n("microphoneEnabled", false)) {
            A(2);
        }
        F();
        d.a.i0.h.e0.b.a.l();
    }
}
