package d.a.m.b;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Process f63313e;

    public b(Process process) {
        this.f63313e = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f63313e.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e2) {
            com.baidu.crabsdk.c.a.a(BitmapPoolType.DUMMY, e2);
        }
    }
}
