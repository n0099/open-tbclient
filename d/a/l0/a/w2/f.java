package d.a.l0.a.w2;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f45697e = 5;

        /* renamed from: f  reason: collision with root package name */
        public long[] f45698f = new long[5];

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f45699g;

        public a(Runnable runnable) {
            this.f45699g = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long[] jArr = this.f45698f;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f45698f;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f45698f[0] >= SystemClock.uptimeMillis() - 1000) {
                this.f45698f = new long[this.f45697e];
                this.f45699g.run();
            }
        }
    }

    public static void a(View view, Runnable runnable) {
        view.setOnClickListener(new a(runnable));
    }
}
