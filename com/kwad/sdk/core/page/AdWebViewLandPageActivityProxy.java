package com.kwad.sdk.core.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.page.kwai.d;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.KsLogoView;
import java.io.InputStream;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes3.dex */
public class AdWebViewLandPageActivityProxy extends com.kwad.sdk.core.e.a<com.kwad.sdk.reward.a> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewLandPageActivityProxy";
    public static boolean showingAdWebViewLandPage;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.download.a.b mApkDownloadHelper;
    public ImageView mBackIcon;
    public ImageView mCloseIcon;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public KSRelativeLayout mKsadVideoContainer;
    public boolean mNeedCloseReward;
    public com.kwad.sdk.reward.c.a mRewardPlayModule;
    public KSRelativeLayout mRootContainer;
    public ImageView mVideoBlurBg;
    public ImageView mVideoCover;
    public com.kwad.sdk.contentalliance.detail.video.d mVideoPlayStateListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-172929119, "Lcom/kwad/sdk/core/page/AdWebViewLandPageActivityProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-172929119, "Lcom/kwad/sdk/core/page/AdWebViewLandPageActivityProxy;");
        }
    }

    public AdWebViewLandPageActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, this, complianceTextView, kSLinearLayout, ksLogoView) == null) || com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate))) {
            return;
        }
        ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
        if (!af.e(this.mContext)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, com.kwad.sdk.a.kwai.a.a(this.mContext, 100.0f));
            ksLogoView.setLayoutParams(marginLayoutParams);
        }
        ksLogoView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
        layoutParams.gravity = 17;
        kSLinearLayout.setLayoutParams(layoutParams);
    }

    private com.kwad.sdk.contentalliance.detail.video.d getVideoPlayStateListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            e eVar = new e(this) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewLandPageActivityProxy a;

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

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.mVideoCover.setVisibility(8);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.mVideoCover.setVisibility(0);
                    }
                }
            };
            this.mVideoPlayStateListener = eVar;
            return eVar;
        }
        return (com.kwad.sdk.contentalliance.detail.video.d) invokeV.objValue;
    }

    @NonNull
    private d.a getWebViewStateListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new d.a(this) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdWebViewLandPageActivityProxy a;

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

            @Override // com.kwad.sdk.core.page.kwai.d.a
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || i2 == 1) {
                    return;
                }
                this.a.initNativeLandPage();
            }
        } : (d.a) invokeV.objValue;
    }

    private void handleCloseBtn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            long t = com.kwad.sdk.core.config.b.t() * 1000;
            if (t == 0) {
                this.mCloseIcon.setVisibility(0);
            } else {
                this.mCloseIcon.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdWebViewLandPageActivityProxy a;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.getActivity() == null || this.a.getActivity().isFinishing()) {
                            return;
                        }
                        this.a.mCloseIcon.setVisibility(0);
                        this.a.mCloseIcon.setAlpha(0.0f);
                        this.a.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, t);
            }
            this.mCloseIcon.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewLandPageActivityProxy a;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        com.kwad.sdk.reward.b.a().b();
                        this.a.finish();
                    }
                }
            });
        }
    }

    private boolean initData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            this.mNeedCloseReward = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
            try {
                AdTemplate adTemplate = new AdTemplate();
                if (stringExtra != null) {
                    adTemplate.parseJson(new JSONObject(stringExtra));
                }
                this.mAdTemplate = adTemplate;
                this.mAdInfo = com.kwad.sdk.core.response.a.d.j(adTemplate);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            findViewById(R.id.ksad_ad_land_page_native).setVisibility(0);
            ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_cover);
            KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.ksad_info_container);
            KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_land_page_logo);
            DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
            setAdTitle((TextView) findViewById(R.id.ksad_ad_title), j2);
            ((TextView) findViewById(R.id.ksad_ad_info)).setText(j2.adBaseInfo.adDescription);
            roundAngleImageView.setRadius(32.0f);
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.au(j2))) {
                KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.a.a.au(j2), this.mAdTemplate);
            }
            setAdkDownload(downloadProgressBar, j2);
            buildView(complianceTextView, kSLinearLayout, ksLogoView);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mRootContainer = (KSRelativeLayout) findViewById(R.id.ksad_root_container);
            this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
            this.mDetailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
            this.mVideoBlurBg = (ImageView) this.mRootContainer.findViewById(R.id.ksad_video_blur_bg);
            this.mBackIcon = (ImageView) this.mRootContainer.findViewById(R.id.ksad_back_icon);
            this.mCloseIcon = (ImageView) this.mRootContainer.findViewById(R.id.ksad_right_close);
            this.mVideoCover = (ImageView) this.mRootContainer.findViewById(R.id.ksad_video_cover);
            if (this.mAdTemplate.adInfoList.size() > 0) {
                loadBlurImage(com.kwad.sdk.core.response.a.a.h(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
            }
            this.mBackIcon.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewLandPageActivityProxy a;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 153);
                        this.a.finish();
                    }
                }
            });
            if (com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate))) {
                setVideoData();
            }
            if (this.mNeedCloseReward) {
                handleCloseBtn();
            }
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, adTemplate) == null) {
            launch(context, adTemplate, false);
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65552, null, context, adTemplate, z) == null) {
            Class cls = af.e(context) ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
            KsAdSDKImpl.putComponentProxy(cls, AdWebViewLandPageActivityProxy.class);
            Intent intent = new Intent(context, cls);
            intent.addFlags(268435456);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            intent.putExtra(KEY_NEED_CLOSE_REWARD, z);
            context.startActivity(intent);
        }
    }

    private void loadBlurImage(String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, this, str, imageView) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdWebViewLandPageActivityProxy a;

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

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
                return invokeLLL.booleanValue;
            }
        });
    }

    private void setAdTitle(TextView textView, AdInfo adInfo) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, textView, adInfo) == null) {
            if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
                str = adInfo.adBaseInfo.appName;
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
                return;
            } else {
                str = adInfo.advertiserInfo.rawUserName;
            }
            textView.setText(str);
        }
    }

    private void setAdkDownload(DownloadProgressBar downloadProgressBar, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, this, downloadProgressBar, adInfo) == null) && com.kwad.sdk.core.response.a.a.B(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.sdk.core.download.a.b(this.mAdTemplate, new com.kwad.sdk.core.download.a.c(this, downloadProgressBar, adInfo) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DownloadProgressBar f58107b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdInfo f58108c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ AdWebViewLandPageActivityProxy f58109d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadProgressBar, adInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58109d = this;
                    this.f58107b = downloadProgressBar;
                    this.f58108c = adInfo;
                }

                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f58107b.setProgress(i2);
                        this.f58107b.setText(com.kwad.sdk.core.response.a.a.b(i2));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f58107b.setProgress(100.0f);
                        this.f58107b.setText(com.kwad.sdk.core.response.a.a.A(this.f58108c));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f58107b.setProgress(100.0f);
                        this.f58107b.setText(com.kwad.sdk.core.response.a.a.a(this.f58109d.mAdTemplate));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f58107b.setProgress(100.0f);
                        this.f58107b.setText(com.kwad.sdk.core.response.a.a.A(this.f58108c));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f58107b.setProgress(100.0f);
                        this.f58107b.setText(com.kwad.sdk.core.response.a.a.m(this.f58108c));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f58107b.setProgress(i2);
                        this.f58107b.setText(com.kwad.sdk.core.response.a.a.a(i2));
                    }
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewLandPageActivityProxy a;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        com.kwad.sdk.core.report.a.f(this.a.mAdTemplate, 152);
                        this.a.mApkDownloadHelper.a(this.a.mContext, true);
                    }
                }
            });
        }
    }

    private void setVideoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
            if (af.e(this.mContext)) {
                layoutParams.height = (com.kwad.sdk.a.kwai.a.c(this.mContext) * 9) / 16;
                layoutParams.width = -1;
                this.mDetailVideoView.a(true);
            } else {
                layoutParams.width = com.kwad.sdk.a.kwai.a.c(this.mContext) / 2;
                layoutParams.height = -1;
                this.mDetailVideoView.setHorizontalVideo(true);
            }
            this.mKsadVideoContainer.setLayoutParams(layoutParams);
            this.mKsadVideoContainer.setVisibility(0);
            KSImageLoader.loadImage(this.mVideoCover, com.kwad.sdk.core.response.a.a.aa(this.mAdInfo).a(), this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(getActivity());
            this.mContext = wrapContextIfNeed;
            showingAdWebViewLandPage = true;
            setContentView(af.e(wrapContextIfNeed) ? R.layout.ksad_activity_ad_land_page : R.layout.ksad_activity_land_page_horizontal);
            if (!initData()) {
                finish();
                return;
            }
            initView();
            onActivityCreated(this.mRootContainer);
        }
    }

    @Override // com.kwad.sdk.core.e.a
    public com.kwad.sdk.reward.a onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.sdk.reward.a aVar = new com.kwad.sdk.reward.a();
            aVar.f59456h = getActivity();
            aVar.f59457i = this.mContext;
            AdTemplate adTemplate = this.mAdTemplate;
            aVar.f59455g = adTemplate;
            aVar.r = false;
            if (com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
                com.kwad.sdk.utils.b.a(this.mContext).a(true);
                com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
                this.mRewardPlayModule = aVar2;
                aVar.f59459k = aVar2;
                aVar2.a(getVideoPlayStateListener());
                aVar.a.add(this.mRewardPlayModule);
            }
            return aVar;
        }
        return (com.kwad.sdk.reward.a) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Presenter presenter = new Presenter();
            if (com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate))) {
                presenter.a((Presenter) new com.kwad.sdk.core.page.kwai.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.core.page.kwai.d(getWebViewStateListener()));
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            showingAdWebViewLandPage = false;
            com.kwad.sdk.core.download.a.b bVar = this.mApkDownloadHelper;
            if (bVar != null) {
                bVar.i();
            }
            com.kwad.sdk.reward.c.a aVar = this.mRewardPlayModule;
            if (aVar != null) {
                aVar.e();
            }
        }
    }
}
