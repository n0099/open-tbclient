package d.a.m.c.a;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Process f63314e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f63315f;

    public b(Process process, String str) {
        this.f63314e = process;
        this.f63315f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f63314e.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e2) {
            com.baidu.crabsdk.lite.b.a.e(this.f63315f, BitmapPoolType.DUMMY, e2);
        }
    }
}
