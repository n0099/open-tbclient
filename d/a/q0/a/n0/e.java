package d.a.q0.a.n0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49521a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(122476106, "Ld/a/q0/a/n0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(122476106, "Ld/a/q0/a/n0/e;");
                return;
            }
        }
        f49521a = k.f49133a;
    }

    @Nullable
    public static Set<String> a(int i2, List<String> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (d.a.q0.a.v1.c.f.c cVar : d.a.q0.a.v1.c.f.e.k().q()) {
                String appId = cVar.getAppId();
                if (TextUtils.isEmpty(appId)) {
                    appId = cVar.j();
                }
                boolean z = cVar.C() || cVar.E();
                if (cVar.H() && z && list.contains(appId)) {
                    d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                    d.a.q0.a.v1.c.c cVar2 = new d.a.q0.a.v1.c.c(i2);
                    cVar2.b(cVar.f51259f);
                    e2.h(cVar2);
                    hashSet.add(appId);
                    if (f49521a) {
                        Log.i("PurgerUtils", "sent msg(" + i2 + ") to active swan(" + appId + SmallTailInfo.EMOTION_SUFFIX);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeIL.objValue;
    }

    public static void b(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{file, str, str2, set, Boolean.valueOf(z)}) == null) {
            c(file, str, str2, set, z, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z, @Nullable d.a.q0.d.i.a<Pair<String, File>> aVar) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{file, str, str2, set, Boolean.valueOf(z), aVar}) == null) && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
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
                                if (f49521a) {
                                    Log.i("PurgerUtils", "clearByDeleteFiles : " + substring);
                                }
                                if (aVar == null) {
                                    aVar.run(Pair.create(str + substring, file2));
                                } else {
                                    d.a.q0.t.d.K(file2);
                                }
                            } else {
                                if (!set.contains(substring)) {
                                }
                                if (f49521a) {
                                }
                                if (aVar == null) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public static Set<String> d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return a(106, list);
        }
        return (Set) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArraySet<String> e(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z) {
        InterceptResult invokeCommon;
        File[] listFiles;
        String I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{file, str, str2, set, Boolean.valueOf(z)})) == null) {
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
                                    I = d.a.q0.t.d.I(file2);
                                    if (f49521a) {
                                        Log.i("PurgerUtils", "originFile:" + file2.getAbsolutePath() + ", renameFile:" + I);
                                    }
                                    if (TextUtils.isEmpty(I)) {
                                        arraySet.add(I);
                                    }
                                } else {
                                    if (!set.contains(substring)) {
                                    }
                                    I = d.a.q0.t.d.I(file2);
                                    if (f49521a) {
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
        return (ArraySet) invokeCommon.objValue;
    }
}
