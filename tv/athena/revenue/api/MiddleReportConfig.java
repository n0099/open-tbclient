package tv.athena.revenue.api;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ReportConfig;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Ltv/athena/revenue/api/MiddleReportConfig;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/ReportConfig;", "Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "builder", "<init>", "(Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;)V", "MiddleReportConfigBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class MiddleReportConfig extends ReportConfig {

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0006\u0010\u0015R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\t\u0010\u0015R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\f\u0010\u001aR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0010\u0010\u001e¨\u0006!"}, d2 = {"Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "Ltv/athena/revenue/api/MiddleReportConfig;", "build", "()Ltv/athena/revenue/api/MiddleReportConfig;", "", "appName", "setAppName", "(Ljava/lang/String;)Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "deviceId", "setDeviceId", "", "reportRatio", "setReportRatio", "(F)Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "reporter", "setReporter", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;)Ltv/athena/revenue/api/MiddleReportConfig$MiddleReportConfigBuilder;", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getDeviceId", "F", "getReportRatio", "()F", "(F)V", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "getReporter", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;)V", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class MiddleReportConfigBuilder {
        public IReporter reporter;
        public String appName = "";
        public float reportRatio = 1.0f;
        public String deviceId = "";

        public final MiddleReportConfig build() {
            return new MiddleReportConfig(this);
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final float getReportRatio() {
            return this.reportRatio;
        }

        public final IReporter getReporter() {
            return this.reporter;
        }

        /* renamed from: setAppName  reason: collision with other method in class */
        public final void m1990setAppName(String str) {
            this.appName = str;
        }

        /* renamed from: setDeviceId  reason: collision with other method in class */
        public final void m1991setDeviceId(String str) {
            this.deviceId = str;
        }

        /* renamed from: setReportRatio  reason: collision with other method in class */
        public final void m1992setReportRatio(float f2) {
            this.reportRatio = f2;
        }

        /* renamed from: setReporter  reason: collision with other method in class */
        public final void m1993setReporter(IReporter iReporter) {
            this.reporter = iReporter;
        }

        public final MiddleReportConfigBuilder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public final MiddleReportConfigBuilder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public final MiddleReportConfigBuilder setReportRatio(float f2) {
            this.reportRatio = f2;
            return this;
        }

        public final MiddleReportConfigBuilder setReporter(IReporter iReporter) {
            this.reporter = iReporter;
            return this;
        }
    }

    public MiddleReportConfig(MiddleReportConfigBuilder middleReportConfigBuilder) {
        super(middleReportConfigBuilder.getAppName(), middleReportConfigBuilder.getDeviceId(), middleReportConfigBuilder.getReportRatio(), middleReportConfigBuilder.getReporter());
        setAppName(middleReportConfigBuilder.getAppName());
        setReportRatio(middleReportConfigBuilder.getReportRatio());
        setReporter(middleReportConfigBuilder.getReporter());
    }
}
