package d.b.i0.c1.c;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public long f53533a;

    /* renamed from: b  reason: collision with root package name */
    public String f53534b;

    public void a(UserInfo userInfo) {
        this.f53533a = userInfo.user_id.longValue();
        String str = userInfo.user_name;
        this.f53534b = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && l.class == obj.getClass() && this.f53533a == ((l) obj).f53533a;
    }

    public int hashCode() {
        long j = this.f53533a;
        return (int) (j ^ (j >>> 32));
    }
}
