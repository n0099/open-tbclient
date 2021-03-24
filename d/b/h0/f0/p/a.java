package d.b.h0.f0.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.b.h0.a.c;
import d.b.h0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<MissionEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.f0.b
    /* renamed from: a */
    public boolean onEvent(MissionEvent missionEvent) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            int i = missionEvent.pageId;
            int i2 = missionEvent.pageType;
            long j = missionEvent.tid;
            String str = missionEvent.actionType;
            if (MissionEvent.MESSAGE_RESUME.equals(str)) {
                c.y().K(i, j);
                c.y().P(i2, j);
            } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
                c.y().E();
            } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
                c.y().F();
            } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
                c.y().K(i, j);
            }
            return true;
        }
        return false;
    }
}
