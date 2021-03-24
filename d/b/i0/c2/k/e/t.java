package d.b.i0.c2.k.e;

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
import d.b.h0.r.s.a;
/* loaded from: classes4.dex */
public class t extends d.b.h0.w.e {

    /* renamed from: f  reason: collision with root package name */
    public VoiceData$VoiceModel f52834f;

    /* renamed from: g  reason: collision with root package name */
    public LocationModel f52835g;

    /* renamed from: h  reason: collision with root package name */
    public PbEditorData.ThreadData f52836h;
    public BaseActivity<?> i;
    public int j;
    public LocationModel.e k;
    public LocationModel.f l;

    /* loaded from: classes4.dex */
    public class a implements LocationModel.e {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            t.this.i.showToast(R.string.no_network_guide);
            t.this.o(0, false, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                t.this.o(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            BaseActivity baseActivity = t.this.i;
            if (StringUtils.isNull(str)) {
                str = t.this.a().getContext().getString(R.string.location_fail);
            }
            baseActivity.showToast(str);
            t.this.o(0, false, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements LocationModel.f {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a(String str) {
            t.this.o(2, true, str);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b() {
            t.this.o(0, false, null);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            t.this.o(0, true, null);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (d.b.b.e.p.j.z()) {
                t.this.o(1, true, null);
                t.this.f52835g.F();
            } else {
                t.this.k.a();
            }
            aVar.dismiss();
        }
    }

    public t(EditorTools editorTools) {
        super(editorTools);
        this.j = 0;
        this.k = new a();
        this.l = new b();
    }

    public BaseActivity<?> f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public VoiceData$VoiceModel h() {
        return this.f52834f;
    }

    public void i() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.i.getActivity())));
    }

    public void j(BaseActivity baseActivity) {
        LocationModel locationModel = new LocationModel(baseActivity.getPageContext());
        this.f52835g = locationModel;
        locationModel.I(this.k);
        this.f52835g.J(this.l);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
            a().A(new d.b.h0.w.a(2, 12, " "));
        }
        if (this.f52835g.v() || a() == null) {
            return;
        }
        a().A(new d.b.h0.w.a(20, 8, null));
    }

    public void k(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 11025) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.i.getActivity(), 12004, true)));
            } else if (i != 23004) {
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        }
    }

    public void l() {
        if (!PermissionUtil.checkLocationForGoogle(this.i.getActivity())) {
            PermissionUtil.reuqestLocation(this.i.getActivity(), 0);
        } else {
            t();
        }
    }

    public void m() {
        if (this.f52835g.v()) {
            if (this.f52835g.z()) {
                this.k.b(d.b.i0.c3.m0.b.a().b());
                return;
            }
            if (d.b.b.e.p.l.C()) {
                this.f52835g.D();
            }
            o(0, true, null);
            return;
        }
        o(0, false, null);
    }

    public void n() {
        PbEditorData.ThreadData threadData = this.f52836h;
        if (threadData == null || StringUtils.isNull(threadData.getAuthorName()) || this.f52836h.getAuthorId() <= 0) {
            return;
        }
        String valueOf = String.valueOf(this.f52836h.getAuthorId());
        if (valueOf != null && !valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.i.getActivity(), this.f52836h.getAuthorId(), this.f52836h.getAuthorName(), this.f52836h.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, d.b.b.e.m.b.f(this.f52836h.getThreadId(), 0L), d.b.b.e.m.b.f(this.f52836h.getPostId(), 0L))));
            return;
        }
        d.b.b.e.p.l.K(this.i.getActivity(), R.string.can_not_send_gift_to_yourself);
    }

    public final void o(int i, boolean z, String str) {
        this.j = i;
        if (a() != null) {
            a().A(new d.b.h0.w.a(19, 8, new d.b.h0.w.u.a(i, z, str)));
        }
    }

    public void p(BaseActivity<?> baseActivity) {
        this.i = baseActivity;
    }

    public void q(PbEditorData.ThreadData threadData) {
        this.f52836h = threadData;
    }

    public void r(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.f52834f = voiceData$VoiceModel;
    }

    public final void s() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.i.getActivity());
        aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d()).setNegativeButton(R.string.cancel, new c()).create(this.i.getPageContext());
        aVar.show();
    }

    public void t() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.i.getActivity())) {
            this.i.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            s();
        } else if (this.f52835g.z()) {
            i();
        } else {
            this.f52835g.H(false);
            o(1, true, null);
            this.f52835g.D();
        }
    }
}
