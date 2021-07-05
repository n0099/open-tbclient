package com.kwad.sdk.contentalliance.tube;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.home.c;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.home.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public long f35585c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f35586d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f35587e;

    /* renamed from: f  reason: collision with root package name */
    public b f35588f;

    /* renamed from: g  reason: collision with root package name */
    public int f35589g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f35590h;

    public a(SceneImpl sceneImpl, @NonNull TubeEpisodeDetailParam tubeEpisodeDetailParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl, tubeEpisodeDetailParam};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35587e = new AtomicBoolean(false);
        b.a aVar = new b.a(this) { // from class: com.kwad.sdk.contentalliance.tube.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35591a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35591a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    this.f35591a.a(i4, str);
                    this.f35591a.f35587e.set(false);
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, adResultData) == null) {
                    if (this.f35591a.f35004a.isEmpty()) {
                        this.f35591a.f35589g = 0;
                        m.e();
                    }
                    for (AdTemplate adTemplate : adResultData.adTemplateList) {
                        adTemplate.mIsTubeEpisodeList = true;
                        com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "onSuccess PhotoId=" + d.k(adTemplate.photoInfo) + " 集：" + d.B(adTemplate.photoInfo));
                    }
                    this.f35591a.f35004a.addAll(adResultData.adTemplateList);
                    a.e(this.f35591a);
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) {
                    a aVar2 = this.f35591a;
                    aVar2.a(false, aVar2.f35589g);
                    this.f35591a.f35587e.set(false);
                }
            }
        };
        this.f35590h = aVar;
        this.f35586d = sceneImpl;
        this.f35585c = tubeEpisodeDetailParam.mTotalEpisodeCount;
        this.f35588f = new b(sceneImpl, tubeEpisodeDetailParam.mTubeId, aVar);
    }

    public static /* synthetic */ int e(a aVar) {
        int i2 = aVar.f35589g;
        aVar.f35589g = i2 + 1;
        return i2;
    }

    private long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            List<AdTemplate> list = this.f35004a;
            if (list == null || list.isEmpty()) {
                return 0L;
            }
            List<AdTemplate> list2 = this.f35004a;
            return d.k(list2.get(list2.size() - 1).photoInfo);
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            if (z2 && this.f35004a.size() >= this.f35585c) {
                f fVar = f.f36364g;
                a(fVar.k, fVar.l);
                return;
            }
            com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "loadData isRefresh=" + z);
            if (this.f35587e.getAndSet(true)) {
                return;
            }
            a(z, z2, i2, this.f35589g);
            if (!c.a()) {
                if (z) {
                    this.f35004a.clear();
                    this.f35589g = 0;
                }
                this.f35588f.a(z2, e());
                return;
            }
            this.f35004a.clear();
            this.f35589g = 0;
            m.e();
            this.f35004a.addAll(c.b());
            c.c();
            a(z, this.f35589g);
            this.f35589g++;
            this.f35587e.set(false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.f35588f.a();
        }
    }
}
