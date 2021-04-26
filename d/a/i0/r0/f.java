package d.a.i0.r0;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class f extends d.a.c.c.f.d {
    public f(int i2) {
        super(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.f.f
    /* renamed from: a */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask == null || !(httpMessageTask instanceof TbHttpMessageTask)) {
            return httpMessage;
        }
        TbHttpMessageTask tbHttpMessageTask = (TbHttpMessageTask) httpMessageTask;
        if (httpMessage.removeParam("reloin_key") == null && ReloginManager.g().h() && tbHttpMessageTask.isNeedLogin()) {
            httpMessage.addParam("reloin_key", "reloin_value");
            ReloginManager.g().l(httpMessage);
            return null;
        }
        return httpMessage;
    }
}
