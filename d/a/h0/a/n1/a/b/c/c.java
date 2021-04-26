package d.a.h0.a.n1.a.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public abstract class c implements a<d.a.h0.a.n1.a.b.a.b> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43415b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f43416a;

    @Override // d.a.h0.a.n1.a.b.c.a
    public String b() {
        if (!TextUtils.isEmpty(this.f43416a)) {
            return this.f43416a;
        }
        String str = System.currentTimeMillis() + "" + hashCode();
        this.f43416a = str;
        if (f43415b && d.a.h0.a.n1.a.b.d.a.a(str)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.f43416a;
    }

    @Override // d.a.h0.a.n1.a.b.c.a
    public abstract /* synthetic */ void onEvent(@NonNull T t);
}
