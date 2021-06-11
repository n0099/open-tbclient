package d.a.l0.a.l2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47055a;

    /* renamed from: b  reason: collision with root package name */
    public String f47056b;

    /* renamed from: c  reason: collision with root package name */
    public String f47057c;

    /* renamed from: d  reason: collision with root package name */
    public String f47058d;

    /* renamed from: e  reason: collision with root package name */
    public long f47059e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47060f;

    /* renamed from: g  reason: collision with root package name */
    public long f47061g;

    /* renamed from: h  reason: collision with root package name */
    public long f47062h;

    /* renamed from: i  reason: collision with root package name */
    public int f47063i;

    /* renamed from: d.a.l0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0789a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int length = aVar2.f47056b.length() - aVar.f47056b.length();
            if (length != 0) {
                return length;
            }
            int length2 = aVar2.f47055a.length() - aVar.f47055a.length();
            if (length2 != 0) {
                return length2;
            }
            int hashCode = aVar2.f47057c.hashCode() - aVar.f47057c.hashCode();
            if (hashCode != 0) {
                return hashCode;
            }
            if (aVar2.f47058d == null) {
                return -1;
            }
            return aVar.f47058d == null ? 1 : 0;
        }
    }

    public a() {
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f47055a)) {
            if (!this.f47055a.startsWith(".")) {
                return str.equals(this.f47055a);
            }
            if (str.endsWith(this.f47055a.substring(1))) {
                int length = this.f47055a.length();
                int length2 = str.length();
                return length2 <= length + (-1) || str.charAt(length2 - length) == '.';
            }
        }
        return false;
    }

    public boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(this.f47055a) || TextUtils.isEmpty(this.f47056b) || TextUtils.isEmpty(this.f47057c) || !TextUtils.equals(this.f47055a, aVar.f47055a) || !TextUtils.equals(this.f47056b, aVar.f47056b) || !TextUtils.equals(this.f47057c, aVar.f47057c)) ? false : true;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f47056b) || !str.startsWith(this.f47056b)) {
            return false;
        }
        int length = this.f47056b.length();
        return this.f47056b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
    }

    @NonNull
    public String toString() {
        return "domain: " + this.f47055a + "; path: " + this.f47056b + "; name: " + this.f47057c + "; value: " + this.f47058d + "; expires: " + this.f47059e + "; secure: " + this.f47060f;
    }

    public a(String str, String str2) {
        this.f47055a = str;
        this.f47056b = str2;
        this.f47059e = -1L;
    }
}
