package d.a.l0.a.p.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import d.a.l0.a.c2.f.o;
import d.a.l0.a.v2.s0;
import java.io.File;
/* loaded from: classes2.dex */
public class p implements d.a.l0.a.p.d.d0 {
    @Override // d.a.l0.a.p.d.d0
    public boolean a(Activity activity, String str, o.b bVar) {
        return false;
    }

    @Override // d.a.l0.a.p.d.d0
    public boolean b(Context context, String str) {
        return true;
    }

    @Override // d.a.l0.a.p.d.d0
    public boolean c(Activity activity, Uri uri, String str) {
        if (activity == null || uri == null || uri.getPath() == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (d.a.l0.a.v2.d.i()) {
            uri = s0.a(activity, new File(uri.getPath()));
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
        d.a.l0.a.v2.f.f(activity, intent);
    }
}
