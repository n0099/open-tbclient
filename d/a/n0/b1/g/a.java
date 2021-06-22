package d.a.n0.b1.g;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f52803a;

    /* renamed from: b  reason: collision with root package name */
    public String f52804b;

    /* renamed from: c  reason: collision with root package name */
    public String f52805c;

    /* renamed from: d  reason: collision with root package name */
    public long f52806d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52807e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.f52806d == this.f52806d && aVar.f52805c.equals(this.f52805c) && aVar.f52804b.equals(this.f52804b) && aVar.f52807e == this.f52807e && aVar.f52803a == this.f52803a;
        }
        return false;
    }

    public String toString() {
        return "[HotForumInfoData:rank=" + this.f52803a + ",forumAvatar=" + this.f52804b + ",forumName=" + this.f52805c + ",forumId=" + this.f52806d + ",isLiked=" + this.f52807e + "," + PreferencesUtil.RIGHT_MOUNT;
    }
}
