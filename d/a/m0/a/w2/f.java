package d.a.m0.a.w2;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f49479e = 5;

        /* renamed from: f  reason: collision with root package name */
        public long[] f49480f = new long[5];

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f49481g;

        public a(Runnable runnable) {
            this.f49481g = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long[] jArr = this.f49480f;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f49480f;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f49480f[0] >= SystemClock.uptimeMillis() - 1000) {
                this.f49480f = new long[this.f49479e];
                this.f49481g.run();
            }
        }
    }

    public static void a(View view, Runnable runnable) {
        view.setOnClickListener(new a(runnable));
    }
}
