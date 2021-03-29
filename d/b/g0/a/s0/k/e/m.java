package d.b.g0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class m extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "setDataSource";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.k.g.a aVar) {
        Object obj = command.obj;
        if (obj == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        command.ret = aVar.n((String) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), command.arg1 != 0) ? 1 : 0;
        String str = command.what;
        d(aVar, str, "DataSource: " + ((String) arrayList.get(0)) + " ;UserAgent: " + ((String) arrayList.get(1)) + " ;Cookies: " + ((String) arrayList.get(2)), false);
    }
}
