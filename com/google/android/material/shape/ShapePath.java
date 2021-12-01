package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ShapePath {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ANGLE_LEFT = 180.0f;
    public static final float ANGLE_UP = 270.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean containsIncompatibleShadowOp;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    public final List<PathOperation> operations;
    public final List<ShadowCompatOperation> shadowCompatOperations;
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    /* loaded from: classes2.dex */
    public static class ArcShadowOperation extends ShadowCompatOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pathArcOperation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i2, @NonNull Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048576, this, matrix, shadowRenderer, i2, canvas) == null) {
                shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i2, this.operation.getStartAngle(), this.operation.getSweepAngle());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class LineShadowOperation extends ShadowCompatOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PathLineOperation operation;
        public final float startX;
        public final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pathLineOperation, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.operation = pathLineOperation;
            this.startX = f2;
            this.startY = f3;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i2, @NonNull Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048576, this, matrix, shadowRenderer, i2, canvas) == null) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.operation.y - this.startY, this.operation.x - this.startX), 0.0f);
                Matrix matrix2 = new Matrix(matrix);
                matrix2.preTranslate(this.startX, this.startY);
                matrix2.preRotate(getAngle());
                shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i2);
            }
        }

        public float getAngle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (float) Math.toDegrees(Math.atan((this.operation.y - this.startY) / (this.operation.x - this.startX))) : invokeV.floatValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class PathArcOperation extends PathOperation {
        public static /* synthetic */ Interceptable $ic;
        public static final RectF rectF;
        public transient /* synthetic */ FieldHolder $fh;
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(547473545, "Lcom/google/android/material/shape/ShapePath$PathArcOperation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(547473545, "Lcom/google/android/material/shape/ShapePath$PathArcOperation;");
                    return;
                }
            }
            rectF = new RectF();
        }

        public PathArcOperation(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            setLeft(f2);
            setTop(f3);
            setRight(f4);
            setBottom(f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getBottom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.bottom : invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.left : invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getRight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.right : invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getStartAngle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? this.startAngle : invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getSweepAngle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.sweepAngle : invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getTop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.top : invokeV.floatValue;
        }

        private void setBottom(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65552, this, f2) == null) {
                this.bottom = f2;
            }
        }

        private void setLeft(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65553, this, f2) == null) {
                this.left = f2;
            }
        }

        private void setRight(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65554, this, f2) == null) {
                this.right = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartAngle(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65555, this, f2) == null) {
                this.startAngle = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSweepAngle(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65556, this, f2) == null) {
                this.sweepAngle = f2;
            }
        }

        private void setTop(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65557, this, f2) == null) {
                this.top = f2;
            }
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, matrix, path) == null) {
                Matrix matrix2 = this.matrix;
                matrix.invert(matrix2);
                path.transform(matrix2);
                rectF.set(getLeft(), getTop(), getRight(), getBottom());
                path.arcTo(rectF, getStartAngle(), getSweepAngle(), false);
                path.transform(matrix);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PathCubicOperation extends PathOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float controlX1;
        public float controlX2;
        public float controlY1;
        public float controlY2;
        public float endX;
        public float endY;

        public PathCubicOperation(float f2, float f3, float f4, float f5, float f6, float f7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setControlX1(f2);
            setControlY1(f3);
            setControlX2(f4);
            setControlY2(f5);
            setEndX(f6);
            setEndY(f7);
        }

        private float getControlX1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.controlX1 : invokeV.floatValue;
        }

        private float getControlX2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.controlX2 : invokeV.floatValue;
        }

        private float getControlY1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.controlY1 : invokeV.floatValue;
        }

        private float getControlY2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.controlY1 : invokeV.floatValue;
        }

        private float getEndX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.endX : invokeV.floatValue;
        }

        private float getEndY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.endY : invokeV.floatValue;
        }

        private void setControlX1(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65543, this, f2) == null) {
                this.controlX1 = f2;
            }
        }

        private void setControlX2(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65544, this, f2) == null) {
                this.controlX2 = f2;
            }
        }

        private void setControlY1(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65545, this, f2) == null) {
                this.controlY1 = f2;
            }
        }

        private void setControlY2(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65546, this, f2) == null) {
                this.controlY2 = f2;
            }
        }

        private void setEndX(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65547, this, f2) == null) {
                this.endX = f2;
            }
        }

        private void setEndY(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65548, this, f2) == null) {
                this.endY = f2;
            }
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, matrix, path) == null) {
                Matrix matrix2 = this.matrix;
                matrix.invert(matrix2);
                path.transform(matrix2);
                path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
                path.transform(matrix);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PathLineOperation extends PathOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float x;
        public float y;

        public PathLineOperation() {
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

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, matrix, path) == null) {
                Matrix matrix2 = this.matrix;
                matrix.invert(matrix2);
                path.transform(matrix2);
                path.lineTo(this.x, this.y);
                path.transform(matrix);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class PathOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Matrix matrix;

        public PathOperation() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.matrix = new Matrix();
        }

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* loaded from: classes2.dex */
    public static class PathQuadOperation extends PathOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        public PathQuadOperation() {
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

        private float getControlX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.controlX : invokeV.floatValue;
        }

        private float getControlY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.controlY : invokeV.floatValue;
        }

        private float getEndX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.endX : invokeV.floatValue;
        }

        private float getEndY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.endY : invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlX(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65545, this, f2) == null) {
                this.controlX = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlY(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65546, this, f2) == null) {
                this.controlY = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndX(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65547, this, f2) == null) {
                this.endX = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndY(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65548, this, f2) == null) {
                this.endY = f2;
            }
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, matrix, path) == null) {
                Matrix matrix2 = this.matrix;
                matrix.invert(matrix2);
                path.transform(matrix2);
                path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
                path.transform(matrix);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ShadowCompatOperation {
        public static /* synthetic */ Interceptable $ic;
        public static final Matrix IDENTITY_MATRIX;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1316985330, "Lcom/google/android/material/shape/ShapePath$ShadowCompatOperation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1316985330, "Lcom/google/android/material/shape/ShapePath$ShadowCompatOperation;");
                    return;
                }
            }
            IDENTITY_MATRIX = new Matrix();
        }

        public ShadowCompatOperation() {
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

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shadowRenderer, i2, canvas) == null) {
                draw(IDENTITY_MATRIX, shadowRenderer, i2, canvas);
            }
        }
    }

    public ShapePath() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65538, this, f2) == null) || getCurrentShadowAngle() == f2) {
            return;
        }
        float currentShadowAngle = ((f2 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > 180.0f) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        pathArcOperation.setStartAngle(getCurrentShadowAngle());
        pathArcOperation.setSweepAngle(currentShadowAngle);
        this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
        setCurrentShadowAngle(f2);
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{shadowCompatOperation, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            addConnectingShadowIfNecessary(f2);
            this.shadowCompatOperations.add(shadowCompatOperation);
            setCurrentShadowAngle(f3);
        }
    }

    private float getCurrentShadowAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.currentShadowAngle : invokeV.floatValue;
    }

    private float getEndShadowAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.endShadowAngle : invokeV.floatValue;
    }

    private void setCurrentShadowAngle(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65542, this, f2) == null) {
            this.currentShadowAngle = f2;
        }
    }

    private void setEndShadowAngle(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65543, this, f2) == null) {
            this.endShadowAngle = f2;
        }
    }

    private void setEndX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65544, this, f2) == null) {
            this.endX = f2;
        }
    }

    private void setEndY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65545, this, f2) == null) {
            this.endY = f2;
        }
    }

    private void setStartX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65546, this, f2) == null) {
            this.startX = f2;
        }
    }

    private void setStartY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65547, this, f2) == null) {
            this.startY = f2;
        }
    }

    public void addArc(float f2, float f3, float f4, float f5, float f6, float f7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
            PathArcOperation pathArcOperation = new PathArcOperation(f2, f3, f4, f5);
            pathArcOperation.setStartAngle(f6);
            pathArcOperation.setSweepAngle(f7);
            this.operations.add(pathArcOperation);
            ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
            float f8 = f6 + f7;
            boolean z = f7 < 0.0f;
            if (z) {
                f6 = (f6 + 180.0f) % 360.0f;
            }
            addShadowCompatOperation(arcShadowOperation, f6, z ? (180.0f + f8) % 360.0f : f8);
            double d2 = f8;
            setEndX(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
            setEndY(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
        }
    }

    public void applyToPath(Matrix matrix, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrix, path) == null) {
            int size = this.operations.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.operations.get(i2).applyToPath(matrix, path);
            }
        }
    }

    public boolean containsIncompatibleShadowOp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.containsIncompatibleShadowOp : invokeV.booleanValue;
    }

    @NonNull
    public ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, matrix)) == null) {
            addConnectingShadowIfNecessary(getEndShadowAngle());
            return new ShadowCompatOperation(this, new ArrayList(this.shadowCompatOperations), matrix) { // from class: com.google.android.material.shape.ShapePath.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShapePath this$0;
                public final /* synthetic */ List val$operations;
                public final /* synthetic */ Matrix val$transform;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, matrix};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$operations = r7;
                    this.val$transform = matrix;
                }

                @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                public void draw(Matrix matrix2, ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, matrix2, shadowRenderer, i2, canvas) == null) {
                        for (ShadowCompatOperation shadowCompatOperation : this.val$operations) {
                            shadowCompatOperation.draw(this.val$transform, shadowRenderer, i2, canvas);
                        }
                    }
                }
            };
        }
        return (ShadowCompatOperation) invokeL.objValue;
    }

    @RequiresApi(21)
    public void cubicToPoint(float f2, float f3, float f4, float f5, float f6, float f7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
            this.operations.add(new PathCubicOperation(f2, f3, f4, f5, f6, f7));
            this.containsIncompatibleShadowOp = true;
            setEndX(f6);
            setEndY(f7);
        }
    }

    public float getEndX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.endX : invokeV.floatValue;
    }

    public float getEndY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.endY : invokeV.floatValue;
    }

    public float getStartX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.startX : invokeV.floatValue;
    }

    public float getStartY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.startY : invokeV.floatValue;
    }

    public void lineTo(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            PathLineOperation pathLineOperation = new PathLineOperation();
            pathLineOperation.x = f2;
            pathLineOperation.y = f3;
            this.operations.add(pathLineOperation);
            LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
            addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + 270.0f, lineShadowOperation.getAngle() + 270.0f);
            setEndX(f2);
            setEndY(f3);
        }
    }

    @RequiresApi(21)
    public void quadToPoint(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            PathQuadOperation pathQuadOperation = new PathQuadOperation();
            pathQuadOperation.setControlX(f2);
            pathQuadOperation.setControlY(f3);
            pathQuadOperation.setEndX(f4);
            pathQuadOperation.setEndY(f5);
            this.operations.add(pathQuadOperation);
            this.containsIncompatibleShadowOp = true;
            setEndX(f4);
            setEndY(f5);
        }
    }

    public void reset(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            reset(f2, f3, 270.0f, 0.0f);
        }
    }

    public void reset(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            setStartX(f2);
            setStartY(f3);
            setEndX(f2);
            setEndY(f3);
            setCurrentShadowAngle(f4);
            setEndShadowAngle((f4 + f5) % 360.0f);
            this.operations.clear();
            this.shadowCompatOperations.clear();
            this.containsIncompatibleShadowOp = false;
        }
    }

    public ShapePath(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(f2, f3);
    }
}
