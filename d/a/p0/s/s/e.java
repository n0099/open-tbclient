package d.a.p0.s.s;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f53542a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f53543b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f53544c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f53545d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f53546e;

    /* renamed from: f  reason: collision with root package name */
    public m f53547f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53548g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f53549h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53550i;
    public AlertDialog j;
    public AdapterView.OnItemClickListener k;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f53551e;

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
            this.f53551e = eVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f53551e.f53544c != null) {
                    this.f53551e.f53544c.onItemClick(adapterView, view, i2, j);
                }
                this.f53551e.f();
            }
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53550i = false;
        this.k = new a(this);
        this.f53549h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f53545d = viewGroup;
        this.f53548g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f53546e = (BdListView) this.f53545d.findViewById(R.id.dialog_content_list);
        this.f53547f = new m(this.f53549h);
    }

    public void b(d.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f53545d);
            }
            this.f53545d.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f53550i) {
                return this;
            }
            this.f53550i = true;
            if (!TextUtils.isEmpty(this.f53542a)) {
                this.f53548g.setText(this.f53542a);
                this.f53548g.setVisibility(0);
            } else {
                this.f53548g.setVisibility(8);
            }
            this.f53546e.setAdapter((ListAdapter) this.f53547f);
            this.f53547f.c(this.f53543b);
            b(this.f53549h);
            return this;
        }
        return (e) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.j) == null) {
            return;
        }
        d.a.d.e.m.g.a(alertDialog, this.f53549h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53545d : (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b(this.f53549h);
            m mVar = this.f53547f;
            if (mVar != null) {
                mVar.notifyDataSetChanged();
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            for (int i3 = 0; i3 < this.f53543b.size(); i3++) {
                if (i3 == i2) {
                    this.f53543b.get(i3).e(true);
                } else {
                    this.f53543b.get(i3).e(false);
                }
            }
            this.f53547f.c(this.f53543b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f53547f.b(z);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            for (int i3 = 0; i3 < this.f53543b.size(); i3++) {
                if (i3 == i2) {
                    n nVar = this.f53543b.get(i3);
                    nVar.e(!nVar.d());
                }
            }
            this.f53547f.c(this.f53543b);
        }
    }

    public e k(ArrayList<n> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f53543b = arrayList;
                if (onItemClickListener != null) {
                    this.f53544c = onItemClickListener;
                    this.f53546e.setOnItemClickListener(this.k);
                }
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public e l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            m(this.f53549h.getResources().getString(i2));
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f53542a = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f53550i) {
                AlertDialog alertDialog = this.j;
                if (alertDialog != null) {
                    d.a.d.e.m.g.j(alertDialog, this.f53549h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f53549h.getPageActivity()).create();
                this.j = create;
                create.setCanceledOnTouchOutside(true);
                if (d.a.d.e.m.g.i(this.j, this.f53549h.getPageActivity())) {
                    Window window = this.j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.f53545d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (e) invokeV.objValue;
    }
}
