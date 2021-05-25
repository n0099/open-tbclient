package d.a.l0.a.y0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.l0.a.y0.f.a;
/* loaded from: classes3.dex */
public class b extends d.a.l0.a.y0.b<d.a.l0.a.y0.f.a> {

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0911a {
        public a() {
        }

        @Override // d.a.l0.a.y0.f.a.InterfaceC0911a
        public void a(Bundle bundle) {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onMediaMetadataExtracted", bundle);
            }
        }

        @Override // d.a.l0.a.y0.f.a.InterfaceC0911a
        public void onRelease() {
            if (b.this.f45774b != null) {
                b.this.f45774b = null;
            }
        }
    }

    public b(@NonNull d.a.l0.a.y0.f.a aVar) {
        super(aVar);
        ((d.a.l0.a.y0.f.a) this.f45775c).x(new a());
        this.f45773a.a(new d.a.l0.a.y0.f.d.a());
        this.f45773a.a(new d.a.l0.a.y0.f.d.b());
    }
}
