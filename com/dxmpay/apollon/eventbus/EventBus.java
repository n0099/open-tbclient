package com.dxmpay.apollon.eventbus;

import androidx.core.view.InputDeviceCompat;
import b.e.a.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class EventBus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_METHOD_NAME = "onModuleEvent";
    public static EventBus mEventBusInstance;
    public static b mEventController;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public class Event {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mEventKey;
        public Object mEventObj;
        public final /* synthetic */ EventBus this$0;

        public Event(EventBus eventBus, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eventBus, str, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eventBus;
            this.mEventKey = str;
            this.mEventObj = obj;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class ThreadMode {
        public static final /* synthetic */ ThreadMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ThreadMode Async;
        public static final ThreadMode MainThread;
        public static final ThreadMode PostThread;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890092259, "Lcom/dxmpay/apollon/eventbus/EventBus$ThreadMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1890092259, "Lcom/dxmpay/apollon/eventbus/EventBus$ThreadMode;");
                    return;
                }
            }
            PostThread = new ThreadMode("PostThread", 0);
            MainThread = new ThreadMode("MainThread", 1);
            ThreadMode threadMode = new ThreadMode("Async", 2);
            Async = threadMode;
            $VALUES = new ThreadMode[]{PostThread, MainThread, threadMode};
        }

        public ThreadMode(String str, int i2) {
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

        public static ThreadMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ThreadMode) Enum.valueOf(ThreadMode.class, str) : (ThreadMode) invokeL.objValue;
        }

        public static ThreadMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ThreadMode[]) $VALUES.clone() : (ThreadMode[]) invokeV.objValue;
        }
    }

    public EventBus() {
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
        mEventController = new b();
    }

    public static EventBus getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mEventBusInstance == null) {
                synchronized (EventBus.class) {
                    if (mEventBusInstance == null) {
                        mEventBusInstance = new EventBus();
                    }
                }
            }
            return mEventBusInstance;
        }
        return (EventBus) invokeV.objValue;
    }

    public void cancelEventDelivery(Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            mEventController.p(event);
        }
    }

    public void post(Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            mEventController.b(event);
        }
    }

    public void postStickyEvent(Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            mEventController.n(event);
        }
    }

    public void register(Object obj, String str, int i2, ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, obj, str, i2, threadMode) == null) {
            mEventController.i(obj, str, i2, false, threadMode);
        }
    }

    public void registerSticky(Object obj, String str, int i2, ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048581, this, obj, str, i2, threadMode) == null) {
            mEventController.i(obj, str, i2, true, threadMode);
        }
    }

    public void removeAllStickyEvents() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            mEventController.a();
        }
    }

    public void removeStickyEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            mEventController.m(str);
        }
    }

    public synchronized void unregister(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
            synchronized (this) {
                mEventController.g(obj);
            }
        }
    }

    public void register(Object obj, String[] strArr, int i2, ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, obj, strArr, i2, threadMode) == null) {
            mEventController.l(obj, strArr, i2, false, threadMode);
        }
    }

    public synchronized void unregister(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, obj, str) == null) {
            synchronized (this) {
                mEventController.h(obj, str);
            }
        }
    }

    public synchronized void unregister(Object obj, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, obj, strArr) == null) {
            synchronized (this) {
                if (strArr == null) {
                    return;
                }
                for (String str : strArr) {
                    mEventController.h(obj, str);
                }
            }
        }
    }
}
