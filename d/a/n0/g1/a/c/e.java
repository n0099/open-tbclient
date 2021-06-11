package d.a.n0.g1.a.c;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import protobuf.CommitInviteMsg.DataReq;
/* loaded from: classes4.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public RequestCommitInviteMessage f58665e;

    /* renamed from: f  reason: collision with root package name */
    public long f58666f;

    /* renamed from: g  reason: collision with root package name */
    public long f58667g;

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
        this.f58666f = bundle.getLong("gid", -1L);
        this.f58667g = bundle.getLong("groupid", -1L);
    }

    public void initWithIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f58666f = intent.getLongExtra("gid", -1L);
        this.f58667g = intent.getLongExtra("groupid", -1L);
    }

    public final RequestCommitInviteMessage w(long j, long j2, String str) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(j);
        builder.msgType = 5;
        builder.toUids = str;
        builder.content = "{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(j2) + "}";
        RequestCommitInviteMessage requestCommitInviteMessage = new RequestCommitInviteMessage();
        requestCommitInviteMessage.setReqData(builder.build(false));
        return requestCommitInviteMessage;
    }

    public void x(Bundle bundle) {
        bundle.putLong("gid", this.f58666f);
        bundle.putLong("groupid", this.f58667g);
    }

    public void y(String str) {
        RequestCommitInviteMessage w = w(this.f58666f, this.f58667g, str);
        this.f58665e = w;
        super.sendMessage(w);
    }
}
