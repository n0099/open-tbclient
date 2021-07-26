package d.a.x0.e;

import android.text.TextUtils;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f69089a;

    /* renamed from: b  reason: collision with root package name */
    public static String f69090b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1402120299, "Ld/a/x0/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1402120299, "Ld/a/x0/e/b;");
                return;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f69089a = arrayList;
        arrayList.add(10000);
        f69089a.add(10001);
        f69089a.add(10002);
        f69089a.add(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT));
        f69089a.add(-1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f69090b)) {
                f69090b = d.a.x0.e.h.d.a();
            }
            if (TextUtils.isEmpty(f69090b)) {
                return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
            }
            if (f69090b.toUpperCase().contains("HUAWEI")) {
                return 10001;
            }
            if (f69090b.toUpperCase().contains("XIAOMI")) {
                return 10002;
            }
            return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
        }
        return invokeV.intValue;
    }
}
