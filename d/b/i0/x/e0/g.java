package d.b.i0.x.e0;
/* loaded from: classes4.dex */
public class g implements d.b.i0.b1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f63780a;

    /* renamed from: b  reason: collision with root package name */
    public String f63781b;

    /* renamed from: c  reason: collision with root package name */
    public String f63782c;

    /* renamed from: d  reason: collision with root package name */
    public long f63783d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63784e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.b.h0.b1.g.a) {
            d.b.h0.b1.g.a aVar = (d.b.h0.b1.g.a) obj;
            return aVar.f50275d == this.f63783d && aVar.f50274c.equals(this.f63782c) && aVar.f50273b.equals(this.f63781b) && aVar.f50276e == this.f63784e && aVar.f50272a == this.f63780a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f63780a + ",forumAvatar=" + this.f63781b + ",forumName=" + this.f63782c + ",forumId=" + this.f63783d + ",isLiked=" + this.f63784e + ",]";
    }
}
