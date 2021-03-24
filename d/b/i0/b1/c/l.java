package d.b.i0.b1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f52131a;

    /* renamed from: b  reason: collision with root package name */
    public String f52132b;

    public void a(UserInfo userInfo) {
        this.f52131a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f52132b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f52131a == ((l) obj).f52131a;
    }

    public int hashCode() {
        long j = this.f52131a;
        return (int) (j ^ (j >>> 32));
    }
}
