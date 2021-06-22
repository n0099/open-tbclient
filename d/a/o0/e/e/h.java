package d.a.o0.e.e;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class h {
    public static b a(c cVar) {
        if (cVar != null && (cVar.a() instanceof TbPageContext) && (((TbPageContext) cVar.a()).getPageActivity() instanceof b)) {
            return (b) ((TbPageContext) cVar.a()).getPageActivity();
        }
        return null;
    }
}
