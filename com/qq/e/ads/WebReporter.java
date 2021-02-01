package com.qq.e.ads;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.pi.WRI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes15.dex */
public class WebReporter {

    /* renamed from: a  reason: collision with root package name */
    private WRI f11425a;

    public WebReporter(Context context, String str, String str2, long j) {
        if (StringUtil.isEmpty(str)) {
            GDTLogger.e("init web reporter fail with error params");
            return;
        }
        try {
            if (GDTADManager.getInstance().initWith(context, str)) {
                this.f11425a = GDTADManager.getInstance().getPM().getPOFactory().getWebReporterDelegate(str2, j);
            } else {
                GDTLogger.e("SDK is not ready!");
            }
        } catch (a e) {
            GDTLogger.e("Web reporter created by factory return null");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void report(String str, int i) {
        if (this.f11425a != null) {
            this.f11425a.report(str, i);
        }
    }
}
