package d.b.h0.a.p.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.p.c.u0;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class z implements u0 {

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final z f46163a = new z();
    }

    public static z c() {
        return b.f46163a;
    }

    @Override // d.b.h0.a.p.c.u0
    public d.b.h0.p.b a(Context context, String str, boolean z) {
        return new d.b.h0.p.i(str);
    }

    @Override // d.b.h0.a.p.c.u0
    public void b(@NonNull String str, Set<String> set, boolean z) {
        d.b.h0.a.j0.d.b(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ActivityChooserModel.HISTORY_FILE_EXTENSION, set, z);
    }

    public z() {
    }
}
