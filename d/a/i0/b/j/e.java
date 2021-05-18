package d.a.i0.b.j;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.i0.b.l.b;
/* loaded from: classes3.dex */
public class e extends d.a.i0.a.v1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements b.c {
        public a() {
        }

        @Override // d.a.i0.b.l.b.c
        public void a(String str) {
            e.this.f45096d.putString("result", str);
            e.this.c();
        }
    }

    @Override // d.a.i0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        d.a.i0.b.j.a.n(bundle.getString("key_result_client_id"), bundle.getStringArrayList("key_param_tpl_list"), new a());
    }
}
