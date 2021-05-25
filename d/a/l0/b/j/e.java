package d.a.l0.b.j;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.l0.b.l.b;
/* loaded from: classes3.dex */
public class e extends d.a.l0.a.v1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements b.c {
        public a() {
        }

        @Override // d.a.l0.b.l.b.c
        public void a(String str) {
            e.this.f45272d.putString("result", str);
            e.this.c();
        }
    }

    @Override // d.a.l0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        d.a.l0.b.j.a.n(bundle.getString("key_result_client_id"), bundle.getStringArrayList("key_param_tpl_list"), new a());
    }
}
