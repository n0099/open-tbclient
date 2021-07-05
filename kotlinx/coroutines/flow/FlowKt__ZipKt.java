package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.CombineKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001as\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001ag\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000b2*\b\u0004\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\f\u001aÁ\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032<\b\u0004\u0010\b\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0018\u001a§\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u000326\b\u0004\u0010\b\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u001a\u001a\u008d\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u000320\b\u0005\u0010\b\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u001c\u001a\u008e\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\b\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\"\u001a\u0084\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\b\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d¢\u0006\u0002\b%H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001ax\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000b2;\b\u0005\u0010\b\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d¢\u0006\u0002\b%H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010(\u001aÒ\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032M\b\u0005\u0010\b\u001aG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070)¢\u0006\u0002\b%H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010*\u001a¸\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032G\b\u0005\u0010\b\u001aA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017¢\u0006\u0002\b%H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010+\u001a\u009e\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032A\b\u0005\u0010\b\u001a;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019¢\u0006\u0002\b%H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010,\u001a¡\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\b\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010-\u001a\u008a\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\b\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\"\u001a\u009d\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\b\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010-\u001al\u00101\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"T", "R", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "transform", "combine", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "T1", "T2", "T3", "T4", "T5", "flow", "flow2", "flow3", "flow4", "flow5", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "combineTransform", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function7;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "flowCombine", "flowCombineTransform", "other", "zip", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes10.dex */
public final /* synthetic */ class FlowKt__ZipKt {
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt.flowCombine(flow, flow2, function3);
    }

    @JvmName(name = "flowCombine")
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> flowCombine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(flow, flow2, function3);
    }

    @JvmName(name = "flowCombineTransform")
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> flowCombineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, @BuilderInference Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$1(flow, flow2, function4, null));
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> zip(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return CombineKt.zipImpl(flow, flow2, function3);
    }

    @ExperimentalCoroutinesApi
    public static final /* synthetic */ <T, R> Flow<R> combine(Iterable<? extends Flow<? extends T>> iterable, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        Object[] array = CollectionsKt___CollectionsKt.toList(iterable).toArray(new Flow[0]);
        if (array != null) {
            Intrinsics.needClassReification();
            return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$6((Flow[]) array, function2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @ExperimentalCoroutinesApi
    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Iterable<? extends Flow<? extends T>> iterable, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3) {
        Object[] array = CollectionsKt___CollectionsKt.toList(iterable).toArray(new Flow[0]);
        if (array != null) {
            Intrinsics.needClassReification();
            return FlowKt.flow(new FlowKt__ZipKt$combineTransform$7((Flow[]) array, function3, null));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, @BuilderInference Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return new FlowKt__ZipKt$combine$$inlined$combine$1(new Flow[]{flow, flow2, flow3}, function4);
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, @BuilderInference Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransform$1(new Flow[]{flow, flow2}, null, function4));
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return new FlowKt__ZipKt$combine$$inlined$combine$2(new Flow[]{flow, flow2, flow3, flow4}, function5);
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, @BuilderInference Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> function5) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2(new Flow[]{flow, flow2, flow3}, null, function5));
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return new FlowKt__ZipKt$combine$$inlined$combine$3(new Flow[]{flow, flow2, flow3, flow4, flow5}, function6);
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, @BuilderInference Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> function6) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransform$3(new Flow[]{flow, flow2, flow3, flow4}, null, function6));
    }

    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, @BuilderInference Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> function7) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransform$4(new Flow[]{flow, flow2, flow3, flow4, flow5}, null, function7));
    }
}
