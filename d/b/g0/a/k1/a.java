package d.b.g0.a.k1;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppBaseActivity;
import d.b.g0.a.k;
import d.b.g0.a.k1.c;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45071a = k.f45051a;

    /* renamed from: d.b.g0.a.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0718a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45072a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f45073b;

        public C0718a(int i, b bVar) {
            this.f45072a = i;
            this.f45073b = bVar;
        }

        @Override // d.b.g0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i != this.f45072a) {
                this.f45073b.b(2, "request permission fail");
                return;
            }
            for (int i2 : iArr) {
                if (i2 == -1) {
                    this.f45073b.b(1, "user denied");
                    return;
                }
            }
            this.f45073b.a("permission granted successful");
        }
    }

    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i, @NonNull Context context, @NonNull b bVar) {
        if (context != null && (context instanceof Activity)) {
            if (d.b.g0.q.d.c.a(context, str)) {
                bVar.a("permission has already granted");
                return;
            } else {
                b(context, strArr, i, bVar);
                return;
            }
        }
        bVar.b(2, "context should be activity ref");
    }

    public static void b(Context context, String[] strArr, int i, @NonNull b bVar) {
        if (context != null && (context instanceof SwanAppBaseActivity)) {
            ((SwanAppBaseActivity) context).requestPermissionsExt(i, strArr, new C0718a(i, bVar));
            return;
        }
        bVar.b(2, "method should be called after setActivityRef");
        if (f45071a) {
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
    }

    public static void c(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull b bVar) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!d.b.g0.q.d.c.a(context, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            b(context, (String[]) arrayList.toArray(new String[0]), i, bVar);
        } else {
            bVar.a("permission has already granted");
        }
    }
}
