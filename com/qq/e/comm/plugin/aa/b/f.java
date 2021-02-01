package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.bg;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class f extends TextureView implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, e, bg.a {
    private String A;
    private AtomicBoolean B;
    private boolean C;
    private int D;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f11674a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f11675b;
    private SurfaceTexture c;
    private volatile MediaPlayer d;
    private AudioManager e;
    private Surface f;
    private int g;
    private int h;
    private AtomicBoolean i;
    private AtomicBoolean j;
    private AtomicBoolean k;
    private AtomicBoolean l;
    private AtomicBoolean m;
    private AtomicBoolean n;
    private volatile int o;
    private AtomicBoolean p;
    private com.qq.e.comm.plugin.aa.b.b q;
    private a r;
    private d s;
    private c t;
    private long u;
    private int v;
    private int w;
    private Handler x;
    private Handler y;
    private HandlerThread z;

    /* loaded from: classes15.dex */
    public interface a {
        void a();

        void a(int i, Exception exc);

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static volatile b f11691a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayBlockingQueue<WeakReference<f>> f11692b;
        private int c = -1;

        private b() {
            this.f11692b = null;
            this.f11692b = new ArrayBlockingQueue<>(16);
        }

        public static b a() {
            if (f11691a == null) {
                synchronized (b.class) {
                    try {
                        if (f11691a == null) {
                            f11691a = new b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f11691a;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int b() {
            int i;
            int i2 = 5;
            if (this.c >= 0) {
                return this.c;
            }
            SM sm = GDTADManager.getInstance().getSM();
            if (sm != null) {
                String string = sm.getString("maxCachedPlayerCount");
                GDTLogger.d("player cache count str = " + string);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        i = Integer.parseInt(string);
                    } catch (Exception e) {
                        GDTLogger.e(e.getMessage());
                    }
                    if (i >= 0) {
                        GDTLogger.i("player cache count = " + i + ", set to default: 5");
                    } else {
                        i2 = i;
                    }
                    this.c = i2;
                    return i2;
                }
            }
            i = 5;
            if (i >= 0) {
            }
            this.c = i2;
            return i2;
        }

        public boolean a(f fVar) {
            if (fVar == null) {
                GDTLogger.e("view == null, return");
                return false;
            }
            int b2 = b();
            if (b2 == 0) {
                GDTLogger.d("maxCount == 0, return");
                return false;
            }
            if (this.f11692b.size() == b()) {
                WeakReference<f> poll = this.f11692b.poll();
                if (poll != null) {
                    f fVar2 = poll.get();
                    if (fVar2 != null) {
                        GDTLogger.e(fVar2.hashCode() + "'s player will be released, maxCacheCount = " + b2);
                        fVar2.m();
                    } else {
                        GDTLogger.d("player is released, remove it");
                    }
                } else {
                    GDTLogger.e("queue is empty, why?!");
                }
            }
            boolean offer = this.f11692b.offer(new WeakReference<>(fVar));
            GDTLogger.d(fVar.hashCode() + " add to cache, result = " + offer + ", size = " + this.f11692b.size());
            return offer;
        }

        public boolean b(f fVar) {
            WeakReference<f> weakReference;
            if (fVar == null) {
                return false;
            }
            Iterator<WeakReference<f>> it = this.f11692b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    weakReference = null;
                    break;
                }
                weakReference = it.next();
                if (fVar == weakReference.get()) {
                    break;
                }
            }
            if (weakReference == null) {
                GDTLogger.d(fVar.hashCode() + " not in cache");
                return false;
            }
            boolean remove = this.f11692b.remove(weakReference);
            GDTLogger.d(fVar.hashCode() + " removed from cache, result = " + remove + ", size = " + this.f11692b.size());
            return remove;
        }
    }

    /* loaded from: classes15.dex */
    public enum c {
        DEFAULT,
        CROP,
        CENTER_CROP
    }

    /* loaded from: classes15.dex */
    public enum d {
        ERROR,
        UNINITIALIZED,
        PREPARED,
        PLAY,
        STOP,
        PAUSE,
        END
    }

    public f(Context context) {
        super(context);
        this.c = null;
        this.d = null;
        this.f = null;
        this.i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.s = d.UNINITIALIZED;
        this.t = c.DEFAULT;
        this.u = 0L;
        this.v = 0;
        this.w = 0;
        this.B = new AtomicBoolean(false);
        this.C = false;
        this.D = 0;
        this.z = new HandlerThread(f.class.getSimpleName());
        this.z.start();
        this.x = new bg(this, this.z.getLooper());
        this.y = new Handler();
        this.x.sendEmptyMessage(6);
        setSurfaceTextureListener(this);
    }

    private void A() {
        b.a().b(this);
        if (this.d != null) {
            this.d.reset();
            this.d.release();
            this.d = null;
            this.s = d.UNINITIALIZED;
            this.c = null;
        }
        this.z.quit();
    }

    private void B() {
        if (this.d != null) {
            this.d.reset();
            this.d.release();
            this.d = null;
            this.s = d.UNINITIALIZED;
            this.B.set(true);
            this.i.set(false);
        }
    }

    private void C() {
        GDTLogger.d(hashCode() + " reInit");
        o();
        if (this.D > 0) {
            a(this.D);
        }
        float f = this.m.get() ? 0.0f : 1.0f;
        this.d.setVolume(f, f);
        if (this.A == null) {
            GDTLogger.e(hashCode() + " reInit failed, path is null");
            return;
        }
        try {
            this.d.setDataSource(this.A);
            this.i.set(true);
            u();
        } catch (Exception e) {
            GDTLogger.e(e.getMessage());
        }
    }

    private void D() {
        if (this.m.get() || this.s != d.PLAY || this.e == null) {
            return;
        }
        this.e.requestAudioFocus(null, 3, 2);
    }

    private void E() {
        if (this.e != null) {
            this.e.abandonAudioFocus(null);
        }
    }

    private void b(int i) {
        try {
            if (t()) {
                this.d.seekTo(i);
                this.n.set(false);
                this.o = 0;
                return;
            }
        } catch (Exception e) {
            GDTLogger.w("MediaPlayer can not seek");
            e.printStackTrace();
        }
        this.n.set(true);
        this.o = i;
    }

    private void b(String str) {
        p();
        try {
            this.d.setDataSource(str);
            this.i.set(true);
            this.A = str;
            u();
        } catch (Exception e) {
            GDTLogger.d(e.getMessage());
            this.s = d.ERROR;
            u.a(30112, 0, null);
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.r != null) {
                        f.this.r.a(5003, e);
                    }
                }
            });
        }
    }

    private void b(boolean z, boolean z2) {
        if (this.s == d.UNINITIALIZED) {
            GDTLogger.d("stop() was called but video is not initialized.");
        } else if (this.s == d.PREPARED) {
            GDTLogger.d("stop() was called but video is just prepared, not playing.");
        } else if (this.s == d.STOP) {
            GDTLogger.d("stop() was called but video already stopped.");
        } else if (this.s == d.END) {
            GDTLogger.d("stop() was called but video already ended.");
        } else if (this.s == d.ERROR) {
            GDTLogger.d("stop() was called but video already encountered error.");
        } else if (this.d == null) {
            GDTLogger.d("stop() was called but MediaPlayer is null.");
        } else {
            this.s = d.STOP;
            E();
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.3
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.r != null) {
                        f.this.r.d();
                    }
                }
            });
            if (z || this.d.isPlaying()) {
                this.d.seekTo(z2 ? 0 : e());
                this.d.pause();
                r();
            }
            if (z) {
                this.C = false;
            }
        }
    }

    private void o() {
        p();
        this.e = (AudioManager) getContext().getSystemService("audio");
        this.d.setOnPreparedListener(this);
        this.d.setOnCompletionListener(this);
        this.d.setOnErrorListener(this);
        this.d.setOnSeekCompleteListener(this);
        this.d.setOnVideoSizeChangedListener(this);
    }

    private void p() {
        this.k.set(false);
        if (this.d == null) {
            this.d = new MediaPlayer();
        } else {
            this.d.reset();
        }
        this.l.set(false);
        this.n.set(false);
        this.o = 0;
        this.s = d.UNINITIALIZED;
    }

    private void q() {
        if (this.q != null) {
            this.q.a(this);
        }
    }

    private void r() {
        this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.q != null) {
                    f.this.q.d();
                }
            }
        });
    }

    private void s() {
        this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.6
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.q != null) {
                    f.this.q.c();
                }
            }
        });
    }

    private boolean t() {
        return (this.d == null || this.s == d.ERROR || this.s == d.UNINITIALIZED) ? false : true;
    }

    private void u() {
        try {
            if (this.d != null) {
                this.d.prepareAsync();
            }
        } catch (IllegalArgumentException e) {
            GDTLogger.d(e.getMessage());
        } catch (IllegalStateException e2) {
            GDTLogger.d(e2.getMessage());
        } catch (SecurityException e3) {
            GDTLogger.d(e3.getMessage());
        }
    }

    private void v() {
        if (!this.i.get()) {
            GDTLogger.d("play() was called but video data source was not set.");
            return;
        }
        this.l.set(true);
        if (!this.k.get()) {
            GDTLogger.d("play() was called but video is not prepared yet, waiting.");
        } else if (!this.j.get()) {
            GDTLogger.d("play() was called but SurfaceTexture is not available yet, waiting.");
        } else if (this.s == d.PLAY) {
            GDTLogger.d("play() was called but video is already playing.");
        } else if (this.d == null) {
            GDTLogger.d("play() was called but MediaPlayer is null.");
        } else if (this.C || this.s == d.PAUSE) {
            GDTLogger.d("play() was called but video is paused, resuming.");
            this.s = d.PLAY;
            this.C = false;
            this.d.start();
            D();
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.12
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.r != null) {
                        f.this.r.f();
                    }
                }
            });
        } else if (this.s == d.END || this.s == d.STOP) {
            GDTLogger.d("play() was called but video already ended/stopped, starting over.");
            b(this.A);
            this.l.set(true);
        } else {
            this.s = d.PLAY;
            D();
            this.d.start();
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.13
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.r != null) {
                        f.this.r.b();
                        float f = f.this.m.get() ? 0.0f : 1.0f;
                        if (f.this.d == null || f.this.s == d.ERROR) {
                            return;
                        }
                        try {
                            f.this.d.setVolume(f, f);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    private void w() {
        if (this.s == d.UNINITIALIZED) {
            GDTLogger.d("pause() was called but video is not initialized.");
        } else if (this.s == d.PREPARED) {
            GDTLogger.d("pause() was called but video is just prepared, not playing.");
        } else if (this.s == d.PAUSE) {
            GDTLogger.d("pause() was called but video already paused.");
        } else if (this.s == d.STOP) {
            GDTLogger.d("pause() was called but video already stopped.");
        } else if (this.s == d.END) {
            GDTLogger.d("pause() was called but video already ended.");
        } else if (this.d == null) {
            GDTLogger.d("pause() was called but MediaPlayer is null.");
        } else {
            this.s = d.PAUSE;
            if (this.d.isPlaying()) {
                this.C = true;
                this.d.pause();
            }
            E();
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.2
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.r != null) {
                        f.this.r.e();
                    }
                }
            });
        }
    }

    private void x() {
        try {
            if (this.d == null || this.s == d.ERROR || this.m.get()) {
                return;
            }
            GDTLogger.d("Set volume off.");
            this.d.setVolume(0.0f, 0.0f);
            this.m.set(true);
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.4
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.q != null) {
                        f.this.q.e();
                    }
                }
            });
            E();
        } catch (Exception e) {
            GDTLogger.w("MediaPlayer set volume off error");
            e.printStackTrace();
        }
    }

    private void y() {
        try {
            if (this.d == null || this.s == d.ERROR || !this.m.get()) {
                return;
            }
            GDTLogger.d("Set volume on.");
            this.d.setVolume(1.0f, 1.0f);
            this.m.set(false);
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.5
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.q != null) {
                        f.this.q.e();
                    }
                }
            });
            D();
        } catch (Exception e) {
            GDTLogger.w("MediaPlayer set volume on error");
            e.printStackTrace();
        }
    }

    private void z() {
        if (this.c == null) {
            GDTLogger.d("SurfaceTexture is not available, can't open video.");
        } else if (this.d == null) {
            GDTLogger.d("MediaPlayer is null, can't open video.");
        } else {
            if (this.f == null) {
                this.f = new Surface(this.c);
            }
            this.d.setSurface(this.f);
            this.j.set(true);
            if (this.i.get() && this.l.get() && this.k.get()) {
                GDTLogger.d("SurfaceTexture is available and play() was called.");
                b();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public void a() {
        this.x.sendEmptyMessage(2);
    }

    public void a(int i) {
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.arg1 = i;
        this.x.sendMessage(obtain);
    }

    public void a(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    @Override // com.qq.e.comm.plugin.util.bg.a
    public void a(Message message) {
        switch (message.what) {
            case 1:
                v();
                return;
            case 2:
                w();
                return;
            case 3:
                b(message.arg1 == 1, message.arg2 == 1);
                return;
            case 4:
                B();
                return;
            case 5:
                C();
                return;
            case 6:
                o();
                return;
            case 7:
                b(String.valueOf(message.obj));
                return;
            case 8:
                x();
                return;
            case 9:
                y();
                return;
            case 10:
                b(message.arg1);
                return;
            case 11:
                z();
                return;
            case 12:
                A();
                return;
            default:
                return;
        }
    }

    public void a(com.qq.e.comm.plugin.aa.b.b bVar) {
        this.q = bVar;
        r();
        q();
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public void a(a aVar) {
        this.r = aVar;
    }

    public void a(c cVar) {
        this.t = cVar;
    }

    public void a(String str) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = str;
        this.x.sendMessage(obtain);
    }

    public void a(boolean z, boolean z2) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = z ? 1 : 0;
        obtain.arg2 = z2 ? 1 : 0;
        this.x.sendMessage(obtain);
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public void b() {
        this.x.sendEmptyMessage(1);
    }

    public void b(boolean z) {
        this.p.set(z);
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public boolean c() {
        try {
            if (!t() || this.d == null) {
                return false;
            }
            return this.d.isPlaying();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public boolean d() {
        return this.m.get();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        n();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public int e() {
        try {
            if (t() && this.k.get()) {
                return this.d.getDuration();
            }
        } catch (Exception e) {
            GDTLogger.w("MediaPlayer can not get Duration");
            e.printStackTrace();
        }
        return 0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0022 -> B:7:0x0010). Please submit an issue!!! */
    @Override // com.qq.e.comm.plugin.aa.b.e
    public int f() {
        try {
            if (t()) {
                return this.s == d.END ? e() : this.d.getCurrentPosition();
            }
        } catch (Exception e) {
            GDTLogger.w("MediaPlayer get current position error");
            e.printStackTrace();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public d g() {
        return this.s;
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public void h() {
        this.x.sendEmptyMessage(8);
    }

    @Override // com.qq.e.comm.plugin.aa.b.e
    public void i() {
        this.x.sendEmptyMessage(9);
    }

    public void j() {
        this.x.sendEmptyMessage(3);
    }

    public String k() {
        return this.A;
    }

    public void l() {
        GDTLogger.d(hashCode() + " free");
        this.x.sendEmptyMessage(12);
    }

    public void m() {
        this.x.sendEmptyMessage(4);
    }

    public void n() {
        if (System.currentTimeMillis() - this.u < 100) {
            return;
        }
        this.u = System.currentTimeMillis();
        if (this.q == null || this.p.get()) {
            return;
        }
        if (this.q.isShown()) {
            r();
        } else {
            s();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d(hashCode() + " attached");
        b.a().b(this);
        if (this.B.get()) {
            this.x.sendEmptyMessage(5);
            this.B.set(false);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.s != d.END) {
            this.s = d.END;
            GDTLogger.d("Video is ended.");
            E();
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.8
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.r != null) {
                        f.this.r.c();
                    }
                }
            });
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d(hashCode() + " detach");
        this.D = f();
        if (this.d != null) {
            b.a().a(this);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
        u.a(30112, i, null);
        if (this.s != d.ERROR) {
            this.s = d.ERROR;
            GDTLogger.e("Video encountered error, what = " + i + ", extra = " + i2);
            E();
            this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.10
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.r != null) {
                        f.this.r.a(i, new Exception(i2 + ""));
                    }
                }
            });
            return true;
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(this.f11674a, i);
        int defaultSize2 = getDefaultSize(this.f11675b, i2);
        if (this.f11674a > 0 && this.f11675b > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (this.t == c.CROP && (size != 0 || size2 != 0)) {
                if (this.f11675b * size < this.f11674a * size2 || size == 0) {
                    size = (this.f11674a * size2) / this.f11675b;
                } else if (this.f11675b * size > this.f11674a * size2 || size2 == 0) {
                    size2 = (this.f11675b * size) / this.f11674a;
                }
                int b2 = ak.b(getContext());
                int c2 = ak.c(getContext());
                if (size > c2) {
                    size = b2;
                }
                if (size2 > c2) {
                    size2 = c2;
                }
            } else if (this.t == c.CENTER_CROP) {
                float f = (defaultSize * 1.0f) / this.f11674a;
                float f2 = (defaultSize2 * 1.0f) / this.f11675b;
                float max = Math.max(f, f2);
                Matrix matrix = new Matrix(getMatrix());
                matrix.setScale(max / f, max / f2, defaultSize / 2, defaultSize2 / 2);
                setTransform(matrix);
                size = defaultSize;
                size2 = defaultSize2;
            } else if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f11674a * size2 < this.f11675b * size) {
                    size = (this.f11674a * size2) / this.f11675b;
                } else if (this.f11674a * size2 > this.f11675b * size) {
                    size2 = (this.f11675b * size) / this.f11674a;
                }
            } else if (mode == 1073741824) {
                int i4 = (this.f11675b * size) / this.f11674a;
                if (mode2 != Integer.MIN_VALUE || i4 <= size2) {
                    size2 = i4;
                }
            } else if (mode2 == 1073741824) {
                i3 = (this.f11674a * size2) / this.f11675b;
                if (mode == Integer.MIN_VALUE) {
                    if (i3 <= size) {
                        size = i3;
                    }
                }
                size = i3;
            } else {
                i3 = this.f11674a;
                int i5 = this.f11675b;
                if (mode2 != Integer.MIN_VALUE || i5 <= size2) {
                    size2 = i5;
                } else {
                    i3 = (this.f11674a * size2) / this.f11675b;
                }
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    size2 = (this.f11675b * size) / this.f11674a;
                }
                size = i3;
            }
            defaultSize = size;
            defaultSize2 = size2;
        } else if (SDKStatus.getSDKVersionCode() >= 13 && this.g > 0 && this.h > 0) {
            defaultSize = View.MeasureSpec.getSize(i);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (this.h * defaultSize < this.g * defaultSize2 || defaultSize2 == 0) {
                defaultSize2 = (this.h * defaultSize) / this.g;
            } else if (this.h * defaultSize > this.g * defaultSize2 || defaultSize == 0) {
                defaultSize = (this.g * defaultSize2) / this.h;
            }
        }
        if (SDKStatus.getSDKVersionCode() >= 13 && this.q != null && (this.q instanceof com.qq.e.comm.plugin.gdtnativead.a.c) && (defaultSize != this.v || defaultSize2 != this.w)) {
            this.v = defaultSize;
            this.w = defaultSize2;
            ((com.qq.e.comm.plugin.gdtnativead.a.c) this.q).a(defaultSize, defaultSize2);
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.s = d.PREPARED;
        this.k.set(true);
        GDTLogger.d("Video is prepared.");
        this.f11674a = mediaPlayer.getVideoWidth();
        this.f11675b = mediaPlayer.getVideoHeight();
        this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.9
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.r != null) {
                    f.this.r.a();
                }
            }
        });
        if (this.n.get()) {
            GDTLogger.d("Player is prepared and seekTo() was called.");
            a(this.o);
        }
        if (this.l.get() && this.j.get()) {
            GDTLogger.d("Player is prepared and play() was called.");
            b();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        GDTLogger.d("onSeekComplete: " + mediaPlayer.getCurrentPosition());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        GDTLogger.d("onSurfaceTextureAvailable");
        if (this.c == null) {
            this.c = surfaceTexture;
        } else if (Build.VERSION.SDK_INT >= 16) {
            setSurfaceTexture(this.c);
        } else {
            this.c.release();
            this.c = surfaceTexture;
            if (this.f != null) {
                this.f.release();
            }
            this.f = new Surface(this.c);
        }
        this.x.sendEmptyMessage(11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        GDTLogger.d("onSurfaceTextureDestroyed");
        this.l.set(false);
        this.j.set(false);
        return this.c == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.c = surfaceTexture;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f11674a = mediaPlayer.getVideoWidth();
        this.f11675b = mediaPlayer.getVideoHeight();
        if (this.f11674a == 0 || this.f11675b == 0) {
            return;
        }
        this.y.post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.f.11
            @Override // java.lang.Runnable
            public void run() {
                f.this.requestLayout();
            }
        });
    }
}
