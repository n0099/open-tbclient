package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, d2 = {}, k = 4, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowKt {
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    public static /* synthetic */ void DEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    public static final Flow asFlow(Iterable iterable) {
        return FlowKt__BuildersKt.asFlow(iterable);
    }

    public static final Flow callbackFlow(Function2 function2) {
        return FlowKt__BuildersKt.callbackFlow(function2);
    }

    public static final Flow channelFlow(Function2 function2) {
        return FlowKt__BuildersKt.channelFlow(function2);
    }

    public static final Flow conflate(Flow flow) {
        return FlowKt__ContextKt.conflate(flow);
    }

    public static final Flow consumeAsFlow(ReceiveChannel receiveChannel) {
        return FlowKt__ChannelsKt.consumeAsFlow(receiveChannel);
    }

    public static final Flow distinctUntilChanged(Flow flow) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow);
    }

    public static final Flow filterNotNull(Flow flow) {
        return FlowKt__TransformKt.filterNotNull(flow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final Flow flatten(Flow flow) {
        return FlowKt__MigrationKt.flatten(flow);
    }

    public static final Flow flattenConcat(Flow flow) {
        return FlowKt__MergeKt.flattenConcat(flow);
    }

    public static final Flow flow(Function2 function2) {
        return FlowKt__BuildersKt.flow(function2);
    }

    public static final Flow flowOf(Object obj) {
        return FlowKt__BuildersKt.flowOf(obj);
    }

    public static final Flow merge(Iterable iterable) {
        return FlowKt__MergeKt.merge(iterable);
    }

    public static final Flow receiveAsFlow(ReceiveChannel receiveChannel) {
        return FlowKt__ChannelsKt.receiveAsFlow(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final void subscribe(Flow flow) {
        FlowKt__MigrationKt.subscribe(flow);
    }

    public static final Flow withIndex(Flow flow) {
        return FlowKt__TransformKt.withIndex(flow);
    }

    public static final Flow asFlow(Iterator it) {
        return FlowKt__BuildersKt.asFlow(it);
    }

    public static final Flow flowOf(Object... objArr) {
        return FlowKt__BuildersKt.flowOf(objArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final Flow merge(Flow flow) {
        return FlowKt__MigrationKt.merge(flow);
    }

    public static final Flow asFlow(Function0 function0) {
        return FlowKt__BuildersKt.asFlow(function0);
    }

    public static final Flow merge(Flow... flowArr) {
        return FlowKt__MergeKt.merge(flowArr);
    }

    public static final Flow asFlow(Function1 function1) {
        return FlowKt__BuildersKt.asFlow(function1);
    }

    public static final Flow asFlow(IntRange intRange) {
        return FlowKt__BuildersKt.asFlow(intRange);
    }

    public static final Flow asFlow(LongRange longRange) {
        return FlowKt__BuildersKt.asFlow(longRange);
    }

    public static final Flow asFlow(Sequence sequence) {
        return FlowKt__BuildersKt.asFlow(sequence);
    }

    public static final Flow asFlow(BroadcastChannel broadcastChannel) {
        return FlowKt__ChannelsKt.asFlow(broadcastChannel);
    }

    public static final Flow asFlow(int[] iArr) {
        return FlowKt__BuildersKt.asFlow(iArr);
    }

    public static final Flow asFlow(long[] jArr) {
        return FlowKt__BuildersKt.asFlow(jArr);
    }

    public static final Flow asFlow(Object[] objArr) {
        return FlowKt__BuildersKt.asFlow(objArr);
    }

    public static final BroadcastChannel broadcastIn(Flow flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart) {
        return FlowKt__ChannelsKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    public static final Object catchImpl(Flow flow, FlowCollector flowCollector, Continuation continuation) {
        return FlowKt__ErrorsKt.catchImpl(flow, flowCollector, continuation);
    }

    public static final Object collect(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__CollectKt.collect(flow, function2, continuation);
    }

    public static final Object collectIndexed(Flow flow, Function3 function3, Continuation continuation) {
        return FlowKt__CollectKt.collectIndexed(flow, function3, continuation);
    }

    public static final Object collectLatest(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__CollectKt.collectLatest(flow, function2, continuation);
    }

    public static final Flow combine(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt__ZipKt.combine(flow, flow2, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    public static final Flow combineLatest(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, function3);
    }

    public static final Flow combineTransform(Flow flow, Flow flow2, Function4 function4) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, function4);
    }

    public static final Object count(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__CountKt.count(flow, function2, continuation);
    }

    public static final Object emitAll(FlowCollector flowCollector, ReceiveChannel receiveChannel, Continuation continuation) {
        return FlowKt__ChannelsKt.emitAll(flowCollector, receiveChannel, continuation);
    }

    public static final Object first(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__ReduceKt.first(flow, function2, continuation);
    }

    public static final Object firstOrNull(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__ReduceKt.firstOrNull(flow, function2, continuation);
    }

    public static final ReceiveChannel fixedPeriodTicker(CoroutineScope coroutineScope, long j, long j2) {
        return FlowKt__DelayKt.fixedPeriodTicker(coroutineScope, j, j2);
    }

    public static final Flow flatMapMerge(Flow flow, int i, Function2 function2) {
        return FlowKt__MergeKt.flatMapMerge(flow, i, function2);
    }

    public static final Flow flowCombine(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt__ZipKt.flowCombine(flow, flow2, function3);
    }

    public static final Flow flowCombineTransform(Flow flow, Flow flow2, Function4 function4) {
        return FlowKt__ZipKt.flowCombineTransform(flow, flow2, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    public static final Flow onErrorCollect(Flow flow, Flow flow2, Function1 function1) {
        return FlowKt__ErrorsKt.onErrorCollect(flow, flow2, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final Flow onErrorReturn(Flow flow, Object obj, Function1 function1) {
        return FlowKt__MigrationKt.onErrorReturn(flow, obj, function1);
    }

    public static final Object reduce(Flow flow, Function3 function3, Continuation continuation) {
        return FlowKt__ReduceKt.reduce(flow, function3, continuation);
    }

    public static final Flow scan(Flow flow, Object obj, Function3 function3) {
        return FlowKt__TransformKt.scan(flow, obj, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    public static final Flow scanFold(Flow flow, Object obj, Function3 function3) {
        return FlowKt__MigrationKt.scanFold(flow, obj, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final void subscribe(Flow flow, Function2 function2, Function2 function22) {
        FlowKt__MigrationKt.subscribe(flow, function2, function22);
    }

    public static final Object toCollection(Flow flow, Collection collection, Continuation continuation) {
        return FlowKt__CollectionKt.toCollection(flow, collection, continuation);
    }

    public static final Object toList(Flow flow, List list, Continuation continuation) {
        return FlowKt__CollectionKt.toList(flow, list, continuation);
    }

    public static final Object toSet(Flow flow, Set set, Continuation continuation) {
        return FlowKt__CollectionKt.toSet(flow, set, continuation);
    }

    public static final Flow zip(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt__ZipKt.zip(flow, flow2, function3);
    }

    public static final Flow combine(Flow flow, Flow flow2, Flow flow3, Flow flow4, Function5 function5) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, function5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final Flow combineLatest(Flow flow, Flow flow2, Flow flow3, Flow flow4, Function5 function5) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, function5);
    }

    public static final Flow combineTransform(Flow flow, Flow flow2, Flow flow3, Flow flow4, Function6 function6) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, function6);
    }

    public static final Flow buffer(Flow flow, int i) {
        return FlowKt__ContextKt.buffer(flow, i);
    }

    /* renamed from: catch  reason: not valid java name */
    public static final Flow m2098catch(Flow flow, Function3 function3) {
        return FlowKt__ErrorsKt.m2103catch(flow, function3);
    }

    public static final Object collect(Flow flow, Continuation continuation) {
        return FlowKt__CollectKt.collect(flow, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    public static final Flow compose(Flow flow, Function1 function1) {
        return FlowKt__MigrationKt.compose(flow, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final Flow concatMap(Flow flow, Function1 function1) {
        return FlowKt__MigrationKt.concatMap(flow, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    public static final Flow concatWith(Flow flow, Object obj) {
        return FlowKt__MigrationKt.concatWith(flow, obj);
    }

    public static final Object count(Flow flow, Continuation continuation) {
        return FlowKt__CountKt.count(flow, continuation);
    }

    public static final Flow debounce(Flow flow, long j) {
        return FlowKt__DelayKt.debounce(flow, j);
    }

    /* renamed from: debounce-8GFy2Ro  reason: not valid java name */
    public static final Flow m2099debounce8GFy2Ro(Flow flow, double d) {
        return FlowKt__DelayKt.m2101debounce8GFy2Ro(flow, d);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final Flow delayEach(Flow flow, long j) {
        return FlowKt__MigrationKt.delayEach(flow, j);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final Flow delayFlow(Flow flow, long j) {
        return FlowKt__MigrationKt.delayFlow(flow, j);
    }

    public static final Flow distinctUntilChanged(Flow flow, Function2 function2) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow, function2);
    }

    public static final Flow distinctUntilChangedBy(Flow flow, Function1 function1) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(flow, function1);
    }

    public static final Flow drop(Flow flow, int i) {
        return FlowKt__LimitKt.drop(flow, i);
    }

    public static final Flow dropWhile(Flow flow, Function2 function2) {
        return FlowKt__LimitKt.dropWhile(flow, function2);
    }

    public static final Flow filter(Flow flow, Function2 function2) {
        return FlowKt__TransformKt.filter(flow, function2);
    }

    public static final Flow filterNot(Flow flow, Function2 function2) {
        return FlowKt__TransformKt.filterNot(flow, function2);
    }

    public static final Object first(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.first(flow, continuation);
    }

    public static final Object firstOrNull(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.firstOrNull(flow, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is named flatMapConcat", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final Flow flatMap(Flow flow, Function2 function2) {
        return FlowKt__MigrationKt.flatMap(flow, function2);
    }

    public static final Flow flatMapConcat(Flow flow, Function2 function2) {
        return FlowKt__MergeKt.flatMapConcat(flow, function2);
    }

    public static final Flow flatMapLatest(Flow flow, Function2 function2) {
        return FlowKt__MergeKt.flatMapLatest(flow, function2);
    }

    public static final Flow flattenMerge(Flow flow, int i) {
        return FlowKt__MergeKt.flattenMerge(flow, i);
    }

    public static final Flow flowOn(Flow flow, CoroutineContext coroutineContext) {
        return FlowKt__ContextKt.flowOn(flow, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    public static final Flow flowViaChannel(int i, Function2 function2) {
        return FlowKt__BuildersKt.flowViaChannel(i, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    public static final void forEach(Flow flow, Function2 function2) {
        FlowKt__MigrationKt.forEach(flow, function2);
    }

    public static final Job launchIn(Flow flow, CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.launchIn(flow, coroutineScope);
    }

    public static final Flow map(Flow flow, Function2 function2) {
        return FlowKt__TransformKt.map(flow, function2);
    }

    public static final Flow mapLatest(Flow flow, Function2 function2) {
        return FlowKt__MergeKt.mapLatest(flow, function2);
    }

    public static final Flow mapNotNull(Flow flow, Function2 function2) {
        return FlowKt__TransformKt.mapNotNull(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final Flow observeOn(Flow flow, CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.observeOn(flow, coroutineContext);
    }

    public static final Flow onEach(Flow flow, Function2 function2) {
        return FlowKt__TransformKt.onEach(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final Flow onErrorResume(Flow flow, Flow flow2) {
        return FlowKt__MigrationKt.onErrorResume(flow, flow2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final Flow onErrorResumeNext(Flow flow, Flow flow2) {
        return FlowKt__MigrationKt.onErrorResumeNext(flow, flow2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    public static final Flow onErrorReturn(Flow flow, Object obj) {
        return FlowKt__MigrationKt.onErrorReturn(flow, obj);
    }

    public static final Flow onStart(Flow flow, Function2 function2) {
        return FlowKt__EmittersKt.onStart(flow, function2);
    }

    public static final ReceiveChannel produceIn(Flow flow, CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.produceIn(flow, coroutineScope);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final Flow publishOn(Flow flow, CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.publishOn(flow, coroutineContext);
    }

    public static final Flow retryWhen(Flow flow, Function4 function4) {
        return FlowKt__ErrorsKt.retryWhen(flow, function4);
    }

    public static final Flow sample(Flow flow, long j) {
        return FlowKt__DelayKt.sample(flow, j);
    }

    /* renamed from: sample-8GFy2Ro  reason: not valid java name */
    public static final Flow m2100sample8GFy2Ro(Flow flow, double d) {
        return FlowKt__DelayKt.m2102sample8GFy2Ro(flow, d);
    }

    public static final Flow scanReduce(Flow flow, Function3 function3) {
        return FlowKt__TransformKt.scanReduce(flow, function3);
    }

    public static final Object single(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.single(flow, continuation);
    }

    public static final Object singleOrNull(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.singleOrNull(flow, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    public static final Flow skip(Flow flow, int i) {
        return FlowKt__MigrationKt.skip(flow, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    public static final Flow startWith(Flow flow, Object obj) {
        return FlowKt__MigrationKt.startWith(flow, obj);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final void subscribe(Flow flow, Function2 function2) {
        FlowKt__MigrationKt.subscribe(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use flowOn instead")
    public static final Flow subscribeOn(Flow flow, CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.subscribeOn(flow, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final Flow switchMap(Flow flow, Function2 function2) {
        return FlowKt__MigrationKt.switchMap(flow, function2);
    }

    public static final Flow take(Flow flow, int i) {
        return FlowKt__LimitKt.take(flow, i);
    }

    public static final Flow takeWhile(Flow flow, Function2 function2) {
        return FlowKt__LimitKt.takeWhile(flow, function2);
    }

    public static final Flow transform(Flow flow, Function3 function3) {
        return FlowKt__EmittersKt.transform(flow, function3);
    }

    public static final Flow transformLatest(Flow flow, Function3 function3) {
        return FlowKt__MergeKt.transformLatest(flow, function3);
    }

    public static final Flow unsafeTransform(Flow flow, Function3 function3) {
        return FlowKt__EmittersKt.unsafeTransform(flow, function3);
    }

    public static final Flow combine(Flow flow, Flow flow2, Flow flow3, Function4 function4) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final Flow combineLatest(Flow flow, Flow flow2, Flow flow3, Function4 function4) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, function4);
    }

    public static final Flow combineTransform(Flow flow, Flow flow2, Flow flow3, Function5 function5) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, function5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    public static final Flow flowWith(Flow flow, CoroutineContext coroutineContext, int i, Function1 function1) {
        return FlowKt__ContextKt.flowWith(flow, coroutineContext, i, function1);
    }

    public static final Object fold(Flow flow, Object obj, Function3 function3, Continuation continuation) {
        return FlowKt__ReduceKt.fold(flow, obj, function3, continuation);
    }

    public static final Flow combine(Flow flow, Flow flow2, Flow flow3, Flow flow4, Flow flow5, Function6 function6) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, flow5, function6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final Flow combineLatest(Flow flow, Flow flow2, Flow flow3, Flow flow4, Flow flow5, Function6 function6) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, flow5, function6);
    }

    public static final Flow combineTransform(Flow flow, Flow flow2, Flow flow3, Flow flow4, Flow flow5, Function7 function7) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, flow5, function7);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emitAll(other) }", imports = {}))
    public static final Flow concatWith(Flow flow, Flow flow2) {
        return FlowKt__MigrationKt.concatWith(flow, flow2);
    }

    public static final Flow onCompletion(Flow flow, Function3 function3) {
        return FlowKt__EmittersKt.onCompletion(flow, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    public static final Flow startWith(Flow flow, Flow flow2) {
        return FlowKt__MigrationKt.startWith(flow, flow2);
    }

    public static final Object emitAll(FlowCollector flowCollector, Flow flow, Continuation continuation) {
        return FlowKt__CollectKt.emitAll(flowCollector, flow, continuation);
    }

    public static final Flow retry(Flow flow, long j, Function2 function2) {
        return FlowKt__ErrorsKt.retry(flow, j, function2);
    }

    public static final Flow emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }
}
