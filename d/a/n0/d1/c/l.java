package d.a.n0.d1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f56285a;

    /* renamed from: b  reason: collision with root package name */
    public String f56286b;

    public void a(UserInfo userInfo) {
        this.f56285a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f56286b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f56285a == ((l) obj).f56285a;
    }

    public int hashCode() {
        long j = this.f56285a;
        return (int) (j ^ (j >>> 32));
    }
}
