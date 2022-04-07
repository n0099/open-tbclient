package com.tachikoma.core.component.listview.viewpager;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.utility.V8Proxy;
/* loaded from: classes8.dex */
public class TKPageTransformer implements ITKPageTransformer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TKJSContext mTKJSContext;
    public final V8Object mTKPageTransformerCallback;

    public TKPageTransformer(V8Object v8Object, TKJSContext tKJSContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object, tKJSContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTKJSContext = tKJSContext;
        this.mTKPageTransformerCallback = v8Object.twin();
    }

    @Override // com.tachikoma.core.component.listview.viewpager.ITKPageTransformer
    public void transformPage(@NonNull View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
            V8Proxy.executeJsFunction(this.mTKPageTransformerCallback, this.mTKJSContext, "transformPage", view2, Float.valueOf(f));
        }
    }
}
