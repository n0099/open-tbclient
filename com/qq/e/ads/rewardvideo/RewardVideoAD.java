package com.qq.e.ads.rewardvideo;

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
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.VideoAdValidity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public RewardVideoADListener f67924g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f67925h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67926i;
    public Map<String, String> j;
    public LoadAdParams k;
    public ServerSideVerificationOptions l;
    public boolean m;

    /* loaded from: classes2.dex */
    public static class ADListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int EVENT_TYPE_ON_AD_CLICK = 6;
        public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
        public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
        public static final int EVENT_TYPE_ON_AD_LOADED = 1;
        public static final int EVENT_TYPE_ON_AD_SHOW = 3;
        public static final int EVENT_TYPE_ON_ERROR = 9;
        public static final int EVENT_TYPE_ON_REWARD = 5;
        public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
        public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CacheCallback f67928a;
        public RewardVideoADListener adListener;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<RewardVideoAD> f67929b;

        /* loaded from: classes2.dex */
        public interface CacheCallback {
            void onCached();

            void onLoaded();
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardVideoADListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.adListener = rewardVideoADListener;
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener, CacheCallback cacheCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardVideoADListener, cacheCallback};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.adListener = rewardVideoADListener;
            this.f67928a = cacheCallback;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                switch (aDEvent.getType()) {
                    case 1:
                        this.adListener.onADLoad();
                        CacheCallback cacheCallback = this.f67928a;
                        if (cacheCallback != null) {
                            cacheCallback.onLoaded();
                            return;
                        }
                        return;
                    case 2:
                        CacheCallback cacheCallback2 = this.f67928a;
                        if (cacheCallback2 != null) {
                            cacheCallback2.onCached();
                        }
                        this.adListener.onVideoCached();
                        return;
                    case 3:
                        this.adListener.onADShow();
                        return;
                    case 4:
                        this.adListener.onADExpose();
                        return;
                    case 5:
                        if (aDEvent.getParas().length < 1 || !(aDEvent.getParas()[0] instanceof String)) {
                            AbstractAD.a(RewardVideoAD.class, aDEvent);
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                        this.adListener.onReward(hashMap);
                        return;
                    case 6:
                        if (this.f67929b != null && aDEvent.getParas().length == 1) {
                            Object obj = aDEvent.getParas()[0];
                            if ((obj instanceof String) && this.f67929b.get() != null) {
                                this.f67929b.get().setExt((String) obj);
                            }
                        }
                        this.adListener.onADClick();
                        return;
                    case 7:
                        this.adListener.onVideoComplete();
                        return;
                    case 8:
                        this.adListener.onADClose();
                        return;
                    case 9:
                        if (aDEvent.getParas().length < 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                            AbstractAD.a(RewardVideoAD.class, aDEvent);
                            return;
                        } else {
                            this.adListener.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                            return;
                        }
                    default:
                        return;
                }
            }
        }

        public void setBase(RewardVideoAD rewardVideoAD) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rewardVideoAD) == null) {
                this.f67929b = new WeakReference<>(rewardVideoAD);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rewardVideoADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (RewardVideoADListener) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rewardVideoADListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new HashMap();
        this.k = null;
        this.f67924g = rewardVideoADListener;
        this.m = z;
        a(context, str);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rewardVideoADListener, Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = new HashMap();
        this.k = null;
        this.f67924g = rewardVideoADListener;
        this.m = z;
        a(context, str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener) {
        this(context, str, str2, rewardVideoADListener, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, rewardVideoADListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (RewardVideoADListener) objArr2[3], ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        this(context, str2, rewardVideoADListener, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, rewardVideoADListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (RewardVideoADListener) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            ADListenerAdapter aDListenerAdapter = new ADListenerAdapter(this.f67924g, new ADListenerAdapter.CacheCallback(this) { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RewardVideoAD f67927a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67927a = this;
                }

                @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                public void onCached() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67927a.f67926i = true;
                    }
                }

                @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                public void onLoaded() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f67927a.f67926i = false;
                    }
                }
            });
            aDListenerAdapter.setBase(this);
            return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, aDListenerAdapter);
        }
        return invokeLLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        RewardVideoADListener rewardVideoADListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (rewardVideoADListener = this.f67924g) == null) {
            return;
        }
        rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i2));
    }

    public VideoAdValidity checkValidity() {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? hasShown() ? VideoAdValidity.SHOWED : SystemClock.elapsedRealtime() > getExpireTimestamp() - 1000 ? VideoAdValidity.OVERDUE : (this.f67926i || (t = this.f67799a) == 0 || ((RVADI) t).getRewardAdType() != 0) ? VideoAdValidity.VALID : VideoAdValidity.NONE_CACHE : (VideoAdValidity) invokeV.objValue;
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.f67799a;
            if (t != 0) {
                return ((RVADI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long getExpireTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.f67799a;
            if (t != 0) {
                return ((RVADI) t).getExpireTimestamp();
            }
            a("getExpireTimestamp");
            return 0L;
        }
        return invokeV.longValue;
    }

    public Map<String, String> getExts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (Map) invokeV.objValue;
    }

    public int getRewardAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.f67799a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.f67799a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            T t = this.f67799a;
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
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && a()) {
            if (!b()) {
                this.f67925h = true;
                return;
            }
            T t = this.f67799a;
            if (t != 0) {
                ((RVADI) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.j.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, str);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, loadAdParams) == null) {
            this.k = loadAdParams;
            T t = this.f67799a;
            if (t != 0) {
                ((RVADI) t).setLoadAdParams(loadAdParams);
            }
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, serverSideVerificationOptions) == null) {
            this.l = serverSideVerificationOptions;
            T t = this.f67799a;
            if (t != 0) {
                ((RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    public void showAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            T t = this.f67799a;
            if (t != 0) {
                ((RVADI) t).showAD();
            } else {
                a("showAD");
            }
        }
    }

    public void showAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            T t = this.f67799a;
            if (t != 0) {
                ((RVADI) t).showAD(activity);
            } else {
                a("showAD");
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            RVADI rvadi = (RVADI) obj;
            rvadi.setVolumeOn(this.m);
            rvadi.setLoadAdParams(this.k);
            rvadi.setServerSideVerificationOptions(this.l);
            if (this.f67925h) {
                loadAD();
            }
        }
    }
}
