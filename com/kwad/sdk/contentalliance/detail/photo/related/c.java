package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.l;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34929c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f34930d;

    public c(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34929c = adTemplate;
        this.f34930d = adTemplate.mAdScene;
    }

    @Override // com.kwad.sdk.lib.b.b
    public i<g, AdResultData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            l.a aVar = new l.a();
            f fVar = new f(this.f34930d);
            fVar.f36139b = this.f34930d.getPageScene();
            aVar.f36298a = fVar;
            aVar.f36299b = new com.kwad.sdk.core.g.a.c();
            aVar.f36300c = String.valueOf(com.kwad.sdk.core.response.b.d.k(this.f34929c.photoInfo));
            return new i<g, AdResultData>(this, aVar) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l.a f34931a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f34932b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34932b = this;
                    this.f34931a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public l b() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? new l(this.f34931a) : (l) invokeV2.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.f34932b.f34930d);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }
            };
        }
        return (i) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.b
    public List<AdTemplate> a(AdResultData adResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adResultData)) == null) {
            if (adResultData == null) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                    arrayList.add(adTemplate);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.kwad.sdk.lib.b.b
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 != com.kwad.sdk.core.network.f.f36364g.k : invokeI.booleanValue;
    }

    @Override // com.kwad.sdk.lib.b.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<AdTemplate> d2 = a.a().d();
            return (d2 == null || d2.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.b
    /* renamed from: c */
    public AdResultData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<AdTemplate> d2 = a.a().d();
            if (d2 == null || d2.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(d2.size());
            for (AdTemplate adTemplate : d2) {
                adTemplate.mAdScene = this.f34930d;
                arrayList.add(adTemplate);
            }
            a.a().e();
            AdResultData adResultData = new AdResultData();
            adResultData.adTemplateList = arrayList;
            return adResultData;
        }
        return (AdResultData) invokeV.objValue;
    }
}
