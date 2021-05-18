package d.a.i0.a.l2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f43205a;

    /* renamed from: b  reason: collision with root package name */
    public String f43206b;

    /* renamed from: c  reason: collision with root package name */
    public String f43207c;

    /* renamed from: d  reason: collision with root package name */
    public String f43208d;

    /* renamed from: e  reason: collision with root package name */
    public long f43209e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43210f;

    /* renamed from: g  reason: collision with root package name */
    public long f43211g;

    /* renamed from: h  reason: collision with root package name */
    public long f43212h;

    /* renamed from: i  reason: collision with root package name */
    public int f43213i;

    /* renamed from: d.a.i0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0722a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int length = aVar2.f43206b.length() - aVar.f43206b.length();
            if (length != 0) {
                return length;
            }
            int length2 = aVar2.f43205a.length() - aVar.f43205a.length();
            if (length2 != 0) {
                return length2;
            }
            int hashCode = aVar2.f43207c.hashCode() - aVar.f43207c.hashCode();
            if (hashCode != 0) {
                return hashCode;
            }
            if (aVar2.f43208d == null) {
                return -1;
            }
            return aVar.f43208d == null ? 1 : 0;
        }
    }

    public a() {
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f43205a)) {
            if (!this.f43205a.startsWith(".")) {
                return str.equals(this.f43205a);
            }
            if (str.endsWith(this.f43205a.substring(1))) {
                int length = this.f43205a.length();
                int length2 = str.length();
                return length2 <= length + (-1) || str.charAt(length2 - length) == '.';
            }
        }
        return false;
    }

    public boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(this.f43205a) || TextUtils.isEmpty(this.f43206b) || TextUtils.isEmpty(this.f43207c) || !TextUtils.equals(this.f43205a, aVar.f43205a) || !TextUtils.equals(this.f43206b, aVar.f43206b) || !TextUtils.equals(this.f43207c, aVar.f43207c)) ? false : true;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f43206b) || !str.startsWith(this.f43206b)) {
            return false;
        }
        int length = this.f43206b.length();
        return this.f43206b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
    }

    @NonNull
    public String toString() {
        return "domain: " + this.f43205a + "; path: " + this.f43206b + "; name: " + this.f43207c + "; value: " + this.f43208d + "; expires: " + this.f43209e + "; secure: " + this.f43210f;
    }

    public a(String str, String str2) {
        this.f43205a = str;
        this.f43206b = str2;
        this.f43209e = -1L;
    }
}
