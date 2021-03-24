package d.b.b.i;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.StatisticCallback;
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
        RequestParams requestParams = new RequestParams();
        requestParams.setRunType(str);
        if (TextUtils.equals(str, "0")) {
            requestParams.addChannel(d.b.b.g.c.d().c());
            if (BdLog.isDebugMode()) {
                BdLog.d("requestParams size " + requestParams.getChannelList());
            }
        }
        return requestParams;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public StatisticCallback getStatisticCallback() {
        return new d();
    }
}
