package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
/* loaded from: classes2.dex */
public final class SignatureEnhancementBuilder {
    public final Map<String, PredefinedFunctionEnhancementInfo> signatures = new LinkedHashMap();

    /* loaded from: classes2.dex */
    public final class ClassEnhancementBuilder {
        public final String className;

        /* loaded from: classes2.dex */
        public final class FunctionEnhancementBuilder {
            public final String functionName;
            public final List<Pair<String, TypeEnhancementInfo>> parameters = new ArrayList();
            public Pair<String, TypeEnhancementInfo> returnType = TuplesKt.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);

            public FunctionEnhancementBuilder(String str) {
                this.functionName = str;
            }

            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                String className = ClassEnhancementBuilder.this.getClassName();
                String str = this.functionName;
                List<Pair<String, TypeEnhancementInfo>> list = this.parameters;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                String signature = signatureBuildingComponents.signature(className, signatureBuildingComponents.jvmDescriptor(str, arrayList, this.returnType.getFirst()));
                TypeEnhancementInfo second = this.returnType.getSecond();
                List<Pair<String, TypeEnhancementInfo>> list2 = this.parameters;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((TypeEnhancementInfo) ((Pair) it2.next()).getSecond());
                }
                return TuplesKt.to(signature, new PredefinedFunctionEnhancementInfo(second, arrayList2));
            }

            public final void parameter(String str, JavaTypeQualifiers... javaTypeQualifiersArr) {
                boolean z;
                TypeEnhancementInfo typeEnhancementInfo;
                List<Pair<String, TypeEnhancementInfo>> list = this.parameters;
                if (javaTypeQualifiersArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    typeEnhancementInfo = null;
                } else {
                    Iterable<IndexedValue> withIndex = ArraysKt___ArraysKt.withIndex(javaTypeQualifiersArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10)), 16));
                    for (IndexedValue indexedValue : withIndex) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                    }
                    typeEnhancementInfo = new TypeEnhancementInfo(linkedHashMap);
                }
                list.add(TuplesKt.to(str, typeEnhancementInfo));
            }

            public final void returns(String str, JavaTypeQualifiers... javaTypeQualifiersArr) {
                Iterable<IndexedValue> withIndex = ArraysKt___ArraysKt.withIndex(javaTypeQualifiersArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10)), 16));
                for (IndexedValue indexedValue : withIndex) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                }
                this.returnType = TuplesKt.to(str, new TypeEnhancementInfo(linkedHashMap));
            }

            public final void returns(JvmPrimitiveType jvmPrimitiveType) {
                this.returnType = TuplesKt.to(jvmPrimitiveType.getDesc(), null);
            }
        }

        public ClassEnhancementBuilder(String str) {
            this.className = str;
        }

        public final void function(String str, Function1<? super FunctionEnhancementBuilder, Unit> function1) {
            Map map = SignatureEnhancementBuilder.this.signatures;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(str);
            function1.invoke(functionEnhancementBuilder);
            Pair<String, PredefinedFunctionEnhancementInfo> build = functionEnhancementBuilder.build();
            map.put(build.getFirst(), build.getSecond());
        }

        public final String getClassName() {
            return this.className;
        }
    }

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }
}
