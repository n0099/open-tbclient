package com.kwad.sdk.lib.widget.recycler;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class d extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f38583a;

    /* renamed from: b  reason: collision with root package name */
    public final a f38584b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView.Adapter f38585c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView.AdapterDataObserver f38586d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f38587e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f38588f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f38589g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f38590h;

    /* renamed from: i  reason: collision with root package name */
    public int f38591i;
    public int j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public Set<WeakReference<b>> o;
    public boolean p;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<View> f38597a;

        /* renamed from: b  reason: collision with root package name */
        public int f38598b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((List) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f38597a = new SparseArray<>();
            this.f38598b = 0;
            if (list != null) {
                for (View view : list) {
                    SparseArray<View> sparseArray = this.f38597a;
                    int i4 = this.f38598b;
                    this.f38598b = i4 + 1;
                    sparseArray.put(i4, view);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38597a.size() : invokeV.intValue;
        }

        public View a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f38597a.get(i2) : (View) invokeI.objValue;
        }

        public boolean a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? this.f38597a.indexOfValue(view) >= 0 : invokeL.booleanValue;
        }

        public int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f38597a.size()) {
                    return -1;
                }
                return this.f38597a.keyAt(i2);
            }
            return invokeI.intValue;
        }

        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                if (a(view)) {
                    return false;
                }
                SparseArray<View> sparseArray = this.f38597a;
                int i2 = this.f38598b;
                this.f38598b = i2 + 1;
                sparseArray.put(i2, view);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean c(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
                int indexOfValue = this.f38597a.indexOfValue(view);
                if (indexOfValue < 0) {
                    return false;
                }
                this.f38597a.removeAt(indexOfValue);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(RecyclerView.Adapter adapter) {
        this(adapter, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((RecyclerView.Adapter) objArr2[0], (List) objArr2[1], (List) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(RecyclerView.Adapter adapter, List<View> list, List<View> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adapter, list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38591i = -2048;
        this.j = -1024;
        this.l = -1;
        this.m = false;
        this.n = true;
        this.o = new HashSet();
        this.f38585c = adapter;
        this.f38583a = new a(list);
        this.f38584b = new a(list2);
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver(this) { // from class: com.kwad.sdk.lib.widget.recycler.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f38592a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38592a = this;
            }

            private void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(65537, this, i4) == null) {
                    try {
                        int i5 = this.f38592a.l;
                        int a2 = this.f38592a.a();
                        if (i5 == -1) {
                            this.f38592a.notifyDataSetChanged();
                        } else if (i4 == i5) {
                            this.f38592a.notifyItemRangeChanged(a2, i4);
                        } else if (i4 > i5) {
                            this.f38592a.notifyItemRangeChanged(a2, i5);
                            this.f38592a.notifyItemRangeInserted(a2 + i5, i4 - i5);
                        } else {
                            this.f38592a.notifyItemRangeChanged(a2, i4);
                            this.f38592a.notifyItemRangeRemoved(a2 + i4, i5 - i4);
                        }
                    } catch (Exception unused) {
                    }
                    this.f38592a.l = i4;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38592a.d();
                    if (this.f38592a.m) {
                        this.f38592a.notifyDataSetChanged();
                    } else if (this.f38592a.p) {
                        a(this.f38592a.f38585c.getItemCount());
                    } else {
                        int itemCount = this.f38592a.f38585c.getItemCount();
                        try {
                            if (this.f38592a.l == -1 || (itemCount != 0 && itemCount == this.f38592a.l)) {
                                this.f38592a.notifyItemRangeChanged(this.f38592a.a(), itemCount);
                            } else {
                                this.f38592a.notifyDataSetChanged();
                            }
                        } catch (Exception unused) {
                        }
                        this.f38592a.l = itemCount;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    d dVar = this.f38592a;
                    dVar.l = dVar.f38585c.getItemCount();
                    try {
                        this.f38592a.notifyItemRangeChanged(i4 + this.f38592a.a(), i5);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i4, int i5, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i4, i5, obj) == null) {
                    d dVar = this.f38592a;
                    dVar.l = dVar.f38585c.getItemCount();
                    try {
                        this.f38592a.notifyItemRangeChanged(i4 + this.f38592a.a(), i5, obj);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048579, this, i4, i5) == null) {
                    d dVar = this.f38592a;
                    dVar.l = dVar.f38585c.getItemCount();
                    try {
                        this.f38592a.notifyItemRangeInserted(i4 + this.f38592a.a(), i5);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIII(1048580, this, i4, i5, i6) == null) {
                    try {
                        this.f38592a.notifyItemMoved(i4 + this.f38592a.a(), i5 + this.f38592a.a());
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048581, this, i4, i5) == null) {
                    try {
                        this.f38592a.notifyItemRangeRemoved(i4 + this.f38592a.a(), i5);
                    } catch (Exception unused) {
                    }
                }
            }
        };
        this.f38586d = adapterDataObserver;
        this.f38587e = adapterDataObserver;
        this.f38588f = adapterDataObserver;
        this.f38585c.registerAdapterDataObserver(adapterDataObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            for (WeakReference<b> weakReference : this.o) {
                b bVar = weakReference.get();
                if (bVar != null) {
                    bVar.a(this);
                }
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            try {
                notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }
    }

    private RecyclerView.ViewHolder f(View view) {
        InterceptResult invokeL;
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, view)) == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i2 = layoutParams2 == null ? -1 : layoutParams2.width;
            int i3 = layoutParams2 == null ? -2 : layoutParams2.height;
            if (this.n) {
                if (this.k) {
                    StaggeredGridLayoutManager.LayoutParams layoutParams3 = new StaggeredGridLayoutManager.LayoutParams(i2, i3);
                    layoutParams3.setFullSpan(true);
                    layoutParams = layoutParams3;
                } else {
                    layoutParams = new RecyclerView.LayoutParams(i2, i3);
                }
                view.setLayoutParams(layoutParams);
            }
            return new RecyclerView.ViewHolder(this, view) { // from class: com.kwad.sdk.lib.widget.recycler.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f38593a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(view);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38593a = this;
                }
            };
        }
        return (RecyclerView.ViewHolder) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RecyclerView.Adapter adapter = this.f38589g;
            return adapter != null ? adapter.getItemCount() : this.f38583a.a();
        }
        return invokeV.intValue;
    }

    public void a(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, layoutParams) == null) {
            if (view == null) {
                throw new IllegalArgumentException("the view to add must not be null");
            }
            if (layoutParams != null) {
                view.setLayoutParams(layoutParams);
            }
            if (this.f38583a.b(view)) {
                e();
            }
            d();
        }
    }

    public void a(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            a(recyclerView, (GridLayoutManager.SpanSizeLookup) null);
        }
    }

    public void a(RecyclerView recyclerView, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, recyclerView, spanSizeLookup) == null) {
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, gridLayoutManager, spanSizeLookup) { // from class: com.kwad.sdk.lib.widget.recycler.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ GridLayoutManager f38594a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ GridLayoutManager.SpanSizeLookup f38595b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f38596c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, gridLayoutManager, spanSizeLookup};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38596c = this;
                        this.f38594a = gridLayoutManager;
                        this.f38595b = spanSizeLookup;
                    }

                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i2) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) {
                            if (this.f38596c.a(i2) || this.f38596c.b(i2)) {
                                return this.f38594a.getSpanCount();
                            }
                            GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.f38595b;
                            if (spanSizeLookup2 != null) {
                                return spanSizeLookup2.getSpanSize(i2);
                            }
                            return 1;
                        }
                        return invokeI.intValue;
                    }
                });
            }
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                this.k = true;
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 < a() : invokeI.booleanValue;
    }

    public boolean a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            boolean c2 = this.f38584b.c(view);
            if (c2) {
                e();
            }
            return c2;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RecyclerView.Adapter adapter = this.f38590h;
            return adapter != null ? adapter.getItemCount() : this.f38584b.a();
        }
        return invokeV.intValue;
    }

    public void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            a(view, (ViewGroup.LayoutParams) null);
        }
    }

    public void b(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, layoutParams) == null) {
            if (view == null) {
                throw new IllegalArgumentException("the view to add must not be null!");
            }
            if ((view.getParent() instanceof ViewGroup) && view.getParent() != this.f38584b) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (layoutParams != null) {
                view.setLayoutParams(layoutParams);
            }
            if (this.f38584b.b(view)) {
                e();
            }
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 >= a() + this.f38585c.getItemCount() : invokeI.booleanValue;
    }

    public RecyclerView.Adapter c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38585c : (RecyclerView.Adapter) invokeV.objValue;
    }

    public void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            b(view, null);
        }
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? i2 >= -1024 && i2 <= this.j : invokeI.booleanValue;
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? i2 >= -2048 && i2 <= this.f38591i : invokeI.booleanValue;
    }

    public boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view)) == null) ? this.f38584b.a(view) : invokeL.booleanValue;
    }

    public int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? i2 + 2048 : invokeI.intValue;
    }

    public boolean e(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) ? this.f38583a.a(view) : invokeL.booleanValue;
    }

    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? i2 + 1024 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? b() + a() + this.f38585c.getItemCount() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (a(i2)) {
                RecyclerView.Adapter adapter = this.f38589g;
                return adapter != null ? adapter.getItemId(i2) : getItemViewType(i2);
            } else if (b(i2)) {
                RecyclerView.Adapter adapter2 = this.f38590h;
                return adapter2 != null ? adapter2.getItemId(i2) : getItemViewType(i2);
            } else {
                return this.f38585c.getItemId(i2);
            }
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            if (a(i2)) {
                RecyclerView.Adapter adapter = this.f38589g;
                int itemViewType = (adapter != null ? adapter.getItemViewType(i2) : this.f38583a.b(i2)) - 1024;
                this.j = Math.max(itemViewType, this.j);
                return itemViewType;
            } else if (b(i2)) {
                int itemCount = (i2 - this.f38585c.getItemCount()) - a();
                RecyclerView.Adapter adapter2 = this.f38590h;
                int itemViewType2 = (adapter2 != null ? adapter2.getItemViewType(itemCount) : this.f38584b.b(itemCount)) - 2048;
                this.f38591i = Math.max(itemViewType2, this.f38591i);
                return itemViewType2;
            } else {
                return this.f38585c.getItemViewType(i2 - a());
            }
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, recyclerView) == null) {
            super.onAttachedToRecyclerView(recyclerView);
            if (this.f38585c.hasObservers()) {
                this.f38585c.unregisterAdapterDataObserver(this.f38586d);
            }
            this.f38585c.registerAdapterDataObserver(this.f38586d);
            this.f38585c.onAttachedToRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.f38589g;
            if (adapter != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
                this.f38589g.unregisterAdapterDataObserver(this.f38587e);
                this.f38589g.registerAdapterDataObserver(this.f38587e);
            }
            RecyclerView.Adapter adapter2 = this.f38590h;
            if (adapter2 != null) {
                adapter2.onAttachedToRecyclerView(recyclerView);
                this.f38590h.unregisterAdapterDataObserver(this.f38588f);
                this.f38590h.registerAdapterDataObserver(this.f38588f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, viewHolder, i2) == null) {
            if (i2 >= a() && i2 < a() + this.f38585c.getItemCount()) {
                this.f38585c.onBindViewHolder(viewHolder, i2 - a());
                return;
            }
            if (i2 >= a() || (adapter = this.f38589g) == null) {
                if (i2 < a() + this.f38585c.getItemCount() || (adapter = this.f38590h) == null) {
                    return;
                }
                i2 = (i2 - a()) - this.f38585c.getItemCount();
            }
            adapter.onBindViewHolder(viewHolder, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List list) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, viewHolder, i2, list) == null) {
            if (list.isEmpty()) {
                onBindViewHolder(viewHolder, i2);
            } else if (i2 >= a() && i2 < a() + this.f38585c.getItemCount()) {
                this.f38585c.onBindViewHolder(viewHolder, i2 - a(), list);
            } else {
                if (i2 >= a() || (adapter = this.f38589g) == null) {
                    if (i2 < a() + this.f38585c.getItemCount() || (adapter = this.f38590h) == null) {
                        return;
                    }
                    i2 = (i2 - a()) - this.f38585c.getItemCount();
                }
                adapter.onBindViewHolder(viewHolder, i2, list);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, viewGroup, i2)) == null) {
            if (c(i2)) {
                int f2 = f(i2);
                RecyclerView.Adapter adapter = this.f38589g;
                return adapter == null ? f(this.f38583a.a(f2)) : adapter.onCreateViewHolder(viewGroup, f2);
            } else if (d(i2)) {
                int e2 = e(i2);
                RecyclerView.Adapter adapter2 = this.f38590h;
                return adapter2 == null ? f(this.f38584b.a(e2)) : adapter2.onCreateViewHolder(viewGroup, e2);
            } else {
                return this.f38585c.onCreateViewHolder(viewGroup, i2);
            }
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            if (this.f38585c.hasObservers()) {
                this.f38585c.unregisterAdapterDataObserver(this.f38586d);
            }
            this.f38585c.onDetachedFromRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.f38589g;
            if (adapter != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
                this.f38589g.unregisterAdapterDataObserver(this.f38587e);
            }
            RecyclerView.Adapter adapter2 = this.f38590h;
            if (adapter2 != null) {
                adapter2.onDetachedFromRecyclerView(recyclerView);
                this.f38590h.unregisterAdapterDataObserver(this.f38588f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, viewHolder) == null) {
            super.onViewAttachedToWindow(viewHolder);
            int itemViewType = viewHolder.getItemViewType();
            if (c(itemViewType)) {
                adapter = this.f38589g;
                if (adapter == null) {
                    return;
                }
            } else if (d(itemViewType)) {
                adapter = this.f38590h;
                if (adapter == null) {
                    return;
                }
            } else {
                adapter = this.f38585c;
            }
            adapter.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, viewHolder) == null) {
            super.onViewDetachedFromWindow(viewHolder);
            int itemViewType = viewHolder.getItemViewType();
            if (c(itemViewType)) {
                adapter = this.f38589g;
                if (adapter == null) {
                    return;
                }
            } else if (d(itemViewType)) {
                adapter = this.f38590h;
                if (adapter == null) {
                    return;
                }
            } else {
                adapter = this.f38585c;
            }
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, adapterDataObserver) == null) {
            super.registerAdapterDataObserver(adapterDataObserver);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, adapterDataObserver) == null) {
            super.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }
}
