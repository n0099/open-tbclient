package d.b.g0.t;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import d.b.g0.l.o.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements d.b.g0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49429a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<b.a> f49430b = new HashSet();

    /* loaded from: classes3.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public a() {
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i, String str) {
            synchronized (c.f49430b) {
                d.b.g0.t.a.c(true);
                c.this.e(new b(AppRuntime.getAppContext()).q());
                boolean unused = c.f49429a = false;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
        }
    }

    @Override // d.b.g0.l.o.b
    public void a(String str, b.a aVar) {
        synchronized (f49430b) {
            f49430b.add(aVar);
            if (f49429a) {
                return;
            }
            f49429a = true;
            WebKitFactory.installAsync("file://" + str, new a());
        }
    }

    public final void e(boolean z) {
        synchronized (f49430b) {
            for (b.a aVar : f49430b) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
            f49430b.clear();
        }
    }
}
