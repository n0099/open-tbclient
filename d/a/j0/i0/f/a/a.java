package d.a.j0.i0.f.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f54966a;

    /* renamed from: b  reason: collision with root package name */
    public String f54967b;

    /* renamed from: c  reason: collision with root package name */
    public long f54968c;

    /* renamed from: d  reason: collision with root package name */
    public long f54969d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f54970e;

    public List<String> a() {
        return this.f54970e;
    }

    public long b() {
        return this.f54968c;
    }

    public int c() {
        return this.f54966a;
    }

    public String d() {
        return this.f54967b;
    }

    public long e() {
        return this.f54969d;
    }

    public void f(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo == null) {
            return;
        }
        this.f54966a = forumPopupInfo.forum_id.intValue();
        this.f54968c = forumPopupInfo.mem_count_static.intValue();
        this.f54969d = forumPopupInfo.thread_count_static.intValue();
        this.f54970e = forumPopupInfo.forum_names;
        this.f54967b = forumPopupInfo.forum_name;
    }
}
