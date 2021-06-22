package d.a.o0.q0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f62099e;

    /* renamed from: f  reason: collision with root package name */
    public String f62100f;

    /* renamed from: g  reason: collision with root package name */
    public String f62101g;

    /* renamed from: h  reason: collision with root package name */
    public String f62102h;

    /* renamed from: i  reason: collision with root package name */
    public String f62103i;
    public String j;
    public List<FrsTabInfo> k;

    public b(String str) {
        this.j = str;
    }

    public String c() {
        return this.f62101g;
    }

    public String g() {
        return this.f62103i;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public long i() {
        return this.f62099e;
    }

    public String k() {
        return this.f62100f;
    }

    public List<FrsTabInfo> o() {
        return this.k;
    }

    public String p() {
        return this.f62102h;
    }

    public String q() {
        return this.j;
    }

    public void t(SearchForum searchForum) {
        if (searchForum == null) {
            return;
        }
        this.f62099e = searchForum.forum_id.longValue();
        this.f62100f = searchForum.forum_name;
        this.f62101g = searchForum.avatar;
        this.f62102h = searchForum.post_num;
        this.f62103i = searchForum.concern_num;
        String str = searchForum.slogan;
        String str2 = searchForum.intro;
        searchForum.has_concerned.intValue();
        this.k = searchForum.tab_info;
    }
}
