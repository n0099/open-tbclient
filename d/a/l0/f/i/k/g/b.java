package d.a.l0.f.i.k.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadButtonView;
import d.a.l0.f.i.c;
import d.a.l0.f.i.g;
import d.a.l0.f.i.k.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public Context f46752a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f46753b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.f.i.k.g.a f46754c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.f.i.k.f.a f46755d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.l0.f.i.m.a.b() == null) {
                return;
            }
            if (b.this.f46754c.f46749a == DownloadState.NOT_START || b.this.f46754c.f46749a == DownloadState.DELETED) {
                d.a.l0.f.i.m.a.b().b(b.this.f46752a, ((DownloadParams) b.this.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f46755d);
            }
            if (b.this.f46754c.f46749a == DownloadState.DOWNLOADING) {
                d.a.l0.f.i.m.a.b().b(b.this.f46752a, ((DownloadParams) b.this.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.f46755d);
            }
            if (b.this.f46754c.f46749a == DownloadState.DOWNLOAD_PAUSED) {
                d.a.l0.f.i.m.a.b().b(b.this.f46752a, ((DownloadParams) b.this.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f46755d);
            }
            if (b.this.f46754c.f46749a == DownloadState.DOWNLOAD_FAILED) {
                d.a.l0.f.i.m.a.b().b(b.this.f46752a, ((DownloadParams) b.this.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f46755d);
            }
            if (b.this.f46754c.f46749a == DownloadState.DOWNLOADED) {
                b.this.f46755d.b();
                d.a.l0.f.i.m.a.b().b(b.this.f46752a, ((DownloadParams) b.this.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.f46755d);
            }
            if (b.this.f46754c.f46749a == DownloadState.INSTALLED) {
                String e2 = b.this.f46755d.e();
                if (TextUtils.isEmpty(b.this.f46754c.f46750b) && !TextUtils.isEmpty(e2)) {
                    b.this.a(e2);
                }
                b bVar = b.this;
                bVar.r(bVar.f46754c.f46750b);
            }
        }
    }

    /* renamed from: d.a.l0.f.i.k.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0981b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46757a;

        static {
            int[] iArr = new int[DownloadState.values().length];
            f46757a = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46757a[DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46757a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46757a[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46757a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46757a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static float m(float f2) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return f2 * (displayMetrics != null ? displayMetrics.density : 0.0f);
    }

    @Override // d.a.l0.f.i.k.f.f
    public void a(String str) {
        this.f46754c.f46750b = str;
    }

    @Override // d.a.l0.f.i.k.f.f
    public void b(DownloadState downloadState) {
        v(downloadState);
    }

    @Override // d.a.l0.f.i.k.f.f
    public /* bridge */ /* synthetic */ f c(Context context, DownloadParams downloadParams, d.a.l0.f.i.k.f.a aVar) {
        l(context, downloadParams, aVar);
        return this;
    }

    @Override // d.a.l0.f.i.k.f.f
    public void d(int i2) {
        t(i2);
    }

    @Override // d.a.l0.f.i.k.f.f
    public void e(Object obj) {
        this.f46753b.setTag(obj);
    }

    @Override // d.a.l0.f.i.k.f.f
    public void f() {
        u(this.f46753b);
    }

    @Override // d.a.l0.f.i.k.f.f
    public View getRealView() {
        return this.f46753b;
    }

    public final void k() {
        this.f46753b = new SwanAdDownloadButtonView(this.f46752a);
        String string = this.f46752a.getResources().getString(g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (this.f46752a.getResources().getDisplayMetrics().heightPixels * 0.04d);
        this.f46753b.setLayoutParams(layoutParams);
        float n = n(this.f46752a, c.swan_ad_round_text_size);
        int color = this.f46752a.getResources().getColor(d.a.l0.f.i.b.swanapp_ad_download_button_color);
        u(this.f46753b);
        SwanAdDownloadButtonView swanAdDownloadButtonView = this.f46753b;
        swanAdDownloadButtonView.j(m(n));
        swanAdDownloadButtonView.f(true);
        swanAdDownloadButtonView.i(-1);
        swanAdDownloadButtonView.h(color);
        swanAdDownloadButtonView.g(true);
        this.f46753b.setText(string);
        this.f46753b.setVisibility(0);
        this.f46753b.setProgress(this.f46754c.f46751c);
    }

    public b l(Context context, DownloadParams downloadParams, d.a.l0.f.i.k.f.a aVar) {
        this.f46752a = context;
        this.f46754c = d.a.l0.f.i.k.g.a.a(downloadParams.f11534a, downloadParams.f11535b);
        this.f46755d = aVar;
        k();
        q();
        return this;
    }

    public final float n(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i2, typedValue, true);
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
        if (queryIntentActivities.size() > 0) {
            return queryIntentActivities.iterator().next();
        }
        return null;
    }

    public Object p() {
        return this.f46753b.getTag();
    }

    public final void q() {
        this.f46753b.setOnClickListener(new a());
    }

    public final void r(String str) {
        ResolveInfo o;
        if (TextUtils.isEmpty(str) || (o = o(this.f46752a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            this.f46752a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final int s(DownloadState downloadState) {
        switch (C0981b.f46757a[downloadState.ordinal()]) {
            case 1:
                return g.swanapp_ad_download_button;
            case 2:
                return g.swanapp_ad_download_button_pause;
            case 3:
                return g.swanapp_ad_download_button_continue;
            case 4:
                return g.swanapp_ad_download_button_install;
            case 5:
                return g.swanapp_ad_download_button_failed_retry;
            case 6:
                return g.swanapp_ad_download_button_open;
            default:
                return g.swanapp_ad_download_button;
        }
    }

    public final void t(int i2) {
        d.a.l0.f.i.k.g.a aVar = this.f46754c;
        if (i2 != aVar.f46751c) {
            aVar.f46751c = i2;
            w();
        }
    }

    public final void u(View view) {
        if (view != null) {
            float n = n(this.f46752a, c.swan_ad_round_width_size);
            float n2 = n(this.f46752a, c.swan_ad_round_height_size);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            if (n >= 0.0f && n <= 1.0f) {
                n *= this.f46752a.getResources().getDisplayMetrics().widthPixels;
            }
            if (n2 > 0.0f && n2 <= 1.0f) {
                n2 *= this.f46752a.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) n;
            layoutParams.height = (int) n2;
        }
    }

    public final void v(DownloadState downloadState) {
        d.a.l0.f.i.k.g.a aVar = this.f46754c;
        if (downloadState != aVar.f46749a) {
            aVar.f46749a = downloadState;
            w();
        }
    }

    public final void w() {
        String string;
        d.a.l0.f.i.k.g.a aVar = this.f46754c;
        if (aVar.f46749a == DownloadState.DOWNLOADING) {
            SwanAdDownloadButtonView swanAdDownloadButtonView = this.f46753b;
            if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                if (this.f46754c.f46751c < this.f46753b.getMax()) {
                    String string2 = this.f46752a.getResources().getString(g.swanapp_ad_button_downloading);
                    string = String.format(string2, this.f46754c.f46751c + "%");
                } else {
                    string = this.f46752a.getResources().getString(g.swanapp_ad_download_button_install);
                }
                this.f46753b.setText(string);
                this.f46753b.setProgress(this.f46754c.f46751c);
            }
        } else {
            if (d.a.l0.f.i.r.g.a(this.f46752a, aVar.f46750b)) {
                this.f46754c.f46749a = DownloadState.INSTALLED;
            }
            String string3 = this.f46752a.getResources().getString(s(this.f46754c.f46749a));
            if (this.f46754c.f46749a == DownloadState.DOWNLOADED) {
                this.f46753b.setProgress(100);
            }
            d.a.l0.f.i.k.g.a aVar2 = this.f46754c;
            if (aVar2.f46749a == DownloadState.DOWNLOAD_PAUSED) {
                this.f46753b.setProgress(aVar2.f46751c);
            }
            this.f46753b.setText(string3);
        }
        SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f46753b;
        if (swanAdDownloadButtonView2 != null) {
            swanAdDownloadButtonView2.postInvalidate();
        }
    }
}
