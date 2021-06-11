package d.a.m.a.a;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Process f52275e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f52276f;

    public b(Process process, String str) {
        this.f52275e = process;
        this.f52276f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f52275e.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e2) {
            com.baidu.crabsdk.lite.b.a.e(this.f52276f, BitmapPoolType.DUMMY, e2);
        }
    }
}
