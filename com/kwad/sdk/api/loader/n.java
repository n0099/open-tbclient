package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes10.dex */
public class n extends ContextWrapper implements ResContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f71159a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f71160b;

    /* renamed from: c  reason: collision with root package name */
    public int f71161c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71161c = -1;
        this.f71159a = context;
        this.f71161c = ((Integer) Reflect.a(context).d("getThemeResId").a()).intValue();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71159a : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Resources externalResource = Loader.get().getExternalResource();
            return externalResource != null ? externalResource : super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            boolean equals = "layout_inflater".equals(str);
            Object systemService = super.getSystemService(str);
            if (equals) {
                LayoutInflater layoutInflater = (LayoutInflater) systemService;
                return !(layoutInflater.getContext() instanceof ResContext) ? layoutInflater.cloneInContext(this) : layoutInflater;
            }
            return systemService;
        }
        return invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
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
                if (this.f71160b == null) {
                    Resources.Theme newTheme = externalResource.newTheme();
                    this.f71160b = newTheme;
                    int i2 = this.f71161c;
                    if (i2 > 0) {
                        newTheme.applyStyle(i2, true);
                    }
                }
                return this.f71160b;
            }
            return theme;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, componentCallbacks) == null) {
            this.f71159a.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, componentCallbacks) == null) {
            this.f71159a.unregisterComponentCallbacks(componentCallbacks);
        }
    }
}
