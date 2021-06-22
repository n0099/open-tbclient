package d.a.o0.s3.d;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class b implements d.a.o0.s3.d.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.s3.c.a f64572a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.s3.b f64573b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f64574c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f64575e;

        public a(ShareItem shareItem) {
            this.f64575e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f64575e.t);
            l.M(b.this.f64574c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.o0.s3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnDismissListenerC1664b implements DialogInterface.OnDismissListener {
        public DialogInterface$OnDismissListenerC1664b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.h();
        }
    }

    public b(TbPageContext<?> tbPageContext, d.a.o0.s3.b bVar, Intent intent) {
        this.f64574c = tbPageContext;
        this.f64573b = bVar;
        d.a.o0.s3.c.b bVar2 = new d.a.o0.s3.c.b();
        this.f64572a = bVar2;
        bVar2.b(intent);
        this.f64572a.e(tbPageContext.getUniqueId());
    }

    @Override // d.a.o0.s3.d.a
    public void a() {
        d.a.o0.s3.b bVar = this.f64573b;
        if (bVar != null) {
            bVar.showErrorView();
        }
    }

    @Override // d.a.o0.s3.d.a
    public void b() {
        d.a.o0.s3.c.a aVar = this.f64572a;
        if (aVar != null) {
            d.a.n0.r.d0.b.j().t(d.a.n0.r.d0.b.n(aVar.c()), false);
        }
    }

    @Override // d.a.o0.s3.d.a
    public void c() {
        d.a.o0.s3.c.a aVar = this.f64572a;
        if (aVar == null || this.f64573b == null) {
            return;
        }
        this.f64573b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // d.a.o0.s3.d.a
    public void d() {
        d.a.o0.s3.c.a aVar;
        d.a.o0.s3.b bVar = this.f64573b;
        if (bVar == null || (aVar = this.f64572a) == null) {
            return;
        }
        bVar.showDialog(aVar.a(), this.f64572a.g());
    }

    @Override // d.a.o0.s3.d.a
    public void e() {
        if (this.f64574c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f64574c.getPageActivity())) {
            i();
        }
    }

    public final void h() {
        d.a.o0.s3.c.a aVar = this.f64572a;
        if (aVar == null || this.f64573b == null) {
            return;
        }
        this.f64573b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        if (this.f64572a == null || this.f64574c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f64572a.d();
        shareItem.s = this.f64572a.i();
        shareItem.t = this.f64572a.f();
        shareItem.u = this.f64572a.f();
        if (!k.isEmpty(this.f64572a.h())) {
            shareItem.v = Uri.parse(this.f64572a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f64574c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1664b());
        this.f64574c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // d.a.o0.s3.d.a
    public void onClose() {
        d.a.o0.s3.b bVar = this.f64573b;
        if (bVar != null) {
            bVar.finishActivity();
        }
    }

    @Override // d.a.o0.s3.d.a
    public void onDestroy() {
    }

    @Override // d.a.o0.s3.d.a
    public void onPause() {
    }

    @Override // d.a.o0.s3.d.a
    public void onResume() {
        h();
    }
}
