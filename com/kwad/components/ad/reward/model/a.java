package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String kY;
    public String liveStartTime;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public String np;
    public List<String> oW;
    public String oX;
    public String oY;
    public String oZ;
    public String originPrice;
    public boolean pa;
    public String pb;
    public String pc;
    public String pd;
    public List<String> pe;
    @Nullable
    public AdTemplate pf;
    public int playableStyle;
    public String price;
    public String title;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pc = "查看详情";
        this.pd = "立即预约";
    }

    private void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            this.oY = str;
        }
    }

    private void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.oZ = str;
        }
    }

    @Nullable
    public static a a(u uVar, boolean z) {
        InterceptResult invokeLZ;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, uVar, z)) == null) {
            if (uVar == null || (adTemplate = uVar.getAdTemplate()) == null) {
                return null;
            }
            AdInfo bQ = d.bQ(adTemplate);
            a aVar = new a();
            aVar.title = com.kwad.sdk.core.response.a.a.bl(bQ);
            aVar.kY = com.kwad.sdk.core.response.a.a.bn(bQ);
            aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
            aVar.oW = com.kwad.sdk.core.response.a.c.bH(adTemplate);
            aVar.oX = com.kwad.sdk.core.response.a.a.al(bQ);
            aVar.playableStyle = d.f(adTemplate, z);
            aVar.pf = adTemplate;
            aVar.mApkDownloadHelper = uVar.getApkDownloadHelper();
            return aVar;
        }
        return (a) invokeLZ.objValue;
    }

    @Nullable
    public static a v(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo bQ = d.bQ(adTemplate);
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(bQ);
            a aVar = new a();
            String name = bN.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.a.a.af(bQ);
            }
            aVar.kY = bN.getIcon();
            aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
            aVar.oX = com.kwad.components.ad.c.b.ai();
            aVar.price = bN.getPrice();
            aVar.originPrice = bN.getOriginPrice();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Nullable
    public static a w(AdTemplate adTemplate) {
        InterceptResult invokeL;
        CouponInfo firstCouponList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo bQ = d.bQ(adTemplate);
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(bQ);
            a aVar = new a();
            String name = bN.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.a.a.af(bQ);
            }
            aVar.kY = bN.getIcon();
            aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
            aVar.price = bN.getPrice();
            aVar.originPrice = bN.getOriginPrice();
            if (!bN.isCouponListEmpty() && (firstCouponList = bN.getFirstCouponList()) != null) {
                aVar.T(CouponInfo.jinniuFormatCoupon(firstCouponList));
                aVar.S(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Nullable
    public static a x(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adTemplate)) == null) {
            AdMatrixInfo.MerchantLiveReservationInfo bA = com.kwad.sdk.core.response.a.b.bA(adTemplate);
            a aVar = new a();
            aVar.kY = bA.userHeadUrl;
            aVar.liveStartTime = bA.liveStartTime;
            aVar.title = bA.title;
            aVar.pa = bA.needShowSubscriberCount();
            aVar.pb = bA.getFormattedLiveSubscribeCount();
            aVar.pe = bA.bookUserUrlList;
            AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = bA.playEndCard;
            aVar.pc = liveReservationPlayEndInfo.detailBtnTitle;
            aVar.pd = liveReservationPlayEndInfo.reservationBtnTitle;
            aVar.pf = adTemplate;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final String eL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.kY : (String) invokeV.objValue;
    }

    public final String fO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.np : (String) invokeV.objValue;
    }

    @Nullable
    public final AdTemplate gA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pf : (AdTemplate) invokeV.objValue;
    }

    public final List<String> gB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.oW : (List) invokeV.objValue;
    }

    public final boolean gC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<String> list = this.oW;
            return list == null || list.size() == 0;
        }
        return invokeV.booleanValue;
    }

    public final int gD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.playableStyle : invokeV.intValue;
    }

    public final String gE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pb : (String) invokeV.objValue;
    }

    public final String gF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.pc : (String) invokeV.objValue;
    }

    public final String gG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.pd : (String) invokeV.objValue;
    }

    public final boolean gH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.pa : invokeV.booleanValue;
    }

    public final List<String> gI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.pe : (List) invokeV.objValue;
    }

    public final String gJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.liveStartTime : (String) invokeV.objValue;
    }

    @Nullable
    public final com.kwad.components.core.c.a.c getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mApkDownloadHelper : (com.kwad.components.core.c.a.c) invokeV.objValue;
    }

    public final String getOriginPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.originPrice : (String) invokeV.objValue;
    }

    public final String getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.price : (String) invokeV.objValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public final String gx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.oX : (String) invokeV.objValue;
    }

    public final String gy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.oZ : (String) invokeV.objValue;
    }

    public final String gz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.oY : (String) invokeV.objValue;
    }
}
