package d.b.i0.i0.d;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<i> f55493a;

    public void a(List<FrsTabInfo> list) {
        if (this.f55493a == null) {
            this.f55493a = new ArrayList<>();
        }
        this.f55493a.clear();
        if (list == null) {
            return;
        }
        for (FrsTabInfo frsTabInfo : list) {
            if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                this.f55493a.add(new i(frsTabInfo));
            }
        }
    }
}
