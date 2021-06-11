package d.a.l0.a.i1.f;

import android.text.TextUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwai.video.player.KsMediaMeta;
import d.a.l0.a.k;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f46586a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public String f46587b = "aac";

    /* renamed from: c  reason: collision with root package name */
    public int f46588c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f46589d = 8000;

    /* renamed from: e  reason: collision with root package name */
    public int f46590e = 16000;

    /* renamed from: f  reason: collision with root package name */
    public int f46591f = 1;

    /* renamed from: g  reason: collision with root package name */
    public String f46592g;

    static {
        boolean z = k.f46875a;
    }

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null && jSONObject.length() > 0) {
            aVar = new a();
            aVar.f46586a = jSONObject.optInt("duration", 60000);
            String optString = jSONObject.optString(KsMediaMeta.KSM_KEY_FORMAT);
            aVar.f46587b = optString;
            if (TextUtils.isEmpty(optString)) {
                aVar.f46587b = "aac";
            }
            aVar.f46588c = jSONObject.optInt("numberOfChannels", 1);
            aVar.f46589d = jSONObject.optInt("sampleRate", 8000);
            int optInt = jSONObject.optInt("encodeBitRate");
            aVar.f46590e = optInt;
            if (optInt == 0) {
                int i2 = aVar.f46589d;
                if (i2 == 8000) {
                    aVar.f46590e = 16000;
                } else if (i2 == 16000) {
                    aVar.f46590e = 24000;
                } else if (i2 == 44100) {
                    aVar.f46590e = 64000;
                }
            }
            aVar.f46591f = b(jSONObject.optString("audioSource", DebugKt.DEBUG_PROPERTY_VALUE_AUTO));
            aVar.f46592g = jSONObject.optString("cb");
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
        int i2 = this.f46586a;
        if (i2 <= 600000 && i2 >= 0) {
            int i3 = this.f46588c;
            boolean z = true;
            if (i3 != 1 && i3 != 2) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
            }
            if (!TextUtils.equals(this.f46587b, "aac") && !TextUtils.equals(this.f46587b, "pcm")) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
            }
            int i4 = this.f46589d;
            if (i4 != 8000 && i4 != 16000 && i4 != 44100) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
            }
            if (!TextUtils.equals(this.f46587b, "pcm")) {
                if ((r3 = this.f46589d) != 8000) {
                    if (z) {
                        return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
                    }
                } else if (z) {
                }
            }
            if (this.f46591f < 0) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
            }
            return null;
        }
        return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
    }

    public String toString() {
        return "recordTime : " + this.f46586a + "; channel : " + this.f46588c + "; audioFormat : " + this.f46587b + "; sampleRate : " + this.f46589d + "; bitRate : " + this.f46590e + "; callbacks : " + this.f46592g;
    }
}
