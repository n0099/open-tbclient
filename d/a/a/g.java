package d.a.a;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f41176a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41177b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41178c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f41179d;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f41176a = str;
        this.f41177b = str2;
        this.f41178c = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f41179d;
    }

    public String b() {
        return this.f41178c;
    }

    public String c() {
        return this.f41177b;
    }

    public String d() {
        return this.f41176a;
    }

    public void e(@Nullable Bitmap bitmap) {
        this.f41179d = bitmap;
    }
}
