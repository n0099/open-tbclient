package i.a.a.e.q;

import android.view.View;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes8.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public static long f72357e;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f72357e >= 1000) {
            f72357e = currentTimeMillis;
            a(view);
            return;
        }
        RLog.info("OnMultiClickListener", "click too often");
    }
}
