package d.a.h0.a.j0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.h0.a.k;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42846a = k.f43101a;

    @Nullable
    public static Set<String> a(int i2, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (d.a.h0.a.n1.c.f.c cVar : d.a.h0.a.n1.c.f.e.j().p()) {
            String appId = cVar.getAppId();
            if (cVar.D() && cVar.z() && list.contains(appId)) {
                d.a.h0.a.n1.c.a e2 = d.a.h0.a.n1.c.a.e();
                d.a.h0.a.n1.c.c cVar2 = new d.a.h0.a.n1.c.c(i2);
                cVar2.b(cVar.f43457f);
                e2.h(cVar2);
                hashSet.add(appId);
                if (f42846a) {
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
    public static void c(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z, @Nullable d.a.h0.c.i.a<Pair<String, File>> aVar) {
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
                            if (f42846a) {
                                Log.i("PurgerUtils", "clearByDeleteFiles : " + substring);
                            }
                            if (aVar == null) {
                                aVar.a(Pair.create(str + substring, file2));
                            } else {
                                file2.delete();
                            }
                        } else {
                            if (!set.contains(substring)) {
                            }
                            if (f42846a) {
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
}
