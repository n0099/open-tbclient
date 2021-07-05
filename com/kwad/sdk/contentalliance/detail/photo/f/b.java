package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, view, onClickListener) == null) || view == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        b.c(view2);
                        return false;
                    } else if (action == 1 || action == 3) {
                        b.d(view2);
                        return false;
                    } else {
                        return false;
                    }
                }
                return invokeLL.booleanValue;
            }
        });
    }

    public static void c(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, view) == null) || view == null) {
            return;
        }
        view.animate().cancel();
        view.animate().scaleX(0.8f).scaleY(0.8f).setDuration(100L).start();
    }

    public static void d(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, view) == null) || view == null) {
            return;
        }
        view.animate().cancel();
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L).start();
    }
}
