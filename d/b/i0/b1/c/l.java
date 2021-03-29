package d.b.i0.b1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f52132a;

    /* renamed from: b  reason: collision with root package name */
    public String f52133b;

    public void a(UserInfo userInfo) {
        this.f52132a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f52133b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f52132a == ((l) obj).f52132a;
    }

    public int hashCode() {
        long j = this.f52132a;
        return (int) (j ^ (j >>> 32));
    }
}
