package d.a.l0.a.r1.n;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnyThread;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Integer, CopyOnWriteArrayList<View>> f44545b;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44546a = new a();
    }

    public static a a() {
        return b.f44546a;
    }

    @Nullable
    @UiThread
    public View b(@LayoutRes int i2, @Nullable ViewGroup viewGroup, boolean z) {
        ViewGroup.LayoutParams layoutParams;
        View d2 = d(i2);
        if (d2 != null && viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
            ViewGroup.LayoutParams layoutParams2 = d2.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(layoutParams);
            } else {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
            }
            d2.setLayoutParams(layoutParams2);
        }
        if (d2 == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View inflate = LayoutInflater.from(d.a.l0.a.c1.a.b()).inflate(i2, viewGroup, z);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", "getView resId = " + i2 + " ；inflate new view cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return inflate;
        }
        return d2;
    }

    @AnyThread
    public void c(@LayoutRes int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int length = iArr.length;
            LayoutInflater from = LayoutInflater.from(d.a.l0.a.c1.a.b());
            for (int i2 : iArr) {
                View inflate = from.inflate(i2, (ViewGroup) null);
                CopyOnWriteArrayList<View> copyOnWriteArrayList = this.f44545b.get(Integer.valueOf(i2));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                copyOnWriteArrayList.add(inflate);
                this.f44545b.put(Integer.valueOf(i2), copyOnWriteArrayList);
            }
            if (d.a.l0.a.f1.f.a.f41852a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "inflateLayoutRes count = " + length + "; cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        } catch (Exception e2) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", Log.getStackTraceString(e2));
            }
        }
    }

    @Nullable
    @AnyThread
    public View d(@LayoutRes int i2) {
        View view = null;
        try {
            CopyOnWriteArrayList<View> copyOnWriteArrayList = this.f44545b.get(Integer.valueOf(i2));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                view = copyOnWriteArrayList.remove(0);
            }
        } catch (Exception e2) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", Log.getStackTraceString(e2));
            }
        }
        if (d.a.l0.a.f1.f.a.f41852a) {
            StringBuilder sb = new StringBuilder();
            sb.append("tryObtainLayoutByResId resId = ");
            sb.append(i2);
            sb.append(view == null ? " cache view is null" : " adopt cached view");
            Log.d("SwanPerformance", sb.toString());
        }
        return view;
    }

    public a() {
        this.f44545b = new ConcurrentHashMap<>();
    }
}
