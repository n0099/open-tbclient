package d.a.i0.a.v1.a.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public abstract class c implements a<d.a.i0.a.v1.a.b.a.b> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45107b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f45108a;

    @Override // d.a.i0.a.v1.a.b.c.a
    public String b() {
        if (!TextUtils.isEmpty(this.f45108a)) {
            return this.f45108a;
        }
        String str = System.currentTimeMillis() + "" + hashCode();
        this.f45108a = str;
        if (f45107b && d.a.i0.a.v1.a.b.d.a.a(str)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.f45108a;
    }

    @Override // d.a.i0.a.v1.a.b.c.a
    public abstract /* synthetic */ void onEvent(@NonNull T t);
}
