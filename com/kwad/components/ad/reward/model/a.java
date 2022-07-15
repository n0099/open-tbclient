package com.kwad.components.ad.reward.model;

import android.text.SpannableString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.core.widget.f;
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
    public String a;
    public String b;
    public String c;
    public List<String> d;
    public String e;
    public String f;
    public String g;
    public SpannableString h;
    public String i;
    public String j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public List<String> p;
    public String q;
    @Nullable
    public AdTemplate r;
    @Nullable
    public com.kwad.components.core.c.a.b s;

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
        this.n = "查看详情";
        this.o = "立即预约";
    }

    @Nullable
    public static a a(w wVar, boolean z) {
        InterceptResult invokeLZ;
        AdTemplate a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, wVar, z)) == null) {
            if (wVar == null || (a = wVar.a()) == null) {
                return null;
            }
            AdInfo i = d.i(a);
            a aVar = new a();
            aVar.b = com.kwad.sdk.core.response.a.a.aC(i);
            aVar.a = com.kwad.sdk.core.response.a.a.aE(i);
            aVar.c = com.kwad.sdk.core.response.a.a.z(i);
            aVar.d = com.kwad.sdk.core.response.a.c.f(a);
            aVar.e = com.kwad.sdk.core.response.a.a.H(i);
            aVar.k = d.b(a, z);
            aVar.r = a;
            aVar.s = wVar.b();
            return aVar;
        }
        return (a) invokeLZ.objValue;
    }

    @Nullable
    public static a a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo i = d.i(adTemplate);
            a aVar = new a();
            aVar.b = com.kwad.sdk.core.response.a.a.aY(i);
            aVar.a = com.kwad.sdk.core.response.a.a.aZ(i);
            aVar.h = com.kwad.sdk.core.response.a.a.a(i, f.a);
            aVar.c = com.kwad.sdk.core.response.a.a.aX(i);
            aVar.e = com.kwad.sdk.core.response.a.a.aU(i) ? com.kwad.components.ad.c.b.a() : com.kwad.components.ad.c.b.d();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            this.i = str;
        }
    }

    @Nullable
    public static a b(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo i = d.i(adTemplate);
            AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(i);
            a aVar = new a();
            String name = bd.getName();
            aVar.b = name;
            if (TextUtils.isEmpty(name)) {
                aVar.b = com.kwad.sdk.core.response.a.a.B(i);
            }
            aVar.a = bd.getIcon();
            aVar.c = com.kwad.sdk.core.response.a.a.z(i);
            aVar.e = com.kwad.components.ad.c.b.b();
            aVar.f = bd.getPrice();
            aVar.g = bd.getOriginPrice();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            this.j = str;
        }
    }

    @Nullable
    public static a c(AdTemplate adTemplate) {
        InterceptResult invokeL;
        CouponInfo firstCouponList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo i = d.i(adTemplate);
            AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(i);
            a aVar = new a();
            String name = bd.getName();
            aVar.b = name;
            if (TextUtils.isEmpty(name)) {
                aVar.b = com.kwad.sdk.core.response.a.a.B(i);
            }
            aVar.a = bd.getIcon();
            aVar.c = com.kwad.sdk.core.response.a.a.z(i);
            aVar.f = bd.getPrice();
            aVar.g = bd.getOriginPrice();
            if (!bd.isCouponListEmpty() && (firstCouponList = bd.getFirstCouponList()) != null) {
                aVar.b(CouponInfo.jinniuFormatCoupon(firstCouponList));
                aVar.a(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Nullable
    public static a d(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) {
            AdMatrixInfo.MerchantLiveReservationInfo C = com.kwad.sdk.core.response.a.b.C(adTemplate);
            a aVar = new a();
            aVar.a = C.userHeadUrl;
            aVar.q = C.liveStartTime;
            aVar.b = C.title;
            aVar.l = C.needShowSubscriberCount();
            aVar.m = C.getFormattedLiveSubscribeCount();
            aVar.p = C.bookUserUrlList;
            AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = C.playEndCard;
            aVar.n = liveReservationPlayEndInfo.detailBtnTitle;
            aVar.o = liveReservationPlayEndInfo.reservationBtnTitle;
            aVar.r = adTemplate;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public final SpannableString g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.h : (SpannableString) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    @Nullable
    public final AdTemplate j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : (AdTemplate) invokeV.objValue;
    }

    @Nullable
    public final com.kwad.components.core.c.a.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : (com.kwad.components.core.c.a.b) invokeV.objValue;
    }

    public final List<String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            List<String> list = this.d;
            return list == null || list.size() == 0;
        }
        return invokeV.booleanValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.intValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public final List<String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.p : (List) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q : (String) invokeV.objValue;
    }
}
