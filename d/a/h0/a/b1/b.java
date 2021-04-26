package d.a.h0.a.b1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<a> f41268a = new ArrayList<>();

    public static void a(a aVar) {
        if (aVar == null || f41268a.contains(aVar)) {
            return;
        }
        f41268a.add(aVar);
    }

    public static void b() {
        f41268a.clear();
    }

    public static void c() {
        for (int size = f41268a.size() - 1; size >= 0; size--) {
            a aVar = f41268a.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = f41268a.size() - 1; size >= 0; size--) {
            a aVar = f41268a.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.a())) {
                aVar.onDestroy();
            }
        }
    }

    public static a e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = f41268a.size() - 1; size >= 0; size--) {
            a aVar = f41268a.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.b())) {
                return aVar;
            }
        }
        return null;
    }

    public static a f(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = f41268a.size() - 1; size >= 0; size--) {
            a aVar = f41268a.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.a())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.c())) || TextUtils.equals(str3, aVar.b())))) {
                return aVar;
            }
        }
        return null;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = f41268a.size() - 1; size >= 0; size--) {
            a aVar = f41268a.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.a()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void h(boolean z) {
        for (int size = f41268a.size() - 1; size >= 0; size--) {
            a aVar = f41268a.get(size);
            if (aVar != null) {
                aVar.e(z);
            }
        }
    }

    public static void i(boolean z) {
        for (int size = f41268a.size() - 1; size >= 0; size--) {
            a aVar = f41268a.get(size);
            if (aVar != null) {
                aVar.f(z);
            }
        }
    }

    public static void j(a aVar) {
        if (aVar == null) {
            return;
        }
        f41268a.remove(aVar);
    }
}
