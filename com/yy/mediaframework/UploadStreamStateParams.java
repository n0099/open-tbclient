package com.yy.mediaframework;

import android.graphics.Bitmap;
import android.view.SurfaceView;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.utils.YMFLog;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class UploadStreamStateParams {
    public static int mOffsetX;
    public static int mOffsetY;
    public static SurfaceView mPreviewView;
    public static Bitmap mWaterMarkBitmap;
    public static Constant.ScaleMode mScaleMode = Constant.ScaleMode.AspectFit;
    public static boolean mWaterMarkEffect = false;
    public static boolean mPreviewMirror = true;
    public static boolean mEncoderMirror = false;
    public static int mCameraPosition = 0;
    public static long mDeltaPtsDts = 0;
    public static boolean mNetWorkStrategy = false;
    public static Constant.CaptureFpsMode mCaptureFpsMode = Constant.CaptureFpsMode.AlignEncoder;
    public static Constant.CaptureMode mCaptureMode = Constant.CaptureMode.TextureMode;
    public static Constant.PreviewMode mPreviewMode = Constant.PreviewMode.TextureMode;
    public static boolean mDisableBeauty = false;
    public static Constant.EncoderInputMode mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
    public static boolean mYuvTextureMode = false;
    public static AtomicBoolean mDisableHardEncoder = new AtomicBoolean(false);

    public static void reset() {
        mPreviewView = null;
        mScaleMode = Constant.ScaleMode.AspectFit;
        try {
            if (mWaterMarkBitmap != null && !mWaterMarkBitmap.isRecycled()) {
                mWaterMarkBitmap.recycle();
            }
            mWaterMarkBitmap = null;
        } catch (Exception e) {
            YMFLog.info(null, "[Procedur]", "UploadStreamStateParams mWaterMarkBitmap recycle exception:" + e.toString());
        }
        mOffsetX = 0;
        mOffsetY = 0;
        mWaterMarkEffect = false;
        mPreviewMirror = true;
        mEncoderMirror = false;
        mCameraPosition = 0;
        mDeltaPtsDts = 0L;
        mNetWorkStrategy = false;
        mCaptureMode = Constant.CaptureMode.TextureMode;
        mPreviewMode = Constant.PreviewMode.TextureMode;
        mDisableBeauty = false;
        mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
        mCaptureFpsMode = Constant.CaptureFpsMode.AlignEncoder;
        mYuvTextureMode = false;
    }
}
