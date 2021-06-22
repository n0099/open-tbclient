package d.a.n0.f0.s;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import d.a.n0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<PrePageKeyEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.f0.b
    /* renamed from: a */
    public boolean onEvent(PrePageKeyEvent prePageKeyEvent) {
        if (prePageKeyEvent == null && StringUtil.isEmpty(prePageKeyEvent.prePageKey)) {
            return false;
        }
        TbPageExtraHelper.u(prePageKeyEvent.prePageKey);
        return true;
    }
}
