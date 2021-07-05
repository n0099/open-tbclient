package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f36339a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile List<WeakReference<Object>> f36340b;

    public d() {
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
        this.f36340b = new CopyOnWriteArrayList();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f36339a == null) {
                synchronized (d.class) {
                    if (f36339a == null) {
                        f36339a = c();
                    }
                }
            }
            return f36339a;
        }
        return (d) invokeV.objValue;
    }

    private boolean a(@NonNull Collection<WeakReference<Object>> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, collection, obj)) == null) {
            if (obj == null) {
                return false;
            }
            for (WeakReference<Object> weakReference : collection) {
                if (weakReference != null && weakReference.get() != null && weakReference.get().equals(obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void b(@NonNull Collection<WeakReference<Object>> collection, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, collection, obj) == null) || obj == null) {
            return;
        }
        collection.add(new WeakReference<>(obj));
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? new d() : (d) invokeV.objValue;
    }

    private boolean c(@NonNull Collection<WeakReference<Object>> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, collection, obj)) == null) {
            if (obj == null) {
                return false;
            }
            for (WeakReference<Object> weakReference : collection) {
                if (weakReference != null && weakReference.get() != null && weakReference.get().equals(obj)) {
                    return collection.remove(weakReference);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            b.a().a(b() > 0);
        }
    }

    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || a(this.f36340b, obj)) {
            return;
        }
        b(this.f36340b, obj);
        d();
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Iterator<WeakReference<Object>> it = this.f36340b.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().get() == null) {
                    it.remove();
                } else {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            c(this.f36340b, obj);
            d();
        }
    }
}
