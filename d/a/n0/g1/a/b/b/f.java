package d.a.n0.g1.a.b.b;

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
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.s.e.a f54914a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f54915b;

    /* renamed from: g  reason: collision with root package name */
    public final BlackListModel f54920g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalTalkSettingActivity f54921h;

    /* renamed from: i  reason: collision with root package name */
    public e f54922i;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54916c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54917d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54918e = false;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f54919f = BdUniqueId.gen();
    public d.a.c.c.g.c j = new c(0);
    public CustomMessageListener k = new d(0);

    /* loaded from: classes4.dex */
    public class a extends f0<PersonalSettingItemData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f54923a;

        public a(f fVar, long j) {
            this.f54923a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            return d.a.n0.f1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f54923a));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<PersonalSettingItemData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f54924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f54925b;

        public b(long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
            this.f54924a = j;
            this.f54925b = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
            if (personalSettingItemData != null) {
                f.this.f54918e = personalSettingItemData.isAcceptNotify();
            }
            RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
            requestQueryUserInfoMessage.setReqUserId(this.f54924a);
            this.f54925b.sendMessage(requestQueryUserInfoMessage);
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
                    f.this.f54921h.closeLoadingDialog();
                    if (socketResponsedMessage.getError() != 0) {
                        f.this.f54921h.showToast(socketResponsedMessage.getErrorString());
                    }
                }
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                        if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                            f.this.f54917d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                            if (f.this.f54922i != null) {
                                f.this.f54922i.updateUI();
                            }
                        }
                    }
                }
            } else if (cmd != 205003) {
            } else {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                    f.this.f54921h.hideProgressBar();
                    f.this.f54921h.showToast(socketResponsedMessage.getErrorString());
                } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                    ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                    if (responseQueryUserInfoMessage.getResData() != null) {
                        f.this.f54915b = responseQueryUserInfoMessage.getResData();
                        f fVar = f.this;
                        fVar.f54916c = fVar.f54915b.hasConcerned.intValue() == 1;
                        f fVar2 = f.this;
                        fVar2.f54917d = fVar2.f54915b.isBlacklist.intValue() == 1;
                        f.this.f54921h.hideProgressBar();
                        if (f.this.f54922i != null) {
                            f.this.f54922i.updateUI();
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
                    if (f.this.f54921h == null || TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        return;
                    }
                    f.this.f54921h.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                f.this.f54916c = updateAttentionMessage.isAttention();
                if (f.this.f54921h != null) {
                    if (f.this.f54916c) {
                        f.this.f54921h.showToast(R.string.add_success);
                    } else {
                        f.this.f54921h.showToast(R.string.remove_succ);
                    }
                }
                if (f.this.f54922i != null) {
                    f.this.f54922i.updateUI();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void updateUI();
    }

    public f(PersonalTalkSettingActivity personalTalkSettingActivity, e eVar, long j) {
        this.f54921h = personalTalkSettingActivity;
        this.f54922i = eVar;
        this.f54914a = new d.a.m0.s.e.a(personalTalkSettingActivity.getPageContext());
        this.f54920g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        h0.c(new a(this, j), new b(j, personalTalkSettingActivity));
    }

    public CustomMessageListener i() {
        return this.k;
    }

    public DataRes j() {
        return this.f54915b;
    }

    public d.a.c.c.g.c k() {
        return this.j;
    }

    public boolean l() {
        return this.f54917d;
    }

    public boolean m() {
        return this.f54918e;
    }

    public void n() {
        d.a.m0.s.e.a aVar = this.f54914a;
        if (aVar != null) {
            aVar.g();
        }
        BlackListModel blackListModel = this.f54920g;
        if (blackListModel != null) {
            blackListModel.cancelLoadData();
        }
    }

    public void o(boolean z) {
        this.f54918e = z;
    }

    public void p(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.f54915b.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.f54919f);
        MessageManager.getInstance().removeMessage(104102, this.f54919f);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void q(boolean z) {
        this.f54921h.showLoadingDialog(null);
        if (z) {
            this.f54920g.addToBlackList(this.f54915b.id.longValue());
        } else {
            this.f54920g.removeFromBlackList(this.f54915b.id.longValue());
        }
    }
}
