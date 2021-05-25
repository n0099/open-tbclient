package d.a.l0.g.c.c;

import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import d.a.l0.a.v2.f0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.a.l0.g.f.a {
    public g() {
        super("openSpaceCleanActivity");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        boolean b2;
        if (f0.m()) {
            b2 = b("com.huawei.systemmanager", "com.huawei.systemmanager.appfeature.spacecleaner.SpaceCleanActivity");
        } else if (f0.n()) {
            b2 = b("com.miui.cleanmaster", "com.miui.optimizecenter.MainActivity");
        } else if (f0.o()) {
            b2 = b("com.coloros.phonemanager", "com.coloros.phonemanager.clear.ClearActivity");
        } else {
            b2 = f0.r() ? b("com.iqoo.secure", "com.iqoo.secure.clean.PhoneCleanActivity2") : false;
        }
        if (!b2) {
            Toast.makeText(d.a.l0.a.c1.a.b(), d.a.l0.g.b.aiapps_goto_clean_activity_fail, 0).show();
        }
        bVar.b(null);
        return null;
    }

    public final boolean b(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        return d.a.l0.a.v2.f.i(d.a.l0.a.c1.a.b(), intent, true, false);
    }
}
