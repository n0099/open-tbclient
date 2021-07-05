package com.kwad.sdk.contentalliance.profile.tabvideo;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.p;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35393c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileTabVideoParam f35394d;

    /* renamed from: e  reason: collision with root package name */
    public int f35395e;

    /* renamed from: f  reason: collision with root package name */
    public String f35396f;

    public d(SceneImpl sceneImpl, ProfileTabVideoParam profileTabVideoParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl, profileTabVideoParam};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35393c = sceneImpl;
        this.f35394d = profileTabVideoParam;
    }

    @Override // com.kwad.sdk.lib.b.b
    public i<g, AdResultData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            p.a aVar = new p.a();
            aVar.f36324e = this.f35396f;
            f fVar = new f(this.f35393c);
            fVar.f36139b = this.f35393c.getPageScene();
            aVar.f36320a = fVar;
            ProfileTabVideoParam profileTabVideoParam = this.f35394d;
            aVar.f36322c = profileTabVideoParam.mAuthorId;
            aVar.f36323d = profileTabVideoParam.mTabId;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f36126d = this.f35395e;
            aVar.f36321b = cVar;
            return new i<g, AdResultData>(this, aVar) { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p.a f35397a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f35398b;

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
                    this.f35398b = this;
                    this.f35397a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.f35397a.f36320a.f36138a);
                        adResultData.parseJson(jSONObject);
                        if (!adResultData.adTemplateList.isEmpty()) {
                            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                                adTemplate.mPcursor = adResultData.pcursor;
                            }
                        }
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public p b() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? new p(this.f35397a) : (p) invokeV2.objValue;
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
            this.f35395e++;
            return adResultData.adTemplateList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.b
    public boolean b(AdResultData adResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adResultData)) == null) {
            String str = adResultData.pcursor;
            this.f35396f = str;
            return !"0".equals(str);
        }
        return invokeL.booleanValue;
    }
}
