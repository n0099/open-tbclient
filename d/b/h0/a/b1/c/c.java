package d.b.h0.a.b1.c;

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
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z0.f;
import d.b.h0.a.z1.h;
import d.b.h0.g.l.n;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static final boolean i = k.f45772a;
    public static d.b.h0.a.z1.a j;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f44015a;

    /* renamed from: b  reason: collision with root package name */
    public Context f44016b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.b1.c.e.a f44018d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44021g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.a.z0.a f44022h;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.b1.c.a f44017c = new d.b.h0.a.b1.c.a();

    /* renamed from: e  reason: collision with root package name */
    public int f44019e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f44020f = 0;

    /* loaded from: classes2.dex */
    public class a extends d.b.h0.a.z0.a {
        public a() {
        }

        @Override // d.b.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            c.this.f44021g = false;
            if (c.this.w()) {
                return;
            }
            c.this.o();
        }

        @Override // d.b.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            c.this.f44021g = true;
            if (c.this.v()) {
                if (c.this.w()) {
                    d.b.h0.a.z1.a unused = c.j = null;
                    return;
                } else if (c.j == null) {
                    d.b.h0.a.z1.a unused2 = c.j = h.e("1044");
                    return;
                } else {
                    return;
                }
            }
            super.onActivityStopped(activity);
            c.this.H();
            d.b.h0.a.c0.c.l("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.i2.u0.b<String> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.this.u().v(c.this.f44017c.c(str), str);
        }
    }

    /* renamed from: d.b.h0.a.b1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0632c implements SwanAppAudioClient.c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f44025a;

        public C0632c() {
        }

        @Override // com.baidu.swan.apps.media.audio.SwanAppAudioClient.c
        public boolean a(Message message) {
            int i = message.what;
            int i2 = message.arg1;
            int i3 = message.arg2;
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1001:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onCanPlay");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a("onCanplay");
                    }
                    this.f44025a = true;
                    return true;
                case 1002:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onPlay");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a("onPlay");
                    }
                    if (c.this.f44021g) {
                        d.b.h0.a.z1.a unused = c.j = h.e("1044");
                    }
                    return true;
                case 1003:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onPause");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (c.this.f44021g) {
                        c.this.o();
                    }
                    return true;
                case 1004:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onStop");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a(MissionEvent.MESSAGE_STOP);
                    }
                    this.f44025a = true;
                    if (c.this.f44021g) {
                        c.this.o();
                    }
                    return true;
                case 1005:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onEnd");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a("onEnded");
                    }
                    if (c.this.f44021g) {
                        c.this.o();
                    }
                    return true;
                case 1006:
                    c.this.f44019e = i3;
                    try {
                        jSONObject.putOpt("currentTime", Integer.valueOf(c.this.q()));
                        jSONObject.putOpt("duration", Integer.valueOf(c.this.t() / 1000));
                    } catch (JSONException e2) {
                        if (c.i) {
                            e2.printStackTrace();
                        }
                    }
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                    if (c.this.f44018d != null) {
                        c.this.f44018d.b("onTimeUpdate", jSONObject);
                    }
                    if (this.f44025a) {
                        if (c.this.f44017c.i > 0) {
                            c cVar = c.this;
                            cVar.F(cVar.f44017c.i);
                        }
                        this.f44025a = false;
                    }
                    return true;
                case 1007:
                    try {
                        jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i2));
                    } catch (JSONException e3) {
                        if (c.i) {
                            e3.printStackTrace();
                        }
                    }
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onError code:" + i2);
                    if (c.this.f44018d != null) {
                        c.this.f44018d.b("onError", jSONObject);
                    }
                    return true;
                case 1008:
                    int r = c.this.r();
                    c.this.f44020f = i2;
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onDownloadProgress " + c.this.f44020f);
                    if (c.this.f44018d != null && r >= c.this.f44020f) {
                        c.this.f44018d.a("onWaiting");
                    }
                    return true;
                case 1009:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onPrev");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a("onPrev");
                    }
                    return true;
                case 1010:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onNext");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a("onNext");
                    }
                    return true;
                case 1011:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onSeekEnd");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a("onSeeked");
                    }
                    return true;
                case 1012:
                    d.b.h0.a.c0.c.g("backgroundAudio", "event onSeeking");
                    if (c.this.f44018d != null) {
                        c.this.f44018d.a("onSeeking");
                    }
                    return true;
                default:
                    return false;
            }
        }

        public /* synthetic */ C0632c(c cVar, a aVar) {
            this();
        }
    }

    public c(Context context) {
        this.f44016b = context;
    }

    public final void A() {
        if (i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        if (this.f44017c.a()) {
            return;
        }
        G();
        String str = this.f44017c.f44001c;
        e y = e.y();
        if (d.b.h0.a.a2.b.c(str) == PathType.CLOUD) {
            B(str);
        } else {
            C(str, y);
        }
        f.V().D();
    }

    public final void B(String str) {
        d.b.h0.a.w0.a.j().a(this.f44016b, str, new b());
    }

    public final void C(String str, e eVar) {
        if (this.f44017c.m && eVar != null) {
            if (this.f44018d.c()) {
                str = n.U(str);
            } else {
                str = d.b.h0.a.a2.b.p(str, eVar);
            }
        }
        u().v(this.f44017c.c(str), str);
    }

    public void D() {
        d.b.h0.a.c0.c.g("backgroundAudio", "release ");
        if (this.f44015a == null || v()) {
            return;
        }
        this.f44015a.w();
        f.V().f();
        this.f44015a = null;
        j = null;
    }

    public void E() {
        if (i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        SwanAppAudioClient swanAppAudioClient = this.f44015a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.y();
        }
    }

    public void F(int i2) {
        if (i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.f44015a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        d.b.h0.a.c0.c.g("backgroundAudio", "seekTo " + i2);
        d.b.h0.a.b1.c.e.a aVar = this.f44018d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void G() {
        if (this.f44022h != null) {
            d.b.h0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this.f44022h);
        }
        this.f44022h = new a();
        d.b.h0.a.w0.a.c().registerActivityLifecycleCallbacks(this.f44022h);
    }

    public void H() {
        SwanAppAudioClient swanAppAudioClient = this.f44015a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.C();
        }
        if (this.f44022h != null) {
            d.b.h0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this.f44022h);
            this.f44022h = null;
        }
    }

    public void I(d.b.h0.a.b1.c.a aVar) {
        if (i) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.f44017c = aVar;
        d.b.h0.a.b1.c.e.a aVar2 = this.f44018d;
        if (aVar2 != null) {
            aVar2.d(aVar.l);
        }
        A();
    }

    public final void o() {
        if (e.y() != null && e.y().L() != null && j != null) {
            b.a L = e.y().L();
            d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
            fVar.f47972a = h.n(L.F());
            fVar.f47976e = L.G();
            fVar.f47974c = L.S();
            fVar.a("appid", L.G());
            fVar.a("cuid", d.b.h0.a.w0.a.O().c(d.b.h0.a.w0.a.c()));
            JSONObject l = h.l(L.V());
            if (l != null) {
                fVar.a("keyfeed", l.optString("keyfeed"));
            }
            h.k(j, fVar);
        }
        j = null;
    }

    public d.b.h0.a.b1.c.a p() {
        return this.f44017c;
    }

    public int q() {
        return this.f44019e;
    }

    public final int r() {
        int t = t();
        if (t <= 0) {
            return 0;
        }
        return (int) ((q() / t) * 100.0f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object s(String str) {
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
                return Integer.valueOf(t() / 1000);
            case 1:
                return Integer.valueOf(this.f44019e);
            case 2:
                return Boolean.valueOf(w());
            case 3:
                return this.f44017c.f44001c;
            case 4:
                return Integer.valueOf(this.f44017c.i);
            case 5:
                return Integer.valueOf(this.f44020f);
            case 6:
                return this.f44017c.f44002d;
            case 7:
                return this.f44017c.f44003e;
            case '\b':
                return this.f44017c.f44004f;
            case '\t':
                return this.f44017c.f44005g;
            case '\n':
                return this.f44017c.f44006h;
            default:
                return "";
        }
    }

    public int t() {
        SwanAppAudioClient swanAppAudioClient = this.f44015a;
        if (swanAppAudioClient != null) {
            return swanAppAudioClient.r();
        }
        return 0;
    }

    public final SwanAppAudioClient u() {
        if (this.f44015a == null) {
            this.f44015a = new SwanAppAudioClient(this.f44016b);
            this.f44015a.A(new C0632c(this, null));
        }
        return this.f44015a;
    }

    public final boolean v() {
        SwanAppConfigData D = e.y() != null ? e.y().D() : null;
        return D != null && D.o.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    public boolean w() {
        SwanAppAudioClient swanAppAudioClient = this.f44015a;
        if (swanAppAudioClient != null) {
            return !swanAppAudioClient.s();
        }
        return true;
    }

    public void x(boolean z) {
        SwanAppAudioClient swanAppAudioClient = this.f44015a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.t(z);
            f.V().D();
        }
    }

    public void y(d.b.h0.a.b1.c.a aVar, CallbackHandler callbackHandler) {
        if (i) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.f44017c = aVar;
        if (aVar.l != null) {
            try {
                this.f44018d = new d.b.h0.a.b1.c.e.a(callbackHandler, new JSONObject(this.f44017c.l));
            } catch (JSONException e2) {
                d.b.h0.a.c0.c.b("backgroundAudio", e2.toString());
                if (i) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        A();
    }

    public void z() {
        SwanAppAudioClient swanAppAudioClient = this.f44015a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.u();
        }
    }
}
