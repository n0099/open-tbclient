package d.a.h0.a.e0.k.d;

import android.util.Log;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.h0.a.k;
import d.a.h0.a.p.d.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a implements h {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f41935h = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.h0.a.e0.k.d.b> f41936a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f41937b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f41938c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f41939d;

    /* renamed from: e  reason: collision with root package name */
    public int f41940e;

    /* renamed from: f  reason: collision with root package name */
    public c f41941f;

    /* renamed from: g  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f41942g;

    /* renamed from: d.a.h0.a.e0.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0621a implements c {
        public C0621a() {
        }

        @Override // d.a.h0.a.e0.k.d.a.c
        public void a() {
            try {
                a.this.f41937b.lock();
                a.this.f41939d = true;
                a.this.j();
                a.this.p();
            } finally {
                a.this.f41937b.unlock();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements WebKitFactory.IForceInitZeusListener {
        public b() {
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusFinish(boolean z) {
            try {
                a.this.f41937b.lock();
                a.this.f41938c = true;
                a.this.p();
                a.this.f41937b.unlock();
                BdSailor.getInstance().removeForceInitListener(a.this.f41942g);
            } catch (Throwable th) {
                a.this.f41937b.unlock();
                throw th;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            if (a.f41935h) {
                Log.d("NgWebViewInitHelper", "onForceInitZeusStart");
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f41945a = new a(null);
    }

    public /* synthetic */ a(C0621a c0621a) {
        this();
    }

    public static a k() {
        return d.f41945a;
    }

    @Override // d.a.h0.a.p.d.h
    public void a(d.a.h0.a.e0.k.d.b bVar) {
        try {
            this.f41937b.lock();
            if (bVar != null && this.f41936a.contains(bVar)) {
                this.f41936a.remove(bVar);
            }
        } finally {
            this.f41937b.unlock();
        }
    }

    @Override // d.a.h0.a.p.d.h
    public void b(d.a.h0.a.e0.k.d.b bVar) {
        try {
            this.f41937b.lock();
            if (bVar == null) {
                return;
            }
            if (!this.f41936a.contains(bVar)) {
                this.f41936a.add(bVar);
            }
            if (n()) {
                p();
            }
        } finally {
            this.f41937b.unlock();
        }
    }

    public final synchronized void j() {
        if (this.f41940e == -1) {
            d.a.h0.a.w0.a.N().getSwitch("swan_enable_file_in_io", 0);
            this.f41940e = 0;
        }
        if (!ProcessUtils.isMainProcess() && this.f41940e == 1) {
            WebSettingsGlobalBlink.setFileInIOEnabled(true);
        }
    }

    public void l() {
        m(false);
    }

    public void m(boolean z) {
        d.a.h0.a.w0.a.f().d(z);
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
            this.f41937b.lock();
            if (f41935h) {
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.f41939d);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.f41938c + " ,isZeusForceInited: " + o());
            }
            if (this.f41939d) {
                if (!this.f41938c) {
                }
                z = true;
                return z;
            }
            z = false;
            return z;
        } finally {
            this.f41937b.unlock();
        }
    }

    public final boolean o() {
        if (f41935h) {
            Log.d("NgWebViewInitHelper", "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit());
            Log.d("NgWebViewInitHelper", "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited());
        }
        return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
    }

    public final void p() {
        try {
            this.f41937b.lock();
            if (n()) {
                Iterator<d.a.h0.a.e0.k.d.b> it = this.f41936a.iterator();
                while (it.hasNext()) {
                    d.a.h0.a.e0.k.d.b next = it.next();
                    if (next != null) {
                        next.a();
                    }
                }
                this.f41936a.clear();
            }
        } finally {
            this.f41937b.unlock();
        }
    }

    public a() {
        this.f41936a = new ArrayList<>();
        this.f41937b = new ReentrantLock();
        this.f41938c = false;
        this.f41939d = false;
        this.f41940e = -1;
        this.f41941f = new C0621a();
        b bVar = new b();
        this.f41942g = bVar;
        BdSailor.addForceInitListener(bVar);
        d.a.h0.a.w0.a.f().h(this.f41941f);
    }
}
