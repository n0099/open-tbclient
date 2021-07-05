package d.a.s0.w2;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.request.ShowStatisticUploadRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.j0.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class y implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AdvertAppInfo> f69277a;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69278a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2104530572, "Ld/a/s0/w2/y$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2104530572, "Ld/a/s0/w2/y$a;");
                    return;
                }
            }
            int[] iArr = new int[IAdBaseAsyncController.Type.values().length];
            f69278a = iArr;
            try {
                iArr[IAdBaseAsyncController.Type.PIC_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69278a[IAdBaseAsyncController.Type.PIC_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.s0.w2.u
    public d.a.c.k.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.i4) {
                return new d.a.s0.w2.a0.f(baseFragmentActivity, bdUniqueId);
            }
            if (bdUniqueId == AdvertAppInfo.g4) {
                return new d.a.s0.w2.a0.e(baseFragmentActivity, bdUniqueId);
            }
            return null;
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e.t() : (p) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public App c(App app, Cmatch cmatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, app, cmatch)) == null) ? d.a.s0.q.e.a.i().n(app, cmatch) : (App) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, list, str5}) == null) {
            ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
        }
    }

    @Override // d.a.s0.w2.u
    public k e(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{tbPageContext, iLegoAdvert, Integer.valueOf(i2), Boolean.valueOf(z), str, str2})) == null) {
            if (iLegoAdvert instanceof AdCard) {
                return new d.a.s0.w2.f0.d.a.d(tbPageContext, iLegoAdvert, i2, z, str, str2);
            }
            return null;
        }
        return (k) invokeCommon.objValue;
    }

    @Override // d.a.s0.w2.u
    public l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? d.a.s0.q.a.l() : (l) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public d.a.c.k.e.a<?, ?> g(t tVar, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tVar, bdUniqueId)) == null) {
            if (tVar == null || bdUniqueId == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.f4) {
                return new d.a.s0.w2.a0.c(tVar, bdUniqueId);
            }
            return new d.a.s0.w2.a0.d(tVar, bdUniqueId);
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public void h() {
        List<AdvertAppInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (list = this.f69277a) == null) {
            return;
        }
        StringUtils.string(Integer.valueOf(list.size()));
    }

    @Override // d.a.s0.w2.u
    public List<AdvertAppInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f69277a == null) {
                this.f69277a = new ArrayList();
            }
            return this.f69277a;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public void j(AdvertAppInfo advertAppInfo, Context context) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, advertAppInfo, context) == null) || advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.T3;
        AdCard adCard = null;
        if (iLegoAdvert instanceof AdCard) {
            adCard = (AdCard) iLegoAdvert;
            videoInfo = adCard.videoInfo;
        } else {
            videoInfo = null;
        }
        if (adCard == null || videoInfo == null) {
            return;
        }
        AdWebVideoActivity.setStaticInfo(advertAppInfo, 0, "DETAIL");
        String m = x.m(adCard.getScheme());
        Bundle bundle = new Bundle();
        bundle.putString("video_url", videoInfo.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, videoInfo.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, videoInfo.video_width.intValue() / videoInfo.video_height.intValue());
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration.intValue());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, advertAppInfo.getDownloadId());
        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, advertAppInfo.S3);
        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, adCard.goodsStyle);
        bundle.putString(WebViewActivityConfig.TAG_AD_DEEPLINK_URL, adCard.scheme);
        d.a.s0.w2.f0.b.f fVar = adCard.tailFrame;
        if (fVar != null) {
            fVar.f69154e = adCard.getButtonText();
            bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, adCard.tailFrame.e());
        }
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", m, true, true, true, bundle));
    }

    @Override // d.a.s0.w2.u
    public d.a.c.k.e.a<?, ?> k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, tbPageContext, bdUniqueId, str)) == null) {
            if (bdUniqueId == AdvertAppInfo.h4) {
                return new d.a.s0.w2.a0.a(tbPageContext, bdUniqueId, str);
            }
            if (bdUniqueId != null) {
                return new d.a.s0.w2.a0.b(tbPageContext, bdUniqueId, str);
            }
            return null;
        }
        return (d.a.c.k.e.a) invokeLLL.objValue;
    }

    @Override // d.a.s0.w2.u
    @Nullable
    public IAdBaseAsyncController l(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, type, aVar)) == null) {
            int i2 = a.f69278a[type.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return new d.a.s0.w2.h0.b(aVar);
            }
            return new d.a.s0.w2.h0.c(aVar);
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public d.a.s0.f3.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d.a.s0.q.f.a.g() : (d.a.s0.f3.a) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), str, str2, str3, list, str4}) == null) {
            ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
        }
    }

    @Override // d.a.s0.w2.u
    public r o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? e.t() : (r) invokeV.objValue;
    }
}
