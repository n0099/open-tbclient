package d.b.m.d;

import android.content.Context;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f64746e;

    public b(Context context) {
        this.f64746e = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.i(this.f64746e);
    }
}
