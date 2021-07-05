package com.kwad.sdk.contentalliance.tube.detail.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.tube.a.c;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.detail.TubeDetailParam;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f35630a;

    /* renamed from: b  reason: collision with root package name */
    public TubeDetailParam f35631b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35632c;

    /* renamed from: d  reason: collision with root package name */
    public Set<b.a> f35633d;

    /* renamed from: e  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.tube.detail.a> f35634e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f35635f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.b f35636g;

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
        this.f35633d = new LinkedHashSet();
        this.f35634e = new LinkedHashSet();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35633d.clear();
            com.kwad.sdk.core.i.a aVar = this.f35632c;
            if (aVar != null) {
                aVar.f();
            }
        }
    }
}
