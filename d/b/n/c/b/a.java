package d.b.n.c.b;

import android.content.Context;
import com.baidu.crabsdk.lite.sender.e;
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f64137e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f64138f;

    public a(String str, Context context) {
        this.f64137e = str;
        this.f64138f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.d(this.f64137e, this.f64138f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
