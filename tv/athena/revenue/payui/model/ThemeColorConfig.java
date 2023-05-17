package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Ltv/athena/revenue/payui/model/ThemeColorConfig;", "", "themeResId", "Ljava/lang/Integer;", "getThemeResId", "()Ljava/lang/Integer;", "setThemeResId", "(Ljava/lang/Integer;)V", "<init>", "()V", "MiddleUiConfigBuilder", "payui-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ThemeColorConfig {
    public Integer themeResId;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Ltv/athena/revenue/payui/model/ThemeColorConfig$MiddleUiConfigBuilder;", "Ltv/athena/revenue/payui/model/ThemeColorConfig;", "build", "()Ltv/athena/revenue/payui/model/ThemeColorConfig;", "", "themeResId", "setTheme", "(I)Ltv/athena/revenue/payui/model/ThemeColorConfig$MiddleUiConfigBuilder;", "Ljava/lang/Integer;", "getThemeResId", "()Ljava/lang/Integer;", "setThemeResId", "(Ljava/lang/Integer;)V", "<init>", "()V", "payui-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class MiddleUiConfigBuilder {
        public Integer themeResId;

        public final ThemeColorConfig build() {
            ThemeColorConfig themeColorConfig = new ThemeColorConfig();
            themeColorConfig.setThemeResId(this.themeResId);
            return themeColorConfig;
        }

        public final Integer getThemeResId() {
            return this.themeResId;
        }

        public final MiddleUiConfigBuilder setTheme(int i) {
            this.themeResId = Integer.valueOf(i);
            return this;
        }

        public final void setThemeResId(Integer num) {
            this.themeResId = num;
        }
    }

    public final Integer getThemeResId() {
        return this.themeResId;
    }

    public final void setThemeResId(Integer num) {
        this.themeResId = num;
    }
}
