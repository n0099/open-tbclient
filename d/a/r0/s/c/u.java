package d.a.r0.s.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Hashtable<String, String> f56449a;

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<String, String> f56450b;

    public u() {
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
        this.f56449a = new Hashtable<>();
        this.f56450b = new Hashtable<>();
    }

    public final void a(Hashtable hashtable, JSONArray jSONArray) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, hashtable, jSONArray) == null) || (length = jSONArray.length()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    hashtable.put(next, optJSONObject.get(next));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (str == null) {
                return true;
            }
            String str2 = null;
            if (i2 == 1) {
                str2 = this.f56450b.get(str);
            } else if (i2 == 2) {
                str2 = this.f56449a.get(str);
            }
            if (StringUtils.isNull(str2)) {
                return true;
            }
            return str2.equals("3");
        }
        return invokeIL.booleanValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("tdou_cashier_type");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("pay_cashier_type");
            BdLog.e("consumepath is:" + jSONObject.toString());
            a(this.f56449a, optJSONArray);
            a(this.f56450b, optJSONArray2);
            BdLog.e("pay mPayCashierType:" + this.f56449a.toString());
            BdLog.e("pay mPayCashierType:" + this.f56450b.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
