package d.a.m0.a.l2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47163a;

    /* renamed from: b  reason: collision with root package name */
    public String f47164b;

    /* renamed from: c  reason: collision with root package name */
    public String f47165c;

    /* renamed from: d  reason: collision with root package name */
    public String f47166d;

    /* renamed from: e  reason: collision with root package name */
    public long f47167e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47168f;

    /* renamed from: g  reason: collision with root package name */
    public long f47169g;

    /* renamed from: h  reason: collision with root package name */
    public long f47170h;

    /* renamed from: i  reason: collision with root package name */
    public int f47171i;

    /* renamed from: d.a.m0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0792a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int length = aVar2.f47164b.length() - aVar.f47164b.length();
            if (length != 0) {
                return length;
            }
            int length2 = aVar2.f47163a.length() - aVar.f47163a.length();
            if (length2 != 0) {
                return length2;
            }
            int hashCode = aVar2.f47165c.hashCode() - aVar.f47165c.hashCode();
            if (hashCode != 0) {
                return hashCode;
            }
            if (aVar2.f47166d == null) {
                return -1;
            }
            return aVar.f47166d == null ? 1 : 0;
        }
    }

    public a() {
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f47163a)) {
            if (!this.f47163a.startsWith(".")) {
                return str.equals(this.f47163a);
            }
            if (str.endsWith(this.f47163a.substring(1))) {
                int length = this.f47163a.length();
                int length2 = str.length();
                return length2 <= length + (-1) || str.charAt(length2 - length) == '.';
            }
        }
        return false;
    }

    public boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(this.f47163a) || TextUtils.isEmpty(this.f47164b) || TextUtils.isEmpty(this.f47165c) || !TextUtils.equals(this.f47163a, aVar.f47163a) || !TextUtils.equals(this.f47164b, aVar.f47164b) || !TextUtils.equals(this.f47165c, aVar.f47165c)) ? false : true;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f47164b) || !str.startsWith(this.f47164b)) {
            return false;
        }
        int length = this.f47164b.length();
        return this.f47164b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
    }

    @NonNull
    public String toString() {
        return "domain: " + this.f47163a + "; path: " + this.f47164b + "; name: " + this.f47165c + "; value: " + this.f47166d + "; expires: " + this.f47167e + "; secure: " + this.f47168f;
    }

    public a(String str, String str2) {
        this.f47163a = str;
        this.f47164b = str2;
        this.f47167e = -1L;
    }
}
