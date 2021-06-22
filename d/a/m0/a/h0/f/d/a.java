package d.a.m0.a.h0.f.d;

import android.util.Log;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.m0.a.k;
import d.a.m0.a.p.e.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a implements h {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45750g = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.m0.a.h0.f.d.b> f45751a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f45752b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f45753c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45754d;

    /* renamed from: e  reason: collision with root package name */
    public c f45755e;

    /* renamed from: f  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f45756f;

    /* renamed from: d.a.m0.a.h0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0705a implements c {
        public C0705a() {
        }

        @Override // d.a.m0.a.h0.f.d.a.c
        public void a() {
            try {
                a.this.f45752b.lock();
                a.this.f45754d = true;
                a.this.j();
                a.this.p();
            } finally {
                a.this.f45752b.unlock();
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
                a.this.f45752b.lock();
                a.this.f45753c = true;
                a.this.p();
                a.this.f45752b.unlock();
                BdSailor.getInstance().removeForceInitListener(a.this.f45756f);
            } catch (Throwable th) {
                a.this.f45752b.unlock();
                throw th;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            if (a.f45750g) {
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
        public static final a f45759a = new a(null);
    }

    public /* synthetic */ a(C0705a c0705a) {
        this();
    }

    public static a k() {
        return d.f45759a;
    }

    @Override // d.a.m0.a.p.e.h
    public void a(d.a.m0.a.h0.f.d.b bVar) {
        try {
            this.f45752b.lock();
            if (bVar != null && this.f45751a.contains(bVar)) {
                this.f45751a.remove(bVar);
            }
        } finally {
            this.f45752b.unlock();
        }
    }

    @Override // d.a.m0.a.p.e.h
    public void b(d.a.m0.a.h0.f.d.b bVar) {
        try {
            this.f45752b.lock();
            if (bVar == null) {
                return;
            }
            if (!this.f45751a.contains(bVar)) {
                this.f45751a.add(bVar);
            }
            if (n()) {
                p();
            }
        } finally {
            this.f45752b.unlock();
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
        d.a.m0.a.c1.a.f().d(z);
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
            this.f45752b.lock();
            if (f45750g) {
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.f45754d);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.f45753c + " ,isZeusForceInited: " + o());
            }
            if (this.f45754d) {
                if (!this.f45753c) {
                }
                z = true;
                return z;
            }
            z = false;
            return z;
        } finally {
            this.f45752b.unlock();
        }
    }

    public final boolean o() {
        if (f45750g) {
            Log.d("NgWebViewInitHelper", "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit());
            Log.d("NgWebViewInitHelper", "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited());
        }
        return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
    }

    public final void p() {
        try {
            this.f45752b.lock();
            if (n()) {
                Iterator<d.a.m0.a.h0.f.d.b> it = this.f45751a.iterator();
                while (it.hasNext()) {
                    d.a.m0.a.h0.f.d.b next = it.next();
                    if (next != null) {
                        next.a();
                    }
                }
                this.f45751a.clear();
            }
        } finally {
            this.f45752b.unlock();
        }
    }

    public a() {
        this.f45751a = new ArrayList<>();
        this.f45752b = new ReentrantLock();
        this.f45753c = false;
        this.f45754d = false;
        this.f45755e = new C0705a();
        b bVar = new b();
        this.f45756f = bVar;
        BdSailor.addForceInitListener(bVar);
        d.a.m0.a.c1.a.f().h(this.f45755e);
    }
}
