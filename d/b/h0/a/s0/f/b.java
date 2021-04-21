package d.b.h0.a.s0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.b.h0.a.s0.f.a;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.s0.b<d.b.h0.a.s0.f.a> {

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0816a {
        public a() {
        }

        @Override // d.b.h0.a.s0.f.a.InterfaceC0816a
        public void a(Bundle bundle) {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onMediaMetadataExtracted", bundle);
            }
        }

        @Override // d.b.h0.a.s0.f.a.InterfaceC0816a
        public void onRelease() {
            if (b.this.f46507b != null) {
                b.this.f46507b = null;
            }
        }
    }

    public b(@NonNull d.b.h0.a.s0.f.a aVar) {
        super(aVar);
        ((d.b.h0.a.s0.f.a) this.f46508c).L(new a());
        this.f46506a.a(new d.b.h0.a.s0.f.d.a());
        this.f46506a.a(new d.b.h0.a.s0.f.d.b());
    }
}
