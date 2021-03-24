package d.b.g0.e.a.l.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadButtonView;
import d.b.g0.a.k;
import d.b.g0.a.p.c.g;
import d.b.g0.e.a.d;
import d.b.g0.e.a.e;
import d.b.g0.e.a.i;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47620e = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public Context f47621a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f47622b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.e.a.l.j.a f47623c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.q.g.a.a f47624d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f47623c.f47617a == SwanAdDownloadState.NOT_START || b.this.f47623c.f47617a == SwanAdDownloadState.DELETED) {
                if (b.f47620e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download start");
                }
                d.b.g0.a.w0.a.d().a(b.this.f47621a, ((d.b.g0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f47624d);
            }
            if (b.this.f47623c.f47617a == SwanAdDownloadState.DOWNLOADING) {
                if (b.f47620e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download pause");
                }
                d.b.g0.a.w0.a.d().a(b.this.f47621a, ((d.b.g0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.f47624d);
            }
            if (b.this.f47623c.f47617a == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                if (b.f47620e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download resume");
                }
                d.b.g0.a.w0.a.d().a(b.this.f47621a, ((d.b.g0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f47624d);
            }
            if (b.this.f47623c.f47617a == SwanAdDownloadState.DOWNLOAD_FAILED) {
                if (b.f47620e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download retry");
                }
                d.b.g0.a.w0.a.d().a(b.this.f47621a, ((d.b.g0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f47624d);
            }
            if (b.this.f47623c.f47617a == SwanAdDownloadState.DOWNLOADED) {
                if (b.f47620e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download install");
                }
                b.this.f47624d.b();
                d.b.g0.a.w0.a.d().a(b.this.f47621a, ((d.b.g0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.f47624d);
            }
            if (b.this.f47623c.f47617a == SwanAdDownloadState.INSTALLED) {
                if (b.f47620e) {
                    Log.d("SwanAppAdDownloadViewImpl", "open app");
                }
                String e2 = b.this.f47624d.e();
                if (TextUtils.isEmpty(b.this.f47623c.f47618b) && !TextUtils.isEmpty(e2)) {
                    b.this.a(e2);
                }
                b bVar = b.this;
                bVar.r(bVar.f47623c.f47618b);
            }
        }
    }

    /* renamed from: d.b.g0.e.a.l.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0931b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47626a;

        static {
            int[] iArr = new int[SwanAdDownloadState.values().length];
            f47626a = iArr;
            try {
                iArr[SwanAdDownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47626a[SwanAdDownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47626a[SwanAdDownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47626a[SwanAdDownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47626a[SwanAdDownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47626a[SwanAdDownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static float m(@Nullable Context context, float f2) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return f2 * (displayMetrics != null ? displayMetrics.density : 0.0f);
    }

    @Override // d.b.g0.a.p.c.g
    public void a(String str) {
        this.f47623c.f47618b = str;
    }

    @Override // d.b.g0.a.p.c.g
    public void b(int i) {
        t(i);
    }

    @Override // d.b.g0.a.p.c.g
    public void c(Object obj) {
        this.f47622b.setTag(obj);
    }

    @Override // d.b.g0.a.p.c.g
    public void d() {
        u(this.f47622b);
    }

    @Override // d.b.g0.a.p.c.g
    public void e(SwanAdDownloadState swanAdDownloadState) {
        v(swanAdDownloadState);
    }

    @Override // d.b.g0.a.p.c.g
    public /* bridge */ /* synthetic */ g f(Context context, d.b.g0.a.q.g.b.a aVar, d.b.g0.a.q.g.a.a aVar2) {
        l(context, aVar, aVar2);
        return this;
    }

    @Override // d.b.g0.a.p.c.g
    public View getRealView() {
        return this.f47622b;
    }

    public final void k() {
        this.f47622b = new SwanAdDownloadButtonView(this.f47621a);
        String string = this.f47621a.getResources().getString(i.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        double d2 = d.b.g0.a.w0.a.c().getResources().getDisplayMetrics().heightPixels;
        Double.isNaN(d2);
        layoutParams.bottomMargin = (int) (d2 * 0.04d);
        this.f47622b.setLayoutParams(layoutParams);
        float n = n(this.f47621a, e.swanapp_round_text_size);
        int color = this.f47621a.getResources().getColor(d.swanapp_ad_download_button_color);
        u(this.f47622b);
        SwanAdDownloadButtonView swanAdDownloadButtonView = this.f47622b;
        swanAdDownloadButtonView.j(m(this.f47621a, n));
        swanAdDownloadButtonView.f(true);
        swanAdDownloadButtonView.i(-1);
        swanAdDownloadButtonView.h(color);
        swanAdDownloadButtonView.g(true);
        this.f47622b.setText(string);
        this.f47622b.setVisibility(0);
        this.f47622b.setProgress(this.f47623c.f47619c);
    }

    public b l(Context context, d.b.g0.a.q.g.b.a aVar, d.b.g0.a.q.g.a.a aVar2) {
        this.f47621a = context;
        this.f47623c = d.b.g0.e.a.l.j.a.a(aVar.f45486a, aVar.f45487b);
        this.f47624d = aVar2;
        k();
        q();
        return this;
    }

    public final float n(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    public final ResolveInfo o(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        return queryIntentActivities.iterator().next();
    }

    public Object p() {
        return this.f47622b.getTag();
    }

    public final void q() {
        this.f47622b.setOnClickListener(new a());
    }

    public final void r(String str) {
        ResolveInfo o;
        if (TextUtils.isEmpty(str) || (o = o(this.f47621a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(268435456);
        try {
            this.f47621a.startActivity(intent);
        } catch (Exception e2) {
            if (f47620e) {
                e2.printStackTrace();
            }
        }
    }

    public final int s(SwanAdDownloadState swanAdDownloadState) {
        switch (C0931b.f47626a[swanAdDownloadState.ordinal()]) {
            case 1:
                return i.swanapp_ad_download_button;
            case 2:
                return i.swanapp_ad_download_button_pause;
            case 3:
                return i.swanapp_ad_download_button_continue;
            case 4:
                return i.swanapp_ad_download_button_install;
            case 5:
                return i.swanapp_ad_download_button_failed_retry;
            case 6:
                return i.swanapp_ad_download_button_open;
            default:
                return i.swanapp_ad_download_button;
        }
    }

    public final void t(int i) {
        d.b.g0.e.a.l.j.a aVar = this.f47623c;
        if (i != aVar.f47619c) {
            aVar.f47619c = i;
            w();
        }
    }

    public final void u(View view) {
        if (view != null) {
            float n = n(this.f47621a, e.swanapp_round_width_size);
            float n2 = n(this.f47621a, e.swanapp_round_height_size);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            if (n >= 0.0f && n <= 1.0f) {
                n *= this.f47621a.getResources().getDisplayMetrics().widthPixels;
            }
            if (n2 > 0.0f && n2 <= 1.0f) {
                n2 *= this.f47621a.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) n;
            layoutParams.height = (int) n2;
        }
    }

    public final void v(SwanAdDownloadState swanAdDownloadState) {
        d.b.g0.e.a.l.j.a aVar = this.f47623c;
        if (swanAdDownloadState != aVar.f47617a) {
            aVar.f47617a = swanAdDownloadState;
            w();
        }
    }

    public final void w() {
        String string;
        d.b.g0.e.a.l.j.a aVar = this.f47623c;
        if (aVar.f47617a == SwanAdDownloadState.DOWNLOADING) {
            SwanAdDownloadButtonView swanAdDownloadButtonView = this.f47622b;
            if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                if (this.f47623c.f47619c < this.f47622b.getMax()) {
                    String string2 = this.f47621a.getResources().getString(i.swanapp_ad_button_downloading);
                    string = String.format(string2, this.f47623c.f47619c + "%");
                } else {
                    string = this.f47621a.getResources().getString(i.swanapp_ad_download_button_install);
                }
                this.f47622b.setText(string);
                this.f47622b.setProgress(this.f47623c.f47619c);
            }
        } else {
            if (d.b.g0.e.a.l.e.a(this.f47621a, aVar.f47618b)) {
                this.f47623c.f47617a = SwanAdDownloadState.INSTALLED;
            }
            String string3 = this.f47621a.getResources().getString(s(this.f47623c.f47617a));
            if (this.f47623c.f47617a == SwanAdDownloadState.DOWNLOADED) {
                this.f47622b.setProgress(100);
            }
            d.b.g0.e.a.l.j.a aVar2 = this.f47623c;
            if (aVar2.f47617a == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.f47622b.setProgress(aVar2.f47619c);
            }
            this.f47622b.setText(string3);
        }
        SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f47622b;
        if (swanAdDownloadButtonView2 != null) {
            swanAdDownloadButtonView2.postInvalidate();
        }
    }
}
