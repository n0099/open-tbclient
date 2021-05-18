package d.a.j0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f48997a;

    /* renamed from: b  reason: collision with root package name */
    public String f48998b;

    /* renamed from: c  reason: collision with root package name */
    public String f48999c;

    /* renamed from: d  reason: collision with root package name */
    public long f49000d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49001e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f49000d == this.f49000d && aVar.f48999c.equals(this.f48999c) && aVar.f48998b.equals(this.f48998b) && aVar.f49001e == this.f49001e && aVar.f48997a == this.f48997a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f48997a + ",forumAvatar=" + this.f48998b + ",forumName=" + this.f48999c + ",forumId=" + this.f49000d + ",isLiked=" + this.f49001e + ",]";
    }
}
