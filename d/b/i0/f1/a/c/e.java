package d.b.i0.f1.a.c;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import protobuf.CommitInviteMsg.DataReq;
/* loaded from: classes4.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public RequestCommitInviteMessage f55781e;

    /* renamed from: f  reason: collision with root package name */
    public long f55782f;

    /* renamed from: g  reason: collision with root package name */
    public long f55783g;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return true;
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f55782f = bundle.getLong("gid", -1L);
        this.f55783g = bundle.getLong("groupid", -1L);
    }

    public void initWithIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f55782f = intent.getLongExtra("gid", -1L);
        this.f55783g = intent.getLongExtra("groupid", -1L);
    }

    public final RequestCommitInviteMessage s(long j, long j2, String str) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(j);
        builder.msgType = 5;
        builder.toUids = str;
        builder.content = "{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(j2) + "}";
        RequestCommitInviteMessage requestCommitInviteMessage = new RequestCommitInviteMessage();
        requestCommitInviteMessage.setReqData(builder.build(false));
        return requestCommitInviteMessage;
    }

    public void t(Bundle bundle) {
        bundle.putLong("gid", this.f55782f);
        bundle.putLong("groupid", this.f55783g);
    }

    public void u(String str) {
        RequestCommitInviteMessage s = s(this.f55782f, this.f55783g, str);
        this.f55781e = s;
        super.sendMessage(s);
    }
}
