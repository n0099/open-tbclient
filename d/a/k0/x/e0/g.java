package d.a.k0.x.e0;
/* loaded from: classes4.dex */
public class g implements d.a.k0.b1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f63188a;

    /* renamed from: b  reason: collision with root package name */
    public String f63189b;

    /* renamed from: c  reason: collision with root package name */
    public String f63190c;

    /* renamed from: d  reason: collision with root package name */
    public long f63191d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63192e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.a.j0.b1.g.a) {
            d.a.j0.b1.g.a aVar = (d.a.j0.b1.g.a) obj;
            return aVar.f49000d == this.f63191d && aVar.f48999c.equals(this.f63190c) && aVar.f48998b.equals(this.f63189b) && aVar.f49001e == this.f63192e && aVar.f48997a == this.f63188a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f63188a + ",forumAvatar=" + this.f63189b + ",forumName=" + this.f63190c + ",forumId=" + this.f63191d + ",isLiked=" + this.f63192e + ",]";
    }
}
