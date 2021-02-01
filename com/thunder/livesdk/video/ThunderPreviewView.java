package com.thunder.livesdk.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.UploadStreamStateParams;
import com.yy.mediaframework.opengles.YMFPreviewCanvasView;
import com.yy.mediaframework.opengles.YMFPreviewView;
/* loaded from: classes4.dex */
public class ThunderPreviewView extends FrameLayout {
    private SurfaceView mSurfaceView;

    public ThunderPreviewView(Context context) {
        super(context);
        initData();
    }

    public ThunderPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initData();
    }

    public ThunderPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initData();
    }

    public SurfaceView getSurfaceView() {
        return this.mSurfaceView;
    }

    private void initData() {
        if (this.mSurfaceView == null) {
            if (UploadStreamStateParams.mPreviewMode == Constant.PreviewMode.GlSurfaceMode) {
                this.mSurfaceView = new YMFPreviewView(getContext().getApplicationContext());
            } else if (UploadStreamStateParams.mPreviewMode == Constant.PreviewMode.CanvasMode) {
                this.mSurfaceView = new YMFPreviewCanvasView(getContext().getApplicationContext());
            } else {
                this.mSurfaceView = new SurfaceView(getContext().getApplicationContext());
            }
            this.mSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.mSurfaceView);
        }
    }

    public boolean checkViewType(Constant.PreviewMode previewMode) {
        return (previewMode == Constant.PreviewMode.GlSurfaceMode && !(this.mSurfaceView instanceof YMFPreviewView)) || (previewMode == Constant.PreviewMode.CanvasMode && !(this.mSurfaceView instanceof YMFPreviewCanvasView)) || (previewMode == Constant.PreviewMode.TextureMode && ((this.mSurfaceView instanceof YMFPreviewView) || (this.mSurfaceView instanceof YMFPreviewCanvasView)));
    }

    public void changeViewType() {
        removeAllViews();
        this.mSurfaceView = null;
        initData();
    }

    public void clearViews() {
        removeAllViews();
    }

    public void addViews(SurfaceView surfaceView) {
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(surfaceView);
    }
}
