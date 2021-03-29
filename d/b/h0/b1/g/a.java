package d.b.h0.b1.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f49879a;

    /* renamed from: b  reason: collision with root package name */
    public String f49880b;

    /* renamed from: c  reason: collision with root package name */
    public String f49881c;

    /* renamed from: d  reason: collision with root package name */
    public long f49882d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49883e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f49882d == this.f49882d && aVar.f49881c.equals(this.f49881c) && aVar.f49880b.equals(this.f49880b) && aVar.f49883e == this.f49883e && aVar.f49879a == this.f49879a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f49879a + ",forumAvatar=" + this.f49880b + ",forumName=" + this.f49881c + ",forumId=" + this.f49882d + ",isLiked=" + this.f49883e + ",]";
    }
}
