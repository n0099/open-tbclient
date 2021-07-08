package d.a.o0.r.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.l;
/* loaded from: classes7.dex */
public class h implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52894a;

    /* renamed from: b  reason: collision with root package name */
    public l f52895b;

    /* renamed from: c  reason: collision with root package name */
    public View f52896c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f52897d;

    /* renamed from: e  reason: collision with root package name */
    public View f52898e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52899f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f52900g;

    /* renamed from: h  reason: collision with root package name */
    public String f52901h;

    /* renamed from: i  reason: collision with root package name */
    public int f52902i;
    public int j;
    public int k;
    public l.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f52903e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52903e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f52903e.l != null) {
                    this.f52903e.l.onClick();
                }
                if (this.f52903e.f52895b == null || this.f52903e.f52895b.e() == null) {
                    return;
                }
                this.f52903e.f52895b.e().onItemClick(this.f52903e.f52895b, this.f52903e.f52894a, this.f52903e.f52897d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(642021749, "Ld/a/o0/r/s/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(642021749, "Ld/a/o0/r/s/h;");
                return;
            }
        }
        q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        r = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(l lVar) {
        this(null, lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (l) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.r.s.k
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f52897d, this.j);
            SkinManager.setViewTextColorSelector(this.f52897d, this.f52902i);
            SkinManager.setBackgroundColor(this.f52898e, R.color.CAM_X0204);
            MaskView.b(this.f52897d, this.n);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52894a : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52901h : (String) invokeV.objValue;
    }

    @Override // d.a.o0.r.s.k
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52896c : (View) invokeV.objValue;
    }

    public final void h() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (lVar = this.f52895b) == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f52895b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f52895b.g(), false);
        this.f52896c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f52897d.getTag();
        EMTextView eMTextView = (EMTextView) this.f52896c.findViewById(R.id.item_view);
        this.f52897d = eMTextView;
        eMTextView.setText(this.f52901h);
        this.f52897d.setGravity(this.k);
        this.f52897d.setTag(tag);
        View findViewById = this.f52896c.findViewById(R.id.divider_line);
        this.f52898e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f52896c.findViewById(R.id.item_image);
        this.f52899f = imageView;
        imageView.setImageDrawable(this.f52900g);
        a();
        this.f52896c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eMTextView = this.f52897d) == null) {
            return;
        }
        eMTextView.setOnClickListener(this.p);
    }

    public final void j() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lVar = this.f52895b) == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f52895b.d()).inflate(R.layout.popup_dialog_view_item, this.f52895b.g(), false);
        this.f52896c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f52897d = eMTextView;
        eMTextView.setText(this.f52901h);
        this.f52897d.setGravity(this.k);
        View findViewById = this.f52896c.findViewById(R.id.divider_line);
        this.f52898e = findViewById;
        if (this.m) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public void l(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.f52900g = drawable;
        }
    }

    public void m(l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.l = dVar;
            i();
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f52901h = str;
            this.f52897d.setText(str);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f52902i = i2;
            SkinManager.setViewTextColor(this.f52897d, i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.n = z;
            MaskView.b(this.f52897d, z);
        }
    }

    public h(String str, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, lVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f52902i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.f52901h = str;
        this.f52895b = lVar;
        this.f52894a = hashCode();
        j();
        i();
    }

    public h(int i2, String str, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52902i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.f52894a = i2;
        this.f52901h = str;
        this.f52895b = lVar;
        j();
        i();
    }
}
