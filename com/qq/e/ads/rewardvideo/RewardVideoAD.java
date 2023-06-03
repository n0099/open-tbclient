package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final RewardVideoADListener g;
    public volatile boolean h;
    public LoadAdParams i;
    public ServerSideVerificationOptions j;
    public final boolean k;
    public final ADListenerAdapter l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rewardVideoADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (RewardVideoADListener) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this(rewardVideoADListener, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rewardVideoADListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((RewardVideoADListener) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z, String str2) {
        this(rewardVideoADListener, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rewardVideoADListener, Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((RewardVideoADListener) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context, str, str2);
    }

    public RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rewardVideoADListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = null;
        this.k = z;
        this.g = rewardVideoADListener;
        this.l = new ADListenerAdapter(rewardVideoADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        RewardVideoADListener rewardVideoADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (rewardVideoADListener = this.g) == null) {
            return;
        }
        rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i));
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((RVADI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getRewardAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((RVADI) t).getRewardAdType();
            }
            a("getRewardAdType");
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((RVADI) t).getVideoDuration();
            }
            a("getVideoDuration");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((RVADI) t).hasShown();
            }
            a("hasShown");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && a()) {
            if (!b()) {
                this.h = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((RVADI) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, loadAdParams) == null) {
            this.i = loadAdParams;
            T t = this.a;
            if (t != 0) {
                ((RVADI) t).setLoadAdParams(loadAdParams);
            }
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, negativeFeedbackListener) == null) {
            ADListenerAdapter.a(this.l, negativeFeedbackListener);
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, serverSideVerificationOptions) == null) {
            this.j = serverSideVerificationOptions;
            T t = this.a;
            if (t != 0) {
                ((RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    public void showAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            T t = this.a;
            if (t != 0) {
                ((RVADI) t).showAD();
            } else {
                a("showAD");
            }
        }
    }

    public void showAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            T t = this.a;
            if (t != 0) {
                ((RVADI) t).showAD(activity);
            } else {
                a("showAD");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class ADListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NegativeFeedbackListener a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardVideoADListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.adListener = rewardVideoADListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                int type = aDEvent.getType();
                if (type == 100) {
                    this.adListener.onADLoad();
                } else if (type == 201) {
                    this.adListener.onVideoCached();
                } else if (type == 206) {
                    this.adListener.onVideoComplete();
                } else if (type == 304) {
                    NegativeFeedbackListener negativeFeedbackListener = this.a;
                    if (negativeFeedbackListener != null) {
                        negativeFeedbackListener.onComplainSuccess();
                    }
                } else {
                    switch (type) {
                        case 102:
                            this.adListener.onADShow();
                            return;
                        case 103:
                            this.adListener.onADExpose();
                            return;
                        case 104:
                            String str = (String) aDEvent.getParam(String.class);
                            if (str != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("transId", str);
                                this.adListener.onReward(hashMap);
                                return;
                            }
                            return;
                        case 105:
                            this.adListener.onADClick();
                            return;
                        case 106:
                            this.adListener.onADClose();
                            return;
                        case 107:
                            Integer num = (Integer) aDEvent.getParam(Integer.class);
                            if (num != null) {
                                this.adListener.onError(AdErrorConvertor.formatErrorCode(num.intValue()));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        public static void a(ADListenerAdapter aDListenerAdapter, NegativeFeedbackListener negativeFeedbackListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, aDListenerAdapter, negativeFeedbackListener) == null) {
                aDListenerAdapter.a = negativeFeedbackListener;
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.l);
        }
        return invokeLLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            RVADI rvadi = (RVADI) obj;
            rvadi.setVolumeOn(this.k);
            rvadi.setLoadAdParams(this.i);
            rvadi.setServerSideVerificationOptions(this.j);
            if (this.h) {
                loadAD();
            }
        }
    }
}
