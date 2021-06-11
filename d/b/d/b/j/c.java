package d.b.d.b.j;

import android.content.Context;
import android.os.Handler;
import d.b.d.b.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f69681a;

    public c(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.f69681a = arrayList;
        arrayList.add(new b(handler, 0L, 15000L));
    }

    public static c a(Handler handler, Context context) {
        return new c(handler, context);
    }

    public void b() {
        l.k.a("[ScheduleTaskManager] execute, task size=" + this.f69681a.size());
        for (a aVar : this.f69681a) {
            try {
                aVar.a();
            } catch (Throwable unused) {
            }
        }
    }
}
