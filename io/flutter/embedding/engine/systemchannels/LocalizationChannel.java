package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class LocalizationChannel {
    public static final String TAG = "LocalizationChannel";
    @NonNull
    public final MethodChannel channel;

    public LocalizationChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
    }

    public void sendLocales(@NonNull List<Locale> list) {
        Log.v(TAG, "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            Log.v(TAG, "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + SmallTailInfo.EMOTION_SUFFIX);
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.channel.invokeMethod("setLocale", arrayList);
    }
}
