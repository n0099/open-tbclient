package d.b.j0.c1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f53954a;

    /* renamed from: b  reason: collision with root package name */
    public String f53955b;

    public void a(UserInfo userInfo) {
        this.f53954a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f53955b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f53954a == ((l) obj).f53954a;
    }

    public int hashCode() {
        long j = this.f53954a;
        return (int) (j ^ (j >>> 32));
    }
}
