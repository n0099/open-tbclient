package d.c.b;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.c.b.g1;
/* loaded from: classes5.dex */
public final class d1 implements g1 {
    @Override // d.c.b.g1
    public boolean a(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // d.c.b.g1
    public g1.a b(Context context) {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return null;
                }
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call == null) {
                return null;
            }
            if (call.getInt("code", -1) == 0) {
                g1.a aVar = new g1.a();
                aVar.f65936a = call.getString("id");
                return aVar;
            }
            String string = call.getString("message");
            if (!TextUtils.isEmpty(string)) {
                Log.e(f1.j, string);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
