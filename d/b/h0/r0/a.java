package d.b.h0.r0;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import d.b.h0.z0.p;
/* loaded from: classes.dex */
public class a extends d.b.b.c.f.c {
    public a() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.c.f.g
    /* renamed from: c */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null) {
            return null;
        }
        if (httpResponsedMessage.getError() == 2260104) {
            p.a();
        }
        return httpResponsedMessage;
    }
}
