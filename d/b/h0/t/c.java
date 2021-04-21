package d.b.h0.t;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import d.b.h0.l.o.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements d.b.h0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50151a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<b.a> f50152b = new HashSet();

    /* loaded from: classes3.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public a() {
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i, String str) {
            synchronized (c.f50152b) {
                d.b.h0.t.a.c(true);
                c.this.e(new b(AppRuntime.getAppContext()).q());
                boolean unused = c.f50151a = false;
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
        }
    }

    @Override // d.b.h0.l.o.b
    public void a(String str, b.a aVar) {
        synchronized (f50152b) {
            f50152b.add(aVar);
            if (f50151a) {
                return;
            }
            f50151a = true;
            WebKitFactory.installAsync("file://" + str, new a());
        }
    }

    public final void e(boolean z) {
        synchronized (f50152b) {
            for (b.a aVar : f50152b) {
                if (aVar != null) {
                    aVar.a(z);
                }
            }
            f50152b.clear();
        }
    }
}
