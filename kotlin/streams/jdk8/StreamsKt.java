package kotlin.streams.jdk8;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\n\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\fH\u0007¢\u0006\u0004\b\u0003\u0010\r\u001a%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010*\u00020\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010*\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0013\u001a\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010*\u00020\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0014\u001a%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0015¨\u0006\u0016"}, d2 = {"Ljava/util/stream/DoubleStream;", "Lkotlin/sequences/Sequence;", "", "asSequence", "(Ljava/util/stream/DoubleStream;)Lkotlin/sequences/Sequence;", "Ljava/util/stream/IntStream;", "", "(Ljava/util/stream/IntStream;)Lkotlin/sequences/Sequence;", "Ljava/util/stream/LongStream;", "", "(Ljava/util/stream/LongStream;)Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/stream/Stream;", "(Ljava/util/stream/Stream;)Lkotlin/sequences/Sequence;", "asStream", "(Lkotlin/sequences/Sequence;)Ljava/util/stream/Stream;", "", "toList", "(Ljava/util/stream/DoubleStream;)Ljava/util/List;", "(Ljava/util/stream/IntStream;)Ljava/util/List;", "(Ljava/util/stream/LongStream;)Ljava/util/List;", "(Ljava/util/stream/Stream;)Ljava/util/List;", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "StreamsKt")
/* loaded from: classes10.dex */
public final class StreamsKt {
    @SinceKotlin(version = "1.2")
    public static final Sequence<Double> asSequence(final DoubleStream asSequence) {
        Intrinsics.checkNotNullParameter(asSequence, "$this$asSequence");
        return new Sequence<Double>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$4
            @Override // kotlin.sequences.Sequence
            public Iterator<Double> iterator() {
                PrimitiveIterator.OfDouble it = asSequence.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Stream<T> asStream(final Sequence<? extends T> asStream) {
        Intrinsics.checkNotNullParameter(asStream, "$this$asStream");
        Stream<T> stream = StreamSupport.stream(new Supplier<Spliterator<T>>() { // from class: kotlin.streams.jdk8.StreamsKt$asStream$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.function.Supplier
            public final Spliterator<T> get() {
                return Spliterators.spliteratorUnknownSize(Sequence.this.iterator(), 16);
            }
        }, 16, false);
        Intrinsics.checkNotNullExpressionValue(stream, "StreamSupport.stream({ S…literator.ORDERED, false)");
        return stream;
    }

    @SinceKotlin(version = "1.2")
    public static final List<Double> toList(DoubleStream toList) {
        Intrinsics.checkNotNullParameter(toList, "$this$toList");
        double[] array = toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Integer> asSequence(final IntStream asSequence) {
        Intrinsics.checkNotNullParameter(asSequence, "$this$asSequence");
        return new Sequence<Integer>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$2
            @Override // kotlin.sequences.Sequence
            public Iterator<Integer> iterator() {
                PrimitiveIterator.OfInt it = asSequence.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    public static final List<Integer> toList(IntStream toList) {
        Intrinsics.checkNotNullParameter(toList, "$this$toList");
        int[] array = toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Long> asSequence(final LongStream asSequence) {
        Intrinsics.checkNotNullParameter(asSequence, "$this$asSequence");
        return new Sequence<Long>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$3
            @Override // kotlin.sequences.Sequence
            public Iterator<Long> iterator() {
                PrimitiveIterator.OfLong it = asSequence.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    public static final List<Long> toList(LongStream toList) {
        Intrinsics.checkNotNullParameter(toList, "$this$toList");
        long[] array = toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Sequence<T> asSequence(final Stream<T> asSequence) {
        Intrinsics.checkNotNullParameter(asSequence, "$this$asSequence");
        return new Sequence<T>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                Iterator<T> it = asSequence.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<T> toList(Stream<T> toList) {
        Intrinsics.checkNotNullParameter(toList, "$this$toList");
        Object collect = toList.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(collect, "collect(Collectors.toList<T>())");
        return (List) collect;
    }
}
