package d.a.o0.p1;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.mainentrance.RequestSearchPersonHistoryReadMessage;
import com.baidu.tieba.mainentrance.ResponseSearchPersonHistoryReadMessage;
import d.a.c.e.d.l;
import d.a.c.e.p.p;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements CustomMessageTask.CustomRunnable<Object> {
    public static final List<String> a(List<l.b<String>> list) {
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (l.b<String> bVar : list) {
                String str = bVar.f42297a;
                if (!TextUtils.isEmpty(str)) {
                    linkedList.add(str);
                }
            }
        }
        return linkedList;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchPersonHistoryReadMessage)) {
            return null;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        List<String> a2 = a(p.b(d.a.n0.r.r.a.f().h("tb.searchperson_history", currentAccount)));
        ResponseSearchPersonHistoryReadMessage responseSearchPersonHistoryReadMessage = new ResponseSearchPersonHistoryReadMessage();
        responseSearchPersonHistoryReadMessage.datas.addAll(a2);
        return responseSearchPersonHistoryReadMessage;
    }
}
