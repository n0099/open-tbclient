package d.a.i0.w;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.i0.n.l.b;
import d.a.i0.t.d;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements d.a.i0.n.l.b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f48417c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f48418d = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public int f48419a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f48420b;

    /* loaded from: classes3.dex */
    public class a implements WebKitFactory.WebkitInstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f48422b;

        /* renamed from: d.a.i0.w.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1083a implements Runnable {
            public RunnableC1083a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.j(cVar.f48420b);
            }
        }

        public a(String str, File file) {
            this.f48421a = str;
            this.f48422b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            if (d.A(this.f48421a, str)) {
                synchronized (c.f48418d) {
                    c.this.i(new b(AppRuntime.getAppContext()).q());
                }
                return;
            }
            if (c.e(c.this) <= 2) {
                boolean z = true;
                if (8 == i2) {
                    c.this.f48420b = this.f48421a;
                } else {
                    c cVar = c.this;
                    cVar.f48420b = this.f48421a + File.pathSeparator + c.this.f48419a;
                    if (d.f(this.f48422b, new File(c.this.f48420b)) != this.f48422b.length()) {
                        z = false;
                    }
                }
                if (z && d.a.i0.a.a2.d.i().postDelayed(new RunnableC1083a(), 1000L)) {
                    return;
                }
            }
            if (8 == i2) {
                d.j(this.f48421a);
            }
            synchronized (c.f48418d) {
                c.this.i(false);
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
        }
    }

    public static /* synthetic */ int e(c cVar) {
        int i2 = cVar.f48419a + 1;
        cVar.f48419a = i2;
        return i2;
    }

    @Override // d.a.i0.n.l.b
    public void a(String str, b.a aVar) {
        synchronized (f48418d) {
            f48418d.add(aVar);
            if (f48417c) {
                return;
            }
            f48417c = true;
            j(str);
        }
    }

    public final void i(boolean z) {
        synchronized (f48418d) {
            for (b.a aVar : f48418d) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
            f48418d.clear();
            f48417c = false;
            this.f48419a = 0;
        }
    }

    public final void j(String str) {
        if (TextUtils.isEmpty(str)) {
            synchronized (f48418d) {
                i(false);
            }
            return;
        }
        File file = new File(str);
        if (!file.isFile()) {
            synchronized (f48418d) {
                i(false);
            }
            return;
        }
        WebKitFactory.installAsync("file://" + str, new a(str, file));
    }
}
