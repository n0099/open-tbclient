package d.a.o0.r.f0;

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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f52333a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52334b;

    /* renamed from: c  reason: collision with root package name */
    public View f52335c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52336d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52337e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f52338f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f52339g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f52340h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f52341e;

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
            this.f52341e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52341e.f52338f == null) {
                return;
            }
            this.f52341e.f52338f.cancel();
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
        this.f52333a = 3000L;
        this.f52334b = null;
        this.f52335c = null;
        this.f52336d = null;
        this.f52337e = null;
        this.f52340h = new a(this);
        this.f52334b = TbadkCoreApplication.getInst().getContext();
        this.f52339g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f52334b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f52335c = inflate;
            this.f52336d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f52337e = (ImageView) this.f52335c.findViewById(R.id.tip_iamge);
            this.f52335c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f52334b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f52336d, R.color.CAM_X0101);
            this.f52336d.setText(charSequence);
            this.f52337e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f52335c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f52334b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f52335c = inflate;
            this.f52336d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f52337e = (ImageView) this.f52335c.findViewById(R.id.tip_iamge);
            this.f52335c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f52334b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f52336d, R.color.CAM_X0101);
            this.f52336d.setText(charSequence);
            this.f52337e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f52335c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f52334b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f52335c = inflate;
            this.f52336d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f52337e = (ImageView) this.f52335c.findViewById(R.id.tip_iamge);
            this.f52335c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f52334b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f52336d, R.color.CAM_X0101);
            this.f52336d.setText(i3);
            this.f52337e.setImageResource(i2);
            e(this.f52335c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f52339g.removeCallbacks(this.f52340h);
            if (this.f52338f == null) {
                this.f52338f = new Toast(this.f52334b);
            }
            this.f52339g.postDelayed(this.f52340h, this.f52333a);
            this.f52338f.setView(view);
            this.f52338f.setDuration(1);
            this.f52338f.setGravity(17, 0, 0);
            this.f52338f.show();
        }
    }
}
