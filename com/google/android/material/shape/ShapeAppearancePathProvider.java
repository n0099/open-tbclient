package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ShapeAppearancePathProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Path boundsPath;
    public final ShapePath[] cornerPaths;
    public final Matrix[] cornerTransforms;
    public boolean edgeIntersectionCheckEnabled;
    public final Matrix[] edgeTransforms;
    public final Path overlappedEdgePath;
    public final PointF pointF;
    public final float[] scratch;
    public final float[] scratch2;
    public final ShapePath shapePath;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i2);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i2);
    }

    /* loaded from: classes2.dex */
    public static final class ShapeAppearancePathSpec {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final RectF bounds;
        public final float interpolation;
        @NonNull
        public final Path path;
        @Nullable
        public final PathListener pathListener;
        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, @Nullable PathListener pathListener, Path path) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shapeAppearanceModel, Float.valueOf(f2), rectF, pathListener, path};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f2;
            this.bounds = rectF;
            this.path = path;
        }
    }

    public ShapeAppearancePathProvider() {
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
        this.cornerPaths = new ShapePath[4];
        this.cornerTransforms = new Matrix[4];
        this.edgeTransforms = new Matrix[4];
        this.pointF = new PointF();
        this.overlappedEdgePath = new Path();
        this.boundsPath = new Path();
        this.shapePath = new ShapePath();
        this.scratch = new float[2];
        this.scratch2 = new float[2];
        this.edgeIntersectionCheckEnabled = true;
        for (int i4 = 0; i4 < 4; i4++) {
            this.cornerPaths[i4] = new ShapePath();
            this.cornerTransforms[i4] = new Matrix();
            this.edgeTransforms[i4] = new Matrix();
        }
    }

    private float angleOfEdge(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? (i2 + 1) * 90 : invokeI.floatValue;
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, shapeAppearancePathSpec, i2) == null) {
            this.scratch[0] = this.cornerPaths[i2].getStartX();
            this.scratch[1] = this.cornerPaths[i2].getStartY();
            this.cornerTransforms[i2].mapPoints(this.scratch);
            if (i2 == 0) {
                Path path = shapeAppearancePathSpec.path;
                float[] fArr = this.scratch;
                path.moveTo(fArr[0], fArr[1]);
            } else {
                Path path2 = shapeAppearancePathSpec.path;
                float[] fArr2 = this.scratch;
                path2.lineTo(fArr2[0], fArr2[1]);
            }
            this.cornerPaths[i2].applyToPath(this.cornerTransforms[i2], shapeAppearancePathSpec.path);
            PathListener pathListener = shapeAppearancePathSpec.pathListener;
            if (pathListener != null) {
                pathListener.onCornerPathCreated(this.cornerPaths[i2], this.cornerTransforms[i2], i2);
            }
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, shapeAppearancePathSpec, i2) == null) {
            int i3 = (i2 + 1) % 4;
            this.scratch[0] = this.cornerPaths[i2].getEndX();
            this.scratch[1] = this.cornerPaths[i2].getEndY();
            this.cornerTransforms[i2].mapPoints(this.scratch);
            this.scratch2[0] = this.cornerPaths[i3].getStartX();
            this.scratch2[1] = this.cornerPaths[i3].getStartY();
            this.cornerTransforms[i3].mapPoints(this.scratch2);
            float[] fArr = this.scratch;
            float f2 = fArr[0];
            float[] fArr2 = this.scratch2;
            float max = Math.max(((float) Math.hypot(f2 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i2);
            this.shapePath.reset(0.0f, 0.0f);
            EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i2, shapeAppearancePathSpec.shapeAppearanceModel);
            edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
            Path path = new Path();
            this.shapePath.applyToPath(this.edgeTransforms[i2], path);
            if (this.edgeIntersectionCheckEnabled && Build.VERSION.SDK_INT >= 19 && (edgeTreatmentForIndex.forceIntersection() || pathOverlapsCorner(path, i2) || pathOverlapsCorner(path, i3))) {
                path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
                this.scratch[0] = this.shapePath.getStartX();
                this.scratch[1] = this.shapePath.getStartY();
                this.edgeTransforms[i2].mapPoints(this.scratch);
                Path path2 = this.overlappedEdgePath;
                float[] fArr3 = this.scratch;
                path2.moveTo(fArr3[0], fArr3[1]);
                this.shapePath.applyToPath(this.edgeTransforms[i2], this.overlappedEdgePath);
            } else {
                this.shapePath.applyToPath(this.edgeTransforms[i2], shapeAppearancePathSpec.path);
            }
            PathListener pathListener = shapeAppearancePathSpec.pathListener;
            if (pathListener != null) {
                pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i2], i2);
            }
        }
    }

    private void getCoordinatesOfCorner(int i2, @NonNull RectF rectF, @NonNull PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, rectF, pointF) == null) {
            if (i2 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i2 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i2 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
        }
    }

    private CornerSize getCornerSizeForIndex(int i2, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, this, i2, shapeAppearanceModel)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return shapeAppearanceModel.getTopRightCornerSize();
                    }
                    return shapeAppearanceModel.getTopLeftCornerSize();
                }
                return shapeAppearanceModel.getBottomLeftCornerSize();
            }
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        return (CornerSize) invokeIL.objValue;
    }

    private CornerTreatment getCornerTreatmentForIndex(int i2, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, this, i2, shapeAppearanceModel)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return shapeAppearanceModel.getTopRightCorner();
                    }
                    return shapeAppearanceModel.getTopLeftCorner();
                }
                return shapeAppearanceModel.getBottomLeftCorner();
            }
            return shapeAppearanceModel.getBottomRightCorner();
        }
        return (CornerTreatment) invokeIL.objValue;
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, rectF, i2)) == null) {
            float[] fArr = this.scratch;
            ShapePath[] shapePathArr = this.cornerPaths;
            fArr[0] = shapePathArr[i2].endX;
            fArr[1] = shapePathArr[i2].endY;
            this.cornerTransforms[i2].mapPoints(fArr);
            if (i2 != 1 && i2 != 3) {
                return Math.abs(rectF.centerY() - this.scratch[1]);
            }
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return invokeLI.floatValue;
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i2, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, this, i2, shapeAppearanceModel)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return shapeAppearanceModel.getRightEdge();
                    }
                    return shapeAppearanceModel.getTopEdge();
                }
                return shapeAppearanceModel.getLeftEdge();
            }
            return shapeAppearanceModel.getBottomEdge();
        }
        return (EdgeTreatment) invokeIL.objValue;
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path path, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, this, path, i2)) == null) {
            Path path2 = new Path();
            this.cornerPaths[i2].applyToPath(this.cornerTransforms[i2], path2);
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            path2.computeBounds(rectF, true);
            path.op(path2, Path.Op.INTERSECT);
            path.computeBounds(rectF, true);
            if (rectF.isEmpty()) {
                return rectF.width() > 1.0f && rectF.height() > 1.0f;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, shapeAppearancePathSpec, i2) == null) {
            getCornerTreatmentForIndex(i2, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i2], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i2, shapeAppearancePathSpec.shapeAppearanceModel));
            float angleOfEdge = angleOfEdge(i2);
            this.cornerTransforms[i2].reset();
            getCoordinatesOfCorner(i2, shapeAppearancePathSpec.bounds, this.pointF);
            Matrix matrix = this.cornerTransforms[i2];
            PointF pointF = this.pointF;
            matrix.setTranslate(pointF.x, pointF.y);
            this.cornerTransforms[i2].preRotate(angleOfEdge);
        }
    }

    private void setEdgePathAndTransform(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            this.scratch[0] = this.cornerPaths[i2].getEndX();
            this.scratch[1] = this.cornerPaths[i2].getEndY();
            this.cornerTransforms[i2].mapPoints(this.scratch);
            float angleOfEdge = angleOfEdge(i2);
            this.edgeTransforms[i2].reset();
            Matrix matrix = this.edgeTransforms[i2];
            float[] fArr = this.scratch;
            matrix.setTranslate(fArr[0], fArr[1]);
            this.edgeTransforms[i2].preRotate(angleOfEdge);
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, @NonNull Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shapeAppearanceModel, Float.valueOf(f2), rectF, path}) == null) {
            calculatePath(shapeAppearanceModel, f2, rectF, null, path);
        }
    }

    public void setEdgeIntersectionCheckEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.edgeIntersectionCheckEnabled = z;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, PathListener pathListener, @NonNull Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shapeAppearanceModel, Float.valueOf(f2), rectF, pathListener, path}) == null) {
            path.rewind();
            this.overlappedEdgePath.rewind();
            this.boundsPath.rewind();
            this.boundsPath.addRect(rectF, Path.Direction.CW);
            ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f2, rectF, pathListener, path);
            for (int i2 = 0; i2 < 4; i2++) {
                setCornerPathAndTransform(shapeAppearancePathSpec, i2);
                setEdgePathAndTransform(i2);
            }
            for (int i3 = 0; i3 < 4; i3++) {
                appendCornerPath(shapeAppearancePathSpec, i3);
                appendEdgePath(shapeAppearancePathSpec, i3);
            }
            path.close();
            this.overlappedEdgePath.close();
            if (Build.VERSION.SDK_INT < 19 || this.overlappedEdgePath.isEmpty()) {
                return;
            }
            path.op(this.overlappedEdgePath, Path.Op.UNION);
        }
    }
}
