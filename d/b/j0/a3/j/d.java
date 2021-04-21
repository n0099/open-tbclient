package d.b.j0.a3.j;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f53582a;

    /* renamed from: b  reason: collision with root package name */
    public String f53583b;

    /* renamed from: c  reason: collision with root package name */
    public String f53584c;

    /* renamed from: d  reason: collision with root package name */
    public String f53585d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f53586e;

    public void a(JSONObject jSONObject) throws JSONException {
        this.f53582a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.f53583b = jSONObject.optString("menu_name");
        this.f53584c = jSONObject.optString("menu_id");
        String optString = jSONObject.optString("default_logo_url", null);
        this.f53585d = optString;
        this.f53585d = optString != null ? this.f53585d + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<d> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(dVar);
            }
            this.f53586e = arrayList;
        }
    }
}
