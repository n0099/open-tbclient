package d.a.a;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f41480a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41481b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41482c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41483d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41484e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f41485f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f41480a = i;
        this.f41481b = i2;
        this.f41482c = str;
        this.f41483d = str2;
        this.f41484e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f41485f;
    }

    public String b() {
        return this.f41484e;
    }

    public String c() {
        return this.f41483d;
    }

    public int d() {
        return this.f41481b;
    }

    public String e() {
        return this.f41482c;
    }

    public int f() {
        return this.f41480a;
    }

    public void g(@Nullable Bitmap bitmap) {
        this.f41485f = bitmap;
    }
}
