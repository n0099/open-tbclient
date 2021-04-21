package d.b.m.d;

import android.content.Context;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f65013e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Throwable f65014f;

    public d(Context context, Throwable th) {
        this.f65013e = context;
        this.f65014f = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.g(this.f65013e, i.h(com.baidu.crabsdk.sender.g.c(this.f65013e, this.f65014f, false)));
            k.l(this.f65013e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
