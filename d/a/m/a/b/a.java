package d.a.m.a.b;

import android.content.Context;
import com.baidu.crabsdk.lite.sender.e;
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f44352e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f44353f;

    public a(String str, Context context) {
        this.f44352e = str;
        this.f44353f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.d(this.f44352e, this.f44353f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
