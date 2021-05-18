package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapsdkplatform.comapi.map.ag;
/* loaded from: classes7.dex */
public class l extends a {
    public l(Context context, d.o.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        String t = this.f66967b.t("s");
        String b2 = d.o.a.e.a.h.b.b(this.f66967b.t(ag.f7700h), t);
        String b3 = d.o.a.e.a.h.b.b(this.f66967b.t("ah"), t);
        String b4 = d.o.a.e.a.h.b.b(this.f66967b.t("ai"), t);
        String b5 = d.o.a.e.a.h.b.b(this.f66967b.t("aj"), t);
        Intent intent = new Intent();
        intent.putExtra(b2, this.f66968c);
        intent.putExtra(b3, "*/*");
        intent.putExtra(b4, true);
        intent.setAction(b5);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.addFlags(32768);
        return intent;
    }
}
