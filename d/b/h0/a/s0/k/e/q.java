package d.b.h0.a.s0.k.e;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class q extends d.b.h0.a.s0.a<d.b.h0.a.s0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f46611b;

    @Override // d.b.h0.a.s0.a
    @NonNull
    public String b() {
        return "setVolume";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.h0.a.s0.k.g.a aVar) {
        if (command.obj == null) {
            return;
        }
        if (!aVar.o()) {
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
                if (d.b.h0.a.s0.a.f46504a) {
                    Log.e(b(), "setVolume param type error");
                }
            }
        }
    }

    public final void f(double d2, Context context) {
        if (this.f46611b == null) {
            this.f46611b = (AudioManager) context.getSystemService("audio");
        }
        AudioManager audioManager = this.f46611b;
        if (audioManager == null) {
            return;
        }
        int round = (int) Math.round(audioManager.getStreamMaxVolume(3) * d2);
        if (round == this.f46611b.getStreamVolume(3)) {
            if (d.b.h0.a.s0.a.f46504a) {
                Log.d("【InlineCommand】", "Setting same volume level, ignore : (" + round + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            return;
        }
        if (d2 > 0.0d && round == 0) {
            round = 1;
        }
        if (d.b.h0.a.s0.a.f46504a) {
            Log.d("【InlineCommand】", "setVolumeInt" + round);
        }
        this.f46611b.setStreamVolume(3, round, 0);
    }
}
