package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class ObservableInternalHelper {

    /* loaded from: classes7.dex */
    public static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final int bufferSize;
        public final Observable<T> parent;

        public BufferedReplayCallable(Observable<T> observable, int i2) {
            this.parent = observable;
            this.bufferSize = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    /* loaded from: classes7.dex */
    public static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final int bufferSize;
        public final Observable<T> parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public BufferedTimedReplayCallable(Observable<T> observable, int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = observable;
            this.bufferSize = i2;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    /* loaded from: classes7.dex */
    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        public final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapIntoIterable<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<U> apply(T t) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* loaded from: classes7.dex */
    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        public final BiFunction<? super T, ? super U, ? extends R> combiner;
        public final T t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.combiner = biFunction;
            this.t = t;
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.functions.Function
        public R apply(U u) throws Exception {
            return this.combiner.apply((T) this.t, u);
        }
    }

    /* loaded from: classes7.dex */
    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        public final BiFunction<? super T, ? super U, ? extends R> combiner;
        public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapWithCombinerOuter<T, R, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<R> apply(T t) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, t));
        }
    }

    /* loaded from: classes7.dex */
    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        public final Function<? super T, ? extends ObservableSource<U>> itemDelay;

        public ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.itemDelay = function;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((ItemDelayFunction<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<T> apply(T t) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.itemDelay.apply(t), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    /* loaded from: classes7.dex */
    public enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ObserverOnComplete<T> implements Action {
        public final Observer<T> observer;

        public ObserverOnComplete(Observer<T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.observer.onComplete();
        }
    }

    /* loaded from: classes7.dex */
    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        public final Observer<T> observer;

        public ObserverOnError(Observer<T> observer) {
            this.observer = observer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            this.observer.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ObserverOnNext<T> implements Consumer<T> {
        public final Observer<T> observer;

        public ObserverOnNext(Observer<T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.observer.onNext(t);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final Observable<T> parent;

        public ReplayCallable(Observable<T> observable) {
            this.parent = observable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay();
        }
    }

    /* loaded from: classes7.dex */
    public static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        public final Scheduler scheduler;
        public final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

        public ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            this.selector = function;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((Observable) ((Observable) obj));
        }

        public ObservableSource<R> apply(Observable<T> observable) throws Exception {
            return Observable.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.scheduler);
        }
    }

    /* loaded from: classes7.dex */
    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final BiConsumer<S, Emitter<T>> consumer;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.consumer = biConsumer;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleBiGenerator<T, S>) obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(s, emitter);
            return s;
        }
    }

    /* loaded from: classes7.dex */
    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final Consumer<Emitter<T>> consumer;

        public SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.consumer = consumer;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleGenerator<T, S>) obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(emitter);
            return s;
        }
    }

    /* loaded from: classes7.dex */
    public static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final Observable<T> parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public TimedReplayCallable(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = observable;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        public final Function<? super Object[], ? extends R> zipper;

        public ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((List) ((List) obj));
        }

        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return Observable.zipIterable(list, this.zipper, false, Observable.bufferSize());
        }
    }

    public ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i2) {
        return new BufferedReplayCallable(observable, i2);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, i2, j, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j, timeUnit, scheduler);
    }
}
