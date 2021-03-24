package d.b.h0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f49878a;

    /* renamed from: b  reason: collision with root package name */
    public String f49879b;

    /* renamed from: c  reason: collision with root package name */
    public String f49880c;

    /* renamed from: d  reason: collision with root package name */
    public long f49881d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49882e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f49881d == this.f49881d && aVar.f49880c.equals(this.f49880c) && aVar.f49879b.equals(this.f49879b) && aVar.f49882e == this.f49882e && aVar.f49878a == this.f49878a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f49878a + ",forumAvatar=" + this.f49879b + ",forumName=" + this.f49880c + ",forumId=" + this.f49881d + ",isLiked=" + this.f49882e + ",]";
    }
}
