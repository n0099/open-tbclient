package kotlin.text;

import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0019\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b:\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006\u001a&\u0010\n\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\n\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\n\u0010\f\u001a\u001c\u0010\n\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\n\u0010\u000f\u001a#\u0010\u0010\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u000b\u001a#\u0010\u0010\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\f\u001aA\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016*\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aG\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016*\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001aA\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016*\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0018\u001a\u0019\u0010\u001e\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001f\u001a6\u0010$\u001a\u00028\u0001\"\f\b\u0000\u0010 *\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010!*\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0087\b¢\u0006\u0004\b$\u0010%\u001a6\u0010&\u001a\u00028\u0001\"\f\b\u0000\u0010 *\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010!*\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0087\b¢\u0006\u0004\b&\u0010%\u001a-\u0010'\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(\u001a=\u0010'\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+\u001a-\u0010'\u001a\u00020\u0014*\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b'\u0010-\u001a-\u00100\u001a\u00020\u0014*\u00020\u00002\u0006\u0010/\u001a\u00020.2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b0\u00101\u001a3\u00100\u001a\u00020\u0014*\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b0\u00102\u001a\u0014\u00103\u001a\u00020\u0002*\u00020\u0000H\u0087\b¢\u0006\u0004\b3\u00104\u001a\u0014\u00105\u001a\u00020\u0002*\u00020\u0000H\u0087\b¢\u0006\u0004\b5\u00104\u001a\u0014\u00106\u001a\u00020\u0002*\u00020\u0000H\u0087\b¢\u0006\u0004\b6\u00104\u001a'\u00107\u001a\u00020\u0002*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b7\u00104\u001a'\u00108\u001a\u00020\u0002*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b8\u00104\u001a\u0014\u0010:\u001a\u000209*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b:\u0010;\u001a-\u0010<\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b<\u0010(\u001a-\u0010<\u001a\u00020\u0014*\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b<\u0010-\u001a-\u0010=\u001a\u00020\u0014*\u00020\u00002\u0006\u0010/\u001a\u00020.2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b=\u00101\u001a3\u0010=\u001a\u00020\u0014*\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b=\u00102\u001a\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040>*\u00020\u0000¢\u0006\u0004\b?\u0010@\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040A*\u00020\u0000¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0087\f¢\u0006\u0004\bD\u0010\u000f\u001a\u0016\u0010E\u001a\u00020\u0004*\u0004\u0018\u00010\u0004H\u0087\b¢\u0006\u0004\bE\u0010F\u001a#\u0010I\u001a\u00020\u0000*\u00020\u00002\u0006\u0010G\u001a\u00020\u00142\b\b\u0002\u0010H\u001a\u00020\b¢\u0006\u0004\bI\u0010J\u001a#\u0010I\u001a\u00020\u0004*\u00020\u00042\u0006\u0010G\u001a\u00020\u00142\b\b\u0002\u0010H\u001a\u00020\b¢\u0006\u0004\bI\u0010K\u001a#\u0010L\u001a\u00020\u0000*\u00020\u00002\u0006\u0010G\u001a\u00020\u00142\b\b\u0002\u0010H\u001a\u00020\b¢\u0006\u0004\bL\u0010J\u001a#\u0010L\u001a\u00020\u0004*\u00020\u00042\u0006\u0010G\u001a\u00020\u00142\b\b\u0002\u0010H\u001a\u00020\b¢\u0006\u0004\bL\u0010K\u001aG\u0010S\u001a\b\u0012\u0004\u0012\u00020P0>*\u00020\u00002\u000e\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040M2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010O\u001a\u00020\u0014H\u0002¢\u0006\u0004\bQ\u0010R\u001a?\u0010S\u001a\b\u0012\u0004\u0012\u00020P0>*\u00020\u00002\u0006\u0010N\u001a\u00020.2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010O\u001a\u00020\u0014H\u0002¢\u0006\u0004\bQ\u0010T\u001a;\u0010W\u001a\u00020\u0002*\u00020\u00002\u0006\u0010U\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\bW\u0010X\u001a\u0019\u0010Z\u001a\u00020\u0000*\u00020\u00002\u0006\u0010Y\u001a\u00020\u0000¢\u0006\u0004\bZ\u0010[\u001a\u0019\u0010Z\u001a\u00020\u0004*\u00020\u00042\u0006\u0010Y\u001a\u00020\u0000¢\u0006\u0004\bZ\u0010\\\u001a!\u0010]\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\b]\u0010^\u001a\u0019\u0010]\u001a\u00020\u0000*\u00020\u00002\u0006\u0010_\u001a\u00020P¢\u0006\u0004\b]\u0010`\u001a$\u0010]\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b]\u0010a\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020\u00042\u0006\u0010_\u001a\u00020PH\u0087\b¢\u0006\u0004\b]\u0010b\u001a\u0019\u0010c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\bc\u0010[\u001a\u0019\u0010c\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\bc\u0010\\\u001a\u0019\u0010e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010d\u001a\u00020\u0000¢\u0006\u0004\be\u0010[\u001a!\u0010e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010Y\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\be\u0010f\u001a\u0019\u0010e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u0000¢\u0006\u0004\be\u0010\\\u001a!\u0010e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010Y\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\be\u0010g\u001a2\u0010k\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0014\b\b\u0010j\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020\u00000hH\u0087\b¢\u0006\u0004\bk\u0010l\u001a$\u0010k\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010m\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\bk\u0010n\u001a+\u0010p\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bp\u0010q\u001a+\u0010p\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bp\u0010r\u001a+\u0010s\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bs\u0010q\u001a+\u0010s\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bs\u0010r\u001a+\u0010t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bt\u0010q\u001a+\u0010t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bt\u0010r\u001a+\u0010u\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bu\u0010q\u001a+\u0010u\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0004\bu\u0010r\u001a$\u0010v\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010m\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\bv\u0010n\u001a)\u0010w\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010m\u001a\u00020\u0000¢\u0006\u0004\bw\u0010x\u001a!\u0010w\u001a\u00020\u0000*\u00020\u00002\u0006\u0010_\u001a\u00020P2\u0006\u0010m\u001a\u00020\u0000¢\u0006\u0004\bw\u0010y\u001a,\u0010w\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010m\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bw\u0010z\u001a$\u0010w\u001a\u00020\u0004*\u00020\u00042\u0006\u0010_\u001a\u00020P2\u0006\u0010m\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bw\u0010{\u001a?\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00040A*\u00020\u00002\u0012\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040M\"\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010O\u001a\u00020\u0014¢\u0006\u0004\b|\u0010}\u001a7\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00040A*\u00020\u00002\n\u0010N\u001a\u00020.\"\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010O\u001a\u00020\u0014¢\u0006\u0004\b|\u0010~\u001a2\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00040A*\u00020\u00002\u0006\u0010d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010O\u001a\u00020\u0014H\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001\u001a-\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00040A*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010O\u001a\u00020\u0014H\u0087\b¢\u0006\u0005\b|\u0010\u0081\u0001\u001aB\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040>*\u00020\u00002\u0012\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040M\"\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010O\u001a\u00020\u0014¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a:\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040>*\u00020\u00002\n\u0010N\u001a\u00020.\"\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010O\u001a\u00020\u0014¢\u0006\u0006\b\u0082\u0001\u0010\u0084\u0001\u001a%\u0010\u0085\u0001\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u000b\u001a%\u0010\u0085\u0001\u001a\u00020\u0002*\u00020\u00002\u0006\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0005\b\u0085\u0001\u0010\f\u001a.\u0010\u0085\u0001\u001a\u00020\u0002*\u00020\u00002\u0006\u0010Y\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u001b\u0010\u0087\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u0010_\u001a\u00020P¢\u0006\u0005\b\u0087\u0001\u0010`\u001a)\u0010\u0087\u0001\u001a\u00020\u0000*\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u00142\u0007\u0010\u0089\u0001\u001a\u00020\u0014H\u0087\b¢\u0006\u0006\b\u0087\u0001\u0010\u008a\u0001\u001a)\u0010\u008b\u0001\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u0014H\u0087\b¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u001c\u0010\u008b\u0001\u001a\u00020\u0004*\u00020\u00002\u0006\u0010_\u001a\u00020P¢\u0006\u0006\b\u008b\u0001\u0010\u008d\u0001\u001a\u001b\u0010\u008b\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010_\u001a\u00020P¢\u0006\u0005\b\u008b\u0001\u0010b\u001a&\u0010\u008e\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a&\u0010\u008e\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u008e\u0001\u0010\u0090\u0001\u001a&\u0010\u0091\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u0091\u0001\u0010\u008f\u0001\u001a&\u0010\u0091\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u0091\u0001\u0010\u0090\u0001\u001a&\u0010\u0092\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u0092\u0001\u0010\u008f\u0001\u001a&\u0010\u0092\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u0092\u0001\u0010\u0090\u0001\u001a&\u0010\u0093\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\b2\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u0093\u0001\u0010\u008f\u0001\u001a&\u0010\u0093\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010d\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004¢\u0006\u0006\b\u0093\u0001\u0010\u0090\u0001\u001a\u0014\u0010\u0094\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a,\u0010\u0094\u0001\u001a\u00020\u0000*\u00020\u00002\u0013\u0010\u0096\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020hH\u0086\b¢\u0006\u0006\b\u0094\u0001\u0010\u0097\u0001\u001a \u0010\u0094\u0001\u001a\u00020\u0000*\u00020\u00002\n\u0010/\u001a\u00020.\"\u00020\b¢\u0006\u0006\b\u0094\u0001\u0010\u0098\u0001\u001a\u0016\u0010\u0094\u0001\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0005\b\u0094\u0001\u0010F\u001a,\u0010\u0094\u0001\u001a\u00020\u0004*\u00020\u00042\u0013\u0010\u0096\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020hH\u0086\b¢\u0006\u0006\b\u0094\u0001\u0010\u0099\u0001\u001a \u0010\u0094\u0001\u001a\u00020\u0004*\u00020\u00042\n\u0010/\u001a\u00020.\"\u00020\b¢\u0006\u0006\b\u0094\u0001\u0010\u009a\u0001\u001a\u0014\u0010\u009b\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u0095\u0001\u001a,\u0010\u009b\u0001\u001a\u00020\u0000*\u00020\u00002\u0013\u0010\u0096\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020hH\u0086\b¢\u0006\u0006\b\u009b\u0001\u0010\u0097\u0001\u001a \u0010\u009b\u0001\u001a\u00020\u0000*\u00020\u00002\n\u0010/\u001a\u00020.\"\u00020\b¢\u0006\u0006\b\u009b\u0001\u0010\u0098\u0001\u001a\u0016\u0010\u009b\u0001\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0005\b\u009b\u0001\u0010F\u001a,\u0010\u009b\u0001\u001a\u00020\u0004*\u00020\u00042\u0013\u0010\u0096\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020hH\u0086\b¢\u0006\u0006\b\u009b\u0001\u0010\u0099\u0001\u001a \u0010\u009b\u0001\u001a\u00020\u0004*\u00020\u00042\n\u0010/\u001a\u00020.\"\u00020\b¢\u0006\u0006\b\u009b\u0001\u0010\u009a\u0001\u001a\u0014\u0010\u009c\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u0095\u0001\u001a,\u0010\u009c\u0001\u001a\u00020\u0000*\u00020\u00002\u0013\u0010\u0096\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020hH\u0086\b¢\u0006\u0006\b\u009c\u0001\u0010\u0097\u0001\u001a \u0010\u009c\u0001\u001a\u00020\u0000*\u00020\u00002\n\u0010/\u001a\u00020.\"\u00020\b¢\u0006\u0006\b\u009c\u0001\u0010\u0098\u0001\u001a\u0016\u0010\u009c\u0001\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0005\b\u009c\u0001\u0010F\u001a,\u0010\u009c\u0001\u001a\u00020\u0004*\u00020\u00042\u0013\u0010\u0096\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020hH\u0086\b¢\u0006\u0006\b\u009c\u0001\u0010\u0099\u0001\u001a \u0010\u009c\u0001\u001a\u00020\u0004*\u00020\u00042\n\u0010/\u001a\u00020.\"\u00020\b¢\u0006\u0006\b\u009c\u0001\u0010\u009a\u0001\"\u001a\u0010\u009f\u0001\u001a\u00020P*\u00020\u00008F@\u0006¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u001a\u0010¢\u0001\u001a\u00020\u0014*\u00020\u00008F@\u0006¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006£\u0001"}, d2 = {"", "other", "", "ignoreCase", "", "commonPrefixWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Ljava/lang/String;", "commonSuffixWith", "", "char", "contains", "(Ljava/lang/CharSequence;CZ)Z", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "Lkotlin/text/Regex;", "regex", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;)Z", "endsWith", "suffix", "", "strings", "", "startIndex", "Lkotlin/Pair;", "findAnyOf", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)Lkotlin/Pair;", "last", "findAnyOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "findLastAnyOf", "index", "hasSurrogatePairAt", "(Ljava/lang/CharSequence;I)Z", "C", "R", "Lkotlin/Function0;", "defaultValue", "ifBlank", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "(Ljava/lang/CharSequence;CIZ)I", "endIndex", "indexOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "string", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "", "chars", "indexOfAny", "(Ljava/lang/CharSequence;[CIZ)I", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)I", "isEmpty", "(Ljava/lang/CharSequence;)Z", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "Lkotlin/collections/CharIterator;", "iterator", "(Ljava/lang/CharSequence;)Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "Lkotlin/sequences/Sequence;", "lineSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "", "lines", "(Ljava/lang/CharSequence;)Ljava/util/List;", "matches", "orEmpty", "(Ljava/lang/String;)Ljava/lang/String;", "length", "padChar", "padEnd", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "(Ljava/lang/String;IC)Ljava/lang/String;", "padStart", "", "delimiters", Constants.EXTRA_CONFIG_LIMIT, "Lkotlin/ranges/IntRange;", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "rangesDelimitedBy", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "thisOffset", "otherOffset", "regionMatchesImpl", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "prefix", "removePrefix", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "removeRange", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", "range", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/CharSequence;", "(Ljava/lang/String;II)Ljava/lang/String;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "removeSuffix", "delimiter", "removeSurrounding", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "transform", "replace", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Lkotlin/Function1;)Ljava/lang/String;", "replacement", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Ljava/lang/String;)Ljava/lang/String;", "missingDelimiterValue", "replaceAfter", "(Ljava/lang/String;CLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;IILjava/lang/CharSequence;)Ljava/lang/String;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/String;", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "split$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;I)Ljava/util/List;", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;[CZI)Lkotlin/sequences/Sequence;", "startsWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IZ)Z", "subSequence", IntentConfig.START, ProgressInfo.JSON_KEY_END, "(Ljava/lang/String;II)Ljava/lang/CharSequence;", "substring", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "substringAfter", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "predicate", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;[C)Ljava/lang/CharSequence;", "(Ljava/lang/String;Lkotlin/Function1;)Ljava/lang/String;", "(Ljava/lang/String;[C)Ljava/lang/String;", "trimEnd", "trimStart", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes7.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final String commonPrefixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (hasSurrogatePairAt(charSequence, i2) || hasSurrogatePairAt(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        int length;
        int length2 = charSequence.length();
        int min = Math.min(length2, charSequence2.length());
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(charSequence.charAt((length2 - i) - 1), charSequence2.charAt((length - i) - 1), z)) {
            i++;
        }
        if (hasSurrogatePairAt(charSequence, (length2 - i) - 1) || hasSurrogatePairAt(charSequence2, (length - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length2 - i, length2).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(CharSequence charSequence, char c2, boolean z) {
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(getLastIndex(charSequence)), c2, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c2, z);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
    }

    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt___CollectionsKt.single(collection);
            int indexOf$default = !z2 ? indexOf$default(charSequence, str, i, false, 4, (Object) null) : lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
            if (indexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(indexOf$default), str);
        }
        IntProgression intRange = !z2 ? new IntRange(RangesKt___RangesKt.coerceAtLeast(i, 0), charSequence.length()) : RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (StringsKt__StringsJVMKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if (step2 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i, z);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i, z);
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i) {
        return i >= 0 && charSequence.length() + (-2) >= i && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: C extends java.lang.CharSequence & R */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <C extends CharSequence & R, R> R ifBlank(C c2, Function0<? extends R> function0) {
        return StringsKt__StringsJVMKt.isBlank(c2) ? function0.invoke() : c2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: C extends java.lang.CharSequence & R */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <C extends CharSequence & R, R> R ifEmpty(C c2, Function0<? extends R> function0) {
        return c2.length() == 0 ? function0.invoke() : c2;
    }

    public static final int indexOf(CharSequence charSequence, char c2, int i, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i);
        }
        return indexOfAny(charSequence, new char[]{c2}, i, z);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression downTo;
        if (!z2) {
            downTo = new IntRange(RangesKt___RangesKt.coerceAtLeast(i, 0), RangesKt___RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            downTo = RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)), RangesKt___RangesKt.coerceAtLeast(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if (step >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = downTo.getFirst();
        int last2 = downTo.getLast();
        int step2 = downTo.getStep();
        if (step2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c2, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt___ArraysKt.single(cArr), i);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
        int lastIndex = getLastIndex(charSequence);
        if (coerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(coerceAtLeast);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (CharsKt__CharKt.equals(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return coerceAtLeast;
            }
            if (coerceAtLeast == lastIndex) {
                return -1;
            }
            coerceAtLeast++;
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i, z);
    }

    @InlineOnly
    public static final boolean isEmpty(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @InlineOnly
    public static final boolean isNotBlank(CharSequence charSequence) {
        return !StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    public static final boolean isNotEmpty(CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    @InlineOnly
    public static final boolean isNullOrBlank(CharSequence charSequence) {
        return charSequence == null || StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    public static final boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static final CharIterator iterator(final CharSequence charSequence) {
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            public int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < charSequence.length();
            }

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence2 = charSequence;
                int i = this.index;
                this.index = i + 1;
                return charSequence2.charAt(i);
            }
        };
    }

    public static final int lastIndexOf(CharSequence charSequence, char c2, int i, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i);
        }
        return lastIndexOfAny(charSequence, new char[]{c2}, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c2, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.single(cArr), i);
        }
        for (int coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)); coerceAtMost >= 0; coerceAtMost--) {
            char charAt = charSequence.charAt(coerceAtMost);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (CharsKt__CharKt.equals(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return coerceAtMost;
            }
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i, z);
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        return splitToSequence$default(charSequence, new String[]{Part.CRLF, "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        return SequencesKt___SequencesKt.toList(lineSequence(charSequence));
    }

    @InlineOnly
    public static final boolean matches(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    @InlineOnly
    public static final String orEmpty(String str) {
        return str != null ? str : "";
    }

    public static final CharSequence padEnd(CharSequence charSequence, int i, char c2) {
        if (i >= 0) {
            if (i <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i);
            sb.append(charSequence);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c2 = ' ';
        }
        return padEnd(charSequence, i, c2);
    }

    public static final CharSequence padStart(CharSequence charSequence, int i, char c2) {
        if (i >= 0) {
            if (i <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c2 = ' ';
        }
        return padStart(charSequence, i, c2);
    }

    public static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + IStringUtil.EXTENSION_SEPARATOR).toString());
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence charSequence2) {
        if (startsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i, int i2) {
        if (i2 >= i) {
            if (i2 == i) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
            sb.append(charSequence, 0, i);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence charSequence2) {
        if (endsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        if (charSequence.length() >= charSequence2.length() + charSequence3.length() && startsWith$default(charSequence, charSequence2, false, 2, (Object) null) && endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @InlineOnly
    public static final String replace(CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    public static final String replaceAfter(String str, char c2, String str2, String str3) {
        int indexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange((CharSequence) str, indexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c2, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c2, str2, str3);
    }

    public static final String replaceAfterLast(String str, String str2, String str3, String str4) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange((CharSequence) str, lastIndexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    public static final String replaceBefore(String str, char c2, String str2, String str3) {
        int indexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange((CharSequence) str, 0, indexOf$default, (CharSequence) str2).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c2, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c2, str2, str3);
    }

    public static final String replaceBeforeLast(String str, char c2, String str2, String str3) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange((CharSequence) str, 0, lastIndexOf$default, (CharSequence) str2).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c2, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c2, str2, str3);
    }

    @InlineOnly
    public static final String replaceFirst(CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(charSequence, intRange));
        }
        return arrayList;
    }

    public static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int indexOf = indexOf(charSequence, str, 0, z);
            if (indexOf != -1 && i != 1) {
                boolean z2 = i > 0;
                ArrayList arrayList = new ArrayList(z2 ? RangesKt___RangesKt.coerceAtMost(i, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                    i2 = str.length() + indexOf;
                    if (z2 && arrayList.size() == i - 1) {
                        break;
                    }
                    indexOf = indexOf(charSequence, str, i2, z);
                } while (indexOf != -1);
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                return arrayList;
            }
            return CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + IStringUtil.EXTENSION_SEPARATOR).toString());
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, String[] strArr, boolean z, int i) {
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z, i);
    }

    public static final boolean startsWith(CharSequence charSequence, char c2, boolean z) {
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(0), c2, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c2, z);
    }

    public static final CharSequence subSequence(CharSequence charSequence, IntRange intRange) {
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    public static final String substring(String str, IntRange intRange) {
        String substring = str.substring(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substring$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return charSequence.subSequence(i, i2).toString();
    }

    public static final String substringAfter(String str, char c2, String str2) {
        int indexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c2, str2);
    }

    public static final String substringAfterLast(String str, char c2, String str2) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c2, str2);
    }

    public static final String substringBefore(String str, char c2, String str2) {
        int indexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c2, str2);
    }

    public static final String substringBeforeLast(String str, char c2, String str2) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c2, str2);
    }

    public static final CharSequence trim(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (function1.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c2, z);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, collection, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, collection, i, z);
    }

    public static /* synthetic */ String padEnd$default(String str, int i, char c2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c2 = ' ';
        }
        return padEnd(str, i, c2);
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c2 = ' ';
        }
        return padStart(str, i, c2);
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    @InlineOnly
    public static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        return regex.replace(charSequence, function1);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c2, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c2, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z, i);
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, char[] cArr, boolean z, int i) {
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, cArr, z, i);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    public static final CharSequence subSequence(String str, int i, int i2) {
        return str.subSequence(i, i2);
    }

    @InlineOnly
    public static final String substring(CharSequence charSequence, int i, int i2) {
        return charSequence.subSequence(i, i2).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    public static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$4(ArraysKt___ArraysJvmKt.asList(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + IStringUtil.EXTENSION_SEPARATOR).toString());
    }

    public static final String replaceAfter(String str, String str2, String str3, String str4) {
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange((CharSequence) str, indexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static final String replaceAfterLast(String str, char c2, String str2, String str3) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange((CharSequence) str, lastIndexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static final String replaceBefore(String str, String str2, String str3, String str4) {
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange((CharSequence) str, 0, indexOf$default, (CharSequence) str3).toString();
    }

    public static final String replaceBeforeLast(String str, String str2, String str3, String str4) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange((CharSequence) str, 0, lastIndexOf$default, (CharSequence) str3).toString();
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i, z);
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substringAfter(String str, String str2, String str3) {
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(indexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringAfterLast(String str, String str2, String str3) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(lastIndexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBefore(String str, String str2, String str3) {
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBeforeLast(String str, String str2, String str3) {
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean contains(CharSequence charSequence, char c2, boolean z) {
        return indexOf$default(charSequence, c2, 0, z, 2, (Object) null) >= 0;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true);
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        if (startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            String substring = str.substring(charSequence.length());
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        if (endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            String substring = str.substring(0, str.length() - charSequence.length());
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str.length() >= charSequence.length() + charSequence2.length() && startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) && endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    @InlineOnly
    public static final String trim(String str) {
        if (str != null) {
            return trim((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final String trimEnd(String str) {
        if (str != null) {
            return trimEnd((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final String trimStart(String str) {
        if (str != null) {
            return trimStart((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final boolean contains(CharSequence charSequence, Regex regex) {
        return regex.containsMatchIn(charSequence);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) charSequence2, i, false, 4, null);
        }
        return regionMatchesImpl(charSequence, i, charSequence2, 0, charSequence2.length(), z);
    }

    public static final String trim(String str, Function1<? super Character, Boolean> function1) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(str.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static final String trimEnd(String str, Function1<? super Character, Boolean> function1) {
        CharSequence charSequence;
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            } else if (!function1.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                charSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    public static final String trimStart(String str, Function1<? super Character, Boolean> function1) {
        CharSequence charSequence;
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            } else if (!function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                charSequence = str.subSequence(i, str.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    @InlineOnly
    public static final String removeRange(String str, int i, int i2) {
        if (str != null) {
            return removeRange((CharSequence) str, i, i2).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2) {
        return removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    @InlineOnly
    public static final String replaceRange(String str, int i, int i2, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, i, i2, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence removeRange(CharSequence charSequence, IntRange intRange) {
        return removeRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        return removeSurrounding(str, charSequence, charSequence);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, IntRange intRange, CharSequence charSequence2) {
        return replaceRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1, charSequence2);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer first;
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer first;
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final String padEnd(String str, int i, char c2) {
        return padEnd((CharSequence) str, i, c2).toString();
    }

    public static final String padStart(String str, int i, char c2) {
        return padStart((CharSequence) str, i, c2).toString();
    }

    @InlineOnly
    public static final String removeRange(String str, IntRange intRange) {
        if (str != null) {
            return removeRange((CharSequence) str, intRange).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final String replaceRange(String str, IntRange intRange, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, intRange, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence trim(CharSequence charSequence, char... cArr) {
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char... cArr) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... cArr) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z, int i) {
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(charSequence, intRange));
        }
        return arrayList;
    }

    public static final String trim(String str, char... cArr) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, str.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static final String trimEnd(String str, char... cArr) {
        CharSequence charSequence;
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            } else if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(length))) {
                charSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    public static final String trimStart(String str, char... cArr) {
        CharSequence charSequence;
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            } else if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(i))) {
                charSequence = str.subSequence(i, str.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    @InlineOnly
    public static final List<String> split(CharSequence charSequence, Regex regex, int i) {
        return regex.split(charSequence, i);
    }

    public static final CharSequence trim(CharSequence charSequence) {
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }
}
