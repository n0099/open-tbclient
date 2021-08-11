package org.apache.commons.lang3.time;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class StopWatch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long NANO_2_MILLIS = 1000000;
    public transient /* synthetic */ FieldHolder $fh;
    public State runningState;
    public SplitState splitState;
    public long startTime;
    public long startTimeMillis;
    public long stopTime;

    /* renamed from: org.apache.commons.lang3.time.StopWatch$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class SplitState {
        public static final /* synthetic */ SplitState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SplitState SPLIT;
        public static final SplitState UNSPLIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1496145798, "Lorg/apache/commons/lang3/time/StopWatch$SplitState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1496145798, "Lorg/apache/commons/lang3/time/StopWatch$SplitState;");
                    return;
                }
            }
            SPLIT = new SplitState("SPLIT", 0);
            SplitState splitState = new SplitState("UNSPLIT", 1);
            UNSPLIT = splitState;
            $VALUES = new SplitState[]{SPLIT, splitState};
        }

        public SplitState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SplitState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SplitState) Enum.valueOf(SplitState.class, str) : (SplitState) invokeL.objValue;
        }

        public static SplitState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SplitState[]) $VALUES.clone() : (SplitState[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static abstract class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State RUNNING;
        public static final State STOPPED;
        public static final State SUSPENDED;
        public static final State UNSTARTED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-216609144, "Lorg/apache/commons/lang3/time/StopWatch$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-216609144, "Lorg/apache/commons/lang3/time/StopWatch$State;");
                    return;
                }
            }
            UNSTARTED = new State("UNSTARTED", 0) { // from class: org.apache.commons.lang3.time.StopWatch.State.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStarted() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStopped() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isSuspended() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            };
            RUNNING = new State("RUNNING", 1) { // from class: org.apache.commons.lang3.time.StopWatch.State.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStarted() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStopped() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isSuspended() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            };
            STOPPED = new State("STOPPED", 2) { // from class: org.apache.commons.lang3.time.StopWatch.State.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStarted() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStopped() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isSuspended() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            };
            State state = new State("SUSPENDED", 3) { // from class: org.apache.commons.lang3.time.StopWatch.State.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStarted() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isStopped() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // org.apache.commons.lang3.time.StopWatch.State
                public boolean isSuspended() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }
            };
            SUSPENDED = state;
            $VALUES = new State[]{UNSTARTED, RUNNING, STOPPED, state};
        }

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }

        public abstract boolean isStarted();

        public abstract boolean isStopped();

        public abstract boolean isSuspended();

        public /* synthetic */ State(String str, int i2, AnonymousClass1 anonymousClass1) {
            this(str, i2);
        }
    }

    public StopWatch() {
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
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    public static StopWatch createStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            return stopWatch;
        }
        return (StopWatch) invokeV.objValue;
    }

    public long getNanoTime() {
        InterceptResult invokeV;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            State state = this.runningState;
            if (state != State.STOPPED && state != State.SUSPENDED) {
                if (state == State.UNSTARTED) {
                    return 0L;
                }
                if (state == State.RUNNING) {
                    j2 = System.nanoTime();
                    j3 = this.startTime;
                } else {
                    throw new RuntimeException("Illegal running state has occurred.");
                }
            } else {
                j2 = this.stopTime;
                j3 = this.startTime;
            }
            return j2 - j3;
        }
        return invokeV.longValue;
    }

    public long getSplitNanoTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.splitState == SplitState.SPLIT) {
                return this.stopTime - this.startTime;
            }
            throw new IllegalStateException("Stopwatch must be split to get the split time. ");
        }
        return invokeV.longValue;
    }

    public long getSplitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getSplitNanoTime() / 1000000 : invokeV.longValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.runningState != State.UNSTARTED) {
                return this.startTimeMillis;
            }
            throw new IllegalStateException("Stopwatch has not been started");
        }
        return invokeV.longValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getNanoTime() / 1000000 : invokeV.longValue;
    }

    public boolean isStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.runningState.isStarted() : invokeV.booleanValue;
    }

    public boolean isStopped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.runningState.isStopped() : invokeV.booleanValue;
    }

    public boolean isSuspended() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.runningState.isSuspended() : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.runningState = State.UNSTARTED;
            this.splitState = SplitState.UNSPLIT;
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.runningState == State.SUSPENDED) {
                this.startTime += System.nanoTime() - this.stopTime;
                this.runningState = State.RUNNING;
                return;
            }
            throw new IllegalStateException("Stopwatch must be suspended to resume. ");
        }
    }

    public void split() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.runningState == State.RUNNING) {
                this.stopTime = System.nanoTime();
                this.splitState = SplitState.SPLIT;
                return;
            }
            throw new IllegalStateException("Stopwatch is not running. ");
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            State state = this.runningState;
            if (state != State.STOPPED) {
                if (state == State.UNSTARTED) {
                    this.startTime = System.nanoTime();
                    this.startTimeMillis = System.currentTimeMillis();
                    this.runningState = State.RUNNING;
                    return;
                }
                throw new IllegalStateException("Stopwatch already started. ");
            }
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            State state = this.runningState;
            if (state != State.RUNNING && state != State.SUSPENDED) {
                throw new IllegalStateException("Stopwatch is not running. ");
            }
            if (this.runningState == State.RUNNING) {
                this.stopTime = System.nanoTime();
            }
            this.runningState = State.STOPPED;
        }
    }

    public void suspend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.runningState == State.RUNNING) {
                this.stopTime = System.nanoTime();
                this.runningState = State.SUSPENDED;
                return;
            }
            throw new IllegalStateException("Stopwatch must be running to suspend. ");
        }
    }

    public String toSplitString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? DurationFormatUtils.formatDurationHMS(getSplitTime()) : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? DurationFormatUtils.formatDurationHMS(getTime()) : (String) invokeV.objValue;
    }

    public void unsplit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.splitState == SplitState.SPLIT) {
                this.splitState = SplitState.UNSPLIT;
                return;
            }
            throw new IllegalStateException("Stopwatch has not been split. ");
        }
    }

    public long getTime(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, timeUnit)) == null) ? timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS) : invokeL.longValue;
    }
}
