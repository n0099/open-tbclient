package com.kwad.sdk.contentalliance.home.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<AdTemplate> f35004a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f35005b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f35006c;

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
        this.f35004a = new ArrayList();
        this.f35005b = new Handler(Looper.getMainLooper());
        this.f35006c = new LinkedList();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public int a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) ? this.f35004a.indexOf(adTemplate) : invokeL.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(false, true, 4);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0) {
                a(false, false, i2);
            } else if (i2 == 1 || i2 == 2 || i2 == 3) {
                a(true, false, i2);
            } else {
                a(false, true, i2);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(int i2, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, adTemplate) == null) || i2 < 0 || this.f35004a.size() <= i2) {
            return;
        }
        this.f35004a.set(i2, adTemplate);
    }

    @MainThread
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            for (d dVar : this.f35006c) {
                dVar.a(i2, str);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.f35006c.add(dVar);
        }
    }

    @MainThread
    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            for (d dVar : this.f35006c) {
                dVar.a(z, i2);
            }
        }
    }

    public abstract void a(boolean z, boolean z2, int i2);

    @MainThread
    public void a(boolean z, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            for (d dVar : this.f35006c) {
                dVar.a(z, z2, i2, i3);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public List<AdTemplate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35004a : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.f35006c.remove(dVar);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            List<AdTemplate> list = this.f35004a;
            return list == null || list.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f35005b.removeCallbacksAndMessages(null);
        }
    }
}
