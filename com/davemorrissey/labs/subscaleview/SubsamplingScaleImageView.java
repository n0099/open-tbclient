package com.davemorrissey.labs.subscaleview;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class SubsamplingScaleImageView extends View {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final String TAG;
    public static final List VALID_EASING_STYLES;
    public static final List VALID_ORIENTATIONS;
    public static final List VALID_PAN_LIMITS;
    public static final List VALID_SCALE_TYPES;
    public static final List VALID_ZOOM_STYLES;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_CENTER_IN_TO_MAX_OUT_TO_INIT = 4;
    public static final int ZOOM_FOCUS_FIXED = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Anim anim;
    public Bitmap bitmap;
    public DecoderFactory bitmapDecoderFactory;
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
    public DecoderFactory regionDecoderFactory;
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
    public Map tileMap;
    public PointF vCenterStart;
    public float vDistStart;
    public PointF vTranslate;
    public PointF vTranslateStart;
    public boolean zoomEnabled;

    /* loaded from: classes7.dex */
    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    private float easeInOutQuad(long j, float f, float f2, long j2) {
        InterceptResult invokeCommon;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65586, this, new Object[]{Long.valueOf(j), Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j2)})) == null) {
            float f4 = ((float) j) / (((float) j2) / 2.0f);
            if (f4 < 1.0f) {
                f3 = (f2 / 2.0f) * f4;
            } else {
                float f5 = f4 - 1.0f;
                f3 = (-f2) / 2.0f;
                f4 = (f5 * (f5 - 2.0f)) - 1.0f;
            }
            return (f3 * f4) + f;
        }
        return invokeCommon.floatValue;
    }

    private float easeOutQuad(long j, float f, float f2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65587, this, new Object[]{Long.valueOf(j), Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j2)})) == null) {
            float f3 = ((float) j) / ((float) j2);
            return ((-f2) * f3 * (f3 - 2.0f)) + f;
        }
        return invokeCommon.floatValue;
    }

    public void onImageLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class Anim {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.time = System.currentTimeMillis();
        }

        public /* synthetic */ Anim(Anim anim) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public final class AnimationBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long duration;
        public int easing;
        public boolean interruptible;
        public boolean panLimited;
        public final PointF targetSCenter;
        public final float targetScale;
        public final /* synthetic */ SubsamplingScaleImageView this$0;
        public final PointF vFocus;

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = subsamplingScaleImageView;
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = subsamplingScaleImageView.getCenter();
            this.vFocus = null;
        }

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, Float.valueOf(f), pointF};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = subsamplingScaleImageView;
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, Float.valueOf(f), pointF, pointF2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.this$0 = subsamplingScaleImageView;
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, f, pointF, pointF2);
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, f, pointF);
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, f);
        }

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, pointF};
                interceptable.invokeUnInit(65542, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65542, newInitContext);
                    return;
                }
            }
            this.this$0 = subsamplingScaleImageView;
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = subsamplingScaleImageView.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
                this.panLimited = z;
                return this;
            }
            return (AnimationBuilder) invokeZ.objValue;
        }

        public AnimationBuilder withDuration(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.duration = j;
                return this;
            }
            return (AnimationBuilder) invokeJ.objValue;
        }

        public AnimationBuilder withInterruptible(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.interruptible = z;
                return this;
            }
            return (AnimationBuilder) invokeZ.objValue;
        }

        public void start() {
            PointF pointF;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int paddingLeft = this.this$0.getPaddingLeft() + (((this.this$0.getWidth() - this.this$0.getPaddingRight()) - this.this$0.getPaddingLeft()) / 2);
                int paddingTop = this.this$0.getPaddingTop() + (((this.this$0.getHeight() - this.this$0.getPaddingBottom()) - this.this$0.getPaddingTop()) / 2);
                float limitedScale = this.this$0.limitedScale(this.targetScale);
                if (this.panLimited) {
                    SubsamplingScaleImageView subsamplingScaleImageView = this.this$0;
                    PointF pointF2 = this.targetSCenter;
                    pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, limitedScale, new PointF());
                } else {
                    pointF = this.targetSCenter;
                }
                this.this$0.anim = new Anim(null);
                this.this$0.anim.scaleStart = this.this$0.scale;
                this.this$0.anim.scaleEnd = limitedScale;
                this.this$0.anim.time = System.currentTimeMillis();
                this.this$0.anim.sCenterEndRequested = pointF;
                this.this$0.anim.sCenterStart = this.this$0.getCenter();
                this.this$0.anim.sCenterEnd = pointF;
                this.this$0.anim.vFocusStart = this.this$0.sourceToViewCoord(pointF);
                this.this$0.anim.vFocusEnd = new PointF(paddingLeft, paddingTop);
                this.this$0.anim.duration = this.duration;
                this.this$0.anim.interruptible = this.interruptible;
                this.this$0.anim.easing = this.easing;
                this.this$0.anim.time = System.currentTimeMillis();
                PointF pointF3 = this.vFocus;
                if (pointF3 != null) {
                    float f = pointF3.x - (this.this$0.anim.sCenterStart.x * limitedScale);
                    float f2 = this.vFocus.y - (this.this$0.anim.sCenterStart.y * limitedScale);
                    ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f, f2), null);
                    this.this$0.fitToBounds(true, scaleAndTranslate);
                    this.this$0.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f2));
                }
                this.this$0.invalidate();
            }
        }

        public AnimationBuilder withEasing(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i))) {
                    this.easing = i;
                    return this;
                }
                throw new IllegalArgumentException("Unknown easing type: " + i);
            }
            return (AnimationBuilder) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class BitmapLoadTask extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap bitmap;
        public final WeakReference contextRef;
        public final WeakReference decoderFactoryRef;
        public Exception exception;
        public final boolean preview;
        public final Uri source;
        public final WeakReference viewRef;

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory decoderFactory, Uri uri, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, context, decoderFactory, uri, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewRef = new WeakReference(subsamplingScaleImageView);
            this.contextRef = new WeakReference(context);
            this.decoderFactoryRef = new WeakReference(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    String uri = this.source.toString();
                    Context context = (Context) this.contextRef.get();
                    DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                    SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                    if (context != null && decoderFactory != null && subsamplingScaleImageView != null) {
                        this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                        return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(uri));
                    }
                    return null;
                } catch (Exception e) {
                    Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e);
                    this.exception = e;
                    return null;
                }
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) && (subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get()) != null) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                    } else {
                        subsamplingScaleImageView.onImageLoaded(bitmap, num.intValue());
                    }
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                    } else {
                        subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class DefaultOnImageEventListener implements OnImageEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            }
        }

        public DefaultOnImageEventListener() {
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
    }

    /* loaded from: classes7.dex */
    public class ScaleAndTranslate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float scale;
        public PointF vTranslate;

        public ScaleAndTranslate(float f, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), pointF};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scale = f;
            this.vTranslate = pointF;
        }

        public /* synthetic */ ScaleAndTranslate(float f, PointF pointF, ScaleAndTranslate scaleAndTranslate) {
            this(f, pointF);
        }
    }

    /* loaded from: classes7.dex */
    public class Tile {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap bitmap;
        public Rect fileSRect;
        public boolean loading;
        public Rect sRect;
        public int sampleSize;
        public Rect vRect;
        public boolean visible;

        public Tile() {
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

        public /* synthetic */ Tile(Tile tile) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class TileLoadTask extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference decoderRef;
        public Exception exception;
        public final WeakReference tileRef;
        public final WeakReference viewRef;

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, imageRegionDecoder, tile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewRef = new WeakReference(subsamplingScaleImageView);
            this.decoderRef = new WeakReference(imageRegionDecoder);
            this.tileRef = new WeakReference(tile);
            tile.loading = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeRegion;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                    ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) this.decoderRef.get();
                    Tile tile = (Tile) this.tileRef.get();
                    if (imageRegionDecoder != null && tile != null && subsamplingScaleImageView != null && imageRegionDecoder.isReady()) {
                        synchronized (subsamplingScaleImageView.decoderLock) {
                            subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                            if (subsamplingScaleImageView.sRegion != null) {
                                tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                            }
                            decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                        }
                        return decodeRegion;
                    } else if (tile == null) {
                        return null;
                    } else {
                        tile.loading = false;
                        return null;
                    }
                } catch (Exception e) {
                    Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e);
                    this.exception = e;
                    return null;
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                    this.exception = new Exception(e2.getMessage());
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                Tile tile = (Tile) this.tileRef.get();
                if (subsamplingScaleImageView != null && tile != null) {
                    if (bitmap != null) {
                        tile.bitmap = bitmap;
                        tile.loading = false;
                        subsamplingScaleImageView.onTileLoaded();
                    } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class TilesInitTask extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference contextRef;
        public ImageRegionDecoder decoder;
        public final WeakReference decoderFactoryRef;
        public Exception exception;
        public final Uri source;
        public final WeakReference viewRef;

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory decoderFactory, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, context, decoderFactory, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewRef = new WeakReference(subsamplingScaleImageView);
            this.contextRef = new WeakReference(context);
            this.decoderFactoryRef = new WeakReference(decoderFactory);
            this.source = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public int[] doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    String uri = this.source.toString();
                    Context context = (Context) this.contextRef.get();
                    DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                    SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                    if (context != null && decoderFactory != null && subsamplingScaleImageView != null) {
                        ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                        this.decoder = imageRegionDecoder;
                        Point init = imageRegionDecoder.init(context, this.source);
                        int i = init.x;
                        int i2 = init.y;
                        int exifOrientation = subsamplingScaleImageView.getExifOrientation(uri);
                        if (subsamplingScaleImageView.sRegion != null) {
                            i = subsamplingScaleImageView.sRegion.width();
                            i2 = subsamplingScaleImageView.sRegion.height();
                        }
                        return new int[]{i, i2, exifOrientation};
                    }
                    return null;
                } catch (Exception e) {
                    Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e);
                    this.exception = e;
                    return null;
                }
            }
            return (int[]) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) && (subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get()) != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder == null || iArr == null || iArr.length != 3) {
                    if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                        return;
                    }
                    return;
                }
                subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1316079985, "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1316079985, "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;");
                return;
            }
        }
        TAG = SubsamplingScaleImageView.class.getSimpleName();
        VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
        VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3, 4);
        VALID_EASING_STYLES = Arrays.asList(2, 1);
        VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
        VALID_SCALE_TYPES = Arrays.asList(2, 1, 3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubsamplingScaleImageView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void restoreState(ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65607, this, imageViewState) == null) && imageViewState != null && imageViewState.getCenter() != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    public final void setMinimumScaleType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
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
    }

    public void setMinimumTileDpi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i);
            if (isReady()) {
                reset(false);
                invalidate();
            }
        }
    }

    public final void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            if (VALID_ORIENTATIONS.contains(Integer.valueOf(i))) {
                this.orientation = i;
                reset(false);
                invalidate();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Invalid orientation: " + i);
        }
    }

    public final void setPanLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        this.handler = new Handler(new Handler.Callback(this) { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SubsamplingScaleImageView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    if (message.what == 1 && this.this$0.onLongClickListener != null) {
                        this.this$0.maxTouchCount = 0;
                        SubsamplingScaleImageView subsamplingScaleImageView = this.this$0;
                        SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                        this.this$0.performLongClick();
                        SubsamplingScaleImageView.super.setOnLongClickListener(null);
                    }
                    return true;
                }
                return invokeL.booleanValue;
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

    public AnimationBuilder animateScaleAndCenter(float f, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), pointF})) == null) {
            if (!isReady()) {
                return null;
            }
            return new AnimationBuilder(this, f, pointF, (AnimationBuilder) null);
        }
        return (AnimationBuilder) invokeCommon.objValue;
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, imageSource, imageSource2) == null) {
            setImage(imageSource, imageSource2, null);
        }
    }

    public final void setScaleAndCenter(float f, PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Float.valueOf(f), pointF}) == null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(f);
            this.sPendingCenter = pointF;
            this.sRequestedCenter = pointF;
            invalidate();
        }
    }

    public final PointF sourceToViewCoord(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return sourceToViewCoord(f, f2, new PointF());
        }
        return (PointF) invokeCommon.objValue;
    }

    public final PointF viewToSourceCoord(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return viewToSourceCoord(f, f2, new PointF());
        }
        return (PointF) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65598, this, f)) == null) {
            return Math.min(this.maxScale, Math.max(minScale(), f));
        }
        return invokeF.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65610, this, context) != null) || context == null) {
            return;
        }
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(this, context) { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SubsamplingScaleImageView this$0;
            public final /* synthetic */ Context val$context;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context};
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
                this.val$context = context;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                    if (!this.this$0.zoomEnabled || !this.this$0.readySent || this.this$0.vTranslate == null) {
                        return super.onDoubleTapEvent(motionEvent);
                    }
                    this.this$0.setGestureDetector(this.val$context);
                    if (!this.this$0.quickScaleEnabled) {
                        SubsamplingScaleImageView subsamplingScaleImageView = this.this$0;
                        subsamplingScaleImageView.doubleTapZoom(subsamplingScaleImageView.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                        return true;
                    }
                    this.this$0.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    this.this$0.vTranslateStart = new PointF(this.this$0.vTranslate.x, this.this$0.vTranslate.y);
                    SubsamplingScaleImageView subsamplingScaleImageView2 = this.this$0;
                    subsamplingScaleImageView2.scaleStart = subsamplingScaleImageView2.scale;
                    this.this$0.isQuickScaling = true;
                    this.this$0.isZooming = true;
                    SubsamplingScaleImageView subsamplingScaleImageView3 = this.this$0;
                    subsamplingScaleImageView3.quickScaleCenter = subsamplingScaleImageView3.viewToSourceCoord(subsamplingScaleImageView3.vCenterStart);
                    this.this$0.quickScaleLastDistance = -1.0f;
                    this.this$0.quickScaleLastPoint = new PointF(this.this$0.quickScaleCenter.x, this.this$0.quickScaleCenter.y);
                    this.this$0.quickScaleMoved = false;
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                    if (this.this$0.mIScrollDistanceCallBack != null) {
                        this.this$0.mIScrollDistanceCallBack.onMove(motionEvent, motionEvent2, this.this$0.vTranslate, f, f2);
                    }
                    if (this.this$0.panEnabled && this.this$0.readySent && this.this$0.vTranslate != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f) > 500.0f || Math.abs(f2) > 500.0f) && !this.this$0.isZooming))) {
                        PointF pointF = new PointF(this.this$0.vTranslate.x + (f * 0.25f), this.this$0.vTranslate.y + (f2 * 0.25f));
                        new AnimationBuilder(this.this$0, new PointF(((this.this$0.getWidth() / 2) - pointF.x) / this.this$0.scale, ((this.this$0.getHeight() / 2) - pointF.y) / this.this$0.scale), (AnimationBuilder) null).withEasing(1).withPanLimited(false).start();
                        return true;
                    }
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                    this.this$0.performClick();
                    return true;
                }
                return invokeL.booleanValue;
            }
        });
    }

    private float sourceToViewX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65613, this, f)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f * this.scale) + pointF.x;
        }
        return invokeF.floatValue;
    }

    private float sourceToViewY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65614, this, f)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f * this.scale) + pointF.y;
        }
        return invokeF.floatValue;
    }

    private float viewToSourceX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65617, this, f)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f - pointF.x) / this.scale;
        }
        return invokeF.floatValue;
    }

    private float viewToSourceY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65618, this, f)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f - pointF.y) / this.scale;
        }
        return invokeF.floatValue;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pointF)) == null) {
            if (!isReady()) {
                return null;
            }
            return new AnimationBuilder(this, pointF, (AnimationBuilder) null);
        }
        return (AnimationBuilder) invokeL.objValue;
    }

    public AnimationBuilder animateScale(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            if (!isReady()) {
                return null;
            }
            return new AnimationBuilder(this, f, (AnimationBuilder) null);
        }
        return (AnimationBuilder) invokeF.objValue;
    }

    public final void setBitmapDecoderClass(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cls) == null) {
            if (cls != null) {
                this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
    }

    public final void setBitmapDecoderFactory(DecoderFactory decoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, decoderFactory) == null) {
            if (decoderFactory != null) {
                this.bitmapDecoderFactory = decoderFactory;
                return;
            }
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
    }

    public final void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.debug = z;
        }
    }

    public final void setDoubleTapZoomDpi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
        }
    }

    public final void setDoubleTapZoomScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f) == null) {
            this.doubleTapZoomScale = f;
        }
    }

    public final void setDoubleTapZoomStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i))) {
                this.doubleTapZoomStyle = i;
                return;
            }
            throw new IllegalArgumentException("Invalid zoom style: " + i);
        }
    }

    public void setIScrollDistanceCallBack(IScrollDistanceCallBack iScrollDistanceCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, iScrollDistanceCallBack) == null) {
            this.mIScrollDistanceCallBack = iScrollDistanceCallBack;
        }
    }

    public final void setImage(ImageSource imageSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, imageSource) == null) {
            setImage(imageSource, null, null);
        }
    }

    public void setInitScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f) == null) {
            this.mInitScale = Float.valueOf(f);
        }
    }

    public final void setMaxScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f) == null) {
            this.maxScale = f;
        }
    }

    public final void setMaximumDpi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
        }
    }

    public final void setMinScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f) == null) {
            this.minScale = f;
        }
    }

    public final void setMinimumDpi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onImageEventListener) == null) {
            this.onImageEventListener = onImageEventListener;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onLongClickListener) == null) {
            this.onLongClickListener = onLongClickListener;
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.quickScaleEnabled = z;
        }
    }

    public final void setRegionDecoderClass(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, cls) == null) {
            if (cls != null) {
                this.regionDecoderFactory = new CompatDecoderFactory(cls);
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
    }

    public final void setRegionDecoderFactory(DecoderFactory decoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, decoderFactory) == null) {
            if (decoderFactory != null) {
                this.regionDecoderFactory = decoderFactory;
                return;
            }
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
    }

    public final void setTileBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
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
    }

    public final void setZoomEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.zoomEnabled = z;
        }
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, pointF)) == null) {
            return sourceToViewCoord(pointF.x, pointF.y, new PointF());
        }
        return (PointF) invokeL.objValue;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, pointF)) == null) {
            return viewToSourceCoord(pointF.x, pointF.y, new PointF());
        }
        return (PointF) invokeL.objValue;
    }

    private boolean checkImageLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private int getRequiredRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) {
            int i = this.orientation;
            if (i == -1) {
                return this.sOrientation;
            }
            return i;
        }
        return invokeV.intValue;
    }

    private int sHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, this)) == null) {
            int requiredRotation = getRequiredRotation();
            if (requiredRotation != 90 && requiredRotation != 270) {
                return this.sHeight;
            }
            return this.sWidth;
        }
        return invokeV.intValue;
    }

    private int sWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, this)) == null) {
            int requiredRotation = getRequiredRotation();
            if (requiredRotation != 90 && requiredRotation != 270) {
                return this.sWidth;
            }
            return this.sHeight;
        }
        return invokeV.intValue;
    }

    public final int getAppliedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getRequiredRotation();
        }
        return invokeV.intValue;
    }

    public final PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
        }
        return (PointF) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.maxScale;
        }
        return invokeV.floatValue;
    }

    public final float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return minScale();
        }
        return invokeV.floatValue;
    }

    public final int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.orientation;
        }
        return invokeV.intValue;
    }

    public final int getSHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.sHeight;
        }
        return invokeV.intValue;
    }

    public final int getSWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.sWidth;
        }
        return invokeV.intValue;
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.scale;
        }
        return invokeV.floatValue;
    }

    public boolean isCanDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.scale == this.norScale) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isImageLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.imageLoadedSent;
        }
        return invokeV.booleanValue;
    }

    public final boolean isPanEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.panEnabled;
        }
        return invokeV.booleanValue;
    }

    public final boolean isQuickScaleEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.quickScaleEnabled;
        }
        return invokeV.booleanValue;
    }

    public final boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.readySent;
        }
        return invokeV.booleanValue;
    }

    public boolean isViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.vTranslate.y == 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isZoomEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.zoomEnabled;
        }
        return invokeV.booleanValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            reset(true);
            this.bitmapPaint = null;
            this.debugPaint = null;
            this.tileBgPaint = null;
        }
    }

    private int calculateInSampleSize(float f) {
        InterceptResult invokeF;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65579, this, f)) == null) {
            if (this.minimumTileDpi > 0) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                f *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
            }
            int sWidth = (int) (sWidth() * f);
            int sHeight = (int) (sHeight() * f);
            if (sWidth != 0 && sHeight != 0) {
                int i = 1;
                if (sHeight() <= sHeight && sWidth() <= sWidth) {
                    round = 1;
                } else {
                    round = Math.round(sHeight() / sHeight);
                    int round2 = Math.round(sWidth() / sWidth);
                    if (round >= round2) {
                        round = round2;
                    }
                }
                while (true) {
                    int i2 = i * 2;
                    if (i2 >= round) {
                        return i;
                    }
                    i = i2;
                }
            } else {
                return 32;
            }
        } else {
            return invokeF.intValue;
        }
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65589, this, z) == null) {
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
            float f = this.satTemp.scale;
            this.scale = f;
            if (this.norScale == 0.0f) {
                this.norScale = f;
            }
            this.vTranslate.set(this.satTemp.vTranslate);
            if (z2) {
                this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExifOrientation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, this, str)) == null) {
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
        return invokeL.intValue;
    }

    private synchronized void initialiseBaseLayer(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65594, this, point) == null) {
            synchronized (this) {
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
                this.satTemp = scaleAndTranslate;
                fitToBounds(true, scaleAndTranslate);
                int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
                this.fullImageSampleSize = calculateInSampleSize;
                if (calculateInSampleSize > 1) {
                    this.fullImageSampleSize = calculateInSampleSize / 2;
                }
                initialiseTileMap(point);
                for (Tile tile : (List) this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                    TileLoadTask tileLoadTask = new TileLoadTask(this, this.decoder, tile);
                    tileLoadTask.setPriority(3);
                    tileLoadTask.execute(new Void[0]);
                }
                refreshRequiredTiles(true);
            }
        }
    }

    private boolean checkReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) {
            if (getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady())) {
                z = true;
            } else {
                z = false;
            }
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
        return invokeV.booleanValue;
    }

    private void createPaints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
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
    }

    private float distance(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = f - f2;
            float f6 = f3 - f4;
            return FloatMath.sqrt((f5 * f5) + (f6 * f6));
        }
        return invokeCommon.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        boolean z;
        float minScale;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, this, pointF, pointF2) == null) {
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
            if (this.scale <= min * 0.9d) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                minScale = min;
            } else {
                minScale = minScale();
            }
            int i = this.doubleTapZoomStyle;
            if (i == 4) {
                if (!z) {
                    min = this.mInitScale.floatValue();
                }
                new AnimationBuilder(this, min, pointF, (AnimationBuilder) null).withInterruptible(false).start();
            } else if (i == 3) {
                setScaleAndCenter(minScale, pointF);
            } else if (i != 2 && z && this.panEnabled) {
                if (i == 1) {
                    new AnimationBuilder(this, minScale, pointF, pointF2, null).withInterruptible(false).start();
                }
            } else {
                new AnimationBuilder(this, minScale, pointF, (AnimationBuilder) null).withInterruptible(false).start();
            }
            invalidate();
        }
    }

    private float ease(int i, long j, float f, float f2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j2)})) == null) {
            if (i != 1) {
                if (i == 2) {
                    return easeInOutQuad(j, f, f2, j2);
                }
                throw new IllegalStateException("Unexpected easing type: " + i);
            }
            return easeOutQuad(j, f, f2, j2);
        }
        return invokeCommon.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65588, this, rect, rect2) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65600, this, bitmap, i) == null) {
            synchronized (this) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float paddingLeft;
        float max;
        int max2;
        float max3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65590, this, z, scaleAndTranslate) == null) {
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
            float f = 0.5f;
            if (getPaddingLeft() <= 0 && getPaddingRight() <= 0) {
                paddingLeft = 0.5f;
            } else {
                paddingLeft = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
            }
            if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
                f = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
            }
            if (this.panLimit == 3 && isReady()) {
                max = Math.max(0, getWidth() / 2);
                max2 = Math.max(0, getHeight() / 2);
            } else if (z) {
                max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
                max3 = Math.max(0.0f, (getHeight() - sHeight) * f);
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
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, this, canvas)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    return new Point(((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue(), ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue());
                } catch (Exception unused) {
                }
            }
            return new Point(2048, 2048);
        }
        return (Point) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65601, this, bitmap) == null) {
            synchronized (this) {
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
        }
    }

    private boolean tileVisible(Tile tile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, this, tile)) == null) {
            float viewToSourceX = viewToSourceX(0.0f);
            float viewToSourceX2 = viewToSourceX(getWidth());
            float viewToSourceY = viewToSourceY(0.0f);
            float viewToSourceY2 = viewToSourceY(getHeight());
            if (viewToSourceX <= tile.sRect.right && tile.sRect.left <= viewToSourceX2 && viewToSourceY <= tile.sRect.bottom && tile.sRect.top <= viewToSourceY2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.panEnabled = z;
            if (!z && (pointF = this.vTranslate) != null) {
                pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
                this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
                if (isReady()) {
                    refreshRequiredTiles(true);
                    invalidate();
                }
            }
        }
    }

    private void initialiseTileMap(Point point) {
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65595, this, point) == null) {
            this.tileMap = new LinkedHashMap();
            int i3 = this.fullImageSampleSize;
            int i4 = 1;
            int i5 = 1;
            int i6 = 1;
            while (true) {
                int sWidth = sWidth() / i5;
                int sHeight = sHeight() / i6;
                int i7 = sWidth / i3;
                int i8 = sHeight / i3;
                while (true) {
                    if (i7 + i5 + i4 > point.x || (i7 > getWidth() * 1.25d && i3 < this.fullImageSampleSize)) {
                        i5++;
                        sWidth = sWidth() / i5;
                        i7 = sWidth / i3;
                        i4 = 1;
                    }
                }
                while (true) {
                    if (i8 + i6 + i4 > point.y || (i8 > getHeight() * 1.25d && i3 < this.fullImageSampleSize)) {
                        i6++;
                        sHeight = sHeight() / i6;
                        i8 = sHeight / i3;
                        i4 = 1;
                    }
                }
                ArrayList arrayList = new ArrayList(i5 * i6);
                for (int i9 = 0; i9 < i5; i9++) {
                    int i10 = 0;
                    while (i10 < i6) {
                        Tile tile = new Tile(null);
                        tile.sampleSize = i3;
                        if (i3 == this.fullImageSampleSize) {
                            z = true;
                        } else {
                            z = false;
                        }
                        tile.visible = z;
                        int i11 = i9 * sWidth;
                        int i12 = i10 * sHeight;
                        if (i9 == i5 - 1) {
                            i = sWidth();
                        } else {
                            i = (i9 + 1) * sWidth;
                        }
                        if (i10 == i6 - 1) {
                            i2 = sHeight();
                        } else {
                            i2 = (i10 + 1) * sHeight;
                        }
                        tile.sRect = new Rect(i11, i12, i, i2);
                        tile.vRect = new Rect(0, 0, 0, 0);
                        tile.fileSRect = new Rect(tile.sRect);
                        arrayList.add(tile);
                        i10++;
                        i4 = 1;
                    }
                }
                this.tileMap.put(Integer.valueOf(i3), arrayList);
                if (i3 == i4) {
                    return;
                }
                i3 /= 2;
            }
        }
    }

    private void refreshRequiredTiles(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65605, this, z) == null) && this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry entry : this.tileMap.entrySet()) {
                for (Tile tile : (List) entry.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
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
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        tile.visible = true;
                    }
                }
            }
        }
    }

    private boolean isBaseLayerReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, this)) == null) {
            boolean z = true;
            if (this.bitmap != null && !this.preview) {
                return true;
            }
            Map map = this.tileMap;
            if (map == null) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                if (((Integer) entry.getKey()).intValue() == this.fullImageSampleSize) {
                    for (Tile tile : (List) entry.getValue()) {
                        if (tile.loading || tile.bitmap == null) {
                            z = false;
                        }
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private float minScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, this)) == null) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i = this.minimumScaleType;
            if (i == 2) {
                return Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
            }
            if (i == 3) {
                float f = this.minScale;
                if (f > 0.0f) {
                    return f;
                }
            }
            return Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        return invokeV.floatValue;
    }

    private void preDraw() {
        Float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65604, this) == null) && getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (this.sPendingCenter != null && (f = this.pendingScale) != null) {
                float floatValue = f.floatValue();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF limitedSCenter(float f, float f2, float f3, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65597, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), pointF})) == null) {
            PointF vTranslateForSCenter = vTranslateForSCenter(f, f2, f3);
            pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - vTranslateForSCenter.x) / f3, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - vTranslateForSCenter.y) / f3);
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65602, this) == null) {
            synchronized (this) {
                checkReady();
                checkImageLoaded();
                if (isBaseLayerReady() && this.bitmap != null) {
                    this.bitmap.recycle();
                    this.bitmap = null;
                    this.preview = false;
                }
                invalidate();
            }
        }
    }

    public final ImageViewState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.vTranslate != null && this.sWidth > 0 && this.sHeight > 0) {
                return new ImageViewState(getScale(), getCenter(), getOrientation());
            }
            return null;
        }
        return (ImageViewState) invokeV.objValue;
    }

    public final void resetScaleAndCenter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(limitedScale(0.0f));
            if (isReady()) {
                this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
            } else {
                this.sPendingCenter = new PointF(0.0f, 0.0f);
            }
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65603, this, imageRegionDecoder, i, i2, i3) == null) {
            synchronized (this) {
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
        }
    }

    private void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65606, this, z) == null) {
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
            Map map = this.tileMap;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    for (Tile tile : (List) entry.getValue()) {
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
    }

    private void setMatrixArray(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65611, this, new Object[]{fArr, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)}) == null) {
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f4;
            fArr[4] = f5;
            fArr[5] = f6;
            fArr[6] = f7;
            fArr[7] = f8;
        }
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65612, this, rect, rect2)) == null) {
            rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
            return rect2;
        }
        return (Rect) invokeLL.objValue;
    }

    private PointF vTranslateForSCenter(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65616, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
            int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            if (this.satTemp == null) {
                this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.satTemp.scale = f3;
            this.satTemp.vTranslate.set(paddingLeft - (f * f3), paddingTop - (f2 * f3));
            fitToBounds(true, this.satTemp);
            return this.satTemp.vTranslate;
        }
        return (PointF) invokeCommon.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f;
        int i;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, canvas) == null) {
            super.onDraw(canvas);
            createPaints();
            if (this.sWidth != 0 && this.sHeight != 0 && getWidth() != 0 && getHeight() != 0) {
                if (this.tileMap == null && this.decoder != null) {
                    initialiseBaseLayer(getMaxBitmapDimensions(canvas));
                }
                if (!checkReady()) {
                    return;
                }
                preDraw();
                int i2 = 1;
                char c = 0;
                if (this.anim != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                    if (currentTimeMillis > this.anim.duration) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long min = Math.min(currentTimeMillis, this.anim.duration);
                    this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                    float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                    float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                    this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                    this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                    if (!z && this.anim.scaleStart != this.anim.scaleEnd) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    fitToBounds(z2);
                    refreshRequiredTiles(z);
                    if (z) {
                        this.anim = null;
                    }
                    invalidate();
                }
                if (this.tileMap != null && isBaseLayerReady()) {
                    int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                    boolean z3 = false;
                    for (Map.Entry entry : this.tileMap.entrySet()) {
                        int i3 = min2;
                        if (((Integer) entry.getKey()).intValue() == i3) {
                            for (Tile tile : (List) entry.getValue()) {
                                if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                    z3 = true;
                                }
                            }
                        }
                        min2 = i3;
                        i2 = 1;
                        c = 0;
                    }
                    for (Map.Entry entry2 : this.tileMap.entrySet()) {
                        if (((Integer) entry2.getKey()).intValue() == min2 || z3) {
                            for (Tile tile2 : (List) entry2.getValue()) {
                                sourceToViewRect(tile2.sRect, tile2.vRect);
                                if (!tile2.loading && tile2.bitmap != null) {
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
                                } else {
                                    i = min2;
                                    if (tile2.loading && this.debug) {
                                        canvas.drawText("LOADING", tile2.vRect.left + 5, tile2.vRect.top + 35, this.debugPaint);
                                    }
                                }
                                if (tile2.visible && this.debug) {
                                    canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, tile2.vRect.left + 5, tile2.vRect.top + 15, this.debugPaint);
                                }
                                min2 = i;
                                i2 = 1;
                                c = 0;
                            }
                        }
                    }
                    if (this.debug) {
                        StringBuilder sb = new StringBuilder("Scale: ");
                        Object[] objArr = new Object[i2];
                        objArr[c] = Float.valueOf(this.scale);
                        sb.append(String.format("%.2f", objArr));
                        canvas.drawText(sb.toString(), 5.0f, 15.0f, this.debugPaint);
                        StringBuilder sb2 = new StringBuilder("Translate: ");
                        Object[] objArr2 = new Object[i2];
                        objArr2[c] = Float.valueOf(this.vTranslate.x);
                        sb2.append(String.format("%.2f", objArr2));
                        sb2.append(":");
                        Object[] objArr3 = new Object[i2];
                        objArr3[c] = Float.valueOf(this.vTranslate.y);
                        sb2.append(String.format("%.2f", objArr3));
                        canvas.drawText(sb2.toString(), 5.0f, 35.0f, this.debugPaint);
                        PointF center = getCenter();
                        StringBuilder sb3 = new StringBuilder("Source center: ");
                        Object[] objArr4 = new Object[i2];
                        objArr4[c] = Float.valueOf(center.x);
                        sb3.append(String.format("%.2f", objArr4));
                        sb3.append(":");
                        Object[] objArr5 = new Object[i2];
                        objArr5[c] = Float.valueOf(center.y);
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
                    float f2 = this.scale;
                    if (this.preview) {
                        f2 *= this.sWidth / bitmap.getWidth();
                        f = this.scale * (this.sHeight / this.bitmap.getHeight());
                    } else {
                        f = f2;
                    }
                    if (this.matrix == null) {
                        this.matrix = new Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(f2, f);
                    this.matrix.postRotate(getOrientation());
                    Matrix matrix = this.matrix;
                    PointF pointF = this.vTranslate;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getOrientation() == 180) {
                        Matrix matrix2 = this.matrix;
                        float f3 = this.scale;
                        matrix2.postTranslate(this.sWidth * f3, f3 * this.sHeight);
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
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            boolean z2 = true;
            if (mode != 1073741824) {
                z = true;
            } else {
                z = false;
            }
            if (mode2 == 1073741824) {
                z2 = false;
            }
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
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i, i2, i3, i4) == null) {
            PointF center = getCenter();
            if (this.readySent && center != null) {
                this.anim = null;
                this.pendingScale = Float.valueOf(this.scale);
                this.sPendingCenter = center;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0088, code lost:
        if (r5 != 262) goto L42;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        GestureDetector gestureDetector;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            Anim anim = this.anim;
            if (anim != null && !anim.interruptible) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            this.anim = null;
            if (this.vTranslate == null) {
                return true;
            }
            boolean z5 = false;
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
                    if (action != 2) {
                        if (action != 5) {
                            if (action != 6) {
                                if (action != 261) {
                                }
                            }
                        }
                    } else {
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
                                            float f = pointF2.x;
                                            PointF pointF3 = this.vTranslateStart;
                                            float f2 = f - pointF3.x;
                                            float f3 = pointF2.y - pointF3.y;
                                            float f4 = this.scale;
                                            float f5 = this.scaleStart;
                                            float f6 = f3 * (f4 / f5);
                                            PointF pointF4 = this.vTranslate;
                                            pointF4.x = x - (f2 * (f4 / f5));
                                            pointF4.y = y - f6;
                                        } else if (this.sRequestedCenter != null) {
                                            this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
                                            this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
                                        } else {
                                            this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
                                            this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
                                        }
                                        fitToBounds(true);
                                        refreshRequiredTiles(false);
                                        z5 = true;
                                    }
                                }
                            } else {
                                if (this.isQuickScaling) {
                                    float abs = (Math.abs(this.vCenterStart.y - motionEvent.getY()) * 2.0f) + this.quickScaleThreshold;
                                    if (this.quickScaleLastDistance == -1.0f) {
                                        this.quickScaleLastDistance = abs;
                                    }
                                    if (motionEvent.getY() > this.quickScaleLastPoint.y) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    this.quickScaleLastPoint.set(0.0f, motionEvent.getY());
                                    float f7 = 1.0f;
                                    float abs2 = Math.abs(1.0f - (abs / this.quickScaleLastDistance)) * 0.5f;
                                    if (abs2 > 0.03f || this.quickScaleMoved) {
                                        this.quickScaleMoved = true;
                                        if (this.quickScaleLastDistance > 0.0f) {
                                            if (z4) {
                                                f7 = abs2 + 1.0f;
                                            } else {
                                                f7 = 1.0f - abs2;
                                            }
                                        }
                                        float max = Math.max(minScale(), Math.min(this.maxScale, this.scale * f7));
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
                                        if (f12 != this.vTranslate.x) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z && abs3 > abs4 && !this.isPanning) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (f13 == this.vTranslate.y && abs4 > 15.0f) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (!z2 && (!z || z3 || this.isPanning)) {
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
                                z5 = true;
                            }
                        }
                        if (z5) {
                            this.handler.removeMessages(1);
                            invalidate();
                            return true;
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
                if (this.maxTouchCount > 0 && (this.isZooming || this.isPanning)) {
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
                if (pointerCount == 1) {
                    this.isZooming = false;
                    this.isPanning = false;
                    this.maxTouchCount = 0;
                }
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
        return invokeL.booleanValue;
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, imageSource, imageSource2, imageViewState) == null) {
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
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, imageSource, imageViewState) == null) {
            setImage(imageSource, null, imageViewState);
        }
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048635, this, pointF, pointF2)) == null) {
            return sourceToViewCoord(pointF.x, pointF.y, pointF2);
        }
        return (PointF) invokeLL.objValue;
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048639, this, pointF, pointF2)) == null) {
            return viewToSourceCoord(pointF.x, pointF.y, pointF2);
        }
        return (PointF) invokeLL.objValue;
    }

    public final PointF sourceToViewCoord(float f, float f2, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), pointF})) == null) {
            if (this.vTranslate == null) {
                return null;
            }
            pointF.set(sourceToViewX(f), sourceToViewY(f2));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final PointF viewToSourceCoord(float f, float f2, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), pointF})) == null) {
            if (this.vTranslate == null) {
                return null;
            }
            pointF.set(viewToSourceX(f), viewToSourceY(f2));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }
}
