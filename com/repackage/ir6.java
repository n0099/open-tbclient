package com.repackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.FunNativeViewInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.channel.ModuleConfigCsj;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.kwad.sdk.api.KsCustomController;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.repackage.zq6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class ir6 implements zq6.f {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public p a;
    public HashMap<String, Long> b;
    public final FunAdCallback c;

    /* loaded from: classes6.dex */
    public class a implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq6.i a;
        public final /* synthetic */ zq6.g b;
        public final /* synthetic */ ir6 c;

        public a(ir6 ir6Var, zq6.i iVar, zq6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ir6Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                zq6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                zq6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.a(str);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zq6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunNativeAd2 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ViewGroup d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ FunAdInteractionListener g;

        /* loaded from: classes6.dex */
        public class a extends FunNativeViewInflater {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, FunNativeAd2 funNativeAd2) {
                super(funNativeAd2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, funNativeAd2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((FunNativeAd2) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
            }

            @Override // com.fun.ad.sdk.CustomInflater
            public List<View> getClickViews() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.b : (List) invokeV.objValue;
            }

            @Override // com.fun.ad.sdk.CustomInflater
            public List<View> getCreativeViews() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.c : (List) invokeV.objValue;
            }
        }

        public b(ir6 ir6Var, FunNativeAd2 funNativeAd2, List list, List list2, ViewGroup viewGroup, Activity activity, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, funNativeAd2, list, list2, viewGroup, activity, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = funNativeAd2;
            this.b = list;
            this.c = list2;
            this.d = viewGroup;
            this.e = activity;
            this.f = str;
            this.g = funAdInteractionListener;
        }

        @Override // com.repackage.zq6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.getNativeType() == FunNativeAd2.NativeType.EXPRESS) {
                return;
            }
            a aVar = new a(this, this.a);
            ViewGroup viewGroup = null;
            if (this.d.getParent() instanceof ViewGroup) {
                viewGroup = (ViewGroup) this.d.getParent();
                viewGroup.removeView(this.d);
            }
            FunNativeView inflate = FunNativeView.inflate(this.e, this.d);
            if (viewGroup != null) {
                viewGroup.addView(inflate);
            }
            aVar.setFunNativeView(inflate);
            this.a.show(this.e, aVar, this.f, this.g);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq6.i a;
        public final /* synthetic */ zq6.g b;
        public final /* synthetic */ ir6 c;

        public c(ir6 ir6Var, zq6.i iVar, zq6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ir6Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                zq6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                zq6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                if (this.c.a != null) {
                    this.c.a.b = str;
                    this.c.a.c = str2;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "BEAR ad sspType=" + str2 + ", sid=" + str + " ,pid=" + str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.a(str);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements zq6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;
        public final /* synthetic */ ir6 e;

        public d(ir6 ir6Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ir6Var;
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funAdInteractionListener;
        }

        @Override // com.repackage.zq6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunSplashAd showSplash = FunAdSdk.getAdFactory().showSplash(this.a, this.b, this.c, this.d);
                if (showSplash != null) {
                    this.e.a = new p();
                    this.e.a.a = showSplash;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "BEAR ad showSplash:" + this.e.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends TTCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        /* renamed from: a */
        public TTLocation getTTLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new TTLocation(ng.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), ng.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d)) : (TTLocation) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends KsCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? KsPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? KsPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? KsPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? KsPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? KsPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TbadkCoreApplication.getInst().getAndroidId() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String[] getImeis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new String[]{TbadkCoreApplication.getInst().getImei(), TbadkCoreApplication.getInst().getImei()} : (String[]) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Location location = new Location("");
                location.setLatitude(ng.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d));
                location.setLongitude(ng.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d));
                return location;
            }
            return (Location) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getMacAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()) : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst()) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements FunAdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir6 a;

        public g(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir6Var;
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
                this.a.b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoadError(String str, String str2, String str3, int i, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
                this.a.x(str);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW_ERROR).param("obj_locate", i).param("obj_source", str).param("obj_param1", str4).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, str3));
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoaded(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
                this.a.x(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShowError(String str, String str2, String str3, int i, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onRewardedVideo(String str, String str2, String str3, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements FunAdSdk.SdkInitializeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq6.l a;

        public h(ir6 ir6Var, zq6.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                zq6.l lVar = this.a;
                if (lVar != null) {
                    lVar.initComplete();
                    or6.a("小熊SDK开始初始化完成！");
                }
            }
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onModulesInitComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq6.h a;
        public final /* synthetic */ zq6.g b;
        public final /* synthetic */ ir6 c;

        public i(ir6 ir6Var, zq6.h hVar, zq6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ir6Var;
            this.a = hVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zq6.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                zq6.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements zq6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public j(ir6 ir6Var, Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, context, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = funAdSlot;
            this.c = funAdLoadListener;
        }

        @Override // com.repackage.zq6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().loadAd(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq6.i a;
        public final /* synthetic */ zq6.g b;
        public final /* synthetic */ ir6 c;

        public k(ir6 ir6Var, zq6.i iVar, zq6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ir6Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                zq6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                zq6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            zq6.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) || (iVar = this.a) == null) {
                return;
            }
            iVar.a(str);
        }
    }

    /* loaded from: classes6.dex */
    public class l implements zq6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;

        public l(ir6 ir6Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funAdInteractionListener;
        }

        @Override // com.repackage.zq6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements zq6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public m(ir6 ir6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.repackage.zq6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq6.h a;
        public final /* synthetic */ zq6.g b;
        public final /* synthetic */ ir6 c;

        public n(ir6 ir6Var, zq6.h hVar, zq6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ir6Var;
            this.a = hVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zq6.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                zq6.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements zq6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public o(ir6 ir6Var, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, activity, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = funAdSlot;
            this.c = funAdLoadListener;
        }

        @Override // com.repackage.zq6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FunAdSdk.getAdFactory().loadAd(this.a, this.b, this.c);
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FunSplashAd a;
        public String b;
        public String c;

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755608796, "Lcom/repackage/ir6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755608796, "Lcom/repackage/ir6;");
                return;
            }
        }
        d = um4.a();
    }

    public ir6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new g(this);
    }

    @Override // com.repackage.zq6.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // com.repackage.zq6.f
    public void b(Activity activity, String str, int i2, zq6.h hVar, zq6.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, str, Integer.valueOf(i2), hVar, gVar}) == null) {
            u(new o(this, activity, new FunAdSlot.Builder().setSid(str).setAdCount(i2).setExpressWidth(pi.k(activity)).build(), new n(this, hVar, gVar)));
        }
    }

    @Override // com.repackage.zq6.f
    public void c(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, obj) == null) && (obj instanceof FunNativeAd2) && imageView != null) {
            hr6.L(imageView, (FunNativeAd2) obj);
        }
    }

    @Override // com.repackage.zq6.f
    public void d(Context context, String str, int i2, int i3, zq6.h hVar, zq6.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), hVar, gVar}) == null) {
            FunAdSlot.Builder builder = new FunAdSlot.Builder();
            builder.setSid(str).setAdCount(i2).setExpressWidth(pi.k(context));
            if (i3 > 0) {
                builder.setExpressHeight(i3);
            }
            u(new j(this, context, builder.build(), new i(this, hVar, gVar)));
        }
    }

    @Override // com.repackage.zq6.f
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            u(new m(this, str));
        }
    }

    @Override // com.repackage.zq6.f
    public ViewGroup e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new NativeAdContainer(context) : (ViewGroup) invokeL.objValue;
    }

    @Override // com.repackage.zq6.f
    public View f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                hr6.D(funNativeAd2);
                hr6.E(funNativeAd2);
                return hr6.m(funNativeAd2);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.repackage.zq6.f
    public void g(Activity activity, String str, ViewGroup viewGroup, zq6.i iVar, zq6.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new d(this, activity, viewGroup, str, new c(this, iVar, gVar)));
    }

    @Override // com.repackage.zq6.f
    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                return hr6.M((FunNativeAd2) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.zq6.f
    public Object i(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().getNativeAd2(activity, str);
        }
        return invokeLL.objValue;
    }

    @Override // com.repackage.zq6.f
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            u(null);
            return FunAdSdk.isSdkInitializeComplete() && FunAdSdk.getAdFactory().isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.zq6.f
    public void j(Object obj, zq6.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, obj, jVar) == null) && (obj instanceof FunNativeAd2)) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
            hr6.K(funNativeAd2, hr6.s(funNativeAd2), jVar);
        }
    }

    @Override // com.repackage.zq6.f
    public void k(Application application, zq6.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, application, lVar) == null) {
            if (FunAdSdk.isSdkInitializeComplete()) {
                if (lVar != null) {
                    lVar.initComplete();
                    return;
                }
                return;
            }
            FunAdConfig.Builder builder = new FunAdConfig.Builder(application);
            if (wc5.c()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_CSJ);
                or6.a("不初始化 PLATFORM_CSJ");
            } else {
                or6.a("初始化 PLATFORM_CSJ");
            }
            if (wc5.d()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_GDT);
                or6.a("不初始化 PLATFORM_GDT");
            } else {
                or6.a("初始化 PLATFORM_GDT");
            }
            if (wc5.e()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_KS);
                or6.a("不初始化 PLATFORM_KS");
            } else {
                or6.a("初始化 PLATFORM_KS");
            }
            boolean z = true;
            FunAdConfig.Builder videoDataFlowAutoStart = builder.setAppName(application.getString(R.string.obfuscated_res_0x7f0f029e)).setAppId(d).setUserId("").setUseTextureView(true).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false);
            if (!um4.g() && !um4.h() && !TbadkCoreApplication.getInst().isDebugMode()) {
                z = false;
            }
            videoDataFlowAutoStart.setLogEnabled(z).setKsAdConfig(w().build()).setCsjAdConfig(v().build());
            GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
            or6.a("小熊SDK开始初始化，APPID 是：" + d);
            FunAdSdk.init(builder.build(), this.c, new h(this, lVar));
        }
    }

    @Override // com.repackage.zq6.f
    public List<yq6> l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (!FunAdSdk.isSdkInitializeComplete()) {
                return new ArrayList();
            }
            List<CacheStatistic> cacheStatistics = FunAdSdk.getAdFactory().getCacheStatistics(str);
            ArrayList arrayList = new ArrayList(cacheStatistics.size());
            for (CacheStatistic cacheStatistic : cacheStatistics) {
                FunAdType funAdType = cacheStatistic.adType;
                String str2 = funAdType != null ? funAdType.getAdType().toString() : "";
                FunAdType funAdType2 = cacheStatistic.adType;
                arrayList.add(new yq6(str2, funAdType2 != null ? funAdType2.getPlatform() : "", cacheStatistic.pid, cacheStatistic.hashCode(), cacheStatistic.count, cacheStatistic.basePrice));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.zq6.f
    public void m(Activity activity, @NonNull Object obj, zq6.i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, zq6.g gVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar, str}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd2)) {
            u(new b(this, (FunNativeAd2) obj, list, list2, viewGroup, activity, str, new a(this, iVar, gVar)));
        }
    }

    @Override // com.repackage.zq6.f
    public void n(Activity activity, String str, ViewGroup viewGroup, zq6.i iVar, zq6.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048591, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new l(this, activity, viewGroup, str, new k(this, iVar, gVar)));
    }

    @Override // com.repackage.zq6.f
    public cq8 o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            cq8 cq8Var = null;
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                int s = hr6.s(funNativeAd2);
                if (s == -1) {
                    return null;
                }
                cq8Var = new cq8();
                String c2 = hr6.c(funNativeAd2, s);
                if (oi.isEmpty(c2)) {
                    c2 = "推广";
                }
                cq8Var.k(c2);
                cq8Var.l(hr6.v(funNativeAd2, s));
                cq8Var.j(hr6.q(funNativeAd2, s));
                cq8Var.g(hr6.n(funNativeAd2));
                cq8Var.h(hr6.b(funNativeAd2));
                cq8Var.i(s);
            }
            return cq8Var;
        }
        return (cq8) invokeL.objValue;
    }

    public final void u(zq6.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, lVar) == null) {
            k(TbadkCoreApplication.getInst(), lVar);
        }
    }

    public final ModuleConfigCsj.Builder v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new ModuleConfigCsj.Builder().setTitleBarTheme(1).setTtSupportMultiProcess(true).setTTCustomController(new e(this)) : (ModuleConfigCsj.Builder) invokeV.objValue;
    }

    public final ModuleConfigKs.Builder w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new ModuleConfigKs.Builder().setKsCustomController(new f(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen()) : (ModuleConfigKs.Builder) invokeV.objValue;
    }

    public final void x(String str) {
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (l2 = this.b.get(str)) == null) {
            return;
        }
        SpeedStatsManager speedStatsManager = SpeedStatsManager.getInstance();
        speedStatsManager.setTaskRunTime("Ad_load" + str, System.currentTimeMillis() - l2.longValue());
        SpeedStatsManager speedStatsManager2 = SpeedStatsManager.getInstance();
        speedStatsManager2.setTaskRunTime("Ad_end" + str, SpeedStatsManager.getInstance().isAdLoadEnd() ? 1L : 0L);
        this.b.remove(str);
    }

    public final void y(String str, String str2, int i2, zq6.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048597, this, str, str2, i2, gVar) == null) {
            vg a2 = s95.a();
            a2.b("type", "bear");
            a2.b("locate", gVar.a);
            a2.b(SetImageWatermarkTypeReqMsg.SWITCH, gVar.b);
            a2.b("sid", str2);
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
