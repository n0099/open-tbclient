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
    public String f58689e;

    /* renamed from: f  reason: collision with root package name */
    public String f58690f;

    /* renamed from: g  reason: collision with root package name */
    public String f58691g;

    /* renamed from: h  reason: collision with root package name */
    public String f58692h;

    /* renamed from: i  reason: collision with root package name */
    public String f58693i;
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
        public long f58694a;

        /* renamed from: b  reason: collision with root package name */
        public long f58695b;

        /* renamed from: c  reason: collision with root package name */
        public String f58696c;

        /* renamed from: d  reason: collision with root package name */
        public String f58697d;

        /* renamed from: e  reason: collision with root package name */
        public String f58698e;

        /* renamed from: f  reason: collision with root package name */
        public String f58699f;

        public boolean a() {
            return (StringUtils.isNull(this.f58698e) || StringUtils.isNull(this.f58697d)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.f58694a);
            sb.append(",   ad_end_time = " + this.f58695b);
            sb.append(",   pic_url = " + this.f58696c);
            sb.append(",   card_title = " + this.f58698e);
            sb.append(",   button_title = " + this.f58699f);
            return sb.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f58700a;

        /* renamed from: b  reason: collision with root package name */
        public String f58701b;

        /* renamed from: c  reason: collision with root package name */
        public String f58702c;

        /* renamed from: d  reason: collision with root package name */
        public String f58703d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f58704e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f58705f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f58706g;

        /* renamed from: h  reason: collision with root package name */
        public a f58707h;

        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f58708a;

            /* renamed from: b  reason: collision with root package name */
            public String f58709b;

            /* renamed from: c  reason: collision with root package name */
            public String f58710c;

            /* renamed from: d  reason: collision with root package name */
            public String f58711d;

            /* renamed from: e  reason: collision with root package name */
            public Integer f58712e;

            /* renamed from: f  reason: collision with root package name */
            public String f58713f;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f58714a;

        /* renamed from: b  reason: collision with root package name */
        public String f58715b;

        /* renamed from: c  reason: collision with root package name */
        public String f58716c;

        /* renamed from: d  reason: collision with root package name */
        public String f58717d;

        /* renamed from: e  reason: collision with root package name */
        public int f58718e;

        /* renamed from: f  reason: collision with root package name */
        public String f58719f;

        /* renamed from: g  reason: collision with root package name */
        public String f58720g;

        /* renamed from: h  reason: collision with root package name */
        public long f58721h;

        /* renamed from: i  reason: collision with root package name */
        public String f58722i;
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

    public static a2 h(g gVar) {
        if (gVar == null) {
            return null;
        }
        a2 a2Var = new a2();
        a2Var.H3(gVar.f58690f);
        a2Var.A = gVar.f58690f;
        a2Var.q4(gVar.x);
        a2Var.m3(gVar.x);
        try {
            a2Var.c4((int) gVar.k);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        a2Var.h4(gVar.l);
        a2Var.u3(gVar.A);
        if (a2Var.L() != null && gVar.J != null) {
            a2Var.L().threadId = gVar.f58690f;
            a2Var.L().agreeType = gVar.o;
            a2Var.L().hasAgree = gVar.p;
            a2Var.L().agreeNum = gVar.m;
            a2Var.L().baijiahaoData = gVar.A;
        }
        a2Var.x3(d.a.c.e.m.b.f(gVar.f58689e, 0L));
        a2Var.o4(40);
        return a2Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return K;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        c cVar = this.z;
        if (cVar != null) {
            return cVar.f58717d;
        }
        return null;
    }

    public AgreeData l() {
        return this.J;
    }

    public String m() {
        return this.f58690f;
    }

    public int p() {
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

    public boolean s() {
        c cVar = this.z;
        if (cVar == null) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(cVar.f58719f);
            return parseInt > 0 && ((float) Integer.parseInt(this.z.f58720g)) / ((float) parseInt) > 1.0f;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    @Override // d.a.n0.k1.o.l.i
    public void setAutoPlay(boolean z) {
        this.F = z;
    }

    @Override // d.a.n0.k1.o.l.i
    public void setWaitConfirm(boolean z) {
    }

    public void t(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f58689e = jSONObject.optString("forum_id");
            this.f58690f = jSONObject.optString("thread_id");
            this.f58691g = jSONObject.optString("nid");
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
            this.J.threadId = this.f58690f;
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
                this.y.f58700a = jSONObject2.optString("user_id");
                this.y.f58701b = jSONObject2.optString("user_name");
                this.y.f58702c = jSONObject2.optString("user_nickname");
                this.y.f58703d = jSONObject2.optString("portrait");
                this.y.f58704e = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                b bVar = this.y;
                if (jSONObject2.optInt("is_god") != 1) {
                    z = false;
                }
                bVar.f58705f = z;
                String optString4 = jSONObject2.optString("baijiahao_info");
                if (!TextUtils.isEmpty(optString4)) {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.y.f58707h = new b.a();
                    this.y.f58707h.f58708a = jSONObject3.optString("name");
                    this.y.f58707h.f58711d = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    this.y.f58707h.f58709b = jSONObject3.optString("avatar");
                    this.y.f58707h.f58710c = jSONObject3.optString("avatar_h");
                    this.y.f58707h.f58712e = Integer.valueOf(jSONObject3.optInt("auth_id"));
                    this.y.f58707h.f58713f = jSONObject3.optString("auth_desc");
                }
            }
            String optString5 = jSONObject.optString("video");
            if (!TextUtils.isEmpty(optString5)) {
                this.z = new c();
                JSONObject jSONObject4 = new JSONObject(optString5);
                this.z.f58714a = jSONObject4.optString("thumbnail_width");
                this.z.f58715b = jSONObject4.optString("thumbnail_height");
                this.z.f58716c = jSONObject4.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.z.f58717d = jSONObject4.optString("video_url");
                this.z.f58718e = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.z.f58719f = jSONObject4.optString("video_width");
                this.z.f58720g = jSONObject4.optString("video_height");
                this.z.f58721h = jSONObject4.optLong("video_size");
                this.z.f58722i = jSONObject4.optString("video_type");
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
                    aVar.f58694a = optJSONObject.optLong("ad_start_time");
                    aVar.f58695b = optJSONObject.optLong("ad_end_time");
                    aVar.f58696c = optJSONObject.optString("pic_url");
                    aVar.f58697d = optJSONObject.optString("jump_url");
                    aVar.f58698e = optJSONObject.optString("card_title");
                    aVar.f58699f = optJSONObject.optString("button_title");
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
}
