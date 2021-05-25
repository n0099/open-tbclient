package d.a.l0.h.c;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.audio.AudioPlayer;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.k;
import d.a.l0.h.c.j.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends EventTargetImpl implements d.a.l0.h.c.a, d.a.l0.h.c.b {
    @V8JavascriptField
    public boolean autoplay;
    @V8JavascriptField
    public int buffered;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;

    /* renamed from: e  reason: collision with root package name */
    public AudioPlayer f47188e;

    /* renamed from: f  reason: collision with root package name */
    public String f47189f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.l0.c f47190g;
    @V8JavascriptField
    public boolean loop;
    @V8JavascriptField
    public boolean obeyMuteSwitch;
    @V8JavascriptField
    public boolean paused;
    @V8JavascriptField
    public String src;
    @V8JavascriptField
    public float startTime;
    @V8JavascriptField
    public float volume;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47191e;

        public a(boolean z) {
            this.f47191e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f47191e || g.this.f47188e.I()) {
                g.this.f47188e.N(d.a.l0.h.c.f.c(g.this));
                g gVar = g.this;
                if (gVar.autoplay) {
                    gVar.f47188e.Q();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f47188e.Q();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f47188e.O();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f47195e;

        public d(float f2) {
            this.f47195e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f47188e.U(this.f47195e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f47188e.Y();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f47188e.T();
        }
    }

    /* renamed from: d.a.l0.h.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1012g implements a.b {

        /* renamed from: d.a.l0.h.c.g$g$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47200e;

            public a(String str) {
                this.f47200e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.src = d.a.l0.a.g1.f.V().I().g(this.f47200e);
                if (k.f43199a) {
                    Log.d("Aigame AudioContext", "prepare path: " + g.this.src + " autoPlay: " + g.this.autoplay + " class: " + toString());
                }
                g.this.G(true);
            }
        }

        public C1012g() {
        }

        @Override // d.a.l0.h.c.j.a.b
        public void a(String str) {
            g.this.f47190g.runOnJSThread(new a(str));
        }

        @Override // d.a.l0.h.c.j.a.b
        public void b() {
        }
    }

    public g(d.a.l0.a.l0.c cVar) {
        super(cVar);
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.f47190g = cVar;
        C();
    }

    public static AudioPlayer E(String str) {
        return new AudioPlayer(str);
    }

    public final void C() {
        String valueOf = String.valueOf(d.a.l0.h.c.c.a());
        this.f47189f = valueOf;
        this.f47188e = E(valueOf);
        F();
    }

    public int D() {
        AudioPlayer audioPlayer = this.f47188e;
        if (audioPlayer != null) {
            return audioPlayer.y();
        }
        return 0;
    }

    public final void F() {
        if (this.f47188e != null) {
            d.a.l0.h.c.e eVar = new d.a.l0.h.c.e(this, d.a.l0.h.c.f.i());
            eVar.e(this);
            this.f47188e.V(eVar);
        }
    }

    public final void G(boolean z) {
        if (this.f47188e == null) {
            return;
        }
        d.a.l0.h.c.j.b.h().e().post(new a(z));
    }

    public final void H(d.a.l0.h.c.d dVar) {
        this.f47188e.Z(dVar);
    }

    @Override // d.a.l0.h.c.a
    @JavascriptInterface
    public void destroy() {
        if (this.f47188e != null) {
            d.a.l0.h.c.j.b.h().e().post(new f());
        }
    }

    @Override // d.a.l0.h.c.a
    public int getDuration() {
        AudioPlayer audioPlayer = this.f47188e;
        if (audioPlayer != null) {
            return (int) audioPlayer.A();
        }
        return 0;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (k.f43199a) {
            Log.d("Aigame AudioContext", str);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2129294769:
                if (str.equals("startTime")) {
                    c2 = 1;
                    break;
                }
                break;
            case -810883302:
                if (str.equals("volume")) {
                    c2 = 2;
                    break;
                }
                break;
            case 114148:
                if (str.equals(UserAccountActionItem.KEY_SRC)) {
                    c2 = 3;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1) {
            H(d.a.l0.h.c.f.c(this));
        } else if (c2 == 2) {
            if (d.a.l0.h.c.f.b(this.volume)) {
                H(d.a.l0.h.c.f.c(this));
            } else {
                this.volume = this.f47188e.D();
            }
        } else if (c2 != 3) {
            if (c2 == 4 && this.autoplay) {
                play();
            }
        } else {
            G(false);
        }
    }

    @Override // d.a.l0.h.c.a
    @JavascriptInterface
    public void pause() {
        if (this.f47188e != null) {
            d.a.l0.h.c.j.b.h().e().post(new c());
        }
    }

    @Override // d.a.l0.h.c.a
    @JavascriptInterface
    public void play() {
        if (this.f47188e != null) {
            d.a.l0.h.c.j.b.h().e().post(new b());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.l0.h.c.b
    public void q(String str, JSONObject jSONObject) {
        char c2;
        switch (str.hashCode()) {
            case -1522036513:
                if (str.equals("buffered")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3443508:
                if (str.equals("play")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3540994:
                if (str.equals(IntentConfig.STOP)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 96651962:
                if (str.equals("ended")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 96784904:
                if (str.equals("error")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 550609668:
                if (str.equals("canplay")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1762557398:
                if (str.equals("timeupdate")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                this.buffered = D();
                return;
            case 1:
                if (jSONObject != null) {
                    this.duration = getDuration() / 1000;
                    this.currentTime = x() / 1000.0d;
                    return;
                }
                return;
            case 2:
                this.paused = false;
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.paused = true;
                return;
            case 7:
                this.duration = getDuration() / 1000;
                return;
            default:
                return;
        }
    }

    @Override // d.a.l0.h.c.a
    @JavascriptInterface
    public void seek(float f2) {
        if (this.f47188e != null) {
            d.a.l0.h.c.j.b.h().e().post(new d(f2));
        }
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        d.a.l0.h.c.j.b.h().m(jsArrayBuffer, new C1012g());
    }

    @Override // d.a.l0.h.c.a
    @JavascriptInterface
    public void stop() {
        if (this.f47188e != null) {
            d.a.l0.h.c.j.b.h().e().post(new e());
        }
    }

    @Override // d.a.l0.h.c.a
    public int x() {
        AudioPlayer audioPlayer = this.f47188e;
        if (audioPlayer != null) {
            return audioPlayer.z();
        }
        return 0;
    }
}
