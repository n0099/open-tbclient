package com.kwad.v8.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.ReferenceHandler;
import com.kwad.v8.V8;
import com.kwad.v8.V8Value;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class MemoryManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MemoryManagerReferenceHandler memoryManagerReferenceHandler;
    public ArrayList<V8Value> references;
    public boolean released;
    public boolean releasing;
    public V8 v8;

    /* renamed from: com.kwad.v8.utils.MemoryManager$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class MemoryManagerReferenceHandler implements ReferenceHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemoryManager this$0;

        public MemoryManagerReferenceHandler(MemoryManager memoryManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memoryManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = memoryManager;
        }

        public /* synthetic */ MemoryManagerReferenceHandler(MemoryManager memoryManager, AnonymousClass1 anonymousClass1) {
            this(memoryManager);
        }

        @Override // com.kwad.v8.ReferenceHandler
        public void v8HandleCreated(V8Value v8Value) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v8Value) == null) {
                this.this$0.references.add(v8Value);
            }
        }

        @Override // com.kwad.v8.ReferenceHandler
        public void v8HandleDisposed(V8Value v8Value) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Value) == null) || this.this$0.releasing) {
                return;
            }
            Iterator it = this.this$0.references.iterator();
            while (it.hasNext()) {
                if (it.next() == v8Value) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public MemoryManager(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.references = new ArrayList<>();
        this.releasing = false;
        this.released = false;
        this.v8 = v8;
        MemoryManagerReferenceHandler memoryManagerReferenceHandler = new MemoryManagerReferenceHandler(this, null);
        this.memoryManagerReferenceHandler = memoryManagerReferenceHandler;
        v8.addReferenceHandler(memoryManagerReferenceHandler);
    }

    private void checkReleased() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.released) {
            throw new IllegalStateException("Memory manager released");
        }
    }

    public int getObjectReferenceCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            checkReleased();
            return this.references.size();
        }
        return invokeV.intValue;
    }

    public boolean isReleased() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.released : invokeV.booleanValue;
    }

    public void persist(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v8Value) == null) {
            this.v8.getLocker().checkThread();
            checkReleased();
            this.references.remove(v8Value);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.v8.getLocker().checkThread();
            if (this.released) {
                return;
            }
            this.releasing = true;
            try {
                Iterator<V8Value> it = this.references.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                this.v8.removeReferenceHandler(this.memoryManagerReferenceHandler);
                this.references.clear();
                this.releasing = false;
                this.released = true;
            } catch (Throwable th) {
                this.releasing = false;
                throw th;
            }
        }
    }
}
