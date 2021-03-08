package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class ce extends Handler {
    public final /* synthetic */ ck qlw;

    public ce(ck ckVar) {
        this.qlw = ckVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        Context context;
        int i = message.what;
        try {
            if (i == 11) {
                str = (String) message.obj;
                bx iT = ca.iT(this.qlw.f8146a);
                try {
                    iT.qlo = ca.a("ps", new cd(this.qlw.qlv));
                    iT.P(BdStatsConstant.StatsKey.COUNT, 2002);
                    iT.hD("msg", str);
                } catch (JSONException e) {
                }
                iT.a();
                context = this.qlw.f8146a;
            } else if (i == 12) {
                str = (String) message.obj;
                context = this.qlw.f8146a;
            } else {
                return;
            }
            cb.i(context, Uri.parse(str));
        } catch (Exception e2) {
        }
    }
}
