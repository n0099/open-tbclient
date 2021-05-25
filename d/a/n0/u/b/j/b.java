package d.a.n0.u.b.j;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.livesdk.api.share.Share;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends ActivityDelegation {

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.d(true);
        }
    }

    /* renamed from: d.a.n0.u.b.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class DialogInterface$OnCancelListenerC1634b implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1634b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.d(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c(b bVar) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public final int b(int i2, String str) {
        if (str.equals(Share.WEIXIN_FRIEND)) {
            return 3;
        }
        if (str.equals(Share.WEIXIN_TIMELINE)) {
            return 2;
        }
        if (str.equals(Share.QQFRIEND)) {
            return 8;
        }
        if (str.equals(Share.QQDENGLU)) {
            return 4;
        }
        if (str.equals(Share.SINAWEIBO)) {
            return 6;
        }
        return i2;
    }

    public final void c() {
    }

    public final void d(boolean z) {
        this.mResult.putBoolean("share_result", z);
        f();
        finish();
    }

    public final void e(Activity activity, String str) {
        if (activity == null) {
            d(false);
            return;
        }
        d.a.n0.u.b.j.a aVar = new d.a.n0.u.b.j.a();
        try {
            aVar.p(new JSONObject(str));
            TbadkCoreApplication.getInst().setCurAiAppid(aVar.h0);
            if (!TextUtils.isEmpty(aVar.n())) {
                int b2 = b(-1, aVar.n());
                if (!TextUtils.isEmpty(aVar.m()) && !TextUtils.isEmpty(aVar.l())) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage.addParam("scheme", aVar.m());
                    httpMessage.setExtra(new d.a.m0.r.m.a(aVar, activity, b2, new a()));
                    MessageManager.getInstance().sendMessage(httpMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, b2, aVar, true));
                d(d.a.m0.s.g.a.b(activity, b2));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13530").param("obj_id", aVar.h0).param("obj_type", aVar.i0).param("obj_source", aVar.j0));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface$OnCancelListenerC1634b();
            shareDialogConfig.onDismissListener = new c(this);
            JSONArray o = aVar.o();
            if (o != null && !TextUtils.isEmpty(aVar.m()) && !TextUtils.isEmpty(aVar.l())) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < o.length(); i2++) {
                    try {
                        arrayList.add(Integer.valueOf(b(-1, o.getString(i2))));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    aVar.h(arrayList);
                }
                HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                httpMessage2.addParam("scheme", aVar.m());
                httpMessage2.setExtra(new d.a.m0.r.m.a(aVar, activity, shareDialogConfig.onCancelListener));
                MessageManager.getInstance().sendMessage(httpMessage2);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } catch (JSONException unused) {
            d(false);
        }
    }

    public final void f() {
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        c();
        e(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        f();
    }
}
