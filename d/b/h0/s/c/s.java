package d.b.h0.s.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public Hashtable<String, String> f51222a = new Hashtable<>();

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<String, String> f51223b = new Hashtable<>();

    public final void a(Hashtable hashtable, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
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

    public boolean b(int i, String str) {
        if (str == null) {
            return true;
        }
        String str2 = null;
        if (i == 1) {
            str2 = this.f51223b.get(str);
        } else if (i == 2) {
            str2 = this.f51222a.get(str);
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
            a(this.f51222a, optJSONArray);
            a(this.f51223b, optJSONArray2);
            BdLog.e("pay mPayCashierType:" + this.f51222a.toString());
            BdLog.e("pay mPayCashierType:" + this.f51223b.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
