package com.kwad.sdk.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.request.a.k;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class e extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public static final h<?, ?> f37673a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f37674b;

    /* renamed from: c  reason: collision with root package name */
    public final Registry f37675c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.request.a.f f37676d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.request.f f37677e;

    /* renamed from: f  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.request.e<Object>> f37678f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Class<?>, h<?, ?>> f37679g;

    /* renamed from: h  reason: collision with root package name */
    public final i f37680h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f37681i;
    public final int j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1341723387, "Lcom/kwad/sdk/glide/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1341723387, "Lcom/kwad/sdk/glide/e;");
                return;
            }
        }
        f37673a = new b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, @NonNull Registry registry, @NonNull com.kwad.sdk.glide.request.a.f fVar, @NonNull com.kwad.sdk.glide.request.f fVar2, @NonNull Map<Class<?>, h<?, ?>> map, @NonNull List<com.kwad.sdk.glide.request.e<Object>> list, @NonNull i iVar, boolean z, int i2) {
        super(context.getApplicationContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, bVar, registry, fVar, fVar2, map, list, iVar, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37674b = bVar;
        this.f37675c = registry;
        this.f37676d = fVar;
        this.f37677e = fVar2;
        this.f37678f = list;
        this.f37679g = map;
        this.f37680h = iVar;
        this.f37681i = z;
        this.j = i2;
    }

    @NonNull
    public <T> h<?, T> a(@NonNull Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            h<?, T> hVar = (h<?, T>) this.f37679g.get(cls);
            if (hVar == null) {
                for (Map.Entry<Class<?>, h<?, ?>> entry : this.f37679g.entrySet()) {
                    if (entry.getKey().isAssignableFrom(cls)) {
                        hVar = (h<?, T>) entry.getValue();
                    }
                }
            }
            return hVar == null ? (h<?, T>) f37673a : hVar;
        }
        return (h) invokeL.objValue;
    }

    @NonNull
    public <X> k<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, cls)) == null) ? this.f37676d.a(imageView, cls) : (k) invokeLL.objValue;
    }

    public List<com.kwad.sdk.glide.request.e<Object>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37678f : (List) invokeV.objValue;
    }

    public com.kwad.sdk.glide.request.f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37677e : (com.kwad.sdk.glide.request.f) invokeV.objValue;
    }

    @NonNull
    public i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37680h : (i) invokeV.objValue;
    }

    @NonNull
    public Registry d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37675c : (Registry) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37674b : (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37681i : invokeV.booleanValue;
    }
}
