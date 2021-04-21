package d.b.a0.k.k;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.poly.a.l.c;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.a0.k.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0560a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f42041e;

        public RunnableC0560a(c cVar) {
            this.f42041e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(this.f42041e);
        }
    }

    public static c a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, long j) {
        if (viewGroup == null) {
            return null;
        }
        c cVar = new c(viewGroup.getContext());
        if (!TextUtils.isEmpty(str)) {
            cVar.setText(str);
        }
        b(viewGroup, layoutParams, cVar, j);
        return cVar;
    }

    public static void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, c cVar, long j) {
        if (cVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) cVar.getParent()).removeView(cVar);
        }
        viewGroup.addView(cVar, layoutParams);
        cVar.setLoading(true);
        if (j != -1) {
            viewGroup.postDelayed(new RunnableC0560a(cVar), j);
        }
    }

    public static void c(c cVar) {
        if (cVar != null && (cVar.getParent() instanceof ViewGroup)) {
            ((ViewGroup) cVar.getParent()).removeView(cVar);
            cVar.setLoading(false);
        }
    }
}
