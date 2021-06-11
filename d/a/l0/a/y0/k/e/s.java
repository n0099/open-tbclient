package d.a.l0.a.y0.k.e;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class s extends d.a.l0.a.y0.a<d.a.l0.a.y0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f49558b;

    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "setVolume";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.k.g.a aVar) {
        if (command.obj == null) {
            return;
        }
        if (!aVar.P()) {
            d(aVar, command.what, "Not Set!! Volume: " + command.obj, false);
            return;
        }
        Object obj = command.obj;
        if (obj instanceof Double) {
            try {
                double doubleValue = ((Double) obj).doubleValue();
                d(aVar, command.what, "Volume: " + command.obj, false);
                if (doubleValue > 1.0d) {
                    doubleValue = 1.0d;
                }
                if (doubleValue < 0.0d) {
                    doubleValue = 0.0d;
                }
                f(doubleValue, aVar.getContext());
            } catch (Exception unused) {
                if (d.a.l0.a.y0.a.f49445a) {
                    Log.e(b(), "setVolume param type error");
                }
            }
        }
    }

    public final void f(double d2, Context context) {
        if (this.f49558b == null) {
            this.f49558b = (AudioManager) context.getSystemService("audio");
        }
        AudioManager audioManager = this.f49558b;
        if (audioManager == null) {
            return;
        }
        int round = (int) Math.round(audioManager.getStreamMaxVolume(3) * d2);
        if (round == this.f49558b.getStreamVolume(3)) {
            if (d.a.l0.a.y0.a.f49445a) {
                Log.d("【InlineCommand】", "Setting same volume level, ignore : (" + round + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            return;
        }
        if (d2 > 0.0d && round == 0) {
            round = 1;
        }
        if (d.a.l0.a.y0.a.f49445a) {
            Log.d("【InlineCommand】", "setVolumeInt" + round);
        }
        this.f49558b.setStreamVolume(3, round, 0);
    }
}
