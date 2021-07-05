package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f38552a;

    /* renamed from: b  reason: collision with root package name */
    public final ListUpdateCallback f38553b;

    /* renamed from: c  reason: collision with root package name */
    public final b<T> f38554c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView.Adapter f38555d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public List<T> f38556e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public List<T> f38557f;

    /* renamed from: g  reason: collision with root package name */
    public int f38558g;

    public d(@NonNull ListUpdateCallback listUpdateCallback, @NonNull b<T> bVar, @NonNull RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listUpdateCallback, bVar, adapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38557f = Collections.emptyList();
        this.f38553b = listUpdateCallback;
        this.f38554c = bVar;
        this.f38555d = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, list, diffResult) == null) {
            this.f38556e = list;
            this.f38557f = Collections.unmodifiableList(list);
            diffResult.dispatchUpdatesTo(this.f38553b);
            this.f38552a = false;
            if (this.f38554c.d() != null) {
                this.f38554c.d().run();
            }
        }
    }

    @NonNull
    public List<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38557f : (List) invokeV.objValue;
    }

    public void a(List<T> list) {
        List<T> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == (list2 = this.f38556e)) {
            return;
        }
        int i2 = this.f38558g + 1;
        this.f38558g = i2;
        if (list == null) {
            this.f38553b.onRemoved(0, list2.size());
            this.f38556e = null;
            this.f38557f = Collections.emptyList();
        } else if (list2 != null) {
            this.f38552a = true;
            this.f38554c.b().execute(new Runnable(this, this.f38556e, list, i2) { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ List f38559a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f38560b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f38561c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f38562d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, list, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38562d = this;
                    this.f38559a = r7;
                    this.f38560b = list;
                    this.f38561c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38562d.f38554c.a().execute(new Runnable(this, DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f38563a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38563a = this;
                            }

                            @Override // androidx.recyclerview.widget.DiffUtil.Callback
                            public boolean areContentsTheSame(int i3, int i4) {
                                InterceptResult invokeII;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeII = interceptable3.invokeII(1048576, this, i3, i4)) == null) ? this.f38563a.f38562d.f38554c.c().a((T) this.f38563a.f38559a.get(i3), (T) this.f38563a.f38560b.get(i4)) : invokeII.booleanValue;
                            }

                            @Override // androidx.recyclerview.widget.DiffUtil.Callback
                            public boolean areItemsTheSame(int i3, int i4) {
                                InterceptResult invokeII;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeII = interceptable3.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4)) == null) ? this.f38563a.f38562d.f38554c.c().b((T) this.f38563a.f38559a.get(i3), (T) this.f38563a.f38560b.get(i4)) : invokeII.booleanValue;
                            }

                            @Override // androidx.recyclerview.widget.DiffUtil.Callback
                            @Nullable
                            public Object getChangePayload(int i3, int i4) {
                                InterceptResult invokeII;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeII = interceptable3.invokeII(Constants.METHOD_SEND_USER_MSG, this, i3, i4)) == null) ? this.f38563a.f38562d.f38554c.c().c((T) this.f38563a.f38559a.get(i3), (T) this.f38563a.f38560b.get(i4)) : invokeII.objValue;
                            }

                            @Override // androidx.recyclerview.widget.DiffUtil.Callback
                            public int getNewListSize() {
                                InterceptResult invokeV;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeV = interceptable3.invokeV(1048579, this)) == null) ? this.f38563a.f38560b.size() : invokeV.intValue;
                            }

                            @Override // androidx.recyclerview.widget.DiffUtil.Callback
                            public int getOldListSize() {
                                InterceptResult invokeV;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeV = interceptable3.invokeV(1048580, this)) == null) ? this.f38563a.f38559a.size() : invokeV.intValue;
                            }
                        })) { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ DiffUtil.DiffResult f38564a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f38565b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38565b = this;
                                this.f38564a = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    int i3 = this.f38565b.f38562d.f38558g;
                                    AnonymousClass1 anonymousClass1 = this.f38565b;
                                    if (i3 == anonymousClass1.f38561c) {
                                        anonymousClass1.f38562d.a(anonymousClass1.f38560b, this.f38564a);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        } else {
            this.f38553b.onInserted(0, list.size());
            this.f38556e = list;
            this.f38557f = Collections.unmodifiableList(list);
        }
    }

    public void b(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f38556e = list;
            this.f38557f = Collections.unmodifiableList(list);
            this.f38555d.notifyDataSetChanged();
        }
    }
}
