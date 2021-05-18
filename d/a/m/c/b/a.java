package d.a.m.c.b;

import android.content.Context;
import com.baidu.crabsdk.lite.sender.e;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f63855e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f63856f;

    public a(String str, Context context) {
        this.f63855e = str;
        this.f63856f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.d(this.f63855e, this.f63856f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
