package org.chromium.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.baidu.mobstat.Config;
import com.google.android.exoplayer2.extractor.mp4.MetadataUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.ArrayList;
import java.util.Locale;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.VerifiesOnN;
/* loaded from: classes2.dex */
public class LocaleUtils {
    @CalledByNative
    public static String getDefaultCountryCode() {
        CommandLine commandLine = CommandLine.getInstance();
        if (commandLine.hasSwitch(BaseSwitches.DEFAULT_COUNTRY_CODE_AT_INSTALL)) {
            return commandLine.getSwitchValue(BaseSwitches.DEFAULT_COUNTRY_CODE_AT_INSTALL);
        }
        return Locale.getDefault().getCountry();
    }

    @CalledByNative
    public static String getDefaultLocaleListString() {
        if (Build.VERSION.SDK_INT >= 24) {
            return toLanguageTags(LocaleList.getDefault());
        }
        return getDefaultLocaleString();
    }

    @CalledByNative
    public static String getDefaultLocaleString() {
        return toLanguageTag(Locale.getDefault());
    }

    @VisibleForTesting
    @VerifiesOnN
    @RequiresApi(24)
    /* loaded from: classes2.dex */
    public static class ApisN {
        public static LocaleList prependToLocaleList(String str, LocaleList localeList) {
            return LocaleList.forLanguageTags(String.format("%1$s,%2$s", str, localeList.toLanguageTags().replaceFirst(String.format("(^|,)%1$s$|%1$s,", str), "")));
        }

        public static void setConfigLocales(Context context, Configuration configuration, String str) {
            configuration.setLocales(prependToLocaleList(str, context.getResources().getConfiguration().getLocales()));
        }

        public static void setLocaleList(Configuration configuration) {
            LocaleList.setDefault(configuration.getLocales());
        }
    }

    public static Locale forLanguageTag(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getUpdatedLocaleForAndroid(Locale.forLanguageTag(str));
        }
        return forLanguageTagCompat(str);
    }

    public static String getConfigurationLanguage(Configuration configuration) {
        Locale locale = configuration.locale;
        if (locale != null) {
            return locale.toLanguageTag();
        }
        return "";
    }

    public static String getContextLanguage(Context context) {
        return getConfigurationLanguage(context.getResources().getConfiguration());
    }

    public static String getUpdatedLanguageForAndroid(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 101385) {
            if (hashCode == 115947 && str.equals(MetadataUtil.LANGUAGE_UNDEFINED)) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("fil")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                return str;
            }
            return "tl";
        }
        return "";
    }

    @TargetApi(21)
    @VisibleForTesting
    public static Locale getUpdatedLocaleForAndroid(Locale locale) {
        String language = locale.getLanguage();
        String updatedLanguageForAndroid = getUpdatedLanguageForAndroid(language);
        if (updatedLanguageForAndroid.equals(language)) {
            return locale;
        }
        return new Locale.Builder().setLocale(locale).setLanguage(updatedLanguageForAndroid).build();
    }

    @TargetApi(21)
    @VisibleForTesting
    public static Locale getUpdatedLocaleForChromium(Locale locale) {
        String language = locale.getLanguage();
        String updatedLanguageForChromium = getUpdatedLanguageForChromium(language);
        if (updatedLanguageForChromium.equals(language)) {
            return locale;
        }
        return new Locale.Builder().setLocale(locale).setLanguage(updatedLanguageForChromium).build();
    }

    public static void setDefaultLocalesFromConfiguration(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            ApisN.setLocaleList(configuration);
        } else {
            Locale.setDefault(configuration.locale);
        }
    }

    public static String toLanguage(String str) {
        int indexOf = str.indexOf(45);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    @TargetApi(24)
    public static String toLanguageTags(LocaleList localeList) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < localeList.size(); i++) {
            arrayList.add(toLanguageTag(getUpdatedLocaleForChromium(localeList.get(i))));
        }
        return TextUtils.join(",", arrayList);
    }

    public static Locale forLanguageTagCompat(String str) {
        String[] split = str.split("-");
        if (split.length == 0) {
            return new Locale("");
        }
        String updatedLanguageForAndroid = getUpdatedLanguageForAndroid(split[0]);
        if (updatedLanguageForAndroid.length() != 2 && updatedLanguageForAndroid.length() != 3) {
            return new Locale("");
        }
        if (split.length == 1) {
            return new Locale(updatedLanguageForAndroid);
        }
        String str2 = split[1];
        if (str2.length() != 2 && str2.length() != 3) {
            return new Locale(updatedLanguageForAndroid);
        }
        return new Locale(updatedLanguageForAndroid, str2);
    }

    public static String getUpdatedLanguageForChromium(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 3365) {
            if (hashCode != 3374) {
                if (hashCode != 3391) {
                    if (hashCode == 3704 && str.equals("tl")) {
                        c = 3;
                    }
                    c = 65535;
                } else {
                    if (str.equals("ji")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("iw")) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (str.equals("in")) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        return str;
                    }
                    return "fil";
                }
                return "id";
            }
            return "yi";
        }
        return Config.HEADER_PART;
    }

    public static String toLanguageTag(Locale locale) {
        String updatedLanguageForChromium = getUpdatedLanguageForChromium(locale.getLanguage());
        String country = locale.getCountry();
        if (updatedLanguageForChromium.equals("no") && country.equals(HlsPlaylistParser.BOOLEAN_FALSE) && locale.getVariant().equals("NY")) {
            return "nn-NO";
        }
        if (!country.isEmpty()) {
            return updatedLanguageForChromium + "-" + country;
        }
        return updatedLanguageForChromium;
    }

    public static void updateConfig(Context context, Configuration configuration, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            ApisN.setConfigLocales(context, configuration, str);
        } else {
            configuration.setLocale(Locale.forLanguageTag(str));
        }
    }
}
