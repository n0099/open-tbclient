package d.b.h0.b.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.b.h0.b.k.b;
/* loaded from: classes3.dex */
public class e extends d.b.h0.a.n1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements b.c {
        public a() {
        }

        @Override // d.b.h0.b.k.b.c
        public void a(String str) {
            e.this.f46061d.putString("result", str);
            e.this.c();
        }
    }

    @Override // d.b.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        d.b.h0.b.i.a.n(bundle.getString("key_result_client_id"), bundle.getStringArrayList("key_param_tpl_list"), new a());
    }
}
