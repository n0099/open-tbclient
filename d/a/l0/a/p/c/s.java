package d.a.l0.a.p.c;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import d.a.l0.a.v0.c;
/* loaded from: classes2.dex */
public class s implements d.a.l0.a.p.d.f0 {
    @Override // d.a.l0.a.p.d.f0
    public boolean a(Activity activity) {
        return false;
    }

    @Override // d.a.l0.a.p.d.f0
    public void b(@NonNull Context context) {
    }

    @Override // d.a.l0.a.p.d.f0
    public void c(@NonNull String str) {
    }

    @Override // d.a.l0.a.p.d.f0
    public void d(@NonNull CallbackHandler callbackHandler) {
        callbackHandler.handleSchemeDispatchCallback("", "");
    }

    @Override // d.a.l0.a.p.d.f0
    public void e(d.a.l0.a.a2.e eVar) {
    }

    @Override // d.a.l0.a.p.d.f0
    public String f(@NonNull Context context) {
        return context.getString(d.a.l0.a.h.aiapps_fav_success);
    }

    @Override // d.a.l0.a.p.d.f0
    public void g(d.a.l0.a.a2.e eVar) {
    }

    @Override // d.a.l0.a.p.d.f0
    public void h(@NonNull Activity activity, String str, String str2, d.a.l0.a.v0.b bVar, c.b bVar2) {
        if (bVar2 != null) {
            bVar2.a();
        }
    }
}
