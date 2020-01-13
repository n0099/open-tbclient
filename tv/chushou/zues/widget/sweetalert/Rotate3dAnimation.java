package tv.chushou.zues.widget.sweetalert;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import tv.chushou.zues.b;
/* loaded from: classes4.dex */
public class Rotate3dAnimation extends Animation {
    public static final int ROLL_BY_X = 0;
    public static final int ROLL_BY_Y = 1;
    public static final int ROLL_BY_Z = 2;
    private Camera mCamera;
    private float mFromDegrees;
    private float mPivotX;
    private int mPivotXType;
    private float mPivotXValue;
    private float mPivotY;
    private int mPivotYType;
    private float mPivotYValue;
    private int mRollType;
    private float mToDegrees;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class a {
        public int type;
        public float value;

        protected a() {
        }
    }

    a parseValue(TypedValue typedValue) {
        a aVar = new a();
        if (typedValue == null) {
            aVar.type = 0;
            aVar.value = 0.0f;
        } else if (typedValue.type == 6) {
            aVar.type = (typedValue.data & 15) == 1 ? 2 : 1;
            aVar.value = TypedValue.complexToFloat(typedValue.data);
            return aVar;
        } else if (typedValue.type == 4) {
            aVar.type = 0;
            aVar.value = typedValue.getFloat();
            return aVar;
        } else if (typedValue.type >= 16 && typedValue.type <= 31) {
            aVar.type = 0;
            aVar.value = typedValue.data;
            return aVar;
        }
        aVar.type = 0;
        aVar.value = 0.0f;
        return aVar;
    }

    public Rotate3dAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPivotXType = 0;
        this.mPivotYType = 0;
        this.mPivotXValue = 0.0f;
        this.mPivotYValue = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.Rotate3dAnimation);
        this.mFromDegrees = obtainStyledAttributes.getFloat(b.i.Rotate3dAnimation_fromDeg, 0.0f);
        this.mToDegrees = obtainStyledAttributes.getFloat(b.i.Rotate3dAnimation_toDeg, 0.0f);
        this.mRollType = obtainStyledAttributes.getInt(b.i.Rotate3dAnimation_rollType, 0);
        a parseValue = parseValue(obtainStyledAttributes.peekValue(b.i.Rotate3dAnimation_pivotX));
        this.mPivotXType = parseValue.type;
        this.mPivotXValue = parseValue.value;
        a parseValue2 = parseValue(obtainStyledAttributes.peekValue(b.i.Rotate3dAnimation_pivotY));
        this.mPivotYType = parseValue2.type;
        this.mPivotYValue = parseValue2.value;
        obtainStyledAttributes.recycle();
        initializePivotPoint();
    }

    public Rotate3dAnimation(int i, float f, float f2) {
        this.mPivotXType = 0;
        this.mPivotYType = 0;
        this.mPivotXValue = 0.0f;
        this.mPivotYValue = 0.0f;
        this.mRollType = i;
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
    }

    public Rotate3dAnimation(int i, float f, float f2, float f3, float f4) {
        this.mPivotXType = 0;
        this.mPivotYType = 0;
        this.mPivotXValue = 0.0f;
        this.mPivotYValue = 0.0f;
        this.mRollType = i;
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mPivotXType = 0;
        this.mPivotYType = 0;
        this.mPivotXValue = f3;
        this.mPivotYValue = f4;
        initializePivotPoint();
    }

    public Rotate3dAnimation(int i, float f, float f2, int i2, float f3, int i3, float f4) {
        this.mPivotXType = 0;
        this.mPivotYType = 0;
        this.mPivotXValue = 0.0f;
        this.mPivotYValue = 0.0f;
        this.mRollType = i;
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mPivotXValue = f3;
        this.mPivotXType = i2;
        this.mPivotYValue = f4;
        this.mPivotYType = i3;
        initializePivotPoint();
    }

    private void initializePivotPoint() {
        if (this.mPivotXType == 0) {
            this.mPivotX = this.mPivotXValue;
        }
        if (this.mPivotYType == 0) {
            this.mPivotY = this.mPivotYValue;
        }
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.mCamera = new Camera();
        this.mPivotX = resolveSize(this.mPivotXType, this.mPivotXValue, i, i3);
        this.mPivotY = resolveSize(this.mPivotYType, this.mPivotYValue, i2, i4);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromDegrees;
        float f3 = f2 + ((this.mToDegrees - f2) * f);
        Matrix matrix = transformation.getMatrix();
        this.mCamera.save();
        switch (this.mRollType) {
            case 0:
                this.mCamera.rotateX(f3);
                break;
            case 1:
                this.mCamera.rotateY(f3);
                break;
            case 2:
                this.mCamera.rotateZ(f3);
                break;
        }
        this.mCamera.getMatrix(matrix);
        this.mCamera.restore();
        matrix.preTranslate(-this.mPivotX, -this.mPivotY);
        matrix.postTranslate(this.mPivotX, this.mPivotY);
    }
}
