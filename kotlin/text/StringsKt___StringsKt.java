package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0001\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a(\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010*\u00020\u00002\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00110\u0001H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a:\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0013\"\u0004\b\u0000\u0010\u000f*\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0015\u001aT\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010*\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0019\u001aP\u0010\u001d\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u000f\"\u0018\b\u0001\u0010\u001b*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00020\u00020\u001a*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u001d\u0010\u001e\u001aj\u0010\u001d\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0018\b\u0002\u0010\u001b*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u001a*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\b¢\u0006\u0004\b\u001d\u0010\u001f\u001ab\u0010 \u001a\u00028\u0002\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0018\b\u0002\u0010\u001b*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u001a*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00022\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00110\u0001H\u0086\b¢\u0006\u0004\b \u0010\u001e\u001a:\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u0010*\u00020\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\b\"\u0010\u0015\u001aP\u0010#\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0010\"\u0018\b\u0001\u0010\u001b*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00028\u00000\u001a*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\b#\u0010\u001e\u001a!\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020\u00002\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b(\u0010)\u001a;\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010%\u001a\u00020$2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b(\u0010+\u001a!\u0010,\u001a\b\u0012\u0004\u0012\u00020'0\f*\u00020\u00002\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b,\u0010-\u001a;\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010%\u001a\u00020$2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b,\u0010.\u001a\u0014\u0010/\u001a\u00020$*\u00020\u0000H\u0087\b¢\u0006\u0004\b/\u00100\u001a(\u0010/\u001a\u00020$*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b/\u00101\u001a\u0019\u00103\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020$¢\u0006\u0004\b3\u00104\u001a\u0019\u00103\u001a\u00020'*\u00020'2\u0006\u00102\u001a\u00020$¢\u0006\u0004\b3\u00105\u001a\u0019\u00106\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020$¢\u0006\u0004\b6\u00104\u001a\u0019\u00106\u001a\u00020'*\u00020'2\u0006\u00102\u001a\u00020$¢\u0006\u0004\b6\u00105\u001a(\u00107\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b7\u00108\u001a(\u00107\u001a\u00020'*\u00020'2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b7\u00109\u001a(\u0010:\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b:\u00108\u001a(\u0010:\u001a\u00020'*\u00020'2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b:\u00109\u001a0\u0010=\u001a\u00020\u0002*\u00020\u00002\u0006\u0010;\u001a\u00020$2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\b¢\u0006\u0004\b=\u0010>\u001a\u001e\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0006\u0010;\u001a\u00020$H\u0087\b¢\u0006\u0004\b?\u0010@\u001a(\u0010A\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bA\u00108\u001a(\u0010A\u001a\u00020'*\u00020'2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bA\u00109\u001a=\u0010E\u001a\u00020\u0000*\u00020\u00002'\u0010\u0004\u001a#\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030BH\u0086\b¢\u0006\u0004\bE\u0010F\u001a=\u0010E\u001a\u00020'*\u00020'2'\u0010\u0004\u001a#\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030BH\u0086\b¢\u0006\u0004\bE\u0010G\u001aS\u0010K\u001a\u00028\u0000\"\f\b\u0000\u0010J*\u00060Hj\u0002`I*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00002'\u0010\u0004\u001a#\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030BH\u0086\b¢\u0006\u0004\bK\u0010L\u001a(\u0010M\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bM\u00108\u001a(\u0010M\u001a\u00020'*\u00020'2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bM\u00109\u001a>\u0010N\u001a\u00028\u0000\"\f\b\u0000\u0010J*\u00060Hj\u0002`I*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bN\u0010O\u001a>\u0010P\u001a\u00028\u0000\"\f\b\u0000\u0010J*\u00060Hj\u0002`I*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bP\u0010O\u001a*\u0010Q\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0087\b¢\u0006\u0004\bQ\u0010R\u001a*\u0010S\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0087\b¢\u0006\u0004\bS\u0010R\u001a\u0011\u0010T\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\bT\u0010U\u001a(\u0010T\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bT\u0010V\u001a\u0013\u0010W\u001a\u0004\u0018\u00010\u0002*\u00020\u0000¢\u0006\u0004\bW\u0010X\u001a*\u0010W\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bW\u0010R\u001a:\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010**\u00020\u00002\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u0001H\u0086\b¢\u0006\u0004\bY\u0010Z\u001aN\u0010\\\u001a\u00028\u0001\"\u0004\b\u0000\u0010*\"\u0010\b\u0001\u0010J*\n\u0012\u0006\b\u0000\u0012\u00028\u00000[*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u0001H\u0086\b¢\u0006\u0004\b\\\u0010]\u001aK\u0010a\u001a\u00028\u0000\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010^\u001a\u00028\u00002'\u0010`\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000BH\u0086\b¢\u0006\u0004\ba\u0010b\u001a`\u0010d\u001a\u00028\u0000\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010^\u001a\u00028\u00002<\u0010`\u001a8\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000cH\u0086\b¢\u0006\u0004\bd\u0010e\u001aK\u0010f\u001a\u00028\u0000\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010^\u001a\u00028\u00002'\u0010`\u001a#\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00028\u00000BH\u0086\b¢\u0006\u0004\bf\u0010b\u001a`\u0010g\u001a\u00028\u0000\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010^\u001a\u00028\u00002<\u0010`\u001a8\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00028\u00000cH\u0086\b¢\u0006\u0004\bg\u0010e\u001a(\u0010j\u001a\u00020h*\u00020\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020h0\u0001H\u0086\b¢\u0006\u0004\bj\u0010k\u001a=\u0010l\u001a\u00020h*\u00020\u00002'\u0010i\u001a#\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020h0BH\u0086\b¢\u0006\u0004\bl\u0010m\u001a0\u0010n\u001a\u00020\u0002*\u00020\u00002\u0006\u0010;\u001a\u00020$2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\b¢\u0006\u0004\bn\u0010>\u001a\u001b\u0010o\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0006\u0010;\u001a\u00020$¢\u0006\u0004\bo\u0010@\u001a@\u0010p\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0\u0013\"\u0004\b\u0000\u0010\u000f*\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\bp\u0010\u0015\u001aZ\u0010p\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&0\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010*\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\b¢\u0006\u0004\bp\u0010\u0019\u001aT\u0010r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u000f\"\u001c\b\u0001\u0010\u001b*\u0016\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020q0\u001a*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\br\u0010\u001e\u001an\u0010r\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u001c\b\u0002\u0010\u001b*\u0016\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010q0\u001a*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\b¢\u0006\u0004\br\u0010\u001f\u001a<\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000s\"\u0004\b\u0000\u0010\u000f*\u00020\u00002\u0014\b\u0004\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\bt\u0010u\u001a(\u0010v\u001a\u00020$*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bv\u00101\u001a(\u0010w\u001a\u00020$*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bw\u00101\u001a\u0011\u0010x\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\bx\u0010U\u001a(\u0010x\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\bx\u0010V\u001a\u0013\u0010y\u001a\u0004\u0018\u00010\u0002*\u00020\u0000¢\u0006\u0004\by\u0010X\u001a*\u0010y\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\by\u0010R\u001a4\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010**\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\bz\u0010Z\u001aI\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010**\u00020\u00002'\u0010\u0012\u001a#\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000BH\u0086\b¢\u0006\u0004\b{\u0010|\u001aO\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\b\b\u0000\u0010**\u00020}*\u00020\u00002)\u0010\u0012\u001a%\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00000BH\u0086\b¢\u0006\u0004\b~\u0010|\u001ad\u0010\u007f\u001a\u00028\u0001\"\b\b\u0000\u0010**\u00020}\"\u0010\b\u0001\u0010J*\n\u0012\u0006\b\u0000\u0012\u00028\u00000[*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012)\u0010\u0012\u001a%\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00000BH\u0086\b¢\u0006\u0005\b\u007f\u0010\u0080\u0001\u001a`\u0010\u0081\u0001\u001a\u00028\u0001\"\u0004\b\u0000\u0010*\"\u0010\b\u0001\u0010J*\n\u0012\u0006\b\u0000\u0012\u00028\u00000[*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012'\u0010\u0012\u001a#\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000BH\u0086\b¢\u0006\u0006\b\u0081\u0001\u0010\u0080\u0001\u001a<\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\b\b\u0000\u0010**\u00020}*\u00020\u00002\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0086\b¢\u0006\u0005\b\u0082\u0001\u0010Z\u001aP\u0010\u0083\u0001\u001a\u00028\u0001\"\b\b\u0000\u0010**\u00020}\"\u0010\b\u0001\u0010J*\n\u0012\u0006\b\u0000\u0012\u00028\u00000[*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0086\b¢\u0006\u0005\b\u0083\u0001\u0010]\u001aJ\u0010\u0084\u0001\u001a\u00028\u0001\"\u0004\b\u0000\u0010*\"\u0010\b\u0001\u0010J*\n\u0012\u0006\b\u0000\u0012\u00028\u00000[*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0005\b\u0084\u0001\u0010]\u001a\u0015\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u0000¢\u0006\u0005\b\u0085\u0001\u0010X\u001a>\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0002\"\u000f\b\u0000\u0010**\t\u0012\u0004\u0012\u00028\u00000\u0086\u0001*\u00020\u00002\u0013\u0010\u0087\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0005\b\u0088\u0001\u0010R\u001a5\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u001d\u0010\u008b\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00020\u0089\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0002`\u008a\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0015\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u0000¢\u0006\u0005\b\u008e\u0001\u0010X\u001a>\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0002\"\u000f\b\u0000\u0010**\t\u0012\u0004\u0012\u00028\u00000\u0086\u0001*\u00020\u00002\u0013\u0010\u0087\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0005\b\u008f\u0001\u0010R\u001a5\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u001d\u0010\u008b\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00020\u0089\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0002`\u008a\u0001¢\u0006\u0006\b\u0090\u0001\u0010\u008d\u0001\u001a\u0013\u0010\u0091\u0001\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0005\b\u0091\u0001\u0010\b\u001a*\u0010\u0091\u0001\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0005\b\u0091\u0001\u0010\u0006\u001a6\u0010\u0093\u0001\u001a\u00028\u0000\"\t\b\u0000\u0010\u0092\u0001*\u00020\u0000*\u00028\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020h0\u0001H\u0087\b¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a7\u0010\u0095\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0011*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a7\u0010\u0095\u0001\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0\u0011*\u00020'2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001\u001a\u0016\u0010\u0098\u0001\u001a\u00020\u0002*\u00020\u0000H\u0087\b¢\u0006\u0005\b\u0098\u0001\u0010U\u001a \u0010\u0098\u0001\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0007¢\u0006\u0006\b\u0098\u0001\u0010\u009a\u0001\u001a@\u0010\u009b\u0001\u001a\u00020\u0002*\u00020\u00002'\u0010`\u001a#\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020BH\u0086\b¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001\u001aU\u0010\u009d\u0001\u001a\u00020\u0002*\u00020\u00002<\u0010`\u001a8\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020cH\u0086\b¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a@\u0010\u009f\u0001\u001a\u00020\u0002*\u00020\u00002'\u0010`\u001a#\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00020BH\u0086\b¢\u0006\u0006\b\u009f\u0001\u0010\u009c\u0001\u001aU\u0010 \u0001\u001a\u00020\u0002*\u00020\u00002<\u0010`\u001a8\u0012\u0013\u0012\u00110$¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00020cH\u0086\b¢\u0006\u0006\b \u0001\u0010\u009e\u0001\u001a\u0014\u0010¡\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001\u001a\u0017\u0010¡\u0001\u001a\u00020'*\u00020'H\u0087\b¢\u0006\u0006\b¡\u0001\u0010£\u0001\u001a\u0013\u0010¤\u0001\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0005\b¤\u0001\u0010U\u001a*\u0010¤\u0001\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0005\b¤\u0001\u0010V\u001a\u0015\u0010¥\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u0000¢\u0006\u0005\b¥\u0001\u0010X\u001a,\u0010¥\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0005\b¥\u0001\u0010R\u001a#\u0010§\u0001\u001a\u00020\u0000*\u00020\u00002\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020$0\t¢\u0006\u0006\b§\u0001\u0010¨\u0001\u001a\u001e\u0010§\u0001\u001a\u00020\u0000*\u00020\u00002\b\u0010¦\u0001\u001a\u00030©\u0001¢\u0006\u0006\b§\u0001\u0010ª\u0001\u001a&\u0010§\u0001\u001a\u00020'*\u00020'2\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020$0\tH\u0087\b¢\u0006\u0006\b§\u0001\u0010«\u0001\u001a\u001e\u0010§\u0001\u001a\u00020'*\u00020'2\b\u0010¦\u0001\u001a\u00030©\u0001¢\u0006\u0006\b§\u0001\u0010¬\u0001\u001a+\u0010\u00ad\u0001\u001a\u00020$*\u00020\u00002\u0013\u0010\u0087\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0\u0001H\u0086\b¢\u0006\u0005\b\u00ad\u0001\u00101\u001a.\u0010¯\u0001\u001a\u00030®\u0001*\u00020\u00002\u0014\u0010\u0087\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030®\u00010\u0001H\u0086\b¢\u0006\u0006\b¯\u0001\u0010°\u0001\u001a\u001b\u0010±\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020$¢\u0006\u0005\b±\u0001\u00104\u001a\u001b\u0010±\u0001\u001a\u00020'*\u00020'2\u0006\u00102\u001a\u00020$¢\u0006\u0005\b±\u0001\u00105\u001a\u001b\u0010²\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020$¢\u0006\u0005\b²\u0001\u00104\u001a\u001b\u0010²\u0001\u001a\u00020'*\u00020'2\u0006\u00102\u001a\u00020$¢\u0006\u0005\b²\u0001\u00105\u001a*\u0010³\u0001\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0005\b³\u0001\u00108\u001a*\u0010³\u0001\u001a\u00020'*\u00020'2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0005\b³\u0001\u00109\u001a*\u0010´\u0001\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0005\b´\u0001\u00108\u001a*\u0010´\u0001\u001a\u00020'*\u00020'2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0005\b´\u0001\u00109\u001a.\u0010µ\u0001\u001a\u00028\u0000\"\u0010\b\u0000\u0010J*\n\u0012\u0006\b\u0000\u0012\u00020\u00020[*\u00020\u00002\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0006\bµ\u0001\u0010¶\u0001\u001a&\u0010¹\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00020·\u0001j\t\u0012\u0004\u0012\u00020\u0002`¸\u0001*\u00020\u0000¢\u0006\u0006\b¹\u0001\u0010º\u0001\u001a\u001a\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020&*\u00020\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001\u001a\u001a\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020q*\u00020\u0000¢\u0006\u0006\b½\u0001\u0010¼\u0001\u001a\u001b\u0010¿\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020¾\u0001*\u00020\u0000¢\u0006\u0006\b¿\u0001\u0010À\u0001\u001a:\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020\u00002\u0006\u0010%\u001a\u00020$2\t\b\u0002\u0010Á\u0001\u001a\u00020$2\t\b\u0002\u0010Â\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001\u001aT\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010%\u001a\u00020$2\t\b\u0002\u0010Á\u0001\u001a\u00020$2\t\b\u0002\u0010Â\u0001\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0006\bÃ\u0001\u0010Å\u0001\u001a:\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020'0\f*\u00020\u00002\u0006\u0010%\u001a\u00020$2\t\b\u0002\u0010Á\u0001\u001a\u00020$2\t\b\u0002\u0010Â\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001\u001aT\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010**\u00020\u00002\u0006\u0010%\u001a\u00020$2\t\b\u0002\u0010Á\u0001\u001a\u00020$2\t\b\u0002\u0010Â\u0001\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0006\bÆ\u0001\u0010È\u0001\u001a \u0010Ê\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020É\u00010\t*\u00020\u0000¢\u0006\u0005\bÊ\u0001\u0010\u000b\u001a2\u0010Ì\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00110&*\u00020\u00002\u0007\u0010Ë\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0006\bÌ\u0001\u0010Í\u0001\u001af\u0010Ì\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010\u0010*\u00020\u00002\u0007\u0010Ë\u0001\u001a\u00020\u000028\u0010\u0012\u001a4\u0012\u0014\u0012\u00120\u0002¢\u0006\r\bC\u0012\t\bD\u0012\u0005\b\b(Î\u0001\u0012\u0014\u0012\u00120\u0002¢\u0006\r\bC\u0012\t\bD\u0012\u0005\b\b(Ï\u0001\u0012\u0004\u0012\u00028\u00000BH\u0086\b¢\u0006\u0006\bÌ\u0001\u0010Ð\u0001\u001a(\u0010Ñ\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00110&*\u00020\u0000H\u0007¢\u0006\u0006\bÑ\u0001\u0010¼\u0001\u001a\\\u0010Ñ\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010**\u00020\u000028\u0010\u0012\u001a4\u0012\u0014\u0012\u00120\u0002¢\u0006\r\bC\u0012\t\bD\u0012\u0005\b\b(Î\u0001\u0012\u0014\u0012\u00120\u0002¢\u0006\r\bC\u0012\t\bD\u0012\u0005\b\b(Ï\u0001\u0012\u0004\u0012\u00028\u00000BH\u0087\b¢\u0006\u0005\bÑ\u0001\u0010|¨\u0006Ò\u0001"}, d2 = {"", "Lkotlin/Function1;", "", "", "predicate", "all", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Z", "any", "(Ljava/lang/CharSequence;)Z", "", "asIterable", "(Ljava/lang/CharSequence;)Ljava/lang/Iterable;", "Lkotlin/sequences/Sequence;", "asSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "transform", "", "associate", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Ljava/util/Map;", "keySelector", "associateBy", "valueTransform", "(Ljava/lang/CharSequence;Lkotlin/Function1;Lkotlin/Function1;)Ljava/util/Map;", "", "M", "destination", "associateByTo", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "valueSelector", "associateWith", "associateWithTo", "", "size", "", "", "chunked", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "R", "(Ljava/lang/CharSequence;ILkotlin/Function1;)Ljava/util/List;", "chunkedSequence", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;ILkotlin/Function1;)Lkotlin/sequences/Sequence;", "count", "(Ljava/lang/CharSequence;)I", "(Ljava/lang/CharSequence;Lkotlin/Function1;)I", "n", "drop", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "(Ljava/lang/String;I)Ljava/lang/String;", "dropLast", "dropLastWhile", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Lkotlin/Function1;)Ljava/lang/String;", "dropWhile", "index", "defaultValue", "elementAtOrElse", "(Ljava/lang/CharSequence;ILkotlin/Function1;)C", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", CloudControlRequest.REQUEST_KEY_FILTER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexed", "(Ljava/lang/CharSequence;Lkotlin/Function2;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Lkotlin/Function2;)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "C", "filterIndexedTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", Config.TRACE_VISIT_FIRST, "(Ljava/lang/CharSequence;)C", "(Ljava/lang/CharSequence;Lkotlin/Function1;)C", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Ljava/util/List;", "", "flatMapTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "initial", "acc", AppDownloadNetworkStateReceiver.KEY_OPERATION, "fold", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/Function3;", "foldIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "", "action", "forEach", "(Ljava/lang/CharSequence;Lkotlin/Function1;)V", "forEachIndexed", "(Ljava/lang/CharSequence;Lkotlin/Function2;)V", "getOrElse", "getOrNull", "groupBy", "", "groupByTo", "Lkotlin/collections/Grouping;", "groupingBy", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "(Ljava/lang/CharSequence;Lkotlin/Function2;)Ljava/util/List;", "", "mapIndexedNotNull", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "selector", "maxBy", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "maxWith", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", ExifInterface.LATITUDE_SOUTH, "onEach", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Lkotlin/Pair;", "(Ljava/lang/String;Lkotlin/Function1;)Lkotlin/Pair;", "random", "Lkotlin/random/Random;", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)C", "reduce", "(Ljava/lang/CharSequence;Lkotlin/Function2;)C", "reduceIndexed", "(Ljava/lang/CharSequence;Lkotlin/Function3;)C", "reduceRight", "reduceRightIndexed", "reversed", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;)Ljava/lang/String;", "single", "singleOrNull", "indices", "slice", "(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/CharSequence;", "Lkotlin/ranges/IntRange;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/Iterable;)Ljava/lang/String;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "sumBy", "", "sumByDouble", "(Ljava/lang/CharSequence;Lkotlin/Function1;)D", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toHashSet", "(Ljava/lang/CharSequence;)Ljava/util/HashSet;", "toList", "(Ljava/lang/CharSequence;)Ljava/util/List;", "toMutableList", "", "toSet", "(Ljava/lang/CharSequence;)Ljava/util/Set;", "step", "partialWindows", "windowed", "(Ljava/lang/CharSequence;IIZ)Ljava/util/List;", "(Ljava/lang/CharSequence;IIZLkotlin/Function1;)Ljava/util/List;", "windowedSequence", "(Ljava/lang/CharSequence;IIZ)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;IIZLkotlin/Function1;)Lkotlin/sequences/Sequence;", "Lkotlin/collections/IndexedValue;", "withIndex", "other", "zip", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/util/List;", "a", "b", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/Function2;)Ljava/util/List;", "zipWithNext", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes7.dex */
public class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static final boolean all(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(CharSequence charSequence) {
        return !(charSequence.length() == 0);
    }

    public static final Iterable<Character> asIterable(CharSequence charSequence) {
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
        }
        return new StringsKt___StringsKt$asIterable$$inlined$Iterable$1(charSequence);
    }

    public static final Sequence<Character> asSequence(final CharSequence charSequence) {
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return SequencesKt__SequencesKt.emptySequence();
            }
        }
        return new Sequence<Character>() { // from class: kotlin.text.StringsKt___StringsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<Character> iterator() {
                return StringsKt__StringsKt.iterator(charSequence);
            }
        };
    }

    public static final <K, V> Map<K, V> associate(CharSequence charSequence, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            Pair<? extends K, ? extends V> invoke = function1.invoke(Character.valueOf(charSequence.charAt(i)));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Character> associateBy(CharSequence charSequence, Function1<? super Character, ? extends K> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(function1.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(CharSequence charSequence, M m, Function1<? super Character, ? extends K> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(function1.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(CharSequence charSequence, M m, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            Pair<? extends K, ? extends V> invoke = function1.invoke(Character.valueOf(charSequence.charAt(i)));
            m.put(invoke.getFirst(), invoke.getSecond());
        }
        return m;
    }

    @SinceKotlin(version = "1.3")
    public static final <V> Map<Character, V> associateWith(CharSequence charSequence, Function1<? super Character, ? extends V> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(Character.valueOf(charAt), function1.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(CharSequence charSequence, M m, Function1<? super Character, ? extends V> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(Character.valueOf(charAt), function1.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final List<String> chunked(CharSequence charSequence, int i) {
        return windowed(charSequence, i, i, true);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final Sequence<String> chunkedSequence(CharSequence charSequence, int i) {
        return chunkedSequence(charSequence, i, StringsKt___StringsKt$chunkedSequence$1.INSTANCE);
    }

    @InlineOnly
    public static final int count(CharSequence charSequence) {
        return charSequence.length();
    }

    public static final CharSequence drop(CharSequence charSequence, int i) {
        if (i >= 0) {
            return charSequence.subSequence(RangesKt___RangesKt.coerceAtMost(i, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final CharSequence dropLast(CharSequence charSequence, int i) {
        if (i >= 0) {
            return take(charSequence, RangesKt___RangesKt.coerceAtLeast(charSequence.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final CharSequence dropLastWhile(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(lastIndex))).booleanValue()) {
                return charSequence.subSequence(0, lastIndex + 1);
            }
        }
        return "";
    }

    public static final CharSequence dropWhile(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @InlineOnly
    public static final char elementAtOrElse(CharSequence charSequence, int i, Function1<? super Integer, Character> function1) {
        return (i < 0 || i > StringsKt__StringsKt.getLastIndex(charSequence)) ? function1.invoke(Integer.valueOf(i)).charValue() : charSequence.charAt(i);
    }

    @InlineOnly
    public static final Character elementAtOrNull(CharSequence charSequence, int i) {
        return getOrNull(charSequence, i);
    }

    public static final CharSequence filter(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    public static final CharSequence filterIndexed(CharSequence charSequence, Function2<? super Integer, ? super Character, Boolean> function2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (function2.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return sb;
    }

    public static final <C extends Appendable> C filterIndexedTo(CharSequence charSequence, C c2, Function2<? super Integer, ? super Character, Boolean> function2) {
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (function2.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                c2.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return c2;
    }

    public static final CharSequence filterNot(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    public static final <C extends Appendable> C filterNotTo(CharSequence charSequence, C c2, Function1<? super Character, Boolean> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                c2.append(charAt);
            }
        }
        return c2;
    }

    public static final <C extends Appendable> C filterTo(CharSequence charSequence, C c2, Function1<? super Character, Boolean> function1) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                c2.append(charAt);
            }
        }
        return c2;
    }

    @InlineOnly
    public static final Character find(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @InlineOnly
    public static final Character findLast(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        char charAt;
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            charAt = charSequence.charAt(length);
        } while (!function1.invoke(Character.valueOf(charAt)).booleanValue());
        return Character.valueOf(charAt);
    }

    public static final char first(CharSequence charSequence) {
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final Character firstOrNull(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static final <R> List<R> flatMap(CharSequence charSequence, Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, function1.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(CharSequence charSequence, C c2, Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            CollectionsKt__MutableCollectionsKt.addAll(c2, function1.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return c2;
    }

    /* JADX DEBUG: Type inference failed for r3v4. Raw type applied. Possible types: R, ? super R */
    public static final <R> R fold(CharSequence charSequence, R r, Function2<? super R, ? super Character, ? extends R> function2) {
        for (int i = 0; i < charSequence.length(); i++) {
            r = function2.invoke(r, Character.valueOf(charSequence.charAt(i)));
        }
        return r;
    }

    /* JADX DEBUG: Type inference failed for r5v4. Raw type applied. Possible types: R, ? super R */
    public static final <R> R foldIndexed(CharSequence charSequence, R r, Function3<? super Integer, ? super R, ? super Character, ? extends R> function3) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Character.valueOf(charAt));
        }
        return r;
    }

    /* JADX DEBUG: Type inference failed for r3v4. Raw type applied. Possible types: R, ? super R */
    public static final <R> R foldRight(CharSequence charSequence, R r, Function2<? super Character, ? super R, ? extends R> function2) {
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = function2.invoke(Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    /* JADX DEBUG: Type inference failed for r4v4. Raw type applied. Possible types: R, ? super R */
    public static final <R> R foldRightIndexed(CharSequence charSequence, R r, Function3<? super Integer, ? super Character, ? super R, ? extends R> function3) {
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final void forEach(CharSequence charSequence, Function1<? super Character, Unit> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            function1.invoke(Character.valueOf(charSequence.charAt(i)));
        }
    }

    public static final void forEachIndexed(CharSequence charSequence, Function2<? super Integer, ? super Character, Unit> function2) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Character.valueOf(charAt));
        }
    }

    @InlineOnly
    public static final char getOrElse(CharSequence charSequence, int i, Function1<? super Integer, Character> function1) {
        return (i < 0 || i > StringsKt__StringsKt.getLastIndex(charSequence)) ? function1.invoke(Integer.valueOf(i)).charValue() : charSequence.charAt(i);
    }

    public static final Character getOrNull(CharSequence charSequence, int i) {
        if (i < 0 || i > StringsKt__StringsKt.getLastIndex(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    public static final <K> Map<K, List<Character>> groupBy(CharSequence charSequence, Function1<? super Character, ? extends K> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = function1.invoke(Character.valueOf(charAt));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(CharSequence charSequence, M m, Function1<? super Character, ? extends K> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = function1.invoke(Character.valueOf(charAt));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return m;
    }

    @SinceKotlin(version = "1.1")
    public static final <K> Grouping<Character, K> groupingBy(final CharSequence charSequence, final Function1<? super Character, ? extends K> function1) {
        return new Grouping<Character, K>() { // from class: kotlin.text.StringsKt___StringsKt$groupingBy$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.collections.Grouping
            public /* bridge */ /* synthetic */ Object keyOf(Character ch) {
                return keyOf(ch.charValue());
            }

            @Override // kotlin.collections.Grouping
            public Iterator<Character> sourceIterator() {
                return StringsKt__StringsKt.iterator(charSequence);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, K] */
            public K keyOf(char c2) {
                return function1.invoke(Character.valueOf(c2));
            }
        };
    }

    public static final int indexOfFirst(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (function1.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final char last(CharSequence charSequence) {
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(StringsKt__StringsKt.getLastIndex(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final Character lastOrNull(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final <R> List<R> map(CharSequence charSequence, Function1<? super Character, ? extends R> function1) {
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            arrayList.add(function1.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(CharSequence charSequence, Function2<? super Integer, ? super Character, ? extends R> function2) {
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Character.valueOf(charAt)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexedNotNull(CharSequence charSequence, Function2<? super Integer, ? super Character, ? extends R> function2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            R invoke = function2.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(CharSequence charSequence, C c2, Function2<? super Integer, ? super Character, ? extends R> function2) {
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            R invoke = function2.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                c2.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(CharSequence charSequence, C c2, Function2<? super Integer, ? super Character, ? extends R> function2) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            c2.add(function2.invoke(valueOf, Character.valueOf(charAt)));
        }
        return c2;
    }

    public static final <R> List<R> mapNotNull(CharSequence charSequence, Function1<? super Character, ? extends R> function1) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            R invoke = function1.invoke(Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapNotNullTo(CharSequence charSequence, C c2, Function1<? super Character, ? extends R> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            R invoke = function1.invoke(Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                c2.add(invoke);
            }
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(CharSequence charSequence, C c2, Function1<? super Character, ? extends R> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            c2.add(function1.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return c2;
    }

    public static final Character max(CharSequence charSequence) {
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (charAt < charAt2) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final <R extends Comparable<? super R>> Character maxBy(CharSequence charSequence, Function1<? super Character, ? extends R> function1) {
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = function1.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                R invoke2 = function1.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) < 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final Character maxWith(CharSequence charSequence, Comparator<? super Character> comparator) {
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final Character min(CharSequence charSequence) {
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (charAt > charAt2) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final <R extends Comparable<? super R>> Character minBy(CharSequence charSequence, Function1<? super Character, ? extends R> function1) {
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = function1.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                R invoke2 = function1.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) > 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final Character minWith(CharSequence charSequence, Comparator<? super Character> comparator) {
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final boolean none(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @SinceKotlin(version = "1.1")
    public static final <S extends CharSequence> S onEach(S s, Function1<? super Character, Unit> function1) {
        for (int i = 0; i < s.length(); i++) {
            function1.invoke(Character.valueOf(s.charAt(i)));
        }
        return s;
    }

    public static final Pair<CharSequence, CharSequence> partition(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb, sb2);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final char random(CharSequence charSequence) {
        return random(charSequence, Random.Default);
    }

    public static final char reduce(CharSequence charSequence, Function2<? super Character, ? super Character, Character> function2) {
        int i = 1;
        if (!(charSequence.length() == 0)) {
            char charAt = charSequence.charAt(0);
            int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
            if (1 <= lastIndex) {
                while (true) {
                    charAt = function2.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final char reduceIndexed(CharSequence charSequence, Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        int i = 1;
        if (!(charSequence.length() == 0)) {
            char charAt = charSequence.charAt(0);
            int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
            if (1 <= lastIndex) {
                while (true) {
                    charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final char reduceRight(CharSequence charSequence, Function2<? super Character, ? super Character, Character> function2) {
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex >= 0) {
            char charAt = charSequence.charAt(lastIndex);
            for (int i = lastIndex - 1; i >= 0; i--) {
                charAt = function2.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final char reduceRightIndexed(CharSequence charSequence, Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex >= 0) {
            char charAt = charSequence.charAt(lastIndex);
            for (int i = lastIndex - 1; i >= 0; i--) {
                charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final CharSequence reversed(CharSequence charSequence) {
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        Intrinsics.checkExpressionValueIsNotNull(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }

    public static final char single(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            if (length == 1) {
                return charSequence.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final Character singleOrNull(CharSequence charSequence) {
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    public static final CharSequence slice(CharSequence charSequence, IntRange intRange) {
        return intRange.isEmpty() ? "" : StringsKt__StringsKt.subSequence(charSequence, intRange);
    }

    public static final int sumBy(CharSequence charSequence, Function1<? super Character, Integer> function1) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += function1.invoke(Character.valueOf(charSequence.charAt(i2))).intValue();
        }
        return i;
    }

    public static final double sumByDouble(CharSequence charSequence, Function1<? super Character, Double> function1) {
        double d2 = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            d2 += function1.invoke(Character.valueOf(charSequence.charAt(i))).doubleValue();
        }
        return d2;
    }

    public static final CharSequence take(CharSequence charSequence, int i) {
        if (i >= 0) {
            return charSequence.subSequence(0, RangesKt___RangesKt.coerceAtMost(i, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final CharSequence takeLast(CharSequence charSequence, int i) {
        if (i >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - RangesKt___RangesKt.coerceAtMost(i, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final CharSequence takeLastWhile(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(lastIndex))).booleanValue()) {
                return charSequence.subSequence(lastIndex + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence takeWhile(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(0, i);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final <C extends Collection<? super Character>> C toCollection(CharSequence charSequence, C c2) {
        for (int i = 0; i < charSequence.length(); i++) {
            c2.add(Character.valueOf(charSequence.charAt(i)));
        }
        return c2;
    }

    public static final HashSet<Character> toHashSet(CharSequence charSequence) {
        return (HashSet) toCollection(charSequence, new HashSet(MapsKt__MapsKt.mapCapacity(charSequence.length())));
    }

    public static final List<Character> toList(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            if (length != 1) {
                return toMutableList(charSequence);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(charSequence.charAt(0)));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Character> toMutableList(CharSequence charSequence) {
        return (List) toCollection(charSequence, new ArrayList(charSequence.length()));
    }

    public static final Set<Character> toSet(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            if (length != 1) {
                return (Set) toCollection(charSequence, new LinkedHashSet(MapsKt__MapsKt.mapCapacity(charSequence.length())));
            }
            return SetsKt__SetsJVMKt.setOf(Character.valueOf(charSequence.charAt(0)));
        }
        return SetsKt__SetsKt.emptySet();
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final List<String> windowed(CharSequence charSequence, int i, int i2, boolean z) {
        return windowed(charSequence, i, i2, z, StringsKt___StringsKt$windowed$1.INSTANCE);
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i, i2, z);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final Sequence<String> windowedSequence(CharSequence charSequence, int i, int i2, boolean z) {
        return windowedSequence(charSequence, i, i2, z, StringsKt___StringsKt$windowedSequence$1.INSTANCE);
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i, i2, z);
    }

    public static final Iterable<IndexedValue<Character>> withIndex(CharSequence charSequence) {
        return new IndexingIterable(new StringsKt___StringsKt$withIndex$1(charSequence));
    }

    public static final <V> List<V> zip(CharSequence charSequence, CharSequence charSequence2, Function2<? super Character, ? super Character, ? extends V> function2) {
        int min = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence2.charAt(i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final <R> List<R> zipWithNext(CharSequence charSequence, Function2<? super Character, ? super Character, ? extends R> function2) {
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            i++;
            arrayList.add(function2.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    public static final boolean any(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final <R> List<R> chunked(CharSequence charSequence, int i, Function1<? super CharSequence, ? extends R> function1) {
        return windowed(charSequence, i, i, true, function1);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final <R> Sequence<R> chunkedSequence(CharSequence charSequence, int i, Function1<? super CharSequence, ? extends R> function1) {
        return windowedSequence(charSequence, i, i, true, function1);
    }

    public static final int count(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (function1.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final Character firstOrNull(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    public static final Character lastOrNull(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        char charAt;
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            charAt = charSequence.charAt(length);
        } while (!function1.invoke(Character.valueOf(charAt)).booleanValue());
        return Character.valueOf(charAt);
    }

    public static final boolean none(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final char random(CharSequence charSequence, Random random) {
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(random.nextInt(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @InlineOnly
    public static final String reversed(String str) {
        if (str != null) {
            return reversed((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final Character singleOrNull(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(charAt);
                z = true;
            }
        }
        if (z) {
            return ch;
        }
        return null;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final <R> List<R> windowed(CharSequence charSequence, int i, int i2, boolean z, Function1<? super CharSequence, ? extends R> function1) {
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        int length = charSequence.length();
        int i3 = 0;
        ArrayList arrayList = new ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        while (i3 >= 0 && length > i3) {
            int i4 = i3 + i;
            if (i4 < 0 || i4 > length) {
                if (!z) {
                    break;
                }
                i4 = length;
            }
            arrayList.add(function1.invoke(charSequence.subSequence(i3, i4)));
            i3 += i2;
        }
        return arrayList;
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i, i2, z, function1);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final <R> Sequence<R> windowedSequence(CharSequence charSequence, int i, int i2, boolean z, Function1<? super CharSequence, ? extends R> function1) {
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        return SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.step(z ? StringsKt__StringsKt.getIndices(charSequence) : RangesKt___RangesKt.until(0, (charSequence.length() - i) + 1), i2)), new StringsKt___StringsKt$windowedSequence$2(charSequence, i, function1));
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence charSequence, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i, i2, z, function1);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(CharSequence charSequence, M m, Function1<? super Character, ? extends K> function1, Function1<? super Character, ? extends V> function12) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(function1.invoke(Character.valueOf(charAt)), function12.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    public static final String drop(String str, int i) {
        if (i >= 0) {
            String substring = str.substring(RangesKt___RangesKt.coerceAtMost(i, str.length()));
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final String dropLast(String str, int i) {
        if (i >= 0) {
            return take(str, RangesKt___RangesKt.coerceAtLeast(str.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final String filterNot(String str, Function1<? super Character, Boolean> function1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final String slice(String str, IntRange intRange) {
        return intRange.isEmpty() ? "" : StringsKt__StringsKt.substring(str, intRange);
    }

    public static final String take(String str, int i) {
        if (i >= 0) {
            String substring = str.substring(0, RangesKt___RangesKt.coerceAtMost(i, str.length()));
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final String dropLastWhile(String str, Function1<? super Character, Boolean> function1) {
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(str); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                String substring = str.substring(0, lastIndex + 1);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }

    public static final String dropWhile(String str, Function1<? super Character, Boolean> function1) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(i);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return "";
    }

    public static final String filterIndexed(String str, Function2<? super Integer, ? super Character, Boolean> function2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i3 = i2 + 1;
            if (function2.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "filterIndexedTo(StringBu…(), predicate).toString()");
        return sb2;
    }

    public static final char first(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                return charAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final char last(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        char charAt;
        int length = charSequence.length();
        do {
            length--;
            if (length >= 0) {
                charAt = charSequence.charAt(length);
            } else {
                throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
            }
        } while (!function1.invoke(Character.valueOf(charAt)).booleanValue());
        return charAt;
    }

    public static final String takeLast(String str, int i) {
        if (i >= 0) {
            int length = str.length();
            String substring = str.substring(length - RangesKt___RangesKt.coerceAtMost(i, length));
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final List<Pair<Character, Character>> zip(CharSequence charSequence, CharSequence charSequence2) {
        int min = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence2.charAt(i))));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(CharSequence charSequence, Function1<? super Character, ? extends K> function1, Function1<? super Character, ? extends V> function12) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(function1.invoke(Character.valueOf(charAt)), function12.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    public static final String filter(String str, Function1<? super Character, Boolean> function1) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final char single(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(charAt);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            if (ch != null) {
                return ch.charValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final CharSequence slice(CharSequence charSequence, Iterable<Integer> iterable) {
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(collectionSizeOrDefault);
        for (Integer num : iterable) {
            sb.append(charSequence.charAt(num.intValue()));
        }
        return sb;
    }

    public static final String takeLastWhile(String str, Function1<? super Character, Boolean> function1) {
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(str); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                String substring = str.substring(lastIndex + 1);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return str;
    }

    public static final String takeWhile(String str, Function1<? super Character, Boolean> function1) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(0, i);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return str;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final List<Pair<Character, Character>> zipWithNext(CharSequence charSequence) {
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            i++;
            arrayList.add(TuplesKt.to(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, java.util.List<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(CharSequence charSequence, M m, Function1<? super Character, ? extends K> function1, Function1<? super Character, ? extends V> function12) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = function1.invoke(Character.valueOf(charAt));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    public static final Pair<String, String> partition(String str, Function1<? super Character, Boolean> function1) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb.toString(), sb2.toString());
    }

    public static final <K, V> Map<K, List<V>> groupBy(CharSequence charSequence, Function1<? super Character, ? extends K> function1, Function1<? super Character, ? extends V> function12) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = function1.invoke(Character.valueOf(charAt));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(function12.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    public static final String slice(String str, Iterable<Integer> iterable) {
        if (str != null) {
            return slice((CharSequence) str, iterable).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
