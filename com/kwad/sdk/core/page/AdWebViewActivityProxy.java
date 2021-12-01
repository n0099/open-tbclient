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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import com.kwad.sdk.core.page.c;
import com.kwad.sdk.core.page.widget.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes2.dex */
public class AdWebViewActivityProxy extends com.kwad.sdk.h.a implements c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    public static final String KEY_MINI_WINDOW = "key_mini_window";
    public static final String KEY_PAGE_TITLE = "key_page_title";
    public static final String KEY_PAGE_URL = "key_page_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean showingAdWebViewActivity;
    public transient /* synthetic */ FieldHolder $fh;
    public c landingPageViewHelper;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public boolean mIsVPlusShown;
    public boolean mNormalMode;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57522b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f57523c;

        /* renamed from: com.kwad.sdk.core.page.AdWebViewActivityProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C2022a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f57524b;

            /* renamed from: c  reason: collision with root package name */
            public AdTemplate f57525c;

            public C2022a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public C2022a a(AdTemplate adTemplate) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
                    this.f57525c = adTemplate;
                    return this;
                }
                return (C2022a) invokeL.objValue;
            }

            public C2022a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    this.a = str;
                    return this;
                }
                return (C2022a) invokeL.objValue;
            }

            public a a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this.a, this.f57524b, this.f57525c) : (a) invokeV.objValue;
            }

            public C2022a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    this.f57524b = str;
                    return this;
                }
                return (C2022a) invokeL.objValue;
            }
        }

        public a(String str, String str2, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, adTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f57522b = str2;
            this.f57523c = adTemplate;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(15735015, "Lcom/kwad/sdk/core/page/AdWebViewActivityProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(15735015, "Lcom/kwad/sdk/core/page/AdWebViewActivityProxy;");
        }
    }

    public AdWebViewActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsVPlusShown = false;
    }

    private boolean isFormAdExitInterceptEnable() {
        InterceptResult invokeV;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mNormalMode || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.a.d.v(adTemplate)) {
                return false;
            }
            if (com.kwad.sdk.core.config.b.D() && this.mAdTemplate.mIsFromContent) {
                return true;
            }
            return com.kwad.sdk.core.config.b.E() && !this.mAdTemplate.mIsFromContent;
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, context, aVar) == null) || context == null || TextUtils.isEmpty(aVar.a) || TextUtils.isEmpty(aVar.f57522b)) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.putExtra(KEY_PAGE_TITLE, aVar.a);
        intent.putExtra(KEY_PAGE_URL, aVar.f57522b);
        intent.putExtra("key_template_json", aVar.f57523c.toJson().toString());
        context.startActivity(intent);
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, adTemplate) == null) {
            if (com.ksad.download.c.b.a(context)) {
                launch(context, adTemplate, 0);
            } else {
                u.a(context, v.a(context));
            }
        }
    }

    public static void launch(Context context, AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, null, context, adTemplate, i2) == null) || context == null || adTemplate == null) {
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
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            String stringExtra = getIntent().getStringExtra(KEY_MINI_WINDOW);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            new Handler().post(new Runnable(this, stringExtra) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f57521b;

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
                    this.f57521b = this;
                    this.a = stringExtra;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Rect rect = new Rect();
                        DisplayMetrics displayMetrics = this.f57521b.getActivity().getResources().getDisplayMetrics();
                        int i2 = displayMetrics.widthPixels;
                        rect.right = i2;
                        rect.left = i2 - (i2 / 4);
                        int i3 = (int) (displayMetrics.heightPixels * 0.83f);
                        rect.bottom = i3;
                        rect.top = i3 - (((i2 / 4) * 16) / 9);
                        new com.kwad.sdk.splashscreen.b(this.f57521b.getActivity(), this.a, false, null).a(rect);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AdWebViewActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.page.c.a
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
            if (!isFormAdExitInterceptEnable()) {
                super.onBackPressed();
                return;
            }
            com.kwad.sdk.core.page.widget.b bVar = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewActivityProxy a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 104);
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                        AdWebViewActivityProxy.super.onBackPressed();
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 105);
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 106);
                        dialogInterface.dismiss();
                    }
                }
            });
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
            bVar.show();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (!isFormAdExitInterceptEnable()) {
                finish();
                return;
            }
            com.kwad.sdk.core.page.widget.b bVar = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewActivityProxy a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 104);
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                        this.a.finish();
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 105);
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 106);
                        dialogInterface.dismiss();
                    }
                }
            });
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
            bVar.show();
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        c cVar;
        c.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
                a2 = new c.C2023c().b(com.kwad.sdk.core.response.a.b.j(this.mAdTemplate) ? com.kwad.sdk.core.response.a.b.i(this.mAdTemplate) : com.kwad.sdk.core.response.a.a.G(j2)).a();
            } else {
                this.mNormalMode = true;
                a2 = new c.C2023c().a(true).b(false).a(stringExtra2).b(stringExtra3).a();
                c cVar3 = new c(this.mContext, this.mAdTemplate, 1, false);
                this.landingPageViewHelper = cVar3;
                cVar3.a(this);
                cVar = this.landingPageViewHelper;
            }
            cVar.a(a2);
            setContentView(this.landingPageViewHelper.a());
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            showingAdWebViewActivity = false;
            c cVar = this.landingPageViewHelper;
            if (cVar != null) {
                cVar.f();
            }
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
}
