package d.a.n0.j0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f55857a;

    /* renamed from: b  reason: collision with root package name */
    public String f55858b;

    /* renamed from: c  reason: collision with root package name */
    public long f55859c;

    /* renamed from: d  reason: collision with root package name */
    public long f55860d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f55861e;

    public List<String> a() {
        return this.f55861e;
    }

    public long b() {
        return this.f55859c;
    }

    public int c() {
        return this.f55857a;
    }

    public String d() {
        return this.f55858b;
    }

    public long e() {
        return this.f55860d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f55857a = forumPopupInfo.forum_id.intValue();
        this.f55859c = forumPopupInfo.mem_count_static.intValue();
        this.f55860d = forumPopupInfo.thread_count_static.intValue();
        this.f55861e = forumPopupInfo.forum_names;
        this.f55858b = forumPopupInfo.forum_name;
    }
}
