package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ForwardingControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes11.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Object> COMPONENT_EXTRAS;
    public static final Map<String, Object> SHORTCUT_EXTRAS;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mCallerContext;
    @Nullable
    public String mContentDescription;
    @Nullable
    public ControllerListener<INFO> mControllerListener;
    public ForwardingControllerListener2<INFO> mControllerListener2;
    @Nullable
    public Drawable mControllerOverlay;
    @Nullable
    public ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    @Nullable
    public DataSource<T> mDataSource;
    public final DeferredReleaser mDeferredReleaser;
    @Nullable
    public Drawable mDrawable;
    public final DraweeEventTracker mEventTracker;
    @Nullable
    public T mFetchedImage;
    @Nullable
    public GestureDetector mGestureDetector;
    public boolean mHasFetchFailed;
    public String mId;
    public boolean mIsAttached;
    public boolean mIsRequestSubmitted;
    public boolean mIsVisibleInViewportHint;
    public boolean mJustConstructed;
    @Nullable
    public LoggingListener mLoggingListener;
    public boolean mRetainImageOnFailure;
    @Nullable
    public RetryManager mRetryManager;
    @Nullable
    public SettableDraweeHierarchy mSettableDraweeHierarchy;
    public final Executor mUiThreadImmediateExecutor;

    /* loaded from: classes11.dex */
    public static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public InternalForwardingListener() {
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

        public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, controllerListener, controllerListener2)) == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
                }
                InternalForwardingListener<INFO> internalForwardingListener = new InternalForwardingListener<>();
                internalForwardingListener.addListener(controllerListener);
                internalForwardingListener.addListener(controllerListener2);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return internalForwardingListener;
            }
            return (InternalForwardingListener) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(111528034, "Lcom/facebook/drawee/controller/AbstractDraweeController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(111528034, "Lcom/facebook/drawee/controller/AbstractDraweeController;");
                return;
            }
        }
        COMPONENT_EXTRAS = ImmutableMap.of("component_tag", "drawee");
        SHORTCUT_EXTRAS = ImmutableMap.of("origin", "memory_bitmap", ProducerContext.ExtraKeys.ORIGIN_SUBCATEGORY, "shortcut");
        TAG = AbstractDraweeController.class;
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {deferredReleaser, executor, str, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEventTracker = DraweeEventTracker.newInstance();
        this.mControllerListener2 = new ForwardingControllerListener2<>();
        this.mJustConstructed = true;
        this.mDeferredReleaser = deferredReleaser;
        this.mUiThreadImmediateExecutor = executor;
        init(str, obj);
    }

    @Nullable
    private Rect getDimensions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy == null) {
                return null;
            }
            return settableDraweeHierarchy.getBounds();
        }
        return (Rect) invokeV.objValue;
    }

    private synchronized void init(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, obj) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("AbstractDraweeController#init");
                }
                this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
                if (!this.mJustConstructed && this.mDeferredReleaser != null) {
                    this.mDeferredReleaser.cancelDeferredRelease(this);
                }
                this.mIsAttached = false;
                this.mIsVisibleInViewportHint = false;
                releaseFetch();
                this.mRetainImageOnFailure = false;
                if (this.mRetryManager != null) {
                    this.mRetryManager.init();
                }
                if (this.mGestureDetector != null) {
                    this.mGestureDetector.init();
                    this.mGestureDetector.setClickListener(this);
                }
                if (this.mControllerListener instanceof InternalForwardingListener) {
                    ((InternalForwardingListener) this.mControllerListener).clearListeners();
                } else {
                    this.mControllerListener = null;
                }
                this.mControllerViewportVisibilityListener = null;
                if (this.mSettableDraweeHierarchy != null) {
                    this.mSettableDraweeHierarchy.reset();
                    this.mSettableDraweeHierarchy.setControllerOverlay(null);
                    this.mSettableDraweeHierarchy = null;
                }
                this.mControllerOverlay = null;
                if (FLog.isLoggable(2)) {
                    FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
                }
                this.mId = str;
                this.mCallerContext = obj;
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                if (this.mLoggingListener != null) {
                    setUpLoggingListener();
                }
            }
        }
    }

    private boolean isExpectedDataSource(String str, DataSource<T> dataSource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, dataSource)) == null) {
            if (dataSource == null && this.mDataSource == null) {
                return true;
            }
            return str.equals(this.mId) && dataSource == this.mDataSource && this.mIsRequestSubmitted;
        }
        return invokeLL.booleanValue;
    }

    private void logMessageAndFailure(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, this, str, th) == null) && FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    private void logMessageAndImage(String str, T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, this, str, t) == null) && FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, getImageClass(t), Integer.valueOf(getImageHash(t)));
        }
    }

    private ControllerListener2.Extras obtainExtras(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2, @Nullable Uri uri) {
        InterceptResult invokeLLL;
        String str;
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, map, map2, uri)) == null) {
            SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
                String valueOf = String.valueOf(((GenericDraweeHierarchy) settableDraweeHierarchy).getActualImageScaleType());
                pointF = ((GenericDraweeHierarchy) this.mSettableDraweeHierarchy).getActualImageFocusPoint();
                str = valueOf;
            } else {
                str = null;
                pointF = null;
            }
            return MiddlewareUtils.obtainExtras(COMPONENT_EXTRAS, SHORTCUT_EXTRAS, map, getDimensions(), str, pointF, map2, getCallerContext(), uri);
        }
        return (ControllerListener2.Extras) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailureInternal(String str, DataSource<T> dataSource, Throwable th, boolean z) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{str, dataSource, th, Boolean.valueOf(z)}) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
            }
            if (!isExpectedDataSource(str, dataSource)) {
                logMessageAndFailure("ignore_old_datasource @ onFailure", th);
                dataSource.close();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
            if (z) {
                logMessageAndFailure("final_failed @ onFailure", th);
                this.mDataSource = null;
                this.mHasFetchFailed = true;
                if (this.mRetainImageOnFailure && (drawable = this.mDrawable) != null) {
                    this.mSettableDraweeHierarchy.setImage(drawable, 1.0f, true);
                } else if (shouldRetryOnTap()) {
                    this.mSettableDraweeHierarchy.setRetry(th);
                } else {
                    this.mSettableDraweeHierarchy.setFailure(th);
                }
                reportFailure(th, dataSource);
            } else {
                logMessageAndFailure("intermediate_failed @ onFailure", th);
                reportIntermediateFailure(th);
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void onNewResultInternal(String str, DataSource<T> dataSource, @Nullable T t, float f2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{str, dataSource, t, Float.valueOf(f2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");
                }
                if (!isExpectedDataSource(str, dataSource)) {
                    logMessageAndImage("ignore_old_datasource @ onNewResult", t);
                    releaseImage(t);
                    dataSource.close();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
                try {
                    Drawable createDrawable = createDrawable(t);
                    T t2 = this.mFetchedImage;
                    Drawable drawable = this.mDrawable;
                    this.mFetchedImage = t;
                    this.mDrawable = createDrawable;
                    if (z) {
                        logMessageAndImage("set_final_result @ onNewResult", t);
                        this.mDataSource = null;
                        this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z2);
                        reportSuccess(str, t, dataSource);
                    } else if (z3) {
                        logMessageAndImage("set_temporary_result @ onNewResult", t);
                        this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z2);
                        reportSuccess(str, t, dataSource);
                    } else {
                        logMessageAndImage("set_intermediate_result @ onNewResult", t);
                        this.mSettableDraweeHierarchy.setImage(createDrawable, f2, z2);
                        reportIntermediateSet(str, t);
                    }
                    if (drawable != null && drawable != createDrawable) {
                        releaseDrawable(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        logMessageAndImage("release_previous_result @ onNewResult", t2);
                        releaseImage(t2);
                    }
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Exception e2) {
                    logMessageAndImage("drawable_failed @ onNewResult", t);
                    releaseImage(t);
                    onFailureInternal(str, dataSource, e2, z);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            } catch (Throwable th) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgressUpdateInternal(String str, DataSource<T> dataSource, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{str, dataSource, Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (!isExpectedDataSource(str, dataSource)) {
                logMessageAndFailure("ignore_old_datasource @ onProgress", null);
                dataSource.close();
            } else if (z) {
            } else {
                this.mSettableDraweeHierarchy.setProgress(f2, false);
            }
        }
    }

    private void releaseFetch() {
        Map<String, Object> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            boolean z = this.mIsRequestSubmitted;
            this.mIsRequestSubmitted = false;
            this.mHasFetchFailed = false;
            DataSource<T> dataSource = this.mDataSource;
            Map<String, Object> map2 = null;
            if (dataSource != null) {
                map = dataSource.getExtras();
                this.mDataSource.close();
                this.mDataSource = null;
            } else {
                map = null;
            }
            Drawable drawable = this.mDrawable;
            if (drawable != null) {
                releaseDrawable(drawable);
            }
            if (this.mContentDescription != null) {
                this.mContentDescription = null;
            }
            this.mDrawable = null;
            T t = this.mFetchedImage;
            if (t != null) {
                Map<String, Object> obtainExtrasFromImage = obtainExtrasFromImage(getImageInfo(t));
                logMessageAndImage("release", this.mFetchedImage);
                releaseImage(this.mFetchedImage);
                this.mFetchedImage = null;
                map2 = obtainExtrasFromImage;
            }
            if (z) {
                reportRelease(map, map2);
            }
        }
    }

    private void reportFailure(Throwable th, @Nullable DataSource<T> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, this, th, dataSource) == null) {
            ControllerListener2.Extras obtainExtras = obtainExtras(dataSource, (DataSource<T>) null, (Uri) null);
            getControllerListener().onFailure(this.mId, th);
            getControllerListener2().onFailure(this.mId, th, obtainExtras);
        }
    }

    private void reportIntermediateFailure(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, th) == null) {
            getControllerListener().onIntermediateImageFailed(this.mId, th);
            getControllerListener2().onIntermediateImageFailed(this.mId);
        }
    }

    private void reportIntermediateSet(String str, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, str, t) == null) {
            INFO imageInfo = getImageInfo(t);
            getControllerListener().onIntermediateImageSet(str, imageInfo);
            getControllerListener2().onIntermediateImageSet(str, imageInfo);
        }
    }

    private void reportRelease(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, map, map2) == null) {
            getControllerListener().onRelease(this.mId);
            getControllerListener2().onRelease(this.mId, obtainExtras(map, map2, (Uri) null));
        }
    }

    private void reportSuccess(String str, @Nullable T t, @Nullable DataSource<T> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, this, str, t, dataSource) == null) {
            INFO imageInfo = getImageInfo(t);
            getControllerListener().onFinalImageSet(str, imageInfo, getAnimatable());
            getControllerListener2().onFinalImageSet(str, imageInfo, obtainExtras(dataSource, (DataSource<T>) imageInfo, (Uri) null));
        }
    }

    private void setUpLoggingListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
                ((GenericDraweeHierarchy) settableDraweeHierarchy).setOnFadeFinishedListener(new FadeDrawable.OnFadeFinishedListener(this) { // from class: com.facebook.drawee.controller.AbstractDraweeController.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AbstractDraweeController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // com.facebook.drawee.drawable.FadeDrawable.OnFadeFinishedListener
                    public void onFadeFinished() {
                        AbstractDraweeController abstractDraweeController;
                        LoggingListener loggingListener;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (loggingListener = (abstractDraweeController = this.this$0).mLoggingListener) == null) {
                            return;
                        }
                        loggingListener.onFadeFinished(abstractDraweeController.mId);
                    }
                });
            }
        }
    }

    private boolean shouldRetryOnTap() {
        InterceptResult invokeV;
        RetryManager retryManager;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) ? this.mHasFetchFailed && (retryManager = this.mRetryManager) != null && retryManager.shouldRetryOnTap() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.facebook.drawee.controller.ControllerListener<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addControllerListener(ControllerListener<? super INFO> controllerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, controllerListener) == null) {
            Preconditions.checkNotNull(controllerListener);
            ControllerListener<INFO> controllerListener2 = this.mControllerListener;
            if (controllerListener2 instanceof InternalForwardingListener) {
                ((InternalForwardingListener) controllerListener2).addListener(controllerListener);
            } else if (controllerListener2 != null) {
                this.mControllerListener = InternalForwardingListener.createInternal(controllerListener2, controllerListener);
            } else {
                this.mControllerListener = controllerListener;
            }
        }
    }

    public void addControllerListener2(ControllerListener2<INFO> controllerListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, controllerListener2) == null) {
            this.mControllerListener2.addListener(controllerListener2);
        }
    }

    public abstract Drawable createDrawable(T t);

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public Animatable getAnimatable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Drawable drawable = this.mDrawable;
            if (drawable instanceof Animatable) {
                return (Animatable) drawable;
            }
            return null;
        }
        return (Animatable) invokeV.objValue;
    }

    @Nullable
    public T getCachedImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (T) invokeV.objValue;
    }

    public Object getCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCallerContext : invokeV.objValue;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public String getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mContentDescription : (String) invokeV.objValue;
    }

    public ControllerListener<INFO> getControllerListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ControllerListener<INFO> controllerListener = this.mControllerListener;
            return controllerListener == null ? BaseControllerListener.getNoOpListener() : controllerListener;
        }
        return (ControllerListener) invokeV.objValue;
    }

    public ControllerListener2<INFO> getControllerListener2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mControllerListener2 : (ControllerListener2) invokeV.objValue;
    }

    @Nullable
    public Drawable getControllerOverlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mControllerOverlay : (Drawable) invokeV.objValue;
    }

    public abstract DataSource<T> getDataSource();

    @Nullable
    public GestureDetector getGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mGestureDetector : (GestureDetector) invokeV.objValue;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public DraweeHierarchy getHierarchy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSettableDraweeHierarchy : (DraweeHierarchy) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    public String getImageClass(@Nullable T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, t)) == null) ? t != null ? t.getClass().getSimpleName() : "<null>" : (String) invokeL.objValue;
    }

    public int getImageHash(@Nullable T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, t)) == null) ? System.identityHashCode(t) : invokeL.intValue;
    }

    @Nullable
    public abstract INFO getImageInfo(T t);

    @Nullable
    public LoggingListener getLoggingListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mLoggingListener : (LoggingListener) invokeV.objValue;
    }

    @Nullable
    public Uri getMainUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (Uri) invokeV.objValue;
    }

    @ReturnsOwnership
    public RetryManager getRetryManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mRetryManager == null) {
                this.mRetryManager = new RetryManager();
            }
            return this.mRetryManager;
        }
        return (RetryManager) invokeV.objValue;
    }

    public void initialize(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, obj) == null) {
            init(str, obj);
            this.mJustConstructed = false;
        }
    }

    @Nullable
    public abstract Map<String, Object> obtainExtrasFromImage(INFO info);

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#onAttach");
            }
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mIsRequestSubmitted ? "request already submitted" : "request needs submit");
            }
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
            this.mDeferredReleaser.cancelDeferredRelease(this);
            this.mIsAttached = true;
            if (!this.mIsRequestSubmitted) {
                submitRequest();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    @Override // com.facebook.drawee.gestures.GestureDetector.ClickListener
    public boolean onClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
            }
            if (shouldRetryOnTap()) {
                this.mRetryManager.notifyTapToRetry();
                this.mSettableDraweeHierarchy.reset();
                submitRequest();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#onDetach");
            }
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
            }
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mIsAttached = false;
            this.mDeferredReleaser.scheduleDeferredRelease(this);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public void onImageLoadedFromCacheImmediately(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, t) == null) {
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
            }
            GestureDetector gestureDetector = this.mGestureDetector;
            if (gestureDetector == null) {
                return false;
            }
            if (gestureDetector.isCapturingGesture() || shouldHandleGesture()) {
                this.mGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onViewportVisibilityHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            ControllerViewportVisibilityListener controllerViewportVisibilityListener = this.mControllerViewportVisibilityListener;
            if (controllerViewportVisibilityListener != null) {
                if (z && !this.mIsVisibleInViewportHint) {
                    controllerViewportVisibilityListener.onDraweeViewportEntry(this.mId);
                } else if (!z && this.mIsVisibleInViewportHint) {
                    controllerViewportVisibilityListener.onDraweeViewportExit(this.mId);
                }
            }
            this.mIsVisibleInViewportHint = z;
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
            RetryManager retryManager = this.mRetryManager;
            if (retryManager != null) {
                retryManager.reset();
            }
            GestureDetector gestureDetector = this.mGestureDetector;
            if (gestureDetector != null) {
                gestureDetector.reset();
            }
            SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy != null) {
                settableDraweeHierarchy.reset();
            }
            releaseFetch();
        }
    }

    public abstract void releaseDrawable(@Nullable Drawable drawable);

    public abstract void releaseImage(@Nullable T t);

    public void removeControllerListener(ControllerListener<? super INFO> controllerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, controllerListener) == null) {
            Preconditions.checkNotNull(controllerListener);
            ControllerListener<INFO> controllerListener2 = this.mControllerListener;
            if (controllerListener2 instanceof InternalForwardingListener) {
                ((InternalForwardingListener) controllerListener2).removeListener(controllerListener);
            } else if (controllerListener2 == controllerListener) {
                this.mControllerListener = null;
            }
        }
    }

    public void removeControllerListener2(ControllerListener2<INFO> controllerListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, controllerListener2) == null) {
            this.mControllerListener2.removeListener(controllerListener2);
        }
    }

    public void reportSubmit(DataSource<T> dataSource, @Nullable INFO info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, dataSource, info) == null) {
            getControllerListener().onSubmit(this.mId, this.mCallerContext);
            getControllerListener2().onSubmit(this.mId, this.mCallerContext, obtainExtras(dataSource, (DataSource<T>) info, getMainUri()));
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setContentDescription(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.mContentDescription = str;
        }
    }

    public void setControllerOverlay(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, drawable) == null) {
            this.mControllerOverlay = drawable;
            SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy != null) {
                settableDraweeHierarchy.setControllerOverlay(drawable);
            }
        }
    }

    public void setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, controllerViewportVisibilityListener) == null) {
            this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
        }
    }

    public void setGestureDetector(@Nullable GestureDetector gestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, gestureDetector) == null) {
            this.mGestureDetector = gestureDetector;
            if (gestureDetector != null) {
                gestureDetector.setClickListener(this);
            }
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@Nullable DraweeHierarchy draweeHierarchy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, draweeHierarchy) == null) {
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, draweeHierarchy);
            }
            this.mEventTracker.recordEvent(draweeHierarchy != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
            if (this.mIsRequestSubmitted) {
                this.mDeferredReleaser.cancelDeferredRelease(this);
                release();
            }
            SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy != null) {
                settableDraweeHierarchy.setControllerOverlay(null);
                this.mSettableDraweeHierarchy = null;
            }
            if (draweeHierarchy != null) {
                Preconditions.checkArgument(draweeHierarchy instanceof SettableDraweeHierarchy);
                SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
                this.mSettableDraweeHierarchy = settableDraweeHierarchy2;
                settableDraweeHierarchy2.setControllerOverlay(this.mControllerOverlay);
            }
            if (this.mLoggingListener != null) {
                setUpLoggingListener();
            }
        }
    }

    public void setLoggingListener(LoggingListener loggingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, loggingListener) == null) {
            this.mLoggingListener = loggingListener;
        }
    }

    public void setRetainImageOnFailure(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.mRetainImageOnFailure = z;
        }
    }

    public boolean shouldHandleGesture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? shouldRetryOnTap() : invokeV.booleanValue;
    }

    public void submitRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#submitRequest");
            }
            T cachedImage = getCachedImage();
            if (cachedImage != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("AbstractDraweeController#submitRequest->cache");
                }
                this.mDataSource = null;
                this.mIsRequestSubmitted = true;
                this.mHasFetchFailed = false;
                this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
                reportSubmit(this.mDataSource, getImageInfo(cachedImage));
                onImageLoadedFromCacheImmediately(this.mId, cachedImage);
                onNewResultInternal(this.mId, this.mDataSource, cachedImage, 1.0f, true, true, true);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
            this.mSettableDraweeHierarchy.setProgress(0.0f, true);
            this.mIsRequestSubmitted = true;
            this.mHasFetchFailed = false;
            DataSource<T> dataSource = getDataSource();
            this.mDataSource = dataSource;
            reportSubmit(dataSource, null);
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
            }
            this.mDataSource.subscribe(new BaseDataSubscriber<T>(this, this.mId, this.mDataSource.hasResult()) { // from class: com.facebook.drawee.controller.AbstractDraweeController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractDraweeController this$0;
                public final /* synthetic */ String val$id;
                public final /* synthetic */ boolean val$wasImmediate;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Boolean.valueOf(r8)};
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
                    this.val$id = r7;
                    this.val$wasImmediate = r8;
                }

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(DataSource<T> dataSource2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dataSource2) == null) {
                        this.this$0.onFailureInternal(this.val$id, dataSource2, dataSource2.getFailureCause(), true);
                    }
                }

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onNewResultImpl(DataSource<T> dataSource2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource2) == null) {
                        boolean isFinished = dataSource2.isFinished();
                        boolean hasMultipleResults = dataSource2.hasMultipleResults();
                        float progress = dataSource2.getProgress();
                        T result = dataSource2.getResult();
                        if (result != null) {
                            this.this$0.onNewResultInternal(this.val$id, dataSource2, result, progress, isFinished, this.val$wasImmediate, hasMultipleResults);
                        } else if (isFinished) {
                            this.this$0.onFailureInternal(this.val$id, dataSource2, new NullPointerException(), true);
                        }
                    }
                }

                @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
                public void onProgressUpdate(DataSource<T> dataSource2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSource2) == null) {
                        boolean isFinished = dataSource2.isFinished();
                        this.this$0.onProgressUpdateInternal(this.val$id, dataSource2, dataSource2.getProgress(), isFinished);
                    }
                }
            }, this.mUiThreadImmediateExecutor);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString() : (String) invokeV.objValue;
    }

    private ControllerListener2.Extras obtainExtras(@Nullable DataSource<T> dataSource, @Nullable INFO info, @Nullable Uri uri) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, this, dataSource, info, uri)) == null) {
            return obtainExtras(dataSource == null ? null : dataSource.getExtras(), obtainExtrasFromImage(info), uri);
        }
        return (ControllerListener2.Extras) invokeLLL.objValue;
    }
}
