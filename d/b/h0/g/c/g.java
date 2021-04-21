package d.b.h0.g.c;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.audio.AudioPlayer;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.h0.a.k;
import d.b.h0.g.c.j.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends EventTargetImpl implements d.b.h0.g.c.a, d.b.h0.g.c.b {
    @V8JavascriptField
    public boolean autoplay;
    @V8JavascriptField
    public int buffered;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;

    /* renamed from: e  reason: collision with root package name */
    public AudioPlayer f48668e;

    /* renamed from: f  reason: collision with root package name */
    public String f48669f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.g.i.b f48670g;
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
        public final /* synthetic */ boolean f48671e;

        public a(boolean z) {
            this.f48671e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f48671e || g.this.f48668e.I()) {
                g.this.f48668e.N(d.b.h0.g.c.f.c(g.this));
                g gVar = g.this;
                if (gVar.autoplay) {
                    gVar.f48668e.Q();
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
            g.this.f48668e.Q();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f48668e.O();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f48675e;

        public d(float f2) {
            this.f48675e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f48668e.U(this.f48675e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f48668e.Y();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f48668e.T();
        }
    }

    /* renamed from: d.b.h0.g.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0985g implements a.b {

        /* renamed from: d.b.h0.g.c.g$g$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48680e;

            public a(String str) {
                this.f48680e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.src = d.b.h0.a.z0.f.V().y().b(this.f48680e);
                if (k.f45772a) {
                    Log.d("Aigame AudioContext", "prepare path: " + g.this.src + " autoPlay: " + g.this.autoplay + " class: " + toString());
                }
                g.this.H(true);
            }
        }

        public C0985g() {
        }

        @Override // d.b.h0.g.c.j.a.b
        public void a(String str) {
            g.this.f48670g.runOnJSThread(new a(str));
        }

        @Override // d.b.h0.g.c.j.a.b
        public void b() {
        }
    }

    public g(d.b.h0.g.i.b bVar) {
        super(bVar);
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.f48670g = bVar;
        D();
    }

    public static AudioPlayer F(String str) {
        return new AudioPlayer(str);
    }

    public final void D() {
        String valueOf = String.valueOf(d.b.h0.g.c.c.a());
        this.f48669f = valueOf;
        this.f48668e = F(valueOf);
        G();
    }

    public int E() {
        AudioPlayer audioPlayer = this.f48668e;
        if (audioPlayer != null) {
            return audioPlayer.y();
        }
        return 0;
    }

    public final void G() {
        if (this.f48668e != null) {
            d.b.h0.g.c.e eVar = new d.b.h0.g.c.e(this, d.b.h0.g.c.f.i());
            eVar.e(this);
            this.f48668e.V(eVar);
        }
    }

    public final void H(boolean z) {
        if (this.f48668e == null) {
            return;
        }
        d.b.h0.g.c.j.b.h().e().post(new a(z));
    }

    public final void I(d.b.h0.g.c.d dVar) {
        this.f48668e.Z(dVar);
    }

    @Override // d.b.h0.g.c.a
    @JavascriptInterface
    public void destroy() {
        if (this.f48668e != null) {
            d.b.h0.g.c.j.b.h().e().post(new f());
        }
    }

    @Override // d.b.h0.g.c.a
    public int getDuration() {
        AudioPlayer audioPlayer = this.f48668e;
        if (audioPlayer != null) {
            return (int) audioPlayer.A();
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.b.h0.g.c.b
    public void i(String str, JSONObject jSONObject) {
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
                this.buffered = E();
                return;
            case 1:
                if (jSONObject != null) {
                    this.duration = getDuration() / 1000;
                    this.currentTime = u() / 1000.0d;
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

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (k.f45772a) {
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
            I(d.b.h0.g.c.f.c(this));
        } else if (c2 == 2) {
            if (d.b.h0.g.c.f.b(this.volume)) {
                I(d.b.h0.g.c.f.c(this));
            } else {
                this.volume = this.f48668e.D();
            }
        } else if (c2 != 3) {
            if (c2 == 4 && this.autoplay) {
                play();
            }
        } else {
            H(false);
        }
    }

    @Override // d.b.h0.g.c.a
    @JavascriptInterface
    public void pause() {
        if (this.f48668e != null) {
            d.b.h0.g.c.j.b.h().e().post(new c());
        }
    }

    @Override // d.b.h0.g.c.a
    @JavascriptInterface
    public void play() {
        if (this.f48668e != null) {
            d.b.h0.g.c.j.b.h().e().post(new b());
        }
    }

    @Override // d.b.h0.g.c.a
    @JavascriptInterface
    public void seek(float f2) {
        if (this.f48668e != null) {
            d.b.h0.g.c.j.b.h().e().post(new d(f2));
        }
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        d.b.h0.g.c.j.b.h().m(jsArrayBuffer, new C0985g());
    }

    @Override // d.b.h0.g.c.a
    @JavascriptInterface
    public void stop() {
        if (this.f48668e != null) {
            d.b.h0.g.c.j.b.h().e().post(new e());
        }
    }

    @Override // d.b.h0.g.c.a
    public int u() {
        AudioPlayer audioPlayer = this.f48668e;
        if (audioPlayer != null) {
            return audioPlayer.z();
        }
        return 0;
    }
}
