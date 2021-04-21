package d.b.j0.d2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class a implements d.b.j0.d2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f54164e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f54165f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f54166g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f54167h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f54164e = userInfo;
        this.f54165f = excellentPbThreadInfo;
        this.f54166g = list;
        this.f54167h = list2;
    }

    @Override // d.b.j0.d2.g.c.a
    public int getErroCode() {
        return 0;
    }

    @Override // d.b.j0.d2.g.c.a
    public String getErrorText() {
        return null;
    }

    @Override // d.b.j0.d2.g.c.a
    public List<Post> getPostList() {
        return this.f54166g;
    }

    @Override // d.b.j0.d2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f54165f;
    }

    @Override // d.b.j0.d2.g.c.a
    public UserInfo getUserInfo() {
        return this.f54164e;
    }

    @Override // d.b.j0.d2.g.c.a
    public List<User> getUserList() {
        return this.f54167h;
    }

    @Override // d.b.j0.d2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f54165f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
