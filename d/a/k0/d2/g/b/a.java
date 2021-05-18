package d.a.k0.d2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class a implements d.a.k0.d2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f52640e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f52641f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f52642g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f52643h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f52640e = userInfo;
        this.f52641f = excellentPbThreadInfo;
        this.f52642g = list;
        this.f52643h = list2;
    }

    @Override // d.a.k0.d2.g.c.a
    public int getErroCode() {
        return 0;
    }

    @Override // d.a.k0.d2.g.c.a
    public String getErrorText() {
        return null;
    }

    @Override // d.a.k0.d2.g.c.a
    public List<Post> getPostList() {
        return this.f52642g;
    }

    @Override // d.a.k0.d2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f52641f;
    }

    @Override // d.a.k0.d2.g.c.a
    public UserInfo getUserInfo() {
        return this.f52640e;
    }

    @Override // d.a.k0.d2.g.c.a
    public List<User> getUserList() {
        return this.f52643h;
    }

    @Override // d.a.k0.d2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f52641f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
