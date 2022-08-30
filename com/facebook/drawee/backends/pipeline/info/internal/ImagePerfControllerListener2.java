package com.facebook.drawee.backends.pipeline.info.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.fresco.ui.common.BaseControllerListener2;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ImagePerfControllerListener2 extends BaseControllerListener2<ImageInfo> implements OnDrawControllerListener<ImageInfo> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ImagePerfControllerListener2";
    public static final int WHAT_STATUS = 1;
    public static final int WHAT_VISIBILITY = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final Supplier<Boolean> mAsyncLogging;
    public final MonotonicClock mClock;
    @Nullable
    public Handler mHandler;
    public final ImagePerfNotifier mImagePerfNotifier;
    public final ImagePerfState mImagePerfState;

    /* loaded from: classes7.dex */
    public static class LogHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImagePerfNotifier mNotifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LogHandler(@NonNull Looper looper, @NonNull ImagePerfNotifier imagePerfNotifier) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, imagePerfNotifier};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNotifier = imagePerfNotifier;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 1) {
                    this.mNotifier.notifyStatusUpdated((ImagePerfState) message.obj, message.arg1);
                } else if (i != 2) {
                } else {
                    this.mNotifier.notifyListenersOfVisibilityStateUpdate((ImagePerfState) message.obj, message.arg1);
                }
            }
        }
    }

    public ImagePerfControllerListener2(MonotonicClock monotonicClock, ImagePerfState imagePerfState, ImagePerfNotifier imagePerfNotifier, Supplier<Boolean> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {monotonicClock, imagePerfState, imagePerfNotifier, supplier};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClock = monotonicClock;
        this.mImagePerfState = imagePerfState;
        this.mImagePerfNotifier = imagePerfNotifier;
        this.mAsyncLogging = supplier;
    }

    private synchronized void initHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                if (this.mHandler != null) {
                    return;
                }
                HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
                handlerThread.start();
                this.mHandler = new LogHandler(handlerThread.getLooper(), this.mImagePerfNotifier);
            }
        }
    }

    @VisibleForTesting
    private void reportViewInvisible(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            this.mImagePerfState.setVisible(false);
            this.mImagePerfState.setInvisibilityEventTimeMs(j);
            updateVisibility(2);
        }
    }

    private boolean shouldDispatchAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            boolean booleanValue = this.mAsyncLogging.get().booleanValue();
            if (booleanValue && this.mHandler == null) {
                initHandler();
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    private void updateStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            if (shouldDispatchAsync()) {
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i;
                obtainMessage.obj = this.mImagePerfState;
                this.mHandler.sendMessage(obtainMessage);
                return;
            }
            this.mImagePerfNotifier.notifyStatusUpdated(this.mImagePerfState, i);
        }
    }

    private void updateVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            if (shouldDispatchAsync()) {
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i;
                obtainMessage.obj = this.mImagePerfState;
                this.mHandler.sendMessage(obtainMessage);
                return;
            }
            this.mImagePerfNotifier.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, i);
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String str, Throwable th, @Nullable ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, th, extras) == null) {
            long now = this.mClock.now();
            this.mImagePerfState.setExtraData(extras);
            this.mImagePerfState.setControllerFailureTimeMs(now);
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfState.setErrorThrowable(th);
            updateStatus(5);
            reportViewInvisible(now);
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String str, ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, extras) == null) {
            long now = this.mClock.now();
            this.mImagePerfState.setExtraData(extras);
            int imageLoadStatus = this.mImagePerfState.getImageLoadStatus();
            if (imageLoadStatus != 3 && imageLoadStatus != 5 && imageLoadStatus != 6) {
                this.mImagePerfState.setControllerCancelTimeMs(now);
                this.mImagePerfState.setControllerId(str);
                updateStatus(4);
            }
            reportViewInvisible(now);
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String str, @Nullable Object obj, @Nullable ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj, extras) == null) {
            long now = this.mClock.now();
            this.mImagePerfState.resetPointsTimestamps();
            this.mImagePerfState.setControllerSubmitTimeMs(now);
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfState.setCallerContext(obj);
            this.mImagePerfState.setExtraData(extras);
            updateStatus(0);
            reportViewVisible(now);
        }
    }

    @VisibleForTesting
    public void reportViewVisible(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.mImagePerfState.setVisible(true);
            this.mImagePerfState.setVisibilityEventTimeMs(j);
            updateVisibility(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, extras) == null) {
            long now = this.mClock.now();
            extras.f1068view.size();
            this.mImagePerfState.setExtraData(extras);
            this.mImagePerfState.setControllerFinalImageSetTimeMs(now);
            this.mImagePerfState.setImageRequestEndTimeMs(now);
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfState.setImageInfo(imageInfo);
            updateStatus(3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(String str, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, imageInfo, dimensionsInfo) == null) {
            this.mImagePerfState.setImageDrawTimeMs(this.mClock.now());
            this.mImagePerfState.setDimensionsInfo(dimensionsInfo);
            updateStatus(6);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(String str, @Nullable ImageInfo imageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, imageInfo) == null) {
            this.mImagePerfState.setControllerIntermediateImageSetTimeMs(this.mClock.now());
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfState.setImageInfo(imageInfo);
            updateStatus(2);
        }
    }
}
