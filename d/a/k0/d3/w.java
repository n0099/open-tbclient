package d.a.k0.d3;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public int f54024a;

    /* renamed from: d  reason: collision with root package name */
    public int f54027d;

    /* renamed from: e  reason: collision with root package name */
    public int f54028e;

    /* renamed from: f  reason: collision with root package name */
    public String f54029f;

    /* renamed from: g  reason: collision with root package name */
    public String f54030g;

    /* renamed from: i  reason: collision with root package name */
    public String f54032i;
    public BlockPopInfoData j;
    public int k;
    public String l;

    /* renamed from: h  reason: collision with root package name */
    public List<FeedForumData> f54031h = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f54025b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f54026c = 0;

    public w() {
        t("");
        v(0);
        r(0);
        u(0);
    }

    public BlockPopInfoData a() {
        return this.j;
    }

    public String b() {
        return this.f54032i;
    }

    public int c() {
        return this.f54027d;
    }

    public int d() {
        return this.k;
    }

    public String e() {
        return this.l;
    }

    public List<FeedForumData> f() {
        return this.f54031h;
    }

    public String g() {
        return this.f54029f;
    }

    public String h() {
        return this.f54030g;
    }

    public int i() {
        return this.f54028e;
    }

    public int j() {
        return this.f54025b;
    }

    public int k() {
        return this.f54026c;
    }

    public int l() {
        return this.f54024a;
    }

    public final void m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54032i = jSONObject.optString("block_dealurl");
        String optString = jSONObject.optString("block_content");
        if (StringUtils.isNull(optString)) {
            return;
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        this.j = blockPopInfoData;
        blockPopInfoData.block_info = optString;
        blockPopInfoData.ahead_url = this.f54032i;
        blockPopInfoData.ahead_info = jSONObject.optString("block_confirm");
        this.j.ok_info = jSONObject.optString("block_cancel");
    }

    public void n(JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                FeedForumData feedForumData = new FeedForumData();
                feedForumData.setForumId(jSONObject.optString("forum_id"));
                feedForumData.setForumName(jSONObject.optString("forum_name"));
                feedForumData.setMemberCount(jSONObject.optInt("member_count", 0));
                feedForumData.setPostNum(jSONObject.optInt("post_num", 0));
                feedForumData.setAvatar(jSONObject.optString("avatar"));
                feedForumData.setReason(jSONObject.optString("reason"));
                feedForumData.setIsLike(jSONObject.optInt("is_like", 0));
                feedForumData.setPos(jSONObject.optInt(IAdRequestParam.POS, 0));
                this.f54031h.add(feedForumData);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public void o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            p(jSONObject.optJSONObject("info"));
            n(jSONObject.optJSONArray("feed_forum"));
            this.k = jSONObject.optInt("error_code");
            this.l = jSONObject.optString("error_msg");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("is_black", 0);
            this.f54025b = jSONObject.optInt("like_num", 0);
            this.f54026c = jSONObject.optInt("level_id", 0);
            v(jSONObject.optInt("is_like", 0));
            t(jSONObject.optString("level_name", ""));
            u(jSONObject.optInt("levelup_score", 0));
            r(jSONObject.optInt("cur_score", 0));
            m(jSONObject);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void q(BlockPopInfoData blockPopInfoData) {
        this.j = blockPopInfoData;
    }

    public void r(int i2) {
        this.f54027d = i2;
    }

    public void s(String str) {
        this.f54029f = str;
    }

    public void t(String str) {
        this.f54030g = str;
    }

    public void u(int i2) {
        this.f54028e = i2;
    }

    public void v(int i2) {
        this.f54024a = i2;
    }

    public void w(int i2) {
        if (i2 >= 0) {
            this.f54026c = i2;
        }
    }
}
