package d.a.h0.s.i.a.b;

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
import d.a.h0.a.i2.b0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.s0.d;
import d.a.h0.a.s0.k.g.a;
import java.util.HashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public abstract class a implements d.a.h0.a.s0.k.g.a {
    public static final boolean v = d.a.h0.a.k.f43101a;
    public static boolean w = true;

    /* renamed from: b  reason: collision with root package name */
    public String f47613b;

    /* renamed from: c  reason: collision with root package name */
    public Context f47614c;

    /* renamed from: d  reason: collision with root package name */
    public ZeusPluginFactory.Invoker f47615d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayer f47616e;

    /* renamed from: f  reason: collision with root package name */
    public String f47617f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f47618g;

    /* renamed from: h  reason: collision with root package name */
    public String f47619h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC0764a f47620i;

    /* renamed from: a  reason: collision with root package name */
    public int f47612a = -1;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public d.a.h0.s.j.a.c.a m = new d.a.h0.s.j.a.c.a();
    public final CyberPlayerManager.OnPreparedListener n = new f();
    public final CyberPlayerManager.OnErrorListener o = new g();
    public final CyberPlayerManager.OnCompletionListener p = new h();
    public final CyberPlayerManager.OnInfoListener q = new i();
    public final CyberPlayerManager.OnBufferingUpdateListener r = new j();
    public final CyberPlayerManager.OnSeekCompleteListener s = new k();
    public final CyberPlayerManager.OnVideoSizeChangedListener t = new C1003a();
    public final AudioManager.OnAudioFocusChangeListener u = new b(this);

    /* renamed from: d.a.h0.s.i.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1003a implements CyberPlayerManager.OnVideoSizeChangedListener {
        public C1003a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.m.f47647e = i2;
            a.this.m.f47648f = i3;
            a.InterfaceC0764a interfaceC0764a = a.this.f47620i;
            if (interfaceC0764a != null) {
                interfaceC0764a.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public b(a aVar) {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (a.v) {
                Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange " + i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f47622a;

        public c(a aVar, d.a aVar2) {
            this.f47622a = aVar2;
        }

        @Override // d.a.h0.s.i.a.b.a.l
        public void a(boolean z) {
            this.f47622a.a(z);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f47623a;

        public d(l lVar) {
            this.f47623a = lVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            if (a.v) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
            }
            boolean unused = a.w = false;
            l lVar = this.f47623a;
            if (lVar != null) {
                lVar.a(false);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            if (a.v) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
            }
            boolean unused = a.w = false;
            l lVar = this.f47623a;
            if (lVar != null) {
                lVar.a(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47624e;

        public e(a aVar, boolean z) {
            this.f47624e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity v;
            Window window;
            d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
            if (h2 == null || (v = h2.v()) == null || (window = v.getWindow()) == null) {
                return;
            }
            try {
                if (this.f47624e) {
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
                Log.d("SwanInlineCyberWidget", "setKeepScreenOn: " + this.f47624e);
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
            a.this.m.f47647e = a.this.getVideoWidth();
            a.this.m.f47648f = a.this.getVideoHeight();
            a.InterfaceC0764a interfaceC0764a = a.this.f47620i;
            if (interfaceC0764a != null) {
                interfaceC0764a.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements CyberPlayerManager.OnErrorListener {
        public g() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.h0();
            a.this.q0(i2);
            int i4 = i2 == -10000 ? 0 : i2;
            a.InterfaceC0764a interfaceC0764a = a.this.f47620i;
            if (interfaceC0764a != null) {
                interfaceC0764a.onError(i4);
            }
            a.this.s0(i2, i3, obj2);
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
            a.this.h0();
            a aVar = a.this;
            a.InterfaceC0764a interfaceC0764a = aVar.f47620i;
            if (interfaceC0764a != null) {
                if (z) {
                    interfaceC0764a.onEnded();
                } else {
                    interfaceC0764a.c(aVar.b());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements CyberPlayerManager.OnInfoListener {
        public i() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (a.v) {
                String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            switch (i2) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.m.f47644b = i3;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.m.f47643a = i3;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.m.f47645c = i3;
                    break;
            }
            a.this.q0(i2);
            a.this.f47620i.b(i2);
            if (i2 == 904) {
                a.this.t0();
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
        public void onBufferingUpdate(int i2) {
            if (a.v) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
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
        this.f47615d = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.f47617f = (String) obj;
            }
        }
        this.f47614c = d.a.h0.a.w0.a.c();
        this.f47619h = str;
    }

    public static String r0(String str) {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        return (!d.a.h0.a.a2.b.m(str) || h2 == null) ? str : d.a.h0.a.a2.b.p(str, h2);
    }

    public static void x0(@NonNull Context context, @Nullable l lVar) {
        if (w) {
            if (v) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), d.a.h0.a.w0.a.O().f(context), null, 7, null, null, new d(lVar));
            return;
        }
        if (v) {
            Log.v("【CyberCallback】", "CyberPlayer播放内核已安装，无需重复安装");
        }
        if (lVar != null) {
            lVar.a(true);
        }
    }

    @Override // d.a.h0.a.s0.d
    public void A(@NonNull d.a aVar) {
        x0(d.a.h0.a.w0.a.c(), new c(this, aVar));
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void B(boolean z) {
        if (z) {
            ZeusPluginFactory.Invoker invoker = this.f47615d;
            if (invoker != null) {
                n0().changeProxyDynamic((String) invoker.get("Proxy"), true);
                return;
            }
            return;
        }
        n0().changeProxyDynamic(null, false);
    }

    @Override // d.a.h0.a.s0.k.g.a
    public boolean E() {
        u0();
        n0().prepareAsync();
        return true;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void F(int i2) {
        if (v) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i2);
        }
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void J(int i2, int i3, int i4, int i5) {
    }

    @Override // d.a.h0.a.s0.k.g.a
    public boolean L(String str, String str2, String str3, boolean z) {
        if (v) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.l = true;
        this.f47613b = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(ImageSource.FILE_SCHEME)) {
            str = str.substring(8);
        }
        String r0 = r0(str);
        ZeusPluginFactory.Invoker invoker = this.f47615d;
        if (invoker != null) {
            String str4 = (String) invoker.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                n0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                n0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                n0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                n0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        if (!TextUtils.isEmpty(b2) && b0.c(r0)) {
            if (v) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + b2);
            }
            hashMap.put("Referer", b2);
        }
        n0().setDataSource(this.f47614c, Uri.parse(r0), hashMap);
        return true;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public boolean M() {
        return this.l;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public a.InterfaceC0764a N() {
        return this.f47620i;
    }

    @Override // d.a.h0.a.s0.k.g.a
    @CallSuper
    public void S() {
        this.f47612a = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            w0(true);
        }
    }

    @Override // d.a.h0.a.s0.k.g.a
    @CallSuper
    public void Y() {
        this.f47612a = 1;
        if (isPlaying() || !m0()) {
            return;
        }
        w0(false);
        start();
    }

    @Override // d.a.h0.a.s0.d
    @Nullable
    public String a() {
        return this.f47619h;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public String b() {
        return this.f47617f + "-" + hashCode();
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void b0(int i2) {
        if (v) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i2);
        }
    }

    @Override // d.a.h0.a.s0.k.g.a
    public int c() {
        return 0;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void c0(@NonNull a.InterfaceC0764a interfaceC0764a) {
        this.f47620i = interfaceC0764a;
    }

    @Override // d.a.h0.a.s0.d
    @Nullable
    public String e0() {
        return this.f47617f;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public Context getContext() {
        return this.f47614c;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public int getCurrentPosition() {
        return n0().getCurrentPosition();
    }

    @Override // d.a.h0.a.s0.k.g.a
    public int getDuration() {
        return n0().getDuration();
    }

    @Override // d.a.h0.a.s0.k.g.a
    public int getVideoHeight() {
        return n0().getVideoHeight();
    }

    @Override // d.a.h0.a.s0.k.g.a
    public int getVideoWidth() {
        return n0().getVideoWidth();
    }

    public final void h0() {
        if (this.f47618g == null) {
            this.f47618g = (AudioManager) this.f47614c.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        AudioManager audioManager = this.f47618g;
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.u);
    }

    @Override // d.a.h0.a.s0.k.g.a
    public boolean isPlaying() {
        return n0().isPlaying();
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void k(boolean z) {
        if (v) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.k = z;
        if (z) {
            h0();
        } else {
            u0();
        }
        n0().muteOrUnmuteAudio(z);
    }

    public final boolean m0() {
        return this.j;
    }

    public final synchronized CyberPlayer n0() {
        if (this.f47616e == null) {
            if (d.a.h0.a.w0.a.N().G()) {
                if (v) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                }
                this.f47616e = new CyberPlayer(0);
            } else {
                if (v) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                }
                this.f47616e = new CyberPlayer(0);
            }
            this.f47616e.setOnPreparedListener(this.n);
            this.f47616e.setOnVideoSizeChangedListener(this.t);
            this.f47616e.setOnCompletionListener(this.p);
            this.f47616e.setOnErrorListener(this.o);
            this.f47616e.setOnInfoListener(this.q);
            this.f47616e.setOnBufferingUpdateListener(this.r);
            this.f47616e.setOnSeekCompleteListener(this.s);
            if (v) {
                Log.d("SwanInlineCyberWidget", "create " + this.f47616e.hashCode() + " player");
            }
        }
        return this.f47616e;
    }

    public final boolean o0() {
        if (this.f47612a == -1) {
            SwanAppActivity v2 = d.a.h0.a.r1.d.e().v();
            if (v2 == null) {
                if (v) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                }
                return true;
            }
            d.a.h0.a.o0.c frame = v2.getFrame();
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
            sb2.append(this.f47612a == 0);
            Log.v("SwanInlineCyberWidget", sb2.toString());
        }
        return this.f47612a == 0;
    }

    public void p0() {
        String a2 = this.m.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (v) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + a2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        a.InterfaceC0764a interfaceC0764a = this.f47620i;
        if (interfaceC0764a != null) {
            interfaceC0764a.d(a2);
        }
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void pause() {
        if (v) {
            Log.d("SwanInlineCyberWidget", this.f47617f + "-" + hashCode() + " pause()");
        }
        n0().pause();
        v0(false);
        w0(false);
        a.InterfaceC0764a interfaceC0764a = this.f47620i;
        if (interfaceC0764a != null) {
            interfaceC0764a.c(b());
        }
    }

    public final void q0(int i2) {
        a.InterfaceC0764a interfaceC0764a;
        int b2 = d.a.h0.s.j.a.b.a.b(i2);
        if (v) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i2 + ", statusCode " + b2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        if (b2 != 100) {
            if (b2 == 2101 && (interfaceC0764a = this.f47620i) != null) {
                interfaceC0764a.a(2102);
            }
            a.InterfaceC0764a interfaceC0764a2 = this.f47620i;
            if (interfaceC0764a2 != null) {
                interfaceC0764a2.a(b2);
            }
        }
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void release() {
        if (v) {
            Log.d("SwanInlineCyberWidget", this.f47617f + " release()");
        }
        a.InterfaceC0764a interfaceC0764a = this.f47620i;
        if (interfaceC0764a != null) {
            interfaceC0764a.onRelease(b());
        }
        h0();
        d.a.h0.a.t.c.m.j.c().m(b());
        n0().release();
    }

    public abstract void s0(int i2, int i3, String str);

    @Override // d.a.h0.a.s0.k.g.a
    public void seekTo(int i2) {
        n0().seekTo(i2);
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void setSpeed(float f2) {
        n0().setSpeed(f2);
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void setSurface(Surface surface) {
        n0().setSurface(surface);
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void start() {
        if (v) {
            Log.d("SwanInlineCyberWidget", this.f47617f + "-" + hashCode() + " start()");
        }
        if (o0()) {
            if (v) {
                Log.e("SwanInlineCyberWidget", this.f47617f + "-" + hashCode() + " start ignored, widget is in background");
            }
            w0(true);
            a.InterfaceC0764a interfaceC0764a = this.f47620i;
            if (interfaceC0764a != null) {
                interfaceC0764a.c(b());
                return;
            }
            return;
        }
        u0();
        n0().start();
        v0(true);
        a.InterfaceC0764a interfaceC0764a2 = this.f47620i;
        if (interfaceC0764a2 != null) {
            interfaceC0764a2.e(b());
        }
    }

    public abstract void t0();

    public final void u0() {
        if (this.k) {
            if (v) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.f47618g == null) {
            this.f47618g = (AudioManager) this.f47614c.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        AudioManager audioManager = this.f47618g;
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

    public final void v0(boolean z) {
        k0.T(new e(this, z));
    }

    public final void w0(boolean z) {
        this.j = z;
    }
}
