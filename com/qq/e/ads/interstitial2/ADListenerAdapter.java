package com.qq.e.ads.interstitial2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.a;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class ADListenerAdapter implements ADListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UnifiedInterstitialADListener a;
    public UnifiedInterstitialMediaListener b;
    public com.qq.e.comm.listeners.ADRewardListener c;
    public NegativeFeedbackListener d;

    public ADListenerAdapter(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {unifiedInterstitialADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = unifiedInterstitialADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 109) {
            UnifiedInterstitialADListener unifiedInterstitialADListener2 = this.a;
            if (unifiedInterstitialADListener2 == null || !a.b(unifiedInterstitialADListener2)) {
                return;
            }
            this.a.onRenderSuccess();
        } else if (type == 110) {
            UnifiedInterstitialADListener unifiedInterstitialADListener3 = this.a;
            if (unifiedInterstitialADListener3 == null || !a.a(unifiedInterstitialADListener3)) {
                return;
            }
            this.a.onRenderFail();
        } else if (type == 201) {
            UnifiedInterstitialADListener unifiedInterstitialADListener4 = this.a;
            if (unifiedInterstitialADListener4 != null) {
                unifiedInterstitialADListener4.onVideoCached();
            }
        } else if (type == 202) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.b;
            if (unifiedInterstitialMediaListener != null) {
                unifiedInterstitialMediaListener.onVideoStart();
            }
        } else if (type == 204) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.b;
            if (unifiedInterstitialMediaListener2 != null) {
                unifiedInterstitialMediaListener2.onVideoPause();
            }
        } else if (type == 206) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.b;
            if (unifiedInterstitialMediaListener3 != null) {
                unifiedInterstitialMediaListener3.onVideoComplete();
            }
        } else if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.b;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(AdErrorConvertor.formatErrorCode(num.intValue()));
        } else {
            switch (type) {
                case 100:
                    UnifiedInterstitialADListener unifiedInterstitialADListener5 = this.a;
                    if (unifiedInterstitialADListener5 != null) {
                        unifiedInterstitialADListener5.onADReceive();
                        return;
                    }
                    return;
                case 101:
                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                    if (num2 == null || (unifiedInterstitialADListener = this.a) == null) {
                        return;
                    }
                    unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    return;
                case 102:
                    UnifiedInterstitialADListener unifiedInterstitialADListener6 = this.a;
                    if (unifiedInterstitialADListener6 != null) {
                        unifiedInterstitialADListener6.onADOpened();
                        return;
                    }
                    return;
                case 103:
                    UnifiedInterstitialADListener unifiedInterstitialADListener7 = this.a;
                    if (unifiedInterstitialADListener7 != null) {
                        unifiedInterstitialADListener7.onADExposure();
                        return;
                    }
                    return;
                case 104:
                    if (this.c == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    this.c.onReward(hashMap);
                    return;
                case 105:
                    UnifiedInterstitialADListener unifiedInterstitialADListener8 = this.a;
                    if (unifiedInterstitialADListener8 != null) {
                        unifiedInterstitialADListener8.onADClicked();
                        return;
                    }
                    return;
                case 106:
                    UnifiedInterstitialADListener unifiedInterstitialADListener9 = this.a;
                    if (unifiedInterstitialADListener9 != null) {
                        unifiedInterstitialADListener9.onADClosed();
                        return;
                    }
                    return;
                default:
                    switch (type) {
                        case 209:
                            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.b;
                            if (unifiedInterstitialMediaListener5 != null) {
                                unifiedInterstitialMediaListener5.onVideoInit();
                                return;
                            }
                            return;
                        case 210:
                            Integer num3 = (Integer) aDEvent.getParam(Integer.class);
                            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.b;
                            if (unifiedInterstitialMediaListener6 == null || num3 == null) {
                                return;
                            }
                            unifiedInterstitialMediaListener6.onVideoReady(num3.intValue());
                            return;
                        case 211:
                            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.b;
                            if (unifiedInterstitialMediaListener7 != null) {
                                unifiedInterstitialMediaListener7.onVideoLoading();
                                return;
                            }
                            return;
                        default:
                            switch (type) {
                                case 301:
                                    UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.b;
                                    if (unifiedInterstitialMediaListener8 != null) {
                                        unifiedInterstitialMediaListener8.onVideoPageOpen();
                                        return;
                                    }
                                    return;
                                case 302:
                                    UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.b;
                                    if (unifiedInterstitialMediaListener9 != null) {
                                        unifiedInterstitialMediaListener9.onVideoPageClose();
                                        return;
                                    }
                                    return;
                                case 303:
                                    UnifiedInterstitialADListener unifiedInterstitialADListener10 = this.a;
                                    if (unifiedInterstitialADListener10 != null) {
                                        unifiedInterstitialADListener10.onADLeftApplication();
                                        return;
                                    }
                                    return;
                                case 304:
                                    NegativeFeedbackListener negativeFeedbackListener = this.d;
                                    if (negativeFeedbackListener != null) {
                                        negativeFeedbackListener.onComplainSuccess();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDRewardListener) == null) {
            this.c = aDRewardListener;
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unifiedInterstitialMediaListener) == null) {
            this.b = unifiedInterstitialMediaListener;
        }
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, negativeFeedbackListener) == null) {
            this.d = negativeFeedbackListener;
        }
    }
}
