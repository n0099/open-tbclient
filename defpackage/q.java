package defpackage;

import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.social.core.WidgetPreferenceManager;
import com.baidu.cloudsdk.social.core.WidgetStatisticsManager;
/* renamed from: q  reason: default package */
/* loaded from: classes.dex */
public class q extends HttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WidgetPreferenceManager f2936a;
    final /* synthetic */ String b;
    final /* synthetic */ WidgetStatisticsManager c;

    public q(WidgetStatisticsManager widgetStatisticsManager, WidgetPreferenceManager widgetPreferenceManager, String str) {
        this.c = widgetStatisticsManager;
        this.f2936a = widgetPreferenceManager;
        this.b = str;
    }

    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    protected void onSuccess(int i, String str) {
        this.f2936a.setWidgetActivated(this.b);
    }
}
