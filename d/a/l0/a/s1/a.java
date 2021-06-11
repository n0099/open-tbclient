package d.a.l0.a.s1;

import androidx.annotation.NonNull;
import d.a.l0.a.s1.g;
/* loaded from: classes3.dex */
public final class a implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f48340a;

    /* renamed from: b  reason: collision with root package name */
    public final f f48341b;

    public a(int i2, @NonNull f fVar) {
        this.f48340a = i2;
        this.f48341b = fVar;
    }

    @Override // d.a.l0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != this.f48340a) {
            this.f48341b.b(2, "request permission fail");
            return;
        }
        for (int i3 : iArr) {
            if (i3 == -1) {
                this.f48341b.b(1, "user denied");
                return;
            }
        }
        this.f48341b.a("permission granted successful");
    }
}
