package d.b.i0.v2.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class d extends a {
    public d(Context context) {
        super(context);
    }

    @Override // d.b.i0.v2.e.a
    public void a(ShareEntity shareEntity, d.b.i0.v2.e.b bVar) {
        String str;
        if (shareEntity != null && !TextUtils.isEmpty(shareEntity.b())) {
            if (TextUtils.isEmpty(shareEntity.b())) {
                str = shareEntity.n() + shareEntity.g();
            } else {
                str = shareEntity.b() + shareEntity.g();
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType("text/plain");
            Context context = this.f62051b;
            if (d.b.i0.v2.f.a.a(context, Intent.createChooser(intent, context.getString(R.string.share_to)))) {
                if (bVar != null) {
                    bVar.onShare(0, 1);
                    return;
                }
                return;
            } else if (bVar != null) {
                bVar.onShare(0, 2);
                return;
            } else {
                return;
            }
        }
        l.K(c(), R.string.share_empty_tip);
        if (bVar != null) {
            bVar.onShare(0, 2);
        }
    }
}
