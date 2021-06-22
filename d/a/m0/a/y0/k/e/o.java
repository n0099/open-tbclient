package d.a.m0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class o extends d.a.m0.a.y0.a<d.a.m0.a.y0.k.g.a> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "setDataSource";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.k.g.a aVar) {
        Object obj = command.obj;
        if (obj == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        boolean z = command.arg1 != 0;
        String str = (String) arrayList.get(0);
        String f2 = d.a.m0.a.l2.b.l().f(str, (String) arrayList.get(1));
        command.ret = aVar.O(str, f2, (String) arrayList.get(2), z) ? 1 : 0;
        String str2 = command.what;
        d(aVar, str2, "DataSource: " + str + " ;UserAgent: " + ((String) arrayList.get(2)) + " ;Cookies: " + f2 + ";hideUrlLog: " + z, true);
    }
}
