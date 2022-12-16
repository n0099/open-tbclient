package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(api = 21)
/* loaded from: classes8.dex */
public final class g extends ViewOutlineProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float PF;

    public g(float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.PF = f;
    }

    @RequiresApi(api = 21)
    public static void b(View view2, float f) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65537, null, view2, f) == null) {
            if (f <= 0.0f) {
                view2.setOutlineProvider(null);
                z = false;
            } else {
                view2.setOutlineProvider(new g(f));
                z = true;
            }
            view2.setClipToOutline(z);
        }
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view2, Outline outline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
            outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), this.PF);
        }
    }
}
