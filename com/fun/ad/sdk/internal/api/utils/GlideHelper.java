package com.fun.ad.sdk.internal.api.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
/* loaded from: classes11.dex */
public final class GlideHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.fun.ad.sdk.internal.api.utils.GlideHelper$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class GlideHelperHolder {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final GlideHelper f63762a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1634105819, "Lcom/fun/ad/sdk/internal/api/utils/GlideHelper$GlideHelperHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1634105819, "Lcom/fun/ad/sdk/internal/api/utils/GlideHelper$GlideHelperHolder;");
                    return;
                }
            }
            f63762a = new GlideHelper();
        }

        public GlideHelperHolder() {
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
    }

    public GlideHelper() {
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

    public static GlideHelper get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? GlideHelperHolder.f63762a : (GlideHelper) invokeV.objValue;
    }

    public void load(Activity activity, String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, imageView) == null) {
            if (activity == null) {
                LogPrinter.e("GlideHelper: activity is null when load: " + str, new Object[0]);
            } else if (!activity.isFinishing() && (Build.VERSION.SDK_INT <= 17 || !activity.isDestroyed())) {
                Glide.with(activity).load(str).into(imageView);
            } else {
                LogPrinter.e("GlideHelper: activity is destroyed when load: " + str, new Object[0]);
            }
        }
    }

    public void load(Context context, String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, imageView) == null) {
            if (context == null) {
                LogPrinter.e("GlideHelper: context is null when load: " + str, new Object[0]);
            } else if (context instanceof Activity) {
                load((Activity) context, str, imageView);
            } else {
                Glide.with(context).load(str).into(imageView);
            }
        }
    }

    public void load(View view, String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, imageView) == null) {
            if (view != null) {
                load(view.getContext(), str, imageView);
                return;
            }
            LogPrinter.e("GlideHelper: view is null when load: " + str, new Object[0]);
        }
    }
}
