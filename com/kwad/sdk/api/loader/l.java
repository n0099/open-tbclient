package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes6.dex */
public class l extends ContextThemeWrapper implements ResContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ContextThemeWrapper f34045a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f34046b;

    /* renamed from: c  reason: collision with root package name */
    public int f34047c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contextThemeWrapper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34045a = contextThemeWrapper;
        this.f34047c = ((Integer) Reflect.a(contextThemeWrapper).d("getThemeResId").a()).intValue();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Wrapper.wrapContextIfNeed(super.getApplicationContext()) : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Wrapper.wrapContextIfNeed(super.getBaseContext()) : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
            return externalClassLoader != null ? externalClassLoader : super.getClassLoader();
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.ResContext
    public Context getDelegatedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34045a : (Context) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Resources externalResource = Loader.get().getExternalResource();
            return externalResource != null ? externalResource : super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if ("layout_inflater".equals(str)) {
                LayoutInflater layoutInflater = (LayoutInflater) this.f34045a.getSystemService(str);
                return !(layoutInflater.getContext() instanceof ResContext) ? layoutInflater.cloneInContext(this) : layoutInflater;
            }
            return this.f34045a.getSystemService(str);
        }
        return invokeL.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                theme = super.getTheme();
            } catch (Exception e2) {
                e2.printStackTrace();
                theme = null;
            }
            Resources externalResource = Loader.get().getExternalResource();
            if (externalResource != null) {
                if (this.f34046b == null) {
                    Resources.Theme newTheme = externalResource.newTheme();
                    this.f34046b = newTheme;
                    newTheme.applyStyle(this.f34047c, true);
                }
                return this.f34046b;
            }
            return theme;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, componentCallbacks) == null) {
            this.f34045a.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, componentCallbacks) == null) {
            this.f34045a.unregisterComponentCallbacks(componentCallbacks);
        }
    }
}
