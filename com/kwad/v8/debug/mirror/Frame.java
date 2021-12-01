package com.kwad.v8.debug.mirror;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
/* loaded from: classes2.dex */
public class Frame extends Mirror {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARGUMENT_COUNT = "argumentCount";
    public static final String ARGUMENT_NAME = "argumentName";
    public static final String ARGUMENT_VALUE = "argumentValue";
    public static final String COLUMN = "column";
    public static final String FUNC = "func";
    public static final String LINE = "line";
    public static final String LOCAL_COUNT = "localCount";
    public static final String LOCAL_NAME = "localName";
    public static final String LOCAL_VALUE = "localValue";
    public static final String NAME = "name";
    public static final String POSITION = "position";
    public static final String SCOPE = "scope";
    public static final String SCOPE_COUNT = "scopeCount";
    public static final String SCRIPT = "script";
    public static final String SOURCE_LOCATION = "sourceLocation";
    public static final String SOURCE_TEXT = "sourceText";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Frame(V8Object v8Object) {
        super(v8Object);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((V8Object) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getArgumentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.v8Object.executeIntegerFunction(ARGUMENT_COUNT, null) : invokeV.intValue;
    }

    public String getArgumentName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(i2);
            try {
                return this.v8Object.executeStringFunction(ARGUMENT_NAME, v8Array);
            } finally {
                v8Array.close();
            }
        }
        return (String) invokeI.objValue;
    }

    public ValueMirror getArgumentValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(i2);
            AutoCloseable autoCloseable = null;
            try {
                V8Object executeObjectFunction = this.v8Object.executeObjectFunction(ARGUMENT_VALUE, v8Array);
                if (Mirror.isValue(executeObjectFunction)) {
                    ValueMirror valueMirror = new ValueMirror(executeObjectFunction);
                    v8Array.close();
                    if (executeObjectFunction != null) {
                        executeObjectFunction.close();
                    }
                    return valueMirror;
                }
                throw new IllegalStateException("Argument value is not a ValueMirror");
            } catch (Throwable th) {
                v8Array.close();
                if (0 != 0) {
                    autoCloseable.close();
                }
                throw th;
            }
        }
        return (ValueMirror) invokeI.objValue;
    }

    public FunctionMirror getFunction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            V8Object v8Object = null;
            try {
                v8Object = this.v8Object.executeObjectFunction("func", null);
                return new FunctionMirror(v8Object);
            } finally {
                if (v8Object != null) {
                    v8Object.close();
                }
            }
        }
        return (FunctionMirror) invokeV.objValue;
    }

    public int getLocalCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v8Object.executeIntegerFunction(LOCAL_COUNT, null) : invokeV.intValue;
    }

    public String getLocalName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(i2);
            try {
                return this.v8Object.executeStringFunction(LOCAL_NAME, v8Array);
            } finally {
                v8Array.close();
            }
        }
        return (String) invokeI.objValue;
    }

    public ValueMirror getLocalValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(i2);
            AutoCloseable autoCloseable = null;
            try {
                V8Object executeObjectFunction = this.v8Object.executeObjectFunction(LOCAL_VALUE, v8Array);
                if (Mirror.isValue(executeObjectFunction)) {
                    ValueMirror createMirror = Mirror.createMirror(executeObjectFunction);
                    v8Array.close();
                    if (executeObjectFunction != null) {
                        executeObjectFunction.close();
                    }
                    return createMirror;
                }
                throw new IllegalStateException("Local value is not a ValueMirror");
            } catch (Throwable th) {
                v8Array.close();
                if (0 != 0) {
                    autoCloseable.close();
                }
                throw th;
            }
        }
        return (ValueMirror) invokeI.objValue;
    }

    public Scope getScope(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(i2);
            V8Object v8Object = null;
            try {
                v8Object = this.v8Object.executeObjectFunction("scope", v8Array);
                return new Scope(v8Object);
            } finally {
                v8Array.close();
                if (v8Object != null) {
                    v8Object.close();
                }
            }
        }
        return (Scope) invokeI.objValue;
    }

    public int getScopeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v8Object.executeIntegerFunction(SCOPE_COUNT, null) : invokeV.intValue;
    }

    public SourceLocation getSourceLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = null;
            V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SOURCE_LOCATION, null);
            FunctionMirror function = getFunction();
            String scriptName = function.getScriptName();
            try {
                V8Object v8Object = (V8Object) executeObjectFunction.get("script");
                if (v8Object != null) {
                    str = v8Object.getString("name");
                    v8Object.close();
                }
                if (str != null || scriptName == null) {
                    scriptName = SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
                }
                return new SourceLocation(scriptName, executeObjectFunction.getInteger("position"), executeObjectFunction.getInteger("line"), executeObjectFunction.getInteger(COLUMN), executeObjectFunction.getString(SOURCE_TEXT));
            } finally {
                function.close();
                executeObjectFunction.close();
            }
        }
        return (SourceLocation) invokeV.objValue;
    }

    @Override // com.kwad.v8.debug.mirror.Mirror
    public boolean isFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
