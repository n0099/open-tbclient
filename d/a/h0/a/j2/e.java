package d.a.h0.a.j2;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f43061e = 5;

        /* renamed from: f  reason: collision with root package name */
        public long[] f43062f = new long[5];

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f43063g;

        public a(Runnable runnable) {
            this.f43063g = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long[] jArr = this.f43062f;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f43062f;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f43062f[0] >= SystemClock.uptimeMillis() - 1000) {
                this.f43062f = new long[this.f43061e];
                this.f43063g.run();
            }
        }
    }

    public static void a(View view, Runnable runnable) {
        view.setOnClickListener(new a(runnable));
    }
}
