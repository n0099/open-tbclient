package d.a.i0.a.f1.e;

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
import d.a.i0.a.f1.e.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c<SelfT extends c<SelfT>> extends e<SelfT> {

    /* loaded from: classes3.dex */
    public static final class a extends c<a> {
        @Override // d.a.i0.a.f1.e.c, d.a.i0.a.f1.e.f.c
        public /* bridge */ /* synthetic */ d.a.i0.a.f1.e.f.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // d.a.i0.a.v2.e1.d
        public /* bridge */ /* synthetic */ d.a.i0.a.v2.e1.d a() {
            g1();
            return this;
        }

        public a g1() {
            return this;
        }
    }

    public static String b1(String str, int i2, JSONObject jSONObject) {
        String str2 = i2 == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str2).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
        return builder.toString();
    }

    public static c c1(Bundle bundle) {
        a aVar = new a();
        aVar.D(bundle);
        return aVar;
    }

    public static Intent d1(Context context, c cVar) {
        if (context == null || cVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(SwanAppLauncherActivity.SWAN_APP_LAUNCH_ACTION);
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        if (context instanceof Application) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtras(cVar.C());
        return intent;
    }

    public static String e1(String str, String str2, int i2) {
        String str3 = i2 == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
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
    @Override // d.a.i0.a.f1.e.f.c
    /* renamed from: f1 */
    public SelfT D(Bundle bundle) {
        d.a.i0.a.e0.f.b.h(bundle);
        return (SelfT) super.D(bundle);
    }

    @Override // d.a.i0.a.f1.e.f.c
    public String toString() {
        return "SwanAppLaunchParams{appId='" + H() + "', from='" + T() + "', page='" + e0() + "', isDebug=" + m0() + ", extraData=" + P() + ", clickId='" + L() + "', launchScheme='" + W() + "', notInHistory='" + c0() + "'}";
    }
}
