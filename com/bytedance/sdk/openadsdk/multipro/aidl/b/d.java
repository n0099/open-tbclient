package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes9.dex */
public class d extends IRewardAdInteractionListener.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f68418a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68419b;

    public d(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rewardAdInteractionListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68419b = new Handler(Looper.getMainLooper());
        this.f68418a = rewardAdInteractionListener;
    }

    private Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Handler handler = this.f68419b;
            if (handler == null) {
                Handler handler2 = new Handler(Looper.getMainLooper());
                this.f68419b = handler2;
                return handler2;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f68422a;

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
                    this.f68422a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = this.f68422a.f68418a) == null) {
                        return;
                    }
                    rewardAdInteractionListener.onAdClose();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f68420a;

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
                    this.f68420a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = this.f68420a.f68418a) == null) {
                        return;
                    }
                    rewardAdInteractionListener.onAdShow();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f68421a;

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
                    this.f68421a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = this.f68421a.f68418a) == null) {
                        return;
                    }
                    rewardAdInteractionListener.onAdVideoBarClick();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            b().post(new Runnable(this, z, i2, str, i3, str2) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f68426a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f68427b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f68428c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f68429d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f68430e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ d f68431f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68431f = this;
                    this.f68426a = z;
                    this.f68427b = i2;
                    this.f68428c = str;
                    this.f68429d = i3;
                    this.f68430e = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = this.f68431f.f68418a) == null) {
                        return;
                    }
                    rewardAdInteractionListener.onRewardVerify(this.f68426a, this.f68427b, this.f68428c, this.f68429d, this.f68430e);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f68425a;

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
                    this.f68425a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = this.f68425a.f68418a) == null) {
                        return;
                    }
                    rewardAdInteractionListener.onSkippedVideo();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f68423a;

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
                    this.f68423a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = this.f68423a.f68418a) == null) {
                        return;
                    }
                    rewardAdInteractionListener.onVideoComplete();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoError() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f68424a;

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
                    this.f68424a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = this.f68424a.f68418a) == null) {
                        return;
                    }
                    rewardAdInteractionListener.onVideoError();
                }
            });
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f68418a = null;
            this.f68419b = null;
        }
    }
}
