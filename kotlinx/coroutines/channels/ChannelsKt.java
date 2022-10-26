package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectClause1;
@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt"}, d2 = {}, k = 4, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object all(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.all(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object any(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.any(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object associate(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associate(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object associateBy(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateBy(receiveChannel, function1, continuation);
    }

    public static final Object consumeEach(BroadcastChannel broadcastChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(broadcastChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object consumeEachIndexed(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.consumeEachIndexed(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object count(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.count(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel distinctBy(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel drop(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object elementAt(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.elementAt(receiveChannel, i, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object elementAtOrNull(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrNull(receiveChannel, i, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel filter(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt__Channels_commonKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterNotNullTo(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo(receiveChannel, collection, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object find(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.find(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object findLast(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.findLast(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object first(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.first(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object firstOrNull(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object groupBy(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object indexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.indexOf(receiveChannel, obj, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object indexOfFirst(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.indexOfFirst(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object indexOfLast(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.indexOfLast(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object last(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.last(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object lastIndexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.lastIndexOf(receiveChannel, obj, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object lastOrNull(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel map(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.map(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel mapIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt__Channels_commonKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object maxBy(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.maxBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object maxWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.maxWith(receiveChannel, comparator, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object minBy(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.minBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object minWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.minWith(receiveChannel, comparator, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object none(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.none(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object partition(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.partition(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object reduce(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.reduce(receiveChannel, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object reduceIndexed(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.reduceIndexed(receiveChannel, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object single(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.single(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object singleOrNull(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object sumBy(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.sumBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object sumByDouble(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.sumByDouble(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel take(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object toChannel(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toChannel(receiveChannel, sendChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object toCollection(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toCollection(receiveChannel, collection, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object toMap(ReceiveChannel receiveChannel, Map map, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toMap(receiveChannel, map, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object any(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.any(receiveChannel, continuation);
    }

    public static final void cancelConsumed(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel, th);
    }

    public static final Object consume(BroadcastChannel broadcastChannel, Function1 function1) {
        return ChannelsKt__Channels_commonKt.consume(broadcastChannel, function1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object count(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.count(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object first(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.first(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object firstOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object last(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.last(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object lastOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object none(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.none(receiveChannel, continuation);
    }

    public static final Object receiveOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.receiveOrNull(receiveChannel, continuation);
    }

    public static final void sendBlocking(SendChannel sendChannel, Object obj) {
        ChannelsKt__ChannelsKt.sendBlocking(sendChannel, obj);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object single(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.single(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object singleOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull(receiveChannel, continuation);
    }

    public static final Object toList(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toList(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object toMap(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toMap(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object toMutableList(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toMutableList(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object toMutableSet(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toMutableSet(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object toSet(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.toSet(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.withIndex(receiveChannel, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel zip(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2) {
        return ChannelsKt__Channels_commonKt.zip(receiveChannel, receiveChannel2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object associateBy(ReceiveChannel receiveChannel, Function1 function1, Function1 function12, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateBy(receiveChannel, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object associateByTo(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo(receiveChannel, map, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object associateTo(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateTo(receiveChannel, map, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object elementAtOrElse(ReceiveChannel receiveChannel, int i, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrElse(receiveChannel, i, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterIndexedTo(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo(receiveChannel, collection, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterNotTo(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo(receiveChannel, collection, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterTo(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterTo(receiveChannel, collection, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object fold(ReceiveChannel receiveChannel, Object obj, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.fold(receiveChannel, obj, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object foldIndexed(ReceiveChannel receiveChannel, Object obj, Function3 function3, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.foldIndexed(receiveChannel, obj, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object groupBy(ReceiveChannel receiveChannel, Function1 function1, Function1 function12, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupBy(receiveChannel, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object groupByTo(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo(receiveChannel, map, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapIndexedNotNullTo(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(receiveChannel, collection, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapIndexedTo(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo(receiveChannel, collection, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapNotNullTo(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo(receiveChannel, collection, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapTo(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapTo(receiveChannel, collection, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel zip(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__Channels_commonKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object associateByTo(ReceiveChannel receiveChannel, Map map, Function1 function1, Function1 function12, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo(receiveChannel, map, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object groupByTo(ReceiveChannel receiveChannel, Map map, Function1 function1, Function1 function12, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo(receiveChannel, map, function1, function12, continuation);
    }

    public static final Object consume(ReceiveChannel receiveChannel, Function1 function1) {
        return ChannelsKt__Channels_commonKt.consume(receiveChannel, function1);
    }

    public static final Object consumeEach(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo(receiveChannel, sendChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Function1 consumes(ReceiveChannel receiveChannel) {
        return ChannelsKt__Channels_commonKt.consumes(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Function1 consumesAll(ReceiveChannel... receiveChannelArr) {
        return ChannelsKt__Channels_commonKt.consumesAll(receiveChannelArr);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel distinct(ReceiveChannel receiveChannel) {
        return ChannelsKt__Channels_commonKt.distinct(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel filterNotNull(ReceiveChannel receiveChannel) {
        return ChannelsKt__Channels_commonKt.filterNotNull(receiveChannel);
    }

    public static final SelectClause1 onReceiveOrNull(ReceiveChannel receiveChannel) {
        return ChannelsKt__Channels_commonKt.onReceiveOrNull(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final ReceiveChannel requireNoNulls(ReceiveChannel receiveChannel) {
        return ChannelsKt__Channels_commonKt.requireNoNulls(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterIndexedTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo(receiveChannel, sendChannel, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterNotTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo(receiveChannel, sendChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object filterTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterTo(receiveChannel, sendChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapIndexedNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(receiveChannel, sendChannel, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapIndexedTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo(receiveChannel, sendChannel, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo(receiveChannel, sendChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Object mapTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapTo(receiveChannel, sendChannel, function1, continuation);
    }
}
