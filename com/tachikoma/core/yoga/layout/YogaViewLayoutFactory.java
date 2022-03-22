package com.tachikoma.core.yoga.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class YogaViewLayoutFactory implements LayoutInflater.Factory {
    public static /* synthetic */ Interceptable $ic;
    public static YogaViewLayoutFactory sYogaViewLayoutFactory;
    public transient /* synthetic */ FieldHolder $fh;

    public YogaViewLayoutFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static YogaViewLayoutFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sYogaViewLayoutFactory == null) {
                sYogaViewLayoutFactory = new YogaViewLayoutFactory();
            }
            return sYogaViewLayoutFactory;
        }
        return (YogaViewLayoutFactory) invokeV.objValue;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, context, attributeSet)) == null) {
            if (YogaLayout.class.getSimpleName().equals(str)) {
                return new YogaLayout(context, attributeSet);
            }
            if (VirtualYogaLayout.class.getSimpleName().equals(str)) {
                return new VirtualYogaLayout(context, attributeSet);
            }
            return null;
        }
        return (View) invokeLLL.objValue;
    }
}
