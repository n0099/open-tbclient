package d.a.n0.z.e0;
/* loaded from: classes4.dex */
public class g implements d.a.n0.c1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f67186a;

    /* renamed from: b  reason: collision with root package name */
    public String f67187b;

    /* renamed from: c  reason: collision with root package name */
    public String f67188c;

    /* renamed from: d  reason: collision with root package name */
    public long f67189d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67190e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.a.m0.b1.g.a) {
            d.a.m0.b1.g.a aVar = (d.a.m0.b1.g.a) obj;
            return aVar.f52699d == this.f67189d && aVar.f52698c.equals(this.f67188c) && aVar.f52697b.equals(this.f67187b) && aVar.f52700e == this.f67190e && aVar.f52696a == this.f67186a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f67186a + ",forumAvatar=" + this.f67187b + ",forumName=" + this.f67188c + ",forumId=" + this.f67189d + ",isLiked=" + this.f67190e + ",]";
    }
}
