package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Keep;
import d.r.b.a.a.i.c.g;
import d.r.b.a.a.i.c.h;
import i.a.a.e.j.b;
import i.a.a.e.m.a;
import java.util.List;
@Keep
/* loaded from: classes8.dex */
public interface IYYPayAmountView extends a {

    @Keep
    /* loaded from: classes8.dex */
    public interface Callback {
        void onFail(int i2, String str);

        void showInputNumberDialog(Activity activity, List<g> list);

        void toPayWayDialog(b bVar, List<g> list);
    }

    @Keep
    /* loaded from: classes8.dex */
    public static class ViewParams {
        public String currencyName;
        public int defaultAmount;
        public String defaultCid;
        public String payAmountDialogTitle;
        public h paysSettingInfo;
    }

    @Override // i.a.a.e.m.a
    /* synthetic */ View getContentView();

    /* synthetic */ void refreshView();

    void setCallback(Callback callback);
}
