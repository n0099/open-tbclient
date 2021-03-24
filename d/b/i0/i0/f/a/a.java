package d.b.i0.i0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f55495a;

    /* renamed from: b  reason: collision with root package name */
    public String f55496b;

    /* renamed from: c  reason: collision with root package name */
    public long f55497c;

    /* renamed from: d  reason: collision with root package name */
    public long f55498d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f55499e;

    public List<String> a() {
        return this.f55499e;
    }

    public long b() {
        return this.f55497c;
    }

    public int c() {
        return this.f55495a;
    }

    public String d() {
        return this.f55496b;
    }

    public long e() {
        return this.f55498d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f55495a = forumPopupInfo.forum_id.intValue();
        this.f55497c = forumPopupInfo.mem_count_static.intValue();
        this.f55498d = forumPopupInfo.thread_count_static.intValue();
        this.f55499e = forumPopupInfo.forum_names;
        this.f55496b = forumPopupInfo.forum_name;
    }
}
