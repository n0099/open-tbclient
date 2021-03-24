package d.b.g0.g.c;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.b.g0.a.k;
import d.b.g0.g.l.n;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, String> f47945a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f47945a = hashMap;
        hashMap.put("494433", EmotionResourceProvider.EMOTION_SOUND_SUFFIX);
        f47945a.put("524946", ".wav");
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        String sb2 = sb.toString();
        if (k.f45050a) {
            Log.e("AudioDataUtils", "audio buffer header: " + sb2);
        }
        return sb2;
    }

    public static boolean b(float f2) {
        return f2 <= 1.0f && f2 >= 0.0f;
    }

    public static d c(g gVar) {
        d dVar = new d();
        dVar.f47934a = gVar.f47947f;
        dVar.f47938e = gVar.autoplay;
        dVar.f47939f = gVar.loop;
        dVar.f47936c = gVar.src;
        dVar.f47937d = gVar.startTime;
        dVar.f47940g = gVar.obeyMuteSwitch;
        dVar.i = gVar.volume;
        dVar.j = i().toString();
        return dVar;
    }

    public static String d(String str) throws MalformedURLException {
        int lastIndexOf = str.lastIndexOf(46);
        String substring = lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
        return "/" + d.b.g0.a.r1.e.T() + "/" + str.hashCode() + substring;
    }

    public static String e() {
        String str = n.n() + "/usr";
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return str;
        }
        Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
        return "";
    }

    public static String f() {
        return File.separator + "bdata" + File.separator;
    }

    public static String g() {
        String e2 = e();
        return (!j() || TextUtils.isEmpty(e2)) ? AppRuntime.getAppContext().getCacheDir().getAbsolutePath() : e2;
    }

    public static String h(byte[] bArr) {
        if (bArr == null || 3 > bArr.length) {
            return "";
        }
        byte[] bArr2 = new byte[3];
        for (int i = 0; i < 3; i++) {
            bArr2[i] = bArr[i];
        }
        return f47945a.get(a(bArr2));
    }

    public static JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onCanplay", "canplay");
            jSONObject.put("onPlay", "play");
            jSONObject.put("onEnded", "ended");
            jSONObject.put(MissionEvent.MESSAGE_PAUSE, "pause");
            jSONObject.put("onSeeking", "seeking");
            jSONObject.put("onSeeked", "seeked");
            jSONObject.put(MissionEvent.MESSAGE_STOP, IntentConfig.STOP);
            jSONObject.put("onError", "error");
            jSONObject.put("onTimeUpdate", "timeupdate");
            jSONObject.put("onBufferingUpdate", "buffered");
            jSONObject.put("onWaiting", "waiting");
        } catch (Exception e2) {
            if (k.f45050a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean j() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
