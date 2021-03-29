package d.b.i0.t.j.b;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.h0.r.s.a;
import d.b.i0.t.j.d.m;
/* loaded from: classes4.dex */
public class j extends d.b.b.j.e.a<m, CardViewHolder<d.b.i0.t.j.h.a>> {
    public TbPageContext m;
    public d.b.i0.k3.d n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public TextView s;
    public boolean t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f60836e;

        public a(m mVar) {
            this.f60836e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.o0(this.f60836e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(j jVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60838a;

        public c(TbPageContext tbPageContext) {
            this.f60838a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str = j.this.o ? j.this.p : "0";
            String str2 = j.this.o ? j.this.q : null;
            String str3 = j.this.o ? j.this.r : null;
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.b.b.e.i.a.l().h(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f60838a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
        }
    }

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), m.f60872f);
        this.o = false;
        this.t = false;
        this.m = tbPageContext;
    }

    public void a(String str) {
        this.q = str;
    }

    public final void n0(m mVar, d.b.i0.t.j.h.a aVar) {
        if (mVar.g() == null) {
            return;
        }
        this.s = aVar.u();
        w0();
        aVar.z(8);
        aVar.A(this.f42358e.getResources().getString(R.string.ala_person_center_publish_live));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void o0(m mVar) {
        if (mVar == null || mVar.g() == null) {
            return;
        }
        d.b.h0.r.d0.b.i().s(d.b.h0.r.d0.b.m("live_publish_live_has_showed"), true);
        x0(this.s, null, false);
        s0();
        TiebaStatic.log("c13618");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: p0 */
    public CardViewHolder<d.b.i0.t.j.h.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: q0 */
    public View X(int i, View view, ViewGroup viewGroup, m mVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        n0(mVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(mVar));
        return cardViewHolder.b().m();
    }

    public final void r0(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new c(tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void s0() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.m.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(this.m.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new b(this));
            aVar.create(this.m).show();
        } else if (ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
            if (this.n == null) {
                this.n = new d.b.i0.k3.d(this.m);
            }
            if (this.o) {
                if (this.n.c()) {
                    return;
                }
            } else if (this.n.d()) {
                return;
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                d.b.b.e.p.l.K(this.m.getPageActivity(), R.string.plugin_config_not_found);
            } else {
                r0(this.m);
            }
        }
    }

    public void t0(String str) {
        this.p = str;
    }

    public void u0(String str) {
        this.r = str;
    }

    public void v0(boolean z) {
        this.o = z;
    }

    public final void w0() {
        if (this.t) {
            return;
        }
        this.t = true;
        if (!d.b.h0.r.d0.b.i().g(d.b.h0.r.d0.b.m("live_publish_live_has_showed"), false)) {
            d.b.h0.r.d0.b.i().s(d.b.h0.r.d0.b.m("live_publish_live_has_showed"), true);
            x0(this.s, null, true);
            return;
        }
        x0(this.s, null, false);
    }

    public final void x0(TextView textView, String str, boolean z) {
        if (textView == null || this.m == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.m.getResources().getDrawable(R.drawable.ala_person_center_red_tip_drawable);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
