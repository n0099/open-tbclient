package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.ResContext;
import java.util.Map;
import java.util.WeakHashMap;
@Keep
/* loaded from: classes2.dex */
public class Wrapper {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Context, Context> sResContextCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1972734964, "Lcom/kwad/sdk/api/loader/Wrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1972734964, "Lcom/kwad/sdk/api/loader/Wrapper;");
                return;
            }
        }
        sResContextCache = new WeakHashMap();
    }

    public Wrapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Keep
    public static Context unwrapContextIfNeed(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                if (context2 instanceof Activity) {
                    return context2;
                }
                if (context2 instanceof ResContext) {
                    resContext = (ResContext) context2;
                    context2 = resContext.getDelegatedContext();
                } else {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            return resContext != null ? resContext.getDelegatedContext() : context;
        }
        return (Context) invokeL.objValue;
    }

    @Nullable
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (Loader.get().isExternalLoaded()) {
                if (context == null) {
                    return null;
                }
                if (context instanceof ResContext) {
                    return context;
                }
                if (context instanceof ContextThemeWrapper) {
                    Context context2 = sResContextCache.get(context);
                    if (context2 == null) {
                        l lVar = new l((ContextThemeWrapper) context);
                        sResContextCache.put(context, lVar);
                        return lVar;
                    }
                    return context2;
                } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                    Context context3 = sResContextCache.get(context);
                    if (context3 == null) {
                        m mVar = new m((androidx.appcompat.view.ContextThemeWrapper) context);
                        sResContextCache.put(context, mVar);
                        return mVar;
                    }
                    return context3;
                } else if (context instanceof ContextWrapper) {
                    Context context4 = sResContextCache.get(context);
                    if (context4 == null) {
                        n nVar = new n(context);
                        sResContextCache.put(context, nVar);
                        return nVar;
                    }
                    return context4;
                } else {
                    Context context5 = sResContextCache.get(context);
                    if (context5 == null) {
                        n nVar2 = new n(context);
                        sResContextCache.put(context, nVar2);
                        return nVar2;
                    }
                    return context5;
                }
            }
            return context;
        }
        return (Context) invokeL.objValue;
    }

    @Keep
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, layoutInflater)) == null) {
            if (Loader.get().isExternalLoaded()) {
                Context context = layoutInflater.getContext();
                if (context instanceof ResContext) {
                    return layoutInflater;
                }
                Context wrapContextIfNeed = wrapContextIfNeed(context);
                return wrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(wrapContextIfNeed) : layoutInflater;
            }
            return layoutInflater;
        }
        return (LayoutInflater) invokeL.objValue;
    }
}
