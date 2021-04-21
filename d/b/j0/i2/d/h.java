package d.b.j0.i2.d;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
/* loaded from: classes3.dex */
public class h implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.f2.f f57509e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.i2.d.d f57510f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.l3.a f57511g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f57512h;
    public BlackListModel i;
    public boolean j;
    public String k;
    public long l;
    public String m;
    public d.b.j0.i2.e.a n;
    public BdUniqueId o;
    public boolean p;
    public RemoveFansController q;
    public d.b.j0.f2.e r;
    public final d.b.c.c.g.c s = new g(104102);
    public final d.b.c.c.g.c t = new C1367h(304102);
    public final CustomMessageListener u = new i(2001174);
    public final CustomMessageListener v = new j(2001174);
    public final d.b.c.c.g.c w = new a(304103);

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.c {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                h.this.f57512h.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? h.this.f57512h.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            if (z && i != 2260104) {
                if (StringUtils.isNull(str)) {
                    l.L(h.this.f57512h.getPageActivity(), h.this.f57512h.getString(i == 0 ? R.string.remove_fans_success : R.string.remove_fans_fail));
                } else {
                    l.L(h.this.f57512h.getPageActivity(), str);
                }
            }
            h hVar = h.this;
            if (j == hVar.l && i == 0) {
                hVar.p = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            h.this.q.removeFans(h.this.l);
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d(h hVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            h hVar = h.this;
            if (hVar.l > 0) {
                if (hVar.i.getMaskType() == 1) {
                    h.this.i.removeFromBlackList(h.this.l);
                } else {
                    h.this.i.addToBlackList(h.this.l);
                }
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public f(h hVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.b.c.c.g.c {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() != 10) {
                    return;
                }
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    h.this.i.setMaskType(1);
                } else {
                    h.this.i.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (h.this.i.getMaskType() == 1) {
                        TbPageContext tbPageContext = h.this.f57512h;
                        tbPageContext.showToast(tbPageContext.getString(R.string.chat_message_blocked));
                        return;
                    }
                    TbPageContext tbPageContext2 = h.this.f57512h;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.remove_succ));
                    return;
                }
                h.this.f57512h.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? h.this.f57512h.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* renamed from: d.b.j0.i2.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1367h extends d.b.c.c.g.c {
        public C1367h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    h.this.f(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? h.this.f57512h.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                h.this.f57512h.showToast(errorString);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                h.this.f(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    h.this.f(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    h.this.f(true);
                }
            }
        }
    }

    public h(TbPageContext tbPageContext, d.b.j0.i2.d.d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.f57512h = tbPageContext;
        this.f57510f = dVar;
        this.i = blackListModel;
        this.o = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, d.b.j0.l3.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            d.b.j0.l3.a aVar = (d.b.j0.l3.a) runTask.getData();
            this.f57511g = aVar;
            aVar.a(bdUniqueId);
        }
        h();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.o);
        this.q = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void e() {
        BlackListModel blackListModel;
        if (this.f57510f == null || (blackListModel = this.i) == null) {
            return;
        }
        k(this.j, blackListModel.getMaskType() == 1, this.f57510f.e(), this.p);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        this.j = z;
        d.b.j0.i2.e.a aVar = this.n;
        if (aVar != null) {
            aVar.x(z);
        }
        d.b.j0.f2.f fVar = this.f57509e;
        if (fVar == null || (blackListModel = this.i) == null) {
            return;
        }
        fVar.o(this.j, blackListModel.getMaskType() == 1, this.p);
    }

    public void h() {
        this.s.setTag(this.o);
        this.t.setTag(this.o);
        this.w.setTag(this.o);
        this.v.setTag(this.o);
        this.u.setTag(this.o);
        this.f57512h.registerListener(this.s);
        this.f57512h.registerListener(this.t);
        this.f57512h.registerListener(this.w);
        this.f57512h.registerListener(this.v);
        this.f57512h.registerListener(this.u);
    }

    public void i(d.b.j0.i2.e.a aVar) {
        if (this.i == null || aVar == null || aVar.j() == null) {
            return;
        }
        this.n = aVar;
        UserData j2 = aVar.j();
        this.j = aVar.l();
        this.i.setMaskType(j2.isMask() ? 1 : 0);
        this.k = j2.getName_show();
        this.l = j2.getUserIdLong();
        this.m = j2.getPortrait();
        this.p = j2.getIsMyFans() == 1;
    }

    public void j() {
        String format;
        if (this.k == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f57512h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new e());
        aVar.setNegativeButton(R.string.cancel, new f(this));
        if (this.i.getMaskType() == 1) {
            format = String.format(this.f57512h.getString(R.string.block_chat_ensure_toremove_text), this.k);
        } else {
            format = String.format(this.f57512h.getString(R.string.block_chat_message_alert), this.k);
        }
        aVar.setMessage(format);
        aVar.create(this.f57512h);
        aVar.show();
    }

    public final void k(boolean z, boolean z2, int i2, boolean z3) {
        d.b.j0.f2.f fVar = new d.b.j0.f2.f(this.f57512h, this);
        this.f57509e = fVar;
        fVar.o(z, z2, z3);
        if (i2 != -1) {
            this.f57509e.n(i2);
        }
        d.b.j0.i2.e.a aVar = this.n;
        if (aVar != null && aVar.j() != null) {
            if (this.n.j().getBaijiahaoInfo() != null && !StringUtils.isNull(this.n.j().getBaijiahaoInfo().name)) {
                this.f57509e.q(this.n.j().getBaijiahaoInfo().name);
            } else {
                this.f57509e.q(this.n.j().getUserName());
            }
        }
        this.f57509e.m();
        d.b.j0.f2.e eVar = new d.b.j0.f2.e(this.f57512h.getPageActivity(), this.f57509e.k());
        this.r = eVar;
        eVar.show();
    }

    public final void l() {
        if (this.l == 0) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f57512h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new c());
        aVar.setNegativeButton(R.string.cancel, new d(this));
        aVar.setMessage(String.format(this.f57512h.getString(R.string.remove_fans_alert_text), this.k));
        aVar.create(this.f57512h);
        aVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        d.b.c.e.m.g.a(this.r, this.f57512h.getPageActivity());
        if (this.f57509e.d() != null && view.getId() == this.f57509e.d().getId()) {
            j();
        } else if (this.f57509e.e() != null && view.getId() == this.f57509e.e().getId()) {
            if (this.j) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.l);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f57512h.getPageActivity(), String.valueOf(this.l), this.k, this.m, null, false, null)));
        } else if (this.f57509e.f() != null && view.getId() == this.f57509e.f().getId()) {
            if (!d.b.c.e.p.j.z()) {
                this.f57512h.showToast(R.string.neterror);
                return;
            }
            d.b.j0.i2.d.d dVar = this.f57510f;
            if (dVar == null) {
                return;
            }
            if (dVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.l), this.k, null, null, 0, this.f57510f.d(), this.f57510f.f());
                userMuteAddAndDelCustomMessage.mId = this.f57510f.f();
                d.b.j0.i2.d.d dVar2 = this.f57510f;
                dVar2.j(false, userMuteAddAndDelCustomMessage, dVar2.d(), this.k);
            } else if (this.f57510f.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.l), this.k, null, null, 0, this.f57510f.d(), this.f57510f.f());
                userMuteAddAndDelCustomMessage2.mId = this.f57510f.f();
                this.f57510f.j(true, userMuteAddAndDelCustomMessage2, null, this.k);
            }
        } else if (this.f57509e.i() != null && view.getId() == this.f57509e.i().getId()) {
            if (this.f57511g != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.f57511g.b(String.valueOf(this.l));
            }
        } else if (this.f57509e.h() == null || view.getId() != this.f57509e.h().getId()) {
        } else {
            if (!d.b.c.e.p.j.z()) {
                l.K(this.f57512h.getPageActivity(), R.string.neterror);
            } else {
                l();
            }
        }
    }
}
