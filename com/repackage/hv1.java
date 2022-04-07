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
/* loaded from: classes6.dex */
public class hv1 extends gv1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends pt1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pt1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755634898, "Lcom/repackage/hv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755634898, "Lcom/repackage/hv1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", mu1.class);
        m.put("fillRect", bu1.class);
        m.put("setStrokeStyle", vu1.class);
        m.put("strokeStyle", cv1.class);
        m.put("setLineCap", pu1.class);
        m.put("setLineJoin", ru1.class);
        m.put("setLineWidth", su1.class);
        m.put("setLineDash", qu1.class);
        m.put("setMiterLimit", tu1.class);
        m.put("strokeRect", bv1.class);
        m.put("moveTo", fu1.class);
        m.put("lineTo", eu1.class);
        m.put("stroke", av1.class);
        m.put("fill", au1.class);
        m.put("beginPath", st1.class);
        m.put("rect", hu1.class);
        m.put("clearRect", ut1.class);
        m.put("closePath", wt1.class);
        m.put("arc", rt1.class);
        m.put("bezierCurveTo", tt1.class);
        m.put("quadraticCurveTo", gu1.class);
        m.put(AnimationProperty.SCALE, lu1.class);
        m.put(AnimationProperty.ROTATE, ju1.class);
        m.put(AnimationProperty.TRANSLATE, fv1.class);
        m.put(AnimationProperty.TRANSFORM, ev1.class);
        m.put("setTransform", yu1.class);
        m.put("font", du1.class);
        m.put("setFontSize", nu1.class);
        m.put("setTextAlign", wu1.class);
        m.put("setTextBaseline", xu1.class);
        m.put("fillText", cu1.class);
        m.put("strokeText", dv1.class);
        m.put("clip", vt1.class);
        m.put("drawImage", zt1.class);
        m.put("save", ku1.class);
        m.put("restore", iu1.class);
        m.put("setShadow", uu1.class);
        m.put("setGlobalAlpha", ou1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hv1(String str) {
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
                Class<? extends pt1> cls = m.get(optString);
                if (cls != null) {
                    pt1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (tg1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<pt1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.gv1, com.repackage.zv1, com.repackage.iq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
