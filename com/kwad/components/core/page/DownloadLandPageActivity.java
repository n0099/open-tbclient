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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
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
/* loaded from: classes8.dex */
public class DownloadLandPageActivity extends com.kwad.components.core.g.b<com.kwad.components.core.page.kwai.d> {
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "DownloadLandPageActivity";
    public static boolean showingAdWebViewLandPage;
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

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        if (com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
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
        h hVar = new h() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.6
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i, int i2) {
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(8);
            }
        };
        this.mVideoPlayStateListener = hVar;
        return hVar;
    }

    @NonNull
    private f.a getWebViewStateListener() {
        return new f.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.3
            @Override // com.kwad.components.core.page.kwai.f.a
            public final void aj(int i) {
                if (i != 1) {
                    DownloadLandPageActivity.this.initNativeLandPage();
                }
            }
        };
    }

    private void handleCloseBtn() {
        long X = com.kwad.sdk.core.response.a.a.X(this.mAdInfo);
        if (X == 0) {
            this.mCloseIcon.setVisibility(0);
        } else {
            this.mCloseIcon.postDelayed(new Runnable() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.7
                @Override // java.lang.Runnable
                public final void run() {
                    if (DownloadLandPageActivity.this.getActivity() == null || DownloadLandPageActivity.this.getActivity().isFinishing()) {
                        return;
                    }
                    DownloadLandPageActivity.this.mCloseIcon.setVisibility(0);
                    DownloadLandPageActivity.this.mCloseIcon.setAlpha(0.0f);
                    DownloadLandPageActivity.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                }
            }, X);
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.components.core.m.d.oy().oz();
                DownloadLandPageActivity.this.finish();
            }
        });
    }

    private boolean initData() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        findViewById(R.id.obfuscated_res_0x7f09118c).setVisibility(0);
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0911bf);
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f09117e);
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.obfuscated_res_0x7f0911f7);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091221);
        DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091376);
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        setAdTitle((TextView) findViewById(R.id.obfuscated_res_0x7f091193), bQ);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091189)).setText(bQ.adBaseInfo.adDescription);
        roundAngleImageView.setRadius(32.0f);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.bn(bQ))) {
            KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.a.a.bn(bQ), this.mAdTemplate);
        }
        setAdkDownload(downloadProgressBar, bQ);
        buildView(complianceTextView, kSLinearLayout, ksLogoView);
    }

    private void initView() {
        this.mRootContainer = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09130b);
        this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09134a);
        this.mDetailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091361);
        this.mVideoBlurBg = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091346);
        this.mBackIcon = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0911a8);
        this.mCloseIcon = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091309);
        this.mVideoCover = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091355);
        if (this.mAdTemplate.adInfoList.size() > 0) {
            loadBlurImage(com.kwad.sdk.core.response.a.a.K(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
        }
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.sdk.core.report.a.r(DownloadLandPageActivity.this.mAdTemplate, 153);
                DownloadLandPageActivity.this.finish();
            }
        });
        if (com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
            setVideoData();
        }
        if (this.mIsRewardLandPage) {
            handleCloseBtn();
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Class cls = ag.cB(context) ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
        KsAdSDKImpl.putComponentProxy(cls, DownloadLandPageActivity.class);
        Intent intent = new Intent(context, cls);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_NEED_CLOSE_REWARD, z);
        context.startActivity(intent);
    }

    private void loadBlurImage(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }

    private void setAdTitle(TextView textView, AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
            textView.setText(adInfo.adBaseInfo.appName);
        } else if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
        } else {
            textView.setText(adInfo.advertiserInfo.rawUserName);
        }
    }

    private void setAdkDownload(final DownloadProgressBar downloadProgressBar, final AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.a.am(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.al(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aJ(DownloadLandPageActivity.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.al(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.P(adInfo));
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aX(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aW(i));
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.kwad.sdk.core.report.a.r(DownloadLandPageActivity.this.mAdTemplate, Cea708Decoder.COMMAND_DF0);
                    DownloadLandPageActivity.this.mApkDownloadHelper.m(new a.C0588a(DownloadLandPageActivity.this.getActivity()).aj(true).ak(false).L(DownloadLandPageActivity.this.mAdTemplate).am(false));
                    if (DownloadLandPageActivity.this.mIsRewardLandPage) {
                        com.kwad.sdk.core.report.a.a(DownloadLandPageActivity.this.mAdTemplate, new com.kwad.sdk.core.report.f(), (JSONObject) null);
                    }
                }
            });
        }
    }

    private void setVideoData() {
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

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(getActivity());
        this.mContext = wrapContextIfNeed;
        showingAdWebViewLandPage = true;
        setContentView(ag.cB(wrapContextIfNeed) ? R.layout.obfuscated_res_0x7f0d0428 : R.layout.obfuscated_res_0x7f0d042e);
        if (!initData()) {
            finish();
            return;
        }
        initView();
        onActivityCreated(this.mRootContainer);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.core.g.b
    public com.kwad.components.core.page.kwai.d onCreateCallerContext() {
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

    @Override // com.kwad.components.core.g.b
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
            presenter.a(new e());
        }
        presenter.a(new f(getWebViewStateListener(), this.mIsRewardLandPage));
        return presenter;
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
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
