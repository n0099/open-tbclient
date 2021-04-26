package d.a.j0.s.b;

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
import d.a.c.e.p.l;
import d.a.i0.a.f;
import d.a.i0.a.g;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: d.a.j0.s.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class View$OnClickListenerC1519a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f59894e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f59895f;

        public View$OnClickListenerC1519a(g gVar, PopupWindow popupWindow) {
            this.f59894e = gVar;
            this.f59895f = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.go_to_aiapps_go) {
                if (d.a.c.a.b.f().b() != null && !StringUtils.isNull(this.f59894e.f())) {
                    Uri parse = Uri.parse(this.f59894e.f());
                    if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters("obj_source") != null) {
                        TiebaStatic.log(new StatisticItem("c13391").param("obj_type", parse.getQueryParameter("obj_type")).param("obj_source", parse.getQueryParameter("obj_source")));
                    }
                    if (this.f59894e.f().startsWith(f.f47853a)) {
                        Uri.Builder buildUpon = Uri.parse(this.f59894e.f()).buildUpon();
                        buildUpon.appendQueryParameter(f.w, f.L);
                        parse = buildUpon.build();
                    }
                    UtilHelper.dealOneScheme(d.a.c.a.b.f().b(), parse.toString());
                }
                try {
                    this.f59895f.dismiss();
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                try {
                    this.f59895f.dismiss();
                } catch (Throwable th2) {
                    BdLog.e(th2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f59897f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f59898g;

        public b(String str, g gVar, PopupWindow popupWindow) {
            this.f59896e = str;
            this.f59897f = gVar;
            this.f59898g = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.go_to_aiapps_go) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, this.f59896e));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.f59897f.j).param("obj_source", "tb_password").param("obj_name", this.f59897f.f47870h).param("obj_param1", this.f59897f.k.intValue()));
                try {
                    this.f59898g.dismiss();
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                try {
                    this.f59898g.dismiss();
                } catch (Throwable th2) {
                    BdLog.e(th2);
                }
            }
        }
    }

    public static PopupWindow a(g gVar) {
        View.OnClickListener view$OnClickListenerC1519a;
        Activity b2 = d.a.c.a.b.f().b();
        if (b2 == null || gVar == null) {
            return null;
        }
        String f2 = gVar.f();
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
        if (gVar.g() != 3) {
            view$OnClickListenerC1519a = new b(f2, gVar, popupWindow);
            if (!StringUtils.isNull(gVar.c())) {
                tbImageView.V(gVar.c(), 10, false);
            } else {
                tbImageView.setImageResource(R.drawable.toastpic);
            }
        } else {
            tbImageView.setImageResource(R.drawable.toastpic_scheme);
            view$OnClickListenerC1519a = new View$OnClickListenerC1519a(gVar, popupWindow);
        }
        textView.setOnClickListener(view$OnClickListenerC1519a);
        textView2.setOnClickListener(view$OnClickListenerC1519a);
        textView.setText(gVar.b());
        textView2.setText(gVar.a());
        textView3.setText(gVar.e());
        textView4.setText(gVar.d());
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
}
