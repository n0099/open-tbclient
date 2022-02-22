package j.a.a.b;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import java.util.List;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes5.dex */
public interface a {
    void addLogDelegate(IRLogDelegate iRLogDelegate);

    void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig);

    List<IRevenue> getAllRevenue();

    IMiddleRevenue getMiddleRevenue(int i2, int i3);

    IRevenue getRevenue(int i2, int i3);

    void removeRevenueConfig(int i2, int i3);

    void updateMiddleRevenueConfig(int i2, int i3, Long l, String str);
}
