package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bitmap.Config mBitmapConfig;
    public final BitmapFrameRenderer mBitmapFrameRenderer;
    public final ExecutorService mExecutorService;
    public final SparseArray<Runnable> mPendingFrameDecodeJobs;
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    /* loaded from: classes2.dex */
    public class FrameDecodeRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AnimationBackend mAnimationBackend;
        public final BitmapFrameCache mBitmapFrameCache;
        public final int mFrameNumber;
        public final int mHashCode;
        public final /* synthetic */ DefaultBitmapFramePreparer this$0;

        public FrameDecodeRunnable(DefaultBitmapFramePreparer defaultBitmapFramePreparer, AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultBitmapFramePreparer, animationBackend, bitmapFrameCache, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultBitmapFramePreparer;
            this.mAnimationBackend = animationBackend;
            this.mBitmapFrameCache = bitmapFrameCache;
            this.mFrameNumber = i2;
            this.mHashCode = i3;
        }

        private boolean prepareFrameAndCache(int i2, int i3) {
            InterceptResult invokeII;
            CloseableReference<Bitmap> bitmapToReuseForFrame;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i2, i3)) == null) {
                int i4 = 2;
                try {
                    if (i3 == 1) {
                        bitmapToReuseForFrame = this.mBitmapFrameCache.getBitmapToReuseForFrame(i2, this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight());
                    } else if (i3 != 2) {
                        return false;
                    } else {
                        bitmapToReuseForFrame = this.this$0.mPlatformBitmapFactory.createBitmap(this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), this.this$0.mBitmapConfig);
                        i4 = -1;
                    }
                    boolean renderFrameAndCache = renderFrameAndCache(i2, bitmapToReuseForFrame, i3);
                    CloseableReference.closeSafely(bitmapToReuseForFrame);
                    return (renderFrameAndCache || i4 == -1) ? renderFrameAndCache : prepareFrameAndCache(i2, i4);
                } catch (RuntimeException e2) {
                    FLog.w(DefaultBitmapFramePreparer.TAG, "Failed to create frame bitmap", e2);
                    return false;
                } finally {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                }
            }
            return invokeII.booleanValue;
        }

        private boolean renderFrameAndCache(int i2, CloseableReference<Bitmap> closeableReference, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), closeableReference, Integer.valueOf(i3)})) == null) {
                if (CloseableReference.isValid(closeableReference) && this.this$0.mBitmapFrameRenderer.renderFrame(i2, closeableReference.get())) {
                    FLog.v(DefaultBitmapFramePreparer.TAG, "Frame %d ready.", Integer.valueOf(this.mFrameNumber));
                    synchronized (this.this$0.mPendingFrameDecodeJobs) {
                        this.mBitmapFrameCache.onFramePrepared(this.mFrameNumber, closeableReference, i3);
                    }
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.mBitmapFrameCache.contains(this.mFrameNumber)) {
                        FLog.v(DefaultBitmapFramePreparer.TAG, "Frame %d is cached already.", Integer.valueOf(this.mFrameNumber));
                        synchronized (this.this$0.mPendingFrameDecodeJobs) {
                            this.this$0.mPendingFrameDecodeJobs.remove(this.mHashCode);
                        }
                        return;
                    }
                    if (prepareFrameAndCache(this.mFrameNumber, 1)) {
                        FLog.v(DefaultBitmapFramePreparer.TAG, "Prepared frame frame %d.", Integer.valueOf(this.mFrameNumber));
                    } else {
                        FLog.e(DefaultBitmapFramePreparer.TAG, "Could not prepare frame %d.", Integer.valueOf(this.mFrameNumber));
                    }
                    synchronized (this.this$0.mPendingFrameDecodeJobs) {
                        this.this$0.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    }
                } catch (Throwable th) {
                    synchronized (this.this$0.mPendingFrameDecodeJobs) {
                        this.this$0.mPendingFrameDecodeJobs.remove(this.mHashCode);
                        throw th;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514258912, "Lcom/facebook/fresco/animation/bitmap/preparation/DefaultBitmapFramePreparer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-514258912, "Lcom/facebook/fresco/animation/bitmap/preparation/DefaultBitmapFramePreparer;");
                return;
            }
        }
        TAG = DefaultBitmapFramePreparer.class;
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config config, ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {platformBitmapFactory, bitmapFrameRenderer, config, executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
        this.mPendingFrameDecodeJobs = new SparseArray<>();
    }

    public static int getUniqueId(AnimationBackend animationBackend, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, animationBackend, i2)) == null) ? (animationBackend.hashCode() * 31) + i2 : invokeLI.intValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer
    public boolean prepareFrame(BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, bitmapFrameCache, animationBackend, i2)) == null) {
            int uniqueId = getUniqueId(animationBackend, i2);
            synchronized (this.mPendingFrameDecodeJobs) {
                if (this.mPendingFrameDecodeJobs.get(uniqueId) != null) {
                    FLog.v(TAG, "Already scheduled decode job for frame %d", Integer.valueOf(i2));
                    return true;
                } else if (bitmapFrameCache.contains(i2)) {
                    FLog.v(TAG, "Frame %d is cached already.", Integer.valueOf(i2));
                    return true;
                } else {
                    FrameDecodeRunnable frameDecodeRunnable = new FrameDecodeRunnable(this, animationBackend, bitmapFrameCache, i2, uniqueId);
                    this.mPendingFrameDecodeJobs.put(uniqueId, frameDecodeRunnable);
                    this.mExecutorService.execute(frameDecodeRunnable);
                    return true;
                }
            }
        }
        return invokeLLI.booleanValue;
    }
}
