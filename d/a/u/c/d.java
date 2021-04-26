package d.a.u.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.gldraw2d.params.MirrorType;
import d.a.u.c.g.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class d {
    public static final String u = "d";
    public static volatile int v = 0;
    public static volatile boolean w = false;
    public static volatile d x;

    /* renamed from: b  reason: collision with root package name */
    public Context f64047b;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f64049d;

    /* renamed from: h  reason: collision with root package name */
    public d.a.u.c.g.d f64053h;

    /* renamed from: i  reason: collision with root package name */
    public e f64054i;
    public HandlerC1744d j;
    public d.a.u.c.g.e k;
    public f l;
    public d.a.u.c.f.a m;
    public d.a.u.c.g.c n;
    public d.a.u.c.f.b p;
    public d.a.u.c.g.c q;
    public ArrayList<d.a.u.b.g.c> s;
    public int t;

    /* renamed from: a  reason: collision with root package name */
    public int f64046a = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64048c = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64050e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64051f = false;

    /* renamed from: g  reason: collision with root package name */
    public long f64052g = 0;
    public volatile boolean o = false;
    public volatile boolean r = false;

    /* loaded from: classes2.dex */
    public class a implements d.a.u.c.g.c {
        public a() {
        }

        @Override // d.a.u.c.g.c
        public void a(boolean z) {
            d.this.p.v();
            d.this.p = null;
            d.this.q = null;
            d.this.v(2, z);
        }

        @Override // d.a.u.c.g.c
        public void b(boolean z) {
            if (z) {
                d.this.p.x();
            }
        }

        @Override // d.a.u.c.g.c
        public void c(boolean z) {
        }

        @Override // d.a.u.c.g.c
        public void d(boolean z) {
            d.this.r = z;
            d.this.u(2, z);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.u.c.g.c {
        public b() {
        }

        @Override // d.a.u.c.g.c
        public void a(boolean z) {
            d.this.m.p();
            d.this.m = null;
            d.this.n = null;
            d.this.v(4, z);
        }

        @Override // d.a.u.c.g.c
        public void b(boolean z) {
            if (z) {
                d.this.m.r();
            }
        }

        @Override // d.a.u.c.g.c
        public void c(boolean z) {
            boolean unused = d.w = z;
        }

        @Override // d.a.u.c.g.c
        public void d(boolean z) {
            d.this.o = z;
            d.this.u(4, z);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements f {
        public c() {
        }

        @Override // d.a.u.c.g.f
        public void a(boolean z) {
            d.this.u(1, z);
        }

        @Override // d.a.u.c.g.f
        public void b(boolean z) {
            if (Build.VERSION.SDK_INT >= 18) {
                d.this.k.d();
                d.this.k = null;
            }
            d.this.l = null;
            d.this.v(1, z);
        }
    }

    /* renamed from: d.a.u.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1744d extends Handler {
        public HandlerC1744d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 7001:
                    if (d.this.f64054i != null) {
                        d.this.f64054i.a(((Boolean) message.obj).booleanValue());
                    }
                    d.this.f64050e = false;
                    break;
                case 7002:
                    if (d.this.f64054i != null) {
                        d.this.f64054i.d(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.f64054i != null) {
                        d.this.f64054i.c(((Boolean) message.obj).booleanValue(), d.this.f64053h != null ? d.this.f64053h.f() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.f64054i != null) {
                        d.this.f64054i.b(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.R();
                    break;
                case 7006:
                    d.this.f64050e = false;
                    d.this.U();
                    break;
            }
            super.handleMessage(message);
        }
    }

    public static void K() {
        x = null;
    }

    public static void N(int i2) {
        v = i2;
    }

    public static void O(boolean z) {
        w = z;
    }

    public static d x() {
        if (x == null) {
            synchronized (d.class) {
                if (x == null) {
                    x = new d();
                }
            }
        }
        return x;
    }

    public final void A() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.k = new d.a.u.c.g.e();
        }
        if (this.f64053h.o()) {
            this.m = new d.a.u.c.f.a();
        } else {
            w = true;
        }
        this.p = new d.a.u.c.f.b();
        this.f64046a = 0;
        if (!this.f64048c && this.f64049d == null) {
            HandlerThread handlerThread = new HandlerThread(u);
            this.f64049d = handlerThread;
            handlerThread.start();
        }
        HandlerC1744d handlerC1744d = this.j;
        if (handlerC1744d == null) {
            if (this.f64049d != null) {
                this.j = new HandlerC1744d(this.f64049d.getLooper());
            } else {
                this.j = new HandlerC1744d(this.f64047b.getMainLooper());
            }
        } else {
            handlerC1744d.removeCallbacksAndMessages(null);
        }
        this.f64053h.h();
    }

    public final synchronized boolean B() {
        int i2;
        String str = u;
        Log.i(str, "isMovieRecordStarted sMovieRecordState = " + v);
        i2 = (v ^ 1) ^ 2;
        if (this.f64053h != null) {
            if (this.f64053h.o()) {
                i2 ^= 4;
            }
        }
        return i2 == 0;
    }

    public final synchronized boolean C() {
        return v == 0;
    }

    public final boolean D() {
        d.a.u.c.g.d dVar = this.f64053h;
        if (dVar == null) {
            return false;
        }
        if (dVar.o()) {
            if (this.f64046a == 3) {
                return true;
            }
        } else if (this.f64046a == 2) {
            return true;
        }
        return false;
    }

    public final boolean E() {
        return this.f64046a == 0;
    }

    public void F(ByteBuffer byteBuffer, int i2, long j) {
        d.a.u.c.f.a aVar;
        if (this.o && (aVar = this.m) != null && aVar.o()) {
            this.m.g(byteBuffer, i2, j);
        }
    }

    public void G() {
        ArrayList<d.a.u.b.g.c> arrayList = this.s;
        if (arrayList != null) {
            arrayList.clear();
            this.s = null;
        }
        this.f64047b = null;
        this.f64053h = null;
        N(0);
        K();
        HandlerC1744d handlerC1744d = this.j;
        if (handlerC1744d != null) {
            handlerC1744d.removeCallbacksAndMessages(null);
            this.j = null;
        }
        HandlerThread handlerThread = this.f64049d;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64049d = null;
        }
    }

    public void H(long j) {
        d.a.u.c.f.b bVar = this.p;
        if (bVar != null && bVar.t() && this.r && w) {
            this.p.i(j);
        }
    }

    public void I() {
        d.a.u.c.f.b bVar = this.p;
        if (bVar != null) {
            bVar.u();
        }
    }

    public final boolean J() {
        boolean z;
        d.a.u.c.f.a aVar = this.m;
        if (aVar == null || !aVar.o()) {
            z = true;
        } else {
            Log.e(u, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.m.s();
            this.m.p();
            z = false;
        }
        d.a.u.c.f.b bVar = this.p;
        if (bVar != null && bVar.t()) {
            Log.e(u, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.p.y();
            this.p.v();
            z = false;
        }
        d.a.u.c.g.d dVar = this.f64053h;
        if (dVar == null || this.k.b(dVar.f(), this.f64053h.g(), this.l)) {
            return z;
        }
        Log.e(u, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    public final void L() {
        String str = u;
        Log.i(str, "restartRecorder mRestartTried = " + this.f64051f);
        HandlerC1744d handlerC1744d = this.j;
        if (handlerC1744d != null) {
            this.f64051f = true;
            handlerC1744d.sendMessageDelayed(handlerC1744d.obtainMessage(7005), 500L);
        }
    }

    public final void M(int i2, boolean z) {
        if (z) {
            v = i2 | v;
        }
        this.f64046a++;
    }

    public final void P() {
        d.a.u.c.f.a aVar = this.m;
        if (aVar != null) {
            aVar.q(this.f64053h, this.k, this.n);
        }
    }

    public final void Q() {
        HandlerC1744d handlerC1744d = this.j;
        if (handlerC1744d != null) {
            handlerC1744d.sendMessageDelayed(handlerC1744d.obtainMessage(7001, Boolean.FALSE), 500L);
        }
    }

    public final void R() {
        A();
        z();
        if (J()) {
            P();
            T();
        } else if (!this.f64051f) {
            L();
        } else {
            Q();
        }
    }

    public void S(Context context, d.a.u.c.g.d dVar, e eVar) {
        String str = u;
        Log.i(str, "startRecorder mStarting = " + this.f64050e);
        if (this.f64050e) {
            Q();
            return;
        }
        this.f64050e = true;
        this.f64047b = context;
        this.f64053h = dVar;
        this.f64054i = eVar;
        R();
    }

    public final void T() {
        Y();
        this.p.w(this.s, this.f64053h, this.k, this.q);
    }

    public void U() {
        HandlerC1744d handlerC1744d;
        String str = u;
        Log.i(str, "stopRecorder mStarting = " + this.f64050e);
        if (this.f64050e) {
            if (!B() && (handlerC1744d = this.j) != null) {
                handlerC1744d.sendMessage(handlerC1744d.obtainMessage(7004, 4002));
            }
            Log.d(u, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            HandlerC1744d handlerC1744d2 = this.j;
            if (handlerC1744d2 != null) {
                handlerC1744d2.sendMessageDelayed(handlerC1744d2.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.o = false;
        this.r = false;
        this.f64052g = 0L;
        d.a.u.c.f.a aVar = this.m;
        if (aVar != null && aVar.o()) {
            this.m.s();
        }
        d.a.u.c.f.b bVar = this.p;
        if (bVar != null && bVar.t()) {
            this.p.y();
        }
        O(false);
    }

    public void V(long j) {
        this.f64052g *= 1000000;
        e eVar = this.f64054i;
        if (eVar != null) {
            eVar.d(j);
        }
    }

    public void W(d.a.u.b.g.c cVar) {
        X(cVar, true);
    }

    public void X(d.a.u.b.g.c cVar, boolean z) {
        if (this.p != null) {
            t(cVar, z);
            this.p.z(this.s);
        }
    }

    public final void Y() {
        Z();
    }

    public final void Z() {
        ArrayList<d.a.u.b.g.c> arrayList = this.s;
        if (arrayList == null) {
            return;
        }
        Iterator<d.a.u.b.g.c> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.u.b.g.a d2 = it.next().d();
            if (d2.e() == MirrorType.NO_MIRROR) {
                d2.j(-this.t);
            } else {
                d2.j(this.t);
            }
        }
    }

    public void s(d.a.u.b.g.c cVar) {
        t(cVar, true);
    }

    public void t(d.a.u.b.g.c cVar, boolean z) {
        if (cVar == null || cVar.g() == null) {
            return;
        }
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (this.s.get(i3).e() == cVar.e()) {
                i2 = i3;
            }
        }
        if (i2 >= 0 && i2 < this.s.size()) {
            if (this.s.get(i2).g() == cVar.g()) {
                return;
            }
            this.s.remove(i2);
        }
        if (z) {
            this.s.add(cVar.clone());
        } else {
            this.s.add(cVar);
        }
        Collections.sort(this.s);
    }

    public final synchronized void u(int i2, boolean z) {
        String str = u;
        Log.i(str, "checkMovieRecordStartState condition = " + i2 + " && state = " + z);
        M(i2, z);
        String str2 = u;
        Log.i(str2, "checkMovieRecordStartState sMovieRecordState = " + v);
        if (D()) {
            this.j.sendMessage(this.j.obtainMessage(7001, Boolean.valueOf(B())));
        }
    }

    public final synchronized void v(int i2, boolean z) {
        String str = u;
        Log.i(str, "checkMovieRecordStopState condition = " + i2 + " && state = " + z);
        w(i2, z);
        String str2 = u;
        Log.i(str2, "checkMovieRecordStopState sMovieRecordState = " + v);
        if (E() && this.j != null) {
            this.j.sendMessage(this.j.obtainMessage(7003, Boolean.valueOf(C())));
        }
    }

    public final void w(int i2, boolean z) {
        if (z) {
            v = i2 ^ v;
        }
        this.f64046a--;
    }

    public long y() {
        d.a.u.c.f.b bVar = this.p;
        if (bVar != null) {
            return bVar.j();
        }
        return 0L;
    }

    public final void z() {
        this.q = new a();
        this.n = new b();
        this.l = new c();
    }
}
