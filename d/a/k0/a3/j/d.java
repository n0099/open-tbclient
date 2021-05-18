package d.a.k0.a3.j;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f52017a;

    /* renamed from: b  reason: collision with root package name */
    public String f52018b;

    /* renamed from: c  reason: collision with root package name */
    public String f52019c;

    /* renamed from: d  reason: collision with root package name */
    public String f52020d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f52021e;

    public void a(JSONObject jSONObject) throws JSONException {
        this.f52017a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.f52018b = jSONObject.optString("menu_name");
        this.f52019c = jSONObject.optString("menu_id");
        String optString = jSONObject.optString("default_logo_url", null);
        this.f52020d = optString;
        this.f52020d = optString != null ? this.f52020d + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<d> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                d dVar = new d();
                dVar.a(optJSONArray.getJSONObject(i2));
                arrayList.add(dVar);
            }
            this.f52021e = arrayList;
        }
    }
}
