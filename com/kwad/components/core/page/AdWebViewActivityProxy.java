package com.kwad.components.core.page;

import android.app.Activity;
import android.app.Dialog;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.a.h;
import com.kwad.components.core.page.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes7.dex */
public class AdWebViewActivityProxy extends com.kwad.components.core.i.a implements c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    public static final String KEY_MINI_WINDOW = "key_mini_window";
    public static final String KEY_PAGE_TITLE = "key_page_title";
    public static final String KEY_PAGE_URL = "key_page_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean showingAdWebViewActivity;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean destroyed;
    public c landingPageViewHelper;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public boolean mIsVPlusShown;
    public Dialog mKsExitInterceptDialog;
    public Dialog mKsExitInterceptDialogV2;
    public boolean mNormalMode;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String FC;
        public String FD;
        public AdTemplate adTemplate;

        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0576a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String FC;
            public String FD;
            public AdTemplate adTemplate;

            public C0576a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public final C0576a N(AdTemplate adTemplate) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
                    this.adTemplate = adTemplate;
                    return this;
                }
                return (C0576a) invokeL.objValue;
            }

            public final C0576a ao(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    this.FC = str;
                    return this;
                }
                return (C0576a) invokeL.objValue;
            }

            public final C0576a ap(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    this.FD = str;
                    return this;
                }
                return (C0576a) invokeL.objValue;
            }

            public final a nx() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this.FC, this.FD, this.adTemplate, (byte) 0) : (a) invokeV.objValue;
            }
        }

        public a(String str, String str2, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, adTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.FC = str;
            this.FD = str2;
            this.adTemplate = adTemplate;
        }

        public /* synthetic */ a(String str, String str2, AdTemplate adTemplate, byte b) {
            this(str, str2, adTemplate);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-416404145, "Lcom/kwad/components/core/page/AdWebViewActivityProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-416404145, "Lcom/kwad/components/core/page/AdWebViewActivityProxy;");
        }
    }

    public AdWebViewActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsVPlusShown = false;
        this.destroyed = false;
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0578a(this) { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdWebViewActivityProxy FB;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.FB = this;
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0578a
            public final void a(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                    com.kwad.sdk.core.report.a.r(this.FB.mAdTemplate, 104);
                    dialogInterface.dismiss();
                }
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0578a
            public final void b(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                    try {
                        AdWebViewActivityProxy.super.onBackPressed();
                    } catch (Throwable unused) {
                    }
                    com.kwad.sdk.core.report.a.r(this.FB.mAdTemplate, 105);
                }
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0578a
            public final void c(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                    com.kwad.sdk.core.report.a.r(this.FB.mAdTemplate, 106);
                    dialogInterface.dismiss();
                }
            }
        }) : (com.kwad.components.core.page.widget.a) invokeV.objValue;
    }

    private boolean isFormAdExitInterceptEnable() {
        InterceptResult invokeV;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.mNormalMode || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.a.d.p(adTemplate)) {
                return false;
            }
            if (com.kwad.sdk.core.config.d.sa() && this.mAdTemplate.mIsFromContent) {
                return true;
            }
            return com.kwad.sdk.core.config.d.sb() && !this.mAdTemplate.mIsFromContent;
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, context, aVar) == null) || context == null || TextUtils.isEmpty(aVar.FC) || TextUtils.isEmpty(aVar.FD)) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_page_title", aVar.FC);
        intent.putExtra("key_page_url", aVar.FD);
        intent.putExtra("key_template_json", aVar.adTemplate.toJson().toString());
        context.startActivity(intent);
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, adTemplate) == null) {
            if (ae.isNetworkConnected(context)) {
                launch(context, adTemplate, 0);
                return;
            }
            Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
            t.z(wrapContextIfNeed, u.ck(wrapContextIfNeed));
        }
    }

    public static void launch(Context context, AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65546, null, context, adTemplate, i) == null) || context == null || adTemplate == null) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_LANDING_PAGE_TYPE, i);
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

    private void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.mKsExitInterceptDialog == null) {
                this.mKsExitInterceptDialog = buildDialog();
            }
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, (JSONObject) null);
            this.mKsExitInterceptDialog.show();
        }
    }

    private void showMiniWindowIfNeeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            String stringExtra = getIntent().getStringExtra(KEY_MINI_WINDOW);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            new Handler().post(new Runnable(this, stringExtra) { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String FA;
                public final /* synthetic */ AdWebViewActivityProxy FB;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, stringExtra};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.FB = this;
                    this.FA = stringExtra;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Rect rect = new Rect();
                        DisplayMetrics displayMetrics = this.FB.getActivity().getResources().getDisplayMetrics();
                        int i = displayMetrics.widthPixels;
                        rect.right = i;
                        rect.left = i - (i / 4);
                        int i2 = (int) (displayMetrics.heightPixels * 0.83f);
                        rect.bottom = i2;
                        rect.top = i2 - (((i / 4) * 16) / 9);
                        h hVar = (h) com.kwad.sdk.components.c.f(h.class);
                        if (hVar != null) {
                            hVar.a(this.FB.getActivity(), this.FA, false, rect);
                        }
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AdWebViewActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.page.c.a
    public void onBackBtnClicked(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (isFormAdExitInterceptEnable()) {
                try {
                    if (this.mKsExitInterceptDialogV2 == null) {
                        this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0578a(this) { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdWebViewActivityProxy FB;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.FB = this;
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0578a
                            public final void a(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                    com.kwad.sdk.core.report.a.r(this.FB.mAdTemplate, 104);
                                    dialogInterface.dismiss();
                                }
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0578a
                            public final void b(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                                    if (!this.FB.destroyed) {
                                        try {
                                            AdWebViewActivityProxy.super.onBackPressed();
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.e.b.printStackTrace(th);
                                        }
                                    }
                                    com.kwad.sdk.core.report.a.r(this.FB.mAdTemplate, 105);
                                }
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0578a
                            public final void c(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                                    com.kwad.sdk.core.report.a.r(this.FB.mAdTemplate, 106);
                                    dialogInterface.dismiss();
                                }
                            }
                        });
                    }
                    com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, (JSONObject) null);
                    this.mKsExitInterceptDialogV2.show();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.page.c.a
    public void onCloseBtnClicked(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (isFormAdExitInterceptEnable()) {
                showDialog();
            } else {
                finish();
            }
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            try {
                getIntent().removeExtra(AdWebViewVideoActivityProxy.KEY_TEMPLATE);
            } catch (Throwable unused) {
            }
            super.onCreate(bundle);
            getActivity().setTheme(R.style.obfuscated_res_0x7f10022f);
            this.destroyed = false;
            this.mContext = Wrapper.wrapContextIfNeed(getActivity());
            String stringExtra = getIntent().getStringExtra("key_template_json");
            String stringExtra2 = getIntent().getStringExtra("key_page_title");
            String stringExtra3 = getIntent().getStringExtra("key_page_url");
            int intExtra = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
            showingAdWebViewActivity = true;
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra));
                this.mAdTemplate = adTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
            }
            if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
                AdTemplate adTemplate2 = this.mAdTemplate;
                if (adTemplate2 == null) {
                    finish();
                    return;
                }
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate2);
                c cVar = new c(this.mContext, this.mAdTemplate, intExtra, true);
                this.landingPageViewHelper = cVar;
                cVar.a(this);
                this.landingPageViewHelper.a(new c.C0577c().ar(com.kwad.sdk.core.response.a.b.bg(this.mAdTemplate) ? com.kwad.sdk.core.response.a.b.bf(this.mAdTemplate) : com.kwad.sdk.core.response.a.a.ar(bQ)).nI());
            } else {
                this.mNormalMode = true;
                c.b nI = new c.C0577c().as(true).at(false).aq(stringExtra2).ar(stringExtra3).nI();
                c cVar2 = new c(this.mContext, this.mAdTemplate, 1, false);
                this.landingPageViewHelper = cVar2;
                cVar2.a(this);
                this.landingPageViewHelper.a(nI);
            }
            setContentView(this.landingPageViewHelper.getRootView());
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.destroyed = true;
            showingAdWebViewActivity = false;
            c cVar = this.landingPageViewHelper;
            if (cVar != null) {
                cVar.destroy();
            }
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
            if (adTemplate != null && adTemplate.interactLandingPageShowing) {
                adTemplate.interactLandingPageShowing = false;
            }
            if (!this.mIsVPlusShown || (hVar = (h) com.kwad.sdk.components.c.f(h.class)) == null) {
                return;
            }
            hVar.ag();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            showingAdWebViewActivity = false;
            c cVar = this.landingPageViewHelper;
            if (cVar != null) {
                cVar.hide();
            }
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            showingAdWebViewActivity = true;
            c cVar = this.landingPageViewHelper;
            if (cVar != null) {
                cVar.show();
            }
            if (this.mIsVPlusShown) {
                return;
            }
            showMiniWindowIfNeeded();
            this.mIsVPlusShown = true;
        }
    }
}
