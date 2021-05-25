package d.a.n0.e2.k.e;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import d.a.m0.r.s.a;
/* loaded from: classes5.dex */
public class v extends d.a.m0.w.e {

    /* renamed from: f  reason: collision with root package name */
    public VoiceData$VoiceModel f53518f;

    /* renamed from: g  reason: collision with root package name */
    public LocationModel f53519g;

    /* renamed from: h  reason: collision with root package name */
    public PbEditorData.ThreadData f53520h;

    /* renamed from: i  reason: collision with root package name */
    public BaseActivity<?> f53521i;
    public int j;
    public LocationModel.e k;
    public LocationModel.f l;

    /* loaded from: classes5.dex */
    public class a implements LocationModel.e {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a(String str) {
            BaseActivity baseActivity = v.this.f53521i;
            if (StringUtils.isNull(str)) {
                str = v.this.a().getContext().getString(R.string.location_fail);
            }
            baseActivity.showToast(str);
            v.this.o(0, false, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b() {
            v.this.f53521i.showToast(R.string.no_network_guide);
            v.this.o(0, false, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void c(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                v.this.o(2, true, locationData.getFormatted_address());
            } else {
                a(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements LocationModel.f {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            v.this.o(0, false, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            v.this.o(2, true, str);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            v.this.o(0, true, null);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (d.a.c.e.p.j.z()) {
                v.this.o(1, true, null);
                v.this.f53519g.F();
            } else {
                v.this.k.b();
            }
            aVar.dismiss();
        }
    }

    public v(EditorTools editorTools) {
        super(editorTools);
        this.j = 0;
        this.k = new a();
        this.l = new b();
    }

    public BaseActivity<?> f() {
        return this.f53521i;
    }

    public int g() {
        return this.j;
    }

    public VoiceData$VoiceModel h() {
        return this.f53518f;
    }

    public void i() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.f53521i.getActivity())));
    }

    public void j(BaseActivity baseActivity) {
        LocationModel locationModel = new LocationModel(baseActivity.getPageContext());
        this.f53519g = locationModel;
        locationModel.I(this.k);
        this.f53519g.J(this.l);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
            a().A(new d.a.m0.w.a(2, 12, " "));
        }
        if (this.f53519g.v() || a() == null) {
            return;
        }
        a().A(new d.a.m0.w.a(20, 8, null));
    }

    public void k(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 == 11025) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f53521i.getActivity(), 12004, true)));
            } else if (i2 != 23004) {
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        }
    }

    public void l() {
        if (!PermissionUtil.checkLocationForGoogle(this.f53521i.getActivity())) {
            PermissionUtil.reuqestLocation(this.f53521i.getActivity(), 0);
        } else {
            t();
        }
    }

    public void m() {
        if (this.f53519g.v()) {
            if (this.f53519g.z()) {
                this.k.c(d.a.n0.e3.m0.b.a().b());
                return;
            }
            if (d.a.c.e.p.l.D()) {
                this.f53519g.D();
            }
            o(0, true, null);
            return;
        }
        o(0, false, null);
    }

    public void n() {
        PbEditorData.ThreadData threadData = this.f53520h;
        if (threadData == null || StringUtils.isNull(threadData.getAuthorName()) || this.f53520h.getAuthorId() <= 0) {
            return;
        }
        String valueOf = String.valueOf(this.f53520h.getAuthorId());
        if (valueOf != null && !valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f53521i.getActivity(), this.f53520h.getAuthorId(), this.f53520h.getAuthorName(), this.f53520h.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, d.a.c.e.m.b.f(this.f53520h.getThreadId(), 0L), d.a.c.e.m.b.f(this.f53520h.getPostId(), 0L))));
            return;
        }
        d.a.c.e.p.l.L(this.f53521i.getActivity(), R.string.can_not_send_gift_to_yourself);
    }

    public final void o(int i2, boolean z, String str) {
        this.j = i2;
        if (a() != null) {
            a().A(new d.a.m0.w.a(19, 8, new d.a.m0.w.u.a(i2, z, str)));
        }
    }

    public void p(BaseActivity<?> baseActivity) {
        this.f53521i = baseActivity;
    }

    public void q(PbEditorData.ThreadData threadData) {
        this.f53520h = threadData;
        if (a() == null || this.f53520h == null) {
            return;
        }
        a().setFid(d.a.c.e.m.b.f(this.f53520h.getForumId(), 0L));
        a().setTid(this.f53520h.getThreadId());
    }

    public void r(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.f53518f = voiceData$VoiceModel;
    }

    public final void s() {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f53521i.getActivity());
        aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d()).setNegativeButton(R.string.cancel, new c()).create(this.f53521i.getPageContext());
        aVar.show();
    }

    public void t() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.f53521i.getActivity())) {
            this.f53521i.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            s();
        } else if (this.f53519g.z()) {
            i();
        } else {
            this.f53519g.H(false);
            o(1, true, null);
            this.f53519g.D();
        }
    }
}
