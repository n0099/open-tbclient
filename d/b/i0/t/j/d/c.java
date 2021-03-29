package d.b.i0.t.j.d;

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
    public r f60863h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60861f = false;

    /* renamed from: a  reason: collision with root package name */
    public AlaUserInfoData f60856a = new AlaUserInfoData();

    /* renamed from: b  reason: collision with root package name */
    public i f60857b = new i();

    /* renamed from: c  reason: collision with root package name */
    public q f60858c = new q();

    /* renamed from: g  reason: collision with root package name */
    public final a f60862g = new a();

    /* renamed from: d  reason: collision with root package name */
    public List<AlaLiveInfoData> f60859d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<p> f60860e = new ArrayList();

    public a a() {
        return this.f60862g;
    }

    public AlaUserInfoData b() {
        return this.f60856a;
    }

    public boolean c() {
        return this.f60861f;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.f60856a = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject, AlaUserInfoData.class);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("watch_list");
            for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                p pVar = new p();
                pVar.a(optJSONArray.getJSONObject(i));
                this.f60860e.add(pVar);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
            for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                this.f60859d.add(alaLiveInfoData);
            }
            this.f60857b.a(jSONObject2.optJSONObject(VodClient.PATH_MEDIA));
            this.f60858c.parserJson(jSONObject2.optJSONObject("privacy_set"));
            this.f60862g.parserJson(jSONObject2.optJSONObject("authority_info"));
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
            if (optJSONObject2 != null) {
                r rVar = new r();
                this.f60863h = rVar;
                rVar.a(optJSONObject2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(boolean z) {
        this.f60861f = z;
    }
}
