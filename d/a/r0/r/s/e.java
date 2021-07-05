package d.a.r0.r.s;

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
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f56159a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f56160b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f56161c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56162d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56163e;

    /* renamed from: f  reason: collision with root package name */
    public m f56164f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56165g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f56166h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56167i;
    public AlertDialog j;
    public AdapterView.OnItemClickListener k;

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f56168e;

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
            this.f56168e = eVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f56168e.f56161c != null) {
                    this.f56168e.f56161c.onItemClick(adapterView, view, i2, j);
                }
                this.f56168e.f();
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
        this.f56167i = false;
        this.k = new a(this);
        this.f56166h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f56162d = viewGroup;
        this.f56165g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f56163e = (BdListView) this.f56162d.findViewById(R.id.dialog_content_list);
        this.f56164f = new m(this.f56166h);
    }

    public void b(d.a.c.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f56162d);
            }
            this.f56162d.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f56167i) {
                return this;
            }
            this.f56167i = true;
            if (!TextUtils.isEmpty(this.f56159a)) {
                this.f56165g.setText(this.f56159a);
                this.f56165g.setVisibility(0);
            } else {
                this.f56165g.setVisibility(8);
            }
            this.f56163e.setAdapter((ListAdapter) this.f56164f);
            this.f56164f.c(this.f56160b);
            b(this.f56166h);
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
        d.a.c.e.m.g.a(alertDialog, this.f56166h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56162d : (View) invokeV.objValue;
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
            b(this.f56166h);
            m mVar = this.f56164f;
            if (mVar != null) {
                mVar.notifyDataSetChanged();
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            for (int i3 = 0; i3 < this.f56160b.size(); i3++) {
                if (i3 == i2) {
                    this.f56160b.get(i3).e(true);
                } else {
                    this.f56160b.get(i3).e(false);
                }
            }
            this.f56164f.c(this.f56160b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f56164f.b(z);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            for (int i3 = 0; i3 < this.f56160b.size(); i3++) {
                if (i3 == i2) {
                    n nVar = this.f56160b.get(i3);
                    nVar.e(!nVar.d());
                }
            }
            this.f56164f.c(this.f56160b);
        }
    }

    public e k(ArrayList<n> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f56160b = arrayList;
                if (onItemClickListener != null) {
                    this.f56161c = onItemClickListener;
                    this.f56163e.setOnItemClickListener(this.k);
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
            m(this.f56166h.getResources().getString(i2));
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f56159a = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f56167i) {
                AlertDialog alertDialog = this.j;
                if (alertDialog != null) {
                    d.a.c.e.m.g.j(alertDialog, this.f56166h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f56166h.getPageActivity()).create();
                this.j = create;
                create.setCanceledOnTouchOutside(true);
                if (d.a.c.e.m.g.i(this.j, this.f56166h.getPageActivity())) {
                    Window window = this.j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.f56162d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (e) invokeV.objValue;
    }
}
