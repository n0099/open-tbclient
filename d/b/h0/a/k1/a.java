package d.b.h0.a.k1;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppBaseActivity;
import d.b.h0.a.k;
import d.b.h0.a.k1.c;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45792a = k.f45772a;

    /* renamed from: d.b.h0.a.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0750a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45793a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f45794b;

        public C0750a(int i, b bVar) {
            this.f45793a = i;
            this.f45794b = bVar;
        }

        @Override // d.b.h0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i != this.f45793a) {
                this.f45794b.b(2, "request permission fail");
                return;
            }
            for (int i2 : iArr) {
                if (i2 == -1) {
                    this.f45794b.b(1, "user denied");
                    return;
                }
            }
            this.f45794b.a("permission granted successful");
        }
    }

    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i, @NonNull Context context, @NonNull b bVar) {
        if (context != null && (context instanceof Activity)) {
            if (d.b.h0.q.d.c.a(context, str)) {
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
            ((SwanAppBaseActivity) context).requestPermissionsExt(i, strArr, new C0750a(i, bVar));
            return;
        }
        bVar.b(2, "method should be called after setActivityRef");
        if (f45792a) {
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
    }

    public static void c(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull b bVar) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!d.b.h0.q.d.c.a(context, str)) {
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
