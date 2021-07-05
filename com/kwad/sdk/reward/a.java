package com.kwad.sdk.reward;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<com.kwad.sdk.reward.a.a> f38811a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f38812b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f38813c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f38814d;

    /* renamed from: e  reason: collision with root package name */
    public int f38815e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f38816f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f38817g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public AdBaseFrameLayout f38818h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f38819i;
    @Nullable
    public com.kwad.sdk.core.download.b.b j;
    @NonNull
    public com.kwad.sdk.reward.b.b.a.a k;
    @Nullable
    public com.kwad.sdk.c.c l;
    @Nullable
    public com.kwad.sdk.c.b m;
    public Set<com.kwad.sdk.reward.a.e> n;
    public Set<com.kwad.sdk.reward.a.d> o;
    public boolean p;
    public boolean q;

    public a() {
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
        this.f38811a = new ArrayList();
        this.n = new HashSet();
        this.o = new HashSet();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f38811a.clear();
            this.n.clear();
            this.f38819i.h();
            com.kwad.sdk.core.download.b.b bVar = this.j;
            if (bVar != null) {
                bVar.f();
            }
            com.kwad.sdk.c.c cVar = this.l;
            if (cVar != null) {
                cVar.c();
            }
            com.kwad.sdk.c.b bVar2 = this.m;
            if (bVar2 != null) {
                bVar2.c();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (com.kwad.sdk.reward.a.e eVar : this.n) {
                eVar.a();
            }
        }
    }
}
