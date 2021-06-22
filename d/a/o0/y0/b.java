package d.a.o0.y0;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes4.dex */
public class b extends d.a.c.c.f.c {
    public b() {
        super(0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
    @Override // d.a.c.c.f.g
    public /* bridge */ /* synthetic */ HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        c(httpResponsedMessage2);
        return httpResponsedMessage2;
    }

    public HttpResponsedMessage c(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getError() == 1990055 && !a.c(httpResponsedMessage.getCmd())) {
            a.d();
        }
        return httpResponsedMessage;
    }
}
