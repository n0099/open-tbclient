package d.a.q0.u.b;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.a.g;
import d.a.p0.a.i;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.u.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class View$OnClickListenerC1653a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f63044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f63045f;

        public View$OnClickListenerC1653a(i iVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63044e = iVar;
            this.f63045f = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.go_to_aiapps_go) {
                    if (d.a.d.a.b.f().b() != null && !StringUtils.isNull(this.f63044e.f())) {
                        Uri parse = Uri.parse(this.f63044e.f());
                        if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters("obj_source") != null) {
                            TiebaStatic.log(new StatisticItem("c13391").param("obj_type", parse.getQueryParameter("obj_type")).param("obj_source", parse.getQueryParameter("obj_source")));
                        }
                        if (this.f63044e.f().startsWith(g.f51838a)) {
                            Uri.Builder buildUpon = Uri.parse(this.f63044e.f()).buildUpon();
                            buildUpon.appendQueryParameter(g.x, g.U);
                            parse = buildUpon.build();
                        }
                        UtilHelper.dealOneScheme(d.a.d.a.b.f().b(), parse.toString());
                    }
                    try {
                        this.f63045f.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                    try {
                        this.f63045f.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f63047f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f63048g;

        public b(String str, i iVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, iVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63046e = str;
            this.f63047f = iVar;
            this.f63048g = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.go_to_aiapps_go) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, this.f63046e));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.f63047f.j).param("obj_source", "tb_password").param("obj_name", this.f63047f.f51860h).param("obj_param1", this.f63047f.k.intValue()));
                    try {
                        this.f63048g.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                    try {
                        this.f63048g.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    public static PopupWindow a(i iVar) {
        InterceptResult invokeL;
        View.OnClickListener view$OnClickListenerC1653a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iVar)) == null) {
            Activity b2 = d.a.d.a.b.f().b();
            if (b2 == null || iVar == null) {
                return null;
            }
            String f2 = iVar.f();
            if (StringUtils.isNull(f2)) {
                return null;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.aiapps_token_layout, (ViewGroup) null, true);
            TextView textView = (TextView) inflate.findViewById(R.id.go_to_aiapps_go);
            TextView textView2 = (TextView) inflate.findViewById(R.id.go_to_aiapps_cancel);
            TextView textView3 = (TextView) inflate.findViewById(R.id.token_title);
            TextView textView4 = (TextView) inflate.findViewById(R.id.token_tip);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.token_top_cover);
            tbImageView.setDefaultResource(R.drawable.toastpic);
            tbImageView.setAutoChangeStyle(false);
            PopupWindow popupWindow = new PopupWindow(b2);
            if (iVar.g() != 3) {
                view$OnClickListenerC1653a = new b(f2, iVar, popupWindow);
                if (!StringUtils.isNull(iVar.c())) {
                    tbImageView.M(iVar.c(), 10, false);
                } else {
                    tbImageView.setImageResource(R.drawable.toastpic);
                }
            } else {
                tbImageView.setImageResource(R.drawable.toastpic_scheme);
                view$OnClickListenerC1653a = new View$OnClickListenerC1653a(iVar, popupWindow);
            }
            textView.setOnClickListener(view$OnClickListenerC1653a);
            textView2.setOnClickListener(view$OnClickListenerC1653a);
            textView.setText(iVar.b());
            textView2.setText(iVar.a());
            textView3.setText(iVar.e());
            textView4.setText(iVar.d());
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(Color.argb(178, 0, 0, 0));
            popupWindow.setBackgroundDrawable(colorDrawable);
            popupWindow.setWidth(l.k(b2));
            popupWindow.setHeight(l.i(b2));
            popupWindow.setContentView(inflate);
            popupWindow.setOutsideTouchable(true);
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                    declaredField.setAccessible(true);
                    declaredField.set(popupWindow, Boolean.TRUE);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
            }
            return popupWindow;
        }
        return (PopupWindow) invokeL.objValue;
    }
}
