package d.a.p0.t.a;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Domain f53708a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f53709b;

    /* renamed from: c  reason: collision with root package name */
    public static b f53710c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1108710867, "Ld/a/p0/t/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1108710867, "Ld/a/p0/t/a/a;");
                return;
            }
        }
        f53708a = Domain.DOMAIN_ONLINE;
        f53709b = true;
        f53710c = null;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (TbConfig.USE_OLD_LOGIN) {
                f53709b = true;
                return;
            }
            if (Build.VERSION.SDK_INT < 9) {
                if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                    f53709b = false;
                } else {
                    f53709b = true;
                }
            } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
                f53709b = false;
            } else {
                f53709b = true;
            }
            if (Build.VERSION.SDK_INT > 10 || f53709b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
                return;
            }
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            f53709b = true;
        }
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f53710c : (b) invokeV.objValue;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || f53710c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f53710c = (b) runTask.getData();
    }
}
