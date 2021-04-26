package d.a.h0.a.b1.c;

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
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z0.f;
import d.a.h0.a.z1.h;
import d.a.h0.g.l.n;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f41287i = k.f43101a;
    public static d.a.h0.a.z1.a j;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f41288a;

    /* renamed from: b  reason: collision with root package name */
    public Context f41289b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.b1.c.e.a f41291d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41294g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.a.z0.a f41295h;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.b1.c.a f41290c = new d.a.h0.a.b1.c.a();

    /* renamed from: e  reason: collision with root package name */
    public int f41292e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f41293f = 0;

    /* loaded from: classes3.dex */
    public class a extends d.a.h0.a.z0.a {
        public a() {
        }

        @Override // d.a.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            c.this.f41294g = false;
            if (c.this.w()) {
                return;
            }
            c.this.o();
        }

        @Override // d.a.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            c.this.f41294g = true;
            if (c.this.v()) {
                if (c.this.w()) {
                    d.a.h0.a.z1.a unused = c.j = null;
                    return;
                } else if (c.j == null) {
                    d.a.h0.a.z1.a unused2 = c.j = h.e("1044");
                    return;
                } else {
                    return;
                }
            }
            super.onActivityStopped(activity);
            c.this.H();
            d.a.h0.a.c0.c.l("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<String> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.this.u().v(c.this.f41290c.c(str), str);
        }
    }

    /* renamed from: d.a.h0.a.b1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0571c implements SwanAppAudioClient.c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f41298a;

        public C0571c() {
        }

        @Override // com.baidu.swan.apps.media.audio.SwanAppAudioClient.c
        public boolean a(Message message) {
            int i2 = message.what;
            int i3 = message.arg1;
            int i4 = message.arg2;
            JSONObject jSONObject = new JSONObject();
            switch (i2) {
                case 1001:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onCanPlay");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a("onCanplay");
                    }
                    this.f41298a = true;
                    return true;
                case 1002:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onPlay");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a("onPlay");
                    }
                    if (c.this.f41294g) {
                        d.a.h0.a.z1.a unused = c.j = h.e("1044");
                    }
                    return true;
                case 1003:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onPause");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (c.this.f41294g) {
                        c.this.o();
                    }
                    return true;
                case 1004:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onStop");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a(MissionEvent.MESSAGE_STOP);
                    }
                    this.f41298a = true;
                    if (c.this.f41294g) {
                        c.this.o();
                    }
                    return true;
                case 1005:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onEnd");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a("onEnded");
                    }
                    if (c.this.f41294g) {
                        c.this.o();
                    }
                    return true;
                case 1006:
                    c.this.f41292e = i4;
                    try {
                        jSONObject.putOpt("currentTime", Integer.valueOf(c.this.q()));
                        jSONObject.putOpt("duration", Integer.valueOf(c.this.t() / 1000));
                    } catch (JSONException e2) {
                        if (c.f41287i) {
                            e2.printStackTrace();
                        }
                    }
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                    if (c.this.f41291d != null) {
                        c.this.f41291d.b("onTimeUpdate", jSONObject);
                    }
                    if (this.f41298a) {
                        if (c.this.f41290c.f41277i > 0) {
                            c cVar = c.this;
                            cVar.F(cVar.f41290c.f41277i);
                        }
                        this.f41298a = false;
                    }
                    return true;
                case 1007:
                    try {
                        jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i3));
                    } catch (JSONException e3) {
                        if (c.f41287i) {
                            e3.printStackTrace();
                        }
                    }
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onError code:" + i3);
                    if (c.this.f41291d != null) {
                        c.this.f41291d.b("onError", jSONObject);
                    }
                    return true;
                case 1008:
                    int r = c.this.r();
                    c.this.f41293f = i3;
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onDownloadProgress " + c.this.f41293f);
                    if (c.this.f41291d != null && r >= c.this.f41293f) {
                        c.this.f41291d.a("onWaiting");
                    }
                    return true;
                case 1009:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onPrev");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a("onPrev");
                    }
                    return true;
                case 1010:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onNext");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a("onNext");
                    }
                    return true;
                case 1011:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onSeekEnd");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a("onSeeked");
                    }
                    return true;
                case 1012:
                    d.a.h0.a.c0.c.g("backgroundAudio", "event onSeeking");
                    if (c.this.f41291d != null) {
                        c.this.f41291d.a("onSeeking");
                    }
                    return true;
                default:
                    return false;
            }
        }

        public /* synthetic */ C0571c(c cVar, a aVar) {
            this();
        }
    }

    public c(Context context) {
        this.f41289b = context;
    }

    public final void A() {
        if (f41287i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        if (this.f41290c.a()) {
            return;
        }
        G();
        String str = this.f41290c.f41271c;
        e h2 = e.h();
        if (d.a.h0.a.a2.b.c(str) == PathType.CLOUD) {
            B(str);
        } else {
            C(str, h2);
        }
        f.V().r();
    }

    public final void B(String str) {
        d.a.h0.a.w0.a.j().a(this.f41289b, str, new b());
    }

    public final void C(String str, e eVar) {
        if (this.f41290c.m && eVar != null) {
            if (this.f41291d.c()) {
                str = n.U(str);
            } else {
                str = d.a.h0.a.a2.b.p(str, eVar);
            }
        }
        u().v(this.f41290c.c(str), str);
    }

    public void D() {
        d.a.h0.a.c0.c.g("backgroundAudio", "release ");
        if (this.f41288a == null || v()) {
            return;
        }
        this.f41288a.w();
        f.V().d();
        this.f41288a = null;
        j = null;
    }

    public void E() {
        if (f41287i) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        SwanAppAudioClient swanAppAudioClient = this.f41288a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.y();
        }
    }

    public void F(int i2) {
        if (i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.f41288a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        d.a.h0.a.c0.c.g("backgroundAudio", "seekTo " + i2);
        d.a.h0.a.b1.c.e.a aVar = this.f41291d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void G() {
        if (this.f41295h != null) {
            d.a.h0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this.f41295h);
        }
        this.f41295h = new a();
        d.a.h0.a.w0.a.c().registerActivityLifecycleCallbacks(this.f41295h);
    }

    public void H() {
        SwanAppAudioClient swanAppAudioClient = this.f41288a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.C();
        }
        if (this.f41295h != null) {
            d.a.h0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this.f41295h);
            this.f41295h = null;
        }
    }

    public void I(d.a.h0.a.b1.c.a aVar) {
        if (f41287i) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.f41290c = aVar;
        d.a.h0.a.b1.c.e.a aVar2 = this.f41291d;
        if (aVar2 != null) {
            aVar2.d(aVar.l);
        }
        A();
    }

    public final void o() {
        if (e.h() != null && e.h().L() != null && j != null) {
            b.a L = e.h().L();
            d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
            fVar.f45411a = h.n(L.F());
            fVar.f45415e = L.G();
            fVar.f45413c = L.S();
            fVar.a("appid", L.G());
            fVar.a("cuid", d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c()));
            JSONObject l = h.l(L.V());
            if (l != null) {
                fVar.a("keyfeed", l.optString("keyfeed"));
            }
            h.k(j, fVar);
        }
        j = null;
    }

    public d.a.h0.a.b1.c.a p() {
        return this.f41290c;
    }

    public int q() {
        return this.f41292e;
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
                return Integer.valueOf(this.f41292e);
            case 2:
                return Boolean.valueOf(w());
            case 3:
                return this.f41290c.f41271c;
            case 4:
                return Integer.valueOf(this.f41290c.f41277i);
            case 5:
                return Integer.valueOf(this.f41293f);
            case 6:
                return this.f41290c.f41272d;
            case 7:
                return this.f41290c.f41273e;
            case '\b':
                return this.f41290c.f41274f;
            case '\t':
                return this.f41290c.f41275g;
            case '\n':
                return this.f41290c.f41276h;
            default:
                return "";
        }
    }

    public int t() {
        SwanAppAudioClient swanAppAudioClient = this.f41288a;
        if (swanAppAudioClient != null) {
            return swanAppAudioClient.r();
        }
        return 0;
    }

    public final SwanAppAudioClient u() {
        if (this.f41288a == null) {
            this.f41288a = new SwanAppAudioClient(this.f41289b);
            this.f41288a.A(new C0571c(this, null));
        }
        return this.f41288a;
    }

    public final boolean v() {
        SwanAppConfigData D = e.h() != null ? e.h().D() : null;
        return D != null && D.o.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    public boolean w() {
        SwanAppAudioClient swanAppAudioClient = this.f41288a;
        if (swanAppAudioClient != null) {
            return !swanAppAudioClient.s();
        }
        return true;
    }

    public void x(boolean z) {
        SwanAppAudioClient swanAppAudioClient = this.f41288a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.t(z);
            f.V().r();
        }
    }

    public void y(d.a.h0.a.b1.c.a aVar, CallbackHandler callbackHandler) {
        if (f41287i) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.f41290c = aVar;
        if (aVar.l != null) {
            try {
                this.f41291d = new d.a.h0.a.b1.c.e.a(callbackHandler, new JSONObject(this.f41290c.l));
            } catch (JSONException e2) {
                d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
                if (f41287i) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        A();
    }

    public void z() {
        SwanAppAudioClient swanAppAudioClient = this.f41288a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.u();
        }
    }
}
