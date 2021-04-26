package d.a.h0.a.s0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.h0.a.s0.f.a;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.s0.b<d.a.h0.a.s0.f.a> {

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0755a {
        public a() {
        }

        @Override // d.a.h0.a.s0.f.a.InterfaceC0755a
        public void a(Bundle bundle) {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onMediaMetadataExtracted", bundle);
            }
        }

        @Override // d.a.h0.a.s0.f.a.InterfaceC0755a
        public void onRelease() {
            if (b.this.f43872b != null) {
                b.this.f43872b = null;
            }
        }
    }

    public b(@NonNull d.a.h0.a.s0.f.a aVar) {
        super(aVar);
        ((d.a.h0.a.s0.f.a) this.f43873c).w(new a());
        this.f43871a.a(new d.a.h0.a.s0.f.d.a());
        this.f43871a.a(new d.a.h0.a.s0.f.d.b());
    }
}
