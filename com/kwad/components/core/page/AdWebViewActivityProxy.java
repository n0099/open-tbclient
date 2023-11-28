package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.c.f;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes10.dex */
public class AdWebViewActivityProxy extends com.kwad.components.core.proxy.c {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    public static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    public static final String KEY_PAGE_TITLE = "key_page_title";
    public static final String KEY_PAGE_URL = "key_page_url";
    public static final String KEY_SHOW_PERMISSION = "key_show_permission";
    public static final String KEY_SHOW_TK_CONFIRM_DIALOG = "key_show_tk_confirm_dialog";
    public static final String KEY_TEMPLATE = "key_template_json";
    public AdResultData mAdResultData;
    public AdTemplate mAdTemplate;
    public boolean mAutoShow;
    public com.kwad.components.core.q.b mDialogFragment;
    public boolean mDisableShowConfirmDialog;
    public boolean mHasShowShowConfirmDialog;
    public Dialog mKsExitInterceptDialog;
    public Dialog mKsExitInterceptDialogV2;
    public int mLandingPageType;
    public c mLandingPageView;
    public String mPageTitle;
    public String mPageUrl;
    public boolean mShowPermission;
    public volatile boolean destroyed = false;
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    public com.kwad.components.core.page.a.a mLandPageViewListener = new com.kwad.components.core.page.a.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.a.a
        public final void oS() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.a
        public final void oT() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.pc();
            } else if (AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                AdWebViewActivityProxy.this.finish();
            } else if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
            } else {
                if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                    AdWebViewActivityProxy.this.finish();
                } else if (com.kwad.sdk.core.response.b.a.aO(e.dP(AdWebViewActivityProxy.this.mAdTemplate)) && com.kwad.components.core.q.a.qu().qv() == 1 && com.kwad.components.core.q.a.qu().qA() && !com.kwad.components.core.q.a.qu().qx()) {
                    if (!com.kwad.components.core.q.a.qu().qw() && com.kwad.sdk.core.config.d.AM()) {
                        AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                        adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                        com.kwad.components.core.q.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
                        return;
                    }
                    AdWebViewActivityProxy.this.finish();
                } else if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                    AdWebViewActivityProxy.this.showDialog();
                } else {
                    AdWebViewActivityProxy.this.finish();
                }
            }
        }
    };
    public com.kwad.components.core.webview.tachikoma.e.c mBaseDialogListener = new com.kwad.components.core.webview.tachikoma.e.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void F(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void fY() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void fP() {
            com.kwad.components.core.q.a.qu().aK(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void fX() {
            com.kwad.components.core.q.a.qu().aK(false);
        }
    };

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    /* loaded from: classes10.dex */
    public static class a {
        public String NY;
        public String NZ;
        public AdResultData Oa;
        public boolean Ob;
        public boolean Oc;
        public int Od;
        public boolean Oe;
        public AdTemplate adTemplate;

        public a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.Oa = adResultData;
            this.adTemplate = com.kwad.sdk.core.response.b.c.m(adResultData);
        }

        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0655a {
            public String NY;
            public String NZ;
            public AdResultData Oa;
            public boolean Oc;
            public int Od = 0;
            public boolean Oe;
            public boolean Of;
            public AdTemplate adTemplate;

            public final C0655a aB(boolean z) {
                this.Of = z;
                return this;
            }

            public final C0655a aC(boolean z) {
                this.Oc = z;
                return this;
            }

            public final C0655a aD(boolean z) {
                this.Oe = z;
                return this;
            }

            public final C0655a al(String str) {
                this.NY = str;
                return this;
            }

            public final C0655a am(String str) {
                this.NZ = str;
                return this;
            }

            public final C0655a as(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }

            public final C0655a av(int i) {
                this.Od = i;
                return this;
            }

            public final C0655a l(AdResultData adResultData) {
                this.Oa = adResultData;
                return this;
            }

            public final a pa() {
                AdResultData adResultData = this.Oa;
                if (adResultData != null) {
                    return new a(this.NY, this.NZ, adResultData, this.Of, this.Oc, this.Oe, this.Od, (byte) 0);
                }
                return new a(this.NY, this.NZ, this.adTemplate, this.Of, this.Oc, this.Oe, this.Od, (byte) 0);
            }
        }

        public /* synthetic */ a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adResultData, z, z2, z3, i);
        }

        public a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.adTemplate = adTemplate;
        }

        public /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adTemplate, z, z2, z3, i);
        }

        public a(String str, String str2, boolean z, boolean z2, boolean z3, int i) {
            this.NY = str;
            this.NZ = str2;
            this.Ob = z;
            this.Oc = z2;
            this.Oe = z3;
            this.Od = i;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final String oU() {
            return this.NY;
        }

        public final String oV() {
            return this.NZ;
        }

        public final int oW() {
            return this.Od;
        }

        public final boolean oX() {
            return this.Ob;
        }

        public final boolean oY() {
            return this.Oe;
        }

        public final boolean oZ() {
            return this.Oc;
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0658a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.s(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.report.a.s(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.s(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.q.b getTkDialogFragment() {
        e.b bVar = new e.b();
        bVar.d(this.mAdResultData);
        bVar.aN(com.kwad.sdk.core.response.b.b.dv(this.mAdTemplate));
        bVar.aV(false);
        bVar.aW(true);
        return com.kwad.components.core.q.b.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.b.e.F(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.AS() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        if (!com.kwad.sdk.core.config.d.AT() || this.mAdTemplate.mIsFromContent) {
            return false;
        }
        return true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        setContentView(R.layout.obfuscated_res_0x7f0d04a6);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.h.a.l(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        this.destroyed = true;
        Dialog dialog = this.mKsExitInterceptDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mKsExitInterceptDialog.dismiss();
        }
        Dialog dialog2 = this.mKsExitInterceptDialogV2;
        if (dialog2 != null && dialog2.isShowing()) {
            this.mKsExitInterceptDialogV2.dismiss();
        }
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.interactLandingPageShowing = false;
            adTemplate.mIsForceJumpLandingPage = false;
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        AdResultData d = f.mB().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = d;
        if (d == null) {
            return false;
        }
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(d);
        this.mAdTemplate = m;
        if (m == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0655a().am(com.kwad.sdk.core.response.b.b.cA(adTemplate)).as(adTemplate).pa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMiddlePageDialog() {
        boolean z = false;
        if (this.mAdTemplate == null || !com.kwad.sdk.core.config.d.AM()) {
            return false;
        }
        if (!bg.isNullString(com.kwad.sdk.core.response.b.a.bZ(this.mAdTemplate)) && com.kwad.sdk.core.response.b.a.bY(this.mAdTemplate)) {
            z = true;
            if (this.mHasShowShowConfirmDialog) {
                try {
                    super.onBackPressed();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            } else {
                com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
                this.mDialogFragment = tkDialogFragment;
                com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                this.mHasShowShowConfirmDialog = true;
            }
        }
        return z;
    }

    private void initContentView() {
        c a2 = c.a(this.mContext, new a.C0655a().al(this.mPageTitle).am(this.mPageUrl).as(this.mAdTemplate).aB(this.mShowPermission).aC(this.mAutoShow).av(this.mLandingPageType).aD(this.mDisableShowConfirmDialog).pa());
        this.mLandingPageView = a2;
        a2.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        ((ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913a9)).addView(this.mLandingPageView);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra(KEY_SHOW_TK_CONFIRM_DIALOG, false);
    }

    public static void launch(Context context, a aVar) {
        if (context != null && !TextUtils.isEmpty(aVar.NZ)) {
            try {
                com.kwad.sdk.commercial.h.a.k(aVar.getAdTemplate(), aVar.oW(), aVar.oV());
                com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
                Intent intent = new Intent(context, AdWebViewActivity.class);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.putExtra(KEY_PAGE_TITLE, aVar.NY);
                intent.putExtra(KEY_LANDING_PAGE_TYPE, aVar.Od);
                intent.putExtra(KEY_PAGE_URL, aVar.NZ);
                intent.putExtra(KEY_IS_AUTO_SHOW, aVar.Oc);
                intent.putExtra(KEY_SHOW_PERMISSION, aVar.Ob);
                intent.putExtra(KEY_SHOW_TK_CONFIRM_DIALOG, aVar.oY());
                AdResultData adResultData = aVar.Oa;
                if (adResultData == null) {
                    adResultData = com.kwad.sdk.core.response.b.c.dA(aVar.adTemplate);
                }
                intent.putExtra("key_ad_result_cache_idx", f.mB().i(adResultData));
                context.startActivity(intent);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                com.kwad.sdk.commercial.h.a.a(aVar.getAdTemplate(), aVar.oW(), aVar.oV(), bn.s(th));
                if (KsAdSDKImpl.get().getIsExternal()) {
                    try {
                        ServiceProvider.b(th);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.pc();
        } else if (this.mDisableShowConfirmDialog) {
            finish();
        } else if (handleMiddlePageDialog()) {
        } else {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null && !adTemplate.mIsForceJumpLandingPage) {
                if (com.kwad.sdk.core.response.b.a.aO(com.kwad.sdk.core.response.b.e.dP(adTemplate)) && com.kwad.components.core.q.a.qu().qv() == 1 && com.kwad.components.core.q.a.qu().qA() && !com.kwad.components.core.q.a.qu().qx()) {
                    if (!com.kwad.components.core.q.a.qu().qw() && com.kwad.sdk.core.config.d.AM()) {
                        com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
                        this.mDialogFragment = tkDialogFragment;
                        com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                        return;
                    }
                    super.onBackPressed();
                    return;
                }
                if (isFormAdExitInterceptEnable()) {
                    try {
                        if (this.mKsExitInterceptDialogV2 == null) {
                            this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0658a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                                @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
                                public final void a(DialogInterface dialogInterface) {
                                    com.kwad.sdk.core.report.a.s(AdWebViewActivityProxy.this.mAdTemplate, 104);
                                    dialogInterface.dismiss();
                                }

                                @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
                                public final void b(DialogInterface dialogInterface) {
                                    if (!AdWebViewActivityProxy.this.destroyed) {
                                        try {
                                            AdWebViewActivityProxy.super.onBackPressed();
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.e.c.printStackTrace(th);
                                        }
                                    }
                                    com.kwad.sdk.core.report.a.s(AdWebViewActivityProxy.this.mAdTemplate, 105);
                                }

                                @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
                                public final void c(DialogInterface dialogInterface) {
                                    com.kwad.sdk.core.report.a.s(AdWebViewActivityProxy.this.mAdTemplate, 106);
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
                        this.mKsExitInterceptDialogV2.show();
                        return;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
                super.onBackPressed();
                return;
            }
            super.onBackPressed();
        }
    }
}
