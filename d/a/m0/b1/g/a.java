package d.a.m0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f52696a;

    /* renamed from: b  reason: collision with root package name */
    public String f52697b;

    /* renamed from: c  reason: collision with root package name */
    public String f52698c;

    /* renamed from: d  reason: collision with root package name */
    public long f52699d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52700e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f52699d == this.f52699d && aVar.f52698c.equals(this.f52698c) && aVar.f52697b.equals(this.f52697b) && aVar.f52700e == this.f52700e && aVar.f52696a == this.f52696a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f52696a + ",forumAvatar=" + this.f52697b + ",forumName=" + this.f52698c + ",forumId=" + this.f52699d + ",isLiked=" + this.f52700e + ",]";
    }
}
