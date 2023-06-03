package com.qq.e.ads.nativ;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int g;
    public volatile int h;
    public List<Integer> i;
    public VideoOption j;
    public ADSize k;
    public NativeExpressADListener l;
    public final ADListenerAdapter m;
    public LoadAdParams n;
    public volatile ServerSideVerificationOptions o;

    /* loaded from: classes10.dex */
    public static class ADListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NativeExpressADListener a;
        public NativeExpressMediaListener b;
        public NegativeFeedbackListener c;
        public ADRewardListener d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeExpressADListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || NativeExpressAD.a(this.a, aDEvent) || NativeExpressAD.a(this.b, aDEvent) || NativeExpressAD.a(this.c, aDEvent)) {
                return;
            }
            NativeExpressAD.a(this.d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDRewardListener) == null) {
                this.d = aDRewardListener;
            }
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeExpressMediaListener) == null) {
                this.b = nativeExpressMediaListener;
            }
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, negativeFeedbackListener) == null) {
                this.c = negativeFeedbackListener;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = Collections.synchronizedList(new ArrayList());
        this.l = nativeExpressADListener;
        this.m = new ADListenerAdapter(nativeExpressADListener);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = Collections.synchronizedList(new ArrayList());
        this.l = nativeExpressADListener;
        this.m = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    private boolean a(ADSize aDSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aDSize)) == null) {
            if (aDSize != null) {
                this.k = aDSize;
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, neadi) == null) {
            super.a((NativeExpressAD) neadi);
            neadi.setMinVideoDuration(this.g);
            neadi.setMaxVideoDuration(this.h);
            ((NEADI) this.a).setServerSideVerificationOptions(this.o);
            VideoOption videoOption = this.j;
            if (videoOption != null) {
                setVideoOption(videoOption);
            }
            synchronized (this.i) {
                Iterator<Integer> it = this.i.iterator();
                while (it.hasNext()) {
                    if (this.a != 0) {
                        if (this.n != null) {
                            ((NEADI) this.a).loadAd(it.next().intValue(), this.n);
                        } else {
                            ((NEADI) this.a).loadAd(it.next().intValue());
                        }
                    }
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        NativeExpressADListener nativeExpressADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (nativeExpressADListener = this.l) == null) {
            return;
        }
        nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
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

    public void loadAD(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            loadAD(i, null);
        }
    }

    public void loadAD(int i, LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, loadAdParams) == null) && a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.i) {
                    this.i.add(Integer.valueOf(i));
                }
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.n;
            NEADI neadi = (NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i, loadAdParams2);
            } else {
                neadi.loadAd(i);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, loadAdParams) == null) {
            this.n = loadAdParams;
        }
    }

    public void setMaxVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.h = i;
            if (this.h > 0 && this.g > this.h) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((NEADI) t).setMaxVideoDuration(this.h);
            }
        }
    }

    public void setMinVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.g = i;
            if (this.h > 0 && this.g > this.h) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((NEADI) t).setMinVideoDuration(this.g);
            }
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aDRewardListener) == null) {
            this.m.setAdRewardListener(aDRewardListener);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, serverSideVerificationOptions) == null) {
            this.o = serverSideVerificationOptions;
            T t = this.a;
            if (t != 0) {
                ((NEADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, videoOption) == null) {
            this.j = videoOption;
            T t = this.a;
            if (t == 0 || videoOption == null) {
                return;
            }
            ((NEADI) t).setVideoOption(videoOption);
        }
    }

    public static boolean a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, nativeExpressADListener, aDEvent)) == null) {
            if (nativeExpressADListener != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type != 101) {
                        if (type != 103) {
                            if (type != 303) {
                                if (type != 105) {
                                    if (type != 106) {
                                        if (type != 109) {
                                            if (type == 110) {
                                                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                                                if (nativeExpressADView != null) {
                                                    nativeExpressADListener.onRenderFail(nativeExpressADView);
                                                }
                                            }
                                        } else {
                                            NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                                            if (nativeExpressADView2 != null) {
                                                nativeExpressADListener.onRenderSuccess(nativeExpressADView2);
                                            }
                                        }
                                    } else {
                                        NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                                        if (nativeExpressADView3 != null) {
                                            nativeExpressADListener.onADClosed(nativeExpressADView3);
                                            nativeExpressADView3.negativeFeedback();
                                        }
                                    }
                                } else {
                                    NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                                    if (nativeExpressADView4 != null) {
                                        nativeExpressADListener.onADClicked(nativeExpressADView4);
                                    }
                                }
                            } else {
                                NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                                if (nativeExpressADView5 != null) {
                                    nativeExpressADListener.onADLeftApplication(nativeExpressADView5);
                                }
                            }
                        } else {
                            NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                            if (nativeExpressADView6 != null) {
                                nativeExpressADListener.onADExposure(nativeExpressADView6);
                            }
                        }
                    } else {
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num != null) {
                            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        }
                    }
                } else {
                    List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                    if (list != null) {
                        nativeExpressADListener.onADLoaded(list);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        InterceptResult invokeLL;
        NativeExpressADView nativeExpressADView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nativeExpressMediaListener, aDEvent)) == null) {
            if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
                int type = aDEvent.getType();
                if (type != 201) {
                    if (type != 202) {
                        if (type != 204) {
                            if (type != 206) {
                                if (type != 207) {
                                    if (type != 301) {
                                        if (type != 302) {
                                            switch (type) {
                                                case 209:
                                                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                                                    return true;
                                                case 210:
                                                    Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                                                    if (num == null) {
                                                        return true;
                                                    }
                                                    nativeExpressMediaListener.onVideoReady(nativeExpressADView, num.intValue());
                                                    return true;
                                                case AdEventType.VIDEO_LOADING /* 211 */:
                                                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                                                    return true;
                                            }
                                        }
                                        nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                                        return true;
                                    }
                                    nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                                    return true;
                                }
                                Integer num2 = (Integer) aDEvent.getParam(1, Integer.class);
                                if (num2 == null) {
                                    return true;
                                }
                                nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num2.intValue()));
                                return true;
                            }
                            nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                            return true;
                        }
                        nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                        return true;
                    }
                    nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                    return true;
                }
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, aDRewardListener, aDEvent)) == null) {
            if (aDRewardListener == null || aDEvent.getType() != 104) {
                return false;
            }
            String str = (String) aDEvent.getParam(String.class);
            if (str != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("transId", str);
                aDRewardListener.onReward(hashMap);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, negativeFeedbackListener, aDEvent)) == null) {
            if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
                return false;
            }
            negativeFeedbackListener.onComplainSuccess();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            return pOFactory.getNativeExpressADDelegate(context, this.k, str, str2, str3, this.m);
        }
        return invokeLLLLL.objValue;
    }
}
