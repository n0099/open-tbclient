package d.a.m0.f0.u;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import d.a.m0.b.c;
import d.a.m0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<SyncDataEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.f0.b
    /* renamed from: a */
    public boolean onEvent(SyncDataEvent syncDataEvent) {
        if (syncDataEvent == null) {
            return false;
        }
        TbSingleton.getInstance().setSampleId(syncDataEvent.sampleId);
        d.a.m0.z0.a.d().f(syncDataEvent.abtestExtraData);
        c.d().i(syncDataEvent.ubsABTest);
        return true;
    }
}
