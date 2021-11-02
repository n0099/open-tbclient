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
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator<Comparable> NATURAL_ORDER;
    public transient /* synthetic */ FieldHolder $fh;
    public Comparator<? super K> comparator;
    public LinkedTreeMap<K, V>.EntrySet entrySet;
    public final Node<K, V> header;
    public LinkedTreeMap<K, V>.KeySet keySet;
    public int modCount;
    public Node<K, V> root;
    public int size;

    /* loaded from: classes2.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedTreeMap this$0;

        public EntrySet(LinkedTreeMap linkedTreeMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedTreeMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedTreeMap;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>(this) { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
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
                            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) newInitContext.callArgs[0];
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    LinkedTreeMap linkedTreeMap2 = this.this$0;
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

    /* loaded from: classes2.dex */
    public final class KeySet extends AbstractSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedTreeMap this$0;

        public KeySet(LinkedTreeMap linkedTreeMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedTreeMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedTreeMap;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>(this) { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
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
                            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) newInitContext.callArgs[0];
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    LinkedTreeMap linkedTreeMap2 = this.this$0;
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

    /* loaded from: classes2.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int expectedModCount;
        public Node<K, V> lastReturned;
        public Node<K, V> next;
        public final /* synthetic */ LinkedTreeMap this$0;

        public LinkedTreeMapIterator(LinkedTreeMap linkedTreeMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedTreeMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedTreeMap;
            LinkedTreeMap linkedTreeMap2 = this.this$0;
            this.next = linkedTreeMap2.header.next;
            this.lastReturned = null;
            this.expectedModCount = linkedTreeMap2.modCount;
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
                LinkedTreeMap linkedTreeMap = this.this$0;
                if (node != linkedTreeMap.header) {
                    if (linkedTreeMap.modCount == this.expectedModCount) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1807795072, "Lcom/google/gson/internal/LinkedTreeMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1807795072, "Lcom/google/gson/internal/LinkedTreeMap;");
                return;
            }
        }
        NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
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
    public LinkedTreeMap() {
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

    private boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    private void rebalance(Node<K, V> node, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, node, z) == null) {
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
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, node, node2) == null) {
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
            this.root = node2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, node) == null) {
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
        if (interceptable == null || interceptable.invokeL(65543, this, node) == null) {
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

    private Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new LinkedHashMap(this) : invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.root = null;
            this.size = 0;
            this.modCount++;
            Node<K, V> node = this.header;
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
            LinkedTreeMap<K, V>.EntrySet entrySet = this.entrySet;
            if (entrySet != null) {
                return entrySet;
            }
            LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet(this);
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r4v3. Raw type applied. Possible types: K, ? super K */
    public Node<K, V> find(K k, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Node<K, V> node;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, k, z)) == null) {
            Comparator<? super K> comparator = this.comparator;
            Node<K, V> node2 = this.root;
            if (node2 != null) {
                Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
                while (true) {
                    if (comparable != null) {
                        i2 = comparable.compareTo(node2.key);
                    } else {
                        i2 = comparator.compare(k, (K) node2.key);
                    }
                    if (i2 == 0) {
                        return node2;
                    }
                    Node<K, V> node3 = i2 < 0 ? node2.left : node2.right;
                    if (node3 == null) {
                        break;
                    }
                    node2 = node3;
                }
            } else {
                i2 = 0;
            }
            if (z) {
                Node<K, V> node4 = this.header;
                if (node2 == null) {
                    if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                        throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                    }
                    node = new Node<>(node2, k, node4, node4.prev);
                    this.root = node;
                } else {
                    node = new Node<>(node2, k, node4, node4.prev);
                    if (i2 < 0) {
                        node2.left = node;
                    } else {
                        node2.right = node;
                    }
                    rebalance(node2, true);
                }
                this.size++;
                this.modCount++;
                return node;
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
            LinkedTreeMap<K, V>.KeySet keySet = this.keySet;
            if (keySet != null) {
                return keySet;
            }
            LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet(this);
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

    public LinkedTreeMap(Comparator<? super K> comparator) {
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
        this.header = new Node<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    /* loaded from: classes2.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        public Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {node, k, node2, node3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.parent = node;
            this.key = k;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}
