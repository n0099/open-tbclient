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
/* loaded from: classes2.dex */
public class a implements h {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44309h = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.b.g0.a.e0.k.d.b> f44310a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f44311b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f44312c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44313d;

    /* renamed from: e  reason: collision with root package name */
    public int f44314e;

    /* renamed from: f  reason: collision with root package name */
    public c f44315f;

    /* renamed from: g  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f44316g;

    /* renamed from: d.b.g0.a.e0.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0662a implements c {
        public C0662a() {
        }

        @Override // d.b.g0.a.e0.k.d.a.c
        public void a() {
            try {
                a.this.f44311b.lock();
                a.this.f44313d = true;
                a.this.j();
                a.this.p();
            } finally {
                a.this.f44311b.unlock();
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
                a.this.f44311b.lock();
                a.this.f44312c = true;
                a.this.p();
                a.this.f44311b.unlock();
                BdSailor.getInstance().removeForceInitListener(a.this.f44316g);
            } catch (Throwable th) {
                a.this.f44311b.unlock();
                throw th;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            if (a.f44309h) {
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
        public static final a f44319a = new a(null);
    }

    public /* synthetic */ a(C0662a c0662a) {
        this();
    }

    public static a k() {
        return d.f44319a;
    }

    @Override // d.b.g0.a.p.d.h
    public void a(d.b.g0.a.e0.k.d.b bVar) {
        try {
            this.f44311b.lock();
            if (bVar != null && this.f44310a.contains(bVar)) {
                this.f44310a.remove(bVar);
            }
        } finally {
            this.f44311b.unlock();
        }
    }

    @Override // d.b.g0.a.p.d.h
    public void b(d.b.g0.a.e0.k.d.b bVar) {
        try {
            this.f44311b.lock();
            if (bVar == null) {
                return;
            }
            if (!this.f44310a.contains(bVar)) {
                this.f44310a.add(bVar);
            }
            if (n()) {
                p();
            }
        } finally {
            this.f44311b.unlock();
        }
    }

    public final synchronized void j() {
        if (this.f44314e == -1) {
            d.b.g0.a.w0.a.N().getSwitch("swan_enable_file_in_io", 0);
            this.f44314e = 0;
        }
        if (!ProcessUtils.isMainProcess() && this.f44314e == 1) {
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
            this.f44311b.lock();
            if (f44309h) {
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.f44313d);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.f44312c + " ,isZeusForceInited: " + o());
            }
            if (this.f44313d) {
                if (!this.f44312c) {
                }
                z = true;
                return z;
            }
            z = false;
            return z;
        } finally {
            this.f44311b.unlock();
        }
    }

    public final boolean o() {
        if (f44309h) {
            Log.d("NgWebViewInitHelper", "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit());
            Log.d("NgWebViewInitHelper", "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited());
        }
        return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
    }

    public final void p() {
        try {
            this.f44311b.lock();
            if (n()) {
                Iterator<d.b.g0.a.e0.k.d.b> it = this.f44310a.iterator();
                while (it.hasNext()) {
                    d.b.g0.a.e0.k.d.b next = it.next();
                    if (next != null) {
                        next.a();
                    }
                }
                this.f44310a.clear();
            }
        } finally {
            this.f44311b.unlock();
        }
    }

    public a() {
        this.f44310a = new ArrayList<>();
        this.f44311b = new ReentrantLock();
        this.f44312c = false;
        this.f44313d = false;
        this.f44314e = -1;
        this.f44315f = new C0662a();
        b bVar = new b();
        this.f44316g = bVar;
        BdSailor.addForceInitListener(bVar);
        d.b.g0.a.w0.a.f().h(this.f44315f);
    }
}
