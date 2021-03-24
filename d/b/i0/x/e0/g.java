package d.b.i0.x.e0;
/* loaded from: classes4.dex */
public class g implements d.b.i0.a1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f62204a;

    /* renamed from: b  reason: collision with root package name */
    public String f62205b;

    /* renamed from: c  reason: collision with root package name */
    public String f62206c;

    /* renamed from: d  reason: collision with root package name */
    public long f62207d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62208e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.b.h0.b1.g.a) {
            d.b.h0.b1.g.a aVar = (d.b.h0.b1.g.a) obj;
            return aVar.f49881d == this.f62207d && aVar.f49880c.equals(this.f62206c) && aVar.f49879b.equals(this.f62205b) && aVar.f49882e == this.f62208e && aVar.f49878a == this.f62204a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f62204a + ",forumAvatar=" + this.f62205b + ",forumName=" + this.f62206c + ",forumId=" + this.f62207d + ",isLiked=" + this.f62208e + ",]";
    }
}
