package d.b.b;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<WeakReference<b>> f64331a = new ArrayList<>(4);

    @Override // d.b.b.b
    public synchronized void a(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<b>> it = f64331a.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.a(z, jSONObject);
            }
        }
    }

    @Override // d.b.b.b
    public synchronized void b(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<WeakReference<b>> it = f64331a.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.b(z, str, str2, str3, str4, str5, str6);
            }
        }
    }

    @Override // d.b.b.b
    public synchronized void c(String str, String str2, String str3) {
        Iterator<WeakReference<b>> it = f64331a.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.c(str, str2, str3);
            }
        }
    }

    @Override // d.b.b.b
    public synchronized void d(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<b>> it = f64331a.iterator();
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
