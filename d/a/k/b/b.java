package d.a.k.b;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public File f44209a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f44210b;

    /* renamed from: c  reason: collision with root package name */
    public String f44211c;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f44212a;

        /* renamed from: b  reason: collision with root package name */
        public File f44213b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f44214c;

        /* renamed from: d  reason: collision with root package name */
        public String f44215d;

        public b a() {
            return new b(this.f44215d, this.f44213b, this.f44214c, this.f44212a);
        }

        public a b(File file) {
            this.f44213b = file;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f44214c = charSequence;
            return this;
        }

        public a d(String str) {
            this.f44215d = str;
            return this;
        }
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.f44211c = str;
        this.f44209a = file;
        this.f44210b = charSequence;
    }

    public File a() {
        return this.f44209a;
    }

    public CharSequence b() {
        if (TextUtils.isEmpty(this.f44210b)) {
            this.f44210b = d.a.k.b.d.b.a(c());
        }
        return this.f44210b;
    }

    public String c() {
        return this.f44211c;
    }
}
