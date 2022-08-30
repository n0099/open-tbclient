package com.facebook.drawee.backends.pipeline.info;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener2;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ImagePerfMonitor implements ImagePerfNotifier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Supplier<Boolean> mAsyncLogging;
    public boolean mEnabled;
    @Nullable
    public ForwardingRequestListener mForwardingRequestListener;
    @Nullable
    public ImageOriginListener mImageOriginListener;
    @Nullable
    public ImageOriginRequestListener mImageOriginRequestListener;
    @Nullable
    public ImagePerfControllerListener2 mImagePerfControllerListener2;
    @Nullable
    public List<ImagePerfDataListener> mImagePerfDataListeners;
    @Nullable
    public ImagePerfRequestListener mImagePerfRequestListener;
    public final ImagePerfState mImagePerfState;
    public final MonotonicClock mMonotonicClock;
    public final PipelineDraweeController mPipelineDraweeController;

    public ImagePerfMonitor(MonotonicClock monotonicClock, PipelineDraweeController pipelineDraweeController, Supplier<Boolean> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {monotonicClock, pipelineDraweeController, supplier};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMonotonicClock = monotonicClock;
        this.mPipelineDraweeController = pipelineDraweeController;
        this.mImagePerfState = new ImagePerfState();
        this.mAsyncLogging = supplier;
    }

    private void setupListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (this.mImagePerfControllerListener2 == null) {
                this.mImagePerfControllerListener2 = new ImagePerfControllerListener2(this.mMonotonicClock, this.mImagePerfState, this, this.mAsyncLogging);
            }
            if (this.mImagePerfRequestListener == null) {
                this.mImagePerfRequestListener = new ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
            }
            if (this.mImageOriginListener == null) {
                this.mImageOriginListener = new ImagePerfImageOriginListener(this.mImagePerfState, this);
            }
            ImageOriginRequestListener imageOriginRequestListener = this.mImageOriginRequestListener;
            if (imageOriginRequestListener == null) {
                this.mImageOriginRequestListener = new ImageOriginRequestListener(this.mPipelineDraweeController.getId(), this.mImageOriginListener);
            } else {
                imageOriginRequestListener.init(this.mPipelineDraweeController.getId());
            }
            if (this.mForwardingRequestListener == null) {
                this.mForwardingRequestListener = new ForwardingRequestListener(this.mImagePerfRequestListener, this.mImageOriginRequestListener);
            }
        }
    }

    public void addImagePerfDataListener(@Nullable ImagePerfDataListener imagePerfDataListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, imagePerfDataListener) == null) || imagePerfDataListener == null) {
            return;
        }
        if (this.mImagePerfDataListeners == null) {
            this.mImagePerfDataListeners = new CopyOnWriteArrayList();
        }
        this.mImagePerfDataListeners.add(imagePerfDataListener);
    }

    public void addViewportData() {
        DraweeHierarchy hierarchy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hierarchy = this.mPipelineDraweeController.getHierarchy()) == null || hierarchy.getTopLevelDrawable() == null) {
            return;
        }
        Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
        this.mImagePerfState.setOnScreenWidth(bounds.width());
        this.mImagePerfState.setOnScreenHeight(bounds.height());
    }

    public void clearImagePerfDataListeners() {
        List<ImagePerfDataListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.mImagePerfDataListeners) == null) {
            return;
        }
        list.clear();
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier
    public void notifyListenersOfVisibilityStateUpdate(ImagePerfState imagePerfState, int i) {
        List<ImagePerfDataListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, imagePerfState, i) == null) || !this.mEnabled || (list = this.mImagePerfDataListeners) == null || list.isEmpty()) {
            return;
        }
        ImagePerfData snapshot = imagePerfState.snapshot();
        for (ImagePerfDataListener imagePerfDataListener : this.mImagePerfDataListeners) {
            imagePerfDataListener.onImageVisibilityUpdated(snapshot, i);
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier
    public void notifyStatusUpdated(ImagePerfState imagePerfState, int i) {
        List<ImagePerfDataListener> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, imagePerfState, i) == null) {
            imagePerfState.setImageLoadStatus(i);
            if (!this.mEnabled || (list = this.mImagePerfDataListeners) == null || list.isEmpty()) {
                return;
            }
            if (i == 3) {
                addViewportData();
            }
            ImagePerfData snapshot = imagePerfState.snapshot();
            for (ImagePerfDataListener imagePerfDataListener : this.mImagePerfDataListeners) {
                imagePerfDataListener.onImageLoadStatusUpdated(snapshot, i);
            }
        }
    }

    public void removeImagePerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        List<ImagePerfDataListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, imagePerfDataListener) == null) || (list = this.mImagePerfDataListeners) == null) {
            return;
        }
        list.remove(imagePerfDataListener);
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            clearImagePerfDataListeners();
            setEnabled(false);
            this.mImagePerfState.reset();
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mEnabled = z;
            if (z) {
                setupListeners();
                ImageOriginListener imageOriginListener = this.mImageOriginListener;
                if (imageOriginListener != null) {
                    this.mPipelineDraweeController.addImageOriginListener(imageOriginListener);
                }
                ImagePerfControllerListener2 imagePerfControllerListener2 = this.mImagePerfControllerListener2;
                if (imagePerfControllerListener2 != null) {
                    this.mPipelineDraweeController.addControllerListener2(imagePerfControllerListener2);
                }
                ForwardingRequestListener forwardingRequestListener = this.mForwardingRequestListener;
                if (forwardingRequestListener != null) {
                    this.mPipelineDraweeController.addRequestListener(forwardingRequestListener);
                    return;
                }
                return;
            }
            ImageOriginListener imageOriginListener2 = this.mImageOriginListener;
            if (imageOriginListener2 != null) {
                this.mPipelineDraweeController.removeImageOriginListener(imageOriginListener2);
            }
            ImagePerfControllerListener2 imagePerfControllerListener22 = this.mImagePerfControllerListener2;
            if (imagePerfControllerListener22 != null) {
                this.mPipelineDraweeController.removeControllerListener2(imagePerfControllerListener22);
            }
            ForwardingRequestListener forwardingRequestListener2 = this.mForwardingRequestListener;
            if (forwardingRequestListener2 != null) {
                this.mPipelineDraweeController.removeRequestListener(forwardingRequestListener2);
            }
        }
    }

    public void updateImageRequestData(AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> abstractDraweeControllerBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, abstractDraweeControllerBuilder) == null) {
            this.mImagePerfState.setControllerImageRequests(abstractDraweeControllerBuilder.getImageRequest(), abstractDraweeControllerBuilder.getLowResImageRequest(), abstractDraweeControllerBuilder.getFirstAvailableImageRequests());
        }
    }
}
