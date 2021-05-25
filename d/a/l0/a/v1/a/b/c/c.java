package d.a.l0.a.v1.a.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public abstract class c implements a<d.a.l0.a.v1.a.b.a.b> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45283b = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f45284a;

    @Override // d.a.l0.a.v1.a.b.c.a
    public String b() {
        if (!TextUtils.isEmpty(this.f45284a)) {
            return this.f45284a;
        }
        String str = System.currentTimeMillis() + "" + hashCode();
        this.f45284a = str;
        if (f45283b && d.a.l0.a.v1.a.b.d.a.a(str)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.f45284a;
    }

    @Override // d.a.l0.a.v1.a.b.c.a
    public abstract /* synthetic */ void onEvent(@NonNull T t);
}
