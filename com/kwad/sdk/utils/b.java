package com.kwad.sdk.utils;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f66670e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f66671a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<h.a>> f66672b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66673c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66674d;

    public b(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66672b = new ArrayList();
        this.f66673c = false;
        this.f66674d = false;
        b(context);
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f66670e == null) {
                synchronized (b.class) {
                    if (f66670e == null) {
                        f66670e = new b(context.getApplicationContext());
                    }
                }
            }
            return f66670e;
        }
        return (b) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.f66673c = false;
            h hVar = new h(context);
            this.f66671a = hVar;
            hVar.a(new h.a(this) { // from class: com.kwad.sdk.utils.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66675a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66675a = this;
                }

                @Override // com.kwad.sdk.utils.h.a
                public void a() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f66675a.f66672b.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                                it.remove();
                            } else {
                                aVar.a();
                            }
                        }
                        this.f66675a.f66674d = true;
                    }
                }

                @Override // com.kwad.sdk.utils.h.a
                public void b() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Iterator it = this.f66675a.f66672b.iterator();
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

    public void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f66672b.add(new WeakReference<>(aVar));
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f66671a == null) {
            return;
        }
        if (z || !this.f66673c) {
            this.f66671a.a();
            this.f66673c = true;
            this.f66674d = false;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66674d : invokeV.booleanValue;
    }

    public void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            Iterator<WeakReference<h.a>> it = this.f66672b.iterator();
            while (it.hasNext()) {
                WeakReference<h.a> next = it.next();
                if (next == null || next.get() == aVar) {
                    it.remove();
                }
            }
        }
    }
}
