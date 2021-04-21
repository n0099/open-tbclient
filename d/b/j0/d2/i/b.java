package d.b.j0.d2.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    public static void a(int i) {
        if (TbadkCoreApplication.getInst().getFontSize() != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
    }

    public static String b() {
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

    public static void c() {
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        int i = 3;
        if (fontSize == 0) {
            i = 1;
        } else if (fontSize == 1) {
            i = 2;
        }
        if (fontSize != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
        BdToast.h(TbadkCoreApplication.getInst(), b(), R.drawable.icon_word_t_size, 0, false).q();
    }

    public static void d() {
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        int i = 2;
        if (fontSize == 0 || fontSize == 1) {
            i = 0;
        } else if (fontSize == 2) {
            i = 1;
        }
        if (fontSize != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
        BdToast.h(TbadkCoreApplication.getInst(), b(), R.drawable.icon_word_t_size, 0, false).q();
    }
}
