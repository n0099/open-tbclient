package d.d.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    public static Handler f66061b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66062a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public a(i iVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (10001 == i2) {
                j jVar = (j) message.obj;
                f.a().c(d.d.a.a.a.c(), jVar.f66069f);
                h.a().c(jVar);
            } else if (10002 != i2) {
                if (10003 == i2) {
                    h.a().h();
                }
            } else {
                String str = (String) message.obj;
                h.a().b(message.arg1, str);
                h.a().d(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static i f66063a = new i(null);
    }

    public /* synthetic */ i(a aVar) {
        this();
    }

    public static i a() {
        return b.f66063a;
    }

    public void b(String str, int i2) {
        f66061b.obtainMessage(10002, i2, -1, str).sendToTarget();
    }

    public void c(String str, String str2, String str3, String str4, long j) {
        ArrayList arrayList;
        if (str3 != null) {
            arrayList = new ArrayList(1);
            arrayList.add(str3);
        } else {
            arrayList = null;
        }
        d(str, str2, arrayList, null, str4, j);
    }

    public void d(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3, long j) {
        if (d.d.a.a.a.e().f().isIgnoreToSend(str)) {
            return;
        }
        e();
        f66061b.obtainMessage(10001, j.a(str, j, str2, k.a(), e.a(), collection, map, str3)).sendToTarget();
    }

    public boolean e() {
        if (this.f66062a) {
            return false;
        }
        this.f66062a = true;
        f66061b.sendEmptyMessage(10003);
        d.h().a();
        d.d.a.a.a.e().f().loadStrategy();
        return true;
    }

    public i() {
        this.f66062a = false;
        f66061b = new a(this, g.a().b().getLooper());
    }
}
