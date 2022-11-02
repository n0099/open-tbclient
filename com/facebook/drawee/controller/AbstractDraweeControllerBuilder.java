package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    public static /* synthetic */ Interceptable $ic;
    public static final NullPointerException NO_REQUEST_EXCEPTION;
    public static final ControllerListener<Object> sAutoPlayAnimationsListener;
    public static final AtomicLong sIdCounter;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAutoPlayAnimations;
    public final Set<ControllerListener> mBoundControllerListeners;
    public final Set<ControllerListener2> mBoundControllerListeners2;
    @Nullable
    public Object mCallerContext;
    public String mContentDescription;
    public final Context mContext;
    @Nullable
    public ControllerListener<? super INFO> mControllerListener;
    @Nullable
    public ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    @Nullable
    public Supplier<DataSource<IMAGE>> mDataSourceSupplier;
    @Nullable
    public REQUEST mImageRequest;
    @Nullable
    public LoggingListener mLoggingListener;
    @Nullable
    public REQUEST mLowResImageRequest;
    @Nullable
    public REQUEST[] mMultiImageRequests;
    @Nullable
    public DraweeController mOldController;
    public boolean mRetainImageOnFailure;
    public boolean mTapToRetryEnabled;
    public boolean mTryCacheOnlyFirst;

    public abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController draweeController, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    public final BUILDER getThis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this : (BUILDER) invokeV.objValue;
    }

    @ReturnsOwnership
    public abstract AbstractDraweeController obtainController();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class CacheLevel {
        public static final /* synthetic */ CacheLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CacheLevel BITMAP_MEMORY_CACHE;
        public static final CacheLevel DISK_CACHE;
        public static final CacheLevel FULL_FETCH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(234750967, "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder$CacheLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(234750967, "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder$CacheLevel;");
                    return;
                }
            }
            FULL_FETCH = new CacheLevel("FULL_FETCH", 0);
            DISK_CACHE = new CacheLevel("DISK_CACHE", 1);
            CacheLevel cacheLevel = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
            BITMAP_MEMORY_CACHE = cacheLevel;
            $VALUES = new CacheLevel[]{FULL_FETCH, DISK_CACHE, cacheLevel};
        }

        public CacheLevel(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CacheLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CacheLevel) Enum.valueOf(CacheLevel.class, str);
            }
            return (CacheLevel) invokeL.objValue;
        }

        public static CacheLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CacheLevel[]) $VALUES.clone();
            }
            return (CacheLevel[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1834256871, "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1834256871, "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;");
                return;
            }
        }
        sAutoPlayAnimationsListener = new BaseControllerListener<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, obj, animatable) == null) && animatable != null) {
                    animatable.start();
                }
            }
        };
        NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
        sIdCounter = new AtomicLong();
    }

    public void validate() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            boolean z2 = false;
            if (this.mMultiImageRequests != null && this.mImageRequest != null) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkState(z, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
            if (this.mDataSourceSupplier == null || (this.mMultiImageRequests == null && this.mImageRequest == null && this.mLowResImageRequest == null)) {
                z2 = true;
            }
            Preconditions.checkState(z2, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        }
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set, Set<ControllerListener2> set2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, set, set2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mBoundControllerListeners = set;
        this.mBoundControllerListeners2 = set2;
        init();
    }

    public static String generateUniqueControllerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return String.valueOf(sIdCounter.getAndIncrement());
        }
        return (String) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mCallerContext = null;
            this.mImageRequest = null;
            this.mLowResImageRequest = null;
            this.mMultiImageRequests = null;
            this.mTryCacheOnlyFirst = true;
            this.mControllerListener = null;
            this.mLoggingListener = null;
            this.mControllerViewportVisibilityListener = null;
            this.mTapToRetryEnabled = false;
            this.mAutoPlayAnimations = false;
            this.mOldController = null;
            this.mContentDescription = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public AbstractDraweeController build() {
        InterceptResult invokeV;
        REQUEST request;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            validate();
            if (this.mImageRequest == null && this.mMultiImageRequests == null && (request = this.mLowResImageRequest) != null) {
                this.mImageRequest = request;
                this.mLowResImageRequest = null;
            }
            return buildController();
        }
        return (AbstractDraweeController) invokeV.objValue;
    }

    public boolean getAutoPlayAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAutoPlayAnimations;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public Object getCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mCallerContext;
        }
        return invokeV.objValue;
    }

    @Nullable
    public String getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mContentDescription;
        }
        return (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public ControllerListener<? super INFO> getControllerListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mControllerListener;
        }
        return (ControllerListener) invokeV.objValue;
    }

    @Nullable
    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mControllerViewportVisibilityListener;
        }
        return (ControllerViewportVisibilityListener) invokeV.objValue;
    }

    @Nullable
    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mDataSourceSupplier;
        }
        return (Supplier) invokeV.objValue;
    }

    @Nullable
    public REQUEST[] getFirstAvailableImageRequests() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mMultiImageRequests;
        }
        return (REQUEST[]) ((Object[]) invokeV.objValue);
    }

    @Nullable
    public REQUEST getImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mImageRequest;
        }
        return (REQUEST) invokeV.objValue;
    }

    @Nullable
    public LoggingListener getLoggingListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mLoggingListener;
        }
        return (LoggingListener) invokeV.objValue;
    }

    @Nullable
    public REQUEST getLowResImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mLowResImageRequest;
        }
        return (REQUEST) invokeV.objValue;
    }

    @Nullable
    public DraweeController getOldController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mOldController;
        }
        return (DraweeController) invokeV.objValue;
    }

    public boolean getRetainImageOnFailure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mRetainImageOnFailure;
        }
        return invokeV.booleanValue;
    }

    public boolean getTapToRetryEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mTapToRetryEnabled;
        }
        return invokeV.booleanValue;
    }

    public BUILDER reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            init();
            return getThis();
        }
        return (BUILDER) invokeV.objValue;
    }

    public AbstractDraweeController buildController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
            }
            AbstractDraweeController obtainController = obtainController();
            obtainController.setRetainImageOnFailure(getRetainImageOnFailure());
            obtainController.setContentDescription(getContentDescription());
            obtainController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
            maybeBuildAndSetRetryManager(obtainController);
            maybeAttachListeners(obtainController);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return obtainController;
        }
        return (AbstractDraweeController) invokeV.objValue;
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, draweeController, str, request)) == null) {
            return getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.FULL_FETCH);
        }
        return (Supplier) invokeLLL.objValue;
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request, CacheLevel cacheLevel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, draweeController, str, request, cacheLevel)) == null) {
            return new Supplier<DataSource<IMAGE>>(this, draweeController, str, request, getCallerContext(), cacheLevel) { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractDraweeControllerBuilder this$0;
                public final /* synthetic */ CacheLevel val$cacheLevel;
                public final /* synthetic */ Object val$callerContext;
                public final /* synthetic */ DraweeController val$controller;
                public final /* synthetic */ String val$controllerId;
                public final /* synthetic */ Object val$imageRequest;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, draweeController, str, request, r10, cacheLevel};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$controller = draweeController;
                    this.val$controllerId = str;
                    this.val$imageRequest = request;
                    this.val$callerContext = r10;
                    this.val$cacheLevel = cacheLevel;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.facebook.common.internal.Supplier
                public DataSource<IMAGE> get() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return this.this$0.getDataSourceForRequest(this.val$controller, this.val$controllerId, this.val$imageRequest, this.val$callerContext, this.val$cacheLevel);
                    }
                    return (DataSource) invokeV.objValue;
                }

                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return Objects.toStringHelper(this).add("request", this.val$imageRequest.toString()).toString();
                    }
                    return (String) invokeV.objValue;
                }
            };
        }
        return (Supplier) invokeLLLL.objValue;
    }

    public Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController draweeController, String str, REQUEST[] requestArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{draweeController, str, requestArr, Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList(requestArr.length * 2);
            if (z) {
                for (REQUEST request : requestArr) {
                    arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.BITMAP_MEMORY_CACHE));
                }
            }
            for (REQUEST request2 : requestArr) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request2));
            }
            return FirstAvailableDataSourceSupplier.create(arrayList);
        }
        return (Supplier) invokeCommon.objValue;
    }

    public void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, abstractDraweeController) == null) {
            Set<ControllerListener> set = this.mBoundControllerListeners;
            if (set != null) {
                for (ControllerListener controllerListener : set) {
                    abstractDraweeController.addControllerListener(controllerListener);
                }
            }
            Set<ControllerListener2> set2 = this.mBoundControllerListeners2;
            if (set2 != null) {
                for (ControllerListener2 controllerListener2 : set2) {
                    abstractDraweeController.addControllerListener2(controllerListener2);
                }
            }
            ControllerListener<? super INFO> controllerListener3 = this.mControllerListener;
            if (controllerListener3 != null) {
                abstractDraweeController.addControllerListener(controllerListener3);
            }
            if (this.mAutoPlayAnimations) {
                abstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
            }
        }
    }

    public void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, abstractDraweeController) == null) && abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
        }
    }

    public void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, abstractDraweeController) != null) || !this.mTapToRetryEnabled) {
            return;
        }
        abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
        maybeBuildAndSetGestureDetector(abstractDraweeController);
    }

    public BUILDER setAutoPlayAnimations(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            this.mAutoPlayAnimations = z;
            return getThis();
        }
        return (BUILDER) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setCallerContext(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            this.mCallerContext = obj;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setContentDescription(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.mContentDescription = str;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setControllerListener(@Nullable ControllerListener<? super INFO> controllerListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, controllerListener)) == null) {
            this.mControllerListener = controllerListener;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, controllerViewportVisibilityListener)) == null) {
            this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> supplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, supplier)) == null) {
            this.mDataSourceSupplier = supplier;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, requestArr)) == null) {
            return setFirstAvailableImageRequests(requestArr, true);
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setImageRequest(REQUEST request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, request)) == null) {
            this.mImageRequest = request;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setLoggingListener(@Nullable LoggingListener loggingListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, loggingListener)) == null) {
            this.mLoggingListener = loggingListener;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setLowResImageRequest(REQUEST request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, request)) == null) {
            this.mLowResImageRequest = request;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setOldController(@Nullable DraweeController draweeController) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, draweeController)) == null) {
            this.mOldController = draweeController;
            return getThis();
        }
        return (BUILDER) invokeL.objValue;
    }

    public BUILDER setRetainImageOnFailure(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            this.mRetainImageOnFailure = z;
            return getThis();
        }
        return (BUILDER) invokeZ.objValue;
    }

    public BUILDER setTapToRetryEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
            this.mTapToRetryEnabled = z;
            return getThis();
        }
        return (BUILDER) invokeZ.objValue;
    }

    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController draweeController, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, draweeController, str)) == null) {
            Supplier<DataSource<IMAGE>> supplier = this.mDataSourceSupplier;
            if (supplier != null) {
                return supplier;
            }
            Supplier<DataSource<IMAGE>> supplier2 = null;
            REQUEST request = this.mImageRequest;
            if (request != null) {
                supplier2 = getDataSourceSupplierForRequest(draweeController, str, request);
            } else {
                REQUEST[] requestArr = this.mMultiImageRequests;
                if (requestArr != null) {
                    supplier2 = getFirstAvailableDataSourceSupplier(draweeController, str, requestArr, this.mTryCacheOnlyFirst);
                }
            }
            if (supplier2 != null && this.mLowResImageRequest != null) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(supplier2);
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
                supplier2 = IncreasingQualityDataSourceSupplier.create(arrayList, false);
            }
            if (supplier2 == null) {
                return DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
            }
            return supplier2;
        }
        return (Supplier) invokeLL.objValue;
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048612, this, requestArr, z)) == null) {
            if (requestArr != null && requestArr.length <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "No requests specified!");
            this.mMultiImageRequests = requestArr;
            this.mTryCacheOnlyFirst = z;
            return getThis();
        }
        return (BUILDER) invokeLZ.objValue;
    }
}
