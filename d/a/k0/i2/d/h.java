package d.a.k0.i2.d;

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
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
/* loaded from: classes5.dex */
public class h implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.f2.f f56159e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.i2.d.d f56160f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.l3.a f56161g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f56162h;

    /* renamed from: i  reason: collision with root package name */
    public BlackListModel f56163i;
    public boolean j;
    public String k;
    public long l;
    public String m;
    public d.a.k0.i2.e.a n;
    public BdUniqueId o;
    public boolean p;
    public RemoveFansController q;
    public d.a.k0.f2.e r;
    public final d.a.c.c.g.c s = new g(104102);
    public final d.a.c.c.g.c t = new C1378h(304102);
    public final CustomMessageListener u = new i(2001174);
    public final CustomMessageListener v = new j(2001174);
    public final d.a.c.c.g.c w = new a(304103);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                h.this.f56162h.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? h.this.f56162h.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            if (z && i2 != 2260104) {
                if (StringUtils.isNull(str)) {
                    l.M(h.this.f56162h.getPageActivity(), h.this.f56162h.getString(i2 == 0 ? R.string.remove_fans_success : R.string.remove_fans_fail));
                } else {
                    l.M(h.this.f56162h.getPageActivity(), str);
                }
            }
            h hVar = h.this;
            if (j == hVar.l && i2 == 0) {
                hVar.p = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            h.this.q.removeFans(h.this.l);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d(h hVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            h hVar = h.this;
            if (hVar.l > 0) {
                if (hVar.f56163i.getMaskType() == 1) {
                    h.this.f56163i.removeFromBlackList(h.this.l);
                } else {
                    h.this.f56163i.addToBlackList(h.this.l);
                }
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f(h hVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends d.a.c.c.g.c {
        public g(int i2) {
            super(i2);
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
                    h.this.f56163i.setMaskType(1);
                } else {
                    h.this.f56163i.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (h.this.f56163i.getMaskType() == 1) {
                        TbPageContext tbPageContext = h.this.f56162h;
                        tbPageContext.showToast(tbPageContext.getString(R.string.chat_message_blocked));
                        return;
                    }
                    TbPageContext tbPageContext2 = h.this.f56162h;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.remove_succ));
                    return;
                }
                h.this.f56162h.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? h.this.f56162h.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* renamed from: d.a.k0.i2.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1378h extends d.a.c.c.g.c {
        public C1378h(int i2) {
            super(i2);
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
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? h.this.f56162h.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                h.this.f56162h.showToast(errorString);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
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
        public j(int i2) {
            super(i2);
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

    public h(TbPageContext tbPageContext, d.a.k0.i2.d.d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.f56162h = tbPageContext;
        this.f56160f = dVar;
        this.f56163i = blackListModel;
        this.o = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, d.a.k0.l3.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            d.a.k0.l3.a aVar = (d.a.k0.l3.a) runTask.getData();
            this.f56161g = aVar;
            aVar.a(bdUniqueId);
        }
        g();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.o);
        this.q = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void e() {
        BlackListModel blackListModel;
        if (this.f56160f == null || (blackListModel = this.f56163i) == null) {
            return;
        }
        j(this.j, blackListModel.getMaskType() == 1, this.f56160f.e(), this.p);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        this.j = z;
        d.a.k0.i2.e.a aVar = this.n;
        if (aVar != null) {
            aVar.x(z);
        }
        d.a.k0.f2.f fVar = this.f56159e;
        if (fVar == null || (blackListModel = this.f56163i) == null) {
            return;
        }
        fVar.n(this.j, blackListModel.getMaskType() == 1, this.p);
    }

    public void g() {
        this.s.setTag(this.o);
        this.t.setTag(this.o);
        this.w.setTag(this.o);
        this.v.setTag(this.o);
        this.u.setTag(this.o);
        this.f56162h.registerListener(this.s);
        this.f56162h.registerListener(this.t);
        this.f56162h.registerListener(this.w);
        this.f56162h.registerListener(this.v);
        this.f56162h.registerListener(this.u);
    }

    public void h(d.a.k0.i2.e.a aVar) {
        if (this.f56163i == null || aVar == null || aVar.j() == null) {
            return;
        }
        this.n = aVar;
        UserData j2 = aVar.j();
        this.j = aVar.l();
        this.f56163i.setMaskType(j2.isMask() ? 1 : 0);
        this.k = j2.getName_show();
        this.l = j2.getUserIdLong();
        this.m = j2.getPortrait();
        this.p = j2.getIsMyFans() == 1;
    }

    public void i() {
        String format;
        if (this.k == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f56162h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new e());
        aVar.setNegativeButton(R.string.cancel, new f(this));
        if (this.f56163i.getMaskType() == 1) {
            format = String.format(this.f56162h.getString(R.string.block_chat_ensure_toremove_text), this.k);
        } else {
            format = String.format(this.f56162h.getString(R.string.block_chat_message_alert), this.k);
        }
        aVar.setMessage(format);
        aVar.create(this.f56162h);
        aVar.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        d.a.k0.f2.f fVar = new d.a.k0.f2.f(this.f56162h, this);
        this.f56159e = fVar;
        fVar.n(z, z2, z3);
        if (i2 != -1) {
            this.f56159e.m(i2);
        }
        d.a.k0.i2.e.a aVar = this.n;
        if (aVar != null && aVar.j() != null) {
            if (this.n.j().getBaijiahaoInfo() != null && !StringUtils.isNull(this.n.j().getBaijiahaoInfo().name)) {
                this.f56159e.o(this.n.j().getBaijiahaoInfo().name);
            } else {
                this.f56159e.o(this.n.j().getUserName());
            }
        }
        this.f56159e.l();
        d.a.k0.f2.e eVar = new d.a.k0.f2.e(this.f56162h.getPageActivity(), this.f56159e.j());
        this.r = eVar;
        eVar.show();
    }

    public final void k() {
        if (this.l == 0) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f56162h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new c());
        aVar.setNegativeButton(R.string.cancel, new d(this));
        aVar.setMessage(String.format(this.f56162h.getString(R.string.remove_fans_alert_text), this.k));
        aVar.create(this.f56162h);
        aVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        d.a.c.e.m.g.a(this.r, this.f56162h.getPageActivity());
        if (this.f56159e.d() != null && view.getId() == this.f56159e.d().getId()) {
            i();
        } else if (this.f56159e.e() != null && view.getId() == this.f56159e.e().getId()) {
            if (this.j) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.l);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f56162h.getPageActivity(), String.valueOf(this.l), this.k, this.m, null, false, null)));
        } else if (this.f56159e.f() != null && view.getId() == this.f56159e.f().getId()) {
            if (!d.a.c.e.p.j.z()) {
                this.f56162h.showToast(R.string.neterror);
                return;
            }
            d.a.k0.i2.d.d dVar = this.f56160f;
            if (dVar == null) {
                return;
            }
            if (dVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.l), this.k, null, null, 0, this.f56160f.d(), this.f56160f.f());
                userMuteAddAndDelCustomMessage.mId = this.f56160f.f();
                d.a.k0.i2.d.d dVar2 = this.f56160f;
                dVar2.j(false, userMuteAddAndDelCustomMessage, dVar2.d(), this.k);
            } else if (this.f56160f.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.l), this.k, null, null, 0, this.f56160f.d(), this.f56160f.f());
                userMuteAddAndDelCustomMessage2.mId = this.f56160f.f();
                this.f56160f.j(true, userMuteAddAndDelCustomMessage2, null, this.k);
            }
        } else if (this.f56159e.h() != null && view.getId() == this.f56159e.h().getId()) {
            if (this.f56161g != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.f56161g.b(String.valueOf(this.l));
            }
        } else if (this.f56159e.g() == null || view.getId() != this.f56159e.g().getId()) {
        } else {
            if (!d.a.c.e.p.j.z()) {
                l.L(this.f56162h.getPageActivity(), R.string.neterror);
            } else {
                k();
            }
        }
    }
}
