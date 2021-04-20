package d.b.i0.a3.j;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f53161a;

    /* renamed from: b  reason: collision with root package name */
    public String f53162b;

    /* renamed from: c  reason: collision with root package name */
    public String f53163c;

    /* renamed from: d  reason: collision with root package name */
    public String f53164d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f53165e;

    public void a(JSONObject jSONObject) throws JSONException {
        this.f53161a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.f53162b = jSONObject.optString("menu_name");
        this.f53163c = jSONObject.optString("menu_id");
        String optString = jSONObject.optString("default_logo_url", null);
        this.f53164d = optString;
        this.f53164d = optString != null ? this.f53164d + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<d> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(dVar);
            }
            this.f53165e = arrayList;
        }
    }
}
