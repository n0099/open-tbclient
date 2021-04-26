package d.a.h0.a.k1;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppBaseActivity;
import d.a.h0.a.k;
import d.a.h0.a.k1.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43121a = k.f43101a;

    /* renamed from: d.a.h0.a.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0689a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f43123b;

        public C0689a(int i2, b bVar) {
            this.f43122a = i2;
            this.f43123b = bVar;
        }

        @Override // d.a.h0.a.k1.c.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i2 != this.f43122a) {
                this.f43123b.b(2, "request permission fail");
                return;
            }
            for (int i3 : iArr) {
                if (i3 == -1) {
                    this.f43123b.b(1, "user denied");
                    return;
                }
            }
            this.f43123b.a("permission granted successful");
        }
    }

    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i2, @NonNull Context context, @NonNull b bVar) {
        if (context != null && (context instanceof Activity)) {
            if (d.a.h0.q.d.c.a(context, str)) {
                bVar.a("permission has already granted");
                return;
            } else {
                b(context, strArr, i2, bVar);
                return;
            }
        }
        bVar.b(2, "context should be activity ref");
    }

    public static void b(Context context, String[] strArr, int i2, @NonNull b bVar) {
        if (context != null && (context instanceof SwanAppBaseActivity)) {
            ((SwanAppBaseActivity) context).requestPermissionsExt(i2, strArr, new C0689a(i2, bVar));
            return;
        }
        bVar.b(2, "method should be called after setActivityRef");
        if (f43121a) {
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
    }

    public static void c(@NonNull String[] strArr, int i2, @NonNull Context context, @NonNull b bVar) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!d.a.h0.q.d.c.a(context, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            b(context, (String[]) arrayList.toArray(new String[0]), i2, bVar);
        } else {
            bVar.a("permission has already granted");
        }
    }
}
