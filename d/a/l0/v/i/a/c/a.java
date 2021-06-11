package d.a.l0.v.i.a.c;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.a.l0.a.v2.d0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.y0.d;
import d.a.l0.a.y0.k.g.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a implements d.a.l0.a.y0.k.g.a {
    public static final boolean x = d.a.l0.a.k.f46875a;
    public static boolean y = true;

    /* renamed from: b  reason: collision with root package name */
    public String f52192b;

    /* renamed from: c  reason: collision with root package name */
    public Context f52193c;

    /* renamed from: d  reason: collision with root package name */
    public ZeusPluginFactory.Invoker f52194d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayer f52195e;

    /* renamed from: f  reason: collision with root package name */
    public String f52196f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f52197g;

    /* renamed from: h  reason: collision with root package name */
    public String f52198h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC0976a f52199i;

    /* renamed from: a  reason: collision with root package name */
    public int f52191a = -1;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public int m = 1;
    public int n = 1;
    public d.a.l0.v.j.a.c.a o = new d.a.l0.v.j.a.c.a();
    public final CyberPlayerManager.OnPreparedListener p = new h();
    public final CyberPlayerManager.OnErrorListener q = new i();
    public final CyberPlayerManager.OnCompletionListener r = new j();
    public final CyberPlayerManager.OnInfoListener s = new k();
    public final CyberPlayerManager.OnBufferingUpdateListener t = new l();
    public final CyberPlayerManager.OnSeekCompleteListener u = new C1144a();
    public final CyberPlayerManager.OnVideoSizeChangedListener v = new b();
    public final AudioManager.OnAudioFocusChangeListener w = new c(this);

    /* renamed from: d.a.l0.v.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1144a implements CyberPlayerManager.OnSeekCompleteListener {
        public C1144a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CyberPlayerManager.OnVideoSizeChangedListener {
        public b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            if (a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.o.f52228e = i2;
            a.this.o.f52229f = i3;
            if (i4 == 0 || i5 == 0) {
                a.this.m = 1;
                a.this.n = 1;
            } else {
                a.this.m = i4;
                a.this.n = i5;
            }
            a.InterfaceC0976a interfaceC0976a = a.this.f52199i;
            if (interfaceC0976a != null) {
                interfaceC0976a.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AudioManager.OnAudioFocusChangeListener {
        public c(a aVar) {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (a.x) {
                Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange " + i2);
            }
            if (i2 == -1 && a.x) {
                Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange = AudioManager.AUDIOFOCUS_LOSS");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f52202a;

        public d(a aVar, d.a aVar2) {
            this.f52202a = aVar2;
        }

        @Override // d.a.l0.v.i.a.c.a.m
        public void a(boolean z) {
            this.f52202a.a(z);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f52203e;

        public e(HashMap hashMap) {
            this.f52203e = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.x0().setDataSource(a.this.f52193c, Uri.parse(str), this.f52203e);
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f52205a;

        public f(m mVar) {
            this.f52205a = mVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            if (a.x) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
            }
            boolean unused = a.y = false;
            m mVar = this.f52205a;
            if (mVar != null) {
                mVar.a(false);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            if (a.x) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
            }
            boolean unused = a.y = false;
            m mVar = this.f52205a;
            if (mVar != null) {
                mVar.a(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f52206e;

        public g(a aVar, boolean z) {
            this.f52206e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity x;
            Window window;
            d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
            if (i2 == null || (x = i2.x()) == null || (window = x.getWindow()) == null) {
                return;
            }
            try {
                if (this.f52206e) {
                    window.addFlags(128);
                } else {
                    window.clearFlags(128);
                }
            } catch (Exception e2) {
                if (a.x) {
                    throw new RuntimeException("inline video set screenOn/Off in wrong thread", e2);
                }
            }
            if (a.x) {
                Log.d("SwanInlineCyberWidget", "setKeepScreenOn: " + this.f52206e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public h() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.o.f52228e = a.this.getVideoWidth();
            a.this.o.f52229f = a.this.getVideoHeight();
            a.InterfaceC0976a interfaceC0976a = a.this.f52199i;
            if (interfaceC0976a != null) {
                interfaceC0976a.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements CyberPlayerManager.OnErrorListener {
        public i() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
            if (a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.o0();
            a.this.A0(i2);
            int i4 = i2 == -10000 ? 0 : i2;
            a.InterfaceC0976a interfaceC0976a = a.this.f52199i;
            if (interfaceC0976a != null) {
                interfaceC0976a.onError(i4);
            }
            a.this.C0(i2, i3, obj2);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements CyberPlayerManager.OnCompletionListener {
        public j() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.o0();
            a aVar = a.this;
            a.InterfaceC0976a interfaceC0976a = aVar.f52199i;
            if (interfaceC0976a != null) {
                if (z) {
                    interfaceC0976a.onEnded();
                } else {
                    interfaceC0976a.c(aVar.c());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements CyberPlayerManager.OnInfoListener {
        public k() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (a.x) {
                String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            switch (i2) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.o.f52225b = i3;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.o.f52224a = i3;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.o.f52226c = i3;
                    break;
            }
            a.this.A0(i2);
            a.this.f52199i.b(i2);
            if (i2 == 904) {
                a.this.D0();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements CyberPlayerManager.OnBufferingUpdateListener {
        public l() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i2) {
            if (a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface m {
        void a(boolean z);
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f52194d = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.f52196f = (String) obj;
            }
        }
        this.f52193c = d.a.l0.a.c1.a.b();
        this.f52198h = str;
    }

    public static String B0(String str) {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        return (!d.a.l0.a.k2.b.E(str) || i2 == null) ? str : d.a.l0.a.k2.b.H(str, i2);
    }

    public static void I0(@NonNull Context context, @Nullable m mVar) {
        if (y) {
            if (x) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), d.a.l0.a.c1.a.a0().i(context), null, 7, null, null, new f(mVar));
            return;
        }
        if (x) {
            Log.v("【CyberCallback】", "CyberPlayer播放内核已安装，无需重复安装");
        }
        if (mVar != null) {
            mVar.a(true);
        }
    }

    @Override // d.a.l0.a.y0.d
    public void A(@NonNull d.a aVar) {
        I0(d.a.l0.a.c1.a.b(), new d(this, aVar));
    }

    public final void A0(int i2) {
        a.InterfaceC0976a interfaceC0976a;
        int b2 = d.a.l0.v.j.a.b.a.b(i2);
        if (x) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i2 + ", statusCode " + b2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        if (b2 != 100) {
            if (b2 == 2101 && (interfaceC0976a = this.f52199i) != null) {
                interfaceC0976a.a(2102);
            }
            a.InterfaceC0976a interfaceC0976a2 = this.f52199i;
            if (interfaceC0976a2 != null) {
                interfaceC0976a2.a(b2);
            }
        }
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void B(boolean z) {
        if (z) {
            ZeusPluginFactory.Invoker invoker = this.f52194d;
            if (invoker != null) {
                x0().changeProxyDynamic((String) invoker.get("Proxy"), true);
                return;
            }
            return;
        }
        x0().changeProxyDynamic(null, false);
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void C() {
    }

    public abstract void C0(int i2, int i3, String str);

    public abstract void D0();

    public final void E0() {
        if (this.k) {
            if (x) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.f52197g == null) {
            this.f52197g = (AudioManager) this.f52193c.getSystemService("audio");
        }
        AudioManager audioManager = this.f52197g;
        if (audioManager == null) {
            return;
        }
        try {
            audioManager.requestAudioFocus(this.w, 3, 1);
        } catch (Exception e2) {
            if (x) {
                e2.printStackTrace();
            }
        }
    }

    public final void F0(String str, HashMap<String, String> hashMap) {
        d.a.l0.a.c1.a.k().b(getContext(), str, new e(hashMap));
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void G(int i2) {
        if (x) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i2);
        }
    }

    public final void G0(boolean z) {
        q0.X(new g(this, z));
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void H() {
    }

    public final void H0(boolean z) {
        this.j = z;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void L(int i2, int i3, int i4, int i5) {
    }

    @Override // d.a.l0.a.y0.k.g.a
    public boolean O(String str, String str2, String str3, boolean z) {
        if (x) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.l = true;
        this.f52192b = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(ImageSource.FILE_SCHEME)) {
            str = str.substring(8);
        }
        String B0 = B0(str);
        ZeusPluginFactory.Invoker invoker = this.f52194d;
        if (invoker != null) {
            String str4 = (String) invoker.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                x0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                x0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                x0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                x0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Cookie", str2);
        }
        if (z) {
            hashMap.put("x-hide-urls-from-log", "true");
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("User-Agent", str3);
        }
        String b2 = d0.b();
        if (!TextUtils.isEmpty(b2) && d0.c(B0)) {
            if (x) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + b2);
            }
            hashMap.put("Referer", b2);
        }
        if (d.a.l0.a.k2.b.s(B0) == PathType.CLOUD) {
            F0(B0, hashMap);
        } else {
            x0().setDataSource(this.f52193c, Uri.parse(B0), hashMap);
        }
        return true;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public boolean P() {
        return this.l;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public a.InterfaceC0976a Q() {
        return this.f52199i;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void U(Map map) {
        x0().setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, map);
    }

    @Override // d.a.l0.a.y0.k.g.a
    @CallSuper
    public void X() {
        this.f52191a = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            H0(true);
        }
    }

    @Override // d.a.l0.a.y0.k.g.a
    public int a() {
        return 0;
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String b() {
        return this.f52198h;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public String c() {
        return this.f52196f + "-" + hashCode();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void c0(String str) {
        d.a.l0.a.y0.k.f.b.b().a(c(), str);
    }

    @Override // d.a.l0.a.y0.k.g.a
    @CallSuper
    public void d0() {
        this.f52191a = 1;
        if (isPlaying() || !w0()) {
            return;
        }
        H0(false);
        start();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public Context getContext() {
        return this.f52193c;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public int getCurrentPosition() {
        return x0().getCurrentPosition();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public int getDuration() {
        return x0().getDuration();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public int getVideoHeight() {
        return x0().getVideoHeight();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public int getVideoSarDen() {
        return this.n;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public int getVideoSarNum() {
        return this.m;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public int getVideoWidth() {
        return x0().getVideoWidth();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void h0(int i2) {
        if (x) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i2);
        }
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void i0(@NonNull a.InterfaceC0976a interfaceC0976a) {
        this.f52199i = interfaceC0976a;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public boolean isPlaying() {
        return x0().isPlaying();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void k(boolean z) {
        if (x) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.k = z;
        if (z) {
            o0();
        } else {
            E0();
        }
        x0().muteOrUnmuteAudio(z);
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String k0() {
        return this.f52196f;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void n0() {
    }

    public final void o0() {
        if (this.f52197g == null) {
            this.f52197g = (AudioManager) this.f52193c.getSystemService("audio");
        }
        AudioManager audioManager = this.f52197g;
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.w);
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void pause() {
        if (x) {
            Log.d("SwanInlineCyberWidget", this.f52196f + "-" + hashCode() + " pause()");
        }
        x0().pause();
        G0(false);
        H0(false);
        a.InterfaceC0976a interfaceC0976a = this.f52199i;
        if (interfaceC0976a != null) {
            interfaceC0976a.c(c());
        }
    }

    @Override // d.a.l0.a.y0.k.g.a
    public boolean prepareAsync() {
        E0();
        x0().prepareAsync();
        return true;
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void release() {
        if (x) {
            Log.d("SwanInlineCyberWidget", this.f52196f + " release()");
        }
        a.InterfaceC0976a interfaceC0976a = this.f52199i;
        if (interfaceC0976a != null) {
            interfaceC0976a.onRelease(c());
        }
        o0();
        d.a.l0.a.u.e.o.k.e().q(c());
        x0().release();
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void seekTo(int i2) {
        x0().seekTo(i2);
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void setSpeed(float f2) {
        x0().setSpeed(f2);
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void setSurface(Surface surface) {
        x0().setSurface(surface);
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void start() {
        if (x) {
            Log.d("SwanInlineCyberWidget", this.f52196f + "-" + hashCode() + " start()");
        }
        if (y0()) {
            if (x) {
                Log.e("SwanInlineCyberWidget", this.f52196f + "-" + hashCode() + " start ignored, widget is in background");
            }
            H0(true);
            a.InterfaceC0976a interfaceC0976a = this.f52199i;
            if (interfaceC0976a != null) {
                interfaceC0976a.c(c());
                return;
            }
            return;
        }
        E0();
        x0().start();
        G0(true);
        a.InterfaceC0976a interfaceC0976a2 = this.f52199i;
        if (interfaceC0976a2 != null) {
            interfaceC0976a2.e(c());
        }
    }

    public final boolean w0() {
        return this.j;
    }

    public final synchronized CyberPlayer x0() {
        if (this.f52195e == null) {
            if (d.a.l0.a.c1.a.Z().D()) {
                if (x) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                }
                this.f52195e = new CyberPlayer(0);
            } else {
                if (x) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                }
                this.f52195e = new CyberPlayer(0);
            }
            this.f52195e.setOnPreparedListener(this.p);
            this.f52195e.setOnVideoSizeChangedListener(this.v);
            this.f52195e.setOnCompletionListener(this.r);
            this.f52195e.setOnErrorListener(this.q);
            this.f52195e.setOnInfoListener(this.s);
            this.f52195e.setOnBufferingUpdateListener(this.t);
            this.f52195e.setOnSeekCompleteListener(this.u);
            if (x) {
                Log.d("SwanInlineCyberWidget", "create " + this.f52195e.hashCode() + " player");
            }
        }
        return this.f52195e;
    }

    public final boolean y0() {
        if (this.f52191a == -1) {
            SwanAppActivity x2 = d.a.l0.a.a2.d.g().x();
            if (x2 == null) {
                if (x) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                }
                return true;
            }
            d.a.l0.a.t0.c frame = x2.getFrame();
            if (frame == null) {
                if (x) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                }
                return true;
            }
            if (x) {
                StringBuilder sb = new StringBuilder();
                sb.append("check background by frame lifeState, background ? ");
                sb.append(!frame.P().hasStarted());
                Log.v("SwanInlineCyberWidget", sb.toString());
            }
            return !frame.P().hasStarted();
        }
        if (x) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("check background by kernel state, background ? ");
            sb2.append(this.f52191a == 0);
            Log.v("SwanInlineCyberWidget", sb2.toString());
        }
        return this.f52191a == 0;
    }

    public void z0() {
        String a2 = this.o.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (x) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + a2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        a.InterfaceC0976a interfaceC0976a = this.f52199i;
        if (interfaceC0976a != null) {
            interfaceC0976a.d(a2);
        }
    }
}
