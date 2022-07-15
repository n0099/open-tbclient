package kotlin.text;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0086\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010J\u001a=\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bI\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\u0087\bø\u0001\u0000¢\u0006\u0002\ba\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000¢\u0006\u0002\bb\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010e\u001a0\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bf\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010h\u001a0\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\f\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006y"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", Constants.EXTRA_CONFIG_LIMIT, "commonPrefixWith", "", ImageViewerConfig.FROM_OTHER, "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", EMABTest.TYPE_STRING, "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", CloudStabilityUBCUtils.KEY_LENGTH, "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", StickerDataChangeType.REPLACE, "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes8.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final String commonPrefixWith(CharSequence commonPrefixWith, CharSequence other, boolean z) {
        Intrinsics.checkNotNullParameter(commonPrefixWith, "$this$commonPrefixWith");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(commonPrefixWith.length(), other.length());
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(commonPrefixWith.charAt(i), other.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (hasSurrogatePairAt(commonPrefixWith, i2) || hasSurrogatePairAt(other, i2)) {
            i--;
        }
        return commonPrefixWith.subSequence(0, i).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    public static final String commonSuffixWith(CharSequence commonSuffixWith, CharSequence other, boolean z) {
        int length;
        Intrinsics.checkNotNullParameter(commonSuffixWith, "$this$commonSuffixWith");
        Intrinsics.checkNotNullParameter(other, "other");
        int length2 = commonSuffixWith.length();
        int min = Math.min(length2, other.length());
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(commonSuffixWith.charAt((length2 - i) - 1), other.charAt((length - i) - 1), z)) {
            i++;
        }
        if (hasSurrogatePairAt(commonSuffixWith, (length2 - i) - 1) || hasSurrogatePairAt(other, (length - i) - 1)) {
            i--;
        }
        return commonSuffixWith.subSequence(length2 - i, length2).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(CharSequence contains, CharSequence other, boolean z) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            if (indexOf$default(contains, (String) other, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt$default(contains, other, 0, contains.length(), z, false, 16, null) >= 0) {
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

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.equals((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean endsWith(CharSequence endsWith, char c, boolean z) {
        Intrinsics.checkNotNullParameter(endsWith, "$this$endsWith");
        return endsWith.length() > 0 && CharsKt__CharKt.equals(endsWith.charAt(getLastIndex(endsWith)), c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence findAnyOf, Collection<String> strings, int i, boolean z) {
        Intrinsics.checkNotNullParameter(findAnyOf, "$this$findAnyOf");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(findAnyOf, strings, i, z, false);
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

    public static final Pair<Integer, String> findLastAnyOf(CharSequence findLastAnyOf, Collection<String> strings, int i, boolean z) {
        Intrinsics.checkNotNullParameter(findLastAnyOf, "$this$findLastAnyOf");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(findLastAnyOf, strings, i, z, true);
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

    public static final IntRange getIndices(CharSequence indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return new IntRange(0, indices.length() - 1);
    }

    public static final int getLastIndex(CharSequence lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return lastIndex.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence hasSurrogatePairAt, int i) {
        Intrinsics.checkNotNullParameter(hasSurrogatePairAt, "$this$hasSurrogatePairAt");
        return i >= 0 && hasSurrogatePairAt.length() + (-2) >= i && Character.isHighSurrogate(hasSurrogatePairAt.charAt(i)) && Character.isLowSurrogate(hasSurrogatePairAt.charAt(i + 1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: C extends java.lang.CharSequence & R */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <C extends CharSequence & R, R> R ifBlank(C c, Function0<? extends R> function0) {
        return StringsKt__StringsJVMKt.isBlank(c) ? function0.invoke() : c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: C extends java.lang.CharSequence & R */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <C extends CharSequence & R, R> R ifEmpty(C c, Function0<? extends R> function0) {
        return c.length() == 0 ? function0.invoke() : c;
    }

    public static final int indexOf(CharSequence indexOf, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        if (!z && (indexOf instanceof String)) {
            return ((String) indexOf).indexOf(c, i);
        }
        return indexOfAny(indexOf, new char[]{c}, i, z);
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

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c, i, z);
    }

    public static final int indexOfAny(CharSequence indexOfAny, char[] chars, int i, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(indexOfAny, "$this$indexOfAny");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (indexOfAny instanceof String)) {
            return ((String) indexOfAny).indexOf(ArraysKt___ArraysKt.single(chars), i);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
        int lastIndex = getLastIndex(indexOfAny);
        if (coerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char charAt = indexOfAny.charAt(coerceAtLeast);
            int length = chars.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (CharsKt__CharKt.equals(chars[i2], charAt, z)) {
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

    public static final CharIterator iterator(final CharSequence iterator) {
        Intrinsics.checkNotNullParameter(iterator, "$this$iterator");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            public int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < iterator.length();
            }

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence = iterator;
                int i = this.index;
                this.index = i + 1;
                return charSequence.charAt(i);
            }
        };
    }

    public static final int lastIndexOf(CharSequence lastIndexOf, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(lastIndexOf, "$this$lastIndexOf");
        if (!z && (lastIndexOf instanceof String)) {
            return ((String) lastIndexOf).lastIndexOf(c, i);
        }
        return lastIndexOfAny(lastIndexOf, new char[]{c}, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOfAny(CharSequence lastIndexOfAny, char[] chars, int i, boolean z) {
        Intrinsics.checkNotNullParameter(lastIndexOfAny, "$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (lastIndexOfAny instanceof String)) {
            return ((String) lastIndexOfAny).lastIndexOf(ArraysKt___ArraysKt.single(chars), i);
        }
        for (int coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, getLastIndex(lastIndexOfAny)); coerceAtMost >= 0; coerceAtMost--) {
            char charAt = lastIndexOfAny.charAt(coerceAtMost);
            int length = chars.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (CharsKt__CharKt.equals(chars[i2], charAt, z)) {
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

    public static final Sequence<String> lineSequence(CharSequence lineSequence) {
        Intrinsics.checkNotNullParameter(lineSequence, "$this$lineSequence");
        return splitToSequence$default(lineSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> lines(CharSequence lines) {
        Intrinsics.checkNotNullParameter(lines, "$this$lines");
        return SequencesKt___SequencesKt.toList(lineSequence(lines));
    }

    @InlineOnly
    public static final boolean matches(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    @InlineOnly
    public static final String orEmpty(String str) {
        return str != null ? str : "";
    }

    public static final CharSequence padEnd(CharSequence padEnd, int i, char c) {
        Intrinsics.checkNotNullParameter(padEnd, "$this$padEnd");
        if (i >= 0) {
            if (i <= padEnd.length()) {
                return padEnd.subSequence(0, padEnd.length());
            }
            StringBuilder sb = new StringBuilder(i);
            sb.append(padEnd);
            int length = i - padEnd.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
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

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = WebvttCueParser.CHAR_SPACE;
        }
        return padEnd(charSequence, i, c);
    }

    public static final CharSequence padStart(CharSequence padStart, int i, char c) {
        Intrinsics.checkNotNullParameter(padStart, "$this$padStart");
        if (i >= 0) {
            if (i <= padStart.length()) {
                return padStart.subSequence(0, padStart.length());
            }
            StringBuilder sb = new StringBuilder(i);
            int length = i - padStart.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(padStart);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = WebvttCueParser.CHAR_SPACE;
        }
        return padStart(charSequence, i, c);
    }

    public static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z));
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

    public static final boolean regionMatchesImpl(CharSequence regionMatchesImpl, int i, CharSequence other, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(regionMatchesImpl, "$this$regionMatchesImpl");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 < 0 || i < 0 || i > regionMatchesImpl.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.equals(regionMatchesImpl.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final CharSequence removePrefix(CharSequence removePrefix, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(removePrefix, "$this$removePrefix");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (startsWith$default(removePrefix, prefix, false, 2, (Object) null)) {
            return removePrefix.subSequence(prefix.length(), removePrefix.length());
        }
        return removePrefix.subSequence(0, removePrefix.length());
    }

    public static final CharSequence removeRange(CharSequence removeRange, int i, int i2) {
        Intrinsics.checkNotNullParameter(removeRange, "$this$removeRange");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        } else if (i2 == i) {
            return removeRange.subSequence(0, removeRange.length());
        } else {
            StringBuilder sb = new StringBuilder(removeRange.length() - (i2 - i));
            sb.append(removeRange, 0, i);
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            sb.append(removeRange, i2, removeRange.length());
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
    }

    public static final CharSequence removeSuffix(CharSequence removeSuffix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(removeSuffix, "$this$removeSuffix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (endsWith$default(removeSuffix, suffix, false, 2, (Object) null)) {
            return removeSuffix.subSequence(0, removeSuffix.length() - suffix.length());
        }
        return removeSuffix.subSequence(0, removeSuffix.length());
    }

    public static final CharSequence removeSurrounding(CharSequence removeSurrounding, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (removeSurrounding.length() >= prefix.length() + suffix.length() && startsWith$default(removeSurrounding, prefix, false, 2, (Object) null) && endsWith$default(removeSurrounding, suffix, false, 2, (Object) null)) {
            return removeSurrounding.subSequence(prefix.length(), removeSurrounding.length() - suffix.length());
        }
        return removeSurrounding.subSequence(0, removeSurrounding.length());
    }

    @InlineOnly
    public static final String replace(CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    public static final String replaceAfter(String replaceAfter, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceAfter, "$this$replaceAfter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceAfter, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfter, indexOf$default + 1, replaceAfter.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c, str2, str3);
    }

    public static final String replaceAfterLast(String replaceAfterLast, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceAfterLast, "$this$replaceAfterLast");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceAfterLast, delimiter, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfterLast, lastIndexOf$default + delimiter.length(), replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    public static final String replaceBefore(String replaceBefore, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceBefore, "$this$replaceBefore");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceBefore, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBefore, 0, indexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c, str2, str3);
    }

    public static final String replaceBeforeLast(String replaceBeforeLast, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceBeforeLast, "$this$replaceBeforeLast");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceBeforeLast, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBeforeLast, 0, lastIndexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c, str2, str3);
    }

    @InlineOnly
    public static final String replaceFirst(CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String replaceFirstCharWithChar(String str, Function1<? super Character, Character> function1) {
        if (str.length() > 0) {
            char charValue = function1.invoke(Character.valueOf(str.charAt(0))).charValue();
            if (str != null) {
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return String.valueOf(charValue) + substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return str;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String replaceFirstCharWithCharSequence(String str, Function1<? super Character, ? extends CharSequence> function1) {
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(function1.invoke(Character.valueOf(str.charAt(0))).toString());
            if (str != null) {
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                return sb.toString();
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return str;
    }

    public static final CharSequence replaceRange(CharSequence replaceRange, int i, int i2, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(replaceRange, "$this$replaceRange");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(replaceRange, 0, i);
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(replaceRange, i2, replaceRange.length());
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List<String> split(CharSequence split, String[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(split, "$this$split");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(split, str, z, i);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(split, delimiters, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(split, intRange));
        }
        return arrayList;
    }

    public static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        requireNonNegativeLimit(i);
        int i2 = 0;
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

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    public static final Sequence<String> splitToSequence(CharSequence splitToSequence, String[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(splitToSequence, "$this$splitToSequence");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(splitToSequence, delimiters, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(splitToSequence));
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

    public static final boolean startsWith(CharSequence startsWith, char c, boolean z) {
        Intrinsics.checkNotNullParameter(startsWith, "$this$startsWith");
        return startsWith.length() > 0 && CharsKt__CharKt.equals(startsWith.charAt(0), c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    public static final CharSequence subSequence(CharSequence subSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(subSequence, "$this$subSequence");
        Intrinsics.checkNotNullParameter(range, "range");
        return subSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final String substring(String substring, IntRange range) {
        Intrinsics.checkNotNullParameter(substring, "$this$substring");
        Intrinsics.checkNotNullParameter(range, "range");
        String substring2 = substring.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2;
    }

    public static /* synthetic */ String substring$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return charSequence.subSequence(i, i2).toString();
    }

    public static final String substringAfter(String substringAfter, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringAfter, "$this$substringAfter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringAfter, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(indexOf$default + 1, substringAfter.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    public static final String substringAfterLast(String substringAfterLast, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringAfterLast, "$this$substringAfterLast");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringAfterLast, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(lastIndexOf$default + 1, substringAfterLast.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c, str2);
    }

    public static final String substringBefore(String substringBefore, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringBefore, "$this$substringBefore");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringBefore, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    public static final String substringBeforeLast(String substringBeforeLast, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringBeforeLast, "$this$substringBeforeLast");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringBeforeLast, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean toBooleanStrict(String toBooleanStrict) {
        Intrinsics.checkNotNullParameter(toBooleanStrict, "$this$toBooleanStrict");
        int hashCode = toBooleanStrict.hashCode();
        if (hashCode != 3569038) {
            if (hashCode == 97196323 && toBooleanStrict.equals("false")) {
                return false;
            }
        } else if (toBooleanStrict.equals("true")) {
            return true;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + toBooleanStrict);
    }

    @SinceKotlin(version = "1.5")
    public static final Boolean toBooleanStrictOrNull(String toBooleanStrictOrNull) {
        Intrinsics.checkNotNullParameter(toBooleanStrictOrNull, "$this$toBooleanStrictOrNull");
        int hashCode = toBooleanStrictOrNull.hashCode();
        if (hashCode != 3569038) {
            if (hashCode == 97196323 && toBooleanStrictOrNull.equals("false")) {
                return Boolean.FALSE;
            }
        } else if (toBooleanStrictOrNull.equals("true")) {
            return Boolean.TRUE;
        }
        return null;
    }

    public static final CharSequence trim(CharSequence trim, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(trim, "$this$trim");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i : length))).booleanValue();
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
        return trim.subSequence(i, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence trimEnd, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(trimEnd, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue());
        return trimEnd.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence trimStart, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(trimStart, "$this$trimStart");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(trimStart.charAt(i))).booleanValue()) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static final boolean endsWith(CharSequence endsWith, CharSequence suffix, boolean z) {
        Intrinsics.checkNotNullParameter(endsWith, "$this$endsWith");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!z && (endsWith instanceof String) && (suffix instanceof String)) {
            return StringsKt__StringsJVMKt.endsWith$default((String) endsWith, (String) suffix, false, 2, null);
        }
        return regionMatchesImpl(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), z);
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

    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = WebvttCueParser.CHAR_SPACE;
        }
        return padEnd(str, i, c);
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = WebvttCueParser.CHAR_SPACE;
        }
        return padStart(str, i, c);
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

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c, str2, str3);
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

    public static final Sequence<String> splitToSequence(CharSequence splitToSequence, char[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(splitToSequence, "$this$splitToSequence");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(splitToSequence, delimiters, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$2(splitToSequence));
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

    public static final boolean startsWith(CharSequence startsWith, CharSequence prefix, boolean z) {
        Intrinsics.checkNotNullParameter(startsWith, "$this$startsWith");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z && (startsWith instanceof String) && (prefix instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) startsWith, (String) prefix, false, 2, null);
        }
        return regionMatchesImpl(startsWith, 0, prefix, 0, prefix.length(), z);
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
        requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(ArraysKt___ArraysJvmKt.asList(strArr), z));
    }

    public static final String replaceAfter(String replaceAfter, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceAfter, "$this$replaceAfter");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceAfter, delimiter, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfter, indexOf$default + delimiter.length(), replaceAfter.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceAfterLast(String replaceAfterLast, char c, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceAfterLast, "$this$replaceAfterLast");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceAfterLast, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfterLast, lastIndexOf$default + 1, replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceBefore(String replaceBefore, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceBefore, "$this$replaceBefore");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceBefore, delimiter, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBefore, 0, indexOf$default, (CharSequence) replacement).toString();
    }

    public static final String replaceBeforeLast(String replaceBeforeLast, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(replaceBeforeLast, "$this$replaceBeforeLast");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceBeforeLast, delimiter, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBeforeLast, 0, lastIndexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final Sequence<String> splitToSequence(CharSequence charSequence, Regex regex, int i) {
        return regex.splitToSequence(charSequence, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i, z);
    }

    public static final String substring(CharSequence substring, IntRange range) {
        Intrinsics.checkNotNullParameter(substring, "$this$substring");
        Intrinsics.checkNotNullParameter(range, "range");
        return substring.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substringAfter(String substringAfter, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringAfter, "$this$substringAfter");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringAfter, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(indexOf$default + delimiter.length(), substringAfter.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringAfterLast(String substringAfterLast, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringAfterLast, "$this$substringAfterLast");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringAfterLast, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(lastIndexOf$default + delimiter.length(), substringAfterLast.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBefore(String substringBefore, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringBefore, "$this$substringBefore");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringBefore, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringBeforeLast(String substringBeforeLast, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(substringBeforeLast, "$this$substringBeforeLast");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringBeforeLast, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean contains(CharSequence contains, char c, boolean z) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return indexOf$default(contains, c, 0, z, 2, (Object) null) >= 0;
    }

    public static final int indexOf(CharSequence indexOf, String string, int i, boolean z) {
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z && (indexOf instanceof String)) {
            return ((String) indexOf).indexOf(string, i);
        }
        return indexOf$StringsKt__StringsKt$default(indexOf, string, i, indexOf.length(), z, false, 16, null);
    }

    public static final int lastIndexOf(CharSequence lastIndexOf, String string, int i, boolean z) {
        Intrinsics.checkNotNullParameter(lastIndexOf, "$this$lastIndexOf");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z && (lastIndexOf instanceof String)) {
            return ((String) lastIndexOf).lastIndexOf(string, i);
        }
        return indexOf$StringsKt__StringsKt(lastIndexOf, string, i, 0, z, true);
    }

    public static final String removePrefix(String removePrefix, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(removePrefix, "$this$removePrefix");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (startsWith$default((CharSequence) removePrefix, prefix, false, 2, (Object) null)) {
            String substring = removePrefix.substring(prefix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return removePrefix;
    }

    public static final String removeSuffix(String removeSuffix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(removeSuffix, "$this$removeSuffix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (endsWith$default((CharSequence) removeSuffix, suffix, false, 2, (Object) null)) {
            String substring = removeSuffix.substring(0, removeSuffix.length() - suffix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return removeSuffix;
    }

    public static final String removeSurrounding(String removeSurrounding, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (removeSurrounding.length() >= prefix.length() + suffix.length() && startsWith$default((CharSequence) removeSurrounding, prefix, false, 2, (Object) null) && endsWith$default((CharSequence) removeSurrounding, suffix, false, 2, (Object) null)) {
            String substring = removeSurrounding.substring(prefix.length(), removeSurrounding.length() - suffix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return removeSurrounding;
    }

    @InlineOnly
    public static final String trim(String str) {
        if (str != null) {
            return trim((CharSequence) str).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final String trimEnd(String str) {
        if (str != null) {
            return trimEnd((CharSequence) str).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final String trimStart(String str) {
        if (str != null) {
            return trimStart((CharSequence) str).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final boolean contains(CharSequence contains, Regex regex) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return regex.containsMatchIn(contains);
    }

    public static final boolean startsWith(CharSequence startsWith, CharSequence prefix, int i, boolean z) {
        Intrinsics.checkNotNullParameter(startsWith, "$this$startsWith");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z && (startsWith instanceof String) && (prefix instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) startsWith, (String) prefix, i, false, 4, null);
        }
        return regionMatchesImpl(startsWith, i, prefix, 0, prefix.length(), z);
    }

    public static final String trim(String trim, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(trim, "$this$trim");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i : length))).booleanValue();
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
        return trim.subSequence(i, length + 1).toString();
    }

    public static final String trimEnd(String trimEnd, Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(trimEnd, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            } else if (!predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue()) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    public static final String trimStart(String trimStart, Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(trimStart, "$this$trimStart");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = trimStart.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            } else if (!predicate.invoke(Character.valueOf(trimStart.charAt(i))).booleanValue()) {
                charSequence = trimStart.subSequence(i, trimStart.length());
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
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence removeSurrounding(CharSequence removeSurrounding, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(removeSurrounding, delimiter, delimiter);
    }

    @InlineOnly
    public static final String replaceRange(String str, int i, int i2, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, i, i2, charSequence).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence removeRange(CharSequence removeRange, IntRange range) {
        Intrinsics.checkNotNullParameter(removeRange, "$this$removeRange");
        Intrinsics.checkNotNullParameter(range, "range");
        return removeRange(removeRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final String removeSurrounding(String removeSurrounding, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(removeSurrounding, delimiter, delimiter);
    }

    public static final CharSequence replaceRange(CharSequence replaceRange, IntRange range, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(replaceRange, "$this$replaceRange");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return replaceRange(replaceRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    public static final int indexOfAny(CharSequence indexOfAny, Collection<String> strings, int i, boolean z) {
        Integer first;
        Intrinsics.checkNotNullParameter(indexOfAny, "$this$indexOfAny");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(indexOfAny, strings, i, z, false);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int lastIndexOfAny(CharSequence lastIndexOfAny, Collection<String> strings, int i, boolean z) {
        Integer first;
        Intrinsics.checkNotNullParameter(lastIndexOfAny, "$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(lastIndexOfAny, strings, i, z, true);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final String padEnd(String padEnd, int i, char c) {
        Intrinsics.checkNotNullParameter(padEnd, "$this$padEnd");
        return padEnd((CharSequence) padEnd, i, c).toString();
    }

    public static final String padStart(String padStart, int i, char c) {
        Intrinsics.checkNotNullParameter(padStart, "$this$padStart");
        return padStart((CharSequence) padStart, i, c).toString();
    }

    @InlineOnly
    public static final String removeRange(String str, IntRange intRange) {
        if (str != null) {
            return removeRange((CharSequence) str, intRange).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    public static final String replaceRange(String str, IntRange intRange, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, intRange, charSequence).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence trim(CharSequence trim, char... chars) {
        Intrinsics.checkNotNullParameter(trim, "$this$trim");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(chars, trim.charAt(!z ? i : length));
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
        return trim.subSequence(i, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence trimEnd, char... chars) {
        Intrinsics.checkNotNullParameter(trimEnd, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (ArraysKt___ArraysKt.contains(chars, trimEnd.charAt(length)));
        return trimEnd.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence trimStart, char... chars) {
        Intrinsics.checkNotNullParameter(trimStart, "$this$trimStart");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt___ArraysKt.contains(chars, trimStart.charAt(i))) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    public static final List<String> split(CharSequence split, char[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(split, "$this$split");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt(split, String.valueOf(delimiters[0]), z, i);
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(split, delimiters, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(split, intRange));
        }
        return arrayList;
    }

    public static final String trim(String trim, char... chars) {
        Intrinsics.checkNotNullParameter(trim, "$this$trim");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(chars, trim.charAt(!z ? i : length));
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
        return trim.subSequence(i, length + 1).toString();
    }

    public static final String trimEnd(String trimEnd, char... chars) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(trimEnd, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            } else if (!ArraysKt___ArraysKt.contains(chars, trimEnd.charAt(length))) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    public static final String trimStart(String trimStart, char... chars) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(trimStart, "$this$trimStart");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = trimStart.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            } else if (!ArraysKt___ArraysKt.contains(chars, trimStart.charAt(i))) {
                charSequence = trimStart.subSequence(i, trimStart.length());
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

    public static final CharSequence trim(CharSequence trim) {
        Intrinsics.checkNotNullParameter(trim, "$this$trim");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = CharsKt__CharJVMKt.isWhitespace(trim.charAt(!z ? i : length));
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
        return trim.subSequence(i, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence trimEnd) {
        Intrinsics.checkNotNullParameter(trimEnd, "$this$trimEnd");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (CharsKt__CharJVMKt.isWhitespace(trimEnd.charAt(length)));
        return trimEnd.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence trimStart) {
        Intrinsics.checkNotNullParameter(trimStart, "$this$trimStart");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt__CharJVMKt.isWhitespace(trimStart.charAt(i))) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }
}
