package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.player.ubc.FloatingStatPlugin;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.apache.commons.codec.language.bm.Languages;
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\nH\u0001¢\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a1\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u0006\u0012\u0002\b\u00030\nH\u0001\u001a!\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0007\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a0\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010!\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a+\u0010$\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001aT\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ai\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u0010 \u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001aT\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a$\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0001\u001aA\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u00101\u001a!\u00102\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u00103\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a`\u00104\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172(\u00106\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\n0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u00107\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a!\u0010:\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a)\u0010;\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a#\u0010<\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aZ\u0010=\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u00106\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010>\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u00106\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0001ø\u0001\u0000¢\u0006\u0002\u0010(\u001au\u0010?\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001729\u00106\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001a`\u0010@\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\u00106\u001a \b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a?\u0010A\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a?\u0010F\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a!\u0010G\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a$\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0007\u001a!\u0010I\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u0010J\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a0\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a9\u0010M\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u00101\u001a;\u0010N\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010O\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0P\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aU\u0010O\u001a\u0002HS\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q\"\u0018\b\u0002\u0010S*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0015\u0012\u0006\b\u0000\u0012\u0002HQ0T*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\n2\u0006\u0010.\u001a\u0002HSH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010U\u001a'\u0010V\u001a\b\u0012\u0004\u0012\u0002H\u000e0W\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u000e0Y\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010Z\u001a\b\u0012\u0004\u0012\u0002H\u000e0[\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a.\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0]0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a?\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H50R0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\nH\u0087\u0004\u001az\u0010^\u001a\b\u0012\u0004\u0012\u0002HQ0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105\"\u0004\b\u0002\u0010Q*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001726\u00106\u001a2\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(`\u0012\u0013\u0012\u0011H5¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(a\u0012\u0004\u0012\u0002HQ0\u0019H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006b"}, d2 = {"consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", Languages.ANY, "", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", "count", "", "distinct", "distinctBy", "K", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "predicate", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Config.TRACE_VISIT_FIRST, "firstOrNull", "flatMap", "R", "transform", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FloatingStatPlugin.VALUE_LAST, "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "single", "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toMutableSet", "", "toSet", "", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes10.dex */
public final /* synthetic */ class ChannelsKt__DeprecatedKt {
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0035  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object any(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$any$1 channelsKt__DeprecatedKt$any$1;
        int i;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$any$1) {
                channelsKt__DeprecatedKt$any$1 = (ChannelsKt__DeprecatedKt$any$1) continuation;
                int i2 = channelsKt__DeprecatedKt$any$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$any$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$any$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$any$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$any$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$any$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$any$1.label = 1;
                        obj = it.hasNext(channelsKt__DeprecatedKt$any$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    return obj;
                }
            }
            if (i == 0) {
            }
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return obj;
        } finally {
        }
        channelsKt__DeprecatedKt$any$1 = new ChannelsKt__DeprecatedKt$any$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$any$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$any$1.label;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0051  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object none(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$none$1 channelsKt__DeprecatedKt$none$1;
        Object obj;
        int i;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$none$1) {
                channelsKt__DeprecatedKt$none$1 = (ChannelsKt__DeprecatedKt$none$1) continuation;
                int i2 = channelsKt__DeprecatedKt$none$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$none$1.label = i2 - Integer.MIN_VALUE;
                    obj = channelsKt__DeprecatedKt$none$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$none$1.label;
                    boolean z = true;
                    if (i == 0) {
                        if (i == 1) {
                            receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$none$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$none$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$none$1.label = 1;
                        obj = it.hasNext(channelsKt__DeprecatedKt$none$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        z = false;
                    }
                    Boolean boxBoolean = Boxing.boxBoolean(z);
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    return boxBoolean;
                }
            }
            if (i == 0) {
            }
            if (!((Boolean) obj).booleanValue()) {
            }
            Boolean boxBoolean2 = Boxing.boxBoolean(z);
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return boxBoolean2;
        } finally {
        }
        channelsKt__DeprecatedKt$none$1 = new ChannelsKt__DeprecatedKt$none$1(continuation);
        obj = channelsKt__DeprecatedKt$none$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$none$1.label;
        boolean z2 = true;
    }

    @PublishedApi
    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> receiveChannel) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ChannelsKt.cancelConsumed(receiveChannel, th);
            }
        };
    }

    @PublishedApi
    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... receiveChannelArr) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumesAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ReceiveChannel<?>[] receiveChannelArr2 = receiveChannelArr;
                int length = receiveChannelArr2.length;
                Throwable th2 = null;
                int i = 0;
                while (i < length) {
                    ReceiveChannel<?> receiveChannel = receiveChannelArr2[i];
                    i++;
                    try {
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                    } catch (Throwable th3) {
                        if (th2 == null) {
                            th2 = th3;
                        } else {
                            ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
                        }
                    }
                }
                if (th2 == null) {
                    return;
                }
                throw th2;
            }
        };
    }

    @PublishedApi
    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> filter$default;
        filter$default = filter$default(receiveChannel, null, new ChannelsKt__DeprecatedKt$filterNotNull$1(null), 1, null);
        return filter$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0069 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:60:0x0031, B:74:0x0061, B:76:0x0069, B:77:0x0073), top: B:90:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0073 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:60:0x0031, B:74:0x0061, B:76:0x0069, B:77:0x0073), top: B:90:0x0031 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x005d -> B:73:0x0060). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object count(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$count$1 channelsKt__DeprecatedKt$count$1;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        ReceiveChannel receiveChannel3;
        ChannelIterator it;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$count$1) {
            channelsKt__DeprecatedKt$count$1 = (ChannelsKt__DeprecatedKt$count$1) continuation;
            int i2 = channelsKt__DeprecatedKt$count$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$count$1.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$count$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$count$1.label;
                if (i == 0) {
                    if (i == 1) {
                        it = (ChannelIterator) channelsKt__DeprecatedKt$count$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$count$1.L$1;
                        intRef = (Ref.IntRef) channelsKt__DeprecatedKt$count$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                it.next();
                                intRef.element++;
                                receiveChannel3 = receiveChannel2;
                                try {
                                    channelsKt__DeprecatedKt$count$1.L$0 = intRef;
                                    channelsKt__DeprecatedKt$count$1.L$1 = receiveChannel3;
                                    channelsKt__DeprecatedKt$count$1.L$2 = it;
                                    channelsKt__DeprecatedKt$count$1.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$count$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel2 = receiveChannel3;
                                    obj = hasNext;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                                        return Boxing.boxInt(intRef.element);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    receiveChannel2 = receiveChannel3;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                                        throw th3;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        intRef = new Ref.IntRef();
                        receiveChannel3 = receiveChannel;
                        it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$count$1.L$0 = intRef;
                        channelsKt__DeprecatedKt$count$1.L$1 = receiveChannel3;
                        channelsKt__DeprecatedKt$count$1.L$2 = it;
                        channelsKt__DeprecatedKt$count$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$count$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$count$1 = new ChannelsKt__DeprecatedKt$count$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$count$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$count$1.label;
        if (i == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005c A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:54:0x002d, B:66:0x0054, B:68:0x005c, B:71:0x0064, B:72:0x006b), top: B:81:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0064 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #1 {all -> 0x0031, blocks: (B:54:0x002d, B:66:0x0054, B:68:0x005c, B:71:0x0064, B:72:0x006b), top: B:81:0x002d }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object first(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$first$1 channelsKt__DeprecatedKt$first$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$first$1) {
            channelsKt__DeprecatedKt$first$1 = (ChannelsKt__DeprecatedKt$first$1) continuation;
            int i2 = channelsKt__DeprecatedKt$first$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$first$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$first$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$first$1.label;
                if (i == 0) {
                    if (i == 1) {
                        channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$first$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$first$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$first$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$first$1.L$1 = it;
                        channelsKt__DeprecatedKt$first$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$first$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return next;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        channelsKt__DeprecatedKt$first$1 = new ChannelsKt__DeprecatedKt$first$1(continuation);
        obj = channelsKt__DeprecatedKt$first$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$first$1.label;
        if (i == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0060 A[Catch: all -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:55:0x002d, B:66:0x0053, B:71:0x0060), top: B:80:0x002d }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$firstOrNull$1 channelsKt__DeprecatedKt$firstOrNull$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$firstOrNull$1) {
            channelsKt__DeprecatedKt$firstOrNull$1 = (ChannelsKt__DeprecatedKt$firstOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$firstOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$firstOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$firstOrNull$1.label;
                if (i == 0) {
                    if (i == 1) {
                        channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$firstOrNull$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$firstOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$firstOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$firstOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$firstOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$firstOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                Object next = channelIterator.next();
                ChannelsKt.cancelConsumed(receiveChannel2, null);
                return next;
            }
        }
        channelsKt__DeprecatedKt$firstOrNull$1 = new ChannelsKt__DeprecatedKt$firstOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$firstOrNull$1.label;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @PublishedApi
    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$distinctBy$1(receiveChannel, function2, null), 6, null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.drop$default(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.CoroutineContext, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.drop$default(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.CoroutineContext, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$drop$1(i, receiveChannel, null), 6, null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.dropWhile$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.dropWhile$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$dropWhile$1(receiveChannel, function2, null), 6, null);
    }

    @PublishedApi
    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$filter$1(receiveChannel, function2, null), 6, null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterIndexed$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function3, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterIndexed$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function3, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$filterIndexed$1(receiveChannel, function3, null), 6, null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNot$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNot$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filter(receiveChannel, coroutineContext, new ChannelsKt__DeprecatedKt$filterNot$1(function2, null));
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.flatMap$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.flatMap$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$flatMap$1(receiveChannel, function2, null), 6, null);
    }

    @PublishedApi
    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$map$1(receiveChannel, function2, null), 6, null);
    }

    @PublishedApi
    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$mapIndexed$1(receiveChannel, function3, null), 6, null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.mapIndexedNotNull$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function3, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.mapIndexedNotNull$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function3, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.mapNotNull$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.mapNotNull$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map(receiveChannel, coroutineContext, function2));
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.take$default(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.CoroutineContext, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.take$default(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.CoroutineContext, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$take$1(i, receiveChannel, null), 6, null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.takeWhile$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.takeWhile$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$takeWhile$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        ReceiveChannel drop;
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        drop = drop(receiveChannel, i, coroutineContext);
        return drop;
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel dropWhile;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        dropWhile = dropWhile(receiveChannel, coroutineContext, function2);
        return dropWhile;
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        ReceiveChannel filterIndexed;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        filterIndexed = filterIndexed(receiveChannel, coroutineContext, function3);
        return filterIndexed;
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel filterNot;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        filterNot = filterNot(receiveChannel, coroutineContext, function2);
        return filterNot;
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel flatMap;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        flatMap = flatMap(receiveChannel, coroutineContext, function2);
        return flatMap;
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        ReceiveChannel mapIndexedNotNull;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        mapIndexedNotNull = mapIndexedNotNull(receiveChannel, coroutineContext, function3);
        return mapIndexedNotNull;
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel mapNotNull;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        mapNotNull = mapNotNull(receiveChannel, coroutineContext, function2);
        return mapNotNull;
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        ReceiveChannel take;
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        take = take(receiveChannel, i, coroutineContext);
        return take;
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel takeWhile;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        takeWhile = takeWhile(receiveChannel, coroutineContext, function2);
        return takeWhile;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x006c A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:62:0x0035, B:77:0x0064, B:79:0x006c, B:85:0x007b, B:86:0x0092), top: B:98:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x007b A[Catch: all -> 0x0039, TRY_ENTER, TryCatch #2 {all -> 0x0039, blocks: (B:62:0x0035, B:77:0x0064, B:79:0x006c, B:85:0x007b, B:86:0x0092), top: B:98:0x0035 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x005f -> B:76:0x0063). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAt(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAt$1 channelsKt__DeprecatedKt$elementAt$1;
        int i2;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i3;
        ChannelIterator it;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$elementAt$1) {
                channelsKt__DeprecatedKt$elementAt$1 = (ChannelsKt__DeprecatedKt$elementAt$1) continuation;
                int i4 = channelsKt__DeprecatedKt$elementAt$1.label;
                if ((i4 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$elementAt$1.label = i4 - Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$elementAt$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = channelsKt__DeprecatedKt$elementAt$1.label;
                    if (i2 == 0) {
                        if (i2 == 1) {
                            int i5 = channelsKt__DeprecatedKt$elementAt$1.I$1;
                            i = channelsKt__DeprecatedKt$elementAt$1.I$0;
                            it = (ChannelIterator) channelsKt__DeprecatedKt$elementAt$1.L$1;
                            receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAt$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = it.next();
                                    int i6 = i5 + 1;
                                    if (i == i5) {
                                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                                        return next;
                                    }
                                    receiveChannel = receiveChannel2;
                                    i3 = i6;
                                    channelsKt__DeprecatedKt$elementAt$1.L$0 = receiveChannel;
                                    channelsKt__DeprecatedKt$elementAt$1.L$1 = it;
                                    channelsKt__DeprecatedKt$elementAt$1.I$0 = i;
                                    channelsKt__DeprecatedKt$elementAt$1.I$1 = i3;
                                    channelsKt__DeprecatedKt$elementAt$1.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAt$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel2 = receiveChannel;
                                    i5 = i3;
                                    obj = hasNext;
                                    if (!((Boolean) obj).booleanValue()) {
                                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + IStringUtil.EXTENSION_SEPARATOR);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th3;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (i >= 0) {
                            i3 = 0;
                            it = receiveChannel.iterator();
                            channelsKt__DeprecatedKt$elementAt$1.L$0 = receiveChannel;
                            channelsKt__DeprecatedKt$elementAt$1.L$1 = it;
                            channelsKt__DeprecatedKt$elementAt$1.I$0 = i;
                            channelsKt__DeprecatedKt$elementAt$1.I$1 = i3;
                            channelsKt__DeprecatedKt$elementAt$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAt$1);
                            if (hasNext != coroutine_suspended) {
                            }
                        } else {
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + IStringUtil.EXTENSION_SEPARATOR);
                        }
                    }
                }
            }
            if (i2 == 0) {
            }
        } catch (Throwable th4) {
            receiveChannel2 = receiveChannel;
            th = th4;
        }
        channelsKt__DeprecatedKt$elementAt$1 = new ChannelsKt__DeprecatedKt$elementAt$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$elementAt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__DeprecatedKt$elementAt$1.label;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0059 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x007e A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:76:0x0062, B:80:0x0075, B:82:0x007e, B:84:0x0084, B:88:0x0097, B:75:0x005e), top: B:100:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0097 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #2 {all -> 0x009d, blocks: (B:76:0x0062, B:80:0x0075, B:82:0x007e, B:84:0x0084, B:88:0x0097, B:75:0x005e), top: B:100:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v8, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0093 -> B:76:0x0062). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$3;
        Object coroutine_suspended;
        int i;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$32;
        ChannelIterator channelIterator;
        SendChannel sendChannel2;
        ChannelIterator channelIterator2;
        SendChannel sendChannel3;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3) {
            channelsKt__DeprecatedKt$filterNotNullTo$3 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) continuation;
            int i2 = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$3.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
                if (i == 0) {
                    try {
                        if (i != 1) {
                            if (i == 2) {
                                ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                                ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                                SendChannel sendChannel4 = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                                ResultKt.throwOnFailure(obj);
                                channelIterator2 = channelIterator3;
                                receiveChannel = receiveChannel2;
                                sendChannel3 = sendChannel4;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                            ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                            SendChannel sendChannel5 = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                            ResultKt.throwOnFailure(obj);
                            channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                            channelIterator = channelIterator4;
                            receiveChannel = receiveChannel3;
                            sendChannel2 = sendChannel5;
                            Object obj2 = coroutine_suspended;
                            ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$33 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                            if (((Boolean) obj).booleanValue()) {
                                Object next = channelIterator.next();
                                if (next != null) {
                                    channelsKt__DeprecatedKt$filterNotNullTo$33.L$0 = sendChannel2;
                                    channelsKt__DeprecatedKt$filterNotNullTo$33.L$1 = receiveChannel;
                                    channelsKt__DeprecatedKt$filterNotNullTo$33.L$2 = channelIterator;
                                    channelsKt__DeprecatedKt$filterNotNullTo$33.label = 2;
                                    if (sendChannel2.send(next, channelsKt__DeprecatedKt$filterNotNullTo$33) == obj2) {
                                        return obj2;
                                    }
                                }
                                channelIterator2 = channelIterator;
                                channelsKt__DeprecatedKt$filterNotNullTo$3 = channelsKt__DeprecatedKt$filterNotNullTo$33;
                                coroutine_suspended = obj2;
                                sendChannel3 = sendChannel2;
                            } else {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel, null);
                                return sendChannel2;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            ChannelsKt.cancelConsumed(sendChannel, th);
                            throw th2;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        channelIterator2 = receiveChannel.iterator();
                        sendChannel3 = sendChannel;
                    } catch (Throwable th3) {
                        sendChannel = receiveChannel;
                        th = th3;
                        throw th;
                    }
                }
                channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = sendChannel3;
                channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$filterNotNullTo$3.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$3);
                if (hasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                channelIterator = channelIterator2;
                obj = hasNext;
                sendChannel2 = sendChannel3;
                Object obj22 = coroutine_suspended;
                ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$332 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                if (((Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$3 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(continuation);
        Object obj3 = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
        if (i == 0) {
        }
        channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = sendChannel3;
        channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = receiveChannel;
        channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = channelIterator2;
        channelsKt__DeprecatedKt$filterNotNullTo$3.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$3);
        if (hasNext != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0070 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:59:0x0033, B:72:0x0067, B:74:0x0070, B:76:0x007a, B:79:0x0084, B:68:0x0053, B:80:0x008b), top: B:91:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x008b A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:59:0x0033, B:72:0x0067, B:74:0x0070, B:76:0x007a, B:79:0x0084, B:68:0x0053, B:80:0x008b), top: B:91:0x0033 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0064 -> B:72:0x0067). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object indexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$indexOf$1 channelsKt__DeprecatedKt$indexOf$1;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Ref.IntRef intRef;
        Object obj2;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$indexOf$1) {
                channelsKt__DeprecatedKt$indexOf$1 = (ChannelsKt__DeprecatedKt$indexOf$1) continuation;
                int i2 = channelsKt__DeprecatedKt$indexOf$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$indexOf$1.label = i2 - Integer.MIN_VALUE;
                    Object obj3 = channelsKt__DeprecatedKt$indexOf$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$indexOf$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            it = (ChannelIterator) channelsKt__DeprecatedKt$indexOf$1.L$3;
                            receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$2;
                            intRef = (Ref.IntRef) channelsKt__DeprecatedKt$indexOf$1.L$1;
                            Object obj4 = channelsKt__DeprecatedKt$indexOf$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj3);
                                if (((Boolean) obj3).booleanValue()) {
                                    if (Intrinsics.areEqual(obj4, it.next())) {
                                        Integer boxInt = Boxing.boxInt(intRef.element);
                                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                                        return boxInt;
                                    }
                                    intRef.element++;
                                    obj2 = obj4;
                                    channelsKt__DeprecatedKt$indexOf$1.L$0 = obj2;
                                    channelsKt__DeprecatedKt$indexOf$1.L$1 = intRef;
                                    channelsKt__DeprecatedKt$indexOf$1.L$2 = receiveChannel2;
                                    channelsKt__DeprecatedKt$indexOf$1.L$3 = it;
                                    channelsKt__DeprecatedKt$indexOf$1.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj4 = obj2;
                                    obj3 = hasNext;
                                    if (((Boolean) obj3).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    return Boxing.boxInt(-1);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj3);
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        try {
                            receiveChannel2 = receiveChannel;
                            it = receiveChannel.iterator();
                            intRef = intRef2;
                            obj2 = obj;
                            channelsKt__DeprecatedKt$indexOf$1.L$0 = obj2;
                            channelsKt__DeprecatedKt$indexOf$1.L$1 = intRef;
                            channelsKt__DeprecatedKt$indexOf$1.L$2 = receiveChannel2;
                            channelsKt__DeprecatedKt$indexOf$1.L$3 = it;
                            channelsKt__DeprecatedKt$indexOf$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$1);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th4) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th4;
        }
        channelsKt__DeprecatedKt$indexOf$1 = new ChannelsKt__DeprecatedKt$indexOf$1(continuation);
        Object obj32 = channelsKt__DeprecatedKt$indexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$indexOf$1.label;
        if (i == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007e A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:58:0x0037, B:71:0x0075, B:73:0x007e, B:75:0x0088, B:76:0x008c, B:67:0x005f, B:77:0x0093), top: B:88:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0093 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:58:0x0037, B:71:0x0075, B:73:0x007e, B:75:0x0088, B:76:0x008c, B:67:0x005f, B:77:0x0093), top: B:88:0x0037 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0072 -> B:71:0x0075). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastIndexOf$1 channelsKt__DeprecatedKt$lastIndexOf$1;
        int i;
        Ref.IntRef intRef;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Ref.IntRef intRef2;
        Object obj2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1) {
            channelsKt__DeprecatedKt$lastIndexOf$1 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) continuation;
            int i2 = channelsKt__DeprecatedKt$lastIndexOf$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastIndexOf$1.label = i2 - Integer.MIN_VALUE;
                Object obj3 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
                if (i == 0) {
                    if (i == 1) {
                        it = (ChannelIterator) channelsKt__DeprecatedKt$lastIndexOf$1.L$4;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$3;
                        intRef = (Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$2;
                        intRef2 = (Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$1;
                        Object obj4 = channelsKt__DeprecatedKt$lastIndexOf$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            if (((Boolean) obj3).booleanValue()) {
                                if (Intrinsics.areEqual(obj4, it.next())) {
                                    intRef2.element = intRef.element;
                                }
                                intRef.element++;
                                obj2 = obj4;
                                channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = obj2;
                                channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = intRef2;
                                channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = intRef;
                                channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = receiveChannel2;
                                channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = it;
                                channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj4 = obj2;
                                obj3 = hasNext;
                                if (((Boolean) obj3).booleanValue()) {
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel2, null);
                                return Boxing.boxInt(intRef2.element);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = -1;
                    intRef = new Ref.IntRef();
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        intRef2 = intRef3;
                        obj2 = obj;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = obj2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = intRef2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = intRef;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = it;
                        channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$lastIndexOf$1 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(continuation);
        Object obj32 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
        if (i == 0) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:94:0x0022 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0079 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0034, B:78:0x0071, B:80:0x0079, B:83:0x008c, B:67:0x004f), top: B:94:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008c A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0034, B:78:0x0071, B:80:0x0079, B:83:0x008c, B:67:0x004f), top: B:94:0x0022 }] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0089 -> B:63:0x0037). Please submit an issue!!! */
    @PublishedApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$1;
        int i;
        ChannelIterator<? extends E> it;
        ChannelIterator<? extends E> channelIterator;
        SendChannel sendChannel;
        C c2;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$toChannel$1) {
                channelsKt__DeprecatedKt$toChannel$1 = (ChannelsKt__DeprecatedKt$toChannel$1) continuation;
                int i2 = channelsKt__DeprecatedKt$toChannel$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$toChannel$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$toChannel$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$toChannel$1.label;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$2;
                                ?? r8 = (C) ((ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$1);
                                sendChannel = (SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                ReceiveChannel<? extends E> receiveChannel2 = r8;
                                it = channelIterator;
                                receiveChannel = receiveChannel2;
                                c2 = (C) sendChannel;
                                channelsKt__DeprecatedKt$toChannel$1.L$0 = c2;
                                channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                                channelsKt__DeprecatedKt$toChannel$1.L$2 = it;
                                channelsKt__DeprecatedKt$toChannel$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                                if (hasNext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator = it;
                                obj = hasNext;
                                sendChannel = c2;
                                c = (C) receiveChannel;
                                if (!((Boolean) obj).booleanValue()) {
                                    E next = channelIterator.next();
                                    channelsKt__DeprecatedKt$toChannel$1.L$0 = sendChannel;
                                    channelsKt__DeprecatedKt$toChannel$1.L$1 = (Object) c;
                                    channelsKt__DeprecatedKt$toChannel$1.L$2 = channelIterator;
                                    channelsKt__DeprecatedKt$toChannel$1.label = 2;
                                    receiveChannel2 = c;
                                    if (sendChannel.send(next, channelsKt__DeprecatedKt$toChannel$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    it = channelIterator;
                                    receiveChannel = receiveChannel2;
                                    c2 = (C) sendChannel;
                                    channelsKt__DeprecatedKt$toChannel$1.L$0 = c2;
                                    channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                                    channelsKt__DeprecatedKt$toChannel$1.L$2 = it;
                                    channelsKt__DeprecatedKt$toChannel$1.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                                    if (hasNext == coroutine_suspended) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed((ReceiveChannel) c, null);
                                    return sendChannel;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$2;
                            C c3 = (C) ((ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$1);
                            sendChannel = (SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            c = c3;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        try {
                            it = receiveChannel.iterator();
                            c2 = c;
                            channelsKt__DeprecatedKt$toChannel$1.L$0 = c2;
                            channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                            channelsKt__DeprecatedKt$toChannel$1.L$2 = it;
                            channelsKt__DeprecatedKt$toChannel$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                            if (hasNext == coroutine_suspended) {
                            }
                        } catch (Throwable th) {
                            c = receiveChannel;
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                ChannelsKt.cancelConsumed(c, th);
                                throw th2;
                            }
                        }
                    }
                }
            }
            if (i == 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        channelsKt__DeprecatedKt$toChannel$1 = new ChannelsKt__DeprecatedKt$toChannel$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$toChannel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toChannel$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x006b A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #2 {all -> 0x007d, blocks: (B:76:0x0063, B:78:0x006b, B:73:0x0052, B:72:0x004e), top: B:96:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0079  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0060 -> B:76:0x0063). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$1;
        int i2;
        int i3;
        ChannelIterator it;
        Throwable th;
        ReceiveChannel receiveChannel2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1) {
            channelsKt__DeprecatedKt$elementAtOrNull$1 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) continuation;
            int i4 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$elementAtOrNull$1.label = i4 - Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
                if (i2 == 0) {
                    if (i2 == 1) {
                        int i5 = channelsKt__DeprecatedKt$elementAtOrNull$1.I$1;
                        i = channelsKt__DeprecatedKt$elementAtOrNull$1.I$0;
                        it = (ChannelIterator) channelsKt__DeprecatedKt$elementAtOrNull$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAtOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i3 = i5;
                            receiveChannel = receiveChannel2;
                            hasNext = obj;
                            if (((Boolean) hasNext).booleanValue()) {
                                Object next = it.next();
                                int i6 = i3 + 1;
                                if (i == i3) {
                                    ChannelsKt.cancelConsumed(receiveChannel, null);
                                    return next;
                                }
                                i3 = i6;
                                channelsKt__DeprecatedKt$elementAtOrNull$1.L$0 = receiveChannel;
                                channelsKt__DeprecatedKt$elementAtOrNull$1.L$1 = it;
                                channelsKt__DeprecatedKt$elementAtOrNull$1.I$0 = i;
                                channelsKt__DeprecatedKt$elementAtOrNull$1.I$1 = i3;
                                channelsKt__DeprecatedKt$elementAtOrNull$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$1);
                                if (hasNext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (((Boolean) hasNext).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel, null);
                                    return null;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (i < 0) {
                        ChannelsKt.cancelConsumed(receiveChannel, null);
                        return null;
                    }
                    i3 = 0;
                    try {
                        it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$elementAtOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.I$0 = i;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.I$1 = i3;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$1);
                        if (hasNext == coroutine_suspended) {
                        }
                        if (((Boolean) hasNext).booleanValue()) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$elementAtOrNull$1 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
        if (i2 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0065 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:58:0x0031, B:71:0x005c, B:73:0x0065, B:75:0x006b, B:67:0x004a, B:77:0x0070), top: B:86:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0070 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:58:0x0031, B:71:0x005c, B:73:0x0065, B:75:0x006b, B:67:0x004a, B:77:0x0070), top: B:86:0x0031 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0059 -> B:71:0x005c). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 channelsKt__DeprecatedKt$filterNotNullTo$1;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Collection collection2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1) {
            channelsKt__DeprecatedKt$filterNotNullTo$1 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) continuation;
            int i2 = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$1.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
                if (i == 0) {
                    if (i == 1) {
                        it = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$1.L$1;
                        Collection collection3 = (Collection) channelsKt__DeprecatedKt$filterNotNullTo$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                Object next = it.next();
                                if (next != null) {
                                    collection3.add(next);
                                }
                                collection2 = collection3;
                                channelsKt__DeprecatedKt$filterNotNullTo$1.L$0 = collection2;
                                channelsKt__DeprecatedKt$filterNotNullTo$1.L$1 = receiveChannel2;
                                channelsKt__DeprecatedKt$filterNotNullTo$1.L$2 = it;
                                channelsKt__DeprecatedKt$filterNotNullTo$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                collection3 = collection2;
                                obj = hasNext;
                                if (((Boolean) obj).booleanValue()) {
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel2, null);
                                return collection3;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        collection2 = collection;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$0 = collection2;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$2 = it;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$1 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
        if (i == 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0065 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:55:0x0031, B:68:0x005c, B:70:0x0065, B:64:0x004a, B:71:0x006e), top: B:82:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x006e A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:55:0x0031, B:68:0x005c, B:70:0x0065, B:64:0x004a, B:71:0x006e), top: B:82:0x0031 }] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0059 -> B:68:0x005c). Please submit an issue!!! */
    @PublishedApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toCollection$1 channelsKt__DeprecatedKt$toCollection$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends E> it;
        C c2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toCollection$1) {
            channelsKt__DeprecatedKt$toCollection$1 = (ChannelsKt__DeprecatedKt$toCollection$1) continuation;
            int i2 = channelsKt__DeprecatedKt$toCollection$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toCollection$1.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$toCollection$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$toCollection$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toCollection$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$toCollection$1.L$1;
                        ?? r2 = (Collection) channelsKt__DeprecatedKt$toCollection$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            C c3 = r2;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                c3.add(channelIterator2.next());
                                c2 = c3;
                                it = channelIterator2;
                                channelsKt__DeprecatedKt$toCollection$1.L$0 = c2;
                                channelsKt__DeprecatedKt$toCollection$1.L$1 = receiveChannel2;
                                channelsKt__DeprecatedKt$toCollection$1.L$2 = it;
                                channelsKt__DeprecatedKt$toCollection$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$toCollection$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                c3 = c2;
                                obj = hasNext;
                                channelIterator2 = it;
                                if (!((Boolean) obj).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    return c3;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        c2 = c;
                        channelsKt__DeprecatedKt$toCollection$1.L$0 = c2;
                        channelsKt__DeprecatedKt$toCollection$1.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$toCollection$1.L$2 = it;
                        channelsKt__DeprecatedKt$toCollection$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toCollection$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$toCollection$1 = new ChannelsKt__DeprecatedKt$toCollection$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$toCollection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toCollection$1.label;
        if (i == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0065 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:55:0x0031, B:68:0x005c, B:70:0x0065, B:64:0x004a, B:71:0x0078), top: B:82:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0078 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:55:0x0031, B:68:0x005c, B:70:0x0065, B:64:0x004a, B:71:0x0078), top: B:82:0x0031 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0059 -> B:68:0x005c). Please submit an issue!!! */
    @PublishedApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        ChannelsKt__DeprecatedKt$toMap$2 channelsKt__DeprecatedKt$toMap$2;
        int i;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> it;
        M m2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toMap$2) {
            channelsKt__DeprecatedKt$toMap$2 = (ChannelsKt__DeprecatedKt$toMap$2) continuation;
            int i2 = channelsKt__DeprecatedKt$toMap$2.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toMap$2.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$toMap$2.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$toMap$2.label;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toMap$2.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$toMap$2.L$1;
                        Map map = (Map) channelsKt__DeprecatedKt$toMap$2.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Map map2 = map;
                            ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                Pair<? extends K, ? extends V> next = channelIterator2.next();
                                map2.put(next.getFirst(), next.getSecond());
                                m2 = map2;
                                it = channelIterator2;
                                channelsKt__DeprecatedKt$toMap$2.L$0 = m2;
                                channelsKt__DeprecatedKt$toMap$2.L$1 = receiveChannel2;
                                channelsKt__DeprecatedKt$toMap$2.L$2 = it;
                                channelsKt__DeprecatedKt$toMap$2.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$toMap$2);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                map2 = m2;
                                obj = hasNext;
                                channelIterator2 = it;
                                if (!((Boolean) obj).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    return map2;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        m2 = m;
                        channelsKt__DeprecatedKt$toMap$2.L$0 = m2;
                        channelsKt__DeprecatedKt$toMap$2.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$toMap$2.L$2 = it;
                        channelsKt__DeprecatedKt$toMap$2.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toMap$2);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$toMap$2 = new ChannelsKt__DeprecatedKt$toMap$2(continuation);
        Object obj2 = channelsKt__DeprecatedKt$toMap$2.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toMap$2.label;
        if (i == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x009d A[Catch: all -> 0x004e, TRY_ENTER, TryCatch #3 {all -> 0x004e, blocks: (B:79:0x004a, B:88:0x0068, B:90:0x0070, B:103:0x009d, B:104:0x00a4), top: B:117:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0070 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #3 {all -> 0x004e, blocks: (B:79:0x004a, B:88:0x0068, B:90:0x0070, B:103:0x009d, B:104:0x00a4), top: B:117:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0093 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:72:0x0032, B:97:0x008b, B:99:0x0093), top: B:113:0x0032 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x0086 -> B:96:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object last(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$last$1 channelsKt__DeprecatedKt$last$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ChannelIterator channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$last$1) {
            channelsKt__DeprecatedKt$last$1 = (ChannelsKt__DeprecatedKt$last$1) continuation;
            int i2 = channelsKt__DeprecatedKt$last$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$last$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$last$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$last$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = channelsKt__DeprecatedKt$last$1.L$2;
                            channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$last$1.L$1;
                            ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator2.next();
                                    receiveChannel = receiveChannel3;
                                    channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel;
                                    channelsKt__DeprecatedKt$last$1.L$1 = channelIterator2;
                                    channelsKt__DeprecatedKt$last$1.L$2 = next;
                                    channelsKt__DeprecatedKt$last$1.label = 2;
                                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$last$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel3 = receiveChannel;
                                    obj2 = next;
                                    obj = hasNext;
                                    if (!((Boolean) obj).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel3, null);
                                        return obj2;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$last$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$last$1.L$1 = it;
                        channelsKt__DeprecatedKt$last$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$last$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator.next();
                    ReceiveChannel receiveChannel4 = receiveChannel2;
                    channelIterator2 = channelIterator;
                    receiveChannel = receiveChannel4;
                    channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel;
                    channelsKt__DeprecatedKt$last$1.L$1 = channelIterator2;
                    channelsKt__DeprecatedKt$last$1.L$2 = next;
                    channelsKt__DeprecatedKt$last$1.label = 2;
                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$last$1);
                    if (hasNext != coroutine_suspended) {
                    }
                } else {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
            }
        }
        channelsKt__DeprecatedKt$last$1 = new ChannelsKt__DeprecatedKt$last$1(continuation);
        obj = channelsKt__DeprecatedKt$last$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$last$1.label;
        if (i == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0097 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #2 {all -> 0x0037, blocks: (B:72:0x0033, B:98:0x008f, B:100:0x0097), top: B:114:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0075 A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004f, blocks: (B:79:0x004b, B:88:0x0069, B:92:0x0075), top: B:116:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x008b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x008b -> B:98:0x008f). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastOrNull$1 channelsKt__DeprecatedKt$lastOrNull$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ChannelIterator channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastOrNull$1) {
            channelsKt__DeprecatedKt$lastOrNull$1 = (ChannelsKt__DeprecatedKt$lastOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$lastOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$lastOrNull$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = channelsKt__DeprecatedKt$lastOrNull$1.L$2;
                            channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                            ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator2.next();
                                    receiveChannel = receiveChannel3;
                                    channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel;
                                    channelsKt__DeprecatedKt$lastOrNull$1.L$1 = channelIterator2;
                                    channelsKt__DeprecatedKt$lastOrNull$1.L$2 = next;
                                    channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel3 = receiveChannel;
                                    obj2 = next;
                                    obj = hasNext;
                                    if (!((Boolean) obj).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel3, null);
                                        return obj2;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$lastOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$lastOrNull$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel;
                channelsKt__DeprecatedKt$lastOrNull$1.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$lastOrNull$1.L$2 = next;
                channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__DeprecatedKt$lastOrNull$1 = new ChannelsKt__DeprecatedKt$lastOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$lastOrNull$1.label;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x006c A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:77:0x0046, B:86:0x0064, B:88:0x006c, B:99:0x0096, B:100:0x009d), top: B:111:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x008e A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #1 {all -> 0x0032, blocks: (B:70:0x002e, B:93:0x0082, B:97:0x008e, B:98:0x0095), top: B:109:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0096 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #2 {all -> 0x004a, blocks: (B:77:0x0046, B:86:0x0064, B:88:0x006c, B:99:0x0096, B:100:0x009d), top: B:111:0x0046 }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object single(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$single$1 channelsKt__DeprecatedKt$single$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel3;
        Object obj2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$single$1) {
            channelsKt__DeprecatedKt$single$1 = (ChannelsKt__DeprecatedKt$single$1) continuation;
            int i2 = channelsKt__DeprecatedKt$single$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$single$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$single$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$single$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            obj2 = channelsKt__DeprecatedKt$single$1.L$1;
                            receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (((Boolean) obj).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel3, null);
                                    return obj2;
                                }
                                throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                            } catch (Throwable th2) {
                                th = th2;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th3;
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$single$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$single$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$single$1.L$1 = it;
                        channelsKt__DeprecatedKt$single$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$single$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    channelsKt__DeprecatedKt$single$1.L$0 = receiveChannel2;
                    channelsKt__DeprecatedKt$single$1.L$1 = next;
                    channelsKt__DeprecatedKt$single$1.label = 2;
                    Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$single$1);
                    if (hasNext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel3 = receiveChannel2;
                    obj = hasNext2;
                    obj2 = next;
                    if (((Boolean) obj).booleanValue()) {
                    }
                } else {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
            }
        }
        channelsKt__DeprecatedKt$single$1 = new ChannelsKt__DeprecatedKt$single$1(continuation);
        obj = channelsKt__DeprecatedKt$single$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$single$1.label;
        if (i == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0071 A[Catch: all -> 0x004b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004b, blocks: (B:77:0x0047, B:86:0x0065, B:90:0x0071), top: B:112:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0092  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$singleOrNull$1 channelsKt__DeprecatedKt$singleOrNull$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel3;
        Object obj2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$singleOrNull$1) {
            channelsKt__DeprecatedKt$singleOrNull$1 = (ChannelsKt__DeprecatedKt$singleOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$singleOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$singleOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$singleOrNull$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            obj2 = channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                            receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (!((Boolean) obj).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel3, null);
                                    return null;
                                }
                                ChannelsKt.cancelConsumed(receiveChannel3, null);
                                return obj2;
                            } catch (Throwable th2) {
                                th = th2;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th3;
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$singleOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$singleOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$singleOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                Object next = channelIterator.next();
                channelsKt__DeprecatedKt$singleOrNull$1.L$0 = receiveChannel2;
                channelsKt__DeprecatedKt$singleOrNull$1.L$1 = next;
                channelsKt__DeprecatedKt$singleOrNull$1.label = 2;
                Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                if (hasNext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel3 = receiveChannel2;
                obj = hasNext2;
                obj2 = next;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__DeprecatedKt$singleOrNull$1 = new ChannelsKt__DeprecatedKt$singleOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$singleOrNull$1.label;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ac A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #3 {all -> 0x00bf, blocks: (B:103:0x00a4, B:105:0x00ac, B:99:0x008f, B:89:0x0063), top: B:124:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0087 A[Catch: all -> 0x005d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:84:0x0059, B:93:0x007b, B:97:0x0087), top: B:122:0x0059 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x00a0 -> B:78:0x003d). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object maxWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Comparator comparator2;
        Object next;
        Comparator comparator3;
        ChannelIterator channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$maxWith$1) {
            channelsKt__DeprecatedKt$maxWith$1 = (ChannelsKt__DeprecatedKt$maxWith$1) continuation;
            int i2 = channelsKt__DeprecatedKt$maxWith$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$maxWith$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$maxWith$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$maxWith$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = channelsKt__DeprecatedKt$maxWith$1.L$3;
                            channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$2;
                            ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$1;
                            comparator3 = (Comparator) channelsKt__DeprecatedKt$maxWith$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                                Object obj3 = obj2;
                                receiveChannel = receiveChannel3;
                                Object obj4 = coroutine_suspended;
                                ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$13 = channelsKt__DeprecatedKt$maxWith$12;
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator2.next();
                                    if (comparator3.compare(obj3, next) >= 0) {
                                        next = obj3;
                                    }
                                    channelsKt__DeprecatedKt$maxWith$1 = channelsKt__DeprecatedKt$maxWith$13;
                                    coroutine_suspended = obj4;
                                    channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator3;
                                    channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel;
                                    channelsKt__DeprecatedKt$maxWith$1.L$2 = channelIterator2;
                                    channelsKt__DeprecatedKt$maxWith$1.L$3 = next;
                                    channelsKt__DeprecatedKt$maxWith$1.label = 2;
                                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                                    obj3 = next;
                                    obj = hasNext;
                                    Object obj42 = coroutine_suspended;
                                    ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$132 = channelsKt__DeprecatedKt$maxWith$12;
                                    if (!((Boolean) obj).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel, null);
                                        return obj3;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$1;
                        comparator2 = (Comparator) channelsKt__DeprecatedKt$maxWith$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator;
                        channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$maxWith$1.L$2 = it;
                        channelsKt__DeprecatedKt$maxWith$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                        comparator2 = comparator;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                comparator3 = comparator2;
                ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator3;
                channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$maxWith$1.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$maxWith$1.L$3 = next;
                channelsKt__DeprecatedKt$maxWith$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__DeprecatedKt$maxWith$1 = new ChannelsKt__DeprecatedKt$maxWith$1(continuation);
        obj = channelsKt__DeprecatedKt$maxWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$maxWith$1.label;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ac A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #3 {all -> 0x00bf, blocks: (B:103:0x00a4, B:105:0x00ac, B:99:0x008f, B:89:0x0063), top: B:124:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0087 A[Catch: all -> 0x005d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:84:0x0059, B:93:0x007b, B:97:0x0087), top: B:122:0x0059 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x00a0 -> B:78:0x003d). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object minWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Comparator comparator2;
        Object next;
        Comparator comparator3;
        ChannelIterator channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$minWith$1) {
            channelsKt__DeprecatedKt$minWith$1 = (ChannelsKt__DeprecatedKt$minWith$1) continuation;
            int i2 = channelsKt__DeprecatedKt$minWith$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$minWith$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$minWith$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$minWith$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj2 = channelsKt__DeprecatedKt$minWith$1.L$3;
                            channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$2;
                            ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$1;
                            comparator3 = (Comparator) channelsKt__DeprecatedKt$minWith$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                                Object obj3 = obj2;
                                receiveChannel = receiveChannel3;
                                Object obj4 = coroutine_suspended;
                                ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$13 = channelsKt__DeprecatedKt$minWith$12;
                                if (!((Boolean) obj).booleanValue()) {
                                    next = channelIterator2.next();
                                    if (comparator3.compare(obj3, next) <= 0) {
                                        next = obj3;
                                    }
                                    channelsKt__DeprecatedKt$minWith$1 = channelsKt__DeprecatedKt$minWith$13;
                                    coroutine_suspended = obj4;
                                    channelsKt__DeprecatedKt$minWith$1.L$0 = comparator3;
                                    channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel;
                                    channelsKt__DeprecatedKt$minWith$1.L$2 = channelIterator2;
                                    channelsKt__DeprecatedKt$minWith$1.L$3 = next;
                                    channelsKt__DeprecatedKt$minWith$1.label = 2;
                                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$minWith$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                                    obj3 = next;
                                    obj = hasNext;
                                    Object obj42 = coroutine_suspended;
                                    ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$132 = channelsKt__DeprecatedKt$minWith$12;
                                    if (!((Boolean) obj).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel, null);
                                        return obj3;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th2;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$1;
                        comparator2 = (Comparator) channelsKt__DeprecatedKt$minWith$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$minWith$1.L$0 = comparator;
                        channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$minWith$1.L$2 = it;
                        channelsKt__DeprecatedKt$minWith$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$minWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                        comparator2 = comparator;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                comparator3 = comparator2;
                ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                channelsKt__DeprecatedKt$minWith$1.L$0 = comparator3;
                channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$minWith$1.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$minWith$1.L$3 = next;
                channelsKt__DeprecatedKt$minWith$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$minWith$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__DeprecatedKt$minWith$1 = new ChannelsKt__DeprecatedKt$minWith$1(continuation);
        obj = channelsKt__DeprecatedKt$minWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$minWith$1.label;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @PublishedApi
    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.withIndex$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.withIndex$default(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.CoroutineContext, int, java.lang.Object):kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$withIndex$1(receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        ReceiveChannel withIndex;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        withIndex = withIndex(receiveChannel, coroutineContext);
        return withIndex;
    }

    @PublishedApi
    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new ChannelsKt__DeprecatedKt$zip$2(receiveChannel2, receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}
