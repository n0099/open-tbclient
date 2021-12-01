package com.qq.e.ads.nativ;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
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

    /* renamed from: g  reason: collision with root package name */
    public volatile int f60732g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f60733h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f60734i;

    /* renamed from: j  reason: collision with root package name */
    public VideoOption f60735j;

    /* renamed from: k  reason: collision with root package name */
    public ADSize f60736k;
    public NativeExpressADListener l;
    public LoadAdParams m;

    /* loaded from: classes2.dex */
    public static class ADListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NativeExpressADListener a;

        /* renamed from: b  reason: collision with root package name */
        public NativeExpressMediaListener f60737b;

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
            this.a = nativeExpressADListener;
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
            this.f60737b = nativeExpressMediaListener;
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
                        NativeExpressAD.a(this.a, aDEvent);
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
                        NativeExpressAD.a(this.f60737b, aDEvent);
                        return;
                    case 20:
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        @Deprecated
        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        @Deprecated
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
        this.f60734i = Collections.synchronizedList(new ArrayList());
        this.l = nativeExpressADListener;
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
        this.f60734i = Collections.synchronizedList(new ArrayList());
        this.l = nativeExpressADListener;
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

    public static void a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, nativeExpressADListener, aDEvent) == null) || nativeExpressADListener == null) {
            return;
        }
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                break;
            case 2:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    nativeExpressADListener.onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 3:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 4:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 6:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParas()[0];
                    nativeExpressADListener.onADClicked(nativeExpressADView);
                    if (aDEvent.getParas()[1] instanceof String) {
                        nativeExpressADView.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[1]);
                        return;
                    }
                    return;
                }
                break;
            case 7:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                    ((NativeExpressADView) aDEvent.getParas()[0]).negativeFeedback();
                    return;
                }
                break;
            case 8:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 9:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 10:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            default:
                return;
        }
        AbstractAD.a(NativeExpressAD.class, aDEvent);
    }

    private boolean a(ADSize aDSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, aDSize)) == null) {
            if (aDSize != null) {
                this.f60736k = aDSize;
                return false;
            }
            GDTLogger.e("初始化错误：参数adSize不能为空");
            a(2001);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEADI neadi) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, neadi) == null) {
            super.a((NativeExpressAD) neadi);
            neadi.setMinVideoDuration(this.f60732g);
            neadi.setMaxVideoDuration(this.f60733h);
            VideoOption videoOption = this.f60735j;
            if (videoOption != null) {
                setVideoOption(videoOption);
            }
            synchronized (this.f60734i) {
                Iterator<Integer> it = this.f60734i.iterator();
                while (it.hasNext()) {
                    if (this.a != 0) {
                        if (this.m != null) {
                            ((NEADI) this.a).loadAd(it.next().intValue(), this.m);
                        } else {
                            ((NEADI) this.a).loadAd(it.next().intValue());
                        }
                    }
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        NativeExpressADListener nativeExpressADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (nativeExpressADListener = this.l) == null) {
            return;
        }
        nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((NEADI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void loadAD(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            loadAD(i2, null);
        }
    }

    public void loadAD(int i2, LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i2, loadAdParams) == null) && a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f60734i) {
                    this.f60734i.add(Integer.valueOf(i2));
                }
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.m;
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, loadAdParams) == null) {
            this.m = loadAdParams;
        }
    }

    public void setMaxVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f60733h = i2;
            if (this.f60733h > 0 && this.f60732g > this.f60733h) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((NEADI) t).setMaxVideoDuration(this.f60733h);
            }
        }
    }

    public void setMinVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f60732g = i2;
            if (this.f60733h > 0 && this.f60732g > this.f60733h) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((NEADI) t).setMinVideoDuration(this.f60732g);
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, videoOption) == null) {
            this.f60735j = videoOption;
            T t = this.a;
            if (t == 0 || videoOption == null) {
                return;
            }
            ((NEADI) t).setVideoOption(videoOption);
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    public static void a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nativeExpressMediaListener, aDEvent) == null) || nativeExpressMediaListener == null) {
            return;
        }
        switch (aDEvent.getType()) {
            case 11:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoInit((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 12:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoLoading((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 13:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoReady((NativeExpressADView) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                    return;
                }
                break;
            case 14:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoStart((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 15:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPause((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 16:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoComplete((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 17:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoError((NativeExpressADView) aDEvent.getParas()[0], AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                }
                break;
            case 18:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageOpen((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 19:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageClose((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 20:
            default:
                return;
            case 21:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoCached((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
        }
        AbstractAD.a(NativeExpressAD.class, aDEvent);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) ? pOFactory.getNativeExpressADDelegate(context, this.f60736k, str, str2, str3, new ADListenerAdapter(this.l)) : invokeLLLLL.objValue;
    }
}
