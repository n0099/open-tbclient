package d.a.o0.x2;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import d.a.n0.s.g.d;
/* loaded from: classes5.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public Context f67138a;

    public b(Context context, d.a.n0.s.g.c cVar) {
        this.f67138a = null;
        this.f67138a = context;
    }

    @Override // d.a.n0.s.g.d
    public void a(ShareItem shareItem, int i2, boolean z) {
        b(shareItem, i2);
    }

    public final void b(ShareItem shareItem, int i2) {
        if (this.f67138a == null || shareItem == null) {
            return;
        }
        IntentConfig intentConfig = new IntentConfig(this.f67138a);
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.E(shareItem.r);
        shareEntity.s(shareItem.s);
        shareEntity.A(shareItem.R);
        int i3 = shareItem.M;
        shareEntity.v(i3 == 2 || i3 == 6 || i3 == 8);
        shareEntity.u(shareItem.v);
        shareEntity.canShareBySmartApp = shareItem.f0;
        String str = shareItem.t;
        if (i2 == 6 && !StringUtils.isNull(shareItem.u)) {
            str = shareItem.u;
        }
        shareEntity.w(str);
        shareEntity.x(shareItem.x);
        shareEntity.y(shareItem.B);
        shareEntity.B(i2);
        shareEntity.C(shareItem.e());
        shareEntity.z(shareItem.W);
        shareEntity.D(shareItem.K);
        shareEntity.H(shareItem.p);
        shareEntity.F(shareItem.y);
        shareEntity.topic = shareItem.O;
        if (i2 == 6 && !StringUtils.isNull(shareItem.Q)) {
            shareEntity.topic = shareItem.P + shareItem.Q;
            shareEntity.s("");
        }
        shareEntity.taskCompleteId = shareItem.S;
        shareEntity.diskPicOperate = shareItem.A;
        shareEntity.t(shareItem.k0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_share_data", shareEntity);
        bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
        intentConfig.getIntent().putExtras(bundle);
        shareItem.j(true);
        intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
    }
}
