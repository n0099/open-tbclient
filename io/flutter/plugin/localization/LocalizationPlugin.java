package io.flutter.plugin.localization;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes4.dex */
public class LocalizationPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context context;
    @NonNull
    public final LocalizationChannel localizationChannel;
    @VisibleForTesting
    public final LocalizationChannel.LocalizationMessageHandler localizationMessageHandler;

    public LocalizationPlugin(@NonNull Context context, @NonNull LocalizationChannel localizationChannel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, localizationChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LocalizationChannel.LocalizationMessageHandler localizationMessageHandler = new LocalizationChannel.LocalizationMessageHandler(this) { // from class: io.flutter.plugin.localization.LocalizationPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LocalizationPlugin this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
            @Override // io.flutter.embedding.engine.systemchannels.LocalizationChannel.LocalizationMessageHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public String getStringResource(@NonNull String str, @Nullable String str2) {
                InterceptResult invokeLL;
                Locale locale;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) {
                    Context context2 = this.this$0.context;
                    if (str2 != null) {
                        Locale localeFromString = LocalizationPlugin.localeFromString(str2);
                        if (Build.VERSION.SDK_INT < 17) {
                            Resources resources = this.this$0.context.getResources();
                            Configuration configuration = resources.getConfiguration();
                            locale = configuration.locale;
                            configuration.locale = localeFromString;
                            resources.updateConfiguration(configuration, null);
                            int identifier = context2.getResources().getIdentifier(str, "string", this.this$0.context.getPackageName());
                            String string = identifier == 0 ? context2.getResources().getString(identifier) : null;
                            if (str2 != null && Build.VERSION.SDK_INT < 17) {
                                Resources resources2 = this.this$0.context.getResources();
                                Configuration configuration2 = resources2.getConfiguration();
                                configuration2.locale = locale;
                                resources2.updateConfiguration(configuration2, null);
                            }
                            return string;
                        }
                        Configuration configuration3 = new Configuration(this.this$0.context.getResources().getConfiguration());
                        configuration3.setLocale(localeFromString);
                        context2 = this.this$0.context.createConfigurationContext(configuration3);
                    }
                    locale = null;
                    int identifier2 = context2.getResources().getIdentifier(str, "string", this.this$0.context.getPackageName());
                    if (identifier2 == 0) {
                    }
                    if (str2 != null) {
                        Resources resources22 = this.this$0.context.getResources();
                        Configuration configuration22 = resources22.getConfiguration();
                        configuration22.locale = locale;
                        resources22.updateConfiguration(configuration22, null);
                    }
                    return string;
                }
                return (String) invokeLL.objValue;
            }
        };
        this.localizationMessageHandler = localizationMessageHandler;
        this.context = context;
        this.localizationChannel = localizationChannel;
        localizationChannel.setLocalizationMessageHandler(localizationMessageHandler);
    }

    @VisibleForTesting
    public static Locale localeFromString(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String[] split = str.replace('_', SignatureImpl.SEP).split("-", -1);
            String str3 = split[0];
            String str4 = "";
            int i2 = 1;
            if (split.length <= 1 || split[1].length() != 4) {
                str2 = "";
            } else {
                str2 = split[1];
                i2 = 2;
            }
            if (split.length > i2 && split[i2].length() >= 2 && split[i2].length() <= 3) {
                str4 = split[i2];
            }
            return new Locale(str3, str4, str2);
        }
        return (Locale) invokeL.objValue;
    }

    public Locale resolveNativeLocale(List<Locale> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26) {
                ArrayList arrayList = new ArrayList();
                LocaleList locales = this.context.getResources().getConfiguration().getLocales();
                int size = locales.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Locale locale = locales.get(i3);
                    String language = locale.getLanguage();
                    if (!locale.getScript().isEmpty()) {
                        language = language + "-" + locale.getScript();
                    }
                    if (!locale.getCountry().isEmpty()) {
                        language = language + "-" + locale.getCountry();
                    }
                    arrayList.add(new Locale.LanguageRange(language));
                    arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
                    arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
                }
                Locale lookup = Locale.lookup(arrayList, list);
                return lookup != null ? lookup : list.get(0);
            } else if (i2 >= 24) {
                LocaleList locales2 = this.context.getResources().getConfiguration().getLocales();
                for (int i4 = 0; i4 < locales2.size(); i4++) {
                    Locale locale2 = locales2.get(i4);
                    for (Locale locale3 : list) {
                        if (locale2.equals(locale3)) {
                            return locale3;
                        }
                    }
                    for (Locale locale4 : list) {
                        if (locale2.getLanguage().equals(locale4.toLanguageTag())) {
                            return locale4;
                        }
                    }
                    for (Locale locale5 : list) {
                        if (locale2.getLanguage().equals(locale5.getLanguage())) {
                            return locale5;
                        }
                    }
                }
                return list.get(0);
            } else {
                Locale locale6 = this.context.getResources().getConfiguration().locale;
                if (locale6 != null) {
                    for (Locale locale7 : list) {
                        if (locale6.equals(locale7)) {
                            return locale7;
                        }
                    }
                    for (Locale locale8 : list) {
                        if (locale6.getLanguage().equals(locale8.toString())) {
                            return locale8;
                        }
                    }
                }
                return list.get(0);
            }
        }
        return (Locale) invokeL.objValue;
    }

    public void sendLocalesToFlutter(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleList locales = configuration.getLocales();
                int size = locales.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(locales.get(i2));
                }
            } else {
                arrayList.add(configuration.locale);
            }
            this.localizationChannel.sendLocales(arrayList);
        }
    }
}
