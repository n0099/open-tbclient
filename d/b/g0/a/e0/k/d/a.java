package d.b.g0.a.e0.k.d;

import android.util.Log;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebKitFactory;
import d.b.g0.a.k;
import d.b.g0.a.p.d.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a implements h {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43916h = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.b.g0.a.e0.k.d.b> f43917a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f43918b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43919c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f43920d;

    /* renamed from: e  reason: collision with root package name */
    public int f43921e;

    /* renamed from: f  reason: collision with root package name */
    public c f43922f;

    /* renamed from: g  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f43923g;

    /* renamed from: d.b.g0.a.e0.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0649a implements c {
        public C0649a() {
        }

        @Override // d.b.g0.a.e0.k.d.a.c
        public void a() {
            try {
                a.this.f43918b.lock();
                a.this.f43920d = true;
                a.this.j();
                a.this.p();
            } finally {
                a.this.f43918b.unlock();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements WebKitFactory.IForceInitZeusListener {
        public b() {
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusFinish(boolean z) {
            try {
                a.this.f43918b.lock();
                a.this.f43919c = true;
                a.this.p();
                a.this.f43918b.unlock();
                BdSailor.getInstance().removeForceInitListener(a.this.f43923g);
            } catch (Throwable th) {
                a.this.f43918b.unlock();
                throw th;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            if (a.f43916h) {
                Log.d("NgWebViewInitHelper", "onForceInitZeusStart");
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f43926a = new a(null);
    }

    public /* synthetic */ a(C0649a c0649a) {
        this();
    }

    public static a k() {
        return d.f43926a;
    }

    @Override // d.b.g0.a.p.d.h
    public void a(d.b.g0.a.e0.k.d.b bVar) {
        try {
            this.f43918b.lock();
            if (bVar != null && this.f43917a.contains(bVar)) {
                this.f43917a.remove(bVar);
            }
        } finally {
            this.f43918b.unlock();
        }
    }

    @Override // d.b.g0.a.p.d.h
    public void b(d.b.g0.a.e0.k.d.b bVar) {
        try {
            this.f43918b.lock();
            if (bVar == null) {
                return;
            }
            if (!this.f43917a.contains(bVar)) {
                this.f43917a.add(bVar);
            }
            if (n()) {
                p();
            }
        } finally {
            this.f43918b.unlock();
        }
    }

    public final synchronized void j() {
        if (this.f43921e == -1) {
            d.b.g0.a.w0.a.N().getSwitch("swan_enable_file_in_io", 0);
            this.f43921e = 0;
        }
        if (!ProcessUtils.isMainProcess() && this.f43921e == 1) {
            WebSettingsGlobalBlink.setFileInIOEnabled(true);
        }
    }

    public void l() {
        m(false);
    }

    public void m(boolean z) {
        d.b.g0.a.w0.a.f().a(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
        if (o() != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        boolean z;
        try {
            this.f43918b.lock();
            if (f43916h) {
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.f43920d);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.f43919c + " ,isZeusForceInited: " + o());
            }
            if (this.f43920d) {
                if (!this.f43919c) {
                }
                z = true;
                return z;
            }
            z = false;
            return z;
        } finally {
            this.f43918b.unlock();
        }
    }

    public final boolean o() {
        if (f43916h) {
            Log.d("NgWebViewInitHelper", "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit());
            Log.d("NgWebViewInitHelper", "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited());
        }
        return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
    }

    public final void p() {
        try {
            this.f43918b.lock();
            if (n()) {
                Iterator<d.b.g0.a.e0.k.d.b> it = this.f43917a.iterator();
                while (it.hasNext()) {
                    d.b.g0.a.e0.k.d.b next = it.next();
                    if (next != null) {
                        next.a();
                    }
                }
                this.f43917a.clear();
            }
        } finally {
            this.f43918b.unlock();
        }
    }

    public a() {
        this.f43917a = new ArrayList<>();
        this.f43918b = new ReentrantLock();
        this.f43919c = false;
        this.f43920d = false;
        this.f43921e = -1;
        this.f43922f = new C0649a();
        b bVar = new b();
        this.f43923g = bVar;
        BdSailor.addForceInitListener(bVar);
        d.b.g0.a.w0.a.f().h(this.f43922f);
    }
}
