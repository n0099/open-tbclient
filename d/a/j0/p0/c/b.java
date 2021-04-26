package d.a.j0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f57345e;

    /* renamed from: f  reason: collision with root package name */
    public String f57346f;

    /* renamed from: g  reason: collision with root package name */
    public String f57347g;

    /* renamed from: h  reason: collision with root package name */
    public String f57348h;

    /* renamed from: i  reason: collision with root package name */
    public String f57349i;
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
        return this.f57347g;
    }

    public String l() {
        return this.f57349i;
    }

    public long m() {
        return this.f57345e;
    }

    public String p() {
        return this.f57346f;
    }

    public List<FrsTabInfo> s() {
        return this.k;
    }

    public String t() {
        return this.f57348h;
    }

    public String u() {
        return this.j;
    }

    public void v(SearchForum searchForum) {
        if (searchForum == null) {
            return;
        }
        this.f57345e = searchForum.forum_id.longValue();
        this.f57346f = searchForum.forum_name;
        this.f57347g = searchForum.avatar;
        this.f57348h = searchForum.post_num;
        this.f57349i = searchForum.concern_num;
        String str = searchForum.slogan;
        String str2 = searchForum.intro;
        searchForum.has_concerned.intValue();
        this.k = searchForum.tab_info;
    }
}
