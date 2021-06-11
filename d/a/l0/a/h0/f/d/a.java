package d.a.l0.a.h0.f.d;

import android.util.Log;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.l0.a.k;
import d.a.l0.a.p.e.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a implements h {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45642g = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.l0.a.h0.f.d.b> f45643a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f45644b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f45645c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45646d;

    /* renamed from: e  reason: collision with root package name */
    public c f45647e;

    /* renamed from: f  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f45648f;

    /* renamed from: d.a.l0.a.h0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0702a implements c {
        public C0702a() {
        }

        @Override // d.a.l0.a.h0.f.d.a.c
        public void a() {
            try {
                a.this.f45644b.lock();
                a.this.f45646d = true;
                a.this.j();
                a.this.p();
            } finally {
                a.this.f45644b.unlock();
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
                a.this.f45644b.lock();
                a.this.f45645c = true;
                a.this.p();
                a.this.f45644b.unlock();
                BdSailor.getInstance().removeForceInitListener(a.this.f45648f);
            } catch (Throwable th) {
                a.this.f45644b.unlock();
                throw th;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            if (a.f45642g) {
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
        public static final a f45651a = new a(null);
    }

    public /* synthetic */ a(C0702a c0702a) {
        this();
    }

    public static a k() {
        return d.f45651a;
    }

    @Override // d.a.l0.a.p.e.h
    public void a(d.a.l0.a.h0.f.d.b bVar) {
        try {
            this.f45644b.lock();
            if (bVar != null && this.f45643a.contains(bVar)) {
                this.f45643a.remove(bVar);
            }
        } finally {
            this.f45644b.unlock();
        }
    }

    @Override // d.a.l0.a.p.e.h
    public void b(d.a.l0.a.h0.f.d.b bVar) {
        try {
            this.f45644b.lock();
            if (bVar == null) {
                return;
            }
            if (!this.f45643a.contains(bVar)) {
                this.f45643a.add(bVar);
            }
            if (n()) {
                p();
            }
        } finally {
            this.f45644b.unlock();
        }
    }

    public final synchronized void j() {
        if (!ProcessUtils.isMainProcess()) {
            WebSettingsGlobalBlink.setFileInIOEnabled(true);
        }
    }

    public void l() {
        m(false);
    }

    public void m(boolean z) {
        d.a.l0.a.c1.a.f().d(z);
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
            this.f45644b.lock();
            if (f45642g) {
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.f45646d);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.f45645c + " ,isZeusForceInited: " + o());
            }
            if (this.f45646d) {
                if (!this.f45645c) {
                }
                z = true;
                return z;
            }
            z = false;
            return z;
        } finally {
            this.f45644b.unlock();
        }
    }

    public final boolean o() {
        if (f45642g) {
            Log.d("NgWebViewInitHelper", "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit());
            Log.d("NgWebViewInitHelper", "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited());
        }
        return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
    }

    public final void p() {
        try {
            this.f45644b.lock();
            if (n()) {
                Iterator<d.a.l0.a.h0.f.d.b> it = this.f45643a.iterator();
                while (it.hasNext()) {
                    d.a.l0.a.h0.f.d.b next = it.next();
                    if (next != null) {
                        next.a();
                    }
                }
                this.f45643a.clear();
            }
        } finally {
            this.f45644b.unlock();
        }
    }

    public a() {
        this.f45643a = new ArrayList<>();
        this.f45644b = new ReentrantLock();
        this.f45645c = false;
        this.f45646d = false;
        this.f45647e = new C0702a();
        b bVar = new b();
        this.f45648f = bVar;
        BdSailor.addForceInitListener(bVar);
        d.a.l0.a.c1.a.f().h(this.f45647e);
    }
}
