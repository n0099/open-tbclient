package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NativeUnifiedADData a;
    public NativeADEventListener b;
    public NativeADMediaListener c;
    public DownloadConfirmListener d;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class UnifiedAdListener implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NativeUnifiedADDataAdapter a;

        public UnifiedAdListener(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeUnifiedADDataAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nativeUnifiedADDataAdapter;
        }

        public /* synthetic */ UnifiedAdListener(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, AnonymousClass1 anonymousClass1) {
            this(nativeUnifiedADDataAdapter);
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                if (aDEvent.getType() <= 4) {
                    NativeUnifiedADDataAdapter.a(this.a, aDEvent);
                } else {
                    NativeUnifiedADDataAdapter.b(this.a, aDEvent);
                }
            }
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeUnifiedADData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener(this, null));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, nativeAdContainer, layoutParams, list) == null) {
            this.a.bindAdToView(context, nativeAdContainer, layoutParams, list);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, nativeAdContainer, layoutParams, list, list2) == null) {
            this.a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.bindCTAViews(list);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i) == null) {
            this.a.bindImageViews(list, i);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, bArr) == null) {
            this.a.bindImageViews(list, bArr);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, mediaView, videoOption, nativeADMediaListener) == null) {
            this.c = nativeADMediaListener;
            this.a.bindMediaView(mediaView, videoOption, null);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.destroy();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, nativeUnifiedADData)) == null) ? this.a.equalsAdData(nativeUnifiedADData) : invokeL.booleanValue;
    }

    public NativeUnifiedADData getAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (NativeUnifiedADData) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.getAdPatternType() : invokeV.intValue;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.getApkInfoUrl() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getAppMiitInfo() : (NativeUnifiedADAppMiitInfo) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.getAppPrice() : invokeV.doubleValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.getAppScore() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.getAppStatus() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a.getButtonText() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a.getCTAText() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a.getDesc() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.a.getDownloadCount() : invokeV.longValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a.getECPM() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a.getECPMLevel() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public Map<String, Object> getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.a.getExtraInfo() : (Map) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a.getIconUrl() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.getImgList() : (List) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.a.getImgUrl() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.a.getPictureHeight() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a.getPictureWidth() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a.getProgress() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.a.getTitle() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.a.getVastContent() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a.getVastTag() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.a.getVideoCurrentPosition() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.a.getVideoDuration() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.a.isAppAd() : invokeV.booleanValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isSkippable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.a.isSkippable() : invokeV.booleanValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.a.isWeChatCanvasAd() : invokeV.booleanValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.a.negativeFeedback();
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048613, this, activity, i, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.d) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
            this.a.onVideoADExposured(view2);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.a.pauseAppDownload();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.a.pauseVideo();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, videoPreloadListener) == null) {
            this.a.preloadVideo(videoPreloadListener);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void reportVastEvent(ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, aDEvent) == null) {
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.a.resume();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.a.resumeAppDownload();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.a.resumeVideo();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void sendLossNotification(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048622, this, i, i2, str) == null) {
            this.a.sendLossNotification(i, i2, str);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void sendWinNotification(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.a.sendWinNotification(i);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setBidECPM(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.a.setBidECPM(i);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, downloadConfirmListener) == null) {
            this.d = downloadConfirmListener;
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.setDownloadConfirmListener(this);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, nativeADEventListener) == null) {
            this.b = nativeADEventListener;
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.a.setVideoMute(z);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.a.startVideo();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.a.stopVideo();
        }
    }

    public static void a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, nativeUnifiedADDataAdapter, aDEvent) == null) && nativeUnifiedADDataAdapter.b != null) {
            int type = aDEvent.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            nativeUnifiedADDataAdapter.b.onADStatusChanged();
                            return;
                        }
                        return;
                    } else if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.b.onADError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    } else {
                        return;
                    }
                } else if (aDEvent.getParas().length >= 1 && (aDEvent.getParas()[0] instanceof String)) {
                    try {
                        NativeUnifiedADData.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[0]);
                    } catch (Exception unused) {
                    }
                    NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.b;
                    if (nativeADEventListener instanceof NativeADEventListenerWithClickInfo) {
                        View view2 = null;
                        if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[1] instanceof View)) {
                            view2 = (View) aDEvent.getParas()[1];
                        }
                        ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.b).onADClicked(view2);
                        return;
                    }
                    nativeADEventListener.onADClicked();
                    return;
                } else {
                    return;
                }
            }
            nativeUnifiedADDataAdapter.b.onADExposed();
        }
    }

    public static void b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, nativeUnifiedADDataAdapter, aDEvent) == null) && nativeUnifiedADDataAdapter.c != null) {
            switch (aDEvent.getType()) {
                case 5:
                    nativeUnifiedADDataAdapter.c.onVideoInit();
                    return;
                case 6:
                    nativeUnifiedADDataAdapter.c.onVideoLoading();
                    return;
                case 7:
                    nativeUnifiedADDataAdapter.c.onVideoReady();
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.c.onVideoLoaded(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    }
                    return;
                case 9:
                    nativeUnifiedADDataAdapter.c.onVideoStart();
                    return;
                case 10:
                    nativeUnifiedADDataAdapter.c.onVideoPause();
                    return;
                case 11:
                    nativeUnifiedADDataAdapter.c.onVideoResume();
                    return;
                case 12:
                    nativeUnifiedADDataAdapter.c.onVideoCompleted();
                    return;
                case 13:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.c.onVideoError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    return;
                case 14:
                    nativeUnifiedADDataAdapter.c.onVideoStop();
                    return;
                case 15:
                    nativeUnifiedADDataAdapter.c.onVideoClicked();
                    return;
                default:
                    return;
            }
        }
    }
}
