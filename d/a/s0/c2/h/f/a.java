package d.a.s0.c2.h.f;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener, d.a.s0.p0.y.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f58062e;

    /* renamed from: f  reason: collision with root package name */
    public View f58063f;

    /* renamed from: g  reason: collision with root package name */
    public View f58064g;

    /* renamed from: h  reason: collision with root package name */
    public View f58065h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f58066i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public Animation m;
    public TbPageContext n;
    public int o;
    public d.a.s0.p0.y.d.a p;

    /* renamed from: d.a.s0.c2.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1357a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58067e;

        /* renamed from: d.a.s0.c2.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1358a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58068e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC1357a f58069f;

            public RunnableC1358a(RunnableC1357a runnableC1357a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1357a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58069f = runnableC1357a;
                this.f58068e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f58068e >= 30) {
                        l.M(this.f58069f.f58067e.n.getPageActivity(), String.format(this.f58069f.f58067e.n.getString(R.string.emotion_create_tip), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f58069f.f58067e.n.getPageActivity(), true, 25021)));
                    }
                }
            }
        }

        public RunnableC1357a(a aVar) {
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
            this.f58067e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = d.a.s0.c2.c.i().f();
                d.a.c.e.m.e.a().post(new RunnableC1358a(this, f2 == null ? 0 : f2.size()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58070e;

        /* renamed from: d.a.s0.c2.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1359a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58071e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f58072f;

            public RunnableC1359a(b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58072f = bVar;
                this.f58071e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f58071e >= 30) {
                        l.M(this.f58072f.f58070e.n.getPageActivity(), String.format(this.f58072f.f58070e.n.getString(R.string.emotion_create_tip), 30));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f58072f.f58070e.n.getPageActivity(), 25021)));
                    }
                }
            }
        }

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
            this.f58070e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = d.a.s0.c2.c.i().f();
                d.a.c.e.m.e.a().post(new RunnableC1359a(this, f2 == null ? 0 : f2.size()));
            }
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = tbPageContext;
        this.o = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.f58064g = inflate;
        this.f58062e = inflate.findViewById(R.id.emotion_manager_add_layout);
        View findViewById = this.f58064g.findViewById(R.id.emotion_manager_create);
        this.f58063f = findViewById;
        findViewById.setOnClickListener(this);
        this.f58062e.setVisibility(0);
        View findViewById2 = this.f58064g.findViewById(R.id.emotion_manager_upload_status);
        this.f58065h = findViewById2;
        findViewById2.setClickable(false);
        this.f58065h.setOnClickListener(this);
        this.f58065h.setVisibility(8);
        this.f58066i = (ImageView) this.f58064g.findViewById(R.id.uploading_status_img);
        this.j = (ImageView) this.f58064g.findViewById(R.id.icon_add);
        this.k = (TextView) this.f58064g.findViewById(R.id.add_emotion_tv);
        this.l = (TextView) this.f58064g.findViewById(R.id.add_emotion_manager_upload_status);
    }

    @Override // d.a.s0.p0.y.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.s0.c2.a.b().a(new b(this));
        }
    }

    @Override // d.a.s0.p0.y.d.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.s0.c2.a.b().a(new RunnableC1357a(this));
        }
    }

    public void d() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.f58066i) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.m == null) {
                this.m = AnimationUtils.loadAnimation(this.n.getPageActivity(), R.anim.refresh_rotate);
                this.m.setInterpolator(new LinearInterpolator());
                this.m.setFillAfter(true);
            }
            return this.m;
        }
        return (Animation) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58064g : (View) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            View view = this.f58062e;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
            }
            TextView textView = this.l;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i2);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i2);
            }
            View view2 = this.f58065h;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i2);
            }
            ImageView imageView2 = this.f58066i;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void h() {
        d.a.s0.p0.y.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (aVar = this.p) != null && aVar.isShowing()) {
            this.p.dismiss();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.s0.p0.y.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f58065h.setVisibility(8);
            this.f58062e.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.s0.p0.y.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            k();
            this.f58065h.setVisibility(0);
            this.f58062e.setVisibility(8);
            SkinManager.setBackgroundColor(this.f58065h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f58066i, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
            this.l.setText(R.string.emotion_uploading);
            this.f58065h.setClickable(false);
        }
    }

    public void k() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (imageView = this.f58066i) == null) {
            return;
        }
        imageView.startAnimation(e());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FaceGroupDraft k = d.a.s0.c2.g.e.l().k();
            if (k != null && TextUtils.isEmpty(k.getFailMsg())) {
                l.M(this.n.getPageActivity(), k.getFailMsg());
            }
            m(null);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.s0.p0.y.d.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            d();
            this.f58065h.setVisibility(0);
            this.f58062e.setVisibility(8);
            SkinManager.setBackgroundColor(this.f58065h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f58066i, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.l, R.color.common_color_10037);
            if (!TextUtils.isEmpty(str)) {
                this.l.setText(str);
            } else {
                this.l.setText(R.string.emotion_center_upload_failed);
            }
            this.f58065h.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (this.f58063f != null && view.getId() == this.f58063f.getId() && this.f58063f.isShown()) {
                if (this.o == 1) {
                    if (this.p == null) {
                        d.a.s0.p0.y.d.a aVar = new d.a.s0.p0.y.d.a(this.n.getPageActivity(), this.o);
                        this.p = aVar;
                        aVar.d(this);
                    }
                    this.p.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.n.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.p.showAtLocation(this.f58064g, 81, 0, this.n.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                } else {
                    a();
                }
            }
            if (this.f58065h != null && view.getId() == this.f58065h.getId() && this.f58065h.isShown()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.n.getPageActivity(), this.o == 1, 25021)));
            }
        }
    }
}
