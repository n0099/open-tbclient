package rx;

import android.support.v7.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Emitter;
import rx.a;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.functions.l;
import rx.functions.m;
import rx.functions.o;
import rx.functions.p;
import rx.internal.operators.CachedObservable;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OnSubscribeAmb;
import rx.internal.operators.OnSubscribeCombineLatest;
import rx.internal.operators.OnSubscribeDetach;
import rx.internal.operators.OnSubscribeFromArray;
import rx.internal.operators.OnSubscribeFromEmitter;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OnSubscribeGroupJoin;
import rx.internal.operators.OnSubscribeJoin;
import rx.internal.operators.OnSubscribeRange;
import rx.internal.operators.OnSubscribeUsing;
import rx.internal.operators.OperatorBufferWithSize;
import rx.internal.operators.OperatorEagerConcatMap;
import rx.internal.operators.OperatorElementAt;
import rx.internal.operators.OperatorGroupBy;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorPublish;
import rx.internal.operators.OperatorReplay;
import rx.internal.operators.OperatorWindowWithSize;
import rx.internal.operators.OperatorZip;
import rx.internal.operators.aa;
import rx.internal.operators.ab;
import rx.internal.operators.ac;
import rx.internal.operators.ad;
import rx.internal.operators.ae;
import rx.internal.operators.af;
import rx.internal.operators.ag;
import rx.internal.operators.ah;
import rx.internal.operators.ai;
import rx.internal.operators.aj;
import rx.internal.operators.ak;
import rx.internal.operators.al;
import rx.internal.operators.am;
import rx.internal.operators.an;
import rx.internal.operators.ao;
import rx.internal.operators.ap;
import rx.internal.operators.aq;
import rx.internal.operators.ar;
import rx.internal.operators.as;
import rx.internal.operators.at;
import rx.internal.operators.au;
import rx.internal.operators.av;
import rx.internal.operators.aw;
import rx.internal.operators.ax;
import rx.internal.operators.ay;
import rx.internal.operators.az;
import rx.internal.operators.ba;
import rx.internal.operators.bb;
import rx.internal.operators.bc;
import rx.internal.operators.bd;
import rx.internal.operators.be;
import rx.internal.operators.bf;
import rx.internal.operators.bg;
import rx.internal.operators.bh;
import rx.internal.operators.bi;
import rx.internal.operators.bj;
import rx.internal.operators.bk;
import rx.internal.operators.bl;
import rx.internal.operators.bm;
import rx.internal.operators.bn;
import rx.internal.operators.bo;
import rx.internal.operators.bp;
import rx.internal.operators.bq;
import rx.internal.operators.br;
import rx.internal.operators.bs;
import rx.internal.operators.bt;
import rx.internal.operators.bu;
import rx.internal.operators.bv;
import rx.internal.operators.bw;
import rx.internal.operators.bx;
import rx.internal.operators.by;
import rx.internal.operators.bz;
import rx.internal.operators.ca;
import rx.internal.operators.cc;
import rx.internal.operators.cd;
import rx.internal.operators.ce;
import rx.internal.operators.cf;
import rx.internal.operators.cg;
import rx.internal.operators.ch;
import rx.internal.operators.ci;
import rx.internal.operators.cj;
import rx.internal.operators.ck;
import rx.internal.operators.cl;
import rx.internal.operators.cm;
import rx.internal.operators.cn;
import rx.internal.operators.n;
import rx.internal.operators.q;
import rx.internal.operators.r;
import rx.internal.operators.t;
import rx.internal.operators.u;
import rx.internal.operators.v;
import rx.internal.operators.w;
import rx.internal.operators.x;
import rx.internal.operators.y;
import rx.internal.operators.z;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class d<T> {
    final a<T> onSubscribe;

    /* loaded from: classes2.dex */
    public interface a<T> extends rx.functions.b<j<? super T>> {
    }

    /* loaded from: classes2.dex */
    public interface b<R, T> extends rx.functions.f<j<? super R>, j<? super T>> {
    }

    /* loaded from: classes2.dex */
    public interface c<T, R> extends rx.functions.f<d<T>, d<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(a<T> aVar) {
        this.onSubscribe = aVar;
    }

    public static <T> d<T> create(a<T> aVar) {
        return new d<>(rx.c.c.a(aVar));
    }

    public static <S, T> d<T> create(SyncOnSubscribe<S, T> syncOnSubscribe) {
        return create((a) syncOnSubscribe);
    }

    public static <S, T> d<T> create(rx.observables.a<S, T> aVar) {
        return create((a) aVar);
    }

    public final <R> d<R> lift(b<? extends R, ? super T> bVar) {
        return create(new n(this.onSubscribe, bVar));
    }

    public <R> d<R> compose(c<? super T, ? extends R> cVar) {
        return (d) cVar.call(this);
    }

    public final <R> R to(rx.functions.f<? super d<T>, R> fVar) {
        return fVar.call(this);
    }

    public h<T> toSingle() {
        return new h<>(t.g(this));
    }

    public rx.b toCompletable() {
        return rx.b.a((d<?>) this);
    }

    public static <T> d<T> amb(Iterable<? extends d<? extends T>> iterable) {
        return create(OnSubscribeAmb.g(iterable));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2) {
        return create(OnSubscribeAmb.a(dVar, dVar2));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3) {
        return create(OnSubscribeAmb.a(dVar, dVar2, dVar3));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4) {
        return create(OnSubscribeAmb.a(dVar, dVar2, dVar3, dVar4));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5) {
        return create(OnSubscribeAmb.a(dVar, dVar2, dVar3, dVar4, dVar5));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6) {
        return create(OnSubscribeAmb.a(dVar, dVar2, dVar3, dVar4, dVar5, dVar6));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7) {
        return create(OnSubscribeAmb.a(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8) {
        return create(OnSubscribeAmb.a(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8));
    }

    public static <T> d<T> amb(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8, d<? extends T> dVar9) {
        return create(OnSubscribeAmb.a(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9));
    }

    public static <T1, T2, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, rx.functions.g<? super T1, ? super T2, ? extends R> gVar) {
        return combineLatest(Arrays.asList(dVar, dVar2), p.a(gVar));
    }

    public static <T1, T2, T3, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, rx.functions.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        return combineLatest(Arrays.asList(dVar, dVar2, dVar3), p.a(hVar));
    }

    public static <T1, T2, T3, T4, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, rx.functions.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        return combineLatest(Arrays.asList(dVar, dVar2, dVar3, dVar4), p.a(iVar));
    }

    public static <T1, T2, T3, T4, T5, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, rx.functions.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        return combineLatest(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5), p.a(jVar));
    }

    public static <T1, T2, T3, T4, T5, T6, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, rx.functions.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        return combineLatest(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6), p.a(kVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, d<? extends T7> dVar7, l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        return combineLatest(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7), p.a(lVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, d<? extends T7> dVar7, d<? extends T8> dVar8, m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        return combineLatest(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8), p.a(mVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d<R> combineLatest(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, d<? extends T7> dVar7, d<? extends T8> dVar8, d<? extends T9> dVar9, rx.functions.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        return combineLatest(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9), p.a(nVar));
    }

    public static <T, R> d<R> combineLatest(List<? extends d<? extends T>> list, o<? extends R> oVar) {
        return create(new OnSubscribeCombineLatest(list, oVar));
    }

    public static <T, R> d<R> combineLatest(Iterable<? extends d<? extends T>> iterable, o<? extends R> oVar) {
        return create(new OnSubscribeCombineLatest(iterable, oVar));
    }

    public static <T, R> d<R> combineLatestDelayError(Iterable<? extends d<? extends T>> iterable, o<? extends R> oVar) {
        return create(new OnSubscribeCombineLatest(null, iterable, oVar, rx.internal.util.h.SIZE, true));
    }

    public static <T> d<T> concat(Iterable<? extends d<? extends T>> iterable) {
        return concat(from(iterable));
    }

    public static <T> d<T> concat(d<? extends d<? extends T>> dVar) {
        return (d<T>) dVar.concatMap(UtilityFunctions.cew());
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2) {
        return concat(just(dVar, dVar2));
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3) {
        return concat(just(dVar, dVar2, dVar3));
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4) {
        return concat(just(dVar, dVar2, dVar3, dVar4));
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5) {
        return concat(just(dVar, dVar2, dVar3, dVar4, dVar5));
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6) {
        return concat(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6));
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7) {
        return concat(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7));
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8) {
        return concat(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8));
    }

    public static <T> d<T> concat(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8, d<? extends T> dVar9) {
        return concat(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9));
    }

    public static <T> d<T> concatDelayError(d<? extends d<? extends T>> dVar) {
        return (d<T>) dVar.concatMapDelayError(UtilityFunctions.cew());
    }

    public static <T> d<T> concatDelayError(Iterable<? extends d<? extends T>> iterable) {
        return concatDelayError(from(iterable));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2) {
        return concatDelayError(just(dVar, dVar2));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3) {
        return concatDelayError(just(dVar, dVar2, dVar3));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4) {
        return concatDelayError(just(dVar, dVar2, dVar3, dVar4));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5) {
        return concatDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6) {
        return concatDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7) {
        return concatDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8) {
        return concatDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8));
    }

    public static <T> d<T> concatDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8, d<? extends T> dVar9) {
        return concatDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9));
    }

    public static <T> d<T> defer(rx.functions.e<d<T>> eVar) {
        return create(new rx.internal.operators.f(eVar));
    }

    public static <T> d<T> empty() {
        return EmptyObservableHolder.instance();
    }

    public static <T> d<T> error(Throwable th) {
        return create(new w(th));
    }

    public static <T> d<T> from(Future<? extends T> future) {
        return create(ab.b(future));
    }

    public static <T> d<T> from(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return create(ab.a(future, j, timeUnit));
    }

    public static <T> d<T> from(Future<? extends T> future, g gVar) {
        return create(ab.b(future)).subscribeOn(gVar);
    }

    public static <T> d<T> from(Iterable<? extends T> iterable) {
        return create(new OnSubscribeFromIterable(iterable));
    }

    public static <T> d<T> from(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return just(tArr[0]);
        }
        return create(new OnSubscribeFromArray(tArr));
    }

    public static <T> d<T> fromEmitter(rx.functions.b<Emitter<T>> bVar, Emitter.BackpressureMode backpressureMode) {
        return create(new OnSubscribeFromEmitter(bVar, backpressureMode));
    }

    public static <T> d<T> fromCallable(Callable<? extends T> callable) {
        return create(new rx.internal.operators.m(callable));
    }

    public static d<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, Schedulers.computation());
    }

    public static d<Long> interval(long j, TimeUnit timeUnit, g gVar) {
        return interval(j, j, timeUnit, gVar);
    }

    public static d<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, Schedulers.computation());
    }

    public static d<Long> interval(long j, long j2, TimeUnit timeUnit, g gVar) {
        return create(new y(j, j2, timeUnit, gVar));
    }

    public static <T> d<T> just(T t) {
        return ScalarSynchronousObservable.bp(t);
    }

    public static <T> d<T> just(T t, T t2) {
        return from(new Object[]{t, t2});
    }

    public static <T> d<T> just(T t, T t2, T t3) {
        return from(new Object[]{t, t2, t3});
    }

    public static <T> d<T> just(T t, T t2, T t3, T t4) {
        return from(new Object[]{t, t2, t3, t4});
    }

    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5) {
        return from(new Object[]{t, t2, t3, t4, t5});
    }

    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        return from(new Object[]{t, t2, t3, t4, t5, t6});
    }

    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7});
    }

    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7, t8});
    }

    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9});
    }

    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9, t10});
    }

    public static <T> d<T> merge(Iterable<? extends d<? extends T>> iterable) {
        return merge(from(iterable));
    }

    public static <T> d<T> merge(Iterable<? extends d<? extends T>> iterable, int i) {
        return merge(from(iterable), i);
    }

    public static <T> d<T> merge(d<? extends d<? extends T>> dVar) {
        return dVar.getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) dVar).d(UtilityFunctions.cew()) : (d<T>) dVar.lift(OperatorMerge.pn(false));
    }

    public static <T> d<T> merge(d<? extends d<? extends T>> dVar, int i) {
        return dVar.getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) dVar).d(UtilityFunctions.cew()) : (d<T>) dVar.lift(OperatorMerge.o(false, i));
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2) {
        return merge(new d[]{dVar, dVar2});
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3) {
        return merge(new d[]{dVar, dVar2, dVar3});
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4) {
        return merge(new d[]{dVar, dVar2, dVar3, dVar4});
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5) {
        return merge(new d[]{dVar, dVar2, dVar3, dVar4, dVar5});
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6) {
        return merge(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6});
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7) {
        return merge(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7});
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8) {
        return merge(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8});
    }

    public static <T> d<T> merge(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8, d<? extends T> dVar9) {
        return merge(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9});
    }

    public static <T> d<T> merge(d<? extends T>[] dVarArr) {
        return merge(from(dVarArr));
    }

    public static <T> d<T> merge(d<? extends T>[] dVarArr, int i) {
        return merge(from(dVarArr), i);
    }

    public static <T> d<T> mergeDelayError(d<? extends d<? extends T>> dVar) {
        return (d<T>) dVar.lift(OperatorMerge.pn(true));
    }

    public static <T> d<T> mergeDelayError(d<? extends d<? extends T>> dVar, int i) {
        return (d<T>) dVar.lift(OperatorMerge.o(true, i));
    }

    public static <T> d<T> mergeDelayError(Iterable<? extends d<? extends T>> iterable) {
        return mergeDelayError(from(iterable));
    }

    public static <T> d<T> mergeDelayError(Iterable<? extends d<? extends T>> iterable, int i) {
        return mergeDelayError(from(iterable), i);
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2) {
        return mergeDelayError(just(dVar, dVar2));
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3) {
        return mergeDelayError(just(dVar, dVar2, dVar3));
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4) {
        return mergeDelayError(just(dVar, dVar2, dVar3, dVar4));
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5) {
        return mergeDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5));
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6) {
        return mergeDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6));
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7) {
        return mergeDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7));
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8) {
        return mergeDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8));
    }

    public static <T> d<T> mergeDelayError(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8, d<? extends T> dVar9) {
        return mergeDelayError(just(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9));
    }

    public final d<d<T>> nest() {
        return just(this);
    }

    public static <T> d<T> never() {
        return NeverObservableHolder.instance();
    }

    public static d<Integer> range(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        }
        if (i2 == 0) {
            return empty();
        }
        if (i > (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2) + 1) {
            throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
        }
        if (i2 == 1) {
            return just(Integer.valueOf(i));
        }
        return create(new OnSubscribeRange(i, (i2 - 1) + i));
    }

    public static d<Integer> range(int i, int i2, g gVar) {
        return range(i, i2).subscribeOn(gVar);
    }

    public static <T> d<Boolean> sequenceEqual(d<? extends T> dVar, d<? extends T> dVar2) {
        return sequenceEqual(dVar, dVar2, InternalObservableUtils.OBJECT_EQUALS);
    }

    public static <T> d<Boolean> sequenceEqual(d<? extends T> dVar, d<? extends T> dVar2, rx.functions.g<? super T, ? super T, Boolean> gVar) {
        return bg.sequenceEqual(dVar, dVar2, gVar);
    }

    public static <T> d<T> switchOnNext(d<? extends d<? extends T>> dVar) {
        return (d<T>) dVar.lift(bp.po(false));
    }

    public static <T> d<T> switchOnNextDelayError(d<? extends d<? extends T>> dVar) {
        return (d<T>) dVar.lift(bp.po(true));
    }

    @Deprecated
    public static d<Long> timer(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, Schedulers.computation());
    }

    @Deprecated
    public static d<Long> timer(long j, long j2, TimeUnit timeUnit, g gVar) {
        return interval(j, j2, timeUnit, gVar);
    }

    public static d<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static d<Long> timer(long j, TimeUnit timeUnit, g gVar) {
        return create(new x(j, timeUnit, gVar));
    }

    public static <T, Resource> d<T> using(rx.functions.e<Resource> eVar, rx.functions.f<? super Resource, ? extends d<? extends T>> fVar, rx.functions.b<? super Resource> bVar) {
        return using(eVar, fVar, bVar, false);
    }

    public static <T, Resource> d<T> using(rx.functions.e<Resource> eVar, rx.functions.f<? super Resource, ? extends d<? extends T>> fVar, rx.functions.b<? super Resource> bVar, boolean z) {
        return create(new OnSubscribeUsing(eVar, fVar, bVar, z));
    }

    public static <R> d<R> zip(Iterable<? extends d<?>> iterable, o<? extends R> oVar) {
        ArrayList arrayList = new ArrayList();
        for (d<?> dVar : iterable) {
            arrayList.add(dVar);
        }
        return just(arrayList.toArray(new d[arrayList.size()])).lift(new OperatorZip(oVar));
    }

    public static <R> d<R> zip(d<?>[] dVarArr, o<? extends R> oVar) {
        return just(dVarArr).lift(new OperatorZip(oVar));
    }

    public static <R> d<R> zip(d<? extends d<?>> dVar, o<? extends R> oVar) {
        return dVar.toList().map(InternalObservableUtils.TO_ARRAY).lift(new OperatorZip(oVar));
    }

    public static <T1, T2, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, rx.functions.g<? super T1, ? super T2, ? extends R> gVar) {
        return just(new d[]{dVar, dVar2}).lift(new OperatorZip(gVar));
    }

    public static <T1, T2, T3, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, rx.functions.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        return just(new d[]{dVar, dVar2, dVar3}).lift(new OperatorZip(hVar));
    }

    public static <T1, T2, T3, T4, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, rx.functions.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        return just(new d[]{dVar, dVar2, dVar3, dVar4}).lift(new OperatorZip(iVar));
    }

    public static <T1, T2, T3, T4, T5, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, rx.functions.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        return just(new d[]{dVar, dVar2, dVar3, dVar4, dVar5}).lift(new OperatorZip(jVar));
    }

    public static <T1, T2, T3, T4, T5, T6, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, rx.functions.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        return just(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6}).lift(new OperatorZip(kVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, d<? extends T7> dVar7, l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        return just(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7}).lift(new OperatorZip(lVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, d<? extends T7> dVar7, d<? extends T8> dVar8, m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        return just(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8}).lift(new OperatorZip(mVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d<R> zip(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, d<? extends T6> dVar6, d<? extends T7> dVar7, d<? extends T8> dVar8, d<? extends T9> dVar9, rx.functions.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        return just(new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9}).lift(new OperatorZip(nVar));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<java.lang.Boolean> */
    public final d<Boolean> all(rx.functions.f<? super T, Boolean> fVar) {
        return lift(new ac(fVar));
    }

    public final d<T> ambWith(d<? extends T> dVar) {
        return amb(this, dVar);
    }

    public final d<T> asObservable() {
        return (d<T>) lift(ae.cdm());
    }

    public final <TClosing> d<List<T>> buffer(rx.functions.e<? extends d<? extends TClosing>> eVar) {
        return (d<List<T>>) lift(new af(eVar, 16));
    }

    public final d<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final d<List<T>> buffer(int i, int i2) {
        return (d<List<T>>) lift(new OperatorBufferWithSize(i, i2));
    }

    public final d<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return buffer(j, j2, timeUnit, Schedulers.computation());
    }

    public final d<List<T>> buffer(long j, long j2, TimeUnit timeUnit, g gVar) {
        return (d<List<T>>) lift(new ah(j, j2, timeUnit, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, gVar));
    }

    public final d<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Schedulers.computation());
    }

    public final d<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return (d<List<T>>) lift(new ah(j, j, timeUnit, i, Schedulers.computation()));
    }

    public final d<List<T>> buffer(long j, TimeUnit timeUnit, int i, g gVar) {
        return (d<List<T>>) lift(new ah(j, j, timeUnit, i, gVar));
    }

    public final d<List<T>> buffer(long j, TimeUnit timeUnit, g gVar) {
        return buffer(j, j, timeUnit, gVar);
    }

    public final <TOpening, TClosing> d<List<T>> buffer(d<? extends TOpening> dVar, rx.functions.f<? super TOpening, ? extends d<? extends TClosing>> fVar) {
        return (d<List<T>>) lift(new ag(dVar, fVar));
    }

    public final <B> d<List<T>> buffer(d<B> dVar) {
        return buffer(dVar, 16);
    }

    public final <B> d<List<T>> buffer(d<B> dVar, int i) {
        return (d<List<T>>) lift(new af(dVar, i));
    }

    public final d<T> cache() {
        return CachedObservable.b(this);
    }

    @Deprecated
    public final d<T> cache(int i) {
        return cacheWithInitialCapacity(i);
    }

    public final d<T> cacheWithInitialCapacity(int i) {
        return CachedObservable.a(this, i);
    }

    public final <R> d<R> cast(Class<R> cls) {
        return lift(new ai(cls));
    }

    public final <R> d<R> collect(rx.functions.e<R> eVar, rx.functions.c<R, ? super T> cVar) {
        return create(new rx.internal.operators.d(this, eVar, cVar));
    }

    public final <R> d<R> concatMap(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).d(fVar) : create(new rx.internal.operators.e(this, fVar, 2, 0));
    }

    public final <R> d<R> concatMapDelayError(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).d(fVar) : create(new rx.internal.operators.e(this, fVar, 2, 2));
    }

    public final <R> d<R> concatMapIterable(rx.functions.f<? super T, ? extends Iterable<? extends R>> fVar) {
        return rx.internal.operators.l.a(this, fVar, rx.internal.util.h.SIZE);
    }

    public final d<T> concatWith(d<? extends T> dVar) {
        return concat(this, dVar);
    }

    public final d<Boolean> contains(Object obj) {
        return exists(InternalObservableUtils.equalsWith(obj));
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: rx.d<R>, rx.d<java.lang.Integer> */
    public final d<Integer> count() {
        return reduce(0, InternalObservableUtils.COUNTER);
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: rx.d<R>, rx.d<java.lang.Long> */
    public final d<Long> countLong() {
        return reduce(0L, InternalObservableUtils.LONG_COUNTER);
    }

    public final <U> d<T> debounce(rx.functions.f<? super T, ? extends d<U>> fVar) {
        return (d<T>) lift(new aj(fVar));
    }

    public final d<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, Schedulers.computation());
    }

    public final d<T> debounce(long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new ak(j, timeUnit, gVar));
    }

    public final d<T> defaultIfEmpty(T t) {
        return switchIfEmpty(just(t));
    }

    public final d<T> switchIfEmpty(d<? extends T> dVar) {
        if (dVar == null) {
            throw new NullPointerException("alternate is null");
        }
        return (d<T>) lift(new bq(dVar));
    }

    public final <U, V> d<T> delay(rx.functions.e<? extends d<U>> eVar, rx.functions.f<? super T, ? extends d<V>> fVar) {
        return (d<T>) delaySubscription(eVar).lift(new am(this, fVar));
    }

    public final <U> d<T> delay(rx.functions.f<? super T, ? extends d<U>> fVar) {
        return (d<T>) lift(new am(this, fVar));
    }

    public final d<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation());
    }

    public final d<T> delay(long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new al(j, timeUnit, gVar));
    }

    public final d<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.computation());
    }

    public final d<T> delaySubscription(long j, TimeUnit timeUnit, g gVar) {
        return create(new rx.internal.operators.g(this, j, timeUnit, gVar));
    }

    public final <U> d<T> delaySubscription(rx.functions.e<? extends d<U>> eVar) {
        return create(new rx.internal.operators.i(this, eVar));
    }

    public final <U> d<T> delaySubscription(d<U> dVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        return create(new rx.internal.operators.h(this, dVar));
    }

    public final <T2> d<T2> dematerialize() {
        return (d<T2>) lift(an.cds());
    }

    public final d<T> distinct() {
        return (d<T>) lift(ao.cdt());
    }

    public final <U> d<T> distinct(rx.functions.f<? super T, ? extends U> fVar) {
        return (d<T>) lift(new ao(fVar));
    }

    public final d<T> distinctUntilChanged() {
        return (d<T>) lift(ap.cdu());
    }

    public final <U> d<T> distinctUntilChanged(rx.functions.f<? super T, ? extends U> fVar) {
        return (d<T>) lift(new ap(fVar));
    }

    public final d<T> distinctUntilChanged(rx.functions.g<? super T, ? super T, Boolean> gVar) {
        return (d<T>) lift(new ap(gVar));
    }

    public final d<T> doOnCompleted(rx.functions.a aVar) {
        return create(new rx.internal.operators.j(this, new rx.internal.util.b(Actions.cdb(), Actions.cdb(), aVar)));
    }

    public final d<T> doOnEach(rx.functions.b<Notification<? super T>> bVar) {
        return create(new rx.internal.operators.j(this, new rx.internal.util.a(bVar)));
    }

    public final d<T> doOnEach(e<? super T> eVar) {
        return create(new rx.internal.operators.j(this, eVar));
    }

    public final d<T> doOnError(rx.functions.b<? super Throwable> bVar) {
        return create(new rx.internal.operators.j(this, new rx.internal.util.b(Actions.cdb(), bVar, Actions.cdb())));
    }

    public final d<T> doOnNext(rx.functions.b<? super T> bVar) {
        return create(new rx.internal.operators.j(this, new rx.internal.util.b(bVar, Actions.cdb(), Actions.cdb())));
    }

    public final d<T> doOnRequest(rx.functions.b<? super Long> bVar) {
        return (d<T>) lift(new ar(bVar));
    }

    public final d<T> doOnSubscribe(rx.functions.a aVar) {
        return (d<T>) lift(new as(aVar));
    }

    public final d<T> doOnTerminate(rx.functions.a aVar) {
        return create(new rx.internal.operators.j(this, new rx.internal.util.b(Actions.cdb(), Actions.c(aVar), aVar)));
    }

    public final d<T> doOnUnsubscribe(rx.functions.a aVar) {
        return (d<T>) lift(new at(aVar));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2) {
        return concatEager(Arrays.asList(dVar, dVar2));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3) {
        return concatEager(Arrays.asList(dVar, dVar2, dVar3));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4) {
        return concatEager(Arrays.asList(dVar, dVar2, dVar3, dVar4));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5) {
        return concatEager(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6) {
        return concatEager(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7) {
        return concatEager(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8) {
        return concatEager(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8));
    }

    public static <T> d<T> concatEager(d<? extends T> dVar, d<? extends T> dVar2, d<? extends T> dVar3, d<? extends T> dVar4, d<? extends T> dVar5, d<? extends T> dVar6, d<? extends T> dVar7, d<? extends T> dVar8, d<? extends T> dVar9) {
        return concatEager(Arrays.asList(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9));
    }

    public static <T> d<T> concatEager(Iterable<? extends d<? extends T>> iterable) {
        return from(iterable).concatMapEager(UtilityFunctions.cew());
    }

    public static <T> d<T> concatEager(Iterable<? extends d<? extends T>> iterable, int i) {
        return from(iterable).concatMapEager(UtilityFunctions.cew(), i);
    }

    public static <T> d<T> concatEager(d<? extends d<? extends T>> dVar) {
        return (d<T>) dVar.concatMapEager(UtilityFunctions.cew());
    }

    public static <T> d<T> concatEager(d<? extends d<? extends T>> dVar, int i) {
        return (d<T>) dVar.concatMapEager(UtilityFunctions.cew(), i);
    }

    public final <R> d<R> concatMapEager(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return concatMapEager(fVar, rx.internal.util.h.SIZE);
    }

    public final <R> d<R> concatMapEager(rx.functions.f<? super T, ? extends d<? extends R>> fVar, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + i);
        }
        return lift(new OperatorEagerConcatMap(fVar, i, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
    }

    public final <R> d<R> concatMapEager(rx.functions.f<? super T, ? extends d<? extends R>> fVar, int i, int i2) {
        if (i < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + i);
        }
        if (i2 < 1) {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
        }
        return lift(new OperatorEagerConcatMap(fVar, i, i2));
    }

    public final d<T> elementAt(int i) {
        return (d<T>) lift(new OperatorElementAt(i));
    }

    public final d<T> elementAtOrDefault(int i, T t) {
        return (d<T>) lift(new OperatorElementAt(i, t));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<java.lang.Boolean> */
    public final d<Boolean> exists(rx.functions.f<? super T, Boolean> fVar) {
        return lift(new ad(fVar, false));
    }

    public final d<T> filter(rx.functions.f<? super T, Boolean> fVar) {
        return create(new rx.internal.operators.k(this, fVar));
    }

    @Deprecated
    public final d<T> finallyDo(rx.functions.a aVar) {
        return (d<T>) lift(new aq(aVar));
    }

    public final d<T> doAfterTerminate(rx.functions.a aVar) {
        return (d<T>) lift(new aq(aVar));
    }

    public final d<T> first() {
        return take(1).single();
    }

    public final d<T> first(rx.functions.f<? super T, Boolean> fVar) {
        return takeFirst(fVar).single();
    }

    public final d<T> firstOrDefault(T t) {
        return take(1).singleOrDefault(t);
    }

    public final d<T> firstOrDefault(T t, rx.functions.f<? super T, Boolean> fVar) {
        return takeFirst(fVar).singleOrDefault(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.f<? super T, ? extends rx.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> flatMap(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) this).d(fVar) : merge(map(fVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.f<? super T, ? extends rx.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> flatMap(rx.functions.f<? super T, ? extends d<? extends R>> fVar, int i) {
        return getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) this).d(fVar) : merge(map(fVar), i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.functions.f<? super T, ? extends rx.d<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.f<? super java.lang.Throwable, ? extends rx.d<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: rx.functions.e<? extends rx.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> flatMap(rx.functions.f<? super T, ? extends d<? extends R>> fVar, rx.functions.f<? super Throwable, ? extends d<? extends R>> fVar2, rx.functions.e<? extends d<? extends R>> eVar) {
        return merge(mapNotification(fVar, fVar2, eVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.functions.f<? super T, ? extends rx.d<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.f<? super java.lang.Throwable, ? extends rx.d<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: rx.functions.e<? extends rx.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> flatMap(rx.functions.f<? super T, ? extends d<? extends R>> fVar, rx.functions.f<? super Throwable, ? extends d<? extends R>> fVar2, rx.functions.e<? extends d<? extends R>> eVar, int i) {
        return merge(mapNotification(fVar, fVar2, eVar), i);
    }

    public final <U, R> d<R> flatMap(rx.functions.f<? super T, ? extends d<? extends U>> fVar, rx.functions.g<? super T, ? super U, ? extends R> gVar) {
        return merge(lift(new aw(fVar, gVar)));
    }

    public final <U, R> d<R> flatMap(rx.functions.f<? super T, ? extends d<? extends U>> fVar, rx.functions.g<? super T, ? super U, ? extends R> gVar, int i) {
        return merge(lift(new aw(fVar, gVar)), i);
    }

    public final <R> d<R> flatMapIterable(rx.functions.f<? super T, ? extends Iterable<? extends R>> fVar) {
        return flatMapIterable(fVar, rx.internal.util.h.SIZE);
    }

    public final <R> d<R> flatMapIterable(rx.functions.f<? super T, ? extends Iterable<? extends R>> fVar, int i) {
        return rx.internal.operators.l.a(this, fVar, i);
    }

    public final <U, R> d<R> flatMapIterable(rx.functions.f<? super T, ? extends Iterable<? extends U>> fVar, rx.functions.g<? super T, ? super U, ? extends R> gVar) {
        return flatMap(aw.a(fVar), gVar);
    }

    public final <U, R> d<R> flatMapIterable(rx.functions.f<? super T, ? extends Iterable<? extends U>> fVar, rx.functions.g<? super T, ? super U, ? extends R> gVar, int i) {
        return flatMap(aw.a(fVar), gVar, i);
    }

    public final void forEach(rx.functions.b<? super T> bVar) {
        subscribe(bVar);
    }

    public final void forEach(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        subscribe(bVar, bVar2);
    }

    public final void forEach(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        subscribe(bVar, bVar2, aVar);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<rx.observables.d<K, R>> */
    public final <K, R> d<rx.observables.d<K, R>> groupBy(rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends R> fVar2) {
        return (d<R>) lift(new OperatorGroupBy(fVar, fVar2));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<rx.observables.d<K, R>> */
    public final <K, R> d<rx.observables.d<K, R>> groupBy(rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends R> fVar2, rx.functions.f<rx.functions.b<K>, Map<K, Object>> fVar3) {
        if (fVar3 == null) {
            throw new NullPointerException("evictingMapFactory cannot be null");
        }
        return (d<R>) lift(new OperatorGroupBy(fVar, fVar2, fVar3));
    }

    public final <K> d<rx.observables.d<K, T>> groupBy(rx.functions.f<? super T, ? extends K> fVar) {
        return (d<rx.observables.d<K, T>>) lift(new OperatorGroupBy(fVar));
    }

    public final <T2, D1, D2, R> d<R> groupJoin(d<T2> dVar, rx.functions.f<? super T, ? extends d<D1>> fVar, rx.functions.f<? super T2, ? extends d<D2>> fVar2, rx.functions.g<? super T, ? super d<T2>, ? extends R> gVar) {
        return create(new OnSubscribeGroupJoin(this, dVar, fVar, fVar2, gVar));
    }

    public final d<T> ignoreElements() {
        return (d<T>) lift(au.cdw());
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<java.lang.Boolean> */
    public final d<Boolean> isEmpty() {
        return lift(InternalObservableUtils.IS_EMPTY);
    }

    public final <TRight, TLeftDuration, TRightDuration, R> d<R> join(d<TRight> dVar, rx.functions.f<T, d<TLeftDuration>> fVar, rx.functions.f<TRight, d<TRightDuration>> fVar2, rx.functions.g<T, TRight, R> gVar) {
        return create(new OnSubscribeJoin(this, dVar, fVar, fVar2, gVar));
    }

    public final d<T> last() {
        return takeLast(1).single();
    }

    public final d<T> last(rx.functions.f<? super T, Boolean> fVar) {
        return filter(fVar).takeLast(1).single();
    }

    public final d<T> lastOrDefault(T t) {
        return takeLast(1).singleOrDefault(t);
    }

    public final d<T> lastOrDefault(T t, rx.functions.f<? super T, Boolean> fVar) {
        return filter(fVar).takeLast(1).singleOrDefault(t);
    }

    public final d<T> limit(int i) {
        return take(i);
    }

    public final <R> d<R> map(rx.functions.f<? super T, ? extends R> fVar) {
        return create(new rx.internal.operators.o(this, fVar));
    }

    private <R> d<R> mapNotification(rx.functions.f<? super T, ? extends R> fVar, rx.functions.f<? super Throwable, ? extends R> fVar2, rx.functions.e<? extends R> eVar) {
        return lift(new av(fVar, fVar2, eVar));
    }

    public final d<Notification<T>> materialize() {
        return (d<Notification<T>>) lift(ax.cdz());
    }

    public final d<T> mergeWith(d<? extends T> dVar) {
        return merge(this, dVar);
    }

    public final d<T> observeOn(g gVar) {
        return observeOn(gVar, rx.internal.util.h.SIZE);
    }

    public final d<T> observeOn(g gVar, int i) {
        return observeOn(gVar, false, i);
    }

    public final d<T> observeOn(g gVar, boolean z) {
        return observeOn(gVar, z, rx.internal.util.h.SIZE);
    }

    public final d<T> observeOn(g gVar, boolean z, int i) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).b(gVar) : (d<T>) lift(new ay(gVar, z, i));
    }

    public final <R> d<R> ofType(Class<R> cls) {
        return filter(InternalObservableUtils.isInstanceOf(cls)).cast(cls);
    }

    public final d<T> onBackpressureBuffer() {
        return (d<T>) lift(az.cdI());
    }

    public final d<T> onBackpressureBuffer(long j) {
        return (d<T>) lift(new az(j));
    }

    public final d<T> onBackpressureBuffer(long j, rx.functions.a aVar) {
        return (d<T>) lift(new az(j, aVar));
    }

    public final d<T> onBackpressureBuffer(long j, rx.functions.a aVar, a.d dVar) {
        return (d<T>) lift(new az(j, aVar, dVar));
    }

    public final d<T> onBackpressureDrop(rx.functions.b<? super T> bVar) {
        return (d<T>) lift(new ba(bVar));
    }

    public final d<T> onBackpressureDrop() {
        return (d<T>) lift(ba.cdL());
    }

    public final d<T> onBackpressureLatest() {
        return (d<T>) lift(OperatorOnBackpressureLatest.cdM());
    }

    public final d<T> onErrorResumeNext(rx.functions.f<? super Throwable, ? extends d<? extends T>> fVar) {
        return (d<T>) lift(new bb(fVar));
    }

    public final d<T> onErrorResumeNext(d<? extends T> dVar) {
        return (d<T>) lift(bb.i(dVar));
    }

    public final d<T> onErrorReturn(rx.functions.f<? super Throwable, ? extends T> fVar) {
        return (d<T>) lift(bb.b(fVar));
    }

    public final d<T> onExceptionResumeNext(d<? extends T> dVar) {
        return (d<T>) lift(bb.j(dVar));
    }

    public final d<T> onTerminateDetach() {
        return create(new OnSubscribeDetach(this));
    }

    public final rx.observables.c<T> publish() {
        return OperatorPublish.k(this);
    }

    public final <R> d<R> publish(rx.functions.f<? super d<T>, ? extends d<R>> fVar) {
        return OperatorPublish.c(this, fVar);
    }

    public final d<T> rebatchRequests(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("n > 0 required but it was " + i);
        }
        return (d<T>) lift(ay.zn(i));
    }

    public final d<T> reduce(rx.functions.g<T, T, T> gVar) {
        return create(new q(this, gVar));
    }

    public final <R> d<R> reduce(R r, rx.functions.g<R, ? super T, R> gVar) {
        return create(new r(this, r, gVar));
    }

    public final d<T> repeat() {
        return rx.internal.operators.p.e(this);
    }

    public final d<T> repeat(g gVar) {
        return rx.internal.operators.p.a(this, gVar);
    }

    public final d<T> repeat(long j) {
        return rx.internal.operators.p.b(this, j);
    }

    public final d<T> repeat(long j, g gVar) {
        return rx.internal.operators.p.a(this, j, gVar);
    }

    public final d<T> repeatWhen(rx.functions.f<? super d<? extends Void>, ? extends d<?>> fVar, g gVar) {
        return rx.internal.operators.p.b(this, InternalObservableUtils.createRepeatDematerializer(fVar), gVar);
    }

    public final d<T> repeatWhen(rx.functions.f<? super d<? extends Void>, ? extends d<?>> fVar) {
        return rx.internal.operators.p.b(this, InternalObservableUtils.createRepeatDematerializer(fVar));
    }

    public final rx.observables.c<T> replay() {
        return OperatorReplay.k(this);
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar) {
        return OperatorReplay.a(InternalObservableUtils.createReplaySupplier(this), fVar);
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar, int i) {
        return OperatorReplay.a(InternalObservableUtils.createReplaySupplier(this, i), fVar);
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar, int i, long j, TimeUnit timeUnit) {
        return replay(fVar, i, j, timeUnit, Schedulers.computation());
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar, int i, long j, TimeUnit timeUnit, g gVar) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return OperatorReplay.a(InternalObservableUtils.createReplaySupplier(this, i, j, timeUnit, gVar), fVar);
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar, int i, g gVar) {
        return OperatorReplay.a(InternalObservableUtils.createReplaySupplier(this, i), InternalObservableUtils.createReplaySelectorAndObserveOn(fVar, gVar));
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar, long j, TimeUnit timeUnit) {
        return replay(fVar, j, timeUnit, Schedulers.computation());
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar, long j, TimeUnit timeUnit, g gVar) {
        return OperatorReplay.a(InternalObservableUtils.createReplaySupplier(this, j, timeUnit, gVar), fVar);
    }

    public final <R> d<R> replay(rx.functions.f<? super d<T>, ? extends d<R>> fVar, g gVar) {
        return OperatorReplay.a(InternalObservableUtils.createReplaySupplier(this), InternalObservableUtils.createReplaySelectorAndObserveOn(fVar, gVar));
    }

    public final rx.observables.c<T> replay(int i) {
        return OperatorReplay.b(this, i);
    }

    public final rx.observables.c<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, Schedulers.computation());
    }

    public final rx.observables.c<T> replay(int i, long j, TimeUnit timeUnit, g gVar) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return OperatorReplay.a(this, j, timeUnit, gVar, i);
    }

    public final rx.observables.c<T> replay(int i, g gVar) {
        return OperatorReplay.a(replay(i), gVar);
    }

    public final rx.observables.c<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, Schedulers.computation());
    }

    public final rx.observables.c<T> replay(long j, TimeUnit timeUnit, g gVar) {
        return OperatorReplay.a(this, j, timeUnit, gVar);
    }

    public final rx.observables.c<T> replay(g gVar) {
        return OperatorReplay.a(replay(), gVar);
    }

    public final d<T> retry() {
        return rx.internal.operators.p.d(this);
    }

    public final d<T> retry(long j) {
        return rx.internal.operators.p.a(this, j);
    }

    public final d<T> retry(rx.functions.g<Integer, Throwable, Boolean> gVar) {
        return (d<T>) nest().lift(new bc(gVar));
    }

    public final d<T> retryWhen(rx.functions.f<? super d<? extends Throwable>, ? extends d<?>> fVar) {
        return rx.internal.operators.p.a(this, InternalObservableUtils.createRetryDematerializer(fVar));
    }

    public final d<T> retryWhen(rx.functions.f<? super d<? extends Throwable>, ? extends d<?>> fVar, g gVar) {
        return rx.internal.operators.p.a(this, InternalObservableUtils.createRetryDematerializer(fVar), gVar);
    }

    public final d<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, Schedulers.computation());
    }

    public final d<T> sample(long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new be(j, timeUnit, gVar));
    }

    public final <U> d<T> sample(d<U> dVar) {
        return (d<T>) lift(new bd(dVar));
    }

    public final d<T> scan(rx.functions.g<T, T, T> gVar) {
        return (d<T>) lift(new bf(gVar));
    }

    public final <R> d<R> scan(R r, rx.functions.g<R, ? super T, R> gVar) {
        return lift(new bf(r, gVar));
    }

    public final d<T> serialize() {
        return (d<T>) lift(bh.cdQ());
    }

    public final d<T> share() {
        return publish().ceJ();
    }

    public final d<T> single() {
        return (d<T>) lift(bi.cdR());
    }

    public final d<T> single(rx.functions.f<? super T, Boolean> fVar) {
        return filter(fVar).single();
    }

    public final d<T> singleOrDefault(T t) {
        return (d<T>) lift(new bi(t));
    }

    public final d<T> singleOrDefault(T t, rx.functions.f<? super T, Boolean> fVar) {
        return filter(fVar).singleOrDefault(t);
    }

    public final d<T> skip(int i) {
        return (d<T>) lift(new bj(i));
    }

    public final d<T> skip(long j, TimeUnit timeUnit) {
        return skip(j, timeUnit, Schedulers.computation());
    }

    public final d<T> skip(long j, TimeUnit timeUnit, g gVar) {
        return create(new u(this, j, timeUnit, gVar));
    }

    public final d<T> skipLast(int i) {
        return (d<T>) lift(new bk(i));
    }

    public final d<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, Schedulers.computation());
    }

    public final d<T> skipLast(long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new bl(j, timeUnit, gVar));
    }

    public final <U> d<T> skipUntil(d<U> dVar) {
        return (d<T>) lift(new bm(dVar));
    }

    public final d<T> skipWhile(rx.functions.f<? super T, Boolean> fVar) {
        return (d<T>) lift(new bn(bn.c(fVar)));
    }

    public final d<T> startWith(d<T> dVar) {
        return concat(dVar, this);
    }

    public final d<T> startWith(Iterable<T> iterable) {
        return concat(from(iterable), this);
    }

    public final d<T> startWith(T t) {
        return concat(just(t), this);
    }

    public final d<T> startWith(T t, T t2) {
        return concat(just(t, t2), this);
    }

    public final d<T> startWith(T t, T t2, T t3) {
        return concat(just(t, t2, t3), this);
    }

    public final d<T> startWith(T t, T t2, T t3, T t4) {
        return concat(just(t, t2, t3, t4), this);
    }

    public final d<T> startWith(T t, T t2, T t3, T t4, T t5) {
        return concat(just(t, t2, t3, t4, t5), this);
    }

    public final d<T> startWith(T t, T t2, T t3, T t4, T t5, T t6) {
        return concat(just(t, t2, t3, t4, t5, t6), this);
    }

    public final d<T> startWith(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return concat(just(t, t2, t3, t4, t5, t6, t7), this);
    }

    public final d<T> startWith(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return concat(just(t, t2, t3, t4, t5, t6, t7, t8), this);
    }

    public final d<T> startWith(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return concat(just(t, t2, t3, t4, t5, t6, t7, t8, t9), this);
    }

    public final k subscribe() {
        return subscribe((j) new rx.internal.util.c(Actions.cdb(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.cdb()));
    }

    public final k subscribe(rx.functions.b<? super T> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        return subscribe((j) new rx.internal.util.c(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.cdb()));
    }

    public final k subscribe(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        return subscribe((j) new rx.internal.util.c(bVar, bVar2, Actions.cdb()));
    }

    public final k subscribe(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("onComplete can not be null");
        }
        return subscribe((j) new rx.internal.util.c(bVar, bVar2, aVar));
    }

    public final k subscribe(e<? super T> eVar) {
        if (eVar instanceof j) {
            return subscribe((j) ((j) eVar));
        }
        if (eVar == null) {
            throw new NullPointerException("observer is null");
        }
        return subscribe((j) new rx.internal.util.e(eVar));
    }

    public final k unsafeSubscribe(j<? super T> jVar) {
        try {
            jVar.onStart();
            rx.c.c.a(this, this.onSubscribe).call(jVar);
            return rx.c.c.c(jVar);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            try {
                jVar.onError(rx.c.c.W(th));
                return rx.subscriptions.e.cfu();
            } catch (Throwable th2) {
                rx.exceptions.a.J(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.c.c.W(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final k subscribe(j<? super T> jVar) {
        return subscribe(jVar, this);
    }

    static <T> k subscribe(j<? super T> jVar, d<T> dVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (dVar.onSubscribe == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        jVar.onStart();
        if (!(jVar instanceof rx.b.d)) {
            jVar = new rx.b.d(jVar);
        }
        try {
            rx.c.c.a(dVar, dVar.onSubscribe).call(jVar);
            return rx.c.c.c(jVar);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            if (jVar.isUnsubscribed()) {
                rx.c.c.onError(rx.c.c.W(th));
            } else {
                try {
                    jVar.onError(rx.c.c.W(th));
                } catch (Throwable th2) {
                    rx.exceptions.a.J(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.c.c.W(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return rx.subscriptions.e.cfu();
        }
    }

    public final d<T> subscribeOn(g gVar) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).b(gVar) : create(new bo(this, gVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.functions.f<? super T, ? extends rx.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> switchMap(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return switchOnNext(map(fVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.functions.f<? super T, ? extends rx.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> switchMapDelayError(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return switchOnNextDelayError(map(fVar));
    }

    public final d<T> take(int i) {
        return (d<T>) lift(new br(i));
    }

    public final d<T> take(long j, TimeUnit timeUnit) {
        return take(j, timeUnit, Schedulers.computation());
    }

    public final d<T> take(long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new bu(j, timeUnit, gVar));
    }

    public final d<T> takeFirst(rx.functions.f<? super T, Boolean> fVar) {
        return filter(fVar).take(1);
    }

    public final d<T> takeLast(int i) {
        if (i == 0) {
            return ignoreElements();
        }
        if (i == 1) {
            return create(new v(this));
        }
        return (d<T>) lift(new bs(i));
    }

    public final d<T> takeLast(int i, long j, TimeUnit timeUnit) {
        return takeLast(i, j, timeUnit, Schedulers.computation());
    }

    public final d<T> takeLast(int i, long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new bt(i, j, timeUnit, gVar));
    }

    public final d<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, Schedulers.computation());
    }

    public final d<T> takeLast(long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new bt(j, timeUnit, gVar));
    }

    public final d<List<T>> takeLastBuffer(int i) {
        return takeLast(i).toList();
    }

    public final d<List<T>> takeLastBuffer(int i, long j, TimeUnit timeUnit) {
        return takeLast(i, j, timeUnit).toList();
    }

    public final d<List<T>> takeLastBuffer(int i, long j, TimeUnit timeUnit, g gVar) {
        return takeLast(i, j, timeUnit, gVar).toList();
    }

    public final d<List<T>> takeLastBuffer(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit).toList();
    }

    public final d<List<T>> takeLastBuffer(long j, TimeUnit timeUnit, g gVar) {
        return takeLast(j, timeUnit, gVar).toList();
    }

    public final <E> d<T> takeUntil(d<? extends E> dVar) {
        return (d<T>) lift(new bv(dVar));
    }

    public final d<T> takeWhile(rx.functions.f<? super T, Boolean> fVar) {
        return (d<T>) lift(new bx(fVar));
    }

    public final d<T> takeUntil(rx.functions.f<? super T, Boolean> fVar) {
        return (d<T>) lift(new bw(fVar));
    }

    public final d<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, Schedulers.computation());
    }

    public final d<T> throttleFirst(long j, TimeUnit timeUnit, g gVar) {
        return (d<T>) lift(new by(j, timeUnit, gVar));
    }

    public final d<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final d<T> throttleLast(long j, TimeUnit timeUnit, g gVar) {
        return sample(j, timeUnit, gVar);
    }

    public final d<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final d<T> throttleWithTimeout(long j, TimeUnit timeUnit, g gVar) {
        return debounce(j, timeUnit, gVar);
    }

    public final d<rx.schedulers.a<T>> timeInterval() {
        return timeInterval(Schedulers.computation());
    }

    public final d<rx.schedulers.a<T>> timeInterval(g gVar) {
        return (d<rx.schedulers.a<T>>) lift(new bz(gVar));
    }

    public final <U, V> d<T> timeout(rx.functions.e<? extends d<U>> eVar, rx.functions.f<? super T, ? extends d<V>> fVar) {
        return timeout(eVar, fVar, (d) null);
    }

    public final <U, V> d<T> timeout(rx.functions.e<? extends d<U>> eVar, rx.functions.f<? super T, ? extends d<V>> fVar, d<? extends T> dVar) {
        if (fVar == null) {
            throw new NullPointerException("timeoutSelector is null");
        }
        return (d<T>) lift(new cc(eVar, fVar, dVar));
    }

    public final <V> d<T> timeout(rx.functions.f<? super T, ? extends d<V>> fVar) {
        return timeout((rx.functions.e) null, fVar, (d) null);
    }

    public final <V> d<T> timeout(rx.functions.f<? super T, ? extends d<V>> fVar, d<? extends T> dVar) {
        return timeout((rx.functions.e) null, fVar, dVar);
    }

    public final d<T> timeout(long j, TimeUnit timeUnit) {
        return timeout(j, timeUnit, null, Schedulers.computation());
    }

    public final d<T> timeout(long j, TimeUnit timeUnit, d<? extends T> dVar) {
        return timeout(j, timeUnit, dVar, Schedulers.computation());
    }

    public final d<T> timeout(long j, TimeUnit timeUnit, d<? extends T> dVar, g gVar) {
        return (d<T>) lift(new ca(j, timeUnit, dVar, gVar));
    }

    public final d<T> timeout(long j, TimeUnit timeUnit, g gVar) {
        return timeout(j, timeUnit, null, gVar);
    }

    public final d<rx.schedulers.b<T>> timestamp() {
        return timestamp(Schedulers.computation());
    }

    public final d<rx.schedulers.b<T>> timestamp(g gVar) {
        return (d<rx.schedulers.b<T>>) lift(new cd(gVar));
    }

    public final rx.observables.b<T> toBlocking() {
        return rx.observables.b.n(this);
    }

    public final d<List<T>> toList() {
        return (d<List<T>>) lift(ce.cdU());
    }

    public final <K> d<Map<K, T>> toMap(rx.functions.f<? super T, ? extends K> fVar) {
        return create(new z(this, fVar, UtilityFunctions.cew()));
    }

    public final <K, V> d<Map<K, V>> toMap(rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2) {
        return create(new z(this, fVar, fVar2));
    }

    public final <K, V> d<Map<K, V>> toMap(rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.e<? extends Map<K, V>> eVar) {
        return create(new z(this, fVar, fVar2, eVar));
    }

    public final <K> d<Map<K, Collection<T>>> toMultimap(rx.functions.f<? super T, ? extends K> fVar) {
        return create(new aa(this, fVar, UtilityFunctions.cew()));
    }

    public final <K, V> d<Map<K, Collection<V>>> toMultimap(rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2) {
        return create(new aa(this, fVar, fVar2));
    }

    public final <K, V> d<Map<K, Collection<V>>> toMultimap(rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.e<? extends Map<K, Collection<V>>> eVar) {
        return create(new aa(this, fVar, fVar2, eVar));
    }

    public final <K, V> d<Map<K, Collection<V>>> toMultimap(rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.e<? extends Map<K, Collection<V>>> eVar, rx.functions.f<? super K, ? extends Collection<V>> fVar3) {
        return create(new aa(this, fVar, fVar2, eVar, fVar3));
    }

    public final d<List<T>> toSortedList() {
        return (d<List<T>>) lift(new cf(10));
    }

    public final d<List<T>> toSortedList(rx.functions.g<? super T, ? super T, Integer> gVar) {
        return (d<List<T>>) lift(new cf(gVar, 10));
    }

    public final d<List<T>> toSortedList(int i) {
        return (d<List<T>>) lift(new cf(i));
    }

    public final d<List<T>> toSortedList(rx.functions.g<? super T, ? super T, Integer> gVar, int i) {
        return (d<List<T>>) lift(new cf(gVar, i));
    }

    public final d<T> sorted() {
        return (d<T>) toSortedList().flatMapIterable(UtilityFunctions.cew());
    }

    public final d<T> sorted(rx.functions.g<? super T, ? super T, Integer> gVar) {
        return (d<T>) toSortedList(gVar).flatMapIterable(UtilityFunctions.cew());
    }

    public final d<T> unsubscribeOn(g gVar) {
        return (d<T>) lift(new cg(gVar));
    }

    public final <U, R> d<R> withLatestFrom(d<? extends U> dVar, rx.functions.g<? super T, ? super U, ? extends R> gVar) {
        return lift(new cl(dVar, gVar));
    }

    public final <T1, T2, R> d<R> withLatestFrom(d<T1> dVar, d<T2> dVar2, rx.functions.h<? super T, ? super T1, ? super T2, R> hVar) {
        return create(new cm(this, new d[]{dVar, dVar2}, null, p.a(hVar)));
    }

    public final <T1, T2, T3, R> d<R> withLatestFrom(d<T1> dVar, d<T2> dVar2, d<T3> dVar3, rx.functions.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        return create(new cm(this, new d[]{dVar, dVar2, dVar3}, null, p.a(iVar)));
    }

    public final <T1, T2, T3, T4, R> d<R> withLatestFrom(d<T1> dVar, d<T2> dVar2, d<T3> dVar3, d<T4> dVar4, rx.functions.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        return create(new cm(this, new d[]{dVar, dVar2, dVar3, dVar4}, null, p.a(jVar)));
    }

    public final <T1, T2, T3, T4, T5, R> d<R> withLatestFrom(d<T1> dVar, d<T2> dVar2, d<T3> dVar3, d<T4> dVar4, d<T5> dVar5, rx.functions.k<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> kVar) {
        return create(new cm(this, new d[]{dVar, dVar2, dVar3, dVar4, dVar5}, null, p.a(kVar)));
    }

    public final <T1, T2, T3, T4, T5, T6, R> d<R> withLatestFrom(d<T1> dVar, d<T2> dVar2, d<T3> dVar3, d<T4> dVar4, d<T5> dVar5, d<T6> dVar6, l<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, R> lVar) {
        return create(new cm(this, new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6}, null, p.a(lVar)));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, R> d<R> withLatestFrom(d<T1> dVar, d<T2> dVar2, d<T3> dVar3, d<T4> dVar4, d<T5> dVar5, d<T6> dVar6, d<T7> dVar7, m<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, R> mVar) {
        return create(new cm(this, new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7}, null, p.a(mVar)));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> d<R> withLatestFrom(d<T1> dVar, d<T2> dVar2, d<T3> dVar3, d<T4> dVar4, d<T5> dVar5, d<T6> dVar6, d<T7> dVar7, d<T8> dVar8, rx.functions.n<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, R> nVar) {
        return create(new cm(this, new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8}, null, p.a(nVar)));
    }

    public final <R> d<R> withLatestFrom(d<?>[] dVarArr, o<R> oVar) {
        return create(new cm(this, dVarArr, null, oVar));
    }

    public final <R> d<R> withLatestFrom(Iterable<d<?>> iterable, o<R> oVar) {
        return create(new cm(this, null, iterable, oVar));
    }

    public final <TClosing> d<d<T>> window(rx.functions.e<? extends d<? extends TClosing>> eVar) {
        return (d<d<T>>) lift(new ci(eVar));
    }

    public final d<d<T>> window(int i) {
        return window(i, i);
    }

    public final d<d<T>> window(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("count > 0 required but it was " + i);
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("skip > 0 required but it was " + i2);
        }
        return (d<d<T>>) lift(new OperatorWindowWithSize(i, i2));
    }

    public final d<d<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Schedulers.computation());
    }

    public final d<d<T>> window(long j, long j2, TimeUnit timeUnit, g gVar) {
        return window(j, j2, timeUnit, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, gVar);
    }

    public final d<d<T>> window(long j, long j2, TimeUnit timeUnit, int i, g gVar) {
        return (d<d<T>>) lift(new ck(j, j2, timeUnit, i, gVar));
    }

    public final d<d<T>> window(long j, TimeUnit timeUnit) {
        return window(j, j, timeUnit, Schedulers.computation());
    }

    public final d<d<T>> window(long j, TimeUnit timeUnit, int i) {
        return window(j, timeUnit, i, Schedulers.computation());
    }

    public final d<d<T>> window(long j, TimeUnit timeUnit, int i, g gVar) {
        return window(j, j, timeUnit, i, gVar);
    }

    public final d<d<T>> window(long j, TimeUnit timeUnit, g gVar) {
        return window(j, timeUnit, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, gVar);
    }

    public final <TOpening, TClosing> d<d<T>> window(d<? extends TOpening> dVar, rx.functions.f<? super TOpening, ? extends d<? extends TClosing>> fVar) {
        return (d<d<T>>) lift(new cj(dVar, fVar));
    }

    public final <U> d<d<T>> window(d<U> dVar) {
        return (d<d<T>>) lift(new ch(dVar));
    }

    public final <T2, R> d<R> zipWith(Iterable<? extends T2> iterable, rx.functions.g<? super T, ? super T2, ? extends R> gVar) {
        return lift(new cn(iterable, gVar));
    }

    public final <T2, R> d<R> zipWith(d<? extends T2> dVar, rx.functions.g<? super T, ? super T2, ? extends R> gVar) {
        return zip(this, dVar, gVar);
    }

    public final rx.b.a<T> test() {
        rx.internal.a.a dA = rx.internal.a.a.dA(Long.MAX_VALUE);
        subscribe((e) dA);
        return dA;
    }

    public final rx.b.a<T> test(long j) {
        rx.internal.a.a dA = rx.internal.a.a.dA(j);
        subscribe((e) dA);
        return dA;
    }
}
