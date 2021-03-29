package kotlin.text;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.kwai.video.player.KsMediaMeta;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u0003\u0010\n\u001a \u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\u0003\u0010\r\u001a(\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u0003\u0010\u0011\u001a0\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\u0003\u0010\u0012\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0015\u001a(\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u0003\u0010\u0016\u001a(\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u0003\u0010\u0019\u001a\u0011\u0010\u001a\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001a\u0010\u001e\u001a\u001c\u0010 \u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b \u0010!\u001a\u001c\u0010\"\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\"\u0010!\u001a$\u0010%\u001a\u00020\u000e*\u00020\u00022\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b%\u0010&\u001a#\u0010*\u001a\u00020\u000e*\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+\u001a\u0013\u0010,\u001a\u00020\u0002*\u00020\u0013H\u0007¢\u0006\u0004\b,\u0010\u0015\u001a'\u0010,\u001a\u00020\u0002*\u00020\u00132\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000eH\u0007¢\u0006\u0004\b,\u0010\u0016\u001a\u001c\u0010.\u001a\u00020(*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b.\u0010/\u001a\u001c\u0010.\u001a\u00020(*\u00020\u00022\u0006\u00101\u001a\u000200H\u0087\b¢\u0006\u0004\b.\u00102\u001a\u0011\u00103\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b3\u0010\u001b\u001a\u001b\u00103\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b3\u0010\u001e\u001a\u0013\u00104\u001a\u00020\u0002*\u00020\bH\u0007¢\u0006\u0004\b4\u0010\n\u001a1\u00104\u001a\u00020\u0002*\u00020\b2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020(H\u0007¢\u0006\u0004\b4\u00106\u001a\u0013\u00107\u001a\u00020\b*\u00020\u0002H\u0007¢\u0006\u0004\b7\u00108\u001a1\u00107\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020(H\u0007¢\u0006\u0004\b7\u00109\u001a#\u0010;\u001a\u00020(*\u00020\u00022\u0006\u0010:\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b;\u0010<\u001a'\u0010=\u001a\u00020(*\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b=\u0010<\u001a4\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0016\u0010@\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010?0>\"\u0004\u0018\u00010?H\u0087\b¢\u0006\u0004\bA\u0010B\u001a,\u0010A\u001a\u00020\u0002*\u00020\u00022\u0016\u0010@\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010?0>\"\u0004\u0018\u00010?H\u0087\b¢\u0006\u0004\bA\u0010C\u001a<\u0010A\u001a\u00020\u0002*\u00020D2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u00022\u0016\u0010@\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010?0>\"\u0004\u0018\u00010?H\u0087\b¢\u0006\u0004\bA\u0010E\u001a4\u0010A\u001a\u00020\u0002*\u00020D2\u0006\u0010A\u001a\u00020\u00022\u0016\u0010@\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010?0>\"\u0004\u0018\u00010?H\u0087\b¢\u0006\u0004\bA\u0010F\u001a\u0014\u0010G\u001a\u00020\u0002*\u00020\u0002H\u0087\b¢\u0006\u0004\bG\u0010\u001b\u001a\u0011\u0010H\u001a\u00020(*\u000200¢\u0006\u0004\bH\u0010I\u001a$\u0010M\u001a\u00020\u000e*\u00020\u00022\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u000eH\u0081\b¢\u0006\u0004\bM\u0010N\u001a$\u0010M\u001a\u00020\u000e*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u000eH\u0081\b¢\u0006\u0004\bM\u0010P\u001a$\u0010Q\u001a\u00020\u000e*\u00020\u00022\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u000eH\u0081\b¢\u0006\u0004\bQ\u0010N\u001a$\u0010Q\u001a\u00020\u000e*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u000eH\u0081\b¢\u0006\u0004\bQ\u0010P\u001a$\u0010S\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\bS\u0010&\u001a;\u0010V\u001a\u00020(*\u0002002\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010'\u001a\u0002002\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bV\u0010W\u001a;\u0010V\u001a\u00020(*\u00020\u00022\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bV\u0010X\u001a\u0019\u0010Z\u001a\u00020\u0002*\u0002002\u0006\u0010Y\u001a\u00020\u000e¢\u0006\u0004\bZ\u0010[\u001a+\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\\\u001a\u00020J2\u0006\u0010]\u001a\u00020J2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b^\u0010_\u001a+\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010`\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b^\u0010b\u001a+\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\\\u001a\u00020J2\u0006\u0010]\u001a\u00020J2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bc\u0010_\u001a+\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010`\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bc\u0010b\u001a)\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00020g*\u0002002\u0006\u0010e\u001a\u00020d2\b\b\u0002\u0010f\u001a\u00020\u000e¢\u0006\u0004\bh\u0010i\u001a#\u0010k\u001a\u00020(*\u00020\u00022\u0006\u0010j\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bk\u0010<\u001a+\u0010k\u001a\u00020(*\u00020\u00022\u0006\u0010j\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bk\u0010l\u001a\u001c\u0010m\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\bm\u0010n\u001a$\u0010m\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\bm\u0010o\u001a\u001e\u0010p\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\bp\u0010q\u001a\u0014\u0010r\u001a\u00020\u0013*\u00020\u0002H\u0087\b¢\u0006\u0004\br\u0010s\u001a:\u0010r\u001a\u00020\u0013*\u00020\u00022\u0006\u0010t\u001a\u00020\u00132\b\b\u0002\u0010u\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\br\u0010v\u001a'\u0010r\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000eH\u0007¢\u0006\u0004\br\u0010w\u001a\u0014\u0010x\u001a\u00020\u0002*\u00020\u0002H\u0087\b¢\u0006\u0004\bx\u0010\u001b\u001a\u001c\u0010x\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\b¢\u0006\u0004\bx\u0010\u001e\u001a\u001e\u0010z\u001a\u00020d*\u00020\u00022\b\b\u0002\u0010y\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\bz\u0010{\u001a\u0014\u0010|\u001a\u00020\u0002*\u00020\u0002H\u0087\b¢\u0006\u0004\b|\u0010\u001b\u001a\u001c\u0010|\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\b¢\u0006\u0004\b|\u0010\u001e\")\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00020}j\b\u0012\u0004\u0012\u00020\u0002`~*\u00020D8F@\u0006¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0082\u0001"}, d2 = {"Ljava/lang/StringBuffer;", "stringBuffer", "", "String", "(Ljava/lang/StringBuffer;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "stringBuilder", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "", "bytes", "([B)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "([BLjava/nio/charset/Charset;)Ljava/lang/String;", "", "offset", "length", "([BII)Ljava/lang/String;", "([BIILjava/nio/charset/Charset;)Ljava/lang/String;", "", "chars", "([C)Ljava/lang/String;", "([CII)Ljava/lang/String;", "", "codePoints", "([III)Ljava/lang/String;", "capitalize", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "index", "codePointAt", "(Ljava/lang/String;I)I", "codePointBefore", "beginIndex", "endIndex", "codePointCount", "(Ljava/lang/String;II)I", "other", "", "ignoreCase", "compareTo", "(Ljava/lang/String;Ljava/lang/String;Z)I", "concatToString", "startIndex", "contentEquals", "(Ljava/lang/String;Ljava/lang/StringBuffer;)Z", "", "charSequence", "(Ljava/lang/String;Ljava/lang/CharSequence;)Z", "decapitalize", "decodeToString", "throwOnInvalidSequence", "([BIIZ)Ljava/lang/String;", "encodeToByteArray", "(Ljava/lang/String;)[B", "(Ljava/lang/String;IIZ)[B", "suffix", "endsWith", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "equals", "", "", "args", KsMediaMeta.KSM_KEY_FORMAT, "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "(Ljava/lang/CharSequence;)Z", "", "ch", "fromIndex", "nativeIndexOf", "(Ljava/lang/String;CI)I", "str", "(Ljava/lang/String;Ljava/lang/String;I)I", "nativeLastIndexOf", "codePointOffset", "offsetByCodePoints", "thisOffset", "otherOffset", "regionMatches", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "(Ljava/lang/String;ILjava/lang/String;IIZ)Z", "n", "repeat", "(Ljava/lang/CharSequence;I)Ljava/lang/String;", "oldChar", "newChar", "replace", "(Ljava/lang/String;CCZ)Ljava/lang/String;", "oldValue", "newValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "replaceFirst", "Ljava/util/regex/Pattern;", "regex", Constants.EXTRA_CONFIG_LIMIT, "", "split", "(Ljava/lang/CharSequence;Ljava/util/regex/Pattern;I)Ljava/util/List;", "prefix", "startsWith", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "substring", "(Ljava/lang/String;I)Ljava/lang/String;", "(Ljava/lang/String;II)Ljava/lang/String;", "toByteArray", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", "toCharArray", "(Ljava/lang/String;)[C", "destination", "destinationOffset", "(Ljava/lang/String;[CIII)[C", "(Ljava/lang/String;II)[C", "toLowerCase", "flags", "toPattern", "(Ljava/lang/String;I)Ljava/util/regex/Pattern;", "toUpperCase", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes7.dex */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    @InlineOnly
    public static final String String(byte[] bArr, int i, int i2, Charset charset) {
        return new String(bArr, i, i2, charset);
    }

    public static final String capitalize(String str) {
        if ((str.length() > 0) && Character.isLowerCase(str.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, 1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring != null) {
                String upperCase = substring.toUpperCase();
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
                sb.append(upperCase);
                String substring2 = str.substring(1);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                return sb.toString();
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return str;
    }

    @InlineOnly
    public static final int codePointAt(String str, int i) {
        if (str != null) {
            return str.codePointAt(i);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final int codePointBefore(String str, int i) {
        if (str != null) {
            return str.codePointBefore(i);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final int codePointCount(String str, int i, int i2) {
        if (str != null) {
            return str.codePointCount(i, i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final int compareTo(String str, String str2, boolean z) {
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return compareTo(str, str2, z);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String concatToString(char[] cArr) {
        return new String(cArr);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return concatToString(cArr, i, i2);
    }

    @InlineOnly
    public static final boolean contentEquals(String str, CharSequence charSequence) {
        if (str != null) {
            return str.contentEquals(charSequence);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String decapitalize(String str) {
        if ((str.length() > 0) && Character.isUpperCase(str.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, 1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring != null) {
                String lowerCase = substring.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                String substring2 = str.substring(1);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                return sb.toString();
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return str;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String decodeToString(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return decodeToString(bArr, i, i2, z);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte[] encodeToByteArray(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return encodeToByteArray(str, i, i2, z);
    }

    public static final boolean endsWith(String str, String str2, boolean z) {
        if (!z) {
            return str.endsWith(str2);
        }
        return regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(str, str2, z);
    }

    public static final boolean equals(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return equals(str, str2, z);
    }

    @InlineOnly
    public static final String format(String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
        return format;
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject stringCompanionObject) {
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkExpressionValueIsNotNull(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    @InlineOnly
    public static final String intern(String str) {
        if (str != null) {
            String intern = str.intern();
            Intrinsics.checkExpressionValueIsNotNull(intern, "(this as java.lang.String).intern()");
            return intern;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean isBlank(CharSequence charSequence) {
        boolean z;
        if (charSequence.length() != 0) {
            IntRange indices = StringsKt__StringsKt.getIndices(charSequence);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator<Integer> it = indices.iterator();
                while (it.hasNext()) {
                    if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(((IntIterator) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @InlineOnly
    public static final int nativeIndexOf(String str, char c2, int i) {
        if (str != null) {
            return str.indexOf(c2, i);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final int nativeLastIndexOf(String str, char c2, int i) {
        if (str != null) {
            return str.lastIndexOf(c2, i);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final int offsetByCodePoints(String str, int i, int i2) {
        if (str != null) {
            return str.offsetByCodePoints(i, i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean regionMatches(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return regionMatches((String) charSequence, i, (String) charSequence2, i2, i3, z);
        }
        return StringsKt__StringsKt.regionMatchesImpl(charSequence, i, charSequence2, i2, i3, z);
    }

    public static final String repeat(CharSequence charSequence, int i) {
        int i2 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + IStringUtil.EXTENSION_SEPARATOR).toString());
        } else if (i != 0) {
            if (i != 1) {
                int length = charSequence.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(charSequence.length() * i);
                        if (1 <= i) {
                            while (true) {
                                sb.append(charSequence);
                                if (i2 == i) {
                                    break;
                                }
                                i2++;
                            }
                        }
                        String sb2 = sb.toString();
                        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
                        return sb2;
                    }
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i];
                    for (int i3 = 0; i3 < i; i3++) {
                        cArr[i3] = charAt;
                    }
                    return new String(cArr);
                }
                return "";
            }
            return charSequence.toString();
        } else {
            return "";
        }
    }

    public static final String replace(String str, char c2, char c3, boolean z) {
        if (!z) {
            String replace = str.replace(c2, c3);
            Intrinsics.checkExpressionValueIsNotNull(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace;
        }
        return SequencesKt___SequencesKt.joinToString$default(StringsKt__StringsKt.splitToSequence$default(str, new char[]{c2}, z, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String replace$default(String str, char c2, char c3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replace(str, c2, c3, z);
    }

    public static final String replaceFirst(String str, char c2, char c3, boolean z) {
        int indexOf$default = StringsKt__StringsKt.indexOf$default(str, c2, 0, z, 2, (Object) null);
        return indexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, indexOf$default, indexOf$default + 1, (CharSequence) String.valueOf(c3)).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c2, char c3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, c2, c3, z);
    }

    public static final List<String> split(CharSequence charSequence, Pattern pattern, int i) {
        if (i >= 0) {
            if (i == 0) {
                i = -1;
            }
            String[] split = pattern.split(charSequence, i);
            Intrinsics.checkExpressionValueIsNotNull(split, "regex.split(this, if (limit == 0) -1 else limit)");
            return ArraysKt___ArraysJvmKt.asList(split);
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + IStringUtil.EXTENSION_SEPARATOR).toString());
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return split(charSequence, pattern, i);
    }

    public static final boolean startsWith(String str, String str2, boolean z) {
        if (!z) {
            return str.startsWith(str2);
        }
        return regionMatches(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(str, str2, z);
    }

    @InlineOnly
    public static final String substring(String str, int i) {
        if (str != null) {
            String substring = str.substring(i);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final byte[] toByteArray(String str, Charset charset) {
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final char[] toCharArray(String str, int i, int i2) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        char[] cArr = new char[i2 - i];
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return toCharArray(str, i, i2);
    }

    @InlineOnly
    public static final String toLowerCase(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final Pattern toPattern(String str, int i) {
        Pattern compile = Pattern.compile(str, i);
        Intrinsics.checkExpressionValueIsNotNull(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    public static /* synthetic */ Pattern toPattern$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Pattern compile = Pattern.compile(str, i);
        Intrinsics.checkExpressionValueIsNotNull(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    @InlineOnly
    public static final String toUpperCase(String str) {
        if (str != null) {
            String upperCase = str.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final String String(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String capitalize(String str, Locale locale) {
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String upperCase = substring.toUpperCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return str;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String concatToString(char[] cArr, int i, int i2) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    @InlineOnly
    public static final boolean contentEquals(String str, StringBuffer stringBuffer) {
        if (str != null) {
            return str.contentEquals(stringBuffer);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String decapitalize(String str, Locale locale) {
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring != null) {
            String lowerCase = substring.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            String substring2 = str.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String decodeToString(byte[] bArr, int i, int i2, boolean z) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (!z) {
            return new String(bArr, i, i2 - i, Charsets.UTF_8);
        }
        String charBuffer = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i, i2 - i)).toString();
        Intrinsics.checkExpressionValueIsNotNull(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte[] encodeToByteArray(String str, int i, int i2, boolean z) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (!z) {
            String substring = str.substring(i, i2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = Charsets.UTF_8;
            if (substring != null) {
                byte[] bytes = substring.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        ByteBuffer encode = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i, i2));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            if (array == null) {
                Intrinsics.throwNpe();
            }
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                Intrinsics.checkExpressionValueIsNotNull(array2, "byteBuffer.array()");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @InlineOnly
    public static final String format(StringCompanionObject stringCompanionObject, String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @InlineOnly
    public static final int nativeIndexOf(String str, String str2, int i) {
        if (str != null) {
            return str.indexOf(str2, i);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final int nativeLastIndexOf(String str, String str2, int i) {
        if (str != null) {
            return str.lastIndexOf(str2, i);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replace(str, str2, str3, z);
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, str2, str3, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(str, str2, i, z);
    }

    @InlineOnly
    public static final String substring(String str, int i, int i2) {
        if (str != null) {
            String substring = str.substring(i, i2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ char[] toCharArray$default(String str, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = str.length();
        }
        if (str != null) {
            str.getChars(i2, i3, cArr, i);
            return cArr;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final String toLowerCase(String str, Locale locale) {
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final String toUpperCase(String str, Locale locale) {
        if (str != null) {
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final String String(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, Charsets.UTF_8);
    }

    @InlineOnly
    public static final String format(String str, Locale locale, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    public static final String replace(String str, String str2, String str3, boolean z) {
        return SequencesKt___SequencesKt.joinToString$default(StringsKt__StringsKt.splitToSequence$default(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    public static final String replaceFirst(String str, String str2, String str3, boolean z) {
        int indexOf$default = StringsKt__StringsKt.indexOf$default(str, str2, 0, z, 2, (Object) null);
        return indexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, indexOf$default, str2.length() + indexOf$default, (CharSequence) str3).toString();
    }

    public static final boolean startsWith(String str, String str2, int i, boolean z) {
        if (!z) {
            return str.startsWith(str2, i);
        }
        return regionMatches(str, i, str2, 0, str2.length(), z);
    }

    @InlineOnly
    public static final char[] toCharArray(String str) {
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            return charArray;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final String String(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    @InlineOnly
    public static final String format(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final boolean regionMatches(String str, int i, String str2, int i2, int i3, boolean z) {
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }

    @InlineOnly
    public static final char[] toCharArray(String str, char[] cArr, int i, int i2, int i3) {
        if (str != null) {
            str.getChars(i2, i3, cArr, i);
            return cArr;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    public static final String String(char[] cArr) {
        return new String(cArr);
    }

    @InlineOnly
    public static final String String(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    @InlineOnly
    public static final String String(int[] iArr, int i, int i2) {
        return new String(iArr, i, i2);
    }

    @InlineOnly
    public static final String String(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    @InlineOnly
    public static final String String(StringBuilder sb) {
        return new String(sb);
    }
}
