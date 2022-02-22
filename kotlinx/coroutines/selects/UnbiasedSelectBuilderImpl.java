package kotlinx.coroutines.selects;

import androidx.transition.Transition;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectBuilder;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0015\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\t\u0010\nJ8\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\b0\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0013\u001a\u00020\u0005*\u00020\u00122\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\b0\rH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014JG\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u00028\u00010\u00162\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0017H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0018J[\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0019\"\u0004\b\u0002\u0010\u0015*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0017H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u001cR5\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e`\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "e", "", "handleBuilderException", "(Ljava/lang/Throwable;)V", "", "initSelectResult", "()Ljava/lang/Object;", "", "timeMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "clauses", "Ljava/util/ArrayList;", "getClauses", "()Ljava/util/ArrayList;", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", Transition.MATCH_INSTANCE_STR, "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "getInstance", "()Lkotlinx/coroutines/selects/SelectBuilderImpl;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@PublishedApi
/* loaded from: classes5.dex */
public final class UnbiasedSelectBuilderImpl<R> implements SelectBuilder<R> {
    public final ArrayList<Function0<Unit>> clauses = new ArrayList<>();
    public final SelectBuilderImpl<R> instance;

    public UnbiasedSelectBuilderImpl(Continuation<? super R> continuation) {
        this.instance = new SelectBuilderImpl<>(continuation);
    }

    public final ArrayList<Function0<Unit>> getClauses() {
        return this.clauses;
    }

    public final SelectBuilderImpl<R> getInstance() {
        return this.instance;
    }

    @PublishedApi
    public final void handleBuilderException(Throwable th) {
        this.instance.handleBuilderException(th);
    }

    @PublishedApi
    public final Object initSelectResult() {
        if (!this.instance.isSelected()) {
            try {
                Collections.shuffle(this.clauses);
                Iterator<T> it = this.clauses.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
            } catch (Throwable th) {
                this.instance.handleBuilderException(th);
            }
        }
        return this.instance.getResult();
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j2, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.clauses.add(new UnbiasedSelectBuilderImpl$onTimeout$1(this, j2, function1));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.clauses.add(new UnbiasedSelectBuilderImpl$invoke$1(this, selectClause0, function1));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.clauses.add(new UnbiasedSelectBuilderImpl$invoke$2(this, selectClause1, function2));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.clauses.add(new UnbiasedSelectBuilderImpl$invoke$3(this, selectClause2, p, function2));
    }
}
