package com.kwad.sdk.contentalliance.detail.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<KsContentPage.SubShowItem> f34572a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, KsContentPage.SubShowItem> f34573b;

    public b() {
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
        this.f34572a = new ArrayList();
        this.f34573b = new HashMap();
    }

    public int a(AdTemplate adTemplate, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, adTemplate, i2)) == null) {
            if (adTemplate == null) {
                return 0;
            }
            String str = adTemplate.mUniqueId;
            if (this.f34573b.containsKey(str)) {
                return 3;
            }
            if (adTemplate.contentType == 3) {
                com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，开始尝试插入,position:" + i2);
                if (this.f34572a.size() > 0) {
                    this.f34573b.put(str, this.f34572a.remove(0));
                    com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入成功,position:" + i2);
                    return 3;
                } else if (adTemplate.adInfoList.size() > 0 && adTemplate.adInfoList.get(0) != null) {
                    adTemplate.realShowType = 2;
                    com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入失败使用默认广告兜底,position:" + i2);
                    return 2;
                } else {
                    com.kwad.sdk.core.d.a.a("ThirdModelManager", "检测到第三方广告位，插入失败丢弃该位置，position:" + i2);
                    e.i(adTemplate);
                }
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public KsContentPage.SubShowItem a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate)) == null) ? this.f34573b.get(adTemplate.mUniqueId) : (KsContentPage.SubShowItem) invokeL.objValue;
    }

    public void a(KsContentPage.SubShowItem subShowItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subShowItem) == null) || this.f34572a.contains(subShowItem)) {
            return;
        }
        this.f34572a.add(subShowItem);
    }

    public void a(List<KsContentPage.SubShowItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        for (KsContentPage.SubShowItem subShowItem : list) {
            a(subShowItem);
        }
    }
}
