package d.a.o0.z.e0;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes4.dex */
public class g implements d.a.o0.c1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f67311a;

    /* renamed from: b  reason: collision with root package name */
    public String f67312b;

    /* renamed from: c  reason: collision with root package name */
    public String f67313c;

    /* renamed from: d  reason: collision with root package name */
    public long f67314d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67315e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.a.n0.b1.g.a) {
            d.a.n0.b1.g.a aVar = (d.a.n0.b1.g.a) obj;
            return aVar.f52806d == this.f67314d && aVar.f52805c.equals(this.f67313c) && aVar.f52804b.equals(this.f67312b) && aVar.f52807e == this.f67315e && aVar.f52803a == this.f67311a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f67311a + ",forumAvatar=" + this.f67312b + ",forumName=" + this.f67313c + ",forumId=" + this.f67314d + ",isLiked=" + this.f67315e + "," + PreferencesUtil.RIGHT_MOUNT;
    }
}
