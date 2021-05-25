package d.a.m.a.a;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Process f48601e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f48602f;

    public b(Process process, String str) {
        this.f48601e = process;
        this.f48602f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f48601e.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e2) {
            com.baidu.crabsdk.lite.b.a.e(this.f48602f, BitmapPoolType.DUMMY, e2);
        }
    }
}
