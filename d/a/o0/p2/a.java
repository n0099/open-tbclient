package d.a.o0.p2;

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
    public PushDialogActivity f61957a;

    /* renamed from: b  reason: collision with root package name */
    public String f61958b;

    /* renamed from: c  reason: collision with root package name */
    public long f61959c;

    /* renamed from: d.a.o0.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1530a extends d.a.c.c.g.a {
        public C1530a(int i2, int i3) {
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
        this.f61957a = pushDialogActivity;
        pushDialogActivity.registerListener(new C1530a(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614));
        Intent intent = this.f61957a.getIntent();
        if (intent != null) {
            this.f61958b = intent.getStringExtra("thread_id");
            this.f61959c = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.f61958b)) {
                this.f61957a.finish();
            }
        }
    }

    public long c() {
        return this.f61959c;
    }

    public String d() {
        return this.f61958b;
    }

    public void e() {
        long f2 = d.a.c.e.m.b.f(this.f61958b, 0L);
        if (f2 == 0) {
            PushDialogActivity pushDialogActivity = this.f61957a;
            if (pushDialogActivity != null) {
                pushDialogActivity.onNetCallback(false, null);
                return;
            }
            return;
        }
        PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
        pushDialogReqNetMsg.setTask_id(this.f61959c);
        pushDialogReqNetMsg.setTid(f2);
        MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
    }

    public final void f(PushDialogHttpResMsg pushDialogHttpResMsg) {
        PushDialogActivity pushDialogActivity = this.f61957a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(pushDialogHttpResMsg.getError() == 0, pushDialogHttpResMsg.getData());
        }
    }

    public final void g(PushDialogSocketResMsg pushDialogSocketResMsg) {
        PushDialogActivity pushDialogActivity = this.f61957a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
        }
    }
}
