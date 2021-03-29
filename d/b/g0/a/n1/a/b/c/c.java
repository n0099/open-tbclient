package d.b.g0.a.n1.a.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public abstract class c implements a<d.b.g0.a.n1.a.b.a.b> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45351b = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f45352a;

    @Override // d.b.g0.a.n1.a.b.c.a
    public String b() {
        if (!TextUtils.isEmpty(this.f45352a)) {
            return this.f45352a;
        }
        String str = System.currentTimeMillis() + "" + hashCode();
        this.f45352a = str;
        if (f45351b && d.b.g0.a.n1.a.b.d.a.a(str)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.f45352a;
    }

    @Override // d.b.g0.a.n1.a.b.c.a
    public abstract /* synthetic */ void onEvent(@NonNull T t);
}
