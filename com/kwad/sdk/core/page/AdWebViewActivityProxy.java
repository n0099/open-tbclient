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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.page.b;
import com.kwad.sdk.core.page.widget.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes2.dex */
public class AdWebViewActivityProxy extends com.kwad.sdk.c.a implements b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    public static final String KEY_MINI_WINDOW = "key_mini_window";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public b landingPageViewHelper;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public boolean mIsVPlusShown;

    public AdWebViewActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsVPlusShown = false;
    }

    private boolean isAggregateAdOpen() {
        InterceptResult invokeV;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? d.f65521a == 2 && c.p() && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.c.s(this.mAdTemplate)) && (adTemplate = this.mAdTemplate) != null && adTemplate.mIsFromContent : invokeV.booleanValue;
    }

    private boolean isFormAdExitInterceptEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mAdTemplate == null) {
                return false;
            }
            if (c.D() && this.mAdTemplate.mIsFromContent) {
                return true;
            }
            return c.E() && !this.mAdTemplate.mIsFromContent;
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, adTemplate) == null) {
            if (com.ksad.download.d.b.a(context)) {
                launch(context, adTemplate, 0);
            } else {
                r.a(context, s.a(context));
            }
        }
    }

    public static void launch(Context context, AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, context, adTemplate, i2) == null) || context == null || adTemplate == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String stringExtra = getIntent().getStringExtra(KEY_MINI_WINDOW);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            new Handler().post(new Runnable(this, stringExtra) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f64826a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f64827b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, stringExtra};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64827b = this;
                    this.f64826a = stringExtra;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Rect rect = new Rect();
                        DisplayMetrics displayMetrics = this.f64827b.getActivity().getResources().getDisplayMetrics();
                        int i2 = displayMetrics.widthPixels;
                        rect.right = i2;
                        rect.left = i2 - (i2 / 4);
                        int i3 = (int) (displayMetrics.heightPixels * 0.83f);
                        rect.bottom = i3;
                        rect.top = i3 - (((i2 / 4) * 16) / 9);
                        new com.kwad.sdk.splashscreen.a(this.f64827b.getActivity(), this.f64826a, false, null).a(rect);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.c.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AdWebViewActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.page.b.a
    public void onBackBtnClicked(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (isAggregateAdOpen()) {
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) f.a(com.kwad.sdk.plugin.b.class);
                if (bVar != null) {
                    bVar.a(getActivity(), this.mAdTemplate, 2);
                }
                finish();
            } else if (!isFormAdExitInterceptEnable()) {
                super.onBackPressed();
            } else {
                com.kwad.sdk.core.page.widget.b bVar2 = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdWebViewActivityProxy f64828a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64828a = this;
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void a(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            com.kwad.sdk.core.report.a.e(this.f64828a.mAdTemplate, 104);
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void b(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                            AdWebViewActivityProxy.super.onBackPressed();
                            com.kwad.sdk.core.report.a.e(this.f64828a.mAdTemplate, 105);
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void c(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                            com.kwad.sdk.core.report.a.e(this.f64828a.mAdTemplate, 106);
                            dialogInterface.dismiss();
                        }
                    }
                });
                com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
                bVar2.show();
            }
        }
    }

    @Override // com.kwad.sdk.core.page.b.a
    public void onCloseBtnClicked(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (isAggregateAdOpen()) {
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) f.a(com.kwad.sdk.plugin.b.class);
                if (bVar != null) {
                    bVar.a(getActivity(), this.mAdTemplate, 2);
                }
            } else if (isFormAdExitInterceptEnable()) {
                com.kwad.sdk.core.page.widget.b bVar2 = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdWebViewActivityProxy f64829a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64829a = this;
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void a(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            com.kwad.sdk.core.report.a.e(this.f64829a.mAdTemplate, 104);
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void b(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                            this.f64829a.finish();
                            com.kwad.sdk.core.report.a.e(this.f64829a.mAdTemplate, 105);
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void c(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                            com.kwad.sdk.core.report.a.e(this.f64829a.mAdTemplate, 106);
                            dialogInterface.dismiss();
                        }
                    }
                });
                com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
                bVar2.show();
                return;
            }
            finish();
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = Wrapper.wrapContextIfNeed(getActivity());
            String stringExtra = getIntent().getStringExtra("key_template_json");
            int intExtra = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra));
                this.mAdTemplate = adTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 == null) {
                finish();
                return;
            }
            b bVar = new b(this.mContext, adTemplate2, intExtra, true);
            this.landingPageViewHelper = bVar;
            bVar.a(this);
            this.landingPageViewHelper.c();
            setContentView(this.landingPageViewHelper.a());
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b bVar = this.landingPageViewHelper;
            if (bVar != null) {
                bVar.f();
            }
            super.onDestroy();
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate.interactLandingPageShowing) {
                adTemplate.interactLandingPageShowing = false;
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b bVar = this.landingPageViewHelper;
            if (bVar != null) {
                bVar.e();
            }
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            b bVar = this.landingPageViewHelper;
            if (bVar != null) {
                bVar.d();
            }
            if (this.mIsVPlusShown) {
                return;
            }
            showMiniWindowIfNeeded();
            this.mIsVPlusShown = true;
        }
    }
}
