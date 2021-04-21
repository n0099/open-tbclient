package d.b.j0.t.j.d;

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
    public r f62848h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62846f = false;

    /* renamed from: a  reason: collision with root package name */
    public AlaUserInfoData f62841a = new AlaUserInfoData();

    /* renamed from: b  reason: collision with root package name */
    public i f62842b = new i();

    /* renamed from: c  reason: collision with root package name */
    public q f62843c = new q();

    /* renamed from: g  reason: collision with root package name */
    public final a f62847g = new a();

    /* renamed from: d  reason: collision with root package name */
    public List<AlaLiveInfoData> f62844d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<p> f62845e = new ArrayList();

    public a a() {
        return this.f62847g;
    }

    public AlaUserInfoData b() {
        return this.f62841a;
    }

    public boolean c() {
        return this.f62846f;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.f62841a = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject, AlaUserInfoData.class);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("watch_list");
            for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                p pVar = new p();
                pVar.a(optJSONArray.getJSONObject(i));
                this.f62845e.add(pVar);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
            for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                this.f62844d.add(alaLiveInfoData);
            }
            this.f62842b.a(jSONObject2.optJSONObject(VodClient.PATH_MEDIA));
            this.f62843c.parserJson(jSONObject2.optJSONObject("privacy_set"));
            this.f62847g.parserJson(jSONObject2.optJSONObject("authority_info"));
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
            if (optJSONObject2 != null) {
                r rVar = new r();
                this.f62848h = rVar;
                rVar.a(optJSONObject2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(boolean z) {
        this.f62846f = z;
    }
}
