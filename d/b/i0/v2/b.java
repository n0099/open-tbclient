package d.b.i0.v2;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import d.b.h0.s.g.d;
/* loaded from: classes5.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public Context f62046a;

    public b(Context context, d.b.h0.s.g.c cVar) {
        this.f62046a = null;
        this.f62046a = context;
    }

    @Override // d.b.h0.s.g.d
    public void a(ShareItem shareItem, int i, boolean z) {
        b(shareItem, i);
    }

    public final void b(ShareItem shareItem, int i) {
        if (this.f62046a == null || shareItem == null) {
            return;
        }
        IntentConfig intentConfig = new IntentConfig(this.f62046a);
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.E(shareItem.r);
        shareEntity.s(shareItem.s);
        shareEntity.A(shareItem.Q);
        int i2 = shareItem.L;
        shareEntity.v(i2 == 2 || i2 == 6 || i2 == 8);
        shareEntity.u(shareItem.v);
        shareEntity.canShareBySmartApp = shareItem.d0;
        String str = shareItem.t;
        if (i == 6 && !StringUtils.isNull(shareItem.u)) {
            str = shareItem.u;
        }
        shareEntity.w(str);
        shareEntity.x(shareItem.x);
        shareEntity.y(shareItem.A);
        shareEntity.B(i);
        shareEntity.C(shareItem.d());
        shareEntity.z(shareItem.V);
        shareEntity.D(shareItem.J);
        shareEntity.H(shareItem.p);
        shareEntity.F(shareItem.y);
        shareEntity.topic = shareItem.N;
        if (i == 6 && !StringUtils.isNull(shareItem.P)) {
            shareEntity.topic = shareItem.O + shareItem.P;
            shareEntity.s("");
        }
        shareEntity.taskCompleteId = shareItem.R;
        shareEntity.diskPicOperate = shareItem.z;
        shareEntity.t(shareItem.i0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_share_data", shareEntity);
        bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
        intentConfig.getIntent().putExtras(bundle);
        intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
    }
}
