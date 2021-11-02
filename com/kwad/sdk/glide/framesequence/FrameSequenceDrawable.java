package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class FrameSequenceDrawable extends Drawable implements Animatable, Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_DELAY_MS = 100;
    public static final int LOOP_DEFAULT = 3;
    public static final int LOOP_FINITE = 1;
    public static final int LOOP_INF = 2;
    @Deprecated
    public static final int LOOP_ONCE = 1;
    public static final long MIN_DELAY_MS = 20;
    public static final int STATE_DECODING = 2;
    public static final int STATE_READY_TO_SWAP = 4;
    public static final int STATE_SCHEDULED = 1;
    public static final int STATE_WAITING_TO_SWAP = 3;
    public static final String TAG = "FrameSequenceDrawable";
    public static a sAllocatingBitmapProvider;
    public static HandlerThread sDecodingThread;
    public static Handler sDecodingThreadHandler;
    public static final Object sLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mBackBitmap;
    public BitmapShader mBackBitmapShader;
    public final a mBitmapProvider;
    public boolean mCircleMaskEnabled;
    public int mCurrentLoop;
    public Runnable mDecodeRunnable;
    public boolean mDestroyed;
    public Runnable mFinishedCallbackRunnable;
    public final FrameSequence mFrameSequence;
    public final FrameSequence.State mFrameSequenceState;
    public Bitmap mFrontBitmap;
    public BitmapShader mFrontBitmapShader;
    public long mLastSwap;
    public final Object mLock;
    public int mLoopBehavior;
    public int mLoopCount;
    public int mNextFrameToDecode;
    public long mNextSwap;
    public b mOnFinishedListener;
    public final Paint mPaint;
    public final Rect mSrcRect;
    public int mState;
    public RectF mTempRectF;

    /* loaded from: classes2.dex */
    public interface a {
        Bitmap a(int i2, int i3);

        void a(Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(FrameSequenceDrawable frameSequenceDrawable);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-497017067, "Lcom/kwad/sdk/glide/framesequence/FrameSequenceDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-497017067, "Lcom/kwad/sdk/glide/framesequence/FrameSequenceDrawable;");
                return;
            }
        }
        sLock = new Object();
        sAllocatingBitmapProvider = new a() { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public Bitmap a(int i2, int i3) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) ? Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888) : (Bitmap) invokeII.objValue;
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public void a(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameSequenceDrawable(FrameSequence frameSequence) {
        this(frameSequence, sAllocatingBitmapProvider);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameSequence};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FrameSequence) objArr2[0], (a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public FrameSequenceDrawable(FrameSequence frameSequence, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameSequence, aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mDestroyed = false;
        this.mLoopBehavior = 3;
        this.mLoopCount = 1;
        this.mTempRectF = new RectF();
        this.mDecodeRunnable = new Runnable(this) { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrameSequenceDrawable f65834a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65834a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Bitmap bitmap;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f65834a.mLock) {
                        if (this.f65834a.mDestroyed) {
                            return;
                        }
                        int i4 = this.f65834a.mNextFrameToDecode;
                        if (i4 < 0) {
                            return;
                        }
                        Bitmap bitmap2 = this.f65834a.mBackBitmap;
                        this.f65834a.mState = 2;
                        long j = 0;
                        boolean z2 = true;
                        try {
                            j = this.f65834a.mFrameSequenceState.getFrame(i4, bitmap2, i4 - 2);
                            z = false;
                        } catch (Exception e2) {
                            String str = "exception during decode: " + e2;
                            z = true;
                        }
                        if (j < 20) {
                            j = 100;
                        }
                        synchronized (this.f65834a.mLock) {
                            bitmap = null;
                            if (this.f65834a.mDestroyed) {
                                Bitmap bitmap3 = this.f65834a.mBackBitmap;
                                this.f65834a.mBackBitmap = null;
                                bitmap = bitmap3;
                            } else if (this.f65834a.mNextFrameToDecode >= 0 && this.f65834a.mState == 2) {
                                this.f65834a.mNextSwap = z ? Long.MAX_VALUE : j + this.f65834a.mLastSwap;
                                this.f65834a.mState = 3;
                            }
                            z2 = false;
                        }
                        if (z2) {
                            FrameSequenceDrawable frameSequenceDrawable = this.f65834a;
                            frameSequenceDrawable.scheduleSelf(frameSequenceDrawable, frameSequenceDrawable.mNextSwap);
                        }
                        if (bitmap != null) {
                            this.f65834a.mBitmapProvider.a(bitmap);
                        }
                    }
                }
            }
        };
        this.mFinishedCallbackRunnable = new Runnable(this) { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrameSequenceDrawable f65835a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65835a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f65835a.mLock) {
                        this.f65835a.mNextFrameToDecode = -1;
                        this.f65835a.mState = 0;
                    }
                    if (this.f65835a.mOnFinishedListener != null) {
                        this.f65835a.mOnFinishedListener.a(this.f65835a);
                    }
                }
            }
        };
        if (frameSequence == null || aVar == null) {
            throw new IllegalArgumentException();
        }
        this.mFrameSequence = frameSequence;
        this.mFrameSequenceState = frameSequence.createState();
        int width = frameSequence.getWidth();
        int height = frameSequence.getHeight();
        this.mBitmapProvider = aVar;
        this.mFrontBitmap = acquireAndValidateBitmap(aVar, width, height);
        this.mBackBitmap = acquireAndValidateBitmap(aVar, width, height);
        this.mSrcRect = new Rect(0, 0, width, height);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setFilterBitmap(true);
        Bitmap bitmap = this.mFrontBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mFrontBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Bitmap bitmap2 = this.mBackBitmap;
        Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
        this.mBackBitmapShader = new BitmapShader(bitmap2, tileMode2, tileMode2);
        this.mLastSwap = 0L;
        this.mNextFrameToDecode = -1;
        this.mFrameSequenceState.getFrame(0, this.mFrontBitmap, -1);
        initializeDecodingThread();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameSequenceDrawable(InputStream inputStream) {
        this(FrameSequence.decodeStream(inputStream));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((FrameSequence) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public static Bitmap acquireAndValidateBitmap(a aVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65554, null, aVar, i2, i3)) == null) {
            Bitmap a2 = aVar.a(i2, i3);
            if (a2.getWidth() < i2 || a2.getHeight() < i3 || a2.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("Invalid bitmap provided");
            }
            return a2;
        }
        return (Bitmap) invokeLII.objValue;
    }

    private void checkDestroyedLocked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.mDestroyed) {
            throw new IllegalStateException("Cannot perform operation on recycled drawable");
        }
    }

    public static void initializeDecodingThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            synchronized (sLock) {
                if (sDecodingThread != null) {
                    return;
                }
                HandlerThread handlerThread = new HandlerThread("FrameSequence decoding thread", 10);
                sDecodingThread = handlerThread;
                handlerThread.start();
                sDecodingThreadHandler = new Handler(sDecodingThread.getLooper());
            }
        }
    }

    private void scheduleDecodeLocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.mState = 1;
            this.mNextFrameToDecode = (this.mNextFrameToDecode + 1) % this.mFrameSequence.getFrameCount();
            Handler handler = sDecodingThreadHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mDecodeRunnable);
                sDecodingThreadHandler.post(this.mDecodeRunnable);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mBitmapProvider == null) {
                throw new IllegalStateException("BitmapProvider must be non-null");
            }
            synchronized (this.mLock) {
                if (this.mDestroyed) {
                    return;
                }
                Bitmap bitmap = this.mFrontBitmap;
                Bitmap bitmap2 = null;
                this.mFrontBitmap = null;
                if (this.mState != 2) {
                    Bitmap bitmap3 = this.mBackBitmap;
                    this.mBackBitmap = null;
                    bitmap2 = bitmap3;
                }
                this.mDestroyed = true;
                this.mBitmapProvider.a(bitmap);
                if (bitmap2 != null) {
                    this.mBitmapProvider.a(bitmap2);
                }
                this.mFrameSequenceState.destroy();
                this.mFrameSequence.destroy();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            synchronized (this.mLock) {
                if (isDestroyed()) {
                    return;
                }
                if (this.mState == 3 && this.mNextSwap - SystemClock.uptimeMillis() <= 0) {
                    this.mState = 4;
                }
                if (isRunning() && this.mState == 4) {
                    Bitmap bitmap = this.mBackBitmap;
                    this.mBackBitmap = this.mFrontBitmap;
                    this.mFrontBitmap = bitmap;
                    BitmapShader bitmapShader = this.mBackBitmapShader;
                    this.mBackBitmapShader = this.mFrontBitmapShader;
                    this.mFrontBitmapShader = bitmapShader;
                    this.mLastSwap = SystemClock.uptimeMillis();
                    boolean z = true;
                    if (this.mNextFrameToDecode == this.mFrameSequence.getFrameCount() - 1) {
                        int i2 = this.mCurrentLoop + 1;
                        this.mCurrentLoop = i2;
                        if ((this.mLoopBehavior == 1 && i2 == this.mLoopCount) || (this.mLoopBehavior == 3 && this.mCurrentLoop == this.mFrameSequence.getDefaultLoopCount())) {
                            z = false;
                        }
                    }
                    if (z) {
                        scheduleDecodeLocked();
                    } else {
                        unscheduleSelf(this.mFinishedCallbackRunnable);
                        scheduleSelf(this.mFinishedCallbackRunnable, 0L);
                    }
                }
                if (!this.mCircleMaskEnabled) {
                    this.mPaint.setShader(null);
                    canvas.drawBitmap(this.mFrontBitmap, this.mSrcRect, getBounds(), this.mPaint);
                    return;
                }
                Rect bounds = getBounds();
                int intrinsicWidth = getIntrinsicWidth();
                float f2 = intrinsicWidth;
                float width = (bounds.width() * 1.0f) / f2;
                float intrinsicHeight = getIntrinsicHeight();
                float height = (bounds.height() * 1.0f) / intrinsicHeight;
                canvas.save();
                canvas.translate(bounds.left, bounds.top);
                canvas.scale(width, height);
                float min = Math.min(bounds.width(), bounds.height());
                float f3 = min / width;
                float f4 = min / height;
                this.mTempRectF.set((f2 - f3) / 2.0f, (intrinsicHeight - f4) / 2.0f, (f2 + f3) / 2.0f, (intrinsicHeight + f4) / 2.0f);
                this.mPaint.setShader(this.mFrontBitmapShader);
                canvas.drawOval(this.mTempRectF, this.mPaint);
                canvas.restore();
            }
        }
    }

    public final boolean getCircleMaskEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCircleMaskEnabled : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFrameSequence.getHeight() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFrameSequence.getWidth() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFrameSequence.isOpaque() ? -1 : -2 : invokeV.intValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFrameSequence.getWidth() * this.mFrameSequence.getHeight() * 4 : invokeV.intValue;
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.mLock) {
                z = this.mDestroyed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.mLock) {
                z = this.mNextFrameToDecode > -1 && !this.mDestroyed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.mLock) {
                if (this.mNextFrameToDecode < 0 || this.mState != 3) {
                    z = false;
                } else {
                    this.mState = 4;
                    z = true;
                }
            }
            if (z) {
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mPaint.setAlpha(i2);
        }
    }

    public final void setCircleMaskEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.mCircleMaskEnabled == z) {
            return;
        }
        this.mCircleMaskEnabled = z;
        this.mPaint.setAntiAlias(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mPaint.setFilterBitmap(z);
        }
    }

    public void setLoopCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mLoopCount = i2;
        }
    }

    public void setOnFinishedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.mOnFinishedListener = bVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? super.setVisible(z, z2) : invokeCommon.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || isRunning() || isDestroyed()) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mState == 1) {
                return;
            }
            this.mCurrentLoop = 0;
            scheduleDecodeLocked();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && isRunning()) {
            unscheduleSelf(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, runnable) == null) {
            synchronized (this.mLock) {
                this.mNextFrameToDecode = -1;
                this.mState = 0;
            }
            super.unscheduleSelf(runnable);
        }
    }
}
