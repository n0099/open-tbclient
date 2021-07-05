package d.a.r0.r.f0;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f55627a;

    /* renamed from: b  reason: collision with root package name */
    public Context f55628b;

    /* renamed from: c  reason: collision with root package name */
    public View f55629c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55630d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f55631e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f55632f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f55633g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f55634h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f55635e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55635e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55635e.f55632f == null) {
                return;
            }
            this.f55635e.f55632f.cancel();
        }
    }

    public c() {
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
        this.f55627a = 3000L;
        this.f55628b = null;
        this.f55629c = null;
        this.f55630d = null;
        this.f55631e = null;
        this.f55634h = new a(this);
        this.f55628b = TbadkCoreApplication.getInst().getContext();
        this.f55633g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f55628b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f55629c = inflate;
            this.f55630d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f55631e = (ImageView) this.f55629c.findViewById(R.id.tip_iamge);
            this.f55629c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f55628b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f55630d, R.color.CAM_X0101);
            this.f55630d.setText(charSequence);
            this.f55631e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f55629c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f55628b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f55629c = inflate;
            this.f55630d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f55631e = (ImageView) this.f55629c.findViewById(R.id.tip_iamge);
            this.f55629c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f55628b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f55630d, R.color.CAM_X0101);
            this.f55630d.setText(charSequence);
            this.f55631e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f55629c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f55628b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f55629c = inflate;
            this.f55630d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f55631e = (ImageView) this.f55629c.findViewById(R.id.tip_iamge);
            this.f55629c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f55628b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f55630d, R.color.CAM_X0101);
            this.f55630d.setText(i3);
            this.f55631e.setImageResource(i2);
            e(this.f55629c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f55633g.removeCallbacks(this.f55634h);
            if (this.f55632f == null) {
                this.f55632f = new Toast(this.f55628b);
            }
            this.f55633g.postDelayed(this.f55634h, this.f55627a);
            this.f55632f.setView(view);
            this.f55632f.setDuration(1);
            this.f55632f.setGravity(17, 0, 0);
            this.f55632f.show();
        }
    }
}
