package com.kwad.sdk.contentalliance.home;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.b.f;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.trends.a.b.c;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsFragment f35219a;

    /* renamed from: b  reason: collision with root package name */
    public i f35220b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f35221c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.b.b f35222d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f35223e;

    /* renamed from: f  reason: collision with root package name */
    public h f35224f;

    /* renamed from: g  reason: collision with root package name */
    public String f35225g;

    /* renamed from: h  reason: collision with root package name */
    public List<TrendInfo> f35226h;

    /* renamed from: i  reason: collision with root package name */
    public TrendInfo f35227i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public List<c.a> n;
    public List<com.kwad.sdk.contentalliance.trends.view.c> o;
    public List<f.a> p;

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
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.f35224f) == null) {
            return;
        }
        hVar.a();
    }
}
