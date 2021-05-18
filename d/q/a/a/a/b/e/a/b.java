package d.q.a.a.a.b.e.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f67520a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper, Context context) {
        super(looper);
        this.f67520a = context;
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
                    f2 = a.f(this.f67520a, data.getString("appid"));
                    String unused = a.f67516g = f2;
                }
                obj = a.f67513d;
                synchronized (obj) {
                    obj2 = a.f67513d;
                    obj2.notify();
                }
            } catch (Throwable th) {
                d.q.a.a.c.b.b.c(th);
            }
        }
    }
}
