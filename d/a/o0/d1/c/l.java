package d.a.o0.d1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f56410a;

    /* renamed from: b  reason: collision with root package name */
    public String f56411b;

    public void a(UserInfo userInfo) {
        this.f56410a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f56411b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f56410a == ((l) obj).f56410a;
    }

    public int hashCode() {
        long j = this.f56410a;
        return (int) (j ^ (j >>> 32));
    }
}
