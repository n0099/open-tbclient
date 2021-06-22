package d.a.m0.a.y0.g.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes3.dex */
public class e extends d.a.m0.a.y0.a<d.a.m0.a.y0.g.h.b> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "enableLocalMirror";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (TextUtils.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2)) {
                bVar.j0(str2);
            } else if (TextUtils.equals(com.baidu.fsg.face.base.b.c.l, str2)) {
                bVar.j0(str2);
            } else if (TextUtils.equals(PackageTable.DISABLE, str2)) {
                bVar.j0(str2);
            }
        }
    }
}
