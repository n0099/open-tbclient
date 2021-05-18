package d.a.m.d;

import android.content.Context;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f63862e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Throwable f63863f;

    public d(Context context, Throwable th) {
        this.f63862e = context;
        this.f63863f = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.g(this.f63862e, i.h(com.baidu.crabsdk.sender.g.c(this.f63862e, this.f63863f, false)));
            k.l(this.f63862e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
