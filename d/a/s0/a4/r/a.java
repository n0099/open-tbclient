package d.a.s0.a4.r;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.b.d;
import d.a.r0.z0.j0;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f57567a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.a4.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1318a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b f57568e;

        /* renamed from: f  reason: collision with root package name */
        public int f57569f;

        public C1318a(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57569f = i2;
            this.f57568e = bVar;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (spanned == null || charSequence == null || (j0.c(spanned.toString()) - (i5 - i4)) + j0.c(charSequence.toString()) <= this.f57569f) {
                    return charSequence;
                }
                b bVar = this.f57568e;
                if (bVar != null) {
                    bVar.a();
                }
                return "";
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-183620890, "Ld/a/s0/a4/r/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-183620890, "Ld/a/s0/a4/r/a;");
        }
    }

    public static boolean a(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        String filePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageFileInfo)) == null) {
            if (!LimitLowQualityPicUploadSwitch.isOff() && imageFileInfo != null && !imageFileInfo.isGif() && (filePath = imageFileInfo.getFilePath()) != null) {
                long fileSize = FileHelper.getFileSize(filePath);
                if (fileSize < 5120) {
                    d(1, "" + fileSize);
                    return true;
                }
                int[] imageFileWH = FileHelper.getImageFileWH(filePath);
                if (imageFileWH[0] < 100 || imageFileWH[1] < 100) {
                    d(2, imageFileWH[0] + "*" + imageFileWH[1]);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d.a.r0.r.d0.b.j().k("show_write_title_tip_count", 0) : invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.I() : invokeV.booleanValue;
    }

    public static void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65540, null, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c14021").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2).param("obj_param1", str));
        }
    }

    public static void e(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, writeData) == null) || writeData == null || !c() || TextUtils.isEmpty(writeData.getTitle())) {
            return;
        }
        d.a.r0.r.d0.b.j().v("show_write_title_tip_count", b() + 1);
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f57567a = true;
        }
    }

    public static void g(TitleTipView titleTipView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, titleTipView) == null) || titleTipView == null) {
            return;
        }
        if (c() && !f57567a && b() <= 0) {
            titleTipView.d();
            f();
            StatisticItem.make("c13996").eventStat();
            return;
        }
        titleTipView.setVisibility(8);
    }
}
