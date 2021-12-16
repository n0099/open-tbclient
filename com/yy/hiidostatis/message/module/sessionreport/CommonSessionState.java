package com.yy.hiidostatis.message.module.sessionreport;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.message.SessionReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CommonSessionState implements SessionReport.StatisContentAble {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Map<String, Map<String, String>> extras;
    public volatile Map<String, Map<String, CalValue>> stateStore;

    public CommonSessionState() {
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
        this.stateStore = new HashMap();
        this.extras = new HashMap();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.stateStore.clear();
            this.extras.clear();
        }
    }

    public CalValue get(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            Map<String, CalValue> map = this.stateStore.get(str);
            if (map != null) {
                return map.get(str2);
            }
            return null;
        }
        return (CalValue) invokeLL.objValue;
    }

    public void put(String str, String str2, CalValue calValue, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, calValue, map) == null) {
            Map<String, CalValue> map2 = this.stateStore.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.stateStore.put(str, map2);
            }
            map2.put(str2, calValue);
            if (map == null || map.isEmpty()) {
                return;
            }
            this.extras.put(str, map);
        }
    }

    @Override // com.yy.hiidostatis.message.SessionReport.StatisContentAble
    public List<StatisContent> toStatisContent(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            Map<String, Map<String, CalValue>> map = this.stateStore;
            Map<String, Map<String, String>> map2 = this.extras;
            this.stateStore = new HashMap();
            this.extras = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Map<String, CalValue>> entry : map.entrySet()) {
                try {
                    StatisContent statisContent = new StatisContent(str);
                    statisContent.put("eventid", str2);
                    if (!entry.getKey().isEmpty()) {
                        for (String str3 : entry.getKey().split(",")) {
                            String[] split = str3.split("=");
                            try {
                                statisContent.put(split[0], split[1]);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    Map<String, String> map3 = map2.get(entry.getKey());
                    if (map3 != null && !map3.isEmpty()) {
                        for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                            statisContent.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    for (Map.Entry<String, CalValue> entry3 : entry.getValue().entrySet()) {
                        if (entry3.getValue().value instanceof Long) {
                            statisContent.put(entry3.getKey(), entry3.getValue().value.longValue());
                        } else {
                            statisContent.put(entry3.getKey(), entry3.getValue().value.doubleValue());
                        }
                    }
                    arrayList.add(statisContent);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
