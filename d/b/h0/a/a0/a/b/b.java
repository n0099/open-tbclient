package d.b.h0.a.a0.a.b;

import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.a0.a.d.b {
    public String x;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.x = "";
    }

    @Override // d.b.h0.a.a0.a.d.b, d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString(UserAccountActionItem.KEY_SRC);
    }
}
