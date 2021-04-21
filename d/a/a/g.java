package d.a.a;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f41575a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41576b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41577c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41578d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41579e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f41580f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f41575a = i;
        this.f41576b = i2;
        this.f41577c = str;
        this.f41578d = str2;
        this.f41579e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f41580f;
    }

    public String b() {
        return this.f41579e;
    }

    public String c() {
        return this.f41578d;
    }

    public int d() {
        return this.f41576b;
    }

    public String e() {
        return this.f41577c;
    }

    public int f() {
        return this.f41575a;
    }

    public void g(@Nullable Bitmap bitmap) {
        this.f41580f = bitmap;
    }
}
