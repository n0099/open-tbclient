package d.a.l0.a.i1.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.SwanAppAudioClient;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.router.RouterCallback;
import d.a.l0.a.a2.e;
import d.a.l0.a.e0.d;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.a.p.b.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f46404i = k.f46875a;
    public static d.a.l0.a.j2.a j;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f46405a;

    /* renamed from: b  reason: collision with root package name */
    public Context f46406b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.i1.c.e.a f46408d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46411g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.g1.a f46412h;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.i1.c.a f46407c = new d.a.l0.a.i1.c.a();

    /* renamed from: e  reason: collision with root package name */
    public int f46409e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f46410f = 0;

    /* loaded from: classes3.dex */
    public class a extends d.a.l0.a.g1.a {
        public a() {
        }

        @Override // d.a.l0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            c.this.f46411g = false;
            if (c.this.x()) {
                return;
            }
            c.this.p();
        }

        @Override // d.a.l0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            c.this.f46411g = true;
            if (c.this.w()) {
                if (c.this.x()) {
                    d.a.l0.a.j2.a unused = c.j = null;
                    return;
                } else if (c.j == null) {
                    d.a.l0.a.j2.a unused2 = c.j = d.a.l0.a.j2.k.c("1044");
                    return;
                } else {
                    return;
                }
            }
            super.onActivityStopped(activity);
            c.this.J();
            d.l("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<String> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.this.v().v(c.this.f46407c.c(str), str);
        }
    }

    /* renamed from: d.a.l0.a.i1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0760c implements SwanAppAudioClient.c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f46415a;

        public C0760c() {
        }

        @Override // com.baidu.swan.apps.media.audio.SwanAppAudioClient.c
        public boolean a(Message message) {
            int i2 = message.what;
            int i3 = message.arg1;
            int i4 = message.arg2;
            JSONObject jSONObject = new JSONObject();
            c.this.H(message, i4, c.this.u() / 1000);
            switch (i2) {
                case 1001:
                    d.g("backgroundAudio", "event onCanPlay");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a("onCanplay");
                    }
                    this.f46415a = true;
                    return true;
                case 1002:
                    d.g("backgroundAudio", "event onPlay");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a("onPlay");
                    }
                    if (c.this.f46411g) {
                        d.a.l0.a.j2.a unused = c.j = d.a.l0.a.j2.k.c("1044");
                    }
                    return true;
                case 1003:
                    d.g("backgroundAudio", "event onPause");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (c.this.f46411g) {
                        c.this.p();
                    }
                    return true;
                case 1004:
                    d.g("backgroundAudio", "event onStop");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a(MissionEvent.MESSAGE_STOP);
                    }
                    this.f46415a = true;
                    if (c.this.f46411g) {
                        c.this.p();
                    }
                    return true;
                case 1005:
                    d.g("backgroundAudio", "event onEnd");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a("onEnded");
                    }
                    if (c.this.f46411g) {
                        c.this.p();
                    }
                    return true;
                case 1006:
                    c.this.f46409e = i4;
                    try {
                        jSONObject.putOpt("currentTime", Integer.valueOf(c.this.r()));
                        jSONObject.putOpt("duration", Integer.valueOf(c.this.u() / 1000));
                    } catch (JSONException e2) {
                        if (c.f46404i) {
                            e2.printStackTrace();
                        }
                    }
                    d.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                    if (c.this.f46408d != null) {
                        c.this.f46408d.b("onTimeUpdate", jSONObject);
                    }
                    if (this.f46415a) {
                        if (c.this.f46407c.k > 0) {
                            c cVar = c.this;
                            cVar.G(cVar.f46407c.k);
                        }
                        this.f46415a = false;
                    }
                    return true;
                case 1007:
                    try {
                        jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i3));
                    } catch (JSONException e3) {
                        if (c.f46404i) {
                            e3.printStackTrace();
                        }
                    }
                    d.g("backgroundAudio", "event onError code:" + i3);
                    if (c.this.f46408d != null) {
                        c.this.f46408d.b("onError", jSONObject);
                    }
                    return true;
                case 1008:
                    int s = c.this.s();
                    c.this.f46410f = i3;
                    d.g("backgroundAudio", "event onDownloadProgress " + c.this.f46410f);
                    if (c.this.f46408d != null && s >= c.this.f46410f) {
                        c.this.f46408d.a("onWaiting");
                    }
                    return true;
                case 1009:
                    d.g("backgroundAudio", "event onPrev");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a("onPrev");
                    }
                    return true;
                case 1010:
                    d.g("backgroundAudio", "event onNext");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a("onNext");
                    }
                    return true;
                case 1011:
                    d.g("backgroundAudio", "event onSeekEnd");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a("onSeeked");
                    }
                    return true;
                case 1012:
                    d.g("backgroundAudio", "event onSeeking");
                    if (c.this.f46408d != null) {
                        c.this.f46408d.a("onSeeking");
                    }
                    return true;
                default:
                    return false;
            }
        }

        public /* synthetic */ C0760c(c cVar, a aVar) {
            this();
        }
    }

    public c(Context context) {
        this.f46406b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient = this.f46405a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.u();
        }
    }

    public final void B() {
        if (f46404i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        if (this.f46407c.a()) {
            return;
        }
        I();
        String str = this.f46407c.f46388c;
        e i2 = e.i();
        if (d.a.l0.a.k2.b.s(str) == PathType.CLOUD) {
            C(str);
        } else {
            D(str, i2);
        }
        f.V().p();
    }

    public final void C(String str) {
        d.a.l0.a.c1.a.k().b(this.f46406b, str, new b());
    }

    public final void D(String str, e eVar) {
        if (this.f46407c.q && eVar != null) {
            l m = d.a.l0.a.c1.b.m();
            if (this.f46408d.c()) {
                str = m == null ? null : m.a(str);
            } else {
                str = d.a.l0.a.k2.b.H(str, eVar);
            }
        }
        v().v(this.f46407c.c(str), str);
    }

    public void E() {
        d.g("backgroundAudio", "release ");
        if (this.f46405a == null || w()) {
            return;
        }
        this.f46405a.w();
        f.V().b();
        this.f46405a = null;
        j = null;
    }

    public void F() {
        if (f46404i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        SwanAppAudioClient swanAppAudioClient = this.f46405a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.y();
        }
    }

    public void G(int i2) {
        if (i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.f46405a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        d.g("backgroundAudio", "seekTo " + i2);
        d.a.l0.a.i1.c.e.a aVar = this.f46408d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        d.a.l0.a.i1.c.a aVar = this.f46407c;
        if (aVar == null || !aVar.f46394i) {
            return;
        }
        aVar.n = i2;
        aVar.o = i3;
        d.a.l0.a.c1.a.n().v(message, this.f46407c);
    }

    public final void I() {
        if (this.f46412h != null) {
            d.a.l0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f46412h);
        }
        this.f46412h = new a();
        d.a.l0.a.c1.a.b().registerActivityLifecycleCallbacks(this.f46412h);
    }

    public void J() {
        SwanAppAudioClient swanAppAudioClient = this.f46405a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.C();
        }
        if (this.f46412h != null) {
            d.a.l0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f46412h);
            this.f46412h = null;
        }
    }

    public void K(d.a.l0.a.i1.c.a aVar) {
        if (f46404i) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.f46407c = aVar;
        d.a.l0.a.i1.c.e.a aVar2 = this.f46408d;
        if (aVar2 != null) {
            aVar2.d(aVar.p);
        }
        B();
    }

    public final void p() {
        if (e.i() != null && e.i().N() != null && j != null) {
            b.a N = e.i().N();
            d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
            fVar.f46861a = d.a.l0.a.j2.k.m(N.G());
            fVar.f46866f = N.H();
            fVar.f46863c = N.T();
            fVar.a("appid", N.H());
            fVar.a("cuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()));
            JSONObject k = d.a.l0.a.j2.k.k(N.W());
            if (k != null) {
                fVar.a("keyfeed", k.optString("keyfeed"));
            }
            d.a.l0.a.j2.k.i(j, fVar);
        }
        j = null;
    }

    public d.a.l0.a.i1.c.a q() {
        return this.f46407c;
    }

    public int r() {
        return this.f46409e;
    }

    public final int s() {
        int u = u();
        if (u <= 0) {
            return 0;
        }
        return (int) ((r() / u) * 100.0f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object t(String str) {
        char c2;
        switch (str.hashCode()) {
            case -2129294769:
                if (str.equals("startTime")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1522036513:
                if (str.equals("buffered")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1296614986:
                if (str.equals("epname")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -1094703982:
                if (str.equals("lrcURL")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -995321554:
                if (str.equals("paused")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -902265988:
                if (str.equals("singer")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -453814973:
                if (str.equals("coverImgUrl")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 114148:
                if (str.equals("src")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 110371416:
                if (str.equals("title")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 601235430:
                if (str.equals("currentTime")) {
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
                return Integer.valueOf(u() / 1000);
            case 1:
                return Integer.valueOf(this.f46409e);
            case 2:
                return Boolean.valueOf(x());
            case 3:
                return this.f46407c.f46388c;
            case 4:
                return Integer.valueOf(this.f46407c.k);
            case 5:
                return Integer.valueOf(this.f46410f);
            case 6:
                return this.f46407c.f46389d;
            case 7:
                return this.f46407c.f46390e;
            case '\b':
                return this.f46407c.f46391f;
            case '\t':
                return this.f46407c.f46392g;
            case '\n':
                return this.f46407c.f46393h;
            default:
                return "";
        }
    }

    public int u() {
        SwanAppAudioClient swanAppAudioClient = this.f46405a;
        if (swanAppAudioClient != null) {
            return swanAppAudioClient.r();
        }
        return 0;
    }

    public final SwanAppAudioClient v() {
        if (this.f46405a == null) {
            this.f46405a = new SwanAppAudioClient(this.f46406b);
            this.f46405a.A(new C0760c(this, null));
        }
        return this.f46405a;
    }

    public final boolean w() {
        SwanAppConfigData F = e.i() != null ? e.i().F() : null;
        return F != null && F.p.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode);
    }

    public boolean x() {
        SwanAppAudioClient swanAppAudioClient = this.f46405a;
        if (swanAppAudioClient != null) {
            return !swanAppAudioClient.s();
        }
        return true;
    }

    public void y(boolean z) {
        SwanAppAudioClient swanAppAudioClient = this.f46405a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.t(z);
            f.V().p();
        }
    }

    public void z(d.a.l0.a.i1.c.a aVar, CallbackHandler callbackHandler) {
        if (f46404i) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.f46407c = aVar;
        if (aVar.p != null) {
            try {
                this.f46408d = new d.a.l0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f46407c.p));
            } catch (JSONException e2) {
                d.b("backgroundAudio", e2.toString());
                if (f46404i) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        B();
    }
}
