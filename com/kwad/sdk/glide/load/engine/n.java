package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n<Z> implements s<Z> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38139a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f38140b;

    /* renamed from: c  reason: collision with root package name */
    public final s<Z> f38141c;

    /* renamed from: d  reason: collision with root package name */
    public a f38142d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f38143e;

    /* renamed from: f  reason: collision with root package name */
    public int f38144f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38145g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38141c = (s) com.kwad.sdk.glide.g.j.a(sVar);
        this.f38139a = z;
        this.f38140b = z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38141c.a() : (Class) invokeV.objValue;
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, aVar) == null) {
            synchronized (this) {
                this.f38143e = cVar;
                this.f38142d = aVar;
            }
        }
    }

    public s<Z> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38141c : (s) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38141c.c() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f38144f > 0) {
                    throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
                }
                if (this.f38145g) {
                    throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
                }
                this.f38145g = true;
                if (this.f38140b) {
                    this.f38141c.d_();
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38141c.e() : (Z) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38139a : invokeV.booleanValue;
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.f38145g) {
                    throw new IllegalStateException("Cannot acquire a recycled resource");
                }
                this.f38144f++;
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.f38142d) {
                synchronized (this) {
                    if (this.f38144f <= 0) {
                        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                    }
                    int i2 = this.f38144f - 1;
                    this.f38144f = i2;
                    if (i2 == 0) {
                        this.f38142d.a(this.f38143e, this);
                    }
                }
            }
        }
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                str = "EngineResource{isCacheable=" + this.f38139a + ", listener=" + this.f38142d + ", key=" + this.f38143e + ", acquired=" + this.f38144f + ", isRecycled=" + this.f38145g + ", resource=" + this.f38141c + '}';
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
