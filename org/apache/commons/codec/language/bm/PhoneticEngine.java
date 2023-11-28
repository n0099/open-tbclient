package org.apache.commons.codec.language.bm;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kuaishou.weapon.p0.t;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.codec.language.bm.Rule;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes2.dex */
public class PhoneticEngine {
    public static final Map<NameType, Set<String>> NAME_PREFIXES;
    public final boolean concat;
    public final Lang lang;
    public final NameType nameType;
    public final RuleType ruleType;

    /* renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$commons$codec$language$bm$NameType;

        static {
            int[] iArr = new int[NameType.values().length];
            $SwitchMap$org$apache$commons$codec$language$bm$NameType = iArr;
            try {
                iArr[NameType.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class PhonemeBuilder {
        public final Set<Rule.Phoneme> phonemes;

        public PhonemeBuilder(Set<Rule.Phoneme> set) {
            this.phonemes = set;
        }

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(Collections.singleton(new Rule.Phoneme("", languageSet)));
        }

        public PhonemeBuilder append(CharSequence charSequence) {
            HashSet hashSet = new HashSet();
            for (Rule.Phoneme phoneme : this.phonemes) {
                hashSet.add(phoneme.append(charSequence));
            }
            return new PhonemeBuilder(hashSet);
        }

        public PhonemeBuilder apply(Rule.PhonemeExpr phonemeExpr) {
            HashSet hashSet = new HashSet();
            for (Rule.Phoneme phoneme : this.phonemes) {
                for (Rule.Phoneme phoneme2 : phonemeExpr.getPhonemes()) {
                    Rule.Phoneme join = phoneme.join(phoneme2);
                    if (!join.getLanguages().isEmpty()) {
                        hashSet.add(join);
                    }
                }
            }
            return new PhonemeBuilder(hashSet);
        }

        public Set<Rule.Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            StringBuilder sb = new StringBuilder();
            for (Rule.Phoneme phoneme : this.phonemes) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(phoneme.getPhonemeText());
            }
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static final class RulesApplication {
        public final List<Rule> finalRules;
        public boolean found;
        public int i;
        public final CharSequence input;
        public PhonemeBuilder phonemeBuilder;

        public RulesApplication(List<Rule> list, CharSequence charSequence, PhonemeBuilder phonemeBuilder, int i) {
            if (list != null) {
                this.finalRules = list;
                this.phonemeBuilder = phonemeBuilder;
                this.input = charSequence;
                this.i = i;
                return;
            }
            throw new NullPointerException("The finalRules argument must not be null");
        }

        public int getI() {
            return this.i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public boolean isFound() {
            return this.found;
        }

        public RulesApplication invoke() {
            int i;
            int i2 = 0;
            this.found = false;
            Iterator<Rule> it = this.finalRules.iterator();
            while (true) {
                i = 1;
                if (!it.hasNext()) {
                    break;
                }
                Rule next = it.next();
                int length = next.getPattern().length();
                if (!next.patternAndContextMatches(this.input, this.i)) {
                    i2 = length;
                } else {
                    this.phonemeBuilder = this.phonemeBuilder.apply(next.getPhoneme());
                    this.found = true;
                    i2 = length;
                    break;
                }
            }
            if (this.found) {
                i = i2;
            }
            this.i += i;
            return this;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        NAME_PREFIXES = enumMap;
        enumMap.put((EnumMap) NameType.ASHKENAZI, (NameType) Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", "de", "van", "von"))));
        NAME_PREFIXES.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("al", t.n, "da", "dal", "de", "del", "dela", "de la", "della", "des", AppIconSetting.DEFAULT_LARGE_ICON, "do", "dos", "du", "van", "von"))));
        NAME_PREFIXES.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", "de", "del", "dela", "de la", "della", "des", AppIconSetting.DEFAULT_LARGE_ICON, "do", "dos", "du", "van", "von"))));
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z) {
        if (ruleType != RuleType.RULES) {
            this.nameType = nameType;
            this.ruleType = ruleType;
            this.concat = z;
            this.lang = Lang.instance(nameType);
            return;
        }
        throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES);
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, List<Rule> list) {
        PhonemeBuilder phonemeBuilder2;
        if (list != null) {
            if (list.isEmpty()) {
                return phonemeBuilder;
            }
            TreeSet treeSet = new TreeSet(Rule.Phoneme.COMPARATOR);
            for (Rule.Phoneme phoneme : phonemeBuilder.getPhonemes()) {
                PhonemeBuilder empty = PhonemeBuilder.empty(phoneme.getLanguages());
                CharSequence cacheSubSequence = cacheSubSequence(phoneme.getPhonemeText());
                int i = 0;
                while (i < cacheSubSequence.length()) {
                    RulesApplication invoke = new RulesApplication(list, cacheSubSequence, empty, i).invoke();
                    boolean isFound = invoke.isFound();
                    PhonemeBuilder phonemeBuilder3 = invoke.getPhonemeBuilder();
                    if (!isFound) {
                        phonemeBuilder2 = phonemeBuilder3.append(cacheSubSequence.subSequence(i, i + 1));
                    } else {
                        phonemeBuilder2 = phonemeBuilder3;
                    }
                    PhonemeBuilder phonemeBuilder4 = phonemeBuilder2;
                    i = invoke.getI();
                    empty = phonemeBuilder4;
                }
                treeSet.addAll(empty.getPhonemes());
            }
            return new PhonemeBuilder(treeSet);
        }
        throw new NullPointerException("finalRules can not be null");
    }

    public static CharSequence cacheSubSequence(final CharSequence charSequence) {
        final CharSequence[][] charSequenceArr = (CharSequence[][]) Array.newInstance(CharSequence.class, charSequence.length(), charSequence.length());
        return new CharSequence() { // from class: org.apache.commons.codec.language.bm.PhoneticEngine.1
            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                if (i == i2) {
                    return "";
                }
                int i3 = i2 - 1;
                CharSequence charSequence2 = charSequenceArr[i][i3];
                if (charSequence2 == null) {
                    CharSequence subSequence = charSequence.subSequence(i, i2);
                    charSequenceArr[i][i3] = subSequence;
                    return subSequence;
                }
                return charSequence2;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return charSequence.charAt(i);
            }

            @Override // java.lang.CharSequence
            public int length() {
                return charSequence.length();
            }
        };
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public static String join(Iterable<String> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public String encode(String str, Languages.LanguageSet languageSet) {
        String str2;
        String substring;
        String substring2;
        List<Rule> rule = Rule.getInstance(this.nameType, RuleType.RULES, languageSet);
        List<Rule> rule2 = Rule.getInstance(this.nameType, this.ruleType, "common");
        List<Rule> rule3 = Rule.getInstance(this.nameType, this.ruleType, languageSet);
        String trim = str.toLowerCase(Locale.ENGLISH).replace(SignatureImpl.SEP, WebvttCueParser.CHAR_SPACE).trim();
        int i = 0;
        if (this.nameType == NameType.GENERIC) {
            if (trim.length() >= 2 && trim.substring(0, 2).equals("d'")) {
                String str3 = "d" + trim.substring(2);
                return "(" + encode(substring2) + ")-(" + encode(str3) + SmallTailInfo.EMOTION_SUFFIX;
            }
            for (String str4 : NAME_PREFIXES.get(this.nameType)) {
                if (trim.startsWith(str4 + " ")) {
                    String str5 = str4 + trim.substring(str4.length() + 1);
                    return "(" + encode(substring) + ")-(" + encode(str5) + SmallTailInfo.EMOTION_SUFFIX;
                }
            }
        }
        List<String> asList = Arrays.asList(trim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList();
        int i2 = AnonymousClass2.$SwitchMap$org$apache$commons$codec$language$bm$NameType[this.nameType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    arrayList.addAll(asList);
                } else {
                    throw new IllegalStateException("Unreachable case: " + this.nameType);
                }
            } else {
                arrayList.addAll(asList);
                arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
            }
        } else {
            for (String str6 : asList) {
                String[] split = str6.split("'");
                arrayList.add(split[split.length - 1]);
            }
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        }
        if (this.concat) {
            str2 = join(arrayList, " ");
        } else if (arrayList.size() == 1) {
            str2 = (String) asList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str7 : arrayList) {
                sb.append("-");
                sb.append(encode(str7));
            }
            return sb.substring(1);
        }
        PhonemeBuilder empty = PhonemeBuilder.empty(languageSet);
        CharSequence cacheSubSequence = cacheSubSequence(str2);
        while (i < cacheSubSequence.length()) {
            RulesApplication invoke = new RulesApplication(rule, cacheSubSequence, empty, i).invoke();
            i = invoke.getI();
            empty = invoke.getPhonemeBuilder();
        }
        return applyFinalRules(applyFinalRules(empty, rule2), rule3).makeString();
    }

    public Lang getLang() {
        return this.lang;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }
}
