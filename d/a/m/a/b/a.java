package d.a.m.a.b;

import android.content.Context;
import com.baidu.crabsdk.lite.sender.e;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f48603e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f48604f;

    public a(String str, Context context) {
        this.f48603e = str;
        this.f48604f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.d(this.f48603e, this.f48604f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
