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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ac8 implements wb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdvertAppInfo> a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-533425410, "Lcom/repackage/ac8$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-533425410, "Lcom/repackage/ac8$a;");
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
                a[IAdBaseAsyncController.Type.VIDEO_FLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ac8() {
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

    @Override // com.repackage.wb8
    public bn<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.z) {
                return new gc8(baseFragmentActivity, bdUniqueId);
            }
            if (bdUniqueId == AdvertAppInfo.x) {
                return new fc8(baseFragmentActivity, bdUniqueId);
            }
            return null;
        }
        return (bn) invokeLL.objValue;
    }

    @Override // com.repackage.wb8
    public rb8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? gb8.t() : (rb8) invokeV.objValue;
    }

    @Override // com.repackage.wb8
    public mb8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? am5.l() : (mb8) invokeV.objValue;
    }

    @Override // com.repackage.wb8
    public bn<?, ?> d(vb8 vb8Var, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, vb8Var, bdUniqueId)) == null) {
            if (vb8Var == null || bdUniqueId == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.w) {
                return new dc8(vb8Var, bdUniqueId);
            }
            return new ec8(vb8Var, bdUniqueId, null);
        }
        return (bn) invokeLL.objValue;
    }

    @Override // com.repackage.wb8
    public void e() {
        List<AdvertAppInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.a) == null) {
            return;
        }
        StringUtils.string(Integer.valueOf(list.size()));
    }

    @Override // com.repackage.wb8
    public List<AdvertAppInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.wb8
    public bn<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, bdUniqueId, str)) == null) {
            if (bdUniqueId == AdvertAppInfo.y) {
                return new bc8(tbPageContext, bdUniqueId, str);
            }
            if (bdUniqueId != null) {
                return new cc8(tbPageContext, bdUniqueId, str);
            }
            return null;
        }
        return (bn) invokeLLL.objValue;
    }

    @Override // com.repackage.wb8
    @Nullable
    public IAdBaseAsyncController h(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, type, aVar)) == null) {
            int i = a.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new sd8(aVar);
            }
            return new id8(aVar);
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.repackage.wb8
    public tb8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? gb8.t() : (tb8) invokeV.objValue;
    }

    @Override // com.repackage.wb8
    public void j(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, advertAppInfo) == null) {
            AdWebVideoActivity.f2(advertAppInfo, 0, "DETAIL");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v14 */
    @Override // com.repackage.wb8
    public void k(@NonNull HashMap<String, String> hashMap, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hashMap, context) == null) {
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
                        bd8 bd8Var = new bd8();
                        bd8Var.b(jSONObject3);
                        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, bd8Var.d());
                        jSONObject = str;
                    } catch (JSONException e) {
                        e = e;
                        jSONObject = str;
                        e.printStackTrace();
                        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
                        AdWebVideoActivity.e2(new AdWebVideoActivityConfig(context, "", jSONObject, true, true, true, bundle));
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
            bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
            AdWebVideoActivity.e2(new AdWebVideoActivityConfig(context, "", jSONObject, true, true, true, bundle));
        }
    }
}
