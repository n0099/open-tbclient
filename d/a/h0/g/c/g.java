package d.a.h0.g.c;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.audio.AudioPlayer;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.k;
import d.a.h0.g.c.j.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends EventTargetImpl implements d.a.h0.g.c.a, d.a.h0.g.c.b {
    @V8JavascriptField
    public boolean autoplay;
    @V8JavascriptField
    public int buffered;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;

    /* renamed from: e  reason: collision with root package name */
    public AudioPlayer f46134e;

    /* renamed from: f  reason: collision with root package name */
    public String f46135f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.i.b f46136g;
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
        public final /* synthetic */ boolean f46137e;

        public a(boolean z) {
            this.f46137e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f46137e || g.this.f46134e.I()) {
                g.this.f46134e.N(d.a.h0.g.c.f.c(g.this));
                g gVar = g.this;
                if (gVar.autoplay) {
                    gVar.f46134e.Q();
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
            g.this.f46134e.Q();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f46134e.O();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f46141e;

        public d(float f2) {
            this.f46141e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f46134e.U(this.f46141e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f46134e.Y();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f46134e.T();
        }
    }

    /* renamed from: d.a.h0.g.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0924g implements a.b {

        /* renamed from: d.a.h0.g.c.g$g$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46146e;

            public a(String str) {
                this.f46146e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.src = d.a.h0.a.z0.f.V().I().g(this.f46146e);
                if (k.f43101a) {
                    Log.d("Aigame AudioContext", "prepare path: " + g.this.src + " autoPlay: " + g.this.autoplay + " class: " + toString());
                }
                g.this.H(true);
            }
        }

        public C0924g() {
        }

        @Override // d.a.h0.g.c.j.a.b
        public void a(String str) {
            g.this.f46136g.runOnJSThread(new a(str));
        }

        @Override // d.a.h0.g.c.j.a.b
        public void b() {
        }
    }

    public g(d.a.h0.g.i.b bVar) {
        super(bVar);
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.f46136g = bVar;
        D();
    }

    public static AudioPlayer F(String str) {
        return new AudioPlayer(str);
    }

    public final void D() {
        String valueOf = String.valueOf(d.a.h0.g.c.c.a());
        this.f46135f = valueOf;
        this.f46134e = F(valueOf);
        G();
    }

    public int E() {
        AudioPlayer audioPlayer = this.f46134e;
        if (audioPlayer != null) {
            return audioPlayer.y();
        }
        return 0;
    }

    public final void G() {
        if (this.f46134e != null) {
            d.a.h0.g.c.e eVar = new d.a.h0.g.c.e(this, d.a.h0.g.c.f.i());
            eVar.e(this);
            this.f46134e.V(eVar);
        }
    }

    public final void H(boolean z) {
        if (this.f46134e == null) {
            return;
        }
        d.a.h0.g.c.j.b.h().e().post(new a(z));
    }

    public final void I(d.a.h0.g.c.d dVar) {
        this.f46134e.Z(dVar);
    }

    @Override // d.a.h0.g.c.a
    @JavascriptInterface
    public void destroy() {
        if (this.f46134e != null) {
            d.a.h0.g.c.j.b.h().e().post(new f());
        }
    }

    @Override // d.a.h0.g.c.a
    public int getDuration() {
        AudioPlayer audioPlayer = this.f46134e;
        if (audioPlayer != null) {
            return (int) audioPlayer.A();
        }
        return 0;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (k.f43101a) {
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
            I(d.a.h0.g.c.f.c(this));
        } else if (c2 == 2) {
            if (d.a.h0.g.c.f.b(this.volume)) {
                I(d.a.h0.g.c.f.c(this));
            } else {
                this.volume = this.f46134e.D();
            }
        } else if (c2 != 3) {
            if (c2 == 4 && this.autoplay) {
                play();
            }
        } else {
            H(false);
        }
    }

    @Override // d.a.h0.g.c.a
    @JavascriptInterface
    public void pause() {
        if (this.f46134e != null) {
            d.a.h0.g.c.j.b.h().e().post(new c());
        }
    }

    @Override // d.a.h0.g.c.a
    @JavascriptInterface
    public void play() {
        if (this.f46134e != null) {
            d.a.h0.g.c.j.b.h().e().post(new b());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.h0.g.c.b
    public void r(String str, JSONObject jSONObject) {
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
                    this.currentTime = y() / 1000.0d;
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

    @Override // d.a.h0.g.c.a
    @JavascriptInterface
    public void seek(float f2) {
        if (this.f46134e != null) {
            d.a.h0.g.c.j.b.h().e().post(new d(f2));
        }
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        d.a.h0.g.c.j.b.h().m(jsArrayBuffer, new C0924g());
    }

    @Override // d.a.h0.g.c.a
    @JavascriptInterface
    public void stop() {
        if (this.f46134e != null) {
            d.a.h0.g.c.j.b.h().e().post(new e());
        }
    }

    @Override // d.a.h0.g.c.a
    public int y() {
        AudioPlayer audioPlayer = this.f46134e;
        if (audioPlayer != null) {
            return audioPlayer.z();
        }
        return 0;
    }
}
