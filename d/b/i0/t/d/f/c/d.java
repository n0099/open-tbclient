package d.b.i0.t.d.f.c;

import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public UserData f62100a = new UserData();

    /* renamed from: b  reason: collision with root package name */
    public AlaInfoData f62101b = new AlaInfoData();

    public void a(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f62100a.parserJson(jSONObject);
        this.f62101b.parserJson(jSONObject2);
    }
}
