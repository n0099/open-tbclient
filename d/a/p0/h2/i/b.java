package d.a.p0.h2.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65536, null, i2) == null) || TbadkCoreApplication.getInst().getFontSize() == i2) {
            return;
        }
        TbadkCoreApplication.getInst().setFontSize(i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize == 0) {
                return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_xlarge);
            }
            if (fontSize == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_big);
            }
            if (fontSize == 2) {
                return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_mid);
            }
            return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_small);
        }
        return (String) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            int i2 = 3;
            if (fontSize == 0) {
                i2 = 1;
            } else if (fontSize == 1) {
                i2 = 2;
            }
            if (fontSize != i2) {
                TbadkCoreApplication.getInst().setFontSize(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
            }
            BdToast.h(TbadkCoreApplication.getInst(), b(), R.drawable.icon_word_t_size, 0, false).q();
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            int i2 = 2;
            if (fontSize == 0 || fontSize == 1) {
                i2 = 0;
            } else if (fontSize == 2) {
                i2 = 1;
            }
            if (fontSize != i2) {
                TbadkCoreApplication.getInst().setFontSize(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
            }
            BdToast.h(TbadkCoreApplication.getInst(), b(), R.drawable.icon_word_t_size, 0, false).q();
        }
    }
}
