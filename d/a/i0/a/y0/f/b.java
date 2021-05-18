package d.a.i0.a.y0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.i0.a.y0.f.a;
/* loaded from: classes.dex */
public class b extends d.a.i0.a.y0.b<d.a.i0.a.y0.f.a> {

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0900a {
        public a() {
        }

        @Override // d.a.i0.a.y0.f.a.InterfaceC0900a
        public void a(Bundle bundle) {
            if (b.this.f45598b != null) {
                b.this.f45598b.onCallback(b.this, "onMediaMetadataExtracted", bundle);
            }
        }

        @Override // d.a.i0.a.y0.f.a.InterfaceC0900a
        public void onRelease() {
            if (b.this.f45598b != null) {
                b.this.f45598b = null;
            }
        }
    }

    public b(@NonNull d.a.i0.a.y0.f.a aVar) {
        super(aVar);
        ((d.a.i0.a.y0.f.a) this.f45599c).x(new a());
        this.f45597a.a(new d.a.i0.a.y0.f.d.a());
        this.f45597a.a(new d.a.i0.a.y0.f.d.b());
    }
}
