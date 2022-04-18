package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
import com.repackage.hl8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class oa8 implements ja8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdvertAppInfo> a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-134464338, "Lcom/repackage/oa8$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-134464338, "Lcom/repackage/oa8$a;");
                    return;
                }
            }
            int[] iArr = new int[IAdBaseAsyncController.Type.values().length];
            a = iArr;
            try {
                iArr[IAdBaseAsyncController.Type.PIC_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IAdBaseAsyncController.Type.PIC_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IAdBaseAsyncController.Type.VIDEO_FLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public oa8() {
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

    @Override // com.repackage.ja8
    public ho<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.z) {
                return new wa8(baseFragmentActivity, bdUniqueId);
            }
            if (bdUniqueId == AdvertAppInfo.x) {
                return new va8(baseFragmentActivity, bdUniqueId);
            }
            return null;
        }
        return (ho) invokeLL.objValue;
    }

    @Override // com.repackage.ja8
    public ea8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? s98.t() : (ea8) invokeV.objValue;
    }

    @Override // com.repackage.ja8
    public App c(App app, Cmatch cmatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, app, cmatch)) == null) ? yj5.i().n(app, cmatch) : (App) invokeLL.objValue;
    }

    @Override // com.repackage.ja8
    public void d(boolean z, String str, String str2, String str3, String str4, List<hl8.c> list, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, list, str5}) == null) {
            ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
        }
    }

    @Override // com.repackage.ja8
    public y98 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? wi5.l() : (y98) invokeV.objValue;
    }

    @Override // com.repackage.ja8
    public ho<?, ?> f(ia8 ia8Var, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, ia8Var, bdUniqueId)) == null) {
            if (ia8Var == null || bdUniqueId == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.w) {
                return new ta8(ia8Var, bdUniqueId);
            }
            return new ua8(ia8Var, bdUniqueId);
        }
        return (ho) invokeLL.objValue;
    }

    @Override // com.repackage.ja8
    public void g() {
        List<AdvertAppInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.a) == null) {
            return;
        }
        StringUtils.string(Integer.valueOf(list.size()));
    }

    @Override // com.repackage.ja8
    public List<AdvertAppInfo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.ja8
    public void i(AdvertAppInfo advertAppInfo, Context context) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo, context) == null) || advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.i;
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
        o(advertAppInfo);
        String n = na8.n(adCard.getScheme());
        Bundle bundle = new Bundle();
        bundle.putString("video_url", videoInfo.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, videoInfo.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, videoInfo.video_width.intValue() / videoInfo.video_height.intValue());
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration.intValue());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, advertAppInfo.getDownloadId());
        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, advertAppInfo.h);
        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, adCard.goodsStyle);
        bundle.putString(WebViewActivityConfig.TAG_AD_DEEPLINK_URL, adCard.scheme);
        nc8 nc8Var = adCard.tailFrame;
        if (nc8Var != null) {
            nc8Var.e = adCard.getButtonText();
            bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, adCard.tailFrame.e());
        }
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", n, true, true, true, bundle));
    }

    @Override // com.repackage.ja8
    public ho<?, ?> j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, tbPageContext, bdUniqueId, str)) == null) {
            if (bdUniqueId == AdvertAppInfo.y) {
                return new ra8(tbPageContext, bdUniqueId, str);
            }
            if (bdUniqueId != null) {
                return new sa8(tbPageContext, bdUniqueId, str);
            }
            return null;
        }
        return (ho) invokeLLL.objValue;
    }

    @Override // com.repackage.ja8
    @Nullable
    public IAdBaseAsyncController k(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, type, aVar)) == null) {
            int i = a.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return new md8(aVar);
                }
                return new vc8(aVar);
            }
            return new wc8(aVar);
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.repackage.ja8
    public aj8 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ak5.g() : (aj8) invokeV.objValue;
    }

    @Override // com.repackage.ja8
    public void m(boolean z, String str, String str2, String str3, List<hl8.c> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), str, str2, str3, list, str4}) == null) {
            ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
        }
    }

    @Override // com.repackage.ja8
    public ga8 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? s98.t() : (ga8) invokeV.objValue;
    }

    @Override // com.repackage.ja8
    public void o(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, advertAppInfo) == null) {
            AdWebVideoActivity.setStaticInfo(advertAppInfo, 0, "DETAIL");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v14 */
    @Override // com.repackage.ja8
    public void p(@NonNull HashMap<String, String> hashMap, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, hashMap, context) == null) {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = null;
            try {
                JSONObject jSONObject2 = hashMap.get(WriteActivityConfig.VIDEO_INFO) != null ? new JSONObject(hashMap.get(WriteActivityConfig.VIDEO_INFO)) : null;
                if (jSONObject2 != null) {
                    bundle.putString("video_url", jSONObject2.optString("video_url", ""));
                    bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, jSONObject2.optString("poster_image", ""));
                    float floatValue = Float.valueOf(jSONObject2.optString("video_aspect_ratio", "1")).floatValue();
                    bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, floatValue);
                    if (floatValue < 1.0f) {
                        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 14);
                    } else {
                        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
                    }
                    bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, jSONObject2.optInt("duration", 0));
                    bundle.putString(WebViewActivityConfig.TAG_AD_DEEPLINK_URL, jSONObject2.optString("page_url", ""));
                    String str = hashMap.get("url");
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = jSONObject2.optString("page_url", "");
                        }
                        JSONObject jSONObject3 = jSONObject2.get(AdWebVideoActivityConfig.KEY_TAIL_FRAME) != null ? new JSONObject(jSONObject2.optString(AdWebVideoActivityConfig.KEY_TAIL_FRAME)) : null;
                        JSONObject jSONObject4 = hashMap.get("download") != null ? new JSONObject(hashMap.get("download")) : null;
                        if (jSONObject4 != null) {
                            bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, jSONObject4.optString("key", ""));
                            jSONObject = new JSONObject();
                            jSONObject.put("pkgname", jSONObject4.optString("key", ""));
                            jSONObject.put("download_url", jSONObject4.optString("download_url", ""));
                        }
                        if (jSONObject3 != null) {
                            jSONObject3.put("style", TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                            jSONObject3.put("button_scheme", jSONObject3.optString("button_scheme", ""));
                            jSONObject3.put("scheme", jSONObject2.optString("page_url", ""));
                            jSONObject3.put("ext_data", jSONObject);
                            if (jSONObject4 != null) {
                                jSONObject3.put("pkgname", jSONObject4.optString("key", ""));
                                jSONObject3.put("style", "apk_download");
                            }
                        }
                        nc8 nc8Var = new nc8();
                        nc8Var.b(jSONObject3);
                        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, nc8Var.e());
                        jSONObject = str;
                    } catch (JSONException e) {
                        e = e;
                        jSONObject = str;
                        e.printStackTrace();
                        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
                        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", jSONObject, true, true, true, bundle));
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
            bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
            AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", jSONObject, true, true, true, bundle));
        }
    }
}
