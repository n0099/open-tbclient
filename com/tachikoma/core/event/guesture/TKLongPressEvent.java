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
import java.util.Map;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKLongPressEvent extends TKBaseEvent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Float> mPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKLongPressEvent(Context context, List<Object> list) {
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
        this.mPosition = new HashMap<>();
    }

    @Override // com.tachikoma.core.event.base.TKBaseEvent, com.tachikoma.core.event.base.IBaseEvent
    public void configWithData(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            super.configWithData(hashMap);
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                this.mPosition.put(entry.getKey(), Float.valueOf(((Number) entry.getValue()).floatValue()));
            }
        }
    }

    public HashMap<String, Float> getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPosition : (HashMap) invokeV.objValue;
    }

    public void setPosition(HashMap<String, Float> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.mPosition = hashMap;
        }
    }
}
