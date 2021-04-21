package d.b.j0.o2;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogReqNetMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PushDialogActivity f59259a;

    /* renamed from: b  reason: collision with root package name */
    public String f59260b;

    /* renamed from: c  reason: collision with root package name */
    public long f59261c;

    /* renamed from: d.b.j0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1447a extends d.b.c.c.g.a {
        public C1447a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof PushDialogHttpResMsg) {
                a.this.f((PushDialogHttpResMsg) responsedMessage);
            } else if (responsedMessage instanceof PushDialogSocketResMsg) {
                a.this.g((PushDialogSocketResMsg) responsedMessage);
            }
        }
    }

    public a(PushDialogActivity pushDialogActivity) {
        this.f59259a = pushDialogActivity;
        pushDialogActivity.registerListener(new C1447a(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614));
        Intent intent = this.f59259a.getIntent();
        if (intent != null) {
            this.f59260b = intent.getStringExtra("thread_id");
            this.f59261c = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.f59260b)) {
                this.f59259a.finish();
            }
        }
    }

    public long c() {
        return this.f59261c;
    }

    public String d() {
        return this.f59260b;
    }

    public void e() {
        long f2 = d.b.c.e.m.b.f(this.f59260b, 0L);
        if (f2 == 0) {
            PushDialogActivity pushDialogActivity = this.f59259a;
            if (pushDialogActivity != null) {
                pushDialogActivity.onNetCallback(false, null);
                return;
            }
            return;
        }
        PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
        pushDialogReqNetMsg.setTask_id(this.f59261c);
        pushDialogReqNetMsg.setTid(f2);
        MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
    }

    public final void f(PushDialogHttpResMsg pushDialogHttpResMsg) {
        PushDialogActivity pushDialogActivity = this.f59259a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(pushDialogHttpResMsg.getError() == 0, pushDialogHttpResMsg.getData());
        }
    }

    public final void g(PushDialogSocketResMsg pushDialogSocketResMsg) {
        PushDialogActivity pushDialogActivity = this.f59259a;
        if (pushDialogActivity != null) {
            pushDialogActivity.onNetCallback(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
        }
    }
}
