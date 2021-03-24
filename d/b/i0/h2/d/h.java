package d.b.i0.h2.d;

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
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
/* loaded from: classes5.dex */
public class h implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.e2.f f55229e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.h2.d.d f55230f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.k3.a f55231g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f55232h;
    public BlackListModel i;
    public boolean j;
    public String k;
    public long l;
    public String m;
    public d.b.i0.h2.e.a n;
    public BdUniqueId o;
    public boolean p;
    public RemoveFansController q;
    public d.b.i0.e2.e r;
    public final d.b.b.c.g.c s = new g(104102);
    public final d.b.b.c.g.c t = new C1268h(304102);
    public final CustomMessageListener u = new i(2001174);
    public final CustomMessageListener v = new j(2001174);
    public final d.b.b.c.g.c w = new a(304103);

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.c {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                h.this.f55232h.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? h.this.f55232h.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            if (z && i != 2260104) {
                if (StringUtils.isNull(str)) {
                    l.L(h.this.f55232h.getPageActivity(), h.this.f55232h.getString(i == 0 ? R.string.remove_fans_success : R.string.remove_fans_fail));
                } else {
                    l.L(h.this.f55232h.getPageActivity(), str);
                }
            }
            h hVar = h.this;
            if (j == hVar.l && i == 0) {
                hVar.p = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            h.this.q.removeFans(h.this.l);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d(h hVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
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

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f(h hVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends d.b.b.c.g.c {
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
                        TbPageContext tbPageContext = h.this.f55232h;
                        tbPageContext.showToast(tbPageContext.getString(R.string.chat_message_blocked));
                        return;
                    }
                    TbPageContext tbPageContext2 = h.this.f55232h;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.remove_succ));
                    return;
                }
                h.this.f55232h.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? h.this.f55232h.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* renamed from: d.b.i0.h2.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1268h extends d.b.b.c.g.c {
        public C1268h(int i) {
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
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? h.this.f55232h.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                h.this.f55232h.showToast(errorString);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    public h(TbPageContext tbPageContext, d.b.i0.h2.d.d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.f55232h = tbPageContext;
        this.f55230f = dVar;
        this.i = blackListModel;
        this.o = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, d.b.i0.k3.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            d.b.i0.k3.a aVar = (d.b.i0.k3.a) runTask.getData();
            this.f55231g = aVar;
            aVar.a(bdUniqueId);
        }
        h();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.o);
        this.q = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void e() {
        BlackListModel blackListModel;
        if (this.f55230f == null || (blackListModel = this.i) == null) {
            return;
        }
        k(this.j, blackListModel.getMaskType() == 1, this.f55230f.e(), this.p);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        this.j = z;
        d.b.i0.h2.e.a aVar = this.n;
        if (aVar != null) {
            aVar.x(z);
        }
        d.b.i0.e2.f fVar = this.f55229e;
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
        this.f55232h.registerListener(this.s);
        this.f55232h.registerListener(this.t);
        this.f55232h.registerListener(this.w);
        this.f55232h.registerListener(this.v);
        this.f55232h.registerListener(this.u);
    }

    public void i(d.b.i0.h2.e.a aVar) {
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f55232h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new e());
        aVar.setNegativeButton(R.string.cancel, new f(this));
        if (this.i.getMaskType() == 1) {
            format = String.format(this.f55232h.getString(R.string.block_chat_ensure_toremove_text), this.k);
        } else {
            format = String.format(this.f55232h.getString(R.string.block_chat_message_alert), this.k);
        }
        aVar.setMessage(format);
        aVar.create(this.f55232h);
        aVar.show();
    }

    public final void k(boolean z, boolean z2, int i2, boolean z3) {
        d.b.i0.e2.f fVar = new d.b.i0.e2.f(this.f55232h, this);
        this.f55229e = fVar;
        fVar.o(z, z2, z3);
        if (i2 != -1) {
            this.f55229e.n(i2);
        }
        d.b.i0.h2.e.a aVar = this.n;
        if (aVar != null && aVar.j() != null) {
            if (this.n.j().getBaijiahaoInfo() != null && !StringUtils.isNull(this.n.j().getBaijiahaoInfo().name)) {
                this.f55229e.q(this.n.j().getBaijiahaoInfo().name);
            } else {
                this.f55229e.q(this.n.j().getUserName());
            }
        }
        this.f55229e.m();
        d.b.i0.e2.e eVar = new d.b.i0.e2.e(this.f55232h.getPageActivity(), this.f55229e.k());
        this.r = eVar;
        eVar.show();
    }

    public final void l() {
        if (this.l == 0) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f55232h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new c());
        aVar.setNegativeButton(R.string.cancel, new d(this));
        aVar.setMessage(String.format(this.f55232h.getString(R.string.remove_fans_alert_text), this.k));
        aVar.create(this.f55232h);
        aVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        d.b.b.e.m.g.a(this.r, this.f55232h.getPageActivity());
        if (this.f55229e.d() != null && view.getId() == this.f55229e.d().getId()) {
            j();
        } else if (this.f55229e.e() != null && view.getId() == this.f55229e.e().getId()) {
            if (this.j) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.l);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f55232h.getPageActivity(), String.valueOf(this.l), this.k, this.m, null, false, null)));
        } else if (this.f55229e.f() != null && view.getId() == this.f55229e.f().getId()) {
            if (!d.b.b.e.p.j.z()) {
                this.f55232h.showToast(R.string.neterror);
                return;
            }
            d.b.i0.h2.d.d dVar = this.f55230f;
            if (dVar == null) {
                return;
            }
            if (dVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.l), this.k, null, null, 0, this.f55230f.d(), this.f55230f.f());
                userMuteAddAndDelCustomMessage.mId = this.f55230f.f();
                d.b.i0.h2.d.d dVar2 = this.f55230f;
                dVar2.j(false, userMuteAddAndDelCustomMessage, dVar2.d(), this.k);
            } else if (this.f55230f.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.l), this.k, null, null, 0, this.f55230f.d(), this.f55230f.f());
                userMuteAddAndDelCustomMessage2.mId = this.f55230f.f();
                this.f55230f.j(true, userMuteAddAndDelCustomMessage2, null, this.k);
            }
        } else if (this.f55229e.i() != null && view.getId() == this.f55229e.i().getId()) {
            if (this.f55231g != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.f55231g.b(String.valueOf(this.l));
            }
        } else if (this.f55229e.h() == null || view.getId() != this.f55229e.h().getId()) {
        } else {
            if (!d.b.b.e.p.j.z()) {
                l.K(this.f55232h.getPageActivity(), R.string.neterror);
            } else {
                l();
            }
        }
    }
}
