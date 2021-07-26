package d.a.p0.s.f0;

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
    public long f52989a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52990b;

    /* renamed from: c  reason: collision with root package name */
    public View f52991c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52992d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52993e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f52994f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f52995g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f52996h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f52997e;

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
            this.f52997e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52997e.f52994f == null) {
                return;
            }
            this.f52997e.f52994f.cancel();
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
        this.f52989a = 3000L;
        this.f52990b = null;
        this.f52991c = null;
        this.f52992d = null;
        this.f52993e = null;
        this.f52996h = new a(this);
        this.f52990b = TbadkCoreApplication.getInst().getContext();
        this.f52995g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f52990b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f52991c = inflate;
            this.f52992d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f52993e = (ImageView) this.f52991c.findViewById(R.id.tip_iamge);
            this.f52991c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(this.f52990b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f52992d, R.color.CAM_X0101);
            this.f52992d.setText(charSequence);
            this.f52993e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f52991c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f52990b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f52991c = inflate;
            this.f52992d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f52993e = (ImageView) this.f52991c.findViewById(R.id.tip_iamge);
            this.f52991c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(this.f52990b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f52992d, R.color.CAM_X0101);
            this.f52992d.setText(charSequence);
            this.f52993e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f52991c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f52990b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f52991c = inflate;
            this.f52992d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f52993e = (ImageView) this.f52991c.findViewById(R.id.tip_iamge);
            this.f52991c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(this.f52990b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f52992d, R.color.CAM_X0101);
            this.f52992d.setText(i3);
            this.f52993e.setImageResource(i2);
            e(this.f52991c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f52995g.removeCallbacks(this.f52996h);
            if (this.f52994f == null) {
                this.f52994f = new Toast(this.f52990b);
            }
            this.f52995g.postDelayed(this.f52996h, this.f52989a);
            this.f52994f.setView(view);
            this.f52994f.setDuration(1);
            this.f52994f.setGravity(17, 0, 0);
            this.f52994f.show();
        }
    }
}
