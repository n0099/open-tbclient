package com.kwad.sdk.contentalliance.home.c.a;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.b.a;
/* loaded from: classes7.dex */
public class b extends a.C0475a<AdTemplate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SlidePlayViewPager f35176a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public View f35177b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.c.b f35178c;

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
            }
        }
    }
}
