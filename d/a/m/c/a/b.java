package d.a.m.c.a;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Process f63853e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f63854f;

    public b(Process process, String str) {
        this.f63853e = process;
        this.f63854f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f63853e.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e2) {
            com.baidu.crabsdk.lite.b.a.e(this.f63854f, BitmapPoolType.DUMMY, e2);
        }
    }
}
