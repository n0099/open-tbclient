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
public class qu1 extends pu1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends ys1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ys1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755367740, "Lcom/repackage/qu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755367740, "Lcom/repackage/qu1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", vt1.class);
        m.put("fillRect", kt1.class);
        m.put("setStrokeStyle", eu1.class);
        m.put("strokeStyle", lu1.class);
        m.put("setLineCap", yt1.class);
        m.put("setLineJoin", au1.class);
        m.put("setLineWidth", bu1.class);
        m.put("setLineDash", zt1.class);
        m.put("setMiterLimit", cu1.class);
        m.put("strokeRect", ku1.class);
        m.put("moveTo", ot1.class);
        m.put("lineTo", nt1.class);
        m.put("stroke", ju1.class);
        m.put("fill", jt1.class);
        m.put("beginPath", bt1.class);
        m.put("rect", qt1.class);
        m.put("clearRect", dt1.class);
        m.put("closePath", ft1.class);
        m.put("arc", at1.class);
        m.put("bezierCurveTo", ct1.class);
        m.put("quadraticCurveTo", pt1.class);
        m.put(AnimationProperty.SCALE, ut1.class);
        m.put(AnimationProperty.ROTATE, st1.class);
        m.put(AnimationProperty.TRANSLATE, ou1.class);
        m.put(AnimationProperty.TRANSFORM, nu1.class);
        m.put("setTransform", hu1.class);
        m.put("font", mt1.class);
        m.put("setFontSize", wt1.class);
        m.put("setTextAlign", fu1.class);
        m.put("setTextBaseline", gu1.class);
        m.put("fillText", lt1.class);
        m.put("strokeText", mu1.class);
        m.put("clip", et1.class);
        m.put("drawImage", it1.class);
        m.put("save", tt1.class);
        m.put("restore", rt1.class);
        m.put("setShadow", du1.class);
        m.put("setGlobalAlpha", xt1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu1(String str) {
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
                Class<? extends ys1> cls = m.get(optString);
                if (cls != null) {
                    ys1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (cg1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<ys1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.pu1, com.repackage.iv1, com.repackage.rp2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
