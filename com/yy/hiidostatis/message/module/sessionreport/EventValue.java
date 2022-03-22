package com.yy.hiidostatis.message.module.sessionreport;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes7.dex */
public class EventValue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CalAction calAction;
    public Map<String, String> dimens;
    public Map<String, String> extra;
    public String key;
    public Number value;

    public EventValue(CalAction calAction, String str, Number number) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {calAction, str, number};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.calAction = calAction;
        this.key = str;
        this.value = number;
    }

    public String dimIdentification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> map = this.dimens;
            if (map == null || map.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList(this.dimens.keySet());
            Collections.sort(arrayList);
            for (String str : arrayList) {
                sb.append(str);
                sb.append("=");
                sb.append(this.dimens.get(str));
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
