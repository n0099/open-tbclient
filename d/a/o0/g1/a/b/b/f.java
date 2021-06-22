package d.a.o0.g1.a.b.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.n0.z0.n;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.s.e.a f58728a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f58729b;

    /* renamed from: g  reason: collision with root package name */
    public final BlackListModel f58734g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalTalkSettingActivity f58735h;

    /* renamed from: i  reason: collision with root package name */
    public e f58736i;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58730c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58731d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58732e = false;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f58733f = BdUniqueId.gen();
    public d.a.c.c.g.c j = new c(0);
    public CustomMessageListener k = new d(0);

    /* loaded from: classes4.dex */
    public class a extends f0<PersonalSettingItemData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f58737a;

        public a(f fVar, long j) {
            this.f58737a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            return d.a.o0.f1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f58737a));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<PersonalSettingItemData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f58738a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f58739b;

        public b(long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
            this.f58738a = j;
            this.f58739b = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
            if (personalSettingItemData != null) {
                f.this.f58732e = personalSettingItemData.isAcceptNotify();
            }
            RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
            requestQueryUserInfoMessage.setReqUserId(this.f58738a);
            this.f58739b.sendMessage(requestQueryUserInfoMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.c {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null) {
                return;
            }
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 104102) {
                if (socketResponsedMessage instanceof ResponsedMessage) {
                    f.this.f58735h.closeLoadingDialog();
                    if (socketResponsedMessage.getError() != 0) {
                        f.this.f58735h.showToast(socketResponsedMessage.getErrorString());
                    }
                }
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                        if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                            f.this.f58731d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                            if (f.this.f58736i != null) {
                                f.this.f58736i.updateUI();
                            }
                        }
                    }
                }
            } else if (cmd != 205003) {
            } else {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                    f.this.f58735h.hideProgressBar();
                    f.this.f58735h.showToast(socketResponsedMessage.getErrorString());
                } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                    ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                    if (responseQueryUserInfoMessage.getResData() != null) {
                        f.this.f58729b = responseQueryUserInfoMessage.getResData();
                        f fVar = f.this;
                        fVar.f58730c = fVar.f58729b.hasConcerned.intValue() == 1;
                        f fVar2 = f.this;
                        fVar2.f58731d = fVar2.f58729b.isBlacklist.intValue() == 1;
                        f.this.f58735h.hideProgressBar();
                        if (f.this.f58736i != null) {
                            f.this.f58736i.updateUI();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (f.this.f58735h == null || TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        return;
                    }
                    f.this.f58735h.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                f.this.f58730c = updateAttentionMessage.isAttention();
                if (f.this.f58735h != null) {
                    if (f.this.f58730c) {
                        f.this.f58735h.showToast(R.string.add_success);
                    } else {
                        f.this.f58735h.showToast(R.string.remove_succ);
                    }
                }
                if (f.this.f58736i != null) {
                    f.this.f58736i.updateUI();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void updateUI();
    }

    public f(PersonalTalkSettingActivity personalTalkSettingActivity, e eVar, long j) {
        this.f58735h = personalTalkSettingActivity;
        this.f58736i = eVar;
        this.f58728a = new d.a.n0.s.e.a(personalTalkSettingActivity.getPageContext());
        this.f58734g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        h0.c(new a(this, j), new b(j, personalTalkSettingActivity));
    }

    public CustomMessageListener i() {
        return this.k;
    }

    public DataRes j() {
        return this.f58729b;
    }

    public d.a.c.c.g.c k() {
        return this.j;
    }

    public boolean l() {
        return this.f58731d;
    }

    public boolean m() {
        return this.f58732e;
    }

    public void n() {
        d.a.n0.s.e.a aVar = this.f58728a;
        if (aVar != null) {
            aVar.g();
        }
        BlackListModel blackListModel = this.f58734g;
        if (blackListModel != null) {
            blackListModel.cancelLoadData();
        }
    }

    public void o(boolean z) {
        this.f58732e = z;
    }

    public void p(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.f58729b.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.f58733f);
        MessageManager.getInstance().removeMessage(104102, this.f58733f);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void q(boolean z) {
        this.f58735h.showLoadingDialog(null);
        if (z) {
            this.f58734g.addToBlackList(this.f58729b.id.longValue());
        } else {
            this.f58734g.removeFromBlackList(this.f58729b.id.longValue());
        }
    }
}
