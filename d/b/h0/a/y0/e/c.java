package d.b.h0.a.y0.e;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.b.h0.a.y0.e.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c<SelfT extends c<SelfT>> extends e<SelfT> {

    /* loaded from: classes2.dex */
    public static final class a extends c<a> {
        @Override // d.b.h0.a.y0.e.c, d.b.h0.a.y0.e.f.c
        public /* bridge */ /* synthetic */ d.b.h0.a.y0.e.f.c C(Bundle bundle) {
            return super.C(bundle);
        }

        public a Z0() {
            return this;
        }

        @Override // d.b.h0.a.i2.u0.d
        public /* bridge */ /* synthetic */ d.b.h0.a.i2.u0.d a() {
            Z0();
            return this;
        }
    }

    public static String U0(String str, int i, JSONObject jSONObject) {
        String str2 = i == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str2).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
        return builder.toString();
    }

    public static c V0(Bundle bundle) {
        a aVar = new a();
        aVar.C(bundle);
        return aVar;
    }

    public static Intent W0(Context context, c cVar) {
        if (context == null || cVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(SwanAppLauncherActivity.SWAN_APP_LAUNCH_ACTION);
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        if (context instanceof Application) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtras(cVar.A());
        return intent;
    }

    public static String X0(String str, String str2, int i) {
        String str3 = i == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
        Uri.Builder builder = new Uri.Builder();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str3).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
        return builder.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.y0.e.f.c
    /* renamed from: Y0 */
    public SelfT C(Bundle bundle) {
        d.b.h0.a.c0.d.b.h(bundle);
        return (SelfT) super.C(bundle);
    }

    @Override // d.b.h0.a.y0.e.f.c
    public String toString() {
        return "SwanAppLaunchParams{appId='" + G() + "', from='" + S() + "', page='" + b0() + "', isDebug=" + j0() + ", extraData=" + O() + ", clickId='" + K() + "', launchScheme='" + V() + "', notInHistory='" + Z() + "'}";
    }
}
