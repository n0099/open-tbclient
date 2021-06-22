package d.b.c.b.d;

import android.text.TextUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f69573a;

    /* renamed from: b  reason: collision with root package name */
    public final String f69574b;

    public a(String str, String str2) {
        this.f69573a = str;
        this.f69574b = str2;
    }

    public final String a() {
        return this.f69573a;
    }

    public final String b() {
        return this.f69574b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f69573a, aVar.f69573a) && TextUtils.equals(this.f69574b, aVar.f69574b);
    }

    public int hashCode() {
        return (this.f69573a.hashCode() * 31) + this.f69574b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f69573a + ",value=" + this.f69574b + PreferencesUtil.RIGHT_MOUNT;
    }
}
