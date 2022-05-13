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
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sv1 extends rv1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends au1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<au1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755307197, "Lcom/repackage/sv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755307197, "Lcom/repackage/sv1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", xu1.class);
        m.put("fillRect", mu1.class);
        m.put("setStrokeStyle", gv1.class);
        m.put("strokeStyle", nv1.class);
        m.put("setLineCap", av1.class);
        m.put("setLineJoin", cv1.class);
        m.put("setLineWidth", dv1.class);
        m.put("setLineDash", bv1.class);
        m.put("setMiterLimit", ev1.class);
        m.put("strokeRect", mv1.class);
        m.put("moveTo", qu1.class);
        m.put("lineTo", pu1.class);
        m.put("stroke", lv1.class);
        m.put("fill", lu1.class);
        m.put("beginPath", du1.class);
        m.put("rect", su1.class);
        m.put("clearRect", fu1.class);
        m.put("closePath", hu1.class);
        m.put("arc", cu1.class);
        m.put("bezierCurveTo", eu1.class);
        m.put("quadraticCurveTo", ru1.class);
        m.put(AnimationProperty.SCALE, wu1.class);
        m.put(AnimationProperty.ROTATE, uu1.class);
        m.put(AnimationProperty.TRANSLATE, qv1.class);
        m.put(AnimationProperty.TRANSFORM, pv1.class);
        m.put("setTransform", jv1.class);
        m.put("font", ou1.class);
        m.put("setFontSize", yu1.class);
        m.put("setTextAlign", hv1.class);
        m.put("setTextBaseline", iv1.class);
        m.put("fillText", nu1.class);
        m.put("strokeText", ov1.class);
        m.put("clip", gu1.class);
        m.put("drawImage", ku1.class);
        m.put("save", vu1.class);
        m.put("restore", tu1.class);
        m.put("setShadow", fv1.class);
        m.put("setGlobalAlpha", zu1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sv1(String str) {
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
                Class<? extends au1> cls = m.get(optString);
                if (cls != null) {
                    au1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (eh1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<au1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.rv1, com.repackage.kw1, com.repackage.tq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
