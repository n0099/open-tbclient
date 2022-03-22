package com.yy.hiidostatis.defs.obj;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MetricsPkg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Counter> counterData;
    public int maxCount;
    public ConcurrentLinkedQueue<IJsonSerialize> metricsValues;
    public ConcurrentLinkedQueue<IJsonSerialize> reqData;

    public MetricsPkg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reqData = new ConcurrentLinkedQueue<>();
        this.metricsValues = new ConcurrentLinkedQueue<>();
        this.counterData = new HashMap<>();
        this.maxCount = i;
    }

    private JSONObject cutPiece(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{jSONArray, jSONArray2, jSONArray3, Long.valueOf(j)})) == null) {
            JSONObject jSONObject = new JSONObject();
            if (jSONArray != null) {
                try {
                    jSONObject.put("reqdata", jSONArray);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            if (jSONArray2 != null) {
                jSONObject.put("counterdata", jSONArray2);
            }
            if (jSONArray3 != null) {
                jSONObject.put("flatdata", jSONArray3);
            }
            jSONObject.put("clienttime", j);
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void addActionResult(ActionResult actionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actionResult) == null) {
            this.reqData.add(actionResult);
        }
    }

    public boolean addCounter(Counter counter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, counter)) == null) {
            String key = counter.getKey();
            Counter counter2 = this.counterData.get(key);
            boolean z = false;
            if (counter2 == null) {
                synchronized (this.counterData) {
                    Counter counter3 = this.counterData.get(key);
                    if (counter3 == null) {
                        this.counterData.put(key, (Counter) counter.clone());
                        z = true;
                    } else {
                        counter3.count(counter.getValue(), counter.getInvokeCount());
                    }
                }
            } else {
                counter2.count(counter.getValue(), counter.getInvokeCount());
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void addMetricsValue(MetricsValue metricsValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metricsValue) == null) {
            this.metricsValues.add(metricsValue);
        }
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.reqData.isEmpty() && this.metricsValues.isEmpty() && this.counterData.isEmpty() : invokeV.booleanValue;
    }

    public List<JSONObject> toJson() {
        InterceptResult invokeV;
        int i;
        JSONObject cutPiece;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<IJsonSerialize> it = this.reqData.iterator();
            JSONArray jSONArray = new JSONArray();
            loop0: while (true) {
                i = 0;
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJson());
                    i++;
                    if (i >= this.maxCount) {
                        JSONObject cutPiece2 = cutPiece(jSONArray, null, null, currentTimeMillis);
                        if (cutPiece2 != null) {
                            arrayList.add(cutPiece2);
                        }
                        jSONArray = new JSONArray();
                    }
                }
                break loop0;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (Counter counter : this.counterData.values()) {
                jSONArray2.put(counter.toJson());
                i++;
                if (i >= this.maxCount) {
                    JSONObject cutPiece3 = cutPiece(jSONArray, jSONArray2, null, currentTimeMillis);
                    if (cutPiece3 != null) {
                        arrayList.add(cutPiece3);
                    }
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    i = 0;
                }
            }
            Iterator<IJsonSerialize> it2 = this.metricsValues.iterator();
            JSONArray jSONArray3 = new JSONArray();
            while (it2.hasNext()) {
                jSONArray3.put(it2.next().toJson());
                i++;
                if (i >= this.maxCount) {
                    JSONObject cutPiece4 = cutPiece(jSONArray, jSONArray2, jSONArray3, currentTimeMillis);
                    if (cutPiece4 != null) {
                        arrayList.add(cutPiece4);
                    }
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    jSONArray3 = new JSONArray();
                    i = 0;
                }
            }
            if (jSONArray.length() + jSONArray2.length() + jSONArray3.length() > 0 && (cutPiece = cutPiece(jSONArray, jSONArray2, jSONArray3, currentTimeMillis)) != null) {
                arrayList.add(cutPiece);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
