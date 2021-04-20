package d.b.i0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f58889e;

    /* renamed from: f  reason: collision with root package name */
    public String f58890f;

    /* renamed from: g  reason: collision with root package name */
    public String f58891g;

    /* renamed from: h  reason: collision with root package name */
    public String f58892h;
    public String i;
    public String j;
    public List<FrsTabInfo> k;

    public b(String str) {
        this.j = str;
    }

    public String g() {
        return this.f58891g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String j() {
        return this.i;
    }

    public long n() {
        return this.f58889e;
    }

    public String o() {
        return this.f58890f;
    }

    public List<FrsTabInfo> s() {
        return this.k;
    }

    public String t() {
        return this.f58892h;
    }

    public String u() {
        return this.j;
    }

    public void v(SearchForum searchForum) {
        if (searchForum == null) {
            return;
        }
        this.f58889e = searchForum.forum_id.longValue();
        this.f58890f = searchForum.forum_name;
        this.f58891g = searchForum.avatar;
        this.f58892h = searchForum.post_num;
        this.i = searchForum.concern_num;
        String str = searchForum.slogan;
        String str2 = searchForum.intro;
        searchForum.has_concerned.intValue();
        this.k = searchForum.tab_info;
    }
}
