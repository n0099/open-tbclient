package d.b.g0.s.i.a.b;

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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.b.g0.a.i2.b0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.s0.d;
import d.b.g0.a.s0.k.g.a;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class a implements d.b.g0.a.s0.k.g.a {
    public static final boolean v = d.b.g0.a.k.f45051a;
    public static boolean w = true;

    /* renamed from: b  reason: collision with root package name */
    public String f49360b;

    /* renamed from: c  reason: collision with root package name */
    public Context f49361c;

    /* renamed from: d  reason: collision with root package name */
    public ZeusPluginFactory.Invoker f49362d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayer f49363e;

    /* renamed from: f  reason: collision with root package name */
    public String f49364f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f49365g;

    /* renamed from: h  reason: collision with root package name */
    public String f49366h;
    public a.InterfaceC0793a i;

    /* renamed from: a  reason: collision with root package name */
    public int f49359a = -1;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public d.b.g0.s.j.a.c.a m = new d.b.g0.s.j.a.c.a();
    public final CyberPlayerManager.OnPreparedListener n = new f();
    public final CyberPlayerManager.OnErrorListener o = new g();
    public final CyberPlayerManager.OnCompletionListener p = new h();
    public final CyberPlayerManager.OnInfoListener q = new i();
    public final CyberPlayerManager.OnBufferingUpdateListener r = new j();
    public final CyberPlayerManager.OnSeekCompleteListener s = new k();
    public final CyberPlayerManager.OnVideoSizeChangedListener t = new C1032a();
    public final AudioManager.OnAudioFocusChangeListener u = new b(this);

    /* renamed from: d.b.g0.s.i.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1032a implements CyberPlayerManager.OnVideoSizeChangedListener {
        public C1032a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.m.f49393e = i;
            a.this.m.f49394f = i2;
            a.InterfaceC0793a interfaceC0793a = a.this.i;
            if (interfaceC0793a != null) {
                interfaceC0793a.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public b(a aVar) {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (a.v) {
                Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange " + i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f49368a;

        public c(a aVar, d.a aVar2) {
            this.f49368a = aVar2;
        }

        @Override // d.b.g0.s.i.a.b.a.l
        public void a(boolean z) {
            this.f49368a.a(z);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f49369a;

        public d(l lVar) {
            this.f49369a = lVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            if (a.v) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
            }
            boolean unused = a.w = false;
            l lVar = this.f49369a;
            if (lVar != null) {
                lVar.a(false);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            if (a.v) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
            }
            boolean unused = a.w = false;
            l lVar = this.f49369a;
            if (lVar != null) {
                lVar.a(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49370e;

        public e(a aVar, boolean z) {
            this.f49370e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity n;
            Window window;
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y == null || (n = y.n()) == null || (window = n.getWindow()) == null) {
                return;
            }
            try {
                if (this.f49370e) {
                    window.addFlags(128);
                } else {
                    window.clearFlags(128);
                }
            } catch (Exception e2) {
                if (a.v) {
                    throw new RuntimeException("inline video set screenOn/Off in wrong thread", e2);
                }
            }
            if (a.v) {
                Log.d("SwanInlineCyberWidget", "setKeepScreenOn: " + this.f49370e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public f() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.m.f49393e = a.this.getVideoWidth();
            a.this.m.f49394f = a.this.getVideoHeight();
            a.InterfaceC0793a interfaceC0793a = a.this.i;
            if (interfaceC0793a != null) {
                interfaceC0793a.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements CyberPlayerManager.OnErrorListener {
        public g() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.g0();
            a.this.p0(i);
            int i3 = i == -10000 ? 0 : i;
            a.InterfaceC0793a interfaceC0793a = a.this.i;
            if (interfaceC0793a != null) {
                interfaceC0793a.onError(i3);
            }
            a.this.r0(i, i2, obj2);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements CyberPlayerManager.OnCompletionListener {
        public h() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.g0();
            a aVar = a.this;
            a.InterfaceC0793a interfaceC0793a = aVar.i;
            if (interfaceC0793a != null) {
                if (z) {
                    interfaceC0793a.onEnded();
                } else {
                    interfaceC0793a.b(aVar.c());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements CyberPlayerManager.OnInfoListener {
        public i() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.v) {
                String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.m.f49390b = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.m.f49389a = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.m.f49391c = i2;
                    break;
            }
            a.this.p0(i);
            a.this.i.c(i);
            if (i == 904) {
                a.this.s0();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements CyberPlayerManager.OnBufferingUpdateListener {
        public j() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements CyberPlayerManager.OnSeekCompleteListener {
        public k() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(boolean z);
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f49362d = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.f49364f = (String) obj;
            }
        }
        this.f49361c = d.b.g0.a.w0.a.c();
        this.f49366h = str;
    }

    public static String q0(String str) {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        return (!d.b.g0.a.a2.b.m(str) || y == null) ? str : d.b.g0.a.a2.b.p(str, y);
    }

    public static void w0(@NonNull Context context, @Nullable l lVar) {
        if (w) {
            if (v) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), d.b.g0.a.w0.a.O().c(context), null, 7, null, null, new d(lVar));
            return;
        }
        if (v) {
            Log.v("【CyberCallback】", "CyberPlayer播放内核已安装，无需重复安装");
        }
        if (lVar != null) {
            lVar.a(true);
        }
    }

    @Override // d.b.g0.a.s0.k.g.a
    @CallSuper
    public void H() {
        this.f49359a = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            v0(true);
        }
    }

    @Override // d.b.g0.a.s0.k.g.a
    @CallSuper
    public void Q() {
        this.f49359a = 1;
        if (isPlaying() || !l0()) {
            return;
        }
        v0(false);
        start();
    }

    @Override // d.b.g0.a.s0.d
    public void T(@NonNull d.a aVar) {
        w0(d.b.g0.a.w0.a.c(), new c(this, aVar));
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void U(boolean z) {
        if (z) {
            ZeusPluginFactory.Invoker invoker = this.f49362d;
            if (invoker != null) {
                m0().changeProxyDynamic((String) invoker.get("Proxy"), true);
                return;
            }
            return;
        }
        m0().changeProxyDynamic(null, false);
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void Y(int i2) {
        if (v) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i2);
        }
    }

    @Override // d.b.g0.a.s0.k.g.a
    public int a() {
        return 0;
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void a0(@NonNull a.InterfaceC0793a interfaceC0793a) {
        this.i = interfaceC0793a;
    }

    @Override // d.b.g0.a.s0.d
    @Nullable
    public String b() {
        return this.f49366h;
    }

    @Override // d.b.g0.a.s0.k.g.a
    public String c() {
        return this.f49364f + "-" + hashCode();
    }

    @Override // d.b.g0.a.s0.d
    @Nullable
    public String c0() {
        return this.f49364f;
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void d0(int i2) {
        if (v) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i2);
        }
    }

    public final void g0() {
        if (this.f49365g == null) {
            this.f49365g = (AudioManager) this.f49361c.getSystemService("audio");
        }
        AudioManager audioManager = this.f49365g;
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.u);
    }

    @Override // d.b.g0.a.s0.k.g.a
    public Context getContext() {
        return this.f49361c;
    }

    @Override // d.b.g0.a.s0.k.g.a
    public int getCurrentPosition() {
        return m0().getCurrentPosition();
    }

    @Override // d.b.g0.a.s0.k.g.a
    public int getDuration() {
        return m0().getDuration();
    }

    @Override // d.b.g0.a.s0.k.g.a
    public int getVideoHeight() {
        return m0().getVideoHeight();
    }

    @Override // d.b.g0.a.s0.k.g.a
    public int getVideoWidth() {
        return m0().getVideoWidth();
    }

    @Override // d.b.g0.a.s0.k.g.a
    public boolean isPlaying() {
        return m0().isPlaying();
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void k(int i2, int i3, int i4, int i5) {
    }

    public final boolean l0() {
        return this.j;
    }

    public final synchronized CyberPlayer m0() {
        if (this.f49363e == null) {
            if (d.b.g0.a.w0.a.N().u()) {
                if (v) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                }
                this.f49363e = new CyberPlayer(0);
            } else {
                if (v) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                }
                this.f49363e = new CyberPlayer(0);
            }
            this.f49363e.setOnPreparedListener(this.n);
            this.f49363e.setOnVideoSizeChangedListener(this.t);
            this.f49363e.setOnCompletionListener(this.p);
            this.f49363e.setOnErrorListener(this.o);
            this.f49363e.setOnInfoListener(this.q);
            this.f49363e.setOnBufferingUpdateListener(this.r);
            this.f49363e.setOnSeekCompleteListener(this.s);
            if (v) {
                Log.d("SwanInlineCyberWidget", "create " + this.f49363e.hashCode() + " player");
            }
        }
        return this.f49363e;
    }

    @Override // d.b.g0.a.s0.k.g.a
    public boolean n(String str, String str2, String str3, boolean z) {
        if (v) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.l = true;
        this.f49360b = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(ImageSource.FILE_SCHEME)) {
            str = str.substring(8);
        }
        String q0 = q0(str);
        ZeusPluginFactory.Invoker invoker = this.f49362d;
        if (invoker != null) {
            String str4 = (String) invoker.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                m0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                m0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                m0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                m0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
            }
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Cookie", str2);
        }
        if (z) {
            hashMap.put("x-hide-urls-from-log", "true");
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("User-Agent", str3);
        }
        String b2 = b0.b();
        if (!TextUtils.isEmpty(b2) && b0.c(q0)) {
            if (v) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + b2);
            }
            hashMap.put("Referer", b2);
        }
        m0().setDataSource(this.f49361c, Uri.parse(q0), hashMap);
        return true;
    }

    public final boolean n0() {
        if (this.f49359a == -1) {
            SwanAppActivity n = d.b.g0.a.r1.d.e().n();
            if (n == null) {
                if (v) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                }
                return true;
            }
            d.b.g0.a.o0.c frame = n.getFrame();
            if (frame == null) {
                if (v) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                }
                return true;
            }
            if (v) {
                StringBuilder sb = new StringBuilder();
                sb.append("check background by frame lifeState, background ? ");
                sb.append(!frame.N().hasStarted());
                Log.v("SwanInlineCyberWidget", sb.toString());
            }
            return !frame.N().hasStarted();
        }
        if (v) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("check background by kernel state, background ? ");
            sb2.append(this.f49359a == 0);
            Log.v("SwanInlineCyberWidget", sb2.toString());
        }
        return this.f49359a == 0;
    }

    @Override // d.b.g0.a.s0.k.g.a
    public boolean o() {
        return this.l;
    }

    public void o0() {
        String a2 = this.m.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (v) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + a2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        a.InterfaceC0793a interfaceC0793a = this.i;
        if (interfaceC0793a != null) {
            interfaceC0793a.d(a2);
        }
    }

    public final void p0(int i2) {
        a.InterfaceC0793a interfaceC0793a;
        int b2 = d.b.g0.s.j.a.b.a.b(i2);
        if (v) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i2 + ", statusCode " + b2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        if (b2 != 100) {
            if (b2 == 2101 && (interfaceC0793a = this.i) != null) {
                interfaceC0793a.a(2102);
            }
            a.InterfaceC0793a interfaceC0793a2 = this.i;
            if (interfaceC0793a2 != null) {
                interfaceC0793a2.a(b2);
            }
        }
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void pause() {
        if (v) {
            Log.d("SwanInlineCyberWidget", this.f49364f + "-" + hashCode() + " pause()");
        }
        m0().pause();
        u0(false);
        v0(false);
        a.InterfaceC0793a interfaceC0793a = this.i;
        if (interfaceC0793a != null) {
            interfaceC0793a.b(c());
        }
    }

    @Override // d.b.g0.a.s0.k.g.a
    public boolean prepareAsync() {
        t0();
        m0().prepareAsync();
        return true;
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void r(boolean z) {
        if (v) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.k = z;
        if (z) {
            g0();
        } else {
            t0();
        }
        m0().muteOrUnmuteAudio(z);
    }

    public abstract void r0(int i2, int i3, String str);

    @Override // d.b.g0.a.s0.k.g.a
    public void release() {
        if (v) {
            Log.d("SwanInlineCyberWidget", this.f49364f + " release()");
        }
        a.InterfaceC0793a interfaceC0793a = this.i;
        if (interfaceC0793a != null) {
            interfaceC0793a.onRelease(c());
        }
        g0();
        d.b.g0.a.t.c.m.j.c().m(c());
        m0().release();
    }

    public abstract void s0();

    @Override // d.b.g0.a.s0.k.g.a
    public void seekTo(int i2) {
        m0().seekTo(i2);
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void setSpeed(float f2) {
        m0().setSpeed(f2);
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void setSurface(Surface surface) {
        m0().setSurface(surface);
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void start() {
        if (v) {
            Log.d("SwanInlineCyberWidget", this.f49364f + "-" + hashCode() + " start()");
        }
        if (n0()) {
            if (v) {
                Log.e("SwanInlineCyberWidget", this.f49364f + "-" + hashCode() + " start ignored, widget is in background");
            }
            v0(true);
            a.InterfaceC0793a interfaceC0793a = this.i;
            if (interfaceC0793a != null) {
                interfaceC0793a.b(c());
                return;
            }
            return;
        }
        t0();
        m0().start();
        u0(true);
        a.InterfaceC0793a interfaceC0793a2 = this.i;
        if (interfaceC0793a2 != null) {
            interfaceC0793a2.e(c());
        }
    }

    @Override // d.b.g0.a.s0.k.g.a
    public a.InterfaceC0793a t() {
        return this.i;
    }

    public final void t0() {
        if (this.k) {
            if (v) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.f49365g == null) {
            this.f49365g = (AudioManager) this.f49361c.getSystemService("audio");
        }
        AudioManager audioManager = this.f49365g;
        if (audioManager == null) {
            return;
        }
        try {
            audioManager.requestAudioFocus(this.u, 3, 1);
        } catch (Exception e2) {
            if (v) {
                e2.printStackTrace();
            }
        }
    }

    public final void u0(boolean z) {
        k0.T(new e(this, z));
    }

    public final void v0(boolean z) {
        this.j = z;
    }
}
