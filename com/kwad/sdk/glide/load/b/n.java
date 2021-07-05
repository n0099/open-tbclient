package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public interface n<Model, Data> {

    /* loaded from: classes7.dex */
    public static class a<Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f37878a;

        /* renamed from: b  reason: collision with root package name */
        public final List<com.kwad.sdk.glide.load.c> f37879b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a.d<Data> f37880c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull com.kwad.sdk.glide.load.a.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((com.kwad.sdk.glide.load.c) objArr2[0], (List) objArr2[1], (com.kwad.sdk.glide.load.a.d) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull List<com.kwad.sdk.glide.load.c> list, @NonNull com.kwad.sdk.glide.load.a.d<Data> dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, list, dVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f37878a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f37879b = (List) com.kwad.sdk.glide.g.j.a(list);
            this.f37880c = (com.kwad.sdk.glide.load.a.d) com.kwad.sdk.glide.g.j.a(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar);

    boolean a(@NonNull Model model);
}
