package d.a.i0.e.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.k;
import d.a.i0.a.p.d.d1;
import d.a.i0.a.v2.r0;
import d.a.i0.a.v2.y;
import d.a.i0.a.z1.b.e.b;
@Service
/* loaded from: classes3.dex */
public class e implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.w2.j.b f46355a;

    /* loaded from: classes3.dex */
    public class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f46356a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46357b;

        public a(e eVar, SwanAppActivity swanAppActivity, String str) {
            this.f46356a = swanAppActivity;
            this.f46357b = str;
        }

        @Override // d.a.i0.a.z1.b.e.b.a
        public void a(d.a.i0.a.z1.b.e.b bVar) {
            d.a.i0.a.i1.d.e.a.d(bVar.c(), this.f46356a, this.f46357b);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.i0.a.t0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f46358a;

        public b(SwanAppActivity swanAppActivity) {
            this.f46358a = swanAppActivity;
        }

        @Override // d.a.i0.a.t0.a, d.a.i0.a.t0.b
        public void b() {
            e.this.f46355a.j();
            this.f46358a.unregisterCallback(this);
        }
    }

    static {
        boolean z = k.f43025a;
    }

    @Override // d.a.i0.a.p.d.d1
    public void a(NgWebView ngWebView) {
        ngWebView.doSelectionCancel();
    }

    @Override // d.a.i0.a.p.d.d1
    public void b(NgWebView ngWebView, String str) {
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
        if (x == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f46355a = new d.a.i0.a.w2.j.b(ngWebView.covertToView());
        int[] g2 = g(x);
        int[] h2 = h(x);
        for (int i2 = 0; i2 < g2.length; i2++) {
            this.f46355a.e(g2[i2], h2[i2]);
        }
        this.f46355a.r(new a(this, x, str));
        this.f46355a.t();
        x.registerCallback(new b(x));
    }

    @Override // d.a.i0.a.p.d.d1
    public void c(NgWebView ngWebView, int i2, int i3, int i4, int i5, String str, boolean z) {
        ngWebView.updateAndShowPopupWindow(i4, i5, i2, i3, str, true);
        if (z) {
            i("show", null, null);
        }
    }

    @Override // d.a.i0.a.p.d.d1
    public void d(String str, Context context) {
    }

    @Override // d.a.i0.a.p.d.d1
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
        int[] iArr = {d.a.i0.e.e.swan_app_img_menu_load_image, d.a.i0.e.e.swan_app_img_menu_save_image, d.a.i0.e.e.swan_app_img_menu_share_image, d.a.i0.e.e.swan_app_img_menu_set_wallpaper};
        if (y.a(context, "android.permission.SET_WALLPAPER")) {
            return iArr;
        }
        int[] iArr2 = new int[3];
        System.arraycopy(iArr, 0, iArr2, 0, 3);
        return iArr2;
    }

    public void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43011a = "tool";
        eVar.f43016f = d.a.i0.a.a2.d.g().getAppId();
        eVar.f43013c = "miniapp";
        eVar.f43017g = "text";
        eVar.f43012b = str;
        eVar.f43015e = str2;
        if (!TextUtils.isEmpty(str3)) {
            eVar.a("query", str3);
        }
        d.a.i0.a.j2.k.u("810", eVar);
    }
}
