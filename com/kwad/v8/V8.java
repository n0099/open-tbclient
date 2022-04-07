package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import com.kwad.v8.inspector.V8InspectorDelegate;
import com.kwad.v8.utils.V8Executor;
import com.kwad.v8.utils.V8Map;
import com.kwad.v8.utils.V8Runnable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class V8 extends V8Object {
    public static /* synthetic */ Interceptable $ic;
    public static boolean initialized;
    public static Object invalid;
    public static Object lock;
    public static boolean nativeLibraryLoaded;
    public static Error nativeLoadError;
    public static Exception nativeLoadException;
    public static volatile int runtimeCounter;
    public static V8Object sV8Receiver;
    public static V8Value undefined;
    public static String v8Flags;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> data;
    public V8Map<V8Executor> executors;
    public boolean forceTerminateExecutors;
    public Map<Long, MethodDescriptor> functionRegistry;
    public final V8Locker locker;
    public long methodId;
    public long objectReferences;
    public LinkedList<ReferenceHandler> referenceHandlers;
    public LinkedList<V8Runnable> releaseHandlers;
    public List<Releasable> resources;
    public SignatureProvider signatureProvider;
    public long v8RuntimePtr;
    public Map<Long, V8Value> v8WeakReferences;

    /* renamed from: com.kwad.v8.V8$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class MethodDescriptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JavaCallback callback;
        public boolean includeReceiver;
        public Method method;
        public Object object;
        public final /* synthetic */ V8 this$0;
        public JavaVoidCallback voidCallback;

        public MethodDescriptor(V8 v8) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = v8;
        }

        public /* synthetic */ MethodDescriptor(V8 v8, AnonymousClass1 anonymousClass1) {
            this(v8);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1406932238, "Lcom/kwad/v8/V8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1406932238, "Lcom/kwad/v8/V8;");
                return;
            }
        }
        lock = new Object();
        undefined = new V8Object.Undefined();
        invalid = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public V8() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8(String str) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((V8) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.signatureProvider = null;
        this.objectReferences = 0L;
        this.v8RuntimePtr = 0L;
        this.resources = null;
        this.executors = null;
        this.forceTerminateExecutors = false;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList<>();
        this.releaseHandlers = new LinkedList<>();
        this.released = false;
        this.v8RuntimePtr = _createIsolate(str);
        this.locker = new V8Locker(this);
        checkThread();
        this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }

    private native void _acquireLock(long j);

    private native void _add(long j, long j2, String str, double d);

    private native void _add(long j, long j2, String str, int i);

    private native void _add(long j, long j2, String str, String str2);

    private native void _add(long j, long j2, String str, boolean z);

    private native void _addArrayBooleanItem(long j, long j2, boolean z);

    private native void _addArrayDoubleItem(long j, long j2, double d);

    private native void _addArrayIntItem(long j, long j2, int i);

    private native void _addArrayNullItem(long j, long j2);

    private native void _addArrayObjectItem(long j, long j2, long j3);

    private native void _addArrayStringItem(long j, long j2, String str);

    private native void _addArrayUndefinedItem(long j, long j2);

    private native void _addNull(long j, long j2, String str);

    private native void _addObject(long j, long j2, String str, long j3);

    private native void _addUndefined(long j, long j2, String str);

    private native Object _arrayGet(long j, int i, long j2, int i2);

    private native boolean _arrayGetBoolean(long j, long j2, int i);

    private native int _arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j, long j2, int i, int i2);

    private native byte _arrayGetByte(long j, long j2, int i);

    private native int _arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr);

    private native byte[] _arrayGetBytes(long j, long j2, int i, int i2);

    private native double _arrayGetDouble(long j, long j2, int i);

    private native int _arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr);

    private native double[] _arrayGetDoubles(long j, long j2, int i, int i2);

    private native int _arrayGetInteger(long j, long j2, int i);

    private native int _arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr);

    private native int[] _arrayGetIntegers(long j, long j2, int i, int i2);

    private native int _arrayGetSize(long j, long j2);

    private native String _arrayGetString(long j, long j2, int i);

    private native int _arrayGetStrings(long j, long j2, int i, int i2, String[] strArr);

    private native String[] _arrayGetStrings(long j, long j2, int i, int i2);

    private native void _clearWeak(long j, long j2);

    private native boolean _contains(long j, long j2, String str);

    private native long _createInspector(long j, V8InspectorDelegate v8InspectorDelegate, String str);

    private native long _createIsolate(String str);

    private native void _createTwin(long j, long j2, long j3);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j, long j2, int i);

    private native void _dispatchProtocolMessage(long j, long j2, String str);

    private native boolean _equals(long j, long j2, long j3);

    private native boolean _executeBooleanFunction(long j, long j2, String str, long j3);

    private native boolean _executeBooleanScript(long j, String str, String str2, int i);

    private native double _executeDoubleFunction(long j, long j2, String str, long j3);

    private native double _executeDoubleScript(long j, String str, String str2, int i);

    private native Object _executeFunction(long j, int i, long j2, String str, long j3);

    private native Object _executeFunction(long j, long j2, long j3, long j4);

    private native int _executeIntegerFunction(long j, long j2, String str, long j3);

    private native int _executeIntegerScript(long j, String str, String str2, int i);

    private native Object _executeScript(long j, int i, String str, String str2, int i2);

    private native String _executeStringFunction(long j, long j2, String str, long j3);

    private native String _executeStringScript(long j, String str, String str2, int i);

    private native void _executeVoidFunction(long j, long j2, String str, long j3);

    private native void _executeVoidScript(long j, String str, String str2, int i);

    private native Object _get(long j, int i, long j2, String str);

    private native int _getArrayType(long j, long j2);

    private native boolean _getBoolean(long j, long j2, String str);

    public static native long _getBuildID();

    private native String _getConstructorName(long j, long j2);

    private native double _getDouble(long j, long j2, String str);

    private native long _getGlobalObject(long j);

    private native int _getInteger(long j, long j2, String str);

    private native String[] _getKeys(long j, long j2);

    private native String _getString(long j, long j2, String str);

    private native int _getType(long j, long j2);

    private native int _getType(long j, long j2, int i);

    private native int _getType(long j, long j2, int i, int i2);

    private native int _getType(long j, long j2, String str);

    public static native String _getVersion();

    private native int _identityHash(long j, long j2);

    private native long _initEmptyContainer(long j);

    private native long _initNewV8Array(long j);

    private native long _initNewV8ArrayBuffer(long j, int i);

    private native long _initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i);

    private native long _initNewV8Float32Array(long j, long j2, int i, int i2);

    private native long _initNewV8Float64Array(long j, long j2, int i, int i2);

    private native long[] _initNewV8Function(long j);

    private native long _initNewV8Int16Array(long j, long j2, int i, int i2);

    private native long _initNewV8Int32Array(long j, long j2, int i, int i2);

    private native long _initNewV8Int8Array(long j, long j2, int i, int i2);

    private native long _initNewV8Object(long j);

    private native long _initNewV8UInt16Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt32Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt8Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt8ClampedArray(long j, long j2, int i, int i2);

    public static native boolean _isNodeCompatible();

    public static native boolean _isRunning(long j);

    private native boolean _isWeak(long j, long j2);

    private native void _lowMemoryNotification(long j);

    public static native boolean _pumpMessageLoop(long j);

    private native long _registerJavaMethod(long j, long j2, String str, boolean z);

    private native void _release(long j, long j2);

    private native void _releaseLock(long j);

    private native void _releaseMethodDescriptor(long j, long j2);

    private native void _releaseRuntime(long j);

    private native boolean _sameValue(long j, long j2, long j3);

    private native void _schedulePauseOnNextStatement(long j, long j2, String str);

    public static native void _setFlags(String str);

    private native void _setPrototype(long j, long j2, long j3);

    private native void _setWeak(long j, long j2);

    public static native void _startNodeJS(long j, String str);

    private native boolean _strictEquals(long j, long j2, long j3);

    private native void _terminateExecution(long j);

    private native String _toString(long j, long j2);

    private void checkArgs(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65642, this, objArr) == null) {
            for (Object obj : objArr) {
                if (obj == invalid) {
                    throw new IllegalArgumentException("argument type mismatch");
                }
            }
        }
    }

    public static void checkNativeLibraryLoaded() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65643, null) == null) || nativeLibraryLoaded) {
            return;
        }
        String computeLibraryShortName = LibraryLoader.computeLibraryShortName(true);
        String str = "J2V8 native library not loaded (" + LibraryLoader.computeLibraryShortName(false) + "/" + computeLibraryShortName + SmallTailInfo.EMOTION_SUFFIX;
        if (nativeLoadError != null) {
            throw new IllegalStateException(str, nativeLoadError);
        }
        if (nativeLoadException == null) {
            throw new IllegalStateException(str);
        }
        throw new IllegalStateException(str, nativeLoadException);
    }

    private Object checkResult(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65644, this, obj)) == null) {
            if (obj == null) {
                return obj;
            }
            if (obj instanceof Float) {
                return Double.valueOf(((Float) obj).doubleValue());
            }
            if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof String)) {
                return obj;
            }
            if (obj instanceof V8Value) {
                if (((V8Value) obj).isReleased()) {
                    throw new V8RuntimeException("V8Value already released");
                }
                return obj;
            }
            throw new V8RuntimeException("Unknown return type: " + obj.getClass());
        }
        return invokeL.objValue;
    }

    public static void checkScript(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65645, null, str) == null) && str == null) {
            throw new NullPointerException("Script is null");
        }
    }

    public static V8 createV8Runtime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65646, null)) == null) ? createV8Runtime(null, null) : (V8) invokeV.objValue;
    }

    public static V8 createV8Runtime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65647, null, str)) == null) ? createV8Runtime(str, null) : (V8) invokeL.objValue;
    }

    public static V8 createV8Runtime(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65648, null, str, str2)) == null) {
            if (!nativeLibraryLoaded) {
                synchronized (lock) {
                    if (!nativeLibraryLoaded) {
                        load(str2);
                    }
                }
            }
            checkNativeLibraryLoaded();
            if (!initialized) {
                _setFlags(v8Flags);
                initialized = true;
            }
            V8 v8 = new V8(str);
            synchronized (lock) {
                runtimeCounter++;
            }
            return v8;
        }
        return (V8) invokeLL.objValue;
    }

    public static int getActiveRuntimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65649, null)) == null) ? runtimeCounter : invokeV.intValue;
    }

    private Object[] getArgs(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65650, this, new Object[]{v8Object, methodDescriptor, v8Array, Boolean.valueOf(z)})) == null) {
            int length = methodDescriptor.method.getParameterTypes().length;
            int i = z ? length - 1 : length;
            Object[] defaultValues = setDefaultValues(new Object[length], methodDescriptor.method.getParameterTypes(), v8Object, methodDescriptor.includeReceiver);
            ArrayList arrayList = new ArrayList();
            populateParamters(v8Array, i, defaultValues, arrayList, methodDescriptor.includeReceiver);
            if (z) {
                Object varArgContainer = getVarArgContainer(methodDescriptor.method.getParameterTypes(), arrayList.size());
                System.arraycopy(arrayList.toArray(), 0, varArgContainer, 0, arrayList.size());
                defaultValues[i] = varArgContainer;
            }
            return defaultValues;
        }
        return (Object[]) invokeCommon.objValue;
    }

    private Object getArrayItem(V8Array v8Array, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65651, this, v8Array, i)) == null) {
            try {
                int type = v8Array.getType(i);
                if (type != 10) {
                    if (type != 99) {
                        switch (type) {
                            case 1:
                                return Integer.valueOf(v8Array.getInteger(i));
                            case 2:
                                return Double.valueOf(v8Array.getDouble(i));
                            case 3:
                                return Boolean.valueOf(v8Array.getBoolean(i));
                            case 4:
                                return v8Array.getString(i);
                            case 5:
                            case 8:
                                return v8Array.getArray(i);
                            case 6:
                                return v8Array.getObject(i);
                            case 7:
                                return v8Array.getObject(i);
                            default:
                                return null;
                        }
                    }
                    return getUndefined();
                }
                return v8Array.get(i);
            } catch (V8ResultUndefined unused) {
                return null;
            }
        }
        return invokeLI.objValue;
    }

    public static long getBuildID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65652, null)) == null) ? _getBuildID() : invokeV.longValue;
    }

    private Object getDefaultValue(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65653, this, cls)) == null) ? cls.equals(V8Object.class) ? new V8Object.Undefined() : cls.equals(V8Array.class) ? new V8Array.Undefined() : invalid : invokeL.objValue;
    }

    public static String getSCMRevision() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65654, null)) == null) ? "Unknown revision ID" : (String) invokeV.objValue;
    }

    public static V8Value getUndefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65655, null)) == null) ? undefined : (V8Value) invokeV.objValue;
    }

    public static V8Object getV8Receiver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65656, null)) == null) ? sV8Receiver : (V8Object) invokeV.objValue;
    }

    public static String getV8Version() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65657, null)) == null) ? _getVersion() : (String) invokeV.objValue;
    }

    private Object getVarArgContainer(Class<?>[] clsArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65658, this, clsArr, i)) == null) {
            Class<?> cls = clsArr[clsArr.length - 1];
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return Array.newInstance(cls, i);
        }
        return invokeLI.objValue;
    }

    public static boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65659, null)) == null) ? nativeLibraryLoaded : invokeV.booleanValue;
    }

    public static boolean isNodeCompatible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65660, null)) == null) {
            if (!nativeLibraryLoaded) {
                synchronized (lock) {
                    if (!nativeLibraryLoaded) {
                        load(null);
                    }
                }
            }
            return _isNodeCompatible();
        }
        return invokeV.booleanValue;
    }

    private boolean isVoidMethod(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65661, this, method)) == null) ? method.getReturnType().equals(Void.TYPE) : invokeL.booleanValue;
    }

    public static synchronized void load(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65662, null, str) == null) {
            synchronized (V8.class) {
                try {
                    LibraryLoader.loadLibrary(str);
                    nativeLibraryLoaded = true;
                } catch (Error e) {
                    nativeLoadError = e;
                } catch (Exception e2) {
                    nativeLoadException = e2;
                }
            }
        }
    }

    private void notifyReferenceCreated(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65663, this, v8Value) == null) {
            Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
            while (it.hasNext()) {
                it.next().v8HandleCreated(v8Value);
            }
        }
    }

    private void notifyReferenceDisposed(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65664, this, v8Value) == null) {
            Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
            while (it.hasNext()) {
                it.next().v8HandleDisposed(v8Value);
            }
        }
    }

    private void notifyReleaseHandlers(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65665, this, v8) == null) {
            Iterator<V8Runnable> it = this.releaseHandlers.iterator();
            while (it.hasNext()) {
                it.next().run(v8);
            }
        }
    }

    private void populateParamters(V8Array v8Array, int i, Object[] objArr, List<Object> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65666, this, new Object[]{v8Array, Integer.valueOf(i), objArr, list, Boolean.valueOf(z)}) == null) {
            for (int i2 = z ? 1 : 0; i2 < v8Array.length() + (z ? 1 : 0); i2++) {
                Object arrayItem = getArrayItem(v8Array, i2 - (z ? 1 : 0));
                if (i2 >= i) {
                    list.add(arrayItem);
                } else {
                    objArr[i2] = arrayItem;
                }
            }
        }
    }

    private void releaseArguments(Object[] objArr, boolean z) {
        Object[] objArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65667, this, objArr, z) == null) {
            if (z && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
                for (Object obj : (Object[]) objArr[objArr.length - 1]) {
                    if (obj instanceof V8Value) {
                        ((V8Value) obj).close();
                    }
                }
            }
            for (Object obj2 : objArr) {
                if (obj2 instanceof V8Value) {
                    ((V8Value) obj2).close();
                }
            }
        }
    }

    private void releaseNativeMethodDescriptors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65668, this) == null) {
            for (Long l : this.functionRegistry.keySet()) {
                releaseMethodDescriptor(this.v8RuntimePtr, l.longValue());
            }
        }
    }

    private void releaseResources() {
        List<Releasable> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65669, this) == null) || (list = this.resources) == null) {
            return;
        }
        for (Releasable releasable : list) {
            releasable.release();
        }
        this.resources.clear();
        this.resources = null;
    }

    private Object[] setDefaultValues(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65670, this, new Object[]{objArr, clsArr, v8Object, Boolean.valueOf(z)})) == null) {
            int i = 0;
            if (z) {
                objArr[0] = v8Object;
                i = 1;
            }
            while (i < objArr.length) {
                objArr[i] = getDefaultValue(clsArr[i]);
                i++;
            }
            return objArr;
        }
        return (Object[]) invokeCommon.objValue;
    }

    public static void setFlags(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65671, null, str) == null) {
            v8Flags = str;
            initialized = false;
        }
    }

    public void acquireLock(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            _acquireLock(j);
        }
    }

    public void add(long j, long j2, String str, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Double.valueOf(d)}) == null) {
            _add(j, j2, str, d);
        }
    }

    public void add(long j, long j2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i)}) == null) {
            _add(j, j2, str, i);
        }
    }

    public void add(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            _add(j, j2, str, str2);
        }
    }

    public void add(long j, long j2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Boolean.valueOf(z)}) == null) {
            _add(j, j2, str, z);
        }
    }

    public void addArrayBooleanItem(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            _addArrayBooleanItem(j, j2, z);
        }
    }

    public void addArrayDoubleItem(long j, long j2, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Double.valueOf(d)}) == null) {
            _addArrayDoubleItem(j, j2, d);
        }
    }

    public void addArrayIntItem(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            _addArrayIntItem(j, j2, i);
        }
    }

    public void addArrayNullItem(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            _addArrayNullItem(j, j2);
        }
    }

    public void addArrayObjectItem(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            _addArrayObjectItem(j, j2, j3);
        }
    }

    public void addArrayStringItem(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            _addArrayStringItem(j, j2, str);
        }
    }

    public void addArrayUndefinedItem(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            _addArrayUndefinedItem(j, j2);
        }
    }

    public void addNull(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            _addNull(j, j2, str);
        }
    }

    public void addObjRef(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, v8Value) == null) {
            this.objectReferences++;
            if (this.referenceHandlers.isEmpty()) {
                return;
            }
            notifyReferenceCreated(v8Value);
        }
    }

    public void addObject(long j, long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3)}) == null) {
            _addObject(j, j2, str, j3);
        }
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, referenceHandler) == null) {
            this.referenceHandlers.add(0, referenceHandler);
        }
    }

    public void addReleaseHandler(V8Runnable v8Runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, v8Runnable) == null) {
            this.releaseHandlers.add(v8Runnable);
        }
    }

    public void addUndefined(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            _addUndefined(j, j2, str);
        }
    }

    public Object arrayGet(long j, int i, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? _arrayGet(j, i, j2, i2) : invokeCommon.objValue;
    }

    public boolean arrayGetBoolean(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? _arrayGetBoolean(j, j2, i) : invokeCommon.booleanValue;
    }

    public int arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), zArr})) == null) ? _arrayGetBooleans(j, j2, i, i2, zArr) : invokeCommon.intValue;
    }

    public boolean[] arrayGetBooleans(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _arrayGetBooleans(j, j2, i, i2) : (boolean[]) invokeCommon.objValue;
    }

    public byte arrayGetByte(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? _arrayGetByte(j, j2, i) : invokeCommon.byteValue;
    }

    public int arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), bArr})) == null) ? _arrayGetBytes(j, j2, i, i2, bArr) : invokeCommon.intValue;
    }

    public byte[] arrayGetBytes(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _arrayGetBytes(j, j2, i, i2) : (byte[]) invokeCommon.objValue;
    }

    public double arrayGetDouble(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? _arrayGetDouble(j, j2, i) : invokeCommon.doubleValue;
    }

    public int arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), dArr})) == null) ? _arrayGetDoubles(j, j2, i, i2, dArr) : invokeCommon.intValue;
    }

    public double[] arrayGetDoubles(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _arrayGetDoubles(j, j2, i, i2) : (double[]) invokeCommon.objValue;
    }

    public int arrayGetInteger(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? _arrayGetInteger(j, j2, i) : invokeCommon.intValue;
    }

    public int arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), iArr})) == null) ? _arrayGetIntegers(j, j2, i, i2, iArr) : invokeCommon.intValue;
    }

    public int[] arrayGetIntegers(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _arrayGetIntegers(j, j2, i, i2) : (int[]) invokeCommon.objValue;
    }

    public int arrayGetSize(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _arrayGetSize(j, j2) : invokeCommon.intValue;
    }

    public String arrayGetString(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? _arrayGetString(j, j2, i) : (String) invokeCommon.objValue;
    }

    public int arrayGetStrings(long j, long j2, int i, int i2, String[] strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), strArr})) == null) ? _arrayGetStrings(j, j2, i, i2, strArr) : invokeCommon.intValue;
    }

    public String[] arrayGetStrings(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _arrayGetStrings(j, j2, i, i2) : (String[]) invokeCommon.objValue;
    }

    public Object callObjectJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j), v8Object, v8Array})) == null) {
            MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j));
            JavaCallback javaCallback = methodDescriptor.callback;
            if (javaCallback != null) {
                return checkResult(javaCallback.invoke(v8Object, v8Array));
            }
            boolean isVarArgs = methodDescriptor.method.isVarArgs();
            Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
            checkArgs(args);
            try {
                try {
                    sV8Receiver = v8Object;
                    return checkResult(methodDescriptor.method.invoke(methodDescriptor.object, args));
                } catch (IllegalAccessException e) {
                    throw e;
                } catch (IllegalArgumentException e2) {
                    throw e2;
                } catch (InvocationTargetException e3) {
                    throw e3.getTargetException();
                }
            } finally {
                sV8Receiver = null;
                releaseArguments(args, isVarArgs);
            }
        }
        return invokeCommon.objValue;
    }

    public void callVoidJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j), v8Object, v8Array}) == null) {
            MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j));
            JavaVoidCallback javaVoidCallback = methodDescriptor.voidCallback;
            if (javaVoidCallback != null) {
                javaVoidCallback.invoke(v8Object, v8Array);
                return;
            }
            boolean isVarArgs = methodDescriptor.method.isVarArgs();
            Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
            checkArgs(args);
            try {
                try {
                    sV8Receiver = v8Object;
                    methodDescriptor.method.invoke(methodDescriptor.object, args);
                } catch (Exception e) {
                    if (V8Plugins.getJSBindingErrorHandler() == null) {
                        throw e;
                    }
                    V8Plugins.getJSBindingErrorHandler().onExceptionCaptured(e);
                }
            } finally {
                sV8Receiver = null;
                releaseArguments(args, isVarArgs);
            }
        }
    }

    public void checkRuntime(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, v8Value) == null) || v8Value == null || v8Value.isUndefined()) {
            return;
        }
        V8 runtime = v8Value.getRuntime();
        if (runtime == null || runtime.isReleased() || runtime != this) {
            throw new Error("Invalid target runtime");
        }
    }

    public void checkThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.locker.checkThread();
            if (isReleased()) {
                throw new Error("Runtime disposed error");
            }
        }
    }

    public void clearWeak(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            _clearWeak(j, j2);
        }
    }

    @Override // com.kwad.v8.V8Value, com.kwad.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            release(true);
        }
    }

    public boolean contains(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? _contains(j, j2, str) : invokeCommon.booleanValue;
    }

    public void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048618, this, javaCallback, j) == null) {
            MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
            methodDescriptor.callback = javaCallback;
            this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
        }
    }

    public long createInspector(V8InspectorDelegate v8InspectorDelegate, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, v8InspectorDelegate, str)) == null) ? _createInspector(this.v8RuntimePtr, v8InspectorDelegate, str) : invokeLL.longValue;
    }

    public void createNodeRuntime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            _startNodeJS(this.v8RuntimePtr, str);
        }
    }

    public void createTwin(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            _createTwin(j, j2, j3);
        }
    }

    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, v8Value, v8Value2) == null) {
            checkThread();
            createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
        }
    }

    public ByteBuffer createV8ArrayBufferBackingStore(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? _createV8ArrayBufferBackingStore(j, j2, i) : (ByteBuffer) invokeCommon.objValue;
    }

    public void dispatchProtocolMessage(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048624, this, j, str) == null) {
            checkThread();
            _dispatchProtocolMessage(this.v8RuntimePtr, j, str);
        }
    }

    public void disposeMethodID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048625, this, j) == null) {
            this.functionRegistry.remove(Long.valueOf(j));
        }
    }

    public boolean equals(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? _equals(j, j2, j3) : invokeCommon.booleanValue;
    }

    public V8Array executeArrayScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) ? executeArrayScript(str, null, 0) : (V8Array) invokeL.objValue;
    }

    public V8Array executeArrayScript(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048628, this, str, str2, i)) == null) {
            checkThread();
            Object executeScript = executeScript(str, str2, i);
            if (executeScript instanceof V8Array) {
                return (V8Array) executeScript;
            }
            throw new V8ResultUndefined();
        }
        return (V8Array) invokeLLI.objValue;
    }

    public boolean executeBooleanFunction(long j, long j2, String str, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3)})) == null) ? _executeBooleanFunction(j, j2, str, j3) : invokeCommon.booleanValue;
    }

    public boolean executeBooleanScript(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) ? _executeBooleanScript(j, str, str2, i) : invokeCommon.booleanValue;
    }

    public boolean executeBooleanScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) ? executeBooleanScript(str, null, 0) : invokeL.booleanValue;
    }

    public boolean executeBooleanScript(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048632, this, str, str2, i)) == null) {
            checkThread();
            checkScript(str);
            return executeBooleanScript(this.v8RuntimePtr, str, str2, i);
        }
        return invokeLLI.booleanValue;
    }

    public double executeDoubleFunction(long j, long j2, String str, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3)})) == null) ? _executeDoubleFunction(j, j2, str, j3) : invokeCommon.doubleValue;
    }

    public double executeDoubleScript(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048634, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) ? _executeDoubleScript(j, str, str2, i) : invokeCommon.doubleValue;
    }

    public double executeDoubleScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) ? executeDoubleScript(str, null, 0) : invokeL.doubleValue;
    }

    public double executeDoubleScript(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048636, this, str, str2, i)) == null) {
            checkThread();
            checkScript(str);
            return executeDoubleScript(this.v8RuntimePtr, str, str2, i);
        }
        return invokeLLI.doubleValue;
    }

    public Object executeFunction(long j, int i, long j2, String str, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3)})) == null) ? _executeFunction(j, i, j2, str, j3) : invokeCommon.objValue;
    }

    public Object executeFunction(long j, long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048638, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) ? _executeFunction(j, j2, j3, j4) : invokeCommon.objValue;
    }

    public int executeIntegerFunction(long j, long j2, String str, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048639, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3)})) == null) ? _executeIntegerFunction(j, j2, str, j3) : invokeCommon.intValue;
    }

    public int executeIntegerScript(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048640, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) ? _executeIntegerScript(j, str, str2, i) : invokeCommon.intValue;
    }

    public int executeIntegerScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) ? executeIntegerScript(str, null, 0) : invokeL.intValue;
    }

    public int executeIntegerScript(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048642, this, str, str2, i)) == null) {
            checkThread();
            checkScript(str);
            return executeIntegerScript(this.v8RuntimePtr, str, str2, i);
        }
        return invokeLLI.intValue;
    }

    public Object executeModule(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048643, this, str, str2, str3, str4)) == null) {
            checkThread();
            checkScript(str);
            long v8RuntimePtr = getV8RuntimePtr();
            return executeScript(v8RuntimePtr, 0, str2 + str + str3, str4, 0);
        }
        return invokeLLLL.objValue;
    }

    public V8Object executeObjectScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) ? executeObjectScript(str, null, 0) : (V8Object) invokeL.objValue;
    }

    public V8Object executeObjectScript(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048645, this, str, str2, i)) == null) {
            checkThread();
            Object executeScript = executeScript(str, str2, i);
            if (executeScript instanceof V8Object) {
                return (V8Object) executeScript;
            }
            throw new V8ResultUndefined();
        }
        return (V8Object) invokeLLI.objValue;
    }

    public Object executeScript(long j, int i, String str, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, str2, Integer.valueOf(i2)})) == null) ? _executeScript(j, i, str, str2, i2) : invokeCommon.objValue;
    }

    public Object executeScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) ? executeScript(str, null, 0) : invokeL.objValue;
    }

    public Object executeScript(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, str, str2)) == null) {
            checkThread();
            checkScript(str);
            return executeScript(getV8RuntimePtr(), 0, str, str2, 0);
        }
        return invokeLL.objValue;
    }

    public Object executeScript(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048649, this, str, str2, i)) == null) {
            checkThread();
            checkScript(str);
            return executeScript(getV8RuntimePtr(), 0, str, str2, i);
        }
        return invokeLLI.objValue;
    }

    public String executeStringFunction(long j, long j2, String str, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048650, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3)})) == null) ? _executeStringFunction(j, j2, str, j3) : (String) invokeCommon.objValue;
    }

    public String executeStringScript(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048651, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) ? _executeStringScript(j, str, str2, i) : (String) invokeCommon.objValue;
    }

    public String executeStringScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, str)) == null) ? executeStringScript(str, null, 0) : (String) invokeL.objValue;
    }

    public String executeStringScript(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048653, this, str, str2, i)) == null) {
            checkThread();
            checkScript(str);
            return executeStringScript(this.v8RuntimePtr, str, str2, i);
        }
        return (String) invokeLLI.objValue;
    }

    public void executeVoidFunction(long j, long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3)}) == null) {
            _executeVoidFunction(j, j2, str, j3);
        }
    }

    public void executeVoidScript(long j, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) {
            _executeVoidScript(j, str, str2, i);
        }
    }

    public void executeVoidScript(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
            executeVoidScript(str, null, 0);
        }
    }

    public void executeVoidScript(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048657, this, str, str2, i) == null) {
            checkThread();
            checkScript(str);
            executeVoidScript(this.v8RuntimePtr, str, str2, i);
        }
    }

    public Object get(long j, int i, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str})) == null) ? _get(j, i, j2, str) : invokeCommon.objValue;
    }

    public int getArrayType(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048659, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _getArrayType(j, j2) : invokeCommon.intValue;
    }

    public boolean getBoolean(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048660, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? _getBoolean(j, j2, str) : invokeCommon.booleanValue;
    }

    public String getConstructorName(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048661, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _getConstructorName(j, j2) : (String) invokeCommon.objValue;
    }

    public Object getData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, str)) == null) {
            Map<String, Object> map = this.data;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
        return invokeL.objValue;
    }

    public double getDouble(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048663, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? _getDouble(j, j2, str) : invokeCommon.doubleValue;
    }

    public V8Executor getExecutor(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, v8Object)) == null) {
            checkThread();
            V8Map<V8Executor> v8Map = this.executors;
            if (v8Map == null) {
                return null;
            }
            return v8Map.get(v8Object);
        }
        return (V8Executor) invokeL.objValue;
    }

    public int getInteger(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048665, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? _getInteger(j, j2, str) : invokeCommon.intValue;
    }

    public String[] getKeys(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048666, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _getKeys(j, j2) : (String[]) invokeCommon.objValue;
    }

    public V8Locker getLocker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.locker : (V8Locker) invokeV.objValue;
    }

    public long getObjectReferenceCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.objectReferences - this.v8WeakReferences.size() : invokeV.longValue;
    }

    public String getString(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048669, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? _getString(j, j2, str) : (String) invokeCommon.objValue;
    }

    public int getType(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048670, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _getType(j, j2) : invokeCommon.intValue;
    }

    public int getType(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048671, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? _getType(j, j2, i) : invokeCommon.intValue;
    }

    public int getType(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048672, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _getType(j, j2, i, i2) : invokeCommon.intValue;
    }

    public int getType(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048673, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? _getType(j, j2, str) : invokeCommon.intValue;
    }

    public long getV8RuntimePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.v8RuntimePtr : invokeV.longValue;
    }

    public int identityHash(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048675, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _identityHash(j, j2) : invokeCommon.intValue;
    }

    public long initEmptyContainer(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048676, this, j)) == null) ? _initEmptyContainer(j) : invokeJ.longValue;
    }

    public long initNewV8Array(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048677, this, j)) == null) ? _initNewV8Array(j) : invokeJ.longValue;
    }

    public long initNewV8ArrayBuffer(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048678, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) ? _initNewV8ArrayBuffer(j, i) : invokeCommon.longValue;
    }

    public long initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048679, this, new Object[]{Long.valueOf(j), byteBuffer, Integer.valueOf(i)})) == null) ? _initNewV8ArrayBuffer(j, byteBuffer, i) : invokeCommon.longValue;
    }

    public long initNewV8Float32Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048680, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8Float32Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long initNewV8Float64Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048681, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8Float64Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long[] initNewV8Function(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048682, this, j)) == null) {
            checkThread();
            return _initNewV8Function(j);
        }
        return (long[]) invokeJ.objValue;
    }

    public long initNewV8Int16Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048683, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8Int16Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long initNewV8Int32Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048684, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8Int32Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long initNewV8Int8Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048685, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8Int8Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long initNewV8Object(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048686, this, j)) == null) ? _initNewV8Object(j) : invokeJ.longValue;
    }

    public long initNewV8UInt16Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048687, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8UInt16Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long initNewV8UInt32Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048688, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8UInt32Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long initNewV8UInt8Array(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048689, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8UInt8Array(j, j2, i, i2) : invokeCommon.longValue;
    }

    public long initNewV8UInt8ClampedArray(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048690, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? _initNewV8UInt8ClampedArray(j, j2, i, i2) : invokeCommon.longValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? _isRunning(this.v8RuntimePtr) : invokeV.booleanValue;
    }

    public boolean isWeak(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048692, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _isWeak(j, j2) : invokeCommon.booleanValue;
    }

    public void lowMemoryNotification() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            checkThread();
            lowMemoryNotification(getV8RuntimePtr());
        }
    }

    public void lowMemoryNotification(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048694, this, j) == null) {
            _lowMemoryNotification(j);
        }
    }

    public boolean pumpMessageLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? _pumpMessageLoop(this.v8RuntimePtr) : invokeV.booleanValue;
    }

    public void registerCallback(JavaCallback javaCallback, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048696, this, new Object[]{javaCallback, Long.valueOf(j), str}) == null) {
            createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j, str, false));
        }
    }

    public void registerCallback(Object obj, Method method, long j, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048697, this, new Object[]{obj, method, Long.valueOf(j), str, Boolean.valueOf(z)}) == null) {
            MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
            methodDescriptor.object = obj;
            methodDescriptor.method = method;
            methodDescriptor.includeReceiver = z;
            long registerJavaMethod = registerJavaMethod(getV8RuntimePtr(), j, str, isVoidMethod(method));
            this.methodId = registerJavaMethod;
            this.functionRegistry.put(Long.valueOf(registerJavaMethod), methodDescriptor);
        }
    }

    public long registerJavaMethod(long j, long j2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048698, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Boolean.valueOf(z)})) == null) ? _registerJavaMethod(j, j2, str, z) : invokeCommon.longValue;
    }

    public void registerResource(Releasable releasable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, releasable) == null) {
            checkThread();
            if (this.resources == null) {
                this.resources = new ArrayList();
            }
            this.resources.add(releasable);
        }
    }

    public void registerV8Executor(V8Object v8Object, V8Executor v8Executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048700, this, v8Object, v8Executor) == null) {
            checkThread();
            if (this.executors == null) {
                this.executors = new V8Map<>();
            }
            this.executors.put2((V8Value) v8Object, (V8Object) v8Executor);
        }
    }

    public void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048701, this, new Object[]{javaVoidCallback, Long.valueOf(j), str}) == null) {
            MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
            methodDescriptor.voidCallback = javaVoidCallback;
            this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, true)), methodDescriptor);
        }
    }

    @Override // com.kwad.v8.V8Value, com.kwad.v8.Releasable
    @Deprecated
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            release(true);
        }
    }

    public void release(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            _release(j, j2);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void release(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048704, this, z) == null) || isReleased()) {
            return;
        }
        checkThread();
        try {
            notifyReleaseHandlers(this);
            releaseResources();
            shutdownExecutors(this.forceTerminateExecutors);
            V8Map<V8Executor> v8Map = this.executors;
            if (v8Map != null) {
                v8Map.clear();
            }
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                runtimeCounter--;
            }
            _releaseRuntime(this.v8RuntimePtr);
            this.v8RuntimePtr = 0L;
            this.released = true;
            if (!z || getObjectReferenceCount() <= 0) {
                return;
            }
            throw new IllegalStateException(getObjectReferenceCount() + " Object(s) still exist in runtime");
        } catch (Throwable th) {
            releaseResources();
            shutdownExecutors(this.forceTerminateExecutors);
            V8Map<V8Executor> v8Map2 = this.executors;
            if (v8Map2 != null) {
                v8Map2.clear();
            }
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                runtimeCounter--;
                _releaseRuntime(this.v8RuntimePtr);
                this.v8RuntimePtr = 0L;
                this.released = true;
                if (!z || getObjectReferenceCount() <= 0) {
                    throw th;
                }
                throw new IllegalStateException(getObjectReferenceCount() + " Object(s) still exist in runtime");
            }
        }
    }

    public void releaseLock(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048705, this, j) == null) {
            _releaseLock(j);
        }
    }

    public void releaseMethodDescriptor(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048706, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            _releaseMethodDescriptor(j, j2);
        }
    }

    public void releaseObjRef(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, v8Value) == null) {
            if (!this.referenceHandlers.isEmpty()) {
                notifyReferenceDisposed(v8Value);
            }
            this.objectReferences--;
        }
    }

    public V8Executor removeExecutor(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, v8Object)) == null) {
            checkThread();
            V8Map<V8Executor> v8Map = this.executors;
            if (v8Map == null) {
                return null;
            }
            return v8Map.remove(v8Object);
        }
        return (V8Executor) invokeL.objValue;
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, referenceHandler) == null) {
            this.referenceHandlers.remove(referenceHandler);
        }
    }

    public void removeReleaseHandler(V8Runnable v8Runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, v8Runnable) == null) {
            this.releaseHandlers.remove(v8Runnable);
        }
    }

    public boolean sameValue(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048711, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? _sameValue(j, j2, j3) : invokeCommon.booleanValue;
    }

    public void schedulePauseOnNextStatement(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048712, this, j, str) == null) {
            checkThread();
            _schedulePauseOnNextStatement(this.v8RuntimePtr, j, str);
        }
    }

    public synchronized void setData(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048713, this, str, obj) == null) {
            synchronized (this) {
                if (this.data == null) {
                    this.data = new HashMap();
                }
                this.data.put(str, obj);
            }
        }
    }

    public void setPrototype(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            _setPrototype(j, j2, j3);
        }
    }

    public void setSignatureProvider(SignatureProvider signatureProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, signatureProvider) == null) {
            this.signatureProvider = signatureProvider;
        }
    }

    public void setWeak(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            _setWeak(j, j2);
        }
    }

    public void shutdownExecutors(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048717, this, z) == null) {
            checkThread();
            V8Map<V8Executor> v8Map = this.executors;
            if (v8Map == null) {
                return;
            }
            for (V8Executor v8Executor : v8Map.values()) {
                if (z) {
                    v8Executor.forceTermination();
                } else {
                    v8Executor.shutdown();
                }
            }
        }
    }

    public boolean strictEquals(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048718, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? _strictEquals(j, j2, j3) : invokeCommon.booleanValue;
    }

    public void terminateExecution() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.forceTerminateExecutors = true;
            terminateExecution(this.v8RuntimePtr);
        }
    }

    public void terminateExecution(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048720, this, j) == null) {
            _terminateExecution(j);
        }
    }

    public String toString(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048721, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? _toString(j, j2) : (String) invokeCommon.objValue;
    }

    public void weakReferenceReleased(long j) {
        V8Value v8Value;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048722, this, j) == null) || (v8Value = this.v8WeakReferences.get(Long.valueOf(j))) == null) {
            return;
        }
        this.v8WeakReferences.remove(Long.valueOf(j));
        try {
            v8Value.close();
        } catch (Exception unused) {
        }
    }
}
