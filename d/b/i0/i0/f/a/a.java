package d.b.i0.i0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f56619a;

    /* renamed from: b  reason: collision with root package name */
    public String f56620b;

    /* renamed from: c  reason: collision with root package name */
    public long f56621c;

    /* renamed from: d  reason: collision with root package name */
    public long f56622d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f56623e;

    public List<String> a() {
        return this.f56623e;
    }

    public long b() {
        return this.f56621c;
    }

    public int c() {
        return this.f56619a;
    }

    public String d() {
        return this.f56620b;
    }

    public long e() {
        return this.f56622d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f56619a = forumPopupInfo.forum_id.intValue();
        this.f56621c = forumPopupInfo.mem_count_static.intValue();
        this.f56622d = forumPopupInfo.thread_count_static.intValue();
        this.f56623e = forumPopupInfo.forum_names;
        this.f56620b = forumPopupInfo.forum_name;
    }
}
