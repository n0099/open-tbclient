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
import android.util.Log;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class FrameSequenceDrawable extends Drawable implements Animatable, Runnable {
    private static final long DEFAULT_DELAY_MS = 100;
    public static final int LOOP_DEFAULT = 3;
    public static final int LOOP_FINITE = 1;
    public static final int LOOP_INF = 2;
    @Deprecated
    public static final int LOOP_ONCE = 1;
    private static final long MIN_DELAY_MS = 20;
    private static final int STATE_DECODING = 2;
    private static final int STATE_READY_TO_SWAP = 4;
    private static final int STATE_SCHEDULED = 1;
    private static final int STATE_WAITING_TO_SWAP = 3;
    private static final String TAG = "FrameSequenceDrawable";
    private static HandlerThread sDecodingThread;
    private static Handler sDecodingThreadHandler;
    private Bitmap mBackBitmap;
    private BitmapShader mBackBitmapShader;
    private final a mBitmapProvider;
    private boolean mCircleMaskEnabled;
    private int mCurrentLoop;
    private Runnable mDecodeRunnable;
    private boolean mDestroyed;
    private Runnable mFinishedCallbackRunnable;
    private final FrameSequence mFrameSequence;
    private final FrameSequence.State mFrameSequenceState;
    private Bitmap mFrontBitmap;
    private BitmapShader mFrontBitmapShader;
    private long mLastSwap;
    private final Object mLock;
    private int mLoopBehavior;
    private int mLoopCount;
    private int mNextFrameToDecode;
    private long mNextSwap;
    private b mOnFinishedListener;
    private final Paint mPaint;
    private final Rect mSrcRect;
    private int mState;
    private RectF mTempRectF;
    private static final Object sLock = new Object();
    private static a sAllocatingBitmapProvider = new a() { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.1
        @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
        public Bitmap a(int i, int i2) {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }

        @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
        public void a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        Bitmap a(int i, int i2);

        void a(Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FrameSequenceDrawable frameSequenceDrawable);
    }

    public FrameSequenceDrawable(FrameSequence frameSequence) {
        this(frameSequence, sAllocatingBitmapProvider);
    }

    public FrameSequenceDrawable(FrameSequence frameSequence, a aVar) {
        this.mLock = new Object();
        this.mDestroyed = false;
        this.mLoopBehavior = 3;
        this.mLoopCount = 1;
        this.mTempRectF = new RectF();
        this.mDecodeRunnable = new Runnable() { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                long j;
                boolean z;
                Bitmap bitmap;
                boolean z2;
                synchronized (FrameSequenceDrawable.this.mLock) {
                    if (FrameSequenceDrawable.this.mDestroyed) {
                        return;
                    }
                    int i = FrameSequenceDrawable.this.mNextFrameToDecode;
                    if (i < 0) {
                        return;
                    }
                    Bitmap bitmap2 = FrameSequenceDrawable.this.mBackBitmap;
                    FrameSequenceDrawable.this.mState = 2;
                    try {
                        j = FrameSequenceDrawable.this.mFrameSequenceState.getFrame(i, bitmap2, i - 2);
                        z = false;
                    } catch (Exception e) {
                        Log.e(FrameSequenceDrawable.TAG, "exception during decode: " + e);
                        j = 0;
                        z = true;
                    }
                    if (j < 20) {
                        j = FrameSequenceDrawable.DEFAULT_DELAY_MS;
                    }
                    synchronized (FrameSequenceDrawable.this.mLock) {
                        if (FrameSequenceDrawable.this.mDestroyed) {
                            bitmap = FrameSequenceDrawable.this.mBackBitmap;
                            FrameSequenceDrawable.this.mBackBitmap = null;
                            z2 = false;
                        } else if (FrameSequenceDrawable.this.mNextFrameToDecode < 0 || FrameSequenceDrawable.this.mState != 2) {
                            bitmap = null;
                            z2 = false;
                        } else {
                            FrameSequenceDrawable.this.mNextSwap = z ? Long.MAX_VALUE : j + FrameSequenceDrawable.this.mLastSwap;
                            FrameSequenceDrawable.this.mState = 3;
                            bitmap = null;
                            z2 = true;
                        }
                    }
                    if (z2) {
                        FrameSequenceDrawable.this.scheduleSelf(FrameSequenceDrawable.this, FrameSequenceDrawable.this.mNextSwap);
                    }
                    if (bitmap != null) {
                        FrameSequenceDrawable.this.mBitmapProvider.a(bitmap);
                    }
                }
            }
        };
        this.mFinishedCallbackRunnable = new Runnable() { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (FrameSequenceDrawable.this.mLock) {
                    FrameSequenceDrawable.this.mNextFrameToDecode = -1;
                    FrameSequenceDrawable.this.mState = 0;
                }
                if (FrameSequenceDrawable.this.mOnFinishedListener != null) {
                    FrameSequenceDrawable.this.mOnFinishedListener.a(FrameSequenceDrawable.this);
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
        this.mPaint = new Paint();
        this.mPaint.setFilterBitmap(true);
        this.mFrontBitmapShader = new BitmapShader(this.mFrontBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.mBackBitmapShader = new BitmapShader(this.mBackBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.mLastSwap = 0L;
        this.mNextFrameToDecode = -1;
        this.mFrameSequenceState.getFrame(0, this.mFrontBitmap, -1);
        initializeDecodingThread();
    }

    public FrameSequenceDrawable(InputStream inputStream) {
        this(FrameSequence.decodeStream(inputStream));
    }

    private static Bitmap acquireAndValidateBitmap(a aVar, int i, int i2) {
        Bitmap a2 = aVar.a(i, i2);
        if (a2.getWidth() < i || a2.getHeight() < i2 || a2.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Invalid bitmap provided");
        }
        return a2;
    }

    private void checkDestroyedLocked() {
        if (this.mDestroyed) {
            throw new IllegalStateException("Cannot perform operation on recycled drawable");
        }
    }

    private static void initializeDecodingThread() {
        synchronized (sLock) {
            if (sDecodingThread != null) {
                return;
            }
            sDecodingThread = new HandlerThread("FrameSequence decoding thread", 10);
            sDecodingThread.start();
            sDecodingThreadHandler = new Handler(sDecodingThread.getLooper());
        }
    }

    private void scheduleDecodeLocked() {
        this.mState = 1;
        this.mNextFrameToDecode = (this.mNextFrameToDecode + 1) % this.mFrameSequence.getFrameCount();
        sDecodingThreadHandler.post(this.mDecodeRunnable);
    }

    public void destroy() {
        Bitmap bitmap = null;
        if (this.mBitmapProvider == null) {
            throw new IllegalStateException("BitmapProvider must be non-null");
        }
        synchronized (this.mLock) {
            if (this.mDestroyed) {
                return;
            }
            Bitmap bitmap2 = this.mFrontBitmap;
            this.mFrontBitmap = null;
            if (this.mState != 2) {
                bitmap = this.mBackBitmap;
                this.mBackBitmap = null;
            }
            this.mDestroyed = true;
            this.mBitmapProvider.a(bitmap2);
            if (bitmap != null) {
                this.mBitmapProvider.a(bitmap);
            }
            this.mFrameSequenceState.destroy();
            this.mFrameSequence.destroy();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
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
                if (this.mNextFrameToDecode == this.mFrameSequence.getFrameCount() - 1) {
                    this.mCurrentLoop++;
                    if ((this.mLoopBehavior == 1 && this.mCurrentLoop == this.mLoopCount) || (this.mLoopBehavior == 3 && this.mCurrentLoop == this.mFrameSequence.getDefaultLoopCount())) {
                        z = false;
                    }
                }
                if (z) {
                    scheduleDecodeLocked();
                } else {
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
            int intrinsicHeight = getIntrinsicHeight();
            float width = (bounds.width() * 1.0f) / intrinsicWidth;
            float height = (bounds.height() * 1.0f) / intrinsicHeight;
            canvas.save();
            canvas.translate(bounds.left, bounds.top);
            canvas.scale(width, height);
            float min = Math.min(bounds.width(), bounds.height());
            float f = min / width;
            float f2 = min / height;
            this.mTempRectF.set((intrinsicWidth - f) / 2.0f, (intrinsicHeight - f2) / 2.0f, (intrinsicWidth + f) / 2.0f, (f2 + intrinsicHeight) / 2.0f);
            this.mPaint.setShader(this.mFrontBitmapShader);
            canvas.drawOval(this.mTempRectF, this.mPaint);
            canvas.restore();
        }
    }

    public final boolean getCircleMaskEnabled() {
        return this.mCircleMaskEnabled;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mFrameSequence.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mFrameSequence.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mFrameSequence.isOpaque() ? -1 : -2;
    }

    public int getSize() {
        return this.mFrameSequence.getWidth() * this.mFrameSequence.getHeight() * 4;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mDestroyed;
        }
        return z;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mNextFrameToDecode > -1 && !this.mDestroyed;
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z = false;
        synchronized (this.mLock) {
            if (this.mNextFrameToDecode >= 0 && this.mState == 3) {
                this.mState = 4;
                z = true;
            }
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public final void setCircleMaskEnabled(boolean z) {
        if (this.mCircleMaskEnabled != z) {
            this.mCircleMaskEnabled = z;
            this.mPaint.setAntiAlias(z);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
    }

    public void setLoopCount(int i) {
        this.mLoopCount = i;
    }

    public void setOnFinishedListener(b bVar) {
        this.mOnFinishedListener = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning() || isDestroyed()) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mState != 1) {
                this.mCurrentLoop = 0;
                scheduleDecodeLocked();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            unscheduleSelf(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        synchronized (this.mLock) {
            this.mNextFrameToDecode = -1;
            this.mState = 0;
        }
        super.unscheduleSelf(runnable);
    }
}
