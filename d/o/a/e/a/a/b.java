package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.alibaba.fastjson.asm.Label;
@RequiresApi(api = 26)
/* loaded from: classes6.dex */
public class b extends a {
    public b(Context context) {
        super(context, null, null);
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f66280a.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        return intent;
    }
}
