package d.a.h0.t;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.h0.l.o.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements d.a.h0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f47686a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<b.a> f47687b = new HashSet();

    /* loaded from: classes3.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public a() {
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            synchronized (c.f47687b) {
                d.a.h0.t.a.c(true);
                c.this.e(new b(AppRuntime.getAppContext()).q());
                boolean unused = c.f47686a = false;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
        }
    }

    @Override // d.a.h0.l.o.b
    public void a(String str, b.a aVar) {
        synchronized (f47687b) {
            f47687b.add(aVar);
            if (f47686a) {
                return;
            }
            f47686a = true;
            WebKitFactory.installAsync("file://" + str, new a());
        }
    }

    public final void e(boolean z) {
        synchronized (f47687b) {
            for (b.a aVar : f47687b) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
            f47687b.clear();
        }
    }
}
