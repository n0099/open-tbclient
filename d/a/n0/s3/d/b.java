package d.a.n0.s3.d;

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
public class b implements d.a.n0.s3.d.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.s3.c.a f60756a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.s3.b f60757b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f60758c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f60759e;

        public a(ShareItem shareItem) {
            this.f60759e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f60759e.t);
            l.M(b.this.f60758c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.n0.s3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnDismissListenerC1604b implements DialogInterface.OnDismissListener {
        public DialogInterface$OnDismissListenerC1604b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.h();
        }
    }

    public b(TbPageContext<?> tbPageContext, d.a.n0.s3.b bVar, Intent intent) {
        this.f60758c = tbPageContext;
        this.f60757b = bVar;
        d.a.n0.s3.c.b bVar2 = new d.a.n0.s3.c.b();
        this.f60756a = bVar2;
        bVar2.b(intent);
        this.f60756a.e(tbPageContext.getUniqueId());
    }

    @Override // d.a.n0.s3.d.a
    public void a() {
        d.a.n0.s3.b bVar = this.f60757b;
        if (bVar != null) {
            bVar.showErrorView();
        }
    }

    @Override // d.a.n0.s3.d.a
    public void b() {
        d.a.n0.s3.c.a aVar = this.f60756a;
        if (aVar != null) {
            d.a.m0.r.d0.b.j().t(d.a.m0.r.d0.b.n(aVar.c()), false);
        }
    }

    @Override // d.a.n0.s3.d.a
    public void c() {
        d.a.n0.s3.c.a aVar = this.f60756a;
        if (aVar == null || this.f60757b == null) {
            return;
        }
        this.f60757b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // d.a.n0.s3.d.a
    public void d() {
        d.a.n0.s3.c.a aVar;
        d.a.n0.s3.b bVar = this.f60757b;
        if (bVar == null || (aVar = this.f60756a) == null) {
            return;
        }
        bVar.showDialog(aVar.a(), this.f60756a.g());
    }

    @Override // d.a.n0.s3.d.a
    public void e() {
        if (this.f60758c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f60758c.getPageActivity())) {
            i();
        }
    }

    public final void h() {
        d.a.n0.s3.c.a aVar = this.f60756a;
        if (aVar == null || this.f60757b == null) {
            return;
        }
        this.f60757b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        if (this.f60756a == null || this.f60758c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f60756a.d();
        shareItem.s = this.f60756a.i();
        shareItem.t = this.f60756a.f();
        shareItem.u = this.f60756a.f();
        if (!k.isEmpty(this.f60756a.h())) {
            shareItem.v = Uri.parse(this.f60756a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f60758c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1604b());
        this.f60758c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // d.a.n0.s3.d.a
    public void onClose() {
        d.a.n0.s3.b bVar = this.f60757b;
        if (bVar != null) {
            bVar.finishActivity();
        }
    }

    @Override // d.a.n0.s3.d.a
    public void onDestroy() {
    }

    @Override // d.a.n0.s3.d.a
    public void onPause() {
    }

    @Override // d.a.n0.s3.d.a
    public void onResume() {
        h();
    }
}
