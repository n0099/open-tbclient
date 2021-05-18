package d.a.i0.a.i1.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.SwanAppAudioClient;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.router.RouterCallback;
import d.a.i0.a.a2.e;
import d.a.i0.a.e0.d;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import d.a.i0.a.p.b.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f42554i = k.f43025a;
    public static d.a.i0.a.j2.a j;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f42555a;

    /* renamed from: b  reason: collision with root package name */
    public Context f42556b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.i1.c.e.a f42558d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42561g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.a.g1.a f42562h;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.i1.c.a f42557c = new d.a.i0.a.i1.c.a();

    /* renamed from: e  reason: collision with root package name */
    public int f42559e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f42560f = 0;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.a.g1.a {
        public a() {
        }

        @Override // d.a.i0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            c.this.f42561g = false;
            if (c.this.x()) {
                return;
            }
            c.this.p();
        }

        @Override // d.a.i0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            c.this.f42561g = true;
            if (c.this.w()) {
                if (c.this.x()) {
                    d.a.i0.a.j2.a unused = c.j = null;
                    return;
                } else if (c.j == null) {
                    d.a.i0.a.j2.a unused2 = c.j = d.a.i0.a.j2.k.c("1044");
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
    public class b implements d.a.i0.a.v2.e1.b<String> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.this.v().v(c.this.f42557c.c(str), str);
        }
    }

    /* renamed from: d.a.i0.a.i1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0693c implements SwanAppAudioClient.c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f42565a;

        public C0693c() {
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
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a("onCanplay");
                    }
                    this.f42565a = true;
                    return true;
                case 1002:
                    d.g("backgroundAudio", "event onPlay");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a("onPlay");
                    }
                    if (c.this.f42561g) {
                        d.a.i0.a.j2.a unused = c.j = d.a.i0.a.j2.k.c("1044");
                    }
                    return true;
                case 1003:
                    d.g("backgroundAudio", "event onPause");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (c.this.f42561g) {
                        c.this.p();
                    }
                    return true;
                case 1004:
                    d.g("backgroundAudio", "event onStop");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a(MissionEvent.MESSAGE_STOP);
                    }
                    this.f42565a = true;
                    if (c.this.f42561g) {
                        c.this.p();
                    }
                    return true;
                case 1005:
                    d.g("backgroundAudio", "event onEnd");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a("onEnded");
                    }
                    if (c.this.f42561g) {
                        c.this.p();
                    }
                    return true;
                case 1006:
                    c.this.f42559e = i4;
                    try {
                        jSONObject.putOpt("currentTime", Integer.valueOf(c.this.r()));
                        jSONObject.putOpt("duration", Integer.valueOf(c.this.u() / 1000));
                    } catch (JSONException e2) {
                        if (c.f42554i) {
                            e2.printStackTrace();
                        }
                    }
                    d.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                    if (c.this.f42558d != null) {
                        c.this.f42558d.b("onTimeUpdate", jSONObject);
                    }
                    if (this.f42565a) {
                        if (c.this.f42557c.k > 0) {
                            c cVar = c.this;
                            cVar.G(cVar.f42557c.k);
                        }
                        this.f42565a = false;
                    }
                    return true;
                case 1007:
                    try {
                        jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i3));
                    } catch (JSONException e3) {
                        if (c.f42554i) {
                            e3.printStackTrace();
                        }
                    }
                    d.g("backgroundAudio", "event onError code:" + i3);
                    if (c.this.f42558d != null) {
                        c.this.f42558d.b("onError", jSONObject);
                    }
                    return true;
                case 1008:
                    int s = c.this.s();
                    c.this.f42560f = i3;
                    d.g("backgroundAudio", "event onDownloadProgress " + c.this.f42560f);
                    if (c.this.f42558d != null && s >= c.this.f42560f) {
                        c.this.f42558d.a("onWaiting");
                    }
                    return true;
                case 1009:
                    d.g("backgroundAudio", "event onPrev");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a("onPrev");
                    }
                    return true;
                case 1010:
                    d.g("backgroundAudio", "event onNext");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a("onNext");
                    }
                    return true;
                case 1011:
                    d.g("backgroundAudio", "event onSeekEnd");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a("onSeeked");
                    }
                    return true;
                case 1012:
                    d.g("backgroundAudio", "event onSeeking");
                    if (c.this.f42558d != null) {
                        c.this.f42558d.a("onSeeking");
                    }
                    return true;
                default:
                    return false;
            }
        }

        public /* synthetic */ C0693c(c cVar, a aVar) {
            this();
        }
    }

    public c(Context context) {
        this.f42556b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient = this.f42555a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.u();
        }
    }

    public final void B() {
        if (f42554i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        if (this.f42557c.a()) {
            return;
        }
        I();
        String str = this.f42557c.f42538c;
        e i2 = e.i();
        if (d.a.i0.a.k2.b.s(str) == PathType.CLOUD) {
            C(str);
        } else {
            D(str, i2);
        }
        f.V().p();
    }

    public final void C(String str) {
        d.a.i0.a.c1.a.k().b(this.f42556b, str, new b());
    }

    public final void D(String str, e eVar) {
        if (this.f42557c.q && eVar != null) {
            l m = d.a.i0.a.c1.b.m();
            if (this.f42558d.c()) {
                str = m == null ? null : m.a(str);
            } else {
                str = d.a.i0.a.k2.b.H(str, eVar);
            }
        }
        v().v(this.f42557c.c(str), str);
    }

    public void E() {
        d.g("backgroundAudio", "release ");
        if (this.f42555a == null || w()) {
            return;
        }
        this.f42555a.w();
        f.V().b();
        this.f42555a = null;
        j = null;
    }

    public void F() {
        if (f42554i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        SwanAppAudioClient swanAppAudioClient = this.f42555a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.y();
        }
    }

    public void G(int i2) {
        if (i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.f42555a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        d.g("backgroundAudio", "seekTo " + i2);
        d.a.i0.a.i1.c.e.a aVar = this.f42558d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        d.a.i0.a.i1.c.a aVar = this.f42557c;
        if (aVar == null || !aVar.f42544i) {
            return;
        }
        aVar.n = i2;
        aVar.o = i3;
        d.a.i0.a.c1.a.n().v(message, this.f42557c);
    }

    public final void I() {
        if (this.f42562h != null) {
            d.a.i0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f42562h);
        }
        this.f42562h = new a();
        d.a.i0.a.c1.a.b().registerActivityLifecycleCallbacks(this.f42562h);
    }

    public void J() {
        SwanAppAudioClient swanAppAudioClient = this.f42555a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.C();
        }
        if (this.f42562h != null) {
            d.a.i0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f42562h);
            this.f42562h = null;
        }
    }

    public void K(d.a.i0.a.i1.c.a aVar) {
        if (f42554i) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.f42557c = aVar;
        d.a.i0.a.i1.c.e.a aVar2 = this.f42558d;
        if (aVar2 != null) {
            aVar2.d(aVar.p);
        }
        B();
    }

    public final void p() {
        if (e.i() != null && e.i().N() != null && j != null) {
            b.a N = e.i().N();
            d.a.i0.a.j2.p.f fVar = new d.a.i0.a.j2.p.f();
            fVar.f43011a = d.a.i0.a.j2.k.m(N.G());
            fVar.f43016f = N.H();
            fVar.f43013c = N.T();
            fVar.a("appid", N.H());
            fVar.a("cuid", d.a.i0.a.c1.a.a0().i(d.a.i0.a.c1.a.b()));
            JSONObject k = d.a.i0.a.j2.k.k(N.W());
            if (k != null) {
                fVar.a("keyfeed", k.optString("keyfeed"));
            }
            d.a.i0.a.j2.k.i(j, fVar);
        }
        j = null;
    }

    public d.a.i0.a.i1.c.a q() {
        return this.f42557c;
    }

    public int r() {
        return this.f42559e;
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
                if (str.equals(UserAccountActionItem.KEY_SRC)) {
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
                return Integer.valueOf(this.f42559e);
            case 2:
                return Boolean.valueOf(x());
            case 3:
                return this.f42557c.f42538c;
            case 4:
                return Integer.valueOf(this.f42557c.k);
            case 5:
                return Integer.valueOf(this.f42560f);
            case 6:
                return this.f42557c.f42539d;
            case 7:
                return this.f42557c.f42540e;
            case '\b':
                return this.f42557c.f42541f;
            case '\t':
                return this.f42557c.f42542g;
            case '\n':
                return this.f42557c.f42543h;
            default:
                return "";
        }
    }

    public int u() {
        SwanAppAudioClient swanAppAudioClient = this.f42555a;
        if (swanAppAudioClient != null) {
            return swanAppAudioClient.r();
        }
        return 0;
    }

    public final SwanAppAudioClient v() {
        if (this.f42555a == null) {
            this.f42555a = new SwanAppAudioClient(this.f42556b);
            this.f42555a.A(new C0693c(this, null));
        }
        return this.f42555a;
    }

    public final boolean w() {
        SwanAppConfigData F = e.i() != null ? e.i().F() : null;
        return F != null && F.p.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode);
    }

    public boolean x() {
        SwanAppAudioClient swanAppAudioClient = this.f42555a;
        if (swanAppAudioClient != null) {
            return !swanAppAudioClient.s();
        }
        return true;
    }

    public void y(boolean z) {
        SwanAppAudioClient swanAppAudioClient = this.f42555a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.t(z);
            f.V().p();
        }
    }

    public void z(d.a.i0.a.i1.c.a aVar, CallbackHandler callbackHandler) {
        if (f42554i) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.f42557c = aVar;
        if (aVar.p != null) {
            try {
                this.f42558d = new d.a.i0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f42557c.p));
            } catch (JSONException e2) {
                d.b("backgroundAudio", e2.toString());
                if (f42554i) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        B();
    }
}
