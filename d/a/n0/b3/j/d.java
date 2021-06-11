package d.a.n0.b3.j;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f55873a;

    /* renamed from: b  reason: collision with root package name */
    public String f55874b;

    /* renamed from: c  reason: collision with root package name */
    public String f55875c;

    /* renamed from: d  reason: collision with root package name */
    public String f55876d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f55877e;

    public void a(JSONObject jSONObject) throws JSONException {
        this.f55873a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.f55874b = jSONObject.optString("menu_name");
        this.f55875c = jSONObject.optString("menu_id");
        String optString = jSONObject.optString("default_logo_url", null);
        this.f55876d = optString;
        this.f55876d = optString != null ? this.f55876d + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<d> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                d dVar = new d();
                dVar.a(optJSONArray.getJSONObject(i2));
                arrayList.add(dVar);
            }
            this.f55877e = arrayList;
        }
    }
}
