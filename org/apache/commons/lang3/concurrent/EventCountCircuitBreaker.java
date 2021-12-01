package org.apache.commons.lang3.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
/* loaded from: classes3.dex */
public class EventCountCircuitBreaker extends AbstractCircuitBreaker<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<AbstractCircuitBreaker.State, StateStrategy> STRATEGY_MAP;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<CheckIntervalData> checkIntervalData;
    public final long closingInterval;
    public final int closingThreshold;
    public final long openingInterval;
    public final int openingThreshold;

    /* renamed from: org.apache.commons.lang3.concurrent.EventCountCircuitBreaker$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class CheckIntervalData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long checkIntervalStart;
        public final int eventCount;

        public CheckIntervalData(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.eventCount = i2;
            this.checkIntervalStart = j2;
        }

        public long getCheckIntervalStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.checkIntervalStart : invokeV.longValue;
        }

        public int getEventCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.eventCount : invokeV.intValue;
        }

        public CheckIntervalData increment(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 != 0 ? new CheckIntervalData(getEventCount() + i2, getCheckIntervalStart()) : this : (CheckIntervalData) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class StateStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public StateStrategy() {
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

        public abstract long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker);

        public boolean isCheckIntervalFinished(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eventCountCircuitBreaker, checkIntervalData, Long.valueOf(j2)})) == null) ? j2 - checkIntervalData.getCheckIntervalStart() > fetchCheckInterval(eventCountCircuitBreaker) : invokeCommon.booleanValue;
        }

        public abstract boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2);

        public /* synthetic */ StateStrategy(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class StateStrategyClosed extends StateStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateStrategyClosed() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eventCountCircuitBreaker)) == null) ? eventCountCircuitBreaker.getOpeningInterval() : invokeL.longValue;
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eventCountCircuitBreaker, checkIntervalData, checkIntervalData2)) == null) ? checkIntervalData2.getEventCount() > eventCountCircuitBreaker.getOpeningThreshold() : invokeLLL.booleanValue;
        }

        public /* synthetic */ StateStrategyClosed(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class StateStrategyOpen extends StateStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateStrategyOpen() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eventCountCircuitBreaker)) == null) ? eventCountCircuitBreaker.getClosingInterval() : invokeL.longValue;
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eventCountCircuitBreaker, checkIntervalData, checkIntervalData2)) == null) ? checkIntervalData2.getCheckIntervalStart() != checkIntervalData.getCheckIntervalStart() && checkIntervalData.getEventCount() < eventCountCircuitBreaker.getClosingThreshold() : invokeLLL.booleanValue;
        }

        public /* synthetic */ StateStrategyOpen(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-327396474, "Lorg/apache/commons/lang3/concurrent/EventCountCircuitBreaker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-327396474, "Lorg/apache/commons/lang3/concurrent/EventCountCircuitBreaker;");
                return;
            }
        }
        STRATEGY_MAP = createStrategyMap();
    }

    public EventCountCircuitBreaker(int i2, long j2, TimeUnit timeUnit, int i3, long j3, TimeUnit timeUnit2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), timeUnit, Integer.valueOf(i3), Long.valueOf(j3), timeUnit2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.checkIntervalData = new AtomicReference<>(new CheckIntervalData(0, 0L));
        this.openingThreshold = i2;
        this.openingInterval = timeUnit.toNanos(j2);
        this.closingThreshold = i3;
        this.closingInterval = timeUnit2.toNanos(j3);
    }

    private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, state) == null) {
            changeState(state);
            this.checkIntervalData.set(new CheckIntervalData(0, now()));
        }
    }

    public static Map<AbstractCircuitBreaker.State, StateStrategy> createStrategyMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            EnumMap enumMap = new EnumMap(AbstractCircuitBreaker.State.class);
            enumMap.put((EnumMap) AbstractCircuitBreaker.State.CLOSED, (AbstractCircuitBreaker.State) new StateStrategyClosed(null));
            enumMap.put((EnumMap) AbstractCircuitBreaker.State.OPEN, (AbstractCircuitBreaker.State) new StateStrategyOpen(null));
            return enumMap;
        }
        return (Map) invokeV.objValue;
    }

    private CheckIntervalData nextCheckIntervalData(int i2, CheckIntervalData checkIntervalData, AbstractCircuitBreaker.State state, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i2), checkIntervalData, state, Long.valueOf(j2)})) == null) {
            if (stateStrategy(state).isCheckIntervalFinished(this, checkIntervalData, j2)) {
                return new CheckIntervalData(i2, j2);
            }
            return checkIntervalData.increment(i2);
        }
        return (CheckIntervalData) invokeCommon.objValue;
    }

    private boolean performStateCheck(int i2) {
        AbstractCircuitBreaker.State state;
        CheckIntervalData checkIntervalData;
        CheckIntervalData nextCheckIntervalData;
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            do {
                long now = now();
                state = this.state.get();
                checkIntervalData = this.checkIntervalData.get();
                nextCheckIntervalData = nextCheckIntervalData(i2, checkIntervalData, state, now);
            } while (!updateCheckIntervalData(checkIntervalData, nextCheckIntervalData));
            if (stateStrategy(state).isStateTransition(this, checkIntervalData, nextCheckIntervalData)) {
                state = state.oppositeState();
                changeStateAndStartNewCheckInterval(state);
            }
            return !AbstractCircuitBreaker.isOpen(state);
        }
        return invokeI.booleanValue;
    }

    public static StateStrategy stateStrategy(AbstractCircuitBreaker.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, state)) == null) ? STRATEGY_MAP.get(state) : (StateStrategy) invokeL.objValue;
    }

    private boolean updateCheckIntervalData(CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, checkIntervalData, checkIntervalData2)) == null) ? checkIntervalData == checkIntervalData2 || this.checkIntervalData.compareAndSet(checkIntervalData, checkIntervalData2) : invokeLL.booleanValue;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? performStateCheck(0) : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.close();
            this.checkIntervalData.set(new CheckIntervalData(0, now()));
        }
    }

    public long getClosingInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.closingInterval : invokeV.longValue;
    }

    public int getClosingThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.closingThreshold : invokeV.intValue;
    }

    public long getOpeningInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.openingInterval : invokeV.longValue;
    }

    public int getOpeningThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.openingThreshold : invokeV.intValue;
    }

    public long now() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? System.nanoTime() : invokeV.longValue;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.open();
            this.checkIntervalData.set(new CheckIntervalData(0, now()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean incrementAndCheckState(Integer num) throws CircuitBreakingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, num)) == null) ? performStateCheck(1) : invokeL.booleanValue;
    }

    public boolean incrementAndCheckState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? incrementAndCheckState((Integer) 1) : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventCountCircuitBreaker(int i2, long j2, TimeUnit timeUnit, int i3) {
        this(i2, j2, timeUnit, i3, j2, timeUnit);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), timeUnit, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Long) objArr2[1]).longValue(), (TimeUnit) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (TimeUnit) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventCountCircuitBreaker(int i2, long j2, TimeUnit timeUnit) {
        this(i2, j2, timeUnit, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), timeUnit};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Long) objArr2[1]).longValue(), (TimeUnit) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
