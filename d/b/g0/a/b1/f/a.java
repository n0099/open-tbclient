package d.b.g0.a.b1.f;

import android.text.TextUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwai.video.player.KsMediaMeta;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f43464a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public String f43465b = "aac";

    /* renamed from: c  reason: collision with root package name */
    public int f43466c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f43467d = 8000;

    /* renamed from: e  reason: collision with root package name */
    public int f43468e = 16000;

    /* renamed from: f  reason: collision with root package name */
    public int f43469f = 1;

    /* renamed from: g  reason: collision with root package name */
    public String f43470g;

    static {
        boolean z = k.f45050a;
    }

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null && jSONObject.length() > 0) {
            aVar = new a();
            aVar.f43464a = jSONObject.optInt("duration", 60000);
            String optString = jSONObject.optString(KsMediaMeta.KSM_KEY_FORMAT);
            aVar.f43465b = optString;
            if (TextUtils.isEmpty(optString)) {
                aVar.f43465b = "aac";
            }
            aVar.f43466c = jSONObject.optInt("numberOfChannels", 1);
            aVar.f43467d = jSONObject.optInt("sampleRate", 8000);
            int optInt = jSONObject.optInt("encodeBitRate");
            aVar.f43468e = optInt;
            if (optInt == 0) {
                int i = aVar.f43467d;
                if (i == 8000) {
                    aVar.f43468e = 16000;
                } else if (i == 16000) {
                    aVar.f43468e = 24000;
                } else if (i == 44100) {
                    aVar.f43468e = 64000;
                }
            }
            aVar.f43469f = b(jSONObject.optString("audioSource", "auto"));
            aVar.f43470g = jSONObject.optString("cb");
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
        int i = this.f43464a;
        if (i <= 600000 && i >= 0) {
            int i2 = this.f43466c;
            boolean z = true;
            if (i2 != 1 && i2 != 2) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
            }
            if (!TextUtils.equals(this.f43465b, "aac") && !TextUtils.equals(this.f43465b, "pcm")) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
            }
            int i3 = this.f43467d;
            if (i3 != 8000 && i3 != 16000 && i3 != 44100) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
            }
            if (!TextUtils.equals(this.f43465b, "pcm")) {
                if ((r3 = this.f43467d) != 8000) {
                    if (z) {
                        return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
                    }
                } else if (z) {
                }
            }
            if (this.f43469f < 0) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
            }
            return null;
        }
        return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
    }

    public String toString() {
        return "recordTime : " + this.f43464a + "; channel : " + this.f43466c + "; audioFormat : " + this.f43465b + "; sampleRate : " + this.f43467d + "; bitRate : " + this.f43468e + "; callbacks : " + this.f43470g;
    }
}
