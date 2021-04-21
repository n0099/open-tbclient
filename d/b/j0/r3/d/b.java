package d.b.j0.r3.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class b implements d.b.j0.r3.d.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.r3.c.a f61730a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.r3.b f61731b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f61732c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f61733e;

        public a(ShareItem shareItem) {
            this.f61733e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.p.a.a(this.f61733e.t);
            l.L(b.this.f61732c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.b.j0.r3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnDismissListenerC1579b implements DialogInterface.OnDismissListener {
        public DialogInterface$OnDismissListenerC1579b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.h();
        }
    }

    public b(TbPageContext<?> tbPageContext, d.b.j0.r3.b bVar, Intent intent) {
        this.f61732c = tbPageContext;
        this.f61731b = bVar;
        d.b.j0.r3.c.b bVar2 = new d.b.j0.r3.c.b();
        this.f61730a = bVar2;
        bVar2.c(intent);
        this.f61730a.a(tbPageContext.getUniqueId());
    }

    @Override // d.b.j0.r3.d.a
    public void a() {
        d.b.j0.r3.b bVar = this.f61731b;
        if (bVar != null) {
            bVar.showErrorView();
        }
    }

    @Override // d.b.j0.r3.d.a
    public void b() {
        d.b.j0.r3.c.a aVar = this.f61730a;
        if (aVar == null || this.f61731b == null) {
            return;
        }
        this.f61731b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // d.b.j0.r3.d.a
    public void c() {
        d.b.j0.r3.c.a aVar;
        d.b.j0.r3.b bVar = this.f61731b;
        if (bVar == null || (aVar = this.f61730a) == null) {
            return;
        }
        bVar.showDialog(aVar.b(), this.f61730a.f());
    }

    @Override // d.b.j0.r3.d.a
    public void d() {
        if (this.f61732c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f61732c.getPageActivity())) {
            i();
        }
    }

    @Override // d.b.j0.r3.d.a
    public void e() {
        d.b.j0.r3.c.a aVar = this.f61730a;
        if (aVar != null) {
            d.b.i0.r.d0.b.j().t(d.b.i0.r.d0.b.n(aVar.e()), false);
        }
    }

    public final void h() {
        d.b.j0.r3.c.a aVar = this.f61730a;
        if (aVar == null || this.f61731b == null) {
            return;
        }
        this.f61731b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        if (this.f61730a == null || this.f61732c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f61730a.i();
        shareItem.s = this.f61730a.h();
        shareItem.t = this.f61730a.d();
        shareItem.u = this.f61730a.d();
        if (!k.isEmpty(this.f61730a.g())) {
            shareItem.v = Uri.parse(this.f61730a.g());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f61732c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1579b());
        this.f61732c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // d.b.j0.r3.d.a
    public void onClose() {
        d.b.j0.r3.b bVar = this.f61731b;
        if (bVar != null) {
            bVar.finishActivity();
        }
    }

    @Override // d.b.j0.r3.d.a
    public void onDestroy() {
    }

    @Override // d.b.j0.r3.d.a
    public void onPause() {
    }

    @Override // d.b.j0.r3.d.a
    public void onResume() {
        h();
    }
}
