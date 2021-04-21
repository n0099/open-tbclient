package d.b.h0.a.j2;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f45733e = 5;

        /* renamed from: f  reason: collision with root package name */
        public long[] f45734f = new long[5];

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f45735g;

        public a(Runnable runnable) {
            this.f45735g = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long[] jArr = this.f45734f;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f45734f;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f45734f[0] >= SystemClock.uptimeMillis() - 1000) {
                this.f45734f = new long[this.f45733e];
                this.f45735g.run();
            }
        }
    }

    public static void a(View view, Runnable runnable) {
        view.setOnClickListener(new a(runnable));
    }
}
