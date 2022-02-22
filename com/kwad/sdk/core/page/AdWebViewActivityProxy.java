package com.kwad.sdk.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.page.c;
import com.kwad.sdk.core.page.widget.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes4.dex */
public class AdWebViewActivityProxy extends com.kwad.sdk.h.a implements c.a {
    public static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    public static final String KEY_MINI_WINDOW = "key_mini_window";
    public static final String KEY_PAGE_TITLE = "key_page_title";
    public static final String KEY_PAGE_URL = "key_page_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean showingAdWebViewActivity;
    public c landingPageViewHelper;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public boolean mIsVPlusShown = false;
    public boolean mNormalMode;

    /* loaded from: classes4.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f56118b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f56119c;

        /* renamed from: com.kwad.sdk.core.page.AdWebViewActivityProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C2123a {
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f56120b;

            /* renamed from: c  reason: collision with root package name */
            public AdTemplate f56121c;

            public C2123a a(AdTemplate adTemplate) {
                this.f56121c = adTemplate;
                return this;
            }

            public C2123a a(String str) {
                this.a = str;
                return this;
            }

            public a a() {
                return new a(this.a, this.f56120b, this.f56121c);
            }

            public C2123a b(String str) {
                this.f56120b = str;
                return this;
            }
        }

        public a(String str, String str2, AdTemplate adTemplate) {
            this.a = str;
            this.f56118b = str2;
            this.f56119c = adTemplate;
        }
    }

    private boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mNormalMode || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.a.d.v(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.b.D() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.b.E() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, a aVar) {
        if (context == null || TextUtils.isEmpty(aVar.a) || TextUtils.isEmpty(aVar.f56118b)) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.putExtra(KEY_PAGE_TITLE, aVar.a);
        intent.putExtra(KEY_PAGE_URL, aVar.f56118b);
        intent.putExtra("key_template_json", aVar.f56119c.toJson().toString());
        context.startActivity(intent);
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (com.ksad.download.c.b.a(context)) {
            launch(context, adTemplate, 0);
        } else {
            u.a(context, v.a(context));
        }
    }

    public static void launch(Context context, AdTemplate adTemplate, int i2) {
        if (context == null || adTemplate == null) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_LANDING_PAGE_TYPE, i2);
        String str = adTemplate.mMiniWindowId;
        if (str != null) {
            intent.putExtra(KEY_MINI_WINDOW, str);
        }
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    private void showMiniWindowIfNeeded() {
        final String stringExtra = getIntent().getStringExtra(KEY_MINI_WINDOW);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        new Handler().post(new Runnable() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                DisplayMetrics displayMetrics = AdWebViewActivityProxy.this.getActivity().getResources().getDisplayMetrics();
                int i2 = displayMetrics.widthPixels;
                rect.right = i2;
                rect.left = i2 - (i2 / 4);
                int i3 = (int) (displayMetrics.heightPixels * 0.83f);
                rect.bottom = i3;
                rect.top = i3 - (((i2 / 4) * 16) / 9);
                new com.kwad.sdk.splashscreen.b(AdWebViewActivityProxy.this.getActivity(), stringExtra, false, null).a(rect);
            }
        });
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (!isFormAdExitInterceptEnable()) {
            super.onBackPressed();
            return;
        }
        com.kwad.sdk.core.page.widget.b bVar = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.2
            @Override // com.kwad.sdk.core.page.widget.b.a
            public void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.f(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.sdk.core.page.widget.b.a
            public void b(DialogInterface dialogInterface) {
                AdWebViewActivityProxy.super.onBackPressed();
                com.kwad.sdk.core.report.a.f(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.sdk.core.page.widget.b.a
            public void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.f(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
        com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
        bVar.show();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
        if (!isFormAdExitInterceptEnable()) {
            finish();
            return;
        }
        com.kwad.sdk.core.page.widget.b bVar = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.3
            @Override // com.kwad.sdk.core.page.widget.b.a
            public void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.f(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.sdk.core.page.widget.b.a
            public void b(DialogInterface dialogInterface) {
                AdWebViewActivityProxy.this.finish();
                com.kwad.sdk.core.report.a.f(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.sdk.core.page.widget.b.a
            public void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.f(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
        com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
        bVar.show();
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        c cVar;
        c.b a2;
        super.onCreate(bundle);
        this.mContext = Wrapper.wrapContextIfNeed(getActivity());
        String stringExtra = getIntent().getStringExtra("key_template_json");
        String stringExtra2 = getIntent().getStringExtra(KEY_PAGE_TITLE);
        String stringExtra3 = getIntent().getStringExtra(KEY_PAGE_URL);
        int intExtra = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        showingAdWebViewActivity = true;
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 == null) {
                finish();
                return;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate2);
            c cVar2 = new c(this.mContext, this.mAdTemplate, intExtra, true);
            this.landingPageViewHelper = cVar2;
            cVar2.a(this);
            cVar = this.landingPageViewHelper;
            a2 = new c.C2124c().b(com.kwad.sdk.core.response.a.b.j(this.mAdTemplate) ? com.kwad.sdk.core.response.a.b.i(this.mAdTemplate) : com.kwad.sdk.core.response.a.a.G(j2)).a();
        } else {
            this.mNormalMode = true;
            a2 = new c.C2124c().a(true).b(false).a(stringExtra2).b(stringExtra3).a();
            c cVar3 = new c(this.mContext, this.mAdTemplate, 1, false);
            this.landingPageViewHelper = cVar3;
            cVar3.a(this);
            cVar = this.landingPageViewHelper;
        }
        cVar.a(a2);
        setContentView(this.landingPageViewHelper.a());
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        showingAdWebViewActivity = false;
        c cVar = this.landingPageViewHelper;
        if (cVar != null) {
            cVar.g();
        }
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || !adTemplate.interactLandingPageShowing) {
            return;
        }
        adTemplate.interactLandingPageShowing = false;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        showingAdWebViewActivity = false;
        c cVar = this.landingPageViewHelper;
        if (cVar != null) {
            cVar.f();
        }
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        showingAdWebViewActivity = true;
        c cVar = this.landingPageViewHelper;
        if (cVar != null) {
            cVar.e();
        }
        if (this.mIsVPlusShown) {
            return;
        }
        showMiniWindowIfNeeded();
        this.mIsVPlusShown = true;
    }
}
