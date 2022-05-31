package com.tachikoma.core.event.guesture;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.event.base.TKBaseEvent;
import java.util.HashMap;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKSwipeEvent extends TKBaseEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIRECTION_DOWN = "down";
    public static final String DIRECTION_LEFT = "left";
    public static final String DIRECTION_RIGHT = "right";
    public static final String DIRECTION_UP = "up";
    public transient /* synthetic */ FieldHolder $fh;
    public String direction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKSwipeEvent(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private float getFloatValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, obj)) == null) {
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    @Override // com.tachikoma.core.event.base.TKBaseEvent, com.tachikoma.core.event.base.IBaseEvent
    public void configWithData(HashMap<String, Object> hashMap) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            super.configWithData(hashMap);
            float floatValue = getFloatValue(hashMap.get("beginX"));
            float floatValue2 = getFloatValue(hashMap.get("beginY"));
            float floatValue3 = getFloatValue(hashMap.get("endX"));
            float floatValue4 = getFloatValue(hashMap.get("endY"));
            float floatValue5 = getFloatValue(hashMap.get("velocityX"));
            float floatValue6 = getFloatValue(hashMap.get("velocityY"));
            if (floatValue - floatValue3 > 120.0f && Math.abs(floatValue5) > 0.0f) {
                str = "left";
            } else if (floatValue3 - floatValue > 120.0f && Math.abs(floatValue5) > 0.0f) {
                str = "right";
            } else if (floatValue2 - floatValue4 > 120.0f && Math.abs(floatValue6) > 0.0f) {
                str = "up";
            } else if (floatValue4 - floatValue2 <= 120.0f || Math.abs(floatValue6) <= 0.0f) {
                return;
            } else {
                str = "down";
            }
            this.direction = str;
        }
    }

    public void setDirection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.direction = str;
        }
    }
}
