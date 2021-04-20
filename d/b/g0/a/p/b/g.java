package d.b.g0.a.p.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.alibaba.fastjson.asm.Label;
import d.b.g0.a.t1.k.p;
import java.io.File;
/* loaded from: classes2.dex */
public class g implements d.b.g0.a.p.c.u {
    @Override // d.b.g0.a.p.c.u
    public boolean a(Activity activity, String str, p.b bVar) {
        return false;
    }

    @Override // d.b.g0.a.p.c.u
    public boolean b(Context context, String str) {
        return true;
    }

    @Override // d.b.g0.a.p.c.u
    public boolean c(Activity activity, Uri uri, String str) {
        if (activity == null || uri == null || uri.getPath() == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (d.b.g0.a.i2.c.i()) {
            uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".swan.fileprovider", new File(uri.getPath()));
        }
        d(activity, uri, str);
        return true;
    }

    public final void d(Activity activity, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.addFlags(1);
        intent.setDataAndType(uri, str);
        d.b.g0.a.i2.e.e(activity, intent);
    }
}
