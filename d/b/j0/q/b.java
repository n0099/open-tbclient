package d.b.j0.q;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import d.b.c.c.f.j;
import d.b.j0.q.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f59380a;

    public b() {
        super(304001);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
    @Override // d.b.c.c.f.g
    public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        c(socketResponsedMessage2);
        return socketResponsedMessage2;
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
            d.b.j0.q.f.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            this.f59380a = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
            if (addressListData != null) {
                for (e eVar : addressListData.a()) {
                    List<d.b.i0.s.f.a> a2 = eVar.a();
                    ArrayList arrayList = new ArrayList();
                    for (d.b.i0.s.f.a aVar : a2) {
                        if (!this.f59380a && aVar.i() == 1) {
                            arrayList.add(aVar);
                        }
                    }
                    a2.removeAll(arrayList);
                }
            }
        }
        return socketResponsedMessage;
    }
}
