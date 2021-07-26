package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class RewardVideoAD implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RewardVideoADListener f38060a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f38061b;

    /* renamed from: c  reason: collision with root package name */
    public RVADI f38062c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f38063d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f38064e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f38065f;

    /* renamed from: g  reason: collision with root package name */
    public String f38066g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38067h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f38068i;
    public LoadAdParams j;
    public ServerSideVerificationOptions k;
    public DownloadConfirmListener l;

    /* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38070b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RewardVideoADListener f38071c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f38072d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f38073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RewardVideoAD f38074f;

        public AnonymousClass1(RewardVideoAD rewardVideoAD, Context context, String str, RewardVideoADListener rewardVideoADListener, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardVideoAD, context, str, rewardVideoADListener, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38074f = rewardVideoAD;
            this.f38069a = context;
            this.f38070b = str;
            this.f38071c = rewardVideoADListener;
            this.f38072d = str2;
            this.f38073e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (GDTADManager.getInstance().initWith(this.f38069a, this.f38070b)) {
                    try {
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f38075a;

                            /* renamed from: b  reason: collision with root package name */
                            public /* synthetic */ POFactory f38076b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38075a = this;
                                this.f38076b = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.f38076b == null) {
                                            this.f38075a.f38074f.a(2001);
                                            return;
                                        }
                                        ADListenerAdapter aDListenerAdapter = new ADListenerAdapter(this.f38075a.f38071c, new ADListenerAdapter.CacheCallback(this) { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1.1.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public /* synthetic */ RunnableC04771 f38077a;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.f38077a = this;
                                            }

                                            @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                            public void onCached() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    this.f38077a.f38075a.f38074f.f38067h = true;
                                                }
                                            }

                                            @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                            public void onLoaded() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                    this.f38077a.f38075a.f38074f.f38067h = false;
                                                }
                                            }
                                        });
                                        aDListenerAdapter.setBase(this.f38075a.f38074f);
                                        this.f38075a.f38074f.f38062c = this.f38076b.getRewardVideoADDelegate(this.f38075a.f38069a, this.f38075a.f38070b, this.f38075a.f38072d, aDListenerAdapter);
                                        this.f38075a.f38074f.f38062c.setVolumeOn(this.f38075a.f38073e);
                                        this.f38075a.f38074f.f38062c.setLoadAdParams(this.f38075a.f38074f.j);
                                        this.f38075a.f38074f.f38062c.setServerSideVerificationOptions(this.f38075a.f38074f.k);
                                        this.f38075a.f38074f.f38061b = true;
                                        if (this.f38075a.f38074f.f38065f) {
                                            this.f38075a.f38074f.loadAD();
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("Exception while init Core", th);
                                        this.f38075a.f38074f.a(2001);
                                    }
                                }
                            }
                        });
                        return;
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init Reward Video AD Core", th);
                    }
                }
                this.f38074f.a(2001);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public CacheCallback f38080a;
        public RewardVideoADListener adListener;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<RewardVideoAD> f38081b;

        /* loaded from: classes6.dex */
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
            this.f38080a = cacheCallback;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                switch (aDEvent.getType()) {
                    case 1:
                        this.adListener.onADLoad();
                        CacheCallback cacheCallback = this.f38080a;
                        if (cacheCallback != null) {
                            cacheCallback.onLoaded();
                            return;
                        }
                        return;
                    case 2:
                        CacheCallback cacheCallback2 = this.f38080a;
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
                        if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                        this.adListener.onReward(hashMap);
                        return;
                    case 6:
                        if (this.f38081b != null && aDEvent.getParas().length == 1) {
                            Object obj = aDEvent.getParas()[0];
                            if ((obj instanceof String) && this.f38081b.get() != null) {
                                this.f38081b.get().setExt((String) obj);
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
                        if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                            return;
                        }
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    default:
                        return;
                }
            }
        }

        public void setBase(RewardVideoAD rewardVideoAD) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rewardVideoAD) == null) {
                this.f38081b = new WeakReference<>(rewardVideoAD);
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
        this.f38068i = new HashMap();
        this.j = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, rewardVideoADListener, z);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(2003));
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
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (RewardVideoADListener) objArr2[3], ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, rewardVideoADListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f38068i = new HashMap();
        this.j = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, str2, rewardVideoADListener, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, i2) { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ int f38078a;

                /* renamed from: b  reason: collision with root package name */
                public /* synthetic */ RewardVideoAD f38079b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38079b = this;
                    this.f38078a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f38079b.f38060a == null) {
                        return;
                    }
                    this.f38079b.f38060a.onError(AdErrorConvertor.formatErrorCode(this.f38078a));
                }
            });
        }
    }

    private void a(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, str, str2, rewardVideoADListener, Boolean.valueOf(z)}) == null) {
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || rewardVideoADListener == null) {
                GDTLogger.e(String.format("RewardVideoAD Constructor params error, context=%s, appID=%s, posID=%s, rewardVideoADListener=%s", context, str, str2, rewardVideoADListener));
                return;
            }
            this.f38060a = rewardVideoADListener;
            this.f38063d = true;
            if (!a.a(context)) {
                GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                a(4002);
                return;
            }
            this.f38064e = true;
            this.f38066g = str2;
            GDTADManager.INIT_EXECUTOR.execute(new AnonymousClass1(this, context, str, rewardVideoADListener, str2, z));
        }
    }

    public VideoAdValidity checkValidity() {
        InterceptResult invokeV;
        RVADI rvadi;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? hasShown() ? VideoAdValidity.SHOWED : SystemClock.elapsedRealtime() > getExpireTimestamp() - 1000 ? VideoAdValidity.OVERDUE : (this.f38067h || (rvadi = this.f38062c) == null || rvadi.getRewardAdType() != 0) ? VideoAdValidity.VALID : VideoAdValidity.NONE_CACHE : (VideoAdValidity) invokeV.objValue;
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.getAdNetWorkName();
            }
            GDTLogger.e("please invoke getAdNetWorkName method after callback \"onADLoad\" or the ad does not support \"getAdNetWorkName\" ");
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.getECPM();
            }
            GDTLogger.e("please invoke getECPM method after callback \"onADLoad\" ");
            return -1;
        }
        return invokeV.intValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.getECPMLevel();
            }
            GDTLogger.e("please invoke getECPMLevel method after callback \"onADLoad\" ");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long getExpireTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.getExpireTimestamp();
            }
            GDTLogger.e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
            return 0L;
        }
        return invokeV.longValue;
    }

    public Map<String, String> getExts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38068i : (Map) invokeV.objValue;
    }

    public int getRewardAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.getRewardAdType();
            }
            GDTLogger.e("please invoke getRewardAdType method after callback \"onADLoad\" or the ad does not support \"getRewardAdType\" ");
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.getVideoDuration();
            }
            GDTLogger.e("please invoke getVideoDuration method after callback \"onADLoad\" or the ad does not support \"getVideoDuration\" ");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                return rvadi.hasShown();
            }
            GDTLogger.e("please invoke hasShown method after callback \"onADLoad\" ");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.f38063d || !this.f38064e) {
                GDTLogger.e("AD init Params OR Context error, details in logs produced while init RewardVideoAD");
            } else if (!this.f38061b) {
                this.f38065f = true;
            } else {
                RVADI rvadi = this.f38062c;
                if (rvadi != null) {
                    rvadi.loadAD();
                } else {
                    GDTLogger.e("RewardVideo AD Init error, see more logs");
                }
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048587, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.l) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadConfirmListener) == null) {
            this.l = downloadConfirmListener;
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                rvadi.setDownloadConfirmListener(this);
            }
        }
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f38068i.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, str);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, loadAdParams) == null) {
            this.j = loadAdParams;
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                rvadi.setLoadAdParams(loadAdParams);
            }
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, serverSideVerificationOptions) == null) {
            this.k = serverSideVerificationOptions;
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                rvadi.setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        }
    }

    public void setTag(Map map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, map) == null) || map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.f38066g);
        } catch (Exception e2) {
            GDTLogger.e("NativeUnifiedAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void showAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                rvadi.showAD();
            } else {
                GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
            }
        }
    }

    public void showAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            RVADI rvadi = this.f38062c;
            if (rvadi != null) {
                rvadi.showAD(activity);
            } else {
                GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
            }
        }
    }
}
