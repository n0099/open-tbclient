package d.a.h0.a.b1.f;

import android.text.TextUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.k;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f41463a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public String f41464b = "aac";

    /* renamed from: c  reason: collision with root package name */
    public int f41465c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f41466d = 8000;

    /* renamed from: e  reason: collision with root package name */
    public int f41467e = 16000;

    /* renamed from: f  reason: collision with root package name */
    public int f41468f = 1;

    /* renamed from: g  reason: collision with root package name */
    public String f41469g;

    static {
        boolean z = k.f43101a;
    }

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null && jSONObject.length() > 0) {
            aVar = new a();
            aVar.f41463a = jSONObject.optInt("duration", 60000);
            String optString = jSONObject.optString("format");
            aVar.f41464b = optString;
            if (TextUtils.isEmpty(optString)) {
                aVar.f41464b = "aac";
            }
            aVar.f41465c = jSONObject.optInt("numberOfChannels", 1);
            aVar.f41466d = jSONObject.optInt("sampleRate", 8000);
            int optInt = jSONObject.optInt("encodeBitRate");
            aVar.f41467e = optInt;
            if (optInt == 0) {
                int i2 = aVar.f41466d;
                if (i2 == 8000) {
                    aVar.f41467e = 16000;
                } else if (i2 == 16000) {
                    aVar.f41467e = 24000;
                } else if (i2 == 44100) {
                    aVar.f41467e = 64000;
                }
            }
            aVar.f41468f = b(jSONObject.optString("audioSource", DebugKt.DEBUG_PROPERTY_VALUE_AUTO));
            aVar.f41469g = jSONObject.optString("cb");
        }
        return aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(String str) {
        char c2;
        switch (str.hashCode()) {
            case -401509030:
                if (str.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 108103:
                if (str.equals("mic")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3005871:
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1059882026:
                if (str.equals("voice_recognition")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1611170697:
                if (str.equals("voice_communication")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0 || c2 == 1) {
            return 1;
        }
        if (c2 != 2) {
            if (c2 != 3) {
                return c2 != 4 ? -1 : 6;
            }
            return 7;
        }
        return 5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0082, code lost:
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject c() {
        int i2 = this.f41463a;
        if (i2 <= 600000 && i2 >= 0) {
            int i3 = this.f41465c;
            boolean z = true;
            if (i3 != 1 && i3 != 2) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
            }
            if (!TextUtils.equals(this.f41464b, "aac") && !TextUtils.equals(this.f41464b, "pcm")) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
            }
            int i4 = this.f41466d;
            if (i4 != 8000 && i4 != 16000 && i4 != 44100) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
            }
            if (!TextUtils.equals(this.f41464b, "pcm")) {
                if ((r3 = this.f41466d) != 8000) {
                    if (z) {
                        return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
                    }
                } else if (z) {
                }
            }
            if (this.f41468f < 0) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
            }
            return null;
        }
        return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
    }

    public String toString() {
        return "recordTime : " + this.f41463a + "; channel : " + this.f41465c + "; audioFormat : " + this.f41464b + "; sampleRate : " + this.f41466d + "; bitRate : " + this.f41467e + "; callbacks : " + this.f41469g;
    }
}
