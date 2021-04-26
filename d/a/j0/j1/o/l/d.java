package d.a.j0.j1.o.l;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
/* loaded from: classes4.dex */
public class d {
    public static c a(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof d.a.j0.j1.b)) {
            return null;
        }
        return ((d.a.j0.j1.b) tbPageContext.getPageActivity()).getFloatVideoContainer();
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof d.a.j0.j1.b)) {
            return null;
        }
        return ((d.a.j0.j1.b) tbPageContext.getPageActivity()).getLegoListFragment();
    }

    public static n c(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof d.a.j0.j1.b)) {
            return null;
        }
        return ((d.a.j0.j1.b) tbPageContext.getPageActivity()).getPlaySwitchController();
    }
}
