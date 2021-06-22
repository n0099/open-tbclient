package d.a.m0.a.y0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.m0.a.y0.f.a;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.y0.b<d.a.m0.a.y0.f.a> {

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0970a {
        public a() {
        }

        @Override // d.a.m0.a.y0.f.a.InterfaceC0970a
        public void a(Bundle bundle) {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onMediaMetadataExtracted", bundle);
            }
        }

        @Override // d.a.m0.a.y0.f.a.InterfaceC0970a
        public void onRelease() {
            if (b.this.f49556b != null) {
                b.this.f49556b = null;
            }
        }
    }

    public b(@NonNull d.a.m0.a.y0.f.a aVar) {
        super(aVar);
        ((d.a.m0.a.y0.f.a) this.f49557c).w(new a());
        this.f49555a.a(new d.a.m0.a.y0.f.d.a());
        this.f49555a.a(new d.a.m0.a.y0.f.d.b());
    }
}
