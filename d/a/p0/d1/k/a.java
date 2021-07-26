package d.a.p0.d1.k;

import android.graphics.Bitmap;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.l.d;
import d.a.d.e.p.k;
/* loaded from: classes7.dex */
public class a implements ImageAssetDelegate {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f52369d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52370a;

    /* renamed from: b  reason: collision with root package name */
    public LocalFileImageLoaderProc f52371b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52372c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1312632618, "Ld/a/p0/d1/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1312632618, "Ld/a/p0/d1/k/a;");
                return;
            }
        }
        f52369d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52372c = false;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f52369d + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52372c : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f52372c = z;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f52370a = a() + str + "/";
        }
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lottieImageAsset)) == null) {
            if (k.isEmpty(this.f52370a)) {
                return null;
            }
            String str = this.f52370a + lottieImageAsset.getDirName().replace("/", "") + "/" + lottieImageAsset.getFileName();
            d.a.d.k.d.a aVar = (d.a.d.k.d.a) d.h().n(str, 36, new Object[0]);
            if (aVar == null && b()) {
                if (this.f52371b == null) {
                    this.f52371b = new LocalFileImageLoaderProc();
                }
                aVar = this.f52371b.getBitmapFromFile(str, 0, 0);
            }
            if (aVar != null && aVar.p() != null) {
                Bitmap p = aVar.p();
                try {
                    return p.copy(p.getConfig(), false);
                } catch (OutOfMemoryError e2) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    BdLog.e(e2);
                }
            }
            d.h().m(str, 36, null, null);
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }
}
