package d.a.m0.a.n0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.m0.a.k;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47371a = k.f46983a;

    @Nullable
    public static Set<String> a(int i2, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (d.a.m0.a.v1.c.f.c cVar : d.a.m0.a.v1.c.f.e.k().q()) {
            String appId = cVar.getAppId();
            if (TextUtils.isEmpty(appId)) {
                appId = cVar.j();
            }
            boolean z = cVar.C() || cVar.E();
            if (cVar.H() && z && list.contains(appId)) {
                d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
                d.a.m0.a.v1.c.c cVar2 = new d.a.m0.a.v1.c.c(i2);
                cVar2.b(cVar.f49113f);
                e2.h(cVar2);
                hashSet.add(appId);
                if (f47371a) {
                    Log.i("PurgerUtils", "sent msg(" + i2 + ") to active swan(" + appId + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
        }
        return hashSet;
    }

    public static void b(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z) {
        c(file, str, str2, set, z, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z, @Nullable d.a.m0.d.i.a<Pair<String, File>> aVar) {
        File[] listFiles;
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (!name.isEmpty() && file2.isFile() && name.startsWith(str) && name.endsWith(str2)) {
                int length = name.length();
                int length2 = str.length();
                int length3 = str2.length();
                if (length >= length2 + length3) {
                    String substring = name.substring(length2, length - length3);
                    if (set == null) {
                        set = Collections.emptySet();
                    }
                    if (!TextUtils.isEmpty(substring)) {
                        if (z) {
                            if (set.contains(substring)) {
                            }
                            if (f47371a) {
                                Log.i("PurgerUtils", "clearByDeleteFiles : " + substring);
                            }
                            if (aVar == null) {
                                aVar.a(Pair.create(str + substring, file2));
                            } else {
                                d.a.m0.t.d.K(file2);
                            }
                        } else {
                            if (!set.contains(substring)) {
                            }
                            if (f47371a) {
                            }
                            if (aVar == null) {
                            }
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public static Set<String> d(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return a(106, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArraySet<String> e(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z) {
        File[] listFiles;
        String I;
        ArraySet<String> arraySet = new ArraySet<>();
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!name.isEmpty() && file2.isFile() && name.startsWith(str) && name.endsWith(str2)) {
                    int length = name.length();
                    int length2 = str.length();
                    int length3 = str2.length();
                    if (length >= length2 + length3) {
                        String substring = name.substring(length2, length - length3);
                        if (set == null) {
                            set = Collections.emptySet();
                        }
                        if (!TextUtils.isEmpty(substring)) {
                            if (z) {
                                if (set.contains(substring)) {
                                }
                                I = d.a.m0.t.d.I(file2);
                                if (f47371a) {
                                    Log.i("PurgerUtils", "originFile:" + file2.getAbsolutePath() + ", renameFile:" + I);
                                }
                                if (TextUtils.isEmpty(I)) {
                                    arraySet.add(I);
                                }
                            } else {
                                if (!set.contains(substring)) {
                                }
                                I = d.a.m0.t.d.I(file2);
                                if (f47371a) {
                                }
                                if (TextUtils.isEmpty(I)) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return arraySet;
    }
}
