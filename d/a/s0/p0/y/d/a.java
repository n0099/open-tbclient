package d.a.s0.p0.y.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class a extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f64583e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64584f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64585g;

    /* renamed from: h  reason: collision with root package name */
    public View f64586h;

    /* renamed from: i  reason: collision with root package name */
    public View f64587i;
    public View j;
    public LinearLayout k;
    public c l;
    public Context m;

    /* renamed from: d.a.s0.p0.y.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnTouchListenerC1632a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64588e;

        public View$OnTouchListenerC1632a(a aVar) {
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
            this.f64588e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int top = this.f64588e.f64586h.findViewById(R.id.id_pop_layout).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    this.f64588e.dismiss();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context, i2);
        this.m = context;
        e();
        c(TbadkCoreApplication.getInst().getSkinType());
        this.f64583e.setOnClickListener(this);
        this.f64584f.setOnClickListener(this);
        this.f64585g.setOnClickListener(this);
    }

    public final void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
            this.f64586h = inflate;
            this.f64583e = (TextView) inflate.findViewById(R.id.tv_single_bar);
            this.f64584f = (TextView) this.f64586h.findViewById(R.id.tv_my_emotion);
            this.f64585g = (TextView) this.f64586h.findViewById(R.id.tv_cancel);
            this.k = (LinearLayout) this.f64586h.findViewById(R.id.id_pop_layout);
            this.f64587i = this.f64586h.findViewById(R.id.line1);
            this.j = this.f64586h.findViewById(R.id.line2);
            if (i2 == 1) {
                SkinManager.setViewTextColor(this.f64583e, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f64583e, R.color.CAM_X0204);
            }
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundResource(this.k, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f64587i, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.j, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f64584f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f64585g, R.color.CAM_X0107);
        }
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                setAttachedInDecor(false);
            }
            setContentView(this.f64586h);
            setWidth(-1);
            setHeight(l.i(this.m));
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
            this.f64586h.setOnTouchListener(new View$OnTouchListenerC1632a(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            dismiss();
            c cVar = this.l;
            if (cVar == null) {
                return;
            }
            if (view == this.f64583e) {
                cVar.b();
            } else if (view == this.f64584f) {
                cVar.a();
            }
        }
    }
}
