package com.kwad.sdk.feed.a.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.lib.a.a.b<AdResultData, AdTemplate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SceneImpl f37378a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f37379b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, e.a> f37380c;

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
        this.f37380c = new LinkedHashMap();
    }
}
