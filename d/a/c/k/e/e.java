package d.a.c.k.e;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class e extends BaseAdapter implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f44840e;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f44841f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f44842g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f44843h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44844i;
    public DataSetObserver j;
    public DataSetObserver k;
    public b l;

    /* loaded from: classes8.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f44845a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44845a = eVar;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onChanged();
                if (this.f44845a.j != null) {
                    this.f44845a.j.onChanged();
                }
                if (this.f44845a.l != null) {
                    this.f44845a.l.onPreLoad();
                }
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onInvalidated();
                if (this.f44845a.j != null) {
                    this.f44845a.j.onInvalidated();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onPreLoad();
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f44846a;

        /* renamed from: b  reason: collision with root package name */
        public Object f44847b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44848c;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
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

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44840e = null;
        this.f44841f = null;
        this.f44842g = null;
        this.f44843h = null;
        boolean z = false;
        this.f44844i = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f44840e = context;
        this.f44842g = new ArrayList<>();
        this.f44843h = new ArrayList<>();
        if (i(this.f44842g) && i(this.f44843h)) {
            z = true;
        }
        this.f44844i = z;
        this.k = new a(this);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null) {
                return this.f44844i && listAdapter.areAllItemsEnabled();
            }
            return super.areAllItemsEnabled();
        }
        return invokeV.booleanValue;
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            f(view, null, true, -1);
        }
    }

    public void f(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f44846a = view;
        cVar.f44847b = obj;
        cVar.f44848c = z;
        if (i2 >= 0 && i2 <= this.f44843h.size()) {
            this.f44843h.add(i2, cVar);
        } else {
            this.f44843h.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void g(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            h(view, null, true, i2);
        }
    }

    @Override // android.widget.Adapter, d.a.c.k.e.o
    public int getCount() {
        InterceptResult invokeV;
        int l;
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f44841f != null) {
                l = l() + n();
                n = this.f44841f.getCount();
            } else {
                l = l();
                n = n();
            }
            return l + n;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter, d.a.c.k.e.o
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int n = n();
            if (i2 < n) {
                return this.f44842g.get(i2).f44847b;
            }
            int i3 = i2 - n;
            int i4 = 0;
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f44841f.getItem(i3);
            }
            int i5 = i3 - i4;
            if (i5 < 0 || i5 >= this.f44843h.size()) {
                return null;
            }
            return this.f44843h.get(i5).f44847b;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            int n = n();
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter == null || i2 < n || (i3 = i2 - n) >= listAdapter.getCount()) {
                return Long.MIN_VALUE;
            }
            return this.f44841f.getItemId(i3);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int n = n();
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter == null || i2 < n || (i3 = i2 - n) >= listAdapter.getCount()) {
                return -2;
            }
            return this.f44841f.getItemViewType(i3);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            int n = n();
            if (i2 < n) {
                View view2 = this.f44842g.get(i2).f44846a;
                return view2 == null ? j() : view2;
            }
            int i3 = i2 - n;
            int i4 = 0;
            ListAdapter listAdapter = this.f44841f;
            View view3 = null;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                try {
                    view3 = this.f44841f.getView(i3, view, viewGroup);
                } catch (Exception e2) {
                    if (e2.getMessage() != null) {
                        BdLog.detailException(e2);
                        Log.e("BdListAdapter", e2.getMessage());
                        e2.printStackTrace();
                    }
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                    view3 = this.f44841f.getView(i3, view, viewGroup);
                }
                return view3 == null ? j() : view3;
            }
            try {
                view3 = this.f44843h.get(i3 - i4).f44846a;
            } catch (Exception e3) {
                BdLog.detailException(e3);
            }
            return view3 == null ? j() : view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount() + 1;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f44841f : (ListAdapter) invokeV.objValue;
    }

    public void h(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f44846a = view;
        cVar.f44847b = obj;
        cVar.f44848c = z;
        if (i2 >= 0 && i2 <= this.f44842g.size()) {
            this.f44842g.add(i2, cVar);
        } else {
            this.f44842g.add(cVar);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return super.hasStableIds();
        }
        return invokeV.booleanValue;
    }

    public final boolean i(ArrayList<c> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().f44848c) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.f44841f;
            return listAdapter == null || listAdapter.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int n = n();
            if (i2 < n) {
                return this.f44842g.get(i2).f44848c;
            }
            int i4 = i2 - n;
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null) {
                i3 = listAdapter.getCount();
                if (i4 < i3) {
                    return this.f44841f.isEnabled(i4);
                }
            } else {
                i3 = 0;
            }
            int i5 = i4 - i3;
            if (i5 < 0 || i5 >= this.f44843h.size()) {
                return false;
            }
            return this.f44843h.get(i5).f44848c;
        }
        return invokeI.booleanValue;
    }

    public final View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TextView textView = new TextView(this.f44840e);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
            int e2 = d.a.c.e.p.l.e(this.f44840e, 15.0f);
            textView.setPadding(e2, e2, e2, e2);
            return textView;
        }
        return (View) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f44843h.size() : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f44843h.size() : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f44842g.size() : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f44842g.size() : invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, d.a.c.k.e.o
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && d.a.c.e.p.l.C()) {
            super.notifyDataSetChanged();
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null) {
                return listAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean p(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view)) == null) {
            boolean z = false;
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f44843h.size(); i2++) {
                if (this.f44843h.get(i2).f44846a == view) {
                    this.f44843h.remove(i2);
                    if (i(this.f44842g) && i(this.f44843h)) {
                        z = true;
                    }
                    this.f44844i = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean q(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            boolean z = false;
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f44842g.size(); i2++) {
                if (this.f44842g.get(i2).f44846a == view) {
                    this.f44842g.remove(i2);
                    if (i(this.f44842g) && i(this.f44843h)) {
                        z = true;
                    }
                    this.f44844i = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void r(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.f44841f;
            this.f44841f = listAdapter;
            if (listAdapter != null) {
                boolean z = listAdapter instanceof Filterable;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dataSetObserver) == null) {
            super.registerDataSetObserver(dataSetObserver);
            this.j = dataSetObserver;
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(this.k);
            }
        }
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, dataSetObserver) == null) {
            super.unregisterDataSetObserver(dataSetObserver);
            this.j = dataSetObserver;
            ListAdapter listAdapter = this.f44841f;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(this.k);
            }
        }
    }
}
