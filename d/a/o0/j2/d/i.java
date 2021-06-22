package d.a.o0.j2.d;

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
import d.a.c.k.e.n;
import d.a.n0.r.s.l;
import d.a.n0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends d.a.o0.j2.d.e implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f60170f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f60171g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60172h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.j2.e.a f60173i;
    public PersonChangeData j;
    public PermissionJudgePolicy k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.j f60174e;

        public a(d.a.n0.r.s.j jVar) {
            this.f60174e = jVar;
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            i.this.f60172h = false;
            if (i2 == 0) {
                i.this.t();
            } else if (i2 == 1) {
                i.this.v();
            }
            if (this.f60174e.isShowing()) {
                this.f60174e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f60176e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f60177f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f60178g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.j f60179h;

        public b(o oVar, List list, int i2, d.a.n0.r.s.j jVar) {
            this.f60176e = oVar;
            this.f60177f = list;
            this.f60178g = i2;
            this.f60179h = jVar;
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            i.this.f60172h = true;
            if (i2 == 0) {
                i.this.w(this.f60176e, this.f60177f, this.f60178g);
            } else if (i2 == 1) {
                i iVar = i.this;
                if (iVar.f60139e && iVar.f60173i != null && i.this.f60173i.j() != null && !i.this.f60173i.j().canModifyAvatar()) {
                    if (!StringUtils.isNull(i.this.f60173i.j().getCantModifyAvatarDesc())) {
                        d.a.c.e.p.l.J(TbadkCoreApplication.getInst(), i.this.f60173i.j().getCantModifyAvatarDesc());
                    } else {
                        d.a.c.e.p.l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                    }
                } else {
                    i.this.t();
                }
            } else if (i2 == 2) {
                i iVar2 = i.this;
                if (iVar2.f60139e && iVar2.f60173i != null && i.this.f60173i.j() != null && !i.this.f60173i.j().canModifyAvatar()) {
                    if (!StringUtils.isNull(i.this.f60173i.j().getCantModifyAvatarDesc())) {
                        d.a.c.e.p.l.J(TbadkCoreApplication.getInst(), i.this.f60173i.j().getCantModifyAvatarDesc());
                    } else {
                        d.a.c.e.p.l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                    }
                } else {
                    i.this.v();
                }
            } else if (i2 == 3) {
                TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                i.this.u();
            }
            if (this.f60179h.isShowing()) {
                this.f60179h.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f60181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f60182f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f60183g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.j f60184h;

        public c(o oVar, List list, int i2, d.a.n0.r.s.j jVar) {
            this.f60181e = oVar;
            this.f60182f = list;
            this.f60183g = i2;
            this.f60184h = jVar;
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            if (i2 == 0) {
                i.this.w(this.f60181e, this.f60182f, this.f60183g);
            } else if (i2 == 1) {
                j.d(this.f60181e, i.this.f60170f.getUniqueId());
            } else if (i2 == 2) {
                j.b(this.f60181e, this.f60182f);
            }
            if (this.f60184h.isShowing()) {
                this.f60184h.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                i.this.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends HttpMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof SetUserPicsResponse)) {
                return;
            }
            SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
            if (setUserPicsResponse.getErrCode() != 0) {
                i.this.f60170f.showToast(setUserPicsResponse.getErrorString());
            } else {
                i.this.z();
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
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PersonChangeData)) {
                return;
            }
            i.this.x((PersonChangeData) customResponsedMessage.getData());
        }
    }

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.f60171g = new WriteImagesInfo(1);
        this.f60172h = true;
        this.l = new d(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(2001380);
        this.o = gVar;
        this.f60170f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f60170f.registerListener(this.o);
        this.f60170f.registerListener(this.m);
        this.f60170f.registerListener(this.l);
    }

    public void A(d.a.o0.j2.e.a aVar) {
        this.f60173i = aVar;
    }

    public final void B() {
        TbPageContext tbPageContext = this.f60170f;
        if (tbPageContext == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.f60170f.getString(R.string.change_system_photo)};
        d.a.n0.r.s.j jVar = new d.a.n0.r.s.j(this.f60170f);
        jVar.i(null, strArr, new a(jVar));
        jVar.l();
    }

    public final void F(o oVar, List<n> list, int i2) {
        TbPageContext tbPageContext = this.f60170f;
        if (tbPageContext == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.hd_photo), this.f60170f.getString(R.string.change_photo), this.f60170f.getString(R.string.change_system_photo), this.f60170f.getString(R.string.check_headpendant)};
        d.a.n0.r.s.j jVar = new d.a.n0.r.s.j(this.f60170f);
        jVar.i(null, strArr, new b(oVar, list, i2, jVar));
        jVar.l();
    }

    public final void G(o oVar, List<n> list, int i2) {
        String[] strArr = {this.f60170f.getString(R.string.look_big_photo), this.f60170f.getString(R.string.set_as_portrait_photo), this.f60170f.getString(R.string.delete)};
        d.a.n0.r.s.j jVar = new d.a.n0.r.s.j(this.f60170f);
        jVar.i(null, strArr, new c(oVar, list, i2, jVar));
        jVar.l();
    }

    public void o() {
        d.a.o0.j2.e.a aVar = this.f60173i;
        if (aVar == null || aVar.j() == null) {
            return;
        }
        d.a.n0.a0.c.k().g(this.f60173i.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || q() == null) {
            return;
        }
        n nVar = null;
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
        this.f60171g.parseJson(stringExtra);
        this.f60171g.updateQuality();
        if (!ListUtils.isEmpty(this.f60171g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f60170f.getPageActivity(), (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f60171g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f60172h)));
        }
        this.f60171g.clear();
    }

    public List<n> q() {
        d.a.o0.j2.e.a aVar = this.f60173i;
        if (aVar == null) {
            return null;
        }
        return aVar.k();
    }

    public void r(n nVar, List<n> list, int i2) {
        s(nVar, list, i2, false);
    }

    public void s(n nVar, List<n> list, int i2, boolean z) {
        if (nVar == null) {
            return;
        }
        if (z) {
            if (nVar instanceof o) {
                w((o) nVar, list, i2);
                return;
            }
            return;
        }
        d.a.o0.j2.e.a aVar = this.f60173i;
        if (aVar != null) {
            this.f60139e = aVar.m();
        }
        if (!d.a.c.e.p.l.D()) {
            this.f60170f.showToast(R.string.neterror);
        } else if (!this.f60139e) {
            if (nVar instanceof o) {
                w((o) nVar, list, i2);
            }
        } else if (nVar instanceof d.a.o0.g2.i.c) {
            B();
        } else if (nVar instanceof o) {
            o oVar = (o) nVar;
            if (oVar.e()) {
                F(oVar, list, i2);
            } else {
                G(oVar, list, i2);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext = this.f60170f;
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
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f60170f.getPageActivity(), this.f60171g.toJsonString(), true);
        albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        if (this.f60170f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f60170f.getPageActivity())));
    }

    public void v() {
        if (this.f60170f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f60170f.getPageActivity(), 12014, this.f60172h)));
    }

    public final void w(o oVar, List<n> list, int i2) {
        if (this.f60170f == null || oVar == null || list == null || StringUtils.isNull(oVar.b())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (n nVar : list) {
            if (nVar instanceof o) {
                o oVar2 = (o) nVar;
                if (oVar2.e() && !oVar2.b().startsWith("http")) {
                    arrayList.add(j.c(this.f60170f, oVar2.b()));
                } else {
                    arrayList.add(oVar2.b());
                }
            }
        }
        int size = arrayList.size();
        String str = size > 0 ? arrayList.get(size - 1) : "";
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i2);
        bVar.C(true);
        bVar.J(str);
        bVar.F(true);
        bVar.I(false);
        ImageViewerConfig v = bVar.v(this.f60170f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f60170f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        d.a.o0.j2.e.a aVar;
        if (personChangeData == null || (aVar = this.f60173i) == null || aVar.j() == null || !this.f60173i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.j == null) {
            this.j = new PersonChangeData();
        }
        this.j.setPhotoChanged(true);
        o();
    }

    public void y() {
        d.a.c.e.m.e.a().removeCallbacks(this.n);
    }

    public void z() {
        d.a.c.e.m.e.a().postDelayed(this.n, 300L);
    }
}
