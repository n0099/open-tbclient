package d.b.h0.e.a.l.j;

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
import d.b.h0.a.k;
import d.b.h0.a.p.c.g;
import d.b.h0.e.a.d;
import d.b.h0.e.a.e;
import d.b.h0.e.a.i;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48342e = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public Context f48343a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f48344b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.e.a.l.j.a f48345c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.q.g.a.a f48346d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f48345c.f48339a == SwanAdDownloadState.NOT_START || b.this.f48345c.f48339a == SwanAdDownloadState.DELETED) {
                if (b.f48342e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download start");
                }
                d.b.h0.a.w0.a.d().a(b.this.f48343a, ((d.b.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f48346d);
            }
            if (b.this.f48345c.f48339a == SwanAdDownloadState.DOWNLOADING) {
                if (b.f48342e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download pause");
                }
                d.b.h0.a.w0.a.d().a(b.this.f48343a, ((d.b.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.f48346d);
            }
            if (b.this.f48345c.f48339a == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                if (b.f48342e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download resume");
                }
                d.b.h0.a.w0.a.d().a(b.this.f48343a, ((d.b.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f48346d);
            }
            if (b.this.f48345c.f48339a == SwanAdDownloadState.DOWNLOAD_FAILED) {
                if (b.f48342e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download retry");
                }
                d.b.h0.a.w0.a.d().a(b.this.f48343a, ((d.b.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.f48346d);
            }
            if (b.this.f48345c.f48339a == SwanAdDownloadState.DOWNLOADED) {
                if (b.f48342e) {
                    Log.d("SwanAppAdDownloadViewImpl", "download install");
                }
                b.this.f48346d.b();
                d.b.h0.a.w0.a.d().a(b.this.f48343a, ((d.b.h0.a.q.g.b.a) b.this.p()).a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.f48346d);
            }
            if (b.this.f48345c.f48339a == SwanAdDownloadState.INSTALLED) {
                if (b.f48342e) {
                    Log.d("SwanAppAdDownloadViewImpl", "open app");
                }
                String e2 = b.this.f48346d.e();
                if (TextUtils.isEmpty(b.this.f48345c.f48340b) && !TextUtils.isEmpty(e2)) {
                    b.this.a(e2);
                }
                b bVar = b.this;
                bVar.r(bVar.f48345c.f48340b);
            }
        }
    }

    /* renamed from: d.b.h0.e.a.l.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0964b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48348a;

        static {
            int[] iArr = new int[SwanAdDownloadState.values().length];
            f48348a = iArr;
            try {
                iArr[SwanAdDownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48348a[SwanAdDownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48348a[SwanAdDownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48348a[SwanAdDownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f48348a[SwanAdDownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f48348a[SwanAdDownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static float m(@Nullable Context context, float f2) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return f2 * (displayMetrics != null ? displayMetrics.density : 0.0f);
    }

    @Override // d.b.h0.a.p.c.g
    public void a(String str) {
        this.f48345c.f48340b = str;
    }

    @Override // d.b.h0.a.p.c.g
    public void b(int i) {
        t(i);
    }

    @Override // d.b.h0.a.p.c.g
    public void c(Object obj) {
        this.f48344b.setTag(obj);
    }

    @Override // d.b.h0.a.p.c.g
    public void d() {
        u(this.f48344b);
    }

    @Override // d.b.h0.a.p.c.g
    public void e(SwanAdDownloadState swanAdDownloadState) {
        v(swanAdDownloadState);
    }

    @Override // d.b.h0.a.p.c.g
    public /* bridge */ /* synthetic */ g f(Context context, d.b.h0.a.q.g.b.a aVar, d.b.h0.a.q.g.a.a aVar2) {
        l(context, aVar, aVar2);
        return this;
    }

    @Override // d.b.h0.a.p.c.g
    public View getRealView() {
        return this.f48344b;
    }

    public final void k() {
        this.f48344b = new SwanAdDownloadButtonView(this.f48343a);
        String string = this.f48343a.getResources().getString(i.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (d.b.h0.a.w0.a.c().getResources().getDisplayMetrics().heightPixels * 0.04d);
        this.f48344b.setLayoutParams(layoutParams);
        float n = n(this.f48343a, e.swanapp_round_text_size);
        int color = this.f48343a.getResources().getColor(d.swanapp_ad_download_button_color);
        u(this.f48344b);
        SwanAdDownloadButtonView swanAdDownloadButtonView = this.f48344b;
        swanAdDownloadButtonView.j(m(this.f48343a, n));
        swanAdDownloadButtonView.f(true);
        swanAdDownloadButtonView.i(-1);
        swanAdDownloadButtonView.h(color);
        swanAdDownloadButtonView.g(true);
        this.f48344b.setText(string);
        this.f48344b.setVisibility(0);
        this.f48344b.setProgress(this.f48345c.f48341c);
    }

    public b l(Context context, d.b.h0.a.q.g.b.a aVar, d.b.h0.a.q.g.a.a aVar2) {
        this.f48343a = context;
        this.f48345c = d.b.h0.e.a.l.j.a.a(aVar.f46208a, aVar.f46209b);
        this.f48346d = aVar2;
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
        return this.f48344b.getTag();
    }

    public final void q() {
        this.f48344b.setOnClickListener(new a());
    }

    public final void r(String str) {
        ResolveInfo o;
        if (TextUtils.isEmpty(str) || (o = o(this.f48343a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            this.f48343a.startActivity(intent);
        } catch (Exception e2) {
            if (f48342e) {
                e2.printStackTrace();
            }
        }
    }

    public final int s(SwanAdDownloadState swanAdDownloadState) {
        switch (C0964b.f48348a[swanAdDownloadState.ordinal()]) {
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
        d.b.h0.e.a.l.j.a aVar = this.f48345c;
        if (i != aVar.f48341c) {
            aVar.f48341c = i;
            w();
        }
    }

    public final void u(View view) {
        if (view != null) {
            float n = n(this.f48343a, e.swanapp_round_width_size);
            float n2 = n(this.f48343a, e.swanapp_round_height_size);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            if (n >= 0.0f && n <= 1.0f) {
                n *= this.f48343a.getResources().getDisplayMetrics().widthPixels;
            }
            if (n2 > 0.0f && n2 <= 1.0f) {
                n2 *= this.f48343a.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) n;
            layoutParams.height = (int) n2;
        }
    }

    public final void v(SwanAdDownloadState swanAdDownloadState) {
        d.b.h0.e.a.l.j.a aVar = this.f48345c;
        if (swanAdDownloadState != aVar.f48339a) {
            aVar.f48339a = swanAdDownloadState;
            w();
        }
    }

    public final void w() {
        String string;
        d.b.h0.e.a.l.j.a aVar = this.f48345c;
        if (aVar.f48339a == SwanAdDownloadState.DOWNLOADING) {
            SwanAdDownloadButtonView swanAdDownloadButtonView = this.f48344b;
            if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                if (this.f48345c.f48341c < this.f48344b.getMax()) {
                    String string2 = this.f48343a.getResources().getString(i.swanapp_ad_button_downloading);
                    string = String.format(string2, this.f48345c.f48341c + "%");
                } else {
                    string = this.f48343a.getResources().getString(i.swanapp_ad_download_button_install);
                }
                this.f48344b.setText(string);
                this.f48344b.setProgress(this.f48345c.f48341c);
            }
        } else {
            if (d.b.h0.e.a.l.e.a(this.f48343a, aVar.f48340b)) {
                this.f48345c.f48339a = SwanAdDownloadState.INSTALLED;
            }
            String string3 = this.f48343a.getResources().getString(s(this.f48345c.f48339a));
            if (this.f48345c.f48339a == SwanAdDownloadState.DOWNLOADED) {
                this.f48344b.setProgress(100);
            }
            d.b.h0.e.a.l.j.a aVar2 = this.f48345c;
            if (aVar2.f48339a == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.f48344b.setProgress(aVar2.f48341c);
            }
            this.f48344b.setText(string3);
        }
        SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f48344b;
        if (swanAdDownloadButtonView2 != null) {
            swanAdDownloadButtonView2.postInvalidate();
        }
    }
}
