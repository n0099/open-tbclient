package tv.chushou.common.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
/* loaded from: classes6.dex */
public class SurfaceRenderView extends SurfaceView {
    public int mMeasuredHeight;
    public int mMeasuredWidth;

    public SurfaceRenderView(Context context) {
        super(context);
        this.mMeasuredWidth = -1;
        this.mMeasuredHeight = -1;
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMeasuredWidth = -1;
        this.mMeasuredHeight = -1;
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMeasuredWidth = -1;
        this.mMeasuredHeight = -1;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mMeasuredWidth <= 0 || this.mMeasuredHeight <= 0) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(this.mMeasuredWidth, this.mMeasuredHeight);
        }
    }
}
