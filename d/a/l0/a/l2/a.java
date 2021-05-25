package d.a.l0.a.l2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f43379a;

    /* renamed from: b  reason: collision with root package name */
    public String f43380b;

    /* renamed from: c  reason: collision with root package name */
    public String f43381c;

    /* renamed from: d  reason: collision with root package name */
    public String f43382d;

    /* renamed from: e  reason: collision with root package name */
    public long f43383e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43384f;

    /* renamed from: g  reason: collision with root package name */
    public long f43385g;

    /* renamed from: h  reason: collision with root package name */
    public long f43386h;

    /* renamed from: i  reason: collision with root package name */
    public int f43387i;

    /* renamed from: d.a.l0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0733a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int length = aVar2.f43380b.length() - aVar.f43380b.length();
            if (length != 0) {
                return length;
            }
            int length2 = aVar2.f43379a.length() - aVar.f43379a.length();
            if (length2 != 0) {
                return length2;
            }
            int hashCode = aVar2.f43381c.hashCode() - aVar.f43381c.hashCode();
            if (hashCode != 0) {
                return hashCode;
            }
            if (aVar2.f43382d == null) {
                return -1;
            }
            return aVar.f43382d == null ? 1 : 0;
        }
    }

    public a() {
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f43379a)) {
            if (!this.f43379a.startsWith(".")) {
                return str.equals(this.f43379a);
            }
            if (str.endsWith(this.f43379a.substring(1))) {
                int length = this.f43379a.length();
                int length2 = str.length();
                return length2 <= length + (-1) || str.charAt(length2 - length) == '.';
            }
        }
        return false;
    }

    public boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(this.f43379a) || TextUtils.isEmpty(this.f43380b) || TextUtils.isEmpty(this.f43381c) || !TextUtils.equals(this.f43379a, aVar.f43379a) || !TextUtils.equals(this.f43380b, aVar.f43380b) || !TextUtils.equals(this.f43381c, aVar.f43381c)) ? false : true;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f43380b) || !str.startsWith(this.f43380b)) {
            return false;
        }
        int length = this.f43380b.length();
        return this.f43380b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
    }

    @NonNull
    public String toString() {
        return "domain: " + this.f43379a + "; path: " + this.f43380b + "; name: " + this.f43381c + "; value: " + this.f43382d + "; expires: " + this.f43383e + "; secure: " + this.f43384f;
    }

    public a(String str, String str2) {
        this.f43379a = str;
        this.f43380b = str2;
        this.f43383e = -1L;
    }
}
