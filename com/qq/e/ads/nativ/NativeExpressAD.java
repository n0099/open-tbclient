package com.qq.e.ads.nativ;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_TYPE_AD_WILL_OPEN_OVERLAY = 20;
    public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSED = 7;
    public static final int EVENT_TYPE_ON_AD_CLOSE_OVERLAY = 10;
    public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
    public static final int EVENT_TYPE_ON_AD_LEFT_APPLICATION = 8;
    public static final int EVENT_TYPE_ON_AD_LOADED = 2;
    public static final int EVENT_TYPE_ON_AD_OPEN = 22;
    public static final int EVENT_TYPE_ON_AD_OPEN_OVERLAY = 9;
    public static final int EVENT_TYPE_ON_NO_AD = 1;
    public static final int EVENT_TYPE_ON_RENDER_FAILED = 3;
    public static final int EVENT_TYPE_ON_RENDER_SUCCESS = 4;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 21;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 16;
    public static final int EVENT_TYPE_ON_VIDEO_ERROR = 17;
    public static final int EVENT_TYPE_ON_VIDEO_INIT = 11;
    public static final int EVENT_TYPE_ON_VIDEO_LOADING = 12;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_CLOSE = 19;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_OPEN = 18;
    public static final int EVENT_TYPE_ON_VIDEO_PAUSE = 15;
    public static final int EVENT_TYPE_ON_VIDEO_READY = 13;
    public static final int EVENT_TYPE_ON_VIDEO_START = 14;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f75185b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f75186c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f75187d;

    /* renamed from: e  reason: collision with root package name */
    public VideoOption f75188e;

    /* renamed from: f  reason: collision with root package name */
    public ADSize f75189f;

    /* renamed from: g  reason: collision with root package name */
    public NativeExpressADListener f75190g;

    /* renamed from: h  reason: collision with root package name */
    public LoadAdParams f75191h;

    /* loaded from: classes10.dex */
    public static class ADListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NativeExpressADListener f75192a;

        /* renamed from: b  reason: collision with root package name */
        public NativeExpressMediaListener f75193b;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeExpressADListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75192a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeExpressMediaListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f75193b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                switch (aDEvent.getType()) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 22:
                        NativeExpressAD.a(this.f75192a, aDEvent);
                        return;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 21:
                        NativeExpressAD.a(this.f75193b, aDEvent);
                        return;
                    case 20:
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onADOpenOverlay(NativeExpressADView nativeExpressADView);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aDSize, str, nativeExpressADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75187d = Collections.synchronizedList(new ArrayList());
        this.f75190g = nativeExpressADListener;
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aDSize, str, nativeExpressADListener, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75187d = Collections.synchronizedList(new ArrayList());
        this.f75190g = nativeExpressADListener;
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public NativeExpressAD(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        this(context, aDSize, str2, nativeExpressADListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aDSize, str, str2, nativeExpressADListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (ADSize) objArr2[1], (String) objArr2[2], (NativeExpressADListener) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c();
    }

    public static /* synthetic */ void a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                        nativeExpressADListener.onADLoaded((List) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 3:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressADListener.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 4:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressADListener.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 5:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressADListener.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 6:
                    if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                    NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParas()[0];
                    nativeExpressADListener.onADClicked(nativeExpressADView);
                    if (aDEvent.getParas()[1] instanceof String) {
                        nativeExpressADView.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[1]);
                        return;
                    }
                    return;
                case 7:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                    nativeExpressADListener.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                    ((NativeExpressADView) aDEvent.getParas()[0]).negativeFeedback();
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressADListener.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 9:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressADListener.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 10:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressADListener.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public static /* synthetic */ void a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        if (nativeExpressMediaListener != null) {
            switch (aDEvent.getType()) {
                case 11:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoInit((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 12:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoLoading((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 13:
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                        nativeExpressMediaListener.onVideoReady((NativeExpressADView) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 14:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoStart((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 15:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoPause((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 16:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoComplete((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 17:
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                        nativeExpressMediaListener.onVideoError((NativeExpressADView) aDEvent.getParas()[0], AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[1]).intValue()));
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 18:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoPageOpen((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 19:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoPageClose((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
                case 20:
                default:
                    return;
                case 21:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        nativeExpressMediaListener.onVideoCached((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    } else {
                        AbstractAD.a(NativeExpressAD.class, aDEvent);
                        return;
                    }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEADI neadi) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, neadi) == null) {
            super.a((NativeExpressAD) neadi);
            neadi.setMinVideoDuration(this.f75185b);
            neadi.setMaxVideoDuration(this.f75186c);
            VideoOption videoOption = this.f75188e;
            if (videoOption != null) {
                setVideoOption(videoOption);
            }
            synchronized (this.f75187d) {
                for (Integer num : this.f75187d) {
                    if (this.f75092a != 0) {
                        ((NEADI) this.f75092a).loadAd(num.intValue());
                    }
                }
            }
        }
    }

    private boolean a(ADSize aDSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aDSize)) == null) {
            if (aDSize != null) {
                this.f75189f = aDSize;
                return false;
            }
            GDTLogger.e("初始化错误：参数adSize不能为空");
            a(2001);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f75189f, str, str2, str3, new ADListenerAdapter(this.f75190g));
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        NativeExpressADListener nativeExpressADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (nativeExpressADListener = this.f75190g) == null) {
            return;
        }
        nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public void loadAD(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            loadAD(i2, null);
        }
    }

    public void loadAD(int i2, LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i2, loadAdParams) == null) && b()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!a()) {
                synchronized (this.f75187d) {
                    this.f75187d.add(Integer.valueOf(i2));
                }
                return;
            }
            T t = this.f75092a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f75191h;
            NEADI neadi = (NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i2, loadAdParams2);
            } else {
                neadi.loadAd(i2);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, loadAdParams) == null) {
            this.f75191h = loadAdParams;
        }
    }

    public void setMaxVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f75186c = i2;
            if (this.f75186c > 0 && this.f75185b > this.f75186c) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            T t = this.f75092a;
            if (t != 0) {
                ((NEADI) t).setMaxVideoDuration(this.f75186c);
            }
        }
    }

    public void setMinVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f75185b = i2;
            if (this.f75186c > 0 && this.f75185b > this.f75186c) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            T t = this.f75092a;
            if (t != 0) {
                ((NEADI) t).setMinVideoDuration(this.f75185b);
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoOption) == null) {
            this.f75188e = videoOption;
            T t = this.f75092a;
            if (t == 0 || videoOption == null) {
                return;
            }
            ((NEADI) t).setVideoOption(videoOption);
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }
}
