package d.b.j0.x.e0;
/* loaded from: classes4.dex */
public class g implements d.b.j0.b1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f64201a;

    /* renamed from: b  reason: collision with root package name */
    public String f64202b;

    /* renamed from: c  reason: collision with root package name */
    public String f64203c;

    /* renamed from: d  reason: collision with root package name */
    public long f64204d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64205e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.b.i0.b1.g.a) {
            d.b.i0.b1.g.a aVar = (d.b.i0.b1.g.a) obj;
            return aVar.f50611d == this.f64204d && aVar.f50610c.equals(this.f64203c) && aVar.f50609b.equals(this.f64202b) && aVar.f50612e == this.f64205e && aVar.f50608a == this.f64201a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f64201a + ",forumAvatar=" + this.f64202b + ",forumName=" + this.f64203c + ",forumId=" + this.f64204d + ",isLiked=" + this.f64205e + ",]";
    }
}
