package d.a.c.i;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.StatisticCallback;
import d.a.c.j.g;
import java.util.Collections;
import java.util.List;
@Singleton
@Service
/* loaded from: classes.dex */
public class b implements IPmsContext {
    @Override // com.baidu.searchbox.pms.IPmsContext
    public boolean checkChannelAllow(String str, String str2) {
        return true;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public List<RequestParams.Channel> getLongConnectParams() {
        return Collections.emptyList();
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public RequestParams getRegisterParams(String str) {
        return getRegisterParams(str, "aps");
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public StatisticCallback getStatisticCallback() {
        return new d();
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public RequestParams getRegisterParams(String str, String str2) {
        RequestParams requestParams = new RequestParams();
        requestParams.setRunType(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "aps";
        }
        requestParams.setRunNode(str2);
        if ("0".equals(str)) {
            requestParams.addChannel(d.a.c.g.c.d().c());
            requestParams.addChannel(new g());
        }
        return requestParams;
    }
}
