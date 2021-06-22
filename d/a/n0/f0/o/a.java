package d.a.n0.f0.o;

import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import d.a.n0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<CurrentPageTypeEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.f0.b
    /* renamed from: a */
    public boolean onEvent(CurrentPageTypeEvent currentPageTypeEvent) {
        if (currentPageTypeEvent == null) {
            return false;
        }
        CurrentPageTypeHelper.currentPageType = currentPageTypeEvent.currentPageType;
        return true;
    }
}
