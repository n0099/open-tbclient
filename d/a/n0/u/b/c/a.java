package d.a.n0.u.b.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(getAgent(), true)));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        return false;
    }
}
