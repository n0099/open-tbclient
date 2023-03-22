package kotlin.reflect.jvm.internal.impl.util;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
/* loaded from: classes9.dex */
public final class OperatorNameConventions {
    @JvmField
    public static final Name AND;
    @JvmField
    public static final Set<Name> ASSIGNMENT_OPERATIONS;
    @JvmField
    public static final Set<Name> BINARY_OPERATION_NAMES;
    @JvmField
    public static final Name COMPARE_TO;
    @JvmField
    public static final Regex COMPONENT_REGEX;
    @JvmField
    public static final Name CONTAINS;
    @JvmField
    public static final Name DEC;
    @JvmField
    public static final Set<Name> DELEGATED_PROPERTY_OPERATORS;
    @JvmField
    public static final Name DIV;
    @JvmField
    public static final Name DIV_ASSIGN;
    @JvmField
    public static final Name EQUALS;
    @JvmField
    public static final Name GET;
    @JvmField
    public static final Name GET_VALUE;
    @JvmField
    public static final Name HAS_NEXT;
    @JvmField
    public static final Name INC;
    public static final OperatorNameConventions INSTANCE = new OperatorNameConventions();
    @JvmField
    public static final Name INVOKE;
    @JvmField
    public static final Name ITERATOR;
    @JvmField
    public static final Name MINUS;
    @JvmField
    public static final Name MINUS_ASSIGN;
    @JvmField
    public static final Name MOD;
    @JvmField
    public static final Name MOD_ASSIGN;
    @JvmField
    public static final Name NEXT;
    @JvmField
    public static final Name NOT;
    @JvmField
    public static final Name OR;
    @JvmField
    public static final Name PLUS;
    @JvmField
    public static final Name PLUS_ASSIGN;
    @JvmField
    public static final Name PROVIDE_DELEGATE;
    @JvmField
    public static final Name RANGE_TO;
    @JvmField
    public static final Name REM;
    @JvmField
    public static final Name REM_ASSIGN;
    @JvmField
    public static final Name SET;
    @JvmField
    public static final Name SET_VALUE;
    @JvmField
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES;
    @JvmField
    public static final Name TIMES;
    @JvmField
    public static final Name TIMES_ASSIGN;
    @JvmField
    public static final Name UNARY_MINUS;
    @JvmField
    public static final Set<Name> UNARY_OPERATION_NAMES;
    @JvmField
    public static final Name UNARY_PLUS;

    static {
        Name identifier = Name.identifier("getValue");
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(\"getValue\")");
        GET_VALUE = identifier;
        Name identifier2 = Name.identifier("setValue");
        Intrinsics.checkExpressionValueIsNotNull(identifier2, "Name.identifier(\"setValue\")");
        SET_VALUE = identifier2;
        Name identifier3 = Name.identifier("provideDelegate");
        Intrinsics.checkExpressionValueIsNotNull(identifier3, "Name.identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = identifier3;
        Name identifier4 = Name.identifier("equals");
        Intrinsics.checkExpressionValueIsNotNull(identifier4, "Name.identifier(\"equals\")");
        EQUALS = identifier4;
        Name identifier5 = Name.identifier("compareTo");
        Intrinsics.checkExpressionValueIsNotNull(identifier5, "Name.identifier(\"compareTo\")");
        COMPARE_TO = identifier5;
        Name identifier6 = Name.identifier("contains");
        Intrinsics.checkExpressionValueIsNotNull(identifier6, "Name.identifier(\"contains\")");
        CONTAINS = identifier6;
        Name identifier7 = Name.identifier("invoke");
        Intrinsics.checkExpressionValueIsNotNull(identifier7, "Name.identifier(\"invoke\")");
        INVOKE = identifier7;
        Name identifier8 = Name.identifier("iterator");
        Intrinsics.checkExpressionValueIsNotNull(identifier8, "Name.identifier(\"iterator\")");
        ITERATOR = identifier8;
        Name identifier9 = Name.identifier("get");
        Intrinsics.checkExpressionValueIsNotNull(identifier9, "Name.identifier(\"get\")");
        GET = identifier9;
        Name identifier10 = Name.identifier("set");
        Intrinsics.checkExpressionValueIsNotNull(identifier10, "Name.identifier(\"set\")");
        SET = identifier10;
        Name identifier11 = Name.identifier(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
        Intrinsics.checkExpressionValueIsNotNull(identifier11, "Name.identifier(\"next\")");
        NEXT = identifier11;
        Name identifier12 = Name.identifier("hasNext");
        Intrinsics.checkExpressionValueIsNotNull(identifier12, "Name.identifier(\"hasNext\")");
        HAS_NEXT = identifier12;
        COMPONENT_REGEX = new Regex("component\\d+");
        Name identifier13 = Name.identifier("and");
        Intrinsics.checkExpressionValueIsNotNull(identifier13, "Name.identifier(\"and\")");
        AND = identifier13;
        Name identifier14 = Name.identifier("or");
        Intrinsics.checkExpressionValueIsNotNull(identifier14, "Name.identifier(\"or\")");
        OR = identifier14;
        Name identifier15 = Name.identifier("inc");
        Intrinsics.checkExpressionValueIsNotNull(identifier15, "Name.identifier(\"inc\")");
        INC = identifier15;
        Name identifier16 = Name.identifier("dec");
        Intrinsics.checkExpressionValueIsNotNull(identifier16, "Name.identifier(\"dec\")");
        DEC = identifier16;
        Name identifier17 = Name.identifier("plus");
        Intrinsics.checkExpressionValueIsNotNull(identifier17, "Name.identifier(\"plus\")");
        PLUS = identifier17;
        Name identifier18 = Name.identifier("minus");
        Intrinsics.checkExpressionValueIsNotNull(identifier18, "Name.identifier(\"minus\")");
        MINUS = identifier18;
        Name identifier19 = Name.identifier("not");
        Intrinsics.checkExpressionValueIsNotNull(identifier19, "Name.identifier(\"not\")");
        NOT = identifier19;
        Name identifier20 = Name.identifier("unaryMinus");
        Intrinsics.checkExpressionValueIsNotNull(identifier20, "Name.identifier(\"unaryMinus\")");
        UNARY_MINUS = identifier20;
        Name identifier21 = Name.identifier("unaryPlus");
        Intrinsics.checkExpressionValueIsNotNull(identifier21, "Name.identifier(\"unaryPlus\")");
        UNARY_PLUS = identifier21;
        Name identifier22 = Name.identifier("times");
        Intrinsics.checkExpressionValueIsNotNull(identifier22, "Name.identifier(\"times\")");
        TIMES = identifier22;
        Name identifier23 = Name.identifier(TtmlNode.TAG_DIV);
        Intrinsics.checkExpressionValueIsNotNull(identifier23, "Name.identifier(\"div\")");
        DIV = identifier23;
        Name identifier24 = Name.identifier(SearchJsBridge.COOKIE_MOD);
        Intrinsics.checkExpressionValueIsNotNull(identifier24, "Name.identifier(\"mod\")");
        MOD = identifier24;
        Name identifier25 = Name.identifier("rem");
        Intrinsics.checkExpressionValueIsNotNull(identifier25, "Name.identifier(\"rem\")");
        REM = identifier25;
        Name identifier26 = Name.identifier("rangeTo");
        Intrinsics.checkExpressionValueIsNotNull(identifier26, "Name.identifier(\"rangeTo\")");
        RANGE_TO = identifier26;
        Name identifier27 = Name.identifier("timesAssign");
        Intrinsics.checkExpressionValueIsNotNull(identifier27, "Name.identifier(\"timesAssign\")");
        TIMES_ASSIGN = identifier27;
        Name identifier28 = Name.identifier("divAssign");
        Intrinsics.checkExpressionValueIsNotNull(identifier28, "Name.identifier(\"divAssign\")");
        DIV_ASSIGN = identifier28;
        Name identifier29 = Name.identifier("modAssign");
        Intrinsics.checkExpressionValueIsNotNull(identifier29, "Name.identifier(\"modAssign\")");
        MOD_ASSIGN = identifier29;
        Name identifier30 = Name.identifier("remAssign");
        Intrinsics.checkExpressionValueIsNotNull(identifier30, "Name.identifier(\"remAssign\")");
        REM_ASSIGN = identifier30;
        Name identifier31 = Name.identifier("plusAssign");
        Intrinsics.checkExpressionValueIsNotNull(identifier31, "Name.identifier(\"plusAssign\")");
        PLUS_ASSIGN = identifier31;
        Name identifier32 = Name.identifier("minusAssign");
        Intrinsics.checkExpressionValueIsNotNull(identifier32, "Name.identifier(\"minusAssign\")");
        MINUS_ASSIGN = identifier32;
        UNARY_OPERATION_NAMES = SetsKt__SetsKt.setOf((Object[]) new Name[]{INC, DEC, UNARY_PLUS, UNARY_MINUS, NOT});
        SIMPLE_UNARY_OPERATION_NAMES = SetsKt__SetsKt.setOf((Object[]) new Name[]{UNARY_PLUS, UNARY_MINUS, NOT});
        BINARY_OPERATION_NAMES = SetsKt__SetsKt.setOf((Object[]) new Name[]{TIMES, PLUS, MINUS, DIV, MOD, REM, RANGE_TO});
        ASSIGNMENT_OPERATIONS = SetsKt__SetsKt.setOf((Object[]) new Name[]{TIMES_ASSIGN, DIV_ASSIGN, MOD_ASSIGN, REM_ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN});
        DELEGATED_PROPERTY_OPERATORS = SetsKt__SetsKt.setOf((Object[]) new Name[]{GET_VALUE, SET_VALUE, PROVIDE_DELEGATE});
    }
}
