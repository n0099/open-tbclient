package d.a.l0.w;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.l0.n.l.b;
import d.a.l0.t.d;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements d.a.l0.n.l.b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f52267c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f52268d = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public int f52269a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f52270b;

    /* loaded from: classes3.dex */
    public class a implements WebKitFactory.WebkitInstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52271a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f52272b;

        /* renamed from: d.a.l0.w.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1150a implements Runnable {
            public RunnableC1150a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.j(cVar.f52270b);
            }
        }

        public a(String str, File file) {
            this.f52271a = str;
            this.f52272b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            if (d.A(this.f52271a, str)) {
                synchronized (c.f52268d) {
                    c.this.i(new b(AppRuntime.getAppContext()).q());
                }
                return;
            }
            if (c.e(c.this) <= 2) {
                boolean z = true;
                if (8 == i2) {
                    c.this.f52270b = this.f52271a;
                } else {
                    c cVar = c.this;
                    cVar.f52270b = this.f52271a + File.pathSeparator + c.this.f52269a;
                    if (d.f(this.f52272b, new File(c.this.f52270b)) != this.f52272b.length()) {
                        z = false;
                    }
                }
                if (z && d.a.l0.a.a2.d.i().postDelayed(new RunnableC1150a(), 1000L)) {
                    return;
                }
            }
            if (8 == i2) {
                d.j(this.f52271a);
            }
            synchronized (c.f52268d) {
                c.this.i(false);
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
        }
    }

    public static /* synthetic */ int e(c cVar) {
        int i2 = cVar.f52269a + 1;
        cVar.f52269a = i2;
        return i2;
    }

    @Override // d.a.l0.n.l.b
    public void a(String str, b.a aVar) {
        synchronized (f52268d) {
            f52268d.add(aVar);
            if (f52267c) {
                return;
            }
            f52267c = true;
            j(str);
        }
    }

    public final void i(boolean z) {
        synchronized (f52268d) {
            for (b.a aVar : f52268d) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
            f52268d.clear();
            f52267c = false;
            this.f52269a = 0;
        }
    }

    public final void j(String str) {
        if (TextUtils.isEmpty(str)) {
            synchronized (f52268d) {
                i(false);
            }
            return;
        }
        File file = new File(str);
        if (!file.isFile()) {
            synchronized (f52268d) {
                i(false);
            }
            return;
        }
        WebKitFactory.installAsync("file://" + str, new a(str, file));
    }
}
