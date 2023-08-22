package com.huawei.hms.core.aidl;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.utils.JsonUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends MessageCodec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    public List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, type, bundle)) == null) {
            int i = bundle.getInt(JsonUtil.LIST_SIZE);
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = bundle.get(JsonUtil.LIST_ITEM_VALUE + i2);
                if (!obj.getClass().isPrimitive() && !(obj instanceof String) && !(obj instanceof Serializable)) {
                    if (obj instanceof Bundle) {
                        Bundle bundle2 = (Bundle) obj;
                        int i3 = bundle2.getInt("_val_type_", -1);
                        if (i3 != 1) {
                            if (i3 == 0) {
                                arrayList.add(decode(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                            } else {
                                throw new InstantiationException("Unknown type can not be supported");
                            }
                        } else {
                            throw new InstantiationException("Nested List can not be supported");
                        }
                    } else {
                        continue;
                    }
                } else {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    public void writeList(String str, List list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, bundle) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("_val_type_", 1);
            bundle2.putInt(JsonUtil.LIST_SIZE, list.size());
            for (int i = 0; i < list.size(); i++) {
                writeValue(JsonUtil.LIST_ITEM_VALUE + i, list.get(i), bundle2);
            }
            bundle.putBundle(str, bundle2);
        }
    }
}
