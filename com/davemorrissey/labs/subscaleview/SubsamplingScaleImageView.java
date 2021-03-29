package com.davemorrissey.labs.subscaleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    public static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_CENTER_IN_TO_MAX_OUT_TO_INIT = 4;
    public static final int ZOOM_FOCUS_FIXED = 1;
    public Anim anim;
    public Bitmap bitmap;
    public DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    public Paint bitmapPaint;
    public boolean debug;
    public Paint debugPaint;
    public ImageRegionDecoder decoder;
    public final Object decoderLock;
    public GestureDetector detector;
    public float doubleTapZoomScale;
    public int doubleTapZoomStyle;
    public float[] dstArray;
    public int fullImageSampleSize;
    public Handler handler;
    public boolean imageLoadedSent;
    public ImageSource imageSource;
    public boolean isPanning;
    public boolean isQuickScaling;
    public boolean isZooming;
    public IScrollDistanceCallBack mIScrollDistanceCallBack;
    public Float mInitScale;
    public Matrix matrix;
    public float maxScale;
    public int maxTouchCount;
    public float minScale;
    public int minimumScaleType;
    public int minimumTileDpi;
    public float norScale;
    public OnImageEventListener onImageEventListener;
    public View.OnLongClickListener onLongClickListener;
    public int orientation;
    public Rect pRegion;
    public boolean panEnabled;
    public int panLimit;
    public Float pendingScale;
    public boolean preview;
    public PointF quickScaleCenter;
    public boolean quickScaleEnabled;
    public float quickScaleLastDistance;
    public PointF quickScaleLastPoint;
    public boolean quickScaleMoved;
    public final float quickScaleThreshold;
    public boolean readySent;
    public DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    public int sHeight;
    public int sOrientation;
    public PointF sPendingCenter;
    public RectF sRect;
    public Rect sRegion;
    public PointF sRequestedCenter;
    public int sWidth;
    public ScaleAndTranslate satTemp;
    public float scale;
    public float scaleStart;
    public float[] srcArray;
    public Paint tileBgPaint;
    public Map<Integer, List<Tile>> tileMap;
    public PointF vCenterStart;
    public float vDistStart;
    public PointF vTranslate;
    public PointF vTranslateStart;
    public boolean zoomEnabled;
    public static final String TAG = SubsamplingScaleImageView.class.getSimpleName();
    public static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
    public static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3, 4);
    public static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    public static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    public static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3);

    /* loaded from: classes6.dex */
    public static class BitmapLoadTask extends BdAsyncTask<Void, Void, Integer> {
        public Bitmap bitmap;
        public final WeakReference<Context> contextRef;
        public final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        public Exception exception;
        public final boolean preview;
        public final Uri source;
        public final WeakReference<SubsamplingScaleImageView> viewRef;

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                this.bitmap = decoderFactory.make().decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(uri));
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e2);
                this.exception = e2;
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                    } else {
                        subsamplingScaleImageView.onImageLoaded(bitmap, num.intValue());
                    }
                } else if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                } else {
                    if (this.preview) {
                        subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                    } else {
                        subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class DefaultOnImageEventListener implements OnImageEventListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
        }
    }

    /* loaded from: classes6.dex */
    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* loaded from: classes6.dex */
    public static class Tile {
        public Bitmap bitmap;
        public Rect fileSRect;
        public boolean loading;
        public Rect sRect;
        public int sampleSize;
        public Rect vRect;
        public boolean visible;

        public Tile() {
        }

        public /* synthetic */ Tile(Tile tile) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class TileLoadTask extends BdAsyncTask<Void, Void, Bitmap> {
        public final WeakReference<ImageRegionDecoder> decoderRef;
        public Exception exception;
        public final WeakReference<Tile> tileRef;
        public final WeakReference<SubsamplingScaleImageView> viewRef;

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeRegion;
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady()) {
                    if (tile != null) {
                        tile.loading = false;
                        return null;
                    }
                    return null;
                }
                synchronized (subsamplingScaleImageView.decoderLock) {
                    subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                    if (subsamplingScaleImageView.sRegion != null) {
                        tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                    }
                    decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                }
                return decodeRegion;
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e2);
                this.exception = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                this.exception = new Exception(e3.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.bitmap = bitmap;
                tile.loading = false;
                subsamplingScaleImageView.onTileLoaded();
            } else if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
            } else {
                subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class TilesInitTask extends BdAsyncTask<Void, Void, int[]> {
        public final WeakReference<Context> contextRef;
        public ImageRegionDecoder decoder;
        public final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        public Exception exception;
        public final Uri source;
        public final WeakReference<SubsamplingScaleImageView> viewRef;

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                ImageRegionDecoder make = decoderFactory.make();
                this.decoder = make;
                Point init = make.init(context, this.source);
                int i = init.x;
                int i2 = init.y;
                int exifOrientation = subsamplingScaleImageView.getExifOrientation(uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    i = subsamplingScaleImageView.sRegion.width();
                    i2 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i, i2, exifOrientation};
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e2);
                this.exception = e2;
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                } else {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.decoderLock = new Object();
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(1) && (string = obtainStyledAttributes.getString(1)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(2)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(2, true));
            }
            if (obtainStyledAttributes.hasValue(3)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(3, true));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(4, true));
            }
            if (obtainStyledAttributes.hasValue(5)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(5, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f2) {
        int round;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f2);
        int sHeight = (int) (sHeight() * f2);
        if (sWidth == 0 || sHeight == 0) {
            return 32;
        }
        int i = 1;
        if (sHeight() > sHeight || sWidth() > sWidth) {
            round = Math.round(sHeight() / sHeight);
            int round2 = Math.round(sWidth() / sWidth);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while (true) {
            int i2 = i * 2;
            if (i2 >= round) {
                return i;
            }
            i = i2;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if (this.debugPaint == null && this.debug) {
            Paint paint2 = new Paint();
            this.debugPaint = paint2;
            paint2.setTextSize(18.0f);
            this.debugPaint.setColor(-65281);
            this.debugPaint.setStyle(Paint.Style.STROKE);
        }
    }

    @SuppressLint({"FloatMath"})
    private float distance(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return FloatMath.sqrt((f6 * f6) + (f7 * f7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        boolean z = ((double) this.scale) <= ((double) min) * 0.9d;
        float minScale = z ? min : minScale();
        int i = this.doubleTapZoomStyle;
        if (i == 4) {
            if (!z) {
                min = this.mInitScale.floatValue();
            }
            new AnimationBuilder(this, min, pointF, (AnimationBuilder) null).withInterruptible(false).start();
        } else if (i == 3) {
            setScaleAndCenter(minScale, pointF);
        } else if (i == 2 || !z || !this.panEnabled) {
            new AnimationBuilder(this, minScale, pointF, (AnimationBuilder) null).withInterruptible(false).start();
        } else if (i == 1) {
            new AnimationBuilder(this, minScale, pointF, pointF2, null).withInterruptible(false).start();
        }
        invalidate();
    }

    private float ease(int i, long j, float f2, float f3, long j2) {
        if (i != 1) {
            if (i == 2) {
                return easeInOutQuad(j, f2, f3, j2);
            }
            throw new IllegalStateException("Unexpected easing type: " + i);
        }
        return easeOutQuad(j, f2, f3, j2);
    }

    private float easeInOutQuad(long j, float f2, float f3, long j2) {
        float f4;
        float f5 = ((float) j) / (((float) j2) / 2.0f);
        if (f5 < 1.0f) {
            f4 = (f3 / 2.0f) * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f6 * (f6 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    private float easeOutQuad(long j, float f2, float f3, long j2) {
        float f4 = ((float) j) / ((float) j2);
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            int i = rect.top;
            int i2 = this.sHeight;
            rect2.set(i, i2 - rect.right, rect.bottom, i2 - rect.left);
        } else if (getRequiredRotation() == 180) {
            int i3 = this.sWidth;
            int i4 = this.sHeight;
            rect2.set(i3 - rect.right, i4 - rect.bottom, i3 - rect.left, i4 - rect.top);
        } else {
            int i5 = this.sWidth;
            rect2.set(i5 - rect.bottom, rect.left, i5 - rect.top, rect.right);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float max;
        int max2;
        float max3;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth = sWidth() * limitedScale;
        float sHeight = sHeight() * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - sWidth);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - sHeight);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - sWidth);
            pointF.y = Math.max(pointF.y, getHeight() - sHeight);
        } else {
            pointF.x = Math.max(pointF.x, -sWidth);
            pointF.y = Math.max(pointF.y, -sHeight);
        }
        float f2 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
        }
        if (this.panLimit == 3 && isReady()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else if (z) {
            max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
            max3 = Math.max(0.0f, (getHeight() - sHeight) * f2);
            pointF.x = Math.min(pointF.x, max);
            pointF.y = Math.min(pointF.y, max3);
            scaleAndTranslate.scale = limitedScale;
        } else {
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        scaleAndTranslate.scale = limitedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExifOrientation(String str) {
        if (!str.startsWith(ImageSource.FILE_SCHEME) || str.startsWith("file:///android_asset/")) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 1 && attributeInt != 0) {
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 8) {
                    return 270;
                }
                String str2 = TAG;
                Log.w(str2, "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            }
            return 0;
        } catch (Exception unused) {
            Log.w(TAG, "Could not get EXIF orientation of image");
            return 0;
        }
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                return new Point(((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue(), ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue());
            } catch (Exception unused) {
            }
        }
        return new Point(2048, 2048);
    }

    private int getRequiredRotation() {
        int i = this.orientation;
        return i == -1 ? this.sOrientation : i;
    }

    private synchronized void initialiseBaseLayer(Point point) {
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = calculateInSampleSize;
        if (calculateInSampleSize > 1) {
            this.fullImageSampleSize = calculateInSampleSize / 2;
        }
        initialiseTileMap(point);
        for (Tile tile : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
            TileLoadTask tileLoadTask = new TileLoadTask(this, this.decoder, tile);
            tileLoadTask.setPriority(3);
            tileLoadTask.execute(new Void[0]);
        }
        refreshRequiredTiles(true);
    }

    private void initialiseTileMap(Point point) {
        this.tileMap = new LinkedHashMap();
        int i = this.fullImageSampleSize;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int sWidth = sWidth() / i3;
            int sHeight = sHeight() / i4;
            int i5 = sWidth / i;
            int i6 = sHeight / i;
            while (true) {
                if (i5 + i3 + i2 > point.x || (i5 > getWidth() * 1.25d && i < this.fullImageSampleSize)) {
                    i3++;
                    sWidth = sWidth() / i3;
                    i5 = sWidth / i;
                    i2 = 1;
                }
            }
            while (true) {
                if (i6 + i4 + i2 > point.y || (i6 > getHeight() * 1.25d && i < this.fullImageSampleSize)) {
                    i4++;
                    sHeight = sHeight() / i4;
                    i6 = sHeight / i;
                    i2 = 1;
                }
            }
            ArrayList arrayList = new ArrayList(i3 * i4);
            int i7 = 0;
            while (i7 < i3) {
                int i8 = 0;
                while (i8 < i4) {
                    Tile tile = new Tile(null);
                    tile.sampleSize = i;
                    tile.visible = i == this.fullImageSampleSize;
                    tile.sRect = new Rect(i7 * sWidth, i8 * sHeight, i7 == i3 + (-1) ? sWidth() : (i7 + 1) * sWidth, i8 == i4 + (-1) ? sHeight() : (i8 + 1) * sHeight);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i8++;
                    i2 = 1;
                }
                i7++;
            }
            this.tileMap.put(Integer.valueOf(i), arrayList);
            if (i == i2) {
                return;
            }
            i /= 2;
        }
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap == null || this.preview) {
            Map<Integer, List<Tile>> map = this.tileMap;
            if (map != null) {
                for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                    if (entry.getKey().intValue() == this.fullImageSampleSize) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.loading || tile.bitmap == null) {
                                z = false;
                            }
                        }
                    }
                }
                return z;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF limitedSCenter(float f2, float f3, float f4, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - vTranslateForSCenter.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - vTranslateForSCenter.y) / f4);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f2) {
        return Math.min(this.maxScale, Math.max(minScale(), f2));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.minimumScaleType;
        if (i == 2) {
            return Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        if (i == 3) {
            float f2 = this.minScale;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i) {
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        if (this.bitmap != null) {
            this.bitmap.recycle();
        }
        this.preview = false;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i;
        if (checkReady() || checkImageLoaded()) {
            invalidate();
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        if (this.bitmap == null && !this.imageLoadedSent) {
            if (this.pRegion != null) {
                this.bitmap = Bitmap.createBitmap(bitmap, this.pRegion.left, this.pRegion.top, this.pRegion.width(), this.pRegion.height());
            } else {
                this.bitmap = bitmap;
            }
            this.preview = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && this.bitmap != null) {
            this.bitmap.recycle();
            this.bitmap = null;
            this.preview = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != i || this.sHeight != i2)) {
            reset(false);
            if (this.bitmap != null) {
                this.bitmap.recycle();
                this.bitmap = null;
                this.preview = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        checkImageLoaded();
        invalidate();
        requestLayout();
    }

    private void preDraw() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0 || this.sHeight <= 0) {
            return;
        }
        if (this.sPendingCenter != null && (f2 = this.pendingScale) != null) {
            float floatValue = f2.floatValue();
            this.scale = floatValue;
            if (floatValue != this.norScale) {
                this.norScale = floatValue;
            }
            if (this.vTranslate == null) {
                this.vTranslate = new PointF();
            }
            this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
            this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
            this.sPendingCenter = null;
            this.pendingScale = null;
            fitToBounds(true);
            refreshRequiredTiles(true);
        }
        fitToBounds(false);
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder == null || this.tileMap == null) {
            return;
        }
        int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
            for (Tile tile : entry.getValue()) {
                if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
                if (tile.sampleSize != min) {
                    if (tile.sampleSize == this.fullImageSampleSize) {
                        tile.visible = true;
                    }
                } else if (tileVisible(tile)) {
                    tile.visible = true;
                    if (!tile.loading && tile.bitmap == null && z) {
                        TileLoadTask tileLoadTask = new TileLoadTask(this, this.decoder, tile);
                        tileLoadTask.setPriority(3);
                        tileLoadTask.execute(new Void[0]);
                    }
                } else if (tile.sampleSize != this.fullImageSampleSize) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
        }
    }

    private void reset(boolean z) {
        Float valueOf = Float.valueOf(0.0f);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.pendingScale = valueOf;
        this.mInitScale = valueOf;
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleCenter = null;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleLastPoint = null;
        this.quickScaleMoved = false;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            if (this.decoder != null) {
                synchronized (this.decoderLock) {
                    this.decoder.recycle();
                    this.decoder = null;
                }
            }
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.sWidth = 0;
            this.sHeight = 0;
            this.sOrientation = 0;
            this.sRegion = null;
            this.pRegion = null;
            this.readySent = false;
            this.imageLoadedSent = false;
            this.bitmap = null;
            this.preview = false;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        this.imageSource = null;
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState == null || imageViewState.getCenter() == null || !VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.orientation = imageViewState.getOrientation();
        this.pendingScale = Float.valueOf(imageViewState.getScale());
        this.sPendingCenter = imageViewState.getCenter();
        invalidate();
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        if (context == null) {
            return;
        }
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (SubsamplingScaleImageView.this.zoomEnabled && SubsamplingScaleImageView.this.readySent && SubsamplingScaleImageView.this.vTranslate != null) {
                    SubsamplingScaleImageView.this.setGestureDetector(context);
                    if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                        SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                        SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                        subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                        SubsamplingScaleImageView.this.isQuickScaling = true;
                        SubsamplingScaleImageView.this.isZooming = true;
                        SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                        subsamplingScaleImageView2.quickScaleCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                        SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                        SubsamplingScaleImageView.this.quickScaleLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleCenter.x, SubsamplingScaleImageView.this.quickScaleCenter.y);
                        SubsamplingScaleImageView.this.quickScaleMoved = false;
                        return false;
                    }
                    SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (SubsamplingScaleImageView.this.mIScrollDistanceCallBack != null) {
                    SubsamplingScaleImageView.this.mIScrollDistanceCallBack.onMove(motionEvent, motionEvent2, SubsamplingScaleImageView.this.vTranslate, f2, f3);
                }
                if (SubsamplingScaleImageView.this.panEnabled && SubsamplingScaleImageView.this.readySent && SubsamplingScaleImageView.this.vTranslate != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f2) > 500.0f || Math.abs(f3) > 500.0f) && !SubsamplingScaleImageView.this.isZooming))) {
                    PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f2 * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f3 * 0.25f));
                    new AnimationBuilder(SubsamplingScaleImageView.this, new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.scale, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.scale), (AnimationBuilder) null).withEasing(1).withPanLimited(false).start();
                    return true;
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
        return rect2;
    }

    private float sourceToViewX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private PointF vTranslateForSCenter(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.satTemp.scale = f4;
        this.satTemp.vTranslate.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.scale;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(this, pointF, (AnimationBuilder) null);
        }
        return null;
    }

    public AnimationBuilder animateScale(float f2) {
        if (isReady()) {
            return new AnimationBuilder(this, f2, (AnimationBuilder) null);
        }
        return null;
    }

    public AnimationBuilder animateScaleAndCenter(float f2, PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(this, f2, pointF, (AnimationBuilder) null);
        }
        return null;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean isCanDrag() {
        return this.scale == this.norScale;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public boolean isViewTop() {
        return this.vTranslate.y == 0.0f;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f2;
        int i;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth == 0 || this.sHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.tileMap == null && this.decoder != null) {
            initialiseBaseLayer(getMaxBitmapDimensions(canvas));
        }
        if (checkReady()) {
            preDraw();
            int i2 = 1;
            char c2 = 0;
            if (this.anim != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                boolean z = currentTimeMillis > this.anim.duration;
                long min = Math.min(currentTimeMillis, this.anim.duration);
                this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                fitToBounds(z || this.anim.scaleStart == this.anim.scaleEnd);
                refreshRequiredTiles(z);
                if (z) {
                    this.anim = null;
                }
                invalidate();
            }
            if (this.tileMap != null && isBaseLayerReady()) {
                int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                boolean z2 = false;
                for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                    int i3 = min2;
                    if (entry.getKey().intValue() == i3) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                z2 = true;
                            }
                        }
                    }
                    min2 = i3;
                    i2 = 1;
                    c2 = 0;
                }
                for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z2) {
                        for (Tile tile2 : entry2.getValue()) {
                            sourceToViewRect(tile2.sRect, tile2.vRect);
                            if (tile2.loading || tile2.bitmap == null) {
                                i = min2;
                                if (tile2.loading && this.debug) {
                                    canvas.drawText("LOADING", tile2.vRect.left + 5, tile2.vRect.top + 35, this.debugPaint);
                                }
                            } else {
                                if (this.tileBgPaint != null) {
                                    canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                }
                                if (this.matrix == null) {
                                    this.matrix = new Matrix();
                                }
                                this.matrix.reset();
                                i = min2;
                                setMatrixArray(this.srcArray, 0.0f, 0.0f, tile2.bitmap.getWidth(), 0.0f, tile2.bitmap.getWidth(), tile2.bitmap.getHeight(), 0.0f, tile2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top);
                                } else if (getRequiredRotation() == 180) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top);
                                } else if (getRequiredRotation() == 270) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom);
                                }
                                this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                if (this.debug) {
                                    canvas.drawRect(tile2.vRect, this.debugPaint);
                                }
                            }
                            if (tile2.visible && this.debug) {
                                canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, tile2.vRect.left + 5, tile2.vRect.top + 15, this.debugPaint);
                            }
                            min2 = i;
                            i2 = 1;
                            c2 = 0;
                        }
                    }
                }
                if (this.debug) {
                    StringBuilder sb = new StringBuilder("Scale: ");
                    Object[] objArr = new Object[i2];
                    objArr[c2] = Float.valueOf(this.scale);
                    sb.append(String.format("%.2f", objArr));
                    canvas.drawText(sb.toString(), 5.0f, 15.0f, this.debugPaint);
                    StringBuilder sb2 = new StringBuilder("Translate: ");
                    Object[] objArr2 = new Object[i2];
                    objArr2[c2] = Float.valueOf(this.vTranslate.x);
                    sb2.append(String.format("%.2f", objArr2));
                    sb2.append(":");
                    Object[] objArr3 = new Object[i2];
                    objArr3[c2] = Float.valueOf(this.vTranslate.y);
                    sb2.append(String.format("%.2f", objArr3));
                    canvas.drawText(sb2.toString(), 5.0f, 35.0f, this.debugPaint);
                    PointF center = getCenter();
                    StringBuilder sb3 = new StringBuilder("Source center: ");
                    Object[] objArr4 = new Object[i2];
                    objArr4[c2] = Float.valueOf(center.x);
                    sb3.append(String.format("%.2f", objArr4));
                    sb3.append(":");
                    Object[] objArr5 = new Object[i2];
                    objArr5[c2] = Float.valueOf(center.y);
                    sb3.append(String.format("%.2f", objArr5));
                    canvas.drawText(sb3.toString(), 5.0f, 55.0f, this.debugPaint);
                    Anim anim = this.anim;
                    if (anim != null) {
                        PointF sourceToViewCoord = sourceToViewCoord(anim.sCenterStart);
                        PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                        PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                        canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 10.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, 20.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, 25.0f, this.debugPaint);
                        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.debugPaint);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.bitmap != null) {
                float f3 = this.scale;
                if (this.preview) {
                    f3 *= this.sWidth / bitmap.getWidth();
                    f2 = this.scale * (this.sHeight / this.bitmap.getHeight());
                } else {
                    f2 = f3;
                }
                if (this.matrix == null) {
                    this.matrix = new Matrix();
                }
                this.matrix.reset();
                this.matrix.postScale(f3, f2);
                this.matrix.postRotate(getOrientation());
                Matrix matrix = this.matrix;
                PointF pointF = this.vTranslate;
                matrix.postTranslate(pointF.x, pointF.y);
                if (getOrientation() == 180) {
                    Matrix matrix2 = this.matrix;
                    float f4 = this.scale;
                    matrix2.postTranslate(this.sWidth * f4, f4 * this.sHeight);
                } else if (getOrientation() == 90) {
                    this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
                } else if (getOrientation() == 270) {
                    this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
                }
                if (this.tileBgPaint != null) {
                    if (this.sRect == null) {
                        this.sRect = new RectF();
                    }
                    this.sRect.set(0.0f, 0.0f, this.sWidth, this.sHeight);
                    this.matrix.mapRect(this.sRect);
                    canvas.drawRect(this.sRect, this.tileBgPaint);
                }
                canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
            }
        }
    }

    public void onImageLoaded() {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z && z2) {
                size = sWidth();
                size2 = sHeight();
            } else if (z2) {
                size2 = (int) ((sHeight() / sWidth()) * size);
            } else if (z) {
                size = (int) ((sWidth() / sHeight()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public void onReady() {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        PointF center = getCenter();
        if (!this.readySent || center == null) {
            return;
        }
        this.anim = null;
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = center;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
        if (r5 != 262) goto L40;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        this.anim = null;
        if (this.vTranslate == null) {
            return true;
        }
        boolean z = false;
        if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            if (motionEvent.getAction() == 1) {
                Log.e("SubsamplingScaleImageView", "action1:detector.onTouchEvent:" + this.detector.onTouchEvent(motionEvent));
            }
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        if (this.vTranslateStart == null) {
            this.vTranslateStart = new PointF(0.0f, 0.0f);
        }
        if (this.vCenterStart == null) {
            this.vCenterStart = new PointF(0.0f, 0.0f);
        }
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.maxTouchCount > 0) {
                        if (pointerCount >= 2) {
                            float distance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                            float x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                            float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                            if (this.zoomEnabled) {
                                PointF pointF = this.vCenterStart;
                                if (distance(pointF.x, x, pointF.y, y) > 5.0f || Math.abs(distance - this.vDistStart) > 5.0f || this.isPanning) {
                                    this.isZooming = true;
                                    this.isPanning = true;
                                    float min = Math.min(this.maxScale, (distance / this.vDistStart) * this.scaleStart);
                                    this.scale = min;
                                    if (min <= minScale()) {
                                        this.vDistStart = distance;
                                        this.scaleStart = minScale();
                                        this.vCenterStart.set(x, y);
                                        this.vTranslateStart.set(this.vTranslate);
                                    } else if (this.panEnabled) {
                                        PointF pointF2 = this.vCenterStart;
                                        float f2 = pointF2.x;
                                        PointF pointF3 = this.vTranslateStart;
                                        float f3 = f2 - pointF3.x;
                                        float f4 = pointF2.y - pointF3.y;
                                        float f5 = this.scale;
                                        float f6 = this.scaleStart;
                                        float f7 = f4 * (f5 / f6);
                                        PointF pointF4 = this.vTranslate;
                                        pointF4.x = x - (f3 * (f5 / f6));
                                        pointF4.y = y - f7;
                                    } else if (this.sRequestedCenter != null) {
                                        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
                                        this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
                                    } else {
                                        this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
                                        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
                                    }
                                    fitToBounds(true);
                                    refreshRequiredTiles(false);
                                    z = true;
                                }
                            }
                        } else {
                            if (this.isQuickScaling) {
                                float abs = (Math.abs(this.vCenterStart.y - motionEvent.getY()) * 2.0f) + this.quickScaleThreshold;
                                if (this.quickScaleLastDistance == -1.0f) {
                                    this.quickScaleLastDistance = abs;
                                }
                                boolean z2 = motionEvent.getY() > this.quickScaleLastPoint.y;
                                this.quickScaleLastPoint.set(0.0f, motionEvent.getY());
                                float abs2 = Math.abs(1.0f - (abs / this.quickScaleLastDistance)) * 0.5f;
                                if (abs2 > 0.03f || this.quickScaleMoved) {
                                    this.quickScaleMoved = true;
                                    float max = Math.max(minScale(), Math.min(this.maxScale, this.scale * (this.quickScaleLastDistance > 0.0f ? z2 ? abs2 + 1.0f : 1.0f - abs2 : 1.0f)));
                                    this.scale = max;
                                    if (this.panEnabled) {
                                        PointF pointF5 = this.vCenterStart;
                                        float f8 = pointF5.x;
                                        PointF pointF6 = this.vTranslateStart;
                                        float f9 = pointF5.y;
                                        float f10 = this.scaleStart;
                                        float f11 = (f9 - pointF6.y) * (max / f10);
                                        PointF pointF7 = this.vTranslate;
                                        pointF7.x = f8 - ((f8 - pointF6.x) * (max / f10));
                                        pointF7.y = f9 - f11;
                                    } else if (this.sRequestedCenter != null) {
                                        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
                                        this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
                                    } else {
                                        this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
                                        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
                                    }
                                }
                                this.quickScaleLastDistance = abs;
                                fitToBounds(true);
                                refreshRequiredTiles(false);
                            } else if (!this.isZooming) {
                                float x2 = motionEvent.getX();
                                float y2 = motionEvent.getY();
                                if (pointerCount >= 2) {
                                    x2 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                                    y2 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                                }
                                float abs3 = Math.abs(x2 - this.vCenterStart.x);
                                float abs4 = Math.abs(y2 - this.vCenterStart.y);
                                int i = (abs3 > 100.0f ? 1 : (abs3 == 100.0f ? 0 : -1));
                                if (i > 0 || abs4 > 100.0f || this.isPanning) {
                                    this.vTranslate.x = this.vTranslateStart.x + (motionEvent.getX() - this.vCenterStart.x);
                                    this.vTranslate.y = this.vTranslateStart.y + (motionEvent.getY() - this.vCenterStart.y);
                                    PointF pointF8 = this.vTranslate;
                                    float f12 = pointF8.x;
                                    float f13 = pointF8.y;
                                    fitToBounds(true);
                                    boolean z3 = f12 != this.vTranslate.x;
                                    boolean z4 = z3 && abs3 > abs4 && !this.isPanning;
                                    boolean z5 = f13 == this.vTranslate.y && abs4 > 15.0f;
                                    if (!z4 && (!z3 || z5 || this.isPanning)) {
                                        this.isPanning = true;
                                    } else if (i > 0) {
                                        this.maxTouchCount = 0;
                                        this.handler.removeMessages(1);
                                        getParent().requestDisallowInterceptTouchEvent(false);
                                    }
                                    if (!this.panEnabled) {
                                        PointF pointF9 = this.vTranslate;
                                        PointF pointF10 = this.vTranslateStart;
                                        pointF9.x = pointF10.x;
                                        pointF9.y = pointF10.y;
                                        getParent().requestDisallowInterceptTouchEvent(false);
                                    }
                                    refreshRequiredTiles(false);
                                }
                            }
                            z = true;
                        }
                    }
                    if (z) {
                        this.handler.removeMessages(1);
                        invalidate();
                        return true;
                    }
                } else if (action != 5) {
                    if (action != 6) {
                        if (action != 261) {
                        }
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            this.handler.removeMessages(1);
            if (this.isQuickScaling) {
                this.isQuickScaling = false;
                if (!this.quickScaleMoved) {
                    doubleTapZoom(this.quickScaleCenter, this.vCenterStart);
                }
            }
            if (this.maxTouchCount <= 0 || !(this.isZooming || this.isPanning)) {
                if (pointerCount == 1) {
                    this.isZooming = false;
                    this.isPanning = false;
                    this.maxTouchCount = 0;
                }
                return true;
            }
            if (this.isZooming && pointerCount == 2) {
                this.isPanning = true;
                PointF pointF11 = this.vTranslateStart;
                PointF pointF12 = this.vTranslate;
                pointF11.set(pointF12.x, pointF12.y);
                if (motionEvent.getActionIndex() == 1) {
                    this.vCenterStart.set(motionEvent.getX(0), motionEvent.getY(0));
                } else {
                    this.vCenterStart.set(motionEvent.getX(1), motionEvent.getY(1));
                }
            }
            if (pointerCount < 3) {
                this.isZooming = false;
            }
            if (pointerCount < 2) {
                this.isPanning = false;
                this.maxTouchCount = 0;
            }
            refreshRequiredTiles(true);
            return true;
        }
        this.anim = null;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.maxTouchCount = Math.max(this.maxTouchCount, pointerCount);
        if (pointerCount >= 2) {
            if (this.zoomEnabled) {
                float distance2 = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                this.scaleStart = this.scale;
                this.vDistStart = distance2;
                PointF pointF13 = this.vTranslateStart;
                PointF pointF14 = this.vTranslate;
                pointF13.set(pointF14.x, pointF14.y);
                this.vCenterStart.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
            } else {
                this.maxTouchCount = 0;
            }
        } else if (!this.isQuickScaling) {
            PointF pointF15 = this.vTranslateStart;
            PointF pointF16 = this.vTranslate;
            pointF15.set(pointF16.x, pointF16.y);
            this.vCenterStart.set(motionEvent.getX(), motionEvent.getY());
        }
        this.handler.sendEmptyMessageDelayed(1, 600L);
        return true;
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugPaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.doubleTapZoomScale = f2;
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i))) {
            this.doubleTapZoomStyle = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public void setIScrollDistanceCallBack(IScrollDistanceCallBack iScrollDistanceCallBack) {
        this.mIScrollDistanceCallBack = iScrollDistanceCallBack;
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public void setInitScale(float f2) {
        this.mInitScale = Float.valueOf(f2);
    }

    public final void setMaxScale(float f2) {
        this.maxScale = f2;
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinScale(float f2) {
        this.minScale = f2;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinimumScaleType(int i) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i))) {
            this.minimumScaleType = i;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i);
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public final void setOrientation(int i) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i))) {
            this.orientation = i;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i);
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.panEnabled = z;
        if (z || (pointF = this.vTranslate) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        if (isReady()) {
            refreshRequiredTiles(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i))) {
            this.panLimit = i;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i);
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f2);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public final PointF sourceToViewCoord(float f2, float f3) {
        return sourceToViewCoord(f2, f3, new PointF());
    }

    public final PointF viewToSourceCoord(float f2, float f3) {
        return viewToSourceCoord(f2, f3, new PointF());
    }

    /* loaded from: classes6.dex */
    public static class ScaleAndTranslate {
        public float scale;
        public PointF vTranslate;

        public ScaleAndTranslate(float f2, PointF pointF) {
            this.scale = f2;
            this.vTranslate = pointF;
        }

        public /* synthetic */ ScaleAndTranslate(float f2, PointF pointF, ScaleAndTranslate scaleAndTranslate) {
            this(f2, pointF);
        }
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            this.imageSource = imageSource;
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() == null) {
                    if (imageSource.getSWidth() > 0 && imageSource.getSHeight() > 0) {
                        this.sWidth = imageSource.getSWidth();
                        this.sHeight = imageSource.getSHeight();
                        this.pRegion = imageSource2.getSRegion();
                        if (imageSource2.getBitmap() != null) {
                            onPreviewLoaded(imageSource2.getBitmap());
                        } else {
                            Uri uri = imageSource2.getUri();
                            if (uri == null && imageSource2.getResource() != null) {
                                uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                            }
                            BitmapLoadTask bitmapLoadTask = new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true);
                            bitmapLoadTask.setPriority(3);
                            bitmapLoadTask.execute(new Void[0]);
                        }
                    } else {
                        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0);
                return;
            } else if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0);
                return;
            } else {
                this.sRegion = imageSource.getSRegion();
                Uri uri2 = imageSource.getUri();
                if (uri2 == null && imageSource.getResource() != null) {
                    uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
                }
                Uri uri3 = uri2;
                if (!imageSource.getTile() && this.sRegion == null) {
                    BitmapLoadTask bitmapLoadTask2 = new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri3, false);
                    bitmapLoadTask2.setPriority(3);
                    bitmapLoadTask2.execute(new Void[0]);
                    return;
                }
                TilesInitTask tilesInitTask = new TilesInitTask(this, getContext(), this.regionDecoderFactory, uri3);
                tilesInitTask.setPriority(3);
                tilesInitTask.execute(new Void[0]);
                return;
            }
        }
        throw new NullPointerException("imageSource must not be null");
    }

    public final PointF sourceToViewCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f2), sourceToViewY(f3));
        return pointF;
    }

    public final PointF viewToSourceCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f2), viewToSourceY(f3));
        return pointF;
    }

    /* loaded from: classes6.dex */
    public static class Anim {
        public long duration;
        public int easing;
        public boolean interruptible;
        public PointF sCenterEnd;
        public PointF sCenterEndRequested;
        public PointF sCenterStart;
        public float scaleEnd;
        public float scaleStart;
        public long time;
        public PointF vFocusEnd;
        public PointF vFocusStart;

        public Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.time = System.currentTimeMillis();
        }

        public /* synthetic */ Anim(Anim anim) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public final class AnimationBuilder {
        public long duration;
        public int easing;
        public boolean interruptible;
        public boolean panLimited;
        public final PointF targetSCenter;
        public final float targetScale;
        public final PointF vFocus;

        public AnimationBuilder(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        public void start() {
            PointF pointF;
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float limitedScale = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, limitedScale, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            SubsamplingScaleImageView.this.anim = new Anim(null);
            SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.anim.scaleEnd = limitedScale;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(paddingLeft, paddingTop);
            SubsamplingScaleImageView.this.anim.duration = this.duration;
            SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            SubsamplingScaleImageView.this.anim.easing = this.easing;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f2 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * limitedScale);
                float f3 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * limitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f2, f3), null);
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f2), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f3));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public AnimationBuilder withEasing(int i) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i))) {
                this.easing = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, AnimationBuilder animationBuilder) {
            this(pointF);
        }

        public AnimationBuilder(float f2) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, AnimationBuilder animationBuilder) {
            this(f2);
        }

        public AnimationBuilder(float f2, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, AnimationBuilder animationBuilder) {
            this(f2, pointF);
        }

        public AnimationBuilder(float f2, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, PointF pointF2, AnimationBuilder animationBuilder) {
            this(f2, pointF, pointF2);
        }
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        if (this.vTranslate == null) {
            z2 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        float f2 = this.satTemp.scale;
        this.scale = f2;
        if (this.norScale == 0.0f) {
            this.norScale = f2;
        }
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z2) {
            this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
