package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.internal.Experimental;
import java.util.ArrayList;
import java.util.List;
@Experimental("The shapes API is currently experimental and subject to change")
/* loaded from: classes6.dex */
public class ShapePath {
    public float endX;
    public float endY;
    public final List<PathOperation> operations = new ArrayList();
    public float startX;
    public float startY;

    /* loaded from: classes6.dex */
    public static class PathArcOperation extends PathOperation {
        public static final RectF rectF = new RectF();
        public float bottom;
        public float left;
        public float right;
        public float startAngle;
        public float sweepAngle;
        public float top;

        public PathArcOperation(float f2, float f3, float f4, float f5) {
            this.left = f2;
            this.top = f3;
            this.right = f4;
            this.bottom = f5;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            rectF.set(this.left, this.top, this.right, this.bottom);
            path.arcTo(rectF, this.startAngle, this.sweepAngle, false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes6.dex */
    public static class PathLineOperation extends PathOperation {
        public float x;
        public float y;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.x, this.y);
            path.transform(matrix);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class PathOperation {
        public final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* loaded from: classes6.dex */
    public static class PathQuadOperation extends PathOperation {
        public float controlX;
        public float controlY;
        public float endX;
        public float endY;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(this.controlX, this.controlY, this.endX, this.endY);
            path.transform(matrix);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public void addArc(float f2, float f3, float f4, float f5, float f6, float f7) {
        PathArcOperation pathArcOperation = new PathArcOperation(f2, f3, f4, f5);
        pathArcOperation.startAngle = f6;
        pathArcOperation.sweepAngle = f7;
        this.operations.add(pathArcOperation);
        double d2 = f6 + f7;
        this.endX = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2))));
        this.endY = ((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i = 0; i < size; i++) {
            this.operations.get(i).applyToPath(matrix, path);
        }
    }

    public void lineTo(float f2, float f3) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.x = f2;
        pathLineOperation.y = f3;
        this.operations.add(pathLineOperation);
        this.endX = f2;
        this.endY = f3;
    }

    public void quadToPoint(float f2, float f3, float f4, float f5) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.controlX = f2;
        pathQuadOperation.controlY = f3;
        pathQuadOperation.endX = f4;
        pathQuadOperation.endY = f5;
        this.operations.add(pathQuadOperation);
        this.endX = f4;
        this.endY = f5;
    }

    public void reset(float f2, float f3) {
        this.startX = f2;
        this.startY = f3;
        this.endX = f2;
        this.endY = f3;
        this.operations.clear();
    }

    public ShapePath(float f2, float f3) {
        reset(f2, f3);
    }
}
