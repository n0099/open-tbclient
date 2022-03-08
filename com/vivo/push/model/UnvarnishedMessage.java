package com.vivo.push.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.m;
import com.vivo.push.util.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UnvarnishedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UnvarnishedMessage";
    public transient /* synthetic */ FieldHolder $fh;
    public String mMessage;
    public long mMsgId;
    public Map<String, String> mParams;
    public int mTargetType;
    public String mTragetContent;

    public UnvarnishedMessage() {
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
        this.mParams = new HashMap();
    }

    private void packToObj(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    p.a(TAG, "unvarnishedMsg pack to obj is null");
                    return;
                }
                JSONArray jSONArray = new JSONArray(str);
                this.mTargetType = jSONArray.optInt(0);
                this.mTragetContent = jSONArray.getString(1);
                this.mMessage = jSONArray.getString(2);
                this.mParams = m.a(new JSONObject(jSONArray.getString(3)));
            } catch (JSONException e2) {
                e2.printStackTrace();
                p.a(TAG, "unvarnishedMsg pack to obj error", e2);
            }
        }
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mMessage : (String) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMsgId : invokeV.longValue;
    }

    public Map<String, String> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mParams : (Map) invokeV.objValue;
    }

    public int getTargetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTargetType : invokeV.intValue;
    }

    public String getTragetContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTragetContent : (String) invokeV.objValue;
    }

    public void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mMessage = str;
        }
    }

    public void setMsgId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.mMsgId = j2;
        }
    }

    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            this.mParams = map;
        }
    }

    public void setTargetType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mTargetType = i2;
        }
    }

    public void setTragetContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mTragetContent = str;
        }
    }

    public String unpackToJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.mTargetType);
            jSONArray.put(this.mTragetContent);
            jSONArray.put(this.mMessage);
            Object obj = this.mParams;
            if (obj == null) {
                obj = new HashMap();
            }
            jSONArray.put(obj);
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public UnvarnishedMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mParams = new HashMap();
        packToObj(str);
    }
}
