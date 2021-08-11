package com.kwad.sdk.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.page.widget.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.d;
import com.kwad.sdk.widget.DownloadProgressBar;
import java.io.Serializable;
import java.util.List;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes10.dex */
public class AdWebViewVideoActivityProxy extends com.kwad.sdk.c.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template";
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.download.b.b mApkDownloadHelper;
    public a mFragment;
    public DownloadProgressBar mProgressbar;
    public ViewGroup mWebDownloadContainer;

    public AdWebViewVideoActivityProxy() {
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

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mProgressbar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
            this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.ksad_web_download_container);
            AdInfo i2 = c.i(this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.v(i2)) {
                this.mWebDownloadContainer.setVisibility(0);
                this.mApkDownloadHelper = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, new com.kwad.sdk.core.download.b.c(this, i2) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AdInfo f71635b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdWebViewVideoActivityProxy f71636c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, i2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f71636c = this;
                        this.f71635b = i2;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                            this.f71636c.mProgressbar.setProgress(i3);
                            this.f71636c.mProgressbar.setText(com.kwad.sdk.core.response.b.a.b(i3));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f71636c.mProgressbar.setProgress(100.0f);
                            this.f71636c.mProgressbar.setText(com.kwad.sdk.core.response.b.a.u(this.f71635b));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f71636c.mProgressbar.setProgress(100.0f);
                            this.f71636c.mProgressbar.setText(com.kwad.sdk.core.response.b.a.a(this.f71636c.mAdTemplate));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f71636c.mProgressbar.setProgress(100.0f);
                            this.f71636c.mProgressbar.setText(com.kwad.sdk.core.response.b.a.u(this.f71635b));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f71636c.mProgressbar.setProgress(100.0f);
                            this.f71636c.mProgressbar.setText(com.kwad.sdk.core.response.b.a.j(this.f71635b));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i3) == null) {
                            this.f71636c.mProgressbar.setProgress(i3);
                            this.f71636c.mProgressbar.setText(com.kwad.sdk.core.response.b.a.a(i3));
                        }
                    }
                });
                this.mProgressbar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdWebViewVideoActivityProxy f71637a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f71637a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f71637a.mApkDownloadHelper.a((Context) this.f71637a.getActivity(), true);
                        }
                    }
                });
                this.mApkDownloadHelper.a((Context) getActivity(), false);
            } else {
                this.mWebDownloadContainer.setVisibility(8);
            }
            TextView textView = (TextView) findViewById(R.id.ksad_kwad_titlebar_title);
            ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_web_navi_back);
            ImageView imageView2 = (ImageView) findViewById(R.id.ksad_kwad_web_navi_close);
            List<AdInfo> list = this.mAdTemplate.adInfoList;
            if (list != null && list.size() > 0 && this.mAdTemplate.adInfoList.get(0) != null) {
                AdInfo.AdBaseInfo adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo;
                if (!TextUtils.isEmpty(adBaseInfo.productName)) {
                    textView.setText(adBaseInfo.productName);
                    imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdWebViewVideoActivityProxy f71638a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f71638a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f71638a.finish();
                            }
                        }
                    });
                    imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdWebViewVideoActivityProxy f71639a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f71639a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f71639a.onBackPressed();
                            }
                        }
                    });
                    ab.b(getActivity());
                    d.a(getActivity(), 0, true);
                    int i3 = R.id.ksad_recycler_container;
                    a a2 = a.a(this.mAdTemplate);
                    this.mFragment = a2;
                    a2.a(this.mApkDownloadHelper);
                    getSupportFragmentManager().beginTransaction().replace(i3, this.mFragment).commitAllowingStateLoss();
                }
            }
            textView.setText("详情页面");
            imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewVideoActivityProxy f71638a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i32 = newInitContext.flag;
                        if ((i32 & 1) != 0) {
                            int i4 = i32 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f71638a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f71638a.finish();
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewVideoActivityProxy f71639a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i32 = newInitContext.flag;
                        if ((i32 & 1) != 0) {
                            int i4 = i32 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f71639a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f71639a.onBackPressed();
                    }
                }
            });
            ab.b(getActivity());
            d.a(getActivity(), 0, true);
            int i32 = R.id.ksad_recycler_container;
            a a22 = a.a(this.mAdTemplate);
            this.mFragment = a22;
            a22.a(this.mApkDownloadHelper);
            getSupportFragmentManager().beginTransaction().replace(i32, this.mFragment).commitAllowingStateLoss();
        }
    }

    private boolean isFormAdExitInterceptEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.mAdTemplate == null) {
                return false;
            }
            if (com.kwad.sdk.core.config.c.D() && this.mAdTemplate.mIsFromContent) {
                return true;
            }
            return com.kwad.sdk.core.config.c.E() && !this.mAdTemplate.mIsFromContent;
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, context, adTemplate) == null) || context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(268435456);
        intent.putExtra(KEY_TEMPLATE, adTemplate);
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    private void showWaitDialog() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && isFormAdExitInterceptEnable()) {
            com.kwad.sdk.core.page.widget.b bVar = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewVideoActivityProxy f71640a;

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
                    this.f71640a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.e(this.f71640a.mAdTemplate, 104);
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                        AdWebViewVideoActivityProxy.super.onBackPressed();
                        com.kwad.sdk.core.report.a.e(this.f71640a.mAdTemplate, 105);
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.e(this.f71640a.mAdTemplate, 106);
                        dialogInterface.dismiss();
                    }
                }
            });
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
            bVar.show();
        }
    }

    @Override // com.kwad.sdk.c.b
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AdWebViewVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.c.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.mFragment;
            if (aVar == null || !aVar.a_()) {
                showWaitDialog();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.sdk.c.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.ksad_activity_ad_video_webview);
            Serializable serializableExtra = getIntent().getSerializableExtra(KEY_TEMPLATE);
            if (!(serializableExtra instanceof AdTemplate)) {
                finish();
                return;
            }
            AdTemplate adTemplate = (AdTemplate) serializableExtra;
            this.mAdTemplate = adTemplate;
            adTemplate.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
            initView();
        }
    }

    @Override // com.kwad.sdk.c.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            com.kwad.sdk.core.download.b.b bVar = this.mApkDownloadHelper;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            overridePendingTransition(0, 0);
        }
    }
}
