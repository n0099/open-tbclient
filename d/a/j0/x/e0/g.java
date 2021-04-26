package d.a.j0.x.e0;
/* loaded from: classes4.dex */
public class g implements d.a.j0.b1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f62464a;

    /* renamed from: b  reason: collision with root package name */
    public String f62465b;

    /* renamed from: c  reason: collision with root package name */
    public String f62466c;

    /* renamed from: d  reason: collision with root package name */
    public long f62467d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62468e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.a.i0.b1.g.a) {
            d.a.i0.b1.g.a aVar = (d.a.i0.b1.g.a) obj;
            return aVar.f48172d == this.f62467d && aVar.f48171c.equals(this.f62466c) && aVar.f48170b.equals(this.f62465b) && aVar.f48173e == this.f62468e && aVar.f48169a == this.f62464a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f62464a + ",forumAvatar=" + this.f62465b + ",forumName=" + this.f62466c + ",forumId=" + this.f62467d + ",isLiked=" + this.f62468e + ",]";
    }
}
