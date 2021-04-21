package d.b.i0.s0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    public static final boolean a(TbPageContext<?> tbPageContext, View view) {
        boolean z = false;
        if (tbPageContext == null || view == null) {
            return false;
        }
        tbPageContext.getLayoutMode().k((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true);
        tbPageContext.getLayoutMode().j(view);
        return true;
    }
}
