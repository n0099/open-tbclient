package d.b.h0.a.b1.f;

import android.text.TextUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwai.video.player.KsMediaMeta;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f44186a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public String f44187b = "aac";

    /* renamed from: c  reason: collision with root package name */
    public int f44188c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f44189d = 8000;

    /* renamed from: e  reason: collision with root package name */
    public int f44190e = 16000;

    /* renamed from: f  reason: collision with root package name */
    public int f44191f = 1;

    /* renamed from: g  reason: collision with root package name */
    public String f44192g;

    static {
        boolean z = k.f45772a;
    }

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null && jSONObject.length() > 0) {
            aVar = new a();
            aVar.f44186a = jSONObject.optInt("duration", 60000);
            String optString = jSONObject.optString(KsMediaMeta.KSM_KEY_FORMAT);
            aVar.f44187b = optString;
            if (TextUtils.isEmpty(optString)) {
                aVar.f44187b = "aac";
            }
            aVar.f44188c = jSONObject.optInt("numberOfChannels", 1);
            aVar.f44189d = jSONObject.optInt("sampleRate", 8000);
            int optInt = jSONObject.optInt("encodeBitRate");
            aVar.f44190e = optInt;
            if (optInt == 0) {
                int i = aVar.f44189d;
                if (i == 8000) {
                    aVar.f44190e = 16000;
                } else if (i == 16000) {
                    aVar.f44190e = 24000;
                } else if (i == 44100) {
                    aVar.f44190e = 64000;
                }
            }
            aVar.f44191f = b(jSONObject.optString("audioSource", "auto"));
            aVar.f44192g = jSONObject.optString("cb");
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
                if (str.equals("auto")) {
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
        int i = this.f44186a;
        if (i <= 600000 && i >= 0) {
            int i2 = this.f44188c;
            boolean z = true;
            if (i2 != 1 && i2 != 2) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
            }
            if (!TextUtils.equals(this.f44187b, "aac") && !TextUtils.equals(this.f44187b, "pcm")) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
            }
            int i3 = this.f44189d;
            if (i3 != 8000 && i3 != 16000 && i3 != 44100) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
            }
            if (!TextUtils.equals(this.f44187b, "pcm")) {
                if ((r3 = this.f44189d) != 8000) {
                    if (z) {
                        return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
                    }
                } else if (z) {
                }
            }
            if (this.f44191f < 0) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
            }
            return null;
        }
        return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
    }

    public String toString() {
        return "recordTime : " + this.f44186a + "; channel : " + this.f44188c + "; audioFormat : " + this.f44187b + "; sampleRate : " + this.f44189d + "; bitRate : " + this.f44190e + "; callbacks : " + this.f44192g;
    }
}
