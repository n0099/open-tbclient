package d.a.m0.a.v1.a.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public abstract class c implements a<d.a.m0.a.v1.a.b.a.b> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49065b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f49066a;

    @Override // d.a.m0.a.v1.a.b.c.a
    public String b() {
        if (!TextUtils.isEmpty(this.f49066a)) {
            return this.f49066a;
        }
        String str = System.currentTimeMillis() + "" + hashCode();
        this.f49066a = str;
        if (f49065b && d.a.m0.a.v1.a.b.d.a.a(str)) {
            throw new RuntimeException("illegal observer id");
        }
        return this.f49066a;
    }

    @Override // d.a.m0.a.v1.a.b.c.a
    public abstract /* synthetic */ void onEvent(@NonNull T t);
}
