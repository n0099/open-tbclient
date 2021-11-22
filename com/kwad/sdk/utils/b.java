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
    public static volatile b f67583e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f67584a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<h.a>> f67585b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67586c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67587d;

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
        this.f67585b = new ArrayList();
        this.f67586c = false;
        this.f67587d = false;
        b(context);
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f67583e == null) {
                synchronized (b.class) {
                    if (f67583e == null) {
                        f67583e = new b(context.getApplicationContext());
                    }
                }
            }
            return f67583e;
        }
        return (b) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.f67586c = false;
            h hVar = new h(context);
            this.f67584a = hVar;
            hVar.a(new h.a(this) { // from class: com.kwad.sdk.utils.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f67588a;

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
                    this.f67588a = this;
                }

                @Override // com.kwad.sdk.utils.h.a
                public void a() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f67588a.f67585b.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                                it.remove();
                            } else {
                                aVar.a();
                            }
                        }
                        this.f67588a.f67587d = true;
                    }
                }

                @Override // com.kwad.sdk.utils.h.a
                public void b() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Iterator it = this.f67588a.f67585b.iterator();
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
            this.f67585b.add(new WeakReference<>(aVar));
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f67584a == null) {
            return;
        }
        if (z || !this.f67586c) {
            this.f67584a.a();
            this.f67586c = true;
            this.f67587d = false;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67587d : invokeV.booleanValue;
    }

    public void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            Iterator<WeakReference<h.a>> it = this.f67585b.iterator();
            while (it.hasNext()) {
                WeakReference<h.a> next = it.next();
                if (next == null || next.get() == aVar) {
                    it.remove();
                }
            }
        }
    }
}
