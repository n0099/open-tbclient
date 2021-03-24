package d.b.i0.s.b.q;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import d.b.g0.a.i2.p;
import d.b.g0.a.n1.c.f.e;
import d.b.g0.r.c;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements d.b.g0.r.a {
    @Override // d.b.g0.r.a
    public Bundle a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c2 = 65535;
        if (str.hashCode() == -504534151 && str.equals("veloce_sync_account_info")) {
            c2 = 0;
        }
        if (c2 != 0) {
            return c.a(str, bundle);
        }
        return d(bundle);
    }

    @Override // d.b.g0.r.a
    public void b() {
        p.f();
        p.g();
        p.h();
        try {
            new UnitedSchemeMainDispatcher();
            SwanLauncher.j();
            e.j();
        } catch (Exception unused) {
        }
    }

    @Override // d.b.g0.r.a
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.g0.d.h.b.a(str);
    }

    public final Bundle d(Bundle bundle) {
        if (bundle == null) {
        }
        return null;
    }
}
