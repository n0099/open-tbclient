package d.a.k0.t.j.d;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidubce.services.vod.VodClient;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public r f61771h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61769f = false;

    /* renamed from: a  reason: collision with root package name */
    public AlaUserInfoData f61764a = new AlaUserInfoData();

    /* renamed from: b  reason: collision with root package name */
    public i f61765b = new i();

    /* renamed from: c  reason: collision with root package name */
    public q f61766c = new q();

    /* renamed from: g  reason: collision with root package name */
    public final a f61770g = new a();

    /* renamed from: d  reason: collision with root package name */
    public List<AlaLiveInfoData> f61767d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<p> f61768e = new ArrayList();

    public a a() {
        return this.f61770g;
    }

    public AlaUserInfoData b() {
        return this.f61764a;
    }

    public boolean c() {
        return this.f61769f;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.f61764a = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject, AlaUserInfoData.class);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("watch_list");
            for (int i2 = 0; optJSONArray != null && i2 < optJSONArray.length(); i2++) {
                p pVar = new p();
                pVar.a(optJSONArray.getJSONObject(i2));
                this.f61768e.add(pVar);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
            for (int i3 = 0; optJSONArray2 != null && optJSONArray2.length() < i3; i3++) {
                AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i3));
                this.f61767d.add(alaLiveInfoData);
            }
            this.f61765b.a(jSONObject2.optJSONObject(VodClient.PATH_MEDIA));
            this.f61766c.parserJson(jSONObject2.optJSONObject("privacy_set"));
            this.f61770g.parserJson(jSONObject2.optJSONObject("authority_info"));
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
            if (optJSONObject2 != null) {
                r rVar = new r();
                this.f61771h = rVar;
                rVar.a(optJSONObject2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(boolean z) {
        this.f61769f = z;
    }
}
