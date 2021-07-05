package com.kwad.sdk.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.d;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.widget.DownloadProgressBar;
import java.io.Serializable;
import java.util.List;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes7.dex */
public class AdWebViewVideoActivityProxy extends IFragmentActivityProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template";
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public b mApkDownloadHelper;
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
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.mProgressbar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
            this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.ksad_web_download_container);
            AdInfo j = c.j(this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.y(j)) {
                this.mWebDownloadContainer.setVisibility(0);
                this.mApkDownloadHelper = new b(this.mAdTemplate, new com.kwad.sdk.core.download.b.c(this, j) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdInfo f36376a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AdWebViewVideoActivityProxy f36377b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, j};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36377b = this;
                        this.f36376a = j;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f36377b.mProgressbar.setProgress(i2);
                            this.f36377b.mProgressbar.setText(com.kwad.sdk.core.response.b.a.c(i2));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f36377b.mProgressbar.setProgress(100.0f);
                            this.f36377b.mProgressbar.setText(com.kwad.sdk.core.response.b.a.w(this.f36376a));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f36377b.mProgressbar.setProgress(100.0f);
                            this.f36377b.mProgressbar.setText(com.kwad.sdk.core.response.b.a.a(this.f36377b.mAdTemplate));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f36377b.mProgressbar.setProgress(100.0f);
                            this.f36377b.mProgressbar.setText(com.kwad.sdk.core.response.b.a.w(this.f36376a));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f36377b.mProgressbar.setProgress(100.0f);
                            this.f36377b.mProgressbar.setText(com.kwad.sdk.core.response.b.a.b());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f36377b.mProgressbar.setProgress(i2);
                            this.f36377b.mProgressbar.setText(com.kwad.sdk.core.response.b.a.a(i2));
                        }
                    }
                });
                this.mProgressbar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdWebViewVideoActivityProxy f36378a;

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
                        this.f36378a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            b.a(this.f36378a.mApkDownloadHelper, true);
                            this.f36378a.mApkDownloadHelper.a(this.f36378a.getActivity());
                        }
                    }
                });
                this.mApkDownloadHelper.a(getActivity());
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
                        public final /* synthetic */ AdWebViewVideoActivityProxy f36379a;

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
                            this.f36379a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f36379a.finish();
                            }
                        }
                    });
                    imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdWebViewVideoActivityProxy f36380a;

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
                            this.f36380a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f36380a.onBackPressed();
                            }
                        }
                    });
                    x.b(getActivity());
                    d.a(getActivity(), 0, true);
                    int i2 = R.id.ksad_recycler_container;
                    a a2 = a.a(this.mAdTemplate);
                    this.mFragment = a2;
                    a2.a(this.mApkDownloadHelper);
                    getSupportFragmentManager().beginTransaction().replace(i2, this.mFragment).commitAllowingStateLoss();
                }
            }
            textView.setText("详情页面");
            imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewVideoActivityProxy f36379a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i22 = newInitContext.flag;
                        if ((i22 & 1) != 0) {
                            int i3 = i22 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36379a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f36379a.finish();
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewVideoActivityProxy f36380a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i22 = newInitContext.flag;
                        if ((i22 & 1) != 0) {
                            int i3 = i22 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36380a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f36380a.onBackPressed();
                    }
                }
            });
            x.b(getActivity());
            d.a(getActivity(), 0, true);
            int i22 = R.id.ksad_recycler_container;
            a a22 = a.a(this.mAdTemplate);
            this.mFragment = a22;
            a22.a(this.mApkDownloadHelper);
            getSupportFragmentManager().beginTransaction().replace(i22, this.mFragment).commitAllowingStateLoss();
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, adTemplate) == null) || context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("key_template", adTemplate);
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.mFragment;
            if (aVar == null || !aVar.a()) {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            setContentView(R.layout.ksad_activity_ad_video_webview);
            Serializable serializableExtra = getIntent().getSerializableExtra("key_template");
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

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            b bVar = this.mApkDownloadHelper;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            overridePendingTransition(0, 0);
        }
    }
}
