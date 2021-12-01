package com.tachikoma.core.event.base;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import java.util.HashMap;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class TKBaseEvent implements IBaseEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TK_CLICK_EVENT_NAME = "tap";
    public static final String TK_DISPATCH_EVENT_NAME = "dispatch";
    public static final String TK_DOWN_EVENT_NAME = "down";
    public static final int TK_GESTURE_STATE_BEGAN = 1;
    public static final int TK_GESTURE_STATE_CANCELLED = 4;
    public static final int TK_GESTURE_STATE_CHANGED = 2;
    public static final int TK_GESTURE_STATE_ENDED = 3;
    public static final int TK_GESTURE_STATE_NORMAL = 0;
    public static final String TK_INPUT_EVENT_NAME = "input";
    public static final String TK_LONG_PRESS_EVENT_NAME = "longPress";
    public static final String TK_PAN_EVENT_NAME = "pan";
    public static final String TK_PINCH_EVENT_NAME = "pinch";
    public static final String TK_SCROLL_EVENT_NAME = "scroll";
    public static final String TK_SWIPE_EVENT_NAME = "swipe";
    public static final String TK_SWITCH_EVENT_NAME = "switch";
    public static final String TK_UP_EVENT_NAME = "up";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Object> mData;
    public int state;
    public long timestamp;
    public String type;

    public TKBaseEvent(Context context, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mData = new HashMap<>();
        this.timestamp = System.currentTimeMillis();
    }

    @Override // com.tachikoma.core.event.base.IBaseEvent
    public void configWithData(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            this.mData = hashMap;
        }
    }

    @Override // com.tachikoma.core.event.base.IBaseEvent
    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.state = i2;
        }
    }

    @Override // com.tachikoma.core.event.base.IBaseEvent
    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.type = str;
        }
    }
}
