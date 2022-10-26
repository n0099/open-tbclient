package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginColor;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.fresco.ui.common.MultiUriHelper;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class PipelineDraweeController extends AbstractDraweeController {
    public static /* synthetic */ Interceptable $ic;
    public static final Class TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public CacheKey mCacheKey;
    @Nullable
    public ImmutableList mCustomDrawableFactories;
    public Supplier mDataSourceSupplier;
    public DebugOverlayImageOriginListener mDebugOverlayImageOriginListener;
    public final DrawableFactory mDefaultDrawableFactory;
    public boolean mDrawDebugOverlay;
    @Nullable
    public ImageRequest[] mFirstAvailableImageRequests;
    @Nullable
    public final ImmutableList mGlobalDrawableFactories;
    @Nullable
    public ImageOriginListener mImageOriginListener;
    @Nullable
    public ImagePerfMonitor mImagePerfMonitor;
    @Nullable
    public ImageRequest mImageRequest;
    @Nullable
    public ImageRequest mLowResImageRequest;
    @Nullable
    public final MemoryCache mMemoryCache;
    @Nullable
    public Set mRequestListeners;
    public final Resources mResources;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1086579616, "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1086579616, "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;");
                return;
            }
        }
        TAG = PipelineDraweeController.class;
    }

    public void clearImageOriginListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.mImageOriginListener = null;
            }
        }
    }

    public CacheKey getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mCacheKey;
        }
        return (CacheKey) invokeV.objValue;
    }

    public Supplier getDataSourceSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mDataSourceSupplier;
        }
        return (Supplier) invokeV.objValue;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @Nullable
    public Uri getMainUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return MultiUriHelper.getMainUri(this.mImageRequest, this.mLowResImageRequest, this.mFirstAvailableImageRequests, ImageRequest.REQUEST_TO_URI_FN);
        }
        return (Uri) invokeV.objValue;
    }

    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mResources;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, @Nullable MemoryCache memoryCache, @Nullable ImmutableList immutableList) {
        super(deferredReleaser, executor, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, deferredReleaser, drawableFactory, executor, memoryCache, immutableList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DeferredReleaser) objArr2[0], (Executor) objArr2[1], (String) objArr2[2], objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mResources = resources;
        this.mDefaultDrawableFactory = new DefaultDrawableFactory(resources, drawableFactory);
        this.mGlobalDrawableFactories = immutableList;
        this.mMemoryCache = memoryCache;
    }

    private void init(Supplier supplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, supplier) == null) {
            this.mDataSourceSupplier = supplier;
            maybeUpdateDebugOverlay(null);
        }
    }

    public synchronized void addRequestListener(RequestListener requestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestListener) == null) {
            synchronized (this) {
                if (this.mRequestListeners == null) {
                    this.mRequestListeners = new HashSet();
                }
                this.mRequestListeners.add(requestListener);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public int getImageHash(@Nullable CloseableReference closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, closeableReference)) == null) {
            if (closeableReference != null) {
                return closeableReference.getValueHash();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public ImageInfo getImageInfo(CloseableReference closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, closeableReference)) == null) {
            Preconditions.checkState(CloseableReference.isValid(closeableReference));
            return (ImageInfo) closeableReference.get();
        }
        return (ImageInfo) invokeL.objValue;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean isSameImageRequest(@Nullable DraweeController draweeController) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, draweeController)) == null) {
            CacheKey cacheKey = this.mCacheKey;
            if (cacheKey != null && (draweeController instanceof PipelineDraweeController)) {
                return Objects.equal(cacheKey, ((PipelineDraweeController) draweeController).getCacheKey());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @Nullable
    public Map obtainExtrasFromImage(ImageInfo imageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, imageInfo)) == null) {
            if (imageInfo == null) {
                return null;
            }
            return imageInfo.getExtras();
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) && (drawable instanceof DrawableWithCaches)) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseImage(@Nullable CloseableReference closeableReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, closeableReference) == null) {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, imageOriginListener) == null) {
            synchronized (this) {
                if (this.mImageOriginListener instanceof ForwardingImageOriginListener) {
                    ((ForwardingImageOriginListener) this.mImageOriginListener).removeImageOriginListener(imageOriginListener);
                    return;
                }
                if (this.mImageOriginListener == imageOriginListener) {
                    this.mImageOriginListener = null;
                }
            }
        }
    }

    public synchronized void removeRequestListener(RequestListener requestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, requestListener) == null) {
            synchronized (this) {
                if (this.mRequestListeners == null) {
                    return;
                }
                this.mRequestListeners.remove(requestListener);
            }
        }
    }

    public void setCustomDrawableFactories(@Nullable ImmutableList immutableList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, immutableList) == null) {
            this.mCustomDrawableFactories = immutableList;
        }
    }

    public void setDrawDebugOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mDrawDebugOverlay = z;
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@Nullable DraweeHierarchy draweeHierarchy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, draweeHierarchy) == null) {
            super.setHierarchy(draweeHierarchy);
            maybeUpdateDebugOverlay(null);
        }
    }

    @Nullable
    private Drawable maybeCreateDrawableFromFactories(@Nullable ImmutableList immutableList, CloseableImage closeableImage) {
        InterceptResult invokeLL;
        Drawable createDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, immutableList, closeableImage)) == null) {
            if (immutableList == null) {
                return null;
            }
            Iterator it = immutableList.iterator();
            while (it.hasNext()) {
                DrawableFactory drawableFactory = (DrawableFactory) it.next();
                if (drawableFactory.supportsImageType(closeableImage) && (createDrawable = drawableFactory.createDrawable(closeableImage)) != null) {
                    return createDrawable;
                }
            }
            return null;
        }
        return (Drawable) invokeLL.objValue;
    }

    private void maybeUpdateDebugOverlay(@Nullable CloseableImage closeableImage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, closeableImage) != null) || !this.mDrawDebugOverlay) {
            return;
        }
        if (getControllerOverlay() == null) {
            DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
            ControllerListener imageLoadingTimeControllerListener = new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable);
            this.mDebugOverlayImageOriginListener = new DebugOverlayImageOriginListener();
            addControllerListener(imageLoadingTimeControllerListener);
            setControllerOverlay(debugControllerOverlayDrawable);
        }
        if (this.mImageOriginListener == null) {
            addImageOriginListener(this.mDebugOverlayImageOriginListener);
        }
        if (getControllerOverlay() instanceof DebugControllerOverlayDrawable) {
            updateDebugOverlay(closeableImage, (DebugControllerOverlayDrawable) getControllerOverlay());
        }
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageOriginListener) == null) {
            synchronized (this) {
                if (this.mImageOriginListener instanceof ForwardingImageOriginListener) {
                    ((ForwardingImageOriginListener) this.mImageOriginListener).addImageOriginListener(imageOriginListener);
                } else if (this.mImageOriginListener != null) {
                    this.mImageOriginListener = new ForwardingImageOriginListener(this.mImageOriginListener, imageOriginListener);
                } else {
                    this.mImageOriginListener = imageOriginListener;
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Drawable createDrawable(CloseableReference closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, closeableReference)) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("PipelineDraweeController#createDrawable");
                }
                Preconditions.checkState(CloseableReference.isValid(closeableReference));
                CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                maybeUpdateDebugOverlay(closeableImage);
                Drawable maybeCreateDrawableFromFactories = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, closeableImage);
                if (maybeCreateDrawableFromFactories != null) {
                    return maybeCreateDrawableFromFactories;
                }
                Drawable maybeCreateDrawableFromFactories2 = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, closeableImage);
                if (maybeCreateDrawableFromFactories2 != null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return maybeCreateDrawableFromFactories2;
                }
                Drawable createDrawable = this.mDefaultDrawableFactory.createDrawable(closeableImage);
                if (createDrawable != null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return createDrawable;
                }
                throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
        return (Drawable) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @Nullable
    public CloseableReference getCachedImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("PipelineDraweeController#getCachedImage");
            }
            try {
                if (this.mMemoryCache != null && this.mCacheKey != null) {
                    CloseableReference closeableReference = this.mMemoryCache.get(this.mCacheKey);
                    if (closeableReference != null && !((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality()) {
                        closeableReference.close();
                        return null;
                    }
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return closeableReference;
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return null;
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
        return (CloseableReference) invokeV.objValue;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public DataSource getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("PipelineDraweeController#getDataSource");
            }
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
            }
            DataSource dataSource = (DataSource) this.mDataSourceSupplier.get();
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return dataSource;
        }
        return (DataSource) invokeV.objValue;
    }

    @Nullable
    public synchronized RequestListener getRequestListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (this) {
                ImageOriginRequestListener imageOriginRequestListener = null;
                if (this.mImageOriginListener != null) {
                    imageOriginRequestListener = new ImageOriginRequestListener(getId(), this.mImageOriginListener);
                }
                if (this.mRequestListeners != null) {
                    ForwardingRequestListener forwardingRequestListener = new ForwardingRequestListener(this.mRequestListeners);
                    if (imageOriginRequestListener != null) {
                        forwardingRequestListener.addRequestListener(imageOriginRequestListener);
                    }
                    return forwardingRequestListener;
                }
                return imageOriginRequestListener;
            }
        }
        return (RequestListener) invokeV.objValue;
    }

    public void initialize(Supplier supplier, String str, CacheKey cacheKey, Object obj, @Nullable ImmutableList immutableList, @Nullable ImageOriginListener imageOriginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{supplier, str, cacheKey, obj, immutableList, imageOriginListener}) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("PipelineDraweeController#initialize");
            }
            super.initialize(str, obj);
            init(supplier);
            this.mCacheKey = cacheKey;
            setCustomDrawableFactories(immutableList);
            clearImageOriginListeners();
            maybeUpdateDebugOverlay(null);
            addImageOriginListener(imageOriginListener);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public synchronized void initializePerformanceMonitoring(@Nullable ImagePerfDataListener imagePerfDataListener, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Supplier supplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, imagePerfDataListener, abstractDraweeControllerBuilder, supplier) == null) {
            synchronized (this) {
                if (this.mImagePerfMonitor != null) {
                    this.mImagePerfMonitor.reset();
                }
                if (imagePerfDataListener != null) {
                    if (this.mImagePerfMonitor == null) {
                        this.mImagePerfMonitor = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this, supplier);
                    }
                    this.mImagePerfMonitor.addImagePerfDataListener(imagePerfDataListener);
                    this.mImagePerfMonitor.setEnabled(true);
                    this.mImagePerfMonitor.updateImageRequestData(abstractDraweeControllerBuilder);
                }
                this.mImageRequest = (ImageRequest) abstractDraweeControllerBuilder.getImageRequest();
                this.mFirstAvailableImageRequests = (ImageRequest[]) abstractDraweeControllerBuilder.getFirstAvailableImageRequests();
                this.mLowResImageRequest = (ImageRequest) abstractDraweeControllerBuilder.getLowResImageRequest();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void onImageLoadedFromCacheImmediately(String str, CloseableReference closeableReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, closeableReference) == null) {
            super.onImageLoadedFromCacheImmediately(str, (Object) closeableReference);
            synchronized (this) {
                if (this.mImageOriginListener != null) {
                    this.mImageOriginListener.onImageLoaded(str, 6, true, "PipelineDraweeController");
                }
            }
        }
    }

    public void updateDebugOverlay(@Nullable CloseableImage closeableImage, DebugControllerOverlayDrawable debugControllerOverlayDrawable) {
        ScaleTypeDrawable activeScaleTypeDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, closeableImage, debugControllerOverlayDrawable) == null) {
            debugControllerOverlayDrawable.setControllerId(getId());
            DraweeHierarchy hierarchy = getHierarchy();
            ScalingUtils.ScaleType scaleType = null;
            if (hierarchy != null && (activeScaleTypeDrawable = ScalingUtils.getActiveScaleTypeDrawable(hierarchy.getTopLevelDrawable())) != null) {
                scaleType = activeScaleTypeDrawable.getScaleType();
            }
            debugControllerOverlayDrawable.setScaleType(scaleType);
            int imageOrigin = this.mDebugOverlayImageOriginListener.getImageOrigin();
            debugControllerOverlayDrawable.setOrigin(ImageOriginUtils.toString(imageOrigin), DebugOverlayImageOriginColor.getImageOriginColor(imageOrigin));
            if (closeableImage != null) {
                debugControllerOverlayDrawable.setDimensions(closeableImage.getWidth(), closeableImage.getHeight());
                debugControllerOverlayDrawable.setImageSize(closeableImage.getSizeInBytes());
                return;
            }
            debugControllerOverlayDrawable.reset();
        }
    }
}
