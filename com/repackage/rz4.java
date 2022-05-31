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
public class rz4 {
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
        public static final rz4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-25607993, "Lcom/repackage/rz4$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-25607993, "Lcom/repackage/rz4$b;");
                    return;
                }
            }
            a = new rz4(null);
        }
    }

    public /* synthetic */ rz4(a aVar) {
        this();
    }

    public static rz4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (rz4) invokeV.objValue;
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

    public void b(String str, String str2, qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, qz4Var) == null) {
            d("", str, str2, true, 2, qz4Var);
        }
    }

    public void c(pz4 pz4Var) {
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pz4Var) == null) || pz4Var == null) {
            return;
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial != null && (data = agreeMaterial.longPressData) != null) {
            String A = data.A("", "", "");
            if (StringUtils.isNull(A)) {
                l(pz4Var);
                return;
            } else {
                k(A, pz4Var);
                return;
            }
        }
        l(pz4Var);
    }

    public final void d(String str, String str2, String str3, boolean z, int i, qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i), qz4Var}) == null) || qz4Var == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial == null || !z) {
            m(i, str, qz4Var);
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
            m(i, str, qz4Var);
            return;
        }
        String A = data.A(str, str2, str3);
        if (StringUtils.isNull(A)) {
            m(i, str, qz4Var);
        } else {
            qz4Var.b(A);
        }
    }

    public void e(String str, String str2, String str3, boolean z, qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Boolean.valueOf(z), qz4Var}) == null) {
            d(str, str2, str3, z, 1, qz4Var);
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

    public final void j(@NonNull qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qz4Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            boolean z = true;
            if (skinType != 4 && skinType != 1) {
                z = false;
            }
            qz4Var.a(z ? R.raw.obfuscated_res_0x7f110041 : R.raw.obfuscated_res_0x7f110040, z ? g : f);
        }
    }

    public final void k(String str, pz4 pz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, pz4Var) == null) {
            ArrayList arrayList = new ArrayList();
            File file = new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/animation/" + str);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        arrayList.add(BitmapFactory.decodeFile(file2.toString()));
                    }
                    pz4Var.a(arrayList);
                    return;
                }
                l(pz4Var);
                return;
            }
            l(pz4Var);
        }
    }

    public final void l(pz4 pz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pz4Var) == null) {
            ArrayList arrayList = new ArrayList();
            Bitmap decodeResource = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080858);
            Bitmap decodeResource2 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080859);
            Bitmap decodeResource3 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f08085a);
            Bitmap decodeResource4 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f08085b);
            Bitmap decodeResource5 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f08085c);
            arrayList.add(decodeResource);
            arrayList.add(decodeResource2);
            arrayList.add(decodeResource3);
            arrayList.add(decodeResource4);
            arrayList.add(decodeResource5);
            pz4Var.a(arrayList);
        }
    }

    public final void m(int i, String str, qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i, str, qz4Var) == null) {
            if (i == 1) {
                n(qz4Var, str);
            } else if (i != 2) {
                qz4Var.a(0, null);
            } else {
                j(qz4Var);
            }
        }
    }

    public final void n(@NonNull qz4 qz4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, qz4Var, str) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            boolean z = true;
            if (skinType != 4 && skinType != 1) {
                z = false;
            }
            if ("/feed".equals(str)) {
                qz4Var.a(z ? R.raw.obfuscated_res_0x7f110038 : R.raw.obfuscated_res_0x7f110037, z ? d : b);
            } else if ("/duang1".equals(str)) {
                qz4Var.a(R.raw.obfuscated_res_0x7f110035, "lottie_feed_firework_duang1/");
            } else if ("/duang2".equals(str)) {
                qz4Var.a(R.raw.obfuscated_res_0x7f110036, "lottie_feed_firework_duang2/");
            } else {
                qz4Var.a(z ? R.raw.obfuscated_res_0x7f11003f : R.raw.obfuscated_res_0x7f11003e, z ? e : c);
            }
        }
    }

    public rz4() {
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
