package d.q.a.a.a.b.e.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f71453a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper, Context context) {
        super(looper);
        this.f71453a = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        Object obj2;
        String f2;
        if (message.what == 666) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    f2 = a.f(this.f71453a, data.getString("appid"));
                    String unused = a.f71449g = f2;
                }
                obj = a.f71446d;
                synchronized (obj) {
                    obj2 = a.f71446d;
                    obj2.notify();
                }
            } catch (Throwable th) {
                d.q.a.a.c.b.b.c(th);
            }
        }
    }
}
