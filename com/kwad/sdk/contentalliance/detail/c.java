package com.kwad.sdk.contentalliance.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.a.e;
import com.kwad.sdk.contentalliance.detail.photo.f.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f34574a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.a.a> f34575b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.a.c> f34576c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f34577d;

    /* renamed from: e  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.home.swipe.a> f34578e;

    /* renamed from: f  reason: collision with root package name */
    public List<f.a> f34579f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34580g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34581h;

    /* renamed from: i  reason: collision with root package name */
    public int f34582i;
    @NonNull
    public AdTemplate j;
    public KsFragment k;
    public SlidePlayViewPager l;
    @Nullable
    public com.kwad.sdk.contentalliance.detail.video.b m;
    public boolean n;
    @Nullable
    public com.kwad.sdk.core.download.b.b o;
    @Nullable
    public com.kwad.sdk.c.c p;
    public com.kwad.sdk.contentalliance.detail.b.b q;
    @Nullable
    public com.kwad.sdk.live.slide.detail.a.a r;

    public c() {
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
        this.f34575b = new LinkedList();
        this.f34576c = new ArrayList();
        this.f34577d = new ArrayList();
        this.f34578e = new LinkedList();
        this.f34579f = new ArrayList();
        this.n = false;
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.b bVar = this.m;
            if (bVar != null) {
                bVar.i();
            }
            com.kwad.sdk.live.slide.detail.a.a aVar = this.r;
            if (aVar != null) {
                aVar.a();
            }
            com.kwad.sdk.core.download.b.b bVar2 = this.o;
            if (bVar2 != null) {
                bVar2.f();
            }
        }
    }

    public void a(com.kwad.sdk.contentalliance.trends.view.c cVar) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && com.kwad.sdk.core.response.b.c.B(this.j) && (hVar = this.f34574a) != null) {
            hVar.f35244e.add(cVar);
        }
    }

    public void b(com.kwad.sdk.contentalliance.trends.view.c cVar) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) && com.kwad.sdk.core.response.b.c.B(this.j) && (hVar = this.f34574a) != null) {
            hVar.f35244e.remove(cVar);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34580g : invokeV.booleanValue;
    }
}
