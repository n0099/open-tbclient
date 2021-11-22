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
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes11.dex */
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
    public static final List<Integer> VALID_EASING_STYLES;
    public static final List<Integer> VALID_ORIENTATIONS;
    public static final List<Integer> VALID_PAN_LIMITS;
    public static final List<Integer> VALID_SCALE_TYPES;
    public static final List<Integer> VALID_ZOOM_STYLES;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_CENTER_IN_TO_MAX_OUT_TO_INIT = 4;
    public static final int ZOOM_FOCUS_FIXED = 1;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes11.dex */
    public static class BitmapLoadTask extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap bitmap;
        public final WeakReference<Context> contextRef;
        public final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        public Exception exception;
        public final boolean preview;
        public final Uri source;
        public final WeakReference<SubsamplingScaleImageView> viewRef;

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, context, decoderFactory, uri, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
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
                    Context context = this.contextRef.get();
                    DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                    SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                    if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                        return null;
                    }
                    this.bitmap = decoderFactory.make().decode(context, this.source);
                    return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(uri));
                } catch (Exception e2) {
                    String unused = SubsamplingScaleImageView.TAG;
                    this.exception = e2;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) || (subsamplingScaleImageView = this.viewRef.get()) == null) {
                return;
            }
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

    /* loaded from: classes11.dex */
    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultOnImageEventListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

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
    }

    /* loaded from: classes11.dex */
    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* loaded from: classes11.dex */
    public static class Tile {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Tile(Tile tile) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public static class TileLoadTask extends BdAsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ImageRegionDecoder> decoderRef;
        public Exception exception;
        public final WeakReference<Tile> tileRef;
        public final WeakReference<SubsamplingScaleImageView> viewRef;

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, imageRegionDecoder, tile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
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
                    String unused = SubsamplingScaleImageView.TAG;
                    this.exception = e2;
                    return null;
                } catch (OutOfMemoryError e3) {
                    e3.printStackTrace();
                    this.exception = new Exception(e3.getMessage());
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
    }

    /* loaded from: classes11.dex */
    public static class TilesInitTask extends BdAsyncTask<Void, Void, int[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<Context> contextRef;
        public ImageRegionDecoder decoder;
        public final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        public Exception exception;
        public final Uri source;
        public final WeakReference<SubsamplingScaleImageView> viewRef;

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, context, decoderFactory, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
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
                    Context context = this.contextRef.get();
                    DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                    SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                    if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                        return null;
                    }
                    ImageRegionDecoder make = decoderFactory.make();
                    this.decoder = make;
                    Point init = make.init(context, this.source);
                    int i2 = init.x;
                    int i3 = init.y;
                    int exifOrientation = subsamplingScaleImageView.getExifOrientation(uri);
                    if (subsamplingScaleImageView.sRegion != null) {
                        i2 = subsamplingScaleImageView.sRegion.width();
                        i3 = subsamplingScaleImageView.sRegion.height();
                    }
                    return new int[]{i2, i3, exifOrientation};
                } catch (Exception e2) {
                    String unused = SubsamplingScaleImageView.TAG;
                    this.exception = e2;
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) || (subsamplingScaleImageView = this.viewRef.get()) == null) {
                return;
            }
            ImageRegionDecoder imageRegionDecoder = this.decoder;
            if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
            } else if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
            } else {
                subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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

    private int calculateInSampleSize(float f2) {
        InterceptResult invokeF;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeF = interceptable.invokeF(65579, this, f2)) != null) {
            return invokeF.intValue;
        }
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f2);
        int sHeight = (int) (sHeight() * f2);
        if (sWidth == 0 || sHeight == 0) {
            return 32;
        }
        int i2 = 1;
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
            int i3 = i2 * 2;
            if (i3 >= round) {
                return i2;
            }
            i2 = i3;
        }
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

    private boolean checkReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) {
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

    @SuppressLint({"FloatMath"})
    private float distance(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f2 - f3;
            float f7 = f4 - f5;
            return FloatMath.sqrt((f6 * f6) + (f7 * f7));
        }
        return invokeCommon.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
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
            boolean z = ((double) this.scale) <= ((double) min) * 0.9d;
            float minScale = z ? min : minScale();
            int i2 = this.doubleTapZoomStyle;
            if (i2 == 4) {
                if (!z) {
                    min = this.mInitScale.floatValue();
                }
                new AnimationBuilder(this, min, pointF, (AnimationBuilder) null).withInterruptible(false).start();
            } else if (i2 == 3) {
                setScaleAndCenter(minScale, pointF);
            } else if (i2 == 2 || !z || !this.panEnabled) {
                new AnimationBuilder(this, minScale, pointF, (AnimationBuilder) null).withInterruptible(false).start();
            } else if (i2 == 1) {
                new AnimationBuilder(this, minScale, pointF, pointF2, null).withInterruptible(false).start();
            }
            invalidate();
        }
    }

    private float ease(int i2, long j, float f2, float f3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)})) == null) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return easeInOutQuad(j, f2, f3, j2);
                }
                throw new IllegalStateException("Unexpected easing type: " + i2);
            }
            return easeOutQuad(j, f2, f3, j2);
        }
        return invokeCommon.floatValue;
    }

    private float easeInOutQuad(long j, float f2, float f3, long j2) {
        InterceptResult invokeCommon;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65586, this, new Object[]{Long.valueOf(j), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)})) == null) {
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
        return invokeCommon.floatValue;
    }

    private float easeOutQuad(long j, float f2, float f3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65587, this, new Object[]{Long.valueOf(j), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)})) == null) {
            float f4 = ((float) j) / ((float) j2);
            return ((-f3) * f4 * (f4 - 2.0f)) + f2;
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
                int i2 = rect.top;
                int i3 = this.sHeight;
                rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
            } else if (getRequiredRotation() == 180) {
                int i4 = this.sWidth;
                int i5 = this.sHeight;
                rect2.set(i4 - rect.right, i5 - rect.bottom, i4 - rect.left, i5 - rect.top);
            } else {
                int i6 = this.sWidth;
                rect2.set(i6 - rect.bottom, rect.left, i6 - rect.top, rect.right);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
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
                int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
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
                    String str2 = "Unsupported EXIF orientation: " + attributeInt;
                    return 0;
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
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

    private int getRequiredRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) {
            int i2 = this.orientation;
            return i2 == -1 ? this.sOrientation : i2;
        }
        return invokeV.intValue;
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
                for (Tile tile : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                    TileLoadTask tileLoadTask = new TileLoadTask(this, this.decoder, tile);
                    tileLoadTask.setPriority(3);
                    tileLoadTask.execute(new Void[0]);
                }
                refreshRequiredTiles(true);
            }
        }
    }

    private void initialiseTileMap(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65595, this, point) != null) {
            return;
        }
        this.tileMap = new LinkedHashMap();
        int i2 = this.fullImageSampleSize;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int sWidth = sWidth() / i4;
            int sHeight = sHeight() / i5;
            int i6 = sWidth / i2;
            int i7 = sHeight / i2;
            while (true) {
                if (i6 + i4 + i3 > point.x || (i6 > getWidth() * 1.25d && i2 < this.fullImageSampleSize)) {
                    i4++;
                    sWidth = sWidth() / i4;
                    i6 = sWidth / i2;
                    i3 = 1;
                }
            }
            while (true) {
                if (i7 + i5 + i3 > point.y || (i7 > getHeight() * 1.25d && i2 < this.fullImageSampleSize)) {
                    i5++;
                    sHeight = sHeight() / i5;
                    i7 = sHeight / i2;
                    i3 = 1;
                }
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    Tile tile = new Tile(null);
                    tile.sampleSize = i2;
                    tile.visible = i2 == this.fullImageSampleSize;
                    tile.sRect = new Rect(i8 * sWidth, i9 * sHeight, i8 == i4 + (-1) ? sWidth() : (i8 + 1) * sWidth, i9 == i5 + (-1) ? sHeight() : (i9 + 1) * sHeight);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i9++;
                    i3 = 1;
                }
                i8++;
            }
            this.tileMap.put(Integer.valueOf(i2), arrayList);
            if (i2 == i3) {
                return;
            }
            i2 /= 2;
        }
    }

    private boolean isBaseLayerReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, this)) == null) {
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
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF limitedSCenter(float f2, float f3, float f4, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65597, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), pointF})) == null) {
            PointF vTranslateForSCenter = vTranslateForSCenter(f2, f3, f4);
            pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - vTranslateForSCenter.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - vTranslateForSCenter.y) / f4);
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65598, this, f2)) == null) ? Math.min(this.maxScale, Math.max(minScale(), f2)) : invokeF.floatValue;
    }

    private float minScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, this)) == null) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i2 = this.minimumScaleType;
            if (i2 == 2) {
                return Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
            }
            if (i2 == 3) {
                float f2 = this.minScale;
                if (f2 > 0.0f) {
                    return f2;
                }
            }
            return Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        return invokeV.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65600, this, bitmap, i2) == null) {
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
                this.sOrientation = i2;
                if (checkReady() || checkImageLoaded()) {
                    invalidate();
                    requestLayout();
                }
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65603, this, imageRegionDecoder, i2, i3, i4) == null) {
            synchronized (this) {
                if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != i2 || this.sHeight != i3)) {
                    reset(false);
                    if (this.bitmap != null) {
                        this.bitmap.recycle();
                        this.bitmap = null;
                        this.preview = false;
                    }
                }
                this.decoder = imageRegionDecoder;
                this.sWidth = i2;
                this.sHeight = i3;
                this.sOrientation = i4;
                checkReady();
                checkImageLoaded();
                invalidate();
                requestLayout();
            }
        }
    }

    private void preDraw() {
        Float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65604, this) == null) || getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0 || this.sHeight <= 0) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65605, this, z) == null) || this.decoder == null || this.tileMap == null) {
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
    }

    private void restoreState(ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65607, this, imageViewState) == null) || imageViewState == null || imageViewState.getCenter() == null || !VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.orientation = imageViewState.getOrientation();
        this.pendingScale = Float.valueOf(imageViewState.getScale());
        this.sPendingCenter = imageViewState.getCenter();
        invalidate();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65610, this, context) == null) || context == null) {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    if (this.this$0.zoomEnabled && this.this$0.readySent && this.this$0.vTranslate != null) {
                        this.this$0.setGestureDetector(this.val$context);
                        if (this.this$0.quickScaleEnabled) {
                            this.this$0.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                            this.this$0.vTranslateStart = new PointF(this.this$0.vTranslate.x, this.this$0.vTranslate.y);
                            SubsamplingScaleImageView subsamplingScaleImageView = this.this$0;
                            subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                            this.this$0.isQuickScaling = true;
                            this.this$0.isZooming = true;
                            SubsamplingScaleImageView subsamplingScaleImageView2 = this.this$0;
                            subsamplingScaleImageView2.quickScaleCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                            this.this$0.quickScaleLastDistance = -1.0f;
                            this.this$0.quickScaleLastPoint = new PointF(this.this$0.quickScaleCenter.x, this.this$0.quickScaleCenter.y);
                            this.this$0.quickScaleMoved = false;
                            return false;
                        }
                        SubsamplingScaleImageView subsamplingScaleImageView3 = this.this$0;
                        subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                        return true;
                    }
                    return super.onDoubleTapEvent(motionEvent);
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    if (this.this$0.mIScrollDistanceCallBack != null) {
                        this.this$0.mIScrollDistanceCallBack.onMove(motionEvent, motionEvent2, this.this$0.vTranslate, f2, f3);
                    }
                    if (this.this$0.panEnabled && this.this$0.readySent && this.this$0.vTranslate != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f2) > 500.0f || Math.abs(f3) > 500.0f) && !this.this$0.isZooming))) {
                        PointF pointF = new PointF(this.this$0.vTranslate.x + (f2 * 0.25f), this.this$0.vTranslate.y + (f3 * 0.25f));
                        new AnimationBuilder(this.this$0, new PointF(((this.this$0.getWidth() / 2) - pointF.x) / this.this$0.scale, ((this.this$0.getHeight() / 2) - pointF.y) / this.this$0.scale), (AnimationBuilder) null).withEasing(1).withPanLimited(false).start();
                        return true;
                    }
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
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

    private void setMatrixArray(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65611, this, new Object[]{fArr, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)}) == null) {
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f5;
            fArr[4] = f6;
            fArr[5] = f7;
            fArr[6] = f8;
            fArr[7] = f9;
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

    private float sourceToViewX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65613, this, f2)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 * this.scale) + pointF.x;
        }
        return invokeF.floatValue;
    }

    private float sourceToViewY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65614, this, f2)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 * this.scale) + pointF.y;
        }
        return invokeF.floatValue;
    }

    private boolean tileVisible(Tile tile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, this, tile)) == null) {
            return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
        }
        return invokeL.booleanValue;
    }

    private PointF vTranslateForSCenter(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65616, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
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
        return (PointF) invokeCommon.objValue;
    }

    private float viewToSourceX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65617, this, f2)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 - pointF.x) / this.scale;
        }
        return invokeF.floatValue;
    }

    private float viewToSourceY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65618, this, f2)) == null) {
            PointF pointF = this.vTranslate;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 - pointF.y) / this.scale;
        }
        return invokeF.floatValue;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pointF)) == null) {
            if (isReady()) {
                return new AnimationBuilder(this, pointF, (AnimationBuilder) null);
            }
            return null;
        }
        return (AnimationBuilder) invokeL.objValue;
    }

    public AnimationBuilder animateScale(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            if (isReady()) {
                return new AnimationBuilder(this, f2, (AnimationBuilder) null);
            }
            return null;
        }
        return (AnimationBuilder) invokeF.objValue;
    }

    public AnimationBuilder animateScaleAndCenter(float f2, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), pointF})) == null) {
            if (isReady()) {
                return new AnimationBuilder(this, f2, pointF, (AnimationBuilder) null);
            }
            return null;
        }
        return (AnimationBuilder) invokeCommon.objValue;
    }

    public final int getAppliedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getRequiredRotation() : invokeV.intValue;
    }

    public final PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? viewToSourceCoord(getWidth() / 2, getHeight() / 2) : (PointF) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.maxScale : invokeV.floatValue;
    }

    public final float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? minScale() : invokeV.floatValue;
    }

    public final int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.orientation : invokeV.intValue;
    }

    public final int getSHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.sHeight : invokeV.intValue;
    }

    public final int getSWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.sWidth : invokeV.intValue;
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.scale : invokeV.floatValue;
    }

    public final ImageViewState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
                return null;
            }
            return new ImageViewState(getScale(), getCenter(), getOrientation());
        }
        return (ImageViewState) invokeV.objValue;
    }

    public boolean isCanDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.scale == this.norScale : invokeV.booleanValue;
    }

    public final boolean isImageLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.imageLoadedSent : invokeV.booleanValue;
    }

    public final boolean isPanEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.panEnabled : invokeV.booleanValue;
    }

    public final boolean isQuickScaleEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.quickScaleEnabled : invokeV.booleanValue;
    }

    public final boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.readySent : invokeV.booleanValue;
    }

    public boolean isViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.vTranslate.y == 0.0f : invokeV.booleanValue;
    }

    public final boolean isZoomEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.zoomEnabled : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, canvas) == null) {
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
                int i3 = 1;
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
                        int i4 = min2;
                        if (entry.getKey().intValue() == i4) {
                            for (Tile tile : entry.getValue()) {
                                if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                    z2 = true;
                                }
                            }
                        }
                        min2 = i4;
                        i3 = 1;
                        c2 = 0;
                    }
                    for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
                        if (entry2.getKey().intValue() == min2 || z2) {
                            for (Tile tile2 : entry2.getValue()) {
                                sourceToViewRect(tile2.sRect, tile2.vRect);
                                if (tile2.loading || tile2.bitmap == null) {
                                    i2 = min2;
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
                                    i2 = min2;
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
                                min2 = i2;
                                i3 = 1;
                                c2 = 0;
                            }
                        }
                    }
                    if (this.debug) {
                        StringBuilder sb = new StringBuilder("Scale: ");
                        Object[] objArr = new Object[i3];
                        objArr[c2] = Float.valueOf(this.scale);
                        sb.append(String.format("%.2f", objArr));
                        canvas.drawText(sb.toString(), 5.0f, 15.0f, this.debugPaint);
                        StringBuilder sb2 = new StringBuilder("Translate: ");
                        Object[] objArr2 = new Object[i3];
                        objArr2[c2] = Float.valueOf(this.vTranslate.x);
                        sb2.append(String.format("%.2f", objArr2));
                        sb2.append(":");
                        Object[] objArr3 = new Object[i3];
                        objArr3[c2] = Float.valueOf(this.vTranslate.y);
                        sb2.append(String.format("%.2f", objArr3));
                        canvas.drawText(sb2.toString(), 5.0f, 35.0f, this.debugPaint);
                        PointF center = getCenter();
                        StringBuilder sb3 = new StringBuilder("Source center: ");
                        Object[] objArr4 = new Object[i3];
                        objArr4[c2] = Float.valueOf(center.x);
                        sb3.append(String.format("%.2f", objArr4));
                        sb3.append(":");
                        Object[] objArr5 = new Object[i3];
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
    }

    public void onImageLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
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
    }

    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i2, i3, i4, i5) == null) {
            PointF center = getCenter();
            if (!this.readySent || center == null) {
                return;
            }
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0082, code lost:
        if (r5 != 262) goto L42;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
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
            boolean z = false;
            if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
                if (motionEvent.getAction() == 1) {
                    String str = "action1:detector.onTouchEvent:" + this.detector.onTouchEvent(motionEvent);
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
                                    int i2 = (abs3 > 100.0f ? 1 : (abs3 == 100.0f ? 0 : -1));
                                    if (i2 > 0 || abs4 > 100.0f || this.isPanning) {
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
                                        } else if (i2 > 0) {
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
        return invokeL.booleanValue;
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

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cls) == null) {
            if (cls != null) {
                this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
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

    public final void setDoubleTapZoomDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
        }
    }

    public final void setDoubleTapZoomScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f2) == null) {
            this.doubleTapZoomScale = f2;
        }
    }

    public final void setDoubleTapZoomStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i2))) {
                this.doubleTapZoomStyle = i2;
                return;
            }
            throw new IllegalArgumentException("Invalid zoom style: " + i2);
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

    public void setInitScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
            this.mInitScale = Float.valueOf(f2);
        }
    }

    public final void setMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f2) == null) {
            this.maxScale = f2;
        }
    }

    public final void setMaximumDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
        }
    }

    public final void setMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.minScale = f2;
        }
    }

    public final void setMinimumDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
        }
    }

    public final void setMinimumScaleType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            if (VALID_SCALE_TYPES.contains(Integer.valueOf(i2))) {
                this.minimumScaleType = i2;
                if (isReady()) {
                    fitToBounds(true);
                    invalidate();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Invalid scale type: " + i2);
        }
    }

    public void setMinimumTileDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
            if (isReady()) {
                reset(false);
                invalidate();
            }
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

    public final void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            if (VALID_ORIENTATIONS.contains(Integer.valueOf(i2))) {
                this.orientation = i2;
                reset(false);
                invalidate();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Invalid orientation: " + i2);
        }
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
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
    }

    public final void setPanLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            if (VALID_PAN_LIMITS.contains(Integer.valueOf(i2))) {
                this.panLimit = i2;
                if (isReady()) {
                    fitToBounds(true);
                    invalidate();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Invalid pan limit: " + i2);
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.quickScaleEnabled = z;
        }
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, cls) == null) {
            if (cls != null) {
                this.regionDecoderFactory = new CompatDecoderFactory(cls);
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, decoderFactory) == null) {
            if (decoderFactory != null) {
                this.regionDecoderFactory = decoderFactory;
                return;
            }
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Float.valueOf(f2), pointF}) == null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(f2);
            this.sPendingCenter = pointF;
            this.sRequestedCenter = pointF;
            invalidate();
        }
    }

    public final void setTileBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            if (Color.alpha(i2) == 0) {
                this.tileBgPaint = null;
            } else {
                Paint paint = new Paint();
                this.tileBgPaint = paint;
                paint.setStyle(Paint.Style.FILL);
                this.tileBgPaint.setColor(i2);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, pointF)) == null) ? sourceToViewCoord(pointF.x, pointF.y, new PointF()) : (PointF) invokeL.objValue;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, pointF)) == null) ? viewToSourceCoord(pointF.x, pointF.y, new PointF()) : (PointF) invokeL.objValue;
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, imageSource, imageViewState) == null) {
            setImage(imageSource, null, imageViewState);
        }
    }

    public final PointF sourceToViewCoord(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? sourceToViewCoord(f2, f3, new PointF()) : (PointF) invokeCommon.objValue;
    }

    public final PointF viewToSourceCoord(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? viewToSourceCoord(f2, f3, new PointF()) : (PointF) invokeCommon.objValue;
    }

    /* loaded from: classes11.dex */
    public static class ScaleAndTranslate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float scale;
        public PointF vTranslate;

        public ScaleAndTranslate(float f2, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), pointF};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scale = f2;
            this.vTranslate = pointF;
        }

        public /* synthetic */ ScaleAndTranslate(float f2, PointF pointF, ScaleAndTranslate scaleAndTranslate) {
            this(f2, pointF);
        }
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, imageSource, imageSource2) == null) {
            setImage(imageSource, imageSource2, null);
        }
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048635, this, pointF, pointF2)) == null) ? sourceToViewCoord(pointF.x, pointF.y, pointF2) : (PointF) invokeLL.objValue;
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048639, this, pointF, pointF2)) == null) ? viewToSourceCoord(pointF.x, pointF.y, pointF2) : (PointF) invokeLL.objValue;
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

    public final PointF sourceToViewCoord(float f2, float f3, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), pointF})) == null) {
            if (this.vTranslate == null) {
                return null;
            }
            pointF.set(sourceToViewX(f2), sourceToViewY(f3));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final PointF viewToSourceCoord(float f2, float f3, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), pointF})) == null) {
            if (this.vTranslate == null) {
                return null;
            }
            pointF.set(viewToSourceX(f2), viewToSourceY(f3));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    /* loaded from: classes11.dex */
    public static class Anim {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes11.dex */
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

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, pointF};
                interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
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
                    float f2 = pointF3.x - (this.this$0.anim.sCenterStart.x * limitedScale);
                    float f3 = this.vFocus.y - (this.this$0.anim.sCenterStart.y * limitedScale);
                    ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f2, f3), null);
                    this.this$0.fitToBounds(true, scaleAndTranslate);
                    this.this$0.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f2), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f3));
                }
                this.this$0.invalidate();
            }
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

        public AnimationBuilder withEasing(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i2))) {
                    this.easing = i2;
                    return this;
                }
                throw new IllegalArgumentException("Unknown easing type: " + i2);
            }
            return (AnimationBuilder) invokeI.objValue;
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

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, pointF);
        }

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.targetScale = f2;
            this.targetSCenter = subsamplingScaleImageView.getCenter();
            this.vFocus = null;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, f2);
        }

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, Float.valueOf(f2), pointF};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, f2, pointF);
        }

        public AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subsamplingScaleImageView, Float.valueOf(f2), pointF, pointF2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, PointF pointF2, AnimationBuilder animationBuilder) {
            this(subsamplingScaleImageView, f2, pointF, pointF2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
