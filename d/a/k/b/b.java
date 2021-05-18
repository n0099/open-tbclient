package d.a.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f51041a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f51042b;

    /* renamed from: c  reason: collision with root package name */
    public String f51043c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f51044a;

        /* renamed from: b  reason: collision with root package name */
        public File f51045b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f51046c;

        /* renamed from: d  reason: collision with root package name */
        public String f51047d;

        public b a() {
            return new b(this.f51047d, this.f51045b, this.f51046c, this.f51044a);
        }

        public a b(File file) {
            this.f51045b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f51046c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f51047d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f51043c = str;
        this.f51041a = file;
        this.f51042b = charSequence;
    }

    public File a() {
        return this.f51041a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f51042b)) {
            this.f51042b = d.a.k.b.d.b.a(c());
        }
        return this.f51042b;
    }

    public String c() {
        return this.f51043c;
    }
}
