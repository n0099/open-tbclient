package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.c.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes10.dex */
public class DownloadLandPageActivity extends com.kwad.components.core.l.b<com.kwad.components.core.page.c.d> {
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "DownloadLandPageActivity";
    public static boolean showingAdWebViewLandPage;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public ImageView mBackIcon;
    public ImageView mCloseIcon;
    public DetailVideoView mDetailVideoView;
    public boolean mIsRewardLandPage;
    public KSRelativeLayout mKsadVideoContainer;
    public com.kwad.components.core.page.d.a mPlayModule;
    public ImageView mVideoBlurBg;
    public ImageView mVideoCover;
    public k mVideoPlayStateListener;

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return TAG;
    }

    private k getVideoPlayStateListener() {
        l lVar = new l() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.6
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(8);
            }
        };
        this.mVideoPlayStateListener = lVar;
        return lVar;
    }

    @NonNull
    private f.a getWebViewStateListener() {
        return new f.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.3
            @Override // com.kwad.components.core.page.c.f.a
            public final void aw(int i) {
                if (i == 1) {
                    return;
                }
                DownloadLandPageActivity.this.initNativeLandPage();
            }
        };
    }

    private void handleCloseBtn() {
        long am = com.kwad.sdk.core.response.b.a.am(this.mAdInfo);
        if (am == 0) {
            this.mCloseIcon.setVisibility(0);
        } else {
            this.mCloseIcon.postDelayed(new Runnable() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.7
                @Override // java.lang.Runnable
                public final void run() {
                    if (DownloadLandPageActivity.this.getActivity() != null && !DownloadLandPageActivity.this.getActivity().isFinishing()) {
                        DownloadLandPageActivity.this.mCloseIcon.setVisibility(0);
                        DownloadLandPageActivity.this.mCloseIcon.setAlpha(0.0f);
                        DownloadLandPageActivity.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }
            }, am);
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.components.core.s.c.qM().qN();
                DownloadLandPageActivity.this.finish();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        if (ai.Kx()) {
            return R.layout.obfuscated_res_0x7f0d049d;
        }
        return R.layout.obfuscated_res_0x7f0d04a5;
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        showingAdWebViewLandPage = true;
        this.mIsRewardLandPage = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
        this.mAdInfo = e.dP(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (com.kwad.sdk.core.response.b.a.bc(e.dP(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.core.page.c.e());
        }
        presenter.a(new f(getWebViewStateListener(), this.mIsRewardLandPage));
        return presenter;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        showingAdWebViewLandPage = false;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        com.kwad.components.core.page.d.a aVar = this.mPlayModule;
        if (aVar != null) {
            aVar.release();
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            if (stringExtra != null) {
                adTemplate.parseJson(new JSONObject(stringExtra));
            }
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        if (this.mAdTemplate != null) {
            return true;
        }
        return false;
    }

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        if (!com.kwad.sdk.core.response.b.a.bc(e.dP(this.mAdTemplate))) {
            ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
            if (!ai.Kx()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, com.kwad.sdk.d.a.a.a(this.mContext, 100.0f));
                ksLogoView.setLayoutParams(marginLayoutParams);
            }
            ksLogoView.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
            layoutParams.gravity = 17;
            kSLinearLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        findViewById(R.id.obfuscated_res_0x7f0912f6).setVisibility(0);
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09133a);
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f0912de);
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.obfuscated_res_0x7f091377);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0913a8);
        DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091519);
        AdInfo dP = e.dP(this.mAdTemplate);
        setAdTitle((TextView) findViewById(R.id.obfuscated_res_0x7f0912ff), dP);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f0912f2)).setText(dP.adBaseInfo.adDescription);
        roundAngleImageView.setRadius(32.0f);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cf(dP))) {
            KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.b.a.cf(dP), this.mAdTemplate);
        }
        setAdkDownload(downloadProgressBar, dP);
        buildView(complianceTextView, kSLinearLayout, ksLogoView);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09148f);
        this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0914e7);
        DetailVideoView detailVideoView = (DetailVideoView) kSRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.g(true, com.kwad.sdk.core.config.d.Bs());
        this.mVideoBlurBg = (ImageView) kSRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0914e3);
        this.mBackIcon = (ImageView) kSRelativeLayout.findViewById(R.id.obfuscated_res_0x7f091316);
        this.mCloseIcon = (ImageView) kSRelativeLayout.findViewById(R.id.obfuscated_res_0x7f09148d);
        this.mVideoCover = (ImageView) kSRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0914f2);
        if (this.mAdTemplate.adInfoList.size() > 0) {
            loadBlurImage(com.kwad.sdk.core.response.b.a.X(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
        }
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.sdk.core.report.a.s(DownloadLandPageActivity.this.mAdTemplate, 153);
                DownloadLandPageActivity.this.finish();
            }
        });
        if (com.kwad.sdk.core.response.b.a.bc(e.dP(this.mAdTemplate))) {
            setVideoData();
        }
        if (this.mIsRewardLandPage) {
            handleCloseBtn();
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Class cls;
        if (ai.Kx()) {
            cls = AdWebViewActivity.class;
        } else {
            cls = KsFullScreenLandScapeVideoActivity.class;
        }
        com.kwad.sdk.service.b.a(cls, DownloadLandPageActivity.class);
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
        } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
            textView.setText(adInfo.advertiserInfo.rawUserName);
        }
    }

    private void setAdkDownload(final DownloadProgressBar downloadProgressBar, final AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.bX(DownloadLandPageActivity.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.ac(adInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.cR(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.cQ(i));
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.kwad.sdk.core.report.a.s(DownloadLandPageActivity.this.mAdTemplate, Cea708Decoder.COMMAND_DF0);
                    DownloadLandPageActivity.this.mApkDownloadHelper.s(new a.C0644a(DownloadLandPageActivity.this.getActivity()).ao(true).ap(false).aq(DownloadLandPageActivity.this.mAdTemplate).ar(false));
                    if (DownloadLandPageActivity.this.mIsRewardLandPage) {
                        com.kwad.sdk.core.report.a.a(DownloadLandPageActivity.this.mAdTemplate, new j(), (JSONObject) null);
                    }
                }
            });
        }
    }

    private void setVideoData() {
        ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
        if (ai.Kx()) {
            layoutParams.height = (com.kwad.sdk.d.a.a.getScreenWidth(this.mContext) * 9) / 16;
            layoutParams.width = -1;
        } else {
            layoutParams.width = com.kwad.sdk.d.a.a.getScreenWidth(this.mContext) / 2;
            layoutParams.height = -1;
        }
        this.mKsadVideoContainer.setLayoutParams(layoutParams);
        this.mKsadVideoContainer.setVisibility(0);
        KSImageLoader.loadImage(this.mVideoCover, com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl(), this.mAdTemplate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.core.l.b
    public com.kwad.components.core.page.c.d onCreateCallerContext() {
        com.kwad.components.core.page.c.d dVar = new com.kwad.components.core.page.c.d(this);
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        if (com.kwad.sdk.core.response.b.a.bc(e.dP(adTemplate))) {
            com.kwad.components.core.s.a.ah(this.mContext).aM(true);
            com.kwad.components.core.page.d.a aVar = new com.kwad.components.core.page.d.a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
            this.mPlayModule = aVar;
            dVar.mPlayModule = aVar;
            aVar.a(getVideoPlayStateListener());
            dVar.Mm.add(this.mPlayModule);
        }
        return dVar;
    }
}
