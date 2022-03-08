package org.apache.commons.lang3.event;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;
/* loaded from: classes9.dex */
public class EventListenerSupport<L> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3593265990380473632L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<L> listeners;
    public transient L[] prototypeArray;
    public transient L proxy;

    /* loaded from: classes9.dex */
    public class ProxyInvocationHandler implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EventListenerSupport this$0;

        public ProxyInvocationHandler(EventListenerSupport eventListenerSupport) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eventListenerSupport};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eventListenerSupport;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                for (Object obj2 : this.this$0.listeners) {
                    method.invoke(obj2, objArr);
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventListenerSupport(Class<L> cls) {
        this(cls, Thread.currentThread().getContextClassLoader());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Class) objArr2[0], (ClassLoader) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static <T> EventListenerSupport<T> create(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) ? new EventListenerSupport<>(cls) : (EventListenerSupport) invokeL.objValue;
    }

    private void createProxy(Class<L> cls, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, cls, classLoader) == null) {
            this.proxy = cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, createInvocationHandler()));
        }
    }

    private void initializeTransientFields(Class<L> cls, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, cls, classLoader) == null) {
            this.prototypeArray = (L[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
            createProxy(cls, classLoader);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, objectInputStream) == null) {
            Object[] objArr = (Object[]) objectInputStream.readObject();
            this.listeners = new CopyOnWriteArrayList(objArr);
            initializeTransientFields(objArr.getClass().getComponentType(), Thread.currentThread().getContextClassLoader());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, objectOutputStream) == null) {
            ArrayList arrayList = new ArrayList();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
            for (L l : this.listeners) {
                try {
                    objectOutputStream2.writeObject(l);
                    arrayList.add(l);
                } catch (IOException unused) {
                    objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
                }
            }
            objectOutputStream.writeObject(arrayList.toArray(this.prototypeArray));
        }
    }

    public void addListener(L l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
            addListener(l, true);
        }
    }

    public InvocationHandler createInvocationHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ProxyInvocationHandler(this) : (InvocationHandler) invokeV.objValue;
    }

    public L fire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.proxy : (L) invokeV.objValue;
    }

    public int getListenerCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.listeners.size() : invokeV.intValue;
    }

    public L[] getListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (L[]) this.listeners.toArray(this.prototypeArray) : (L[]) ((Object[]) invokeV.objValue);
    }

    public void removeListener(L l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, l) == null) {
            Validate.notNull(l, "Listener object cannot be null.", new Object[0]);
            this.listeners.remove(l);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventListenerSupport(Class<L> cls, ClassLoader classLoader) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, classLoader};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Validate.notNull(cls, "Listener interface cannot be null.", new Object[0]);
        Validate.notNull(classLoader, "ClassLoader cannot be null.", new Object[0]);
        Validate.isTrue(cls.isInterface(), "Class {0} is not an interface", cls.getName());
        initializeTransientFields(cls, classLoader);
    }

    public void addListener(L l, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, z) == null) {
            Validate.notNull(l, "Listener object cannot be null.", new Object[0]);
            if (z) {
                this.listeners.add(l);
            } else if (this.listeners.contains(l)) {
            } else {
                this.listeners.add(l);
            }
        }
    }

    public EventListenerSupport() {
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
        this.listeners = new CopyOnWriteArrayList();
    }
}
