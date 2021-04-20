package d.b.f0.f;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f43338a;

    /* renamed from: b  reason: collision with root package name */
    public Context f43339b;

    public a(Context context, Handler handler) {
        this.f43338a = new b(context, handler);
        this.f43339b = context;
    }

    public String a(String str, byte[] bArr) {
        if (str != null) {
            return this.f43338a.b(str, bArr, null);
        }
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
