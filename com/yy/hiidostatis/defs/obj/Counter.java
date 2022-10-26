package com.yy.hiidostatis.defs.obj;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class Counter implements IJsonSerialize, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String counterName;
    public int invokeCount;
    public int scode;
    public String uri;
    public long value;

    public Counter(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.scode = i;
        this.uri = str;
        this.counterName = str2;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Counter counter = new Counter(this.scode, this.uri, this.counterName);
            counter.value = this.value;
            counter.invokeCount = this.invokeCount;
            return counter;
        }
        return invokeV.objValue;
    }

    public int getInvokeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.invokeCount;
        }
        return invokeV.intValue;
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return String.format("%d&%s&%s", Integer.valueOf(this.scode), this.uri, this.counterName);
        }
        return (String) invokeV.objValue;
    }

    public long getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.value;
        }
        return invokeV.longValue;
    }

    public synchronized void count(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            synchronized (this) {
                this.value += j;
                this.invokeCount += i;
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.obj.IJsonSerialize
    public JSONObject toJson() {
        InterceptResult invokeV;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                j = this.value;
                j2 = this.invokeCount;
            }
            if (j == 0 && j2 == 0) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scode", this.scode);
                jSONObject.put("uri", URLEncoder.encode(this.uri, IMAudioTransRequest.CHARSET));
                jSONObject.put("counterName", URLEncoder.encode(this.counterName, IMAudioTransRequest.CHARSET));
                jSONObject.put("value", j);
                jSONObject.put("invokecount", (int) j2);
                return jSONObject;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
