package d.a.m0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f49022a;

    /* renamed from: b  reason: collision with root package name */
    public String f49023b;

    /* renamed from: c  reason: collision with root package name */
    public String f49024c;

    /* renamed from: d  reason: collision with root package name */
    public long f49025d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49026e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f49025d == this.f49025d && aVar.f49024c.equals(this.f49024c) && aVar.f49023b.equals(this.f49023b) && aVar.f49026e == this.f49026e && aVar.f49022a == this.f49022a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f49022a + ",forumAvatar=" + this.f49023b + ",forumName=" + this.f49024c + ",forumId=" + this.f49025d + ",isLiked=" + this.f49026e + ",]";
    }
}
