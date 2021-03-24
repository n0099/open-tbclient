package d.b.i0.n2;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogReqNetMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PushDialogActivity f57138a;

    /* renamed from: b  reason: collision with root package name */
    public String f57139b;

    /* renamed from: c  reason: collision with root package name */
    public long f57140c;

    /* renamed from: d.b.i0.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1359a extends d.b.b.c.g.a {
        public C1359a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof PushDialogHttpResMsg) {
                a.this.f((PushDialogHttpResMsg) responsedMessage);
            } else if (responsedMessage instanceof PushDialogSocketResMsg) {
                a.this.g((PushDialogSocketResMsg) responsedMessage);
            }
        }
    }

    public a(PushDialogActivity pushDialogActivity) {
        this.f57138a = pushDialogActivity;
        pushDialogActivity.registerListener(new C1359a(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614));
        Intent intent = this.f57138a.getIntent();
        if (intent != null) {
            this.f57139b = intent.getStringExtra("thread_id");
            this.f57140c = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.f57139b)) {
                this.f57138a.finish();
            }
        }
    }

    public long c() {
        return this.f57140c;
    }

    public String d() {
        return this.f57139b;
    }

    public void e() {
        long f2 = d.b.b.e.m.b.f(this.f57139b, 0L);
        if (f2 == 0) {
            PushDialogActivity pushDialogActivity = this.f57138a;
            if (pushDialogActivity != null) {
                pushDialogActivity.onNetCallback(false, null);
                return;
            }
            return;
        }
        PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
        pushDialogReqNetMsg.setTask_id(this.f57140c);
        pushDialogReqNetMsg.setTid(f2);
        MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
    }

    public final void f(PushDialogHttpResMsg pushDialogHttpResMsg) {
        PushDialogActivity pushDialogActivity = this.f57138a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(pushDialogHttpResMsg.getError() == 0, pushDialogHttpResMsg.getData());
        }
    }

    public final void g(PushDialogSocketResMsg pushDialogSocketResMsg) {
        PushDialogActivity pushDialogActivity = this.f57138a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
        }
    }
}
