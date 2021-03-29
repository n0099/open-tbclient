package d.b.i0.c2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class a implements d.b.i0.c2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f52348e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f52349f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f52350g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f52351h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f52348e = userInfo;
        this.f52349f = excellentPbThreadInfo;
        this.f52350g = list;
        this.f52351h = list2;
    }

    @Override // d.b.i0.c2.g.c.a
    public int getErroCode() {
        return 0;
    }

    @Override // d.b.i0.c2.g.c.a
    public String getErrorText() {
        return null;
    }

    @Override // d.b.i0.c2.g.c.a
    public List<Post> getPostList() {
        return this.f52350g;
    }

    @Override // d.b.i0.c2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f52349f;
    }

    @Override // d.b.i0.c2.g.c.a
    public UserInfo getUserInfo() {
        return this.f52348e;
    }

    @Override // d.b.i0.c2.g.c.a
    public List<User> getUserList() {
        return this.f52351h;
    }

    @Override // d.b.i0.c2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f52349f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
