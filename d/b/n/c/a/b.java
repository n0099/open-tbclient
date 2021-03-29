package d.b.n.c.a;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Process f64136e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f64137f;

    public b(Process process, String str) {
        this.f64136e = process;
        this.f64137f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f64136e.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e2) {
            com.baidu.crabsdk.lite.b.a.e(this.f64137f, BitmapPoolType.DUMMY, e2);
        }
    }
}
