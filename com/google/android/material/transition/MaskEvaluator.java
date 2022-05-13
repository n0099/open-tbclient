package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.MaterialContainerTransform;
/* loaded from: classes4.dex */
public class MaskEvaluator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShapeAppearanceModel currentShapeAppearanceModel;
    public final Path endPath;
    public final Path path;
    public final ShapeAppearancePathProvider pathProvider;
    public final Path startPath;

    public MaskEvaluator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.path = new Path();
        this.startPath = new Path();
        this.endPath = new Path();
        this.pathProvider = new ShapeAppearancePathProvider();
    }

    public void clip(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                canvas.clipPath(this.path);
                return;
            }
            canvas.clipPath(this.startPath);
            canvas.clipPath(this.endPath, Region.Op.UNION);
        }
    }

    public void evaluate(float f, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF2, rectF3, progressThresholds}) == null) {
            ShapeAppearanceModel lerp = TransitionUtils.lerp(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f);
            this.currentShapeAppearanceModel = lerp;
            this.pathProvider.calculatePath(lerp, 1.0f, rectF2, this.startPath);
            this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, rectF3, this.endPath);
            if (Build.VERSION.SDK_INT >= 23) {
                this.path.op(this.startPath, this.endPath, Path.Op.UNION);
            }
        }
    }

    public ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.currentShapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    public Path getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.path : (Path) invokeV.objValue;
    }
}
