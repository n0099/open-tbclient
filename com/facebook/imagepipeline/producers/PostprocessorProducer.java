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
/* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean mIsClosed;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean mIsDirty;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean mIsPostProcessingRunning;
        public final ProducerListener2 mListener;
        public final Postprocessor mPostprocessor;
        public final ProducerContext mProducerContext;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        public CloseableReference<CloseableImage> mSourceImageRef;
        @GuardedBy("PostprocessorConsumer.this")
        public int mStatus;
        public final /* synthetic */ PostprocessorProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostprocessorConsumer(PostprocessorProducer postprocessorProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postprocessorProducer, consumer, producerListener2, postprocessor, producerContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            this.mListener = producerListener2;
            this.mPostprocessor = postprocessor;
            this.mProducerContext = producerContext;
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
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
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

        private void maybeNotifyOnFailure(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65550, this, th) == null) && close()) {
                getConsumer().onFailure(th);
            }
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, closeableImage)) == null) {
                return closeableImage instanceof CloseableStaticBitmap;
            }
            return invokeL.booleanValue;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                maybeNotifyOnFailure(th);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65551, this, closeableReference, i) == null) {
                boolean isLast = BaseConsumer.isLast(i);
                if ((!isLast && !isClosed()) || (isLast && close())) {
                    getConsumer().onNewResult(closeableReference, i);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, closeableReference, i) == null) {
                if (!CloseableReference.isValid(closeableReference)) {
                    if (BaseConsumer.isLast(i)) {
                        maybeNotifyOnNewResult(null, i);
                        return;
                    }
                    return;
                }
                updateSourceImageRef(closeableReference, i);
            }
        }

        @Nullable
        private Map<String, String> getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, this, producerListener2, producerContext, postprocessor)) == null) {
                if (!producerListener2.requiresExtraMap(producerContext, PostprocessorProducer.NAME)) {
                    return null;
                }
                return ImmutableMap.of(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
            }
            return (Map) invokeLLL.objValue;
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

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
                synchronized (this) {
                    if (!this.mIsClosed && this.mIsDirty && !this.mIsPostProcessingRunning && CloseableReference.isValid(this.mSourceImageRef)) {
                        this.mIsPostProcessingRunning = true;
                        return true;
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                        int i;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (this.this$1) {
                                closeableReference = this.this$1.mSourceImageRef;
                                i = this.this$1.mStatus;
                                this.this$1.mSourceImageRef = null;
                                this.this$1.mIsDirty = false;
                            }
                            if (CloseableReference.isValid(closeableReference)) {
                                try {
                                    this.this$1.doPostprocessing(closeableReference, i);
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

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                maybeNotifyOnCancellation();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65546, this, closeableReference, i) == null) {
                Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
                if (!shouldPostprocess(closeableReference.get())) {
                    maybeNotifyOnNewResult(closeableReference, i);
                    return;
                }
                this.mListener.onProducerStart(this.mProducerContext, PostprocessorProducer.NAME);
                try {
                    try {
                        CloseableReference<CloseableImage> postprocessInternal = postprocessInternal(closeableReference.get());
                        this.mListener.onProducerFinishWithSuccess(this.mProducerContext, PostprocessorProducer.NAME, getExtraMap(this.mListener, this.mProducerContext, this.mPostprocessor));
                        maybeNotifyOnNewResult(postprocessInternal, i);
                        CloseableReference.closeSafely(postprocessInternal);
                    } catch (Exception e) {
                        this.mListener.onProducerFinishWithFailure(this.mProducerContext, PostprocessorProducer.NAME, e, getExtraMap(this.mListener, this.mProducerContext, this.mPostprocessor));
                        maybeNotifyOnFailure(e);
                        CloseableReference.closeSafely((CloseableReference<?>) null);
                    }
                } catch (Throwable th) {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    throw th;
                }
            }
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, closeableImage)) == null) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
                CloseableReference<Bitmap> process = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), this.this$0.mBitmapFactory);
                try {
                    CloseableStaticBitmap closeableStaticBitmap2 = new CloseableStaticBitmap(process, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                    closeableStaticBitmap2.setImageExtras(closeableStaticBitmap.getExtras());
                    return CloseableReference.of(closeableStaticBitmap2);
                } finally {
                    CloseableReference.closeSafely(process);
                }
            }
            return (CloseableReference) invokeL.objValue;
        }

        private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65556, this, closeableReference, i) == null) {
                synchronized (this) {
                    if (this.mIsClosed) {
                        return;
                    }
                    CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                    this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                    this.mStatus = i;
                    this.mIsDirty = true;
                    boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                    CloseableReference.closeSafely(closeableReference2);
                    if (runningIfDirtyAndNotRunning) {
                        submitPostprocessing();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        public boolean mIsClosed;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        public CloseableReference<CloseableImage> mSourceImageRef;
        public final /* synthetic */ PostprocessorProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RepeatedPostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postprocessorProducer, postprocessorConsumer, repeatedPostprocessor, producerContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
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

        public /* synthetic */ RepeatedPostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext, AnonymousClass1 anonymousClass1) {
            this(postprocessorProducer, postprocessorConsumer, repeatedPostprocessor, producerContext);
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

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) && close()) {
                getConsumer().onFailure(th);
            }
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

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this) {
                    updateInternal();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, closeableReference, i) != null) || BaseConsumer.isNotLast(i)) {
                return;
            }
            setSourceImageRef(closeableReference);
            updateInternal();
        }
    }

    /* loaded from: classes7.dex */
    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostprocessorProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SingleUsePostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postprocessorProducer, postprocessorConsumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = postprocessorProducer;
        }

        public /* synthetic */ SingleUsePostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, AnonymousClass1 anonymousClass1) {
            this(postprocessorProducer, postprocessorConsumer);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, closeableReference, i) != null) || BaseConsumer.isNotLast(i)) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, platformBitmapFactory, executor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            ProducerListener2 producerListener = producerContext.getProducerListener();
            Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
            PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(this, consumer, producerListener, postprocessor, producerContext);
            if (postprocessor instanceof RepeatedPostprocessor) {
                singleUsePostprocessorConsumer = new RepeatedPostprocessorConsumer(this, postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext, null);
            } else {
                singleUsePostprocessorConsumer = new SingleUsePostprocessorConsumer(this, postprocessorConsumer, null);
            }
            this.mInputProducer.produceResults(singleUsePostprocessorConsumer, producerContext);
        }
    }
}
