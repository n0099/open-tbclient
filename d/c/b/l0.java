package d.c.b;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<WeakReference<b>> f65032a = new ArrayList<>(4);

    @Override // d.c.b.b
    public synchronized void a(String str, String str2, String str3) {
        Iterator<WeakReference<b>> it = f65032a.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.a(str, str2, str3);
            }
        }
    }

    @Override // d.c.b.b
    public synchronized void b(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<b>> it = f65032a.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.b(z, jSONObject);
            }
        }
    }

    @Override // d.c.b.b
    public synchronized void c(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<WeakReference<b>> it = f65032a.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.c(z, str, str2, str3, str4, str5, str6);
            }
        }
    }

    @Override // d.c.b.b
    public synchronized void d(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<b>> it = f65032a.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.d(z, jSONObject);
            }
        }
    }
}
