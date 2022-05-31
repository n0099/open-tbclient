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
/* loaded from: classes5.dex */
public class fu1 extends eu1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends ns1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ns1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755695441, "Lcom/repackage/fu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755695441, "Lcom/repackage/fu1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", kt1.class);
        m.put("fillRect", zs1.class);
        m.put("setStrokeStyle", tt1.class);
        m.put("strokeStyle", au1.class);
        m.put("setLineCap", nt1.class);
        m.put("setLineJoin", pt1.class);
        m.put("setLineWidth", qt1.class);
        m.put("setLineDash", ot1.class);
        m.put("setMiterLimit", rt1.class);
        m.put("strokeRect", zt1.class);
        m.put("moveTo", dt1.class);
        m.put("lineTo", ct1.class);
        m.put("stroke", yt1.class);
        m.put("fill", ys1.class);
        m.put("beginPath", qs1.class);
        m.put("rect", ft1.class);
        m.put("clearRect", ss1.class);
        m.put("closePath", us1.class);
        m.put("arc", ps1.class);
        m.put("bezierCurveTo", rs1.class);
        m.put("quadraticCurveTo", et1.class);
        m.put(AnimationProperty.SCALE, jt1.class);
        m.put(AnimationProperty.ROTATE, ht1.class);
        m.put(AnimationProperty.TRANSLATE, du1.class);
        m.put(AnimationProperty.TRANSFORM, cu1.class);
        m.put("setTransform", wt1.class);
        m.put("font", bt1.class);
        m.put("setFontSize", lt1.class);
        m.put("setTextAlign", ut1.class);
        m.put("setTextBaseline", vt1.class);
        m.put("fillText", at1.class);
        m.put("strokeText", bu1.class);
        m.put("clip", ts1.class);
        m.put("drawImage", xs1.class);
        m.put("save", it1.class);
        m.put("restore", gt1.class);
        m.put("setShadow", st1.class);
        m.put("setGlobalAlpha", mt1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu1(String str) {
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
                Class<? extends ns1> cls = m.get(optString);
                if (cls != null) {
                    ns1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (rf1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<ns1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.eu1, com.repackage.xu1, com.repackage.gp2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
