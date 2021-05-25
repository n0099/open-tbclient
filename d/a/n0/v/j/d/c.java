package d.a.n0.v.j.d;

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
    public r f62059h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62057f = false;

    /* renamed from: a  reason: collision with root package name */
    public AlaUserInfoData f62052a = new AlaUserInfoData();

    /* renamed from: b  reason: collision with root package name */
    public i f62053b = new i();

    /* renamed from: c  reason: collision with root package name */
    public q f62054c = new q();

    /* renamed from: g  reason: collision with root package name */
    public final a f62058g = new a();

    /* renamed from: d  reason: collision with root package name */
    public List<AlaLiveInfoData> f62055d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<p> f62056e = new ArrayList();

    public a a() {
        return this.f62058g;
    }

    public AlaUserInfoData b() {
        return this.f62052a;
    }

    public boolean c() {
        return this.f62057f;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.f62052a = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject, AlaUserInfoData.class);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("watch_list");
            for (int i2 = 0; optJSONArray != null && i2 < optJSONArray.length(); i2++) {
                p pVar = new p();
                pVar.a(optJSONArray.getJSONObject(i2));
                this.f62056e.add(pVar);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
            for (int i3 = 0; optJSONArray2 != null && optJSONArray2.length() < i3; i3++) {
                AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i3));
                this.f62055d.add(alaLiveInfoData);
            }
            this.f62053b.a(jSONObject2.optJSONObject(VodClient.PATH_MEDIA));
            this.f62054c.parserJson(jSONObject2.optJSONObject("privacy_set"));
            this.f62058g.parserJson(jSONObject2.optJSONObject("authority_info"));
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
            if (optJSONObject2 != null) {
                r rVar = new r();
                this.f62059h = rVar;
                rVar.a(optJSONObject2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(boolean z) {
        this.f62057f = z;
    }
}
