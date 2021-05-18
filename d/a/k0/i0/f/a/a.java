package d.a.k0.i0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f55673a;

    /* renamed from: b  reason: collision with root package name */
    public String f55674b;

    /* renamed from: c  reason: collision with root package name */
    public long f55675c;

    /* renamed from: d  reason: collision with root package name */
    public long f55676d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f55677e;

    public List<String> a() {
        return this.f55677e;
    }

    public long b() {
        return this.f55675c;
    }

    public int c() {
        return this.f55673a;
    }

    public String d() {
        return this.f55674b;
    }

    public long e() {
        return this.f55676d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f55673a = forumPopupInfo.forum_id.intValue();
        this.f55675c = forumPopupInfo.mem_count_static.intValue();
        this.f55676d = forumPopupInfo.thread_count_static.intValue();
        this.f55677e = forumPopupInfo.forum_names;
        this.f55674b = forumPopupInfo.forum_name;
    }
}
