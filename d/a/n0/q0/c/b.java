package d.a.n0.q0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f58283e;

    /* renamed from: f  reason: collision with root package name */
    public String f58284f;

    /* renamed from: g  reason: collision with root package name */
    public String f58285g;

    /* renamed from: h  reason: collision with root package name */
    public String f58286h;

    /* renamed from: i  reason: collision with root package name */
    public String f58287i;
    public String j;
    public List<FrsTabInfo> k;

    public b(String str) {
        this.j = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String h() {
        return this.f58285g;
    }

    public String l() {
        return this.f58287i;
    }

    public long m() {
        return this.f58283e;
    }

    public String p() {
        return this.f58284f;
    }

    public List<FrsTabInfo> s() {
        return this.k;
    }

    public String t() {
        return this.f58286h;
    }

    public String u() {
        return this.j;
    }

    public void v(SearchForum searchForum) {
        if (searchForum == null) {
            return;
        }
        this.f58283e = searchForum.forum_id.longValue();
        this.f58284f = searchForum.forum_name;
        this.f58285g = searchForum.avatar;
        this.f58286h = searchForum.post_num;
        this.f58287i = searchForum.concern_num;
        String str = searchForum.slogan;
        String str2 = searchForum.intro;
        searchForum.has_concerned.intValue();
        this.k = searchForum.tab_info;
    }
}
