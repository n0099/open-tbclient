package d.a.n0.f3.b;

import android.text.TextUtils;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f54877a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f54878b;

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("splash_schedule")) == null) {
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
        if (optJSONArray != null) {
            this.f54877a = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                b bVar = new b();
                bVar.d(optJSONArray.optJSONObject(i2));
                this.f54877a.add(bVar);
            }
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
        if (optJSONArray != null) {
            this.f54878b = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                b bVar2 = new b();
                bVar2.d(optJSONArray2.optJSONObject(i3));
                this.f54878b.add(bVar2);
            }
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject != null) {
            a(jSONObject);
        }
    }
}
