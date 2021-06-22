package d.a.o0.j0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f59671a;

    /* renamed from: b  reason: collision with root package name */
    public String f59672b;

    /* renamed from: c  reason: collision with root package name */
    public long f59673c;

    /* renamed from: d  reason: collision with root package name */
    public long f59674d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f59675e;

    public List<String> a() {
        return this.f59675e;
    }

    public long b() {
        return this.f59673c;
    }

    public int c() {
        return this.f59671a;
    }

    public String d() {
        return this.f59672b;
    }

    public long e() {
        return this.f59674d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f59671a = forumPopupInfo.forum_id.intValue();
        this.f59673c = forumPopupInfo.mem_count_static.intValue();
        this.f59674d = forumPopupInfo.thread_count_static.intValue();
        this.f59675e = forumPopupInfo.forum_names;
        this.f59672b = forumPopupInfo.forum_name;
    }
}
