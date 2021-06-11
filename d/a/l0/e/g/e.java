package d.a.l0.e.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.k;
import d.a.l0.a.p.d.d1;
import d.a.l0.a.v2.r0;
import d.a.l0.a.v2.y;
import d.a.l0.a.z1.b.e.b;
@Service
/* loaded from: classes3.dex */
public class e implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.w2.j.b f50205a;

    /* loaded from: classes3.dex */
    public class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50206a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50207b;

        public a(e eVar, SwanAppActivity swanAppActivity, String str) {
            this.f50206a = swanAppActivity;
            this.f50207b = str;
        }

        @Override // d.a.l0.a.z1.b.e.b.a
        public void a(d.a.l0.a.z1.b.e.b bVar) {
            d.a.l0.a.i1.d.e.a.d(bVar.c(), this.f50206a, this.f50207b);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.l0.a.t0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50208a;

        public b(SwanAppActivity swanAppActivity) {
            this.f50208a = swanAppActivity;
        }

        @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
        public void b() {
            e.this.f50205a.j();
            this.f50208a.unregisterCallback(this);
        }
    }

    static {
        boolean z = k.f46875a;
    }

    @Override // d.a.l0.a.p.d.d1
    public void a(NgWebView ngWebView) {
        ngWebView.doSelectionCancel();
    }

    @Override // d.a.l0.a.p.d.d1
    public void b(NgWebView ngWebView, String str) {
        SwanAppActivity x = d.a.l0.a.a2.d.g().x();
        if (x == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f50205a = new d.a.l0.a.w2.j.b(ngWebView.covertToView());
        int[] g2 = g(x);
        int[] h2 = h(x);
        for (int i2 = 0; i2 < g2.length; i2++) {
            this.f50205a.e(g2[i2], h2[i2]);
        }
        this.f50205a.r(new a(this, x, str));
        this.f50205a.t();
        x.registerCallback(new b(x));
    }

    @Override // d.a.l0.a.p.d.d1
    public void c(NgWebView ngWebView, int i2, int i3, int i4, int i5, String str, boolean z) {
        ngWebView.updateAndShowPopupWindow(i4, i5, i2, i3, str, true);
        if (z) {
            i("show", null, null);
        }
    }

    @Override // d.a.l0.a.p.d.d1
    public void d(String str, Context context) {
    }

    @Override // d.a.l0.a.p.d.d1
    public void e(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        r0.b(context).c(str);
        i(PrefetchEvent.STATE_CLICK, "copy", null);
    }

    public int[] g(Context context) {
        int[] iArr = {7, 6, 5, 8};
        if (y.a(context, "android.permission.SET_WALLPAPER")) {
            return iArr;
        }
        int[] iArr2 = new int[3];
        System.arraycopy(iArr, 0, iArr2, 0, 3);
        return iArr2;
    }

    public int[] h(Context context) {
        int[] iArr = {d.a.l0.e.e.swan_app_img_menu_load_image, d.a.l0.e.e.swan_app_img_menu_save_image, d.a.l0.e.e.swan_app_img_menu_share_image, d.a.l0.e.e.swan_app_img_menu_set_wallpaper};
        if (y.a(context, "android.permission.SET_WALLPAPER")) {
            return iArr;
        }
        int[] iArr2 = new int[3];
        System.arraycopy(iArr, 0, iArr2, 0, 3);
        return iArr2;
    }

    public void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46861a = "tool";
        eVar.f46866f = d.a.l0.a.a2.d.g().getAppId();
        eVar.f46863c = "miniapp";
        eVar.f46867g = "text";
        eVar.f46862b = str;
        eVar.f46865e = str2;
        if (!TextUtils.isEmpty(str3)) {
            eVar.a("query", str3);
        }
        d.a.l0.a.j2.k.u("810", eVar);
    }
}
