package d.a.q0.w0;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.comm.managers.setting.GlobalSetting;
import d.a.q0.v0.a;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FunAdCallback f66364a;

    /* loaded from: classes8.dex */
    public class a implements a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f66365a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f66366b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f66367c;

        public a(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66365a = activity;
            this.f66366b = funAdSlot;
            this.f66367c = funAdLoadListener;
        }

        @Override // d.a.q0.v0.a.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FunAdSdk.getAdFactory().loadAd(this.f66365a, this.f66366b, this.f66367c);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f66368a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.f f66369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f66370c;

        public b(c cVar, a.h hVar, a.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66370c = cVar;
            this.f66368a = hVar;
            this.f66369b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (hVar = this.f66368a) == null) {
                return;
            }
            hVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (hVar = this.f66368a) == null) {
                return;
            }
            hVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.h hVar = this.f66368a;
                if (hVar != null) {
                    hVar.onAdError(str);
                }
                this.f66370c.p("advert_show", str, 0, this.f66369b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.h hVar = this.f66368a;
                if (hVar != null) {
                    hVar.onAdShow(str, str2, str3);
                }
                this.f66370c.p("advert_show", str, 1, this.f66369b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (hVar = this.f66368a) == null) {
                return;
            }
            hVar.onRewardedVideo(str);
        }
    }

    /* renamed from: d.a.q0.w0.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1827c implements a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f66371a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f66372b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f66373c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f66374d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f66375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f66376f;

        public C1827c(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, funNativeAd, activity, viewGroup, list, list2, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66371a = funNativeAd;
            this.f66372b = activity;
            this.f66373c = viewGroup;
            this.f66374d = list;
            this.f66375e = list2;
            this.f66376f = funAdInteractionListener;
        }

        @Override // d.a.q0.v0.a.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66371a.show(this.f66372b, this.f66373c, this.f66374d, this.f66375e, this.f66376f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements FunAdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClose(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoad(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoadError(String str, String str2, String str3, int i2, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW_ERROR).param("obj_locate", i2).param("obj_source", str).param("obj_param1", str4).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, str3));
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoaded(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShowError(String str, String str2, String str3, int i2, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onRewardedVideo(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends TTCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public TTLocation getTTLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new TTLocation(d.a.d.e.m.b.b(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), d.a.d.e.m.b.b(TbadkCoreApplication.getInst().getLocationLat(), 0.0d)) : (TTLocation) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements FunAdSdk.SdkInitializeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.k f66377a;

        public f(c cVar, a.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66377a = kVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                a.k kVar = this.f66377a;
                if (kVar != null) {
                    kVar.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.g f66378a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.f f66379b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f66380c;

        public g(c cVar, a.g gVar, a.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, gVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66380c = cVar;
            this.f66378a = gVar;
            this.f66379b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.g gVar = this.f66378a;
                if (gVar != null) {
                    gVar.a(str, 0);
                }
                this.f66380c.p("advert_load", str, 1, this.f66379b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.g gVar = this.f66378a;
                if (gVar != null) {
                    gVar.onError(str);
                }
                this.f66380c.p("advert_load", str, 0, this.f66379b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f66381a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f66382b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f66383c;

        public h(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66381a = activity;
            this.f66382b = funAdSlot;
            this.f66383c = funAdLoadListener;
        }

        @Override // d.a.q0.v0.a.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().loadAd(this.f66381a, this.f66382b, this.f66383c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f66384a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.f f66385b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f66386c;

        public i(c cVar, a.h hVar, a.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66386c = cVar;
            this.f66384a = hVar;
            this.f66385b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (hVar = this.f66384a) == null) {
                return;
            }
            hVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (hVar = this.f66384a) == null) {
                return;
            }
            hVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.h hVar = this.f66384a;
                if (hVar != null) {
                    hVar.onAdError(str);
                }
                this.f66386c.p("advert_show", str, 0, this.f66385b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.h hVar = this.f66384a;
                if (hVar != null) {
                    hVar.onAdShow(str, str2, str3);
                }
                this.f66386c.p("advert_show", str, 1, this.f66385b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (hVar = this.f66384a) == null) {
                return;
            }
            hVar.onRewardedVideo(str);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f66387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f66388b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f66389c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f66390d;

        public j(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66387a = activity;
            this.f66388b = viewGroup;
            this.f66389c = str;
            this.f66390d = funAdInteractionListener;
        }

        @Override // d.a.q0.v0.a.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.f66387a, this.f66388b, this.f66389c, this.f66390d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f66391a;

        public k(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66391a = str;
        }

        @Override // d.a.q0.v0.a.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.f66391a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.g f66392a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.f f66393b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f66394c;

        public l(c cVar, a.g gVar, a.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, gVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66394c = cVar;
            this.f66392a = gVar;
            this.f66393b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.g gVar = this.f66392a;
                if (gVar != null) {
                    gVar.a(str, 0);
                }
                this.f66394c.p("advert_load", str, 1, this.f66393b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.g gVar = this.f66392a;
                if (gVar != null) {
                    gVar.onError(str);
                }
                this.f66394c.p("advert_load", str, 0, this.f66393b);
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66364a = new d(this);
    }

    @Override // d.a.q0.v0.a.e
    public void a(Activity activity, String str, a.g gVar, a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, activity, str, gVar, fVar) == null) {
            o(new h(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(d.a.d.e.p.l.k(activity)).build(), new g(this, gVar, fVar)));
        }
    }

    @Override // d.a.q0.v0.a.e
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // d.a.q0.v0.a.e
    public void c(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, obj) == null) && (obj instanceof FunNativeAd) && imageView != null) {
            d.a.q0.w0.b.y(imageView, (FunNativeAd) obj);
        }
    }

    @Override // d.a.q0.v0.a.e
    public void d(Activity activity, @NonNull Object obj, a.h hVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, obj, hVar, viewGroup, list, list2, fVar}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd)) {
            o(new C1827c(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new b(this, hVar, fVar)));
        }
    }

    @Override // d.a.q0.v0.a.e
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            o(new k(this, str));
        }
    }

    @Override // d.a.q0.v0.a.e
    public View e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                d.a.q0.w0.b.s(funNativeAd);
                d.a.q0.w0.b.t(funNativeAd);
                return funNativeAd.getVideoView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // d.a.q0.v0.a.e
    public ViewGroup f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, activity, str)) == null) ? new FrameLayout(activity) : (ViewGroup) invokeLL.objValue;
    }

    @Override // d.a.q0.v0.a.e
    public boolean g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                return d.a.q0.w0.b.z((FunNativeAd) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.v0.a.e
    public Object h(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str)) == null) {
            o(null);
            return FunAdSdk.getAdFactory().getNativeAd(activity, str);
        }
        return invokeLL.objValue;
    }

    @Override // d.a.q0.v0.a.e
    public void i(Object obj, a.i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, obj, iVar) == null) && (obj instanceof FunNativeAd)) {
            FunNativeAd funNativeAd = (FunNativeAd) obj;
            d.a.q0.w0.b.x(funNativeAd, d.a.q0.w0.b.i(funNativeAd), iVar);
        }
    }

    @Override // d.a.q0.v0.a.e
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            o(null);
            return FunAdSdk.getAdFactory().isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.v0.a.e
    public synchronized void j(Application application, a.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, application, kVar) == null) {
            synchronized (this) {
                if (FunAdSdk.isSdkInitializeComplete()) {
                    if (kVar != null) {
                        kVar.a();
                    }
                    return;
                }
                FunAdConfig build = new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).setTTCustomController(new e(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen()).build();
                Log.e("Test", "funAdConfig.logEnabled=>" + build.logEnabled);
                Log.e("Test", "FUN_AD_TEST_TEST=>false");
                Log.e("Test", "FUN_AD_APP_ID=>b122ce58b8954c27b6882f7987c08860");
                Log.e("Test", "PB_SPLASH_FUN_AD_SID_1=>6021002119-1732188456");
                Log.e("Test", "PB_SPLASH_FUN_AD_SID_2=>6021002118-283136489");
                Log.e("Test", "PB_BANNER_FUN_AD_SID=>6051001308-627527144");
                Log.e("Test", "AD_FUN_FRS_SID=>6051001001-2043781376");
                Log.e("Test", "GET_AD_FUN_FRS_PRE_LOAD_SID=>6051002409-2123988582");
                Log.e("Test", "PICPAGE_SID=>6051001643-679358748");
                Log.e("Test", "AD_FUN_PERSONALIZED_FEED_SID=>6051001980-1210572494");
                Log.e("Test", "VIDEO_MIDDLE_SID=>6061002332-203360688");
                Log.e("Test", "VIDEO_MIDDLE_DRAW_SID=>6061002410-390177882");
                FunAdSdk.init(build, this.f66364a, new f(this, kVar));
            }
        }
    }

    @Override // d.a.q0.v0.a.e
    public void k(Activity activity, String str, a.g gVar, a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, activity, str, gVar, fVar) == null) {
            o(new a(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(d.a.d.e.p.l.k(activity)).build(), new l(this, gVar, fVar)));
        }
    }

    @Override // d.a.q0.v0.a.e
    public void l(Activity activity, String str, ViewGroup viewGroup, a.h hVar, a.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048589, this, activity, str, viewGroup, hVar, fVar) == null) || viewGroup == null) {
            return;
        }
        o(new j(this, activity, viewGroup, str, new i(this, hVar, fVar)));
    }

    @Override // d.a.q0.v0.a.e
    public d.a.q0.v3.g m(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            d.a.q0.v3.g gVar = null;
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                int i2 = d.a.q0.w0.b.i(funNativeAd);
                if (i2 == -1) {
                    return null;
                }
                gVar = new d.a.q0.v3.g();
                String c2 = d.a.q0.w0.b.c(funNativeAd, i2);
                if (d.a.d.e.p.k.isEmpty(c2)) {
                    c2 = "推广";
                }
                gVar.k(c2);
                gVar.l(d.a.q0.w0.b.l(funNativeAd, i2));
                gVar.j(d.a.q0.w0.b.g(funNativeAd, i2));
                gVar.g(d.a.q0.w0.b.d(funNativeAd));
                gVar.h(d.a.q0.w0.b.b(funNativeAd));
                gVar.i(i2);
            }
            return gVar;
        }
        return (d.a.q0.v3.g) invokeL.objValue;
    }

    public final void o(a.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kVar) == null) {
            j(TbadkCoreApplication.getInst(), kVar);
        }
    }

    public final void p(String str, String str2, int i2, a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048592, this, str, str2, i2, fVar) == null) {
            d.a.d.e.n.a a2 = d.a.p0.o0.j.a();
            a2.b("type", "bear");
            a2.b("locate", fVar.f65637a);
            a2.b(SetImageWatermarkTypeReqMsg.SWITCH, fVar.f65638b);
            a2.b("sid", str2);
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
