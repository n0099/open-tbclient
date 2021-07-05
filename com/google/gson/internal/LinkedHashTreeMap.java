package com.google.gson.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes7.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator<Comparable> NATURAL_ORDER;
    public transient /* synthetic */ FieldHolder $fh;
    public Comparator<? super K> comparator;
    public LinkedHashTreeMap<K, V>.EntrySet entrySet;
    public final Node<K, V> header;
    public LinkedHashTreeMap<K, V>.KeySet keySet;
    public int modCount;
    public int size;
    public Node<K, V>[] table;
    public int threshold;

    /* loaded from: classes7.dex */
    public static final class AvlBuilder<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int leavesSkipped;
        public int leavesToSkip;
        public int size;
        public Node<K, V> stack;

        public AvlBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void add(Node<K, V> node) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, node) != null) {
                return;
            }
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int i2 = this.leavesToSkip;
            if (i2 > 0) {
                int i3 = this.size;
                if ((i3 & 1) == 0) {
                    this.size = i3 + 1;
                    this.leavesToSkip = i2 - 1;
                    this.leavesSkipped++;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            int i4 = this.size + 1;
            this.size = i4;
            int i5 = this.leavesToSkip;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.size = i4 + 1;
                this.leavesToSkip = i5 - 1;
                this.leavesSkipped++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.size & i7) != i7) {
                    return;
                }
                int i8 = this.leavesSkipped;
                if (i8 == 0) {
                    Node<K, V> node2 = this.stack;
                    Node<K, V> node3 = node2.parent;
                    Node<K, V> node4 = node3.parent;
                    node3.parent = node4.parent;
                    this.stack = node3;
                    node3.left = node4;
                    node3.right = node2;
                    node3.height = node2.height + 1;
                    node4.parent = node3;
                    node2.parent = node3;
                } else if (i8 == 1) {
                    Node<K, V> node5 = this.stack;
                    Node<K, V> node6 = node5.parent;
                    this.stack = node6;
                    node6.right = node5;
                    node6.height = node5.height + 1;
                    node5.parent = node6;
                    this.leavesSkipped = 0;
                } else if (i8 == 2) {
                    this.leavesSkipped = 0;
                }
                i6 *= 2;
            }
        }

        public void reset(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.leavesToSkip = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
                this.size = 0;
                this.leavesSkipped = 0;
                this.stack = null;
            }
        }

        public Node<K, V> root() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Node<K, V> node = this.stack;
                if (node.parent == null) {
                    return node;
                }
                throw new IllegalStateException();
            }
            return (Node) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class AvlIterator<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Node<K, V> stackTop;

        public AvlIterator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Node<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (Node) invokeV.objValue;
            }
            Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            Node<K, V> node2 = node.parent;
            node.parent = null;
            Node<K, V> node3 = node.right;
            while (true) {
                Node<K, V> node4 = node2;
                node2 = node3;
                if (node2 != null) {
                    node2.parent = node4;
                    node3 = node2.left;
                } else {
                    this.stackTop = node4;
                    return node;
                }
            }
        }

        public void reset(Node<K, V> node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, node) == null) {
                Node<K, V> node2 = null;
                while (node != null) {
                    node.parent = node2;
                    node2 = node;
                    node = node.left;
                }
                this.stackTop = node2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedHashTreeMap this$0;

        public EntrySet(LinkedHashTreeMap linkedHashTreeMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedHashTreeMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedHashTreeMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof Map.Entry) && this.this$0.findByEntry((Map.Entry) obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>(this) { // from class: com.google.gson.internal.LinkedHashTreeMap.EntrySet.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EntrySet this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            LinkedHashTreeMap linkedHashTreeMap = (LinkedHashTreeMap) newInitContext.callArgs[0];
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    LinkedHashTreeMap linkedHashTreeMap2 = this.this$0;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? nextNode() : (Map.Entry) invokeV2.objValue;
                }
            } : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Node<K, V> findByEntry;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if ((obj instanceof Map.Entry) && (findByEntry = this.this$0.findByEntry((Map.Entry) obj)) != null) {
                    this.this$0.removeInternal(findByEntry, true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.this$0.size : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class KeySet extends AbstractSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedHashTreeMap this$0;

        public KeySet(LinkedHashTreeMap linkedHashTreeMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedHashTreeMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedHashTreeMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.this$0.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>(this) { // from class: com.google.gson.internal.LinkedHashTreeMap.KeySet.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KeySet this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            LinkedHashTreeMap linkedHashTreeMap = (LinkedHashTreeMap) newInitContext.callArgs[0];
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    LinkedHashTreeMap linkedHashTreeMap2 = this.this$0;
                }

                @Override // java.util.Iterator
                public K next() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? nextNode().key : (K) invokeV2.objValue;
                }
            } : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.this$0.removeInternalByKey(obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.this$0.size : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int expectedModCount;
        public Node<K, V> lastReturned;
        public Node<K, V> next;
        public final /* synthetic */ LinkedHashTreeMap this$0;

        public LinkedTreeMapIterator(LinkedHashTreeMap linkedHashTreeMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedHashTreeMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedHashTreeMap;
            LinkedHashTreeMap linkedHashTreeMap2 = this.this$0;
            this.next = linkedHashTreeMap2.header.next;
            this.lastReturned = null;
            this.expectedModCount = linkedHashTreeMap2.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.next != this.this$0.header : invokeV.booleanValue;
        }

        public final Node<K, V> nextNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Node<K, V> node = this.next;
                LinkedHashTreeMap linkedHashTreeMap = this.this$0;
                if (node != linkedHashTreeMap.header) {
                    if (linkedHashTreeMap.modCount == this.expectedModCount) {
                        this.next = node.next;
                        this.lastReturned = node;
                        return node;
                    }
                    throw new ConcurrentModificationException();
                }
                throw new NoSuchElementException();
            }
            return (Node) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Node<K, V> node = this.lastReturned;
                if (node != null) {
                    this.this$0.removeInternal(node, true);
                    this.lastReturned = null;
                    this.expectedModCount = this.this$0.modCount;
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-725874130, "Lcom/google/gson/internal/LinkedHashTreeMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-725874130, "Lcom/google/gson/internal/LinkedHashTreeMap;");
                return;
            }
        }
        NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedHashTreeMap.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Comparable comparable, Comparable comparable2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, comparable, comparable2)) == null) ? comparable.compareTo(comparable2) : invokeLL.intValue;
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Comparator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void doubleCapacity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Node<K, V>[] doubleCapacity = doubleCapacity(this.table);
            this.table = doubleCapacity;
            this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
        }
    }

    private boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    private void rebalance(Node<K, V> node, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, node, z) == null) {
            while (node != null) {
                Node<K, V> node2 = node.left;
                Node<K, V> node3 = node.right;
                int i2 = node2 != null ? node2.height : 0;
                int i3 = node3 != null ? node3.height : 0;
                int i4 = i2 - i3;
                if (i4 == -2) {
                    Node<K, V> node4 = node3.left;
                    Node<K, V> node5 = node3.right;
                    int i5 = (node4 != null ? node4.height : 0) - (node5 != null ? node5.height : 0);
                    if (i5 != -1 && (i5 != 0 || z)) {
                        rotateRight(node3);
                        rotateLeft(node);
                    } else {
                        rotateLeft(node);
                    }
                    if (z) {
                        return;
                    }
                } else if (i4 == 2) {
                    Node<K, V> node6 = node2.left;
                    Node<K, V> node7 = node2.right;
                    int i6 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                    if (i6 != 1 && (i6 != 0 || z)) {
                        rotateLeft(node2);
                        rotateRight(node);
                    } else {
                        rotateRight(node);
                    }
                    if (z) {
                        return;
                    }
                } else if (i4 == 0) {
                    node.height = i2 + 1;
                    if (z) {
                        return;
                    }
                } else {
                    node.height = Math.max(i2, i3) + 1;
                    if (!z) {
                        return;
                    }
                }
                node = node.parent;
            }
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, node, node2) == null) {
            Node<K, V> node3 = node.parent;
            node.parent = null;
            if (node2 != null) {
                node2.parent = node3;
            }
            if (node3 != null) {
                if (node3.left == node) {
                    node3.left = node2;
                    return;
                } else {
                    node3.right = node2;
                    return;
                }
            }
            int i2 = node.hash;
            Node<K, V>[] nodeArr = this.table;
            nodeArr[i2 & (nodeArr.length - 1)] = node2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, node) == null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            Node<K, V> node4 = node3.left;
            Node<K, V> node5 = node3.right;
            node.right = node4;
            if (node4 != null) {
                node4.parent = node;
            }
            replaceInParent(node, node3);
            node3.left = node;
            node.parent = node3;
            int max = Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
            node.height = max;
            node3.height = Math.max(max, node5 != null ? node5.height : 0) + 1;
        }
    }

    private void rotateRight(Node<K, V> node) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, node) == null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            Node<K, V> node4 = node2.left;
            Node<K, V> node5 = node2.right;
            node.left = node5;
            if (node5 != null) {
                node5.parent = node;
            }
            replaceInParent(node, node2);
            node2.right = node;
            node.parent = node2;
            int max = Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
            node.height = max;
            node2.height = Math.max(max, node4 != null ? node4.height : 0) + 1;
        }
    }

    public static int secondaryHash(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
            return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
        }
        return invokeI.intValue;
    }

    private Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? new LinkedHashMap(this) : invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Arrays.fill(this.table, (Object) null);
            this.size = 0;
            this.modCount++;
            Node<K, V> node = this.header;
            Node<K, V> node2 = node.next;
            while (node2 != node) {
                Node<K, V> node3 = node2.next;
                node2.prev = null;
                node2.next = null;
                node2 = node3;
            }
            node.prev = node;
            node.next = node;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? findByObject(obj) != null : invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinkedHashTreeMap<K, V>.EntrySet entrySet = this.entrySet;
            if (entrySet != null) {
                return entrySet;
            }
            LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new EntrySet(this);
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r7v2. Raw type applied. Possible types: K, ? super K */
    public Node<K, V> find(K k, boolean z) {
        InterceptResult invokeLZ;
        Node<K, V> node;
        int i2;
        Node<K, V> node2;
        int compare;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, k, z)) == null) {
            Comparator<? super K> comparator = this.comparator;
            Node<K, V>[] nodeArr = this.table;
            int secondaryHash = secondaryHash(k.hashCode());
            int length = (nodeArr.length - 1) & secondaryHash;
            Node<K, V> node3 = nodeArr[length];
            if (node3 != null) {
                Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
                while (true) {
                    if (comparable != null) {
                        compare = comparable.compareTo(node3.key);
                    } else {
                        compare = comparator.compare(k, (K) node3.key);
                    }
                    if (compare == 0) {
                        return node3;
                    }
                    Node<K, V> node4 = compare < 0 ? node3.left : node3.right;
                    if (node4 == null) {
                        node = node3;
                        i2 = compare;
                        break;
                    }
                    node3 = node4;
                }
            } else {
                node = node3;
                i2 = 0;
            }
            if (z) {
                Node<K, V> node5 = this.header;
                if (node == null) {
                    if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                        throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                    }
                    node2 = new Node<>(node, k, secondaryHash, node5, node5.prev);
                    nodeArr[length] = node2;
                } else {
                    node2 = new Node<>(node, k, secondaryHash, node5, node5.prev);
                    if (i2 < 0) {
                        node.left = node2;
                    } else {
                        node.right = node2;
                    }
                    rebalance(node, true);
                }
                int i3 = this.size;
                this.size = i3 + 1;
                if (i3 > this.threshold) {
                    doubleCapacity();
                }
                this.modCount++;
                return node2;
            }
            return null;
        }
        return (Node) invokeLZ.objValue;
    }

    public Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, entry)) == null) {
            Node<K, V> findByObject = findByObject(entry.getKey());
            if (findByObject != null && equal(findByObject.value, entry.getValue())) {
                return findByObject;
            }
            return null;
        }
        return (Node) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public Node<K, V> findByObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj != 0) {
                try {
                    return find(obj, false);
                } catch (ClassCastException unused) {
                    return null;
                }
            }
            return null;
        }
        return (Node) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            Node<K, V> findByObject = findByObject(obj);
            if (findByObject != null) {
                return findByObject.value;
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinkedHashTreeMap<K, V>.KeySet keySet = this.keySet;
            if (keySet != null) {
                return keySet;
            }
            LinkedHashTreeMap<K, V>.KeySet keySet2 = new KeySet(this);
            this.keySet = keySet2;
            return keySet2;
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, v)) == null) {
            if (k != null) {
                Node<K, V> find = find(k, true);
                V v2 = find.value;
                find.value = v;
                return v2;
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            Node<K, V> removeInternalByKey = removeInternalByKey(obj);
            if (removeInternalByKey != null) {
                return removeInternalByKey.value;
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public void removeInternal(Node<K, V> node, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, node, z) == null) {
            if (z) {
                Node<K, V> node2 = node.prev;
                node2.next = node.next;
                node.next.prev = node2;
                node.prev = null;
                node.next = null;
            }
            Node<K, V> node3 = node.left;
            Node<K, V> node4 = node.right;
            Node<K, V> node5 = node.parent;
            int i3 = 0;
            if (node3 != null && node4 != null) {
                Node<K, V> last = node3.height > node4.height ? node3.last() : node4.first();
                removeInternal(last, false);
                Node<K, V> node6 = node.left;
                if (node6 != null) {
                    i2 = node6.height;
                    last.left = node6;
                    node6.parent = last;
                    node.left = null;
                } else {
                    i2 = 0;
                }
                Node<K, V> node7 = node.right;
                if (node7 != null) {
                    i3 = node7.height;
                    last.right = node7;
                    node7.parent = last;
                    node.right = null;
                }
                last.height = Math.max(i2, i3) + 1;
                replaceInParent(node, last);
                return;
            }
            if (node3 != null) {
                replaceInParent(node, node3);
                node.left = null;
            } else if (node4 != null) {
                replaceInParent(node, node4);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node5, false);
            this.size--;
            this.modCount++;
        }
    }

    public Node<K, V> removeInternalByKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            Node<K, V> findByObject = findByObject(obj);
            if (findByObject != null) {
                removeInternal(findByObject, true);
            }
            return findByObject;
        }
        return (Node) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.size : invokeV.intValue;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new Node<>();
        Node<K, V>[] nodeArr = new Node[16];
        this.table = nodeArr;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    public static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] nodeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, nodeArr)) == null) {
            int length = nodeArr.length;
            Node<K, V>[] nodeArr2 = new Node[length * 2];
            AvlIterator avlIterator = new AvlIterator();
            AvlBuilder avlBuilder = new AvlBuilder();
            AvlBuilder avlBuilder2 = new AvlBuilder();
            for (int i2 = 0; i2 < length; i2++) {
                Node<K, V> node = nodeArr[i2];
                if (node != null) {
                    avlIterator.reset(node);
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        Node<K, V> next = avlIterator.next();
                        if (next == null) {
                            break;
                        } else if ((next.hash & length) == 0) {
                            i3++;
                        } else {
                            i4++;
                        }
                    }
                    avlBuilder.reset(i3);
                    avlBuilder2.reset(i4);
                    avlIterator.reset(node);
                    while (true) {
                        Node<K, V> next2 = avlIterator.next();
                        if (next2 == null) {
                            break;
                        } else if ((next2.hash & length) == 0) {
                            avlBuilder.add(next2);
                        } else {
                            avlBuilder2.add(next2);
                        }
                    }
                    nodeArr2[i2] = i3 > 0 ? avlBuilder.root() : null;
                    nodeArr2[i2 + length] = i4 > 0 ? avlBuilder2.root() : null;
                }
            }
            return nodeArr2;
        }
        return (Node[]) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int hash;
        public int height;
        public final K key;
        public Node<K, V> left;
        public Node<K, V> next;
        public Node<K, V> parent;
        public Node<K, V> prev;
        public Node<K, V> right;
        public V value;

        public Node() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    K k = this.key;
                    if (k == null) {
                        if (entry.getKey() != null) {
                            return false;
                        }
                    } else if (!k.equals(entry.getKey())) {
                        return false;
                    }
                    V v = this.value;
                    if (v == null) {
                        if (entry.getValue() != null) {
                            return false;
                        }
                    } else if (!v.equals(entry.getValue())) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public Node<K, V> first() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Node<K, V> node = this;
                for (Node<K, V> node2 = this.left; node2 != null; node2 = node2.left) {
                    node = node2;
                }
                return node;
            }
            return (Node) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.key : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.value : (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                K k = this.key;
                int hashCode = k == null ? 0 : k.hashCode();
                V v = this.value;
                return hashCode ^ (v != null ? v.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public Node<K, V> last() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Node<K, V> node = this;
                for (Node<K, V> node2 = this.right; node2 != null; node2 = node2.right) {
                    node = node2;
                }
                return node;
            }
            return (Node) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v)) == null) {
                V v2 = this.value;
                this.value = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.key + "=" + this.value;
            }
            return (String) invokeV.objValue;
        }

        public Node(Node<K, V> node, K k, int i2, Node<K, V> node2, Node<K, V> node3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {node, k, Integer.valueOf(i2), node2, node3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.parent = node;
            this.key = k;
            this.hash = i2;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}
