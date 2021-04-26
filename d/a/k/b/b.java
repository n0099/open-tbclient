package d.a.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f63056a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f63057b;

    /* renamed from: c  reason: collision with root package name */
    public String f63058c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f63059a;

        /* renamed from: b  reason: collision with root package name */
        public File f63060b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f63061c;

        /* renamed from: d  reason: collision with root package name */
        public String f63062d;

        public b a() {
            return new b(this.f63062d, this.f63060b, this.f63061c, this.f63059a);
        }

        public a b(File file) {
            this.f63060b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f63061c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f63062d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f63058c = str;
        this.f63056a = file;
        this.f63057b = charSequence;
    }

    public File a() {
        return this.f63056a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f63057b)) {
            this.f63057b = d.a.k.b.d.b.a(c());
        }
        return this.f63057b;
    }

    public String c() {
        return this.f63058c;
    }
}
