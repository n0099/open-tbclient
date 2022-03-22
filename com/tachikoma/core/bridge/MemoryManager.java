package com.tachikoma.core.bridge;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.ReferenceHandler;
import com.kwad.v8.V8;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.tachikoma.core.base.NativeModule;
import com.tachikoma.core.common.ILifeCycle;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class MemoryManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OBJ_ID_KEY = "_objId";
    public static long objId;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> dataMap;
    public final boolean enableV8ObjectLeakCheck;
    public ReferenceHandler mReferenceHandler;
    public ArrayList<V8Value> references;
    public boolean released;
    public boolean releasing;
    public final V8 v8;
    public List<V8ValueReference<Throwable>> v8ValueCreateStackTrace;
    public Set<V8ValueReference> weakReferenceSet;

    /* loaded from: classes7.dex */
    public static class V8ValueReference<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final T ext;
        public final V8Value v8Value;

        public V8ValueReference(V8Value v8Value) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Value};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.v8Value = v8Value;
            this.ext = null;
        }

        public V8ValueReference(V8Value v8Value, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Value, t};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.v8Value = v8Value;
            this.ext = t;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && V8ValueReference.class == obj.getClass() && ((V8ValueReference) obj).v8Value == this.v8Value;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v8Value.hashCode() : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1513547743, "Lcom/tachikoma/core/bridge/MemoryManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1513547743, "Lcom/tachikoma/core/bridge/MemoryManager;");
        }
    }

    public MemoryManager(V8 v8, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.references = new ArrayList<>();
        this.releasing = false;
        this.released = false;
        this.dataMap = new HashMap();
        this.weakReferenceSet = new HashSet();
        this.v8ValueCreateStackTrace = new ArrayList();
        ReferenceHandler referenceHandler = new ReferenceHandler(this) { // from class: com.tachikoma.core.bridge.MemoryManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MemoryManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwad.v8.ReferenceHandler
            public void v8HandleCreated(V8Value v8Value) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, v8Value) == null) || this.this$0.releasing) {
                    return;
                }
                this.this$0.references.add(v8Value);
                if (this.this$0.enableV8ObjectLeakCheck) {
                    this.this$0.v8ValueCreateStackTrace.add(new V8ValueReference(v8Value, new Exception("")));
                }
            }

            @Override // com.kwad.v8.ReferenceHandler
            public void v8HandleDisposed(V8Value v8Value) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Value) == null) || this.this$0.releasing) {
                    return;
                }
                Iterator it = this.this$0.references.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next() == v8Value) {
                        it.remove();
                        break;
                    }
                }
                if (this.this$0.enableV8ObjectLeakCheck) {
                    this.this$0.v8ValueCreateStackTrace.remove(new V8ValueReference(v8Value));
                }
                if ((v8Value instanceof V8Object) && this.this$0.weakReferenceSet.remove(new V8ValueReference(v8Value))) {
                    this.this$0.destroyLinkedNativeObject((V8Object) v8Value);
                }
            }
        };
        this.mReferenceHandler = referenceHandler;
        this.v8 = v8;
        this.enableV8ObjectLeakCheck = z;
        v8.addReferenceHandler(referenceHandler);
    }

    private void checkReleased() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && this.released) {
            throw new IllegalStateException("Memory manager released");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyLinkedNativeObject(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, v8Object) == null) {
            Object remove = this.dataMap.remove(String.valueOf(v8Object.get(OBJ_ID_KEY)));
            if (remove instanceof ILifeCycle) {
                ((ILifeCycle) remove).onDestroy();
            } else if (remove instanceof NativeModule) {
                ((NativeModule) remove).destroy();
            }
        }
    }

    public static String generateOrGetId(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, v8Object)) == null) {
            Object obj = v8Object.get(OBJ_ID_KEY);
            if (obj instanceof String) {
                return (String) obj;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            long j = objId;
            objId = 1 + j;
            sb.append(j);
            String sb2 = sb.toString();
            v8Object.add(OBJ_ID_KEY, sb2);
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    private void warningUnCloseV8Value() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.enableV8ObjectLeakCheck && !this.v8ValueCreateStackTrace.isEmpty()) {
            HashMap hashMap = new HashMap();
            int i = 0;
            for (V8ValueReference<Throwable> v8ValueReference : this.v8ValueCreateStackTrace) {
                StringWriter stringWriter = new StringWriter();
                if (v8ValueReference.ext != null && !v8ValueReference.v8Value.isReleased() && !v8ValueReference.v8Value.isWeak()) {
                    i++;
                    v8ValueReference.ext.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    Integer num = (Integer) hashMap.get(stringWriter2);
                    hashMap.put(stringWriter2, Integer.valueOf(Integer.valueOf(num == null ? 0 : num.intValue()).intValue() + 1));
                }
            }
            Log.e("MemoryManager", "总计未关闭的引用个数: " + i);
            for (String str : hashMap.keySet()) {
                Log.e("MemoryManager", "未关闭的引用个数：" + hashMap.get(str));
                Log.e("MemoryManager", str);
            }
            this.v8ValueCreateStackTrace.clear();
        }
    }

    public <T> T getLinkedNativeObject(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v8Object)) == null) {
            this.v8.getLocker().checkThread();
            return (T) this.dataMap.get(generateOrGetId(v8Object));
        }
        return (T) invokeL.objValue;
    }

    public int getObjectReferenceCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            checkReleased();
            return this.references.size();
        }
        return invokeV.intValue;
    }

    public boolean isReleased() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.released : invokeV.booleanValue;
    }

    public void linkNativeObject(V8Object v8Object, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, v8Object, obj) == null) {
            this.v8.getLocker().checkThread();
            if (v8Object == null || obj == null) {
                return;
            }
            removeLinkedNativeObject(v8Object);
            this.weakReferenceSet.add(new V8ValueReference(v8Object.twin().setWeak()));
            this.dataMap.put(generateOrGetId(v8Object), obj);
        }
    }

    public void persist(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v8Value) == null) {
            this.v8.getLocker().checkThread();
            checkReleased();
            this.references.remove(v8Value);
            if (this.enableV8ObjectLeakCheck) {
                this.v8ValueCreateStackTrace.remove(new V8ValueReference(v8Value));
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.v8.getLocker().checkThread();
            if (this.released) {
                return;
            }
            this.releasing = true;
            try {
                this.v8.removeReferenceHandler(this.mReferenceHandler);
                warningUnCloseV8Value();
                Iterator<V8Value> it = this.references.iterator();
                while (it.hasNext()) {
                    V8Value next = it.next();
                    if (!next.isReleased()) {
                        if (next instanceof V8Object) {
                            destroyLinkedNativeObject((V8Object) next);
                        }
                        next.close();
                    }
                }
                this.references.clear();
                this.releasing = false;
                this.released = true;
            } catch (Throwable th) {
                this.releasing = false;
                throw th;
            }
        }
    }

    public <T> T removeLinkedNativeObject(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v8Object)) == null) {
            this.v8.getLocker().checkThread();
            this.weakReferenceSet.remove(new V8ValueReference((V8Value) v8Object));
            return (T) this.dataMap.remove(generateOrGetId(v8Object));
        }
        return (T) invokeL.objValue;
    }

    public boolean removeNativeObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            for (Map.Entry<String, Object> entry : this.dataMap.entrySet()) {
                if (entry.getValue() == obj) {
                    this.dataMap.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
