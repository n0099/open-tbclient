package d.a.j0.d2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class a implements d.a.j0.d2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f51941e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f51942f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f51943g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f51944h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f51941e = userInfo;
        this.f51942f = excellentPbThreadInfo;
        this.f51943g = list;
        this.f51944h = list2;
    }

    @Override // d.a.j0.d2.g.c.a
    public int getErroCode() {
        return 0;
    }

    @Override // d.a.j0.d2.g.c.a
    public String getErrorText() {
        return null;
    }

    @Override // d.a.j0.d2.g.c.a
    public List<Post> getPostList() {
        return this.f51943g;
    }

    @Override // d.a.j0.d2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f51942f;
    }

    @Override // d.a.j0.d2.g.c.a
    public UserInfo getUserInfo() {
        return this.f51941e;
    }

    @Override // d.a.j0.d2.g.c.a
    public List<User> getUserList() {
        return this.f51944h;
    }

    @Override // d.a.j0.d2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f51942f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
