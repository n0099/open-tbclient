package com.kwad.components.core.l;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b e;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.utils.h a;
    public List<WeakReference<h.a>> b;
    public boolean c;
    public boolean d;

    public b(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = false;
        this.d = false;
        b(context);
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (e == null) {
                synchronized (b.class) {
                    if (e == null) {
                        e = new b(context.getApplicationContext());
                    }
                }
            }
            return e;
        }
        return (b) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.c = false;
            com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
            this.a = hVar;
            hVar.a(new h.a(this) { // from class: com.kwad.components.core.l.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.utils.h.a
                public final void a() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.a.b.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                                it.remove();
                            } else {
                                aVar.a();
                            }
                        }
                        this.a.d = true;
                    }
                }

                @Override // com.kwad.sdk.utils.h.a
                public final void b() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Iterator it = this.a.b.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                                it.remove();
                            } else {
                                aVar.b();
                            }
                        }
                    }
                }
            });
        }
    }

    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.b.add(new WeakReference<>(aVar));
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (this.a == null) {
                return false;
            }
            if (z || !this.c) {
                this.c = true;
                this.d = false;
                return this.a.a();
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            Iterator<WeakReference<h.a>> it = this.b.iterator();
            while (it.hasNext()) {
                WeakReference<h.a> next = it.next();
                if (next == null || next.get() == aVar) {
                    it.remove();
                }
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }
}
