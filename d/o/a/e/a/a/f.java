package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
/* loaded from: classes7.dex */
public class f extends a {
    public f(Context context) {
        super(context, null, null);
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
