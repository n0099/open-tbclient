package d.b.g0.a.s0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.b.g0.a.s0.f.a;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.s0.b<d.b.g0.a.s0.f.a> {

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0796a {
        public a() {
        }

        @Override // d.b.g0.a.s0.f.a.InterfaceC0796a
        public void a(Bundle bundle) {
            if (b.this.f46178b != null) {
                b.this.f46178b.onCallback(b.this, "onMediaMetadataExtracted", bundle);
            }
        }

        @Override // d.b.g0.a.s0.f.a.InterfaceC0796a
        public void onRelease() {
            if (b.this.f46178b != null) {
                b.this.f46178b = null;
            }
        }
    }

    public b(@NonNull d.b.g0.a.s0.f.a aVar) {
        super(aVar);
        ((d.b.g0.a.s0.f.a) this.f46179c).L(new a());
        this.f46177a.a(new d.b.g0.a.s0.f.d.a());
        this.f46177a.a(new d.b.g0.a.s0.f.d.b());
    }
}
