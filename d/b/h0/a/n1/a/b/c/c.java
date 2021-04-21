package d.b.h0.a.n1.a.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public abstract class c implements a<d.b.h0.a.n1.a.b.a.b> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46072b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f46073a;

    @Override // d.b.h0.a.n1.a.b.c.a
    public String b() {
        if (!TextUtils.isEmpty(this.f46073a)) {
            return this.f46073a;
        }
        String str = System.currentTimeMillis() + "" + hashCode();
        this.f46073a = str;
        if (f46072b && d.b.h0.a.n1.a.b.d.a.a(str)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.f46073a;
    }

    @Override // d.b.h0.a.n1.a.b.c.a
    public abstract /* synthetic */ void onEvent(@NonNull T t);
}
