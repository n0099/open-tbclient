package d.a.m0.w;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.m0.n.l.b;
import d.a.m0.t.d;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements d.a.m0.n.l.b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f52375c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f52376d = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public int f52377a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f52378b;

    /* loaded from: classes3.dex */
    public class a implements WebKitFactory.WebkitInstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52379a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f52380b;

        /* renamed from: d.a.m0.w.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1153a implements Runnable {
            public RunnableC1153a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.j(cVar.f52378b);
            }
        }

        public a(String str, File file) {
            this.f52379a = str;
            this.f52380b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            if (d.A(this.f52379a, str)) {
                synchronized (c.f52376d) {
                    c.this.i(new b(AppRuntime.getAppContext()).q());
                }
                return;
            }
            if (c.e(c.this) <= 2) {
                boolean z = true;
                if (8 == i2) {
                    c.this.f52378b = this.f52379a;
                } else {
                    c cVar = c.this;
                    cVar.f52378b = this.f52379a + File.pathSeparator + c.this.f52377a;
                    if (d.f(this.f52380b, new File(c.this.f52378b)) != this.f52380b.length()) {
                        z = false;
                    }
                }
                if (z && d.a.m0.a.a2.d.i().postDelayed(new RunnableC1153a(), 1000L)) {
                    return;
                }
            }
            if (8 == i2) {
                d.j(this.f52379a);
            }
            synchronized (c.f52376d) {
                c.this.i(false);
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
        }
    }

    public static /* synthetic */ int e(c cVar) {
        int i2 = cVar.f52377a + 1;
        cVar.f52377a = i2;
        return i2;
    }

    @Override // d.a.m0.n.l.b
    public void a(String str, b.a aVar) {
        synchronized (f52376d) {
            f52376d.add(aVar);
            if (f52375c) {
                return;
            }
            f52375c = true;
            j(str);
        }
    }

    public final void i(boolean z) {
        synchronized (f52376d) {
            for (b.a aVar : f52376d) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
            f52376d.clear();
            f52375c = false;
            this.f52377a = 0;
        }
    }

    public final void j(String str) {
        if (TextUtils.isEmpty(str)) {
            synchronized (f52376d) {
                i(false);
            }
            return;
        }
        File file = new File(str);
        if (!file.isFile()) {
            synchronized (f52376d) {
                i(false);
            }
            return;
        }
        WebKitFactory.installAsync("file://" + str, new a(str, file));
    }
}
