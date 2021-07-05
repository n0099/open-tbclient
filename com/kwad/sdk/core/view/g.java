package com.kwad.sdk.core.view;

import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.core.i.b, ap.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ap f36782a;

    /* renamed from: b  reason: collision with root package name */
    public Set<a> f36783b;

    /* renamed from: c  reason: collision with root package name */
    public Set<com.kwad.sdk.core.i.c> f36784c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36785d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36786e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public View f36787f;

    /* renamed from: g  reason: collision with root package name */
    public int f36788g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z);
    }

    public g(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36785d = false;
        this.f36786e = true;
        this.f36787f = view;
        this.f36788g = i2;
        this.f36782a = new ap(this);
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            Set<a> set = this.f36783b;
            if (set != null) {
                for (a aVar : set) {
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
            }
            if (this.f36784c != null) {
                if (z != this.f36785d || this.f36786e) {
                    this.f36785d = z;
                    this.f36786e = false;
                    if (z) {
                        for (com.kwad.sdk.core.i.c cVar : this.f36784c) {
                            if (cVar != null) {
                                cVar.c_();
                            }
                        }
                        return;
                    }
                    for (com.kwad.sdk.core.i.c cVar2 : this.f36784c) {
                        if (cVar2 != null) {
                            cVar2.c_();
                        }
                    }
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36782a.removeMessages(1);
            this.f36782a.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 1) {
            a(d());
            this.f36782a.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    public void a(com.kwad.sdk.core.i.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        if (this.f36784c == null) {
            this.f36784c = new HashSet();
        }
        this.f36784c.add(cVar);
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f36783b == null) {
            this.f36783b = new HashSet();
        }
        this.f36783b.add(aVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f36782a.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    public void b(com.kwad.sdk.core.i.c cVar) {
        Set<com.kwad.sdk.core.i.c> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (set = this.f36784c) == null) {
            return;
        }
        set.remove(cVar);
    }

    public void b(a aVar) {
        Set<a> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || (set = this.f36783b) == null) {
            return;
        }
        set.remove(aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            Set<a> set = this.f36783b;
            if (set != null) {
                set.clear();
            }
            Set<com.kwad.sdk.core.i.c> set2 = this.f36784c;
            if (set2 != null) {
                set2.clear();
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ao.a(this.f36787f, this.f36788g) : invokeV.booleanValue;
    }
}
