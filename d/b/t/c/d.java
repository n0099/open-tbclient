package d.b.t.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.gldraw2d.params.MirrorType;
import d.b.t.c.g.f;
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
    public Context f65432b;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f65434d;

    /* renamed from: h  reason: collision with root package name */
    public d.b.t.c.g.d f65438h;
    public e i;
    public HandlerC1785d j;
    public d.b.t.c.g.e k;
    public f l;
    public d.b.t.c.f.a m;
    public d.b.t.c.g.c n;
    public d.b.t.c.f.b p;
    public d.b.t.c.g.c q;
    public ArrayList<d.b.t.b.g.c> s;
    public int t;

    /* renamed from: a  reason: collision with root package name */
    public int f65431a = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65433c = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f65435e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65436f = false;

    /* renamed from: g  reason: collision with root package name */
    public long f65437g = 0;
    public volatile boolean o = false;
    public volatile boolean r = false;

    /* loaded from: classes2.dex */
    public class a implements d.b.t.c.g.c {
        public a() {
        }

        @Override // d.b.t.c.g.c
        public void a(boolean z) {
            d.this.p.v();
            d.this.p = null;
            d.this.q = null;
            d.this.v(2, z);
        }

        @Override // d.b.t.c.g.c
        public void b(boolean z) {
        }

        @Override // d.b.t.c.g.c
        public void c(boolean z) {
            if (z) {
                d.this.p.x();
            }
        }

        @Override // d.b.t.c.g.c
        public void d(boolean z) {
            d.this.r = z;
            d.this.u(2, z);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.t.c.g.c {
        public b() {
        }

        @Override // d.b.t.c.g.c
        public void a(boolean z) {
            d.this.m.p();
            d.this.m = null;
            d.this.n = null;
            d.this.v(4, z);
        }

        @Override // d.b.t.c.g.c
        public void b(boolean z) {
            boolean unused = d.w = z;
        }

        @Override // d.b.t.c.g.c
        public void c(boolean z) {
            if (z) {
                d.this.m.r();
            }
        }

        @Override // d.b.t.c.g.c
        public void d(boolean z) {
            d.this.o = z;
            d.this.u(4, z);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements f {
        public c() {
        }

        @Override // d.b.t.c.g.f
        public void a(boolean z) {
            d.this.u(1, z);
        }

        @Override // d.b.t.c.g.f
        public void b(boolean z) {
            if (Build.VERSION.SDK_INT >= 18) {
                d.this.k.d();
                d.this.k = null;
            }
            d.this.l = null;
            d.this.v(1, z);
        }
    }

    /* renamed from: d.b.t.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1785d extends Handler {
        public HandlerC1785d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 7001:
                    if (d.this.i != null) {
                        d.this.i.d(((Boolean) message.obj).booleanValue());
                    }
                    d.this.f65435e = false;
                    break;
                case 7002:
                    if (d.this.i != null) {
                        d.this.i.c(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.i != null) {
                        d.this.i.b(((Boolean) message.obj).booleanValue(), d.this.f65438h != null ? d.this.f65438h.f() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.i != null) {
                        d.this.i.a(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.R();
                    break;
                case 7006:
                    d.this.f65435e = false;
                    d.this.U();
                    break;
            }
            super.handleMessage(message);
        }
    }

    public static void K() {
        x = null;
    }

    public static void N(int i) {
        v = i;
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
            this.k = new d.b.t.c.g.e();
        }
        if (this.f65438h.o()) {
            this.m = new d.b.t.c.f.a();
        } else {
            w = true;
        }
        this.p = new d.b.t.c.f.b();
        this.f65431a = 0;
        if (!this.f65433c && this.f65434d == null) {
            HandlerThread handlerThread = new HandlerThread(u);
            this.f65434d = handlerThread;
            handlerThread.start();
        }
        HandlerC1785d handlerC1785d = this.j;
        if (handlerC1785d == null) {
            if (this.f65434d != null) {
                this.j = new HandlerC1785d(this.f65434d.getLooper());
            } else {
                this.j = new HandlerC1785d(this.f65432b.getMainLooper());
            }
        } else {
            handlerC1785d.removeCallbacksAndMessages(null);
        }
        this.f65438h.h();
    }

    public final synchronized boolean B() {
        int i;
        String str = u;
        Log.i(str, "isMovieRecordStarted sMovieRecordState = " + v);
        i = (v ^ 1) ^ 2;
        if (this.f65438h != null) {
            if (this.f65438h.o()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    public final synchronized boolean C() {
        return v == 0;
    }

    public final boolean D() {
        d.b.t.c.g.d dVar = this.f65438h;
        if (dVar == null) {
            return false;
        }
        if (dVar.o()) {
            if (this.f65431a == 3) {
                return true;
            }
        } else if (this.f65431a == 2) {
            return true;
        }
        return false;
    }

    public final boolean E() {
        return this.f65431a == 0;
    }

    public void F(ByteBuffer byteBuffer, int i, long j) {
        d.b.t.c.f.a aVar;
        if (this.o && (aVar = this.m) != null && aVar.o()) {
            this.m.g(byteBuffer, i, j);
        }
    }

    public void G() {
        ArrayList<d.b.t.b.g.c> arrayList = this.s;
        if (arrayList != null) {
            arrayList.clear();
            this.s = null;
        }
        this.f65432b = null;
        this.f65438h = null;
        N(0);
        K();
        HandlerC1785d handlerC1785d = this.j;
        if (handlerC1785d != null) {
            handlerC1785d.removeCallbacksAndMessages(null);
            this.j = null;
        }
        HandlerThread handlerThread = this.f65434d;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f65434d = null;
        }
    }

    public void H(long j) {
        d.b.t.c.f.b bVar = this.p;
        if (bVar != null && bVar.t() && this.r && w) {
            this.p.i(j);
        }
    }

    public void I() {
        d.b.t.c.f.b bVar = this.p;
        if (bVar != null) {
            bVar.u();
        }
    }

    public final boolean J() {
        boolean z;
        d.b.t.c.f.a aVar = this.m;
        if (aVar == null || !aVar.o()) {
            z = true;
        } else {
            Log.e(u, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.m.s();
            this.m.p();
            z = false;
        }
        d.b.t.c.f.b bVar = this.p;
        if (bVar != null && bVar.t()) {
            Log.e(u, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.p.y();
            this.p.v();
            z = false;
        }
        d.b.t.c.g.d dVar = this.f65438h;
        if (dVar == null || this.k.b(dVar.f(), this.f65438h.g(), this.l)) {
            return z;
        }
        Log.e(u, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    public final void L() {
        String str = u;
        Log.i(str, "restartRecorder mRestartTried = " + this.f65436f);
        HandlerC1785d handlerC1785d = this.j;
        if (handlerC1785d != null) {
            this.f65436f = true;
            handlerC1785d.sendMessageDelayed(handlerC1785d.obtainMessage(7005), 500L);
        }
    }

    public final void M(int i, boolean z) {
        if (z) {
            v = i | v;
        }
        this.f65431a++;
    }

    public final void P() {
        d.b.t.c.f.a aVar = this.m;
        if (aVar != null) {
            aVar.q(this.f65438h, this.k, this.n);
        }
    }

    public final void Q() {
        HandlerC1785d handlerC1785d = this.j;
        if (handlerC1785d != null) {
            handlerC1785d.sendMessageDelayed(handlerC1785d.obtainMessage(7001, Boolean.FALSE), 500L);
        }
    }

    public final void R() {
        A();
        z();
        if (J()) {
            P();
            T();
        } else if (!this.f65436f) {
            L();
        } else {
            Q();
        }
    }

    public void S(Context context, d.b.t.c.g.d dVar, e eVar) {
        String str = u;
        Log.i(str, "startRecorder mStarting = " + this.f65435e);
        if (this.f65435e) {
            Q();
            return;
        }
        this.f65435e = true;
        this.f65432b = context;
        this.f65438h = dVar;
        this.i = eVar;
        R();
    }

    public final void T() {
        Y();
        this.p.w(this.s, this.f65438h, this.k, this.q);
    }

    public void U() {
        HandlerC1785d handlerC1785d;
        String str = u;
        Log.i(str, "stopRecorder mStarting = " + this.f65435e);
        if (this.f65435e) {
            if (!B() && (handlerC1785d = this.j) != null) {
                handlerC1785d.sendMessage(handlerC1785d.obtainMessage(7004, 4002));
            }
            Log.d(u, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            HandlerC1785d handlerC1785d2 = this.j;
            if (handlerC1785d2 != null) {
                handlerC1785d2.sendMessageDelayed(handlerC1785d2.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.o = false;
        this.r = false;
        this.f65437g = 0L;
        d.b.t.c.f.a aVar = this.m;
        if (aVar != null && aVar.o()) {
            this.m.s();
        }
        d.b.t.c.f.b bVar = this.p;
        if (bVar != null && bVar.t()) {
            this.p.y();
        }
        O(false);
    }

    public void V(long j) {
        this.f65437g *= 1000000;
        e eVar = this.i;
        if (eVar != null) {
            eVar.c(j);
        }
    }

    public void W(d.b.t.b.g.c cVar) {
        X(cVar, true);
    }

    public void X(d.b.t.b.g.c cVar, boolean z) {
        if (this.p != null) {
            t(cVar, z);
            this.p.z(this.s);
        }
    }

    public final void Y() {
        Z();
    }

    public final void Z() {
        ArrayList<d.b.t.b.g.c> arrayList = this.s;
        if (arrayList == null) {
            return;
        }
        Iterator<d.b.t.b.g.c> it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.t.b.g.a d2 = it.next().d();
            if (d2.e() == MirrorType.NO_MIRROR) {
                d2.j(-this.t);
            } else {
                d2.j(this.t);
            }
        }
    }

    public void s(d.b.t.b.g.c cVar) {
        t(cVar, true);
    }

    public void t(d.b.t.b.g.c cVar, boolean z) {
        if (cVar == null || cVar.g() == null) {
            return;
        }
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        int i = -1;
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            if (this.s.get(i2).e() == cVar.e()) {
                i = i2;
            }
        }
        if (i >= 0 && i < this.s.size()) {
            if (this.s.get(i).g() == cVar.g()) {
                return;
            }
            this.s.remove(i);
        }
        if (z) {
            this.s.add(cVar.clone());
        } else {
            this.s.add(cVar);
        }
        Collections.sort(this.s);
    }

    public final synchronized void u(int i, boolean z) {
        String str = u;
        Log.i(str, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        M(i, z);
        String str2 = u;
        Log.i(str2, "checkMovieRecordStartState sMovieRecordState = " + v);
        if (D()) {
            this.j.sendMessage(this.j.obtainMessage(7001, Boolean.valueOf(B())));
        }
    }

    public final synchronized void v(int i, boolean z) {
        String str = u;
        Log.i(str, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        w(i, z);
        String str2 = u;
        Log.i(str2, "checkMovieRecordStopState sMovieRecordState = " + v);
        if (E() && this.j != null) {
            this.j.sendMessage(this.j.obtainMessage(7003, Boolean.valueOf(C())));
        }
    }

    public final void w(int i, boolean z) {
        if (z) {
            v = i ^ v;
        }
        this.f65431a--;
    }

    public long y() {
        d.b.t.c.f.b bVar = this.p;
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
