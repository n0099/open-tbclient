package d.b.i0.z2.j;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f63541a;

    /* renamed from: b  reason: collision with root package name */
    public String f63542b;

    /* renamed from: c  reason: collision with root package name */
    public String f63543c;

    /* renamed from: d  reason: collision with root package name */
    public String f63544d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f63545e;

    public void a(JSONObject jSONObject) throws JSONException {
        this.f63541a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.f63542b = jSONObject.optString("menu_name");
        this.f63543c = jSONObject.optString("menu_id");
        String optString = jSONObject.optString("default_logo_url", null);
        this.f63544d = optString;
        this.f63544d = optString != null ? this.f63544d + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<d> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(dVar);
            }
            this.f63545e = arrayList;
        }
    }
}
