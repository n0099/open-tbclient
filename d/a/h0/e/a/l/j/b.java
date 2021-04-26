package d.a.h0.e.a.l.j;

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
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadButtonView;
import d.a.h0.a.k;
import d.a.h0.a.p.c.g;
import d.a.h0.e.a.d;
import d.a.h0.e.a.e;
import d.a.h0.e.a.i;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45796e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45797a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f45798b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.e.a.l.j.a f45799c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.q.g.a.a f45800d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f45799c.f45793a == SwanAdDownloadState.NOT_START || b.this.f45799c.f45793a == SwanAdDownloadState.DELETED) {
                if (b.f45796e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download start");
                }
                d.a.h0.a.w0.a.d().a(b.this.f45797a, ((d.a.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f45800d);
            }
            if (b.this.f45799c.f45793a == SwanAdDownloadState.DOWNLOADING) {
                if (b.f45796e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download pause");
                }
                d.a.h0.a.w0.a.d().a(b.this.f45797a, ((d.a.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.f45800d);
            }
            if (b.this.f45799c.f45793a == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                if (b.f45796e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download resume");
                }
                d.a.h0.a.w0.a.d().a(b.this.f45797a, ((d.a.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f45800d);
            }
            if (b.this.f45799c.f45793a == SwanAdDownloadState.DOWNLOAD_FAILED) {
                if (b.f45796e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download retry");
                }
                d.a.h0.a.w0.a.d().a(b.this.f45797a, ((d.a.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f45800d);
            }
            if (b.this.f45799c.f45793a == SwanAdDownloadState.DOWNLOADED) {
                if (b.f45796e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download install");
                }
                b.this.f45800d.a();
                d.a.h0.a.w0.a.d().a(b.this.f45797a, ((d.a.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.f45800d);
            }
            if (b.this.f45799c.f45793a == SwanAdDownloadState.INSTALLED) {
                if (b.f45796e) {
                    Log.d("SwanAppAdDownloadViewImpl", "open app");
                }
                String e2 = b.this.f45800d.e();
                if (TextUtils.isEmpty(b.this.f45799c.f45794b) && !TextUtils.isEmpty(e2)) {
                    b.this.a(e2);
                }
                b bVar = b.this;
                bVar.r(bVar.f45799c.f45794b);
            }
        }
    }

    /* renamed from: d.a.h0.e.a.l.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0903b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45802a;

        static {
            int[] iArr = new int[SwanAdDownloadState.values().length];
            f45802a = iArr;
            try {
                iArr[SwanAdDownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45802a[SwanAdDownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45802a[SwanAdDownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45802a[SwanAdDownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45802a[SwanAdDownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45802a[SwanAdDownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static float m(@Nullable Context context, float f2) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return f2 * (displayMetrics != null ? displayMetrics.density : 0.0f);
    }

    @Override // d.a.h0.a.p.c.g
    public void a(String str) {
        this.f45799c.f45794b = str;
    }

    @Override // d.a.h0.a.p.c.g
    public void b(SwanAdDownloadState swanAdDownloadState) {
        v(swanAdDownloadState);
    }

    @Override // d.a.h0.a.p.c.g
    public /* bridge */ /* synthetic */ g c(Context context, d.a.h0.a.q.g.b.a aVar, d.a.h0.a.q.g.a.a aVar2) {
        l(context, aVar, aVar2);
        return this;
    }

    @Override // d.a.h0.a.p.c.g
    public void d(int i2) {
        t(i2);
    }

    @Override // d.a.h0.a.p.c.g
    public void e(Object obj) {
        this.f45798b.setTag(obj);
    }

    @Override // d.a.h0.a.p.c.g
    public void f() {
        u(this.f45798b);
    }

    @Override // d.a.h0.a.p.c.g
    public View getRealView() {
        return this.f45798b;
    }

    public final void k() {
        this.f45798b = new SwanAdDownloadButtonView(this.f45797a);
        String string = this.f45797a.getResources().getString(i.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (d.a.h0.a.w0.a.c().getResources().getDisplayMetrics().heightPixels * 0.04d);
        this.f45798b.setLayoutParams(layoutParams);
        float n = n(this.f45797a, e.swanapp_round_text_size);
        int color = this.f45797a.getResources().getColor(d.swanapp_ad_download_button_color);
        u(this.f45798b);
        SwanAdDownloadButtonView swanAdDownloadButtonView = this.f45798b;
        swanAdDownloadButtonView.j(m(this.f45797a, n));
        swanAdDownloadButtonView.f(true);
        swanAdDownloadButtonView.i(-1);
        swanAdDownloadButtonView.h(color);
        swanAdDownloadButtonView.g(true);
        this.f45798b.setText(string);
        this.f45798b.setVisibility(0);
        this.f45798b.setProgress(this.f45799c.f45795c);
    }

    public b l(Context context, d.a.h0.a.q.g.b.a aVar, d.a.h0.a.q.g.a.a aVar2) {
        this.f45797a = context;
        this.f45799c = d.a.h0.e.a.l.j.a.a(aVar.f43556a, aVar.f43557b);
        this.f45800d = aVar2;
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
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        return queryIntentActivities.iterator().next();
    }

    public Object p() {
        return this.f45798b.getTag();
    }

    public final void q() {
        this.f45798b.setOnClickListener(new a());
    }

    public final void r(String str) {
        ResolveInfo o;
        if (TextUtils.isEmpty(str) || (o = o(this.f45797a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            this.f45797a.startActivity(intent);
        } catch (Exception e2) {
            if (f45796e) {
                e2.printStackTrace();
            }
        }
    }

    public final int s(SwanAdDownloadState swanAdDownloadState) {
        switch (C0903b.f45802a[swanAdDownloadState.ordinal()]) {
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

    public final void t(int i2) {
        d.a.h0.e.a.l.j.a aVar = this.f45799c;
        if (i2 != aVar.f45795c) {
            aVar.f45795c = i2;
            w();
        }
    }

    public final void u(View view) {
        if (view != null) {
            float n = n(this.f45797a, e.swanapp_round_width_size);
            float n2 = n(this.f45797a, e.swanapp_round_height_size);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            if (n >= 0.0f && n <= 1.0f) {
                n *= this.f45797a.getResources().getDisplayMetrics().widthPixels;
            }
            if (n2 > 0.0f && n2 <= 1.0f) {
                n2 *= this.f45797a.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) n;
            layoutParams.height = (int) n2;
        }
    }

    public final void v(SwanAdDownloadState swanAdDownloadState) {
        d.a.h0.e.a.l.j.a aVar = this.f45799c;
        if (swanAdDownloadState != aVar.f45793a) {
            aVar.f45793a = swanAdDownloadState;
            w();
        }
    }

    public final void w() {
        String string;
        d.a.h0.e.a.l.j.a aVar = this.f45799c;
        if (aVar.f45793a == SwanAdDownloadState.DOWNLOADING) {
            SwanAdDownloadButtonView swanAdDownloadButtonView = this.f45798b;
            if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                if (this.f45799c.f45795c < this.f45798b.getMax()) {
                    String string2 = this.f45797a.getResources().getString(i.swanapp_ad_button_downloading);
                    string = String.format(string2, this.f45799c.f45795c + "%");
                } else {
                    string = this.f45797a.getResources().getString(i.swanapp_ad_download_button_install);
                }
                this.f45798b.setText(string);
                this.f45798b.setProgress(this.f45799c.f45795c);
            }
        } else {
            if (d.a.h0.e.a.l.e.a(this.f45797a, aVar.f45794b)) {
                this.f45799c.f45793a = SwanAdDownloadState.INSTALLED;
            }
            String string3 = this.f45797a.getResources().getString(s(this.f45799c.f45793a));
            if (this.f45799c.f45793a == SwanAdDownloadState.DOWNLOADED) {
                this.f45798b.setProgress(100);
            }
            d.a.h0.e.a.l.j.a aVar2 = this.f45799c;
            if (aVar2.f45793a == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.f45798b.setProgress(aVar2.f45795c);
            }
            this.f45798b.setText(string3);
        }
        SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f45798b;
        if (swanAdDownloadButtonView2 != null) {
            swanAdDownloadButtonView2.postInvalidate();
        }
    }
}
