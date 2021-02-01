package com.qq.e.comm.managers.setting;

import com.qq.e.comm.constants.Constants;
/* loaded from: classes15.dex */
public final class b extends d {
    public b() {
        a(Constants.KEYS.SDKServerGetADReportSamplingRate, (Object) 1);
        a(Constants.KEYS.SDKServerExpReportSamplingRate, (Object) 1);
        a(Constants.KEYS.SDKServerClickReportSamplingRate, (Object) 100);
        a(Constants.KEYS.RequireWindowFocus, (Object) 1);
        a(Constants.KEYS.SHOW_LOGO, (Object) 1);
        a(Constants.KEYS.INNER_BROWSER_SCHEME, "weixin,tel,openapp.jdmobile");
        a(Constants.KEYS.FLOW_CONTROL, (Object) 1);
        a(Constants.KEYS.GDT_SDK_IDENTITY, (Object) 1);
        a(Constants.KEYS.Banner_RF, (Object) 30000);
        a(Constants.KEYS.SPLASH_LOADTIMEOUT, (Object) 3000);
        a(Constants.KEYS.SPLASH_EXPOSURE_TIME, (Object) 5000);
        a(Constants.KEYS.SPLASH_NETWORK_PERMISION, (Object) 26);
        a(Constants.KEYS.SPLASH_MAX_REQUEST_NUM, (Object) 100);
        a(Constants.KEYS.FORCE_EXPOSURE, (Object) 1);
    }

    @Override // com.qq.e.comm.managers.setting.d
    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
