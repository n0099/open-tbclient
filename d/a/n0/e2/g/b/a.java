package d.a.n0.e2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class a implements d.a.n0.e2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f52845e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f52846f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f52847g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f52848h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f52845e = userInfo;
        this.f52846f = excellentPbThreadInfo;
        this.f52847g = list;
        this.f52848h = list2;
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
        return this.f52847g;
    }

    @Override // d.a.n0.e2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f52846f;
    }

    @Override // d.a.n0.e2.g.c.a
    public UserInfo getUserInfo() {
        return this.f52845e;
    }

    @Override // d.a.n0.e2.g.c.a
    public List<User> getUserList() {
        return this.f52848h;
    }

    @Override // d.a.n0.e2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f52846f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
