package d.a.h0.b.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class g extends d.a.h0.a.n1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<Bundle> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            g.this.f43404d.putBundle("key_result_stokent", bundle);
            g.this.c();
        }
    }

    @Override // d.a.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String[] stringArray = bundle.getStringArray("key_param_tpl_list");
        if (stringArray != null && stringArray.length >= 1) {
            d.a.h0.b.i.a.u(AppRuntime.getAppContext(), new a(), stringArray);
        } else {
            c();
        }
    }
}
