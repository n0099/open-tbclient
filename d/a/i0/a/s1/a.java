package d.a.i0.a.s1;

import androidx.annotation.NonNull;
import d.a.i0.a.s1.g;
/* loaded from: classes3.dex */
public final class a implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f44490a;

    /* renamed from: b  reason: collision with root package name */
    public final f f44491b;

    public a(int i2, @NonNull f fVar) {
        this.f44490a = i2;
        this.f44491b = fVar;
    }

    @Override // d.a.i0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != this.f44490a) {
            this.f44491b.b(2, "request permission fail");
            return;
        }
        for (int i3 : iArr) {
            if (i3 == -1) {
                this.f44491b.b(1, "user denied");
                return;
            }
        }
        this.f44491b.a("permission granted successful");
    }
}
