package d.a.k0.c1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f52416a;

    /* renamed from: b  reason: collision with root package name */
    public String f52417b;

    public void a(UserInfo userInfo) {
        this.f52416a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f52417b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f52416a == ((l) obj).f52416a;
    }

    public int hashCode() {
        long j = this.f52416a;
        return (int) (j ^ (j >>> 32));
    }
}
