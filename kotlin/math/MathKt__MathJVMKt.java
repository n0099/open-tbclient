package kotlin.math;

import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.TbConfig;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bD\u001a\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0018\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0002\u0010\b\u001a\u0018\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\u0003\u001a\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\f\u0010\u0005\u001a\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\r\u0010\u0003\u001a\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\r\u0010\u0005\u001a\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u0003\u001a\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0005\u001a\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0005\u001a \u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0013\u001a\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0003\u001a\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0005\u001a\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0003\u001a\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0003\u001a\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0005\u001a\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0005\u001a\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0003\u001a\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0005\u001a\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0003\u001a\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u0018\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0003\u001a\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0005\u001a \u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001b\u0010\u0012\u001a \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001b\u0010\u0013\u001a\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0003\u001a\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0005\u001a\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001d\u0010\u0003\u001a\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001d\u0010\u0005\u001a\u001f\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u001f\u0010\u0012\u001a\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0013\u001a\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b \u0010\u0003\u001a\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b \u0010\u0005\u001a\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b!\u0010\u0003\u001a\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\u0005\u001a \u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b$\u0010\u0012\u001a \u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b$\u0010\u0013\u001a \u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b$\u0010%\u001a \u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0087\b¢\u0006\u0004\b$\u0010&\u001a \u0010'\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b'\u0010\u0012\u001a \u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b'\u0010\u0013\u001a \u0010'\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b'\u0010%\u001a \u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0087\b¢\u0006\u0004\b'\u0010&\u001a\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b(\u0010\u0003\u001a\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b(\u0010\u0005\u001a\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b)\u0010\u0003\u001a\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b)\u0010\u0005\u001a\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b*\u0010\u0003\u001a\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b*\u0010\u0005\u001a\u0018\u0010+\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b+\u0010\u0003\u001a\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b+\u0010\u0005\u001a\u0018\u0010,\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b,\u0010\u0003\u001a\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b,\u0010\u0005\u001a\u0018\u0010-\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b-\u0010\u0003\u001a\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b-\u0010\u0005\u001a\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b.\u0010\u0003\u001a\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b.\u0010\u0005\u001a\u0017\u0010/\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b/\u0010\u0003\u001a\u0017\u0010/\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0007¢\u0006\u0004\b/\u0010\u0005\u001a\u001c\u00101\u001a\u00020\u0000*\u00020\u00002\u0006\u00100\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b1\u0010\u0012\u001a\u001c\u00101\u001a\u00020\u0004*\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b1\u0010\u0013\u001a\u0014\u00102\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b2\u0010\u0003\u001a\u0014\u00102\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b2\u0010\u0005\u001a\u001c\u00104\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b4\u0010\u0012\u001a\u001c\u00104\u001a\u00020\u0004*\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b4\u0010\u0013\u001a\u0014\u00105\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b5\u0010\u0003\u001a\u0014\u00105\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b5\u0010\u0005\u001a\u001c\u00106\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b6\u0010\u0012\u001a\u001c\u00106\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b6\u00107\u001a\u001c\u00106\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b6\u0010\u0013\u001a\u001c\u00106\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b6\u00108\u001a\u0013\u00109\u001a\u00020\u0006*\u00020\u0000H\u0007¢\u0006\u0004\b9\u0010:\u001a\u0013\u00109\u001a\u00020\u0006*\u00020\u0004H\u0007¢\u0006\u0004\b9\u0010;\u001a\u0013\u0010<\u001a\u00020\t*\u00020\u0000H\u0007¢\u0006\u0004\b<\u0010=\u001a\u0013\u0010<\u001a\u00020\t*\u00020\u0004H\u0007¢\u0006\u0004\b<\u0010>\u001a\u001c\u0010?\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b?\u0010\u0012\u001a\u001c\u0010?\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b?\u00107\u001a\u001c\u0010?\u001a\u00020\u0004*\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b?\u0010\u0013\u001a\u001c\u0010?\u001a\u00020\u0004*\u00020\u00042\u0006\u0010)\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b?\u00108\"!\u0010C\u001a\u00020\u0000*\u00020\u00008Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010B\u001a\u0004\b@\u0010\u0003\"!\u0010C\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010D\u001a\u0004\b@\u0010\u0005\"!\u0010C\u001a\u00020\u0006*\u00020\u00068Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010E\u001a\u0004\b@\u0010\b\"!\u0010C\u001a\u00020\t*\u00020\t8Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010F\u001a\u0004\b@\u0010\n\"!\u0010)\u001a\u00020\u0000*\u00020\u00008Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010B\u001a\u0004\bG\u0010\u0003\"!\u0010)\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010D\u001a\u0004\bG\u0010\u0005\" \u0010)\u001a\u00020\u0006*\u00020\u00068F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010E\u001a\u0004\bG\u0010\b\" \u0010)\u001a\u00020\u0006*\u00020\t8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010F\u001a\u0004\bG\u0010I\"!\u0010L\u001a\u00020\u0000*\u00020\u00008Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bK\u0010B\u001a\u0004\bJ\u0010\u0003\"!\u0010L\u001a\u00020\u0004*\u00020\u00048Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bK\u0010D\u001a\u0004\bJ\u0010\u0005¨\u0006M"}, d2 = {"", "x", "abs", "(D)D", "", "(F)F", "", "n", "(I)I", "", "(J)J", "acos", "acosh", "asin", "asinh", "atan", "y", "atan2", "(DD)D", "(FF)F", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", SchemeCollecter.CLASSIFY_BASE, TbConfig.TMP_LOG_DIR_NAME, "log10", "log2", "a", "b", "max", "(II)I", "(JJ)J", "min", "round", "sign", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "divisor", "IEEErem", "nextDown", "to", "nextTowards", "nextUp", "pow", "(DI)D", "(FI)F", "roundToInt", "(D)I", "(F)I", "roundToLong", "(D)J", "(F)J", "withSign", "getAbsoluteValue", "getAbsoluteValue$annotations", "(D)V", "absoluteValue", "(F)V", "(I)V", "(J)V", "getSign", "getSign$annotations", "(J)I", "getUlp", "getUlp$annotations", "ulp", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/math/MathKt")
/* loaded from: classes10.dex */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double IEEErem(double d2, double d3) {
        return Math.IEEEremainder(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double abs(double d2) {
        return Math.abs(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double acos(double d2) {
        return Math.acos(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final double acosh(double d2) {
        double d3 = 1;
        if (d2 < d3) {
            return Double.NaN;
        }
        if (d2 > Constants.upper_taylor_2_bound) {
            return Math.log(d2) + Constants.LN2;
        }
        double d4 = d2 - d3;
        if (d4 >= Constants.taylor_n_bound) {
            return Math.log(d2 + Math.sqrt((d2 * d2) - d3));
        }
        double sqrt = Math.sqrt(d4);
        if (sqrt >= Constants.taylor_2_bound) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double asin(double d2) {
        return Math.asin(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final double asinh(double d2) {
        double d3 = Constants.taylor_n_bound;
        if (d2 < d3) {
            if (d2 <= (-d3)) {
                return -asinh(-d2);
            }
            return Math.abs(d2) >= Constants.taylor_2_bound ? d2 - (((d2 * d2) * d2) / 6) : d2;
        } else if (d2 > Constants.upper_taylor_n_bound) {
            if (d2 > Constants.upper_taylor_2_bound) {
                return Math.log(d2) + Constants.LN2;
            }
            double d4 = d2 * 2;
            return Math.log(d4 + (1 / d4));
        } else {
            return Math.log(d2 + Math.sqrt((d2 * d2) + 1));
        }
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double atan(double d2) {
        return Math.atan(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double atan2(double d2, double d3) {
        return Math.atan2(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final double atanh(double d2) {
        if (Math.abs(d2) < Constants.taylor_n_bound) {
            return Math.abs(d2) > Constants.taylor_2_bound ? d2 + (((d2 * d2) * d2) / 3) : d2;
        }
        double d3 = 1;
        return Math.log((d3 + d2) / (d3 - d2)) / 2;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double ceil(double d2) {
        return Math.ceil(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double cos(double d2) {
        return Math.cos(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double cosh(double d2) {
        return Math.cosh(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double exp(double d2) {
        return Math.exp(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double expm1(double d2) {
        return Math.expm1(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double floor(double d2) {
        return Math.floor(d2);
    }

    public static final double getAbsoluteValue(double d2) {
        return Math.abs(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    public static final double getSign(double d2) {
        return Math.signum(d2);
    }

    public static final int getSign(int i2) {
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static final int getSign(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static /* synthetic */ void getSign$annotations(int i2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static /* synthetic */ void getSign$annotations(long j) {
    }

    public static final double getUlp(double d2) {
        return Math.ulp(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f2) {
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double hypot(double d2, double d3) {
        return Math.hypot(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double ln(double d2) {
        return Math.log(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double ln1p(double d2) {
        return Math.log1p(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final double log(double d2, double d3) {
        if (d3 <= 0.0d || d3 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d2) / Math.log(d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double log10(double d2) {
        return Math.log10(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final double log2(double d2) {
        return Math.log(d2) / Constants.LN2;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double max(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double min(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double nextDown(double d2) {
        return Math.nextAfter(d2, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double nextTowards(double d2, double d3) {
        return Math.nextAfter(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double nextUp(double d2) {
        return Math.nextUp(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double pow(double d2, double d3) {
        return Math.pow(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double round(double d2) {
        return Math.rint(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final int roundToInt(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (d2 < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final long roundToLong(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double sign(double d2) {
        return Math.signum(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double sin(double d2) {
        return Math.sin(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double sinh(double d2) {
        return Math.sinh(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double sqrt(double d2) {
        return Math.sqrt(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double tan(double d2) {
        return Math.tan(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double tanh(double d2) {
        return Math.tanh(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final double truncate(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            return d2;
        }
        if (d2 > 0) {
            return Math.floor(d2);
        }
        return Math.ceil(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double withSign(double d2, double d3) {
        return Math.copySign(d2, d3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float IEEErem(float f2, float f3) {
        return (float) Math.IEEEremainder(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float abs(float f2) {
        return Math.abs(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float acos(float f2) {
        return (float) Math.acos(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float asin(float f2) {
        return (float) Math.asin(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float atan(float f2) {
        return (float) Math.atan(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float atan2(float f2, float f3) {
        return (float) Math.atan2(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float ceil(float f2) {
        return (float) Math.ceil(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float cos(float f2) {
        return (float) Math.cos(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float cosh(float f2) {
        return (float) Math.cosh(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float exp(float f2) {
        return (float) Math.exp(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float expm1(float f2) {
        return (float) Math.expm1(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float floor(float f2) {
        return (float) Math.floor(f2);
    }

    public static final float getAbsoluteValue(float f2) {
        return Math.abs(f2);
    }

    public static final float getSign(float f2) {
        return Math.signum(f2);
    }

    public static final float getUlp(float f2) {
        return Math.ulp(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float hypot(float f2, float f3) {
        return (float) Math.hypot(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float ln(float f2) {
        return (float) Math.log(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float ln1p(float f2) {
        return (float) Math.log1p(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final float log(float f2, float f3) {
        if (f3 <= 0.0f || f3 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f2) / Math.log(f3));
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float log10(float f2) {
        return (float) Math.log10(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final float log2(float f2) {
        return (float) (Math.log(f2) / Constants.LN2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float max(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float min(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float nextDown(float f2) {
        return Math.nextAfter(f2, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float nextTowards(float f2, float f3) {
        return Math.nextAfter(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float nextUp(float f2) {
        return Math.nextUp(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double pow(double d2, int i2) {
        return Math.pow(d2, i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float round(float f2) {
        return (float) Math.rint(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final long roundToLong(float f2) {
        return roundToLong(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float sign(float f2) {
        return Math.signum(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float sin(float f2) {
        return (float) Math.sin(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float sinh(float f2) {
        return (float) Math.sinh(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float sqrt(float f2) {
        return (float) Math.sqrt(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float tan(float f2) {
        return (float) Math.tan(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float tanh(float f2) {
        return (float) Math.tanh(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double withSign(double d2, int i2) {
        return Math.copySign(d2, i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final int abs(int i2) {
        return Math.abs(i2);
    }

    public static final int getAbsoluteValue(int i2) {
        return Math.abs(i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final int max(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final int min(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float pow(float f2, float f3) {
        return (float) Math.pow(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float withSign(float f2, float f3) {
        return Math.copySign(f2, f3);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final long abs(long j) {
        return Math.abs(j);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float atanh(float f2) {
        return (float) atanh(f2);
    }

    public static final long getAbsoluteValue(long j) {
        return Math.abs(j);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final long max(long j, long j2) {
        return Math.max(j, j2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final long min(long j, long j2) {
        return Math.min(j, j2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float pow(float f2, int i2) {
        return (float) Math.pow(f2, i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final int roundToInt(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final float truncate(float f2) {
        double ceil;
        if (Float.isNaN(f2) || Float.isInfinite(f2)) {
            return f2;
        }
        if (f2 > 0) {
            ceil = Math.floor(f2);
        } else {
            ceil = Math.ceil(f2);
        }
        return (float) ceil;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float withSign(float f2, int i2) {
        return Math.copySign(f2, i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float acosh(float f2) {
        return (float) acosh(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float asinh(float f2) {
        return (float) asinh(f2);
    }
}
