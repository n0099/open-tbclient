package d.b.j0.i0.d;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import d.b.i0.r.q.w;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends w implements d.b.i0.g0.b.a {

    /* renamed from: h  reason: collision with root package name */
    public String f57034h;
    public String i;
    public int j;
    public int k;
    public String l;
    public int m;
    public int n;
    public int o;
    public PrivateForumInfo p;
    public String q;
    public int r;
    public ThemeColorInfo s;
    public boolean t;
    public long u;
    public ArrayList<FrsTabItemData> v;

    public f() {
        A(1);
    }

    public String B() {
        return this.l;
    }

    public long C() {
        return this.u;
    }

    public String D() {
        return this.f57034h;
    }

    public int E() {
        return this.r;
    }

    public int F() {
        return this.j;
    }

    public String G() {
        return this.i;
    }

    public boolean H() {
        return this.t;
    }

    public ArrayList<FrsTabItemData> I() {
        return this.v;
    }

    public ArrayList<Integer> J() {
        ThemeColorInfo themeColorInfo = this.s;
        if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(d.b.j0.j1.o.k.b.b(this.s.day.light_color)));
        arrayList.add(Integer.valueOf(d.b.j0.j1.o.k.b.b(this.s.day.dark_color)));
        arrayList.add(Integer.valueOf(d.b.j0.j1.o.k.b.b(this.s.night.light_color)));
        arrayList.add(Integer.valueOf(d.b.j0.j1.o.k.b.b(this.s.night.dark_color)));
        arrayList.add(Integer.valueOf(d.b.j0.j1.o.k.b.b(this.s.dark.light_color)));
        arrayList.add(Integer.valueOf(d.b.j0.j1.o.k.b.b(this.s.dark.dark_color)));
        return arrayList;
    }

    public String K() {
        return this.q;
    }

    public ThemeColorInfo L() {
        return this.s;
    }

    public int M() {
        return this.m;
    }

    public boolean N() {
        PrivateForumInfo privateForumInfo;
        return this.n == 1 && this.o == 1 && (privateForumInfo = this.p) != null && privateForumInfo.private_forum_status.intValue() == 1 && this.p.private_forum_audit_status.intValue() == 2;
    }

    public int O() {
        return this.n;
    }

    public int P() {
        return this.o;
    }

    public int Q() {
        return this.k;
    }

    public boolean R() {
        PrivateForumInfo privateForumInfo;
        return this.n == 1 && this.o == 1 && (privateForumInfo = this.p) != null && privateForumInfo.private_forum_status.intValue() == 1;
    }

    public void S(LikeForum likeForum) {
        if (likeForum == null) {
            return;
        }
        T(likeForum, null);
    }

    public void T(LikeForum likeForum, Context context) {
        if (likeForum == null) {
            return;
        }
        try {
            this.f57034h = String.valueOf(likeForum.forum_id);
            this.i = likeForum.forum_name;
            this.k = likeForum.is_sign.intValue();
            this.j = likeForum.level_id.intValue();
            this.l = likeForum.avatar;
            this.n = likeForum.is_manager.intValue();
            this.o = likeForum.is_private_forum.intValue();
            this.p = likeForum.private_forum_info;
            this.m = likeForum.is_brand_forum.intValue();
            this.q = likeForum.content;
            this.r = likeForum.is_top.intValue();
            likeForum.sort_type.intValue();
            this.s = likeForum.theme_color;
            this.t = likeForum.need_trans.booleanValue();
            this.u = likeForum.hot_thread_id.longValue();
            this.v = new ArrayList<>();
            for (FrsTabInfo frsTabInfo : likeForum.tab_info) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.v.add(new FrsTabItemData(frsTabInfo));
                }
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void U(long j) {
        this.u = j;
    }

    public void V(int i) {
        this.k = i;
    }

    public void W(int i) {
        this.j = i;
    }
}
