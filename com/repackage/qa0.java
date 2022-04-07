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
public final class qa0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, List<pa0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755386991, "Lcom/repackage/qa0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755386991, "Lcom/repackage/qa0;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
    }

    @JvmStatic
    @JvmOverloads
    public static final pa0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(null, str, 1, null) : (pa0) invokeL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final pa0 b(String str, String pageId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, pageId)) == null) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            LiveFeedPageSdk.n("LiveFeedPlayerPool", "getPlayer pageId= " + pageId + WebvttCueParser.CHAR_SPACE + a.size());
            List<pa0> list = a.get(pageId);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.isEmpty() && list.size() >= 2) {
                pa0 pa0Var = list.get(0);
                Collections.swap(list, 0, 1);
                if (pa0Var.isPlaying()) {
                    pa0Var.detachFromContainer();
                    pa0Var.stop();
                }
                LiveFeedPageSdk.n("LiveFeedPlayerPool", "getPlayer " + pa0Var);
                return pa0Var;
            }
            pa0 pa0Var2 = new pa0(new ra0(str, 0, null, null, 14, null));
            list.add(pa0Var2);
            a.put(pageId, list);
            return pa0Var2;
        }
        return (pa0) invokeLL.objValue;
    }

    public static /* synthetic */ pa0 c(String str, String str2, int i, Object obj) {
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
            List<pa0> list = a.get(pageId);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (pa0 pa0Var : list) {
                pa0Var.detachFromContainer();
                pa0Var.release();
            }
            list.clear();
            a.remove(pageId);
        }
    }
}
