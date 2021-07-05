package d.a.s0.h2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.k;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f60089a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60090b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f60091c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60092d;

    /* renamed from: e  reason: collision with root package name */
    public e f60093e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60094f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f60095g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60096h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60097i;
    public LinearLayout j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60098e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60098e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f60098e.f60093e == null) {
                return;
            }
            this.f60098e.f60093e.c();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f60099e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f60100f;

        public b(d dVar, UserInfo userInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, userInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60100f = dVar;
            this.f60099e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60100f.e(this.f60099e.id.longValue(), this.f60099e.name);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f60101e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f60102f;

        public c(d dVar, UserInfo userInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, userInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60102f = dVar;
            this.f60101e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60102f.e(this.f60101e.id.longValue(), this.f60101e.name);
            }
        }
    }

    /* renamed from: d.a.s0.h2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1451d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f60103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f60104f;

        public View$OnClickListenerC1451d(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60104f = dVar;
            this.f60103e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f60104f.f60093e == null) {
                return;
            }
            this.f60104f.f60093e.a(this.f60103e);
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(String str);

        void b(String str, String str2);

        void c();
    }

    public d(Context context) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.f60089a = inflate;
        this.f60090b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f60091c = (HeadImageView) this.f60089a.findViewById(R.id.chosen_pb_person_info_head);
        this.f60092d = (TextView) this.f60089a.findViewById(R.id.chosen_pb_person_info_name);
        this.f60094f = (TextView) this.f60089a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f60091c.setRadius(l.e(context, 2.0f));
        this.f60095g = (BarImageView) this.f60089a.findViewById(R.id.chosen_pb_bar_pic);
        this.f60096h = (TextView) this.f60089a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f60089a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f60097i = textView;
        textView.setOnClickListener(new a(this));
        this.j = (LinearLayout) this.f60089a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60089a : (View) invokeV.objValue;
    }

    public void d(String str) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (headImageView = this.f60091c) == null) {
            return;
        }
        headImageView.M(str, 12, false);
    }

    public final void e(long j, String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, str) == null) || (eVar = this.f60093e) == null) {
            return;
        }
        eVar.b(String.valueOf(j), str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f60097i.setText(R.string.relate_forum_is_followed);
                SkinManager.setViewTextColor(this.f60097i, R.color.CAM_X0109, 1);
                this.f60097i.setEnabled(false);
                return;
            }
            this.f60097i.setText(R.string.attention);
            this.f60097i.setEnabled(true);
            SkinManager.setViewTextColor(this.f60097i, R.color.CAM_X0111, 1);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f60093e = eVar;
        }
    }

    public void h(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (textView = this.f60092d) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) || this.f60094f == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f60094f.setVisibility(4);
            return;
        }
        this.f60094f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
        this.f60094f.setOnClickListener(new View$OnClickListenerC1451d(this, str));
        this.f60094f.setVisibility(0);
    }

    public void j(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, userInfo) == null) || userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f60091c.setOnClickListener(new b(this, userInfo));
        this.f60092d.setOnClickListener(new c(this, userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null || (textView = this.f60090b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f60095g;
            if (barImageView != null) {
                barImageView.M(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f60095g.setOnClickListener(new View$OnClickListenerC1451d(this, excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f60096h;
            if (textView2 != null && (num = excellentPbThreadInfo.forum.member_count) != null) {
                textView2.setText(StringHelper.numFormatOver10000(num.intValue()));
            }
            Integer num2 = excellentPbThreadInfo.forum.is_like;
            if (num2 != null && num2.intValue() == 1) {
                f(true);
                return;
            } else {
                f(false);
                return;
            }
        }
        this.j.setVisibility(8);
    }
}
