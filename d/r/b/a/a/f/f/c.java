package d.r.b.a.a.f.f;

import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
/* loaded from: classes7.dex */
public class c {
    public String appName;
    public String deviceId;
    public float reportRatio;
    public IReporter reporter;

    public c(String str, String str2, float f2, IReporter iReporter) {
        this.appName = str;
        this.deviceId = str2;
        this.reportRatio = f2;
        this.reporter = iReporter;
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

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void setReportRatio(float f2) {
        this.reportRatio = f2;
    }

    public final void setReporter(IReporter iReporter) {
        this.reporter = iReporter;
    }
}
