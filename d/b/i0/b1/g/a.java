package d.b.i0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f50608a;

    /* renamed from: b  reason: collision with root package name */
    public String f50609b;

    /* renamed from: c  reason: collision with root package name */
    public String f50610c;

    /* renamed from: d  reason: collision with root package name */
    public long f50611d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50612e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f50611d == this.f50611d && aVar.f50610c.equals(this.f50610c) && aVar.f50609b.equals(this.f50609b) && aVar.f50612e == this.f50612e && aVar.f50608a == this.f50608a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f50608a + ",forumAvatar=" + this.f50609b + ",forumName=" + this.f50610c + ",forumId=" + this.f50611d + ",isLiked=" + this.f50612e + ",]";
    }
}
