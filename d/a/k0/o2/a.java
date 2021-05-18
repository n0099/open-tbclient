package d.a.k0.o2;

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
    public PushDialogActivity f58032a;

    /* renamed from: b  reason: collision with root package name */
    public String f58033b;

    /* renamed from: c  reason: collision with root package name */
    public long f58034c;

    /* renamed from: d.a.k0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1460a extends d.a.c.c.g.a {
        public C1460a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof PushDialogHttpResMsg) {
                a.this.f((PushDialogHttpResMsg) responsedMessage);
            } else if (responsedMessage instanceof PushDialogSocketResMsg) {
                a.this.g((PushDialogSocketResMsg) responsedMessage);
            }
        }
    }

    public a(PushDialogActivity pushDialogActivity) {
        this.f58032a = pushDialogActivity;
        pushDialogActivity.registerListener(new C1460a(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614));
        Intent intent = this.f58032a.getIntent();
        if (intent != null) {
            this.f58033b = intent.getStringExtra("thread_id");
            this.f58034c = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.f58033b)) {
                this.f58032a.finish();
            }
        }
    }

    public long c() {
        return this.f58034c;
    }

    public String d() {
        return this.f58033b;
    }

    public void e() {
        long f2 = d.a.c.e.m.b.f(this.f58033b, 0L);
        if (f2 == 0) {
            PushDialogActivity pushDialogActivity = this.f58032a;
            if (pushDialogActivity != null) {
                pushDialogActivity.onNetCallback(false, null);
                return;
            }
            return;
        }
        PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
        pushDialogReqNetMsg.setTask_id(this.f58034c);
        pushDialogReqNetMsg.setTid(f2);
        MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
    }

    public final void f(PushDialogHttpResMsg pushDialogHttpResMsg) {
        PushDialogActivity pushDialogActivity = this.f58032a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(pushDialogHttpResMsg.getError() == 0, pushDialogHttpResMsg.getData());
        }
    }

    public final void g(PushDialogSocketResMsg pushDialogSocketResMsg) {
        PushDialogActivity pushDialogActivity = this.f58032a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
        }
    }
}
