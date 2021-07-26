package d.a.q0.w3;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.e.l.d;
import d.a.d.e.p.k;
import d.a.p0.s.s.a;
/* loaded from: classes8.dex */
public class a extends d.a.p0.s.s.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f66754e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f66755f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66756g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f66757h;

    /* renamed from: i  reason: collision with root package name */
    public TbCheckBox f66758i;
    public TextView j;
    public Button k;
    public Button l;
    public ImageView m;
    public String n;
    public String o;
    public String p;
    public a.e q;
    public String r;
    public a.e s;
    public String t;
    public CompoundButton.OnCheckedChangeListener u;
    public boolean v;
    public TbCheckBox.b w;
    public final d.a.d.e.l.c<d.a.d.k.d.a> x;

    /* renamed from: d.a.q0.w3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1841a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66759a;

        public C1841a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66759a = aVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) || this.f66759a.u == null) {
                return;
            }
            this.f66759a.u.onCheckedChanged(null, z);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66760a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66760a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.f66760a.f66755f.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                this.f66760a.f66755f.setBackgroundResource(0);
                this.f66760a.f66755f.setImageDrawable(null);
                aVar.h(this.f66760a.f66755f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f66761e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66761e = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66761e : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f66761e = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = false;
        this.w = new C1841a(this);
        this.x = new b(this);
        c();
        setContentViewSize(1);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
            this.f66754e = viewGroup;
            this.f66755f = (ImageView) viewGroup.findViewById(R.id.dialog_bg);
            this.f66756g = (TextView) this.f66754e.findViewById(R.id.message);
            Button button = (Button) this.f66754e.findViewById(R.id.negative_btn);
            this.l = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.f66754e.findViewById(R.id.positive_btn);
            this.k = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f66754e.findViewById(R.id.close);
            this.m = imageView;
            imageView.setOnClickListener(this);
            this.f66757h = (ViewGroup) this.f66754e.findViewById(R.id.checkbox_container);
            this.j = (TextView) this.f66754e.findViewById(R.id.checkbox_text);
            TbCheckBox tbCheckBox = (TbCheckBox) this.f66754e.findViewById(R.id.checkbox);
            this.f66758i = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
            this.f66758i.setStatedChangedListener(this.w);
            this.f66758i.setTagData(new c(this));
            this.f66757h.setClickable(true);
            this.f66757h.setOnClickListener(this);
            setContentView(this.f66754e);
        }
    }

    @Override // d.a.p0.s.s.a
    public d.a.p0.s.s.a create(f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.v) {
                return this;
            }
            this.v = true;
            super.create(fVar);
            if (!k.isEmpty(this.o)) {
                this.f66756g.setText(this.o);
            }
            if (!k.isEmpty(this.t)) {
                this.j.setText(this.t);
            } else {
                this.f66757h.setVisibility(4);
            }
            if (!k.isEmpty(this.r)) {
                this.l.setText(this.r);
            }
            if (!k.isEmpty(this.p)) {
                this.k.setText(this.p);
            }
            if (!TextUtils.isEmpty(this.n)) {
                d.h().m(this.n, 10, this.x, fVar.getUniqueId());
            } else {
                this.f66755f.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (d.a.p0.s.s.a) invokeL.objValue;
    }

    public a d(@StringRes int i2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, onCheckedChangeListener)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.t = activity.getResources().getString(i2);
                this.u = onCheckedChangeListener;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(@StringRes int i2, a.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.r = activity.getResources().getString(i2);
                this.s = eVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a h(int i2, a.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.p = activity.getResources().getString(i2);
                this.q = eVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a i(String str, a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, eVar)) == null) {
            this.p = str;
            this.q = eVar;
            return this;
        }
        return (a) invokeLL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.positive_btn) {
            a.e eVar = this.q;
            if (eVar != null) {
                eVar.onClick(this);
            }
        } else if (id == R.id.negative_btn) {
            a.e eVar2 = this.s;
            if (eVar2 != null) {
                eVar2.onClick(this);
            }
        } else if (id == R.id.close) {
            dismiss();
        } else if (id == R.id.checkbox_container) {
            TbCheckBox tbCheckBox = this.f66758i;
            tbCheckBox.setChecked(!tbCheckBox.d());
        }
    }

    @Override // d.a.p0.s.s.a
    public /* bridge */ /* synthetic */ d.a.p0.s.s.a setMessage(String str) {
        f(str);
        return this;
    }

    @Override // d.a.p0.s.s.a
    public /* bridge */ /* synthetic */ d.a.p0.s.s.a setNegativeButton(@StringRes int i2, a.e eVar) {
        g(i2, eVar);
        return this;
    }

    @Override // d.a.p0.s.s.a
    public /* bridge */ /* synthetic */ d.a.p0.s.s.a setPositiveButton(int i2, a.e eVar) {
        h(i2, eVar);
        return this;
    }

    @Override // d.a.p0.s.s.a
    public d.a.p0.s.s.a setNegativeButton(String str, a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.r = str;
            this.s = eVar;
            return this;
        }
        return (d.a.p0.s.s.a) invokeLL.objValue;
    }

    @Override // d.a.p0.s.s.a
    public /* bridge */ /* synthetic */ d.a.p0.s.s.a setPositiveButton(String str, a.e eVar) {
        i(str, eVar);
        return this;
    }
}
