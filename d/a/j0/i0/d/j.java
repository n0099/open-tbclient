package d.a.j0.i0.d;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<i> f54964a;

    public void a(List<FrsTabInfo> list) {
        if (this.f54964a == null) {
            this.f54964a = new ArrayList<>();
        }
        this.f54964a.clear();
        if (list == null) {
            return;
        }
        for (FrsTabInfo frsTabInfo : list) {
            if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                this.f54964a.add(new i(frsTabInfo));
            }
        }
    }
}
