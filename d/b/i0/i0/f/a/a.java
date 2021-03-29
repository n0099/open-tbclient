package d.b.i0.i0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f55496a;

    /* renamed from: b  reason: collision with root package name */
    public String f55497b;

    /* renamed from: c  reason: collision with root package name */
    public long f55498c;

    /* renamed from: d  reason: collision with root package name */
    public long f55499d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f55500e;

    public List<String> a() {
        return this.f55500e;
    }

    public long b() {
        return this.f55498c;
    }

    public int c() {
        return this.f55496a;
    }

    public String d() {
        return this.f55497b;
    }

    public long e() {
        return this.f55499d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f55496a = forumPopupInfo.forum_id.intValue();
        this.f55498c = forumPopupInfo.mem_count_static.intValue();
        this.f55499d = forumPopupInfo.thread_count_static.intValue();
        this.f55500e = forumPopupInfo.forum_names;
        this.f55497b = forumPopupInfo.forum_name;
    }
}
