package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
public class h extends a {
    public h(Context context, d.o.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        Intent intent = new Intent(d.o.a.e.b.d.c.f66950c + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.f66786c);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
