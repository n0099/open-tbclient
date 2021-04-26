package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
/* loaded from: classes6.dex */
public class k extends a {
    public k(Context context, d.o.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.f66282c);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
