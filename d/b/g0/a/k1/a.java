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
    public static final boolean f45463a = k.f45443a;

    /* renamed from: d.b.g0.a.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0730a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f45465b;

        public C0730a(int i, b bVar) {
            this.f45464a = i;
            this.f45465b = bVar;
        }

        @Override // d.b.g0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i != this.f45464a) {
                this.f45465b.b(2, "request permission fail");
                return;
            }
            for (int i2 : iArr) {
                if (i2 == -1) {
                    this.f45465b.b(1, "user denied");
                    return;
                }
            }
            this.f45465b.a("permission granted successful");
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
            ((SwanAppBaseActivity) context).requestPermissionsExt(i, strArr, new C0730a(i, bVar));
            return;
        }
        bVar.b(2, "method should be called after setActivityRef");
        if (f45463a) {
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
