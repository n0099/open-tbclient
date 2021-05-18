package d.a.i0.b.j;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class g extends d.a.i0.a.v1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<Bundle> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            g.this.f45096d.putBundle("key_result_stokent", bundle);
            g.this.c();
        }
    }

    @Override // d.a.i0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String[] stringArray = bundle.getStringArray("key_param_tpl_list");
        if (stringArray != null && stringArray.length >= 1) {
            d.a.i0.b.j.a.u(AppRuntime.getAppContext(), new a(), stringArray);
        } else {
            c();
        }
    }
}
