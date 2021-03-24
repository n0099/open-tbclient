package d.b.i0.p0.i1;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w1;
import d.b.i0.c3.h0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo implements d.b.i0.i1.o.l.i, IVideoData {
    public static final BdUniqueId K = BdUniqueId.gen();
    public BaijiahaoData A;
    public w1 B;
    public long C;
    public WorksInfoData E;
    public boolean F;
    public int I;

    /* renamed from: e  reason: collision with root package name */
    public String f57618e;

    /* renamed from: f  reason: collision with root package name */
    public String f57619f;

    /* renamed from: g  reason: collision with root package name */
    public String f57620g;

    /* renamed from: h  reason: collision with root package name */
    public String f57621h;
    public String i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public List<String> v;
    public List<String> w;
    public String x;
    public b y;
    public c z;
    public List<p> D = new ArrayList();
    public boolean G = true;
    public boolean H = false;
    public AgreeData J = new AgreeData();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f57622a;

        /* renamed from: b  reason: collision with root package name */
        public long f57623b;

        /* renamed from: c  reason: collision with root package name */
        public String f57624c;

        /* renamed from: d  reason: collision with root package name */
        public String f57625d;

        /* renamed from: e  reason: collision with root package name */
        public String f57626e;

        /* renamed from: f  reason: collision with root package name */
        public String f57627f;

        public boolean a() {
            return (StringUtils.isNull(this.f57626e) || StringUtils.isNull(this.f57625d)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.f57622a);
            sb.append(",   ad_end_time = " + this.f57623b);
            sb.append(",   pic_url = " + this.f57624c);
            sb.append(",   card_title = " + this.f57626e);
            sb.append(",   button_title = " + this.f57627f);
            return sb.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f57628a;

        /* renamed from: b  reason: collision with root package name */
        public String f57629b;

        /* renamed from: c  reason: collision with root package name */
        public String f57630c;

        /* renamed from: d  reason: collision with root package name */
        public String f57631d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f57632e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57633f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f57634g;

        /* renamed from: h  reason: collision with root package name */
        public a f57635h;

        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f57636a;

            /* renamed from: b  reason: collision with root package name */
            public String f57637b;

            /* renamed from: c  reason: collision with root package name */
            public String f57638c;

            /* renamed from: d  reason: collision with root package name */
            public String f57639d;

            /* renamed from: e  reason: collision with root package name */
            public Integer f57640e;

            /* renamed from: f  reason: collision with root package name */
            public String f57641f;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f57642a;

        /* renamed from: b  reason: collision with root package name */
        public String f57643b;

        /* renamed from: c  reason: collision with root package name */
        public String f57644c;

        /* renamed from: d  reason: collision with root package name */
        public String f57645d;

        /* renamed from: e  reason: collision with root package name */
        public int f57646e;

        /* renamed from: f  reason: collision with root package name */
        public String f57647f;

        /* renamed from: g  reason: collision with root package name */
        public String f57648g;

        /* renamed from: h  reason: collision with root package name */
        public long f57649h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public a o;
        public List<d> p;
    }

    /* loaded from: classes4.dex */
    public static class d {
    }

    public static a2 g(g gVar) {
        if (gVar == null) {
            return null;
        }
        a2 a2Var = new a2();
        a2Var.D3(gVar.f57619f);
        a2Var.A = gVar.f57619f;
        a2Var.m4(gVar.x);
        a2Var.h3(gVar.x);
        try {
            a2Var.Y3((int) gVar.k);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        a2Var.d4(gVar.l);
        a2Var.q3(gVar.A);
        if (a2Var.L() != null && gVar.J != null) {
            a2Var.L().threadId = gVar.f57619f;
            a2Var.L().agreeType = gVar.o;
            a2Var.L().hasAgree = gVar.p;
            a2Var.L().agreeNum = gVar.m;
            a2Var.L().baijiahaoData = gVar.A;
        }
        a2Var.t3(d.b.b.e.m.b.f(gVar.f57618e, 0L));
        a2Var.k4(40);
        return a2Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return K;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        c cVar = this.z;
        if (cVar != null) {
            return cVar.f57645d;
        }
        return null;
    }

    public AgreeData j() {
        return this.J;
    }

    public String n() {
        return this.f57619f;
    }

    public int o() {
        BaijiahaoData baijiahaoData = this.A;
        if (baijiahaoData == null) {
            return 1;
        }
        int i = baijiahaoData.oriUgcType;
        if (i == 2) {
            return 3;
        }
        return i == 4 ? 2 : 1;
    }

    public boolean s() {
        c cVar = this.z;
        if (cVar == null) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(cVar.f57647f);
            return parseInt > 0 && ((float) Integer.parseInt(this.z.f57648g)) / ((float) parseInt) > 1.0f;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    @Override // d.b.i0.i1.o.l.i
    public void setAutoPlay(boolean z) {
        this.F = z;
    }

    @Override // d.b.i0.i1.o.l.i
    public void setWaitConfirm(boolean z) {
    }

    public void t(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f57618e = jSONObject.optString("forum_id");
            this.f57619f = jSONObject.optString("thread_id");
            this.f57620g = jSONObject.optString("nid");
            jSONObject.optString("first_post_id");
            jSONObject.optString("create_time");
            this.j = jSONObject.optLong("play_count");
            this.x = jSONObject.optString("title");
            this.k = jSONObject.optLong("post_num");
            this.l = jSONObject.optLong("share_num");
            this.m = jSONObject.optLong("agree_num");
            this.n = jSONObject.optLong("disagree_num");
            this.o = jSONObject.optInt("agree_type");
            boolean z = true;
            this.p = jSONObject.optInt("has_agree") == 1;
            if (this.m < 0) {
                this.m = 0L;
            }
            if (this.n < 0) {
                this.n = 0L;
            }
            this.J.threadId = this.f57619f;
            this.J.agreeType = this.o;
            this.J.hasAgree = this.p;
            this.J.agreeNum = this.m;
            this.J.disAgreeNum = this.n;
            this.J.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
            this.q = jSONObject.optString("source");
            this.s = jSONObject.optString("extra");
            this.t = jSONObject.optString("abtest_tag");
            this.r = jSONObject.optString("weight");
            this.v = new ArrayList();
            String optString = jSONObject.optString("forum_id_shared");
            if (!StringUtils.isNull(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.v.add(jSONArray.optString(i));
                }
            }
            this.w = new ArrayList();
            String optString2 = jSONObject.optString("forum_name_shared");
            if (!StringUtils.isNull(optString2)) {
                JSONArray jSONArray2 = new JSONArray(optString2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.w.add(jSONArray2.optString(i2));
                }
            }
            String optString3 = jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (!TextUtils.isEmpty(optString3)) {
                this.y = new b();
                JSONObject jSONObject2 = new JSONObject(optString3);
                this.y.f57628a = jSONObject2.optString("user_id");
                this.y.f57629b = jSONObject2.optString("user_name");
                this.y.f57630c = jSONObject2.optString("user_nickname");
                this.y.f57631d = jSONObject2.optString("portrait");
                this.y.f57632e = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                b bVar = this.y;
                if (jSONObject2.optInt("is_god") != 1) {
                    z = false;
                }
                bVar.f57633f = z;
                String optString4 = jSONObject2.optString("baijiahao_info");
                if (!TextUtils.isEmpty(optString4)) {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.y.f57635h = new b.a();
                    this.y.f57635h.f57636a = jSONObject3.optString("name");
                    this.y.f57635h.f57639d = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    this.y.f57635h.f57637b = jSONObject3.optString("avatar");
                    this.y.f57635h.f57638c = jSONObject3.optString("avatar_h");
                    this.y.f57635h.f57640e = Integer.valueOf(jSONObject3.optInt("auth_id"));
                    this.y.f57635h.f57641f = jSONObject3.optString("auth_desc");
                }
            }
            String optString5 = jSONObject.optString("video");
            if (!TextUtils.isEmpty(optString5)) {
                this.z = new c();
                JSONObject jSONObject4 = new JSONObject(optString5);
                this.z.f57642a = jSONObject4.optString("thumbnail_width");
                this.z.f57643b = jSONObject4.optString("thumbnail_height");
                this.z.f57644c = jSONObject4.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.z.f57645d = jSONObject4.optString("video_url");
                this.z.f57646e = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.z.f57647f = jSONObject4.optString("video_width");
                this.z.f57648g = jSONObject4.optString("video_height");
                this.z.f57649h = jSONObject4.optLong("video_size");
                this.z.i = jSONObject4.optString("video_type");
                this.z.j = jSONObject4.optString("thumbnail_url");
                this.z.k = jSONObject4.optString("video_format");
                this.z.l = jSONObject4.optString("thumbnail_picid");
                this.z.m = jSONObject4.optString("origin_video_url");
                this.z.n = jSONObject4.optString("mcn_lead_page");
                String optString6 = jSONObject4.optString("video_desc");
                if (!TextUtils.isEmpty(optString6)) {
                    this.z.p = new ArrayList();
                    JSONArray jSONArray3 = new JSONArray(optString6);
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        d dVar = new d();
                        jSONArray3.optJSONObject(i3).optString("video_id");
                        jSONArray3.optJSONObject(i3).optString("video_url");
                        jSONArray3.optJSONObject(i3).optString("video_width");
                        jSONArray3.optJSONObject(i3).optString("video_height");
                        this.z.p.add(dVar);
                    }
                }
                JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.f57622a = optJSONObject.optLong("ad_start_time");
                    aVar.f57623b = optJSONObject.optLong("ad_end_time");
                    aVar.f57624c = optJSONObject.optString("pic_url");
                    aVar.f57625d = optJSONObject.optString("jump_url");
                    aVar.f57626e = optJSONObject.optString("card_title");
                    aVar.f57627f = optJSONObject.optString("button_title");
                    optJSONObject.optLong("effect_time");
                    optJSONObject.optLong("expire_time");
                    this.z.o = aVar;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject2 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.A = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("forum_info");
            if (optJSONObject3 != null) {
                w1 w1Var = new w1();
                this.B = w1Var;
                w1Var.d(optJSONObject3);
            }
            this.C = jSONObject.optLong("last_time_int");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                this.D = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    p pVar = new p();
                    pVar.a(optJSONArray.getJSONObject(i4));
                    this.D.add(pVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("works_info");
            if (optJSONObject4 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                this.E = worksInfoData;
                worksInfoData.parseJson(optJSONObject4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
