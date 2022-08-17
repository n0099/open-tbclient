package com.repackage;

import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class te7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Rect b;
    public String c;
    public Rect d;

    public te7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = new Rect(0, 0, 0, 0);
        this.c = "";
        this.d = new Rect(0, 0, 0, 0);
    }

    public static te7 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new te7();
            }
            try {
                return new te7(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new te7();
            }
        }
        return (te7) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.c) || this.d.isEmpty()) ? false : true : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.a) || this.b.isEmpty()) ? false : true : invokeV.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
            if (optJSONArray == null) {
                return;
            }
            try {
                JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                if (jSONObject == null) {
                    return;
                }
                this.c = jSONObject.optString("pic_url");
                this.d = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("pic_url", this.a);
                    jSONObject.put("rect_left", this.b.left);
                    jSONObject.put("rect_top", this.b.top);
                    jSONObject.put("rect_right", this.b.right);
                    jSONObject.put("rect_bottom", this.b.bottom);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public te7(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = jSONObject.optString("pic_url");
        this.b = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
    }
}
