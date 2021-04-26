package d.a.j0.c1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f51717a;

    /* renamed from: b  reason: collision with root package name */
    public String f51718b;

    public void a(UserInfo userInfo) {
        this.f51717a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f51718b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f51717a == ((l) obj).f51717a;
    }

    public int hashCode() {
        long j = this.f51717a;
        return (int) (j ^ (j >>> 32));
    }
}
