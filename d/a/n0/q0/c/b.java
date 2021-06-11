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
    public long f61974e;

    /* renamed from: f  reason: collision with root package name */
    public String f61975f;

    /* renamed from: g  reason: collision with root package name */
    public String f61976g;

    /* renamed from: h  reason: collision with root package name */
    public String f61977h;

    /* renamed from: i  reason: collision with root package name */
    public String f61978i;
    public String j;
    public List<FrsTabInfo> k;

    public b(String str) {
        this.j = str;
    }

    public String c() {
        return this.f61976g;
    }

    public String g() {
        return this.f61978i;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public long i() {
        return this.f61974e;
    }

    public String k() {
        return this.f61975f;
    }

    public List<FrsTabInfo> o() {
        return this.k;
    }

    public String p() {
        return this.f61977h;
    }

    public String q() {
        return this.j;
    }

    public void t(SearchForum searchForum) {
        if (searchForum == null) {
            return;
        }
        this.f61974e = searchForum.forum_id.longValue();
        this.f61975f = searchForum.forum_name;
        this.f61976g = searchForum.avatar;
        this.f61977h = searchForum.post_num;
        this.f61978i = searchForum.concern_num;
        String str = searchForum.slogan;
        String str2 = searchForum.intro;
        searchForum.has_concerned.intValue();
        this.k = searchForum.tab_info;
    }
}
