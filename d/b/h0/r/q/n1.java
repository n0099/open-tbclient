package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class n1 extends w implements d.b.h0.g0.b.a {

    /* renamed from: h  reason: collision with root package name */
    public long f50853h;
    public String i;
    public String j;
    public boolean k;
    public int l;
    public int m;
    public String n;

    public n1() {
        A(8);
    }

    public String B() {
        return this.i;
    }

    public long C() {
        return this.f50853h;
    }

    public String D() {
        return this.j;
    }

    public int E() {
        return this.l;
    }

    public String F() {
        return this.n;
    }

    public int G() {
        return this.m;
    }

    public boolean H() {
        return this.k;
    }

    public void I(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        try {
            this.f50853h = recommendForumInfo.forum_id.longValue();
            this.i = recommendForumInfo.avatar;
            this.j = recommendForumInfo.forum_name;
            boolean z = true;
            if (recommendForumInfo.is_like.intValue() != 1) {
                z = false;
            }
            this.k = z;
            this.l = recommendForumInfo.member_count.intValue();
            this.m = recommendForumInfo.thread_count.intValue();
            this.n = recommendForumInfo.recom_reason;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void J(boolean z) {
        this.k = z;
    }

    public void K(int i) {
        this.l = i;
    }

    public void L(String str) {
        this.n = str;
    }

    public void M(int i) {
        this.m = i;
    }

    public void N(String str) {
        this.i = str;
    }

    public void O(long j) {
        this.f50853h = j;
    }

    public void P(String str) {
        this.j = str;
    }
}
