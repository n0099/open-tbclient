package d.b.i0.d2.g.b;

import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class a implements d.b.i0.d2.g.c.a {

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f53743e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f53744f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f53745g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f53746h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.f53743e = userInfo;
        this.f53744f = excellentPbThreadInfo;
        this.f53745g = list;
        this.f53746h = list2;
    }

    @Override // d.b.i0.d2.g.c.a
    public int getErroCode() {
        return 0;
    }

    @Override // d.b.i0.d2.g.c.a
    public String getErrorText() {
        return null;
    }

    @Override // d.b.i0.d2.g.c.a
    public List<Post> getPostList() {
        return this.f53745g;
    }

    @Override // d.b.i0.d2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.f53744f;
    }

    @Override // d.b.i0.d2.g.c.a
    public UserInfo getUserInfo() {
        return this.f53743e;
    }

    @Override // d.b.i0.d2.g.c.a
    public List<User> getUserList() {
        return this.f53746h;
    }

    @Override // d.b.i0.d2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.f53744f;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }
}
