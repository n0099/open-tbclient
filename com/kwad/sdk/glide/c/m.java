package com.kwad.sdk.glide.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.RequestTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<com.kwad.sdk.glide.request.c> f37653a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.request.c> f37654b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37655c;

    public m() {
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
        this.f37653a = Collections.newSetFromMap(new WeakHashMap());
        this.f37654b = new ArrayList();
    }

    private boolean a(@Nullable com.kwad.sdk.glide.request.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, cVar, z)) == null) {
            boolean z2 = true;
            if (cVar == null) {
                return true;
            }
            boolean remove = this.f37653a.remove(cVar);
            if (!this.f37654b.remove(cVar) && !remove) {
                z2 = false;
            }
            if (z2) {
                cVar.b();
                if (z) {
                    cVar.h();
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37655c = true;
            for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f37653a)) {
                if (cVar.c()) {
                    cVar.b();
                    this.f37654b.add(cVar);
                }
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.glide.request.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f37653a.add(cVar);
            if (!this.f37655c) {
                cVar.a();
                return;
            }
            cVar.b();
            if (Log.isLoggable(RequestTracker.TAG, 2)) {
                Log.v(RequestTracker.TAG, "Paused, delaying request");
            }
            this.f37654b.add(cVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37655c = false;
            for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f37653a)) {
                if (!cVar.e_() && !cVar.c()) {
                    cVar.a();
                }
            }
            this.f37654b.clear();
        }
    }

    public boolean b(@Nullable com.kwad.sdk.glide.request.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) ? a(cVar, true) : invokeL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f37653a)) {
                a(cVar, false);
            }
            this.f37654b.clear();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f37653a)) {
                if (!cVar.e_() && !cVar.f()) {
                    cVar.b();
                    if (this.f37655c) {
                        this.f37654b.add(cVar);
                    } else {
                        cVar.a();
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return super.toString() + "{numRequests=" + this.f37653a.size() + ", isPaused=" + this.f37655c + "}";
        }
        return (String) invokeV.objValue;
    }
}
