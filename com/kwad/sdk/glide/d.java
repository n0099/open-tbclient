package com.kwad.sdk.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.c.k;
import com.kwad.sdk.glide.load.engine.a.a;
import com.kwad.sdk.glide.load.engine.a.i;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.j;
import com.kwad.sdk.glide.load.engine.i;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, h<?, ?>> f37664a;

    /* renamed from: b  reason: collision with root package name */
    public i f37665b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f37666c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f37667d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.h f37668e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f37669f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.b.a f37670g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0464a f37671h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.a.i f37672i;
    public com.kwad.sdk.glide.c.d j;
    public int k;
    public com.kwad.sdk.glide.request.f l;
    @Nullable
    public k.a m;
    public com.kwad.sdk.glide.load.engine.b.a n;
    public boolean o;
    @Nullable
    public List<com.kwad.sdk.glide.request.e<Object>> p;
    public boolean q;

    public d() {
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
        this.f37664a = new ArrayMap();
        this.k = 4;
        this.l = new com.kwad.sdk.glide.request.f();
    }

    @NonNull
    public c a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f37669f == null) {
                this.f37669f = com.kwad.sdk.glide.load.engine.b.a.b();
            }
            if (this.f37670g == null) {
                this.f37670g = com.kwad.sdk.glide.load.engine.b.a.a();
            }
            if (this.n == null) {
                this.n = com.kwad.sdk.glide.load.engine.b.a.d();
            }
            if (this.f37672i == null) {
                this.f37672i = new i.a(context).a();
            }
            if (this.j == null) {
                this.j = new com.kwad.sdk.glide.c.f();
            }
            if (this.f37666c == null) {
                int b2 = this.f37672i.b();
                if (b2 > 0) {
                    this.f37666c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.k(b2);
                } else {
                    this.f37666c = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f();
                }
            }
            if (this.f37667d == null) {
                this.f37667d = new j(this.f37672i.c());
            }
            if (this.f37668e == null) {
                this.f37668e = new com.kwad.sdk.glide.load.engine.a.g(this.f37672i.a());
            }
            if (this.f37671h == null) {
                this.f37671h = new com.kwad.sdk.glide.load.engine.a.f(context);
            }
            if (this.f37665b == null) {
                this.f37665b = new com.kwad.sdk.glide.load.engine.i(this.f37668e, this.f37671h, this.f37670g, this.f37669f, com.kwad.sdk.glide.load.engine.b.a.c(), com.kwad.sdk.glide.load.engine.b.a.d(), this.o);
            }
            List<com.kwad.sdk.glide.request.e<Object>> list = this.p;
            this.p = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            return new c(context, this.f37665b, this.f37668e, this.f37666c, this.f37667d, new k(this.m), this.j, this.k, this.l.i(), this.f37664a, this.p, this.q);
        }
        return (c) invokeL.objValue;
    }

    public void a(@Nullable k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.m = aVar;
        }
    }
}
