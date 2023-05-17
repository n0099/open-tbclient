package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import tv.athena.revenue.api.MiddleRevenueConfig;
@Keep
/* loaded from: classes2.dex */
public class PayUIKitConfig {
    public ImageLoaderSupplier imageLoaderSupplier;
    public MiddleRevenueConfig revenueConfig;
    public ThemeColorConfig themeColorConfig;

    @Keep
    /* loaded from: classes2.dex */
    public static class PayUIKitConfigBuilder {
        public ImageLoaderSupplier imageLoaderSupplier;
        public MiddleRevenueConfig revenueConfig;
        public ThemeColorConfig themeColorConfig;

        public PayUIKitConfig builder() {
            return new PayUIKitConfig(this);
        }

        public PayUIKitConfigBuilder setImageLoaderSupplier(ImageLoaderSupplier imageLoaderSupplier) {
            this.imageLoaderSupplier = imageLoaderSupplier;
            return this;
        }

        public PayUIKitConfigBuilder setRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
            this.revenueConfig = middleRevenueConfig;
            return this;
        }

        public PayUIKitConfigBuilder setThemeColorConfig(ThemeColorConfig themeColorConfig) {
            this.themeColorConfig = themeColorConfig;
            return this;
        }
    }

    public PayUIKitConfig(PayUIKitConfigBuilder payUIKitConfigBuilder) {
        this.revenueConfig = payUIKitConfigBuilder.revenueConfig;
        this.themeColorConfig = payUIKitConfigBuilder.themeColorConfig;
        this.imageLoaderSupplier = payUIKitConfigBuilder.imageLoaderSupplier;
    }
}
