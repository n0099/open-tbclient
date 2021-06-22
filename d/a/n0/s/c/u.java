package d.a.n0.s.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public Hashtable<String, String> f54308a = new Hashtable<>();

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<String, String> f54309b = new Hashtable<>();

    public final void a(Hashtable hashtable, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length > 0) {
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
    }

    public boolean b(int i2, String str) {
        if (str == null) {
            return true;
        }
        String str2 = null;
        if (i2 == 1) {
            str2 = this.f54309b.get(str);
        } else if (i2 == 2) {
            str2 = this.f54308a.get(str);
        }
        if (StringUtils.isNull(str2)) {
            return true;
        }
        return str2.equals("3");
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("tdou_cashier_type");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("pay_cashier_type");
            BdLog.e("consumepath is:" + jSONObject.toString());
            a(this.f54308a, optJSONArray);
            a(this.f54309b, optJSONArray2);
            BdLog.e("pay mPayCashierType:" + this.f54308a.toString());
            BdLog.e("pay mPayCashierType:" + this.f54309b.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
