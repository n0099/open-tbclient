package d.a.j0.e1.l;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import d.a.j0.e1.d;
import d.a.j0.e1.e;
/* loaded from: classes4.dex */
public class a extends d.a.c.c.f.a {
    public a() {
        super(2016004);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.f.g
    /* renamed from: c */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null) {
            return null;
        }
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data != null && data.getCustomGroupType() == -8) {
                return new MemoryChangedMessage(d.a(data), memoryChangedMessage.isFromServer(), memoryChangedMessage.getType());
            }
            if (data != null && data.getCustomGroupType() == -7) {
                return new MemoryChangedMessage(e.a(data), memoryChangedMessage.isFromServer(), memoryChangedMessage.getType());
            }
        }
        return customResponsedMessage;
    }
}
