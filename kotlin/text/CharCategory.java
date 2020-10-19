package kotlin.text;

import kotlin.jvm.internal.PropertyReference1Impl;
@kotlin.h
/* loaded from: classes10.dex */
public enum CharCategory {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");
    
    private final String code;
    private final int value;
    public static final a Companion = new a(null);
    private static final kotlin.d categoryMap$delegate = kotlin.e.b(CharCategory$Companion$categoryMap$2.INSTANCE);

    CharCategory(int i, String str) {
        this.value = i;
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean contains(char c) {
        return Character.getType(c) == this.value;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        static final /* synthetic */ kotlin.reflect.j[] $$delegatedProperties = {kotlin.jvm.internal.t.a(new PropertyReference1Impl(kotlin.jvm.internal.t.M(a.class), "categoryMap", "getCategoryMap()Ljava/util/Map;"))};

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
