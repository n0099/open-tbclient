package d.a.j0.g1;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.recapp.activity.AdDebugActivity;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.j0.s2.w;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public ForumData f54442b;

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<e> f54444d;

    /* renamed from: f  reason: collision with root package name */
    public String f54446f;

    /* renamed from: g  reason: collision with root package name */
    public String f54447g;

    /* renamed from: i  reason: collision with root package name */
    public int f54449i;
    public String j;
    public String k;
    public MetaData l;
    public int m;
    public int n;

    /* renamed from: a  reason: collision with root package name */
    public String f54441a = null;

    /* renamed from: c  reason: collision with root package name */
    public int f54443c = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f54445e = null;

    /* renamed from: h  reason: collision with root package name */
    public LinkedList<AlaInfoData> f54448h = new LinkedList<>();

    public g() {
        this.f54444d = null;
        this.f54444d = new LinkedList<>();
    }

    public AdvertAppInfo a() {
        return this.f54445e;
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
        builder.app_name = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
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
        this.f54445e = new AdvertAppInfo();
        App c3 = w.p().c(build, Cmatch.PIC_PAGE);
        if (c3 != null) {
            this.f54445e.g4 = true;
            build = c3;
        }
        this.f54445e.H4(build);
        AdvertAppInfo advertAppInfo = this.f54445e;
        advertAppInfo.K3 = "c0111";
        advertAppInfo.b4 = this.f54441a;
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
        builder.button_text = optJSONObject.optString("button_text");
        builder.card_desc = optJSONObject.optString("card_desc");
        builder.card_tag = optJSONObject.optString("card_tag");
        builder.tag_name = optJSONObject.optString("tag_name");
        builder.ad_source = optJSONObject.optString("ad_source");
        builder.tag_name_url = optJSONObject.optString("tag_name_url");
        builder.tag_name_wh = optJSONObject.optString("tag_name_wh");
        builder.lego_card = optJSONObject.optString(AdDebugActivity.KEY_LEGO);
        return builder.build(true);
    }

    public LinkedList<AlaInfoData> d() {
        return this.f54448h;
    }

    public String e() {
        return this.f54446f;
    }

    public ForumData f() {
        return this.f54442b;
    }

    public LinkedList<e> g() {
        return this.f54444d;
    }

    public int h() {
        return this.f54443c;
    }

    public int i() {
        return this.f54449i;
    }

    public String j() {
        return this.f54447g;
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
                this.f54448h.addLast(alaInfoData);
            }
            return;
        }
        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
            AlaInfoData alaInfoData2 = new AlaInfoData();
            alaInfoData2.parserJson(optJSONArray.optJSONObject(length));
            this.f54448h.addFirst(alaInfoData2);
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
                this.f54442b = forumData;
                forumData.parserJson(optJSONObject);
                this.f54441a = optJSONObject.optString("id");
                this.f54446f = optJSONObject.optString("frist_class");
                this.f54447g = optJSONObject.optString("second_class");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("thread");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
                if (optJSONObject3 != null) {
                    MetaData metaData = new MetaData();
                    this.l = metaData;
                    metaData.setUserId(optJSONObject3.optString("user_id"));
                    this.l.setUserName(optJSONObject3.optString("user_name"));
                    this.l.setName_show(optJSONObject3.optString("nickname"));
                }
                this.k = optJSONObject2.optString("first_post_id");
                this.m = optJSONObject2.optInt("is_multiforum_thread");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
            if (optJSONObject4 != null) {
                this.f54449i = optJSONObject4.optInt("reply_private_flag");
                this.j = optJSONObject4.optString("voice_message");
            }
            this.n = jSONObject.optInt("show_adsense", 0);
            this.f54443c = jSONObject.optInt("pic_amount", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
            if (optJSONArray != null) {
                if (bool.booleanValue()) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        e eVar = new e();
                        eVar.w(optJSONArray.optJSONObject(i2));
                        int h2 = eVar.h();
                        if (h2 >= 1 && h2 <= this.f54443c) {
                            this.f54444d.addLast(eVar);
                        }
                    }
                } else {
                    for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                        e eVar2 = new e();
                        eVar2.w(optJSONArray.getJSONObject(length));
                        int h3 = eVar2.h();
                        if (h3 >= 1 && h3 <= this.f54443c) {
                            this.f54444d.addFirst(eVar2);
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
