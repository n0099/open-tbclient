package com.kwad.sdk.contentalliance.profile.home.b;

import androidx.viewpager.widget.ViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.c;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f35327a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f35328b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f35329c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileHomeParam f35330d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35331e;

    /* renamed from: f  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f35332f;

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
        this.f35332f = new LinkedHashSet();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35332f.clear();
            com.kwad.sdk.core.i.a aVar = this.f35331e;
            if (aVar != null) {
                aVar.f();
            }
        }
    }
}
