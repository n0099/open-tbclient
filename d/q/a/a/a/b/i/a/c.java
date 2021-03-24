package d.q.a.a.a.b.i.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f67343a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper, Context context) {
        super(looper);
        this.f67343a = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        Object obj2;
        String h2;
        if (message.what == 666) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    h2 = b.h(this.f67343a, data.getInt("type"), data.getString("appid"));
                    String unused = b.f67340h = h2;
                }
                obj = b.f67337e;
                synchronized (obj) {
                    obj2 = b.f67337e;
                    obj2.notify();
                }
            } catch (Throwable th) {
                d.q.a.a.c.b.b.c(th);
            }
        }
    }
}
