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
import com.kwad.sdk.utils.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f59630e;
    public transient /* synthetic */ FieldHolder $fh;
    public j a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<j.a>> f59631b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59632c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59633d;

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
        this.f59631b = new ArrayList();
        this.f59632c = false;
        this.f59633d = false;
        b(context);
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f59630e == null) {
                synchronized (b.class) {
                    if (f59630e == null) {
                        f59630e = new b(context.getApplicationContext());
                    }
                }
            }
            return f59630e;
        }
        return (b) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.f59632c = false;
            j jVar = new j(context);
            this.a = jVar;
            jVar.a(new j.a(this) { // from class: com.kwad.sdk.utils.b.1
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.utils.j.a
                public void a() {
                    j.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.a.f59631b.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (j.a) weakReference.get()) == null) {
                                it.remove();
                            } else {
                                aVar.a();
                            }
                        }
                        this.a.f59633d = true;
                    }
                }

                @Override // com.kwad.sdk.utils.j.a
                public void b() {
                    j.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Iterator it = this.a.f59631b.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (j.a) weakReference.get()) == null) {
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

    public void a(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f59631b.add(new WeakReference<>(aVar));
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.a == null) {
            return;
        }
        if (z || !this.f59632c) {
            this.a.a();
            this.f59632c = true;
            this.f59633d = false;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59633d : invokeV.booleanValue;
    }

    public void b(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            Iterator<WeakReference<j.a>> it = this.f59631b.iterator();
            while (it.hasNext()) {
                WeakReference<j.a> next = it.next();
                if (next == null || next.get() == aVar) {
                    it.remove();
                }
            }
        }
    }
}
