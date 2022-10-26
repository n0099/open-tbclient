package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i);
    }

    private float angleOfEdge(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) ? (i + 1) * 90 : invokeI.floatValue;
    }

    /* loaded from: classes7.dex */
    public final class ShapeAppearancePathSpec {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RectF bounds;
        public final float interpolation;
        public final Path path;
        public final PathListener pathListener;
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, Path path) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shapeAppearanceModel, Float.valueOf(f), rectF, pathListener, path};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f;
            this.bounds = rectF;
            this.path = path;
        }
    }

    public ShapeAppearancePathProvider() {
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
        for (int i3 = 0; i3 < 4; i3++) {
            this.cornerPaths[i3] = new ShapePath();
            this.cornerTransforms[i3] = new Matrix();
            this.edgeTransforms[i3] = new Matrix();
        }
    }

    private void appendCornerPath(ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, shapeAppearancePathSpec, i) == null) {
            this.scratch[0] = this.cornerPaths[i].getStartX();
            this.scratch[1] = this.cornerPaths[i].getStartY();
            this.cornerTransforms[i].mapPoints(this.scratch);
            if (i == 0) {
                Path path = shapeAppearancePathSpec.path;
                float[] fArr = this.scratch;
                path.moveTo(fArr[0], fArr[1]);
            } else {
                Path path2 = shapeAppearancePathSpec.path;
                float[] fArr2 = this.scratch;
                path2.lineTo(fArr2[0], fArr2[1]);
            }
            this.cornerPaths[i].applyToPath(this.cornerTransforms[i], shapeAppearancePathSpec.path);
            PathListener pathListener = shapeAppearancePathSpec.pathListener;
            if (pathListener != null) {
                pathListener.onCornerPathCreated(this.cornerPaths[i], this.cornerTransforms[i], i);
            }
        }
    }

    private void appendEdgePath(ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, shapeAppearancePathSpec, i) == null) {
            int i2 = (i + 1) % 4;
            this.scratch[0] = this.cornerPaths[i].getEndX();
            this.scratch[1] = this.cornerPaths[i].getEndY();
            this.cornerTransforms[i].mapPoints(this.scratch);
            this.scratch2[0] = this.cornerPaths[i2].getStartX();
            this.scratch2[1] = this.cornerPaths[i2].getStartY();
            this.cornerTransforms[i2].mapPoints(this.scratch2);
            float[] fArr = this.scratch;
            float f = fArr[0];
            float[] fArr2 = this.scratch2;
            float max = Math.max(((float) Math.hypot(f - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i);
            this.shapePath.reset(0.0f, 0.0f);
            EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel);
            edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
            Path path = new Path();
            this.shapePath.applyToPath(this.edgeTransforms[i], path);
            if (this.edgeIntersectionCheckEnabled && Build.VERSION.SDK_INT >= 19 && (edgeTreatmentForIndex.forceIntersection() || pathOverlapsCorner(path, i) || pathOverlapsCorner(path, i2))) {
                path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
                this.scratch[0] = this.shapePath.getStartX();
                this.scratch[1] = this.shapePath.getStartY();
                this.edgeTransforms[i].mapPoints(this.scratch);
                Path path2 = this.overlappedEdgePath;
                float[] fArr3 = this.scratch;
                path2.moveTo(fArr3[0], fArr3[1]);
                this.shapePath.applyToPath(this.edgeTransforms[i], this.overlappedEdgePath);
            } else {
                this.shapePath.applyToPath(this.edgeTransforms[i], shapeAppearancePathSpec.path);
            }
            PathListener pathListener = shapeAppearancePathSpec.pathListener;
            if (pathListener != null) {
                pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i], i);
            }
        }
    }

    private void getCoordinatesOfCorner(int i, RectF rectF, PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, rectF, pointF) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        pointF.set(rectF.right, rectF.top);
                        return;
                    } else {
                        pointF.set(rectF.left, rectF.top);
                        return;
                    }
                }
                pointF.set(rectF.left, rectF.bottom);
                return;
            }
            pointF.set(rectF.right, rectF.bottom);
        }
    }

    private CornerSize getCornerSizeForIndex(int i, ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, this, i, shapeAppearanceModel)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
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

    private CornerTreatment getCornerTreatmentForIndex(int i, ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, this, i, shapeAppearanceModel)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
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

    private EdgeTreatment getEdgeTreatmentForIndex(int i, ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, this, i, shapeAppearanceModel)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
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

    private float getEdgeCenterForIndex(RectF rectF, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, rectF, i)) == null) {
            float[] fArr = this.scratch;
            ShapePath[] shapePathArr = this.cornerPaths;
            fArr[0] = shapePathArr[i].endX;
            fArr[1] = shapePathArr[i].endY;
            this.cornerTransforms[i].mapPoints(fArr);
            if (i != 1 && i != 3) {
                return Math.abs(rectF.centerY() - this.scratch[1]);
            }
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return invokeLI.floatValue;
    }

    private boolean pathOverlapsCorner(Path path, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, this, path, i)) == null) {
            Path path2 = new Path();
            this.cornerPaths[i].applyToPath(this.cornerTransforms[i], path2);
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            path2.computeBounds(rectF, true);
            path.op(path2, Path.Op.INTERSECT);
            path.computeBounds(rectF, true);
            if (!rectF.isEmpty()) {
                return true;
            }
            if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    private void setCornerPathAndTransform(ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, shapeAppearancePathSpec, i) == null) {
            getCornerTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel));
            float angleOfEdge = angleOfEdge(i);
            this.cornerTransforms[i].reset();
            getCoordinatesOfCorner(i, shapeAppearancePathSpec.bounds, this.pointF);
            Matrix matrix = this.cornerTransforms[i];
            PointF pointF = this.pointF;
            matrix.setTranslate(pointF.x, pointF.y);
            this.cornerTransforms[i].preRotate(angleOfEdge);
        }
    }

    private void setEdgePathAndTransform(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i) == null) {
            this.scratch[0] = this.cornerPaths[i].getEndX();
            this.scratch[1] = this.cornerPaths[i].getEndY();
            this.cornerTransforms[i].mapPoints(this.scratch);
            float angleOfEdge = angleOfEdge(i);
            this.edgeTransforms[i].reset();
            Matrix matrix = this.edgeTransforms[i];
            float[] fArr = this.scratch;
            matrix.setTranslate(fArr[0], fArr[1]);
            this.edgeTransforms[i].preRotate(angleOfEdge);
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shapeAppearanceModel, Float.valueOf(f), rectF, path}) == null) {
            calculatePath(shapeAppearanceModel, f, rectF, null, path);
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shapeAppearanceModel, Float.valueOf(f), rectF, pathListener, path}) == null) {
            path.rewind();
            this.overlappedEdgePath.rewind();
            this.boundsPath.rewind();
            this.boundsPath.addRect(rectF, Path.Direction.CW);
            ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f, rectF, pathListener, path);
            for (int i = 0; i < 4; i++) {
                setCornerPathAndTransform(shapeAppearancePathSpec, i);
                setEdgePathAndTransform(i);
            }
            for (int i2 = 0; i2 < 4; i2++) {
                appendCornerPath(shapeAppearancePathSpec, i2);
                appendEdgePath(shapeAppearancePathSpec, i2);
            }
            path.close();
            this.overlappedEdgePath.close();
            if (Build.VERSION.SDK_INT >= 19 && !this.overlappedEdgePath.isEmpty()) {
                path.op(this.overlappedEdgePath, Path.Op.UNION);
            }
        }
    }

    public void setEdgeIntersectionCheckEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.edgeIntersectionCheckEnabled = z;
        }
    }
}
