package d.b.g0.a.b1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<a> f43669a = new ArrayList<>();

    public static void a(a aVar) {
        if (aVar == null || f43669a.contains(aVar)) {
            return;
        }
        f43669a.add(aVar);
    }

    public static void b() {
        f43669a.clear();
    }

    public static void c() {
        for (int size = f43669a.size() - 1; size >= 0; size--) {
            a aVar = f43669a.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = f43669a.size() - 1; size >= 0; size--) {
            a aVar = f43669a.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.b())) {
                aVar.onDestroy();
            }
        }
    }

    public static a e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = f43669a.size() - 1; size >= 0; size--) {
            a aVar = f43669a.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.c())) {
                return aVar;
            }
        }
        return null;
    }

    public static a f(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = f43669a.size() - 1; size >= 0; size--) {
            a aVar = f43669a.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.b())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.e())) || TextUtils.equals(str3, aVar.c())))) {
                return aVar;
            }
        }
        return null;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = f43669a.size() - 1; size >= 0; size--) {
            a aVar = f43669a.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.b()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void h(boolean z) {
        for (int size = f43669a.size() - 1; size >= 0; size--) {
            a aVar = f43669a.get(size);
            if (aVar != null) {
                aVar.d(z);
            }
        }
    }

    public static void i(boolean z) {
        for (int size = f43669a.size() - 1; size >= 0; size--) {
            a aVar = f43669a.get(size);
            if (aVar != null) {
                aVar.f(z);
            }
        }
    }

    public static void j(a aVar) {
        if (aVar == null) {
            return;
        }
        f43669a.remove(aVar);
    }
}
