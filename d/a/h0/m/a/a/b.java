package d.a.h0.m.a.a;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract Parcelable a(View view, Matrix matrix, RectF rectF);

        public abstract View b(Context context, Parcelable parcelable);

        public abstract void c(List<String> list, Map<String, View> map);

        public abstract void d(List<View> list);

        public abstract void e(List<String> list, List<View> list2, List<View> list3);

        public abstract void f(List<String> list, List<View> list2, List<View> list3);
    }

    /* renamed from: d.a.h0.m.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class SharedElementCallbackC0995b extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        public a f47302a;

        public SharedElementCallbackC0995b(a aVar) {
            this.f47302a = aVar;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f47302a.a(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f47302a.b(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f47302a.c(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f47302a.d(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f47302a.e(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f47302a.f(list, list2, list3);
        }
    }

    public static SharedElementCallback a(a aVar) {
        if (aVar != null) {
            return new SharedElementCallbackC0995b(aVar);
        }
        return null;
    }

    public static void b(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void c(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void d(Activity activity, a aVar) {
        activity.setEnterSharedElementCallback(a(aVar));
    }

    public static void e(Activity activity, a aVar) {
        activity.setExitSharedElementCallback(a(aVar));
    }

    public static void f(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
