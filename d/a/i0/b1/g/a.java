package d.a.i0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f48169a;

    /* renamed from: b  reason: collision with root package name */
    public String f48170b;

    /* renamed from: c  reason: collision with root package name */
    public String f48171c;

    /* renamed from: d  reason: collision with root package name */
    public long f48172d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48173e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f48172d == this.f48172d && aVar.f48171c.equals(this.f48171c) && aVar.f48170b.equals(this.f48170b) && aVar.f48173e == this.f48173e && aVar.f48169a == this.f48169a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f48169a + ",forumAvatar=" + this.f48170b + ",forumName=" + this.f48171c + ",forumId=" + this.f48172d + ",isLiked=" + this.f48173e + ",]";
    }
}
