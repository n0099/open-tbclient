package d.b.h0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f50272a;

    /* renamed from: b  reason: collision with root package name */
    public String f50273b;

    /* renamed from: c  reason: collision with root package name */
    public String f50274c;

    /* renamed from: d  reason: collision with root package name */
    public long f50275d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50276e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f50275d == this.f50275d && aVar.f50274c.equals(this.f50274c) && aVar.f50273b.equals(this.f50273b) && aVar.f50276e == this.f50276e && aVar.f50272a == this.f50272a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f50272a + ",forumAvatar=" + this.f50273b + ",forumName=" + this.f50274c + ",forumId=" + this.f50275d + ",isLiked=" + this.f50276e + ",]";
    }
}
