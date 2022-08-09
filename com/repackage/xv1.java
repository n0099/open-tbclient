package com.repackage;

import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xv1 extends wv1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends fu1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<fu1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158242, "Lcom/repackage/xv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158242, "Lcom/repackage/xv1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", cv1.class);
        m.put("fillRect", ru1.class);
        m.put("setStrokeStyle", lv1.class);
        m.put("strokeStyle", sv1.class);
        m.put("setLineCap", fv1.class);
        m.put("setLineJoin", hv1.class);
        m.put("setLineWidth", iv1.class);
        m.put("setLineDash", gv1.class);
        m.put("setMiterLimit", jv1.class);
        m.put("strokeRect", rv1.class);
        m.put("moveTo", vu1.class);
        m.put("lineTo", uu1.class);
        m.put("stroke", qv1.class);
        m.put("fill", qu1.class);
        m.put("beginPath", iu1.class);
        m.put("rect", xu1.class);
        m.put("clearRect", ku1.class);
        m.put("closePath", mu1.class);
        m.put("arc", hu1.class);
        m.put("bezierCurveTo", ju1.class);
        m.put("quadraticCurveTo", wu1.class);
        m.put("scale", bv1.class);
        m.put("rotate", zu1.class);
        m.put("translate", vv1.class);
        m.put("transform", uv1.class);
        m.put("setTransform", ov1.class);
        m.put("font", tu1.class);
        m.put("setFontSize", dv1.class);
        m.put("setTextAlign", mv1.class);
        m.put("setTextBaseline", nv1.class);
        m.put("fillText", su1.class);
        m.put("strokeText", tv1.class);
        m.put("clip", lu1.class);
        m.put("drawImage", pu1.class);
        m.put("save", av1.class);
        m.put("restore", yu1.class);
        m.put("setShadow", kv1.class);
        m.put("setGlobalAlpha", ev1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xv1(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString(NotificationCompat.WearableExtender.KEY_ACTIONS));
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends fu1> cls = m.get(optString);
                if (cls != null) {
                    fu1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (jh1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<fu1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.wv1, com.repackage.pw1, com.repackage.yq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
