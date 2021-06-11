package d.a.n0.j0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f59546a;

    /* renamed from: b  reason: collision with root package name */
    public String f59547b;

    /* renamed from: c  reason: collision with root package name */
    public long f59548c;

    /* renamed from: d  reason: collision with root package name */
    public long f59549d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f59550e;

    public List<String> a() {
        return this.f59550e;
    }

    public long b() {
        return this.f59548c;
    }

    public int c() {
        return this.f59546a;
    }

    public String d() {
        return this.f59547b;
    }

    public long e() {
        return this.f59549d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f59546a = forumPopupInfo.forum_id.intValue();
        this.f59548c = forumPopupInfo.mem_count_static.intValue();
        this.f59549d = forumPopupInfo.thread_count_static.intValue();
        this.f59550e = forumPopupInfo.forum_names;
        this.f59547b = forumPopupInfo.forum_name;
    }
}
