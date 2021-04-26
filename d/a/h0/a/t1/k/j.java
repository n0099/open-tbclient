package d.a.h0.a.t1.k;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends a0 {
    public j(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getImageInfo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("getImageInfo", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = d.a.h0.a.i2.v.b(unitedSchemeEntity.getParam("params")).optString(UserAccountActionItem.KEY_SRC);
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("getImageInfo", "path null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONObject jSONObject = null;
        if (d.a.h0.a.a2.b.c(optString) == PathType.BD_FILE) {
            jSONObject = k(d.a.h0.a.a2.b.u(optString, eVar.f43823f), optString);
        } else if (d.a.h0.a.a2.b.c(optString) == PathType.RELATIVE) {
            jSONObject = k(d.a.h0.a.a2.b.t(optString, eVar, eVar.W()), optString);
        }
        if (jSONObject != null) {
            d.a.h0.a.c0.c.g("getImageInfo", "getImgInfo success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "image not found");
        return false;
    }

    public final ExifInterface j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ExifInterface(str);
        } catch (IOException unused) {
            return null;
        }
    }

    public final JSONObject k(String str, String str2) {
        String str3;
        d.a.h0.a.c0.c.g("getImageInfo", "getImgInfo start");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        String str4 = options.outMimeType;
        if (TextUtils.isEmpty(str4)) {
            str3 = "";
        } else {
            String[] split = str4.split("/");
            str3 = split[split.length - 1];
        }
        if (!TextUtils.equals("png", str3)) {
            ExifInterface j = j(str);
            if (j == null) {
                return null;
            }
            i2 = j.getAttributeInt("Orientation", 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i3);
            jSONObject.put("height", i4);
            jSONObject.put("path", str2);
            jSONObject.put("orientation", l(i2));
            jSONObject.put("type", str3);
        } catch (JSONException e2) {
            d.a.h0.a.c0.c.b("getImageInfo", "getImgInfo failed by json exception");
            if (a0.f44398b) {
                e2.printStackTrace();
            }
        }
        d.a.h0.a.c0.c.g("getImageInfo", "getImgInfo end");
        return jSONObject;
    }

    public final String l(int i2) {
        switch (i2) {
            case 0:
            case 1:
                return "up";
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return CustomDialogData.POS_LEFT;
            case 7:
                return "right-mirrored";
            case 8:
                return "right";
            default:
                return "";
        }
    }
}
