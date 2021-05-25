package d.a.l0.a.y0.f.d;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.y0.a<d.a.l0.a.y0.f.a> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "extractMediaMetadata";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.f.a aVar) {
        Object obj = command.obj;
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.size() < 4) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", (String) arrayList.get(1));
            hashMap.put("User-Agent", (String) arrayList.get(2));
            hashMap.put("Referer", (String) arrayList.get(3));
            aVar.k((String) arrayList.get(0), hashMap);
        }
    }
}
