package d.b.i0.h2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwai.video.player.PlayerPostEvent;
import d.b.h0.r.s.l;
import d.b.h0.t.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends d.b.i0.h2.d.e implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55241f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f55242g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55243h;
    public d.b.i0.h2.e.a i;
    public PersonChangeData j;
    public PermissionJudgePolicy k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.j f55244e;

        public a(d.b.h0.r.s.j jVar) {
            this.f55244e = jVar;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(l lVar, int i, View view) {
            i.this.f55243h = false;
            if (i == 0) {
                i.this.u();
            } else if (i == 1) {
                i.this.w();
            }
            if (this.f55244e.isShowing()) {
                this.f55244e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f55246e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f55247f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55248g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.j f55249h;

        public b(n nVar, List list, int i, d.b.h0.r.s.j jVar) {
            this.f55246e = nVar;
            this.f55247f = list;
            this.f55248g = i;
            this.f55249h = jVar;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(l lVar, int i, View view) {
            i.this.f55243h = true;
            if (i == 0) {
                i.this.x(this.f55246e, this.f55247f, this.f55248g);
            } else if (i == 1) {
                i iVar = i.this;
                if (iVar.f55213e && iVar.i != null && i.this.i.j() != null && !i.this.i.j().canModifyAvatar()) {
                    if (!StringUtils.isNull(i.this.i.j().getCantModifyAvatarDesc())) {
                        d.b.b.e.p.l.I(TbadkCoreApplication.getInst(), i.this.i.j().getCantModifyAvatarDesc());
                    } else {
                        d.b.b.e.p.l.H(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                    }
                } else {
                    i.this.u();
                }
            } else if (i == 2) {
                i iVar2 = i.this;
                if (iVar2.f55213e && iVar2.i != null && i.this.i.j() != null && !i.this.i.j().canModifyAvatar()) {
                    if (!StringUtils.isNull(i.this.i.j().getCantModifyAvatarDesc())) {
                        d.b.b.e.p.l.I(TbadkCoreApplication.getInst(), i.this.i.j().getCantModifyAvatarDesc());
                    } else {
                        d.b.b.e.p.l.H(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                    }
                } else {
                    i.this.w();
                }
            } else if (i == 3) {
                TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                i.this.v();
            }
            if (this.f55249h.isShowing()) {
                this.f55249h.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f55250e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f55251f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55252g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.j f55253h;

        public c(n nVar, List list, int i, d.b.h0.r.s.j jVar) {
            this.f55250e = nVar;
            this.f55251f = list;
            this.f55252g = i;
            this.f55253h = jVar;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(l lVar, int i, View view) {
            if (i == 0) {
                i.this.x(this.f55250e, this.f55251f, this.f55252g);
            } else if (i == 1) {
                j.d(this.f55250e, i.this.f55241f.getUniqueId());
            } else if (i == 2) {
                j.b(this.f55250e, this.f55251f);
            }
            if (this.f55253h.isShowing()) {
                this.f55253h.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                i.this.A();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends HttpMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof SetUserPicsResponse)) {
                return;
            }
            SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
            if (setUserPicsResponse.getErrCode() != 0) {
                i.this.f55241f.showToast(setUserPicsResponse.getErrorString());
            } else {
                i.this.A();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f(i iVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PersonChangeData)) {
                return;
            }
            i.this.y((PersonChangeData) customResponsedMessage.getData());
        }
    }

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.f55242g = new WriteImagesInfo(1);
        this.f55243h = true;
        this.l = new d(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(2001380);
        this.o = gVar;
        this.f55241f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f55241f.registerListener(this.o);
        this.f55241f.registerListener(this.m);
        this.f55241f.registerListener(this.l);
    }

    public void A() {
        d.b.b.e.m.e.a().postDelayed(this.n, 300L);
    }

    public void B(d.b.i0.h2.e.a aVar) {
        this.i = aVar;
    }

    public final void E() {
        TbPageContext tbPageContext = this.f55241f;
        if (tbPageContext == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.f55241f.getString(R.string.change_system_photo)};
        d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(this.f55241f);
        jVar.i(null, strArr, new a(jVar));
        jVar.l();
    }

    public final void F(n nVar, List<d.b.b.j.e.n> list, int i) {
        TbPageContext tbPageContext = this.f55241f;
        if (tbPageContext == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.hd_photo), this.f55241f.getString(R.string.change_photo), this.f55241f.getString(R.string.change_system_photo), this.f55241f.getString(R.string.check_headpendant)};
        d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(this.f55241f);
        jVar.i(null, strArr, new b(nVar, list, i, jVar));
        jVar.l();
    }

    public final void G(n nVar, List<d.b.b.j.e.n> list, int i) {
        String[] strArr = {this.f55241f.getString(R.string.look_big_photo), this.f55241f.getString(R.string.set_as_portrait_photo), this.f55241f.getString(R.string.delete)};
        d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(this.f55241f);
        jVar.i(null, strArr, new c(nVar, list, i, jVar));
        jVar.l();
    }

    public void o() {
        d.b.i0.h2.e.a aVar = this.i;
        if (aVar == null || aVar.j() == null) {
            return;
        }
        d.b.h0.a0.c.j().f(this.i.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || q() == null) {
            return;
        }
        d.b.b.j.e.n nVar = null;
        if (view.getTag() instanceof PersonInfoUserPicViewHolder) {
            nVar = ((PersonInfoUserPicViewHolder) view.getTag()).c();
        } else if (view.getTag() instanceof PersonInfoAddUserPicViewHolder) {
            nVar = ((PersonInfoAddUserPicViewHolder) view.getTag()).c();
        }
        int position = ListUtils.getPosition(q(), nVar);
        if (position < 0) {
            return;
        }
        r(nVar, q(), position);
    }

    public void p(Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f55242g.parseJson(stringExtra);
        this.f55242g.updateQuality();
        if (!ListUtils.isEmpty(this.f55242g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f55241f.getPageActivity(), (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f55242g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f55243h)));
        }
        this.f55242g.clear();
    }

    public List<d.b.b.j.e.n> q() {
        d.b.i0.h2.e.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        return aVar.k();
    }

    public void r(d.b.b.j.e.n nVar, List<d.b.b.j.e.n> list, int i) {
        s(nVar, list, i, false);
    }

    public void s(d.b.b.j.e.n nVar, List<d.b.b.j.e.n> list, int i, boolean z) {
        if (nVar == null) {
            return;
        }
        if (z) {
            if (nVar instanceof n) {
                x((n) nVar, list, i);
                return;
            }
            return;
        }
        d.b.i0.h2.e.a aVar = this.i;
        if (aVar != null) {
            this.f55213e = aVar.m();
        }
        if (!d.b.b.e.p.l.C()) {
            this.f55241f.showToast(R.string.neterror);
        } else if (!this.f55213e) {
            if (nVar instanceof n) {
                x((n) nVar, list, i);
            }
        } else if (nVar instanceof d.b.i0.e2.i.c) {
            E();
        } else if (nVar instanceof n) {
            n nVar2 = (n) nVar;
            if (nVar2.f()) {
                F(nVar2, list, i);
            } else {
                G(nVar2, list, i);
            }
        }
    }

    public void u() {
        TbPageContext tbPageContext = this.f55241f;
        if (tbPageContext == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.k == null) {
            this.k = new PermissionJudgePolicy();
        }
        this.k.clearRequestPermissionList();
        this.k.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.k.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f55241f.getPageActivity(), this.f55242g.toJsonString(), true);
        albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void v() {
        if (this.f55241f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f55241f.getPageActivity())));
    }

    public void w() {
        if (this.f55241f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f55241f.getPageActivity(), 12014, this.f55243h)));
    }

    public final void x(n nVar, List<d.b.b.j.e.n> list, int i) {
        if (this.f55241f == null || nVar == null || list == null || StringUtils.isNull(nVar.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (d.b.b.j.e.n nVar2 : list) {
            if (nVar2 instanceof n) {
                n nVar3 = (n) nVar2;
                if (nVar3.f() && !nVar3.a().startsWith("http")) {
                    arrayList.add(j.c(this.f55241f, nVar3.a()));
                } else {
                    arrayList.add(nVar3.a());
                }
            }
        }
        int size = arrayList.size();
        String str = size > 0 ? arrayList.get(size - 1) : "";
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i);
        bVar.C(true);
        bVar.K(str);
        bVar.G(true);
        bVar.J(false);
        ImageViewerConfig v = bVar.v(this.f55241f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f55241f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void y(PersonChangeData personChangeData) {
        d.b.i0.h2.e.a aVar;
        if (personChangeData == null || (aVar = this.i) == null || aVar.j() == null || !this.i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.j == null) {
            this.j = new PersonChangeData();
        }
        this.j.setPhotoChanged(true);
        o();
    }

    public void z() {
        d.b.b.e.m.e.a().removeCallbacks(this.n);
    }
}
