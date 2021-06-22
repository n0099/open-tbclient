package d.a.m0.a.c1.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.l;
import d.a.m0.a.v2.f0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.s0;
import java.io.File;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c implements d.a.m0.f.i.m.b.b {
    @Override // d.a.m0.f.i.m.b.b
    public String a() {
        return d.a.m0.a.c1.a.m().a();
    }

    @Override // d.a.m0.f.i.m.b.b
    public boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.m0.f.i.k.f.a aVar) {
        return d.a.m0.a.c1.a.c().b(context, jSONObject, swanAppDownloadType, aVar);
    }

    @Override // d.a.m0.f.i.m.b.b
    public String getAppId() {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        return i2 != null ? i2.f44533f : "";
    }

    @Override // d.a.m0.f.i.m.b.b
    public String getAppKey() {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        return i2 != null ? i2.D() : "";
    }

    @Override // d.a.m0.f.i.m.b.b
    public String getSdkVersion() {
        return l.a();
    }

    @Override // d.a.m0.f.i.m.b.b
    public String k() {
        b.a L;
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        return (Q == null || (L = Q.L()) == null) ? "" : L.T();
    }

    @Override // d.a.m0.f.i.m.b.b
    public String l(String str) {
        return d.a.m0.a.c1.a.p().a().getCookie(str);
    }

    @Override // d.a.m0.f.i.m.b.b
    public String m() {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        return Q != null ? Q.L().h1().optString("eqid", "") : "";
    }

    @Override // d.a.m0.f.i.m.b.b
    public int n() {
        if (d.a.m0.a.g1.f.V().getActivity() != null) {
            return f0.e(d.a.m0.a.g1.f.V().getActivity());
        }
        return 0;
    }

    @Override // d.a.m0.f.i.m.b.b
    public String o(String str) {
        return d.a.m0.a.s2.a.b(str);
    }

    @Override // d.a.m0.f.i.m.b.b
    public int p() {
        return ((Integer) d.a.m0.a.g1.f.V().y().second).intValue();
    }

    @Override // d.a.m0.f.i.m.b.b
    public int q() {
        return ((Integer) d.a.m0.a.g1.f.V().y().first).intValue();
    }

    @Override // d.a.m0.f.i.m.b.b
    public Uri r(@NonNull Context context, @NonNull File file) {
        return s0.a(context, file);
    }

    @Override // d.a.m0.f.i.m.b.b
    public String s() {
        String i2 = d.a.m0.a.c1.a.a0().i(d.a.m0.a.c1.a.b());
        return TextUtils.isEmpty(i2) ? q0.r() : i2;
    }

    @Override // d.a.m0.f.i.m.b.b
    public String t() {
        return q0.r();
    }

    @Override // d.a.m0.f.i.m.b.b
    public JSONObject u() {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        return Q != null ? Q.L().M() : new JSONObject();
    }

    @Override // d.a.m0.f.i.m.b.b
    public boolean v(View view) {
        if (d.a.m0.a.g1.f.V().getActivity() != null) {
            return f0.q(d.a.m0.a.g1.f.V().getActivity(), view);
        }
        return false;
    }
}
