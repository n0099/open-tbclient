package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
public class g extends a {
    public g(Context context, d.o.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        Intent intent = new Intent(d.o.a.e.b.d.c.f66955c + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.f66791c);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
