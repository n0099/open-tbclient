package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class LocalizationChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LocalizationChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MethodChannel channel;

    public LocalizationChannel(@NonNull DartExecutor dartExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.channel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
    }

    public void sendLocales(@NonNull List<Locale> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
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
}
