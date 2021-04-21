package d.b.j0.q0.n2;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.UrlManager;
/* loaded from: classes4.dex */
public class h {
    public static void a(TbPageContext tbPageContext, String str) {
        b(tbPageContext, str, null);
    }

    public static void b(TbPageContext tbPageContext, String str, String str2) {
        if (str2 != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str2});
        }
        TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(str);
    }
}
