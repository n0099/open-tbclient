package com.qq.e.ads.rewardvideo2;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;
@Deprecated
/* loaded from: classes3.dex */
public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59035g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59036h;

    /* renamed from: i  reason: collision with root package name */
    public ServerSideVerificationOptions f59037i;

    /* renamed from: j  reason: collision with root package name */
    public ExpressRewardVideoAdListener f59038j;

    /* loaded from: classes3.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ExpressRewardVideoAdListener a;

        public AdListenerAdapter(ExpressRewardVideoAdListener expressRewardVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expressRewardVideoAdListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = expressRewardVideoAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.a.onAdLoaded();
                    return;
                case 101:
                    this.a.onVideoCached();
                    return;
                case 102:
                    this.a.onShow();
                    return;
                case 103:
                    this.a.onExpose();
                    return;
                case 104:
                    if (aDEvent.getParas().length < 1 || !(aDEvent.getParas()[0] instanceof String)) {
                        AbstractAD.a(ExpressRewardVideoAD.class, aDEvent);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                    this.a.onReward(hashMap);
                    return;
                case 105:
                    this.a.onClick();
                    return;
                case 106:
                    this.a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length < 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        AbstractAD.a(ExpressRewardVideoAD.class, aDEvent);
                        return;
                    } else {
                        this.a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                case 108:
                    this.a.onVideoComplete();
                    return;
                default:
                    return;
            }
        }
    }

    public ExpressRewardVideoAD(Context context, String str, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, expressRewardVideoAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59036h = true;
        GDTLogger.e("ExpressRewardVideoAD 接口即将被移除，请使用 RewardVideoAD 接口");
        this.f59038j = expressRewardVideoAdListener;
        a(context, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public ExpressRewardVideoAD(Context context, String str, String str2, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this(context, str2, expressRewardVideoAdListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, expressRewardVideoAdListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ExpressRewardVideoAdListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    public RVADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, pOFactory, str, str2)) == null) ? pOFactory.getExpressRewardVideoADDelegate(context, str, str2, new AdListenerAdapter(this.f59038j)) : (RVADI2) invokeLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            RVADI2 rvadi2 = (RVADI2) obj;
            rvadi2.setVolumeOn(this.f59036h);
            rvadi2.setServerSideVerificationOptions(this.f59037i);
            if (this.f59035g) {
                rvadi2.loadAD();
                this.f59035g = false;
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        ExpressRewardVideoAdListener expressRewardVideoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (expressRewardVideoAdListener = this.f59038j) == null) {
            return;
        }
        expressRewardVideoAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
    }

    public VideoAdValidity checkValidity() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (hasShown()) {
                return VideoAdValidity.SHOWED;
            }
            if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
                return VideoAdValidity.OVERDUE;
            }
            T t = this.a;
            if (t != 0) {
                z = ((RVADI2) t).isVideoCached();
            } else {
                a("isVideoCached");
                z = false;
            }
            return !z ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
        }
        return (VideoAdValidity) invokeV.objValue;
    }

    public void destroy() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (t = this.a) == 0) {
            return;
        }
        ((RVADI2) t).destroy();
    }

    public long getExpireTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((RVADI2) t).getExpireTimestamp();
            }
            a("getExpireTimestamp");
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((RVADI2) t).getVideoDuration();
            }
            a("getVideoDuration");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((RVADI2) t).hasShown();
            }
            a("hasShown");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!b()) {
                this.f59035g = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((RVADI2) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, serverSideVerificationOptions) == null) {
            T t = this.a;
            if (t != 0) {
                ((RVADI2) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            } else {
                this.f59037i = serverSideVerificationOptions;
            }
        }
    }

    public void setVolumeOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            T t = this.a;
            if (t != 0) {
                ((RVADI2) t).setVolumeOn(z);
            } else {
                this.f59036h = z;
            }
        }
    }

    public void showAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            T t = this.a;
            if (t != 0) {
                ((RVADI2) t).showAD(activity);
            } else {
                a("showAD");
            }
        }
    }
}
