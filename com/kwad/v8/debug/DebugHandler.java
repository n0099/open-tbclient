package com.kwad.v8.debug;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.JavaVoidCallback;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class DebugHandler implements Releasable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    public static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    public static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    public static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    public static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    public static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    public static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    public static final String NUMBER = "number";
    public static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    public static final String SET_BREAK_POINT = "setBreakPoint";
    public static final String SET_LISTENER = "setListener";
    public static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    public static final String V8_DEBUG_OBJECT = "Debug";
    public transient /* synthetic */ FieldHolder $fh;
    public List<BreakHandler> breakHandlers;
    public V8Object debugObject;
    public V8 runtime;

    /* renamed from: com.kwad.v8.debug.DebugHandler$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$v8$debug$DebugHandler$DebugEvent;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1171935604, "Lcom/kwad/v8/debug/DebugHandler$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1171935604, "Lcom/kwad/v8/debug/DebugHandler$1;");
                    return;
                }
            }
            int[] iArr = new int[DebugEvent.values().length];
            $SwitchMap$com$kwad$v8$debug$DebugHandler$DebugEvent = iArr;
            try {
                iArr[DebugEvent.Break.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$v8$debug$DebugHandler$DebugEvent[DebugEvent.BeforeCompile.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$v8$debug$DebugHandler$DebugEvent[DebugEvent.AfterCompile.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$v8$debug$DebugHandler$DebugEvent[DebugEvent.Exception.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class BreakpointHandler implements JavaVoidCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DebugHandler this$0;

        public BreakpointHandler(DebugHandler debugHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {debugHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = debugHandler;
        }

        public /* synthetic */ BreakpointHandler(DebugHandler debugHandler, AnonymousClass1 anonymousClass1) {
            this(debugHandler);
        }

        private EventData createDebugEvent(DebugEvent debugEvent, V8Object v8Object) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, debugEvent, v8Object)) == null) {
                int i2 = AnonymousClass1.$SwitchMap$com$kwad$v8$debug$DebugHandler$DebugEvent[debugEvent.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        return i2 != 4 ? new EventData(v8Object) : new ExceptionEvent(v8Object);
                    }
                    return new CompileEvent(v8Object);
                }
                return new BreakEvent(v8Object);
            }
            return (EventData) invokeLL.objValue;
        }

        private void invokeHandler(V8Array v8Array, int i2, BreakHandler breakHandler) {
            V8Object v8Object;
            ExecutionState executionState;
            V8Object v8Object2;
            ExecutionState executionState2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(65539, this, v8Array, i2, breakHandler) != null) {
                return;
            }
            V8Object v8Object3 = null;
            EventData eventData = null;
            try {
                V8Object object = v8Array.getObject(1);
                try {
                    v8Object2 = v8Array.getObject(2);
                    try {
                        v8Object = v8Array.getObject(3);
                        try {
                            executionState2 = new ExecutionState(object);
                            try {
                                DebugEvent debugEvent = DebugEvent.values()[i2];
                                eventData = createDebugEvent(debugEvent, v8Object2);
                                breakHandler.onBreak(debugEvent, executionState2, eventData, v8Object);
                                safeRelease(object);
                                safeRelease(v8Object2);
                                safeRelease(v8Object);
                                safeRelease(executionState2);
                                safeRelease(eventData);
                            } catch (Throwable th) {
                                th = th;
                                executionState = eventData;
                                v8Object3 = object;
                                safeRelease(v8Object3);
                                safeRelease(v8Object2);
                                safeRelease(v8Object);
                                safeRelease(executionState2);
                                safeRelease(executionState);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            executionState = null;
                            executionState2 = executionState;
                            v8Object3 = object;
                            safeRelease(v8Object3);
                            safeRelease(v8Object2);
                            safeRelease(v8Object);
                            safeRelease(executionState2);
                            safeRelease(executionState);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        v8Object = null;
                        executionState = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    v8Object = null;
                    executionState = null;
                    v8Object2 = null;
                    executionState2 = null;
                }
            } catch (Throwable th5) {
                th = th5;
                v8Object = null;
                executionState = null;
                v8Object2 = null;
                executionState2 = null;
            }
        }

        private void safeRelease(Releasable releasable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, releasable) == null) || releasable == null) {
                return;
            }
            releasable.release();
        }

        @Override // com.kwad.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, v8Object, v8Array) == null) || v8Array == null || v8Array.isUndefined()) {
                return;
            }
            int integer = v8Array.getInteger(0);
            for (BreakHandler breakHandler : this.this$0.breakHandlers) {
                invokeHandler(v8Array, integer, breakHandler);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class DebugEvent {
        public static final /* synthetic */ DebugEvent[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DebugEvent AfterCompile;
        public static final DebugEvent AsyncTaskEvent;
        public static final DebugEvent BeforeCompile;
        public static final DebugEvent Break;
        public static final DebugEvent CompileError;
        public static final DebugEvent Exception;
        public static final DebugEvent NewFunction;
        public static final DebugEvent PromiseError;
        public static final DebugEvent Undefined;
        public transient /* synthetic */ FieldHolder $fh;
        public int index;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1079473942, "Lcom/kwad/v8/debug/DebugHandler$DebugEvent;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1079473942, "Lcom/kwad/v8/debug/DebugHandler$DebugEvent;");
                    return;
                }
            }
            Undefined = new DebugEvent("Undefined", 0, 0);
            Break = new DebugEvent("Break", 1, 1);
            Exception = new DebugEvent("Exception", 2, 2);
            NewFunction = new DebugEvent("NewFunction", 3, 3);
            BeforeCompile = new DebugEvent("BeforeCompile", 4, 4);
            AfterCompile = new DebugEvent("AfterCompile", 5, 5);
            CompileError = new DebugEvent("CompileError", 6, 6);
            PromiseError = new DebugEvent("PromiseError", 7, 7);
            DebugEvent debugEvent = new DebugEvent("AsyncTaskEvent", 8, 8);
            AsyncTaskEvent = debugEvent;
            $VALUES = new DebugEvent[]{Undefined, Break, Exception, NewFunction, BeforeCompile, AfterCompile, CompileError, PromiseError, debugEvent};
        }

        public DebugEvent(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.index = i3;
        }

        public static DebugEvent valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DebugEvent) Enum.valueOf(DebugEvent.class, str) : (DebugEvent) invokeL.objValue;
        }

        public static DebugEvent[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DebugEvent[]) $VALUES.clone() : (DebugEvent[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(229152225, "Lcom/kwad/v8/debug/DebugHandler;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(229152225, "Lcom/kwad/v8/debug/DebugHandler;");
        }
    }

    public DebugHandler(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.breakHandlers = new ArrayList();
        this.runtime = v8;
        setupDebugObject(v8);
        setupBreakpointHandler();
    }

    private void setupBreakpointHandler() {
        V8Array v8Array;
        Throwable th;
        V8Function v8Function;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.debugObject.registerJavaMethod(new BreakpointHandler(this, null), "__j2v8_debug_handler");
            try {
                v8Function = (V8Function) this.debugObject.getObject("__j2v8_debug_handler");
                try {
                    v8Array = new V8Array(this.runtime);
                } catch (Throwable th2) {
                    v8Array = null;
                    th = th2;
                }
            } catch (Throwable th3) {
                v8Array = null;
                th = th3;
                v8Function = null;
            }
            try {
                v8Array.push((V8Value) v8Function);
                this.debugObject.executeFunction("setListener", v8Array);
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.close();
                }
                if (v8Array.isReleased()) {
                    return;
                }
                v8Array.close();
            } catch (Throwable th4) {
                th = th4;
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.close();
                }
                if (v8Array != null && !v8Array.isReleased()) {
                    v8Array.close();
                }
                throw th;
            }
        }
    }

    private void setupDebugObject(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, v8) == null) {
            V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
            try {
                this.debugObject = object.getObject("Debug");
            } finally {
                object.close();
            }
        }
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, breakHandler) == null) {
            this.runtime.getLocker().checkThread();
            this.breakHandlers.add(breakHandler);
        }
    }

    public void changeBreakPointCondition(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(i2);
            v8Array.push(str);
            try {
                this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    public void clearBreakPoint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(i2);
            try {
                this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    @Override // com.kwad.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.debugObject.close();
        }
    }

    public void disableAllBreakPoints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, null);
        }
    }

    public void disableScriptBreakPoint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(i2);
            try {
                this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    public void enableScriptBreakPoint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(i2);
            try {
                this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    public ScriptBreakPoint getScriptBreakPoint(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(i2);
            v8Array.push(false);
            V8Object v8Object = null;
            try {
                v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
                return new ScriptBreakPoint(v8Object);
            } finally {
                v8Array.close();
                if (v8Object != null) {
                    v8Object.close();
                }
            }
        }
        return (ScriptBreakPoint) invokeI.objValue;
    }

    public int getScriptBreakPointCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
            try {
                return executeArrayFunction.length();
            } finally {
                executeArrayFunction.close();
            }
        }
        return invokeV.intValue;
    }

    public int[] getScriptBreakPointIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
            try {
                int[] iArr = new int[executeArrayFunction.length()];
                for (int i2 = 0; i2 < executeArrayFunction.length(); i2++) {
                    V8Object object = executeArrayFunction.getObject(i2);
                    iArr[i2] = object.executeIntegerFunction("number", null);
                    object.close();
                }
                return iArr;
            } finally {
                executeArrayFunction.close();
            }
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.kwad.v8.Releasable
    @Deprecated
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            close();
        }
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, breakHandler) == null) {
            this.runtime.getLocker().checkThread();
            this.breakHandlers.remove(breakHandler);
        }
    }

    public int setBreakpoint(V8Function v8Function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, v8Function)) == null) {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push((V8Value) v8Function);
            try {
                return this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
            } finally {
                v8Array.close();
            }
        }
        return invokeL.intValue;
    }

    public int setScriptBreakpoint(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i2)) == null) {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(str);
            v8Array.push(i2);
            try {
                return this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
            } finally {
                v8Array.close();
            }
        }
        return invokeLI.intValue;
    }
}
