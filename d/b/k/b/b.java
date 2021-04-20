package d.b.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f64550a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f64551b;

    /* renamed from: c  reason: collision with root package name */
    public String f64552c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f64553a;

        /* renamed from: b  reason: collision with root package name */
        public File f64554b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f64555c;

        /* renamed from: d  reason: collision with root package name */
        public String f64556d;

        public b a() {
            return new b(this.f64556d, this.f64554b, this.f64555c, this.f64553a);
        }

        public a b(File file) {
            this.f64554b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f64555c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f64556d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f64552c = str;
        this.f64550a = file;
        this.f64551b = charSequence;
    }

    public File a() {
        return this.f64550a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f64551b)) {
            this.f64551b = d.b.k.b.d.b.a(c());
        }
        return this.f64551b;
    }

    public String c() {
        return this.f64552c;
    }
}
