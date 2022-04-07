package com.tachikoma.core.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.event.base.TKBaseEvent;
import com.tachikoma.core.event.guesture.TKDispatchEvent;
import com.tachikoma.core.event.guesture.TKDownEvent;
import com.tachikoma.core.event.guesture.TKLongPressEvent;
import com.tachikoma.core.event.guesture.TKPanEvent;
import com.tachikoma.core.event.guesture.TKPinchEvent;
import com.tachikoma.core.event.guesture.TKSwipeEvent;
import com.tachikoma.core.event.guesture.TKTapEvent;
import com.tachikoma.core.event.guesture.TKUpEvent;
import com.tachikoma.core.event.view.TKInputEvent;
import com.tachikoma.core.event.view.TKScrollEvent;
import com.tachikoma.core.event.view.TKSwitchEvent;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class TKEventCollection {
    public static /* synthetic */ Interceptable $ic;
    public static TKEventCollection instance;
    public static HashMap<String, String> mEventHashMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1263879643, "Lcom/tachikoma/core/event/TKEventCollection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1263879643, "Lcom/tachikoma/core/event/TKEventCollection;");
                return;
            }
        }
        instance = new TKEventCollection();
        mEventHashMap.put(TKBaseEvent.TK_CLICK_EVENT_NAME, TKTapEvent.class.getName());
        mEventHashMap.put("down", TKDownEvent.class.getName());
        mEventHashMap.put("up", TKUpEvent.class.getName());
        mEventHashMap.put(TKBaseEvent.TK_LONG_PRESS_EVENT_NAME, TKLongPressEvent.class.getName());
        mEventHashMap.put(TKBaseEvent.TK_SWIPE_EVENT_NAME, TKSwipeEvent.class.getName());
        mEventHashMap.put(TKBaseEvent.TK_PINCH_EVENT_NAME, TKPinchEvent.class.getName());
        mEventHashMap.put(TKBaseEvent.TK_PAN_EVENT_NAME, TKPanEvent.class.getName());
        mEventHashMap.put("scroll", TKScrollEvent.class.getName());
        mEventHashMap.put("input", TKInputEvent.class.getName());
        mEventHashMap.put("switch", TKSwitchEvent.class.getName());
        mEventHashMap.put("dispatch", TKDispatchEvent.class.getName());
    }

    public TKEventCollection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        mEventHashMap = new HashMap<>();
    }

    public static TKEventCollection getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? instance : (TKEventCollection) invokeV.objValue;
    }

    public void addEventPlugins(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
            return;
        }
        mEventHashMap.putAll(hashMap);
    }

    public String getEventName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String str2 = mEventHashMap.get(str);
            return str2 != null ? str2 : "Event";
        }
        return (String) invokeL.objValue;
    }
}
