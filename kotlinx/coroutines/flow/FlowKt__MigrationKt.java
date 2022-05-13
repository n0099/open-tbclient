package kotlinx.coroutines.flow;

import com.baidu.android.imsdk.db.TableDefine;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.tachikoma.core.component.anim.AnimationProperty;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\u001a\u000f\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a½\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00050\n\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\b\"\u0004\b\u0005\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00040\n2<\b\u0004\u0010\u0012\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a£\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00040\n\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\n26\b\u0004\u0010\u0012\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0016\u001a\u0089\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00030\n\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\n20\b\u0004\u0010\u0012\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0018\u001al\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\n\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2(\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u001a\u001aP\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2#\u0010\u001e\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u001c¢\u0006\u0002\b\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 \u001aE\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u001cH\u0007¢\u0006\u0004\b\"\u0010 \u001a-\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010#\u001a\u00028\u0000H\u0007¢\u0006\u0004\b$\u0010%\u001a3\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b$\u0010&\u001a-\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b)\u0010*\u001a-\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b+\u0010*\u001aX\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2(\u0010!\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a+\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\nH\u0007¢\u0006\u0004\b/\u00100\u001aU\u00105\u001a\u000203\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n21\u00104\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a+\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\nH\u0007¢\u0006\u0004\b7\u00100\u001a-\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b:\u0010;\u001a3\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b=\u0010&\u001a3\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b>\u0010&\u001a-\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010<\u001a\u00028\u0000H\u0007¢\u0006\u0004\b?\u0010%\u001aC\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010<\u001a\u00028\u00002\u0014\b\u0002\u0010B\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0\u001cH\u0007¢\u0006\u0004\b?\u0010C\u001a-\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bD\u0010;\u001a\u0080\u0001\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010E\u001a\u00028\u00012H\b\u0001\u0010G\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(F\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a-\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0004\bL\u0010M\u001a-\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010#\u001a\u00028\u0000H\u0007¢\u0006\u0004\bN\u0010%\u001a3\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\bN\u0010&\u001a\u001f\u0010O\u001a\u000203\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\bO\u0010P\u001aF\u0010O\u001a\u000203\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\"\u0010Q\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u00106\u001aj\u0010O\u001a\u000203\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\"\u0010Q\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,2\"\u0010R\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010S\u001a-\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bT\u0010;\u001ag\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n27\u0010\u0012\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(#\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010.\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006V"}, d2 = {"", "noImpl$FlowKt__MigrationKt", "()Ljava/lang/Void;", "noImpl", "T1", "T2", "T3", "T4", "T5", "R", "Lkotlinx/coroutines/flow/Flow;", "other", "other2", "other3", "other4", "Lkotlin/Function6;", "Lkotlin/coroutines/Continuation;", "", AnimationProperty.TRANSFORM, "combineLatest", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "transformer", "compose", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/Function1;)Lkotlinx/coroutines/flow/Flow;", "mapper", "concatMap", "value", "concatWith", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "timeMillis", "delayEach", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "delayFlow", "Lkotlin/Function2;", "flatMap", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatten", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "merge", "Lkotlin/coroutines/CoroutineContext;", "context", "observeOn", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "fallback", "onErrorResume", "onErrorResumeNext", "onErrorReturn", "", "", "predicate", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "publishOn", "initial", "accumulator", "operation", "scanFold", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "", "count", FreeSpaceBox.TYPE, "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "startWith", TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, "(Lkotlinx/coroutines/flow/Flow;)V", "onEach", "onError", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "subscribeOn", "switchMap", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes8.dex */
public final /* synthetic */ class FlowKt__MigrationKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    public static final <T1, T2, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt.combine(flow, flow2, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    public static final <T, R> Flow<R> compose(Flow<? extends T> flow, Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> concatMap(Flow<? extends T> flow, Function1<? super T, ? extends Flow<? extends R>> function1) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, T t) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayEach(Flow<? extends T> flow, long j) {
        return FlowKt.onEach(flow, new FlowKt__MigrationKt$delayEach$1(j, null));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayFlow(Flow<? extends T> flow, long j) {
        return FlowKt.onStart(flow, new FlowKt__MigrationKt$delayFlow$1(j, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is named flatMapConcat", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> flatMap(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> flatten(Flow<? extends Flow<? extends T>> flow) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    public static final <T> void forEach(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> merge(Flow<? extends Flow<? extends T>> flow) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    public static final Void noImpl$FlowKt__MigrationKt() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> observeOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResume(Flow<? extends T> flow, Flow<? extends T> flow2) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResumeNext(Flow<? extends T> flow, Flow<? extends T> flow2) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = FlowKt__MigrationKt$onErrorReturn$1.INSTANCE;
        }
        return FlowKt.onErrorReturn(flow, obj, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> publishOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> Flow<R> scanFold(Flow<? extends T> flow, R r, @BuilderInference Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    public static final <T> Flow<T> skip(Flow<? extends T> flow, int i) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> Flow<T> startWith(Flow<? extends T> flow, T t) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(Flow<? extends T> flow) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use flowOn instead")
    public static final <T> Flow<T> subscribeOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> Flow<R> switchMap(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$1(new Flow[]{flow, flow2, flow3}, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t, Function1<? super Throwable, Boolean> function1) {
        return FlowKt.m2089catch(flow, new FlowKt__MigrationKt$onErrorReturn$2(function1, t, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> startWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$2(new Flow[]{flow, flow2, flow3, flow4}, function5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$3(new Flow[]{flow, flow2, flow3, flow4, flow5}, function6);
    }
}
