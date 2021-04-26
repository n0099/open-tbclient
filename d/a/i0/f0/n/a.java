package d.a.i0.f0.n;

import android.app.Activity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import d.a.i0.a.o;
import d.a.i0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<CompeteTaskEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.f0.b
    /* renamed from: a */
    public boolean onEvent(CompeteTaskEvent competeTaskEvent) {
        CompleteTaskToastData completeTaskToastData;
        if (competeTaskEvent != null && (completeTaskToastData = competeTaskEvent.taskToastData) != null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof o) {
                ((o) currentActivity).onMissionCompleted(completeTaskToastData);
                return true;
            }
        }
        return false;
    }
}
