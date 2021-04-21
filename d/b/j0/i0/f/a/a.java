package d.b.j0.i0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f57040a;

    /* renamed from: b  reason: collision with root package name */
    public String f57041b;

    /* renamed from: c  reason: collision with root package name */
    public long f57042c;

    /* renamed from: d  reason: collision with root package name */
    public long f57043d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f57044e;

    public List<String> a() {
        return this.f57044e;
    }

    public long b() {
        return this.f57042c;
    }

    public int c() {
        return this.f57040a;
    }

    public String d() {
        return this.f57041b;
    }

    public long e() {
        return this.f57043d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f57040a = forumPopupInfo.forum_id.intValue();
        this.f57042c = forumPopupInfo.mem_count_static.intValue();
        this.f57043d = forumPopupInfo.thread_count_static.intValue();
        this.f57044e = forumPopupInfo.forum_names;
        this.f57041b = forumPopupInfo.forum_name;
    }
}
