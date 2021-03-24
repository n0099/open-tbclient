package d.b.h0.r0;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes.dex */
public class e extends d.b.b.c.f.c {
    public e(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.c.f.g
    /* renamed from: c */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if ((httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001536) && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            ReloginManager g2 = ReloginManager.g();
            if (((JsonHttpResponsedMessage) httpResponsedMessage).getError() == 1) {
                if (httpMessage.removeParam("reloin_key") == null) {
                    httpMessage.addParam("reloin_key", "reloin_value");
                    g2.l((HttpMessage) httpResponsedMessage.getOrginalMessage());
                } else {
                    g2.f(null);
                }
                return null;
            }
        }
        return httpResponsedMessage;
    }
}
