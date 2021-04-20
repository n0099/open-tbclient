package d.b.m.c.b;

import android.content.Context;
import com.baidu.crabsdk.lite.sender.e;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f64742e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f64743f;

    public a(String str, Context context) {
        this.f64742e = str;
        this.f64743f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.d(this.f64742e, this.f64743f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
