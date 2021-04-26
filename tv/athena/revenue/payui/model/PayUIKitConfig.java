package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import tv.athena.revenue.api.MiddleRevenueConfig;
@Keep
/* loaded from: classes7.dex */
public class PayUIKitConfig {
    public MiddleRevenueConfig revenueConfig;

    @Keep
    /* loaded from: classes7.dex */
    public static class PayUIKitConfigBuilder {
        public MiddleRevenueConfig revenueConfig;

        public PayUIKitConfig builder() {
            return new PayUIKitConfig(this);
        }

        public PayUIKitConfigBuilder setRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
            this.revenueConfig = middleRevenueConfig;
            return this;
        }
    }

    public PayUIKitConfig(PayUIKitConfigBuilder payUIKitConfigBuilder) {
        this.revenueConfig = payUIKitConfigBuilder.revenueConfig;
    }
}
