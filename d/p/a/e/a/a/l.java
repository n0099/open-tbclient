package d.p.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapsdkplatform.comapi.map.ag;
/* loaded from: classes6.dex */
public class l extends a {
    public l(Context context, d.p.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // d.p.a.e.a.a.e
    public Intent b() {
        String t = this.f67930b.t("s");
        String b2 = d.p.a.e.a.h.b.b(this.f67930b.t(ag.f7631h), t);
        String b3 = d.p.a.e.a.h.b.b(this.f67930b.t("ah"), t);
        String b4 = d.p.a.e.a.h.b.b(this.f67930b.t("ai"), t);
        String b5 = d.p.a.e.a.h.b.b(this.f67930b.t("aj"), t);
        Intent intent = new Intent();
        intent.putExtra(b2, this.f67931c);
        intent.putExtra(b3, "*/*");
        intent.putExtra(b4, true);
        intent.setAction(b5);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.addFlags(32768);
        return intent;
    }
}
