package d.a.i0.f0.m;

import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import d.a.i0.f0.b;
import d.a.i0.z0.e;
/* loaded from: classes3.dex */
public class a implements b<BackBaiduBoxViewEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.f0.b
    /* renamed from: a */
    public boolean onEvent(BackBaiduBoxViewEvent backBaiduBoxViewEvent) {
        if (backBaiduBoxViewEvent == null) {
            return false;
        }
        e.m().v(backBaiduBoxViewEvent.isShow);
        return true;
    }
}
