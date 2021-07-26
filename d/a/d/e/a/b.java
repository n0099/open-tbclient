package d.a.d.e.a;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f41503a;

    /* renamed from: b  reason: collision with root package name */
    public String f41504b;

    /* renamed from: c  reason: collision with root package name */
    public String f41505c;

    /* renamed from: d  reason: collision with root package name */
    public String f41506d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41503a = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f41504b = this.f41503a + "/baidu/";
        this.f41505c = null;
        this.f41506d = null;
        try {
            this.f41505c = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.f41506d = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z2) {
                if (!b()) {
                    return null;
                }
                if (str != null) {
                    str3 = this.f41504b + str + "/";
                } else {
                    str3 = this.f41504b;
                }
            } else if (z3) {
                str2 = this.f41506d;
                if (str2 == null) {
                    return null;
                }
                if (str != null) {
                    str3 = this.f41506d + str + "/";
                }
                str3 = str2;
            } else {
                str2 = this.f41505c;
                if (str2 == null) {
                    return null;
                }
                if (str != null) {
                    str3 = this.f41505c + str + "/";
                }
                str3 = str2;
            }
            File file = new File(str3);
            if (file.exists()) {
                return str3;
            }
            if (z && file.mkdirs()) {
                return str3;
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public File c(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (str2 == null || (a2 = a(str, z, z2, z3)) == null) {
                return null;
            }
            return new File(a2 + str2);
        }
        return (File) invokeCommon.objValue;
    }

    public File d(String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            String a2 = a(str, z, z2, z3);
            if (a2 == null) {
                return null;
            }
            return new File(a2);
        }
        return (File) invokeCommon.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.f41504b = this.f41503a + "/" + str + "/";
    }
}
