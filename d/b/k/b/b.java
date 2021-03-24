package d.b.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f63849a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f63850b;

    /* renamed from: c  reason: collision with root package name */
    public String f63851c;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f63852a;

        /* renamed from: b  reason: collision with root package name */
        public File f63853b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f63854c;

        /* renamed from: d  reason: collision with root package name */
        public String f63855d;

        public b a() {
            return new b(this.f63855d, this.f63853b, this.f63854c, this.f63852a);
        }

        public a b(File file) {
            this.f63853b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f63854c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f63855d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f63851c = str;
        this.f63849a = file;
        this.f63850b = charSequence;
    }

    public File a() {
        return this.f63849a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f63850b)) {
            this.f63850b = d.b.k.b.d.b.a(c());
        }
        return this.f63850b;
    }

    public String c() {
        return this.f63851c;
    }
}
