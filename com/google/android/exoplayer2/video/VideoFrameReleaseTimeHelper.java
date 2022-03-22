package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Util;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class VideoFrameReleaseTimeHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500;
    public static final long MAX_ALLOWED_DRIFT_NS = 20000000;
    public static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    public static final long VSYNC_OFFSET_PERCENTAGE = 80;
    public transient /* synthetic */ FieldHolder $fh;
    public long adjustedLastFrameTimeNs;
    public final DefaultDisplayListener displayListener;
    public long frameCount;
    public boolean haveSync;
    public long lastFramePresentationTimeUs;
    public long pendingAdjustedFrameTimeNs;
    public long syncFramePresentationTimeNs;
    public long syncUnadjustedReleaseTimeNs;
    public long vsyncDurationNs;
    public long vsyncOffsetNs;
    public final VSyncSampler vsyncSampler;
    public final WindowManager windowManager;

    @TargetApi(17)
    /* loaded from: classes6.dex */
    public final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DisplayManager displayManager;
        public final /* synthetic */ VideoFrameReleaseTimeHelper this$0;

        public DefaultDisplayListener(VideoFrameReleaseTimeHelper videoFrameReleaseTimeHelper, DisplayManager displayManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoFrameReleaseTimeHelper, displayManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = videoFrameReleaseTimeHelper;
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i == 0) {
                this.this$0.updateDefaultDisplayRefreshRateParams();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public void register() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.displayManager.registerDisplayListener(this, null);
            }
        }

        public void unregister() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.displayManager.unregisterDisplayListener(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CREATE_CHOREOGRAPHER = 0;
        public static final VSyncSampler INSTANCE;
        public static final int MSG_ADD_OBSERVER = 1;
        public static final int MSG_REMOVE_OBSERVER = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public Choreographer choreographer;
        public final HandlerThread choreographerOwnerThread;
        public final Handler handler;
        public int observerCount;
        public volatile long sampledVsyncTimeNs;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-855659554, "Lcom/google/android/exoplayer2/video/VideoFrameReleaseTimeHelper$VSyncSampler;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-855659554, "Lcom/google/android/exoplayer2/video/VideoFrameReleaseTimeHelper$VSyncSampler;");
                    return;
                }
            }
            INSTANCE = new VSyncSampler();
        }

        public VSyncSampler() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.sampledVsyncTimeNs = C.TIME_UNSET;
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.choreographerOwnerThread.getLooper(), this);
            this.handler = handler;
            handler.sendEmptyMessage(0);
        }

        private void addObserverInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                int i = this.observerCount + 1;
                this.observerCount = i;
                if (i == 1) {
                    this.choreographer.postFrameCallback(this);
                }
            }
        }

        private void createChoreographerInstanceInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                this.choreographer = Choreographer.getInstance();
            }
        }

        public static VSyncSampler getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? INSTANCE : (VSyncSampler) invokeV.objValue;
        }

        private void removeObserverInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                int i = this.observerCount - 1;
                this.observerCount = i;
                if (i == 0) {
                    this.choreographer.removeFrameCallback(this);
                    this.sampledVsyncTimeNs = C.TIME_UNSET;
                }
            }
        }

        public void addObserver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.handler.sendEmptyMessage(1);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.sampledVsyncTimeNs = j;
                this.choreographer.postFrameCallbackDelayed(this, 500L);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message)) == null) {
                int i = message.what;
                if (i == 0) {
                    createChoreographerInstanceInternal();
                    return true;
                } else if (i == 1) {
                    addObserverInternal();
                    return true;
                } else if (i != 2) {
                    return false;
                } else {
                    removeObserverInternal();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        public void removeObserver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.handler.sendEmptyMessage(2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoFrameReleaseTimeHelper() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static long closestVsync(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j5 = j2 + (((j - j2) / j3) * j3);
            if (j <= j5) {
                j4 = j5 - j3;
            } else {
                j5 = j3 + j5;
                j4 = j5;
            }
            return j5 - j < j - j4 ? j5 : j4;
        }
        return invokeCommon.longValue;
    }

    private boolean isDriftTooLarge(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Math.abs((j2 - this.syncUnadjustedReleaseTimeNs) - (j - this.syncFramePresentationTimeNs)) > MAX_ALLOWED_DRIFT_NS : invokeCommon.booleanValue;
    }

    @TargetApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return null;
            }
            return new DefaultDisplayListener(this, displayManager);
        }
        return (DefaultDisplayListener) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        Display defaultDisplay;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (defaultDisplay = this.windowManager.getDefaultDisplay()) == null) {
            return;
        }
        long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
        this.vsyncDurationNs = refreshRate;
        this.vsyncOffsetNs = (refreshRate * 80) / 100;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long adjustReleaseTime(long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        long j4;
        VSyncSampler vSyncSampler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j5 = 1000 * j;
            if (this.haveSync) {
                if (j != this.lastFramePresentationTimeUs) {
                    this.frameCount++;
                    this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
                }
                long j6 = this.frameCount;
                if (j6 >= 6) {
                    j4 = this.adjustedLastFrameTimeNs + ((j5 - this.syncFramePresentationTimeNs) / j6);
                    if (isDriftTooLarge(j4, j2)) {
                        this.haveSync = false;
                    } else {
                        j3 = (this.syncUnadjustedReleaseTimeNs + j4) - this.syncFramePresentationTimeNs;
                        if (!this.haveSync) {
                            this.syncFramePresentationTimeNs = j5;
                            this.syncUnadjustedReleaseTimeNs = j2;
                            this.frameCount = 0L;
                            this.haveSync = true;
                        }
                        this.lastFramePresentationTimeUs = j;
                        this.pendingAdjustedFrameTimeNs = j4;
                        vSyncSampler = this.vsyncSampler;
                        if (vSyncSampler != null || this.vsyncDurationNs == C.TIME_UNSET) {
                            return j3;
                        }
                        long j7 = vSyncSampler.sampledVsyncTimeNs;
                        return j7 == C.TIME_UNSET ? j3 : closestVsync(j3, j7, this.vsyncDurationNs) - this.vsyncOffsetNs;
                    }
                } else if (isDriftTooLarge(j5, j2)) {
                    this.haveSync = false;
                }
            }
            j3 = j2;
            j4 = j5;
            if (!this.haveSync) {
            }
            this.lastFramePresentationTimeUs = j;
            this.pendingAdjustedFrameTimeNs = j4;
            vSyncSampler = this.vsyncSampler;
            if (vSyncSampler != null) {
            }
            return j3;
        }
        return invokeCommon.longValue;
    }

    public void disable() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.windowManager == null) {
            return;
        }
        DefaultDisplayListener defaultDisplayListener = this.displayListener;
        if (defaultDisplayListener != null) {
            defaultDisplayListener.unregister();
        }
        this.vsyncSampler.removeObserver();
    }

    public void enable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.haveSync = false;
            if (this.windowManager != null) {
                this.vsyncSampler.addObserver();
                DefaultDisplayListener defaultDisplayListener = this.displayListener;
                if (defaultDisplayListener != null) {
                    defaultDisplayListener.register();
                }
                updateDefaultDisplayRefreshRateParams();
            }
        }
    }

    public VideoFrameReleaseTimeHelper(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        WindowManager windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        this.windowManager = windowManager;
        if (windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : null;
            this.vsyncSampler = VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = C.TIME_UNSET;
        this.vsyncOffsetNs = C.TIME_UNSET;
    }
}
