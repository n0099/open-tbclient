package d.a.n0.r0.i1;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.w1;
import d.a.n0.e3.h0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo implements d.a.n0.k1.o.l.i, IVideoData {
    public static final BdUniqueId K = BdUniqueId.gen();
    public BaijiahaoData A;
    public w1 B;
    public long C;
    public WorksInfoData E;
    public boolean F;
    public int I;

    /* renamed from: e  reason: collision with root package name */
    public String f62380e;

    /* renamed from: f  reason: collision with root package name */
    public String f62381f;

    /* renamed from: g  reason: collision with root package name */
    public String f62382g;

    /* renamed from: h  reason: collision with root package name */
    public String f62383h;

    /* renamed from: i  reason: collision with root package name */
    public String f62384i;
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
        public long f62385a;

        /* renamed from: b  reason: collision with root package name */
        public long f62386b;

        /* renamed from: c  reason: collision with root package name */
        public String f62387c;

        /* renamed from: d  reason: collision with root package name */
        public String f62388d;

        /* renamed from: e  reason: collision with root package name */
        public String f62389e;

        /* renamed from: f  reason: collision with root package name */
        public String f62390f;

        public boolean a() {
            return (StringUtils.isNull(this.f62389e) || StringUtils.isNull(this.f62388d)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.f62385a);
            sb.append(",   ad_end_time = " + this.f62386b);
            sb.append(",   pic_url = " + this.f62387c);
            sb.append(",   card_title = " + this.f62389e);
            sb.append(",   button_title = " + this.f62390f);
            return sb.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f62391a;

        /* renamed from: b  reason: collision with root package name */
        public String f62392b;

        /* renamed from: c  reason: collision with root package name */
        public String f62393c;

        /* renamed from: d  reason: collision with root package name */
        public String f62394d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f62395e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f62396f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f62397g;

        /* renamed from: h  reason: collision with root package name */
        public a f62398h;

        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f62399a;

            /* renamed from: b  reason: collision with root package name */
            public String f62400b;

            /* renamed from: c  reason: collision with root package name */
            public String f62401c;

            /* renamed from: d  reason: collision with root package name */
            public String f62402d;

            /* renamed from: e  reason: collision with root package name */
            public Integer f62403e;

            /* renamed from: f  reason: collision with root package name */
            public String f62404f;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f62405a;

        /* renamed from: b  reason: collision with root package name */
        public String f62406b;

        /* renamed from: c  reason: collision with root package name */
        public String f62407c;

        /* renamed from: d  reason: collision with root package name */
        public String f62408d;

        /* renamed from: e  reason: collision with root package name */
        public int f62409e;

        /* renamed from: f  reason: collision with root package name */
        public String f62410f;

        /* renamed from: g  reason: collision with root package name */
        public String f62411g;

        /* renamed from: h  reason: collision with root package name */
        public long f62412h;

        /* renamed from: i  reason: collision with root package name */
        public String f62413i;
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

    public static a2 c(g gVar) {
        if (gVar == null) {
            return null;
        }
        a2 a2Var = new a2();
        a2Var.I3(gVar.f62381f);
        a2Var.A = gVar.f62381f;
        a2Var.r4(gVar.x);
        a2Var.n3(gVar.x);
        try {
            a2Var.d4((int) gVar.k);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        a2Var.i4(gVar.l);
        a2Var.v3(gVar.A);
        if (a2Var.L() != null && gVar.J != null) {
            a2Var.L().threadId = gVar.f62381f;
            a2Var.L().agreeType = gVar.o;
            a2Var.L().hasAgree = gVar.p;
            a2Var.L().agreeNum = gVar.m;
            a2Var.L().baijiahaoData = gVar.A;
        }
        a2Var.y3(d.a.c.e.m.b.f(gVar.f62380e, 0L));
        a2Var.p4(40);
        return a2Var;
    }

    public AgreeData g() {
        return this.J;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return K;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        c cVar = this.z;
        if (cVar != null) {
            return cVar.f62408d;
        }
        return null;
    }

    public String i() {
        return this.f62381f;
    }

    public int k() {
        BaijiahaoData baijiahaoData = this.A;
        if (baijiahaoData == null) {
            return 1;
        }
        int i2 = baijiahaoData.oriUgcType;
        if (i2 == 2) {
            return 3;
        }
        return i2 == 4 ? 2 : 1;
    }

    public boolean o() {
        c cVar = this.z;
        if (cVar == null) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(cVar.f62410f);
            return parseInt > 0 && ((float) Integer.parseInt(this.z.f62411g)) / ((float) parseInt) > 1.0f;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f62380e = jSONObject.optString("forum_id");
            this.f62381f = jSONObject.optString("thread_id");
            this.f62382g = jSONObject.optString("nid");
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
            this.J.threadId = this.f62381f;
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
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.v.add(jSONArray.optString(i2));
                }
            }
            this.w = new ArrayList();
            String optString2 = jSONObject.optString("forum_name_shared");
            if (!StringUtils.isNull(optString2)) {
                JSONArray jSONArray2 = new JSONArray(optString2);
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    this.w.add(jSONArray2.optString(i3));
                }
            }
            String optString3 = jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (!TextUtils.isEmpty(optString3)) {
                this.y = new b();
                JSONObject jSONObject2 = new JSONObject(optString3);
                this.y.f62391a = jSONObject2.optString("user_id");
                this.y.f62392b = jSONObject2.optString("user_name");
                this.y.f62393c = jSONObject2.optString("user_nickname");
                this.y.f62394d = jSONObject2.optString("portrait");
                this.y.f62395e = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                b bVar = this.y;
                if (jSONObject2.optInt("is_god") != 1) {
                    z = false;
                }
                bVar.f62396f = z;
                String optString4 = jSONObject2.optString("baijiahao_info");
                if (!TextUtils.isEmpty(optString4)) {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.y.f62398h = new b.a();
                    this.y.f62398h.f62399a = jSONObject3.optString("name");
                    this.y.f62398h.f62402d = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    this.y.f62398h.f62400b = jSONObject3.optString("avatar");
                    this.y.f62398h.f62401c = jSONObject3.optString("avatar_h");
                    this.y.f62398h.f62403e = Integer.valueOf(jSONObject3.optInt("auth_id"));
                    this.y.f62398h.f62404f = jSONObject3.optString("auth_desc");
                }
            }
            String optString5 = jSONObject.optString("video");
            if (!TextUtils.isEmpty(optString5)) {
                this.z = new c();
                JSONObject jSONObject4 = new JSONObject(optString5);
                this.z.f62405a = jSONObject4.optString("thumbnail_width");
                this.z.f62406b = jSONObject4.optString("thumbnail_height");
                this.z.f62407c = jSONObject4.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.z.f62408d = jSONObject4.optString("video_url");
                this.z.f62409e = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.z.f62410f = jSONObject4.optString("video_width");
                this.z.f62411g = jSONObject4.optString("video_height");
                this.z.f62412h = jSONObject4.optLong("video_size");
                this.z.f62413i = jSONObject4.optString("video_type");
                this.z.j = jSONObject4.optString("thumbnail_url");
                this.z.k = jSONObject4.optString("video_format");
                this.z.l = jSONObject4.optString("thumbnail_picid");
                this.z.m = jSONObject4.optString("origin_video_url");
                this.z.n = jSONObject4.optString("mcn_lead_page");
                String optString6 = jSONObject4.optString("video_desc");
                if (!TextUtils.isEmpty(optString6)) {
                    this.z.p = new ArrayList();
                    JSONArray jSONArray3 = new JSONArray(optString6);
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        d dVar = new d();
                        jSONArray3.optJSONObject(i4).optString("video_id");
                        jSONArray3.optJSONObject(i4).optString("video_url");
                        jSONArray3.optJSONObject(i4).optString("video_width");
                        jSONArray3.optJSONObject(i4).optString("video_height");
                        this.z.p.add(dVar);
                    }
                }
                JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.f62385a = optJSONObject.optLong("ad_start_time");
                    aVar.f62386b = optJSONObject.optLong("ad_end_time");
                    aVar.f62387c = optJSONObject.optString("pic_url");
                    aVar.f62388d = optJSONObject.optString("jump_url");
                    aVar.f62389e = optJSONObject.optString("card_title");
                    aVar.f62390f = optJSONObject.optString("button_title");
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
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    p pVar = new p();
                    pVar.a(optJSONArray.getJSONObject(i5));
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

    @Override // d.a.n0.k1.o.l.i
    public void setAutoPlay(boolean z) {
        this.F = z;
    }

    @Override // d.a.n0.k1.o.l.i
    public void setWaitConfirm(boolean z) {
    }
}
