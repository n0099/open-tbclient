package d.b.f0.f;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f42945a;

    /* renamed from: b  reason: collision with root package name */
    public Context f42946b;

    public a(Context context, Handler handler) {
        this.f42945a = new b(context, handler);
        this.f42946b = context;
    }

    public String a(String str, byte[] bArr) {
        if (str != null) {
            return this.f42945a.b(str, bArr, null);
        }
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
