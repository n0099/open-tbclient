package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NativeUnifiedADData a;
    public NativeADEventListener b;
    public NativeADMediaListener c;
    public DownloadConfirmListener d;
    public NegativeFeedbackListener e;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, viewGroup, context, list, list2) == null) {
            this.a.bindAdToCustomVideo(viewGroup, context, list, list2);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, nativeAdContainer, layoutParams, list) == null) {
            this.a.bindAdToView(context, nativeAdContainer, layoutParams, list);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, nativeAdContainer, layoutParams, list, list2) == null) {
            this.a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a.bindCTAViews(list);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, list, i) == null) {
            this.a.bindImageViews(list, i);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, bArr) == null) {
            this.a.bindImageViews(list, bArr);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, mediaView, videoOption, nativeADMediaListener) == null) {
            this.c = nativeADMediaListener;
            this.a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.destroy();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nativeUnifiedADData)) == null) ? this.a.equalsAdData(nativeUnifiedADData) : invokeL.booleanValue;
    }

    public NativeUnifiedADData getAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (NativeUnifiedADData) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.getAdPatternType() : invokeV.intValue;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getApkInfoUrl() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.getAppMiitInfo() : (NativeUnifiedADAppMiitInfo) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.getAppPrice() : invokeV.doubleValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.getAppScore() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a.getAppStatus() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a.getButtonText() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a.getCTAText() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.a.getCustomizeVideo() : (CustomizeVideo) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a.getDesc() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a.getDownloadCount() : invokeV.longValue;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.a.getECPM() : invokeV.intValue;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a.getECPMLevel() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.getExtraInfo() : (Map) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.a.getIconUrl() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.a.getImgList() : (List) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a.getImgUrl() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a.getPictureHeight() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.a.getPictureWidth() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.a.getProgress() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a.getTitle() : (String) invokeV.objValue;
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

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.a.isValid() : invokeV.booleanValue;
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
    public void pauseAppDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.a.pauseAppDownload();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.a.pauseVideo();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.a.resumeAppDownload();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.a.resumeVideo();
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048619, this, i, i2, str) == null) {
            this.a.sendLossNotification(i, i2, str);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, map) == null) {
            this.a.sendLossNotification(map);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.a.sendWinNotification(i);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, map) == null) {
            this.a.sendWinNotification(map);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.a.setBidECPM(i);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, downloadConfirmListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048625, this, nativeADEventListener) == null) {
            this.b = nativeADEventListener;
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, negativeFeedbackListener) == null) {
            this.e = negativeFeedbackListener;
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

    /* loaded from: classes10.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, aDEvent) != null) || NativeUnifiedADDataAdapter.a(this.a, aDEvent) || NativeUnifiedADDataAdapter.b(this.a, aDEvent)) {
                return;
            }
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = this.a;
            if (nativeUnifiedADDataAdapter != null) {
                NativeUnifiedADDataAdapter.c(nativeUnifiedADDataAdapter, aDEvent);
                return;
            }
            throw null;
        }
    }

    public static boolean a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, nativeUnifiedADDataAdapter, aDEvent)) == null) {
            if (nativeUnifiedADDataAdapter.b != null) {
                int type = aDEvent.getType();
                if (type != 103) {
                    if (type != 105) {
                        if (type != 107) {
                            if (type == 111) {
                                nativeUnifiedADDataAdapter.b.onADStatusChanged();
                            }
                        } else {
                            Integer num = (Integer) aDEvent.getParam(Integer.class);
                            if (num != null) {
                                nativeUnifiedADDataAdapter.b.onADError(AdErrorConvertor.formatErrorCode(num.intValue()));
                            }
                        }
                    } else {
                        NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.b;
                        if (nativeADEventListener instanceof NativeADEventListenerWithClickInfo) {
                            ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.b).onADClicked((View) aDEvent.getParam(View.class));
                        } else {
                            nativeADEventListener.onADClicked();
                        }
                    }
                } else {
                    nativeUnifiedADDataAdapter.b.onADExposed();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, nativeUnifiedADDataAdapter, aDEvent)) == null) {
            if (nativeUnifiedADDataAdapter.c != null) {
                switch (aDEvent.getType()) {
                    case 201:
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num != null) {
                            nativeUnifiedADDataAdapter.c.onVideoLoaded(num.intValue());
                        }
                        return true;
                    case 202:
                        nativeUnifiedADDataAdapter.c.onVideoStart();
                        return true;
                    case 203:
                        nativeUnifiedADDataAdapter.c.onVideoResume();
                        return true;
                    case 204:
                        nativeUnifiedADDataAdapter.c.onVideoPause();
                        return true;
                    case 205:
                        nativeUnifiedADDataAdapter.c.onVideoStop();
                        return true;
                    case 206:
                        nativeUnifiedADDataAdapter.c.onVideoCompleted();
                        return true;
                    case 207:
                        Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                        if (num2 != null) {
                            nativeUnifiedADDataAdapter.c.onVideoError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                        }
                        return true;
                    case 208:
                        nativeUnifiedADDataAdapter.c.onVideoClicked();
                        return true;
                    case 209:
                        nativeUnifiedADDataAdapter.c.onVideoInit();
                        return true;
                    case 210:
                        nativeUnifiedADDataAdapter.c.onVideoReady();
                        return true;
                    case 211:
                        nativeUnifiedADDataAdapter.c.onVideoLoading();
                        return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, nativeUnifiedADDataAdapter, aDEvent)) == null) {
            if (nativeUnifiedADDataAdapter.e == null || aDEvent.getType() != 304) {
                return false;
            }
            nativeUnifiedADDataAdapter.e.onComplainSuccess();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
