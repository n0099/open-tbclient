package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.a;
import d.g.c.a.b;
import d.g.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public enum CaseFormat {
    LOWER_HYPHEN(b.e('-'), "-") { // from class: com.google.common.base.CaseFormat.1
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return a.e(str.replace('-', '_'));
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return a.c(str);
        }
    },
    LOWER_UNDERSCORE(b.e('_'), "_") { // from class: com.google.common.base.CaseFormat.2
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return a.e(str);
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return a.c(str);
        }
    },
    LOWER_CAMEL(b.c('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.3
        @Override // com.google.common.base.CaseFormat
        public String normalizeFirstWord(String str) {
            return a.c(str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_CAMEL(b.c('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.4
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_UNDERSCORE(b.e('_'), "_") { // from class: com.google.common.base.CaseFormat.5
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return a.c(str.replace('_', '-'));
            }
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return a.c(str);
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return a.e(str);
        }
    };
    
    public final b wordBoundary;
    public final String wordSeparator;

    /* loaded from: classes6.dex */
    public static final class StringConverter extends Converter<String, String> implements Serializable {
        public static final long serialVersionUID = 0;
        public final CaseFormat sourceFormat;
        public final CaseFormat targetFormat;

        public StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            n.p(caseFormat);
            this.sourceFormat = caseFormat;
            n.p(caseFormat2);
            this.targetFormat = caseFormat2;
        }

        @Override // com.google.common.base.Converter, d.g.c.a.g
        public boolean equals(Object obj) {
            if (obj instanceof StringConverter) {
                StringConverter stringConverter = (StringConverter) obj;
                return this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat);
            }
            return false;
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + SmallTailInfo.EMOTION_SUFFIX;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }
    }

    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return a.d(str.charAt(0)) + a.c(str.substring(1));
    }

    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            i3 = this.wordBoundary.d(str, i3 + 1);
            if (i3 == -1) {
                break;
            }
            if (i2 == 0) {
                sb = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                sb.append(caseFormat.normalizeFirstWord(str.substring(i2, i3)));
            } else {
                sb.append(caseFormat.normalizeWord(str.substring(i2, i3)));
            }
            sb.append(caseFormat.wordSeparator);
            i2 = this.wordSeparator.length() + i3;
        }
        if (i2 == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        sb.append(caseFormat.normalizeWord(str.substring(i2)));
        return sb.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    public String normalizeFirstWord(String str) {
        return normalizeWord(str);
    }

    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        n.p(caseFormat);
        n.p(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }

    CaseFormat(b bVar, String str) {
        this.wordBoundary = bVar;
        this.wordSeparator = str;
    }
}
