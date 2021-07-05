package d.a.s0.j2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f62350e;

    /* renamed from: f  reason: collision with root package name */
    public View f62351f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f62352g;

    /* renamed from: h  reason: collision with root package name */
    public float f62353h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f62354e;

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
            this.f62354e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62354e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, View view) {
        super(context, 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62353h = 0.33f;
        this.f62350e = context;
        this.f62351f = view;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f62353h = f2;
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.person_info_more_dialog);
            Display defaultDisplay = ((WindowManager) this.f62350e.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            getWindow().setDimAmount(this.f62353h);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
            this.f62352g = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            if (this.f62351f == null) {
                return;
            }
            this.f62352g.removeAllViews();
            if (this.f62351f.getParent() != null) {
                if (this.f62351f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f62351f.getParent()).removeView(this.f62351f);
                    this.f62352g.addView(this.f62351f);
                    return;
                }
                return;
            }
            this.f62352g.addView(this.f62351f);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f62351f = view;
            LinearLayout linearLayout = this.f62352g;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                if (this.f62351f.getParent() != null) {
                    if (this.f62351f.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f62351f.getParent()).removeView(this.f62351f);
                        this.f62352g.addView(this.f62351f);
                        return;
                    }
                    return;
                }
                this.f62352g.addView(this.f62351f);
            }
        }
    }
}
