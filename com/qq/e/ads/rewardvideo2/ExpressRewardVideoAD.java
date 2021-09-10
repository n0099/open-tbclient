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
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;
@Deprecated
/* loaded from: classes10.dex */
public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f75261b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75262c;

    /* renamed from: d  reason: collision with root package name */
    public ServerSideVerificationOptions f75263d;

    /* renamed from: e  reason: collision with root package name */
    public ExpressRewardVideoAdListener f75264e;

    /* loaded from: classes10.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ExpressRewardVideoAdListener f75265a;

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
            this.f75265a = expressRewardVideoAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.f75265a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.f75265a.onAdLoaded();
                    return;
                case 101:
                    this.f75265a.onVideoCached();
                    return;
                case 102:
                    this.f75265a.onShow();
                    return;
                case 103:
                    this.f75265a.onExpose();
                    return;
                case 104:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
                        AbstractAD.a(ExpressRewardVideoAD.class, aDEvent);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                    this.f75265a.onReward(hashMap);
                    return;
                case 105:
                    this.f75265a.onClick();
                    return;
                case 106:
                    this.f75265a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        AbstractAD.a(ExpressRewardVideoAD.class, aDEvent);
                        return;
                    } else {
                        this.f75265a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                case 108:
                    this.f75265a.onVideoComplete();
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
        this.f75262c = true;
        this.f75264e = expressRewardVideoAdListener;
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

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getExpressRewardVideoADDelegate(context, str, str2, new AdListenerAdapter(this.f75264e));
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(Object obj) {
        RVADI2 rvadi2 = (RVADI2) obj;
        rvadi2.setVolumeOn(this.f75262c);
        rvadi2.setServerSideVerificationOptions(this.f75263d);
        if (this.f75261b) {
            rvadi2.loadAD();
            this.f75261b = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        ExpressRewardVideoAdListener expressRewardVideoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (expressRewardVideoAdListener = this.f75264e) == null) {
            return;
        }
        expressRewardVideoAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
    }

    public VideoAdValidity checkValidity() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (hasShown()) {
                return VideoAdValidity.SHOWED;
            }
            if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
                return VideoAdValidity.OVERDUE;
            }
            T t = this.f75092a;
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (t = this.f75092a) == 0) {
            return;
        }
        ((RVADI2) t).destroy();
    }

    public long getExpireTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.f75092a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.f75092a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.f75092a;
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!a()) {
                this.f75261b = true;
                return;
            }
            T t = this.f75092a;
            if (t != 0) {
                ((RVADI2) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, serverSideVerificationOptions) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((RVADI2) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            } else {
                this.f75263d = serverSideVerificationOptions;
            }
        }
    }

    public void setVolumeOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((RVADI2) t).setVolumeOn(z);
            } else {
                this.f75262c = z;
            }
        }
    }

    public void showAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((RVADI2) t).showAD(activity);
            } else {
                a("showAD");
            }
        }
    }
}
