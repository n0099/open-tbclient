package com.kwad.components.core.m;

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
    public static volatile b IP;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.utils.h IL;
    public List<WeakReference<h.a>> IM;
    public boolean IN;
    public boolean IO;

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
        this.IM = new ArrayList();
        this.IN = false;
        this.IO = false;
        init(context);
    }

    public static b at(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (IP == null) {
                synchronized (b.class) {
                    if (IP == null) {
                        IP = new b(context.getApplicationContext());
                    }
                }
            }
            return IP;
        }
        return (b) invokeL.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.IN = false;
            com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
            this.IL = hVar;
            hVar.c(new h.a(this) { // from class: com.kwad.components.core.m.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b IQ;

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
                    this.IQ = this;
                }

                @Override // com.kwad.sdk.utils.h.a
                public final void bk() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.IQ.IM.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                                it.remove();
                            } else {
                                aVar.bk();
                            }
                        }
                        this.IQ.IO = true;
                    }
                }

                @Override // com.kwad.sdk.utils.h.a
                public final void bl() {
                    h.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Iterator it = this.IQ.IM.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                                it.remove();
                            } else {
                                aVar.bl();
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
            this.IM.add(new WeakReference<>(aVar));
        }
    }

    public final boolean ay(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (this.IL == null) {
                return false;
            }
            if (z || !this.IN) {
                this.IN = true;
                this.IO = false;
                return this.IL.zi();
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            Iterator<WeakReference<h.a>> it = this.IM.iterator();
            while (it.hasNext()) {
                WeakReference<h.a> next = it.next();
                if (next == null || next.get() == aVar) {
                    it.remove();
                }
            }
        }
    }

    public final boolean ov() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.IO : invokeV.booleanValue;
    }

    public final boolean ow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.IN : invokeV.booleanValue;
    }
}
