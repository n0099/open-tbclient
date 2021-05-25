package d.a.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f40533a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f40534b;

    /* renamed from: c  reason: collision with root package name */
    public String f40535c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f40536a;

        /* renamed from: b  reason: collision with root package name */
        public File f40537b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f40538c;

        /* renamed from: d  reason: collision with root package name */
        public String f40539d;

        public b a() {
            return new b(this.f40539d, this.f40537b, this.f40538c, this.f40536a);
        }

        public a b(File file) {
            this.f40537b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f40538c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f40539d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f40535c = str;
        this.f40533a = file;
        this.f40534b = charSequence;
    }

    public File a() {
        return this.f40533a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f40534b)) {
            this.f40534b = d.a.k.b.d.b.a(c());
        }
        return this.f40534b;
    }

    public String c() {
        return this.f40535c;
    }
}
