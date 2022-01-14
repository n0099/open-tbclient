package com.kwad.v8.debug.mirror;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.webmanager.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
/* loaded from: classes3.dex */
public class Scope extends Mirror {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCOPE_OBJECT = "scopeObject";
    public static final String SCOPE_TYPE = "scopeType";
    public static final String SET_VARIABLE_VALUE = "setVariableValue";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ScopeType {
        public static final /* synthetic */ ScopeType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ScopeType Block;
        public static final ScopeType Catch;
        public static final ScopeType Closure;
        public static final ScopeType Global;
        public static final ScopeType Local;
        public static final ScopeType Script;
        public static final ScopeType With;
        public transient /* synthetic */ FieldHolder $fh;
        public int index;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1991950154, "Lcom/kwad/v8/debug/mirror/Scope$ScopeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1991950154, "Lcom/kwad/v8/debug/mirror/Scope$ScopeType;");
                    return;
                }
            }
            Global = new ScopeType("Global", 0, 0);
            Local = new ScopeType(b.f32802i, 1, 1);
            With = new ScopeType("With", 2, 2);
            Closure = new ScopeType("Closure", 3, 3);
            Catch = new ScopeType("Catch", 4, 4);
            Block = new ScopeType("Block", 5, 5);
            ScopeType scopeType = new ScopeType("Script", 6, 6);
            Script = scopeType;
            $VALUES = new ScopeType[]{Global, Local, With, Closure, Catch, Block, scopeType};
        }

        public ScopeType(String str, int i2, int i3) {
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

        public static ScopeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScopeType) Enum.valueOf(ScopeType.class, str) : (ScopeType) invokeL.objValue;
        }

        public static ScopeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScopeType[]) $VALUES.clone() : (ScopeType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Scope(V8Object v8Object) {
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

    public ObjectMirror getScopeObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            V8Object v8Object = null;
            try {
                v8Object = this.v8Object.executeObjectFunction(SCOPE_OBJECT, null);
                return (ObjectMirror) Mirror.createMirror(v8Object);
            } finally {
                if (v8Object != null) {
                    v8Object.close();
                }
            }
        }
        return (ObjectMirror) invokeV.objValue;
    }

    public ScopeType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ScopeType.values()[this.v8Object.executeIntegerFunction(SCOPE_TYPE, null)] : (ScopeType) invokeV.objValue;
    }

    public void setVariableValue(String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Double.valueOf(d2)}) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(str);
            v8Array.push(d2);
            try {
                this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    public void setVariableValue(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(str);
            v8Array.push(i2);
            try {
                this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    public void setVariableValue(String str, V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, v8Value) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(str);
            v8Array.push(v8Value);
            try {
                this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    public void setVariableValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(str);
            v8Array.push(str2);
            try {
                this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    public void setVariableValue(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(str);
            v8Array.push(z);
            try {
                this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }
}
