package d.a.k0.d2.k.e;

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
import d.a.j0.r.s.a;
/* loaded from: classes5.dex */
public class v extends d.a.j0.w.e {

    /* renamed from: f  reason: collision with root package name */
    public VoiceData$VoiceModel f53267f;

    /* renamed from: g  reason: collision with root package name */
    public LocationModel f53268g;

    /* renamed from: h  reason: collision with root package name */
    public PbEditorData.ThreadData f53269h;

    /* renamed from: i  reason: collision with root package name */
    public BaseActivity<?> f53270i;
    public int j;
    public LocationModel.e k;
    public LocationModel.f l;

    /* loaded from: classes5.dex */
    public class a implements LocationModel.e {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a(String str) {
            BaseActivity baseActivity = v.this.f53270i;
            if (StringUtils.isNull(str)) {
                str = v.this.a().getContext().getString(R.string.location_fail);
            }
            baseActivity.showToast(str);
            v.this.o(0, false, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b() {
            v.this.f53270i.showToast(R.string.no_network_guide);
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

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            v.this.o(0, true, null);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            if (d.a.c.e.p.j.z()) {
                v.this.o(1, true, null);
                v.this.f53268g.F();
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
        return this.f53270i;
    }

    public int g() {
        return this.j;
    }

    public VoiceData$VoiceModel h() {
        return this.f53267f;
    }

    public void i() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.f53270i.getActivity())));
    }

    public void j(BaseActivity baseActivity) {
        LocationModel locationModel = new LocationModel(baseActivity.getPageContext());
        this.f53268g = locationModel;
        locationModel.I(this.k);
        this.f53268g.J(this.l);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
            a().A(new d.a.j0.w.a(2, 12, " "));
        }
        if (this.f53268g.v() || a() == null) {
            return;
        }
        a().A(new d.a.j0.w.a(20, 8, null));
    }

    public void k(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 == 11025) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f53270i.getActivity(), 12004, true)));
            } else if (i2 != 23004) {
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        }
    }

    public void l() {
        if (!PermissionUtil.checkLocationForGoogle(this.f53270i.getActivity())) {
            PermissionUtil.reuqestLocation(this.f53270i.getActivity(), 0);
        } else {
            t();
        }
    }

    public void m() {
        if (this.f53268g.v()) {
            if (this.f53268g.z()) {
                this.k.c(d.a.k0.d3.m0.b.a().b());
                return;
            }
            if (d.a.c.e.p.l.D()) {
                this.f53268g.D();
            }
            o(0, true, null);
            return;
        }
        o(0, false, null);
    }

    public void n() {
        PbEditorData.ThreadData threadData = this.f53269h;
        if (threadData == null || StringUtils.isNull(threadData.getAuthorName()) || this.f53269h.getAuthorId() <= 0) {
            return;
        }
        String valueOf = String.valueOf(this.f53269h.getAuthorId());
        if (valueOf != null && !valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f53270i.getActivity(), this.f53269h.getAuthorId(), this.f53269h.getAuthorName(), this.f53269h.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, d.a.c.e.m.b.f(this.f53269h.getThreadId(), 0L), d.a.c.e.m.b.f(this.f53269h.getPostId(), 0L))));
            return;
        }
        d.a.c.e.p.l.L(this.f53270i.getActivity(), R.string.can_not_send_gift_to_yourself);
    }

    public final void o(int i2, boolean z, String str) {
        this.j = i2;
        if (a() != null) {
            a().A(new d.a.j0.w.a(19, 8, new d.a.j0.w.u.a(i2, z, str)));
        }
    }

    public void p(BaseActivity<?> baseActivity) {
        this.f53270i = baseActivity;
    }

    public void q(PbEditorData.ThreadData threadData) {
        this.f53269h = threadData;
    }

    public void r(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.f53267f = voiceData$VoiceModel;
    }

    public final void s() {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f53270i.getActivity());
        aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d()).setNegativeButton(R.string.cancel, new c()).create(this.f53270i.getPageContext());
        aVar.show();
    }

    public void t() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.f53270i.getActivity())) {
            this.f53270i.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            s();
        } else if (this.f53268g.z()) {
            i();
        } else {
            this.f53268g.H(false);
            o(1, true, null);
            this.f53268g.D();
        }
    }
}
