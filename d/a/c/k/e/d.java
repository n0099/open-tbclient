package d.a.c.k.e;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c> f44832a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f44833b;

    /* renamed from: c  reason: collision with root package name */
    public a f44834c;

    /* loaded from: classes8.dex */
    public interface a {
        void onPreLoad();
    }

    /* loaded from: classes8.dex */
    public class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f44835a;

        /* renamed from: b  reason: collision with root package name */
        public int f44836b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f44837c;

        /* renamed from: d  reason: collision with root package name */
        public Object f44838d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44839e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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

    public d() {
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
        this.f44832a = null;
        this.f44833b = null;
        this.f44834c = null;
        this.f44832a = new ArrayList<>();
        this.f44833b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f44837c = new TypeAdapter.ViewHolder(view);
        cVar.f44838d = obj;
        cVar.f44839e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f44836b = id;
        cVar.f44835a = id;
        view.setTag("FOOTER");
        if (i2 >= 0 && i2 <= this.f44833b.size()) {
            this.f44833b.add(i2, cVar);
        } else {
            this.f44833b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f44837c = new TypeAdapter.ViewHolder(view);
        cVar.f44838d = obj;
        cVar.f44839e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f44836b = id;
        cVar.f44835a = id;
        view.setTag("HEADER");
        if (i2 >= 0 && i2 <= this.f44832a.size()) {
            this.f44832a.add(i2, cVar);
        } else {
            this.f44832a.add(cVar);
        }
    }

    public TypeAdapter.ViewHolder c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            TextView textView = new TextView(context);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
            int e2 = d.a.c.e.p.l.e(context, 15.0f);
            textView.setPadding(e2, e2, e2, e2);
            textView.setHeight(0);
            return new b(this, textView);
        }
        return (TypeAdapter.ViewHolder) invokeL.objValue;
    }

    public int d(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            for (int i2 = 0; i2 < this.f44833b.size(); i2++) {
                c cVar = this.f44833b.get(i2);
                if (cVar != null && (viewHolder = cVar.f44837c) != null && viewHolder.itemView == view) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public c e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Iterator<c> it = this.f44833b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i2 == next.f44836b) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public int f(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            for (int i2 = 0; i2 < this.f44832a.size(); i2++) {
                c cVar = this.f44832a.get(i2);
                if (cVar != null && (viewHolder = cVar.f44837c) != null && viewHolder.itemView == view) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            Iterator<c> it = this.f44832a.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i2 == next.f44836b) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f44833b.size() : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f44832a.size() : invokeV.intValue;
    }

    public boolean j(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f44833b.size(); i2++) {
                c cVar = this.f44833b.get(i2);
                if (cVar != null && (viewHolder = cVar.f44837c) != null && viewHolder.itemView == view) {
                    this.f44833b.remove(i2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f44832a.size(); i2++) {
                c cVar = this.f44832a.get(i2);
                if (cVar != null && (viewHolder = cVar.f44837c) != null && viewHolder.itemView == view) {
                    this.f44832a.remove(i2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f44834c = aVar;
        }
    }
}
