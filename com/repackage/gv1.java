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
/* loaded from: classes6.dex */
public class gv1 extends fv1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends ot1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ot1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755664689, "Lcom/repackage/gv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755664689, "Lcom/repackage/gv1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", lu1.class);
        m.put("fillRect", au1.class);
        m.put("setStrokeStyle", uu1.class);
        m.put("strokeStyle", bv1.class);
        m.put("setLineCap", ou1.class);
        m.put("setLineJoin", qu1.class);
        m.put("setLineWidth", ru1.class);
        m.put("setLineDash", pu1.class);
        m.put("setMiterLimit", su1.class);
        m.put("strokeRect", av1.class);
        m.put("moveTo", eu1.class);
        m.put("lineTo", du1.class);
        m.put("stroke", zu1.class);
        m.put("fill", zt1.class);
        m.put("beginPath", rt1.class);
        m.put("rect", gu1.class);
        m.put("clearRect", tt1.class);
        m.put("closePath", vt1.class);
        m.put("arc", qt1.class);
        m.put("bezierCurveTo", st1.class);
        m.put("quadraticCurveTo", fu1.class);
        m.put("scale", ku1.class);
        m.put("rotate", iu1.class);
        m.put("translate", ev1.class);
        m.put("transform", dv1.class);
        m.put("setTransform", xu1.class);
        m.put("font", cu1.class);
        m.put("setFontSize", mu1.class);
        m.put("setTextAlign", vu1.class);
        m.put("setTextBaseline", wu1.class);
        m.put("fillText", bu1.class);
        m.put("strokeText", cv1.class);
        m.put("clip", ut1.class);
        m.put("drawImage", yt1.class);
        m.put("save", ju1.class);
        m.put("restore", hu1.class);
        m.put("setShadow", tu1.class);
        m.put("setGlobalAlpha", nu1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gv1(String str) {
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
                Class<? extends ot1> cls = m.get(optString);
                if (cls != null) {
                    ot1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (sg1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<ot1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.fv1, com.repackage.yv1, com.repackage.hq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
