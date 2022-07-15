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
public class fv1 extends ev1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends nt1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nt1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755694480, "Lcom/repackage/fv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755694480, "Lcom/repackage/fv1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", ku1.class);
        m.put("fillRect", zt1.class);
        m.put("setStrokeStyle", tu1.class);
        m.put("strokeStyle", av1.class);
        m.put("setLineCap", nu1.class);
        m.put("setLineJoin", pu1.class);
        m.put("setLineWidth", qu1.class);
        m.put("setLineDash", ou1.class);
        m.put("setMiterLimit", ru1.class);
        m.put("strokeRect", zu1.class);
        m.put("moveTo", du1.class);
        m.put("lineTo", cu1.class);
        m.put("stroke", yu1.class);
        m.put("fill", yt1.class);
        m.put("beginPath", qt1.class);
        m.put("rect", fu1.class);
        m.put("clearRect", st1.class);
        m.put("closePath", ut1.class);
        m.put("arc", pt1.class);
        m.put("bezierCurveTo", rt1.class);
        m.put("quadraticCurveTo", eu1.class);
        m.put("scale", ju1.class);
        m.put("rotate", hu1.class);
        m.put("translate", dv1.class);
        m.put("transform", cv1.class);
        m.put("setTransform", wu1.class);
        m.put("font", bu1.class);
        m.put("setFontSize", lu1.class);
        m.put("setTextAlign", uu1.class);
        m.put("setTextBaseline", vu1.class);
        m.put("fillText", au1.class);
        m.put("strokeText", bv1.class);
        m.put("clip", tt1.class);
        m.put("drawImage", xt1.class);
        m.put("save", iu1.class);
        m.put("restore", gu1.class);
        m.put("setShadow", su1.class);
        m.put("setGlobalAlpha", mu1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fv1(String str) {
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
                Class<? extends nt1> cls = m.get(optString);
                if (cls != null) {
                    nt1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (rg1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<nt1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.ev1, com.repackage.xv1, com.repackage.gq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
