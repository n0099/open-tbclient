package d.b.i0.c2.k.e;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.UrlManager;
import java.util.Map;
/* loaded from: classes4.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static v0 f52851a;

    public static v0 a() {
        if (f52851a == null) {
            synchronized (v0.class) {
                if (f52851a == null) {
                    f52851a = new v0();
                }
            }
        }
        return f52851a;
    }

    public static boolean c(String str) {
        return str != null && str.contains("bookcover:");
    }

    public final boolean b(String str) {
        Map<String, String> paramPair;
        if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
            return false;
        }
        String str2 = paramPair.get("url");
        if (!TextUtils.isEmpty(str2)) {
            return b(d.b.b.e.p.k.getUrlDecode(str2));
        }
        String str3 = paramPair.get("tbgametype");
        return !TextUtils.isEmpty(str3) && str3.equals("1");
    }

    public final boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    public void e(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        str.contains("is_native_app=1");
        if (b(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
        } else if (d(str)) {
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{str}, true);
        } else {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
    }
}
