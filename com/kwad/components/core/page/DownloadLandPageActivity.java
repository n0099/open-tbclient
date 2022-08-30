package com.kwad.components.core.page;

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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.kwai.e;
import com.kwad.components.core.page.kwai.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes7.dex */
public class DownloadLandPageActivity extends com.kwad.components.core.g.b<com.kwad.components.core.page.kwai.d> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "DownloadLandPageActivity";
    public static boolean showingAdWebViewLandPage;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public ImageView mBackIcon;
    public ImageView mCloseIcon;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsRewardLandPage;
    public KSRelativeLayout mKsadVideoContainer;
    public com.kwad.components.core.page.a.a mPlayModule;
    public KSRelativeLayout mRootContainer;
    public ImageView mVideoBlurBg;
    public ImageView mVideoCover;
    public g mVideoPlayStateListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-994214937, "Lcom/kwad/components/core/page/DownloadLandPageActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-994214937, "Lcom/kwad/components/core/page/DownloadLandPageActivity;");
        }
    }

    public DownloadLandPageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, this, complianceTextView, kSLinearLayout, ksLogoView) == null) || com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
            return;
        }
        ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
        if (!ag.cB(this.mContext)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, com.kwad.sdk.b.kwai.a.a(this.mContext, 100.0f));
            ksLogoView.setLayoutParams(marginLayoutParams);
        }
        ksLogoView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
        layoutParams.gravity = 17;
        kSLinearLayout.setLayoutParams(layoutParams);
    }

    private g getVideoPlayStateListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            h hVar = new h(this) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadLandPageActivity FF;

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
                    this.FF = this;
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void onVideoPlayCompleted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.FF.mVideoCover.setVisibility(0);
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void onVideoPlayError(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void onVideoPlayStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.FF.mVideoCover.setVisibility(8);
                    }
                }
            };
            this.mVideoPlayStateListener = hVar;
            return hVar;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    private f.a getWebViewStateListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new f.a(this) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadLandPageActivity FF;

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
                this.FF = this;
            }

            @Override // com.kwad.components.core.page.kwai.f.a
            public final void aj(int i) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) || i == 1) {
                    return;
                }
                this.FF.initNativeLandPage();
            }
        } : (f.a) invokeV.objValue;
    }

    private void handleCloseBtn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            long X = com.kwad.sdk.core.response.a.a.X(this.mAdInfo);
            if (X == 0) {
                this.mCloseIcon.setVisibility(0);
            } else {
                this.mCloseIcon.postDelayed(new Runnable(this) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadLandPageActivity FF;

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
                        this.FF = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.FF.getActivity() == null || this.FF.getActivity().isFinishing()) {
                            return;
                        }
                        this.FF.mCloseIcon.setVisibility(0);
                        this.FF.mCloseIcon.setAlpha(0.0f);
                        this.FF.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, X);
            }
            this.mCloseIcon.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadLandPageActivity FF;

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
                    this.FF = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        com.kwad.components.core.m.d.oy().oz();
                        this.FF.finish();
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
            this.mIsRewardLandPage = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
            try {
                AdTemplate adTemplate = new AdTemplate();
                if (stringExtra != null) {
                    adTemplate.parseJson(new JSONObject(stringExtra));
                }
                this.mAdTemplate = adTemplate;
                this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f091036).setVisibility(0);
            ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f091069);
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f091028);
            KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.obfuscated_res_0x7f0910a1);
            KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0910cb);
            DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091223);
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            setAdTitle((TextView) findViewById(R.id.obfuscated_res_0x7f09103d), bQ);
            ((TextView) findViewById(R.id.obfuscated_res_0x7f091033)).setText(bQ.adBaseInfo.adDescription);
            roundAngleImageView.setRadius(32.0f);
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.bn(bQ))) {
                KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.a.a.bn(bQ), this.mAdTemplate);
            }
            setAdkDownload(downloadProgressBar, bQ);
            buildView(complianceTextView, kSLinearLayout, ksLogoView);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mRootContainer = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0911b8);
            this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0911f7);
            this.mDetailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09120e);
            this.mVideoBlurBg = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0911f3);
            this.mBackIcon = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091052);
            this.mCloseIcon = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0911b6);
            this.mVideoCover = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091202);
            if (this.mAdTemplate.adInfoList.size() > 0) {
                loadBlurImage(com.kwad.sdk.core.response.a.a.K(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
            }
            this.mBackIcon.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadLandPageActivity FF;

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
                    this.FF = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        com.kwad.sdk.core.report.a.r(this.FF.mAdTemplate, 153);
                        this.FF.finish();
                    }
                }
            });
            if (com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
                setVideoData();
            }
            if (this.mIsRewardLandPage) {
                handleCloseBtn();
            }
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65551, null, context, adTemplate, z) == null) {
            Class cls = ag.cB(context) ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
            KsAdSDKImpl.putComponentProxy(cls, DownloadLandPageActivity.class);
            Intent intent = new Intent(context, cls);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            intent.putExtra(KEY_NEED_CLOSE_REWARD, z);
            context.startActivity(intent);
        }
    }

    private void loadBlurImage(String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, this, str, imageView) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadLandPageActivity FF;

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
                this.FF = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, this, textView, adInfo) == null) {
            if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
                textView.setText(adInfo.adBaseInfo.appName);
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
            } else {
                textView.setText(adInfo.advertiserInfo.rawUserName);
            }
        }
    }

    private void setAdkDownload(DownloadProgressBar downloadProgressBar, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65554, this, downloadProgressBar, adInfo) == null) && com.kwad.sdk.core.response.a.a.am(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, new com.kwad.sdk.core.download.kwai.a(this, downloadProgressBar, adInfo) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadLandPageActivity FF;
                public final /* synthetic */ DownloadProgressBar FG;
                public final /* synthetic */ AdInfo pE;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadProgressBar, adInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.FF = this;
                    this.FG = downloadProgressBar;
                    this.pE = adInfo;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.FG.setProgress(100.0f);
                        this.FG.setText(com.kwad.sdk.core.response.a.a.al(this.pE));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.FG.setProgress(100.0f);
                        this.FG.setText(com.kwad.sdk.core.response.a.a.aJ(this.FF.mAdTemplate));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.FG.setProgress(100.0f);
                        this.FG.setText(com.kwad.sdk.core.response.a.a.al(this.pE));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.FG.setProgress(100.0f);
                        this.FG.setText(com.kwad.sdk.core.response.a.a.P(this.pE));
                    }
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                        this.FG.setProgress(i);
                        this.FG.setText(com.kwad.sdk.core.response.a.a.aX(i));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                        this.FG.setProgress(i);
                        this.FG.setText(com.kwad.sdk.core.response.a.a.aW(i));
                    }
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.DownloadLandPageActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadLandPageActivity FF;

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
                    this.FF = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        com.kwad.sdk.core.report.a.r(this.FF.mAdTemplate, Cea708Decoder.COMMAND_DF0);
                        this.FF.mApkDownloadHelper.m(new a.C0569a(this.FF.getActivity()).aj(true).ak(false).L(this.FF.mAdTemplate).am(false));
                        if (this.FF.mIsRewardLandPage) {
                            com.kwad.sdk.core.report.a.a(this.FF.mAdTemplate, new com.kwad.sdk.core.report.f(), (JSONObject) null);
                        }
                    }
                }
            });
        }
    }

    private void setVideoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
            if (ag.cB(this.mContext)) {
                layoutParams.height = (com.kwad.sdk.b.kwai.a.getScreenWidth(this.mContext) * 9) / 16;
                layoutParams.width = -1;
                this.mDetailVideoView.fixWidth(true);
            } else {
                layoutParams.width = com.kwad.sdk.b.kwai.a.getScreenWidth(this.mContext) / 2;
                layoutParams.height = -1;
                this.mDetailVideoView.setHorizontalVideo(true);
            }
            this.mKsadVideoContainer.setLayoutParams(layoutParams);
            this.mKsadVideoContainer.setVisibility(0);
            KSImageLoader.loadImage(this.mVideoCover, com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl(), this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(getActivity());
            this.mContext = wrapContextIfNeed;
            showingAdWebViewLandPage = true;
            setContentView(ag.cB(wrapContextIfNeed) ? R.layout.obfuscated_res_0x7f0d03fb : R.layout.obfuscated_res_0x7f0d0401);
            if (!initData()) {
                finish();
                return;
            }
            initView();
            onActivityCreated(this.mRootContainer);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.core.g.b
    public com.kwad.components.core.page.kwai.d onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.kwad.components.core.page.kwai.d dVar = new com.kwad.components.core.page.kwai.d();
            dVar.EG = this;
            dVar.mContext = this.mContext;
            AdTemplate adTemplate = this.mAdTemplate;
            dVar.mAdTemplate = adTemplate;
            if (com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                com.kwad.components.core.m.b.at(this.mContext).ay(true);
                com.kwad.components.core.page.a.a aVar = new com.kwad.components.core.page.a.a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
                this.mPlayModule = aVar;
                dVar.mPlayModule = aVar;
                aVar.a(getVideoPlayStateListener());
                dVar.EF.add(this.mPlayModule);
            }
            return dVar;
        }
        return (com.kwad.components.core.page.kwai.d) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.b
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Presenter presenter = new Presenter();
            if (com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
                presenter.a(new e());
            }
            presenter.a(new f(getWebViewStateListener(), this.mIsRewardLandPage));
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            showingAdWebViewLandPage = false;
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.clear();
            }
            com.kwad.components.core.page.a.a aVar = this.mPlayModule;
            if (aVar != null) {
                aVar.release();
            }
        }
    }
}
