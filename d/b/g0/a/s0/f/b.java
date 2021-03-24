package d.b.g0.a.s0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.b.g0.a.s0.f.a;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.s0.b<d.b.g0.a.s0.f.a> {

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0783a {
        public a() {
        }

        @Override // d.b.g0.a.s0.f.a.InterfaceC0783a
        public void a(Bundle bundle) {
            if (b.this.f45785b != null) {
                b.this.f45785b.onCallback(b.this, "onMediaMetadataExtracted", bundle);
            }
        }

        @Override // d.b.g0.a.s0.f.a.InterfaceC0783a
        public void onRelease() {
            if (b.this.f45785b != null) {
                b.this.f45785b = null;
            }
        }
    }

    public b(@NonNull d.b.g0.a.s0.f.a aVar) {
        super(aVar);
        ((d.b.g0.a.s0.f.a) this.f45786c).L(new a());
        this.f45784a.a(new d.b.g0.a.s0.f.d.a());
        this.f45784a.a(new d.b.g0.a.s0.f.d.b());
    }
}
