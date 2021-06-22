package d.a.o0.e2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class a implements d.a.o0.e2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f56659e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f56660f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f56661g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f56662h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f56659e = userInfo;
        this.f56660f = excellentPbThreadInfo;
        this.f56661g = list;
        this.f56662h = list2;
    }

    @Override // d.a.o0.e2.g.c.a
    public int getErroCode() {
        return 0;
    }

    @Override // d.a.o0.e2.g.c.a
    public String getErrorText() {
        return null;
    }

    @Override // d.a.o0.e2.g.c.a
    public List<Post> getPostList() {
        return this.f56661g;
    }

    @Override // d.a.o0.e2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f56660f;
    }

    @Override // d.a.o0.e2.g.c.a
    public UserInfo getUserInfo() {
        return this.f56659e;
    }

    @Override // d.a.o0.e2.g.c.a
    public List<User> getUserList() {
        return this.f56662h;
    }

    @Override // d.a.o0.e2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f56660f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
