package d.a.g0.f;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f40131a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40132b;

    public a(Context context, Handler handler) {
        this.f40131a = new b(context, handler);
        this.f40132b = context;
    }

    public String a(String str, byte[] bArr) {
        if (str != null) {
            return this.f40131a.b(str, bArr, null);
        }
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
