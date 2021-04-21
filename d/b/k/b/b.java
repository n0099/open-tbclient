package d.b.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f64766a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f64767b;

    /* renamed from: c  reason: collision with root package name */
    public String f64768c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f64769a;

        /* renamed from: b  reason: collision with root package name */
        public File f64770b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f64771c;

        /* renamed from: d  reason: collision with root package name */
        public String f64772d;

        public b a() {
            return new b(this.f64772d, this.f64770b, this.f64771c, this.f64769a);
        }

        public a b(File file) {
            this.f64770b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f64771c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f64772d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f64768c = str;
        this.f64766a = file;
        this.f64767b = charSequence;
    }

    public File a() {
        return this.f64766a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f64767b)) {
            this.f64767b = d.b.k.b.d.b.a(c());
        }
        return this.f64767b;
    }

    public String c() {
        return this.f64768c;
    }
}
