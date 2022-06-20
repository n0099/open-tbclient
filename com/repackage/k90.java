package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k90 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, List<j90>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755604177, "Lcom/repackage/k90;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755604177, "Lcom/repackage/k90;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
    }

    @JvmStatic
    @JvmOverloads
    public static final j90 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(null, str, 1, null) : (j90) invokeL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final j90 b(String str, String pageId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, pageId)) == null) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            LiveFeedPageSdk.n("LiveFeedPlayerPool", "getPlayer pageId= " + pageId + WebvttCueParser.CHAR_SPACE + a.size());
            List<j90> list = a.get(pageId);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.isEmpty() && list.size() >= 2) {
                j90 j90Var = list.get(0);
                Collections.swap(list, 0, 1);
                if (j90Var.isPlaying()) {
                    j90Var.detachFromContainer();
                    j90Var.stop();
                }
                LiveFeedPageSdk.n("LiveFeedPlayerPool", "getPlayer " + j90Var);
                return j90Var;
            }
            j90 j90Var2 = new j90(new l90(str, 0, null, null, 14, null));
            list.add(j90Var2);
            a.put(pageId, list);
            return j90Var2;
        }
        return (j90) invokeLL.objValue;
    }

    public static /* synthetic */ j90 c(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return b(str, str2);
    }

    @JvmStatic
    public static final void d(String pageId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pageId) == null) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            LiveFeedPageSdk.n("LiveFeedPlayerPool", "release playerMap= " + a.size());
            List<j90> list = a.get(pageId);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (j90 j90Var : list) {
                j90Var.detachFromContainer();
                j90Var.release();
            }
            list.clear();
            a.remove(pageId);
        }
    }
}
