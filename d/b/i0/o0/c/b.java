package d.b.i0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f57243e;

    /* renamed from: f  reason: collision with root package name */
    public String f57244f;

    /* renamed from: g  reason: collision with root package name */
    public String f57245g;

    /* renamed from: h  reason: collision with root package name */
    public String f57246h;
    public String i;
    public String j;
    public List<FrsTabInfo> k;

    public b(String str) {
        this.j = str;
    }

    public String g() {
        return this.f57245g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String j() {
        return this.i;
    }

    public long n() {
        return this.f57243e;
    }

    public String o() {
        return this.f57244f;
    }

    public List<FrsTabInfo> s() {
        return this.k;
    }

    public String t() {
        return this.f57246h;
    }

    public String u() {
        return this.j;
    }

    public void v(SearchForum searchForum) {
        if (searchForum == null) {
            return;
        }
        this.f57243e = searchForum.forum_id.longValue();
        this.f57244f = searchForum.forum_name;
        this.f57245g = searchForum.avatar;
        this.f57246h = searchForum.post_num;
        this.i = searchForum.concern_num;
        String str = searchForum.slogan;
        String str2 = searchForum.intro;
        searchForum.has_concerned.intValue();
        this.k = searchForum.tab_info;
    }
}
