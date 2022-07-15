package com.kwai.sodler.lib.kwai.b;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.q;
/* loaded from: classes5.dex */
public final class c extends ContextThemeWrapper implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ContextThemeWrapper a;
    public Resources.Theme b;
    public int c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contextThemeWrapper, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = contextThemeWrapper;
        this.d = str;
        this.c = ((Integer) q.a((Object) contextThemeWrapper, "getThemeResId", new Object[0])).intValue();
    }

    @Override // com.kwai.sodler.lib.kwai.b.b
    public final Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.a(super.getApplicationContext(), this.d) : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a.a(super.getClassLoader(), this.d) : (ClassLoader) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a.a(super.getResources(), this.d) : (Resources) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? a.a(this.a.getSystemService(str), str, this) : invokeL.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                theme = super.getTheme();
            } catch (Exception e) {
                e.printStackTrace();
                theme = null;
            }
            Resources.Theme theme2 = this.b;
            if (theme2 == null || theme2 == theme) {
                this.b = a.a(theme, this.b, this.c, this.d);
            }
            return this.b;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, componentCallbacks) == null) {
            this.a.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.c = i;
            super.setTheme(i);
        }
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, componentCallbacks) == null) {
            this.a.unregisterComponentCallbacks(componentCallbacks);
        }
    }
}
