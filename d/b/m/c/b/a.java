package d.b.m.c.b;

import android.content.Context;
import com.baidu.crabsdk.lite.sender.e;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f65006e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f65007f;

    public a(String str, Context context) {
        this.f65006e = str;
        this.f65007f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.d(this.f65006e, this.f65007f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
