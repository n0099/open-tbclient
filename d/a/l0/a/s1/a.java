package d.a.l0.a.s1;

import androidx.annotation.NonNull;
import d.a.l0.a.s1.g;
/* loaded from: classes3.dex */
public final class a implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f44666a;

    /* renamed from: b  reason: collision with root package name */
    public final f f44667b;

    public a(int i2, @NonNull f fVar) {
        this.f44666a = i2;
        this.f44667b = fVar;
    }

    @Override // d.a.l0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != this.f44666a) {
            this.f44667b.b(2, "request permission fail");
            return;
        }
        for (int i3 : iArr) {
            if (i3 == -1) {
                this.f44667b.b(1, "user denied");
                return;
            }
        }
        this.f44667b.a("permission granted successful");
    }
}
