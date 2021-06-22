package d.a.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f44050a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f44051b;

    /* renamed from: c  reason: collision with root package name */
    public String f44052c;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f44053a;

        /* renamed from: b  reason: collision with root package name */
        public File f44054b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f44055c;

        /* renamed from: d  reason: collision with root package name */
        public String f44056d;

        public b a() {
            return new b(this.f44056d, this.f44054b, this.f44055c, this.f44053a);
        }

        public a b(File file) {
            this.f44054b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f44055c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f44056d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f44052c = str;
        this.f44050a = file;
        this.f44051b = charSequence;
    }

    public File a() {
        return this.f44050a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f44051b)) {
            this.f44051b = d.a.k.b.d.b.a(c());
        }
        return this.f44051b;
    }

    public String c() {
        return this.f44052c;
    }
}
