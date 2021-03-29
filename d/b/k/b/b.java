package d.b.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f63850a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f63851b;

    /* renamed from: c  reason: collision with root package name */
    public String f63852c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f63853a;

        /* renamed from: b  reason: collision with root package name */
        public File f63854b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f63855c;

        /* renamed from: d  reason: collision with root package name */
        public String f63856d;

        public b a() {
            return new b(this.f63856d, this.f63854b, this.f63855c, this.f63853a);
        }

        public a b(File file) {
            this.f63854b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f63855c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f63856d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f63852c = str;
        this.f63850a = file;
        this.f63851b = charSequence;
    }

    public File a() {
        return this.f63850a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f63851b)) {
            this.f63851b = d.b.k.b.d.b.a(c());
        }
        return this.f63851b;
    }

    public String c() {
        return this.f63852c;
    }
}
