package d.b.i0.q3.d;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class b implements d.b.i0.q3.d.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.q3.c.a f59614a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.q3.b f59615b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f59616c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f59617e;

        public a(ShareItem shareItem) {
            this.f59617e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.a.a(this.f59617e.t);
            l.L(b.this.f59616c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.b.i0.q3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnDismissListenerC1491b implements DialogInterface.OnDismissListener {
        public DialogInterface$OnDismissListenerC1491b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.h();
        }
    }

    public b(TbPageContext<?> tbPageContext, d.b.i0.q3.b bVar, Intent intent) {
        this.f59616c = tbPageContext;
        this.f59615b = bVar;
        d.b.i0.q3.c.b bVar2 = new d.b.i0.q3.c.b();
        this.f59614a = bVar2;
        bVar2.c(intent);
        this.f59614a.a(tbPageContext.getUniqueId());
    }

    @Override // d.b.i0.q3.d.a
    public void a() {
        d.b.i0.q3.b bVar = this.f59615b;
        if (bVar != null) {
            bVar.showErrorView();
        }
    }

    @Override // d.b.i0.q3.d.a
    public void b() {
        d.b.i0.q3.c.a aVar = this.f59614a;
        if (aVar == null || this.f59615b == null) {
            return;
        }
        this.f59615b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // d.b.i0.q3.d.a
    public void c() {
        d.b.i0.q3.c.a aVar;
        d.b.i0.q3.b bVar = this.f59615b;
        if (bVar == null || (aVar = this.f59614a) == null) {
            return;
        }
        bVar.showDialog(aVar.b(), this.f59614a.f());
    }

    @Override // d.b.i0.q3.d.a
    public void d() {
        if (this.f59616c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f59616c.getPageActivity())) {
            i();
        }
    }

    @Override // d.b.i0.q3.d.a
    public void e() {
        d.b.i0.q3.c.a aVar = this.f59614a;
        if (aVar != null) {
            d.b.h0.r.d0.b.i().s(d.b.h0.r.d0.b.m(aVar.e()), false);
        }
    }

    public final void h() {
        d.b.i0.q3.c.a aVar = this.f59614a;
        if (aVar == null || this.f59615b == null) {
            return;
        }
        this.f59615b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        if (this.f59614a == null || this.f59616c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f59614a.i();
        shareItem.s = this.f59614a.h();
        shareItem.t = this.f59614a.d();
        shareItem.u = this.f59614a.d();
        if (!k.isEmpty(this.f59614a.g())) {
            shareItem.v = Uri.parse(this.f59614a.g());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f59616c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1491b());
        this.f59616c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // d.b.i0.q3.d.a
    public void onClose() {
        d.b.i0.q3.b bVar = this.f59615b;
        if (bVar != null) {
            bVar.finishActivity();
        }
    }

    @Override // d.b.i0.q3.d.a
    public void onDestroy() {
    }

    @Override // d.b.i0.q3.d.a
    public void onPause() {
    }

    @Override // d.b.i0.q3.d.a
    public void onResume() {
        h();
    }
}
