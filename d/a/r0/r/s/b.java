package d.a.r0.r.s;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Integer, Integer[]> q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f56136a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f56137b;

    /* renamed from: c  reason: collision with root package name */
    public c f56138c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f56139d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f56140e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f56141f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f56142g;

    /* renamed from: h  reason: collision with root package name */
    public final View f56143h;

    /* renamed from: i  reason: collision with root package name */
    public int f56144i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public AlertDialog n;
    public int o;
    public LinearLayout.LayoutParams p;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56145e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f56146f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f56147g;

        public a(b bVar, int i2, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56147g = bVar;
            this.f56145e = i2;
            this.f56146f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56147g.f56138c.a(this.f56147g, this.f56145e, this.f56146f);
            }
        }
    }

    /* renamed from: d.a.r0.r.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1266b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final int f56148a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1706492928, "Ld/a/r0/r/s/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1706492928, "Ld/a/r0/r/s/b$b;");
                    return;
                }
            }
            f56148a = R.style.dialog_ani_b2t;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(b bVar, int i2, View view);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485374530, "Ld/a/r0/r/s/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-485374530, "Ld/a/r0/r/s/b;");
                return;
            }
        }
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        q = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf(R.drawable.dialg_alert_btn_bg), Integer.valueOf(R.drawable.dialog_bdalert_button_textcolor_pressed)});
        q.put(1, new Integer[]{Integer.valueOf(R.drawable.btn_blue_square), Integer.valueOf(R.color.CAM_X0201)});
    }

    public b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = false;
        this.o = -1;
        this.f56139d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.f56140e = viewGroup;
        this.f56142g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f56141f = (ViewGroup) this.f56140e.findViewById(R.id.dialog_content);
        this.f56143h = this.f56140e.findViewById(R.id.line_bg);
        this.f56144i = R.layout.dialog_bdlist_item;
    }

    public void b(d.a.c.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f56140e);
            }
            this.f56140e.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public b c(d.a.c.a.f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.m) {
                return this;
            }
            this.m = true;
            if (!TextUtils.isEmpty(this.f56136a)) {
                this.f56142g.setText(this.f56136a);
                this.f56142g.setVisibility(0);
                this.f56143h.setVisibility(0);
            } else {
                this.f56142g.setVisibility(8);
                this.f56143h.setVisibility(8);
            }
            List<CharSequence> list = this.f56137b;
            if (list != null && list.size() > 0) {
                int size = this.f56137b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d(i2);
                }
            }
            b(fVar);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final View d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            View inflate = LayoutInflater.from(this.f56139d).inflate(this.f56144i, this.f56141f, false);
            LinearLayout linearLayout = (LinearLayout) inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.dialog_item_btn);
            LinearLayout.LayoutParams layoutParams = this.p;
            if (layoutParams != null) {
                textView.setLayoutParams(layoutParams);
            }
            int i3 = this.l;
            if (i3 != -1) {
                textView.setTextSize(0, i3);
            }
            if (this.o != -1) {
                textView.setPadding(0, 0, 0, 0);
                textView.setGravity(this.o);
            }
            View findViewById = inflate.findViewById(R.id.line);
            CharSequence charSequence = this.f56137b.get(i2);
            if (charSequence.length() <= 0) {
                charSequence = "";
            }
            textView.setText(charSequence);
            if (i2 == this.f56137b.size() - 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
            } else if (this.f56137b.size() == 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
            } else if (i2 == 0 && StringUtils.isNull(this.f56136a)) {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
            } else {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
            }
            if (this.f56138c != null) {
                linearLayout.setOnClickListener(new a(this, i2, textView));
            }
            this.f56141f.addView(inflate);
            return inflate;
        }
        return (View) invokeI.objValue;
    }

    public void e() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.n) == null) {
            return;
        }
        d.a.c.e.m.g.a(alertDialog, this.f56139d);
    }

    public View f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ViewGroup viewGroup = this.f56141f;
            if (viewGroup == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            if (i2 < 0 || i2 > childCount - 1) {
                return null;
            }
            return this.f56141f.getChildAt(i2);
        }
        return (View) invokeI.objValue;
    }

    public b g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.j = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.k = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b i(List<CharSequence> list, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, cVar)) == null) {
            if (list != null && list.size() > 0) {
                this.f56137b = list;
                if (cVar != null) {
                    this.f56138c = cVar;
                }
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b j(CharSequence[] charSequenceArr, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequenceArr, cVar)) == null) {
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                i(Arrays.asList(charSequenceArr), cVar);
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            l(this.f56139d.getResources().getString(i2));
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f56136a = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.m) {
                AlertDialog alertDialog = this.n;
                if (alertDialog != null) {
                    d.a.c.e.m.g.i(alertDialog, this.f56139d);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f56139d, R.style.NoBackDimEnableDialog).create();
                this.n = create;
                create.setCanceledOnTouchOutside(true);
                if (d.a.c.e.m.g.i(this.n, this.f56139d)) {
                    Window window = this.n.getWindow();
                    if (this.j == -1) {
                        this.j = C1266b.f56148a;
                    }
                    if (this.k == -1) {
                        this.k = 17;
                    }
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.dimAmount = 0.5f;
                    window.setAttributes(attributes);
                    window.setGravity(this.k);
                    window.setContentView(this.f56140e);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (b) invokeV.objValue;
    }
}
