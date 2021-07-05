package com.kwad.sdk.contentalliance.tube.detail.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Set;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.contentalliance.tube.detail.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.b f35680b;

    /* renamed from: c  reason: collision with root package name */
    public Set<b.a> f35681c;

    /* renamed from: d  reason: collision with root package name */
    public b.a f35682d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.detail.a f35683e;

    public f() {
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
        this.f35682d = new b.a(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35684a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35684a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    for (b.a aVar : this.f35684a.f35681c) {
                        aVar.a(z);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed isLoadMore" + z + " code=" + i4 + " msg=" + str);
                    for (b.a aVar : this.f35684a.f35681c) {
                        aVar.a(z, i4, str);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, adResultData) == null) {
                    com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed OK");
                    for (b.a aVar : this.f35684a.f35681c) {
                        aVar.a(z, adResultData);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) {
                    for (b.a aVar : this.f35684a.f35681c) {
                        aVar.b(z);
                    }
                }
            }
        };
        this.f35683e = new com.kwad.sdk.contentalliance.tube.detail.a(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35685a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35685a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.detail.a
            public void a(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                    com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "onLoadMore to load feed");
                    this.f35685a.f35680b.a(true, j);
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a;
            this.f35681c = bVar.f35633d;
            com.kwad.sdk.contentalliance.tube.b bVar2 = new com.kwad.sdk.contentalliance.tube.b(bVar.f35635f, bVar.f35631b.getTubeId(), this.f35682d);
            this.f35680b = bVar2;
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35636g = bVar2;
            bVar2.a(false, 0L);
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35634e.add(this.f35683e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35634e.remove(this.f35683e);
            this.f35680b.a();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
        }
    }
}
