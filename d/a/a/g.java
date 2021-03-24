package d.a.a;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f41175a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41176b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41177c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f41178d;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f41175a = str;
        this.f41176b = str2;
        this.f41177c = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f41178d;
    }

    public String b() {
        return this.f41177c;
    }

    public String c() {
        return this.f41176b;
    }

    public String d() {
        return this.f41175a;
    }

    public void e(@Nullable Bitmap bitmap) {
        this.f41178d = bitmap;
    }
}
