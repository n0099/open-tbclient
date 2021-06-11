package d.a.m.a.b;

import android.content.Context;
import com.baidu.crabsdk.lite.sender.e;
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f52277e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f52278f;

    public a(String str, Context context) {
        this.f52277e = str;
        this.f52278f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.d(this.f52277e, this.f52278f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
