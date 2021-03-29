package d.b.i0.h2.d;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.event.PersonPolymericEventController;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.i0.e2.a;
import d.b.i0.h2.d.f;
import d.b.i0.h2.e.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class g extends e implements d.b.i0.h2.h.b {

    /* renamed from: f  reason: collision with root package name */
    public final BaseFragmentActivity f55224f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f55225g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f55226h;
    public final View i;
    public final BdUniqueId j;
    public long k;
    public String l;
    public f m;
    public final PersonPolymericModel n;
    public final d o;
    public final BlackListModel p;
    public k q;
    public d.b.i0.b0.h r;
    public PersonPolymericEventController s;
    public h t;
    public int u;
    public boolean v;
    public final f.e w;
    public CustomMessageListener x;

    /* loaded from: classes5.dex */
    public class a implements f.e {
        public a() {
        }

        @Override // d.b.i0.h2.d.f.e
        public void a(View view) {
            g.this.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            g.this.h();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.c {
        public c() {
        }

        @Override // d.b.i0.e2.a.c
        public void a(int i, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            if (i != 0 || imageUploadResult == null) {
                return;
            }
            String str2 = null;
            ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null) {
                str2 = picDetailedInfo.picUrl;
            }
            j.a(str2, g.this.r());
        }
    }

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.u = 3;
        this.v = false;
        this.w = new a();
        this.x = new b(2921424);
        this.f55225g = baseFragment;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.f55224f = baseFragmentActivity;
        this.i = view;
        this.j = bdUniqueId;
        this.k = j;
        this.l = str;
        this.f55226h = baseFragmentActivity.getPageContext();
        MessageManager.getInstance().registerListener(this.x);
        this.o = new d(this.f55225g.getPageContext(), bdUniqueId);
        f fVar = new f(this.f55225g.getPageContext(), view, z);
        this.m = fVar;
        fVar.u(this.w);
        this.s = new PersonPolymericEventController(this.f55226h, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.f55224f, bdUniqueId, z);
        this.n = personPolymericModel;
        personPolymericModel.J(new p(z));
        this.n.H(this);
        this.n.I(this.o);
        this.p = new BlackListModel(this.f55224f.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.l)) {
            k kVar = new k(this.f55225g, this, this.j, this.k, z);
            this.q = kVar;
            kVar.k(TbadkCoreApplication.getInst().getSkinType());
            this.q.j(this.s);
        }
        this.t = new h(this.f55226h, this.o, this.p, bdUniqueId);
        loadData();
    }

    @Override // d.b.i0.h2.h.b
    public void b(d.b.i0.h2.e.a aVar) {
        NicknameInfo nicknameInfo;
        if (aVar != null && aVar.j() != null && !StringUtils.isNull(this.l)) {
            this.k = aVar.j().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.k)));
            this.f55214e = this.k == d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.m.n();
        h hVar = this.t;
        if (hVar != null) {
            hVar.i(aVar);
        }
        if (aVar != null) {
            this.m.k(aVar);
        }
        k kVar = this.q;
        if (kVar != null) {
            kVar.o(aVar);
        } else {
            k kVar2 = new k(this.f55225g, this, this.j, this.k, this.f55214e);
            this.q = kVar2;
            kVar2.k(TbadkCoreApplication.getInst().getSkinType());
            this.q.j(this.s);
            this.q.o(aVar);
        }
        if (!this.v || aVar == null || (nicknameInfo = aVar.A) == null || nicknameInfo.left_days == null || aVar.j() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        personChangeData.setMem(aVar.j().getIsMem());
        personChangeData.setNickNameLeftDays(aVar.A.left_days.intValue());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
    }

    public void h() {
        if (!TbadkCoreApplication.isLogin() && this.f55214e) {
            this.m.B();
        } else if (d.b.b.e.p.j.A()) {
            this.n.E(this.k, this.l);
        } else {
            this.m.n();
            l.L(this.f55226h.getContext(), this.f55226h.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            d.b.i0.h2.e.i iVar = new d.b.i0.h2.e.i();
            iVar.f55295e = this.f55214e;
            arrayList.add(iVar);
            this.m.m();
            this.m.w(arrayList);
            this.m.z();
        }
    }

    public void j() {
        new d.b.i0.e2.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c());
    }

    public boolean k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.b.b.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.b.h0.r.d0.b.i().g(d.b.h0.r.d0.b.m(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f55224f).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public f l() {
        return this.m;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.f55214e) {
            this.m.B();
        } else if (d.b.b.e.p.j.A()) {
            d.b.i0.h2.b.d().m(System.currentTimeMillis());
            this.m.x(false, -1);
            this.m.E(true);
            this.n.F(this.k);
            this.n.E(this.k, this.l);
        } else {
            this.m.n();
            this.m.s(8);
            this.m.y(this.f55225g.getString(R.string.neterror), true);
        }
    }

    public h m() {
        return this.t;
    }

    public d.b.i0.h2.d.b n() {
        return this.q;
    }

    public i o() {
        return null;
    }

    public d.b.i0.h2.e.a p(boolean z) {
        if (z) {
            this.v = z;
            if (d.b.b.e.p.j.A()) {
                this.n.E(this.k, this.l);
            }
        }
        return this.n.D();
    }

    public PersonPolymericModel q() {
        return this.n;
    }

    public List<n> r() {
        if (this.n.D() == null) {
            return null;
        }
        return this.n.D().k();
    }

    public void s(int i) {
        if (this.u == i) {
            return;
        }
        k kVar = this.q;
        if (kVar != null) {
            kVar.k(i);
        }
        this.u = i;
    }

    public void u() {
        MessageManager.getInstance().unRegisterListener(this.x);
        k kVar = this.q;
        if (kVar != null) {
            kVar.l();
        }
        PersonPolymericModel personPolymericModel = this.n;
        if (personPolymericModel != null) {
            personPolymericModel.destroy();
        }
    }

    public void v(boolean z) {
        k kVar = this.q;
        if (kVar != null) {
            kVar.m(z);
        }
    }

    public void w() {
        k kVar = this.q;
        if (kVar != null) {
            kVar.n();
        }
    }

    public void x(PostWriteCallBackData postWriteCallBackData) {
        if (this.r == null) {
            this.r = new d.b.i0.b0.h(this.f55224f.getPageContext(), (NavigationBarCoverTip) this.f55224f.findViewById(R.id.navigation_cover_tip));
        }
        this.r.m(postWriteCallBackData);
    }
}
