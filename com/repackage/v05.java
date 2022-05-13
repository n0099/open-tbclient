package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class v05 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "lottie_feed_new_agree/";
    public static final String c = "lottie_feed_new_agree/";
    public static final String d = "lottie_feed_new_agree/";
    public static final String e = "lottie_feed_new_agree/";
    public static final String f = "lottie_pb_new_double_tap_agree/";
    public static final String g = "lottie_pb_new_double_tap_agree_1/";
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeMaterial a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final v05 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(20597848, "Lcom/repackage/v05$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(20597848, "Lcom/repackage/v05$b;");
                    return;
                }
            }
            a = new v05(null);
        }
    }

    public /* synthetic */ v05(a aVar) {
        this();
    }

    public static v05 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (v05) invokeV.objValue;
    }

    public void a(AgreeMaterial agreeMaterial) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, agreeMaterial) == null) {
            this.a = agreeMaterial;
            if (agreeMaterial == null) {
                return;
            }
            AgreeMaterial.Data data = agreeMaterial.staticData;
            if (data != null) {
                data.y();
            }
            AgreeMaterial.Data data2 = agreeMaterial.singleTapData;
            if (data2 != null) {
                data2.y();
            }
            AgreeMaterial.Data data3 = agreeMaterial.doubleTapData;
            if (data3 != null) {
                data3.y();
            }
            AgreeMaterial.Data data4 = agreeMaterial.longPressData;
            if (data4 != null) {
                data4.y();
            }
        }
    }

    public void b(String str, String str2, u05 u05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, u05Var) == null) {
            d("", str, str2, true, 2, u05Var);
        }
    }

    public void c(t05 t05Var) {
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t05Var) == null) || t05Var == null) {
            return;
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial != null && (data = agreeMaterial.longPressData) != null) {
            String A = data.A("", "", "");
            if (StringUtils.isNull(A)) {
                l(t05Var);
                return;
            } else {
                k(A, t05Var);
                return;
            }
        }
        l(t05Var);
    }

    public final void d(String str, String str2, String str3, boolean z, int i, u05 u05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i), u05Var}) == null) || u05Var == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial == null || !z) {
            m(i, str, u05Var);
            return;
        }
        AgreeMaterial.Data data = null;
        if (i == 0) {
            data = agreeMaterial.staticData;
        } else if (i == 1) {
            data = agreeMaterial.singleTapData;
        } else if (i == 2) {
            data = agreeMaterial.doubleTapData;
        } else if (i == 3) {
            data = agreeMaterial.longPressData;
        }
        if (data == null) {
            m(i, str, u05Var);
            return;
        }
        String A = data.A(str, str2, str3);
        if (StringUtils.isNull(A)) {
            m(i, str, u05Var);
        } else {
            u05Var.b(A);
        }
    }

    public void e(String str, String str2, String str3, boolean z, u05 u05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Boolean.valueOf(z), u05Var}) == null) {
            d(str, str2, str3, z, 1, u05Var);
        }
    }

    public String f() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial == null || (data = agreeMaterial.doubleTapData) == null) {
                return null;
            }
            return data.activityId;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial == null || (data = agreeMaterial.longPressData) == null) {
                return null;
            }
            return data.activityId;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial == null || (data = agreeMaterial.singleTapData) == null) {
                return null;
            }
            return data.activityId;
        }
        return (String) invokeV.objValue;
    }

    public final void j(@NonNull u05 u05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u05Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            boolean z = true;
            if (skinType != 4 && skinType != 1) {
                z = false;
            }
            u05Var.a(z ? R.raw.obfuscated_res_0x7f110040 : R.raw.obfuscated_res_0x7f11003f, z ? g : f);
        }
    }

    public final void k(String str, t05 t05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, t05Var) == null) {
            ArrayList arrayList = new ArrayList();
            File file = new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/animation/" + str);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        arrayList.add(BitmapFactory.decodeFile(file2.toString()));
                    }
                    t05Var.a(arrayList);
                    return;
                }
                l(t05Var);
                return;
            }
            l(t05Var);
        }
    }

    public final void l(t05 t05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, t05Var) == null) {
            ArrayList arrayList = new ArrayList();
            Bitmap decodeResource = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080855);
            Bitmap decodeResource2 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080856);
            Bitmap decodeResource3 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080857);
            Bitmap decodeResource4 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080858);
            Bitmap decodeResource5 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080859);
            arrayList.add(decodeResource);
            arrayList.add(decodeResource2);
            arrayList.add(decodeResource3);
            arrayList.add(decodeResource4);
            arrayList.add(decodeResource5);
            t05Var.a(arrayList);
        }
    }

    public final void m(int i, String str, u05 u05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i, str, u05Var) == null) {
            if (i == 1) {
                n(u05Var, str);
            } else if (i != 2) {
                u05Var.a(0, null);
            } else {
                j(u05Var);
            }
        }
    }

    public final void n(@NonNull u05 u05Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, u05Var, str) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            boolean z = true;
            if (skinType != 4 && skinType != 1) {
                z = false;
            }
            if ("/feed".equals(str)) {
                u05Var.a(z ? R.raw.obfuscated_res_0x7f110038 : R.raw.obfuscated_res_0x7f110037, z ? d : b);
            } else if ("/duang1".equals(str)) {
                u05Var.a(R.raw.obfuscated_res_0x7f110035, "lottie_feed_firework_duang1/");
            } else if ("/duang2".equals(str)) {
                u05Var.a(R.raw.obfuscated_res_0x7f110036, "lottie_feed_firework_duang2/");
            } else {
                u05Var.a(z ? R.raw.obfuscated_res_0x7f11003e : R.raw.obfuscated_res_0x7f11003d, z ? e : c);
            }
        }
    }

    public v05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
