package d.a.k0.g1;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.k0.s2.x;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public ForumData f55148a;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f55150c;

    /* renamed from: e  reason: collision with root package name */
    public String f55152e;

    /* renamed from: f  reason: collision with root package name */
    public String f55153f;

    /* renamed from: h  reason: collision with root package name */
    public int f55155h;

    /* renamed from: i  reason: collision with root package name */
    public String f55156i;
    public String j;
    public MetaData k;
    public int l;
    public int m;

    /* renamed from: b  reason: collision with root package name */
    public int f55149b = 0;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f55151d = null;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<AlaInfoData> f55154g = new LinkedList<>();

    public g() {
        this.f55150c = null;
        this.f55150c = new LinkedList<>();
    }

    public AdvertAppInfo a() {
        return this.f55151d;
    }

    public final void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("app");
        if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return;
        }
        App.Builder builder = new App.Builder();
        builder.id = optJSONObject.optString("id");
        builder.type = Integer.valueOf(optJSONObject.optInt("type", 0));
        builder.pos = Integer.valueOf(optJSONObject.optInt(IAdRequestParam.POS, 0));
        builder.icon_url = optJSONObject.optString("icon_url");
        builder.icon_link = optJSONObject.optString("icon_link");
        builder.app_name = optJSONObject.optString("app_name");
        builder.app_desc = optJSONObject.optString("app_desc");
        builder.p_name = optJSONObject.optString("p_name");
        builder.p_url = optJSONObject.optString("p_url");
        builder.img_url = optJSONObject.optString(BigdayActivityConfig.IMG_URL);
        builder.app_time = Integer.valueOf(optJSONObject.optInt("app_time", 0));
        builder.web_url = optJSONObject.optString("web_url");
        builder.ad_id = optJSONObject.optString(LegoListActivityConfig.AD_ID);
        builder.id = optJSONObject.optString("id");
        builder.name = optJSONObject.optString("name");
        builder.url_type = Integer.valueOf(optJSONObject.optInt("url_type", 0));
        builder.url = optJSONObject.optString("url");
        builder.ios_url = optJSONObject.optString("ios_url");
        builder.apk_url = optJSONObject.optString("apk_url");
        builder.apk_name = optJSONObject.optString("apk_name");
        builder.pos_name = optJSONObject.optString("pos_name");
        builder.first_name = optJSONObject.optString("first_name");
        builder.second_name = optJSONObject.optString("second_name");
        builder.cpid = Integer.valueOf(optJSONObject.optInt("cpid", 0));
        builder.abtest = optJSONObject.optString("abtest");
        builder.plan_id = Integer.valueOf(optJSONObject.optInt("plan_id", 0));
        builder.user_id = optJSONObject.optString("user_id");
        builder.price = optJSONObject.optString("price");
        builder.verify = optJSONObject.optString(SmsLoginView.f.j);
        builder.ext_info = optJSONObject.optString("ext_info");
        builder.pos_name = optJSONObject.optString("pos_name");
        GoodsInfo c2 = c(optJSONObject);
        if (c2 != null) {
            ArrayList arrayList = new ArrayList();
            builder.goods_info = arrayList;
            arrayList.add(c2);
        }
        builder.loc_code = optJSONObject.optString("loc_code");
        App build = builder.build(true);
        this.f55151d = new AdvertAppInfo();
        App c3 = x.p().c(build, Cmatch.PIC_PAGE);
        if (c3 != null) {
            this.f55151d.K3 = true;
            build = c3;
        }
        this.f55151d.I4(build);
        this.f55151d.L3 = "c0111";
    }

    public final GoodsInfo c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("goods_info");
        if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        GoodsInfo.Builder builder = new GoodsInfo.Builder();
        builder.id = Integer.valueOf(optJSONObject.optInt("id", 0));
        builder.user_name = optJSONObject.optString("user_name");
        builder.user_portrait = optJSONObject.optString("user_portrait");
        builder.thread_title = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
        builder.thread_pic = optJSONObject.optString("thread_pic");
        builder.pop_window_text = optJSONObject.optString("pop_window_text");
        builder.goods_style = Integer.valueOf(optJSONObject.optInt("goods_style", 0));
        builder.label_visible = Integer.valueOf(optJSONObject.optInt("label_visible", 0));
        builder.label_text = optJSONObject.optString("label_text");
        builder.rank_level = Integer.valueOf(optJSONObject.optInt("rank_level", 0));
        builder.thread_type = optJSONObject.optString("thread_type");
        builder.button_text = optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        builder.card_desc = optJSONObject.optString("card_desc");
        builder.card_tag = optJSONObject.optString("card_tag");
        builder.tag_name = optJSONObject.optString("tag_name");
        builder.ad_source = optJSONObject.optString("ad_source");
        builder.tag_name_url = optJSONObject.optString("tag_name_url");
        builder.tag_name_wh = optJSONObject.optString("tag_name_wh");
        builder.lego_card = optJSONObject.optString("lego_card");
        return builder.build(true);
    }

    public LinkedList<AlaInfoData> d() {
        return this.f55154g;
    }

    public String e() {
        return this.f55152e;
    }

    public ForumData f() {
        return this.f55148a;
    }

    public LinkedList<e> g() {
        return this.f55150c;
    }

    public int h() {
        return this.f55149b;
    }

    public int i() {
        return this.f55155h;
    }

    public String j() {
        return this.f55153f;
    }

    public final void k(JSONObject jSONObject, boolean z) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("recom_ala_info")) == null) {
            return;
        }
        if (z) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.parserJson(optJSONArray.optJSONObject(i2));
                this.f55154g.addLast(alaInfoData);
            }
            return;
        }
        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
            AlaInfoData alaInfoData2 = new AlaInfoData();
            alaInfoData2.parserJson(optJSONArray.optJSONObject(length));
            this.f55154g.addFirst(alaInfoData2);
        }
    }

    public void l(String str, boolean z) {
        try {
            m(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void m(JSONObject jSONObject, Boolean bool) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            if (optJSONObject != null) {
                ForumData forumData = new ForumData();
                this.f55148a = forumData;
                forumData.parserJson(optJSONObject);
                optJSONObject.optString("id");
                this.f55152e = optJSONObject.optString("frist_class");
                this.f55153f = optJSONObject.optString("second_class");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("thread");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
                if (optJSONObject3 != null) {
                    MetaData metaData = new MetaData();
                    this.k = metaData;
                    metaData.setUserId(optJSONObject3.optString("user_id"));
                    this.k.setUserName(optJSONObject3.optString("user_name"));
                    this.k.setName_show(optJSONObject3.optString("nickname"));
                }
                this.j = optJSONObject2.optString("first_post_id");
                this.l = optJSONObject2.optInt("is_multiforum_thread");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
            if (optJSONObject4 != null) {
                this.f55155h = optJSONObject4.optInt("reply_private_flag");
                this.f55156i = optJSONObject4.optString("voice_message");
            }
            this.m = jSONObject.optInt("show_adsense", 0);
            this.f55149b = jSONObject.optInt("pic_amount", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
            if (optJSONArray != null) {
                if (bool.booleanValue()) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        e eVar = new e();
                        eVar.w(optJSONArray.optJSONObject(i2));
                        int h2 = eVar.h();
                        if (h2 >= 1 && h2 <= this.f55149b) {
                            this.f55150c.addLast(eVar);
                        }
                    }
                } else {
                    for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                        e eVar2 = new e();
                        eVar2.w(optJSONArray.getJSONObject(length));
                        int h3 = eVar2.h();
                        if (h3 >= 1 && h3 <= this.f55149b) {
                            this.f55150c.addFirst(eVar2);
                        }
                    }
                }
            }
            k(jSONObject, bool.booleanValue());
            b(jSONObject);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
