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
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLIL(1048576, this, matrix, shadowRenderer, i, canvas) != null) {
                return;
            }
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i, this.operation.getStartAngle(), this.operation.getSweepAngle());
        }
    }

    /* loaded from: classes8.dex */
    public static class LineShadowOperation extends ShadowCompatOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PathLineOperation operation;
        public final float startX;
        public final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pathLineOperation, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.operation = pathLineOperation;
            this.startX = f;
            this.startY = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048576, this, matrix, shadowRenderer, i, canvas) == null) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.operation.y - this.startY, this.operation.x - this.startX), 0.0f);
                Matrix matrix2 = new Matrix(matrix);
                matrix2.preTranslate(this.startX, this.startY);
                matrix2.preRotate(getAngle());
                shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i);
            }
        }

        public float getAngle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (float) Math.toDegrees(Math.atan((this.operation.y - this.startY) / (this.operation.x - this.startX)));
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public float getBottom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
                return this.bottom;
            }
            return invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
                return this.left;
            }
            return invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getRight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
                return this.right;
            }
            return invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getStartAngle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
                return this.startAngle;
            }
            return invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getSweepAngle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
                return this.sweepAngle;
            }
            return invokeV.floatValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getTop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
                return this.top;
            }
            return invokeV.floatValue;
        }

        public PathArcOperation(float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            setLeft(f);
            setTop(f2);
            setRight(f3);
            setBottom(f4);
        }

        private void setBottom(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65552, this, f) == null) {
                this.bottom = f;
            }
        }

        private void setLeft(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65553, this, f) == null) {
                this.left = f;
            }
        }

        private void setRight(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65554, this, f) == null) {
                this.right = f;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartAngle(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65555, this, f) == null) {
                this.startAngle = f;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSweepAngle(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65556, this, f) == null) {
                this.sweepAngle = f;
            }
        }

        private void setTop(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65557, this, f) == null) {
                this.top = f;
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

    /* loaded from: classes8.dex */
    public static class PathCubicOperation extends PathOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float controlX1;
        public float controlX2;
        public float controlY1;
        public float controlY2;
        public float endX;
        public float endY;

        public PathCubicOperation(float f, float f2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setControlX1(f);
            setControlY1(f2);
            setControlX2(f3);
            setControlY2(f4);
            setEndX(f5);
            setEndY(f6);
        }

        private float getControlX1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                return this.controlX1;
            }
            return invokeV.floatValue;
        }

        private float getControlX2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                return this.controlX2;
            }
            return invokeV.floatValue;
        }

        private float getControlY1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                return this.controlY1;
            }
            return invokeV.floatValue;
        }

        private float getControlY2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                return this.controlY1;
            }
            return invokeV.floatValue;
        }

        private float getEndX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                return this.endX;
            }
            return invokeV.floatValue;
        }

        private float getEndY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                return this.endY;
            }
            return invokeV.floatValue;
        }

        private void setControlX1(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65543, this, f) == null) {
                this.controlX1 = f;
            }
        }

        private void setControlX2(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65544, this, f) == null) {
                this.controlX2 = f;
            }
        }

        private void setControlY1(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65545, this, f) == null) {
                this.controlY1 = f;
            }
        }

        private void setControlY2(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65546, this, f) == null) {
                this.controlY2 = f;
            }
        }

        private void setEndX(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65547, this, f) == null) {
                this.endX = f;
            }
        }

        private void setEndY(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65548, this, f) == null) {
                this.endY = f;
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

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes8.dex */
    public static abstract class PathOperation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Matrix matrix;

        public abstract void applyToPath(Matrix matrix, Path path);

        public PathOperation() {
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
            this.matrix = new Matrix();
        }
    }

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private float getControlX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                return this.controlX;
            }
            return invokeV.floatValue;
        }

        private float getControlY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                return this.controlY;
            }
            return invokeV.floatValue;
        }

        private float getEndX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
                return this.endX;
            }
            return invokeV.floatValue;
        }

        private float getEndY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
                return this.endY;
            }
            return invokeV.floatValue;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlX(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65545, this, f) == null) {
                this.controlX = f;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlY(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65546, this, f) == null) {
                this.controlY = f;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndX(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65547, this, f) == null) {
                this.endX = f;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndY(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65548, this, f) == null) {
                this.endY = f;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class ShadowCompatOperation {
        public static /* synthetic */ Interceptable $ic;
        public static final Matrix IDENTITY_MATRIX;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final void draw(ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shadowRenderer, i, canvas) == null) {
                draw(IDENTITY_MATRIX, shadowRenderer, i, canvas);
            }
        }
    }

    public ShapePath() {
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
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(0.0f, 0.0f);
    }

    public ShapePath(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(f, f2);
    }

    public void lineTo(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            PathLineOperation pathLineOperation = new PathLineOperation();
            pathLineOperation.x = f;
            pathLineOperation.y = f2;
            this.operations.add(pathLineOperation);
            LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
            addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + 270.0f, lineShadowOperation.getAngle() + 270.0f);
            setEndX(f);
            setEndY(f2);
        }
    }

    private void addConnectingShadowIfNecessary(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(65538, this, f) != null) || getCurrentShadowAngle() == f) {
            return;
        }
        float currentShadowAngle = ((f - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > 180.0f) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        pathArcOperation.setStartAngle(getCurrentShadowAngle());
        pathArcOperation.setSweepAngle(currentShadowAngle);
        this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
        setCurrentShadowAngle(f);
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{shadowCompatOperation, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            addConnectingShadowIfNecessary(f);
            this.shadowCompatOperations.add(shadowCompatOperation);
            setCurrentShadowAngle(f2);
        }
    }

    private float getCurrentShadowAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.currentShadowAngle;
        }
        return invokeV.floatValue;
    }

    private float getEndShadowAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return this.endShadowAngle;
        }
        return invokeV.floatValue;
    }

    public boolean containsIncompatibleShadowOp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.containsIncompatibleShadowOp;
        }
        return invokeV.booleanValue;
    }

    public float getEndX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.endX;
        }
        return invokeV.floatValue;
    }

    public float getEndY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.endY;
        }
        return invokeV.floatValue;
    }

    public float getStartX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.startX;
        }
        return invokeV.floatValue;
    }

    public float getStartY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.startY;
        }
        return invokeV.floatValue;
    }

    private void setCurrentShadowAngle(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65542, this, f) == null) {
            this.currentShadowAngle = f;
        }
    }

    private void setEndShadowAngle(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65543, this, f) == null) {
            this.endShadowAngle = f;
        }
    }

    private void setEndX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65544, this, f) == null) {
            this.endX = f;
        }
    }

    private void setEndY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65545, this, f) == null) {
            this.endY = f;
        }
    }

    private void setStartX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65546, this, f) == null) {
            this.startX = f;
        }
    }

    private void setStartY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65547, this, f) == null) {
            this.startY = f;
        }
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                public void draw(Matrix matrix2, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, matrix2, shadowRenderer, i, canvas) == null) {
                        for (ShadowCompatOperation shadowCompatOperation : this.val$operations) {
                            shadowCompatOperation.draw(this.val$transform, shadowRenderer, i, canvas);
                        }
                    }
                }
            };
        }
        return (ShadowCompatOperation) invokeL.objValue;
    }

    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z;
        float f7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
            PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
            pathArcOperation.setStartAngle(f5);
            pathArcOperation.setSweepAngle(f6);
            this.operations.add(pathArcOperation);
            ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
            float f8 = f5 + f6;
            if (f6 < 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                f5 = (f5 + 180.0f) % 360.0f;
            }
            if (z) {
                f7 = (180.0f + f8) % 360.0f;
            } else {
                f7 = f8;
            }
            addShadowCompatOperation(arcShadowOperation, f5, f7);
            double d = f8;
            setEndX(((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))));
            setEndY(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))));
        }
    }

    public void applyToPath(Matrix matrix, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrix, path) == null) {
            int size = this.operations.size();
            for (int i = 0; i < size; i++) {
                this.operations.get(i).applyToPath(matrix, path);
            }
        }
    }

    public void reset(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            reset(f, f2, 270.0f, 0.0f);
        }
    }

    @RequiresApi(21)
    public void cubicToPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
            this.operations.add(new PathCubicOperation(f, f2, f3, f4, f5, f6));
            this.containsIncompatibleShadowOp = true;
            setEndX(f5);
            setEndY(f6);
        }
    }

    @RequiresApi(21)
    public void quadToPoint(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            PathQuadOperation pathQuadOperation = new PathQuadOperation();
            pathQuadOperation.setControlX(f);
            pathQuadOperation.setControlY(f2);
            pathQuadOperation.setEndX(f3);
            pathQuadOperation.setEndY(f4);
            this.operations.add(pathQuadOperation);
            this.containsIncompatibleShadowOp = true;
            setEndX(f3);
            setEndY(f4);
        }
    }

    public void reset(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            setStartX(f);
            setStartY(f2);
            setEndX(f);
            setEndY(f2);
            setCurrentShadowAngle(f3);
            setEndShadowAngle((f3 + f4) % 360.0f);
            this.operations.clear();
            this.shadowCompatOperations.clear();
            this.containsIncompatibleShadowOp = false;
        }
    }
}
