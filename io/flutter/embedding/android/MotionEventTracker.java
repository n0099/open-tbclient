package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
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
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class MotionEventTracker {
    public static /* synthetic */ Interceptable $ic;
    public static MotionEventTracker INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final LongSparseArray<MotionEvent> eventById;
    public final PriorityQueue<Long> unusedEvents;

    /* loaded from: classes8.dex */
    public static class MotionEventId {
        public static /* synthetic */ Interceptable $ic;
        public static final AtomicLong ID_COUNTER;
        public transient /* synthetic */ FieldHolder $fh;
        public final long id;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764929276, "Lio/flutter/embedding/android/MotionEventTracker$MotionEventId;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-764929276, "Lio/flutter/embedding/android/MotionEventTracker$MotionEventId;");
                    return;
                }
            }
            ID_COUNTER = new AtomicLong(0L);
        }

        public MotionEventId(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.id = j2;
        }

        public static MotionEventId createUnique() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? from(ID_COUNTER.incrementAndGet()) : (MotionEventId) invokeV.objValue;
        }

        public static MotionEventId from(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) ? new MotionEventId(j2) : (MotionEventId) invokeJ.objValue;
        }

        public long getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.longValue;
        }
    }

    public MotionEventTracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.eventById = new LongSparseArray<>();
        this.unusedEvents = new PriorityQueue<>();
    }

    public static MotionEventTracker getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (INSTANCE == null) {
                INSTANCE = new MotionEventTracker();
            }
            return INSTANCE;
        }
        return (MotionEventTracker) invokeV.objValue;
    }

    @Nullable
    public MotionEvent pop(MotionEventId motionEventId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEventId)) == null) {
            while (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() < motionEventId.id) {
                this.eventById.remove(this.unusedEvents.poll().longValue());
            }
            if (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() == motionEventId.id) {
                this.unusedEvents.poll();
            }
            MotionEvent motionEvent = this.eventById.get(motionEventId.id);
            this.eventById.remove(motionEventId.id);
            return motionEvent;
        }
        return (MotionEvent) invokeL.objValue;
    }

    public MotionEventId track(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            MotionEventId createUnique = MotionEventId.createUnique();
            this.eventById.put(createUnique.id, MotionEvent.obtain(motionEvent));
            this.unusedEvents.add(Long.valueOf(createUnique.id));
            return createUnique;
        }
        return (MotionEventId) invokeL.objValue;
    }
}
