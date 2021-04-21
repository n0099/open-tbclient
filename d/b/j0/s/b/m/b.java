package d.b.j0.s.b.m;

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

    /* renamed from: d.b.j0.s.b.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class DialogInterface$OnCancelListenerC1593b implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1593b() {
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

    public final int b(int i, String str) {
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
        return i;
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
        d.b.j0.s.b.m.a aVar = new d.b.j0.s.b.m.a();
        try {
            aVar.n(new JSONObject(str));
            TbadkCoreApplication.getInst().setCurAiAppid(aVar.f0);
            if (!TextUtils.isEmpty(aVar.l())) {
                int b2 = b(-1, aVar.l());
                if (!TextUtils.isEmpty(aVar.k()) && !TextUtils.isEmpty(aVar.j())) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage.addParam("scheme", aVar.k());
                    httpMessage.setExtra(new d.b.i0.r.m.a(aVar, activity, b2, new a()));
                    MessageManager.getInstance().sendMessage(httpMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, b2, aVar, true));
                d(d.b.i0.s.g.a.b(activity, b2));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13530").param("obj_id", aVar.f0).param("obj_type", aVar.g0).param("obj_source", aVar.h0));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface$OnCancelListenerC1593b();
            shareDialogConfig.onDismissListener = new c(this);
            JSONArray m = aVar.m();
            if (m != null && !TextUtils.isEmpty(aVar.k()) && !TextUtils.isEmpty(aVar.j())) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < m.length(); i++) {
                    try {
                        arrayList.add(Integer.valueOf(b(-1, m.getString(i))));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    aVar.g(arrayList);
                }
                HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                httpMessage2.addParam("scheme", aVar.k());
                httpMessage2.setExtra(new d.b.i0.r.m.a(aVar, activity, shareDialogConfig.onCancelListener));
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
