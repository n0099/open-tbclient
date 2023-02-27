package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages;
/* loaded from: classes9.dex */
public class Lang {
    public static final String LANGUAGE_RULES_RN = "org/apache/commons/codec/language/bm/lang.txt";
    public static final Map<NameType, Lang> Langs = new EnumMap(NameType.class);
    public final Languages languages;
    public final List<LangRule> rules;

    /* loaded from: classes9.dex */
    public static final class LangRule {
        public final boolean acceptOnMatch;
        public final Set<String> languages;
        public final Pattern pattern;

        public LangRule(Pattern pattern, Set<String> set, boolean z) {
            this.pattern = pattern;
            this.languages = set;
            this.acceptOnMatch = z;
        }

        public boolean matches(String str) {
            return this.pattern.matcher(str).find();
        }
    }

    static {
        NameType[] values;
        for (NameType nameType : NameType.values()) {
            Langs.put(nameType, loadFromResource(LANGUAGE_RULES_RN, Languages.getInstance(nameType)));
        }
    }

    public Lang(List<LangRule> list, Languages languages) {
        this.rules = Collections.unmodifiableList(list);
        this.languages = languages;
    }

    public static Lang instance(NameType nameType) {
        return Langs.get(nameType);
    }

    public String guessLanguage(String str) {
        Languages.LanguageSet guessLanguages = guessLanguages(str);
        if (guessLanguages.isSingleton()) {
            return guessLanguages.getAny();
        }
        return Languages.ANY;
    }

    public static Lang loadFromResource(String str, Languages languages) {
        String str2;
        ArrayList arrayList = new ArrayList();
        InputStream resourceAsStream = Lang.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
            while (true) {
                boolean z = false;
                while (scanner.hasNextLine()) {
                    String nextLine = scanner.nextLine();
                    if (z) {
                        if (nextLine.endsWith(ResourceConstants.EXT_CMT_END)) {
                            break;
                        }
                    } else if (nextLine.startsWith(ResourceConstants.EXT_CMT_START)) {
                        z = true;
                    } else {
                        int indexOf = nextLine.indexOf(ResourceConstants.CMT);
                        if (indexOf >= 0) {
                            str2 = nextLine.substring(0, indexOf);
                        } else {
                            str2 = nextLine;
                        }
                        String trim = str2.trim();
                        if (trim.length() != 0) {
                            String[] split = trim.split("\\s+");
                            if (split.length != 3) {
                                PrintStream printStream = System.err;
                                printStream.println("Warning: malformed line '" + nextLine + "'");
                            } else {
                                Pattern compile = Pattern.compile(split[0]);
                                String[] split2 = split[1].split("\\+");
                                arrayList.add(new LangRule(compile, new HashSet(Arrays.asList(split2)), split[2].equals("true")));
                            }
                        }
                    }
                }
                return new Lang(arrayList, languages);
            }
        }
        throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/lang.txt");
    }

    public Languages.LanguageSet guessLanguages(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.languages.getLanguages());
        for (LangRule langRule : this.rules) {
            if (langRule.matches(lowerCase)) {
                if (langRule.acceptOnMatch) {
                    hashSet.retainAll(langRule.languages);
                } else {
                    hashSet.removeAll(langRule.languages);
                }
            }
        }
        Languages.LanguageSet from = Languages.LanguageSet.from(hashSet);
        if (from.equals(Languages.NO_LANGUAGES)) {
            return Languages.ANY_LANGUAGE;
        }
        return from;
    }
}
