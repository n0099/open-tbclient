package d.a.l0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f43618a = {d.a.l0.a.c1.a.b().getDatabasePath("ai_apps.db").getAbsolutePath(), d.a.l0.a.c1.a.b().getDatabasePath("ai_apps_pms.db").getAbsolutePath()};

    @Override // d.a.l0.a.n0.j.d.a
    public ArraySet<String> a() {
        ArraySet<String> arraySet = new ArraySet<>();
        for (String str : this.f43618a) {
            String J = d.a.l0.t.d.J(str);
            if (!TextUtils.isEmpty(J)) {
                arraySet.add(J);
            }
        }
        d.a.l0.a.e0.d.h("SwanDatabaseCollector", "recovery renameAllFiles:" + arraySet.toString());
        return arraySet;
    }
}
