package d.a.s0.h2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f60105a;

    /* renamed from: b  reason: collision with root package name */
    public View f60106b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60107c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60108d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60109e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60110f;

    /* renamed from: g  reason: collision with root package name */
    public c f60111g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60112h;

    /* renamed from: i  reason: collision with root package name */
    public long f60113i;
    public Animation j;
    public boolean k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f60114e;

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
            this.f60114e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f60114e.k && ViewHelper.checkUpIsLogin(this.f60114e.f60105a)) {
                this.f60114e.k = true;
                this.f60114e.f60108d.startAnimation(this.f60114e.g());
                if (this.f60114e.f60111g != null) {
                    this.f60114e.f60111g.b(this.f60114e.f60112h);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f60115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f60116f;

        public b(e eVar, ExcellentPbThreadInfo excellentPbThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, excellentPbThreadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60116f = eVar;
            this.f60115e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f60116f.f60111g == null) {
                return;
            }
            c cVar = this.f60116f.f60111g;
            long longValue = this.f60115e.forum.forum_id.longValue();
            cVar.a(longValue, this.f60115e.thread_id + "");
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60113i = 0L;
        this.k = false;
        this.f60105a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f60106b = inflate;
        this.f60107c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f60108d = (ImageView) this.f60106b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f60109e = (TextView) this.f60106b.findViewById(R.id.chosen_post_info_praise_num);
        this.f60110f = (TextView) this.f60106b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.j == null) {
                this.j = AnimationUtils.loadAnimation(this.f60105a, R.anim.praise_animation_scale3);
            }
            return this.j;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60106b : (View) invokeV.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f60111g = cVar;
        }
    }

    public void j(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (textView = this.f60107c) == null) {
            return;
        }
        textView.setText(i2);
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.f60110f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || j < 0) {
            return;
        }
        this.f60113i = j;
        TextView textView = this.f60109e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f60109e.setText(this.f60105a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f60109e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f60109e.setVisibility(0);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            p(z);
            if (z) {
                this.f60113i++;
            } else {
                this.f60113i--;
            }
            l(this.f60113i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
        }
    }

    public void o(ExcellentPbThreadInfo excellentPbThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null) {
            return;
        }
        j(R.string.chosen_pb_copyright);
        l(excellentPbThreadInfo.zan.zansum.longValue());
        p(excellentPbThreadInfo.zan.is_zan.booleanValue());
        this.f60108d.setOnClickListener(new a(this));
        k(new b(this, excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f60112h = z;
            if (z) {
                SkinManager.setImageResource(this.f60108d, R.drawable.btn_zambia_big_s);
            } else {
                SkinManager.setImageResource(this.f60108d, R.drawable.btn_zambia_big_n);
            }
            this.f60108d.setVisibility(0);
        }
    }
}
