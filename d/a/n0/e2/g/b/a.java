package d.a.n0.e2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class a implements d.a.n0.e2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f56534e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f56535f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f56536g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f56537h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f56534e = userInfo;
        this.f56535f = excellentPbThreadInfo;
        this.f56536g = list;
        this.f56537h = list2;
    }

    @Override // d.a.n0.e2.g.c.a
    public int getErroCode() {
        return 0;
    }

    @Override // d.a.n0.e2.g.c.a
    public String getErrorText() {
        return null;
    }

    @Override // d.a.n0.e2.g.c.a
    public List<Post> getPostList() {
        return this.f56536g;
    }

    @Override // d.a.n0.e2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f56535f;
    }

    @Override // d.a.n0.e2.g.c.a
    public UserInfo getUserInfo() {
        return this.f56534e;
    }

    @Override // d.a.n0.e2.g.c.a
    public List<User> getUserList() {
        return this.f56537h;
    }

    @Override // d.a.n0.e2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f56535f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
