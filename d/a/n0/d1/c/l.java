package d.a.n0.d1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f52596a;

    /* renamed from: b  reason: collision with root package name */
    public String f52597b;

    public void a(UserInfo userInfo) {
        this.f52596a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f52597b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f52596a == ((l) obj).f52596a;
    }

    public int hashCode() {
        long j = this.f52596a;
        return (int) (j ^ (j >>> 32));
    }
}
