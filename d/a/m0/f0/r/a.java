package d.a.m0.f0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.m0.a.d;
import d.a.m0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<MissionEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.f0.b
    /* renamed from: a */
    public boolean onEvent(MissionEvent missionEvent) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            int i2 = missionEvent.pageId;
            int i3 = missionEvent.pageType;
            long j = missionEvent.tid;
            String str = missionEvent.actionType;
            if (MissionEvent.MESSAGE_RESUME.equals(str)) {
                d.y().K(i2, j);
                d.y().P(i3, j);
            } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
                d.y().E();
            } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
                d.y().F();
            } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
                d.y().K(i2, j);
            }
            return true;
        }
        return false;
    }
}
