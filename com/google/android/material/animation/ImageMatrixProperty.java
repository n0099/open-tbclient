package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Matrix matrix;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Class) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.matrix = new Matrix();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    @NonNull
    public Matrix get(@NonNull ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageView)) == null) {
            this.matrix.set(imageView.getImageMatrix());
            return this.matrix;
        }
        return (Matrix) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, matrix) == null) {
            imageView.setImageMatrix(matrix);
        }
    }
}
