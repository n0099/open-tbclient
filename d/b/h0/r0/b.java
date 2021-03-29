package d.b.h0.r0;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import d.b.b.c.f.j;
import d.b.h0.z0.p;
/* loaded from: classes3.dex */
public class b extends j {
    public b() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.c.f.g
    /* renamed from: c */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            return null;
        }
        if (socketResponsedMessage.getError() == 2260104) {
            p.a();
        }
        return socketResponsedMessage;
    }
}
