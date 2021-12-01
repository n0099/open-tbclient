package com.google.common.util.concurrent;

import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public abstract class CollectionFutureRunningState extends AggregateFuture<V, C>.RunningState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CollectionFuture this$0;
        public List<Optional<V>> values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CollectionFutureRunningState(CollectionFuture collectionFuture, ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(collectionFuture, immutableCollection, z, true);
            List<Optional<V>> l;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collectionFuture, immutableCollection, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AggregateFuture) objArr2[0], (ImmutableCollection) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = collectionFuture;
            if (immutableCollection.isEmpty()) {
                l = ImmutableList.of();
            } else {
                l = Lists.l(immutableCollection.size());
            }
            this.values = l;
            for (int i4 = 0; i4 < immutableCollection.size(); i4++) {
                this.values.add(null);
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void collectOneValue(boolean z, int i2, V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), v}) == null) {
                List<Optional<V>> list = this.values;
                if (list != null) {
                    list.set(i2, Optional.fromNullable(v));
                } else {
                    n.x(z || this.this$0.isCancelled(), "Future was done before all dependencies completed");
                }
            }
        }

        public abstract C combine(List<Optional<V>> list);

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.util.concurrent.CollectionFuture */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void handleAllCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                List<Optional<V>> list = this.values;
                if (list != null) {
                    this.this$0.set(combine(list));
                } else {
                    n.w(this.this$0.isDone());
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.releaseResourcesAfterFailure();
                this.values = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes2.dex */
        public final class ListFutureRunningState extends CollectionFuture<V, List<V>>.CollectionFutureRunningState {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ListFuture this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListFutureRunningState(ListFuture listFuture, ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
                super(listFuture, immutableCollection, z);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {listFuture, immutableCollection, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((CollectionFuture) objArr2[0], (ImmutableCollection) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = listFuture;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            public List<V> combine(List<Optional<V>> list) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                    ArrayList l = Lists.l(list.size());
                    Iterator<Optional<V>> it = list.iterator();
                    while (it.hasNext()) {
                        Optional<V> next = it.next();
                        l.add(next != null ? next.orNull() : null);
                    }
                    return Collections.unmodifiableList(l);
                }
                return (List) invokeL.objValue;
            }
        }

        public ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableCollection, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            init(new ListFutureRunningState(this, immutableCollection, z));
        }
    }

    public CollectionFuture() {
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
}
