package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NAME = "PostprocessorProducer";
    @VisibleForTesting
    public static final String POSTPROCESSOR = "Postprocessor";
    public transient /* synthetic */ FieldHolder $fh;
    public final PlatformBitmapFactory mBitmapFactory;
    public final Executor mExecutor;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;

    /* renamed from: com.facebook.imagepipeline.producers.PostprocessorProducer$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean mIsClosed;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean mIsDirty;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean mIsPostProcessingRunning;
        public final ProducerListener mListener;
        public final Postprocessor mPostprocessor;
        public final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        public CloseableReference<CloseableImage> mSourceImageRef;
        @GuardedBy("PostprocessorConsumer.this")
        public int mStatus;
        public final /* synthetic */ PostprocessorProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostprocessorConsumer(PostprocessorProducer postprocessorProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener producerListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postprocessorProducer, consumer, producerListener, str, postprocessor, producerContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = postprocessorProducer;
            this.mSourceImageRef = null;
            this.mStatus = 0;
            this.mIsDirty = false;
            this.mIsPostProcessingRunning = false;
            this.mListener = producerListener;
            this.mRequestId = str;
            this.mPostprocessor = postprocessor;
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this, postprocessorProducer) { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PostprocessorConsumer this$1;
                public final /* synthetic */ PostprocessorProducer val$this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, postprocessorProducer};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = postprocessorProducer;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$1.maybeNotifyOnCancellation();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65544, this) == null) {
                synchronized (this) {
                    this.mIsPostProcessingRunning = false;
                    runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                }
                if (runningIfDirtyAndNotRunning) {
                    submitPostprocessing();
                }
            }
        }

        private boolean close() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
                synchronized (this) {
                    if (this.mIsClosed) {
                        return false;
                    }
                    CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                    this.mSourceImageRef = null;
                    this.mIsClosed = true;
                    CloseableReference.closeSafely(closeableReference);
                    return true;
                }
            }
            return invokeV.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65546, this, closeableReference, i2) == null) {
                Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
                if (!shouldPostprocess(closeableReference.get())) {
                    maybeNotifyOnNewResult(closeableReference, i2);
                    return;
                }
                this.mListener.onProducerStart(this.mRequestId, PostprocessorProducer.NAME);
                try {
                    try {
                        CloseableReference<CloseableImage> postprocessInternal = postprocessInternal(closeableReference.get());
                        this.mListener.onProducerFinishWithSuccess(this.mRequestId, PostprocessorProducer.NAME, getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
                        maybeNotifyOnNewResult(postprocessInternal, i2);
                        CloseableReference.closeSafely(postprocessInternal);
                    } catch (Exception e2) {
                        this.mListener.onProducerFinishWithFailure(this.mRequestId, PostprocessorProducer.NAME, e2, getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
                        maybeNotifyOnFailure(e2);
                        CloseableReference.closeSafely((CloseableReference<?>) null);
                    }
                } catch (Throwable th) {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    throw th;
                }
            }
        }

        @Nullable
        private Map<String, String> getExtraMap(ProducerListener producerListener, String str, Postprocessor postprocessor) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, this, producerListener, str, postprocessor)) == null) {
                if (producerListener.requiresExtraMap(str)) {
                    return ImmutableMap.of(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
                }
                return null;
            }
            return (Map) invokeLLL.objValue;
        }

        private synchronized boolean isClosed() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
                synchronized (this) {
                    z = this.mIsClosed;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeNotifyOnCancellation() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65549, this) == null) && close()) {
                getConsumer().onCancellation();
            }
        }

        private void maybeNotifyOnFailure(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65550, this, th) == null) && close()) {
                getConsumer().onFailure(th);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65551, this, closeableReference, i2) == null) {
                boolean isLast = BaseConsumer.isLast(i2);
                if ((isLast || isClosed()) && !(isLast && close())) {
                    return;
                }
                getConsumer().onNewResult(closeableReference, i2);
            }
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, closeableImage)) == null) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
                CloseableReference<Bitmap> process = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), this.this$0.mBitmapFactory);
                try {
                    return CloseableReference.of(new CloseableStaticBitmap(process, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation()));
                } finally {
                    CloseableReference.closeSafely(process);
                }
            }
            return (CloseableReference) invokeL.objValue;
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
                synchronized (this) {
                    if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                        return false;
                    }
                    this.mIsPostProcessingRunning = true;
                    return true;
                }
            }
            return invokeV.booleanValue;
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65554, this, closeableImage)) == null) ? closeableImage instanceof CloseableStaticBitmap : invokeL.booleanValue;
        }

        private void submitPostprocessing() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.this$0.mExecutor.execute(new Runnable(this) { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PostprocessorConsumer this$1;

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
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        CloseableReference closeableReference;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (this.this$1) {
                                closeableReference = this.this$1.mSourceImageRef;
                                i2 = this.this$1.mStatus;
                                this.this$1.mSourceImageRef = null;
                                this.this$1.mIsDirty = false;
                            }
                            if (CloseableReference.isValid(closeableReference)) {
                                try {
                                    this.this$1.doPostprocessing(closeableReference, i2);
                                } finally {
                                    CloseableReference.closeSafely(closeableReference);
                                }
                            }
                            this.this$1.clearRunningAndStartIfDirty();
                        }
                    }
                });
            }
        }

        private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> closeableReference, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65556, this, closeableReference, i2) == null) {
                synchronized (this) {
                    if (this.mIsClosed) {
                        return;
                    }
                    CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                    this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                    this.mStatus = i2;
                    this.mIsDirty = true;
                    boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                    CloseableReference.closeSafely(closeableReference2);
                    if (runningIfDirtyAndNotRunning) {
                        submitPostprocessing();
                    }
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                maybeNotifyOnCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                maybeNotifyOnFailure(th);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, closeableReference, i2) == null) {
                if (!CloseableReference.isValid(closeableReference)) {
                    if (BaseConsumer.isLast(i2)) {
                        maybeNotifyOnNewResult(null, i2);
                        return;
                    }
                    return;
                }
                updateSourceImageRef(closeableReference, i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        public boolean mIsClosed;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        public CloseableReference<CloseableImage> mSourceImageRef;
        public final /* synthetic */ PostprocessorProducer this$0;

        public /* synthetic */ RepeatedPostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext, AnonymousClass1 anonymousClass1) {
            this(postprocessorProducer, postprocessorConsumer, repeatedPostprocessor, producerContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean close() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                synchronized (this) {
                    if (this.mIsClosed) {
                        return false;
                    }
                    CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                    this.mSourceImageRef = null;
                    this.mIsClosed = true;
                    CloseableReference.closeSafely(closeableReference);
                    return true;
                }
            }
            return invokeV.booleanValue;
        }

        private void setSourceImageRef(CloseableReference<CloseableImage> closeableReference) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, closeableReference) == null) {
                synchronized (this) {
                    if (this.mIsClosed) {
                        return;
                    }
                    CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                    this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                    CloseableReference.closeSafely(closeableReference2);
                }
            }
        }

        private void updateInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                synchronized (this) {
                    if (this.mIsClosed) {
                        return;
                    }
                    CloseableReference<CloseableImage> cloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                    try {
                        getConsumer().onNewResult(cloneOrNull, 0);
                    } finally {
                        CloseableReference.closeSafely(cloneOrNull);
                    }
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && close()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) && close()) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this) {
                    updateInternal();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RepeatedPostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postprocessorProducer, postprocessorConsumer, repeatedPostprocessor, producerContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = postprocessorProducer;
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this, postprocessorProducer) { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RepeatedPostprocessorConsumer this$1;
                public final /* synthetic */ PostprocessorProducer val$this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, postprocessorProducer};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = postprocessorProducer;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$1.close()) {
                        this.this$1.getConsumer().onCancellation();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, closeableReference, i2) == null) || BaseConsumer.isNotLast(i2)) {
                return;
            }
            setSourceImageRef(closeableReference);
            updateInternal();
        }
    }

    /* loaded from: classes12.dex */
    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostprocessorProducer this$0;

        public /* synthetic */ SingleUsePostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, AnonymousClass1 anonymousClass1) {
            this(postprocessorProducer, postprocessorConsumer);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SingleUsePostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postprocessorProducer, postprocessorConsumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = postprocessorProducer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, closeableReference, i2) == null) || BaseConsumer.isNotLast(i2)) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i2);
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, platformBitmapFactory, executor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<CloseableReference<CloseableImage>> singleUsePostprocessorConsumer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            ProducerListener listener = producerContext.getListener();
            Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
            PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(this, consumer, listener, producerContext.getId(), postprocessor, producerContext);
            if (postprocessor instanceof RepeatedPostprocessor) {
                singleUsePostprocessorConsumer = new RepeatedPostprocessorConsumer(this, postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext, null);
            } else {
                singleUsePostprocessorConsumer = new SingleUsePostprocessorConsumer(this, postprocessorConsumer, null);
            }
            this.mInputProducer.produceResults(singleUsePostprocessorConsumer, producerContext);
        }
    }
}
