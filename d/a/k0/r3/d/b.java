package d.a.k0.r3.d;

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
public class b implements d.a.k0.r3.d.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.r3.c.a f60633a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.r3.b f60634b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f60635c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f60636e;

        public a(ShareItem shareItem) {
            this.f60636e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f60636e.t);
            l.M(b.this.f60635c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.k0.r3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnDismissListenerC1592b implements DialogInterface.OnDismissListener {
        public DialogInterface$OnDismissListenerC1592b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.h();
        }
    }

    public b(TbPageContext<?> tbPageContext, d.a.k0.r3.b bVar, Intent intent) {
        this.f60635c = tbPageContext;
        this.f60634b = bVar;
        d.a.k0.r3.c.b bVar2 = new d.a.k0.r3.c.b();
        this.f60633a = bVar2;
        bVar2.b(intent);
        this.f60633a.e(tbPageContext.getUniqueId());
    }

    @Override // d.a.k0.r3.d.a
    public void a() {
        d.a.k0.r3.b bVar = this.f60634b;
        if (bVar != null) {
            bVar.showErrorView();
        }
    }

    @Override // d.a.k0.r3.d.a
    public void b() {
        d.a.k0.r3.c.a aVar = this.f60633a;
        if (aVar != null) {
            d.a.j0.r.d0.b.j().t(d.a.j0.r.d0.b.n(aVar.c()), false);
        }
    }

    @Override // d.a.k0.r3.d.a
    public void c() {
        d.a.k0.r3.c.a aVar = this.f60633a;
        if (aVar == null || this.f60634b == null) {
            return;
        }
        this.f60634b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // d.a.k0.r3.d.a
    public void d() {
        d.a.k0.r3.c.a aVar;
        d.a.k0.r3.b bVar = this.f60634b;
        if (bVar == null || (aVar = this.f60633a) == null) {
            return;
        }
        bVar.showDialog(aVar.a(), this.f60633a.g());
    }

    @Override // d.a.k0.r3.d.a
    public void e() {
        if (this.f60635c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f60635c.getPageActivity())) {
            i();
        }
    }

    public final void h() {
        d.a.k0.r3.c.a aVar = this.f60633a;
        if (aVar == null || this.f60634b == null) {
            return;
        }
        this.f60634b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        if (this.f60633a == null || this.f60635c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f60633a.d();
        shareItem.s = this.f60633a.i();
        shareItem.t = this.f60633a.f();
        shareItem.u = this.f60633a.f();
        if (!k.isEmpty(this.f60633a.h())) {
            shareItem.v = Uri.parse(this.f60633a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f60635c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1592b());
        this.f60635c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // d.a.k0.r3.d.a
    public void onClose() {
        d.a.k0.r3.b bVar = this.f60634b;
        if (bVar != null) {
            bVar.finishActivity();
        }
    }

    @Override // d.a.k0.r3.d.a
    public void onDestroy() {
    }

    @Override // d.a.k0.r3.d.a
    public void onPause() {
    }

    @Override // d.a.k0.r3.d.a
    public void onResume() {
        h();
    }
}
