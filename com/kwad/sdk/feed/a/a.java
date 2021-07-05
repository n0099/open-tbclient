package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
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
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f37310d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f37311a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f37312b;

    /* renamed from: c  reason: collision with root package name */
    public List<InterfaceC0448a> f37313c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0448a {
        @MainThread
        void a(int i2);
    }

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
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f37310d == null) {
                synchronized (a.class) {
                    if (f37310d == null) {
                        f37310d = new a();
                    }
                }
            }
            return f37310d;
        }
        return (a) invokeV.objValue;
    }

    @MainThread
    public void a(int i2) {
        List<InterfaceC0448a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (list = this.f37313c) == null) {
            return;
        }
        for (InterfaceC0448a interfaceC0448a : list) {
            interfaceC0448a.a(i2);
        }
    }

    @MainThread
    public void a(InterfaceC0448a interfaceC0448a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0448a) == null) {
            if (this.f37313c == null) {
                this.f37313c = new LinkedList();
            }
            this.f37313c.add(interfaceC0448a);
        }
    }

    public void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        if (this.f37311a == null) {
            this.f37311a = new ArrayList();
        }
        this.f37311a.clear();
        this.f37311a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37311a : (List) invokeV.objValue;
    }

    @MainThread
    public void b(InterfaceC0448a interfaceC0448a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC0448a) == null) {
            if (this.f37313c == null) {
                this.f37313c = new LinkedList();
            }
            this.f37313c.remove(interfaceC0448a);
        }
    }

    public void b(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        if (this.f37312b == null) {
            this.f37312b = new ArrayList();
        }
        this.f37312b.clear();
        this.f37312b.addAll(list);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<AdTemplate> list = this.f37311a;
            if (list != null) {
                list.clear();
            }
            this.f37311a = null;
        }
    }

    @Nullable
    public List<AdTemplate> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37312b : (List) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List<AdTemplate> list = this.f37312b;
            if (list != null) {
                list.clear();
            }
            this.f37312b = null;
        }
    }

    @MainThread
    public void f() {
        List<InterfaceC0448a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.f37313c) == null) {
            return;
        }
        list.clear();
    }
}
