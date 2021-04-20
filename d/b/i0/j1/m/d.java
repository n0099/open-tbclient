package d.b.i0.j1.m;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class d implements d.b.h0.c.e {
    @Override // d.b.h0.c.e
    public String a() {
        return TbConfig.LIKE_ADDRESS;
    }

    @Override // d.b.h0.c.e
    public void b(HashMap<String, String> hashMap, f fVar) {
        if (fVar == null || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        String str = hashMap.get("fid");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = hashMap.get(TiebaStatic.Params.H5_FORUM_NAME);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(d.b.c.e.m.b.f(str, 0L))));
        TbadkCoreApplication.getInst().addLikeForum(str2);
    }
}
