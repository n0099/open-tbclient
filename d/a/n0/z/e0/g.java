package d.a.n0.z.e0;
/* loaded from: classes4.dex */
public class g implements d.a.n0.c1.b.c {

    /* renamed from: a  reason: collision with root package name */
    public int f63468a;

    /* renamed from: b  reason: collision with root package name */
    public String f63469b;

    /* renamed from: c  reason: collision with root package name */
    public String f63470c;

    /* renamed from: d  reason: collision with root package name */
    public long f63471d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63472e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d.a.m0.b1.g.a) {
            d.a.m0.b1.g.a aVar = (d.a.m0.b1.g.a) obj;
            return aVar.f49025d == this.f63471d && aVar.f49024c.equals(this.f63470c) && aVar.f49023b.equals(this.f63469b) && aVar.f49026e == this.f63472e && aVar.f49022a == this.f63468a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f63468a + ",forumAvatar=" + this.f63469b + ",forumName=" + this.f63470c + ",forumId=" + this.f63471d + ",isLiked=" + this.f63472e + ",]";
    }
}
