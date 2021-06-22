package d.a.o0.o3.c;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.c.f.c;
/* loaded from: classes5.dex */
public class a extends c {
    public a() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.f.g
    /* renamed from: c */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null) {
            return null;
        }
        if (d.a.o0.o3.a.c(httpResponsedMessage.getError()) && httpResponsedMessage.getCmd() == 1001601) {
            d.a.o0.o3.a.d(TbadkCoreApplication.getInst().getCurrentActivity(), httpResponsedMessage.getErrorString());
        }
        return httpResponsedMessage;
    }
}
