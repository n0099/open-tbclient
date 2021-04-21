package d.b.g0.f;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f43635a;

    /* renamed from: b  reason: collision with root package name */
    public Context f43636b;

    public a(Context context, Handler handler) {
        this.f43635a = new b(context, handler);
        this.f43636b = context;
    }

    public String a(String str, byte[] bArr) {
        if (str != null) {
            return this.f43635a.b(str, bArr, null);
        }
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
