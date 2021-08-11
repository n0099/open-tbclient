package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes10.dex */
public final class SortedLists {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static abstract class KeyAbsentBehavior {
        public static final /* synthetic */ KeyAbsentBehavior[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX;
        public static final KeyAbsentBehavior NEXT_HIGHER;
        public static final KeyAbsentBehavior NEXT_LOWER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1703528694, "Lcom/google/common/collect/SortedLists$KeyAbsentBehavior;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1703528694, "Lcom/google/common/collect/SortedLists$KeyAbsentBehavior;");
                    return;
                }
            }
            NEXT_LOWER = new KeyAbsentBehavior("NEXT_LOWER", 0) { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
                public int resultIndex(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? i2 - 1 : invokeI.intValue;
                }
            };
            NEXT_HIGHER = new KeyAbsentBehavior("NEXT_HIGHER", 1) { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
                public int resultIndex(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? i2 : invokeI.intValue;
                }
            };
            KeyAbsentBehavior keyAbsentBehavior = new KeyAbsentBehavior("INVERTED_INSERTION_INDEX", 2) { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
                public int resultIndex(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? ~i2 : invokeI.intValue;
                }
            };
            INVERTED_INSERTION_INDEX = keyAbsentBehavior;
            $VALUES = new KeyAbsentBehavior[]{NEXT_LOWER, NEXT_HIGHER, keyAbsentBehavior};
        }

        public KeyAbsentBehavior(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static KeyAbsentBehavior valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (KeyAbsentBehavior) Enum.valueOf(KeyAbsentBehavior.class, str) : (KeyAbsentBehavior) invokeL.objValue;
        }

        public static KeyAbsentBehavior[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (KeyAbsentBehavior[]) $VALUES.clone() : (KeyAbsentBehavior[]) invokeV.objValue;
        }

        public abstract int resultIndex(int i2);

        public /* synthetic */ KeyAbsentBehavior(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static abstract class KeyPresentBehavior {
        public static final /* synthetic */ KeyPresentBehavior[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final KeyPresentBehavior ANY_PRESENT;
        public static final KeyPresentBehavior FIRST_AFTER;
        public static final KeyPresentBehavior FIRST_PRESENT;
        public static final KeyPresentBehavior LAST_BEFORE;
        public static final KeyPresentBehavior LAST_PRESENT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(8737492, "Lcom/google/common/collect/SortedLists$KeyPresentBehavior;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(8737492, "Lcom/google/common/collect/SortedLists$KeyPresentBehavior;");
                    return;
                }
            }
            ANY_PRESENT = new KeyPresentBehavior("ANY_PRESENT", 0) { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(1048576, this, comparator, e2, list, i2)) == null) ? i2 : invokeLLLI.intValue;
                }
            };
            LAST_PRESENT = new KeyPresentBehavior("LAST_PRESENT", 1) { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
                /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: E, ? super E */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(1048576, this, comparator, e2, list, i2)) == null) {
                        int size = list.size() - 1;
                        while (i2 < size) {
                            int i3 = ((i2 + size) + 1) >>> 1;
                            if (comparator.compare((E) list.get(i3), e2) > 0) {
                                size = i3 - 1;
                            } else {
                                i2 = i3;
                            }
                        }
                        return i2;
                    }
                    return invokeLLLI.intValue;
                }
            };
            FIRST_PRESENT = new KeyPresentBehavior("FIRST_PRESENT", 2) { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
                /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: E, ? super E */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(1048576, this, comparator, e2, list, i2)) == null) {
                        int i3 = 0;
                        while (i3 < i2) {
                            int i4 = (i3 + i2) >>> 1;
                            if (comparator.compare((E) list.get(i4), e2) < 0) {
                                i3 = i4 + 1;
                            } else {
                                i2 = i4;
                            }
                        }
                        return i3;
                    }
                    return invokeLLLI.intValue;
                }
            };
            FIRST_AFTER = new KeyPresentBehavior("FIRST_AFTER", 3) { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(1048576, this, comparator, e2, list, i2)) == null) ? KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e2, list, i2) + 1 : invokeLLLI.intValue;
                }
            };
            KeyPresentBehavior keyPresentBehavior = new KeyPresentBehavior("LAST_BEFORE", 4) { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(1048576, this, comparator, e2, list, i2)) == null) ? KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e2, list, i2) - 1 : invokeLLLI.intValue;
                }
            };
            LAST_BEFORE = keyPresentBehavior;
            $VALUES = new KeyPresentBehavior[]{ANY_PRESENT, LAST_PRESENT, FIRST_PRESENT, FIRST_AFTER, keyPresentBehavior};
        }

        public KeyPresentBehavior(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static KeyPresentBehavior valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (KeyPresentBehavior) Enum.valueOf(KeyPresentBehavior.class, str) : (KeyPresentBehavior) invokeL.objValue;
        }

        public static KeyPresentBehavior[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (KeyPresentBehavior[]) $VALUES.clone() : (KeyPresentBehavior[]) invokeV.objValue;
        }

        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2);

        public /* synthetic */ KeyPresentBehavior(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static <E, K extends Comparable> int a(List<E> list, g<? super E, K> gVar, K k, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, list, gVar, k, keyPresentBehavior, keyAbsentBehavior)) == null) ? b(list, gVar, k, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior) : invokeLLLLL.intValue;
    }

    public static <E, K> int b(List<E> list, g<? super E, K> gVar, K k, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, gVar, k, comparator, keyPresentBehavior, keyAbsentBehavior})) == null) ? c(Lists.n(list, gVar), k, comparator, keyPresentBehavior, keyAbsentBehavior) : invokeCommon.intValue;
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: E, ? super E */
    public static <E> int c(List<? extends E> list, E e2, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, list, e2, comparator, keyPresentBehavior, keyAbsentBehavior)) == null) {
            n.p(comparator);
            n.p(list);
            n.p(keyPresentBehavior);
            n.p(keyAbsentBehavior);
            if (!(list instanceof RandomAccess)) {
                list = Lists.j(list);
            }
            int i2 = 0;
            int size = list.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                int compare = comparator.compare(e2, (E) list.get(i3));
                if (compare < 0) {
                    size = i3 - 1;
                } else if (compare <= 0) {
                    return i2 + keyPresentBehavior.resultIndex(comparator, e2, list.subList(i2, size + 1), i3 - i2);
                } else {
                    i2 = i3 + 1;
                }
            }
            return keyAbsentBehavior.resultIndex(i2);
        }
        return invokeLLLLL.intValue;
    }
}
