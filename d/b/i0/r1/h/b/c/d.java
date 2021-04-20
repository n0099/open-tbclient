package d.b.i0.r1.h.b.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.edit.color.TailEditColorToolHost;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class d extends m {
    public d(TbPageContext<?> tbPageContext, int i, String str) {
        super(tbPageContext.getPageActivity(), TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 17, i);
        this.f51951d = R.drawable.tail_edit_tool_color_selector;
        this.f51953f = R.drawable.icon_pure_post_more_bubble64;
        this.k = new TailEditColorToolHost(tbPageContext, str);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
