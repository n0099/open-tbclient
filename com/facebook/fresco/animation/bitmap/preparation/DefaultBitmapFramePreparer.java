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
/* loaded from: classes7.dex */
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bitmap.Config mBitmapConfig;
    public final BitmapFrameRenderer mBitmapFrameRenderer;
    public final ExecutorService mExecutorService;
    public final SparseArray<Runnable> mPendingFrameDecodeJobs;
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    /* loaded from: classes7.dex */
    public class FrameDecodeRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AnimationBackend mAnimationBackend;
        public final BitmapFrameCache mBitmapFrameCache;
        public final int mFrameNumber;
        public final int mHashCode;
        public final /* synthetic */ DefaultBitmapFramePreparer this$0;

        public FrameDecodeRunnable(DefaultBitmapFramePreparer defaultBitmapFramePreparer, AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultBitmapFramePreparer, animationBackend, bitmapFrameCache, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultBitmapFramePreparer;
            this.mAnimationBackend = animationBackend;
            this.mBitmapFrameCache = bitmapFrameCache;
            this.mFrameNumber = i;
            this.mHashCode = i2;
        }

        private boolean prepareFrameAndCache(int i, int i2) {
            InterceptResult invokeII;
            CloseableReference<Bitmap> bitmapToReuseForFrame;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
                int i3 = 2;
                try {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return false;
                        }
                        bitmapToReuseForFrame = this.this$0.mPlatformBitmapFactory.createBitmap(this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), this.this$0.mBitmapConfig);
                        i3 = -1;
                    } else {
                        bitmapToReuseForFrame = this.mBitmapFrameCache.getBitmapToReuseForFrame(i, this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight());
                    }
                    boolean renderFrameAndCache = renderFrameAndCache(i, bitmapToReuseForFrame, i2);
                    CloseableReference.closeSafely(bitmapToReuseForFrame);
                    if (!renderFrameAndCache && i3 != -1) {
                        return prepareFrameAndCache(i, i3);
                    }
                    return renderFrameAndCache;
                } catch (RuntimeException e) {
                    FLog.w(DefaultBitmapFramePreparer.TAG, "Failed to create frame bitmap", e);
                    return false;
                } finally {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                }
            }
            return invokeII.booleanValue;
        }

        private boolean renderFrameAndCache(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), closeableReference, Integer.valueOf(i2)})) == null) {
                if (!CloseableReference.isValid(closeableReference) || !this.this$0.mBitmapFrameRenderer.renderFrame(i, closeableReference.get())) {
                    return false;
                }
                FLog.v(DefaultBitmapFramePreparer.TAG, "Frame %d ready.", Integer.valueOf(this.mFrameNumber));
                synchronized (this.this$0.mPendingFrameDecodeJobs) {
                    this.mBitmapFrameCache.onFramePrepared(this.mFrameNumber, closeableReference, i2);
                }
                return true;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static int getUniqueId(AnimationBackend animationBackend, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, animationBackend, i)) == null) {
            return (animationBackend.hashCode() * 31) + i;
        }
        return invokeLI.intValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer
    public boolean prepareFrame(BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, bitmapFrameCache, animationBackend, i)) == null) {
            int uniqueId = getUniqueId(animationBackend, i);
            synchronized (this.mPendingFrameDecodeJobs) {
                if (this.mPendingFrameDecodeJobs.get(uniqueId) != null) {
                    FLog.v(TAG, "Already scheduled decode job for frame %d", Integer.valueOf(i));
                    return true;
                } else if (bitmapFrameCache.contains(i)) {
                    FLog.v(TAG, "Frame %d is cached already.", Integer.valueOf(i));
                    return true;
                } else {
                    FrameDecodeRunnable frameDecodeRunnable = new FrameDecodeRunnable(this, animationBackend, bitmapFrameCache, i, uniqueId);
                    this.mPendingFrameDecodeJobs.put(uniqueId, frameDecodeRunnable);
                    this.mExecutorService.execute(frameDecodeRunnable);
                    return true;
                }
            }
        }
        return invokeLLI.booleanValue;
    }
}
