package d.b.i0.x.e0;
/* loaded from: classes4.dex */
public class g implements d.b.i0.a1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f62205a;

    /* renamed from: b  reason: collision with root package name */
    public String f62206b;

    /* renamed from: c  reason: collision with root package name */
    public String f62207c;

    /* renamed from: d  reason: collision with root package name */
    public long f62208d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62209e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.b.h0.b1.g.a) {
            d.b.h0.b1.g.a aVar = (d.b.h0.b1.g.a) obj;
            return aVar.f49882d == this.f62208d && aVar.f49881c.equals(this.f62207c) && aVar.f49880b.equals(this.f62206b) && aVar.f49883e == this.f62209e && aVar.f49879a == this.f62205a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f62205a + ",forumAvatar=" + this.f62206b + ",forumName=" + this.f62207c + ",forumId=" + this.f62208d + ",isLiked=" + this.f62209e + ",]";
    }
}
