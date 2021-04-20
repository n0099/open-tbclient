package d.b.i0.e1.l;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import d.b.i0.e1.d;
import d.b.i0.e1.e;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends d.b.c.c.f.a {
    public b() {
        super(2016007);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.f.g
    /* renamed from: c */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        List<ImMessageCenterPojo> data;
        ImMessageCenterPojo imMessageCenterPojo = null;
        if (customResponsedMessage == null) {
            return null;
        }
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            if (responsedMemoryListMessage.getType() == 1 && (data = responsedMemoryListMessage.getData()) != null) {
                ImMessageCenterPojo imMessageCenterPojo2 = null;
                for (ImMessageCenterPojo imMessageCenterPojo3 : data) {
                    if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == -8) {
                        imMessageCenterPojo = imMessageCenterPojo3;
                    }
                    if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == -7) {
                        imMessageCenterPojo2 = imMessageCenterPojo3;
                    }
                }
                if (imMessageCenterPojo != null) {
                    data.remove(imMessageCenterPojo);
                    data.add(d.a(imMessageCenterPojo));
                }
                if (imMessageCenterPojo2 != null) {
                    data.remove(imMessageCenterPojo2);
                    data.add(e.a(imMessageCenterPojo2));
                }
            }
        }
        return customResponsedMessage;
    }
}
