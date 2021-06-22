package d.a.o0.b1.b.a;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.k0;
import d.a.n0.r.q.m;
import d.a.o0.b1.j.h.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BannerImage;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f55061a = true;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a2> f55062b;

    /* renamed from: c  reason: collision with root package name */
    public m f55063c;

    /* renamed from: d  reason: collision with root package name */
    public k0 f55064d;

    /* renamed from: e  reason: collision with root package name */
    public b f55065e;

    public m a() {
        return this.f55063c;
    }

    public k0 b() {
        return this.f55064d;
    }

    public b c() {
        return this.f55065e;
    }

    public ArrayList<a2> d() {
        return this.f55062b;
    }

    public boolean e() {
        return this.f55061a;
    }

    public void f(JSONObject jSONObject) {
        int i2;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                this.f55062b = new ArrayList<>(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (jSONObject2 != null) {
                        a2 a2Var = new a2();
                        a2Var.U2(jSONObject2);
                        a2Var.M1();
                        this.f55062b.add(a2Var);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_list");
            if (optJSONArray2 != null) {
                this.f55063c = new m();
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject != null) {
                        BannerImage.Builder builder = new BannerImage.Builder();
                        builder.ahead_url = optJSONObject.optString("ahead_url");
                        builder.img_url = optJSONObject.optString(BigdayActivityConfig.IMG_URL);
                        builder.title = optJSONObject.optString("title");
                        arrayList.add(builder.build(true));
                    }
                }
                this.f55063c.parserProtobuf(arrayList);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("grid");
            if (optJSONArray3 != null && optJSONArray3.length() >= 4) {
                this.f55064d = new k0();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i5);
                    if (optJSONObject2 != null) {
                        BannerImage.Builder builder2 = new BannerImage.Builder();
                        builder2.ahead_url = optJSONObject2.optString("ahead_url");
                        builder2.img_url = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                        builder2.title = optJSONObject2.optString("title");
                        arrayList2.add(builder2.build(true));
                    }
                }
                this.f55064d.parserProtobuf(arrayList2);
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("module_list");
            JSONArray jSONArray = null;
            int i6 = 0;
            while (true) {
                if (i6 >= optJSONArray4.length()) {
                    i2 = 0;
                    break;
                }
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i6);
                if ("hot_topic".equals(optJSONObject3.optString("type"))) {
                    jSONArray = optJSONObject3.optJSONArray("hot_topic");
                    i2 = optJSONObject3.optInt("position");
                    break;
                }
                i6++;
            }
            if (jSONArray == null || jSONArray.length() < 4) {
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                JSONObject optJSONObject4 = jSONArray.optJSONObject(i7);
                if (optJSONObject4 != null && i7 < 6) {
                    RecomTopicList.Builder builder3 = new RecomTopicList.Builder();
                    builder3.topic_id = Long.valueOf(d.a.c.e.m.b.f(optJSONObject4.optString("topic_id"), 0L));
                    builder3.topic_name = optJSONObject4.optString(IntentConfig.TOPIC_NAME);
                    builder3.topic_desc = optJSONObject4.optString("topic_desc");
                    builder3.tag = Integer.valueOf(optJSONObject4.optInt("tag"));
                    builder3.topic_pic = optJSONObject4.optString("topic_pic");
                    builder3.type = Integer.valueOf(optJSONObject4.optInt("type"));
                    builder3.discuss_num = Long.valueOf(d.a.c.e.m.b.f(optJSONObject4.optString("discuss_num"), 0L));
                    arrayList3.add(builder3.build(true));
                }
                b bVar = new b();
                this.f55065e = bVar;
                bVar.floorPosition = i2;
                bVar.parserProtobuf(arrayList3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
